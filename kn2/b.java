package kn2;

import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageExtraInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchFloatButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JH\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH&\u00a8\u0006\u0015"}, d2 = {"Lkn2/b;", "", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "list", "", "isEnd", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "emptyExtra", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFloatButton;", "floatButton", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "miniAppConditionFilters", "", "extData", "", "onSuccess", "", "errorCode", "errorMsg", "onFailed", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    void onFailed(int errorCode, @NotNull String errorMsg);

    void onSuccess(@NotNull List<? extends com.tencent.mobileqq.search.searchdetail.a> list, boolean isEnd, @NotNull SearchEmptyPageExtraInfo emptyExtra, @NotNull SearchFloatButton floatButton, @NotNull List<SearchMiniAppConditonFilter> miniAppConditionFilters, @Nullable String extData);
}
