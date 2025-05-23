package com.tencent.mobileqq.guild.feed.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001c\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00040\u0003*\u00020\u0000\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a1\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00012\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\u0002\b\fH\u0007\u001a%\u0010\u000f\u001a\u00020\u0007*\u00020\u00002\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\u0002\b\f\u00a8\u0006\u0010"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", "a", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "g", "f", "", "b", "width", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lkotlin/ExtensionFunctionType;", "clearViewPoolMethod", "d", "c", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecyclerViewExtKt {
    public static final int a(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        return (recyclerView.computeVerticalScrollRange() - computeVerticalScrollOffset) - recyclerView.computeVerticalScrollExtent();
    }

    public static final void b(@NotNull RecyclerView recyclerView) {
        int i3;
        LinearLayoutManager linearLayoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            QLog.i("RecyclerViewEx", 1, "itemCount=" + i3 + ", visPos=" + findFirstVisibleItemPosition + ", completeVisPos=" + findFirstCompletelyVisibleItemPosition);
            if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition && findFirstVisibleItemPosition == 0) {
                return;
            }
            if (findFirstVisibleItemPosition != findFirstCompletelyVisibleItemPosition && findFirstVisibleItemPosition == 0) {
                recyclerView.smoothScrollToPosition(0);
            } else if (i3 > 1) {
                recyclerView.scrollToPosition(1);
                recyclerView.smoothScrollToPosition(0);
            }
        }
    }

    public static final void c(@NotNull RecyclerView recyclerView, @NotNull Function1<? super RecyclerView.RecycledViewPool, Unit> clearViewPoolMethod) {
        RecyclerView.Recycler recycler;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(clearViewPoolMethod, "clearViewPoolMethod");
        try {
            Field declaredField = recyclerView.getClass().getDeclaredField("mRecycler");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(recyclerView);
            if (obj instanceof RecyclerView.Recycler) {
                recycler = (RecyclerView.Recycler) obj;
            } else {
                recycler = null;
            }
            if (recycler != null) {
                recycler.clear();
            }
            RecyclerView.RecycledViewPool recycledViewPool = recyclerView.getRecycledViewPool();
            Intrinsics.checkNotNullExpressionValue(recycledViewPool, "recycledViewPool");
            clearViewPoolMethod.invoke(recycledViewPool);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e16) {
            QLog.w("RecyclerViewEx", 1, "clear recycler error for " + e16);
        }
    }

    @JvmOverloads
    public static final void d(@NotNull final RecyclerView recyclerView, final int i3, @NotNull final Function1<? super RecyclerView.RecycledViewPool, Unit> clearViewPoolMethod) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(clearViewPoolMethod, "clearViewPoolMethod");
        yl1.n.i("forceResetWidthAndClear", 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt$forceResetWidthAndClear$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QLog.i("RecyclerViewEx", 1, "forceResetWidthAndClear, width=" + i3);
                recyclerView.getLayoutParams().width = i3;
                recyclerView.requestLayout();
                RecyclerViewExtKt.c(recyclerView, clearViewPoolMethod);
            }
        }, 2, null);
    }

    public static /* synthetic */ void e(RecyclerView recyclerView, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = GuildSplitViewUtils.f235370a.i(true, recyclerView.getContext());
        }
        if ((i16 & 2) != 0) {
            function1 = RecyclerViewExtKt$forceResetWidthAndClear$1.INSTANCE;
        }
        d(recyclerView, i3, function1);
    }

    @NotNull
    public static final Flow<Integer> f(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        return FlowKt.callbackFlow(new RecyclerViewExtKt$onScrollStateChangedFlow$1(recyclerView, null));
    }

    @NotNull
    public static final Flow<Pair<Integer, Integer>> g(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        return FlowKt.callbackFlow(new RecyclerViewExtKt$onScrolledFlow$1(recyclerView, null));
    }
}
