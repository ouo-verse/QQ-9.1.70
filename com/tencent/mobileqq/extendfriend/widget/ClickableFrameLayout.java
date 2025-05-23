package com.tencent.mobileqq.extendfriend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ClickableFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f205571d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f205572e;

    /* renamed from: f, reason: collision with root package name */
    private float f205573f;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void onActionDownTouchEvent(MotionEvent motionEvent);

        void onActionUpTouchEvent(MotionEvent motionEvent);
    }

    public ClickableFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f205572e = true;
            this.f205573f = 1.0f;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f205572e) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    a aVar = this.f205571d;
                    if (aVar != null) {
                        aVar.onActionUpTouchEvent(motionEvent);
                    }
                    setAlpha(1.0f);
                }
            } else {
                a aVar2 = this.f205571d;
                if (aVar2 != null) {
                    aVar2.onActionDownTouchEvent(motionEvent);
                }
                setAlpha(this.f205573f);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setClickAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.f205573f = f16;
        }
    }

    public void setOnDispatchListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f205571d = aVar;
        }
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f205572e = true;
            this.f205573f = 1.0f;
        }
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f205572e = true;
            this.f205573f = 1.0f;
        }
    }
}
