package com.tencent.mobileqq.vas.pendant.drawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pendant.PendantBusiness;
import com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantSticker;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IDiyPendantDrawable;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.LoadFinishCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class VasDiyPendantFetcher implements IDiyPendantFetcher {

    /* renamed from: k, reason: collision with root package name */
    private static VasDiyPendantFetcher f310478k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f310479l;

    /* renamed from: m, reason: collision with root package name */
    public static volatile long f310480m;

    /* renamed from: h, reason: collision with root package name */
    public LoadFinishCallback f310488h;

    /* renamed from: a, reason: collision with root package name */
    private final LRULinkedHashMap<String, DiyPendantEntity> f310481a = new LRULinkedHashMap<>(64);

    /* renamed from: b, reason: collision with root package name */
    private final LRULinkedHashMap<Integer, com.etrump.mixlayout.k> f310482b = new LRULinkedHashMap<>(16);

    /* renamed from: c, reason: collision with root package name */
    private final LRULinkedHashMap<String, Bitmap> f310483c = new LRULinkedHashMap<>(10);

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f310484d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f310485e = new CopyOnWriteArraySet<>();

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<Invalidatable> f310486f = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    AtomicBoolean f310489i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f310490j = new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher.1
        @Override // java.lang.Runnable
        public void run() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                VasDiyPendantFetcher.this.loadPendantDiyAsync((AppInterface) peekAppRuntime);
            }
        }
    };

    /* renamed from: g, reason: collision with root package name */
    ETEngine f310487g = ETEngine.getInstanceForDiyPendant();

    VasDiyPendantFetcher() {
    }

    private void j(String str) {
        String[] split = str.split("_");
        if (split.length == 3) {
            String str2 = split[2];
            String str3 = split[1];
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            if (imageCacheHelper.f(str) == null) {
                File file = new File(((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L).getSavePath(m().getStickerScid(str2)));
                if (file.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("DiyPendantFetcher", 2, "decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + file.getAbsolutePath());
                    }
                    Bitmap c16 = com.tencent.mobileqq.util.j.c(file.getAbsolutePath());
                    if (c16 != null) {
                        imageCacheHelper.i(str, c16, Business.AIO);
                        this.f310485e.remove(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AppInterface appInterface) {
        if (this.f310484d.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantFetcher", 2, "mUnCacheDiyId size is 0!");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.f310484d);
        int size = arrayList2.size();
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        for (int i3 = 0; i3 < size; i3++) {
            DiyPendantEntity diyPendantEntity = (DiyPendantEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) DiyPendantEntity.class, (String) arrayList2.get(i3));
            if (diyPendantEntity != null) {
                arrayList.add(diyPendantEntity);
            }
        }
        Iterator<? extends DiyPendantEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f310484d.remove(it.next().uinAndDiyId);
        }
        if (!arrayList.isEmpty()) {
            notifyLoadFinish(appInterface, false, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendantBusiness m() {
        return (PendantBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L);
    }

    public static VasDiyPendantFetcher n() {
        if (f310478k == null) {
            synchronized (VasDiyPendantFetcher.class) {
                if (f310478k == null) {
                    f310478k = new VasDiyPendantFetcher();
                }
            }
        }
        return f310478k;
    }

    private void o(final AppInterface appInterface) {
        if (!f310479l) {
            f310479l = true;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher.5
                @Override // java.lang.Runnable
                public void run() {
                    List<? extends Entity> query = appInterface.getEntityManagerFactory().createEntityManager().query(DiyPendantEntity.class, true, null, null, null, null, null, " 20 ");
                    if (query != null && query.size() > 0) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            DiyPendantEntity diyPendantEntity = (DiyPendantEntity) it.next();
                            if (!TextUtils.isEmpty(diyPendantEntity.uinAndDiyId)) {
                                VasDiyPendantFetcher.this.f310481a.put(diyPendantEntity.uinAndDiyId, diyPendantEntity);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("DiyPendantFetcher", 2, "initCacheFromDB, size: " + query.size());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        m().startDownload(str);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void clearCache() {
        this.f310486f.clear();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void decodeOrDownloadPaster() {
        k();
        if (!this.f310485e.isEmpty()) {
            Iterator<String> it = this.f310485e.iterator();
            String[] strArr = null;
            int i3 = 0;
            while (it.hasNext()) {
                String[] split = it.next().split("_");
                if (split.length == 3) {
                    if (strArr == null) {
                        strArr = new String[this.f310485e.size()];
                    }
                    strArr[i3] = m().getStickerScid(split[2]);
                    i3++;
                }
            }
            if (strArr != null && strArr.length > 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("DiyPendantFetcher", 2, "now download from VasUpdateConstants list: " + TextUtils.join(",", strArr));
                }
                for (String str : strArr) {
                    m().startDownload(str);
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DiyPendantFetcher", 2, "all paster has decode!");
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public List<DiyPendantSticker> fetchDiyBaseInfo(IDiyPendantDrawable iDiyPendantDrawable) {
        if (iDiyPendantDrawable != null && !TextUtils.isEmpty(iDiyPendantDrawable.getUinAndDiyId())) {
            if (this.f310481a.containsKey(iDiyPendantDrawable.getUinAndDiyId())) {
                return this.f310481a.get(iDiyPendantDrawable.getUinAndDiyId()).getStickerInfoList();
            }
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantFetcher", 2, "can not found cache in DiyPendantCache! " + iDiyPendantDrawable.getUinAndDiyId());
            }
            this.f310484d.add(iDiyPendantDrawable.getUinAndDiyId());
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantFetcher", 2, "fetchDiyBaseInfo: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
            }
            this.f310486f.add(iDiyPendantDrawable);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                postLoadPendantDiy((AppInterface) peekAppRuntime, 500);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public Bitmap fetchDiyPaster(IDiyPendantDrawable iDiyPendantDrawable, int i3) {
        if (iDiyPendantDrawable != null && !TextUtils.isEmpty(iDiyPendantDrawable.getUinAndDiyId())) {
            if (this.f310481a.containsKey(iDiyPendantDrawable.getUinAndDiyId())) {
                DiyPendantEntity diyPendantEntity = this.f310481a.get(iDiyPendantDrawable.getUinAndDiyId());
                if (diyPendantEntity.getStickerInfoList().size() > i3) {
                    String stickerKey = getStickerKey(diyPendantEntity.getStickerInfoList().get(i3));
                    Bitmap f16 = ImageCacheHelper.f98636a.f(stickerKey);
                    if (f16 != null) {
                        this.f310485e.remove(stickerKey);
                        return f16;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("DiyPendantFetcher", 2, "can not found bitmap cache in BaseApplicationImpl.sImageCache! " + stickerKey);
                    }
                    this.f310485e.add(stickerKey);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("DiyPendantFetcher", 2, "can not found cache in DiyPendantCache! " + iDiyPendantDrawable.getUinAndDiyId());
                }
                this.f310484d.add(iDiyPendantDrawable.getUinAndDiyId());
            }
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantFetcher", 2, "fetchDiyPaster: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
            }
            this.f310486f.add(iDiyPendantDrawable);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                postLoadPendantDiy((AppInterface) peekAppRuntime, 500);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public DiyPendantEntity fetchDiyPendant(AppInterface appInterface, String str, BusinessObserver businessObserver) {
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            if (this.f310481a.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f310481a.get(str));
                if (businessObserver != null) {
                    businessObserver.onUpdate(1, true, arrayList);
                }
                return this.f310481a.get(str);
            }
            DiyPendantEntity diyPendantEntity = (DiyPendantEntity) DBMethodProxy.find(appInterface.getEntityManagerFactory().createEntityManager(), DiyPendantEntity.class, " uinAndDiyId=? ", new String[]{str});
            if (diyPendantEntity != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("DiyPendantFetcher", 2, "query diy pendant from database, uinAndDiyId: " + str);
                }
                this.f310481a.put(str, diyPendantEntity);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(diyPendantEntity);
                if (businessObserver != null) {
                    businessObserver.onUpdate(1, true, arrayList2);
                }
                return diyPendantEntity;
            }
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantFetcher", 2, "start request diy id " + str);
            }
            this.f310484d.add(str);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(Long.valueOf(Long.parseLong(str.split("_")[0])));
            ((DiyPendantHandler) appInterface.getBusinessHandler(DiyPendantHandler.class.getName())).D2(arrayList3, businessObserver);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public Bitmap fetchTextBitmap(Invalidatable invalidatable, String str, final int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Bitmap bitmap;
        int i26;
        if (TextUtils.isEmpty(str) || i3 <= 0) {
            return null;
        }
        String str2 = str + "_" + i3 + "_" + i16 + "_" + f16 + "_" + i17 + "_" + i18 + "_" + i19;
        if (this.f310483c.containsKey(str2)) {
            return this.f310483c.get(str2);
        }
        synchronized (this.f310487g) {
            if (!this.f310489i.get()) {
                p();
            }
            if (this.f310489i.get() && !TextUtils.isEmpty(str)) {
                String pendantNumFontScid = m().getPendantNumFontScid(i3);
                final String savePath = m().getSavePath(pendantNumFontScid);
                if (!this.f310487g.native_isFontLoaded(i3)) {
                    this.f310486f.add(invalidatable);
                    if (m().isFileExist(pendantNumFontScid)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DiyPendantFetcher", 2, "found font res but can not load the font, font id = " + i3);
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (VasDiyPendantFetcher.this.f310487g.native_loadFont(savePath, i3, true)) {
                                    VasDiyPendantFetcher.this.r();
                                }
                            }
                        }, 5, null, false);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("DiyPendantFetcher", 2, "can not found font res! font id = " + i3);
                        }
                        q(i3, i16);
                    }
                    QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not exist!");
                    return null;
                }
                ETFont eTFont = new ETFont(i3, savePath, f16);
                eTFont.setColor(i17);
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(i18, i19, Bitmap.Config.ARGB_8888);
                    if (this.f310487g.native_isPaintableChar(str.charAt(0), eTFont)) {
                        int native_spaceMeasureText = this.f310487g.native_spaceMeasureText(str, 0, str.length(), eTFont, paint);
                        while (native_spaceMeasureText > i18) {
                            eTFont.mFontSize--;
                            native_spaceMeasureText = this.f310487g.native_spaceMeasureText(str, 0, str.length(), eTFont, paint);
                        }
                        int i27 = (i18 - native_spaceMeasureText) / 2;
                        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
                        if (this.f310487g.native_getFontMetrics(fontMetrics, eTFont)) {
                            i26 = (int) ((i19 - (fontMetrics.bottom - fontMetrics.top)) / 2.0f);
                        } else {
                            i26 = 0;
                        }
                        if (!this.f310487g.native_drawText(str, createBitmap, i27, i26, eTFont)) {
                            QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not support: " + str.charAt(0));
                            return null;
                        }
                        bitmap = createBitmap;
                    } else {
                        bitmap = createBitmap;
                    }
                    if (bitmap != null) {
                        this.f310483c.put(str2, bitmap);
                    }
                    return bitmap;
                } catch (OutOfMemoryError e16) {
                    QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont Bitmap.createBitmap OutOfMemoryError: " + e16.getMessage());
                    return null;
                }
            }
            QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail EnigeReady = " + this.f310489i.get() + " text = " + str);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public Typeface fetchTextTypeface(Invalidatable invalidatable, int i3, int i16) {
        Typeface typeface;
        if (invalidatable != null && i3 > 0) {
            com.etrump.mixlayout.k kVar = this.f310482b.get(Integer.valueOf(i3));
            if (kVar != null && (typeface = kVar.f32754d) != null) {
                return typeface;
            }
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantFetcher", 2, "can not found typeface in the cache! font id = " + i3);
            }
            this.f310486f.add(invalidatable);
            q(i3, i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    @NonNull
    public LRULinkedHashMap<String, Bitmap> getDiyFontBitmapCache() {
        return this.f310483c;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    @NonNull
    public LRULinkedHashMap<String, DiyPendantEntity> getDiyPendantCache() {
        return this.f310481a;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    @NonNull
    public CopyOnWriteArrayList<Invalidatable> getNotRefreshAIODrawables() {
        return this.f310486f;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public String getStickerKey(DiyPendantSticker diyPendantSticker) {
        return "DiyPendantFetcher_" + diyPendantSticker.type + "_" + diyPendantSticker.stickerId;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    @NonNull
    public CopyOnWriteArraySet<String> getUnCacheDiyId() {
        return this.f310484d;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    @NonNull
    public CopyOnWriteArraySet<String> getUnCachePasterId() {
        return this.f310485e;
    }

    public void i(DiyPendantEntity diyPendantEntity) {
        Iterator<DiyPendantSticker> it = diyPendantEntity.getStickerInfoList().iterator();
        while (it.hasNext()) {
            String stickerKey = getStickerKey(it.next());
            if (this.f310485e.contains(stickerKey)) {
                j(stickerKey);
            }
        }
    }

    public void k() {
        if (this.f310485e.size() > 0) {
            Iterator<String> it = this.f310485e.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            r();
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void loadPendantDiyAsync(final AppInterface appInterface) {
        if (appInterface == null) {
            return;
        }
        o(appInterface);
        if (!this.f310484d.isEmpty() || !this.f310485e.isEmpty() || !this.f310486f.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!VasDiyPendantFetcher.this.f310484d.isEmpty()) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DiyPendantFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", VasDiyPendantFetcher.this.f310484d));
                        }
                        VasDiyPendantFetcher.this.l(appInterface);
                        if (!VasDiyPendantFetcher.this.f310484d.isEmpty()) {
                            DiyPendantHandler diyPendantHandler = (DiyPendantHandler) appInterface.getBusinessHandler(DiyPendantHandler.class.getName());
                            ArrayList arrayList = new ArrayList();
                            try {
                                Iterator it = VasDiyPendantFetcher.this.f310484d.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(Long.valueOf(Long.parseLong(((String) it.next()).split("_")[0])));
                                }
                            } catch (Exception e16) {
                                QLog.w("DiyPendantFetcher", 1, "exception:" + e16.getMessage());
                            }
                            diyPendantHandler.D2(arrayList, null);
                            VasDiyPendantFetcher.this.f310484d.clear();
                        }
                    }
                    if (!VasDiyPendantFetcher.this.f310485e.isEmpty()) {
                        VasDiyPendantFetcher.this.decodeOrDownloadPaster();
                    }
                    Iterator it5 = VasDiyPendantFetcher.this.f310486f.iterator();
                    while (it5.hasNext()) {
                        Invalidatable invalidatable = (Invalidatable) it5.next();
                        if (invalidatable == null || invalidatable.getCallback() == null) {
                            VasDiyPendantFetcher.this.f310486f.remove(invalidatable);
                        }
                    }
                    VasDiyPendantFetcher.f310480m = 0L;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void notifyFontDownloadComplete(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("DiyPendantFetcher", 2, "notifyFontDownloadComplete, scid =" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace(VasUpdateConstants.SCID_PENDANT_FONT_PREFIX, "");
            com.etrump.mixlayout.k kVar = this.f310482b.get(Integer.valueOf(Integer.parseInt(replace)));
            if (kVar != null) {
                if (kVar.f32753c == 1) {
                    if (!this.f310489i.get()) {
                        p();
                    }
                    if (this.f310489i.get() && this.f310487g.native_loadFont(kVar.f32752b, Integer.parseInt(replace), true)) {
                        r();
                        return;
                    }
                    return;
                }
                if (new File(kVar.f32752b).exists()) {
                    kVar.f32754d = Typeface.createFromFile(kVar.f32752b);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void notifyLoadFinish(AppInterface appInterface, boolean z16, List<? extends DiyPendantEntity> list) {
        if (list != null && !list.isEmpty()) {
            for (DiyPendantEntity diyPendantEntity : list) {
                this.f310484d.remove(diyPendantEntity.uinAndDiyId);
                this.f310481a.put(diyPendantEntity.uinAndDiyId, diyPendantEntity);
                i(diyPendantEntity);
            }
            LoadFinishCallback loadFinishCallback = this.f310488h;
            if (loadFinishCallback != null) {
                loadFinishCallback.notifyLoadFinish(appInterface, z16, list);
            }
            r();
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void notifyPasterDownloadComplete(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("DiyPendantFetcher", 2, "notifyPasterDownloadComplete " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.f310485e.contains(str)) {
                j(str);
            }
            r();
        }
    }

    void p() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f310487g.initEngine(16, 1048576)) {
                this.f310489i.set(true);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("DiyPendantFetcher", 2, "DIY Pendant init Font Engine time = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    return;
                }
                return;
            }
            if (this.f310487g.isEngineInited.compareAndSet(false, true)) {
                com.etrump.mixlayout.o.c();
            }
            this.f310489i.set(false);
            QLog.d("DiyPendantFetcher", 1, "vip font not downloaded, start early download.");
        } catch (Throwable th5) {
            this.f310489i.set(false);
            QLog.e("DiyPendantFetcher", 1, "initETEngine Exception:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void postLoadPendantDiy(AppInterface appInterface, int i3) {
        if (appInterface == null) {
            return;
        }
        if (!this.f310484d.isEmpty() || !this.f310485e.isEmpty()) {
            if (i3 <= 0) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f310490j);
                loadPendantDiyAsync(appInterface);
            } else if (System.currentTimeMillis() > f310480m) {
                if (QLog.isColorLevel()) {
                    QLog.i("DiyPendantFetcher", 2, "postLoadPendantDiy delay:  " + i3);
                }
                long j3 = i3;
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.f310490j, j3);
                f310480m = System.currentTimeMillis() + j3;
            }
        }
    }

    void q(final int i3, int i16) {
        final String savePath = m().getSavePath(m().getPendantNumFontScid(i3));
        if (!this.f310482b.containsKey(Integer.valueOf(i3))) {
            com.etrump.mixlayout.k kVar = new com.etrump.mixlayout.k(i3, savePath);
            kVar.f32753c = i16;
            this.f310482b.put(Integer.valueOf(i3), kVar);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (VasDiyPendantFetcher.this.m().isFileExist(VasDiyPendantFetcher.this.m().getPendantNumFontScid(i3))) {
                    if (i3 != 1) {
                        try {
                            ((com.etrump.mixlayout.k) VasDiyPendantFetcher.this.f310482b.get(Integer.valueOf(i3))).f32754d = Typeface.createFromFile(savePath);
                        } catch (RuntimeException e16) {
                            QLog.e("DiyPendantFetcher", 1, "Typeface createFromFile Exception path:" + savePath + "  Message:" + e16.getMessage());
                        }
                        VasDiyPendantFetcher.this.r();
                        return;
                    }
                    return;
                }
                VasDiyPendantFetcher vasDiyPendantFetcher = VasDiyPendantFetcher.this;
                vasDiyPendantFetcher.s(vasDiyPendantFetcher.m().getPendantNumFontScid(i3));
            }
        }, 5, null, false);
    }

    @TargetApi(11)
    public void r() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher.6
            @Override // java.lang.Runnable
            public void run() {
                HashSet hashSet = new HashSet();
                Iterator it = VasDiyPendantFetcher.this.f310486f.iterator();
                while (it.hasNext()) {
                    Invalidatable invalidatable = (Invalidatable) it.next();
                    if (invalidatable != null && invalidatable.getCallback() != null) {
                        if (!hashSet.contains(invalidatable)) {
                            hashSet.add(invalidatable);
                            invalidatable.invalidateSelf();
                            VasDiyPendantFetcher.this.f310486f.remove(invalidatable);
                        }
                    } else {
                        VasDiyPendantFetcher.this.f310486f.remove(invalidatable);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("DiyPendantFetcher", 2, "wait for refresh size: " + VasDiyPendantFetcher.this.f310486f.size());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher
    public void setLoadFinishCallback(LoadFinishCallback loadFinishCallback) {
        if (this.f310488h == loadFinishCallback) {
            return;
        }
        this.f310488h = loadFinishCallback;
    }
}
