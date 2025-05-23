package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureRunnable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure.QAdStandardExposureReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.tvideo.protocol.pb.AdEmptyInfo;
import com.tencent.tvideo.protocol.pb.AdExposureType;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdReportType;
import ew2.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import pw2.g;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ExposureChecker implements ExposureRunnable.a {

    /* renamed from: b, reason: collision with root package name */
    protected ExposureRunnable f303893b;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> f303896e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f303897f;

    /* renamed from: h, reason: collision with root package name */
    private AdExposureType f303899h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<QAdExposure.b> f303900i;

    /* renamed from: j, reason: collision with root package name */
    private int f303901j;

    /* renamed from: a, reason: collision with root package name */
    protected long f303892a = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f303894c = false;

    /* renamed from: d, reason: collision with root package name */
    protected int f303895d = 0;

    /* renamed from: g, reason: collision with root package name */
    private Rect f303898g = new Rect();

    /* renamed from: k, reason: collision with root package name */
    private boolean f303902k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f303903l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f303904m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f303905n = false;

    /* renamed from: o, reason: collision with root package name */
    private ExposureRunnable.a f303906o = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f303907p = false;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f303908q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f303909r = false;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    protected @interface CheckState {
        public static final int STATE_CHECK = 1;
        public static final int STATE_FINISH = 2;
        public static final int STATE_NONE = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ExposureRunnable.a {
        a() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureRunnable.a
        public void a(boolean z16, boolean z17, boolean z18, int i3, Rect rect, long j3, boolean z19) {
            n.a("ExposureChecker", "old version onCheckResult, view: " + i3 + " bShown:" + z16 + " bInScreen:" + z17 + " bExposure:" + z18 + " state:" + ExposureChecker.this.f303895d + " rcView:" + rect + " old RcView:" + ExposureChecker.this.f303898g + " inteval:" + j3 + " emptyView:" + z19 + " mVisibleSizeFlag:" + ExposureChecker.this.f303903l + " switch:" + ExposureChecker.this.f303905n);
            ExposureChecker exposureChecker = ExposureChecker.this;
            if (exposureChecker.f303895d != 2) {
                exposureChecker.f303904m = true;
                if (z18) {
                    ExposureChecker.this.f303903l = true;
                } else if (ExposureChecker.this.f303903l && z16) {
                    z18 = true;
                }
                if (z17) {
                    ExposureChecker.this.o();
                }
                if (!z18) {
                    ExposureChecker.this.f303895d = 0;
                    return;
                }
                n.a("ExposureChecker", "onCheckResult, check report, exposure:" + z18 + " state:" + ExposureChecker.this.f303895d + " validtime:" + ExposureChecker.this.f303892a);
                if (ExposureChecker.this.r(j3)) {
                    ExposureChecker.this.f303895d = 2;
                    n.a("ExposureChecker", "onCheckResult, order:" + ExposureChecker.this.F() + " report finish.");
                    return;
                }
                ExposureChecker.this.f303895d = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExposureChecker(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar, boolean z16, AdExposureType adExposureType, int i3, QAdExposure.b bVar) {
        this.f303899h = AdExposureType.AD_EXPOSURE_TYPE_UNKNOWN;
        this.f303901j = 0;
        this.f303896e = new WeakReference<>(aVar);
        this.f303897f = z16;
        this.f303899h = adExposureType;
        this.f303900i = new WeakReference<>(bVar);
        this.f303901j = i3;
        p(D());
        this.f303893b = W(0.5f, K(), this.f303907p, this);
        n.e("ExposureChecker", "ExposureChecker, reportType: " + this.f303901j + " report in scroll:" + this.f303902k + " switchOldVersion:" + this.f303905n + " newAlgorithm:" + this.f303907p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        Object D = D();
        if (!(D instanceof AdOrderItem)) {
            n.a("ExposureChecker", "doValidReport, order type error:" + D);
            return false;
        }
        AdOrderItem adOrderItem = (AdOrderItem) D;
        n.a("ExposureChecker", "doValidReport, order:" + adOrderItem.order_id);
        z(adOrderItem, 0, this.f303897f, this.f303899h);
        return true;
    }

    private void B() {
        QAdExposure.b bVar;
        Object D = D();
        WeakReference<QAdExposure.b> weakReference = this.f303900i;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        bVar.b(D);
    }

    private void C() {
        QAdExposure.b bVar;
        Object D = D();
        WeakReference<QAdExposure.b> weakReference = this.f303900i;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        bVar.a(D);
    }

    private Object D() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.e();
    }

    private static String E() {
        return nv2.a.a("");
    }

    private String G() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    private String H() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.i();
    }

    private boolean M(boolean z16) {
        if (this.f303908q && !z16) {
            return false;
        }
        return true;
    }

    private void Y(AdOrderItem adOrderItem, int i3) {
        kw2.b.b(adOrderItem, AdReportType.AD_REPORT_TYPE_EXPOSURE);
    }

    private void Z(View view, boolean z16, boolean z17) {
        ExposureRunnable exposureRunnable = this.f303893b;
        if (exposureRunnable != null) {
            exposureRunnable.o(view);
        }
        if (!P(z16)) {
            return;
        }
        Q();
        if (this.f303895d == 0) {
            if (s(0L)) {
                this.f303895d = 1;
                return;
            }
            n.a("ExposureChecker", "check, docheck error:" + this.f303895d);
            return;
        }
        n.a("ExposureChecker", "check, is running, state:" + this.f303895d);
    }

    private void a0(@NonNull View view) {
        if (N() && this.f303905n) {
            n.a("ExposureChecker", "runOldVersionValidExposureChecker");
            Rect rect = new Rect();
            if (ExposureRunnable.h(view, 0.5f)) {
                this.f303903l = true;
                n.a("ExposureChecker", "check, run old version logic, set flag");
            }
            m();
            if (!M(ExposureRunnable.k(view, null, false))) {
                return;
            }
            if (this.f303903l && this.f303904m) {
                this.f303906o.a(true, true, true, view.hashCode(), rect, 1000L, K());
                return;
            }
            ExposureRunnable V = V(0.5f, K(), this.f303907p, this.f303906o);
            V.o(view);
            V.n(1000L);
            g.b(V, 1000L);
        }
    }

    private void f0(View view) {
        ExposureRunnable exposureRunnable;
        if (view != null && (exposureRunnable = this.f303893b) != null) {
            exposureRunnable.o(view);
        }
    }

    private void h0(Class cls) {
        ExposureRunnable exposureRunnable;
        if (cls != null && (exposureRunnable = this.f303893b) != null) {
            exposureRunnable.p(cls);
        }
    }

    private boolean k(boolean z16) {
        if (!z16 || !N() || !this.f303905n) {
            return false;
        }
        return !K();
    }

    private void m() {
        if (this.f303906o != null) {
            return;
        }
        this.f303906o = new a();
    }

    private void p(Object obj) {
        if ((obj instanceof AdOrderItem) && N() && !K()) {
            this.f303902k = false;
            this.f303905n = true;
            this.f303907p = false;
            this.f303908q = true;
            n.e("ExposureChecker", "checkSwitch, report in scroll:" + this.f303902k + " switchOldVersion:" + this.f303905n + " newAlgorithm:" + this.f303907p);
        }
    }

    public static void t(AdEmptyInfo adEmptyInfo) {
        f F = f.F(adEmptyInfo, 1);
        n.e("ExposureChecker", "start doEmptyReport.");
        if (F != null) {
            n.e("ExposureChecker", "doEmptyReport, url=" + F.q());
            F.t(null);
        }
    }

    private static void u(AdOrderItem adOrderItem, int i3) {
        f G = f.G(adOrderItem, E(), i3);
        if (G != null) {
            n.a("ExposureChecker", "[Empty] reportUrl = " + G.q());
            G.t(null);
            return;
        }
        n.a("ExposureChecker", "[Empty] emptyReportInfo is null");
    }

    private static void v(AdOrderItem adOrderItem, int i3, int i16, String str, int i17, int i18) {
        n.a("ExposureChecker", "[exposure] doExposureReport:" + i3 + " " + i16 + " " + i18);
        QAdStandardExposureReportInfo G = QAdStandardExposureReportInfo.G(adOrderItem, i3, i16, str, (long) i17, i18);
        if (G != null) {
            n.a("ExposureChecker", "[exposure] reportUrl = " + G.q());
            G.t(null);
        }
    }

    private static void w(AdOrderItem adOrderItem, boolean z16) {
        v(adOrderItem, 1000, 0, E(), 0, 1);
        if (z16) {
            u(adOrderItem, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        Object D = D();
        if (D == null) {
            n.b("ExposureChecker", "doOriginReport order is null");
            return false;
        }
        if (D instanceof AdOrderItem) {
            AdOrderItem adOrderItem = (AdOrderItem) D;
            n.a("ExposureChecker", "doOriginReport, order:" + adOrderItem.order_id);
            w(adOrderItem, this.f303897f);
            return true;
        }
        if (D instanceof AdEmptyInfo) {
            AdEmptyInfo adEmptyInfo = (AdEmptyInfo) D;
            n.a("ExposureChecker", "doOriginReport, empty:" + adEmptyInfo);
            t(adEmptyInfo);
            return true;
        }
        n.b("ExposureChecker", "doOriginReport object type error ; " + D);
        return false;
    }

    private static void y(AdOrderItem adOrderItem, int i3, boolean z16) {
        v(adOrderItem, 1001, i3, E(), 0, 0);
        if (z16) {
            u(adOrderItem, 0);
        }
    }

    private void z(AdOrderItem adOrderItem, int i3, boolean z16, AdExposureType adExposureType) {
        if (AdExposureType.AD_EXPOSURE_TYPE_STAGE.equals(adExposureType)) {
            Y(adOrderItem, i3);
        } else {
            y(adOrderItem, i3, z16);
        }
    }

    public String F() {
        return G() + "_" + H();
    }

    public int I() {
        return this.f303895d;
    }

    public boolean J(Object obj) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.d(obj);
        }
        return false;
    }

    protected boolean K() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null && aVar.j()) {
            return true;
        }
        return false;
    }

    public boolean L() {
        if (this.f303895d == 2) {
            return true;
        }
        return false;
    }

    protected boolean N() {
        int i3 = this.f303901j;
        if (i3 == 1 || i3 == 3 || i3 == 4) {
            return true;
        }
        return false;
    }

    public boolean O() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null || aVar.e() == null) {
            return false;
        }
        return true;
    }

    protected boolean P(boolean z16) {
        if (!N()) {
            n.e("ExposureChecker", "needCheck, is normal type, true");
            return true;
        }
        if (!z16) {
            n.e("ExposureChecker", "needCheck, is feed type, and not in scroll\uff0c true");
            return true;
        }
        if (this.f303902k) {
            n.e("ExposureChecker", "needCheck, is feed type, can report in scroll, ture");
            return true;
        }
        n.e("ExposureChecker", "needCheck, is feed type, can not report!");
        return false;
    }

    protected void R(View view, boolean z16, boolean z17, boolean z18) {
        if (!k(z18)) {
            Z(view, z17, z16);
        } else {
            a0(view);
        }
    }

    protected void S(View view, boolean z16) {
        R(view, true, z16, false);
    }

    protected void T(boolean z16, boolean z17, boolean z18, long j3) {
        if (z16) {
            o();
            if (K()) {
                this.f303895d = 2;
                n.a("ExposureChecker", "onCheckResult, is empty view, check finished");
                return;
            }
        }
        if (!z17) {
            this.f303895d = 0;
            if (this.f303892a > 0) {
                n.a("ExposureChecker", "onCheckResult, insufficient area size for Valid Exposure, total time :" + this.f303892a);
            }
            this.f303892a = 0L;
            if (z18) {
                l();
                return;
            }
            return;
        }
        n.a("ExposureChecker", "onCheckResult, check report, exposure:" + z17 + " state:" + this.f303895d + " validtime:" + this.f303892a);
        if (r(j3)) {
            this.f303895d = 2;
            n.a("ExposureChecker", "onCheckResult, order:" + F() + " report finish.");
            return;
        }
        if (this.f303905n && !this.f303909r) {
            this.f303895d = 0;
        } else {
            l();
        }
    }

    protected void U(View view, b bVar) {
        R(view, true, false, true);
    }

    protected ExposureRunnable V(float f16, boolean z16, boolean z17, ExposureRunnable.a aVar) {
        return new ExposureRunnable(f16, z16, z17, aVar);
    }

    protected ExposureRunnable W(float f16, boolean z16, boolean z17, ExposureRunnable.a aVar) {
        return new ExposureRunnable(f16, z16, z17, aVar);
    }

    protected boolean X(View view, boolean z16) {
        if (view == null) {
            return false;
        }
        if (this.f303895d == 2) {
            n.a("ExposureChecker", "check, has reported, state:" + this.f303895d);
            return false;
        }
        if (!z16) {
            n.a("ExposureChecker", "check, not visible, state:" + this.f303895d);
            ExposureRunnable exposureRunnable = this.f303893b;
            if (exposureRunnable != null && view.equals(exposureRunnable.e())) {
                d0();
            }
            return false;
        }
        if (!O()) {
            n.a("ExposureChecker", "check, is not vaild");
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureRunnable.a
    public void a(boolean z16, boolean z17, boolean z18, int i3, Rect rect, long j3, boolean z19) {
        n.a("ExposureChecker", "onCheckResult, view: " + i3 + " bShown:" + z16 + " bInScreen:" + z17 + " bExposure:" + z18 + " state:" + this.f303895d + " rcView:" + rect + " old RcView:" + this.f303898g + " inteval:" + j3 + " emptyView:" + z19 + " mVisibleSizeFlag:" + this.f303903l + " switch:" + this.f303905n);
        if (this.f303895d != 1) {
            return;
        }
        if (z19 != K()) {
            n.a("ExposureChecker", "onCheckResult, view not match");
            this.f303895d = 0;
        } else {
            if (rect != null && !this.f303898g.equals(rect)) {
                this.f303898g.set(rect);
            }
            T(z17, z18, false, j3);
        }
    }

    public void b0(boolean z16) {
        this.f303909r = z16;
    }

    public void c0(int i3) {
        this.f303895d = i3;
    }

    public void d0() {
        ExposureRunnable exposureRunnable = this.f303893b;
        if (exposureRunnable == null) {
            return;
        }
        g.c(exposureRunnable);
        if (this.f303895d == 2) {
            n.a("ExposureChecker", "ExposureChecker stop, has finished");
        } else {
            this.f303895d = 0;
            n.a("ExposureChecker", "ExposureChecker stop");
        }
    }

    public void e0(QAdExposure.b bVar) {
        this.f303900i = new WeakReference<>(bVar);
    }

    public void g0(View view, Class cls) {
        f0(view);
        h0(cls);
    }

    public void i(Object obj) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar;
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a> weakReference = this.f303896e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(obj);
        }
    }

    public void j(View view, boolean z16, boolean z17, boolean z18) {
        if (!X(view, z16)) {
            return;
        }
        R(view, z16, z17, z18);
    }

    protected void l() {
        if (this.f303895d == 2) {
            n.a("ExposureChecker", "checkNextRound, state error, report finished");
        } else if (s(100L)) {
            this.f303895d = 1;
        } else {
            this.f303895d = 0;
        }
    }

    public void n(View view, boolean z16) {
        if (!X(view, true)) {
            return;
        }
        ExposureRunnable exposureRunnable = this.f303893b;
        if (exposureRunnable != null) {
            exposureRunnable.o(view);
        }
        S(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        if (!this.f303894c) {
            B();
            QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureChecker.2
                @Override // java.lang.Runnable
                public void run() {
                    ExposureChecker.this.x();
                }
            });
            this.f303894c = true;
        }
    }

    public void q(View view, Boolean bool, b bVar) {
        if (!X(view, bool.booleanValue())) {
            return;
        }
        ExposureRunnable exposureRunnable = this.f303893b;
        if (exposureRunnable != null) {
            exposureRunnable.o(view);
        }
        U(view, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(long j3) {
        long j16 = this.f303892a + j3;
        this.f303892a = j16;
        if (j16 >= 1000) {
            C();
            QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureChecker.3
                @Override // java.lang.Runnable
                public void run() {
                    ExposureChecker.this.A();
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s(long j3) {
        if (this.f303893b == null) {
            n.a("ExposureChecker", "doCheck, runnable is null");
            return false;
        }
        n.a("ExposureChecker", "doCheck, delay:" + j3);
        ExposureRunnable exposureRunnable = this.f303893b;
        long j16 = 0;
        if (j3 > 0) {
            j16 = j3;
        }
        exposureRunnable.n(j16);
        if (j3 <= 0) {
            g.a(this.f303893b);
            return true;
        }
        g.b(this.f303893b, j3);
        return true;
    }

    protected void Q() {
    }
}
