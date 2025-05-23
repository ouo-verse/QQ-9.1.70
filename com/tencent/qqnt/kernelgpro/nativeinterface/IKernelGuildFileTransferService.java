package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGuildFileTransferService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelGuildFileTransferService {
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

        private native long native_addFileUploadListener(long j3, IKernelGuildFileUploadListener iKernelGuildFileUploadListener);

        private native void native_cancelFileGroupUpload(long j3, String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

        private native void native_createFileGroupUpload(long j3, GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam, IGProCreateUploadFileGroupCallback iGProCreateUploadFileGroupCallback);

        private native GProUploadFileGroupInfo native_decoderUploadFileGroupInfo(long j3, byte[] bArr);

        private native GProUploadFileInfo native_decoderUploadFileInfo(long j3, byte[] bArr);

        private native byte[] native_encodeUploadFileGroupInfo(long j3, GProUploadFileGroupInfo gProUploadFileGroupInfo);

        private native byte[] native_encodeUploadFileInfo(long j3, GProUploadFileInfo gProUploadFileInfo);

        private native void native_getFileGroupInfo(long j3, String str, IGProGetUploadFileGroupInfoCallback iGProGetUploadFileGroupInfoCallback);

        private native void native_pauseFileGroupUpload(long j3, String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

        private native void native_removeFileGroupUpload(long j3, String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

        private native void native_removeFileUploadListener(long j3, long j16);

        private native void native_resumeFileGroupUpload(long j3, String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public long addFileUploadListener(IKernelGuildFileUploadListener iKernelGuildFileUploadListener) {
            return native_addFileUploadListener(this.nativeRef, iKernelGuildFileUploadListener);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void cancelFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback) {
            native_cancelFileGroupUpload(this.nativeRef, str, iGProTransferFileOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void createFileGroupUpload(GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam, IGProCreateUploadFileGroupCallback iGProCreateUploadFileGroupCallback) {
            native_createFileGroupUpload(this.nativeRef, gProCreateUploadFileGroupParam, iGProCreateUploadFileGroupCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public GProUploadFileGroupInfo decoderUploadFileGroupInfo(byte[] bArr) {
            return native_decoderUploadFileGroupInfo(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public GProUploadFileInfo decoderUploadFileInfo(byte[] bArr) {
            return native_decoderUploadFileInfo(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public byte[] encodeUploadFileGroupInfo(GProUploadFileGroupInfo gProUploadFileGroupInfo) {
            return native_encodeUploadFileGroupInfo(this.nativeRef, gProUploadFileGroupInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public byte[] encodeUploadFileInfo(GProUploadFileInfo gProUploadFileInfo) {
            return native_encodeUploadFileInfo(this.nativeRef, gProUploadFileInfo);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void getFileGroupInfo(String str, IGProGetUploadFileGroupInfoCallback iGProGetUploadFileGroupInfoCallback) {
            native_getFileGroupInfo(this.nativeRef, str, iGProGetUploadFileGroupInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void pauseFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback) {
            native_pauseFileGroupUpload(this.nativeRef, str, iGProTransferFileOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void removeFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback) {
            native_removeFileGroupUpload(this.nativeRef, str, iGProTransferFileOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void removeFileUploadListener(long j3) {
            native_removeFileUploadListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService
        public void resumeFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback) {
            native_resumeFileGroupUpload(this.nativeRef, str, iGProTransferFileOperateCallback);
        }
    }

    long addFileUploadListener(IKernelGuildFileUploadListener iKernelGuildFileUploadListener);

    void cancelFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

    void createFileGroupUpload(GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam, IGProCreateUploadFileGroupCallback iGProCreateUploadFileGroupCallback);

    GProUploadFileGroupInfo decoderUploadFileGroupInfo(byte[] bArr);

    GProUploadFileInfo decoderUploadFileInfo(byte[] bArr);

    byte[] encodeUploadFileGroupInfo(GProUploadFileGroupInfo gProUploadFileGroupInfo);

    byte[] encodeUploadFileInfo(GProUploadFileInfo gProUploadFileInfo);

    void getFileGroupInfo(String str, IGProGetUploadFileGroupInfoCallback iGProGetUploadFileGroupInfoCallback);

    void pauseFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

    void removeFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);

    void removeFileUploadListener(long j3);

    void resumeFileGroupUpload(String str, IGProTransferFileOperateCallback iGProTransferFileOperateCallback);
}
