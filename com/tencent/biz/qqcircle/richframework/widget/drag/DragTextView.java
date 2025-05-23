package com.tencent.biz.qqcircle.richframework.widget.drag;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import pb0.a;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes5.dex */
public class DragTextView extends TextView {
    private static int C;

    /* renamed from: i, reason: collision with root package name */
    private static int f92142i;

    /* renamed from: m, reason: collision with root package name */
    private static int f92143m;

    /* renamed from: d, reason: collision with root package name */
    private int f92144d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f92145e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f92146f;

    /* renamed from: h, reason: collision with root package name */
    private View f92147h;

    public DragTextView(Context context) {
        super(context);
        this.f92144d = -1;
        this.f92146f = null;
        this.f92147h = null;
        b(context);
    }

    private void a(View view, Rect rect) {
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        super.getGlobalVisibleRect(rect);
        if (this.f92144d == 2) {
            int i3 = rect.top - rect2.top;
            int i16 = f92142i;
            rect.top = i3 - i16;
            int i17 = rect.left - rect2.left;
            int i18 = C;
            rect.left = i17 - i18;
            rect.bottom = (rect.bottom - rect2.top) + i18;
            rect.right = (rect.right - rect2.left) + i16;
            return;
        }
        int i19 = rect.top - rect2.top;
        int i26 = f92143m;
        rect.top = i19 - i26;
        rect.left = (rect.left - rect2.left) - i26;
        int i27 = rect.bottom - rect2.top;
        int i28 = f92142i;
        rect.bottom = i27 + i28;
        rect.right = (rect.right - rect2.left) + i28;
    }

    private static void b(Context context) {
        if (f92142i == 0) {
            float f16 = context.getResources().getDisplayMetrics().density * 16.0f;
            f92142i = (int) f16;
            f92143m = (int) (1.5f * f16);
            C = (int) (f16 * 0.5f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        Rect rect = this.f92146f;
        if (rect != null && z16) {
            a(this.f92147h, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f92144d != -1 && !this.f92145e && motionEvent.getAction() == 0) {
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDragViewType(int i3) {
        setDragViewType(i3, null);
    }

    public void setOnModeChangeListener(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "setOnModeChangeListener:" + aVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (this.f92145e && i3 == 0) {
            this.f92145e = false;
        }
    }

    public void setDragViewType(int i3, View view) {
        this.f92144d = i3;
        this.f92147h = view;
        if (view == null) {
            this.f92147h = (ViewGroup) getParent();
        }
    }

    public DragTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f92144d = -1;
        this.f92146f = null;
        this.f92147h = null;
        b(context);
    }

    public DragTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92144d = -1;
        this.f92146f = null;
        this.f92147h = null;
        b(context);
    }
}
