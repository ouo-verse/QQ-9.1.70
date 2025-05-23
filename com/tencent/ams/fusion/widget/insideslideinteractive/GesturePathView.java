package com.tencent.ams.fusion.widget.insideslideinteractive;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class GesturePathView extends TextureAnimatorView implements GesturePathLayer.GestureResultListener {
    static IPatchRedirector $redirector_;
    private boolean mEnableShowStorke;
    private GesturePathLayer mGesturePathLayer;
    private float mGestureSlideValidAngle;
    private boolean mIsStarted;

    @SlideGestureViewHelper.SlideDirection
    private int mSlideDirection;
    private InsideSlideInteractiveListener mSlideInteractiveListener;
    private float mSlideStorkWidthDp;
    private float mSlideThreshold;
    private int mStorkColor;

    public GesturePathView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mStorkColor = -1;
        this.mEnableShowStorke = true;
        this.mSlideStorkWidthDp = 8.0f;
        this.mGestureSlideValidAngle = 90.0f;
        this.mSlideDirection = 1;
    }

    private void initLayer() {
        if (getWidth() > 0 && getHeight() > 0) {
            if (this.mGesturePathLayer == null) {
                GesturePathLayer gesturePathLayer = new GesturePathLayer(getContext(), new Rect(0, 0, getWidth(), getHeight()), this.mSlideThreshold);
                this.mGesturePathLayer = gesturePathLayer;
                gesturePathLayer.setEnableShowStroke(this.mEnableShowStorke);
                this.mGesturePathLayer.setStrokeColor(this.mStorkColor);
                this.mGesturePathLayer.setSlideAngleThreshold(this.mGestureSlideValidAngle);
                this.mGesturePathLayer.setStrokeWidth(Utils.dp2px(this.mSlideStorkWidthDp));
                this.mGesturePathLayer.setSlideDirection(this.mSlideDirection);
                this.mGesturePathLayer.setGestureResultListener(this);
                addLayer(this.mGesturePathLayer);
            }
            this.mGesturePathLayer.reset();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
    public void onGestureMatchFinish(boolean z16, int i3, float f16, float f17, float f18, float f19, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i16));
            return;
        }
        InsideSlideInteractiveListener insideSlideInteractiveListener = this.mSlideInteractiveListener;
        if (insideSlideInteractiveListener != null) {
            insideSlideInteractiveListener.onGestureResult(z16, null, f16, f17, f18, f19);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
    public void onGestureMatchProgress(float f16, float f17, float f18, float f19, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
    public void onGestureMatchStart(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        InsideSlideInteractiveListener insideSlideInteractiveListener = this.mSlideInteractiveListener;
        if (insideSlideInteractiveListener != null) {
            insideSlideInteractiveListener.onGestureStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
    public void onGestureMatchSuccess(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mIsStarted) {
            initLayer();
        }
    }

    public boolean processEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        InsideSlideInteractiveListener insideSlideInteractiveListener = this.mSlideInteractiveListener;
        if (insideSlideInteractiveListener != null) {
            insideSlideInteractiveListener.onTouch(this, motionEvent);
        }
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            return gesturePathLayer.processEvent(motionEvent);
        }
        return false;
    }

    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            int parseColor = Color.parseColor(str);
            this.mStorkColor = parseColor;
            GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
            if (gesturePathLayer != null) {
                gesturePathLayer.setStrokeColor(parseColor);
            }
        }
    }

    public void setGestureSlideValidAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        this.mGestureSlideValidAngle = f16;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setSlideAngleThreshold(f16);
        }
    }

    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        float dp2px = Utils.dp2px(i3);
        this.mSlideThreshold = dp2px;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setSlideThreshold(dp2px);
        }
    }

    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        float f16 = i3;
        this.mSlideStorkWidthDp = f16;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setStrokeWidth(Utils.dp2px(f16));
        }
    }

    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.mEnableShowStorke = z16;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setEnableShowStroke(z16);
        }
    }

    public void setSlideDirection(@SlideGestureViewHelper.SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        this.mSlideDirection = i3;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setSlideDirection(i3);
        }
    }

    public void setSlideInteractiveListener(InsideSlideInteractiveListener insideSlideInteractiveListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) insideSlideInteractiveListener);
        } else {
            this.mSlideInteractiveListener = insideSlideInteractiveListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mIsStarted = true;
        initLayer();
        super.startAnimation();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mIsStarted = false;
            super.stopAnimation();
        }
    }
}
