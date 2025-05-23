package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IFMDataCacheApi extends QRouteApi {
    void addFileViewerLocalFiles(ArrayList<FileInfo> arrayList);

    void addSelected(FileInfo fileInfo);

    void addSelected(FileManagerEntity fileManagerEntity);

    void addTmpSig(String str, byte[] bArr);

    void clearFileViewerLocalFiles();

    void clearSelected();

    ArrayList<FavFileInfo> getFavFiles();

    ArrayList<FileInfo> getFileViewerLocalFiles();

    Set<FileInfo> getLocalFiles();

    ArrayList<OfflineFileInfo> getOfflineFiles();

    ArrayList<FileManagerEntity> getRecentFiles();

    long getSelectedCloudFileSize();

    long getSelectedCount();

    long getSelectedFileSize();

    long getSelectedLocalFileSize();

    ArrayList<WeiYunFileInfo> getWeiYunFiles();

    boolean isDocsFile(FileInfo fileInfo);

    boolean isDocsFile(FileManagerEntity fileManagerEntity);

    boolean isSelected(FileInfo fileInfo);

    boolean isSelected(FileManagerEntity fileManagerEntity);

    void removeSelected(FileInfo fileInfo);

    void removeSelected(FileManagerEntity fileManagerEntity);
}
