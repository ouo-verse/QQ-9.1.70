package com.tencent.mobileqq.search.searchdetail.searchbox;

import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchHistoryEntity;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.UnifySearchTabInfo;
import rp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0007R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR'\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130 8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b!\u0010\"*\u0004\b#\u0010$R'\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130 8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b&\u0010\"*\u0004\b'\u0010$R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060 8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b)\u0010\"*\u0004\b*\u0010$\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "W1", "Lrp2/c$a;", "entity", "b2", "Z1", "keyword", "Lrp2/d;", "tab", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "R1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_localHistory", "Lrp2/c$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_netSuggestWord", BdhLogUtil.LogTag.Tag_Conn, "_historyListRemoved", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/l;", "D", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/l;", "repo", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "getLocalHistory$delegate", "(Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;)Ljava/lang/Object;", "localHistory", "U1", "getNetSuggestWord$delegate", "netSuggestWord", "S1", "getHistoryListRemoved$delegate", "historyListRemoved", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchBoxViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<c.SearchHistoryKeywordData>> _localHistory = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<c.SearchSuggestKeywordData>> _netSuggestWord = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<c.SearchHistoryKeywordData> _historyListRemoved = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final l repo = new l();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(final SearchBoxViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).loadSearchHistory(new Function1<List<SearchHistoryEntity>, Void>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchBoxViewModel$loadHistoryNetSearchRecord$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(List<SearchHistoryEntity> history) {
                int collectionSizeOrDefault;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullExpressionValue(history, "history");
                ArrayList<SearchHistoryEntity> arrayList = new ArrayList();
                Iterator<T> it = history.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((SearchHistoryEntity) next).getType() == 10025) {
                        arrayList.add(next);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (SearchHistoryEntity searchHistoryEntity : arrayList) {
                    arrayList2.add(new c.SearchHistoryKeywordData(searchHistoryEntity.getId(), searchHistoryEntity.getDisplayName()));
                }
                QLog.d("QQSearch.NetDetail.SearchBoxViewModel", 1, "loadHistoryNetSearchRecord rs.size= " + arrayList2.size());
                mutableLiveData = SearchBoxViewModel.this._localHistory;
                mutableLiveData.postValue(arrayList2);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(SearchBoxViewModel this$0) {
        List<c.SearchHistoryKeywordData> emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<c.SearchHistoryKeywordData> value = this$0._localHistory.getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                QLog.d("QQSearch.NetDetail.SearchBoxViewModel", 1, "removeResult  " + ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).removeHistoryById(((c.SearchHistoryKeywordData) it.next()).getId()));
            }
        }
        MutableLiveData<List<c.SearchHistoryKeywordData>> mutableLiveData = this$0._localHistory;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(emptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(c.SearchHistoryKeywordData entity, SearchBoxViewModel this$0) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean removeHistoryById = ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).removeHistoryById(entity.getId());
        QLog.d("QQSearch.NetDetail.SearchBoxViewModel", 1, "removeResult  " + removeHistoryById);
        if (removeHistoryById) {
            this$0._historyListRemoved.postValue(entity);
        }
    }

    @UiThread
    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b R1(@NotNull String keyword, @NotNull UnifySearchTabInfo tab, int querySource, int userSource) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(tab, "tab");
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQSearch.NetDetail.SearchBoxViewModel fetchSugWords", null, null, Boolean.TRUE, new SearchBoxViewModel$fetchSugWords$1(this, keyword, querySource, userSource, tab, null), 6, null);
    }

    @NotNull
    public final LiveData<c.SearchHistoryKeywordData> S1() {
        return this._historyListRemoved;
    }

    @NotNull
    public final LiveData<List<c.SearchHistoryKeywordData>> T1() {
        return this._localHistory;
    }

    @NotNull
    public final LiveData<List<c.SearchSuggestKeywordData>> U1() {
        return this._netSuggestWord;
    }

    public final void W1() {
        QLog.d("QQSearch.NetDetail.SearchBoxViewModel", 1, "loadHistoryNetSearchRecord " + this);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.o
            @Override // java.lang.Runnable
            public final void run() {
                SearchBoxViewModel.X1(SearchBoxViewModel.this);
            }
        });
    }

    public final void Z1() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.n
            @Override // java.lang.Runnable
            public final void run() {
                SearchBoxViewModel.a2(SearchBoxViewModel.this);
            }
        });
    }

    public final void b2(@NotNull final c.SearchHistoryKeywordData entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.m
            @Override // java.lang.Runnable
            public final void run() {
                SearchBoxViewModel.c2(c.SearchHistoryKeywordData.this, this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QQSearch.NetDetail.SearchBoxViewModel";
    }
}
