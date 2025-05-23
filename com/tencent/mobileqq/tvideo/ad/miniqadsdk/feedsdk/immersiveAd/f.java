package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveHVView;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import pw2.n;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f<ImmersiveView extends QAdInteractiveImmersiveHVView> extends c<ImmersiveView> {
    protected volatile boolean N;
    private Rect P;
    private boolean Q;
    private boolean R;

    public f(ImmersiveView immersiveview, Context context) {
        super(immersiveview, context);
        this.N = false;
    }

    private int A(sv2.a aVar) {
        if (aVar != null) {
            long j3 = aVar.f434835d;
            long j16 = aVar.f434834c;
            if (j3 > 0 && j16 > 0 && j3 <= j16) {
                return (int) ((((float) j3) / ((float) j16)) * 1000.0f * 1.0f);
            }
            return 0;
        }
        return 0;
    }

    private boolean B() {
        if (this.D == null) {
            return false;
        }
        if (this.P == null) {
            Rect rect = new Rect();
            this.P = rect;
            rect.left = ((QAdInteractiveImmersiveHVView) this.f304129d).getLeft();
            this.P.right = ((QAdInteractiveImmersiveHVView) this.f304129d).getRight();
            this.P.top = ((QAdInteractiveImmersiveHVView) this.f304129d).getTop();
            this.P.bottom = ((QAdInteractiveImmersiveHVView) this.f304129d).getBottom() / 2;
        }
        Rect rect2 = this.P;
        QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo = this.D;
        return rect2.contains(clickExtraInfo.downX, clickExtraInfo.downY);
    }

    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c C() {
        a aVar = this.f304133i;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    private boolean E(View view, int i3) {
        if (i3 != 5) {
            if (i3 != 14) {
                if (i3 != 16) {
                    if (i3 != 11) {
                        if (i3 != 12) {
                            return false;
                        }
                        m(view);
                        return true;
                    }
                    G();
                    return true;
                }
                J();
            }
            return true;
        }
        if (!B()) {
            return false;
        }
        J();
        return true;
    }

    private void F(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
        if (bVar != null && (bVar instanceof qw2.a)) {
            this.H = ((qw2.a) bVar).f430252a;
        } else {
            this.H = 0;
        }
    }

    private void P() {
        if (this.R) {
            return;
        }
        R(true);
    }

    public int D() {
        a aVar = this.f304133i;
        if (aVar != null) {
            return aVar.e();
        }
        return -1;
    }

    protected void G() {
        u(6);
    }

    public void I(int i3, Object... objArr) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 7) {
                    Q(objArr);
                    return;
                }
                return;
            }
            P();
            return;
        }
        O();
    }

    protected void J() {
        if (this.Q) {
            u(4);
            this.Q = false;
        } else {
            u(3);
            this.Q = true;
        }
    }

    public void K() {
        this.Q = false;
    }

    public void L(sv2.a aVar) {
        this.F = aVar;
        if (!this.N) {
            n.e("NImmController", "onPlayerProgress fail, not visible");
            return;
        }
        x(aVar);
        T(aVar);
        R(false);
    }

    protected void Q(Object... objArr) {
        this.N = ((Boolean) objArr[0]).booleanValue();
    }

    protected void R(boolean z16) {
        V v3 = this.f304129d;
        if (v3 == 0) {
            return;
        }
        ((QAdInteractiveImmersiveHVView) v3).setContentImageViewShow(z16);
    }

    protected void S(boolean z16) {
        V v3 = this.f304129d;
        if (v3 == 0) {
            return;
        }
        ((QAdInteractiveImmersiveHVView) v3).setVideoPauseIconShow(z16);
    }

    protected void T(sv2.a aVar) {
        ((QAdInteractiveImmersiveHVView) this.f304129d).setProgress(A(aVar));
    }

    public void U(boolean z16) {
        if (z16 && !this.N) {
            n.e("NImmController", "showFinishEndMaskView fail, not visible");
            return;
        }
        this.R = z16;
        n.e("NImmController", "showFinishEndMaskView, show:" + z16);
        ((QAdInteractiveImmersiveHVView) this.f304129d).setEndMaskShow(z16);
        if (z16) {
            this.f304134m.r(this.f304129d);
        }
    }

    public void V(QAdCardExtraData qAdCardExtraData) {
        int i3;
        if (this.f304129d != 0 && qAdCardExtraData != null) {
            boolean booleanValue = ((Boolean) qAdCardExtraData.a(QAdCardExtraData.AdExtraInnerKey.AD_RETURN_BTN_VISIBLE, Boolean.TRUE)).booleanValue();
            n.e("NImmController", "returnImageVisible = " + booleanValue);
            QAdInteractiveImmersiveHVView qAdInteractiveImmersiveHVView = (QAdInteractiveImmersiveHVView) this.f304129d;
            if (booleanValue) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qAdInteractiveImmersiveHVView.setReturnImageVisible(i3);
            int intValue = ((Integer) qAdCardExtraData.a(QAdCardExtraData.AdExtraInnerKey.AD_TITLE_LAYOUT_MARGIN_LEFT, Integer.valueOf(s.a(45.0f)))).intValue();
            n.e("NImmController", "titleLayoutMarginLeft = " + intValue);
            ((QAdInteractiveImmersiveHVView) this.f304129d).setTitleLayoutMargin(intValue);
        }
    }

    protected void W() {
        V v3 = this.f304129d;
        if (v3 != 0) {
            ((QAdInteractiveImmersiveHVView) v3).setData(this.f304133i.a());
            ((QAdInteractiveImmersiveHVView) this.f304129d).setImmersiveType(this.f304133i.k());
            S(false);
            ((QAdInteractiveImmersiveHVView) this.f304129d).setEndMaskViewData(C());
            ((QAdInteractiveImmersiveHVView) this.f304129d).m(this.L);
            T(null);
            U(false);
            R(true);
            this.Q = false;
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a
    public void d(int i3, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
        switch (i3) {
            case 8:
                F(bVar);
                return;
            case 9:
                H(bVar);
                return;
            case 10:
                N(bVar);
                return;
            case 11:
                M(bVar);
                return;
            default:
                v(i3, bVar);
                return;
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    protected View i() {
        return ((QAdInteractiveImmersiveHVView) this.f304129d).i();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    protected void j() {
        this.f304134m.p();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void n(AdFeedInfo adFeedInfo, a aVar) {
        super.n(adFeedInfo, aVar);
        W();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void o() {
        super.o();
        R(false);
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void onClick(View view) {
        int a16 = yw2.a.a(view.getId());
        if (b.c(view)) {
            b.a(this.f304130e, this);
        } else {
            if (a16 == 0 || E(view, a16)) {
                return;
            }
            super.onClick(view);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void p() {
        super.p();
        if (!this.R) {
            S(true);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void q() {
        super.q();
        S(false);
        R(false);
        this.Q = false;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void r() {
        super.r();
        n.e("NImmController", "onPlayerStart");
        S(false);
        R(false);
        this.Q = false;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c
    public void w(boolean z16) {
        super.w(z16);
        ((QAdInteractiveImmersiveHVView) this.f304129d).setLandscape(z16);
        this.P = null;
        this.f304134m.s(z16);
    }

    private void O() {
    }

    private void H(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
    }

    private void M(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
    }

    private void N(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
    }

    public void z(long j3) {
    }
}
