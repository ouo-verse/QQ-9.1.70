package com.tencent.ams.mosaic.jsengine.component.scroll;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.music.widget.SensorType;
import com.tencent.ams.music.widget.ShakeScrollConfig;
import com.tencent.ams.music.widget.ShakeScrollWidget;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScrollBannerComponentImpl extends ClickSlideScrollComponentImpl implements ScrollBannerComponent, OnActivityLifecycleChanged.OnActivityLifecycleChangedListener {
    static IPatchRedirector $redirector_;
    private final FrameLayout E;
    private volatile ShakeScrollWidget F;
    private String G;
    private String H;
    private Bitmap I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private int V;
    private volatile boolean W;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.c.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScrollBannerComponentImpl.this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
            } else if (obj instanceof Bitmap) {
                ScrollBannerComponentImpl.this.I = (Bitmap) obj;
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    private ShakeScrollConfig n() {
        ShakeScrollConfig shakeScrollConfig = new ShakeScrollConfig();
        Bitmap bitmap = this.I;
        if (bitmap != null) {
            shakeScrollConfig.setScrollIcon(bitmap);
        }
        shakeScrollConfig.setEnableOrientationInitDegreeProtect(true);
        shakeScrollConfig.setEnableOrientationMinXProtect(true);
        shakeScrollConfig.setEnableOrientationMinYProtect(true);
        shakeScrollConfig.setSensorType(SensorType.ORIENTATION);
        shakeScrollConfig.setDegreeA(this.J);
        shakeScrollConfig.setDegreeB(this.K);
        shakeScrollConfig.setScrollTotalTime(this.L);
        shakeScrollConfig.setMainContent(this.G);
        shakeScrollConfig.setSubContent(this.H);
        shakeScrollConfig.setInvokeJumpType(this.M);
        shakeScrollConfig.setShakeScrollGuideIconType(this.N);
        shakeScrollConfig.setGuideIconMarginBottom(this.P);
        shakeScrollConfig.setBackgroundHighLightColor(this.Q);
        shakeScrollConfig.setNeedRemoveViewOnDestroy(true);
        int j3 = (int) MosaicUtils.j(this.S);
        shakeScrollConfig.setButtonRightMargin((int) MosaicUtils.j(this.T));
        shakeScrollConfig.setButtonLeftMargin(j3);
        shakeScrollConfig.setButtonBottomMargin((int) MosaicUtils.j(this.R));
        shakeScrollConfig.setWidgetWidth((int) MosaicUtils.j(this.V));
        shakeScrollConfig.setScrollButtonHeight((int) MosaicUtils.j(this.U));
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "ShakeScrollConfig info: \n" + shakeScrollConfig.toString());
        return shakeScrollConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.W && this.F == null) {
            this.W = true;
            this.F = new ShakeScrollWidget(this.mContext, n());
            this.F.setShakeScrollListener(this);
            this.F.setOnJumpListener(this);
            this.E.addView((View) this.F, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        com.tencent.ams.mosaic.utils.f.b("ScrollBannerComponentImpl ", "startImpl mScrollWidget exist");
        this.F.resume();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.E;
    }

    @Override // com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged.OnActivityLifecycleChangedListener
    public void onChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "onChanged, status: " + i3);
        ShakeScrollWidget shakeScrollWidget = this.F;
        if (shakeScrollWidget == null) {
            return;
        }
        if (i3 == 3) {
            shakeScrollWidget.pause();
        } else if (i3 == 4) {
            shakeScrollWidget.resume();
        } else if (i3 == 6) {
            shakeScrollWidget.destroy();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setBackgroundHighLightColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setBackgroundHighLightColor:" + str);
        this.Q = Color.parseColor(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scroll.ScrollBannerComponent
    public void setGuideIconMarginBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setGuideIconMarginBottom:" + i3);
        this.P = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scroll.ScrollBannerComponent
    public void setGuideViewShowType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setGuideViewShowType:" + i3);
        this.N = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setInteractionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setInvokeJumpType:" + i3);
        this.M = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollAroundAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setTwistRollbackSuccAngle:" + i3);
        this.K = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerBottomMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollBannerBottomMargin, margin: " + f16);
        this.R = f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollBannerHeight, height: " + f16);
        this.U = f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerLeftMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollBannerLeftMargin, margin: " + f16);
        this.S = f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerRightMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollBannerRightMargin, margin: " + f16);
        this.T = f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBarRightGuideType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollIconUrl:" + str);
        if (!TextUtils.isEmpty(str) && getJSEngine().c() != null) {
            getJSEngine().c().loadImage(str, new a());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollListener(JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, jSFunction, jSFunction2, jSFunction3);
        } else {
            com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollListener");
            super.setScrollListener(jSFunction, jSFunction2, jSFunction3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollTotalTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setScrollTotalTime:" + i3);
        this.L = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setSubTitle:" + str);
        this.H = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setTitle:" + str);
        this.G = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setTriggerAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setSuccAngle:" + i3);
        this.J = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scroll.ScrollBannerComponent
    public void setWidgetWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "setWidgetWidth:" + i3);
        this.V = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "start :" + this.W);
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.scroll.ScrollBannerComponentImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScrollBannerComponentImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ScrollBannerComponentImpl.this.o();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "stop");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.scroll.ScrollBannerComponentImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScrollBannerComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ShakeScrollWidget shakeScrollWidget = ScrollBannerComponentImpl.this.F;
                        if (shakeScrollWidget != null) {
                            com.tencent.ams.mosaic.utils.f.e("ScrollBannerComponentImpl ", "widget.destroy");
                            shakeScrollWidget.invisibleAndClear();
                            shakeScrollWidget.destroy();
                        }
                        ScrollBannerComponentImpl.this.W = false;
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl, com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ScrollBannerComponentImpl ";
    }
}
