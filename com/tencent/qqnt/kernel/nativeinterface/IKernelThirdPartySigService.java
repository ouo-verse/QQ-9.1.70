package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelThirdPartySigService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelThirdPartySigService {
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

        private native void native_addOnSigChangeListener(long j3, IThirdPartySigChangeListener iThirdPartySigChangeListener);

        private native void native_delThirdPartySigByUin(long j3, long j16);

        private native void native_getOpenIDByUin(long j3, long j16, int i3, String str, IOpenIDCallback iOpenIDCallback);

        private native void native_getPT4tokenByUin(long j3, long j16, int i3, ArrayList<String> arrayList, IPT4tokenCallback iPT4tokenCallback);

        private native void native_getThirdPartySigByUin(long j3, long j16, int i3, ThirdPartySigType thirdPartySigType, int i16, String str, String str2, IThirdPartySigCallback iThirdPartySigCallback);

        private native void native_initConfig(long j3, InitThirdPartySigConfig initThirdPartySigConfig);

        private native void native_removeSigChangeListener(long j3, IThirdPartySigChangeListener iThirdPartySigChangeListener);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void addOnSigChangeListener(IThirdPartySigChangeListener iThirdPartySigChangeListener) {
            native_addOnSigChangeListener(this.nativeRef, iThirdPartySigChangeListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void delThirdPartySigByUin(long j3) {
            native_delThirdPartySigByUin(this.nativeRef, j3);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void getOpenIDByUin(long j3, int i3, String str, IOpenIDCallback iOpenIDCallback) {
            native_getOpenIDByUin(this.nativeRef, j3, i3, str, iOpenIDCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void getPT4tokenByUin(long j3, int i3, ArrayList<String> arrayList, IPT4tokenCallback iPT4tokenCallback) {
            native_getPT4tokenByUin(this.nativeRef, j3, i3, arrayList, iPT4tokenCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void getThirdPartySigByUin(long j3, int i3, ThirdPartySigType thirdPartySigType, int i16, String str, String str2, IThirdPartySigCallback iThirdPartySigCallback) {
            native_getThirdPartySigByUin(this.nativeRef, j3, i3, thirdPartySigType, i16, str, str2, iThirdPartySigCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void initConfig(InitThirdPartySigConfig initThirdPartySigConfig) {
            native_initConfig(this.nativeRef, initThirdPartySigConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService
        public void removeSigChangeListener(IThirdPartySigChangeListener iThirdPartySigChangeListener) {
            native_removeSigChangeListener(this.nativeRef, iThirdPartySigChangeListener);
        }
    }

    void addOnSigChangeListener(IThirdPartySigChangeListener iThirdPartySigChangeListener);

    void delThirdPartySigByUin(long j3);

    void getOpenIDByUin(long j3, int i3, String str, IOpenIDCallback iOpenIDCallback);

    void getPT4tokenByUin(long j3, int i3, ArrayList<String> arrayList, IPT4tokenCallback iPT4tokenCallback);

    void getThirdPartySigByUin(long j3, int i3, ThirdPartySigType thirdPartySigType, int i16, String str, String str2, IThirdPartySigCallback iThirdPartySigCallback);

    void initConfig(InitThirdPartySigConfig initThirdPartySigConfig);

    void removeSigChangeListener(IThirdPartySigChangeListener iThirdPartySigChangeListener);
}
