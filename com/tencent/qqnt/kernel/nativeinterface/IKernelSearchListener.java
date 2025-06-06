package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelSearchListener {
    void onSearchAtMeChatsResult(SearchAtMeChatsResult searchAtMeChatsResult);

    void onSearchAtMeMsgsResult(SearchAtMeMsgsResult searchAtMeMsgsResult);

    void onSearchBuddyChatInfoResult(SearchBuddyChatInfoResult searchBuddyChatInfoResult);

    void onSearchCacheResult(String str, String str2, ArrayList<String> arrayList);

    void onSearchChatsKeywordsResult(SearchChatsKeywordsResult searchChatsKeywordsResult);

    void onSearchContactResult(SearchContactResult searchContactResult);

    void onSearchFileKeywordsResult(SearchFileKeywordsResult searchFileKeywordsResult);

    void onSearchFunctionResult(SearchFunctionResult searchFunctionResult);

    void onSearchGroupChatInfoResult(SearchGroupChatInfoResult searchGroupChatInfoResult);

    void onSearchGroupResult(SearchGroupResult searchGroupResult);

    void onSearchLocalInfoResult(SearchLocalInfoResult searchLocalInfoResult);

    void onSearchMsgKeywordsResult(SearchMsgKeywordsResult searchMsgKeywordsResult);

    void onSearchResult(SearchResult searchResult);
}
