package com.qzone.reborn.part.publish.common.inputkeyboardmenu;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f58599d;

    /* renamed from: e, reason: collision with root package name */
    private final View f58600e;

    /* renamed from: f, reason: collision with root package name */
    private int f58601f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f58602h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f58603i;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public e(View view) {
        this(view, false);
    }

    private void b() {
        for (a aVar : this.f58599d) {
            if (aVar != null) {
                aVar.onSoftKeyboardClosed();
            }
        }
    }

    private void c(int i3) {
        this.f58601f = i3;
        for (a aVar : this.f58599d) {
            if (aVar != null) {
                aVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void a(a aVar) {
        this.f58599d.add(aVar);
    }

    public void d() {
        this.f58600e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f58599d.clear();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f58600e.getWindowVisibleDisplayFrame(this.f58603i);
        int height = this.f58600e.getHeight();
        Rect rect = this.f58603i;
        int statusBarHeight = (height - (rect.bottom - rect.top)) - ImmersiveUtils.getStatusBarHeight(this.f58600e.getContext());
        RFWLog.d("QZoneSoftKeyboardStateHelper", RFWLog.USR, "onGlobalLayout, rootViewHeight: " + height + ", heightDiff: " + statusBarHeight + ", mIsSoftKeyboardOpened: " + this.f58602h);
        boolean z16 = this.f58602h;
        if (!z16 && statusBarHeight > 150) {
            this.f58602h = true;
            c(statusBarHeight);
        } else {
            if (!z16 || statusBarHeight >= 150) {
                return;
            }
            this.f58602h = false;
            b();
        }
    }

    public e(View view, boolean z16) {
        this.f58599d = new LinkedList();
        this.f58603i = new Rect();
        this.f58600e = view;
        this.f58602h = z16;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
