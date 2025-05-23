package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class InputMethodRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected b f315752d;

    /* renamed from: e, reason: collision with root package name */
    private int f315753e;

    /* renamed from: f, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f315754f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315755h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int f16;
            InputMethodRelativeLayout inputMethodRelativeLayout = InputMethodRelativeLayout.this;
            if (inputMethodRelativeLayout.f315752d != null && (f16 = inputMethodRelativeLayout.f()) != InputMethodRelativeLayout.this.f315753e) {
                int height = InputMethodRelativeLayout.this.getRootView().getHeight();
                if (height - f16 > height / 4) {
                    InputMethodRelativeLayout.this.f315755h = true;
                } else {
                    InputMethodRelativeLayout.this.f315755h = false;
                }
                InputMethodRelativeLayout inputMethodRelativeLayout2 = InputMethodRelativeLayout.this;
                inputMethodRelativeLayout2.f315752d.n(inputMethodRelativeLayout2.f315755h, InputMethodRelativeLayout.this.f315753e, f16);
                InputMethodRelativeLayout.this.requestLayout();
                InputMethodRelativeLayout.this.f315753e = f16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void n(boolean z16, int i3, int i16);
    }

    public InputMethodRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315754f = new a();
        this.f315755h = false;
        getViewTreeObserver().addOnGlobalLayoutListener(this.f315754f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public void g() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f315754f);
    }

    public void setOnSizeChangedListenner(b bVar) {
        this.f315752d = bVar;
    }

    public InputMethodRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315754f = new a();
        this.f315755h = false;
        getViewTreeObserver().addOnGlobalLayoutListener(this.f315754f);
    }
}
