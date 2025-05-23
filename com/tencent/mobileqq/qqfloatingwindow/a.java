package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.perf.process.state.floating.IFloatingState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gh2.d;
import gh2.f;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements View.OnClickListener, fh2.b, fh2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IFloatingWrapperManager f264315d;

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f264315d = (IFloatingWrapperManager) QRoute.api(IFloatingWrapperManager.class);
            B(context);
        }
    }

    public View A(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (View) iPatchRedirector.redirect((short) 34, (Object) this, i3);
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getViewById(i3);
        }
        return null;
    }

    public void B(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.initViews(context, this);
        }
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.isFloatWindowHasZoomed();
        }
        return false;
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.removeFloatingWidgetWrapperViews();
        }
    }

    public void E(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) view);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.removeParent(view);
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.removeRootLayoutParent();
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.removeWidgetWrapperParent();
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.resetFloatWindowScale();
        }
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.resetWindowSize();
        }
    }

    public void J(FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) floatingScreenParams);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.restoreLastCenterPosition(floatingScreenParams);
        }
    }

    public void K(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setCloseBtnContentDescription(str);
        }
    }

    public void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, z16);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setContainerClipToOutline(z16);
        }
    }

    public IVideoOuterStatusListener M(IVideoInnerStatusListener iVideoInnerStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (IVideoOuterStatusListener) iPatchRedirector.redirect((short) 30, (Object) this, (Object) iVideoInnerStatusListener);
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.setDuplexVideoStatusListener(iVideoInnerStatusListener);
        }
        return null;
    }

    public void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingCloseBtnVisibility(z16);
        }
    }

    public void O(gh2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) aVar);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerBackPressListener(aVar);
        }
    }

    public void P(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) drawable);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerBackground(drawable);
        }
    }

    public void Q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerBackgroundRes(i3);
        }
    }

    public void R(gh2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) bVar);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerDragListener(bVar);
        }
    }

    public void S(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerOrientation(z16);
        }
    }

    public void T(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerPadding(i3, i16, i17, i18);
        }
    }

    public void U(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingContainerVisibility(z16);
        }
    }

    public void V(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) drawable);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingWidgetBackground(drawable);
        }
    }

    public void W(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, z16);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFloatingWidgetClipToOutLine(z16);
        }
    }

    public void X(IFullScreenEnterListener iFullScreenEnterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) iFullScreenEnterListener);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFullScreenEnterListener(iFullScreenEnterListener);
        }
    }

    public void Y(gh2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) cVar);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setFullScreenViewClickListener(cVar);
        }
    }

    public void Z(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Float.valueOf(f16));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setRootLayoutAlpha(f16);
        }
    }

    public void a0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, i3);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setRootLayoutBackgroundColor(i3);
        }
    }

    public void b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, i3);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setRootLayoutBackgroundRes(i3);
        }
    }

    public void c0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setRootLayoutContentDescription(str);
        }
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setRootLayoutVisible();
        }
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setVideoWrapperBackground();
        }
    }

    public void f(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) layoutParams);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.addRootLayoutToFloatingWidgetWrapper(layoutParams);
        }
    }

    public void f0(boolean z16, View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), viewArr);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setViewEnabled(z16, viewArr);
        }
    }

    public void g(int i3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3, (Object) fVar);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.addScreenStatusReceiver(i3, fVar);
        }
    }

    public void g0(View.OnClickListener onClickListener, View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onClickListener, (Object) viewArr);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setViewsClick(onClickListener, viewArr);
        }
    }

    public void h(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) view, (Object) layoutParams);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.addViewToFloatingWidgetWrapper(view, layoutParams);
        }
    }

    public void i(boolean z16, int i3, int i16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.changeContainerLayoutParams(z16, i3, i16, z17);
        }
    }

    public void i0(boolean z16, View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), viewArr);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setViewsVisibility(z16, viewArr);
        }
    }

    public void initStatusReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.initStatusReceiver();
        }
    }

    public void initWidgetWrapper(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.initWidgetWrapper(view);
        }
    }

    public int j(FloatingScreenParams floatingScreenParams, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) floatingScreenParams, (Object) view)).intValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager == null) {
            return 3;
        }
        int enterWindowFloat = iFloatingWrapperManager.enterWindowFloat(floatingScreenParams, view, this, this);
        if (enterWindowFloat == 0) {
            ((IFloatingState) QRoute.api(IFloatingState.class)).writeState(getClass().getName());
        }
        return enterWindowFloat;
    }

    public void j0(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) dVar);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setWindowClickListener(dVar);
        }
    }

    public void k(FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) floatingScreenParams);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.enterWindowFloatWithWidgetWrapper(floatingScreenParams);
        }
    }

    public void k0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.updateLocation(i3, i16);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.floatingContainerEnterFullScreen();
        }
    }

    public void l0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.updateRatio(f16);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.floatingContainerQuitFullScreen();
        }
    }

    public void m0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.updateShapeType(i3);
        }
    }

    public View n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (View) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getCloseView();
        }
        return null;
    }

    public void n0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.updateSize(i3, i16);
        }
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getContainerIsFloating();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
            if (iFloatingWrapperManager != null) {
                iFloatingWrapperManager.onViewClick(view, this);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getContainerIsSmallFloating();
        }
        return false;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatWindowShapeType();
        }
        return 1;
    }

    public void quitWindowFloat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.quitWindowFloat(i3);
            ((IFloatingState) QRoute.api(IFloatingState.class)).removeState(getClass().getName());
        }
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatingContainerCenterX();
        }
        return 0;
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatingContainerCenterY();
        }
        return 0;
    }

    public void setRoundCorners(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.setRoundCorners(i3, i16);
        }
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatingContainerIsNull();
        }
        return true;
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatingContainerVisibility();
        }
        return 4;
    }

    public void updateFloatingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            iFloatingWrapperManager.updateFloatingView();
        }
    }

    public Context v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Context) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatingContext();
        }
        return null;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getFloatingIsFullScreen();
        }
        return false;
    }

    public boolean x(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager == null) {
            return false;
        }
        return iFloatingWrapperManager.getIsInterceptWindowClick(i3, i16);
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getIsWindowClickListenerNull();
        }
        return true;
    }

    public View z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (View) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        IFloatingWrapperManager iFloatingWrapperManager = this.f264315d;
        if (iFloatingWrapperManager != null) {
            return iFloatingWrapperManager.getRootLayout();
        }
        return null;
    }
}
