package com.tencent.mobileqq.mini.entry.search.viewmodel;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchDetailApi;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.a;
import com.tencent.mobileqq.search.util.ap;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageExtraInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchFloatButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn2.b;
import kn2.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qp2.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 22\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b0\u00101J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0013R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u001b\u0010/\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/viewmodel/MiniAppSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", "dataList", "", "preProcessingData", "setItemPageNumAndPosition", "", "extData", "postProcessExtData", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "keyword", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "searchMiniApp", "loadMoreMiniApp", "", "hasMore", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/mini/entry/search/viewmodel/MiniAppSearchResult;", "_searchResultData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "searchResultData", "Landroidx/lifecycle/LiveData;", "getSearchResultData", "()Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/search/api/ISearchDetailApi;", "detailSearchApi$delegate", "Lkotlin/Lazy;", "getDetailSearchApi", "()Lcom/tencent/mobileqq/search/api/ISearchDetailApi;", "detailSearchApi", "Lkn2/c;", "detailSearchRepo$delegate", "getDetailSearchRepo", "()Lkn2/c;", "detailSearchRepo", "pageNum", "I", "totalCountWithoutTitle", "sessionId$delegate", "getSessionId", "()Ljava/lang/String;", "sessionId", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAppSearchViewModel extends ViewModel {
    public static final int PAGE_MODE = 0;
    private static final List<Integer> SUPPORTED_ITEM_TYPES;
    public static final long TAB_MASK = 7;
    public static final String TAB_NAME = "\u5c0f\u7a0b\u5e8f\u4e0b\u62c9\u9875";
    private static final String TAG = "MiniAppSearchViewModel";
    private final MutableLiveData<MiniAppSearchResult> _searchResultData;

    /* renamed from: detailSearchApi$delegate, reason: from kotlin metadata */
    private final Lazy detailSearchApi;

    /* renamed from: detailSearchRepo$delegate, reason: from kotlin metadata */
    private final Lazy detailSearchRepo;
    private int pageNum;
    private final LiveData<MiniAppSearchResult> searchResultData;

    /* renamed from: sessionId$delegate, reason: from kotlin metadata */
    private final Lazy sessionId;
    private int totalCountWithoutTitle;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SearchPageType pageType = SearchPageType.PAGE_NET_SEARCH_MINI_APP_MORE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/viewmodel/MiniAppSearchViewModel$Companion;", "", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "filterByType", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "pageType", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "getPageType", "()Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "", "PAGE_MODE", "I", "SUPPORTED_ITEM_TYPES", "Ljava/util/List;", "", "TAB_MASK", "J", "", "TAB_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchPageType getPageType() {
            return MiniAppSearchViewModel.pageType;
        }

        Companion() {
        }

        public final List<a> filterByType(List<? extends a> list) {
            Set set;
            List<a> minus;
            List<a> emptyList;
            if (list == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            List<? extends a> list2 = list;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (true ^ MiniAppSearchViewModel.SUPPORTED_ITEM_TYPES.contains(Integer.valueOf(((a) obj).getItemType()))) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    QLog.w(MiniAppSearchViewModel.TAG, 1, "get unsupported search item:" + ((a) it.next()));
                }
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            minus = CollectionsKt___CollectionsKt.minus((Iterable) list2, (Iterable) set);
            return minus;
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{22, 7});
        SUPPORTED_ITEM_TYPES = listOf;
    }

    public MiniAppSearchViewModel() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        MutableLiveData<MiniAppSearchResult> mutableLiveData = new MutableLiveData<>(null);
        this._searchResultData = mutableLiveData;
        this.searchResultData = mutableLiveData;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISearchDetailApi>() { // from class: com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchViewModel$detailSearchApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ISearchDetailApi invoke() {
                return (ISearchDetailApi) QRoute.api(ISearchDetailApi.class);
            }
        });
        this.detailSearchApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchViewModel$detailSearchRepo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                ISearchDetailApi detailSearchApi;
                detailSearchApi = MiniAppSearchViewModel.this.getDetailSearchApi();
                return detailSearchApi.createSearchNetContentRepo();
            }
        });
        this.detailSearchRepo = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchViewModel$sessionId$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return System.currentTimeMillis() + "_" + ap.f285014a.a();
            }
        });
        this.sessionId = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISearchDetailApi getDetailSearchApi() {
        return (ISearchDetailApi) this.detailSearchApi.getValue();
    }

    private final c getDetailSearchRepo() {
        return (c) this.detailSearchRepo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preProcessingData(List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
        setItemPageNumAndPosition(dataList);
    }

    private final void setItemPageNumAndPosition(List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
        for (com.tencent.mobileqq.search.searchdetail.c cVar : dataList) {
            cVar.c(this.pageNum);
            getDetailSearchApi().setWithoutTitlePosition(cVar, this.totalCountWithoutTitle);
        }
    }

    public final LiveData<MiniAppSearchResult> getSearchResultData() {
        return this.searchResultData;
    }

    public final String getSessionId() {
        return (String) this.sessionId.getValue();
    }

    public final boolean hasMore() {
        MiniAppSearchResult value = this._searchResultData.getValue();
        return (value == null || value.isEnd()) ? false : true;
    }

    public final void loadMoreMiniApp(final String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        final long currentTimeMillis = System.currentTimeMillis();
        this.pageNum++;
        getDetailSearchRepo().c(keyword, true, null, null, null, "\u5c0f\u7a0b\u5e8f\u4e0b\u62c9\u641c\u7d22-loadMore", this.pageNum, 0, new b() { // from class: com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchViewModel$loadMoreMiniApp$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kn2.b
            public void onFailed(int errorCode, String errorMsg) {
                MutableLiveData mutableLiveData;
                MiniAppSearchResult miniAppSearchResult;
                MutableLiveData mutableLiveData2;
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                QLog.e("MiniAppSearchViewModel", 1, "loadMoreMiniApp fail, errorCode:" + errorCode + ", errorMsg: " + errorMsg);
                mutableLiveData = MiniAppSearchViewModel.this._searchResultData;
                MiniAppSearchResult miniAppSearchResult2 = (MiniAppSearchResult) mutableLiveData.getValue();
                if (miniAppSearchResult2 == null || (miniAppSearchResult = MiniAppSearchResult.copy$default(miniAppSearchResult2, false, null, currentTimeMillis, false, null, false, 58, null)) == null) {
                    miniAppSearchResult = new MiniAppSearchResult(false, keyword, currentTimeMillis, false, null, false, 56, null);
                }
                mutableLiveData2 = MiniAppSearchViewModel.this._searchResultData;
                mutableLiveData2.postValue(miniAppSearchResult);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kn2.b
            public void onSuccess(List<? extends a> list, boolean isEnd, SearchEmptyPageExtraInfo emptyExtra, SearchFloatButton floatButton, List<SearchMiniAppConditonFilter> miniAppConditonFilter, String extData) {
                MutableLiveData mutableLiveData;
                List<a> emptyList;
                List plus;
                MutableLiveData mutableLiveData2;
                Intrinsics.checkNotNullParameter(list, "list");
                Intrinsics.checkNotNullParameter(emptyExtra, "emptyExtra");
                Intrinsics.checkNotNullParameter(floatButton, "floatButton");
                Intrinsics.checkNotNullParameter(miniAppConditonFilter, "miniAppConditonFilter");
                MiniAppSearchViewModel.this.preProcessingData(list);
                mutableLiveData = MiniAppSearchViewModel.this._searchResultData;
                MiniAppSearchResult miniAppSearchResult = (MiniAppSearchResult) mutableLiveData.getValue();
                if (miniAppSearchResult == null || (emptyList = miniAppSearchResult.getResultData()) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                plus = CollectionsKt___CollectionsKt.plus((Collection) emptyList, (Iterable) MiniAppSearchViewModel.INSTANCE.filterByType(list));
                MiniAppSearchResult miniAppSearchResult2 = new MiniAppSearchResult(true, keyword, currentTimeMillis, plus.isEmpty(), plus, isEnd);
                QLog.i("MiniAppSearchViewModel", 1, "loadMoreMiniApp success, result:" + miniAppSearchResult2);
                MiniAppSearchViewModel.this.postProcessExtData(extData);
                mutableLiveData2 = MiniAppSearchViewModel.this._searchResultData;
                mutableLiveData2.postValue(miniAppSearchResult2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postProcessExtData(String extData) {
        int a16;
        if ((extData == null || extData.length() == 0) || (a16 = f.a(extData)) == -1) {
            return;
        }
        this.totalCountWithoutTitle += a16;
    }

    public final void searchMiniApp(Activity activity, final String keyword, int querySource, int userSource) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        QLog.i(TAG, 1, "searchMiniApp start, keyword:" + keyword + ", userSource:" + userSource + ", querySource:" + querySource);
        final long currentTimeMillis = System.currentTimeMillis();
        getDetailSearchRepo().a(TAB_NAME, 7L, querySource, userSource, "", null, getSessionId());
        getDetailSearchRepo().b(activity, keyword, true, true, null, null, null, "\u5c0f\u7a0b\u5e8f\u4e0b\u62c9\u641c\u7d22", this.pageNum, 0, new b() { // from class: com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchViewModel$searchMiniApp$1
            @Override // kn2.b
            public void onFailed(int errorCode, String errorMsg) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                QLog.e("MiniAppSearchViewModel", 1, "searchMiniApp fail, errorCode:" + errorCode + ", errorMsg: " + errorMsg);
                mutableLiveData = MiniAppSearchViewModel.this._searchResultData;
                mutableLiveData.postValue(new MiniAppSearchResult(false, keyword, currentTimeMillis, false, null, false, 56, null));
            }

            @Override // kn2.b
            public void onSuccess(List<? extends a> list, boolean isEnd, SearchEmptyPageExtraInfo emptyExtra, SearchFloatButton floatButton, List<SearchMiniAppConditonFilter> miniAppConditonFilter, String extData) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(list, "list");
                Intrinsics.checkNotNullParameter(emptyExtra, "emptyExtra");
                Intrinsics.checkNotNullParameter(floatButton, "floatButton");
                Intrinsics.checkNotNullParameter(miniAppConditonFilter, "miniAppConditonFilter");
                MiniAppSearchViewModel.this.pageNum = 0;
                MiniAppSearchViewModel.this.totalCountWithoutTitle = 0;
                MiniAppSearchViewModel.this.preProcessingData(list);
                MiniAppSearchResult miniAppSearchResult = new MiniAppSearchResult(true, keyword, currentTimeMillis, MiniAppSearchViewModel.INSTANCE.filterByType(list).isEmpty(), list, isEnd);
                QLog.i("MiniAppSearchViewModel", 1, "searchMiniApp success, result:" + miniAppSearchResult);
                MiniAppSearchViewModel.this.postProcessExtData(extData);
                mutableLiveData = MiniAppSearchViewModel.this._searchResultData;
                mutableLiveData.postValue(miniAppSearchResult);
            }
        });
    }
}
