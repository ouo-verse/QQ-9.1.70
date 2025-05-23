package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.ark.core.g;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes11.dex */
public class ArkIPCServiceImpl implements IArkIPCService {
    @Override // com.tencent.mobileqq.ark.api.IArkIPCService
    public void call(k91.b bVar) {
        g.e().call(bVar);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkIPCService
    public QIPCModule getModule() {
        return g.e();
    }
}
