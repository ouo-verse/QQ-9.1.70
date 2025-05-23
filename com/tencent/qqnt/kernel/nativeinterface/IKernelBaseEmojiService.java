package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelBaseEmojiService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelBaseEmojiService {
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

        private native long native_addKernelBaseEmojiListener(long j3, IKernelBaseEmojiListener iKernelBaseEmojiListener);

        private native void native_delAllBaseEmojiResource(long j3, IOperateCallback iOperateCallback);

        private native void native_downloadBaseEmojiById(long j3, DownloadBaseEmojiByIdReq downloadBaseEmojiByIdReq, IDownloadBaseEmojiByIdCallback iDownloadBaseEmojiByIdCallback);

        private native void native_downloadBaseEmojiByIdWithUrl(long j3, DownloadBaseEmojiByUrlReq downloadBaseEmojiByUrlReq, IDownloadBaseEmojiByIdWithUrlCallback iDownloadBaseEmojiByIdWithUrlCallback);

        private native void native_fetchFullSysEmojis(long j3, PullSysEmojisReq pullSysEmojisReq, IFetchFullSysEmojisCallback iFetchFullSysEmojisCallback);

        private native HashMap<String, BaseEmojiPathInfo> native_getBaseEmojiPathByIds(long j3, ArrayList<GetBaseEmojiPathReq> arrayList);

        private native void native_isBaseEmojiPathExist(long j3, ArrayList<String> arrayList, IBaseEmojiPathExistCallback iBaseEmojiPathExistCallback);

        private native void native_removeKernelBaseEmojiListener(long j3, long j16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public long addKernelBaseEmojiListener(IKernelBaseEmojiListener iKernelBaseEmojiListener) {
            return native_addKernelBaseEmojiListener(this.nativeRef, iKernelBaseEmojiListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public void delAllBaseEmojiResource(IOperateCallback iOperateCallback) {
            native_delAllBaseEmojiResource(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public void downloadBaseEmojiById(DownloadBaseEmojiByIdReq downloadBaseEmojiByIdReq, IDownloadBaseEmojiByIdCallback iDownloadBaseEmojiByIdCallback) {
            native_downloadBaseEmojiById(this.nativeRef, downloadBaseEmojiByIdReq, iDownloadBaseEmojiByIdCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public void downloadBaseEmojiByIdWithUrl(DownloadBaseEmojiByUrlReq downloadBaseEmojiByUrlReq, IDownloadBaseEmojiByIdWithUrlCallback iDownloadBaseEmojiByIdWithUrlCallback) {
            native_downloadBaseEmojiByIdWithUrl(this.nativeRef, downloadBaseEmojiByUrlReq, iDownloadBaseEmojiByIdWithUrlCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public void fetchFullSysEmojis(PullSysEmojisReq pullSysEmojisReq, IFetchFullSysEmojisCallback iFetchFullSysEmojisCallback) {
            native_fetchFullSysEmojis(this.nativeRef, pullSysEmojisReq, iFetchFullSysEmojisCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public HashMap<String, BaseEmojiPathInfo> getBaseEmojiPathByIds(ArrayList<GetBaseEmojiPathReq> arrayList) {
            return native_getBaseEmojiPathByIds(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public void isBaseEmojiPathExist(ArrayList<String> arrayList, IBaseEmojiPathExistCallback iBaseEmojiPathExistCallback) {
            native_isBaseEmojiPathExist(this.nativeRef, arrayList, iBaseEmojiPathExistCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService
        public void removeKernelBaseEmojiListener(long j3) {
            native_removeKernelBaseEmojiListener(this.nativeRef, j3);
        }
    }

    long addKernelBaseEmojiListener(IKernelBaseEmojiListener iKernelBaseEmojiListener);

    void delAllBaseEmojiResource(IOperateCallback iOperateCallback);

    void downloadBaseEmojiById(DownloadBaseEmojiByIdReq downloadBaseEmojiByIdReq, IDownloadBaseEmojiByIdCallback iDownloadBaseEmojiByIdCallback);

    void downloadBaseEmojiByIdWithUrl(DownloadBaseEmojiByUrlReq downloadBaseEmojiByUrlReq, IDownloadBaseEmojiByIdWithUrlCallback iDownloadBaseEmojiByIdWithUrlCallback);

    void fetchFullSysEmojis(PullSysEmojisReq pullSysEmojisReq, IFetchFullSysEmojisCallback iFetchFullSysEmojisCallback);

    HashMap<String, BaseEmojiPathInfo> getBaseEmojiPathByIds(ArrayList<GetBaseEmojiPathReq> arrayList);

    void isBaseEmojiPathExist(ArrayList<String> arrayList, IBaseEmojiPathExistCallback iBaseEmojiPathExistCallback);

    void removeKernelBaseEmojiListener(long j3);
}
