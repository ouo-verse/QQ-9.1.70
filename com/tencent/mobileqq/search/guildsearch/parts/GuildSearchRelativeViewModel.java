package com.tencent.mobileqq.search.guildsearch.parts;

import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.search.searchdetail.searchbox.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.UnifySearchTabInfo;
import rp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007R \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R'\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018*\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "keyword", "Lrp2/d;", "tab", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "N1", "Landroidx/lifecycle/MutableLiveData;", "", "Lrp2/c$b;", "i", "Landroidx/lifecycle/MutableLiveData;", "_netSuggestWord", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/searchbox/l;", "repo", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "getNetSuggestWordLiveData$delegate", "(Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeViewModel;)Ljava/lang/Object;", "netSuggestWordLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildSearchRelativeViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<c.SearchSuggestKeywordData>> _netSuggestWord = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l repo = new l();

    @UiThread
    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b N1(@NotNull String keyword, @NotNull UnifySearchTabInfo tab, int querySource, int userSource) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(tab, "tab");
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQSearch.Local.Guild.GuildSearchRelativeViewModel fetchSugWords", null, null, Boolean.TRUE, new GuildSearchRelativeViewModel$fetchSugWords$1(this, keyword, querySource, userSource, tab, null), 6, null);
    }

    @NotNull
    public final LiveData<List<c.SearchSuggestKeywordData>> O1() {
        return this._netSuggestWord;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQSearch.Local.Guild.GuildSearchRelativeViewModel";
    }
}
