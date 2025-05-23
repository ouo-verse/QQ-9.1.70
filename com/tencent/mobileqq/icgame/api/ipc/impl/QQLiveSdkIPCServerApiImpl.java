package com.tencent.mobileqq.icgame.api.ipc.impl;

import com.tencent.mobileqq.icgame.api.ipc.IQQLiveSdkIPCServerApi;
import com.tencent.mobileqq.icgame.ipc.QQLiveSdkIPCServerModule;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class QQLiveSdkIPCServerApiImpl implements IQQLiveSdkIPCServerApi {
    private static final String TAG = "ICGame_IPC_API";

    @Override // com.tencent.mobileqq.icgame.api.ipc.IQQLiveSdkIPCServerApi
    public QIPCModule getServerIPCModule() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "init");
        }
        return QQLiveSdkIPCServerModule.INSTANCE;
    }
}
