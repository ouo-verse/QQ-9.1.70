package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelSettingService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelSettingService {
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

        private native long native_addKernelSettingListener(long j3, IKernelSettingListener iKernelSettingListener);

        private native void native_clearCache(long j3, ArrayList<CacheType> arrayList, IKernelCleanCacheCallback iKernelCleanCacheCallback);

        private native void native_destroyAccount(long j3, IOperateCallback iOperateCallback);

        private native void native_getAutoLoginSwitch(long j3, IKernelGetSwitchCallback iKernelGetSwitchCallback);

        private native void native_getNeedConfirmSwitch(long j3, IKernelNeedConfirmSwitchCallback iKernelNeedConfirmSwitchCallback);

        private native void native_getPrivacySetting(long j3, IOperateCallback iOperateCallback);

        private native boolean native_getSelfStartSwitch(long j3);

        private native void native_getSettingForBuffer(long j3, ArrayList<SettingKeyForBuffer> arrayList, IOperateCallback iOperateCallback);

        private native void native_getSettingForNum(long j3, ArrayList<SettingKeyForNum> arrayList, IOperateCallback iOperateCallback);

        private native void native_getSettingForStr(long j3, ArrayList<SettingKeyForStr> arrayList, IOperateCallback iOperateCallback);

        private native void native_modifyAccount(long j3, VerifyInfo verifyInfo, IOperateCallback iOperateCallback);

        private native void native_removeKernelSettingListener(long j3, long j16);

        private native void native_scanCache(long j3, IKernelScanCacheCallback iKernelScanCacheCallback);

        private native void native_setAutoLoginSwitch(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setNeedConfirmSwitch(long j3, NeedConfirmState needConfirmState, IOperateCallback iOperateCallback);

        private native void native_setPrivacySetting(long j3, PrivacySetting privacySetting, IOperateCallback iOperateCallback);

        private native boolean native_setSelfStartSwitch(long j3, boolean z16);

        private native void native_setSettingForBuffer(long j3, HashMap<SettingKeyForBuffer, byte[]> hashMap, IOperateCallback iOperateCallback);

        private native void native_setSettingForNum(long j3, HashMap<SettingKeyForNum, Integer> hashMap, IOperateCallback iOperateCallback);

        private native void native_setSettingForStr(long j3, HashMap<SettingKeyForStr, String> hashMap, IOperateCallback iOperateCallback);

        private native void native_verifyNewAccount(long j3, NewAccount newAccount, IOperateCallback iOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public long addKernelSettingListener(IKernelSettingListener iKernelSettingListener) {
            return native_addKernelSettingListener(this.nativeRef, iKernelSettingListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void clearCache(ArrayList<CacheType> arrayList, IKernelCleanCacheCallback iKernelCleanCacheCallback) {
            native_clearCache(this.nativeRef, arrayList, iKernelCleanCacheCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void destroyAccount(IOperateCallback iOperateCallback) {
            native_destroyAccount(this.nativeRef, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void getAutoLoginSwitch(IKernelGetSwitchCallback iKernelGetSwitchCallback) {
            native_getAutoLoginSwitch(this.nativeRef, iKernelGetSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void getNeedConfirmSwitch(IKernelNeedConfirmSwitchCallback iKernelNeedConfirmSwitchCallback) {
            native_getNeedConfirmSwitch(this.nativeRef, iKernelNeedConfirmSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void getPrivacySetting(IOperateCallback iOperateCallback) {
            native_getPrivacySetting(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public boolean getSelfStartSwitch() {
            return native_getSelfStartSwitch(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void getSettingForBuffer(ArrayList<SettingKeyForBuffer> arrayList, IOperateCallback iOperateCallback) {
            native_getSettingForBuffer(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void getSettingForNum(ArrayList<SettingKeyForNum> arrayList, IOperateCallback iOperateCallback) {
            native_getSettingForNum(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void getSettingForStr(ArrayList<SettingKeyForStr> arrayList, IOperateCallback iOperateCallback) {
            native_getSettingForStr(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void modifyAccount(VerifyInfo verifyInfo, IOperateCallback iOperateCallback) {
            native_modifyAccount(this.nativeRef, verifyInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void removeKernelSettingListener(long j3) {
            native_removeKernelSettingListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void scanCache(IKernelScanCacheCallback iKernelScanCacheCallback) {
            native_scanCache(this.nativeRef, iKernelScanCacheCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void setAutoLoginSwitch(boolean z16, IOperateCallback iOperateCallback) {
            native_setAutoLoginSwitch(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void setNeedConfirmSwitch(NeedConfirmState needConfirmState, IOperateCallback iOperateCallback) {
            native_setNeedConfirmSwitch(this.nativeRef, needConfirmState, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void setPrivacySetting(PrivacySetting privacySetting, IOperateCallback iOperateCallback) {
            native_setPrivacySetting(this.nativeRef, privacySetting, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public boolean setSelfStartSwitch(boolean z16) {
            return native_setSelfStartSwitch(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void setSettingForBuffer(HashMap<SettingKeyForBuffer, byte[]> hashMap, IOperateCallback iOperateCallback) {
            native_setSettingForBuffer(this.nativeRef, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void setSettingForNum(HashMap<SettingKeyForNum, Integer> hashMap, IOperateCallback iOperateCallback) {
            native_setSettingForNum(this.nativeRef, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void setSettingForStr(HashMap<SettingKeyForStr, String> hashMap, IOperateCallback iOperateCallback) {
            native_setSettingForStr(this.nativeRef, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
        public void verifyNewAccount(NewAccount newAccount, IOperateCallback iOperateCallback) {
            native_verifyNewAccount(this.nativeRef, newAccount, iOperateCallback);
        }
    }

    long addKernelSettingListener(IKernelSettingListener iKernelSettingListener);

    void clearCache(ArrayList<CacheType> arrayList, IKernelCleanCacheCallback iKernelCleanCacheCallback);

    void destroyAccount(IOperateCallback iOperateCallback);

    void getAutoLoginSwitch(IKernelGetSwitchCallback iKernelGetSwitchCallback);

    void getNeedConfirmSwitch(IKernelNeedConfirmSwitchCallback iKernelNeedConfirmSwitchCallback);

    void getPrivacySetting(IOperateCallback iOperateCallback);

    boolean getSelfStartSwitch();

    void getSettingForBuffer(ArrayList<SettingKeyForBuffer> arrayList, IOperateCallback iOperateCallback);

    void getSettingForNum(ArrayList<SettingKeyForNum> arrayList, IOperateCallback iOperateCallback);

    void getSettingForStr(ArrayList<SettingKeyForStr> arrayList, IOperateCallback iOperateCallback);

    void modifyAccount(VerifyInfo verifyInfo, IOperateCallback iOperateCallback);

    void removeKernelSettingListener(long j3);

    void scanCache(IKernelScanCacheCallback iKernelScanCacheCallback);

    void setAutoLoginSwitch(boolean z16, IOperateCallback iOperateCallback);

    void setNeedConfirmSwitch(NeedConfirmState needConfirmState, IOperateCallback iOperateCallback);

    void setPrivacySetting(PrivacySetting privacySetting, IOperateCallback iOperateCallback);

    boolean setSelfStartSwitch(boolean z16);

    void setSettingForBuffer(HashMap<SettingKeyForBuffer, byte[]> hashMap, IOperateCallback iOperateCallback);

    void setSettingForNum(HashMap<SettingKeyForNum, Integer> hashMap, IOperateCallback iOperateCallback);

    void setSettingForStr(HashMap<SettingKeyForStr, String> hashMap, IOperateCallback iOperateCallback);

    void verifyNewAccount(NewAccount newAccount, IOperateCallback iOperateCallback);
}
