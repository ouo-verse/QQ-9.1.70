package com.tencent.mobileqq.emosm.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.app.DiyDoutuHelper;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.au;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.n;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x388.cmd0x388$ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388$ExtensionExpRoamTryUp;
import tencent.im.cs.cmd0x388.cmd0x388$StoreFileInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FavroamingManagerServiceImpl extends CustomEmotionRoamingManagerBase<CustomEmotionData> implements IFavroamingManagerService {
    public static final String TAG = "FavroamingManager";
    private static final long serialVersionUID = 1;
    private volatile com.tencent.mobileqq.emosm.favroaming.a mAccessibilitylistener;
    private boolean mCancelAddCustomEmotion;
    WeakReference<TransferRequest> mCurAddCustomEmotionsRequest;
    protected ITransFileController mFileController;
    private EmoAddedAuthCallback.c uploadListener;
    boolean isAddHandler = false;
    protected AtomicInteger downloadCount = new AtomicInteger(0);
    protected AtomicInteger uploadCount = new AtomicInteger(0);
    protected int needDownloadCount = 0;
    protected int needUploadCount = 0;
    protected Map<String, ArrayList<CustomEmotionData>> downMap = new HashMap();
    private ConcurrentHashMap<Integer, String> mAccessibilityEmotionDataMap = new ConcurrentHashMap<>();
    protected TransProcessorHandler mTransProcessorHandler = new a(ThreadManagerV2.getSubThreadLooper());
    private final FavEmoRoamingObserver emoRoamingObserver = new FavEmoRoamingObserver() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.2
        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        public void onDelEmoResponse(boolean z16) {
            if (((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp != null && z16) {
                FavroamingManagerServiceImpl.this.syncRoaming();
            }
        }

        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        public void onUploadReq(final List<CustomEmotionData> list) {
            if (((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp == null) {
                ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).notifySyncFail();
            } else {
                ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.removeObserver(FavroamingManagerServiceImpl.this.emoRoamingObserver);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d(FavEmoRoamingObserver.TAG, 2, "start upload and download fav");
                        }
                        FavroamingManagerServiceImpl.this.syncUpload(list);
                        FavroamingManagerServiceImpl.this.downLoadEmo();
                    }
                }, 128, null, true);
            }
        }
    };
    public EmoticonPackageDownloadListener downloadListener = new b();
    private EmotionJsonDownloadListener jsonListener = new c();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends TransProcessorHandler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null && fileMsg.commandId == FavroamingManagerServiceImpl.this.getUploadProcessorID()) {
                int i16 = message.what;
                if (i16 != 1001) {
                    if (i16 != 1008) {
                        switch (i16) {
                            case 1003:
                                if (QLog.isColorLevel()) {
                                    QLog.d(FavroamingManagerServiceImpl.TAG, 2, "finish uploadFace favEmoticon resId=" + fileMsg.serverPath);
                                }
                                int incrementAndGet = FavroamingManagerServiceImpl.this.uploadCount.incrementAndGet();
                                FavroamingManagerServiceImpl favroamingManagerServiceImpl = FavroamingManagerServiceImpl.this;
                                if (incrementAndGet >= favroamingManagerServiceImpl.needUploadCount) {
                                    favroamingManagerServiceImpl.notifyFavEmoticonUploaded();
                                    return;
                                }
                                return;
                            case 1004:
                                QLog.i(FavroamingManagerServiceImpl.TAG, 1, "upload fav cancel:" + fileMsg.serverPath);
                                return;
                            case 1005:
                                QLog.i(FavroamingManagerServiceImpl.TAG, 1, "upload fav error:" + fileMsg.serverPath);
                                if (((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp != null) {
                                    i3 = NetworkUtil.getNetworkType(((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getApplication());
                                } else {
                                    i3 = -1;
                                }
                                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACTION_FAV, "4", "", "", i3 + "", fileMsg.serverPath, "", "", "");
                                return;
                            default:
                                return;
                        }
                    }
                    if (((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp == null) {
                        QLog.e(FavroamingManagerServiceImpl.TAG, 1, "app is null");
                        return;
                    }
                    QLog.d(FavroamingManagerServiceImpl.TAG, 1, "STATUS_SEND_AND_SAVE_FINISHED resId=" + fileMsg.serverPath);
                    CustomEmotionData updateUpload = ((IFavroamingDBManagerService) FavroamingManagerServiceImpl.this.getDBManager()).updateUpload(fileMsg.serverPath);
                    FavEmoRoamingHandler favEmoRoamingHandler = (FavEmoRoamingHandler) ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getBusinessHandler(FavEmoRoamingHandler.f194632e);
                    if (favEmoRoamingHandler != null && updateUpload != null && !updateUpload.isMarkFace) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(updateUpload);
                        favEmoRoamingHandler.I2(arrayList, 1);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(FavroamingManagerServiceImpl.TAG, 2, "start uploadFace favEmoticon");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends EmoticonPackageDownloadListener {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
        public void onPackageEnd(EmoticonPackage emoticonPackage, int i3) {
            boolean z16;
            super.onPackageEnd(emoticonPackage, i3);
            com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(FavroamingManagerServiceImpl.this.downloadListener);
            IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getRuntimeService(IFavroamingDBManagerService.class);
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getRuntimeService(IEmoticonManagerService.class);
            List<CustomEmotionData> findMagicEmosById = iFavroamingDBManagerService.findMagicEmosById(emoticonPackage.epId);
            if (findMagicEmosById != null && findMagicEmosById.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < findMagicEmosById.size(); i16++) {
                    CustomEmotionData customEmotionData = findMagicEmosById.get(i16);
                    if (iEmoticonManagerService.syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId) == null) {
                        customEmotionData.RomaingType = "needDel";
                        iFavroamingDBManagerService.updateCustomEmotion(customEmotionData);
                        if (!TextUtils.isEmpty(customEmotionData.resid)) {
                            arrayList.add(customEmotionData.resid);
                        }
                    }
                    FavroamingManagerServiceImpl favroamingManagerServiceImpl = FavroamingManagerServiceImpl.this;
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    favroamingManagerServiceImpl.onFileDone(customEmotionData, z16);
                }
                FavEmoRoamingHandler favEmoRoamingHandler = (FavEmoRoamingHandler) ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getBusinessHandler(FavEmoRoamingHandler.f194632e);
                if (favEmoRoamingHandler != null && arrayList.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(FavroamingManagerServiceImpl.TAG, 2, "delResId: " + arrayList);
                    }
                    favEmoRoamingHandler.delUserEmoRoamingReq(arrayList, false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c extends EmotionJsonDownloadListener {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
            byte[] bArr;
            if (!FavroamingManagerServiceImpl.this.downMap.containsKey(emoticonPackage.epId)) {
                return;
            }
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getRuntimeService(IEmojiManagerService.class);
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(FavroamingManagerServiceImpl.TAG, 2, "onJsonComplete, start download fav emoticon: " + emoticonPackage.epId);
                }
                int i16 = bundle.getInt("jsonType", EmojiManagerServiceConstant.JSON_EMOSM_MALL);
                File file = new File(MarketFaceConstants.emoticonJsonFilePath.replace("[epId]", emoticonPackage.epId));
                ArrayList<Emoticon> arrayList = new ArrayList<>();
                ReqInfo reqInfo = new ReqInfo();
                if (file.exists()) {
                    bArr = FileUtils.fileToBytes(file);
                } else {
                    bArr = null;
                }
                String parseJson = EmotionJsonUtils.parseJson(((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp, emoticonPackage, i16, bArr, arrayList, reqInfo);
                if (parseJson != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(FavroamingManagerServiceImpl.TAG, 2, "parse Json Error:" + parseJson);
                    }
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACTION_FAV, "2", emoticonPackage.epId, "", "", parseJson, "", "", "");
                    return;
                }
                FavroamingManagerServiceImpl.this.fetchEmoticonEncryptKeys(emoticonPackage, iEmojiManagerService, arrayList, reqInfo);
                FavroamingManagerServiceImpl.this.onJsonCompleteSuccess(emoticonPackage, iEmojiManagerService);
                return;
            }
            FavroamingManagerServiceImpl.this.onJsonCompleteFail(emoticonPackage);
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACTION_FAV, "1", emoticonPackage.epId, "", NetworkUtil.getNetworkType(((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getApplication()) + "", i3 + "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCustomEmotion(String str, EmoAddedAuthCallback.c cVar) {
        int i3;
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            i3 = 1;
            for (int i16 = 0; i16 < emoticonDataList.size(); i16++) {
                CustomEmotionData customEmotionData = emoticonDataList.get(i16);
                int i17 = customEmotionData.emoId;
                if (bytes2HexStr != null && bytes2HexStr.equals(customEmotionData.md5)) {
                    if ("needDel".equals(customEmotionData.RomaingType)) {
                        iFavroamingDBManagerService.updateDeletedEmoticon(customEmotionData, i16);
                        if (cVar != null) {
                            cVar.a(0, bytes2HexStr);
                            return;
                        }
                        return;
                    }
                    if (cVar != null) {
                        cVar.a(1, bytes2HexStr);
                        return;
                    }
                    return;
                }
                if (i3 < i17) {
                    i3 = i17;
                }
            }
        } else {
            i3 = 1;
        }
        CustomEmotionData customEmotionData2 = new CustomEmotionData();
        customEmotionData2.uin = baseQQAppInterface.getCurrentAccountUin();
        customEmotionData2.emoId = i3 + 1;
        customEmotionData2.emoPath = str;
        customEmotionData2.md5 = bytes2HexStr;
        customEmotionData2.isMarkFace = false;
        EmoAddedAuthCallback emoAddedAuthCallback = new EmoAddedAuthCallback(baseQQAppInterface, null, customEmotionData2, null, 2);
        emoAddedAuthCallback.h(cVar);
        this.mCurAddCustomEmotionsRequest = new WeakReference<>(syncUpload(customEmotionData2, emoAddedAuthCallback));
    }

    public static FavroamingManagerServiceImpl get(BaseQQAppInterface baseQQAppInterface) {
        return (FavroamingManagerServiceImpl) baseQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    }

    private String getContentDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return String.format(BaseApplication.getContext().getString(R.string.in8), str);
    }

    private void notifyFavEmoticonDownloaded() {
        n nVar;
        int i3 = this.downloadCount.get();
        this.downloadCount.set(0);
        this.needDownloadCount = 0;
        for (int i16 = 0; i16 < this.listeners.size(); i16++) {
            if (this.listeners.get(i16) != null && (nVar = this.listeners.get(i16).get()) != null) {
                nVar.onDownloadFinish(i3);
            }
        }
        notifyFavEmoticonSyncFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccessibilityEmotionDataMap(final Map<Integer, String> map) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.10
            @Override // java.lang.Runnable
            public void run() {
                FavroamingManagerServiceImpl.this.mAccessibilityEmotionDataMap.clear();
                if (map != null) {
                    FavroamingManagerServiceImpl.this.mAccessibilityEmotionDataMap.putAll(map);
                }
                com.tencent.mobileqq.emosm.favroaming.a aVar = FavroamingManagerServiceImpl.this.mAccessibilitylistener;
                if (aVar != null) {
                    aVar.a(new HashMap<>(FavroamingManagerServiceImpl.this.mAccessibilityEmotionDataMap));
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void addCustomEmotions(final List<String> list, final IFavroamingManagerService.AddCustomEmotionsCallback addCustomEmotionsCallback) {
        if (list == null) {
            return;
        }
        final int size = list.size();
        if (size == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "addCustomEmotions pathList is empty");
            }
        } else {
            this.mCancelAddCustomEmotion = false;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.8

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl$8$a */
                /* loaded from: classes6.dex */
                class a implements EmoAddedAuthCallback.c {

                    /* renamed from: a, reason: collision with root package name */
                    private int f204203a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ List f204204b;

                    a(List list) {
                        this.f204204b = list;
                    }

                    @Override // com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.c
                    public void a(int i3, String str) {
                        this.f204204b.add(Integer.valueOf(i3));
                        int i16 = this.f204203a + 1;
                        this.f204203a = i16;
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        if (i16 <= size) {
                            FavroamingManagerServiceImpl.this.notifyFavEmoticonUploaded();
                            IFavroamingManagerService.AddCustomEmotionsCallback addCustomEmotionsCallback = addCustomEmotionsCallback;
                            if (addCustomEmotionsCallback != null) {
                                addCustomEmotionsCallback.onProgressChanged(this.f204203a / size, this.f204204b);
                            }
                        }
                        int i17 = this.f204203a;
                        AnonymousClass8 anonymousClass82 = AnonymousClass8.this;
                        if (i17 < size) {
                            if (!FavroamingManagerServiceImpl.this.mCancelAddCustomEmotion) {
                                String str2 = (String) list.get(this.f204203a);
                                FavroamingManagerServiceImpl favroamingManagerServiceImpl = FavroamingManagerServiceImpl.this;
                                favroamingManagerServiceImpl.addCustomEmotion(str2, favroamingManagerServiceImpl.uploadListener);
                                return;
                            }
                            return;
                        }
                        MqqHandler handler = ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getHandler(((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityClass());
                        if (handler != null) {
                            handler.obtainMessage(10).sendToTarget();
                        }
                        IFavroamingManagerService.AddCustomEmotionsCallback addCustomEmotionsCallback2 = addCustomEmotionsCallback;
                        if (addCustomEmotionsCallback2 != null) {
                            addCustomEmotionsCallback2.onUploadFinish(this.f204204b);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    FavroamingManagerServiceImpl.this.uploadListener = new a(arrayList);
                    String str = (String) list.get(0);
                    FavroamingManagerServiceImpl favroamingManagerServiceImpl = FavroamingManagerServiceImpl.this;
                    favroamingManagerServiceImpl.addCustomEmotion(str, favroamingManagerServiceImpl.uploadListener);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void asyncIncreaseEmotionClickNum(CustomEmotionData customEmotionData) {
        customEmotionData.increaseClickNum();
        getDBManager().updateCustomEmotion(customEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void cacheAccessibilityEmotionData() {
        final BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface == null) {
            QLog.e(TAG, 2, "[cacheAccessibilityEmotionData] error, app is null!");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) baseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
                    IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
                    List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
                    if (emoticonDataList != null && emoticonDataList.size() > 0) {
                        HashMap hashMap = new HashMap();
                        for (CustomEmotionData customEmotionData : emoticonDataList) {
                            String str = "";
                            if (customEmotionData.isMarkFace) {
                                Emoticon syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId);
                                if (syncFindEmoticonById != null && !TextUtils.isEmpty(syncFindEmoticonById.name)) {
                                    str = syncFindEmoticonById.name;
                                }
                            } else {
                                if (!TextUtils.isEmpty(customEmotionData.modifyWord)) {
                                    str = customEmotionData.modifyWord;
                                }
                                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(customEmotionData.ocrWord)) {
                                    str = customEmotionData.ocrWord;
                                }
                            }
                            hashMap.put(Integer.valueOf(customEmotionData.emoId), str);
                        }
                        FavroamingManagerServiceImpl.this.updateAccessibilityEmotionDataMap(hashMap);
                        return;
                    }
                    QLog.d(FavroamingManagerServiceImpl.TAG, 2, "[cacheAccessibilityEmotionData] emoticonDataList is empty!");
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void cancelAddCustomEmotions() {
        TransferRequest transferRequest;
        this.mCancelAddCustomEmotion = true;
        WeakReference<TransferRequest> weakReference = this.mCurAddCustomEmotionsRequest;
        if (weakReference != null && (transferRequest = weakReference.get()) != null) {
            this.mFileController.stop(transferRequest);
        }
    }

    public void downLoadEmo() {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.isInSync.set(false);
            return;
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface == null) {
            return;
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) baseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        List emoticonDatasByType = iFavroamingDBManagerService.getEmoticonDatasByType(FavEmoConstant.ROAMING_TYPE_PANEL);
        List emoticonDatasByType2 = iFavroamingDBManagerService.getEmoticonDatasByType("overflow");
        ArrayList arrayList = new ArrayList();
        if (emoticonDatasByType != null && emoticonDatasByType.size() > 0) {
            arrayList.addAll(emoticonDatasByType);
        }
        if (emoticonDatasByType2 != null && emoticonDatasByType2.size() > 0) {
            arrayList.addAll(emoticonDatasByType2);
        }
        if (arrayList.size() > 0) {
            this.downloadCount.set(0);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                CustomEmotionData customEmotionData = (CustomEmotionData) arrayList.get(i3);
                if (customEmotionData.isMarkFace) {
                    arrayList3.add(customEmotionData);
                } else {
                    arrayList2.add(customEmotionData);
                }
            }
            if (this.mApp == null) {
                return;
            }
            int size = arrayList3.size();
            this.needDownloadCount = size;
            if (size == 0) {
                notifyFavEmoticonSyncFinished();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "markFace size: " + arrayList3.size() + ", noMarkFace size:" + arrayList2.size());
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).listeners.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null && weakReference.get() != null) {
                            n nVar = (n) weakReference.get();
                            FavroamingManagerServiceImpl favroamingManagerServiceImpl = FavroamingManagerServiceImpl.this;
                            nVar.onFileDone(null, favroamingManagerServiceImpl.needDownloadCount, favroamingManagerServiceImpl.downloadCount.get());
                            if (QLog.isColorLevel()) {
                                QLog.i(FavroamingManagerServiceImpl.TAG, 2, "now notify listener on file done!");
                            }
                        }
                    }
                }
            });
            downLoadMarketEmoList(arrayList3);
            return;
        }
        notifyFavEmoticonSyncFinished();
    }

    public void downLoadMarketEmo(String str) {
        if (str == null) {
            return;
        }
        com.tencent.mobileqq.emoticon.b.b().addEmotionJsonDownloadListener(this.jsonListener);
        ((IEmojiManagerService) this.mApp.getRuntimeService(IEmojiManagerService.class)).startDownloadEmosmJson(str, EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, false);
    }

    public synchronized void downLoadMarketEmoList(List<CustomEmotionData> list) {
        if (list == null) {
            return;
        }
        this.downMap.clear();
        for (int i3 = 0; i3 < list.size(); i3++) {
            CustomEmotionData customEmotionData = list.get(i3);
            if (customEmotionData != null) {
                if (this.downMap.containsKey(customEmotionData.emoPath)) {
                    this.downMap.get(customEmotionData.emoPath).add(customEmotionData);
                } else {
                    ArrayList<CustomEmotionData> arrayList = new ArrayList<>();
                    arrayList.add(customEmotionData);
                    this.downMap.put(customEmotionData.emoPath, arrayList);
                }
            }
        }
        try {
            for (Map.Entry<String, ArrayList<CustomEmotionData>> entry : this.downMap.entrySet()) {
                if (entry != null) {
                    downLoadMarketEmo(entry.getKey());
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downMap exception=" + e16.toString());
            }
        }
    }

    protected void fetchEmoticonEncryptKeys(EmoticonPackage emoticonPackage, IEmojiManagerService iEmojiManagerService, ArrayList<Emoticon> arrayList, ReqInfo reqInfo) {
        if (!reqInfo.encryptKeysSuccess && emoticonPackage.jobType != 4) {
            int i3 = 0;
            do {
                reqInfo.strGetKeySeq = null;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i3);
                }
                iEmojiManagerService.fetchEmoticonEncryptKeys(emoticonPackage.epId, arrayList, reqInfo);
                i3++;
                if (reqInfo.encryptKeysSuccess) {
                    break;
                }
            } while (i3 < 3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i3 + " encryptKeysSuccess=" + reqInfo.encryptKeysSuccess);
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public String getAccessibilityDescription(Integer num) {
        if (num == null) {
            return getContentDescription("");
        }
        return getContentDescription(this.mAccessibilityEmotionDataMap.get(num));
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
    protected CustomEmotionRoamingDBManagerBase<CustomEmotionData> getDBManager() {
        return (CustomEmotionRoamingDBManagerBase) this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
    protected CustomEmoRoamingBaseHandler<CustomEmotionData> getRoamingHandler() {
        return (FavEmoRoamingHandler) this.mApp.getBusinessHandler(FavEmoRoamingHandler.f194632e);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
    public int getUploadProcessorID() {
        return 9;
    }

    public boolean isSyncFinish() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadCount:" + this.downloadCount.get() + ", needDownloadCount" + this.needDownloadCount + "uploadCount:" + this.uploadCount.get() + ", needUploadCount" + this.needUploadCount);
        }
        if (this.downloadCount.get() == this.needDownloadCount && this.uploadCount.get() == this.needUploadCount) {
            return true;
        }
        return false;
    }

    protected void notifyFavEmoticonSyncFinished() {
        n nVar;
        if (isSyncFinish()) {
            this.isInSync.set(false);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "------------end syncRoaming----------");
            }
            for (int i3 = 0; i3 < this.listeners.size(); i3++) {
                if (this.listeners.get(i3) != null && (nVar = this.listeners.get(i3).get()) != null) {
                    nVar.onSyncFinish();
                }
            }
        }
    }

    protected void notifyFavEmoticonUploaded() {
        n nVar;
        this.uploadCount.set(0);
        this.needUploadCount = 0;
        for (int i3 = 0; i3 < this.listeners.size(); i3++) {
            if (this.listeners.get(i3) != null && (nVar = this.listeners.get(i3).get()) != null) {
                nVar.onUploadFinish();
            }
        }
        notifyFavEmoticonSyncFinished();
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        int i3;
        super.onCreate(appRuntime);
        this.mFileController = (ITransFileController) this.mApp.getRuntimeService(ITransFileController.class);
        if (!TextUtils.isEmpty(this.uin)) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
            if (VasUtil.getSignedService(appRuntime).getVipStatus().isSVip()) {
                i3 = 1000;
            } else {
                i3 = 500;
            }
            int i16 = sharedPreferences.getInt(FavEmoConstant.SP_MAX_FROM_SERVER + this.uin, i3);
            if (i16 > 144) {
                FavEmoConstant.FAV_LOCAL_MAX_COUNT = i16;
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase, mqq.app.api.IRuntimeService
    public void onDestroy() {
        super.onDestroy();
        ITransFileController iTransFileController = this.mFileController;
        if (iTransFileController != null) {
            iTransFileController.removeHandle(this.mTransProcessorHandler);
            this.mTransProcessorHandler = null;
        }
        this.mApp.removeObserver(this.emoRoamingObserver);
        com.tencent.mobileqq.emoticon.b.b().removeEmotionJsonDownloadListener(this.jsonListener);
    }

    public void onFileDone(CustomEmotionData customEmotionData, boolean z16) {
        n nVar;
        if (customEmotionData != null && this.mApp != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onFileDone, resId=" + customEmotionData.resid + ",isSuccess = " + z16 + " , roamingType: " + customEmotionData.RomaingType);
            }
            IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
            if (iFavroamingDBManagerService != null && z16) {
                if (FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType)) {
                    customEmotionData.RomaingType = "isUpdate";
                } else if ("overflow".equals(customEmotionData.RomaingType)) {
                    customEmotionData.RomaingType = FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED;
                }
                if (!"needDel".equals(customEmotionData.RomaingType)) {
                    iFavroamingDBManagerService.updateCustomEmotion(customEmotionData);
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onFileDone, resId=" + customEmotionData.resid + " has been deleted");
                }
            }
            for (int i3 = 0; i3 < this.listeners.size(); i3++) {
                if (this.listeners.get(i3) != null && (nVar = this.listeners.get(i3).get()) != null) {
                    nVar.onFileDone(customEmotionData, this.needDownloadCount, this.downloadCount.get());
                }
            }
            int incrementAndGet = this.downloadCount.incrementAndGet();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "market face : downloadCount: " + incrementAndGet + ",needDownloadCount: " + this.needDownloadCount);
            }
            if (incrementAndGet >= this.needDownloadCount) {
                notifyFavEmoticonDownloaded();
            }
        }
    }

    protected void onJsonCompleteFail(EmoticonPackage emoticonPackage) {
        ArrayList<CustomEmotionData> arrayList = this.downMap.get(emoticonPackage.epId);
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                CustomEmotionData customEmotionData = arrayList.get(i3);
                if (customEmotionData != null) {
                    onFileDone(customEmotionData, false);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadAIOEmoticon fail epId:" + emoticonPackage.epId);
        }
    }

    protected void onJsonCompleteSuccess(EmoticonPackage emoticonPackage, IEmojiManagerService iEmojiManagerService) {
        ArrayList<CustomEmotionData> arrayList = this.downMap.get(emoticonPackage.epId);
        if (arrayList != null) {
            int i3 = emoticonPackage.jobType;
            if (i3 == 0) {
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    CustomEmotionData customEmotionData = arrayList.get(i16);
                    if (customEmotionData != null) {
                        Emoticon emoticon = new Emoticon();
                        BaseQQAppInterface baseQQAppInterface = this.mApp;
                        if (baseQQAppInterface == null) {
                            QLog.i(TAG, 1, "downloadAIOEmoticon|app null");
                            onFileDone(customEmotionData, false);
                        } else {
                            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
                            if (iEmoticonManagerService != null) {
                                emoticon = iEmoticonManagerService.syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId);
                            }
                            if (emoticon == null) {
                                QLog.i(TAG, 1, "downloadAIOEmoticon|cannot find emoticon: epId:" + emoticonPackage.epId + "\uff0ceid=" + customEmotionData.eId);
                                customEmotionData.RomaingType = "needDel";
                                ((IFavroamingDBManagerService) this.mApp.getRuntimeService(IFavroamingDBManagerService.class)).updateCustomEmotion(customEmotionData);
                                onFileDone(arrayList.get(i16), false);
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "downloadAIOEmoticon|taskvalue:14\uff0cepid:" + emoticon.epId + "\uff0ceid=" + emoticon.eId);
                                }
                                if (iEmojiManagerService.downloadAIOEmoticon(emoticon, 14)) {
                                    onFileDone(arrayList.get(i16), true);
                                } else {
                                    onFileDone(arrayList.get(i16), false);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (i3 == 3 || i3 == 5) {
                com.tencent.mobileqq.emoticon.b.b().addEmoticonPackageDownloadListener(this.downloadListener);
                iEmojiManagerService.pullEmoticonPackage(emoticonPackage, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void removeCacheAccessibilityEmotionData(Integer num) {
        if (num == null) {
            return;
        }
        this.mAccessibilityEmotionDataMap.remove(num);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void setUpdateResultListener(com.tencent.mobileqq.emosm.favroaming.a aVar) {
        this.mAccessibilitylistener = aVar;
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void syncIncreaseEmoticonExposeNum(CustomEmotionData customEmotionData) {
        customEmotionData.increaseExposeNum();
        getDBManager().updateCustomEmotion(customEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase, com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void syncLocalDel() {
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface == null) {
            QLog.i(TAG, 1, "syncLocalDel  app is null");
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).notifySyncFail();
            return;
        }
        final FavEmoRoamingHandler favEmoRoamingHandler = (FavEmoRoamingHandler) baseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.f194632e);
        if (favEmoRoamingHandler == null) {
            QLog.i(TAG, 1, "syncLocalDel  favHandler is null");
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).notifySyncFail();
        } else {
            this.mApp.addObserver(this.emoRoamingObserver);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    List<String> customEmoticonResIdsByType = ((IFavroamingDBManagerService) ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp.getRuntimeService(IFavroamingDBManagerService.class)).getCustomEmoticonResIdsByType("needDel");
                    if (customEmoticonResIdsByType.size() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    QLog.i(FavroamingManagerServiceImpl.TAG, 1, "syncLocalDel  needDelete:" + z16);
                    if (z16) {
                        favEmoRoamingHandler.delUserEmoRoamingReq(customEmoticonResIdsByType, true);
                    } else if (customEmoticonResIdsByType.size() == 0) {
                        FavroamingManagerServiceImpl.this.syncRoaming();
                    }
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void syncUpload(List<CustomEmotionData> list) {
        if (list != null) {
            uploadCustomEmoticon(list);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void updateCustomEmotionDataOCR(CustomEmotionData customEmotionData) {
        if (this.mApp != null && customEmotionData != null) {
            getDBManager().updateCustomEmotion(customEmotionData);
            StickerRecManagerImpl.get(this.mApp).updateKeywordForFavEmotion();
            ((com.tencent.qqnt.emotion.api.IFavroamingDBManagerService) this.mApp.getRuntimeService(com.tencent.qqnt.emotion.api.IFavroamingDBManagerService.class)).updateCustomEmotion(customEmotionData);
            ((IStickerRecManager) this.mApp.getRuntimeService(IStickerRecManager.class)).updateKeywordForFavEmotion();
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void updateCustomEmotionDataOCRReq(CustomEmotionData customEmotionData, String str) {
        FavEmoRoamingHandler favEmoRoamingHandler;
        if (this.mApp != null && customEmotionData != null && (favEmoRoamingHandler = (FavEmoRoamingHandler) getRoamingHandler()) != null) {
            favEmoRoamingHandler.J2(customEmotionData, str);
        }
    }

    public int uploadCustomEmoticon(List<CustomEmotionData> list) {
        if (list == null || list.size() == 0 || !NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return 0;
        }
        if (list.size() > FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
            int size = list.size();
            int i3 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
            int i16 = size - i3;
            list = list.subList(i16, i3 + i16);
        }
        int size2 = list.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size2; i18++) {
            CustomEmotionData customEmotionData = list.get(i18);
            if (!FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType) && !"needDel".equals(customEmotionData.RomaingType) && !"isUpdate".equals(customEmotionData.RomaingType)) {
                uploadCustomEmoticon(customEmotionData, null);
                i17++;
            }
        }
        this.needUploadCount = i17;
        return i17;
    }

    public void uploadMarkFace(CustomEmotionData customEmotionData, final TransferRequest transferRequest) {
        if (customEmotionData != null && transferRequest != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "uploadMarkFace favEmoticon.epid=" + customEmotionData.emoPath + " and eid=" + customEmotionData.eId);
            }
            if (!customEmotionData.checkMarketFace("uploadMarkFace")) {
                QLog.e(TAG, 1, "uploadMarkFace: marketFace is invalid");
                ad adVar = transferRequest.mUpCallBack;
                if (adVar instanceof com.tencent.mobileqq.emosm.favroaming.b) {
                    com.tencent.mobileqq.emosm.favroaming.b.c((com.tencent.mobileqq.emosm.favroaming.b) adVar);
                    return;
                }
                return;
            }
            try {
                cmd0x388$ExtensionExpRoamTryUp cmd0x388_extensionexproamtryup = new cmd0x388$ExtensionExpRoamTryUp();
                cmd0x388$ExpRoamPicInfo cmd0x388_exproampicinfo = new cmd0x388$ExpRoamPicInfo();
                cmd0x388_exproampicinfo.bytes_pic_id.set(ByteStringMicro.copyFrom(customEmotionData.eId.getBytes()));
                cmd0x388_exproampicinfo.uint32_pkg_id.set(Integer.parseInt(customEmotionData.emoPath));
                cmd0x388_exproampicinfo.uint32_shop_flag.set(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cmd0x388_exproampicinfo);
                cmd0x388_extensionexproamtryup.rpt_msg_exproam_pic_info.set(arrayList);
                cmd0x388_extensionexproamtryup.uint32_capacity_incr.set(1);
                transferRequest.mExtentionInfo = cmd0x388_extensionexproamtryup.toByteArray();
                transferRequest.mUniseq = customEmotionData.emoId;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "uploadMarkFace frequest.mUniseq=" + transferRequest.mUniseq);
                }
                final String[] imgPreviewTask = ((IEmojiManagerService) this.mApp.getRuntimeService(IEmojiManagerService.class)).getImgPreviewTask(customEmotionData.emoPath, customEmotionData.eId, false);
                transferRequest.mLocalPath = imgPreviewTask[1];
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!FileUtils.fileExists(imgPreviewTask[1])) {
                            g gVar = new g(imgPreviewTask[0], new File(imgPreviewTask[1]));
                            gVar.Q = true;
                            if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, ((CustomEmotionRoamingManagerBase) FavroamingManagerServiceImpl.this).mApp) != 0) {
                                ad adVar2 = transferRequest.mUpCallBack;
                                if (adVar2 instanceof com.tencent.mobileqq.emosm.favroaming.b) {
                                    com.tencent.mobileqq.emosm.favroaming.b.c((com.tencent.mobileqq.emosm.favroaming.b) adVar2);
                                }
                                QLog.e(FavroamingManagerServiceImpl.TAG, 1, "collectEmoji fail to download thumbFile: " + imgPreviewTask[1]);
                                return;
                            }
                        }
                        ITransFileController iTransFileController = FavroamingManagerServiceImpl.this.mFileController;
                        if (iTransFileController != null) {
                            iTransFileController.transferAsync(transferRequest);
                        }
                    }
                }, 5, null, true);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "uploadMarkFace error =", e16.getMessage());
                ad adVar2 = transferRequest.mUpCallBack;
                if (adVar2 instanceof com.tencent.mobileqq.emosm.favroaming.b) {
                    com.tencent.mobileqq.emosm.favroaming.b.c((com.tencent.mobileqq.emosm.favroaming.b) adVar2);
                }
            }
        }
    }

    public void uploadNoMarkFace(CustomEmotionData customEmotionData, TransferRequest transferRequest) {
        int i3;
        if (customEmotionData != null && transferRequest != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "uploadNoMarkFace " + customEmotionData);
            }
            cmd0x388$ExtensionExpRoamTryUp cmd0x388_extensionexproamtryup = new cmd0x388$ExtensionExpRoamTryUp();
            cmd0x388$ExpRoamPicInfo cmd0x388_exproampicinfo = new cmd0x388$ExpRoamPicInfo();
            String funnyPicName = FunnyPicHelperConstant.getFunnyPicName(customEmotionData.emoPath);
            if (!TextUtils.isEmpty(funnyPicName) && funnyPicName.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX)) {
                String replace = funnyPicName.replace(FunnyPicHelperConstant.FUNYPIC_PREFIX, FunnyPicHelperConstant.FUNYPIC_PREFIX_REPLACE);
                cmd0x388_exproampicinfo.bytes_pic_id.set(ByteStringMicro.copyFrom(replace.getBytes()));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "upload FunnyPic name.replace->" + replace);
                }
                int f16 = au.f(customEmotionData.eId);
                if (f16 == 0) {
                    f16 = 1;
                }
                cmd0x388_exproampicinfo.uint32_pkg_id.set(f16);
            } else {
                String picId = DiyDoutuHelper.getPicId(customEmotionData.emoPath);
                if (!picId.equals("")) {
                    cmd0x388_exproampicinfo.bytes_pic_id.set(ByteStringMicro.copyFrom(picId.getBytes()));
                    try {
                        i3 = Integer.parseInt(customEmotionData.eId);
                    } catch (NumberFormatException unused) {
                        i3 = 1;
                    }
                    cmd0x388_exproampicinfo.uint32_pkg_id.set(i3);
                } else {
                    cmd0x388_exproampicinfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
                    cmd0x388_exproampicinfo.uint32_pkg_id.set(0);
                }
            }
            cmd0x388_exproampicinfo.uint32_shop_flag.set(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cmd0x388_exproampicinfo);
            cmd0x388_extensionexproamtryup.rpt_msg_exproam_pic_info.set(arrayList);
            cmd0x388_extensionexproamtryup.uint32_capacity_incr.set(1);
            transferRequest.mExtentionInfo = cmd0x388_extensionexproamtryup.toByteArray();
            transferRequest.mUniseq = customEmotionData.emoId;
            transferRequest.mLocalPath = customEmotionData.emoPath;
            cmd0x388$StoreFileInfo cmd0x388_storefileinfo = new cmd0x388$StoreFileInfo();
            cmd0x388_storefileinfo.jump_id.set(customEmotionData.jumpId);
            transferRequest.storeFileInfo = cmd0x388_storefileinfo;
            ITransFileController iTransFileController = this.mFileController;
            if (iTransFileController != null) {
                iTransFileController.transferAsync(transferRequest);
            }
        }
    }

    public static FavroamingManagerServiceProxy get(IEmoticonMainPanelApp iEmoticonMainPanelApp) {
        return (FavroamingManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(IFavroamingManagerService.class);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void syncUpload(CustomEmotionData customEmotionData) {
        syncUpload(customEmotionData, null);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public TransferRequest syncUpload(CustomEmotionData customEmotionData, ad adVar) {
        return uploadCustomEmoticon(customEmotionData, adVar);
    }

    public TransferRequest uploadCustomEmoticon(CustomEmotionData customEmotionData, ad adVar) {
        TransProcessorHandler transProcessorHandler;
        if (customEmotionData == null) {
            if (adVar instanceof com.tencent.mobileqq.emosm.favroaming.b) {
                com.tencent.mobileqq.emosm.favroaming.b.c((com.tencent.mobileqq.emosm.favroaming.b) adVar);
            }
            return null;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (adVar instanceof com.tencent.mobileqq.emosm.favroaming.b) {
                com.tencent.mobileqq.emosm.favroaming.b.c((com.tencent.mobileqq.emosm.favroaming.b) adVar);
            }
            return null;
        }
        if (!this.isAddHandler && (transProcessorHandler = this.mTransProcessorHandler) != null && this.mFileController != null) {
            transProcessorHandler.addFilter(BDHCommonUploadProcessor.class);
            this.mFileController.addHandle(this.mTransProcessorHandler);
            this.isAddHandler = true;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 9;
        transferRequest.mRichTag = FavEmoConstant.SNAPCHAT_PIC_UPLOAD_STATISTIC_TAG;
        String str = this.uin;
        transferRequest.mSelfUin = str;
        transferRequest.mPeerUin = str;
        transferRequest.mIsUp = true;
        if (adVar != null) {
            transferRequest.mUpCallBack = adVar;
        }
        if (customEmotionData.isMarkFace) {
            uploadMarkFace(customEmotionData, transferRequest);
        } else {
            uploadNoMarkFace(customEmotionData, transferRequest);
        }
        return transferRequest;
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService
    public void checkFavEmotionInit() {
    }
}
