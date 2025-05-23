package com.tencent.qqnt.kernel.api;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.qqnt.kernel.nativeinterface.IAddSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchBudlyCoreCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.ILoadSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUpdateSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatAtMeMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchHistoryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgWithKeywordsParams;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J2\u0010\u000f\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J$\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J4\u0010\u001d\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J\"\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J4\u0010\"\u001a\u00020\u000b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J\"\u0010$\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J0\u0010&\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u001c\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J \u0010(\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\bH&J0\u0010)\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\rH&J8\u0010/\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u001c\u001a\u00020.2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J \u00102\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH&J \u00103\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH&J*\u00107\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u0010!\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\u0010\u00108\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J\"\u00109\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\u001c\u0010;\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010:2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&J\"\u0010=\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\u0012\u0010?\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010>H&J\u0012\u0010@\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\u001a\u0010D\u001a\u00020\u00042\u0006\u0010B\u001a\u00020A2\b\u0010\u0018\u001a\u0004\u0018\u00010CH&J\u001a\u0010F\u001a\u00020\u00042\u0006\u0010B\u001a\u00020A2\b\u0010\u000e\u001a\u0004\u0018\u00010EH&J*\u0010G\u001a\u00020\u00042\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020A0\u0007j\b\u0012\u0004\u0012\u00020A`\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\u0012\u0010K\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010JH&J\b\u0010L\u001a\u00020\u0004H&J\b\u0010M\u001a\u00020\u0004H&\u00a8\u0006N"}, d2 = {"Lcom/tencent/qqnt/kernel/api/ae;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "listener", "", "addKernelSearchListener", "q0", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "keywords", "", "pageLimit", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "searchFunction", "searchId", "searchMoreFunction", "code", "reason", "cancelSearchFunction", "keyWord", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalBusinessType;", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "result", "searchLocalInfo", "cancelSearchLocalInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgWithKeywordsParams;", "params", "searchMsgWithKeywords", "searchMoreMsgWithKeywords", "cancelSearchMsgWithKeywords", "searchFields", "pageCount", "searchChatsWithKeywords", "searchMoreChatsWithKeywords", "cancelSearchChatsWithKeywords", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatMsgsParams;", "searchChatMsgs", "searchMoreChatMsgs", "cancelSearchChatMsgs", "searchBuddyChatInfo", "searchMoreBuddyChatInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyInfoParams;", "searchParams", "searchBuddyChatInfoWithParams", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupChatInfoParams;", "searchGroupChatInfo", "searchMoreGroupChatInfo", QzoneIPCModule.RESULT_CODE, "cancelSearchGroupChatInfo", "cancelSearchBuddyChatInfo", "", "includeAtAll", "totalCount", "searchAtMeChats", "searchMoreAtMeChats", "cancelSearchAtMeChats", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatAtMeMsgsParams;", "searchChatAtMeMsgs", "searchMoreChatAtMeMsgs", "cancelSearchChatAtMeMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoadSearchHistoryCallback;", "loadSearchHistory", "clearSearchHistory", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHistoryItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/IAddSearchHistoryCallback;", "addSearchHistory", "Lcom/tencent/qqnt/kernel/nativeinterface/IUpdateSearchHistoryCallback;", "updateSearchHistory", "batchAddSearchHistory", "id", "removeSearchHistory", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSearchBudlyCoreCallback;", "searchCoreBuddy", "initTokenizeUtil", "releaseTokenizeUtil", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ae extends j {
    void addKernelSearchListener(@NotNull IKernelSearchListener listener);

    void addSearchHistory(@NotNull SearchHistoryItem item, @Nullable IAddSearchHistoryCallback result);

    void batchAddSearchHistory(@NotNull ArrayList<SearchHistoryItem> item, @Nullable IOperateCallback callback);

    void cancelSearchAtMeChats(int searchId, int code, @Nullable String reason);

    void cancelSearchBuddyChatInfo(int searchId, int resultCode, @NotNull String result);

    void cancelSearchChatAtMeMsgs(int searchId, int code, @Nullable String reason);

    void cancelSearchChatMsgs(int searchId, int code, @NotNull String reason);

    void cancelSearchChatsWithKeywords(int searchId, int code, @Nullable String reason);

    void cancelSearchFunction(int searchId, int code, @Nullable String reason);

    void cancelSearchGroupChatInfo(int searchId, int resultCode, @NotNull String result);

    void cancelSearchLocalInfo(int searchId, int code, @Nullable String reason);

    void cancelSearchMsgWithKeywords(int searchId, int code, @Nullable String reason);

    void clearSearchHistory(@Nullable IOperateCallback result);

    void initTokenizeUtil();

    void loadSearchHistory(@Nullable ILoadSearchHistoryCallback result);

    void q0(@NotNull IKernelSearchListener listener);

    void releaseTokenizeUtil();

    void removeSearchHistory(int id5, @Nullable IOperateCallback result);

    int searchAtMeChats(boolean includeAtAll, int pageCount, int totalCount, @Nullable IOperateCallback result);

    int searchBuddyChatInfo(@NotNull ArrayList<String> keywords, int pageLimit, @NotNull IOperateCallback callback);

    int searchBuddyChatInfoWithParams(@NotNull SearchBuddyInfoParams searchParams, @NotNull IOperateCallback callback);

    int searchChatAtMeMsgs(@Nullable SearchChatAtMeMsgsParams params, @Nullable IOperateCallback callback);

    int searchChatMsgs(@NotNull ArrayList<String> keywords, @NotNull SearchChatMsgsParams params, @NotNull IOperateCallback callback);

    int searchChatsWithKeywords(@Nullable ArrayList<String> keywords, int searchFields, int pageCount, @Nullable IOperateCallback result);

    void searchCoreBuddy(@Nullable IGetSearchBudlyCoreCallback callback);

    int searchFunction(@NotNull ArrayList<String> keywords, int pageLimit, @Nullable IOperateCallback callback);

    int searchGroupChatInfo(@NotNull ArrayList<String> keywords, @NotNull SearchGroupChatInfoParams params, int pageLimit, @NotNull IOperateCallback callback);

    int searchLocalInfo(@Nullable String keyWord, @NotNull SearchLocalBusinessType searchType, @Nullable IOperateCallback result);

    void searchMoreAtMeChats(int searchId);

    void searchMoreBuddyChatInfo(int searchId);

    void searchMoreChatAtMeMsgs(int searchId);

    void searchMoreChatMsgs(int searchId);

    void searchMoreChatsWithKeywords(int searchId);

    void searchMoreFunction(int searchId);

    void searchMoreGroupChatInfo(int searchId);

    void searchMoreMsgWithKeywords(int searchId);

    int searchMsgWithKeywords(@NotNull ArrayList<String> keywords, @Nullable SearchMsgWithKeywordsParams params, @Nullable IOperateCallback result);

    void updateSearchHistory(@NotNull SearchHistoryItem item, @Nullable IUpdateSearchHistoryCallback callback);
}
