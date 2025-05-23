package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelAddBuddyService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelAddBuddyService {
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

        private native void native_addBuddy(long j3, String str, AddBuddyReq addBuddyReq, byte[] bArr, IAddBuddyCallback iAddBuddyCallback);

        private native void native_getAddBuddyRequestTag(long j3, String str, AccountInfo accountInfo, byte[] bArr, IGetBuddyTagCallback iGetBuddyTagCallback);

        private native void native_getBuddySetting(long j3, String str, BuddySettingReq buddySettingReq, byte[] bArr, IBuddySettingCallback iBuddySettingCallback);

        private native void native_getSmartInfo(long j3, String str, SmartReq smartReq, byte[] bArr, IGetSmartInfoCallback iGetSmartInfoCallback);

        private native void native_queryUinSafetyFlag(long j3, String str, AccountInfo accountInfo, byte[] bArr, IQueryUinSafetyFlagCallback iQueryUinSafetyFlagCallback);

        private native void native_requestInfoByAccount(long j3, String str, AccountInfo accountInfo, byte[] bArr, IGetBuddyInfoCallback iGetBuddyInfoCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService
        public void addBuddy(String str, AddBuddyReq addBuddyReq, byte[] bArr, IAddBuddyCallback iAddBuddyCallback) {
            native_addBuddy(this.nativeRef, str, addBuddyReq, bArr, iAddBuddyCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService
        public void getAddBuddyRequestTag(String str, AccountInfo accountInfo, byte[] bArr, IGetBuddyTagCallback iGetBuddyTagCallback) {
            native_getAddBuddyRequestTag(this.nativeRef, str, accountInfo, bArr, iGetBuddyTagCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService
        public void getBuddySetting(String str, BuddySettingReq buddySettingReq, byte[] bArr, IBuddySettingCallback iBuddySettingCallback) {
            native_getBuddySetting(this.nativeRef, str, buddySettingReq, bArr, iBuddySettingCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService
        public void getSmartInfo(String str, SmartReq smartReq, byte[] bArr, IGetSmartInfoCallback iGetSmartInfoCallback) {
            native_getSmartInfo(this.nativeRef, str, smartReq, bArr, iGetSmartInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService
        public void queryUinSafetyFlag(String str, AccountInfo accountInfo, byte[] bArr, IQueryUinSafetyFlagCallback iQueryUinSafetyFlagCallback) {
            native_queryUinSafetyFlag(this.nativeRef, str, accountInfo, bArr, iQueryUinSafetyFlagCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService
        public void requestInfoByAccount(String str, AccountInfo accountInfo, byte[] bArr, IGetBuddyInfoCallback iGetBuddyInfoCallback) {
            native_requestInfoByAccount(this.nativeRef, str, accountInfo, bArr, iGetBuddyInfoCallback);
        }
    }

    void addBuddy(String str, AddBuddyReq addBuddyReq, byte[] bArr, IAddBuddyCallback iAddBuddyCallback);

    void getAddBuddyRequestTag(String str, AccountInfo accountInfo, byte[] bArr, IGetBuddyTagCallback iGetBuddyTagCallback);

    void getBuddySetting(String str, BuddySettingReq buddySettingReq, byte[] bArr, IBuddySettingCallback iBuddySettingCallback);

    void getSmartInfo(String str, SmartReq smartReq, byte[] bArr, IGetSmartInfoCallback iGetSmartInfoCallback);

    void queryUinSafetyFlag(String str, AccountInfo accountInfo, byte[] bArr, IQueryUinSafetyFlagCallback iQueryUinSafetyFlagCallback);

    void requestInfoByAccount(String str, AccountInfo accountInfo, byte[] bArr, IGetBuddyInfoCallback iGetBuddyInfoCallback);
}
