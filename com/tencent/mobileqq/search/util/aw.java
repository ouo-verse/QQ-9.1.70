package com.tencent.mobileqq.search.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aw implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f285021d;

    /* renamed from: e, reason: collision with root package name */
    private final View f285022e;

    /* renamed from: f, reason: collision with root package name */
    private int f285023f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f285024h;

    /* renamed from: i, reason: collision with root package name */
    private int f285025i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public aw(View view) {
        this(view, false);
    }

    private void b() {
        for (a aVar : this.f285021d) {
            if (aVar != null) {
                aVar.onSoftKeyboardClosed();
            }
        }
    }

    private void c(int i3) {
        this.f285023f = i3;
        for (a aVar : this.f285021d) {
            if (aVar != null) {
                aVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void a(a aVar) {
        this.f285021d.add(aVar);
    }

    public void d() {
        this.f285021d.clear();
        View view = this.f285022e;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public void e(a aVar) {
        this.f285021d.remove(aVar);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f285022e.getWindowVisibleDisplayFrame(rect);
        int height = (this.f285022e.getRootView().getHeight() - (rect.bottom - rect.top)) - ImmersiveUtils.getStatusBarHeight(this.f285022e.getContext());
        if (QLog.isDevelopLevel()) {
            QLog.d(SoftKeyboardStateHelper.TAG, 2, "onGlobalLayout , activityRootView.Height = " + this.f285022e.getRootView().getHeight() + " heightDiff = " + height + " (r.bottom - r.top) = " + (rect.bottom - rect.top));
        }
        boolean z16 = this.f285024h;
        if (!z16 && height > this.f285025i) {
            this.f285024h = true;
            c(height);
        } else if (z16 && height < this.f285025i) {
            this.f285024h = false;
            b();
        }
    }

    public aw(View view, boolean z16) {
        this.f285021d = new LinkedList();
        this.f285025i = 200;
        this.f285022e = view;
        this.f285024h = z16;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
