package com.tencent.qqnt.kernel.api.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.api.impl.SearchService;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.IAddSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchBudlyCoreCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService;
import com.tencent.qqnt.kernel.nativeinterface.ILoadSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUpdateSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatAtMeMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchHistoryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgWithKeywordsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResultGroup;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 Y2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001ZB\u0019\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010V\u001a\u00020U\u00a2\u0006\u0004\bW\u0010XJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J2\u0010\u0014\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u001e\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J4\u0010\"\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\"\u0010$\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016JB\u0010(\u001a\u00020\u00102\u001e\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u000e2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0016J0\u0010*\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010!\u001a\u00020)2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J \u0010,\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\rH\u0016J8\u0010.\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010!\u001a\u00020-2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J0\u00100\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u00104\u001a\u00020\u00102\u0006\u00103\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u00106\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\rH\u0016J*\u0010:\u001a\u00020\u00102\u0006\u00108\u001a\u0002072\u0006\u0010&\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010;\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\"\u0010<\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010>\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010=2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\"\u0010@\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J \u0010A\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\rH\u0016J\u0010\u0010B\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\"\u0010C\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010E\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010F\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010J\u001a\u00020\t2\u0006\u0010H\u001a\u00020G2\b\u0010'\u001a\u0004\u0018\u00010IH\u0016J\u001a\u0010L\u001a\u00020\t2\u0006\u0010H\u001a\u00020G2\b\u0010\u0013\u001a\u0004\u0018\u00010KH\u0016J*\u0010M\u001a\u00020\t2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020G0\fj\b\u0012\u0004\u0012\u00020G`\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010O\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010Q\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010PH\u0016J\b\u0010R\u001a\u00020\tH\u0016J\b\u0010S\u001a\u00020\tH\u0016\u00a8\u0006["}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/SearchService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchService;", "Lcom/tencent/qqnt/kernel/api/ae;", "listener", "com/tencent/qqnt/kernel/api/impl/SearchService$b", "q4", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;)Lcom/tencent/qqnt/kernel/api/impl/SearchService$b;", "", "addKernelSearchListener", "q0", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "keywords", "", "pageLimit", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "searchFunction", "searchId", "searchMoreFunction", "code", "reason", "cancelSearchFunction", "keyWord", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalBusinessType;", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "cb", "searchLocalInfo", "cancelSearchLocalInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgWithKeywordsParams;", "params", "searchMsgWithKeywords", "searchMoreMsgWithKeywords", "cancelSearchMsgWithKeywords", "searchFields", "pageCount", "result", "searchChatsWithKeywords", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatMsgsParams;", "searchChatMsgs", "searchMoreChatMsgs", "cancelSearchChatMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupChatInfoParams;", "searchGroupChatInfo", "searchMoreGroupChatInfo", "searchBuddyChatInfo", "searchMoreBuddyChatInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyInfoParams;", "searchParams", "searchBuddyChatInfoWithParams", QzoneIPCModule.RESULT_CODE, "cancelSearchBuddyChatInfo", "", "includeAtAll", "totalCount", "searchAtMeChats", "searchMoreAtMeChats", "cancelSearchAtMeChats", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatAtMeMsgsParams;", "searchChatAtMeMsgs", "searchMoreChatAtMeMsgs", "cancelSearchChatAtMeMsgs", "cancelSearchGroupChatInfo", "searchMoreChatsWithKeywords", "cancelSearchChatsWithKeywords", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoadSearchHistoryCallback;", "loadSearchHistory", "clearSearchHistory", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHistoryItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/IAddSearchHistoryCallback;", "addSearchHistory", "Lcom/tencent/qqnt/kernel/nativeinterface/IUpdateSearchHistoryCallback;", "updateSearchHistory", "batchAddSearchHistory", "id", "removeSearchHistory", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSearchBudlyCoreCallback;", "searchCoreBuddy", "initTokenizeUtil", "releaseTokenizeUtil", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SearchService extends BaseService<IKernelSearchListener, IKernelSearchService> implements com.tencent.qqnt.kernel.api.ae {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/SearchService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.SearchService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000s\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020#H\u0016\u00a8\u0006%"}, d2 = {"com/tencent/qqnt/kernel/api/impl/SearchService$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchResult;", "searchResult", "", "onSearchResult", "", "searchCacheId", "keyword", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "result", "onSearchCacheResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatsKeywordsResult;", "onSearchChatsKeywordsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "onSearchMsgKeywordsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "onSearchLocalInfoResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyChatInfoResult;", "onSearchBuddyChatInfoResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupChatInfoResult;", "onSearchGroupChatInfoResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeChatsResult;", "onSearchAtMeChatsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsResult;", "onSearchAtMeMsgsResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchContactResult;", "onSearchContactResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFunctionResult;", "onSearchFunctionResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupResult;", "onSearchGroupResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFileKeywordsResult;", "onSearchFileKeywordsResult", "", "hashCode", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelSearchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IKernelSearchListener f357372e;

        b(IKernelSearchListener iKernelSearchListener) {
            this.f357372e = iKernelSearchListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchService.this, (Object) iKernelSearchListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(SearchAtMeChatsResult searchAtMeChatsResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchAtMeChatsResult != null) {
                num = Integer.valueOf(searchAtMeChatsResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchAtMeChatsResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchAtMeChatsResult(searchAtMeChatsResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(SearchAtMeMsgsResult searchAtMeMsgsResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchAtMeMsgsResult != null) {
                num = Integer.valueOf(searchAtMeMsgsResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchAtMeMsgsResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchAtMeMsgsResult(searchAtMeMsgsResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(SearchBuddyChatInfoResult searchBuddyChatInfoResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchBuddyChatInfoResult != null) {
                num = Integer.valueOf(searchBuddyChatInfoResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchBuddyChatInfoResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchBuddyChatInfoResult(searchBuddyChatInfoResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(ArrayList result, IKernelSearchListener listener, String searchCacheId, String keyword) {
            Intrinsics.checkNotNullParameter(result, "$result");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(searchCacheId, "$searchCacheId");
            Intrinsics.checkNotNullParameter(keyword, "$keyword");
            KLog.e(KLog.f359087a, "SearchService", new Object[]{TuplesKt.to("onSearchCacheResult result", Integer.valueOf(result.size()))}, null, 4, null);
            listener.onSearchCacheResult(searchCacheId, keyword, result);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(SearchChatsKeywordsResult searchChatsKeywordsResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchChatsKeywordsResult != null) {
                num = Integer.valueOf(searchChatsKeywordsResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchChatsKeywordsResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchChatsKeywordsResult(searchChatsKeywordsResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(SearchContactResult searchContactResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchContactResult != null) {
                num = Integer.valueOf(searchContactResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchContactResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchContactResult(searchContactResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(SearchFileKeywordsResult searchFileKeywordsResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchFileKeywordsResult != null) {
                num = Integer.valueOf(searchFileKeywordsResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchFileKeywordsResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchFileKeywordsResult(searchFileKeywordsResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(SearchFunctionResult searchFunctionResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchFunctionResult != null) {
                num = Integer.valueOf(searchFunctionResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchFunctionResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchFunctionResult(searchFunctionResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(SearchGroupChatInfoResult searchGroupChatInfoResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchGroupChatInfoResult != null) {
                num = Integer.valueOf(searchGroupChatInfoResult.searchId);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchGroupChatInfoResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchGroupChatInfoResult(searchGroupChatInfoResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(SearchGroupResult searchGroupResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchGroupResult != null) {
                num = Integer.valueOf(searchGroupResult.errorode);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchGroupResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchGroupResult(searchGroupResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(SearchMsgKeywordsResult searchMsgKeywordsResult, IKernelSearchListener listener) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[2];
            objArr[0] = "onSearchMsgKeywordsResult";
            if (searchMsgKeywordsResult != null) {
                num = Integer.valueOf(searchMsgKeywordsResult.searchId);
            } else {
                num = null;
            }
            objArr[1] = TuplesKt.to("result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchMsgKeywordsResult(searchMsgKeywordsResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(SearchResult searchResult, IKernelSearchListener listener) {
            Integer num;
            ArrayList<SearchResultGroup> arrayList;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (searchResult != null && (arrayList = searchResult.resultGroup) != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchResult searchResult", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            listener.onSearchResult(searchResult);
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return this.f357372e.hashCode();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchAtMeChatsResult(@Nullable final SearchAtMeChatsResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pw
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.m(SearchAtMeChatsResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchAtMeMsgsResult(@Nullable final SearchAtMeMsgsResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pn
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.n(SearchAtMeMsgsResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchBuddyChatInfoResult(@Nullable final SearchBuddyChatInfoResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pm
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.o(SearchBuddyChatInfoResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchCacheResult(@NotNull final String searchCacheId, @NotNull final String keyword, @NotNull final ArrayList<String> result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, searchCacheId, keyword, result);
                return;
            }
            Intrinsics.checkNotNullParameter(searchCacheId, "searchCacheId");
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(result, "result");
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pp
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.p(result, iKernelSearchListener, searchCacheId, keyword);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchChatsKeywordsResult(@Nullable final SearchChatsKeywordsResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pu
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.q(SearchChatsKeywordsResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchContactResult(@Nullable final SearchContactResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pr
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.r(SearchContactResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchFileKeywordsResult(@Nullable final SearchFileKeywordsResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.po
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.s(SearchFileKeywordsResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchFunctionResult(@Nullable final SearchFunctionResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pq
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.t(SearchFunctionResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchGroupChatInfoResult(@Nullable final SearchGroupChatInfoResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ps
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.u(SearchGroupChatInfoResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchGroupResult(@Nullable final SearchGroupResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pv
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.v(SearchGroupResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchLocalInfoResult(@Nullable SearchLocalInfoResult result) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) result);
                return;
            }
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (result != null) {
                num = Integer.valueOf(result.f359215id);
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchLocalInfoResult result", num);
            KLog.e(kLog, "SearchService", objArr, null, 4, null);
            this.f357372e.onSearchLocalInfoResult(result);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchMsgKeywordsResult(@Nullable final SearchMsgKeywordsResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) result);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.pt
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.w(SearchMsgKeywordsResult.this, iKernelSearchListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchResult(@Nullable final SearchResult searchResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) searchResult);
                return;
            }
            SearchService searchService = SearchService.this;
            final IKernelSearchListener iKernelSearchListener = this.f357372e;
            searchService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.px
                @Override // java.lang.Runnable
                public final void run() {
                    SearchService.b.x(SearchResult.this, iKernelSearchListener);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 43)) {
            redirector.redirect((short) 43);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchService(@Nullable IKernelSearchService iKernelSearchService, @NotNull py content) {
        super("SearchService", content, iKernelSearchService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelSearchService, (Object) content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b q4(IKernelSearchListener listener) {
        return new b(listener);
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void addKernelSearchListener(@NotNull IKernelSearchListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            addListener(listener, new Function1<IKernelSearchListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$addKernelSearchListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Long invoke(@NotNull IKernelSearchListener it) {
                    SearchService.b q46;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    q46 = SearchService.this.q4(it);
                    return Long.valueOf(service.addKernelSearchListener(q46));
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void addSearchHistory(@NotNull final SearchHistoryItem item, @Nullable final IAddSearchHistoryCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) item, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            check("addSearchHistory", new Function0<Unit>(item, result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$addSearchHistory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SearchHistoryItem $item;
                final /* synthetic */ IAddSearchHistoryCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, item, result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addSearchHistory(this.$item, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void batchAddSearchHistory(@NotNull final ArrayList<SearchHistoryItem> item, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) item, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            check("batchAddSearchHistory", new Function0<Unit>(item, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$batchAddSearchHistory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ ArrayList<SearchHistoryItem> $item;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, item, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.batchAddSearchHistory(this.$item, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchAtMeChats(final int searchId, final int code, @Nullable final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            check("searchMoreAtMeChats", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchAtMeChats$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchAtMeChats(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchBuddyChatInfo(final int searchId, final int resultCode, @NotNull final String result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(searchId), Integer.valueOf(resultCode), result);
        } else {
            Intrinsics.checkNotNullParameter(result, "result");
            check("cancelSearchBuddyChatInfo", new Function0<Unit>(searchId, resultCode, result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchBuddyChatInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $result;
                final /* synthetic */ int $resultCode;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$resultCode = resultCode;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(resultCode), result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchBuddyChatInfo(this.$searchId, this.$resultCode, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchChatAtMeMsgs(final int searchId, final int code, @Nullable final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            check("cancelSearchChatAtMeMsgs", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchChatAtMeMsgs$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchChatAtMeMsgs(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchChatMsgs(final int searchId, final int code, @NotNull final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            Intrinsics.checkNotNullParameter(reason, "reason");
            check("cancelSearchChatMsgs", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchChatMsgs$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchChatMsgs(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchChatsWithKeywords(final int searchId, final int code, @Nullable final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            check("cancelSearchChatsWithKeywords", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchChatsWithKeywords$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchChatsWithKeywords(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchFunction(final int searchId, final int code, @Nullable final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            check("cancelSearchFunction", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchFunction$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchFunction(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchGroupChatInfo(final int searchId, final int resultCode, @NotNull final String result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(searchId), Integer.valueOf(resultCode), result);
        } else {
            Intrinsics.checkNotNullParameter(result, "result");
            check("cancelSearchGroupChatInfo", new Function0<Unit>(searchId, resultCode, result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchGroupChatInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $result;
                final /* synthetic */ int $resultCode;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$resultCode = resultCode;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(resultCode), result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchGroupChatInfo(this.$searchId, this.$resultCode, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchLocalInfo(final int searchId, final int code, @Nullable final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            check("cancelSearchLocalInfo", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchLocalInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchLocalInfo(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void cancelSearchMsgWithKeywords(final int searchId, final int code, @Nullable final String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
        } else {
            check("cancelSearchMsgWithKeywords", new Function0<Unit>(searchId, code, reason) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$cancelSearchMsgWithKeywords$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $code;
                final /* synthetic */ String $reason;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    this.$code = code;
                    this.$reason = reason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(searchId), Integer.valueOf(code), reason);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelSearchMsgWithKeywords(this.$searchId, this.$code, this.$reason);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void clearSearchHistory(@Nullable final IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) result);
        } else {
            check("clearSearchHistory", new Function0<Unit>(result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$clearSearchHistory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, (Object) result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.clearSearchHistory(this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void initTokenizeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else {
            check("initTokenizeUtil", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$initTokenizeUtil$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.initTokenizeUtil();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void loadSearchHistory(@Nullable final ILoadSearchHistoryCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) result);
        } else {
            check("loadSearchHistory", new Function0<Unit>(result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$loadSearchHistory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ILoadSearchHistoryCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, (Object) result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.loadSearchHistory(this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void q0(@NotNull IKernelSearchListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            BaseService.removeListener$default(this, listener, false, new Function1<Long, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$removeKernelSearchListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                        return;
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service != null) {
                        service.removeKernelSearchListener(j3);
                    }
                }
            }, 2, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void releaseTokenizeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            check("releaseTokenizeUtil", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$releaseTokenizeUtil$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.releaseTokenizeUtil();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void removeSearchHistory(final int id5, @Nullable final IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, id5, (Object) result);
        } else {
            check("removeSearchHistory", new Function0<Unit>(id5, result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$removeSearchHistory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $id;
                final /* synthetic */ IOperateCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$id = id5;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, Integer.valueOf(id5), result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.removeSearchHistory(this.$id, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchAtMeChats(final boolean includeAtAll, final int pageCount, final int totalCount, @Nullable final IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(includeAtAll), Integer.valueOf(pageCount), Integer.valueOf(totalCount), result)).intValue();
        }
        Integer num = (Integer) check("searchAtMeChats", new Function0<Integer>(includeAtAll, pageCount, totalCount, result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchAtMeChats$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $includeAtAll;
            final /* synthetic */ int $pageCount;
            final /* synthetic */ IOperateCallback $result;
            final /* synthetic */ int $totalCount;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$includeAtAll = includeAtAll;
                this.$pageCount = pageCount;
                this.$totalCount = totalCount;
                this.$result = result;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, Boolean.valueOf(includeAtAll), Integer.valueOf(pageCount), Integer.valueOf(totalCount), result);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchAtMeChats(this.$includeAtAll, this.$pageCount, this.$totalCount, this.$result));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchBuddyChatInfo(@NotNull final ArrayList<String> keywords, final int pageLimit, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, keywords, Integer.valueOf(pageLimit), callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer num = (Integer) check("searchBuddyChatInfo", new Function0<Integer>(keywords, pageLimit, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchBuddyChatInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ ArrayList<String> $keywords;
            final /* synthetic */ int $pageLimit;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$keywords = keywords;
                this.$pageLimit = pageLimit;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keywords, Integer.valueOf(pageLimit), callback);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchBuddyChatInfo(this.$keywords, this.$pageLimit, this.$callback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchBuddyChatInfoWithParams(@NotNull final SearchBuddyInfoParams searchParams, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) searchParams, (Object) callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer num = (Integer) check("searchBuddyChatInfoWithParams", new Function0<Integer>(searchParams, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchBuddyChatInfoWithParams$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ SearchBuddyInfoParams $searchParams;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$searchParams = searchParams;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, searchParams, callback);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchBuddyChatInfoWithParams(this.$searchParams, this.$callback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchChatAtMeMsgs(@Nullable final SearchChatAtMeMsgsParams params, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) params, (Object) callback)).intValue();
        }
        Integer num = (Integer) check("searchChatAtMeMsgs", new Function0<Integer>(params, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchChatAtMeMsgs$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ SearchChatAtMeMsgsParams $params;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$params = params;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, params, callback);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchChatAtMeMsgs(this.$params, this.$callback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchChatMsgs(@NotNull final ArrayList<String> keywords, @NotNull final SearchChatMsgsParams params, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, keywords, params, callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer num = (Integer) check("searchChatMsgs", new Function0<Integer>(keywords, params, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchChatMsgs$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ ArrayList<String> $keywords;
            final /* synthetic */ SearchChatMsgsParams $params;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$keywords = keywords;
                this.$params = params;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keywords, params, callback);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchChatMsgs(this.$keywords, this.$params, this.$callback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchChatsWithKeywords(@Nullable final ArrayList<String> keywords, final int searchFields, final int pageCount, @Nullable final IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, keywords, Integer.valueOf(searchFields), Integer.valueOf(pageCount), result)).intValue();
        }
        Integer num = (Integer) check("searchChatsWithKeywords", new Function0<Integer>(keywords, searchFields, pageCount, result) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchChatsWithKeywords$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $keywords;
            final /* synthetic */ int $pageCount;
            final /* synthetic */ IOperateCallback $result;
            final /* synthetic */ int $searchFields;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$keywords = keywords;
                this.$searchFields = searchFields;
                this.$pageCount = pageCount;
                this.$result = result;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keywords, Integer.valueOf(searchFields), Integer.valueOf(pageCount), result);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchChatsWithKeywords(this.$keywords, this.$searchFields, this.$pageCount, this.$result));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchCoreBuddy(@Nullable final IGetSearchBudlyCoreCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) callback);
        } else {
            check("removeSearchHistory", new Function0<Unit>(callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchCoreBuddy$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetSearchBudlyCoreCallback $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchCoreBuddy(this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchFunction(@NotNull final ArrayList<String> keywords, final int pageLimit, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, keywords, Integer.valueOf(pageLimit), callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Integer num = (Integer) check("searchFunction", new Function0<Integer>(keywords, pageLimit, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchFunction$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ ArrayList<String> $keywords;
            final /* synthetic */ int $pageLimit;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$keywords = keywords;
                this.$pageLimit = pageLimit;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keywords, Integer.valueOf(pageLimit), callback);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchFunction(this.$keywords, this.$pageLimit, this.$callback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchGroupChatInfo(@NotNull final ArrayList<String> keywords, @NotNull final SearchGroupChatInfoParams params, final int pageLimit, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, keywords, params, Integer.valueOf(pageLimit), callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer num = (Integer) check("searchGroupChatInfo", new Function0<Integer>(keywords, params, pageLimit, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchGroupChatInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ ArrayList<String> $keywords;
            final /* synthetic */ int $pageLimit;
            final /* synthetic */ SearchGroupChatInfoParams $params;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$keywords = keywords;
                this.$params = params;
                this.$pageLimit = pageLimit;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keywords, params, Integer.valueOf(pageLimit), callback);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchGroupChatInfo(this.$keywords, this.$params, this.$pageLimit, this.$callback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchLocalInfo(@Nullable final String keyWord, @NotNull final SearchLocalBusinessType searchType, @Nullable final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, keyWord, searchType, cb5)).intValue();
        }
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        Integer num = (Integer) check("searchLocal", cb5, new Function1<IOperateCallback, Integer>(keyWord, searchType, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchLocalInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $cb;
            final /* synthetic */ String $keyWord;
            final /* synthetic */ SearchLocalBusinessType $searchType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$keyWord = keyWord;
                this.$searchType = searchType;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keyWord, searchType, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Integer invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchLocalInfo(this.$keyWord, this.$searchType, this.$cb));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreAtMeChats(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, searchId);
        } else {
            check("searchMoreAtMeChats", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreAtMeChats$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreAtMeChats(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreBuddyChatInfo(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, searchId);
        } else {
            check("searchMoreBuddyChatInfo", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreBuddyChatInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreBuddyChatInfo(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreChatAtMeMsgs(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, searchId);
        } else {
            check("searchMoreChatAtMeMsgs", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreChatAtMeMsgs$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreChatAtMeMsgs(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreChatMsgs(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, searchId);
        } else {
            check("searchMoreChatMsgs", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreChatMsgs$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreChatMsgs(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreChatsWithKeywords(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, searchId);
        } else {
            check("searchMoreChatsWithKeywords", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreChatsWithKeywords$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreChatsWithKeywords(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreFunction(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, searchId);
        } else {
            check("searchMoreFunction", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreFunction$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreFunction(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreGroupChatInfo(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, searchId);
        } else {
            check("searchMoreGroupChatInfo", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreGroupChatInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreGroupChatInfo(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void searchMoreMsgWithKeywords(final int searchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, searchId);
        } else {
            check("searchMoreMsgWithKeywords", new Function0<Unit>(searchId) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMoreMsgWithKeywords$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $searchId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$searchId = searchId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchService.this, searchId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.searchMoreMsgWithKeywords(this.$searchId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public int searchMsgWithKeywords(@NotNull final ArrayList<String> keywords, @Nullable final SearchMsgWithKeywordsParams params, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, keywords, params, cb5)).intValue();
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Integer num = (Integer) check("searchMsgWithKeywords", cb5, new Function1<IOperateCallback, Integer>(keywords, params) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$searchMsgWithKeywords$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $keywords;
            final /* synthetic */ SearchMsgWithKeywordsParams $params;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$keywords = keywords;
                this.$params = params;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchService.this, keywords, params);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Integer invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelSearchService service = SearchService.this.getService();
                if (service != null) {
                    return Integer.valueOf(service.searchMsgWithKeywords(this.$keywords, this.$params, iOperateCallback));
                }
                return null;
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.kernel.api.ae
    public void updateSearchHistory(@NotNull final SearchHistoryItem item, @Nullable final IUpdateSearchHistoryCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) item, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            check("updateSearchHistory", new Function0<Unit>(item, callback) { // from class: com.tencent.qqnt.kernel.api.impl.SearchService$updateSearchHistory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IUpdateSearchHistoryCallback $callback;
                final /* synthetic */ SearchHistoryItem $item;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchService.this, item, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelSearchService service = SearchService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.updateSearchHistory(this.$item, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
