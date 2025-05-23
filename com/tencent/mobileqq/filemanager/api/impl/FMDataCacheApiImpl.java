package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMDataCacheApiImpl implements IFMDataCacheApi {
    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void addFileViewerLocalFiles(ArrayList<FileInfo> arrayList) {
        com.tencent.mobileqq.filemanager.data.f.a(arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void addSelected(FileInfo fileInfo) {
        com.tencent.mobileqq.filemanager.data.f.c(fileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void addTmpSig(String str, byte[] bArr) {
        com.tencent.mobileqq.filemanager.data.f.g(str, bArr);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void clearFileViewerLocalFiles() {
        com.tencent.mobileqq.filemanager.data.f.i();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void clearSelected() {
        com.tencent.mobileqq.filemanager.data.f.k();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public ArrayList<FavFileInfo> getFavFiles() {
        return com.tencent.mobileqq.filemanager.data.f.l();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public ArrayList<FileInfo> getFileViewerLocalFiles() {
        return com.tencent.mobileqq.filemanager.data.f.m();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public Set<FileInfo> getLocalFiles() {
        return com.tencent.mobileqq.filemanager.data.f.n();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public ArrayList<OfflineFileInfo> getOfflineFiles() {
        return com.tencent.mobileqq.filemanager.data.f.p();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public ArrayList<FileManagerEntity> getRecentFiles() {
        return com.tencent.mobileqq.filemanager.data.f.q();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public long getSelectedCloudFileSize() {
        return com.tencent.mobileqq.filemanager.data.f.r();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public long getSelectedCount() {
        return com.tencent.mobileqq.filemanager.data.f.s();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public long getSelectedFileSize() {
        return com.tencent.mobileqq.filemanager.data.f.t();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public long getSelectedLocalFileSize() {
        return com.tencent.mobileqq.filemanager.data.f.u();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public ArrayList<WeiYunFileInfo> getWeiYunFiles() {
        return com.tencent.mobileqq.filemanager.data.f.v();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public boolean isDocsFile(FileInfo fileInfo) {
        return com.tencent.mobileqq.filemanager.data.f.z(fileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public boolean isSelected(FileManagerEntity fileManagerEntity) {
        return com.tencent.mobileqq.filemanager.data.f.D(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void removeSelected(FileManagerEntity fileManagerEntity) {
        com.tencent.mobileqq.filemanager.data.f.H(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void addSelected(FileManagerEntity fileManagerEntity) {
        com.tencent.mobileqq.filemanager.data.f.d(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public boolean isDocsFile(FileManagerEntity fileManagerEntity) {
        return com.tencent.mobileqq.filemanager.data.f.A(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public boolean isSelected(FileInfo fileInfo) {
        return com.tencent.mobileqq.filemanager.data.f.C(fileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
    public void removeSelected(FileInfo fileInfo) {
        com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
    }
}
