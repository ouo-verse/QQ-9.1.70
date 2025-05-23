package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class k extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        QLog.i("GuildExecuteRemoveGlobalNoticeMethod", 4, "QQGuildJsPlugin GuildExecuteRemoveGlobalNoticeMethod doInvoke");
        ((IGPSService) ch.S0(IGPSService.class, "")).removeGuildGlobalBanner((String) objArr[0]);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
