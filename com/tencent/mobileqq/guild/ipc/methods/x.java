package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class x extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        QLog.i("NavigateRoleGroupDetailMethod", 4, "QQGuildJsPlugin NavigateToForwardFriendListMethod doInvoke");
        String str2 = (String) objArr[0];
        String str3 = (String) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 0 && str3 != null && !str3.isEmpty()) {
            if (intValue == 1) {
                intValue = 2;
            }
        } else {
            str3 = "1";
            intValue = 0;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_guild_id", (String) objArr[0]);
        intent.putExtra("role_group_id", (String) objArr[1]);
        intent.putExtra("role_group_detail_open_type", ((Integer) objArr[2]).intValue());
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openQQGuildRoleGroupDetailFragment(str2, intValue, str3, 0);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
