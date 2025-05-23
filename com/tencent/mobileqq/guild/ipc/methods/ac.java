package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ac extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        if (!ca.a()) {
            QLog.d("NavigateToGuildDiscover", 1, "[doInvoke]  tab not show");
            return EIPCResult.createResult(-204, new Bundle());
        }
        String str2 = (String) objArr[0];
        QLog.i("NavigateToGuildDiscover", 1, "[doInvoke] targetTab=" + str2);
        Bundle bundle = new Bundle();
        bundle.putString("discoveryTargetTab", str2);
        GuildJumpUtil.o(context, bundle);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
