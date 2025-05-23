package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelDirectSessionService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelDirectSessionService {
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

        private native void native_addKernelDirectSessionListener(long j3, IKernelDirectSessionListener iKernelDirectSessionListener);

        private native void native_deleteDirectMsgRecordsAndDirectSession(long j3, String str, String str2, IGuildOperateCallback iGuildOperateCallback);

        private native void native_fetchDirectSessionList(long j3, ArrayList<Long> arrayList, IFetchListCallback iFetchListCallback);

        private native void native_getDirectSessionList(long j3, IGuildOperateCallback iGuildOperateCallback);

        private native int native_getDirectSwitchStatus(long j3);

        private native void native_removeDirectSession(long j3, String str, IGuildOperateCallback iGuildOperateCallback);

        private native void native_removeKernelDirectSessionListener(long j3, IKernelDirectSessionListener iKernelDirectSessionListener);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public void addKernelDirectSessionListener(IKernelDirectSessionListener iKernelDirectSessionListener) {
            native_addKernelDirectSessionListener(this.nativeRef, iKernelDirectSessionListener);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public void deleteDirectMsgRecordsAndDirectSession(String str, String str2, IGuildOperateCallback iGuildOperateCallback) {
            native_deleteDirectMsgRecordsAndDirectSession(this.nativeRef, str, str2, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public void fetchDirectSessionList(ArrayList<Long> arrayList, IFetchListCallback iFetchListCallback) {
            native_fetchDirectSessionList(this.nativeRef, arrayList, iFetchListCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public void getDirectSessionList(IGuildOperateCallback iGuildOperateCallback) {
            native_getDirectSessionList(this.nativeRef, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public int getDirectSwitchStatus() {
            return native_getDirectSwitchStatus(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public void removeDirectSession(String str, IGuildOperateCallback iGuildOperateCallback) {
            native_removeDirectSession(this.nativeRef, str, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService
        public void removeKernelDirectSessionListener(IKernelDirectSessionListener iKernelDirectSessionListener) {
            native_removeKernelDirectSessionListener(this.nativeRef, iKernelDirectSessionListener);
        }
    }

    void addKernelDirectSessionListener(IKernelDirectSessionListener iKernelDirectSessionListener);

    void deleteDirectMsgRecordsAndDirectSession(String str, String str2, IGuildOperateCallback iGuildOperateCallback);

    void fetchDirectSessionList(ArrayList<Long> arrayList, IFetchListCallback iFetchListCallback);

    void getDirectSessionList(IGuildOperateCallback iGuildOperateCallback);

    int getDirectSwitchStatus();

    void removeDirectSession(String str, IGuildOperateCallback iGuildOperateCallback);

    void removeKernelDirectSessionListener(IKernelDirectSessionListener iKernelDirectSessionListener);
}
