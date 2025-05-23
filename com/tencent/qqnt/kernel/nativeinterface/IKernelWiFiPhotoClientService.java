package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelWiFiPhotoClientService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelWiFiPhotoClientService {
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

        private native void native_addKernelWiFiPhotoClientListener(long j3, IKernelWiFiPhotoClientListener iKernelWiFiPhotoClientListener);

        private native void native_cancelAll(long j3);

        private native void native_cancelGetPhoto(long j3, String str, String str2);

        private native void native_cancelGetPhotoThumbBatch(long j3, ArrayList<String> arrayList);

        private native void native_cancelRequest(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_connectToHostForTest(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_deletePhotoBatch(long j3, ArrayList<String> arrayList, IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback);

        private native void native_disconnect(long j3, int i3);

        private native void native_getAlbumFileSavePath(long j3, String str, IKernelWiFiPhotoGetAlbumFileSavePathCallback iKernelWiFiPhotoGetAlbumFileSavePathCallback);

        private native void native_getAlbumList(long j3, IKernelWiFiPhotoGetAlbumListCallback iKernelWiFiPhotoGetAlbumListCallback);

        private native void native_getAllPhotoSimpleInfo(long j3, String str, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);

        private native void native_getPeerNetworkStatus(long j3, IKernelWiFiPhotoGetPeerNetworkStatusCallback iKernelWiFiPhotoGetPeerNetworkStatusCallback);

        private native void native_getPhotoAndSaveAs(long j3, String str, String str2, String str3, IOperateCallback iOperateCallback);

        private native void native_getPhotoBatch(long j3, String str, ArrayList<String> arrayList);

        private native void native_getPhotoInfoBatch(long j3, String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetPhotoInfoBatchForClientCallback iKernelWiFiPhotoGetPhotoInfoBatchForClientCallback);

        private native void native_getPhotoSimpleInfoForFirstView(long j3, String str, int i3, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);

        private native void native_getPhotoThumbBatchWithConfig(long j3, ArrayList<String> arrayList, ThumbConfig thumbConfig);

        private native void native_getWiFiPhotoDownFileInfos(long j3, String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetDownFileInfosCallback iKernelWiFiPhotoGetDownFileInfosCallback);

        private native void native_removeKernelWiFiPhotoClientListener(long j3, IKernelWiFiPhotoClientListener iKernelWiFiPhotoClientListener);

        private native void native_requestAlbumFullAccess(long j3, IOperateCallback iOperateCallback);

        private native void native_requestVisitAlbum(long j3, IOperateCallback iOperateCallback);

        private native void native_wifiPhotoPreCheck(long j3, IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void addKernelWiFiPhotoClientListener(IKernelWiFiPhotoClientListener iKernelWiFiPhotoClientListener) {
            native_addKernelWiFiPhotoClientListener(this.nativeRef, iKernelWiFiPhotoClientListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void cancelAll() {
            native_cancelAll(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void cancelGetPhoto(String str, String str2) {
            native_cancelGetPhoto(this.nativeRef, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void cancelGetPhotoThumbBatch(ArrayList<String> arrayList) {
            native_cancelGetPhotoThumbBatch(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void cancelRequest(int i3, IOperateCallback iOperateCallback) {
            native_cancelRequest(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void connectToHostForTest(String str, IOperateCallback iOperateCallback) {
            native_connectToHostForTest(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void deletePhotoBatch(ArrayList<String> arrayList, IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback) {
            native_deletePhotoBatch(this.nativeRef, arrayList, iKernelWiFiPhotoDeletePhotoBatchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void disconnect(int i3) {
            native_disconnect(this.nativeRef, i3);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getAlbumFileSavePath(String str, IKernelWiFiPhotoGetAlbumFileSavePathCallback iKernelWiFiPhotoGetAlbumFileSavePathCallback) {
            native_getAlbumFileSavePath(this.nativeRef, str, iKernelWiFiPhotoGetAlbumFileSavePathCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getAlbumList(IKernelWiFiPhotoGetAlbumListCallback iKernelWiFiPhotoGetAlbumListCallback) {
            native_getAlbumList(this.nativeRef, iKernelWiFiPhotoGetAlbumListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getAllPhotoSimpleInfo(String str, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback) {
            native_getAllPhotoSimpleInfo(this.nativeRef, str, iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getPeerNetworkStatus(IKernelWiFiPhotoGetPeerNetworkStatusCallback iKernelWiFiPhotoGetPeerNetworkStatusCallback) {
            native_getPeerNetworkStatus(this.nativeRef, iKernelWiFiPhotoGetPeerNetworkStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getPhotoAndSaveAs(String str, String str2, String str3, IOperateCallback iOperateCallback) {
            native_getPhotoAndSaveAs(this.nativeRef, str, str2, str3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getPhotoBatch(String str, ArrayList<String> arrayList) {
            native_getPhotoBatch(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getPhotoInfoBatch(String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetPhotoInfoBatchForClientCallback iKernelWiFiPhotoGetPhotoInfoBatchForClientCallback) {
            native_getPhotoInfoBatch(this.nativeRef, str, arrayList, iKernelWiFiPhotoGetPhotoInfoBatchForClientCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getPhotoSimpleInfoForFirstView(String str, int i3, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback) {
            native_getPhotoSimpleInfoForFirstView(this.nativeRef, str, i3, iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getPhotoThumbBatchWithConfig(ArrayList<String> arrayList, ThumbConfig thumbConfig) {
            native_getPhotoThumbBatchWithConfig(this.nativeRef, arrayList, thumbConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void getWiFiPhotoDownFileInfos(String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetDownFileInfosCallback iKernelWiFiPhotoGetDownFileInfosCallback) {
            native_getWiFiPhotoDownFileInfos(this.nativeRef, str, arrayList, iKernelWiFiPhotoGetDownFileInfosCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void removeKernelWiFiPhotoClientListener(IKernelWiFiPhotoClientListener iKernelWiFiPhotoClientListener) {
            native_removeKernelWiFiPhotoClientListener(this.nativeRef, iKernelWiFiPhotoClientListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void requestAlbumFullAccess(IOperateCallback iOperateCallback) {
            native_requestAlbumFullAccess(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void requestVisitAlbum(IOperateCallback iOperateCallback) {
            native_requestVisitAlbum(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoClientService
        public void wifiPhotoPreCheck(IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback) {
            native_wifiPhotoPreCheck(this.nativeRef, iKernelWiFiPhotoPreCheckCallback);
        }
    }

    void addKernelWiFiPhotoClientListener(IKernelWiFiPhotoClientListener iKernelWiFiPhotoClientListener);

    void cancelAll();

    void cancelGetPhoto(String str, String str2);

    void cancelGetPhotoThumbBatch(ArrayList<String> arrayList);

    void cancelRequest(int i3, IOperateCallback iOperateCallback);

    void connectToHostForTest(String str, IOperateCallback iOperateCallback);

    void deletePhotoBatch(ArrayList<String> arrayList, IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback);

    void disconnect(int i3);

    void getAlbumFileSavePath(String str, IKernelWiFiPhotoGetAlbumFileSavePathCallback iKernelWiFiPhotoGetAlbumFileSavePathCallback);

    void getAlbumList(IKernelWiFiPhotoGetAlbumListCallback iKernelWiFiPhotoGetAlbumListCallback);

    void getAllPhotoSimpleInfo(String str, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);

    void getPeerNetworkStatus(IKernelWiFiPhotoGetPeerNetworkStatusCallback iKernelWiFiPhotoGetPeerNetworkStatusCallback);

    void getPhotoAndSaveAs(String str, String str2, String str3, IOperateCallback iOperateCallback);

    void getPhotoBatch(String str, ArrayList<String> arrayList);

    void getPhotoInfoBatch(String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetPhotoInfoBatchForClientCallback iKernelWiFiPhotoGetPhotoInfoBatchForClientCallback);

    void getPhotoSimpleInfoForFirstView(String str, int i3, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);

    void getPhotoThumbBatchWithConfig(ArrayList<String> arrayList, ThumbConfig thumbConfig);

    void getWiFiPhotoDownFileInfos(String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetDownFileInfosCallback iKernelWiFiPhotoGetDownFileInfosCallback);

    void removeKernelWiFiPhotoClientListener(IKernelWiFiPhotoClientListener iKernelWiFiPhotoClientListener);

    void requestAlbumFullAccess(IOperateCallback iOperateCallback);

    void requestVisitAlbum(IOperateCallback iOperateCallback);

    void wifiPhotoPreCheck(IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback);
}
