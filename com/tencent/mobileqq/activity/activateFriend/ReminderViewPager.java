package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class ReminderViewPager extends ViewPager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f177921d;

    /* renamed from: e, reason: collision with root package name */
    private int f177922e;

    public ReminderViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f177921d = -1;
            this.f177922e = -1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    if (Math.abs(rawX - this.f177921d) + 0 >= Math.abs(rawY - this.f177922e) + 0) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    this.f177921d = rawX;
                    this.f177922e = rawY;
                }
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public ReminderViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f177921d = -1;
            this.f177922e = -1;
        }
    }
}
