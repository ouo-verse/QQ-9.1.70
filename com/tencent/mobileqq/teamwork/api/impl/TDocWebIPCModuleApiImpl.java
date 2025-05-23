package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi;

/* loaded from: classes18.dex */
public class TDocWebIPCModuleApiImpl implements ITDocWebIPCModuleApi {
    @Override // com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi
    public QIPCModule getServerIPCModule() {
        return com.tencent.mobileqq.teamwork.app.v.f();
    }
}
