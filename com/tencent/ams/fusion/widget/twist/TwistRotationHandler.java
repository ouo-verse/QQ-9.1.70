package com.tencent.ams.fusion.widget.twist;

import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public class TwistRotationHandler implements RotationSensor.OnRotationChangeListener {
    static IPatchRedirector $redirector_ = null;
    protected static final float ROTATION_START_THRESHOLD = 5.0f;
    protected TwistCallback mCallback;
    private int mDirection;
    private boolean mHasNotifyRotationZero;
    protected int mInteractSuccessDirection;
    protected boolean mIsInteractSuccess;
    protected boolean mIsReverseInteractStart;
    protected boolean mIsRotationStarted;
    protected float mMaxAngle;
    protected float mReverseAngle;
    protected float mTargetAngle;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface TwistCallback {
        void onBackInteractProgress(float f16, int i3);

        void onInteractProgress(float f16, int i3);

        void onInteractStart();

        void onInteractSuccess();
    }

    public TwistRotationHandler(TwistCallback twistCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) twistCallback);
            return;
        }
        this.mMaxAngle = 0.0f;
        this.mReverseAngle = 0.0f;
        this.mDirection = 0;
        this.mTargetAngle = 90.0f;
        this.mCallback = twistCallback;
    }

    private boolean checkNotify(float f16) {
        if (this.mIsReverseInteractStart) {
            return true;
        }
        if (f16 != 0.0f) {
            this.mHasNotifyRotationZero = false;
            return true;
        }
        if (this.mHasNotifyRotationZero) {
            return false;
        }
        this.mHasNotifyRotationZero = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callbackInteractSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        TwistCallback twistCallback = this.mCallback;
        if (twistCallback != null) {
            twistCallback.onInteractSuccess();
            this.mIsInteractSuccess = true;
        }
    }

    protected void checkAndDispatchProgress(float f16, float f17) {
        boolean z16;
        float reverseRotation;
        TwistCallback twistCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (Math.abs(f16) >= 5.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.mIsRotationStarted) {
            return;
        }
        if (z16 && !this.mIsRotationStarted) {
            TwistCallback twistCallback2 = this.mCallback;
            if (twistCallback2 != null) {
                twistCallback2.onInteractStart();
            }
            this.mIsRotationStarted = true;
        }
        this.mMaxAngle = Math.max(this.mMaxAngle, Math.abs(f17));
        float f18 = this.mTargetAngle;
        if (f16 > f18) {
            f16 = f18;
        } else if (f16 < (-f18)) {
            f16 = -f18;
        }
        int abs = (int) ((Math.abs(f16) * 100.0f) / this.mTargetAngle);
        if (!this.mIsReverseInteractStart && (twistCallback = this.mCallback) != null) {
            twistCallback.onInteractProgress(f16, abs);
        }
        if (abs == 100 && !this.mIsInteractSuccess) {
            if (this.mReverseAngle == 0.0f) {
                callbackInteractSuccess();
                return;
            } else if (!this.mIsReverseInteractStart) {
                this.mIsReverseInteractStart = true;
                if (f17 > 0.0f) {
                    i3 = 1;
                }
                this.mInteractSuccessDirection = i3;
            }
        }
        if (this.mIsReverseInteractStart && this.mReverseAngle > 0.0f && !this.mIsInteractSuccess) {
            int reverseProgress = getReverseProgress(f17);
            if (this.mInteractSuccessDirection == 0) {
                reverseRotation = getReverseRotation(f17) - this.mReverseAngle;
            } else {
                reverseRotation = this.mReverseAngle - getReverseRotation(f17);
            }
            TwistCallback twistCallback3 = this.mCallback;
            if (twistCallback3 != null) {
                twistCallback3.onBackInteractProgress(reverseRotation, 100 - reverseProgress);
            }
            if (reverseProgress >= 100) {
                callbackInteractSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReverseProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16))).intValue();
        }
        float f17 = this.mReverseAngle;
        if (f17 == 0.0f) {
            return 0;
        }
        return (int) ((Math.abs(getReverseRotation(f16)) * 100) / f17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReverseRotation(float f16) {
        float f17;
        float min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16))).intValue();
        }
        if (this.mInteractSuccessDirection == 0) {
            f17 = -this.mMaxAngle;
            min = Math.max(f16, f17);
        } else {
            f17 = this.mMaxAngle;
            min = Math.min(f16, f17);
        }
        return (int) (f17 - min);
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        int i3 = this.mDirection;
        if (i3 == 1) {
            float max = Math.max(f18, 0.0f);
            if (checkNotify(max)) {
                checkAndDispatchProgress(max, f18);
                return;
            }
            return;
        }
        if (i3 == 0) {
            float min = Math.min(f18, 0.0f);
            if (checkNotify(min)) {
                checkAndDispatchProgress(min, f18);
                return;
            }
            return;
        }
        if (i3 == 2) {
            checkAndDispatchProgress(f18, f18);
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mIsRotationStarted = false;
        this.mIsInteractSuccess = false;
        this.mIsReverseInteractStart = false;
        this.mMaxAngle = 0.0f;
    }

    public void setDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mDirection = i3;
        }
    }

    public void setReverseAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mReverseAngle = f16;
        }
    }

    public void setTargetAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mTargetAngle = f16;
        }
    }
}
