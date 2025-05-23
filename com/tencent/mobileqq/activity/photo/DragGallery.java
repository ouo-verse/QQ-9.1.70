package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DragGallery extends ProGallery {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private MotionEvent f183964f;

    public DragGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    @Override // com.tencent.widget.Gallery
    protected void disPatchToParent() {
        float abs;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (Math.abs(this.scrollX) == 0) {
            abs = 999.0f;
        } else {
            abs = Math.abs(this.scrollY) / Math.abs(this.scrollX);
        }
        if (QLog.isColorLevel()) {
            QLog.d("DragGallery", 2, "scrollY : " + Math.abs(this.scrollY) + " scrollX : " + Math.abs(this.scrollX) + " ratio : " + abs);
        }
        int i3 = this.mScrollState;
        if ((i3 == 1 || i3 == -1) && abs >= 6.0f && this.scrollX < 10) {
            getParent().requestDisallowInterceptTouchEvent(false);
            Gallery.OnScollListener onScollListener = this.mOnScollListener;
            if (onScollListener != null) {
                onScollListener.onScrollEnd(this.mSelectedPosition);
            }
        }
    }

    @Override // com.tencent.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onDown(motionEvent);
    }

    @Override // com.tencent.widget.Gallery, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.f183964f = motionEvent;
        return super.onSingleTapConfirmed(motionEvent);
    }
}
