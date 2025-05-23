package com.tencent.mobileqq.guild.webview;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final View f235742a;

    /* renamed from: b, reason: collision with root package name */
    private int f235743b;

    /* renamed from: c, reason: collision with root package name */
    private final FrameLayout.LayoutParams f235744c;

    b(Activity activity) {
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.f235742a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.webview.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                b.this.d();
            }
        });
        this.f235744c = (FrameLayout.LayoutParams) childAt.getLayoutParams();
    }

    public static void b(Activity activity) {
        QLog.i("Guild.AndroidBug5497Workaround", 1, "apply AndroidBug5497Workaround for " + activity.getComponentName().getClassName());
        new b(activity);
    }

    private int c() {
        Rect rect = new Rect();
        this.f235742a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void d() {
        int c16 = c();
        if (c16 != this.f235743b) {
            int height = this.f235742a.getRootView().getHeight();
            int i3 = height - c16;
            if (i3 > height / 4) {
                this.f235744c.height = height - i3;
            } else {
                this.f235744c.height = height;
            }
            this.f235742a.requestLayout();
            this.f235743b = c16;
        }
    }
}
