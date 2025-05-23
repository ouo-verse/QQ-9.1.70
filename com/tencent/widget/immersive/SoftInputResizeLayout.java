package com.tencent.widget.immersive;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SoftInputResizeLayout {
    static IPatchRedirector $redirector_;
    private FrameLayout.LayoutParams frameLayoutParams;
    Activity mAactivity;
    private View mChildOfContent;
    private int usableHeightPrevious;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoftInputResizeLayout.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SoftInputResizeLayout.this.possiblyResizeChildOfContent();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    SoftInputResizeLayout(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.mChildOfContent = childAt;
        this.mAactivity = activity;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    public static void assistActivity(Activity activity) {
        new SoftInputResizeLayout(activity);
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        int computeUsableHeight = computeUsableHeight();
        if (computeUsableHeight != this.usableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            int i3 = height - computeUsableHeight;
            if (i3 > height / 4) {
                this.frameLayoutParams.height = (height - i3) + ImmersiveUtils.getStatusBarHeight(this.mAactivity);
            } else {
                this.frameLayoutParams.height = height;
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = computeUsableHeight;
        }
    }
}
