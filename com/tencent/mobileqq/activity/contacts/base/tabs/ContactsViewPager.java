package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class ContactsViewPager extends ViewPager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f181527d;

    /* renamed from: e, reason: collision with root package name */
    private int f181528e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f181529f;

    /* renamed from: h, reason: collision with root package name */
    private HeaderScrollView f181530h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f181531i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f181532m;

    public ContactsViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f181530h = null;
        this.f181531i = false;
        this.f181532m = false;
    }

    private boolean a() {
        if (!this.f181531i && this.f181530h == null) {
            this.f181531i = true;
            Object parent = getParent();
            while (parent != null && this.f181530h == null) {
                if (parent instanceof HeaderScrollView) {
                    this.f181530h = (HeaderScrollView) parent;
                } else if (parent instanceof View) {
                    parent = ((View) parent).getParent();
                } else {
                    parent = null;
                }
            }
        }
        HeaderScrollView headerScrollView = this.f181530h;
        if (headerScrollView != null) {
            return headerScrollView.T;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onAttachedToWindow();
            QLog.d("ContactsViewPager", 1, "onAttachedToWindow ", Integer.valueOf(hashCode()), " ", getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDetachedFromWindow();
            QLog.d("ContactsViewPager", 1, "onDetachedFromWindow ", Integer.valueOf(hashCode()), " ", getContext());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        boolean z17 = true;
        if (action == 0) {
            this.f181527d = (int) (motionEvent.getX() + 0.5f);
            this.f181528e = (int) (motionEvent.getY() + 0.5f);
            this.f181529f = true;
            this.f181532m = false;
            FrameHelperActivity.gj(false, "ContactsViewPager_onInterceptTouchEvent_MotionEvent.ACTION_DOWN");
        } else {
            if (action == 2) {
                int x16 = (int) (motionEvent.getX() + 0.5f);
                int y16 = (int) (motionEvent.getY() + 0.5f);
                int abs = Math.abs(x16 - this.f181527d);
                int abs2 = Math.abs(y16 - this.f181528e);
                int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                if (this.f181529f && abs > scaledTouchSlop) {
                    if (abs * 0.5f > abs2 && this.f181527d > ((int) (ScreenUtil.SCREEN_WIDTH * 0.1f))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        FrameHelperActivity.gj(true, "ContactsViewPager_onInterceptTouchEvent_MotionEvent_MotionEvent.ACTION_MOVE");
                    }
                    this.f181529f = false;
                } else {
                    z16 = false;
                }
                if (a()) {
                    this.f181532m = true;
                    return false;
                }
                if (this.f181532m && abs > scaledTouchSlop * 3) {
                    return false;
                }
                if (!z16) {
                    try {
                        if (!super.onInterceptTouchEvent(motionEvent)) {
                            z17 = false;
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return z17;
            }
            if (action == 1 || action == 3) {
                FrameHelperActivity.gj(true, "ContactsViewPager_onInterceptTouchEvent_MotionEvent_MotionEvent_ACTION_UP");
                this.f181529f = false;
                this.f181532m = false;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return z17;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            FrameHelperActivity.gj(false, "ContactsViewPager_onTouchEvent_MotionEvent.ACTION_DOWN");
        } else if (action != 1 && action != 3) {
            if (action == 2) {
                FrameHelperActivity.gj(true, "ContactsViewPager_onTouchEvent_MotionEvent.ACTION_UP");
            }
        } else {
            FrameHelperActivity.gj(true, "ContactsViewPager_onTouchEvent_MotionEvent.ACTION_UP");
            this.f181529f = false;
            this.f181532m = false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public ContactsViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f181530h = null;
        this.f181531i = false;
        this.f181532m = false;
    }
}
