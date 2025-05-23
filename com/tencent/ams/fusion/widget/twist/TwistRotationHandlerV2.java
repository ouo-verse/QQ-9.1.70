package com.tencent.ams.fusion.widget.twist;

import com.tencent.ams.fusion.widget.twist.TwistRotationHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwistRotationHandlerV2 extends TwistRotationHandler {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface TwistCallbackV2 extends TwistRotationHandler.TwistCallback {
        void onBackInteractStart();

        void onSensorError();
    }

    public TwistRotationHandlerV2(TwistRotationHandler.TwistCallback twistCallback) {
        super(twistCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) twistCallback);
        }
    }

    private void callbackBackInteractStart() {
        TwistRotationHandler.TwistCallback twistCallback = this.mCallback;
        if (twistCallback instanceof TwistCallbackV2) {
            ((TwistCallbackV2) twistCallback).onBackInteractStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler
    protected void checkAndDispatchProgress(float f16, float f17) {
        boolean z16;
        float reverseRotation;
        TwistRotationHandler.TwistCallback twistCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17));
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
            TwistRotationHandler.TwistCallback twistCallback2 = this.mCallback;
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
                if (f17 > 0.0f) {
                    i3 = 1;
                }
                this.mInteractSuccessDirection = i3;
                callbackInteractSuccess();
                return;
            }
            if (!this.mIsReverseInteractStart) {
                this.mIsReverseInteractStart = true;
                if (f17 > 0.0f) {
                    i3 = 1;
                }
                this.mInteractSuccessDirection = i3;
                callbackBackInteractStart();
            }
        }
        if (this.mIsReverseInteractStart && this.mReverseAngle > 0.0f && !this.mIsInteractSuccess) {
            int reverseProgress = getReverseProgress(f17);
            if (this.mInteractSuccessDirection == 0) {
                reverseRotation = getReverseRotation(f17) - this.mReverseAngle;
            } else {
                reverseRotation = this.mReverseAngle - getReverseRotation(f17);
            }
            TwistRotationHandler.TwistCallback twistCallback3 = this.mCallback;
            if (twistCallback3 != null) {
                twistCallback3.onBackInteractProgress(reverseRotation, 100 - reverseProgress);
            }
            if (reverseProgress >= 100) {
                callbackInteractSuccess();
            }
        }
    }

    public int getInteractSuccessDirection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mInteractSuccessDirection;
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler, com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        TwistRotationHandler.TwistCallback twistCallback = this.mCallback;
        if (twistCallback instanceof TwistCallbackV2) {
            ((TwistCallbackV2) twistCallback).onSensorError();
        }
    }
}
