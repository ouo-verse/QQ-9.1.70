package com.tencent.mobileqq.activity.aio.audiopanel;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final View f178309a;

    /* renamed from: b, reason: collision with root package name */
    private final View f178310b;

    /* renamed from: c, reason: collision with root package name */
    private int f178311c;

    /* renamed from: d, reason: collision with root package name */
    private ViewTreeObserverOnGlobalLayoutListenerC7122a f178312d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.audiopanel.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class ViewTreeObserverOnGlobalLayoutListenerC7122a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<a> f178313d;

        public ViewTreeObserverOnGlobalLayoutListenerC7122a(a aVar) {
            this.f178313d = new WeakReference<>(aVar);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a aVar = this.f178313d.get();
            if (aVar != null) {
                aVar.f();
            } else {
                QLog.i("AndroidBug5497Workaround", 1, "androidBug5497Workaround is null");
            }
        }
    }

    a(Activity activity, View view) {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        View childAt = frameLayout.getChildAt(0);
        this.f178309a = childAt;
        this.f178310b = view;
        QLog.d("AndroidBug5497Workaround", 1, "childCount= " + frameLayout.getChildCount());
        this.f178312d = new ViewTreeObserverOnGlobalLayoutListenerC7122a(this);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(this.f178312d);
    }

    public static a b(Activity activity, View view) {
        QLog.i("AndroidBug5497Workaround", 1, "apply AndroidBug5497Workaround for " + view.getClass().getSimpleName());
        return new a(activity, view);
    }

    private static int c(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.bottom + 0;
    }

    public static int d(Activity activity) {
        int c16 = c(((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0));
        QLog.i("AndroidBug5497Workaround", 1, "fixInitialHeight: " + c16);
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int c16 = c(this.f178309a);
        if (c16 != this.f178311c) {
            QLog.d("AndroidBug5497Workaround", 1, "usableHeightNow = " + c16 + ", previous = " + this.f178311c);
            int height = this.f178309a.getRootView().getHeight();
            int i3 = height - c16;
            if (i3 > height / 4) {
                this.f178310b.getLayoutParams().height = height - i3;
            }
            this.f178310b.getLayoutParams().height = c16;
            this.f178310b.requestLayout();
            this.f178311c = c16;
        }
    }

    public void e() {
        if (this.f178312d != null) {
            this.f178309a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f178312d);
        }
    }
}
