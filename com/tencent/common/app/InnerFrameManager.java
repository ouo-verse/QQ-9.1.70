package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class InnerFrameManager extends ViewFlipper implements ViewStub.OnInflateListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public Activity f99519d;

    /* renamed from: e, reason: collision with root package name */
    private BaseQQAppInterface f99520e;

    /* renamed from: f, reason: collision with root package name */
    private Set<InnerFrame> f99521f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f99522h;

    /* renamed from: i, reason: collision with root package name */
    private Bundle f99523i;

    public InnerFrameManager(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void a(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        Iterator<InnerFrame> it = this.f99521f.iterator();
        while (it.hasNext()) {
            it.next().i(i3, i16, intent);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return getDisplayedChild() - 1;
    }

    public void c(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        this.f99519d = activity;
        int childCount = getChildCount();
        for (int i3 = 1; i3 < childCount; i3++) {
            ((ViewStub) getChildAt(i3)).setOnInflateListener(this);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<InnerFrame> it = this.f99521f.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f99522h = false;
            ((InnerFrame) getChildAt(getDisplayedChild())).k();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f99522h = true;
            ((InnerFrame) getChildAt(getDisplayedChild())).l();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<InnerFrame> it = this.f99521f.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void h(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        int i16 = i3 + 1;
        if (getDisplayedChild() == i16) {
            return;
        }
        if (this.f99522h) {
            ((InnerFrame) getChildAt(getDisplayedChild())).k();
        }
        ((InnerFrame) getChildAt(getDisplayedChild())).onStop();
        getChildAt(i16).setVisibility(0);
        if (z16) {
            if (getDisplayedChild() != 0) {
                if (getDisplayedChild() < i16) {
                    setInAnimation(this.f99519d, R.anim.f154564bc);
                    setOutAnimation(this.f99519d, R.anim.f154565bd);
                } else {
                    setInAnimation(this.f99519d, R.anim.f154561b9);
                    setOutAnimation(this.f99519d, R.anim.b_);
                }
            }
        } else {
            setInAnimation(this.f99519d, R.anim.f154740cc);
            setOutAnimation(this.f99519d, R.anim.f154740cc);
        }
        setDisplayedChild(i16);
        ((InnerFrame) getChildAt(i16)).m(this.f99523i);
        if (this.f99522h) {
            ((InnerFrame) getChildAt(i16)).l();
        }
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f99523i = null;
            h(i3, true);
        }
    }

    public void j(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) bundle);
        } else {
            this.f99523i = bundle;
            h(i3, true);
        }
    }

    @Override // android.view.ViewStub.OnInflateListener
    public void onInflate(ViewStub viewStub, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) viewStub, (Object) view);
            return;
        }
        InnerFrame innerFrame = (InnerFrame) view;
        this.f99521f.add(innerFrame);
        innerFrame.setActivity(this.f99519d);
        innerFrame.setInnerFrameManager(this);
        innerFrame.setAppIntf(this.f99520e);
        innerFrame.j(this.f99523i);
    }

    public void setAppIntf(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.f99520e = baseQQAppInterface;
        Iterator<InnerFrame> it = this.f99521f.iterator();
        while (it.hasNext()) {
            it.next().setAppIntf(baseQQAppInterface);
        }
    }

    public InnerFrameManager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f99519d = null;
        this.f99520e = null;
        this.f99521f = new HashSet();
        this.f99522h = false;
        InnerFrame innerFrame = new InnerFrame(context);
        innerFrame.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(innerFrame, 0);
    }
}
