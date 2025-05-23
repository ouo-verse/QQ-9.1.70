package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelDataReportService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelDataReportService {
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

        private native void native_beaconDataReport(long j3, String str, String str2, boolean z16, HashMap<String, String> hashMap, boolean z17);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelDataReportService
        public void beaconDataReport(String str, String str2, boolean z16, HashMap<String, String> hashMap, boolean z17) {
            native_beaconDataReport(this.nativeRef, str, str2, z16, hashMap, z17);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }
    }

    void beaconDataReport(String str, String str2, boolean z16, HashMap<String, String> hashMap, boolean z17);
}
