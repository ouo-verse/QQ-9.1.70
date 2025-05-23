package com.tencent.mobileqq.search.business.contact;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bl;
import com.tencent.mobileqq.guild.util.cl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberProfileItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wn2.ContactSearchModelNtTroop;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u0005:\u0001\fB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\tH\u0016J:\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u00132\u0006\u0010\n\u001a\u00020\t2\u001c\u0010\u0015\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010(\u001a\u00020#8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R.\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110-0,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00102R\u0016\u00105\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001fR\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001fR\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010F\u001a\u0004\u0018\u00010D8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/NtTroopSearchEngine;", "Lon2/b;", "Lcom/tencent/mobileqq/search/model/k;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/mobileqq/search/business/contact/a;", "Lkotlinx/coroutines/CoroutineScope;", "", "init", "destroy", "Lpn2/a;", "searchRequest", "", "a", "Lon2/d;", "listener", "c", "Ljava/util/concurrent/Future;", "", "i", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "mapFunc", "b", "cancel", "pause", "resume", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupChatInfoResult;", "result", "onSearchGroupChatInfoResult", "", "d", "I", "getFromType", "()I", IProfileCardConst.KEY_FROM_TYPE, "Lkotlin/coroutines/CoroutineContext;", "e", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "f", "Lpn2/a;", "latestSearchRequest", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/util/bl;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "pendingSearch", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "pendingSearchLock", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pendingInfiniteSearchId", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "infiniteSearchListResult", "D", "Lon2/d;", "infiniteSearchListener", "E", "searchId", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "searchWithFutureReportTask", "G", "searchAsyncReportTask", "Lcom/tencent/qqnt/kernel/api/ae;", "()Lcom/tencent/qqnt/kernel/api/ae;", "searchService", "<init>", "(I)V", "H", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NtTroopSearchEngine implements on2.b<com.tencent.mobileqq.search.model.k>, IKernelSearchListener, a<com.tencent.mobileqq.search.model.k>, CoroutineScope {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.search.model.k> infiniteSearchListResult;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private on2.d<com.tencent.mobileqq.search.model.k> infiniteSearchListener;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile int searchId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchWithFutureReportTask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchAsyncReportTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int fromType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private pn2.a latestSearchRequest;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int pendingInfiniteSearchId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext = GuildAIODispatchers.f112358a.b().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Integer, bl<List<com.tencent.mobileqq.search.model.k>>> pendingSearch = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock pendingSearchLock = new ReentrantLock();

    public NtTroopSearchEngine(int i3) {
        this.fromType = i3;
    }

    private final ae h() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getSearchService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(NtTroopSearchEngine this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "searchGroupChatInfo onResult(" + str + ") " + i3);
        IPerformanceReportTask iPerformanceReportTask = this$0.searchAsyncReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "searchGroupChatInfo onResult(" + str + ") " + i3);
    }

    @Override // on2.b
    @NotNull
    public List<com.tencent.mobileqq.search.model.k> a(@NotNull pn2.a searchRequest) {
        Object runBlocking$default;
        List<com.tencent.mobileqq.search.model.k> mutableList;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        this.searchWithFutureReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_group_more_cost");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new NtTroopSearchEngine$search$list$1(this, searchRequest, null), 1, null);
        Intrinsics.checkNotNullExpressionValue(runBlocking$default, "override fun search(sear\u2026        return list\n    }");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) runBlocking$default);
        IPerformanceReportTask iPerformanceReportTask = this.searchWithFutureReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        return mutableList;
    }

    @Override // com.tencent.mobileqq.search.business.contact.a
    @NotNull
    public <R> Future<R> b(@NotNull pn2.a searchRequest, @NotNull Function1<? super List<? extends com.tencent.mobileqq.search.model.k>, ? extends R> mapFunc) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Intrinsics.checkNotNullParameter(mapFunc, "mapFunc");
        Logger logger = Logger.f235387a;
        logger.d().i("NtTroopSearchEngine", 1, "searchAsyncWithMapFunc..... " + searchRequest.f426495a);
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            this.latestSearchRequest = searchRequest;
            ae h16 = h();
            int i3 = 0;
            if (h16 != null) {
                String str = searchRequest.f426495a;
                Intrinsics.checkNotNullExpressionValue(str, "searchRequest.keyword");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
                SearchGroupChatInfoParams searchGroupChatInfoParams = new SearchGroupChatInfoParams();
                searchGroupChatInfoParams.pageLimit = 5;
                Unit unit = Unit.INSTANCE;
                i3 = h16.searchGroupChatInfo(arrayListOf, searchGroupChatInfoParams, -1, new IOperateCallback() { // from class: com.tencent.mobileqq.search.business.contact.o
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i16, String str2) {
                        NtTroopSearchEngine.k(i16, str2);
                    }
                });
            }
            this.searchId = i3;
            cl clVar = new cl(mapFunc);
            this.pendingSearch.put(Integer.valueOf(this.searchId), clVar);
            logger.d().i("NtTroopSearchEngine", 1, "searchAsyncWithMapFunc..... " + this.searchId + " -> " + clVar);
            return clVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // on2.b
    public void c(@NotNull pn2.a searchRequest, @NotNull on2.d<com.tencent.mobileqq.search.model.k> listener) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            Logger.f235387a.d().i("NtTroopSearchEngine", 1, "searchAsync(" + searchRequest + ")");
            String str = searchRequest.f426495a;
            if (str == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(str, "searchRequest.keyword ?: return");
            ae h16 = h();
            if (h16 == null) {
                return;
            }
            if (this.pendingInfiniteSearchId != 0) {
                cancel();
            }
            this.searchAsyncReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_group_more_cost");
            this.infiniteSearchListener = listener;
            this.latestSearchRequest = searchRequest;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            this.pendingInfiniteSearchId = h16.searchGroupChatInfo(arrayListOf, new SearchGroupChatInfoParams(), -1, new IOperateCallback() { // from class: com.tencent.mobileqq.search.business.contact.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    NtTroopSearchEngine.j(NtTroopSearchEngine.this, i3, str2);
                }
            });
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // on2.b
    public void cancel() {
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "cancel() searchId=" + this.searchId + " pendingInfiniteSearchId=" + this.pendingInfiniteSearchId);
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            if (this.searchId != 0) {
                ae h16 = h();
                if (h16 != null) {
                    h16.cancelSearchGroupChatInfo(this.searchId, 0, "cancel");
                }
                bl<List<com.tencent.mobileqq.search.model.k>> blVar = this.pendingSearch.get(Integer.valueOf(this.searchId));
                if (blVar != null) {
                    blVar.cancel(true);
                }
                this.pendingSearch.remove(Integer.valueOf(this.searchId));
                this.searchId = 0;
            }
            if (this.pendingInfiniteSearchId != 0) {
                ae h17 = h();
                if (h17 != null) {
                    h17.cancelSearchGroupChatInfo(this.pendingInfiniteSearchId, 0, "cancel");
                }
                this.pendingInfiniteSearchId = 0;
                on2.d<com.tencent.mobileqq.search.model.k> dVar = this.infiniteSearchListener;
                if (dVar != null) {
                    List<com.tencent.mobileqq.search.model.k> list = this.infiniteSearchListResult;
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    dVar.onFinish(list, 0);
                }
                this.infiniteSearchListener = null;
                this.infiniteSearchListResult = null;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // on2.b
    public void destroy() {
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "destroy()");
        ae h16 = h();
        if (h16 != null) {
            h16.q0(this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @NotNull
    public Future<List<com.tencent.mobileqq.search.model.k>> i(@NotNull pn2.a searchRequest) {
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "searchAsync..... " + searchRequest.f426495a);
        return b(searchRequest, new Function1<List<? extends com.tencent.mobileqq.search.model.k>, List<? extends com.tencent.mobileqq.search.model.k>>() { // from class: com.tencent.mobileqq.search.business.contact.NtTroopSearchEngine$searchAsync$3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final List<com.tencent.mobileqq.search.model.k> invoke(@Nullable List<? extends com.tencent.mobileqq.search.model.k> list) {
                return list;
            }
        });
    }

    @Override // on2.b
    public void init() {
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "init()");
        ae h16 = h();
        if (h16 != null) {
            h16.addKernelSearchListener(this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchAtMeChatsResult(SearchAtMeChatsResult searchAtMeChatsResult) {
        bm.a(this, searchAtMeChatsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchAtMeMsgsResult(SearchAtMeMsgsResult searchAtMeMsgsResult) {
        bm.b(this, searchAtMeMsgsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchBuddyChatInfoResult(SearchBuddyChatInfoResult searchBuddyChatInfoResult) {
        bm.c(this, searchBuddyChatInfoResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchCacheResult(String str, String str2, ArrayList arrayList) {
        bm.d(this, str, str2, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchChatsKeywordsResult(SearchChatsKeywordsResult searchChatsKeywordsResult) {
        bm.e(this, searchChatsKeywordsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchContactResult(SearchContactResult searchContactResult) {
        bm.f(this, searchContactResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchFileKeywordsResult(SearchFileKeywordsResult searchFileKeywordsResult) {
        bm.g(this, searchFileKeywordsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchFunctionResult(SearchFunctionResult searchFunctionResult) {
        bm.h(this, searchFunctionResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public void onSearchGroupChatInfoResult(@NotNull SearchGroupChatInfoResult result) {
        Serializable[] serializableArr;
        Intrinsics.checkNotNullParameter(result, "result");
        Logger.f235387a.d().i("NtTroopSearchEngine", 1, "onSearchGroupChatInfoResult() hasMore: " + result.hasMore + ", " + this.searchId + "/" + result.searchId + ", " + result);
        bm.i(this, result);
        ArrayList arrayList = new ArrayList();
        int i3 = result.searchId;
        ArrayList<SearchGroupItem> arrayList2 = result.resultItems;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "result.resultItems");
        Iterator<T> it = arrayList2.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            SearchGroupItem searchGroupItem = (SearchGroupItem) it.next();
            ContactSearchModelNtTroop contactSearchModelNtTroop = new ContactSearchModelNtTroop(this.fromType, 0L);
            pn2.a aVar = this.latestSearchRequest;
            if (aVar != null) {
                str = aVar.f426495a;
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "latestSearchRequest?.keyword ?: \"\"");
            }
            contactSearchModelNtTroop.keyword = str;
            String str2 = searchGroupItem.groupInfo.groupName;
            Intrinsics.checkNotNullExpressionValue(str2, "item.groupInfo.groupName");
            contactSearchModelNtTroop.title = str2;
            contactSearchModelNtTroop.Z(String.valueOf(searchGroupItem.groupInfo.groupCode));
            String str3 = searchGroupItem.groupInfo.remarkName;
            Intrinsics.checkNotNullExpressionValue(str3, "item.groupInfo.remarkName");
            contactSearchModelNtTroop.i0(str3);
            ArrayList<SearchHitInfo> arrayList3 = searchGroupItem.groupInfo.remarkNameHits;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "item.groupInfo.remarkNameHits");
            contactSearchModelNtTroop.j0(arrayList3);
            String str4 = searchGroupItem.groupInfo.groupName;
            Intrinsics.checkNotNullExpressionValue(str4, "item.groupInfo.groupName");
            contactSearchModelNtTroop.b0(str4);
            ArrayList<SearchHitInfo> arrayList4 = searchGroupItem.groupInfo.groupNameHits;
            Intrinsics.checkNotNullExpressionValue(arrayList4, "item.groupInfo.groupNameHits");
            contactSearchModelNtTroop.c0(arrayList4);
            ArrayList<SearchHitInfo> arrayList5 = searchGroupItem.groupInfo.groupCodeHits;
            Intrinsics.checkNotNullExpressionValue(arrayList5, "item.groupInfo.groupCodeHits");
            contactSearchModelNtTroop.a0(arrayList5);
            contactSearchModelNtTroop.Y(searchGroupItem.groupInfo.isConf);
            contactSearchModelNtTroop.e0(searchGroupItem.groupInfo.noCodeFingerOpenFlag);
            contactSearchModelNtTroop.d0(searchGroupItem.groupInfo.memberCount);
            ArrayList<SearchGroupMemberProfileItem> arrayList6 = searchGroupItem.memberProfile;
            Intrinsics.checkNotNullExpressionValue(arrayList6, "item.memberProfile");
            for (SearchGroupMemberProfileItem searchGroupMemberProfileItem : arrayList6) {
                Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.remarkHits, "profile.remarkHits");
                if (!r8.isEmpty()) {
                    serializableArr = new Serializable[]{searchGroupMemberProfileItem.remark, searchGroupMemberProfileItem.remarkHits, 3};
                } else {
                    Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.cardNameHits, "profile.cardNameHits");
                    if (!r8.isEmpty()) {
                        serializableArr = new Serializable[]{searchGroupMemberProfileItem.cardName, searchGroupMemberProfileItem.cardNameHits, 1};
                    } else {
                        Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.nickHits, "profile.nickHits");
                        if (!r8.isEmpty()) {
                            serializableArr = new Serializable[]{searchGroupMemberProfileItem.nick, searchGroupMemberProfileItem.nickHits, 2};
                        } else {
                            serializableArr = new Serializable[]{String.valueOf(searchGroupMemberProfileItem.uin), searchGroupMemberProfileItem.uinHits, 4};
                        }
                    }
                }
                Serializable serializable = serializableArr[0];
                Serializable serializable2 = serializableArr[1];
                Serializable serializable3 = serializableArr[2];
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.String");
                Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo> }");
                Intrinsics.checkNotNull(serializable3, "null cannot be cast to non-null type kotlin.Int");
                contactSearchModelNtTroop.R((String) serializable, (ArrayList) serializable2, ((Integer) serializable3).intValue());
            }
            contactSearchModelNtTroop.S();
            arrayList.add(contactSearchModelNtTroop);
        }
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            bl<List<com.tencent.mobileqq.search.model.k>> blVar = this.pendingSearch.get(Integer.valueOf(i3));
            if (blVar != null) {
                blVar.complete(arrayList);
                this.pendingSearch.remove(Integer.valueOf(i3));
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str5 = "onSearchGroupChatInfoResult() " + i3;
                if (str5 instanceof String) {
                    bVar.a().add(str5);
                }
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("NtTroopSearchEngine", 1, (String) it5.next(), null);
                }
                rn2.a.a("NtTroopSearchEngine", "async result: ", arrayList);
                Unit unit = Unit.INSTANCE;
            } else if (i3 == this.pendingInfiniteSearchId) {
                List<com.tencent.mobileqq.search.model.k> list = this.infiniteSearchListResult;
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.addAll(arrayList);
                if (result.hasMore) {
                    on2.d<com.tencent.mobileqq.search.model.k> dVar = this.infiniteSearchListener;
                    if (dVar != null) {
                        dVar.onUpdate(list);
                    }
                    this.infiniteSearchListResult = list;
                    ae h16 = h();
                    if (h16 != null) {
                        h16.searchMoreGroupChatInfo(i3);
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    on2.d<com.tencent.mobileqq.search.model.k> dVar2 = this.infiniteSearchListener;
                    if (dVar2 != null) {
                        dVar2.onFinish(list, 1);
                    }
                    this.infiniteSearchListResult = list;
                    rn2.a.a("NtTroopSearchEngine", "details result: ", list);
                    Unit unit3 = Unit.INSTANCE;
                }
            } else {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str6 = "onSearchGroupChatInfoResult() " + i3 + " can not find future??";
                if (str6 instanceof String) {
                    bVar2.a().add(str6);
                }
                Iterator<T> it6 = bVar2.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("NtTroopSearchEngine", 1, (String) it6.next(), null);
                }
                Unit unit4 = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchGroupResult(SearchGroupResult searchGroupResult) {
        bm.j(this, searchGroupResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchLocalInfoResult(SearchLocalInfoResult searchLocalInfoResult) {
        bm.k(this, searchLocalInfoResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchMsgKeywordsResult(SearchMsgKeywordsResult searchMsgKeywordsResult) {
        bm.l(this, searchMsgKeywordsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchResult(SearchResult searchResult) {
        bm.m(this, searchResult);
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
