package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public interface IKernelWiFiPhotoAlbumAccessDelegate {
    void cancelAllRequestAndClearCache();

    void deletePhotoBatch(ArrayList<String> arrayList, IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback);

    void getAlbumList(IKernelWiFiPhotoGetAlbumListCallback iKernelWiFiPhotoGetAlbumListCallback);

    void getAllPhotoSimpleInfo(String str, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);

    void getPhoto(String str, String str2, IKernelWiFiPhotoGetPhotoCallback iKernelWiFiPhotoGetPhotoCallback);

    void getPhotoInfoBatch(String str, ArrayList<String> arrayList, IKernelWiFiPhotoGetPhotoInfoBatchCallback iKernelWiFiPhotoGetPhotoInfoBatchCallback);

    void getPhotoSimpleInfoForFirstView(String str, int i3, IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback iKernelWiFiPhotoGetAllPhotoSimpleInfoCallback);

    void getPhotoThumbWithConfig(String str, ThumbConfig thumbConfig, IKernelWiFiPhotoGetPhotoCallback iKernelWiFiPhotoGetPhotoCallback);
}
