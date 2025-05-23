package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicfaceContainerView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    boolean f243519d;

    /* renamed from: e, reason: collision with root package name */
    b f243520e;

    /* renamed from: f, reason: collision with root package name */
    GestureDetector.SimpleOnGestureListener f243521f;

    /* renamed from: h, reason: collision with root package name */
    GestureDetector f243522h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MagicfaceContainerView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            b bVar = MagicfaceContainerView.this.f243520e;
            if (bVar != null) {
                bVar.a(5);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (motionEvent.getX() - motionEvent2.getX() > 150.0f) {
                b bVar2 = MagicfaceContainerView.this.f243520e;
                if (bVar2 != null) {
                    bVar2.a(0);
                }
            } else if (motionEvent.getX() - motionEvent2.getX() < -150.0f) {
                b bVar3 = MagicfaceContainerView.this.f243520e;
                if (bVar3 != null) {
                    bVar3.a(1);
                }
            } else if (motionEvent.getY() - motionEvent2.getY() > 150.0f) {
                b bVar4 = MagicfaceContainerView.this.f243520e;
                if (bVar4 != null) {
                    bVar4.a(2);
                }
            } else if (motionEvent.getY() - motionEvent2.getY() < -150.0f && (bVar = MagicfaceContainerView.this.f243520e) != null) {
                bVar.a(3);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            b bVar = MagicfaceContainerView.this.f243520e;
            if (bVar != null) {
                bVar.a(4);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        boolean a(int i3);
    }

    public MagicfaceContainerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.f243519d = false;
            this.f243521f = new a();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f243519d) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f243519d) {
            this.f243522h.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMagicfaceGestureListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f243520e = bVar;
        }
    }

    public void setTouchEffect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f243519d = z16;
        }
    }

    public MagicfaceContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243519d = false;
        this.f243521f = new a();
        this.f243522h = new GestureDetector(this.f243521f);
    }
}
