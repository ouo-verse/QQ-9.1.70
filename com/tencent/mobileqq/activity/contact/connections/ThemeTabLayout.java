package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ThemeTabLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ConnectionsTabLayout f181242d;

    /* renamed from: e, reason: collision with root package name */
    private TabThemeMaskView f181243e;

    /* renamed from: f, reason: collision with root package name */
    public float f181244f;

    /* renamed from: h, reason: collision with root package name */
    public float f181245h;

    /* renamed from: i, reason: collision with root package name */
    public float f181246i;

    /* renamed from: m, reason: collision with root package name */
    public float f181247m;

    public ThemeTabLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void a(ArrayList<a> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, i3);
            return;
        }
        ConnectionsTabLayout connectionsTabLayout = this.f181242d;
        if (connectionsTabLayout != null && this.f181243e != null && arrayList != null && i3 >= 0) {
            connectionsTabLayout.W(arrayList, i3);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        View view = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.cbb, (ViewGroup) this, false);
        this.f181242d = (ConnectionsTabLayout) view.findViewById(R.id.le7);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ViewUtils.dip2px(10.0f);
        addView(view, layoutParams);
        this.f181243e = new TabThemeMaskView(getContext());
        addView(this.f181243e, new FrameLayout.LayoutParams(-1, -1));
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f181242d.G();
        }
    }

    public void d(TabLayoutCompat.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
            return;
        }
        ConnectionsTabLayout connectionsTabLayout = this.f181242d;
        if (connectionsTabLayout == null) {
            return;
        }
        connectionsTabLayout.H(cVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                this.f181244f += Math.abs(x16 - this.f181246i);
                float abs = this.f181245h + Math.abs(y16 - this.f181247m);
                this.f181245h = abs;
                this.f181246i = x16;
                this.f181247m = y16;
                if (this.f181244f <= abs) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
        } else {
            this.f181245h = 0.0f;
            this.f181244f = 0.0f;
            this.f181246i = motionEvent.getX();
            this.f181247m = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f181242d.c0(i3);
        }
    }

    public void f(ArrayList<a> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) arrayList, i3);
        } else {
            this.f181242d.d0(arrayList, i3);
        }
    }

    public void setOnTabSelectedListener(TabLayoutCompat.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            return;
        }
        ConnectionsTabLayout connectionsTabLayout = this.f181242d;
        if (connectionsTabLayout != null && this.f181243e != null && cVar != null) {
            connectionsTabLayout.g(cVar);
        }
    }

    public void setScrollPosition(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
            return;
        }
        ConnectionsTabLayout connectionsTabLayout = this.f181242d;
        if (connectionsTabLayout != null) {
            connectionsTabLayout.setScrollX((int) f16);
        }
    }

    public ThemeTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ThemeTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f181242d = null;
            b();
        }
    }
}
