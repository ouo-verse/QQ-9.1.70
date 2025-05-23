package com.tencent.biz.subscribe.comment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f96048d;

    /* renamed from: e, reason: collision with root package name */
    private final View f96049e;

    /* renamed from: f, reason: collision with root package name */
    private int f96050f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f96051h;

    /* renamed from: i, reason: collision with root package name */
    private int f96052i;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public q(View view) {
        this(view, false);
    }

    private void b() {
        for (a aVar : this.f96048d) {
            if (aVar != null) {
                aVar.onSoftKeyboardClosed();
            }
        }
    }

    private void c(int i3) {
        this.f96050f = i3;
        for (a aVar : this.f96048d) {
            if (aVar != null) {
                aVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void a(a aVar) {
        this.f96048d.add(aVar);
    }

    public void d() {
        this.f96048d.clear();
        this.f96049e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public void e(a aVar) {
        this.f96048d.remove(aVar);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f96049e.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        int i3 = this.f96052i;
        if (i3 == 0) {
            this.f96052i = height;
            return;
        }
        int i16 = i3 - height;
        boolean z16 = this.f96051h;
        if (!z16 && i16 >= 250) {
            this.f96051h = true;
            c(i16);
        } else if (z16 && i16 < 100) {
            this.f96051h = false;
            b();
        }
    }

    public q(View view, boolean z16) {
        this.f96048d = new LinkedList();
        this.f96052i = 0;
        this.f96049e = view;
        this.f96051h = z16;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
