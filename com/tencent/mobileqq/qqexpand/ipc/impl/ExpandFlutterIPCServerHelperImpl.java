package com.tencent.mobileqq.qqexpand.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/ipc/impl/ExpandFlutterIPCServerHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/ipc/IExpandFlutterIPCServerHelper;", "()V", "getIPCServer", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getProcessName", "", "notifyPushEvent", "", "pushType", "", "buffer", "", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandFlutterIPCServerHelperImpl implements IExpandFlutterIPCServerHelper {
    @Override // com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper
    public QIPCModule getIPCServer() {
        ExpandFlutterIPCServer y16 = ExpandFlutterIPCServer.y();
        Intrinsics.checkNotNullExpressionValue(y16, "getInstance()");
        return y16;
    }

    @Override // com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper
    public String getProcessName() {
        String processName = ExpandFlutterIPCServer.getProcessName();
        Intrinsics.checkNotNullExpressionValue(processName, "getProcessName()");
        return processName;
    }

    @Override // com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper
    public void notifyPushEvent(long pushType, byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ExpandFlutterIPCServer.y().notifyPushEvent(pushType, buffer);
    }
}
