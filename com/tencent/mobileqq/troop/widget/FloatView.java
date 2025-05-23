package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FloatView extends ImageView {
    static IPatchRedirector $redirector_;
    private GestureDetector C;
    private GestureDetector.OnGestureListener D;

    /* renamed from: d, reason: collision with root package name */
    private float f302305d;

    /* renamed from: e, reason: collision with root package name */
    private float f302306e;

    /* renamed from: f, reason: collision with root package name */
    private float f302307f;

    /* renamed from: h, reason: collision with root package name */
    private float f302308h;

    /* renamed from: i, reason: collision with root package name */
    private WindowManager f302309i;

    /* renamed from: m, reason: collision with root package name */
    private WindowManager.LayoutParams f302310m;

    public FloatView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f302309i = (WindowManager) context.getApplicationContext().getSystemService("window");
            this.f302310m = new WindowManager.LayoutParams();
        }
    }

    private void a() {
        WindowManager.LayoutParams layoutParams = this.f302310m;
        layoutParams.x = (int) (this.f302305d - this.f302307f);
        layoutParams.y = (int) (this.f302306e - this.f302308h);
        this.f302309i.updateViewLayout(this, layoutParams);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int i3 = rect.top;
        this.f302305d = motionEvent.getRawX();
        this.f302306e = motionEvent.getRawY() - i3;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    a();
                }
            } else {
                a();
                this.f302308h = 0.0f;
                this.f302307f = 0.0f;
            }
        } else {
            this.f302307f = motionEvent.getX();
            this.f302308h = motionEvent.getY();
        }
        GestureDetector gestureDetector = this.C;
        if (gestureDetector == null) {
            return true;
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public void setOnGestureListener(Context context, GestureDetector.OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) onGestureListener);
        } else {
            this.D = onGestureListener;
            this.C = new GestureDetector(context, onGestureListener);
        }
    }
}
