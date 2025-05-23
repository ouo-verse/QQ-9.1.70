package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelAVSDKService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelAVSDKService {
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

        private native void native_addKernelAVSDKListener(long j3, IKernelAVSDKListener iKernelAVSDKListener);

        private native void native_allowAlbumNotify(long j3);

        private native void native_removeKernelAVSDKListener(long j3, IKernelAVSDKListener iKernelAVSDKListener);

        private native void native_sendGroupVideoJsonBuffer(long j3, int i3, String str);

        private native void native_setActionFromAVSDK(long j3, int i3, byte[] bArr);

        private native void native_startGroupVideoCmdRequestFromAVSDK(long j3, GroupVideoCmdReq groupVideoCmdReq, IGroupVideoCmdRequestRsp iGroupVideoCmdRequestRsp);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService
        public void addKernelAVSDKListener(IKernelAVSDKListener iKernelAVSDKListener) {
            native_addKernelAVSDKListener(this.nativeRef, iKernelAVSDKListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService
        public void allowAlbumNotify() {
            native_allowAlbumNotify(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService
        public void removeKernelAVSDKListener(IKernelAVSDKListener iKernelAVSDKListener) {
            native_removeKernelAVSDKListener(this.nativeRef, iKernelAVSDKListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService
        public void sendGroupVideoJsonBuffer(int i3, String str) {
            native_sendGroupVideoJsonBuffer(this.nativeRef, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService
        public void setActionFromAVSDK(int i3, byte[] bArr) {
            native_setActionFromAVSDK(this.nativeRef, i3, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService
        public void startGroupVideoCmdRequestFromAVSDK(GroupVideoCmdReq groupVideoCmdReq, IGroupVideoCmdRequestRsp iGroupVideoCmdRequestRsp) {
            native_startGroupVideoCmdRequestFromAVSDK(this.nativeRef, groupVideoCmdReq, iGroupVideoCmdRequestRsp);
        }
    }

    void addKernelAVSDKListener(IKernelAVSDKListener iKernelAVSDKListener);

    void allowAlbumNotify();

    void removeKernelAVSDKListener(IKernelAVSDKListener iKernelAVSDKListener);

    void sendGroupVideoJsonBuffer(int i3, String str);

    void setActionFromAVSDK(int i3, byte[] bArr);

    void startGroupVideoCmdRequestFromAVSDK(GroupVideoCmdReq groupVideoCmdReq, IGroupVideoCmdRequestRsp iGroupVideoCmdRequestRsp);
}
