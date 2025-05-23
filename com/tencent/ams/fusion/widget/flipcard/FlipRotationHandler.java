package com.tencent.ams.fusion.widget.flipcard;

import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipRotationHandler implements RotationSensor.OnRotationChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final float ROTATION_START_THRESHOLD = 5.0f;

    @FlipScreenOrientation
    private int mFlipScreenOrientation;
    private boolean mIsEnabled;
    private boolean mIsFinished;
    private boolean mIsReverseFromNegative;
    private boolean mIsReverseRotationStarted;
    private boolean mIsRotationStarted;
    private float mMaxAngle;
    private float mReverseRotationThreshold;
    private IFlipRotationListener mRotationListener;
    private float mTargetRotationThreshold;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface FlipScreenOrientation {
        public static final int FLIP_ORIENTATION_LANDSCAPE = 1;
        public static final int FLIP_ORIENTATION_PORTRAIT = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IFlipRotationListener {
        void onError();

        void onFlipBackInteractProgress(float f16, float f17);

        void onFlipBackInteractStart();

        void onFlipInteractFinish(boolean z16, boolean z17);

        void onFlipInteractProgress(float f16, float f17);

        void onFlipInteractStart();

        void onRotationChanged(float f16, boolean z16);
    }

    public FlipRotationHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTargetRotationThreshold = 0.0f;
        this.mReverseRotationThreshold = 0.0f;
        this.mIsEnabled = true;
        this.mMaxAngle = 0.0f;
        this.mIsRotationStarted = false;
        this.mIsReverseRotationStarted = false;
        this.mIsFinished = false;
        this.mFlipScreenOrientation = 2;
    }

    private void callbackFinish(boolean z16, boolean z17) {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = true;
        IFlipRotationListener iFlipRotationListener = this.mRotationListener;
        if (iFlipRotationListener != null) {
            iFlipRotationListener.onFlipInteractFinish(z16, z17);
        }
    }

    private float getAbsRotation(float f16, float f17) {
        if (this.mFlipScreenOrientation == 2) {
            return f17;
        }
        return f16;
    }

    public float getMaxAngle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.mMaxAngle;
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
        float f19;
        float f26;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        if (!this.mIsEnabled) {
            return;
        }
        float abs = Math.abs(getAbsRotation(f16, f17));
        if (abs > this.mMaxAngle) {
            this.mMaxAngle = abs;
        }
        IFlipRotationListener iFlipRotationListener = this.mRotationListener;
        if (iFlipRotationListener != null) {
            iFlipRotationListener.onRotationChanged(f17, this.mIsReverseRotationStarted);
        }
        if (abs > 5.0f || this.mIsRotationStarted) {
            if (!this.mIsRotationStarted) {
                this.mIsRotationStarted = true;
                IFlipRotationListener iFlipRotationListener2 = this.mRotationListener;
                if (iFlipRotationListener2 != null) {
                    iFlipRotationListener2.onFlipInteractStart();
                }
            }
            if (!this.mIsReverseRotationStarted && this.mRotationListener != null) {
                this.mRotationListener.onFlipInteractProgress(f17, Math.max(Math.min(f17 / this.mTargetRotationThreshold, 1.0f), -1.0f));
            }
        }
        if (abs >= this.mTargetRotationThreshold && !this.mIsFinished) {
            if (this.mReverseRotationThreshold <= 0.0f) {
                if (f17 < 0.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                callbackFinish(true, z17);
            } else if (!this.mIsReverseRotationStarted) {
                this.mIsReverseRotationStarted = true;
                if (f17 < 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.mIsReverseFromNegative = z16;
                IFlipRotationListener iFlipRotationListener3 = this.mRotationListener;
                if (iFlipRotationListener3 != null) {
                    iFlipRotationListener3.onFlipBackInteractStart();
                }
            }
        }
        if (this.mIsReverseRotationStarted) {
            float f27 = this.mReverseRotationThreshold;
            if (f27 > 0.0f && !this.mIsFinished) {
                boolean z19 = this.mIsReverseFromNegative;
                float f28 = this.mMaxAngle;
                if (z19) {
                    f19 = f28 + f17;
                } else {
                    f19 = f28 - f17;
                }
                if (z19) {
                    f26 = f19 - f27;
                } else {
                    f26 = f27 - f19;
                }
                float f29 = f26 / f27;
                if (f19 >= f27) {
                    z18 = true;
                }
                if (z18) {
                    IFlipRotationListener iFlipRotationListener4 = this.mRotationListener;
                    if (iFlipRotationListener4 != null) {
                        iFlipRotationListener4.onFlipBackInteractProgress(f17, 0.0f);
                    }
                    callbackFinish(true, !this.mIsReverseFromNegative);
                    return;
                }
                IFlipRotationListener iFlipRotationListener5 = this.mRotationListener;
                if (iFlipRotationListener5 != null) {
                    iFlipRotationListener5.onFlipBackInteractProgress(f17, f29);
                }
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IFlipRotationListener iFlipRotationListener = this.mRotationListener;
        if (iFlipRotationListener != null) {
            iFlipRotationListener.onError();
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mIsFinished = false;
        this.mIsReverseRotationStarted = false;
        this.mIsRotationStarted = false;
        this.mIsReverseFromNegative = false;
        this.mMaxAngle = 0.0f;
    }

    public void setFlipScreenOrientation(@FlipScreenOrientation int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mFlipScreenOrientation = i3;
        }
    }

    public void setIsEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mIsEnabled = z16;
        }
    }

    public void setReverseRotationThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mReverseRotationThreshold = f16;
        }
    }

    public void setRotationListener(IFlipRotationListener iFlipRotationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iFlipRotationListener);
        } else {
            this.mRotationListener = iFlipRotationListener;
        }
    }

    public void setTargetRotationThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mTargetRotationThreshold = f16;
        }
    }
}
