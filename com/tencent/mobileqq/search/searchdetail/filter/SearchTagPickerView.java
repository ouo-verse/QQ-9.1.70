package com.tencent.mobileqq.search.searchdetail.filter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J2\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R6\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/SearchTagPickerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/j;", "data", "Lkotlin/Function2;", "Landroid/view/View;", "", "pickerItemCreatedCallback", "setData", "", "f", "Lkotlin/jvm/functions/Function2;", BdhLogUtil.LogTag.Tag_Conn, "()Lkotlin/jvm/functions/Function2;", "setOnTagSelectedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onTagSelectedCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchTagPickerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super Integer, ? super TagFilter, Unit> onTagSelectedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchTagPickerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        gridLayoutManager.setAutoMeasureEnabled(true);
        setLayoutManager(gridLayoutManager);
        setHasFixedSize(true);
        setBackgroundColor(context.getColor(R.color.qui_common_bg_bottom_light));
        addItemDecoration(new c(3, bj.a(8), bj.a(12), bj.a(16), bj.a(4)));
        setPadding(0, 0, 0, bj.a(12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setData$default(SearchTagPickerView searchTagPickerView, List list, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        searchTagPickerView.setData(list, function2);
    }

    @Nullable
    public final Function2<Integer, TagFilter, Unit> C() {
        return this.onTagSelectedCallback;
    }

    public final void setData(@NotNull List<TagFilter> data, @Nullable Function2<? super View, ? super TagFilter, Unit> pickerItemCreatedCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        l lVar = new l(data, new Function2<Integer, TagFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.filter.SearchTagPickerView$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(int i3, @NotNull TagFilter filter) {
                Intrinsics.checkNotNullParameter(filter, "filter");
                Function2<Integer, TagFilter, Unit> C = SearchTagPickerView.this.C();
                if (C != null) {
                    C.invoke(Integer.valueOf(i3), filter);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, TagFilter tagFilter) {
                invoke(num.intValue(), tagFilter);
                return Unit.INSTANCE;
            }
        });
        lVar.n0(pickerItemCreatedCallback);
        lVar.o0(0);
        setAdapter(lVar);
    }

    public final void setOnTagSelectedCallback(@Nullable Function2<? super Integer, ? super TagFilter, Unit> function2) {
        this.onTagSelectedCallback = function2;
    }
}
