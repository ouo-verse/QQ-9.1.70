package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class l extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildExecuteUpdateGlobalNoticeMethod", 2, "QQGuildJsPlugin GuildExecuteUpdateGlobalNoticeMethod doInvoke");
        }
        String str2 = (String) objArr[0];
        if (TextUtils.isEmpty(str2)) {
            QLog.e("GuildExecuteUpdateGlobalNoticeMethod", 1, "QQGuildJsPlugin doInvoke guildId empty!");
            return EIPCResult.createResult(-90, new Bundle());
        }
        ((IGPSService) ch.S0(IGPSService.class, "")).refreshPollingData(str2, 7);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
