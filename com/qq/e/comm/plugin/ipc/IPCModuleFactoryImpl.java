package com.qq.e.comm.plugin.ipc;

import com.qq.e.comm.plugin.ipc.business.BusinessModuleName;
import com.qq.e.comm.plugin.ipc.business.StubVisitorProxyIPCModule;
import com.qq.e.comm.plugin.ipc.business.WuJiConfigIPCModule;

/* loaded from: classes3.dex */
public class IPCModuleFactoryImpl implements IPCModuleFactory {
    @Override // com.qq.e.comm.plugin.ipc.IPCModuleFactory
    public IPCModule createModule(String str) {
        if (BusinessModuleName.IPC_MODULE_WUJI_CONFIG.equals(str)) {
            return new WuJiConfigIPCModule(str);
        }
        if (BusinessModuleName.IPC_MODULE_STUB_VISITOR_PROXY.equals(str)) {
            return new StubVisitorProxyIPCModule(str);
        }
        return null;
    }
}
