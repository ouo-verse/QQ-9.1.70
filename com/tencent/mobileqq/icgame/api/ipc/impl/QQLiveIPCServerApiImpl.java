package com.tencent.mobileqq.icgame.api.ipc.impl;

import com.tencent.mobileqq.icgame.api.ipc.IQQLiveIPCServerApi;
import com.tencent.mobileqq.icgame.base.ipc.QQLiveServerQIPCModule;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes15.dex */
public class QQLiveIPCServerApiImpl implements IQQLiveIPCServerApi {
    @Override // com.tencent.mobileqq.icgame.api.ipc.IQQLiveIPCServerApi
    public QIPCModule getQQLiveServerIPCModule() {
        return QQLiveServerQIPCModule.INSTANCE.a();
    }
}
