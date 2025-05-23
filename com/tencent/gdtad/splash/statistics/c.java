package com.tencent.gdtad.splash.statistics;

import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.splash.GdtSplashPreloader;
import com.tencent.gdtad.splash.p;
import com.tencent.gdtad.splash.u;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f109428a;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f109431d;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f109429b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f109430c = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f109432e = false;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f109433f = false;

    /* renamed from: g, reason: collision with root package name */
    private List<b> f109434g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private volatile long f109435h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: i, reason: collision with root package name */
    private volatile long f109436i = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: j, reason: collision with root package name */
    private volatile long f109437j = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: k, reason: collision with root package name */
    private volatile long f109438k = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: l, reason: collision with root package name */
    private volatile long f109439l = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: m, reason: collision with root package name */
    private volatile long f109440m = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f109441n = false;

    private long b() {
        if (this.f109440m == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109440m;
    }

    private long c() {
        if (this.f109437j == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109437j;
    }

    private long d() {
        if (this.f109436i == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109436i;
    }

    private long e() {
        if (this.f109435h == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109435h;
    }

    private long f() {
        if (this.f109438k == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109438k;
    }

    private void w(b bVar) {
        if (bVar == null) {
            QLog.i("GdtSplashReporterForPrepareAndShow", 1, "[processEvent] error, event is null");
            return;
        }
        String str = "[processEvent] eventId:" + bVar.d() + " shouldReportImmediately:" + this.f109433f;
        if (QLog.isColorLevel()) {
            QLog.i("GdtSplashReporterForPrepareAndShow", 2, str);
        }
        if (this.f109433f) {
            x();
            GdtSplashReporterUtil.e(bVar);
        } else {
            this.f109434g.add(bVar);
        }
    }

    private void x() {
        if (TextUtils.isEmpty(((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashEmptyReportExp())) {
            QLog.i("GdtSplashReporterForPrepareAndShow", 1, "[reportEmptyOrderIfNecessaryAndPreFetchAd] mShouldReportForEmptyOrder:" + this.f109429b + " mEmptyOrderReported:" + this.f109430c + " mUrlForEmptyOrder:" + this.f109431d + " mHasValidOrder:" + this.f109432e);
            if (this.f109429b && !this.f109430c) {
                GdtSplashReporterUtil.c(this.f109431d, this.f109432e, false);
                this.f109430c = true;
                return;
            }
            return;
        }
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateSplashEmptyOrderParams(false, true, 1003);
    }

    private void y() {
        QLog.i("GdtSplashReporterForPrepareAndShow", 1, "[reportForAnalysis]");
        GdtSplashReporterUtil.f(this.f109434g);
        this.f109434g.clear();
    }

    private void z() {
        int i3;
        if (!com.tencent.gdtad.splash.mcconfig.a.e()) {
            QLog.e("GdtSplashReporterForPrepareAndShow", 1, "[reportImmediately] error, not enabled");
            return;
        }
        p a16 = u.a();
        if (a16 != null) {
            i3 = a16.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 0) {
            QLog.e("GdtSplashReporterForPrepareAndShow", 1, "[reportImmediately] error, canRun errorCode:" + i3);
            return;
        }
        QLog.i("GdtSplashReporterForPrepareAndShow", 1, "[reportImmediately]");
        this.f109433f = true;
        x();
        y();
    }

    public void A(String str) {
        this.f109431d = str;
    }

    public void a() {
        QLog.i("GdtSplashReporterForPrepareAndShow", 1, "[doAfterLoginAndMessageLoaded]");
        z();
    }

    public String g() {
        return this.f109428a;
    }

    public void h() {
        int i3;
        b bVar = new b(2000013, f());
        bVar.h(this.f109428a);
        if (this.f109441n) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        bVar.k(i3);
        w(bVar);
        if (this.f109441n) {
            w(new b(2000014, b()));
        }
    }

    public void i(long j3, int i3, p pVar) {
        if (this.f109440m != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return;
        }
        this.f109440m = j3;
        this.f109441n = true;
        b bVar = new b(2000012, f());
        bVar.h(this.f109428a);
        bVar.k(i3);
        bVar.i(pVar);
        w(bVar);
    }

    public void j(p pVar) {
        b bVar = new b(2000006, c());
        bVar.h(this.f109428a);
        bVar.i(pVar);
        w(bVar);
    }

    public void k(long j3) {
        this.f109437j = j3;
        b bVar = new b(2000004);
        bVar.h(this.f109428a);
        w(bVar);
    }

    public void l() {
        b bVar = new b(2000005, c());
        bVar.h(this.f109428a);
        w(bVar);
    }

    public void m(boolean z16, long j3) {
        b bVar;
        if (z16) {
            bVar = new b(2000018, j3);
        } else {
            bVar = new b(2000019, j3);
        }
        bVar.k(z16 ? 1 : 0);
        w(bVar);
    }

    public void n(p pVar, boolean z16, String str) {
        int i3;
        this.f109432e = z16;
        this.f109428a = str;
        long i16 = GdtSplashPreloader.i();
        long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (i16 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            j3 = System.currentTimeMillis() - i16;
        }
        if (pVar != null) {
            i3 = pVar.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        int i17 = 1;
        if (i3 != 2000008 && i3 != 2000009) {
            if (i3 == 2000012) {
                this.f109429b = true;
            } else if (i3 != 2000013 && i3 != 2000014) {
                QLog.e("GdtSplashReporterForPrepareAndShow", 1, "[onPrepareFailed] unknown error, errorCode:" + i3);
            } else {
                this.f109429b = true;
            }
        }
        b bVar = new b(2000003, e());
        if (TextUtils.isEmpty(this.f109431d)) {
            i17 = 2;
        }
        bVar.k(i17);
        bVar.h(str);
        bVar.j(j3);
        bVar.i(pVar);
        w(bVar);
    }

    public void o(long j3) {
        this.f109435h = j3;
        w(new b(2000001));
    }

    public void p(long j3, String str) {
        this.f109436i = j3;
        this.f109432e = true;
        this.f109428a = str;
        long i3 = GdtSplashPreloader.i();
        long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (i3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            j16 = System.currentTimeMillis() - i3;
        }
        b bVar = new b(2000002, e());
        bVar.h(str);
        bVar.j(j16);
        w(bVar);
    }

    public void q(p pVar) {
        b bVar;
        w(new b(2000015, e()));
        boolean z16 = false;
        if (pVar != null && pVar.a() == 0) {
            z16 = true;
        }
        if (z16) {
            bVar = new b(2000016);
        } else {
            bVar = new b(2000017);
        }
        bVar.i(pVar);
        w(bVar);
    }

    public void r(long j3, p pVar) {
        boolean z16;
        int i3 = 1;
        this.f109429b = true;
        this.f109439l = j3;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            z16 = guardManager.isApplicationForeground();
        } else {
            z16 = false;
        }
        b bVar = new b(2000011, f());
        if (!z16) {
            i3 = 2;
        }
        bVar.k(i3);
        bVar.h(this.f109428a);
        bVar.i(pVar);
        w(bVar);
    }

    public void s(long j3) {
        z();
        this.f109439l = j3;
        b bVar = new b(2000010, f());
        bVar.h(this.f109428a);
        w(bVar);
    }

    public void t(long j3) {
        this.f109438k = j3;
        b bVar = new b(2000007, d());
        bVar.h(this.f109428a);
        w(bVar);
    }

    public void u(p pVar) {
        int i3;
        if (pVar != null) {
            i3 = pVar.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 2000009) {
            if (i3 != 2000001 && i3 != 2000015) {
                QLog.e("GdtSplashReporterForPrepareAndShow", 1, "[onPrepareFailed] unknown error, errorCode:" + i3);
            } else {
                this.f109429b = true;
            }
        }
        b bVar = new b(2000009, f());
        bVar.h(this.f109428a);
        bVar.i(pVar);
        w(bVar);
    }

    public void v() {
        b bVar = new b(2000008, f());
        bVar.h(this.f109428a);
        w(bVar);
    }
}
