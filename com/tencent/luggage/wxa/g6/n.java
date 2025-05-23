package com.tencent.luggage.wxa.g6;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n implements k {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f126555a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f126556b;

    /* renamed from: c, reason: collision with root package name */
    public Window f126557c;

    /* renamed from: d, reason: collision with root package name */
    public DialogInterface.OnShowListener f126558d;

    /* renamed from: e, reason: collision with root package name */
    public DialogInterface.OnDismissListener f126559e;

    /* renamed from: f, reason: collision with root package name */
    public DialogInterface.OnCancelListener f126560f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f126561g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (n.this.f126561g) {
                n.this.cancel();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f126563a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, n nVar) {
            super(context);
            this.f126563a = nVar;
            setClickable(true);
            setFocusable(true);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!this.f126563a.isShowing()) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.color.bhu);
        this.f126555a = frameLayout;
        b bVar = new b(context, this);
        this.f126556b = bVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(bVar, layoutParams);
        frameLayout.setOnClickListener(new a());
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        this.f126559e = null;
        dismiss();
    }

    public final DialogInterface.OnCancelListener d() {
        return this.f126560f;
    }

    public final FrameLayout e() {
        return this.f126556b;
    }

    public final DialogInterface.OnDismissListener f() {
        return this.f126559e;
    }

    public final DialogInterface.OnShowListener g() {
        return this.f126558d;
    }

    @Override // com.tencent.luggage.wxa.g6.k
    public Window getWindow() {
        Window window = this.f126557c;
        if (window == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
            return null;
        }
        return window;
    }

    @Override // com.tencent.luggage.wxa.g6.k
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f126556b.removeAllViews();
        this.f126556b.addView(view, layoutParams);
    }

    @Override // com.tencent.luggage.wxa.g6.k
    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f126559e = onDismissListener;
    }

    @Override // com.tencent.luggage.wxa.g6.k
    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f126558d = onShowListener;
    }

    public final void a(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        this.f126557c = window;
        if (window == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
            window = null;
        }
        window.setContentView(this.f126555a);
    }
}
