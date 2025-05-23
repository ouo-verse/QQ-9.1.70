package com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.ams.music.widget.OnJumpListener;
import com.tencent.ams.music.widget.ShakeScrollView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickSlideScrollComponentImpl extends FeatureComponent implements IClickSlideScrollComponent, SlideGestureViewHelper.ISlideGestureListener, ShakeScrollView.ShakeScrollListener, OnJumpListener {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;

    /* renamed from: d, reason: collision with root package name */
    private final ClickSlideScrollView f70994d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f70995e;

    /* renamed from: f, reason: collision with root package name */
    protected JSFunction f70996f;

    /* renamed from: h, reason: collision with root package name */
    protected JSFunction f70997h;

    /* renamed from: i, reason: collision with root package name */
    private float f70998i;

    /* renamed from: m, reason: collision with root package name */
    private float f70999m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface ScrollStatus {
        public static final int INIT = 0;
        public static final int MOVE_LEFT = 3;
        public static final int MOVE_LEFT_RIGHT_SHAKE = 4;
        public static final int MOVE_RIGHT = 1;
        public static final int MOVE_RIGHT_LEFT_SHAKE = 2;
        public static final int SUCCESS = 5;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (View) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        f.e("SlideScrollBannerComponentImpl", "getView");
        return this.f70994d;
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureResult(int i3, View view, boolean z16, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), view, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "onGestureResult, gestureType: " + i3 + ", success: " + z16 + ", xOffset: " + f16 + ", yOffset: " + f17 + ", angle: " + f18);
        if (this.f70995e != null) {
            getJSEngine().u(this.f70995e, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z16), Float.valueOf(this.f70998i), Float.valueOf(this.f70999m), Float.valueOf(this.C), Float.valueOf(this.D)}, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            f.e("SlideScrollBannerComponentImpl", "onGestureStart");
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view, (Object) motionEvent);
        } else {
            f.e("SlideScrollBannerComponentImpl", "onTouch");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setBackgroundHighLightColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setBackgroundHighLightColor, color: " + str);
        this.f70994d.setBackgroundHighLightColor(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setGestureClickHotArea, left: " + i3 + ", right: " + i16 + ", bottom: " + i17 + ", height: " + i18);
        this.f70994d.setGestureClickHotArea(i3, i16, i17, i18);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setGestureColor, color: " + str);
        this.f70994d.setGestureColor(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setGestureSlideHotArea, left: " + i3 + ", right: " + i16 + ", bottom: " + i17 + ", height: " + i18);
        this.f70994d.setGestureSlideHotArea(i3, i16, i17, i18);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setGestureSlideValidHeight, height: " + i3);
        this.f70994d.setGestureSlideValidHeight(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setGestureStrokeWidth, strokeWidth: " + i3);
        this.f70994d.setGestureStrokeWidth(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setGestureVisible, visible: " + z16);
        this.f70994d.setGestureVisible(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setHideClickSlideGuideAnim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setHideClickSlideGuideAnim, showGuide: " + z16);
        this.f70994d.setHideClickSlideGuideAnim(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setInteractionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setInteractionType, type: " + i3);
        this.f70994d.setInteractionType(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            super.setJSEngine(aVar);
            this.f70994d.setImageLoader(getImageLoader());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollAroundAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollAroundAngle, angle: " + i3);
        this.f70994d.setScrollAroundAngle(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerBottomMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollBannerBottomMargin, margin: " + f16);
        this.f70994d.f(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollBannerHeight, height: " + f16);
        this.f70994d.g(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerLeftMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollBannerLeftMargin, margin: " + f16);
        this.f70994d.h(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBannerRightMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollBannerRightMargin, margin: " + f16);
        this.f70994d.i(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollBarRightGuideType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollBarRightGuideType, guideType: " + i3);
        this.f70994d.setScrollBarRightGuideType(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollIconBase64(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollIconBase64, base64: " + str);
        this.f70994d.setScrollIconBase64(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollIcon, url: " + str);
        this.f70994d.setScrollIcon(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollListener(JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, jSFunction, jSFunction2, jSFunction3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollListener");
        this.f70997h = jSFunction2;
        this.f70996f = jSFunction;
        this.f70995e = jSFunction3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setScrollTotalTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setScrollTotalTime, scrollTotalTime: " + i3);
        this.f70994d.setScrollTotalTime(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent, com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setSubTitle, subTitle: " + str);
        this.f70994d.setSubTitle(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setTitle, title: " + str);
        this.f70994d.setMainTitle(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void setTriggerAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        f.e("SlideScrollBannerComponentImpl", "setTriggerAngle, angle: " + i3);
        this.f70994d.setTriggerAngle(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            f.e("SlideScrollBannerComponentImpl", "start");
            this.f70994d.j();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.IClickSlideScrollComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f.e("SlideScrollBannerComponentImpl", "stop");
            this.f70994d.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return "SlideScrollBannerComponentImpl";
    }
}
