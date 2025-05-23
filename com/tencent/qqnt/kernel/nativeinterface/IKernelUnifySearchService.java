package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelUnifySearchService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelUnifySearchService {
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

        private native void native_checkAIAuth(long j3, UfsCheckAIAuthReq ufsCheckAIAuthReq, ICheckAIAuthCallback iCheckAIAuthCallback);

        private native void native_getNetResultTabs(long j3, SearchNetResultTabsReq searchNetResultTabsReq, IGetNetResultTabsCallback iGetNetResultTabsCallback);

        private native void native_getNetSugWords(long j3, SearchNetSugWordsReq searchNetSugWordsReq, IGetNetSugWordsCallback iGetNetSugWordsCallback);

        private native void native_getSearchAppendingInfo(long j3, SearchAppendingInfoReq searchAppendingInfoReq, IGetSearchAppendingInfoCallback iGetSearchAppendingInfoCallback);

        private native void native_getSearchBoxSugWords(long j3, UfsGetSugWordsReq ufsGetSugWordsReq, IGetSearchBoxSugWordsCallback iGetSearchBoxSugWordsCallback);

        private native void native_search(long j3, SearchReqBody searchReqBody, ISearchCallback iSearchCallback);

        private native void native_unifySearch(long j3, UfsReqBody ufsReqBody, IUnifySearchCallback iUnifySearchCallback);

        private native void native_unifySearchDiscovery(long j3, UfsDisReqBody ufsDisReqBody, IUnifySearchDiscoveryCallback iUnifySearchDiscoveryCallback);

        private native void native_unifySearchDiscoveryInCache(long j3, UfsDisReqBody ufsDisReqBody, IUnifySearchDiscoveryCallback iUnifySearchDiscoveryCallback);

        private native void native_wxSearchReport(long j3, UfsWxaSearchReportReq ufsWxaSearchReportReq, IWxSearchReportCallback iWxSearchReportCallback);

        public static native int preloadMethod();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void checkAIAuth(UfsCheckAIAuthReq ufsCheckAIAuthReq, ICheckAIAuthCallback iCheckAIAuthCallback) {
            native_checkAIAuth(this.nativeRef, ufsCheckAIAuthReq, iCheckAIAuthCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void getNetResultTabs(SearchNetResultTabsReq searchNetResultTabsReq, IGetNetResultTabsCallback iGetNetResultTabsCallback) {
            native_getNetResultTabs(this.nativeRef, searchNetResultTabsReq, iGetNetResultTabsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void getNetSugWords(SearchNetSugWordsReq searchNetSugWordsReq, IGetNetSugWordsCallback iGetNetSugWordsCallback) {
            native_getNetSugWords(this.nativeRef, searchNetSugWordsReq, iGetNetSugWordsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void getSearchAppendingInfo(SearchAppendingInfoReq searchAppendingInfoReq, IGetSearchAppendingInfoCallback iGetSearchAppendingInfoCallback) {
            native_getSearchAppendingInfo(this.nativeRef, searchAppendingInfoReq, iGetSearchAppendingInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void getSearchBoxSugWords(UfsGetSugWordsReq ufsGetSugWordsReq, IGetSearchBoxSugWordsCallback iGetSearchBoxSugWordsCallback) {
            native_getSearchBoxSugWords(this.nativeRef, ufsGetSugWordsReq, iGetSearchBoxSugWordsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void search(SearchReqBody searchReqBody, ISearchCallback iSearchCallback) {
            native_search(this.nativeRef, searchReqBody, iSearchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void unifySearch(UfsReqBody ufsReqBody, IUnifySearchCallback iUnifySearchCallback) {
            native_unifySearch(this.nativeRef, ufsReqBody, iUnifySearchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void unifySearchDiscovery(UfsDisReqBody ufsDisReqBody, IUnifySearchDiscoveryCallback iUnifySearchDiscoveryCallback) {
            native_unifySearchDiscovery(this.nativeRef, ufsDisReqBody, iUnifySearchDiscoveryCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void unifySearchDiscoveryInCache(UfsDisReqBody ufsDisReqBody, IUnifySearchDiscoveryCallback iUnifySearchDiscoveryCallback) {
            native_unifySearchDiscoveryInCache(this.nativeRef, ufsDisReqBody, iUnifySearchDiscoveryCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
        public void wxSearchReport(UfsWxaSearchReportReq ufsWxaSearchReportReq, IWxSearchReportCallback iWxSearchReportCallback) {
            native_wxSearchReport(this.nativeRef, ufsWxaSearchReportReq, iWxSearchReportCallback);
        }
    }

    void checkAIAuth(UfsCheckAIAuthReq ufsCheckAIAuthReq, ICheckAIAuthCallback iCheckAIAuthCallback);

    void getNetResultTabs(SearchNetResultTabsReq searchNetResultTabsReq, IGetNetResultTabsCallback iGetNetResultTabsCallback);

    void getNetSugWords(SearchNetSugWordsReq searchNetSugWordsReq, IGetNetSugWordsCallback iGetNetSugWordsCallback);

    void getSearchAppendingInfo(SearchAppendingInfoReq searchAppendingInfoReq, IGetSearchAppendingInfoCallback iGetSearchAppendingInfoCallback);

    void getSearchBoxSugWords(UfsGetSugWordsReq ufsGetSugWordsReq, IGetSearchBoxSugWordsCallback iGetSearchBoxSugWordsCallback);

    void search(SearchReqBody searchReqBody, ISearchCallback iSearchCallback);

    void unifySearch(UfsReqBody ufsReqBody, IUnifySearchCallback iUnifySearchCallback);

    void unifySearchDiscovery(UfsDisReqBody ufsDisReqBody, IUnifySearchDiscoveryCallback iUnifySearchDiscoveryCallback);

    void unifySearchDiscoveryInCache(UfsDisReqBody ufsDisReqBody, IUnifySearchDiscoveryCallback iUnifySearchDiscoveryCallback);

    void wxSearchReport(UfsWxaSearchReportReq ufsWxaSearchReportReq, IWxSearchReportCallback iWxSearchReportCallback);
}
