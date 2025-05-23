package com.tencent.mobileqq.popanim.state;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.popanim.state.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends com.tencent.mobileqq.popanim.state.a {
    static IPatchRedirector $redirector_;
    private static int H;
    private LinearLayout C;
    private LottieAnimationView D;
    private TextView E;
    private IPanelInteractionListener F;
    private boolean G;

    /* renamed from: h, reason: collision with root package name */
    private int f259126h;

    /* renamed from: i, reason: collision with root package name */
    private URLImageView f259127i;

    /* renamed from: m, reason: collision with root package name */
    private QQBlurView f259128m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements QQBlur.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            c.this.C.setVisibility(0);
            if (c.this.f259124f.b()) {
                c.this.E.setText(R.string.f212365nb);
                com.tencent.mobileqq.popanim.view.a.j(8, c.this.D);
            } else {
                c.this.E.setText(R.string.f212375nc);
                com.tencent.mobileqq.popanim.view.a.j(0, c.this.D);
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            QLog.d("BlurMaskState", 2, "blurView afterDraw");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.popanim.state.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.this.d();
                }
            });
            c.this.f259128m.q(null);
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void b(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            } else {
                QLog.d("BlurMaskState", 2, "blurView beforeDraw");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            H = 100;
        }
    }

    public c(ViewGroup viewGroup, f fVar) {
        super(viewGroup, fVar);
        int statusBarHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup, (Object) fVar);
            return;
        }
        IPanelInteractionListener iPanelInteractionListener = fVar.f259143h;
        this.F = iPanelInteractionListener;
        if (iPanelInteractionListener != null && iPanelInteractionListener.isScaleChat()) {
            statusBarHeight = this.F.getTitleBarHeight();
        } else {
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.f259122d);
        }
        this.f259126h = statusBarHeight;
        this.f259127i = (URLImageView) this.f259123e.findViewById(R.id.f26390de);
        this.f259128m = (QQBlurView) this.f259123e.findViewById(R.id.t95);
        LinearLayout linearLayout = (LinearLayout) this.f259123e.findViewById(R.id.f100065rh);
        this.C = linearLayout;
        this.D = (LottieAnimationView) linearLayout.findViewById(R.id.f88164wb);
        this.E = (TextView) this.C.findViewById(R.id.f83164iu);
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void a(com.tencent.mobileqq.popanim.state.a aVar) {
        int statusBarHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        QLog.d("BlurMaskState", 1, "mHasEverUpperAIO: ", Boolean.valueOf(this.f259124f.f259144i));
        this.f259124f.f259144i = false;
        Drawable bigDrawable = this.f259124f.f259137b.getBigDrawable(this.f259122d, this.f259122d.getResources().getDisplayMetrics().density);
        if (bigDrawable == null) {
            return;
        }
        bigDrawable.setCallback(this.f259127i);
        this.f259127i.setImageDrawable(bigDrawable);
        if (this.f259123e.getParent() == null) {
            this.f259123e.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            IPanelInteractionListener iPanelInteractionListener = this.F;
            if (iPanelInteractionListener != null && iPanelInteractionListener.isScaleChat()) {
                statusBarHeight = this.F.getTitleBarHeight();
            } else {
                statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.f259122d);
            }
            layoutParams.topMargin = statusBarHeight;
            ViewGroup viewGroup = this.f259124f.f259139d;
            if (viewGroup != null) {
                viewGroup.addView(this.f259123e, layoutParams);
            }
        }
        int b16 = com.tencent.mobileqq.popanim.util.a.b(this.f259124f.f259141f, this.f259126h);
        IPanelInteractionListener iPanelInteractionListener2 = this.F;
        if (iPanelInteractionListener2 != null && iPanelInteractionListener2.isScaleChat()) {
            b16 = (int) ((b16 - this.F.getAIOLocation()[1]) / this.F.getAIOScale());
        }
        com.tencent.mobileqq.popanim.view.a.c(this.f259128m, this.f259124f.f259139d, b16);
        ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
        layoutParams2.height = b16;
        this.C.setLayoutParams(layoutParams2);
        this.f259128m.setVisibility(0);
        this.f259128m.q(new a());
        com.tencent.mobileqq.popanim.view.a.h("0X800BBA0", this.f259124f.f259137b);
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void b(com.tencent.mobileqq.popanim.state.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.G = false;
            com.tencent.mobileqq.popanim.view.a.j(4, this.D, this.f259127i, this.f259128m, this.C);
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        QQEmoticonPanelLinearLayoutHelper a16 = this.f259124f.a();
        if (a16 == null) {
            return true;
        }
        if (!this.G) {
            this.G = true;
            a16.hidePopupWindow();
            a16.showStickerMaskOnPanel();
            this.f259127i.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f259127i.getLayoutParams();
        if (a16.isSplitViewModeAndLand(this.f259127i.getContext())) {
            layoutParams.leftMargin = (((int) motionEvent.getRawX()) - a16.getNavigateWidth()) - (this.f259127i.getWidth() / 2);
        } else {
            layoutParams.leftMargin = ((int) motionEvent.getRawX()) - (this.f259127i.getWidth() / 2);
        }
        layoutParams.topMargin = ((((int) motionEvent.getRawY()) - this.f259126h) - this.f259127i.getHeight()) - H;
        IPanelInteractionListener iPanelInteractionListener = this.F;
        if (iPanelInteractionListener != null && iPanelInteractionListener.isScaleChat()) {
            layoutParams.leftMargin -= this.F.getAIOLocation()[0];
            layoutParams.topMargin -= this.F.getAIOLocation()[1];
            layoutParams.leftMargin = (int) (layoutParams.leftMargin / this.F.getAIOScale());
            layoutParams.topMargin = (int) (layoutParams.topMargin / this.F.getAIOScale());
        }
        this.f259127i.requestLayout();
        return true;
    }
}
