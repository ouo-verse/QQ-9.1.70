package com.tencent.biz.pubaccount.weishi.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J&\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/RecyclerViewHelper;", "", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "b", "d", "Lkotlin/Function1;", "Landroid/view/View;", "isFooterView", "c", "Landroid/graphics/Rect;", "Lkotlin/Lazy;", "a", "()Landroid/graphics/Rect;", "sGlobalRect", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class RecyclerViewHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final RecyclerViewHelper f82379a = new RecyclerViewHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy sGlobalRect;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Rect>() { // from class: com.tencent.biz.pubaccount.weishi.view.RecyclerViewHelper$sGlobalRect$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                return new Rect();
            }
        });
        sGlobalRect = lazy;
    }

    RecyclerViewHelper() {
    }

    private final Rect a() {
        return (Rect) sGlobalRect.getValue();
    }

    @JvmStatic
    public static final boolean b(RecyclerView recyclerView) {
        return c(recyclerView, new Function1<View, Boolean>() { // from class: com.tencent.biz.pubaccount.weishi.view.RecyclerViewHelper$isLoadMoreViewExposed$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof XLoadMoreLayout);
            }
        });
    }

    @JvmStatic
    public static final boolean c(RecyclerView recyclerView, Function1<? super View, Boolean> isFooterView) {
        View childAt;
        Intrinsics.checkNotNullParameter(isFooterView, "isFooterView");
        if (recyclerView == null || (childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1)) == null || !isFooterView.invoke(childAt).booleanValue()) {
            return false;
        }
        return childAt.getGlobalVisibleRect(f82379a.a());
    }

    @JvmStatic
    public static final boolean d(RecyclerView recyclerView) {
        return c(recyclerView, new Function1<View, Boolean>() { // from class: com.tencent.biz.pubaccount.weishi.view.RecyclerViewHelper$isLoadMoreViewExposedVertical$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof TextView);
            }
        });
    }
}
