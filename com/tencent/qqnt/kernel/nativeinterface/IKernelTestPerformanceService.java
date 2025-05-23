package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelTestPerformanceService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelTestPerformanceService {
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

        private native void native_execSql(long j3, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_insertMsg(long j3, InsertMsgParam insertMsgParam, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelTestPerformanceService
        public void execSql(String str, String str2, IOperateCallback iOperateCallback) {
            native_execSql(this.nativeRef, str, str2, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelTestPerformanceService
        public void insertMsg(InsertMsgParam insertMsgParam, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback) {
            native_insertMsg(this.nativeRef, insertMsgParam, arrayList, iOperateCallback);
        }
    }

    void execSql(String str, String str2, IOperateCallback iOperateCallback);

    void insertMsg(InsertMsgParam insertMsgParam, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback);
}
