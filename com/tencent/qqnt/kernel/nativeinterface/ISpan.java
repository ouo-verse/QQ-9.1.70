package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface ISpan {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements ISpan {
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

        private native void native_addLog(long j3, String str);

        private native ISpan native_addSubSpan(long j3, String str);

        private native void native_end(long j3);

        private native String native_getTraceID(long j3);

        private native void native_setFailedInfo(long j3, long j16, String str);

        private native void native_setMethodName(long j3, String str);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISpan
        public void addLog(String str) {
            native_addLog(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISpan
        public ISpan addSubSpan(String str) {
            return native_addSubSpan(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISpan
        public void end() {
            native_end(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISpan
        public String getTraceID() {
            return native_getTraceID(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISpan
        public void setFailedInfo(long j3, String str) {
            native_setFailedInfo(this.nativeRef, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISpan
        public void setMethodName(String str) {
            native_setMethodName(this.nativeRef, str);
        }
    }

    void addLog(String str);

    ISpan addSubSpan(String str);

    void end();

    String getTraceID();

    void setFailedInfo(long j3, String str);

    void setMethodName(String str);
}
