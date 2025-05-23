package ju;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import cw.c;
import dw.b;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends com.tencent.av.business.manager.a {
    private volatile b C;

    @Deprecated
    private volatile b D;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<cw.b> f410950h;

    /* renamed from: i, reason: collision with root package name */
    private final TipsViewTimerRunnable f410951i;

    /* renamed from: m, reason: collision with root package name */
    private volatile b f410952m;

    public a(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f410952m = null;
        this.C = null;
        this.D = null;
        this.f410951i = new TipsViewTimerRunnable(videoAppInterface);
    }

    private boolean G(b bVar) {
        Object obj;
        boolean z16;
        boolean z17;
        boolean z18;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showMainTips begin avTipsItem = ");
        if (bVar != null) {
            obj = Integer.valueOf(bVar.c());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        t(sb5.toString());
        cw.b M = M();
        if (bVar == null || M == null || !M.b()) {
            return false;
        }
        b g16 = this.f410951i.g();
        boolean b16 = bVar.b();
        if (g16 != null && !g16.b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (bVar.c() == 1072) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            this.C = bVar;
            if (g16 != null || !M.i(bVar)) {
                return false;
            }
            t("showMainTips ShowMainTipsView success");
            this.f410951i.i(bVar);
            return true;
        }
        boolean a16 = b.a(g16, bVar);
        if (b16 && z16 && !a16) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            this.f410952m = bVar;
            return false;
        }
        t("showMainTips canShow = " + a16);
        if (a16) {
            if (!M.i(bVar)) {
                return false;
            }
            t("showMainTips ShowMainTipsView success");
            this.f410951i.i(bVar);
            if (g16 != null && g16.b()) {
                if (!b16 && !z17) {
                    this.f410952m = g16;
                } else {
                    this.f410952m = null;
                }
            }
            return true;
        }
        t("showMainTips canShow is false current = " + g16.c());
        return false;
    }

    private boolean I(b bVar) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showSubTips begin avTipsItem = ");
        if (bVar != null) {
            obj = Integer.valueOf(bVar.c());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        t(sb5.toString());
        cw.b M = M();
        if (bVar == null || M == null || !M.a()) {
            return false;
        }
        b h16 = this.f410951i.h();
        boolean a16 = b.a(h16, bVar);
        t("showSubTips canShow = " + a16);
        if (!a16 || !M.h(bVar)) {
            return false;
        }
        t("showSubTips ShowSubTipsView success");
        this.f410951i.j(bVar);
        if (h16 != null && h16.b()) {
            if (bVar.b()) {
                this.D = null;
            } else {
                this.D = h16;
            }
        }
        return true;
    }

    public static void t(String str) {
        if (str == null) {
            return;
        }
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d("NewTipsManager", 2, str);
        }
    }

    private void u(b bVar) {
        if (bVar == null) {
            return;
        }
        b g16 = this.f410951i.g();
        if (bVar.equals(this.f410952m)) {
            t("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + bVar.c());
            this.f410952m = null;
        }
        if (bVar.equals(this.C)) {
            t("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + bVar.c());
            this.C = null;
        }
        if (bVar.equals(g16)) {
            t("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + bVar.c());
            this.f410951i.e();
        }
    }

    private void v() {
        cw.b M = M();
        t("hiddenMainTipsReal");
        if (M != null && M.b()) {
            M.e();
        }
    }

    private void w(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.equals(this.f410951i.h())) {
            t("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + bVar.c());
            this.f410951i.f();
            return;
        }
        if (bVar.equals(this.D)) {
            t("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + bVar.c());
            this.D = null;
        }
    }

    private void x() {
        cw.b M = M();
        t("hiddenSubTipsReal");
        if (M != null && M.a()) {
            M.f();
        }
    }

    public int A(long j3, boolean z16) {
        if (j3 != 0 && j3 < 1000) {
            return 3;
        }
        if (z16) {
            return 0;
        }
        return (int) (j3 / 1000);
    }

    public void B() {
        t("RemoveAllTips");
        this.f410952m = null;
        this.C = null;
        this.f410951i.e();
        this.f410951i.f();
        this.D = null;
    }

    public void C(cw.b bVar) {
        if (bVar == null) {
            return;
        }
        t("setAvTipsView avTipsView is " + bVar.getClass());
        this.f410950h = new WeakReference<>(bVar);
    }

    public boolean D(int i3, long j3) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        return K(dw.a.b(i3, videoAppInterface, A(j3, false)));
    }

    public boolean E(int i3, long j3, boolean z16) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        return K(dw.a.b(i3, videoAppInterface, A(j3, z16)));
    }

    public boolean F(String str, long j3, boolean z16) {
        if (this.f73316e == null) {
            return false;
        }
        t("showDeviceTips TTL = " + j3 + "    resident = " + z16);
        return K(dw.a.d(1075, this.f73316e, str, A(j3, z16)));
    }

    public boolean H(c cVar) {
        if (this.f73316e == null) {
            return false;
        }
        cw.b M = M();
        if (M == null) {
            QLog.e("NewTipsManager", 1, "tips view is null");
            return false;
        }
        return M.j(cVar);
    }

    public boolean J(int i3, View.OnClickListener onClickListener) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        b a16 = dw.a.a(i3, videoAppInterface);
        if (a16 instanceof dw.c) {
            ((dw.c) a16).x(onClickListener);
        }
        return K(a16);
    }

    public boolean K(b bVar) {
        if (bVar == null) {
            t("showTips (tipsItem == null)");
            return false;
        }
        int f16 = bVar.f();
        if (f16 != 0) {
            if (f16 != 1) {
                t("showTips tipsItem.getShowType() = " + bVar.f());
                return false;
            }
            return I(bVar);
        }
        return G(bVar);
    }

    public boolean L(int i3, String str, Drawable drawable, int i16, View.OnClickListener onClickListener) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        return K(dw.a.e(i3, videoAppInterface, str, 2, drawable, i16, onClickListener));
    }

    public cw.b M() {
        WeakReference<cw.b> weakReference = this.f410950h;
        if (weakReference != null && !weakReference.isEnqueued()) {
            return this.f410950h.get();
        }
        return null;
    }

    @Override // com.tencent.av.business.manager.a
    protected boolean i(String str) {
        return false;
    }

    public void l(int i3) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            t("HiddenTips (mApp == null)");
            return;
        }
        b a16 = dw.a.a(i3, videoAppInterface);
        if (a16 == null) {
            t("HiddenTips (tipsItem == null)");
            return;
        }
        int f16 = a16.f();
        if (f16 != 0) {
            if (f16 != 1) {
                t("HiddenTips tipsItem.getShowType() = " + a16.f());
                return;
            }
            w(a16);
            return;
        }
        u(a16);
    }

    public void m() {
        cw.b M = M();
        t("HiddenViewContainer");
        if (M != null && M.a()) {
            M.g();
        }
    }

    public void n(b bVar) {
        if (bVar == null) {
            return;
        }
        t("NotifyHiddenMainTipsByRunner item" + bVar.c());
        if (!bVar.b() && this.f410952m != null) {
            G(this.f410952m);
            return;
        }
        v();
        if (this.C != null) {
            K(this.C);
        }
    }

    public void o(b bVar) {
        if (bVar == null) {
            return;
        }
        t("NotifyHiddenSubTipsByRunner item" + bVar.c());
        if (!bVar.b() && this.D != null) {
            I(this.D);
        } else {
            x();
        }
    }

    public boolean p(int i3) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        return K(dw.a.a(i3, videoAppInterface));
    }

    public boolean q(int i3, String str) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        return K(dw.a.c(i3, videoAppInterface, str));
    }

    public boolean r(int i3, String str, String str2, Drawable drawable, int i16, View.OnClickListener onClickListener) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface == null) {
            return false;
        }
        return K(dw.a.f(i3, videoAppInterface, str, str2, 2, drawable, i16, onClickListener));
    }

    public void s() {
        cw.b M = M();
        t("ShowViewContainer");
        if (M != null && M.a()) {
            M.d();
        }
    }

    public void y(boolean z16) {
        if (!z16) {
            b g16 = this.f410951i.g();
            if (g16 != null && g16.c() != 1072 && 1075 >= g16.c() && g16.c() >= 1062) {
                t("hiddenDeviceTips current id = " + g16.c());
                l(g16.c());
                return;
            }
            return;
        }
        l(1072);
    }

    public void z() {
        cw.b M = M();
        if (M == null) {
            QLog.e("NewTipsManager", 1, "tips view is null");
        } else {
            M.c();
        }
    }

    @Override // com.tencent.av.business.manager.a
    protected void g() {
    }
}
