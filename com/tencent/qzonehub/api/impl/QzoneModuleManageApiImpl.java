package com.tencent.qzonehub.api.impl;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneModuleManageApiImpl implements IQzoneModuleManageApi {
    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void abortDownloadModule(String str) {
        QzoneModuleManager.getInstance().abortDownloadModule(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void cancelDownloadModule(String str) {
        QzoneModuleManager.getInstance().cancelDownloadModule(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean checkIfNeedUpdate(String str) {
        return QzoneModuleManager.getInstance().checkIfNeedUpdate(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean downloadModule(String str, ModuleDownloadListener moduleDownloadListener) {
        return QzoneModuleManager.getInstance().downloadModule(str, moduleDownloadListener);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public String getModuleFilePath(String str) {
        return QzoneModuleManager.getInstance().getModuleFilePath(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public QzoneModuleRecord getModuleRecord(String str) {
        return QzoneModuleConfigManager.getInstance().getModuleRecord(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public ArrayList<UPDATE_INFO> getUpdateInfo() {
        return QzoneModuleConfigManager.getInstance().getUpdateInfo();
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void handleModuleRsp(SQ_CLIENT_UPDATE_RSP sq_client_update_rsp) {
        QzoneModuleConfigManager.getInstance().handleModuleRsp(sq_client_update_rsp);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean hasLoadNewMapSDK() {
        return QzoneModuleManager.getInstance().hasLoadNewMapSDK;
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean hasLoadOldMapSDK() {
        return QzoneModuleManager.getInstance().hasLoadOldMapSDK;
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean hasStartedUpdateTask() {
        return QzoneModuleManager.getInstance().hasStartedUpdateTask();
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean isModuleDownloaded(String str) {
        return QzoneModuleManager.getInstance().isModuleDownloaded(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean isModuleLoaded(String str) {
        return QzoneModuleManager.getInstance().isModuleLoaded(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean loadLibraryById(String str) {
        return QzoneModuleManager.getInstance().loadLibraryById(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean loadModule(String str, ClassLoader classLoader, boolean z16, boolean z17) {
        return QzoneModuleManager.getInstance().loadModule(str, classLoader, z16, z17);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean loadModuleAsQQPatch(String str) {
        return QzoneModuleManager.getInstance().loadModuleAsQQPatch(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean loadModuleAsQzonePatch(String str, ClassLoader classLoader) {
        return QzoneModuleManager.getInstance().loadModuleAsQzonePatch(str, classLoader);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void putModuleRecord(QzoneModuleRecord qzoneModuleRecord) {
        QzoneModuleConfigManager.getInstance().putModuleRecord(qzoneModuleRecord);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void updateAllModules() {
        QzoneModuleManager.getInstance().updateAllModules();
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void updateConfigAfterDownloaded(QzoneModuleRecord qzoneModuleRecord) {
        QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded(qzoneModuleRecord);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public void updateModule(String str, ModuleDownloadListener moduleDownloadListener) {
        QzoneModuleManager.getInstance().updateModule(str, moduleDownloadListener);
    }

    @Override // com.tencent.qzonehub.api.IQzoneModuleManageApi
    public boolean loadModule(File file) {
        return QzoneModuleManager.getInstance().loadModule(file);
    }
}
