package com.tencent.mobileqq.search.searchdetail.tablist;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.api.ISearchDetailAppendDataService;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterConditionLocal;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterManager;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.mobileqq.search.util.ak;
import com.tencent.mobileqq.search.util.n;
import com.tencent.qqnt.kernel.nativeinterface.IGetNetResultTabsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetResultTabsReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetResultTabsRsp;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabInfo;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "condition", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SearchDetailTabListViewModel$loadTabs$1 extends Lambda implements Function1<SearchGroupFilterConditionLocal, Unit> {
    final /* synthetic */ int $querySource;
    final /* synthetic */ SearchDetailTabListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchDetailTabListViewModel$loadTabs$1(SearchDetailTabListViewModel searchDetailTabListViewModel, int i3) {
        super(1);
        this.this$0 = searchDetailTabListViewModel;
        this.$querySource = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IPerformanceReportTask reportTask, long j3, SearchDetailTabListViewModel this$0, int i3, String errorMsg, SearchNetResultTabsRsp searchNetResultTabsRsp) {
        ISearchDetailAppendDataService iSearchDetailAppendDataService;
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        reportTask.setResultCode(i3);
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        reportTask.setResultMsg(errorMsg);
        reportTask.report();
        ak.d("0x9196_1", System.currentTimeMillis() - j3, i3, null, false, 24, null);
        com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.c(this$0.getPageParam().getTabMask());
        if (!n.e(i3)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getNetResultTabs error " + i3 + "_" + errorMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabListViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<SearchTabInfo> tabs = searchNetResultTabsRsp.getTabs();
        Intrinsics.checkNotNullExpressionValue(tabs, "rsp.getTabs()");
        for (SearchTabInfo searchTabInfo : tabs) {
            String str2 = searchTabInfo.tabName;
            Intrinsics.checkNotNullExpressionValue(str2, "it.tabName");
            arrayList.add(new SearchDetailTabListViewModel.TabInfo(str2, searchTabInfo.tabMask));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSearchDetailAppendDataService = (ISearchDetailAppendDataService) peekAppRuntime.getRuntimeService(ISearchDetailAppendDataService.class, "")) != null) {
            iSearchDetailAppendDataService.setAppendIntervalTime(searchNetResultTabsRsp.getIntervalTime());
        }
        SearchGroupFilterManager.f283869a.h(searchNetResultTabsRsp.groupFilterCondition);
        ah ahVar = ah.f284994a;
        ahVar.m("SEARCH_MAX_HISTORY_COUNT", searchNetResultTabsRsp.searchHistoryCount);
        ahVar.q(new SearchDetailTabListViewModel.Tabs(arrayList));
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListViewModel", 1, "getNetResultTabs intervalTime=" + searchNetResultTabsRsp.getIntervalTime() + " maxHistoryCount=" + searchNetResultTabsRsp.searchHistoryCount + " tab count=" + arrayList.size());
        this$0.d2(arrayList);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchGroupFilterConditionLocal searchGroupFilterConditionLocal) {
        invoke2(searchGroupFilterConditionLocal);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SearchGroupFilterConditionLocal condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        SearchDetailTabListViewModel searchDetailTabListViewModel = this.this$0;
        r rVar = r.f284572a;
        searchDetailTabListViewModel.a2(rVar.f());
        SearchNetResultTabsReq searchNetResultTabsReq = new SearchNetResultTabsReq();
        searchNetResultTabsReq.version = AppSetting.getSubVersion();
        searchNetResultTabsReq.deviceInfo = rVar.i();
        byte[] bytes = r.k(rVar, this.$querySource, this.this$0.getPageParam().getUserSource(), this.this$0.getCurrentTraceId(), null, "", "", 0, this.this$0.getPageParam().getPageMode(), null, false, 776, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        searchNetResultTabsReq.bytesExtension = bytes;
        searchNetResultTabsReq.geoInfoVersion = condition.getGeoInfoVersion();
        com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.g(this.this$0.getPageParam().getTabMask());
        final long currentTimeMillis = System.currentTimeMillis();
        final IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_result_tabs_request_quality");
        a16.setExtra("searchReqTraceId", this.this$0.getCurrentTraceId());
        a16.setExtra(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, Integer.valueOf(this.$querySource));
        a16.setExtra("userSource", Integer.valueOf(this.this$0.getPageParam().getUserSource()));
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            final SearchDetailTabListViewModel searchDetailTabListViewModel2 = this.this$0;
            c16.getNetResultTabs(searchNetResultTabsReq, new IGetNetResultTabsCallback() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetNetResultTabsCallback
                public final void onResult(int i3, String str, SearchNetResultTabsRsp searchNetResultTabsRsp) {
                    SearchDetailTabListViewModel$loadTabs$1.b(IPerformanceReportTask.this, currentTimeMillis, searchDetailTabListViewModel2, i3, str, searchNetResultTabsRsp);
                }
            });
        }
    }
}
