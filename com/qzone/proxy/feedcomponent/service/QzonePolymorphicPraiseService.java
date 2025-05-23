package com.qzone.proxy.feedcomponent.service;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.util.ArrayList;
import java.util.Iterator;
import n7.a;

/* loaded from: classes39.dex */
public class QzonePolymorphicPraiseService {

    /* renamed from: f, reason: collision with root package name */
    private static final String f50502f = "QzonePolymorphicPraiseService";

    /* renamed from: g, reason: collision with root package name */
    private static volatile QzonePolymorphicPraiseService f50503g;

    /* renamed from: h, reason: collision with root package name */
    private static final Object f50504h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private PolymorphicPraiseData f50505a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f50506b;

    /* renamed from: c, reason: collision with root package name */
    final b f50507c = new b("TABLE_POLY_PRAISE", PolymorphicPraiseData.class);

    /* renamed from: d, reason: collision with root package name */
    private ZipLoadedListener f50508d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f50509e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ZipLoadedListener {
        a() {
        }

        @Override // cooperation.qzone.zipanimate.ZipLoadedListener
        public void onZipLoaded(boolean z16) {
            QzonePolymorphicPraiseService.this.f50509e = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f50512a;

        /* renamed from: b, reason: collision with root package name */
        m f50513b;

        /* renamed from: c, reason: collision with root package name */
        String f50514c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f50515d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f50516e = new a();

        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                com.qzone.proxy.feedcomponent.b.a(QzonePolymorphicPraiseService.f50502f, "[polyPraise].DbCacheManager onClosed QzonePolymorphicPraiseService table:" + b.this.f50514c);
                b bVar = b.this;
                bVar.f50512a = 0L;
                bVar.f50513b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f50514c = str;
            this.f50515d = cls;
        }
    }

    QzonePolymorphicPraiseService() {
    }

    private void g() {
        synchronized (this.f50507c) {
            f(this.f50507c);
        }
    }

    public static QzonePolymorphicPraiseService getInstance() {
        if (f50503g == null) {
            synchronized (f50504h) {
                if (f50503g == null) {
                    f50503g = new QzonePolymorphicPraiseService();
                }
            }
        }
        return f50503g;
    }

    public m getPolyPraiseCacheManager() {
        g();
        return this.f50507c.f50513b;
    }

    public PolymorphicPraiseData getPolyPraiseData() {
        com.qzone.proxy.feedcomponent.b.a(f50502f, "[polyPraise].getPolyPraiseData, aniResLoaded = " + this.f50509e + ", mPolyPraiseData = " + this.f50505a);
        PolymorphicPraiseData polymorphicPraiseData = this.f50505a;
        if (polymorphicPraiseData != null && polymorphicPraiseData.itemId > 0) {
            if (!this.f50509e) {
                preLoadRes();
            }
            if (this.f50509e) {
                return this.f50505a;
            }
            return null;
        }
        refreshLocalCache(i.H().j0());
        return null;
    }

