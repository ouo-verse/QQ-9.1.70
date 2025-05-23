package com.tencent.mobileqq.search.searchdetail.filter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J<\u0010\u000b\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/SearchRulePickerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/e;", "data", "", "defaultSelection", "Lkotlin/Function2;", "Landroid/view/View;", "", "pickerItemCreatedCallback", "setData", "f", "Lkotlin/jvm/functions/Function2;", BdhLogUtil.LogTag.Tag_Conn, "()Lkotlin/jvm/functions/Function2;", "setOnRuleSelectedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onRuleSelectedCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchRulePickerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super Integer, ? super RuleFilter, Unit> onRuleSelectedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchRulePickerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        setLayoutManager(linearLayoutManager);
        setHasFixedSize(true);
        setBackgroundColor(context.getColor(R.color.qui_common_bg_bottom_light));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setData$default(SearchRulePickerView searchRulePickerView, List list, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            function2 = null;
        }
        searchRulePickerView.setData(list, i3, function2);
    }

    @Nullable
    public final Function2<Integer, RuleFilter, Unit> C() {
        return this.onRuleSelectedCallback;
    }

    public final void setData(@NotNull List<RuleFilter> data, int defaultSelection, @Nullable Function2<? super View, ? super RuleFilter, Unit> pickerItemCreatedCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        i iVar = new i(data, new Function2<Integer, RuleFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.filter.SearchRulePickerView$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(int i3, @NotNull RuleFilter filter) {
                Intrinsics.checkNotNullParameter(filter, "filter");
                Function2<Integer, RuleFilter, Unit> C = SearchRulePickerView.this.C();
                if (C != null) {
                    C.invoke(Integer.valueOf(i3), filter);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, RuleFilter ruleFilter) {
                invoke(num.intValue(), ruleFilter);
                return Unit.INSTANCE;
            }
        });
        iVar.o0(defaultSelection);
        iVar.n0(pickerItemCreatedCallback);
        setAdapter(iVar);
    }

    public final void setOnRuleSelectedCallback(@Nullable Function2<? super Integer, ? super RuleFilter, Unit> function2) {
        this.onRuleSelectedCallback = function2;
    }
}
