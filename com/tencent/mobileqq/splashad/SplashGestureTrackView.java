package com.tencent.mobileqq.splashad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SplashGestureTrackView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private n f288741d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f288742e;

    /* renamed from: f, reason: collision with root package name */
    private Path f288743f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f288744h;

    /* renamed from: i, reason: collision with root package name */
    private float f288745i;

    /* renamed from: m, reason: collision with root package name */
    private float f288746m;

    public SplashGestureTrackView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f288743f = new Path();
        this.f288744h = new Paint();
        a();
    }

    private void a() {
        this.f288744h.setStyle(Paint.Style.STROKE);
        this.f288744h.setColor(-1);
        this.f288744h.setStrokeWidth(ViewUtils.dpToPx(8.0f));
        this.f288744h.setAntiAlias(true);
        this.f288744h.setStrokeJoin(Paint.Join.ROUND);
    }

    private void b(MotionEvent motionEvent) {
        this.f288743f.reset();
        n nVar = this.f288741d;
        if (nVar != null) {
            nVar.a(this.f288745i, this.f288746m, motionEvent.getX(), motionEvent.getY());
        }
        if (this.f288742e) {
            invalidate();
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f288742e = z16;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        if (this.f288742e) {
            canvas.drawPath(this.f288743f, this.f288744h);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r0 != 3) goto L26;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f288741d == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f288743f.lineTo(motionEvent.getX(), motionEvent.getY());
                    if (this.f288742e) {
                        invalidate();
                    }
                }
            }
            b(motionEvent);
        } else {
            this.f288743f.moveTo(motionEvent.getX(), motionEvent.getY());
            this.f288745i = motionEvent.getX();
            this.f288746m = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    public void setTrackListener(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) nVar);
        } else {
            this.f288741d = nVar;
        }
    }

    public SplashGestureTrackView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f288743f = new Path();
        this.f288744h = new Paint();
        a();
    }

    public SplashGestureTrackView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f288743f = new Path();
        this.f288744h = new Paint();
        a();
    }
}
