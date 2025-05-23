package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.bl;
import com.tencent.mobileqq.guild.util.cl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatAtMeMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgWithKeywordsParams;
import com.tencent.qqnt.search.api.ISearchEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0006\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001cB\u000f\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KJ\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J@\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u0012H\u0002J@\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u0012H\u0002J@\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u0012H\u0002J@\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0017J\b\u0010\u001a\u001a\u00020\u0014H\u0017J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017J\"\u0010\u001d\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0017J\u001e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004H\u0017J\"\u0010#\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J:\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010$2\u0006\u0010\u000e\u001a\u00020\r2\u001c\u0010&\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00018\u00000%H\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00100R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00100R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00100R.\u0010=\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0:098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010D\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/search/ftsmsg/NTFtsMessageSearchEngine;", "Lep2/b;", "Lcom/tencent/mobileqq/search/business/contact/a;", "Lep2/d;", "Lon2/d;", "listener", "com/tencent/mobileqq/search/ftsmsg/NTFtsMessageSearchEngine$b", "l", "(Lon2/d;)Lcom/tencent/mobileqq/search/ftsmsg/NTFtsMessageSearchEngine$b;", "", "chatType", "", "k", "Lpn2/a;", "searchRequest", "", "keyword", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "splitKeywords", "", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "cancel", "destroy", "", "a", "c", "Lep2/c;", "e", "", "Lcom/tencent/mobileqq/fts/v1/FTSEntity;", "entities", "f", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "mapFunc", "Ljava/util/concurrent/Future;", "b", "Lcom/tencent/qqnt/search/api/ISearchEngine;", "d", "Lcom/tencent/qqnt/search/api/ISearchEngine;", "searchRuntimeService", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "I", "searchLocalQueryId", tl.h.F, "searchChatQueryId", "i", "searchMsgQueryId", "searchAtMeChatQueryId", BdhLogUtil.LogTag.Tag_Conn, "searchAtMeMsgsQueryId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/util/bl;", "D", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingSearch", "Ljava/util/concurrent/locks/ReentrantLock;", "E", "Ljava/util/concurrent/locks/ReentrantLock;", "pendingSearchLock", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "searchWithFutureReportTask", "G", "searchAsyncReportTask", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "H", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NTFtsMessageSearchEngine extends ep2.b implements com.tencent.mobileqq.search.business.contact.a<ep2.d> {

    /* renamed from: C, reason: from kotlin metadata */
    private int searchAtMeMsgsQueryId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Integer, bl<List<ep2.d>>> pendingSearch;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ReentrantLock pendingSearchLock;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchWithFutureReportTask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchAsyncReportTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISearchEngine searchRuntimeService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int searchLocalQueryId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int searchChatQueryId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int searchMsgQueryId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int searchAtMeChatQueryId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IRuntimeService runtimeService = app.getRuntimeService(ISearchEngine.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IS\u2026ava, ProcessConstant.ALL)");
        this.searchRuntimeService = (ISearchEngine) runtimeService;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.pendingSearch = new ConcurrentHashMap<>();
        this.pendingSearchLock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(int chatType) {
        return true;
    }

    private final b l(on2.d<ep2.d> listener) {
        return new b(listener, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(pn2.a searchRequest, on2.d<ep2.d> listener, String keyword, ArrayList<String> splitKeywords) {
        int searchAtMeChats;
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        Flow<SearchAtMeChatsResult> searchAtMeChatsResultFlow = this.searchRuntimeService.searchAtMeChatsResultFlow();
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("NTFtsMessageSearchEngine", 1, "searchChatAsynct, request.extra:" + searchRequest.f426496b);
        }
        Bundle bundle = searchRequest.f426496b;
        if (bundle != null && bundle.containsKey("queryId")) {
            searchAtMeChats = searchRequest.f426496b.getInt("queryId");
            this.searchRuntimeService.searchMoreAtMeChats(searchAtMeChats);
            z16 = false;
        } else {
            searchAtMeChats = this.searchRuntimeService.searchAtMeChats(true, 10, 0);
            this.searchAtMeChatQueryId = searchAtMeChats;
        }
        Bundle bundle2 = searchRequest.f426496b;
        if (bundle2 != null) {
            intRef.element = bundle2.getInt("search_req_key_dt_refer_page");
            String string = searchRequest.f426496b.getString("search_req_key_trace_id");
            T t16 = str;
            if (string != null) {
                t16 = string;
            }
            objectRef.element = t16;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTFtsMessageSearchEngine$searchAtMeChatsAsync$1(searchAtMeChatsResultFlow, searchAtMeChats, z16, listener, keyword, splitKeywords, intRef, objectRef, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(pn2.a searchRequest, on2.d<ep2.d> listener, String keyword, ArrayList<String> splitKeywords) {
        int i3;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        Flow<SearchAtMeMsgsResult> searchAtMeMsgsResultFlow = this.searchRuntimeService.searchAtMeMsgsResultFlow();
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("NTFtsMessageSearchEngine", 1, "searchChatAsynct, request.extra:" + searchRequest.f426496b);
        }
        Bundle bundle = searchRequest.f426496b;
        if (bundle != null) {
            String string = bundle.getString("search_req_key_peerId");
            T t16 = str;
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(SEARCH_REQ_KEY_PEERID)?:\"\"");
                t16 = string;
            }
            objectRef.element = t16;
        }
        Bundle bundle2 = searchRequest.f426496b;
        if (bundle2 != null && bundle2.containsKey("queryId")) {
            int i16 = searchRequest.f426496b.getInt("queryId");
            this.searchRuntimeService.searchMoreChatAtMeMsgs(i16);
            i3 = i16;
            z16 = false;
        } else {
            SearchChatAtMeMsgsParams searchChatAtMeMsgsParams = new SearchChatAtMeMsgsParams();
            searchChatAtMeMsgsParams.peerUid = (String) objectRef.element;
            searchChatAtMeMsgsParams.includeAtAll = true;
            searchChatAtMeMsgsParams.pageLimit = 10;
            int searchChatAtMeMsgs = this.searchRuntimeService.searchChatAtMeMsgs(searchChatAtMeMsgsParams);
            this.searchAtMeMsgsQueryId = searchChatAtMeMsgs;
            i3 = searchChatAtMeMsgs;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2(searchAtMeMsgsResultFlow, i3, z16, listener, keyword, splitKeywords, objectRef, null), 3, null);
    }

    private final void o(pn2.a searchRequest, on2.d<ep2.d> listener, String keyword, ArrayList<String> splitKeywords) {
        ArrayList<String> arrayListOf;
        int searchChat;
        Flow<SearchChatsKeywordsResult> searchChatResultFlow = this.searchRuntimeService.searchChatResultFlow();
        Bundle bundle = searchRequest.f426496b;
        boolean z16 = false;
        if (bundle != null && bundle.containsKey("queryId")) {
            searchChat = searchRequest.f426496b.getInt("queryId");
            this.searchRuntimeService.searchMoreChat(searchChat);
        } else {
            ISearchEngine iSearchEngine = this.searchRuntimeService;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keyword);
            searchChat = iSearchEngine.searchChat(arrayListOf, 10);
            this.searchChatQueryId = searchChat;
            z16 = true;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTFtsMessageSearchEngine$searchChatAsync$1(searchChatResultFlow, searchChat, z16, listener, keyword, this, splitKeywords, 10, null), 3, null);
    }

    private final void p(pn2.a searchRequest, on2.d<ep2.d> listener, String keyword, ArrayList<String> splitKeywords) {
        Flow<SearchLocalInfoResult> searchLocalInfoResultFlow = this.searchRuntimeService.searchLocalInfoResultFlow();
        int searchLocalInfo = this.searchRuntimeService.searchLocalInfo(keyword, SearchLocalBusinessType.KSEARCHLOCALBUSINESSTYPEMQQALL);
        this.searchLocalQueryId = searchLocalInfo;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTFtsMessageSearchEngine$searchLocalInfoAsync$1(searchLocalInfoResultFlow, searchLocalInfo, keyword, listener, this, splitKeywords, null), 3, null);
    }

    @Override // on2.b
    @WorkerThread
    @NotNull
    public List<ep2.d> a(@Nullable pn2.a searchRequest) {
        String str;
        String str2;
        List<ep2.d> emptyList;
        Object runBlocking$default;
        List<ep2.d> emptyList2;
        ArrayList<SearchChatSummaryItem> arrayList;
        int collectionSizeOrDefault;
        ep2.d bVar;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QLog.d("NTFtsMessageSearchEngine", 1, "#search: begin search, keyword=" + str);
        this.searchWithFutureReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_chat_more_cost");
        if (searchRequest != null) {
            str2 = searchRequest.f426495a;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return new ArrayList();
        }
        ArrayList<String> l3 = vy2.b.l(str2);
        Flow buffer = FlowKt.buffer(this.searchRuntimeService.searchLocalInfoResultFlow(), 4, BufferOverflow.DROP_OLDEST);
        int searchLocalInfo = this.searchRuntimeService.searchLocalInfo(str2, SearchLocalBusinessType.KSEARCHLOCALBUSINESSTYPEMQQALL);
        this.searchLocalQueryId = searchLocalInfo;
        try {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new NTFtsMessageSearchEngine$search$result$1(buffer, searchLocalInfo, null), 1, null);
            SearchLocalInfoResult searchLocalInfoResult = (SearchLocalInfoResult) runBlocking$default;
            QLog.d("NTFtsMessageSearchEngine", 1, "#search finish search");
            if (searchLocalInfoResult == null || (arrayList = searchLocalInfoResult.chatsSummary) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList<SearchChatSummaryItem> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (k(((SearchChatSummaryItem) obj).chatType)) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                emptyList2 = new ArrayList<>(collectionSizeOrDefault);
                for (SearchChatSummaryItem it : arrayList2) {
                    if (it.chatType == 105) {
                        AppInterface d16 = d();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        bVar = new vn2.c(d16, str2, null, l3, null, it, searchLocalInfo);
                    } else {
                        AppInterface d17 = d();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        String str3 = it.recallReason;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.recallReason");
                        bVar = new vn2.b(d17, str2, null, l3, null, it, searchLocalInfo, str3);
                    }
                    emptyList2.add(bVar);
                }
            }
            QLog.d("NTFtsMessageSearchEngine", 1, "#search finish, data size=" + emptyList2.size());
            IPerformanceReportTask iPerformanceReportTask = this.searchWithFutureReportTask;
            if (iPerformanceReportTask != null) {
                iPerformanceReportTask.setExtra("size", Integer.valueOf(emptyList2.size()));
            }
            IPerformanceReportTask iPerformanceReportTask2 = this.searchWithFutureReportTask;
            if (iPerformanceReportTask2 != null) {
                iPerformanceReportTask2.report();
            }
            return emptyList2;
        } catch (InterruptedException e16) {
            QLog.w("NTFtsMessageSearchEngine", 1, "search but InterruptedException", e16);
            IPerformanceReportTask iPerformanceReportTask3 = this.searchWithFutureReportTask;
            if (iPerformanceReportTask3 != null) {
                iPerformanceReportTask3.report();
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @Override // com.tencent.mobileqq.search.business.contact.a
    @NotNull
    public <R> Future<R> b(@NotNull pn2.a searchRequest, @NotNull Function1<? super List<? extends ep2.d>, ? extends R> mapFunc) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Intrinsics.checkNotNullParameter(mapFunc, "mapFunc");
        String str = searchRequest.f426495a;
        if (str == null) {
            str = "";
        }
        QLog.d("NTFtsMessageSearchEngine", 1, "#search: begin search, keyword=" + str);
        cl clVar = new cl(mapFunc);
        String str2 = searchRequest.f426495a;
        Intrinsics.checkNotNullExpressionValue(str2, "searchRequest.keyword");
        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
        if (isBlank) {
            clVar.complete(new ArrayList());
            return clVar;
        }
        String str3 = searchRequest.f426495a;
        ArrayList<String> l3 = vy2.b.l(str3);
        Flow buffer = FlowKt.buffer(this.searchRuntimeService.searchLocalInfoResultFlow(), 4, BufferOverflow.DROP_OLDEST);
        Ref.IntRef intRef = new Ref.IntRef();
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            int searchLocalInfo = this.searchRuntimeService.searchLocalInfo(str3, SearchLocalBusinessType.KSEARCHLOCALBUSINESSTYPEMQQALL);
            intRef.element = searchLocalInfo;
            this.searchLocalQueryId = searchLocalInfo;
            this.pendingSearch.put(Integer.valueOf(searchLocalInfo), clVar);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2(this, buffer, intRef, str3, l3, null), 3, null);
            return clVar;
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @Override // on2.b
    @MainThread
    public void c(@Nullable pn2.a searchRequest, @Nullable on2.d<ep2.d> listener) {
        String str;
        List<ep2.d> emptyList;
        Integer num = null;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            if (listener != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                listener.onFinish(emptyList, 1);
                return;
            }
            return;
        }
        this.searchAsyncReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_chat_more_cost");
        b l3 = l(listener);
        ArrayList<String> splitKeywords = vy2.b.l(str);
        Bundle bundle = searchRequest.f426496b;
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt("key_search_type"));
        }
        if (num != null && num.intValue() == 1) {
            Intrinsics.checkNotNullExpressionValue(splitKeywords, "splitKeywords");
            p(searchRequest, l3, str, splitKeywords);
            return;
        }
        if (num != null && num.intValue() == 2) {
            Intrinsics.checkNotNullExpressionValue(splitKeywords, "splitKeywords");
            m(searchRequest, l3, str, splitKeywords);
        } else if (num != null && num.intValue() == 3) {
            Intrinsics.checkNotNullExpressionValue(splitKeywords, "splitKeywords");
            n(searchRequest, l3, str, splitKeywords);
        } else {
            Intrinsics.checkNotNullExpressionValue(splitKeywords, "splitKeywords");
            o(searchRequest, l3, str, splitKeywords);
        }
    }

    @Override // ep2.b, on2.b
    @MainThread
    public void cancel() {
        super.cancel();
        if (this.searchLocalQueryId != 0) {
            ReentrantLock reentrantLock = this.pendingSearchLock;
            reentrantLock.lock();
            try {
                bl<List<ep2.d>> blVar = this.pendingSearch.get(Integer.valueOf(this.searchLocalQueryId));
                if (blVar != null) {
                    blVar.cancel(true);
                }
                this.pendingSearch.remove(Integer.valueOf(this.searchLocalQueryId));
                reentrantLock.unlock();
                this.searchRuntimeService.cancelSearchLocalInfo(this.searchLocalQueryId, 1, null);
                this.searchLocalQueryId = 0;
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
        int i3 = this.searchChatQueryId;
        if (i3 != 0) {
            this.searchRuntimeService.cancelSearchChatsWithKeywords(i3, 1, null);
            this.searchChatQueryId = 0;
        }
        int i16 = this.searchMsgQueryId;
        if (i16 != 0) {
            this.searchRuntimeService.cancelSearchMsgWithKeywords(i16, 1, null);
            this.searchMsgQueryId = 0;
        }
        int i17 = this.searchAtMeChatQueryId;
        if (i17 != 0) {
            this.searchRuntimeService.cancelSearchAtMeChats(i17, 1, null);
            this.searchAtMeChatQueryId = 0;
        }
        int i18 = this.searchAtMeMsgsQueryId;
        if (i18 != 0) {
            this.searchRuntimeService.cancelSearchChatAtMeMsgs(i18, 1, null);
            this.searchAtMeMsgsQueryId = 0;
        }
    }

    @Override // ep2.b, on2.b
    @MainThread
    public void destroy() {
        super.destroy();
        cancel();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    @Override // ep2.b
    @MainThread
    public void e(@NotNull pn2.a searchRequest, @NotNull on2.d<ep2.c> listener) {
        ArrayList<String> arrayListOf;
        int searchMsg;
        List<ep2.c> emptyList;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String keyword = searchRequest.f426495a;
        String string = searchRequest.f426496b.getString("originalKeyword", keyword);
        String string2 = searchRequest.f426496b.getString("uid");
        int i3 = searchRequest.f426496b.getInt("chatType");
        String string3 = searchRequest.f426496b.getString("title");
        Flow<SearchMsgKeywordsResult> searchMsgResultFlow = this.searchRuntimeService.searchMsgResultFlow();
        if (string2 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            listener.onFinish(emptyList, 1);
            return;
        }
        ArrayList<String> l3 = vy2.b.l(keyword);
        if (searchRequest.f426496b.containsKey("queryId")) {
            searchMsg = searchRequest.f426496b.getInt("queryId");
            this.searchRuntimeService.searchMoreMsg(searchMsg);
        } else {
            ISearchEngine iSearchEngine = this.searchRuntimeService;
            Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keyword);
            SearchMsgWithKeywordsParams searchMsgWithKeywordsParams = new SearchMsgWithKeywordsParams();
            searchMsgWithKeywordsParams.chatType = i3;
            searchMsgWithKeywordsParams.peerUid = string2;
            searchMsgWithKeywordsParams.searchFields = 1;
            searchMsgWithKeywordsParams.pageLimit = 50;
            Unit unit = Unit.INSTANCE;
            searchMsg = iSearchEngine.searchMsg(arrayListOf, searchMsgWithKeywordsParams);
            this.searchMsgQueryId = searchMsg;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTFtsMessageSearchEngine$searchDetailAsync$2(searchMsgResultFlow, searchMsg, listener, keyword, this, l3, string2, string3, i3, string, 50, null), 3, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016J \u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/search/ftsmsg/NTFtsMessageSearchEngine$b", "Lon2/d;", "Lep2/d;", "", "resultList", "", "onUpdate", "", "isAppend", "Lpn2/b;", "respData", "onFinish", "", "status", "onCancelSearch", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements on2.d<ep2.d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ on2.d<ep2.d> f283295d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NTFtsMessageSearchEngine f283296e;

        b(on2.d<ep2.d> dVar, NTFtsMessageSearchEngine nTFtsMessageSearchEngine) {
            this.f283295d = dVar;
            this.f283296e = nTFtsMessageSearchEngine;
        }

        @Override // on2.d
        public void onCancelSearch() {
            on2.c.a(this);
            on2.d<ep2.d> dVar = this.f283295d;
            if (dVar != null) {
                dVar.onCancelSearch();
            }
            IPerformanceReportTask iPerformanceReportTask = this.f283296e.searchAsyncReportTask;
            if (iPerformanceReportTask != null) {
                iPerformanceReportTask.report();
            }
        }

        @Override // on2.d
        public void onFinish(@Nullable List<ep2.d> resultList, @Nullable pn2.b respData) {
            on2.c.c(this, resultList, respData);
            on2.d<ep2.d> dVar = this.f283295d;
            if (dVar != null) {
                dVar.onFinish(resultList, respData);
            }
            IPerformanceReportTask iPerformanceReportTask = this.f283296e.searchAsyncReportTask;
            if (iPerformanceReportTask != null) {
                iPerformanceReportTask.report();
            }
        }

        @Override // on2.d
        public void onUpdate(@Nullable List<ep2.d> resultList) {
            on2.c.d(this, resultList);
            on2.d<ep2.d> dVar = this.f283295d;
            if (dVar != null) {
                dVar.onUpdate(resultList);
            }
        }

        @Override // on2.d
        public void onUpdate(@Nullable List<ep2.d> resultList, boolean isAppend) {
            on2.c.e(this, resultList, isAppend);
            on2.d<ep2.d> dVar = this.f283295d;
            if (dVar != null) {
                dVar.onUpdate(resultList, isAppend);
            }
        }

        @Override // on2.d
        public void onFinish(@Nullable List<ep2.d> resultList, int status) {
            on2.c.b(this, resultList, status);
            on2.d<ep2.d> dVar = this.f283295d;
            if (dVar != null) {
                dVar.onFinish(resultList, status);
            }
            IPerformanceReportTask iPerformanceReportTask = this.f283296e.searchAsyncReportTask;
            if (iPerformanceReportTask != null) {
                iPerformanceReportTask.report();
            }
        }
    }

    @Override // ep2.b
    public void f(@Nullable String keyword, @Nullable List<FTSEntity> entities) {
    }
}
