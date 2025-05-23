package com.tencent.mobileqq.webview.swift.utils;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View f314734a;

    /* renamed from: b, reason: collision with root package name */
    private int f314735b;

    /* renamed from: c, reason: collision with root package name */
    private int f314736c;

    /* renamed from: d, reason: collision with root package name */
    private int f314737d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout.LayoutParams f314738e;

    b(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        if (frameLayout != null) {
            View childAt = frameLayout.getChildAt(0);
            this.f314734a = childAt;
            if (childAt != null) {
                childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.webview.swift.utils.a
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        b.this.e();
                    }
                });
                this.f314738e = (FrameLayout.LayoutParams) this.f314734a.getLayoutParams();
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null && ((Integer) com.tencent.mobileqq.webview.util.t.j().b("tbs_core_version", 0)).intValue() <= 0) {
            QLog.i("WebLog_AndroidBug5497Workaround", 1, "AndroidBug5497Workaround in sys core for: " + activity.getComponentName().getClassName());
            new b(activity);
        }
    }

    private int c(int i3) {
        Rect rect = new Rect();
        this.f314734a.getWindowVisibleDisplayFrame(rect);
        if (QLog.isDevelopLevel()) {
            QLog.d("WebLog_AndroidBug5497Workaround", 1, "computeBottomSysBarHeight: " + rect.toShortString() + ", rootHeight=" + i3);
        }
        int i16 = rect.bottom;
        if (i16 < i3) {
            return i3 - i16;
        }
        return 0;
    }

    private int d() {
        Rect rect = new Rect();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        this.f314734a.getWindowVisibleDisplayFrame(rect);
        if (QLog.isDebugVersion()) {
            QLog.d("WebLog_AndroidBug5497Workaround", 1, "computeUsableHeight: " + rect.toShortString() + ", statusBarHeight: " + statusBarHeight);
        }
        int i3 = rect.top;
        if (i3 > 0) {
            rect.top = Math.max(i3 - statusBarHeight, 0);
        }
        return rect.bottom - rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void e() {
        int d16 = d();
        if (d16 != this.f314735b) {
            int height = this.f314734a.getRootView().getHeight();
            int height2 = this.f314734a.getHeight();
            if (QLog.isDevelopLevel()) {
                QLog.d("WebLog_AndroidBug5497Workaround", 1, "possiblyResizeChildOfContent rootHeightNow:" + height + " childHeightNow:" + height2 + " windowNow:" + d16 + " usablePrevious:" + this.f314735b + " bottomSysBarHeight=" + this.f314736c);
            }
            if (height - d16 > height / 4) {
                this.f314738e.height = d16;
            } else {
                if (height != this.f314737d) {
                    this.f314736c = c(height);
                    this.f314737d = height;
                }
                this.f314738e.height = height - this.f314736c;
            }
            this.f314734a.requestLayout();
            this.f314735b = d16;
        }
    }
}
