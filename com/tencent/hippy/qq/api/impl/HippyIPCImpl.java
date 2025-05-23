package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.ipc.HippyIpcModule;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes7.dex */
public class HippyIPCImpl implements IHippyIPC {
    @Override // com.tencent.hippy.qq.api.IHippyIPC
    public QIPCModule getIPCModule() {
        return HippyIpcModule.getInstance();
    }
}
