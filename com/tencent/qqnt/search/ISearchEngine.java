package com.tencent.qqnt.search;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgWithKeywordsParams;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(needUin = false, process = {""})
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\f\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J \u0010\u0013\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fH&J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H&J \u0010\u0016\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fH&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011H&J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011H&J(\u0010\u001f\u001a\u00020\u00032\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010 \u001a\u00020!H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0011H&\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/search/ISearchEngine;", "Lmqq/app/api/IRuntimeService;", "cancelBuddySearch", "", "id", "", QzoneIPCModule.RESULT_CODE, "result", "", "cancelChatSearch", "cancelGroupSearch", "cancelLocalInfoSearch", "searchBuddy", "keywords", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "searchBuddyResultFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyChatInfoResult;", "searchChat", "searchChatResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatsKeywordsResult;", "searchGroup", "searchGroupResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupChatInfoResult;", "searchLocalInfo", "keyWord", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalBusinessType;", "searchLocalInfoResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "searchMsg", "params", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgWithKeywordsParams;", "searchMsgResultFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "search_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface ISearchEngine extends IRuntimeService {
    void cancelBuddySearch(int id5, int resultCode, @NotNull String result);

    void cancelChatSearch(int id5, int resultCode, @NotNull String result);

    void cancelGroupSearch(int id5, int resultCode, @NotNull String result);

    void cancelLocalInfoSearch(int id5, int resultCode, @NotNull String result);

    int searchBuddy(@NotNull ArrayList<String> keywords);

    @NotNull
    Flow<SearchBuddyChatInfoResult> searchBuddyResultFlow();

    int searchChat(@NotNull ArrayList<String> keywords);

    @NotNull
    Flow<SearchChatsKeywordsResult> searchChatResultFlow();

    int searchGroup(@NotNull ArrayList<String> keywords);

    @NotNull
    Flow<SearchGroupChatInfoResult> searchGroupResultFlow();

    int searchLocalInfo(@Nullable String keyWord, @NotNull SearchLocalBusinessType searchType);

    @NotNull
    Flow<SearchLocalInfoResult> searchLocalInfoResultFlow();

    void searchMsg(@NotNull ArrayList<String> keywords, @NotNull SearchMsgWithKeywordsParams params);

    @NotNull
    Flow<SearchMsgKeywordsResult> searchMsgResultFlow();
}
