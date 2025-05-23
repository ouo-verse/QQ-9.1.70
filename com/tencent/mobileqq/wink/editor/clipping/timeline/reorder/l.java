package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Rect;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J.\u0010\u000e\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/l;", "", "Landroid/transition/TransitionValues;", "start", "end", "Landroid/animation/Animator;", "b", "", "Landroid/view/View;", "views", "", "targetIndex", "startX", "thumbWidth", "a", "", "[I", "tempLocation", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f319312a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final int[] tempLocation = new int[2];

    l() {
    }

    private final Animator b(TransitionValues start, TransitionValues end) {
        View view = start.view;
        Intrinsics.checkNotNullExpressionValue(view, "start.view");
        Object obj = start.values.get("android:clipBounds:bounds");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Rect");
        Object obj2 = end.values.get("android:clipBounds:bounds");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.graphics.Rect");
        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, (Property<View, V>) i.f319307a.a(), (TypeEvaluator) new h(new Rect()), (Object[]) new Rect[]{(Rect) obj, (Rect) obj2});
        Intrinsics.checkNotNullExpressionValue(ofObject, "ofObject(\n              \u2026      endBounds\n        )");
        ofObject.addListener(new a(view));
        Object obj3 = start.values.get("android:changeBounds:windowX");
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj3).intValue();
        Intrinsics.checkNotNull(end.values.get("android:changeBounds:windowX"), "null cannot be cast to non-null type kotlin.Int");
        float intValue2 = ((Integer) r10).intValue() - intValue;
        float translationX = view.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", intValue2);
        ofFloat.addListener(new b(view, translationX));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofObject, ofFloat);
        return animatorSet;
    }

    @NotNull
    public final Animator a(@Nullable List<? extends View> views, int targetIndex, int startX, int thumbWidth) {
        IntRange indices;
        int collectionSizeOrDefault;
        if (views == null) {
            return new AnimatorSet();
        }
        ArrayList arrayList = new ArrayList();
        indices = CollectionsKt__CollectionsKt.getIndices(views);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList2.add(views.get(((IntIterator) it).nextInt()));
        }
        int i3 = 0;
        for (Object obj : arrayList2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            TransitionValues transitionValues = new TransitionValues();
            int[] iArr = tempLocation;
            view.getLocationInWindow(iArr);
            Map map = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map, "startValue.values");
            map.put("android:changeBounds:windowX", Integer.valueOf(iArr[0]));
            Map map2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map2, "startValue.values");
            map2.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            transitionValues.view = view;
            TransitionValues transitionValues2 = new TransitionValues();
            Map map3 = transitionValues2.values;
            Intrinsics.checkNotNullExpressionValue(map3, "endValue.values");
            map3.put("android:clipBounds:bounds", new Rect(0, 0, thumbWidth, view.getHeight()));
            Map map4 = transitionValues2.values;
            Intrinsics.checkNotNullExpressionValue(map4, "endValue.values");
            map4.put("android:changeBounds:windowX", Integer.valueOf(startX + ((i3 - targetIndex) * thumbWidth)));
            transitionValues2.view = view;
            arrayList.add(f319312a.b(transitionValues, transitionValues2));
            i3 = i16;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/l$a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/b;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f319314d;

        a(View view) {
            this.f319314d = view;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f319314d.setClipBounds(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/l$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/b;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f319315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f319316e;

        b(View view, float f16) {
            this.f319315d = view;
            this.f319316e = f16;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f319315d.setTranslationX(this.f319316e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
