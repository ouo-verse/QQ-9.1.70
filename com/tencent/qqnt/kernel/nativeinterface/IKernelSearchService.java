package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelSearchService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelSearchService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native long native_addKernelSearchListener(long j3, IKernelSearchListener iKernelSearchListener);

        private native void native_addSearchHistory(long j3, SearchHistoryItem searchHistoryItem, IAddSearchHistoryCallback iAddSearchHistoryCallback);

        private native void native_batchAddSearchHistory(long j3, ArrayList<SearchHistoryItem> arrayList, IOperateCallback iOperateCallback);

        private native void native_cancelSearchAtMeChats(long j3, int i3, int i16, String str);

        private native void native_cancelSearchBuddyChatInfo(long j3, int i3, int i16, String str);

        private native void native_cancelSearchChatAtMeMsgs(long j3, int i3, int i16, String str);

        private native void native_cancelSearchChatMsgs(long j3, int i3, int i16, String str);

        private native void native_cancelSearchChatsWithKeywords(long j3, int i3, int i16, String str);

        private native void native_cancelSearchFileWithKeywords(long j3, int i3, int i16, String str);

        private native void native_cancelSearchFunction(long j3, int i3, int i16, String str);

        private native void native_cancelSearchGroupChatInfo(long j3, int i3, int i16, String str);

        private native void native_cancelSearchLocalInfo(long j3, int i3, int i16, String str);

        private native void native_cancelSearchMsgWithKeywords(long j3, int i3, int i16, String str);

        private native void native_clearSearchCache(long j3, String str);

        private native void native_clearSearchHistory(long j3, IOperateCallback iOperateCallback);

        private native void native_initTokenizeUtil(long j3);

        private native void native_loadSearchHistory(long j3, ILoadSearchHistoryCallback iLoadSearchHistoryCallback);

        private native void native_releaseTokenizeUtil(long j3);

        private native void native_removeKernelSearchListener(long j3, long j16);

        private native void native_removeSearchHistory(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_resetSearchGroupChatInfoFilterMembers(long j3, int i3, ArrayList<String> arrayList, int i16);

        private native void native_resetSearchGroupChatInfoSortType(long j3, int i3, SearchGroupChatInfoSortType searchGroupChatInfoSortType, int i16);

        private native int native_searchAtMeChats(long j3, boolean z16, int i3, int i16, IOperateCallback iOperateCallback);

        private native int native_searchBuddyChatInfo(long j3, ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

        private native int native_searchBuddyChatInfoWithParams(long j3, SearchBuddyInfoParams searchBuddyInfoParams, IOperateCallback iOperateCallback);

        private native void native_searchCache(long j3, String str, String str2, IKernelSearchCacheProxy iKernelSearchCacheProxy);

        private native int native_searchChatAtMeMsgs(long j3, SearchChatAtMeMsgsParams searchChatAtMeMsgsParams, IOperateCallback iOperateCallback);

        private native int native_searchChatMsgs(long j3, ArrayList<String> arrayList, SearchChatMsgsParams searchChatMsgsParams, IOperateCallback iOperateCallback);

        private native int native_searchChatsWithKeywords(long j3, ArrayList<String> arrayList, int i3, int i16, IOperateCallback iOperateCallback);

        private native void native_searchCoreBuddy(long j3, IGetSearchBudlyCoreCallback iGetSearchBudlyCoreCallback);

        private native int native_searchFileWithKeywords(long j3, ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

        private native int native_searchFunction(long j3, ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

        private native void native_searchGroup(long j3, SearchGroup searchGroup, IOperateCallback iOperateCallback);

        private native int native_searchGroupChatInfo(long j3, ArrayList<String> arrayList, SearchGroupChatInfoParams searchGroupChatInfoParams, int i3, IOperateCallback iOperateCallback);

        private native int native_searchLocalInfo(long j3, String str, SearchLocalBusinessType searchLocalBusinessType, IOperateCallback iOperateCallback);

        private native void native_searchMoreAtMeChats(long j3, int i3);

        private native void native_searchMoreBuddyChatInfo(long j3, int i3);

        private native void native_searchMoreBuddyChatInfoWithPageLimit(long j3, int i3, int i16);

        private native void native_searchMoreChatAtMeMsgs(long j3, int i3);

        private native void native_searchMoreChatMsgs(long j3, int i3);

        private native void native_searchMoreChatsWithKeywords(long j3, int i3);

        private native void native_searchMoreFileWithKeywords(long j3, int i3);

        private native void native_searchMoreFunction(long j3, int i3);

        private native void native_searchMoreGroupChatInfo(long j3, int i3);

        private native void native_searchMoreMsgWithKeywords(long j3, int i3);

        private native int native_searchMsgWithKeywords(long j3, ArrayList<String> arrayList, SearchMsgWithKeywordsParams searchMsgWithKeywordsParams, IOperateCallback iOperateCallback);

        private native void native_searchStranger(long j3, long j16, SearchStranger searchStranger, SearchParams searchParams, IOperateCallback iOperateCallback);

        private native void native_updateSearchHistory(long j3, SearchHistoryItem searchHistoryItem, IUpdateSearchHistoryCallback iUpdateSearchHistoryCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public long addKernelSearchListener(IKernelSearchListener iKernelSearchListener) {
            return native_addKernelSearchListener(this.nativeRef, iKernelSearchListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void addSearchHistory(SearchHistoryItem searchHistoryItem, IAddSearchHistoryCallback iAddSearchHistoryCallback) {
            native_addSearchHistory(this.nativeRef, searchHistoryItem, iAddSearchHistoryCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void batchAddSearchHistory(ArrayList<SearchHistoryItem> arrayList, IOperateCallback iOperateCallback) {
            native_batchAddSearchHistory(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchAtMeChats(int i3, int i16, String str) {
            native_cancelSearchAtMeChats(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchBuddyChatInfo(int i3, int i16, String str) {
            native_cancelSearchBuddyChatInfo(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchChatAtMeMsgs(int i3, int i16, String str) {
            native_cancelSearchChatAtMeMsgs(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchChatMsgs(int i3, int i16, String str) {
            native_cancelSearchChatMsgs(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchChatsWithKeywords(int i3, int i16, String str) {
            native_cancelSearchChatsWithKeywords(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchFileWithKeywords(int i3, int i16, String str) {
            native_cancelSearchFileWithKeywords(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchFunction(int i3, int i16, String str) {
            native_cancelSearchFunction(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchGroupChatInfo(int i3, int i16, String str) {
            native_cancelSearchGroupChatInfo(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchLocalInfo(int i3, int i16, String str) {
            native_cancelSearchLocalInfo(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void cancelSearchMsgWithKeywords(int i3, int i16, String str) {
            native_cancelSearchMsgWithKeywords(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void clearSearchCache(String str) {
            native_clearSearchCache(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void clearSearchHistory(IOperateCallback iOperateCallback) {
            native_clearSearchHistory(this.nativeRef, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void initTokenizeUtil() {
            native_initTokenizeUtil(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void loadSearchHistory(ILoadSearchHistoryCallback iLoadSearchHistoryCallback) {
            native_loadSearchHistory(this.nativeRef, iLoadSearchHistoryCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void releaseTokenizeUtil() {
            native_releaseTokenizeUtil(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void removeKernelSearchListener(long j3) {
            native_removeKernelSearchListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void removeSearchHistory(int i3, IOperateCallback iOperateCallback) {
            native_removeSearchHistory(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void resetSearchGroupChatInfoFilterMembers(int i3, ArrayList<String> arrayList, int i16) {
            native_resetSearchGroupChatInfoFilterMembers(this.nativeRef, i3, arrayList, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void resetSearchGroupChatInfoSortType(int i3, SearchGroupChatInfoSortType searchGroupChatInfoSortType, int i16) {
            native_resetSearchGroupChatInfoSortType(this.nativeRef, i3, searchGroupChatInfoSortType, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchAtMeChats(boolean z16, int i3, int i16, IOperateCallback iOperateCallback) {
            return native_searchAtMeChats(this.nativeRef, z16, i3, i16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchBuddyChatInfo(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback) {
            return native_searchBuddyChatInfo(this.nativeRef, arrayList, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchBuddyChatInfoWithParams(SearchBuddyInfoParams searchBuddyInfoParams, IOperateCallback iOperateCallback) {
            return native_searchBuddyChatInfoWithParams(this.nativeRef, searchBuddyInfoParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchCache(String str, String str2, IKernelSearchCacheProxy iKernelSearchCacheProxy) {
            native_searchCache(this.nativeRef, str, str2, iKernelSearchCacheProxy);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchChatAtMeMsgs(SearchChatAtMeMsgsParams searchChatAtMeMsgsParams, IOperateCallback iOperateCallback) {
            return native_searchChatAtMeMsgs(this.nativeRef, searchChatAtMeMsgsParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchChatMsgs(ArrayList<String> arrayList, SearchChatMsgsParams searchChatMsgsParams, IOperateCallback iOperateCallback) {
            return native_searchChatMsgs(this.nativeRef, arrayList, searchChatMsgsParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchChatsWithKeywords(ArrayList<String> arrayList, int i3, int i16, IOperateCallback iOperateCallback) {
            return native_searchChatsWithKeywords(this.nativeRef, arrayList, i3, i16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchCoreBuddy(IGetSearchBudlyCoreCallback iGetSearchBudlyCoreCallback) {
            native_searchCoreBuddy(this.nativeRef, iGetSearchBudlyCoreCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchFileWithKeywords(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback) {
            return native_searchFileWithKeywords(this.nativeRef, arrayList, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchFunction(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback) {
            return native_searchFunction(this.nativeRef, arrayList, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchGroup(SearchGroup searchGroup, IOperateCallback iOperateCallback) {
            native_searchGroup(this.nativeRef, searchGroup, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchGroupChatInfo(ArrayList<String> arrayList, SearchGroupChatInfoParams searchGroupChatInfoParams, int i3, IOperateCallback iOperateCallback) {
            return native_searchGroupChatInfo(this.nativeRef, arrayList, searchGroupChatInfoParams, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchLocalInfo(String str, SearchLocalBusinessType searchLocalBusinessType, IOperateCallback iOperateCallback) {
            return native_searchLocalInfo(this.nativeRef, str, searchLocalBusinessType, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreAtMeChats(int i3) {
            native_searchMoreAtMeChats(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreBuddyChatInfo(int i3) {
            native_searchMoreBuddyChatInfo(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreBuddyChatInfoWithPageLimit(int i3, int i16) {
            native_searchMoreBuddyChatInfoWithPageLimit(this.nativeRef, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreChatAtMeMsgs(int i3) {
            native_searchMoreChatAtMeMsgs(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreChatMsgs(int i3) {
            native_searchMoreChatMsgs(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreChatsWithKeywords(int i3) {
            native_searchMoreChatsWithKeywords(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreFileWithKeywords(int i3) {
            native_searchMoreFileWithKeywords(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreFunction(int i3) {
            native_searchMoreFunction(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreGroupChatInfo(int i3) {
            native_searchMoreGroupChatInfo(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchMoreMsgWithKeywords(int i3) {
            native_searchMoreMsgWithKeywords(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public int searchMsgWithKeywords(ArrayList<String> arrayList, SearchMsgWithKeywordsParams searchMsgWithKeywordsParams, IOperateCallback iOperateCallback) {
            return native_searchMsgWithKeywords(this.nativeRef, arrayList, searchMsgWithKeywordsParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void searchStranger(long j3, SearchStranger searchStranger, SearchParams searchParams, IOperateCallback iOperateCallback) {
            native_searchStranger(this.nativeRef, j3, searchStranger, searchParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService
        public void updateSearchHistory(SearchHistoryItem searchHistoryItem, IUpdateSearchHistoryCallback iUpdateSearchHistoryCallback) {
            native_updateSearchHistory(this.nativeRef, searchHistoryItem, iUpdateSearchHistoryCallback);
        }
    }

    long addKernelSearchListener(IKernelSearchListener iKernelSearchListener);

    void addSearchHistory(SearchHistoryItem searchHistoryItem, IAddSearchHistoryCallback iAddSearchHistoryCallback);

    void batchAddSearchHistory(ArrayList<SearchHistoryItem> arrayList, IOperateCallback iOperateCallback);

    void cancelSearchAtMeChats(int i3, int i16, String str);

    void cancelSearchBuddyChatInfo(int i3, int i16, String str);

    void cancelSearchChatAtMeMsgs(int i3, int i16, String str);

    void cancelSearchChatMsgs(int i3, int i16, String str);

    void cancelSearchChatsWithKeywords(int i3, int i16, String str);

    void cancelSearchFileWithKeywords(int i3, int i16, String str);

    void cancelSearchFunction(int i3, int i16, String str);

    void cancelSearchGroupChatInfo(int i3, int i16, String str);

    void cancelSearchLocalInfo(int i3, int i16, String str);

    void cancelSearchMsgWithKeywords(int i3, int i16, String str);

    void clearSearchCache(String str);

    void clearSearchHistory(IOperateCallback iOperateCallback);

    void initTokenizeUtil();

    void loadSearchHistory(ILoadSearchHistoryCallback iLoadSearchHistoryCallback);

    void releaseTokenizeUtil();

    void removeKernelSearchListener(long j3);

    void removeSearchHistory(int i3, IOperateCallback iOperateCallback);

    void resetSearchGroupChatInfoFilterMembers(int i3, ArrayList<String> arrayList, int i16);

    void resetSearchGroupChatInfoSortType(int i3, SearchGroupChatInfoSortType searchGroupChatInfoSortType, int i16);

    int searchAtMeChats(boolean z16, int i3, int i16, IOperateCallback iOperateCallback);

    int searchBuddyChatInfo(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

    int searchBuddyChatInfoWithParams(SearchBuddyInfoParams searchBuddyInfoParams, IOperateCallback iOperateCallback);

    void searchCache(String str, String str2, IKernelSearchCacheProxy iKernelSearchCacheProxy);

    int searchChatAtMeMsgs(SearchChatAtMeMsgsParams searchChatAtMeMsgsParams, IOperateCallback iOperateCallback);

    int searchChatMsgs(ArrayList<String> arrayList, SearchChatMsgsParams searchChatMsgsParams, IOperateCallback iOperateCallback);

    int searchChatsWithKeywords(ArrayList<String> arrayList, int i3, int i16, IOperateCallback iOperateCallback);

    void searchCoreBuddy(IGetSearchBudlyCoreCallback iGetSearchBudlyCoreCallback);

    int searchFileWithKeywords(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

    int searchFunction(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

    void searchGroup(SearchGroup searchGroup, IOperateCallback iOperateCallback);

    int searchGroupChatInfo(ArrayList<String> arrayList, SearchGroupChatInfoParams searchGroupChatInfoParams, int i3, IOperateCallback iOperateCallback);

    int searchLocalInfo(String str, SearchLocalBusinessType searchLocalBusinessType, IOperateCallback iOperateCallback);

    void searchMoreAtMeChats(int i3);

    void searchMoreBuddyChatInfo(int i3);

    void searchMoreBuddyChatInfoWithPageLimit(int i3, int i16);

    void searchMoreChatAtMeMsgs(int i3);

    void searchMoreChatMsgs(int i3);

    void searchMoreChatsWithKeywords(int i3);

    void searchMoreFileWithKeywords(int i3);

    void searchMoreFunction(int i3);

    void searchMoreGroupChatInfo(int i3);

    void searchMoreMsgWithKeywords(int i3);

    int searchMsgWithKeywords(ArrayList<String> arrayList, SearchMsgWithKeywordsParams searchMsgWithKeywordsParams, IOperateCallback iOperateCallback);

    void searchStranger(long j3, SearchStranger searchStranger, SearchParams searchParams, IOperateCallback iOperateCallback);

    void updateSearchHistory(SearchHistoryItem searchHistoryItem, IUpdateSearchHistoryCallback iUpdateSearchHistoryCallback);
}
