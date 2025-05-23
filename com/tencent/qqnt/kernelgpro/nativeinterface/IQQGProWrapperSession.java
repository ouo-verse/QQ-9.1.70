package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IQQGProWrapperSession {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IQQGProWrapperSession {
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

        public static native IQQGProWrapperSession getGProWrapperSession(String str);

        private native void nativeDestroy(long j3);

        private native IKernelDirectSessionService native_getDirectSessionService(long j3);

        private native IKernelFeedServiceNew native_getFeedChannelServiceNew(long j3);

        private native IKernelGProGuildMsgService native_getGProGuildMsgService(long j3);

        private native IKernelGuildFileTransferService native_getGuildFileTransferService(long j3);

        private native IKernelGuildService native_getGuildService(long j3);

        private native String native_getSessionId(long j3);

        private native void native_init(long j3, GProInitSessionConfig gProInitSessionConfig, IGProDependsAdapter iGProDependsAdapter, IKernelGProSessionListener iKernelGProSessionListener);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public IKernelDirectSessionService getDirectSessionService() {
            return native_getDirectSessionService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public IKernelFeedServiceNew getFeedChannelServiceNew() {
            return native_getFeedChannelServiceNew(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public IKernelGProGuildMsgService getGProGuildMsgService() {
            return native_getGProGuildMsgService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public IKernelGuildFileTransferService getGuildFileTransferService() {
            return native_getGuildFileTransferService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public IKernelGuildService getGuildService() {
            return native_getGuildService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public String getSessionId() {
            return native_getSessionId(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession
        public void init(GProInitSessionConfig gProInitSessionConfig, IGProDependsAdapter iGProDependsAdapter, IKernelGProSessionListener iKernelGProSessionListener) {
            native_init(this.nativeRef, gProInitSessionConfig, iGProDependsAdapter, iKernelGProSessionListener);
        }
    }

    IKernelDirectSessionService getDirectSessionService();

    IKernelFeedServiceNew getFeedChannelServiceNew();

    IKernelGProGuildMsgService getGProGuildMsgService();

    IKernelGuildFileTransferService getGuildFileTransferService();

    IKernelGuildService getGuildService();

    String getSessionId();

    void init(GProInitSessionConfig gProInitSessionConfig, IGProDependsAdapter iGProDependsAdapter, IKernelGProSessionListener iKernelGProSessionListener);
}
