package com.tencent.ams.mosaic.jsengine.component.clickshake;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.clickslideshake.ClickSlideShakeListener;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeListener;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickShakeComponentImpl extends FeatureComponent implements ClickShakeComponent, ClickSlideShakeListener, OlympicShakeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final OlympicShakeView f70983d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f70984e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f70985f;

    /* renamed from: h, reason: collision with root package name */
    private JSFunction f70986h;

    public ClickShakeComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        OlympicShakeView olympicShakeView = new OlympicShakeView(context, false);
        this.f70983d = olympicShakeView;
        olympicShakeView.setOnShakeListener((OlympicShakeListener) this);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70983d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.f70983d.stop();
        super.onActivityDestroyed();
        f.a("ClickShakeComponentImpl", "onActivityDestroyed");
    }

    public void onClickComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Double.valueOf(d16));
            return;
        }
        f.a("ClickShakeComponentImpl", "onClickComplete: " + d16);
        if (this.f70986h != null && getJSEngine() != null) {
            getJSEngine().u(this.f70986h, new Object[]{Double.valueOf(d16)}, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Double.valueOf(d16));
            return;
        }
        f.a("ClickShakeComponentImpl", "onShakeComplete: " + d16);
        if (this.f70985f != null && getJSEngine() != null) {
            getJSEngine().u(this.f70985f, new Object[]{Double.valueOf(d16)}, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OlympicShakeListener
    public void onShakeIconClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        f.a("ClickShakeComponentImpl", "onShakeIconClick");
        if (this.f70986h != null && getJSEngine() != null) {
            getJSEngine().u(this.f70986h, null, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        f.a("ClickShakeComponentImpl", "onShaking shakeValue: " + d16);
        if (this.f70984e != null && getJSEngine() != null) {
            getJSEngine().u(this.f70984e, new Object[]{Double.valueOf(d16), Integer.valueOf(i3)}, null);
        }
        f.a("ClickShakeComponentImpl", "mview width: " + this.f70983d.getWidth());
        f.a("ClickShakeComponentImpl", "mview height: " + this.f70983d.getHeight());
        f.a("ClickShakeComponentImpl", "mview CenterPoint: " + this.f70983d.getShakeAnimViewCenterPoint());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.onSwitchBackground();
        f.a("ClickShakeComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f70983d.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.onSwitchForeground();
        f.a("ClickShakeComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f70983d.resume();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setBackgroundImageRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f70983d.setShakeCircleBgRadiusDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setCircleBGViewColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f70983d.setShakeCircleBgColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setInteractiveType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f70983d.setInteractiveMode(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setIsShowBackgroundImage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        OlympicShakeView olympicShakeView = this.f70983d;
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        olympicShakeView.setShakeCircleBgShowAlways(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setOnClickCompleteListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) jSFunction);
        } else {
            this.f70986h = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setOnShakeCompleteListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) jSFunction);
        } else {
            this.f70985f = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setOnShakingListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) jSFunction);
        } else {
            this.f70984e = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iArr);
        } else {
            this.f70983d.setShakeDirectCombine(iArr);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            this.f70983d.setShakeFactor(f16 / 1000.0f, f17 / 1000.0f, f18 / 1000.0f);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setShakeIconSize(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iArr);
        } else if (iArr != null && iArr.length != 0) {
            this.f70983d.setShakeIconSizeDp(iArr[0], iArr[1]);
        } else {
            this.f70983d.setShakeIconSizeDp(60.0f, 60.0f);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f70983d.setShakeSampleRate(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f70983d.setShakeTimeDuration(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.f70983d.setShakeValue(f16 / 100.0f, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f70983d.setSubTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setSubTitleBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f70983d.setBottomPaddingDp(MosaicUtils.E(i3));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f70983d.setTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            f.a("ClickShakeComponentImpl", "start");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponentImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClickShakeComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ClickShakeComponentImpl.this.f70983d.start();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            f.a("ClickShakeComponentImpl", "stop");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponentImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClickShakeComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ClickShakeComponentImpl.this.f70983d.stop();
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
        return "ClickShakeComponentImpl";
    }
}
