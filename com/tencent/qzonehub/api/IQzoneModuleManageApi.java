package com.tencent.qzonehub.api;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneModuleManageApi extends QRouteApi {
    void abortDownloadModule(String str);

    void cancelDownloadModule(String str);

    boolean checkIfNeedUpdate(String str);

    boolean downloadModule(String str, ModuleDownloadListener moduleDownloadListener);

    String getModuleFilePath(String str);

    QzoneModuleRecord getModuleRecord(String str);

    ArrayList<UPDATE_INFO> getUpdateInfo();

    void handleModuleRsp(SQ_CLIENT_UPDATE_RSP sq_client_update_rsp);

    boolean hasLoadNewMapSDK();

    boolean hasLoadOldMapSDK();

    boolean hasStartedUpdateTask();

    boolean isModuleDownloaded(String str);

    boolean isModuleLoaded(String str);

    boolean loadLibraryById(String str);

    boolean loadModule(File file);

    boolean loadModule(String str, ClassLoader classLoader, boolean z16, boolean z17);

    boolean loadModuleAsQQPatch(String str);

    boolean loadModuleAsQzonePatch(String str, ClassLoader classLoader);

    void putModuleRecord(QzoneModuleRecord qzoneModuleRecord);

    void updateAllModules();

    void updateConfigAfterDownloaded(QzoneModuleRecord qzoneModuleRecord);

    void updateModule(String str, ModuleDownloadListener moduleDownloadListener);
}
