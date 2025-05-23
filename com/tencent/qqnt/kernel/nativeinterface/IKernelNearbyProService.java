package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelNearbyProService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelNearbyProService {
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

        private native void native_addKernelNearbyProListener(long j3, IKernelNearbyProListener iKernelNearbyProListener);

        private native void native_fetchNearbyProUserInfo(long j3, ArrayList<Long> arrayList, NearbyProCommonExtInfo nearbyProCommonExtInfo, boolean z16, IFetchNearbyProUserInfoCallback iFetchNearbyProUserInfoCallback);

        private native void native_getNearbyAllContactsUnreadCnt(long j3, IOperateCallback iOperateCallback);

        private native void native_removeKernelNearbyProListener(long j3, IKernelNearbyProListener iKernelNearbyProListener);

        private native void native_setCommonExtInfo(long j3, NearbyProCommonExtInfo nearbyProCommonExtInfo);

        public static native int preloadMethod();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService
        public void addKernelNearbyProListener(IKernelNearbyProListener iKernelNearbyProListener) {
            native_addKernelNearbyProListener(this.nativeRef, iKernelNearbyProListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService
        public void fetchNearbyProUserInfo(ArrayList<Long> arrayList, NearbyProCommonExtInfo nearbyProCommonExtInfo, boolean z16, IFetchNearbyProUserInfoCallback iFetchNearbyProUserInfoCallback) {
            native_fetchNearbyProUserInfo(this.nativeRef, arrayList, nearbyProCommonExtInfo, z16, iFetchNearbyProUserInfoCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService
        public void getNearbyAllContactsUnreadCnt(IOperateCallback iOperateCallback) {
            native_getNearbyAllContactsUnreadCnt(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService
        public void removeKernelNearbyProListener(IKernelNearbyProListener iKernelNearbyProListener) {
            native_removeKernelNearbyProListener(this.nativeRef, iKernelNearbyProListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService
        public void setCommonExtInfo(NearbyProCommonExtInfo nearbyProCommonExtInfo) {
            native_setCommonExtInfo(this.nativeRef, nearbyProCommonExtInfo);
        }
    }

    void addKernelNearbyProListener(IKernelNearbyProListener iKernelNearbyProListener);

    void fetchNearbyProUserInfo(ArrayList<Long> arrayList, NearbyProCommonExtInfo nearbyProCommonExtInfo, boolean z16, IFetchNearbyProUserInfoCallback iFetchNearbyProUserInfoCallback);

    void getNearbyAllContactsUnreadCnt(IOperateCallback iOperateCallback);

    void removeKernelNearbyProListener(IKernelNearbyProListener iKernelNearbyProListener);

    void setCommonExtInfo(NearbyProCommonExtInfo nearbyProCommonExtInfo);
}
