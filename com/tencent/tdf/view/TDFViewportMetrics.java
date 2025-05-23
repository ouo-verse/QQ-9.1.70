package com.tencent.tdf.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFViewportMetrics {
    static IPatchRedirector $redirector_ = null;
    public static final int ZERO_SIDES_BOTH = 3;
    public static final int ZERO_SIDES_LEFT = 1;
    public static final int ZERO_SIDES_NONE = 0;
    public static final int ZERO_SIDES_RIGHT = 2;
    public double devicePixelRatio;
    public int height;
    public int leftFromWindow;
    public int systemGestureInsetBottom;
    public int systemGestureInsetLeft;
    public int systemGestureInsetRight;
    public int systemGestureInsetTop;
    public int topFromWindow;
    public int viewInsetBottom;
    public int viewInsetLeft;
    public int viewInsetRight;
    public int viewInsetTop;
    public int viewPaddingBottom;
    public int viewPaddingLeft;
    public int viewPaddingRight;
    public int viewPaddingTop;
    public int width;

    public TDFViewportMetrics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.leftFromWindow = 0;
        this.topFromWindow = 0;
        this.width = 0;
        this.height = 0;
        this.viewInsetLeft = 0;
        this.viewInsetTop = 0;
        this.viewInsetRight = 0;
        this.viewInsetBottom = 0;
        this.viewPaddingLeft = 0;
        this.viewPaddingTop = 0;
        this.viewPaddingRight = 0;
        this.viewPaddingBottom = 0;
        this.systemGestureInsetLeft = 0;
        this.systemGestureInsetTop = 0;
        this.systemGestureInsetRight = 0;
        this.systemGestureInsetBottom = 0;
        this.devicePixelRatio = 1.0d;
    }
}
