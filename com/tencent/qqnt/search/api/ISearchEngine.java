package com.tencent.qqnt.search.api;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatAtMeMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgWithKeywordsParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(needUin = false, process = {""})
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H&J(\u0010\u0018\u001a\u00020\u00052\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001aj\b\u0012\u0004\u0012\u00020\b`\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H&J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014H&J2\u0010\"\u001a\u00020\u00052\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001aj\b\u0012\u0004\u0012\u00020\b`\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$H&J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0014H&J\u001a\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020*H&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0014H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u00102\u001a\u00020\u00052\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001aj\b\u0012\u0004\u0012\u00020\b`\u001b2\u0006\u0010\u001e\u001a\u000203H&J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0014H&\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/search/api/ISearchEngine;", "Lmqq/app/api/IRuntimeService;", "cancelSearchAtMeChats", "", "searchId", "", "code", "reason", "", "cancelSearchChatAtMeMsgs", "cancelSearchChatsWithKeywords", "cancelSearchFunction", "cancelSearchLocalInfo", "cancelSearchMsgWithKeywords", "searchAtMeChats", "includeAtAll", "", "pageCount", "totalCount", "searchAtMeChatsResultFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeChatsResult;", "searchAtMeMsgsResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsResult;", "searchChat", "keywords", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageLimit", "searchChatAtMeMsgs", "params", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatAtMeMsgsParams;", "searchChatResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatsKeywordsResult;", "searchFunction", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "searchFunctionResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFunctionResult;", "searchLocalInfo", "keyWord", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalBusinessType;", "searchLocalInfoResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "searchMoreAtMeChats", "searchMoreChat", "searchMoreChatAtMeMsgs", "searchMoreFunction", "searchMoreMsg", "searchMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgWithKeywordsParams;", "searchMsgResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface ISearchEngine extends IRuntimeService {
    void cancelSearchAtMeChats(int searchId, int code, @Nullable String reason);

    void cancelSearchChatAtMeMsgs(int searchId, int code, @Nullable String reason);

    void cancelSearchChatsWithKeywords(int searchId, int code, @Nullable String reason);

    void cancelSearchFunction(int searchId, int code, @Nullable String reason);

    void cancelSearchLocalInfo(int searchId, int code, @Nullable String reason);

    void cancelSearchMsgWithKeywords(int searchId, int code, @Nullable String reason);

    int searchAtMeChats(boolean includeAtAll, int pageCount, int totalCount);

    @NotNull
    Flow<SearchAtMeChatsResult> searchAtMeChatsResultFlow();

    @NotNull
    Flow<SearchAtMeMsgsResult> searchAtMeMsgsResultFlow();

    int searchChat(@NotNull ArrayList<String> keywords, int pageLimit);

    int searchChatAtMeMsgs(@Nullable SearchChatAtMeMsgsParams params);

    @NotNull
    Flow<SearchChatsKeywordsResult> searchChatResultFlow();

    int searchFunction(@NotNull ArrayList<String> keywords, int pageLimit, @Nullable IOperateCallback callback);

    @NotNull
    Flow<SearchFunctionResult> searchFunctionResultFlow();

    int searchLocalInfo(@Nullable String keyWord, @NotNull SearchLocalBusinessType searchType);

    @NotNull
    Flow<SearchLocalInfoResult> searchLocalInfoResultFlow();

    void searchMoreAtMeChats(int searchId);

    void searchMoreChat(int searchId);

    void searchMoreChatAtMeMsgs(int searchId);

    void searchMoreFunction(int searchId);

    void searchMoreMsg(int searchId);

    int searchMsg(@NotNull ArrayList<String> keywords, @NotNull SearchMsgWithKeywordsParams params);

    @NotNull
    Flow<SearchMsgKeywordsResult> searchMsgResultFlow();
}
