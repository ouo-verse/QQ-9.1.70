package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelLiteBusinessService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelLiteBusinessService {
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

        private native long native_addListener(long j3, IKernelLiteBusinessListener iKernelLiteBusinessListener);

        private native void native_clearLiteActionForTesting(long j3, IOperateCallback iOperateCallback);

        private native void native_clearLiteBusiness(long j3, String str, HashSet<LiteBusinessClearType> hashSet, IOperateCallback iOperateCallback);

        private native void native_clickLiteAction(long j3, String str, int i3);

        private native void native_exposeLiteAction(long j3, String str, int i3);

        private native void native_generateLiteActionForTesting(long j3, IOperateCallback iOperateCallback);

        private native void native_getLiteBusiness(long j3, String str, HashSet<LiteBusinessType> hashSet, IOperateCallback iOperateCallback);

        private native void native_getRevealTofuAuthority(long j3, RevealAuthorityReq revealAuthorityReq, IGetRevealTofuAuthorityCallback iGetRevealTofuAuthorityCallback);

        private native void native_insertRevealSuc(long j3, RevealDoufuInfo revealDoufuInfo);

        private native void native_recentRevealExposure(long j3, RevealDoufuInfo revealDoufuInfo);

        private native void native_removeListener(long j3, long j16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public long addListener(IKernelLiteBusinessListener iKernelLiteBusinessListener) {
            return native_addListener(this.nativeRef, iKernelLiteBusinessListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void clearLiteActionForTesting(IOperateCallback iOperateCallback) {
            native_clearLiteActionForTesting(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void clearLiteBusiness(String str, HashSet<LiteBusinessClearType> hashSet, IOperateCallback iOperateCallback) {
            native_clearLiteBusiness(this.nativeRef, str, hashSet, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void clickLiteAction(String str, int i3) {
            native_clickLiteAction(this.nativeRef, str, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void exposeLiteAction(String str, int i3) {
            native_exposeLiteAction(this.nativeRef, str, i3);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void generateLiteActionForTesting(IOperateCallback iOperateCallback) {
            native_generateLiteActionForTesting(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void getLiteBusiness(String str, HashSet<LiteBusinessType> hashSet, IOperateCallback iOperateCallback) {
            native_getLiteBusiness(this.nativeRef, str, hashSet, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void getRevealTofuAuthority(RevealAuthorityReq revealAuthorityReq, IGetRevealTofuAuthorityCallback iGetRevealTofuAuthorityCallback) {
            native_getRevealTofuAuthority(this.nativeRef, revealAuthorityReq, iGetRevealTofuAuthorityCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void insertRevealSuc(RevealDoufuInfo revealDoufuInfo) {
            native_insertRevealSuc(this.nativeRef, revealDoufuInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void recentRevealExposure(RevealDoufuInfo revealDoufuInfo) {
            native_recentRevealExposure(this.nativeRef, revealDoufuInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
        public void removeListener(long j3) {
            native_removeListener(this.nativeRef, j3);
        }
    }

    long addListener(IKernelLiteBusinessListener iKernelLiteBusinessListener);

    void clearLiteActionForTesting(IOperateCallback iOperateCallback);

    void clearLiteBusiness(String str, HashSet<LiteBusinessClearType> hashSet, IOperateCallback iOperateCallback);

    void clickLiteAction(String str, int i3);

    void exposeLiteAction(String str, int i3);

    void generateLiteActionForTesting(IOperateCallback iOperateCallback);

    void getLiteBusiness(String str, HashSet<LiteBusinessType> hashSet, IOperateCallback iOperateCallback);

    void getRevealTofuAuthority(RevealAuthorityReq revealAuthorityReq, IGetRevealTofuAuthorityCallback iGetRevealTofuAuthorityCallback);

    void insertRevealSuc(RevealDoufuInfo revealDoufuInfo);

    void recentRevealExposure(RevealDoufuInfo revealDoufuInfo);

    void removeListener(long j3);
}
