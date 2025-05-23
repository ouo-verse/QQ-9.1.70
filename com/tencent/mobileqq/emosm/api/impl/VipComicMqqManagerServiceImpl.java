package com.tencent.mobileqq.emosm.api.impl;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.pb.mqqcomic.MqqComicPb$ComicFavorEmotIcons;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class VipComicMqqManagerServiceImpl implements IVipComicMqqManagerService, Handler.Callback {
    private static final int MSG_INIT_CACHE = 91000;
    private static final int MSG_SAVE_COMIC_EMO = 91001;
    private static final int MSG_SAVE_COMIC_EMO_BATCH = 91002;
    private static final int MSG_UPDATE_COMIC_EMO = 91003;
    private static final String TAG = "VipComicMqqManager";
    private Map<String, VipComicFavorEmoStructMsgInfo> mComicFavEmoCache;
    private Handler mDBHandler;
    private VipComicMqqHandler vipComicMqqHandler;
    private AppInterface mApp = null;
    private EntityManager mEm = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f204210a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CustomEmotionData f204211b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IFavroamingDBManagerService f204212c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f204213d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPicDownloadListener f204214e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f204215f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ EntityManager f204216g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ VipComicFavorEmoStructMsgInfo f204217h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f204218i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f204219j;

        a(File file, CustomEmotionData customEmotionData, IFavroamingDBManagerService iFavroamingDBManagerService, List list, IPicDownloadListener iPicDownloadListener, List list2, EntityManager entityManager, VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
            this.f204210a = file;
            this.f204211b = customEmotionData;
            this.f204212c = iFavroamingDBManagerService;
            this.f204213d = list;
            this.f204214e = iPicDownloadListener;
            this.f204215f = list2;
            this.f204216g = entityManager;
            this.f204217h = vipComicFavorEmoStructMsgInfo;
            this.f204218i = atomicInteger;
            this.f204219j = atomicInteger2;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPicDownloadListener iPicDownloadListener;
            super.onDone(gVar);
            if (gVar.i() == 3 && gVar.f313006d == 0 && this.f204210a.exists()) {
                this.f204211b.emoPath = this.f204210a.getAbsolutePath();
                if (FavEmoConstant.ROAMING_TYPE_PANEL.equals(this.f204211b.RomaingType)) {
                    this.f204211b.RomaingType = "isUpdate";
                }
                if (QLog.isColorLevel() && !TextUtils.isEmpty(this.f204211b.emoPath)) {
                    String fileMd5 = SecUtil.getFileMd5(this.f204211b.emoPath);
                    if (!this.f204211b.md5.equals(fileMd5)) {
                        QLog.i(VipComicMqqManagerServiceImpl.TAG, 2, "init = " + this.f204211b.md5 + " , compute = " + fileMd5);
                    }
                }
                this.f204212c.updateCustomEmotion(this.f204211b);
                this.f204213d.add(this.f204211b);
                VipComicMqqManagerServiceImpl.this.onListenerFailDone(this.f204214e, this.f204211b, true);
            } else {
                this.f204215f.add(this.f204211b);
                this.f204212c.deleteCustomEmotion(this.f204211b);
                this.f204216g.remove(this.f204217h);
                VipComicMqqManagerServiceImpl.this.onListenerFailDone(this.f204214e, this.f204211b, false);
            }
            this.f204218i.getAndIncrement();
            if (this.f204218i.get() == this.f204219j.get() && (iPicDownloadListener = this.f204214e) != null) {
                iPicDownloadListener.onDone(this.f204213d, this.f204215f);
            }
        }
    }

    private void doSaveComicStructInfo(VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo) {
        EntityManager entityManager;
        if (vipComicFavorEmoStructMsgInfo != null && (entityManager = this.mEm) != null && entityManager.isOpen() && !TextUtils.isEmpty(vipComicFavorEmoStructMsgInfo.picMd5)) {
            if (vipComicFavorEmoStructMsgInfo.getStatus() != 1000) {
                vipComicFavorEmoStructMsgInfo.setStatus(1000);
            }
            vipComicFavorEmoStructMsgInfo.picMd5 = vipComicFavorEmoStructMsgInfo.picMd5.toUpperCase();
            this.mEm.persistOrReplace(vipComicFavorEmoStructMsgInfo);
        }
    }

    private void initCache() {
        List<? extends Entity> list;
        EntityManager entityManager = this.mEm;
        if (entityManager != null && entityManager.isOpen()) {
            try {
                list = this.mEm.query(VipComicFavorEmoStructMsgInfo.class, true, null, null, null, null, null, null);
            } catch (Exception unused) {
                list = null;
            }
            if (list != null) {
                Iterator<? extends Entity> it = list.iterator();
                while (it.hasNext()) {
                    VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo) it.next();
                    if (!TextUtils.isEmpty(vipComicFavorEmoStructMsgInfo.picMd5)) {
                        this.mComicFavEmoCache.put(vipComicFavorEmoStructMsgInfo.picMd5.toUpperCase(), vipComicFavorEmoStructMsgInfo);
                    }
                }
            }
        }
    }

    private void onListenerDone(List<CustomEmotionData> list, IPicDownloadListener iPicDownloadListener) {
        if (iPicDownloadListener != null) {
            iPicDownloadListener.onDone(new ArrayList(), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListenerFailDone(IPicDownloadListener iPicDownloadListener, CustomEmotionData customEmotionData, boolean z16) {
        if (iPicDownloadListener != null) {
            iPicDownloadListener.onFileDone(customEmotionData, z16);
        }
    }

    private void saveComicEmoBatch(Message message) {
        List list;
        try {
            list = (List) message.obj;
        } catch (Exception unused) {
            list = null;
        }
        EntityManager entityManager = this.mEm;
        if (entityManager != null && entityManager.isOpen() && list != null && list.size() > 0) {
            try {
                try {
                    this.mEm.getTransaction().begin();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        doSaveComicStructInfo((VipComicFavorEmoStructMsgInfo) it.next());
                    }
                    this.mEm.getTransaction().commit();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                this.mEm.getTransaction().end();
            }
        }
    }

    private void saveComicStructInfoList(List<VipComicFavorEmoStructMsgInfo> list) {
        if (list != null && !list.isEmpty()) {
            Message obtainMessage = this.mDBHandler.obtainMessage(MSG_SAVE_COMIC_EMO_BATCH);
            obtainMessage.obj = list;
            this.mDBHandler.sendMessage(obtainMessage);
            for (VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo : list) {
                if (!TextUtils.isEmpty(vipComicFavorEmoStructMsgInfo.picMd5)) {
                    this.mComicFavEmoCache.put(vipComicFavorEmoStructMsgInfo.picMd5.toUpperCase(), vipComicFavorEmoStructMsgInfo);
                }
            }
        }
    }

    private void startDownload(IPicDownloadListener iPicDownloadListener, EntityManager entityManager, h hVar, List<CustomEmotionData> list, List<CustomEmotionData> list2, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, IFavroamingDBManagerService iFavroamingDBManagerService, CustomEmotionData customEmotionData, VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo, File file) {
        g gVar = new g(customEmotionData.url, file);
        gVar.U = true;
        gVar.S = "comic_emoticon";
        gVar.f313008f = 3;
        hVar.startDownload(gVar, new a(file, customEmotionData, iFavroamingDBManagerService, list, iPicDownloadListener, list2, entityManager, vipComicFavorEmoStructMsgInfo, atomicInteger2, atomicInteger), null);
    }

    private void updateComicEmo(Message message) {
        List list;
        try {
            list = (List) message.obj;
        } catch (Exception unused) {
            list = null;
        }
        EntityManager entityManager = this.mEm;
        if (entityManager != null && entityManager.isOpen() && list != null && list.size() > 0) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", (Integer) 2);
                String[] strArr = new String[list.size()];
                StringBuilder sb5 = new StringBuilder(" ( ");
                for (int i3 = 0; i3 < list.size(); i3++) {
                    sb5.append(" ? ");
                    if (i3 != list.size() - 1) {
                        sb5.append(",");
                    }
                    strArr[i3] = SecurityUtile.encode(((String) list.get(i3)).toUpperCase());
                }
                sb5.append(" ) ");
                this.mEm.update(VipComicFavorEmoStructMsgInfo.class.getSimpleName(), contentValues, "picMd5 in " + sb5.toString(), strArr);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public void delComicEmoticonList(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Map<String, VipComicFavorEmoStructMsgInfo> comicStructInfoMap = getComicStructInfoMap();
            if (comicStructInfoMap != null && comicStructInfoMap.size() > 0) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String upperCase = it.next().toUpperCase();
                    if (comicStructInfoMap.get(upperCase) != null) {
                        arrayList.add(upperCase);
                    }
                }
            }
            if (this.vipComicMqqHandler != null && arrayList.size() > 0) {
                this.vipComicMqqHandler.D2(arrayList);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "delComicStructMsgInfo , delList = " + list);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public VipComicFavorEmoStructMsgInfo getComicStructInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.mComicFavEmoCache.get(str.toUpperCase());
        }
        return null;
    }

    public List<VipComicFavorEmoStructMsgInfo> getComicStructInfoListByStatus(int i3) {
        Map<String, VipComicFavorEmoStructMsgInfo> comicStructInfoMap = getComicStructInfoMap();
        if (comicStructInfoMap != null) {
            ArrayList arrayList = new ArrayList();
            for (VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo : comicStructInfoMap.values()) {
                if (vipComicFavorEmoStructMsgInfo.status == i3) {
                    arrayList.add(vipComicFavorEmoStructMsgInfo);
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public Map<String, VipComicFavorEmoStructMsgInfo> getComicStructInfoMap() {
        if (!this.mComicFavEmoCache.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.mComicFavEmoCache);
            return hashMap;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public List<CustomEmotionData> getEmoticonList(List<CustomEmotionData> list) {
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.mApp.getRuntimeService(IFavroamingDBManagerService.class, "");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Call getEmoticonDataList from getEmoticonList.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null && emoticonDataList.size() != 0) {
            for (CustomEmotionData customEmotionData : emoticonDataList) {
                if (!"needDel".equals(customEmotionData.RomaingType) && list != null) {
                    list.add(customEmotionData);
                }
            }
            return emoticonDataList;
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public String getFilePath(String str) {
        String secureUin = DiySecureFileHelper.secureUin(this.mApp.getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
            return AppConstants.SDCARD_IMG_FAVORITE + secureUin + "-" + str.toUpperCase() + ".jpg";
        }
        return AppConstants.SDCARD_IMG_FAVORITE + secureUin + "-" + str + ".jpg";
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public void handleComicEmoticon(Context context, List<CustomEmotionData> list, Map<String, VipComicFavorEmoStructMsgInfo> map, IPicDownloadListener iPicDownloadListener) {
        VipComicMqqManagerServiceImpl vipComicMqqManagerServiceImpl;
        List<CustomEmotionData> list2;
        int i3;
        IFavroamingDBManagerService iFavroamingDBManagerService;
        boolean z16;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        ArrayList arrayList;
        ArrayList arrayList2;
        h hVar;
        boolean z17;
        EntityManager entityManager;
        VipComicMqqManagerServiceImpl vipComicMqqManagerServiceImpl2 = this;
        List<CustomEmotionData> list3 = list;
        Map<String, VipComicFavorEmoStructMsgInfo> map2 = map;
        if (context != null && list3 != null && !list.isEmpty() && map2 != null) {
            if (map.isEmpty()) {
                vipComicMqqManagerServiceImpl = vipComicMqqManagerServiceImpl2;
                list2 = list3;
            } else {
                EntityManager createEntityManager = vipComicMqqManagerServiceImpl2.mApp.getEntityManagerFactory().createEntityManager();
                if (!NetworkUtil.isNetworkAvailable(context)) {
                    vipComicMqqManagerServiceImpl2.onListenerDone(list3, iPicDownloadListener);
                    return;
                }
                h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
                if (downloader == null) {
                    vipComicMqqManagerServiceImpl2.onListenerDone(list3, iPicDownloadListener);
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                AtomicInteger atomicInteger3 = new AtomicInteger(list.size());
                boolean z18 = false;
                AtomicInteger atomicInteger4 = new AtomicInteger(0);
                IFavroamingDBManagerService iFavroamingDBManagerService2 = (IFavroamingDBManagerService) vipComicMqqManagerServiceImpl2.mApp.getRuntimeService(IFavroamingDBManagerService.class, "");
                int i16 = 0;
                while (i16 < list.size()) {
                    CustomEmotionData customEmotionData = list3.get(i16);
                    VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = map2.get(customEmotionData.md5);
                    if (TextUtils.isEmpty(customEmotionData.url)) {
                        arrayList4.add(customEmotionData);
                        iFavroamingDBManagerService2.deleteCustomEmotion(customEmotionData);
                        createEntityManager.remove(vipComicFavorEmoStructMsgInfo);
                        atomicInteger3.decrementAndGet();
                        vipComicMqqManagerServiceImpl2.onListenerFailDone(iPicDownloadListener, customEmotionData, z18);
                        i3 = i16;
                        iFavroamingDBManagerService = iFavroamingDBManagerService2;
                        z16 = z18;
                        atomicInteger = atomicInteger4;
                        atomicInteger2 = atomicInteger3;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        hVar = downloader;
                        entityManager = createEntityManager;
                        z17 = true;
                    } else if (downloader.getTask(customEmotionData.url) != null) {
                        iFavroamingDBManagerService2.deleteCustomEmotion(customEmotionData);
                        createEntityManager.remove(vipComicFavorEmoStructMsgInfo);
                        atomicInteger3.decrementAndGet();
                        i3 = i16;
                        iFavroamingDBManagerService = iFavroamingDBManagerService2;
                        z16 = z18;
                        atomicInteger = atomicInteger4;
                        atomicInteger2 = atomicInteger3;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        hVar = downloader;
                        entityManager = createEntityManager;
                        z17 = true;
                        i16 = i3 + 1;
                        map2 = map;
                        arrayList4 = arrayList;
                        arrayList3 = arrayList2;
                        createEntityManager = entityManager;
                        iFavroamingDBManagerService2 = iFavroamingDBManagerService;
                        z18 = z16;
                        atomicInteger4 = atomicInteger;
                        atomicInteger3 = atomicInteger2;
                        downloader = hVar;
                        vipComicMqqManagerServiceImpl2 = this;
                        list3 = list;
                    } else {
                        File file = new File(vipComicMqqManagerServiceImpl2.getFilePath(customEmotionData.md5));
                        if (file.exists()) {
                            atomicInteger3.decrementAndGet();
                            customEmotionData.emoPath = file.getAbsolutePath();
                            if (FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType)) {
                                customEmotionData.RomaingType = "isUpdate";
                            }
                            if (QLog.isColorLevel() && !TextUtils.isEmpty(customEmotionData.emoPath)) {
                                String fileMd5 = SecUtil.getFileMd5(customEmotionData.emoPath);
                                if (!customEmotionData.md5.equals(fileMd5)) {
                                    QLog.i(TAG, 2, "init = " + customEmotionData.md5 + " , compute = " + fileMd5);
                                }
                            }
                            iFavroamingDBManagerService2.updateCustomEmotion(customEmotionData);
                            arrayList3.add(customEmotionData);
                            vipComicMqqManagerServiceImpl2.onListenerFailDone(iPicDownloadListener, customEmotionData, true);
                            i3 = i16;
                            iFavroamingDBManagerService = iFavroamingDBManagerService2;
                            z16 = z18;
                            atomicInteger = atomicInteger4;
                            atomicInteger2 = atomicInteger3;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            hVar = downloader;
                            z17 = true;
                            entityManager = createEntityManager;
                        } else {
                            i3 = i16;
                            iFavroamingDBManagerService = iFavroamingDBManagerService2;
                            z16 = z18;
                            atomicInteger = atomicInteger4;
                            atomicInteger2 = atomicInteger3;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            hVar = downloader;
                            z17 = true;
                            entityManager = createEntityManager;
                            startDownload(iPicDownloadListener, createEntityManager, downloader, arrayList3, arrayList4, atomicInteger3, atomicInteger, iFavroamingDBManagerService, customEmotionData, vipComicFavorEmoStructMsgInfo, file);
                        }
                    }
                    if (atomicInteger2.get() == 0 && iPicDownloadListener != null) {
                        iPicDownloadListener.onDone(arrayList2, arrayList);
                    }
                    i16 = i3 + 1;
                    map2 = map;
                    arrayList4 = arrayList;
                    arrayList3 = arrayList2;
                    createEntityManager = entityManager;
                    iFavroamingDBManagerService2 = iFavroamingDBManagerService;
                    z18 = z16;
                    atomicInteger4 = atomicInteger;
                    atomicInteger3 = atomicInteger2;
                    downloader = hVar;
                    vipComicMqqManagerServiceImpl2 = this;
                    list3 = list;
                }
                return;
            }
        } else {
            vipComicMqqManagerServiceImpl = this;
            list2 = list;
        }
        vipComicMqqManagerServiceImpl.onListenerDone(list2, iPicDownloadListener);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 91000:
                initCache();
                return true;
            case MSG_SAVE_COMIC_EMO /* 91001 */:
                Object obj = message.obj;
                if (obj instanceof VipComicFavorEmoStructMsgInfo) {
                    doSaveComicStructInfo((VipComicFavorEmoStructMsgInfo) obj);
                }
                return true;
            case MSG_SAVE_COMIC_EMO_BATCH /* 91002 */:
                saveComicEmoBatch(message);
                return true;
            case MSG_UPDATE_COMIC_EMO /* 91003 */:
                updateComicEmo(message);
                return true;
            default:
                return false;
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public boolean isComicEmoticon(CustomEmotionData customEmotionData) {
        if (customEmotionData != null && !TextUtils.isEmpty(customEmotionData.md5) && getComicStructInfo(customEmotionData.md5) != null) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mApp = appInterface;
        this.mEm = appInterface.getEntityManagerFactory().createEntityManager();
        this.vipComicMqqHandler = (VipComicMqqHandler) this.mApp.getBusinessHandler(VipComicMqqHandler.f204459e);
        this.mComicFavEmoCache = new ConcurrentHashMap();
        Handler handler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.mDBHandler = handler;
        handler.sendEmptyMessage(91000);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mApp = null;
        this.vipComicMqqHandler = null;
        EntityManager entityManager = this.mEm;
        if (entityManager != null) {
            entityManager.close();
        }
        this.mComicFavEmoCache.clear();
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public void saveComicStructInfo(VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo) {
        Message obtainMessage = this.mDBHandler.obtainMessage(MSG_SAVE_COMIC_EMO);
        obtainMessage.obj = vipComicFavorEmoStructMsgInfo;
        this.mDBHandler.sendMessage(obtainMessage);
        this.mComicFavEmoCache.put(vipComicFavorEmoStructMsgInfo.picMd5, vipComicFavorEmoStructMsgInfo);
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public void setMyComicEmoticon(List<VipComicFavorEmoStructMsgInfo> list, boolean z16) {
        if (list != null && list.size() > 0) {
            if (z16) {
                saveComicStructInfoList(list);
            }
            if (this.vipComicMqqHandler != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo : list) {
                    MqqComicPb$ComicFavorEmotIcons mqqComicPb$ComicFavorEmotIcons = new MqqComicPb$ComicFavorEmotIcons();
                    mqqComicPb$ComicFavorEmotIcons.md5.set(vipComicFavorEmoStructMsgInfo.picMd5);
                    mqqComicPb$ComicFavorEmotIcons.info.set(vipComicFavorEmoStructMsgInfo.actionData);
                    arrayList.add(mqqComicPb$ComicFavorEmotIcons);
                }
                this.vipComicMqqHandler.L2(arrayList);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "setMyComicEmoticon,isNeedSaveDb =" + z16 + " , favorEmoStructMsgInfoList = " + list);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public void updateComicStructInfo(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Message obtainMessage = this.mDBHandler.obtainMessage(MSG_UPDATE_COMIC_EMO);
            obtainMessage.obj = list;
            this.mDBHandler.sendMessage(obtainMessage);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.mComicFavEmoCache.get(it.next().toUpperCase()).status = 2;
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
    public void uploadInitComicEmoStructMsgInfo() {
        List<VipComicFavorEmoStructMsgInfo> comicStructInfoListByStatus = getComicStructInfoListByStatus(1);
        setMyComicEmoticon(comicStructInfoListByStatus, false);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "uploadInitComicEmoStructMsgInfo , comicFavorEmoStructMsgInfoList = " + comicStructInfoListByStatus);
        }
    }
}
