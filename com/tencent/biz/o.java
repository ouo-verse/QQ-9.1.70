package com.tencent.biz;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class o implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<View> f78777d;

    /* renamed from: e, reason: collision with root package name */
    private a f78778e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f78779f;

    /* renamed from: h, reason: collision with root package name */
    private final int f78780h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void N1(boolean z16, int i3, int i16);
    }

    public o(View view, a aVar) {
        this(view, aVar, UIUtils.b(view.getContext(), 160.0f));
    }

    public void a() {
        View view = this.f78777d.get();
        if (view == null) {
            return;
        }
        this.f78778e = null;
        try {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } catch (Throwable th5) {
            QLog.d("SoftKeyboardObserver", 1, th5, new Object[0]);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view = this.f78777d.get();
        if (view == null) {
            return;
        }
        Rect rect = new Rect();
        boolean z16 = true;
        try {
            view.getWindowVisibleDisplayFrame(rect);
            int height = view.getRootView().getHeight();
            int i3 = rect.bottom;
            int i16 = height - (i3 - rect.top);
            a aVar = this.f78778e;
            if (aVar != null) {
                if (i16 < this.f78780h) {
                    z16 = false;
                }
                if (z16 != this.f78779f) {
                    this.f78779f = z16;
                    aVar.N1(z16, rect.right, i3);
                }
            }
        } catch (NullPointerException e16) {
            QLog.e("SoftKeyboardObserver", 1, "getWindowVisibleDisplayFrame error", e16);
        }
    }

    public o(View view, a aVar, int i3) {
        this.f78779f = false;
        this.f78777d = new WeakReference<>(view);
        this.f78778e = aVar;
        this.f78780h = i3;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
