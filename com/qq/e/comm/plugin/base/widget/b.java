package com.qq.e.comm.plugin.base.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f39304a;

    /* renamed from: b, reason: collision with root package name */
    private int f39305b;

    /* renamed from: c, reason: collision with root package name */
    private int f39306c;

    /* renamed from: d, reason: collision with root package name */
    private int f39307d;

    /* renamed from: e, reason: collision with root package name */
    private int f39308e;

    /* renamed from: f, reason: collision with root package name */
    private int f39309f;

    /* renamed from: g, reason: collision with root package name */
    private int f39310g;

    /* renamed from: h, reason: collision with root package name */
    private int f39311h;

    /* renamed from: i, reason: collision with root package name */
    private int f39312i;

    /* renamed from: j, reason: collision with root package name */
    private int f39313j;

    /* renamed from: k, reason: collision with root package name */
    private WeakReference<a> f39314k;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(View view);

        void a(View view, int i3, int i16, int i17, int i18);

        void b(View view);
    }

    public b(ViewGroup viewGroup, a aVar) {
        this(viewGroup);
        this.f39314k = new WeakReference<>(aVar);
    }

    public boolean c(View view, MotionEvent motionEvent) {
        int rawX = ((int) motionEvent.getRawX()) - this.f39308e;
        int rawY = ((int) motionEvent.getRawY()) - this.f39309f;
        if (Math.abs(rawX) < 2 && Math.abs(rawY) < 2) {
            view.performClick();
            return false;
        }
        WeakReference<a> weakReference = this.f39314k;
        if (weakReference != null && weakReference.get() != null) {
            this.f39314k.get().b(view);
            return true;
        }
        return true;
    }

    public void a(int i3, int i16, int i17, int i18) {
        this.f39310g = i3;
        this.f39311h = i16;
        this.f39312i = i17;
        this.f39313j = i18;
    }

    public void b(View view, MotionEvent motionEvent) {
        int rawX = ((int) motionEvent.getRawX()) - this.f39306c;
        int rawY = ((int) motionEvent.getRawY()) - this.f39307d;
        int left = view.getLeft() + rawX;
        int top = view.getTop() + rawY;
        int width = view.getWidth() + left;
        int height = view.getHeight() + top;
        if (this.f39304a != 0 && this.f39305b != 0) {
            int i3 = this.f39310g;
            if (left < i3) {
                width = view.getWidth() + i3;
                left = i3;
            }
            int i16 = this.f39304a;
            int i17 = this.f39311h;
            if (width > i16 - i17) {
                int i18 = i16 - i17;
                left = i18 - view.getWidth();
                width = i18;
            }
            int i19 = this.f39312i;
            if (top < i19) {
                height = i19 + view.getHeight();
                top = i19;
            }
            int i26 = this.f39305b;
            int i27 = this.f39313j;
            if (height > i26 - i27) {
                height = i26 - i27;
                top = height - view.getHeight();
            }
        }
        int i28 = top;
        int i29 = width;
        int i36 = left;
        int i37 = height;
        view.layout(i36, i28, i29, i37);
        WeakReference<a> weakReference = this.f39314k;
        if (weakReference != null && weakReference.get() != null) {
            this.f39314k.get().a(view, i36, i28, i29, i37);
        }
        this.f39306c = (int) motionEvent.getRawX();
        this.f39307d = (int) motionEvent.getRawY();
    }

    public b(final ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.qq.e.comm.plugin.base.widget.b.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    b.this.f39305b = viewGroup.getMeasuredHeight();
                    b.this.f39304a = viewGroup.getMeasuredWidth();
                    return true;
                }
            });
        }
    }

    public void a(View view, MotionEvent motionEvent) {
        WeakReference<a> weakReference = this.f39314k;
        if (weakReference != null && weakReference.get() != null) {
            this.f39314k.get().a(view);
        }
        this.f39306c = (int) motionEvent.getRawX();
        this.f39307d = (int) motionEvent.getRawY();
        this.f39308e = (int) motionEvent.getRawX();
        this.f39309f = (int) motionEvent.getRawY();
    }
}
