package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlingGestureHandler extends FlingHandler implements TopGestureLayout.OnGestureListener {
    static IPatchRedirector $redirector_;
    private View mInnerView;
    public TopGestureLayout mTopLayout;

    public FlingGestureHandler(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        }
    }

    private ViewGroup getDecorView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (FlingHelperUtils.utils.isDragFrameLayoutClass(childAt)) {
            return (ViewGroup) childAt;
        }
        return viewGroup;
    }

    public void flingLToR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Activity activity = this.mWrappedActivity.get();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public void flingRToL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    public boolean isWrapped() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        TopGestureLayout topGestureLayout = this.mTopLayout;
        if (topGestureLayout != null && topGestureLayout.getParent() != null && (view = this.mInnerView) != null && view.getParent() == this.mTopLayout) {
            return true;
        }
        return false;
    }

    public void setTopLayout(TopGestureLayout topGestureLayout) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) topGestureLayout);
            return;
        }
        if ((!canWrapContent() && topGestureLayout == null) || (activity = this.mWrappedActivity.get()) == null) {
            return;
        }
        if (isWrapped()) {
            unwrap();
            this.mInnerView = getDecorView(activity).getChildAt(0);
            this.mTopLayout = topGestureLayout;
            if (topGestureLayout != null) {
                topGestureLayout.setOnFlingGesture(this);
            }
            wrap();
            return;
        }
        this.mInnerView = getDecorView(activity).getChildAt(0);
        this.mTopLayout = topGestureLayout;
        if (topGestureLayout != null) {
            topGestureLayout.setOnFlingGesture(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    protected void unwrap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Activity activity = this.mWrappedActivity.get();
        if (activity == null) {
            return;
        }
        ViewGroup decorView = getDecorView(activity);
        if (isWrapped() && this.mTopLayout.getParent().equals(decorView)) {
            decorView.removeView(this.mTopLayout);
            if (this.mInnerView.getParent().equals(this.mTopLayout)) {
                this.mTopLayout.removeView(this.mInnerView);
                decorView.addView(this.mInnerView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    public void wrap() {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!canWrapContent() || (activity = this.mWrappedActivity.get()) == null) {
            return;
        }
        ViewGroup decorView = getDecorView(activity);
        if (this.mTopLayout == null) {
            View childAt = decorView.getChildAt(0);
            this.mInnerView = childAt;
            if (childAt == null) {
                return;
            }
            TopGestureLayout topGestureLayout = new TopGestureLayout(activity);
            this.mTopLayout = topGestureLayout;
            topGestureLayout.setOnFlingGesture(this);
            decorView.addView(topGestureLayout);
            if (childAt.getParent() != null) {
                ((ViewGroup) childAt.getParent()).removeView(childAt);
                topGestureLayout.addView(childAt);
                return;
            }
            return;
        }
        if (!isWrapped()) {
            TopGestureLayout topGestureLayout2 = this.mTopLayout;
            if (topGestureLayout2 != null && topGestureLayout2.getParent() != null) {
                ((ViewGroup) this.mTopLayout.getParent()).removeView(this.mTopLayout);
            }
            decorView.addView(this.mTopLayout);
            View view = this.mInnerView;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.mInnerView.getParent()).removeView(this.mInnerView);
            }
            try {
                this.mTopLayout.addView(this.mInnerView);
            } catch (Exception e16) {
                QLog.e("FlingGestureHandler", 1, e16, new Object[0]);
            }
        }
    }
}
