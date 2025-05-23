package com.qq.e.comm.plugin.tangramsplash.interactive;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsAnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.utils.AppForegroundListener;
import com.tencent.ams.fusion.widget.utils.FusionWidgetConfig;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {
    public static int A = 1046;
    public static int B = 1047;
    public static int C = 1048;
    public static int D = 1049;
    public static int E = 1050;
    public static int F = 1051;
    public static int G = 1052;
    public static int H = 1053;
    public static int I = 1054;
    public static int J = 1055;
    public static int K = 1056;
    public static int L = 1057;
    public static int M = 1058;
    public static int N = 1061;
    public static int O = 1062;
    public static int P = 1063;
    public static int Q = 1064;
    public static int R = 1065;
    public static int S = 1066;
    public static int T = 1069;
    public static int U = 1070;
    public static int V = 1071;
    public static int W = 1072;

    /* renamed from: a, reason: collision with root package name */
    public static int f40089a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static int f40090b = 1001;

    /* renamed from: c, reason: collision with root package name */
    public static int f40091c = 1002;

    /* renamed from: d, reason: collision with root package name */
    public static int f40092d = 1003;

    /* renamed from: e, reason: collision with root package name */
    public static int f40093e = 1004;

    /* renamed from: f, reason: collision with root package name */
    public static int f40094f = 1005;

    /* renamed from: g, reason: collision with root package name */
    public static int f40095g = 1006;

    /* renamed from: h, reason: collision with root package name */
    public static int f40096h = 1011;

    /* renamed from: i, reason: collision with root package name */
    public static int f40097i = 1016;

    /* renamed from: j, reason: collision with root package name */
    public static int f40098j = 1019;

    /* renamed from: k, reason: collision with root package name */
    public static int f40099k = 1020;

    /* renamed from: l, reason: collision with root package name */
    public static int f40100l = 1021;

    /* renamed from: m, reason: collision with root package name */
    public static int f40101m = 1022;

    /* renamed from: n, reason: collision with root package name */
    public static int f40102n = 1030;

    /* renamed from: o, reason: collision with root package name */
    public static int f40103o = 1031;

    /* renamed from: p, reason: collision with root package name */
    public static int f40104p = 1032;

    /* renamed from: q, reason: collision with root package name */
    public static int f40105q = 1033;

    /* renamed from: r, reason: collision with root package name */
    public static int f40106r = 1035;

    /* renamed from: s, reason: collision with root package name */
    public static int f40107s = 1036;

    /* renamed from: t, reason: collision with root package name */
    public static int f40108t = 1037;

    /* renamed from: u, reason: collision with root package name */
    public static int f40109u = 1040;

    /* renamed from: v, reason: collision with root package name */
    public static int f40110v = 1041;

    /* renamed from: w, reason: collision with root package name */
    public static int f40111w = 1042;

    /* renamed from: x, reason: collision with root package name */
    public static int f40112x = 1043;

    /* renamed from: y, reason: collision with root package name */
    public static int f40113y = 1044;

    /* renamed from: z, reason: collision with root package name */
    public static int f40114z = 1045;
    protected r X;
    protected c Y;
    protected volatile com.qq.e.comm.plugin.tangramsplash.interactive.b Z;

    /* renamed from: aa, reason: collision with root package name */
    protected InteractiveInfo f40115aa;

    /* renamed from: ab, reason: collision with root package name */
    protected f f40116ab;

    /* renamed from: ac, reason: collision with root package name */
    protected boolean f40117ac = true;

    /* renamed from: ad, reason: collision with root package name */
    protected long f40118ad;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.tangramsplash.interactive.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0289a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f40119a = null;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f40120b = null;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class b implements AppForegroundListener {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<a> f40127a;

        b(WeakReference<a> weakReference) {
            this.f40127a = weakReference;
        }

        @Override // com.tencent.ams.fusion.widget.utils.AppForegroundListener
        public boolean isOnForeground() {
            a aVar;
            boolean z16;
            WeakReference<a> weakReference = this.f40127a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.f40117ac) {
                z16 = true;
            } else {
                z16 = false;
            }
            GDTLogger.i("TangramAppForegroundListener isOnForeground :" + z16);
            return z16;
        }
    }

    public a(r rVar, c cVar) {
        InteractiveInfo interactiveInfo;
        this.X = rVar;
        this.Y = cVar;
        if (rVar != null) {
            interactiveInfo = rVar.bJ();
        } else {
            interactiveInfo = null;
        }
        this.f40115aa = interactiveInfo;
    }

    private static void b(String str) {
        AnimatorConfig.setRunOnOldRenderer(!c(str));
        PhysicsAnimatorConfig.setEnablePhysicsHardware(com.qq.e.comm.plugin.j.c.a("physicsRainUseHardware", 1, 1));
        GDTLogger.i("InteractiveAd: enable hardware render = " + AnimatorConfig.isEnableHardware());
    }

    private static boolean c(String str) {
        boolean z16 = false;
        if (Build.VERSION.SDK_INT <= com.qq.e.comm.plugin.j.c.a("interactiveChoreographerAboveAND11", 26)) {
            GDTLogger.i("Build.VERSION.SDK_INT <= Android_SDK_VERSION in wuji, can not use new render");
            return false;
        }
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, "interactiveChoreographerList", "IconFlipInteractive,SlideFlipInteractive,AuraIconFlipInteractive,AuraIconTwistInteractive");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(a16)) {
            String[] split = a16.split(",");
            if (g.a((Object[]) split)) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2) && (str.equals(str2) || str2.equals("AllInteractive"))) {
                        GDTLogger.i("displayMode use new render :" + str + " type :" + str2);
                        z16 = true;
                        break;
                    }
                }
            }
        }
        return (TextUtils.isEmpty(str) || !"AnimationInteractive".equals(str)) ? z16 : com.qq.e.comm.plugin.j.c.a("baseRainChoreographer", 1, 1);
    }

    private boolean y() {
        if (this.Z == null || this.Y == null || this.X == null || this.f40115aa == null) {
            return false;
        }
        return true;
    }

    public void a(C0289a c0289a) {
    }

    protected abstract void a(String str);

    protected abstract boolean a();

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        r rVar = this.X;
        if (rVar == null) {
            return "unknown";
        }
        String bP = rVar.bP();
        if (TextUtils.isEmpty(bP)) {
            return "unknown";
        }
        return bP;
    }

    public void e() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010006, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.b(this.X.bP());
    }

    public void f() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010007, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.b(d(), true);
    }

    public void g() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010024, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.b(d(), false);
    }

    public void h() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010023, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d());
    }

    public void i() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010031, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.e(d());
    }

    public void j() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010032, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.d(d());
    }

    public void k() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010033, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.c(d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        com.qq.e.comm.plugin.tangramsplash.report.a.b(d(), "sensorErr");
    }

    public void m() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010034, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
    }

    public void n() {
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(7010035, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o() {
        if (com.qq.e.comm.plugin.j.c.a("SplashAvoidMultiClick", 1, 1)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f40118ad;
            if (j3 != 0 && currentTimeMillis - j3 < com.qq.e.comm.plugin.j.c.a("SplashAvoidMultiClickDuration", 200)) {
                this.f40118ad = currentTimeMillis;
                return true;
            }
            this.f40118ad = currentTimeMillis;
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        f fVar = this.f40116ab;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        this.Z = null;
        FusionWidgetConfig.setAppForegroundListener(null);
    }

    public void w() {
        this.f40117ac = false;
    }

    public void x() {
        this.f40117ac = true;
    }

    public static a a(r rVar, c cVar) {
        InteractiveInfo bJ;
        a aVar = null;
        if (rVar == null || (bJ = rVar.bJ()) == null) {
            return null;
        }
        String bP = rVar.bP();
        String[] bQ = rVar.bQ();
        boolean a16 = bJ.f() != null ? bJ.f().a() : false;
        if ("ShakeInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.g.a(rVar, cVar);
        } else if ("ShakePlusInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.d.a(rVar, cVar);
        } else if ("SlideInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.f.b(rVar, cVar);
        } else if ("LeanForwardInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.f.a(rVar, cVar);
        } else if ("SlideFlipInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.c.a(rVar, cVar);
        } else if ("SlideVerticalCarouselCard".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar, cVar);
        } else if ("TwistVerticalCarouselCard".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.e.b(rVar, cVar);
        } else if ("IconFlipInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.c.b(rVar, cVar);
        } else if ("AuraIconTwistInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.b.b(rVar, cVar);
        } else if ("AuraIconFlipInteractive".equals(bP)) {
            aVar = new com.qq.e.comm.plugin.tangramsplash.interactive.b.a(rVar, cVar);
        }
        a(a16, bP, bQ, bJ);
        b(bP);
        return aVar;
    }

    public void c() {
        if (y() && a()) {
            FusionWidgetConfig.setAppForegroundListener(new b(new WeakReference(this)));
            b();
        } else {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public static boolean a(String[] strArr, String str) {
        if (!g.a(strArr) && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void a(boolean z16, String str, String[] strArr, InteractiveInfo interactiveInfo) {
        if (interactiveInfo == null) {
            return;
        }
        if ("ShakeInteractive".equals(str)) {
            interactiveInfo.d(z16 ? f40090b : f40091c);
            return;
        }
        if ("ShakePlusInteractive".equals(str)) {
            interactiveInfo.d(z16 ? f40092d : f40093e);
            return;
        }
        if ("LeanForwardInteractive".equals(str)) {
            interactiveInfo.d(z16 ? B : C);
            return;
        }
        if ("SlideInteractive".equals(str)) {
            interactiveInfo.d(z16 ? f40098j : f40099k);
            return;
        }
        if ("SlideFlipInteractive".equals(str)) {
            interactiveInfo.d(z16 ? L : M);
            return;
        }
        if ("SlideVerticalCarouselCard".equals(str)) {
            interactiveInfo.d(z16 ? N : O);
            return;
        }
        if ("TwistVerticalCarouselCard".equals(str)) {
            interactiveInfo.d(z16 ? P : Q);
            return;
        }
        if ("IconFlipInteractive".equals(str)) {
            interactiveInfo.d(z16 ? R : S);
            return;
        }
        if ("AuraIconFlipInteractive".equals(str)) {
            interactiveInfo.d(z16 ? T : U);
        } else if ("AuraIconTwistInteractive".equals(str)) {
            interactiveInfo.d(z16 ? V : W);
        } else {
            interactiveInfo.d(f40089a);
        }
    }

    public void a(com.qq.e.comm.plugin.tangramsplash.interactive.b bVar) {
        this.Z = bVar;
    }

    public void a(f.a aVar) {
        GDTLogger.d("startEnableDrawAfterAdShow");
        if (aVar != null) {
            aVar.a(true);
        }
    }

    public void a(boolean z16) {
        int i3 = z16 ? 1310373 : 1310379;
        r rVar = this.X;
        if (rVar != null && this.Y != null) {
            String s16 = rVar.s();
            r rVar2 = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(i3, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), z16);
    }
}
