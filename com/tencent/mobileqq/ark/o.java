package com.tencent.mobileqq.ark;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private View f199595a;

    /* renamed from: b, reason: collision with root package name */
    private int f199596b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup.MarginLayoutParams f199597c;

    /* renamed from: d, reason: collision with root package name */
    private int f199598d;

    /* renamed from: e, reason: collision with root package name */
    private ArkAppView f199599e;

    /* renamed from: f, reason: collision with root package name */
    private int f199600f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            o.this.d();
        }
    }

    o(Activity activity, ArkAppView arkAppView) {
        this.f199598d = 0;
        this.f199600f = 0;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f199595a = childAt;
        if (childAt != null) {
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
        this.f199599e = arkAppView;
        this.f199597c = (ViewGroup.MarginLayoutParams) arkAppView.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f199600f = displayMetrics.heightPixels;
        this.f199598d = this.f199597c.topMargin;
    }

    public static void b(Activity activity, ArkAppView arkAppView) {
        new o(activity, arkAppView);
    }

    private int c() {
        Rect rect = new Rect();
        this.f199595a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int c16 = c();
        if (c16 != this.f199596b) {
            int height = this.f199595a.getRootView().getHeight();
            int i3 = height - c16;
            if (i3 > height / 4) {
                Rect inputRect = this.f199599e.getInputRect();
                int[] iArr = new int[2];
                this.f199599e.getLocationOnScreen(iArr);
                int i16 = inputRect.bottom + iArr[1];
                int i17 = this.f199600f - i3;
                if (i17 < i16) {
                    this.f199597c.topMargin = i17 - i16;
                    this.f199599e.requestLayout();
                }
            } else {
                this.f199597c.topMargin = this.f199598d;
                this.f199599e.requestLayout();
            }
            this.f199596b = c16;
        }
    }
}
