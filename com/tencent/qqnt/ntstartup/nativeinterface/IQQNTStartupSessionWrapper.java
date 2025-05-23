package com.tencent.qqnt.ntstartup.nativeinterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IQQNTStartupSessionWrapper {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class CppProxy implements IQQNTStartupSessionWrapper {
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

        public static native IQQNTStartupSessionWrapper create();

        public static native IQQNTStartupSessionWrapper createWithModuleList(HashSet<String> hashSet);

        private native void nativeDestroy(long j3);

        private native HashMap<String, String> native_getSessionIdList(long j3);

        private native int native_start(long j3);

        private native int native_stop(long j3);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.ntstartup.nativeinterface.IQQNTStartupSessionWrapper
        public HashMap<String, String> getSessionIdList() {
            return native_getSessionIdList(this.nativeRef);
        }

        @Override // com.tencent.qqnt.ntstartup.nativeinterface.IQQNTStartupSessionWrapper
        public int start() {
            return native_start(this.nativeRef);
        }

        @Override // com.tencent.qqnt.ntstartup.nativeinterface.IQQNTStartupSessionWrapper
        public int stop() {
            return native_stop(this.nativeRef);
        }
    }

    HashMap<String, String> getSessionIdList();

    int start();

    int stop();
}
