package com.qzone.proxy.feedcomponent.service;

import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import n7.a;

/* loaded from: classes39.dex */
public class QzoneExendFeedCustomPraiseService {

    /* renamed from: f, reason: collision with root package name */
    private static final String f50487f = "QzoneExendFeedCustomPraiseService";

    /* renamed from: g, reason: collision with root package name */
    private static QzoneExendFeedCustomPraiseService f50488g;

    /* renamed from: a, reason: collision with root package name */
    private CustomPraiseData f50489a;

    /* renamed from: b, reason: collision with root package name */
    private ZipLoadedListener f50490b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f50491c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50492d;

    /* renamed from: e, reason: collision with root package name */
    private final b f50493e = new b("TABLE_EXTEND_FEED_CUSTOM_PRAISE", CustomPraiseData.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ZipLoadedListener {
        a() {
        }

        @Override // cooperation.qzone.zipanimate.ZipLoadedListener
        public void onZipLoaded(boolean z16) {
            QzoneExendFeedCustomPraiseService.this.f50492d = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f50496a;

        /* renamed from: b, reason: collision with root package name */
        m f50497b;

        /* renamed from: c, reason: collision with root package name */
        String f50498c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f50499d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f50500e = new a();

        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                com.qzone.proxy.feedcomponent.b.a(QzoneExendFeedCustomPraiseService.f50487f, "DbCacheManager onClosed QzoneExendFeedCustomPraiseService table:" + b.this.f50498c);
                b bVar = b.this;
                bVar.f50496a = 0L;
                bVar.f50497b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f50498c = str;
            this.f50499d = cls;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m h(long j3) {
        j(j3);
        return this.f50493e.f50497b;
    }

    public static QzoneExendFeedCustomPraiseService i() {
        if (f50488g == null) {
            synchronized (QzoneExendFeedCustomPraiseService.class) {
                if (f50488g == null) {
                    f50488g = new QzoneExendFeedCustomPraiseService();
                }
            }
        }
        return f50488g;
    }

    private void j(long j3) {
        b bVar = this.f50493e;
        if (bVar.f50496a != j3) {
            synchronized (bVar) {
                b bVar2 = this.f50493e;
                if (bVar2.f50496a != j3) {
                    g(bVar2);
                }
            }
        }
    }

    public void k() {
        CustomPraiseData customPraiseData = this.f50489a;
        if (customPraiseData == null || customPraiseData.itemId <= 0) {
            return;
        }
        this.f50492d = false;
        ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
        if (this.f50490b == null) {
            this.f50490b = new a();
        }
        zipDrawableLoader.setZipLoadedListener(this.f50490b);
        zipDrawableLoader.setDrawableData(customPraiseData.praiseZipUrl, -1, false);
        ImageLoader.getInstance().loadImage(customPraiseData.praiseIconImageUrl, customPraiseData.praiseIconUrl, (ImageLoader.Options) null);
        ImageLoader.getInstance().loadImage(customPraiseData.strPraiseListImageUrl, customPraiseData.strPraiseListPic, (ImageLoader.Options) null);
    }

    public void l(final long j3) {
        CustomPraiseData customPraiseData = this.f50489a;
        if (customPraiseData != null && j3 == customPraiseData.uin && this.f50491c) {
            return;
        }
        this.f50491c = false;
        FeedGlobalEnv.g().getBackgroundHandler().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.service.QzoneExendFeedCustomPraiseService.2
            @Override // java.lang.Runnable
            public void run() {
                m h16 = QzoneExendFeedCustomPraiseService.this.h(j3);
                if (h16 == null) {
                    return;
                }
                h16.l("uin=?");
                h16.i(new String[]{"" + j3});
                CustomPraiseData customPraiseData2 = (CustomPraiseData) h16.k("uin=?", new String[]{"" + j3});
                if (customPraiseData2 != null && j3 == customPraiseData2.uin && !QzoneExendFeedCustomPraiseService.this.f50491c) {
                    QzoneExendFeedCustomPraiseService.this.f50489a = customPraiseData2;
                    QzoneExendFeedCustomPraiseService.this.k();
                }
                QzoneExendFeedCustomPraiseService.this.f50491c = true;
            }
        });
    }

    private void g(b bVar) {
        m mVar;
        if (bVar == null) {
            return;
        }
        long j06 = i.H().j0();
        if (j06 != bVar.f50496a || (mVar = bVar.f50497b) == null || mVar.isClosed()) {
            bVar.f50496a = j06;
            m y16 = i.H().y1(bVar.f50499d, j06, bVar.f50498c);
            bVar.f50497b = y16;
            y16.d(bVar.f50500e);
        }
    }

    public void m(CustomPraiseData customPraiseData) {
        if (customPraiseData == null) {
            return;
        }
        if (customPraiseData.uin != i.H().j0()) {
            com.qzone.proxy.feedcomponent.b.a(f50487f, "uin not the login uin, no update.");
            return;
        }
        CustomPraiseData customPraiseData2 = this.f50489a;
        if (customPraiseData2 == null || !customPraiseData2.equals(customPraiseData)) {
            this.f50489a = customPraiseData;
            this.f50491c = true;
            k();
            long j06 = i.H().j0();
            m h16 = h(j06);
            if (h16 != null) {
                if (customPraiseData.itemId <= 0) {
                    h16.o("uin=" + j06);
                    com.qzone.proxy.feedcomponent.b.a(f50487f, "updateCustomPraiseCache deleteData");
                    return;
                }
                h16.appendData(customPraiseData);
                com.qzone.proxy.feedcomponent.b.a(f50487f, "updateCustomPraiseCache saveData");
            }
        }
    }
}
