package com.tencent.mobileqq.guild.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f236715a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<View> f236716b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f236717c;

    /* renamed from: d, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f236718d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f236719e;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (s.this.f236716b.get() != 0) {
                ((View) s.this.f236716b.get()).getViewTreeObserver().addOnGlobalLayoutListener(s.this.f236719e);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            s.this.j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (s.this.f236716b.get() == 0) {
                QLog.d(SoftKeyboardStateHelper.TAG, 1, "onGlobalLayout activityRootViewRef is null");
                return;
            }
            Rect rect = new Rect();
            View view = (View) s.this.f236716b.get();
            view.getWindowVisibleDisplayFrame(rect);
            int height = (view.getRootView().getHeight() - (rect.bottom - rect.top)) - ImmersiveUtils.getStatusBarHeight(view.getContext());
            int height2 = view.getRootView().getHeight() / 4;
            if (!s.this.f236717c && height > height2) {
                s.this.f236717c = true;
                s.this.i(height);
            } else if (s.this.f236717c && height < height2) {
                s.this.f236717c = false;
                s.this.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface c {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public s(View view) {
        this(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        for (c cVar : this.f236715a) {
            if (cVar != null) {
                cVar.onSoftKeyboardClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        for (c cVar : this.f236715a) {
            if (cVar != null) {
                cVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void g(c cVar) {
        this.f236715a.add(cVar);
    }

    public void j() {
        this.f236715a.clear();
        if (this.f236716b.get() != null) {
            this.f236716b.get().getViewTreeObserver().removeOnGlobalLayoutListener(this.f236719e);
            this.f236716b.get().removeOnAttachStateChangeListener(this.f236718d);
        }
    }

    public void k(c cVar) {
        this.f236715a.remove(cVar);
    }

    public s(View view, boolean z16) {
        this.f236715a = new LinkedList();
        a aVar = new a();
        this.f236718d = aVar;
        b bVar = new b();
        this.f236719e = bVar;
        WeakReference<View> weakReference = new WeakReference<>(view);
        this.f236716b = weakReference;
        this.f236717c = z16;
        j();
        if (weakReference.get() != null) {
            if (weakReference.get().isAttachedToWindow()) {
                weakReference.get().getViewTreeObserver().addOnGlobalLayoutListener(bVar);
            }
            weakReference.get().addOnAttachStateChangeListener(aVar);
        }
    }
}
