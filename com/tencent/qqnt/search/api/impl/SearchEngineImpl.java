package com.tencent.qqnt.search.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatAtMeMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoType;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgWithKeywordsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import com.tencent.qqnt.search.api.ISearchEngine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\b*\u0001G\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u0015\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\"\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J \u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010%\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010'\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J2\u0010*\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010,\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002000-H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002020-H\u0016J\u000e\u00105\u001a\b\u0012\u0004\u0012\u0002040-H\u0016J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002060-H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002080-H\u0016R\u0018\u0010:\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020.0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u0002000?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u0002020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u0002040?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010AR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u0002060?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010AR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u0002080?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010AR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/qqnt/search/api/impl/SearchEngineImpl;", "Lcom/tencent/qqnt/search/api/ISearchEngine;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "keywords", "", "pageLimit", "searchChat", "searchId", "searchMoreChat", "code", "reason", "cancelSearchChatsWithKeywords", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgWithKeywordsParams;", "params", "searchMsg", "searchMoreMsg", "cancelSearchMsgWithKeywords", "keyWord", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalBusinessType;", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "searchLocalInfo", "cancelSearchLocalInfo", "", "includeAtAll", "pageCount", "totalCount", "searchAtMeChats", "searchMoreAtMeChats", "cancelSearchAtMeChats", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatAtMeMsgsParams;", "searchChatAtMeMsgs", "searchMoreChatAtMeMsgs", "cancelSearchChatAtMeMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "searchFunction", "searchMoreFunction", "cancelSearchFunction", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatsKeywordsResult;", "searchChatResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "searchMsgResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "searchLocalInfoResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeChatsResult;", "searchAtMeChatsResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsResult;", "searchAtMeMsgsResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFunctionResult;", "searchFunctionResultFlow", "runtime", "Lmqq/app/AppRuntime;", "Lcom/tencent/qqnt/kernel/api/ae;", "searchService", "Lcom/tencent/qqnt/kernel/api/ae;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "searchChatResult", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "searchMsgResult", "localInfoResult", "searchAtMeChatsResult", "searchAtMeMsgsResult", "searchFunctionResult", "com/tencent/qqnt/search/api/impl/SearchEngineImpl$b", "listener", "Lcom/tencent/qqnt/search/api/impl/SearchEngineImpl$b;", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SearchEngineImpl implements ISearchEngine {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SearchEngineImpl";

    @NotNull
    private b listener;

    @NotNull
    private final MutableSharedFlow<SearchLocalInfoResult> localInfoResult;

    @Nullable
    private AppRuntime runtime;

    @NotNull
    private final MutableSharedFlow<SearchAtMeChatsResult> searchAtMeChatsResult;

    @NotNull
    private final MutableSharedFlow<SearchAtMeMsgsResult> searchAtMeMsgsResult;

    @NotNull
    private final MutableSharedFlow<SearchChatsKeywordsResult> searchChatResult;

    @NotNull
    private final MutableSharedFlow<SearchFunctionResult> searchFunctionResult;

    @NotNull
    private final MutableSharedFlow<SearchMsgKeywordsResult> searchMsgResult;

    @Nullable
    private ae searchService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/search/api/impl/SearchEngineImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.search.api.impl.SearchEngineImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/search/api/impl/SearchEngineImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatsKeywordsResult;", "result", "", "onSearchChatsKeywordsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "onSearchMsgKeywordsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "onSearchLocalInfoResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeChatsResult;", "onSearchAtMeChatsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsResult;", "onSearchAtMeMsgsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFunctionResult;", "onSearchFunctionResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IKernelSearchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEngineImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchAtMeChatsResult(@Nullable SearchAtMeChatsResult result) {
            int i3;
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) result);
                return;
            }
            if (result != null) {
                i3 = result.hashCode();
            } else {
                i3 = 0;
            }
            Boolean bool = null;
            if (result != null) {
                num = Integer.valueOf(result.searchId);
            } else {
                num = null;
            }
            if (result != null) {
                bool = Boolean.valueOf(result.hasMore);
            }
            QLog.d(SearchEngineImpl.TAG, 1, "#onSearchAtMeChatsResult result hash:" + i3 + ", searchId:" + num + ", hasMore: " + bool);
            if (result != null) {
                SearchEngineImpl.this.searchAtMeChatsResult.tryEmit(result);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchAtMeMsgsResult(@Nullable SearchAtMeMsgsResult result) {
            int i3;
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) result);
                return;
            }
            if (result != null) {
                i3 = result.hashCode();
            } else {
                i3 = 0;
            }
            Boolean bool = null;
            if (result != null) {
                num = Integer.valueOf(result.searchId);
            } else {
                num = null;
            }
            if (result != null) {
                bool = Boolean.valueOf(result.hasMore);
            }
            QLog.d(SearchEngineImpl.TAG, 1, "#onSearchAtMeMsgsResult hash:" + i3 + ", searchId:" + num + ", hasMore: " + bool);
            if (result != null) {
                SearchEngineImpl.this.searchAtMeMsgsResult.tryEmit(result);
            }
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
        public void onSearchChatsKeywordsResult(@Nullable SearchChatsKeywordsResult result) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            if (result != null) {
                i3 = result.hashCode();
            } else {
                i3 = 0;
            }
            QLog.d(SearchEngineImpl.TAG, 1, "#onSearchChatsKeywordsResult result hash " + i3);
            if (result != null) {
                SearchEngineImpl.this.searchChatResult.tryEmit(result);
            }
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
        public void onSearchFunctionResult(@Nullable SearchFunctionResult result) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) result);
                return;
            }
            Boolean bool = null;
            if (result != null) {
                num = Integer.valueOf(result.searchId);
            } else {
                num = null;
            }
            if (result != null) {
                bool = Boolean.valueOf(result.hasMore);
            }
            QLog.d(SearchEngineImpl.TAG, 1, "#onSearchFunctionResult searchId:" + num + ", hasMore: " + bool);
            if (result != null) {
                SearchEngineImpl.this.searchFunctionResult.tryEmit(result);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchGroupChatInfoResult(SearchGroupChatInfoResult searchGroupChatInfoResult) {
            bm.i(this, searchGroupChatInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchGroupResult(SearchGroupResult searchGroupResult) {
            bm.j(this, searchGroupResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchLocalInfoResult(@Nullable SearchLocalInfoResult result) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) result);
                return;
            }
            SearchLocalInfoType searchLocalInfoType = null;
            if (result != null) {
                num = Integer.valueOf(result.f359215id);
            } else {
                num = null;
            }
            if (result != null) {
                searchLocalInfoType = result.type;
            }
            QLog.d(SearchEngineImpl.TAG, 1, "#onSearchLocalInfoResult " + num + ", type: " + searchLocalInfoType);
            if (result != null) {
                SearchEngineImpl.this.localInfoResult.tryEmit(result);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchMsgKeywordsResult(@Nullable SearchMsgKeywordsResult result) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
                return;
            }
            if (result != null) {
                i3 = result.hashCode();
            } else {
                i3 = 0;
            }
            QLog.d(SearchEngineImpl.TAG, 1, "#onSearchMsgKeywordsResult result hash " + i3);
            if (result != null) {
                SearchEngineImpl.this.searchMsgResult.tryEmit(result);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchResult(SearchResult searchResult) {
            bm.m(this, searchResult);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56010);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchEngineImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.searchChatResult = SharedFlowKt.MutableSharedFlow$default(0, 3, null, 4, null);
        this.searchMsgResult = SharedFlowKt.MutableSharedFlow$default(0, 3, null, 4, null);
        this.localInfoResult = SharedFlowKt.MutableSharedFlow$default(0, 3, null, 4, null);
        this.searchAtMeChatsResult = SharedFlowKt.MutableSharedFlow$default(0, 3, null, 4, null);
        this.searchAtMeMsgsResult = SharedFlowKt.MutableSharedFlow$default(0, 3, null, 4, null);
        this.searchFunctionResult = SharedFlowKt.MutableSharedFlow$default(0, 3, null, 4, null);
        this.listener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchAtMeChats$lambda$2(int i3, String str) {
        QLog.d(TAG, 1, "err: " + i3 + ", msg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchChat$lambda$0(int i3, String str) {
        QLog.d(TAG, 1, "#searchChat err: " + i3 + ", msg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchChatAtMeMsgs$lambda$3(int i3, String str) {
        QLog.d(TAG, 1, "err: " + i3 + ", msg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchLocalInfo$lambda$1(int i3, String str) {
        QLog.d(TAG, 1, "err: " + i3 + ", msg: " + str);
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void cancelSearchAtMeChats(int searchId, int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.cancelSearchAtMeChats(searchId, code, reason);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void cancelSearchChatAtMeMsgs(int searchId, int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.cancelSearchChatAtMeMsgs(searchId, code, reason);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void cancelSearchChatsWithKeywords(int searchId, int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.cancelSearchChatsWithKeywords(searchId, code, reason);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void cancelSearchFunction(int searchId, int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.cancelSearchFunction(searchId, code, reason);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void cancelSearchLocalInfo(int searchId, int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.cancelSearchLocalInfo(searchId, code, reason);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void cancelSearchMsgWithKeywords(int searchId, int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.cancelSearchMsgWithKeywords(searchId, code, reason);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        ae aeVar;
        IKernelService iKernelService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.runtime = appRuntime;
        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            aeVar = iKernelService.getSearchService();
        } else {
            aeVar = null;
        }
        this.searchService = aeVar;
        if (aeVar != null) {
            Intrinsics.checkNotNull(aeVar);
            aeVar.addKernelSearchListener(this.listener);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.runtime = null;
        ae aeVar = this.searchService;
        if (aeVar != null) {
            Intrinsics.checkNotNull(aeVar);
            aeVar.q0(this.listener);
        }
        this.searchService = null;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public int searchAtMeChats(boolean includeAtAll, int pageCount, int totalCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(includeAtAll), Integer.valueOf(pageCount), Integer.valueOf(totalCount))).intValue();
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            Intrinsics.checkNotNull(aeVar);
            return aeVar.searchAtMeChats(includeAtAll, pageCount, totalCount, new IOperateCallback() { // from class: com.tencent.qqnt.search.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SearchEngineImpl.searchAtMeChats$lambda$2(i3, str);
                }
            });
        }
        return -1;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    @NotNull
    public Flow<SearchAtMeChatsResult> searchAtMeChatsResultFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Flow) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.searchAtMeChatsResult;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    @NotNull
    public Flow<SearchAtMeMsgsResult> searchAtMeMsgsResultFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Flow) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.searchAtMeMsgsResult;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public int searchChat(@NotNull ArrayList<String> keywords, int pageLimit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) keywords, pageLimit)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        ae aeVar = this.searchService;
        if (aeVar == null) {
            QLog.w(TAG, 1, "#searchChat searchService is null");
            return -1;
        }
        Intrinsics.checkNotNull(aeVar);
        return aeVar.searchChatsWithKeywords(new ArrayList<>(keywords), 1, pageLimit, new IOperateCallback() { // from class: com.tencent.qqnt.search.api.impl.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                SearchEngineImpl.searchChat$lambda$0(i3, str);
            }
        });
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public int searchChatAtMeMsgs(@Nullable SearchChatAtMeMsgsParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) params)).intValue();
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            Intrinsics.checkNotNull(aeVar);
            return aeVar.searchChatAtMeMsgs(params, new IOperateCallback() { // from class: com.tencent.qqnt.search.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SearchEngineImpl.searchChatAtMeMsgs$lambda$3(i3, str);
                }
            });
        }
        return -1;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    @NotNull
    public Flow<SearchChatsKeywordsResult> searchChatResultFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Flow) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.searchChatResult;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public int searchFunction(@NotNull ArrayList<String> keywords, int pageLimit, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, keywords, Integer.valueOf(pageLimit), callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        ae aeVar = this.searchService;
        if (aeVar != null) {
            return aeVar.searchFunction(keywords, pageLimit, callback);
        }
        return -1;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    @NotNull
    public Flow<SearchFunctionResult> searchFunctionResultFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Flow) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.searchFunctionResult;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public int searchLocalInfo(@Nullable String keyWord, @NotNull SearchLocalBusinessType searchType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) keyWord, (Object) searchType)).intValue();
        }
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        ae aeVar = this.searchService;
        if (aeVar != null) {
            Intrinsics.checkNotNull(aeVar);
            return aeVar.searchLocalInfo(keyWord, searchType, new IOperateCallback() { // from class: com.tencent.qqnt.search.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SearchEngineImpl.searchLocalInfo$lambda$1(i3, str);
                }
            });
        }
        return -1;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    @NotNull
    public Flow<SearchLocalInfoResult> searchLocalInfoResultFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Flow) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.localInfoResult;
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void searchMoreAtMeChats(int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, searchId);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.searchMoreAtMeChats(searchId);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void searchMoreChat(int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, searchId);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar == null) {
            QLog.w(TAG, 1, "#searchMoreChat searchService is null");
        } else {
            Intrinsics.checkNotNull(aeVar);
            aeVar.searchMoreChatsWithKeywords(searchId);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void searchMoreChatAtMeMsgs(int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, searchId);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.searchMoreChatAtMeMsgs(searchId);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void searchMoreFunction(int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, searchId);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.searchMoreFunction(searchId);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public void searchMoreMsg(int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, searchId);
            return;
        }
        ae aeVar = this.searchService;
        if (aeVar != null) {
            aeVar.searchMoreMsgWithKeywords(searchId);
        }
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    public int searchMsg(@NotNull ArrayList<String> keywords, @NotNull SearchMsgWithKeywordsParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) keywords, (Object) params)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(params, "params");
        ae aeVar = this.searchService;
        if (aeVar == null) {
            return -1;
        }
        Intrinsics.checkNotNull(aeVar);
        return aeVar.searchMsgWithKeywords(keywords, params, null);
    }

    @Override // com.tencent.qqnt.search.api.ISearchEngine
    @NotNull
    public Flow<SearchMsgKeywordsResult> searchMsgResultFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Flow) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.searchMsgResult;
    }
}