    public void preLoadRes() {
        PolymorphicPraiseData polymorphicPraiseData = this.f50505a;
        if (polymorphicPraiseData != null && polymorphicPraiseData.itemId > 0) {
            this.f50509e = false;
            if (this.f50508d == null) {
                this.f50508d = new a();
            }
            ArrayList<PolymorphicPraiseEmotionData> arrayList = this.f50505a.emotionDatas;
            if (arrayList != null) {
                Iterator<PolymorphicPraiseEmotionData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PolymorphicPraiseEmotionData next = it.next();
                    if (!TextUtils.isEmpty(next.strPraiseZip)) {
                        ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
                        zipDrawableLoader.setZipLoadedListener(this.f50508d);
                        zipDrawableLoader.setDrawableData(next.strPraiseZip, -1, false);
                    }
                    if (!VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                        ImageLoader.getInstance().loadImage(next.strPraiseImageUrl, next.strPraisePic, (ImageLoader.Options) null);
                        ImageLoader.getInstance().loadImage(next.strPraiseListImageUrl, next.strPraiseListPic, (ImageLoader.Options) null);
                    }
                }
            }
            PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = this.f50505a.polyPraiseEmotionData;
            if (polymorphicPraiseEmotionData == null || TextUtils.isEmpty(polymorphicPraiseEmotionData.strPraiseZip)) {
                return;
            }
            PolymorphicPraiseEmotionData polymorphicPraiseEmotionData2 = this.f50505a.polyPraiseEmotionData;
            ZipDrawableLoaderInterface zipDrawableLoader2 = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
            zipDrawableLoader2.setZipLoadedListener(this.f50508d);
            zipDrawableLoader2.setDrawableData(polymorphicPraiseEmotionData2.strPraiseZip, -1, false);
            if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                return;
            }
            ImageLoader.getInstance().loadImage(polymorphicPraiseEmotionData2.strPraiseImageUrl, polymorphicPraiseEmotionData2.strPraisePic, (ImageLoader.Options) null);
            ImageLoader.getInstance().loadImage(polymorphicPraiseEmotionData2.strPraiseListImageUrl, polymorphicPraiseEmotionData2.strPraiseListPic, (ImageLoader.Options) null);
            return;
        }
        com.qzone.proxy.feedcomponent.b.a(f50502f, "[polyPraise].preLoadRes, preLoadRes is null");
    }

    public void refreshLocalCache(final long j3) {
        com.qzone.proxy.feedcomponent.b.a(f50502f, "[polyPraise].refreshLocalCache cacheLoaded = " + this.f50506b + ", mPolyPraiseData = " + this.f50505a);
        if (this.f50505a == null || !this.f50506b) {
            this.f50506b = false;
            FeedGlobalEnv.g().getBackgroundHandler().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.service.QzonePolymorphicPraiseService.2
                @Override // java.lang.Runnable
                public void run() {
                    m polyPraiseCacheManager = QzonePolymorphicPraiseService.this.getPolyPraiseCacheManager();
                    if (polyPraiseCacheManager == null) {
                        return;
                    }
                    polyPraiseCacheManager.l("uin=?");
                    polyPraiseCacheManager.i(new String[]{"" + j3});
                    PolymorphicPraiseData polymorphicPraiseData = (PolymorphicPraiseData) polyPraiseCacheManager.k("uin=?", new String[]{"" + j3});
                    if (polymorphicPraiseData != null && !QzonePolymorphicPraiseService.this.f50506b) {
                        QzonePolymorphicPraiseService.this.f50505a = polymorphicPraiseData;
                        QzonePolymorphicPraiseService.this.preLoadRes();
                    }
                    QzonePolymorphicPraiseService.this.f50506b = true;
                }
            });
        }
    }

    public void updatePolyPraiseCache(PolymorphicPraiseData polymorphicPraiseData) {
        String str = f50502f;
        com.qzone.proxy.feedcomponent.b.a(str, "[polyPraise].updatePolyPraiseCache, data = " + polymorphicPraiseData);
        if (polymorphicPraiseData != null) {
            PolymorphicPraiseData polymorphicPraiseData2 = this.f50505a;
            if (polymorphicPraiseData2 == null || !polymorphicPraiseData2.equals(polymorphicPraiseData)) {
                this.f50505a = polymorphicPraiseData;
                this.f50506b = true;
                preLoadRes();
                long j06 = i.H().j0();
                m polyPraiseCacheManager = getPolyPraiseCacheManager();
                if (polyPraiseCacheManager != null) {
                    if (polymorphicPraiseData.itemId <= 0) {
                        polyPraiseCacheManager.o("uin=" + j06);
                        com.qzone.proxy.feedcomponent.b.a(str, "[polyPraise].updatePolyPraiseCache deleteData");
                        return;
                    }
                    polyPraiseCacheManager.appendData(polymorphicPraiseData);
                    com.qzone.proxy.feedcomponent.b.a(str, "[polyPraise].updatePolyPraiseCache saveData");
                }
            }
        }
    }

    private void f(b bVar) {
        m mVar;
        if (bVar == null) {
            return;
        }
        long j06 = i.H().j0();
        if (j06 != bVar.f50512a || (mVar = bVar.f50513b) == null || mVar.isClosed()) {
            bVar.f50512a = j06;
            m y16 = i.H().y1(bVar.f50515d, j06, bVar.f50514c);
            bVar.f50513b = y16;
            y16.d(bVar.f50516e);
        }
    }

    public void preLoadRes(PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
        if (polymorphicPraiseEmotionData == null || polymorphicPraiseEmotionData.iItemId <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(polymorphicPraiseEmotionData.strPraiseZip)) {
            ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
            zipDrawableLoader.setZipLoadedListener(this.f50508d);
            zipDrawableLoader.setDrawableData(polymorphicPraiseEmotionData.strPraiseZip, -1, false);
        }
        if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
            return;
        }
        ImageLoader.getInstance().loadImage(polymorphicPraiseEmotionData.strPraiseImageUrl, polymorphicPraiseEmotionData.strPraisePic, (ImageLoader.Options) null);
        ImageLoader.getInstance().loadImage(polymorphicPraiseEmotionData.strPraiseListImageUrl, polymorphicPraiseEmotionData.strPraiseListPic, (ImageLoader.Options) null);
    }
}
