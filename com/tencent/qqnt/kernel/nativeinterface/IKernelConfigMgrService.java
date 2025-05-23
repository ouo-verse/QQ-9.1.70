package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelConfigMgrService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelConfigMgrService {
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

        private native void native_getConfigMgrInfo(long j3, int i3, IGProGetConfigMgrInfoCallback iGProGetConfigMgrInfoCallback);

        private native void native_getConfigMgrInfoTaskId(long j3, int i3, int i16, IGProGetConfigMgrInfoTaskIdCallback iGProGetConfigMgrInfoTaskIdCallback);

        private native void native_getVoiceChannelMaxPeopleCount(long j3, IGProGetVChannelMaxPeopleCountCallback iGProGetVChannelMaxPeopleCountCallback);

        private native void native_loadSideBarConfig(long j3, IGProLoadSideBarConfigCallback iGProLoadSideBarConfigCallback);

        private native void native_saveSideBarConfig(long j3, ArrayList<SideBarConfig> arrayList, IOperateCallback iOperateCallback);

        private native void native_updateConfigMgrInfoTaskId(long j3, int i3, int i16, IGProGetConfigMgrInfoTaskIdCallback iGProGetConfigMgrInfoTaskIdCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelConfigMgrService
        public void getConfigMgrInfo(int i3, IGProGetConfigMgrInfoCallback iGProGetConfigMgrInfoCallback) {
            native_getConfigMgrInfo(this.nativeRef, i3, iGProGetConfigMgrInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelConfigMgrService
        public void getConfigMgrInfoTaskId(int i3, int i16, IGProGetConfigMgrInfoTaskIdCallback iGProGetConfigMgrInfoTaskIdCallback) {
            native_getConfigMgrInfoTaskId(this.nativeRef, i3, i16, iGProGetConfigMgrInfoTaskIdCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelConfigMgrService
        public void getVoiceChannelMaxPeopleCount(IGProGetVChannelMaxPeopleCountCallback iGProGetVChannelMaxPeopleCountCallback) {
            native_getVoiceChannelMaxPeopleCount(this.nativeRef, iGProGetVChannelMaxPeopleCountCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelConfigMgrService
        public void loadSideBarConfig(IGProLoadSideBarConfigCallback iGProLoadSideBarConfigCallback) {
            native_loadSideBarConfig(this.nativeRef, iGProLoadSideBarConfigCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelConfigMgrService
        public void saveSideBarConfig(ArrayList<SideBarConfig> arrayList, IOperateCallback iOperateCallback) {
            native_saveSideBarConfig(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelConfigMgrService
        public void updateConfigMgrInfoTaskId(int i3, int i16, IGProGetConfigMgrInfoTaskIdCallback iGProGetConfigMgrInfoTaskIdCallback) {
            native_updateConfigMgrInfoTaskId(this.nativeRef, i3, i16, iGProGetConfigMgrInfoTaskIdCallback);
        }
    }

    void getConfigMgrInfo(int i3, IGProGetConfigMgrInfoCallback iGProGetConfigMgrInfoCallback);

    void getConfigMgrInfoTaskId(int i3, int i16, IGProGetConfigMgrInfoTaskIdCallback iGProGetConfigMgrInfoTaskIdCallback);

    void getVoiceChannelMaxPeopleCount(IGProGetVChannelMaxPeopleCountCallback iGProGetVChannelMaxPeopleCountCallback);

    void loadSideBarConfig(IGProLoadSideBarConfigCallback iGProLoadSideBarConfigCallback);

    void saveSideBarConfig(ArrayList<SideBarConfig> arrayList, IOperateCallback iOperateCallback);

    void updateConfigMgrInfoTaskId(int i3, int i16, IGProGetConfigMgrInfoTaskIdCallback iGProGetConfigMgrInfoTaskIdCallback);
}
