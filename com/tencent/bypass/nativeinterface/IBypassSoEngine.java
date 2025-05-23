package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IBypassSoEngine {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CppProxy implements IBypassSoEngine {
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

        @Nullable
        public static native IBypassSoEngine getInstance();

        private native void nativeDestroy(long j3);

        private native long native_perCompileRegex(long j3);

        private native Document native_processMarkdown(long j3, String str, boolean z16, int i3);

        private native void native_startEngine(long j3, IGlobalAdapter iGlobalAdapter);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.bypass.nativeinterface.IBypassSoEngine
        public long perCompileRegex() {
            return native_perCompileRegex(this.nativeRef);
        }

        @Override // com.tencent.bypass.nativeinterface.IBypassSoEngine
        public Document processMarkdown(String str, boolean z16, int i3) {
            return native_processMarkdown(this.nativeRef, str, z16, i3);
        }

        @Override // com.tencent.bypass.nativeinterface.IBypassSoEngine
        public void startEngine(IGlobalAdapter iGlobalAdapter) {
            native_startEngine(this.nativeRef, iGlobalAdapter);
        }
    }

    long perCompileRegex();

    @NonNull
    Document processMarkdown(@NonNull String str, boolean z16, int i3);

    void startEngine(@Nullable IGlobalAdapter iGlobalAdapter);
}
