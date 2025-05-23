package com.tencent.mobileqq.search.searchdetail.content.repo;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.api.ISearchDetailAppendDataService;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchAppendingInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.SearchAppendingInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchAppendingInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.SearchAppendingItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabInfo;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0013j\b\u0012\u0004\u0012\u00020\u0006`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/repo/e;", "", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", "inPageData", "", "c", "", "guildId", "docId", "keyword", "currentTraceId", "", "forceReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSearchAppendingInfoCallback;", "callback", "b", "a", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", ISchemeApi.KEY_PAGE_DATA, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "appendGuildList", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SearchDetailTabContentFragment.PageData pageData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> appendGuildList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/repo/e$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSearchAppendingInfoCallback;", "", "errorCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAppendingInfoRsp;", "rsp", "", "onResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements IGetSearchAppendingInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetSearchAppendingInfoCallback f284073a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f284074b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f284075c;

        b(IGetSearchAppendingInfoCallback iGetSearchAppendingInfoCallback, String str, String str2) {
            this.f284073a = iGetSearchAppendingInfoCallback;
            this.f284074b = str;
            this.f284075c = str2;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSearchAppendingInfoCallback
        public void onResult(int errorCode, @Nullable String errMsg, @Nullable SearchAppendingInfoRsp rsp) {
            Logger logger = Logger.f235387a;
            String str = this.f284074b;
            String str2 = this.f284075c;
            logger.d().i("QQSearch.NetDetail.SearchDetailTabAppendRepo", 1, "getSearchAppendingInfo " + str + " " + str2 + " errorCode=" + errorCode + ", " + errMsg);
            this.f284073a.onResult(errorCode, errMsg, rsp);
        }
    }

    public final void a() {
        this.appendGuildList.clear();
    }

    public final void b(@NotNull String guildId, @NotNull String docId, @NotNull String keyword, @NotNull String currentTraceId, boolean forceReq, @NotNull IGetSearchAppendingInfoCallback callback) {
        ISearchDetailAppendDataService iSearchDetailAppendDataService;
        int i3;
        int i16;
        int i17;
        long j3;
        String str;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        SearchDetailTabListViewModel.TabInfo tabInfo2;
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.appendGuildList.contains(guildId)) {
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabAppendRepo", 1, "already request append! " + guildId + " " + docId);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            Logger.f235387a.d().w("QQSearch.NetDetail.SearchDetailTabAppendRepo", 1, "no net can't append! " + guildId + " " + docId);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        if (peekAppRuntime != null) {
            iSearchDetailAppendDataService = (ISearchDetailAppendDataService) peekAppRuntime.getRuntimeService(ISearchDetailAppendDataService.class, "");
        } else {
            iSearchDetailAppendDataService = null;
        }
        if (!forceReq) {
            if (iSearchDetailAppendDataService != null && iSearchDetailAppendDataService.canReqAppendData()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.f235387a.d().w("QQSearch.NetDetail.SearchDetailTabAppendRepo", 1, "can't request append too freq! " + guildId + " " + docId);
                return;
            }
        }
        if (iSearchDetailAppendDataService != null) {
            iSearchDetailAppendDataService.setLatestAppendTime(System.currentTimeMillis());
        }
        this.appendGuildList.add(guildId);
        SearchAppendingInfoReq searchAppendingInfoReq = new SearchAppendingInfoReq();
        r rVar = r.f284572a;
        SearchDetailTabContentFragment.PageData pageData = this.pageData;
        if (pageData != null) {
            i3 = pageData.getQuerySource();
        } else {
            i3 = 0;
        }
        SearchDetailTabContentFragment.PageData pageData2 = this.pageData;
        if (pageData2 != null) {
            i16 = pageData2.getUserSource();
        } else {
            i16 = 0;
        }
        SearchDetailTabContentFragment.PageData pageData3 = this.pageData;
        if (pageData3 != null) {
            i17 = pageData3.getPageMode();
        } else {
            i17 = 0;
        }
        searchAppendingInfoReq.stringExtension = rVar.m(i3, i16, currentTraceId, "", i17);
        SearchTabInfo searchTabInfo = new SearchTabInfo();
        SearchDetailTabContentFragment.PageData pageData4 = this.pageData;
        if (pageData4 != null && (tabInfo2 = pageData4.getTabInfo()) != null) {
            j3 = tabInfo2.getTabMask();
        } else {
            j3 = 0;
        }
        searchTabInfo.tabMask = j3;
        SearchDetailTabContentFragment.PageData pageData5 = this.pageData;
        if (pageData5 == null || (tabInfo = pageData5.getTabInfo()) == null || (str = tabInfo.getTabName()) == null) {
            str = "";
        }
        searchTabInfo.tabName = str;
        searchAppendingInfoReq.tabInfo = searchTabInfo;
        searchAppendingInfoReq.keyword = keyword;
        searchAppendingInfoReq.version = AppSetting.getSubVersion();
        SearchAppendingItem searchAppendingItem = new SearchAppendingItem();
        searchAppendingItem.cardInfoId = guildId;
        searchAppendingItem.docId = docId;
        searchAppendingItem.itemType = 1;
        searchAppendingInfoReq.items.add(searchAppendingItem);
        Logger logger = Logger.f235387a;
        logger.d().i("QQSearch.NetDetail.SearchDetailTabAppendRepo", 1, "getSearchAppendingInfo start forceReq=" + forceReq + " tabInfo=" + searchTabInfo + " guildId=" + guildId + " " + docId);
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.getSearchAppendingInfo(searchAppendingInfoReq, new b(callback, guildId, docId));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            logger.d().w("QQSearch.NetDetail.SearchDetailTabAppendRepo", 1, "getSearchAppendingInfo service is null");
        }
    }

    public final void c(@NotNull SearchDetailTabContentFragment.PageData inPageData) {
        Intrinsics.checkNotNullParameter(inPageData, "inPageData");
        this.pageData = inPageData;
    }
}
