package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileDataCenterImpl implements IQQFileDataCenter {
    QQAppInterface mApp;

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public void insertTBSToolFileEntity(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerDataCenter().t(fileManagerEntity);
        this.mApp.getFileManagerNotifyCenter().b(true, 24, new Object[]{fileManagerEntity, Boolean.TRUE});
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public void insertToFMList(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerDataCenter().t(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public void insertToMemMap(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerDataCenter().v(fileManagerEntity);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public FileManagerEntity queryByFileIdForMemory(String str) {
        return this.mApp.getFileManagerDataCenter().H(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public FileManagerEntity queryBySessionId(long j3) {
        return this.mApp.getFileManagerDataCenter().D(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public FileManagerEntity queryFileEntity(long j3, String str, int i3, long j16) {
        return this.mApp.getFileManagerDataCenter().C(j3, str, i3, j16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public FileManagerEntity queryFileEntityByUuid(String str) {
        return this.mApp.getFileManagerDataCenter().F(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public List<FileManagerEntity> queryMaxRecentReocrds() {
        return this.mApp.getFileManagerProxy().S();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public List<FileManagerEntity> queryMaxRecentReocrdsWithUin(String str) {
        return this.mApp.getFileManagerProxy().T(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public void setAioDelete(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerDataCenter().X(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public void updateFileEntity(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerDataCenter().f0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
    public void updateTBSToolFileEntity(FileManagerEntity fileManagerEntity) {
        this.mApp.getFileManagerDataCenter().f0(fileManagerEntity);
        this.mApp.getFileManagerProxy().f0(fileManagerEntity);
        this.mApp.getFileManagerNotifyCenter().b(true, 24, new Object[]{fileManagerEntity, Boolean.FALSE});
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
