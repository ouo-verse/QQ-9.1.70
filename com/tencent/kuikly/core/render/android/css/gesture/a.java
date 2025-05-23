package com.tencent.kuikly.core.render.android.css.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.kuikly.core.render.android.KGestureDetector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/gesture/a;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector;", "", "t", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "ev", DomainData.DOMAIN_NAME, "disallow", "", "u", "(Z)Lkotlin/Unit;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "I", "Ljava/lang/ref/WeakReference;", "targetViewWeakRef", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "J", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "listener", "Landroid/content/Context;", "context", "targetView", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;)V", "K", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a extends KGestureDetector {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    private final WeakReference<View> targetViewWeakRef;

    /* renamed from: J, reason: from kotlin metadata */
    private final KRCSSGestureListener listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/gesture/a$a;", "", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.css.gesture.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull View targetView, @NotNull KRCSSGestureListener listener) {
        super(context, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.targetViewWeakRef = new WeakReference<>(targetView);
    }

    private final boolean t() {
        return this.listener.c(4);
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector
    public boolean n(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (t()) {
            if (ev5.getAction() == 0 && o()) {
                u(true);
            }
            this.listener.t(ev5);
        }
        boolean n3 = super.n(ev5);
        if (this.listener.getIsPanEventHappening()) {
            if (ev5.getAction() == 1) {
                this.listener.u(ev5);
                u(false);
                return true;
            }
            if (ev5.getAction() == 6) {
                this.listener.s(ev5);
                return true;
            }
            if (ev5.getAction() != 3) {
                return true;
            }
            this.listener.m(ev5);
            u(false);
            return true;
        }
        return n3;
    }

    @Nullable
    public final Unit u(boolean disallow) {
        ViewParent parent;
        View view = this.targetViewWeakRef.get();
        if (view != null && (parent = view.getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
            return Unit.INSTANCE;
        }
        return null;
    }

    @Nullable
    public final View v() {
        return this.targetViewWeakRef.get();
    }
}
