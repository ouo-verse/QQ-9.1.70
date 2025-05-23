package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ap extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        String str2 = (String) objArr[0];
        int intValue = ((Integer) objArr[1]).intValue();
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelListSetting(context, str2, intValue);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
