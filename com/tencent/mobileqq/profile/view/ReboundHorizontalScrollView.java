package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes16.dex */
public class ReboundHorizontalScrollView extends HorizontalScrollView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f260421d;

    /* renamed from: e, reason: collision with root package name */
    private int f260422e;

    public ReboundHorizontalScrollView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f260421d = context;
            a();
        }
    }

    private void a() {
        setFadingEdgeLength(0);
        this.f260422e = (int) (this.f260421d.getResources().getDisplayMetrics().density * 200.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @TargetApi(9)
    protected boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16))).booleanValue();
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, this.f260422e, i28, z16);
    }

    public void setOverScrollDistance(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f260422e = i3;
        }
    }

    public ReboundHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f260421d = context;
            a();
        }
    }

    public ReboundHorizontalScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f260421d = context;
            a();
        }
    }
}
