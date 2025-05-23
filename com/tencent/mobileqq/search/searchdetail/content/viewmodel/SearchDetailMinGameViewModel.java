package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreType;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.util.ap;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\r\b\u0016\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J(\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailMinGameViewModel;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "filter", "", "Y2", "", QzoneIPCModule.RESULT_CODE, "", "filters", "", "fromLoadMore", "B2", "", "keyword", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "loadMoreType", "source", NowProxyConstants.AccountInfoKey.A2, "context", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "refreshType", "R2", "W2", ICustomDataEditor.NUMBER_PARAM_2, "W", "Ljava/lang/String;", "currentSource", "X", "currentKeyword", "Y", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "currentMiniAppConditionFilter", "", "Z", "Ljava/util/List;", "minAppFilters", "a0", "Lkotlin/Lazy;", "getSessionId", "()Ljava/lang/String;", "sessionId", "<init>", "()V", "b0", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class SearchDetailMinGameViewModel extends k {

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private SearchMiniAppConditonFilter currentMiniAppConditionFilter;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sessionId;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String currentSource = "";

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String currentKeyword = "";

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final List<SearchMiniAppConditonFilter> minAppFilters = new ArrayList();

    public SearchDetailMinGameViewModel() {
        Lazy lazy;
        U2(SearchPageType.PAGE_NET_SEARCH_MINI_GAME_MORE);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailMinGameViewModel$sessionId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return System.currentTimeMillis() + "_" + ap.f285014a.a();
            }
        });
        this.sessionId = lazy;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void A2(@NotNull String keyword, @NotNull LoadMoreType loadMoreType, @NotNull String source) {
        Object obj;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.currentMiniAppConditionFilter == null) {
            Iterator<T> it = this.minAppFilters.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    boolean z16 = true;
                    if (((SearchMiniAppConditonFilter) obj).selected != 1) {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            this.currentMiniAppConditionFilter = (SearchMiniAppConditonFilter) obj;
        }
        super.A2(keyword, loadMoreType, source);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void B2(int resultCode, @Nullable List<SearchMiniAppConditonFilter> filters, boolean fromLoadMore) {
        List<SearchMiniAppConditonFilter> list;
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailMinGameViewModel", 1, "onConditionFilterRsp resultCode:" + resultCode + " filters:" + filters + " fromLoadMore:" + fromLoadMore);
        if (fromLoadMore) {
            this.currentMiniAppConditionFilter = null;
            return;
        }
        if (resultCode == 0) {
            if (this.currentMiniAppConditionFilter == null) {
                this.minAppFilters.clear();
                List<SearchMiniAppConditonFilter> list2 = this.minAppFilters;
                if (filters == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    list = filters;
                }
                list2.addAll(list);
            } else {
                Iterator<T> it = this.minAppFilters.iterator();
                while (it.hasNext()) {
                    ((SearchMiniAppConditonFilter) it.next()).selected = 0;
                }
                SearchMiniAppConditonFilter searchMiniAppConditonFilter = this.currentMiniAppConditionFilter;
                if (searchMiniAppConditonFilter != null) {
                    searchMiniAppConditonFilter.selected = 1;
                }
            }
        } else {
            this.minAppFilters.clear();
        }
        this.currentMiniAppConditionFilter = null;
        super.B2(resultCode, filters, fromLoadMore);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void R2(@NotNull Activity context, @NotNull String keyword, @NotNull RefreshType refreshType, @NotNull String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!TextUtils.equals(keyword, this.currentKeyword)) {
            this.currentMiniAppConditionFilter = null;
            this.minAppFilters.clear();
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailMinGameViewModel", 1, "startLoad change keyword:" + keyword);
        }
        if (refreshType == RefreshType.TYPE_FINGER_PULL2REFRESH || refreshType == RefreshType.TYPE_USER_INPUT_SEARCH) {
            this.currentMiniAppConditionFilter = null;
            this.minAppFilters.clear();
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailMinGameViewModel", 1, "startLoad from pull2Refresh");
        }
        this.currentKeyword = keyword;
        this.currentSource = source;
        super.R2(context, keyword, refreshType, source);
    }

    @NotNull
    public final List<SearchMiniAppConditonFilter> W2() {
        return this.minAppFilters;
    }

    public final void Y2(@NotNull Activity activity, @NotNull SearchMiniAppConditonFilter filter) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.currentMiniAppConditionFilter = filter;
        if (filter != null) {
            filter.selected = 1;
        }
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData != null) {
            List<com.tencent.mobileqq.search.searchdetail.c> g26 = g2(new Function1<com.tencent.mobileqq.search.searchdetail.c, Boolean>() { // from class: com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailMinGameViewModel$setCurrentMiniAppFilter$1$wxAppItems$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull com.tencent.mobileqq.search.searchdetail.c it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b);
                }
            });
            if (!g26.isEmpty()) {
                com.tencent.mobileqq.search.searchdetail.c cVar = g26.get(0);
                Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.wxminapp.NetWXMiniAppDetailItem");
                qp2.a backEndReportInfo = ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) cVar).getBackEndReportInfo();
                if (backEndReportInfo == null || (str = backEndReportInfo.getSearchId()) == null) {
                    str = "";
                }
                pageData.t(str);
            }
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailMinGameViewModel", 1, "setCurrentMiniAppFilter wxPreSearchId:" + pageData.getWxPreSearchId());
            pageData.p(6);
            T2(pageData, getSessionId());
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailMinGameViewModel", 1, "setCurrentMiniAppFilter currentMiniAppConditionFilter:" + this.currentMiniAppConditionFilter);
        R2(activity, this.currentKeyword, RefreshType.TYPE_FIRST_RENDER_SEARCH, this.currentSource);
    }

    @NotNull
    public final String getSessionId() {
        return (String) this.sessionId.getValue();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    @Nullable
    /* renamed from: n2, reason: from getter */
    public SearchMiniAppConditonFilter getCurrentMiniAppConditionFilter() {
        return this.currentMiniAppConditionFilter;
    }
}
