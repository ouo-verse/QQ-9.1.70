package com.tencent.ams.mosaic.jsengine.component.clickshakebanner;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.clickslideshake.ClickSlideShakeListener;
import com.tencent.ams.fusion.widget.clickslideshake.ClickSlideShakeView;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickSlideShakeComponentImpl extends FeatureComponent implements ClickSlideShakeComponent, ClickSlideShakeListener, GestureComponent, SlideGestureViewHelper.ISlideGestureListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;
    private float E;
    private float F;

    /* renamed from: d, reason: collision with root package name */
    private final a f70987d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f70988e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f70989f;

    /* renamed from: h, reason: collision with root package name */
    private JSFunction f70990h;

    /* renamed from: i, reason: collision with root package name */
    private JSFunction f70991i;

    /* renamed from: m, reason: collision with root package name */
    private JSFunction f70992m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class a extends ClickSlideShakeView {
        static IPatchRedirector $redirector_;

        public a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClickSlideShakeComponentImpl.this, (Object) context);
            }
        }

        @Override // com.tencent.ams.fusion.widget.clickslideshake.ClickSlideShakeView
        protected boolean needStartWhenAttachedToWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public ClickSlideShakeComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        a aVar = new a(context);
        this.f70987d = aVar;
        aVar.setOnShakeListener((ClickSlideShakeListener) this);
        aVar.setSlideGestureListener(this);
        aVar.setOnClickListener(this);
    }

    private void k(int i3, float f16, float f17) {
        if (this.f70991i != null) {
            getJSEngine().u(this.f70991i, new Object[]{Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17)}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70987d;
    }

    public boolean isInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.onActivityDestroyed();
        f.a("ClickSlideShakeComponentImpl", "onActivityDestroyed");
        this.f70987d.stop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) view);
        } else if (this.f70992m != null) {
            getJSEngine().u(this.f70992m, new Object[]{Float.valueOf(this.C), Float.valueOf(this.D), Float.valueOf(this.E), Float.valueOf(this.F)}, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureResult(int i3, View view, boolean z16, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), view, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else if (this.f70990h != null) {
            getJSEngine().u(this.f70990h, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z16), Float.valueOf(this.C), Float.valueOf(this.D), Float.valueOf(this.E), Float.valueOf(this.F)}, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Double.valueOf(d16));
            return;
        }
        f.a("ClickSlideShakeComponentImpl", "onShakeComplete: " + d16);
        if (this.f70989f != null) {
            getJSEngine().u(this.f70989f, new Object[]{Double.valueOf(d16)}, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        f.a("ClickSlideShakeComponentImpl", "onShaking shakeValue: " + d16);
        if (this.f70988e != null) {
            getJSEngine().u(this.f70988e, new Object[]{Double.valueOf(d16), Integer.valueOf(i3)}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onSwitchBackground();
        f.a("ClickSlideShakeComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f70987d.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.onSwitchForeground();
        f.a("ClickSlideShakeComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f70987d.resume();
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        if (motionEvent != null) {
            if (motionEvent.getAction() == 0) {
                this.C = MosaicUtils.E(view.getLeft() + motionEvent.getX());
                float E = MosaicUtils.E(view.getTop() + motionEvent.getY());
                this.D = E;
                k(0, this.C, E);
                return;
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.E = MosaicUtils.E(view.getLeft() + motionEvent.getX());
                float E2 = MosaicUtils.E(view.getTop() + motionEvent.getY());
                this.F = E2;
                k(1, this.E, E2);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setBannerBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.f70987d.setBannerBackgroundColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setBannerBottomPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f70987d.setBannerBottomPadding((int) MosaicUtils.j(i3));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setBannerIconData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        float n3 = (int) MosaicUtils.n(this.f70987d.getContext(), 52);
        this.f70987d.setBannerIconBitmap(MosaicUtils.d(str, n3, n3));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f70987d.setGestureClickHotArea((int) MosaicUtils.j(i3), (int) MosaicUtils.j(i16), (int) MosaicUtils.j(i17), (int) MosaicUtils.j(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.f70987d.setGestureColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f70987d.setGestureSlideHotArea((int) MosaicUtils.j(i3), (int) MosaicUtils.j(i16), (int) MosaicUtils.j(i17), (int) MosaicUtils.j(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.f70987d.setGestureSlideValidHeightDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.f70987d.setGestureStrokeWidthDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.f70987d.setGestureVisible(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setOnBannerClickListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) jSFunction);
        } else {
            this.f70992m = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setOnShakeCompleteListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jSFunction);
        } else {
            this.f70989f = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setOnShakingListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSFunction);
        } else {
            this.f70988e = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iArr);
        } else {
            this.f70987d.setShakeDirectCombine(iArr);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            this.f70987d.setShakeFactor(f16, f17, f18);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f70987d.setShakeSampleRate(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f70987d.setShakeTimeDuration(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.f70987d.setShakeValue(f16, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        } else {
            this.f70990h = jSFunction;
            this.f70991i = jSFunction2;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f70987d.setSubTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f70987d.setTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            f.a("ClickSlideShakeComponentImpl", "start");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponentImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClickSlideShakeComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ClickSlideShakeComponentImpl.this.f70987d.start();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            f.a("ClickSlideShakeComponentImpl", "stop");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponentImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClickSlideShakeComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ClickSlideShakeComponentImpl.this.f70987d.stop();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ClickSlideShakeComponentImpl";
    }
}
