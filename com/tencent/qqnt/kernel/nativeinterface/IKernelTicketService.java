package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelTicketService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelTicketService {
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

        private native long native_addKernelTicketListener(long j3, IKernelTicketListener iKernelTicketListener);

        private native void native_forceFetchClientKey(long j3, String str, IClientKeyCallback iClientKeyCallback);

        private native void native_removeKernelTicketListener(long j3, long j16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelTicketService
        public long addKernelTicketListener(IKernelTicketListener iKernelTicketListener) {
            return native_addKernelTicketListener(this.nativeRef, iKernelTicketListener);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelTicketService
        public void forceFetchClientKey(String str, IClientKeyCallback iClientKeyCallback) {
            native_forceFetchClientKey(this.nativeRef, str, iClientKeyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelTicketService
        public void removeKernelTicketListener(long j3) {
            native_removeKernelTicketListener(this.nativeRef, j3);
        }
    }

    long addKernelTicketListener(IKernelTicketListener iKernelTicketListener);

    void forceFetchClientKey(String str, IClientKeyCallback iClientKeyCallback);

    void removeKernelTicketListener(long j3);
}
