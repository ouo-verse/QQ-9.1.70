package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class z extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        QLog.i("NavigateToCreateGuildRolePageMethod", 4, "QQGuildJsPlugin NavigateToForwardFriendListMethod doInvoke");
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openQQGuildRoleGroupDetailFragment((String) objArr[0], 0, "1", ((Integer) objArr[1]).intValue());
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
