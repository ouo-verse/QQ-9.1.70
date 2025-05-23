package com.tencent.kuikly.core.render.android.expand.component.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kuikly.core.render.android.KGestureDetector;
import com.tencent.kuikly.core.render.android.css.gesture.KRCSSGestureListener;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aRF\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerContentView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "K", "", "propKey", "", "propValue", "", "b", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/view/View;", "child", "", "index", "addView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "e", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "H", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "panGestureListener", "I", "Landroid/view/MotionEvent;", "panDownForNext", "Lkotlin/Function1;", "value", "J", "Lkotlin/jvm/functions/Function1;", "getAddChildCallback", "()Lkotlin/jvm/functions/Function1;", "setAddChildCallback", "(Lkotlin/jvm/functions/Function1;)V", "addChildCallback", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnRemoveFromParentCallback", "()Lkotlin/jvm/functions/Function0;", "setOnRemoveFromParentCallback", "(Lkotlin/jvm/functions/Function0;)V", "onRemoveFromParentCallback", "", "L", "Ljava/util/List;", "addChildLazyTasks", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "M", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRRecyclerContentView extends KRView {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private KRCSSGestureListener panGestureListener;

    /* renamed from: I, reason: from kotlin metadata */
    private MotionEvent panDownForNext;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> addChildCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onRemoveFromParentCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private final List<View> addChildLazyTasks;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerContentView$a;", "", "", "VIEW_NAME", "Ljava/lang/String;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRRecyclerContentView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setImportantForAccessibility(2);
        setFocusable(false);
        this.addChildLazyTasks = new ArrayList();
    }

    private final void K() {
        for (View view : this.addChildLazyTasks) {
            Function1<? super View, Unit> function1 = this.addChildCallback;
            if (function1 != null) {
                function1.invoke(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.addView(child, index);
        Function1<? super View, Unit> function1 = this.addChildCallback;
        if (function1 == null) {
            this.addChildLazyTasks.add(child);
        } else if (function1 != null) {
            function1.invoke(child);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        boolean b16 = super.b(propKey, propValue);
        if (Intrinsics.areEqual(propKey, "panDirection") && KGestureDetector.ScrollDirection.INSTANCE.b(((Integer) propValue).intValue())) {
            this.panGestureListener = KRCSSViewExtensionKt.q(this);
        }
        return b16;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        super.e(parent);
        Function0<Unit> function0 = this.onRemoveFromParentCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean k() {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(ev5);
        if (this.panGestureListener != null && !onInterceptTouchEvent) {
            if (ev5.getAction() == 0) {
                this.panDownForNext = MotionEvent.obtain(ev5);
                return onInterceptTouchEvent;
            }
            MotionEvent motionEvent = this.panDownForNext;
            if (motionEvent != null) {
                KRCSSGestureListener kRCSSGestureListener = this.panGestureListener;
                if (kRCSSGestureListener != null) {
                    Intrinsics.checkNotNull(motionEvent);
                    kRCSSGestureListener.n(motionEvent);
                }
                this.panDownForNext = null;
            }
            KRCSSGestureListener kRCSSGestureListener2 = this.panGestureListener;
            if (kRCSSGestureListener2 != null) {
                z16 = kRCSSGestureListener2.n(ev5);
            } else {
                z16 = false;
            }
            return z16;
        }
        return onInterceptTouchEvent;
    }

    public final void setAddChildCallback(@Nullable Function1<? super View, Unit> function1) {
        if (Intrinsics.areEqual(this.addChildCallback, function1)) {
            return;
        }
        this.addChildCallback = function1;
        K();
        this.addChildLazyTasks.clear();
    }

    public final void setOnRemoveFromParentCallback(@Nullable Function0<Unit> function0) {
        this.onRemoveFromParentCallback = function0;
    }
}
