package com.tencent.mobileqq.ocr.view.gesture.control;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public void a(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) matrix);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public void b(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onDoubleTap(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public void onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 13, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public void onLongPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 8, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }
}
