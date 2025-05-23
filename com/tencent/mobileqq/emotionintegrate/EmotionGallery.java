package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionGallery extends DragGallery {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private a f205162h;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void F0();

        void onScaleEnd(float f16);

        void x5(float f16);
    }

    public EmotionGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public float G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        View view = this.mSelectedChild;
        if (view != null) {
            return super.getChildScale(view);
        }
        return 1.0f;
    }

    @Override // com.tencent.widget.Gallery
    protected float customScale(View view, float f16, int i3) {
        float min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, this, view, Float.valueOf(f16), Integer.valueOf(i3))).floatValue();
        }
        float f17 = getResources().getDisplayMetrics().density * 135.0f * 1.5f;
        float f18 = i3;
        if (f18 > f17) {
            min = f17 / f18;
        } else {
            min = Math.min(1.5f, f17 / f18);
        }
        setMaxScale(ScreenUtil.SCREEN_WIDTH / f18);
        return min;
    }

    @Override // com.tencent.mobileqq.activity.photo.ProGallery, com.tencent.widget.Gallery, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f205162h != null) {
            this.f205162h.x5(G());
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // com.tencent.widget.Gallery, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        a aVar = this.f205162h;
        if (aVar != null) {
            aVar.F0();
        }
        return super.onScaleBegin(scaleGestureDetector);
    }

    @Override // com.tencent.widget.Gallery, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) scaleGestureDetector);
            return;
        }
        if (this.f205162h != null) {
            this.f205162h.onScaleEnd(G());
        }
        super.onScaleEnd(scaleGestureDetector);
    }

    public void setOnScaleChangeListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f205162h = aVar;
        }
    }

    @Override // android.view.View
    public void setScaleX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        if (!Float.isNaN(f16) && !Float.isInfinite(f16)) {
            try {
                super.setScaleX(f16);
            } catch (Throwable th5) {
                QLog.w("EmotionGallery", 1, "[setScaleX] error. stack=", th5);
            }
        }
    }

    @Override // android.view.View
    public void setScaleY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        if (!Float.isNaN(f16) && !Float.isInfinite(f16)) {
            try {
                super.setScaleY(f16);
            } catch (Throwable th5) {
                QLog.w("EmotionGallery", 1, "[setScaleY] error. stack=", th5);
            }
        }
    }
}
