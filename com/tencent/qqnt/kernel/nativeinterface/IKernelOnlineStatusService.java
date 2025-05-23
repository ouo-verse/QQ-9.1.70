package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelOnlineStatusService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelOnlineStatusService {
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

        private native long native_addKernelOnlineStatusListener(long j3, IKernelOnlineStatusListener iKernelOnlineStatusListener);

        private native void native_checkLikeStatus(long j3, OSCheckLikeReq oSCheckLikeReq, IOSCheckLikeStatusCallback iOSCheckLikeStatusCallback);

        private native void native_didClickAggregationPageEntrance(long j3);

        private native void native_getAggregationGroupModels(long j3, IOSGetAggregationCallback iOSGetAggregationCallback);

        private native void native_getAggregationPageEntrance(long j3, IOSGetAggregationPageEntranceCallback iOSGetAggregationPageEntranceCallback);

        private native void native_getLikeList(long j3, OSGetLikeListReq oSGetLikeListReq, IOSGetLikeListCallback iOSGetLikeListCallback);

        private native void native_getShouldShowAIOStatusAnimation(long j3, String str, IOSGetShouldShowAIOStatusAnimationCallback iOSGetShouldShowAIOStatusAnimationCallback);

        private native void native_removeKernelOnlineStatusListener(long j3, long j16);

        private native void native_setLikeStatus(long j3, OSLikeStatusReq oSLikeStatusReq, IOSLikeStatusCallback iOSLikeStatusCallback);

        private native void native_setOnlineStatusLiteBusinessSwitch(long j3, boolean z16);

        private native void native_setReadLikeList(long j3, OSReadLikeListReq oSReadLikeListReq, IOSReadLikeListCallback iOSReadLikeListCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public long addKernelOnlineStatusListener(IKernelOnlineStatusListener iKernelOnlineStatusListener) {
            return native_addKernelOnlineStatusListener(this.nativeRef, iKernelOnlineStatusListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void checkLikeStatus(OSCheckLikeReq oSCheckLikeReq, IOSCheckLikeStatusCallback iOSCheckLikeStatusCallback) {
            native_checkLikeStatus(this.nativeRef, oSCheckLikeReq, iOSCheckLikeStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void didClickAggregationPageEntrance() {
            native_didClickAggregationPageEntrance(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void getAggregationGroupModels(IOSGetAggregationCallback iOSGetAggregationCallback) {
            native_getAggregationGroupModels(this.nativeRef, iOSGetAggregationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void getAggregationPageEntrance(IOSGetAggregationPageEntranceCallback iOSGetAggregationPageEntranceCallback) {
            native_getAggregationPageEntrance(this.nativeRef, iOSGetAggregationPageEntranceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void getLikeList(OSGetLikeListReq oSGetLikeListReq, IOSGetLikeListCallback iOSGetLikeListCallback) {
            native_getLikeList(this.nativeRef, oSGetLikeListReq, iOSGetLikeListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void getShouldShowAIOStatusAnimation(String str, IOSGetShouldShowAIOStatusAnimationCallback iOSGetShouldShowAIOStatusAnimationCallback) {
            native_getShouldShowAIOStatusAnimation(this.nativeRef, str, iOSGetShouldShowAIOStatusAnimationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void removeKernelOnlineStatusListener(long j3) {
            native_removeKernelOnlineStatusListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void setLikeStatus(OSLikeStatusReq oSLikeStatusReq, IOSLikeStatusCallback iOSLikeStatusCallback) {
            native_setLikeStatus(this.nativeRef, oSLikeStatusReq, iOSLikeStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void setOnlineStatusLiteBusinessSwitch(boolean z16) {
            native_setOnlineStatusLiteBusinessSwitch(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
        public void setReadLikeList(OSReadLikeListReq oSReadLikeListReq, IOSReadLikeListCallback iOSReadLikeListCallback) {
            native_setReadLikeList(this.nativeRef, oSReadLikeListReq, iOSReadLikeListCallback);
        }
    }

    long addKernelOnlineStatusListener(IKernelOnlineStatusListener iKernelOnlineStatusListener);

    void checkLikeStatus(OSCheckLikeReq oSCheckLikeReq, IOSCheckLikeStatusCallback iOSCheckLikeStatusCallback);

    void didClickAggregationPageEntrance();

    void getAggregationGroupModels(IOSGetAggregationCallback iOSGetAggregationCallback);

    void getAggregationPageEntrance(IOSGetAggregationPageEntranceCallback iOSGetAggregationPageEntranceCallback);

    void getLikeList(OSGetLikeListReq oSGetLikeListReq, IOSGetLikeListCallback iOSGetLikeListCallback);

    void getShouldShowAIOStatusAnimation(String str, IOSGetShouldShowAIOStatusAnimationCallback iOSGetShouldShowAIOStatusAnimationCallback);

    void removeKernelOnlineStatusListener(long j3);

    void setLikeStatus(OSLikeStatusReq oSLikeStatusReq, IOSLikeStatusCallback iOSLikeStatusCallback);

    void setOnlineStatusLiteBusinessSwitch(boolean z16);

    void setReadLikeList(OSReadLikeListReq oSReadLikeListReq, IOSReadLikeListCallback iOSReadLikeListCallback);
}
