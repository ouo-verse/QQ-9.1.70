package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.util.Pair;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ae extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        Context context2 = context;
        if (!ca.a()) {
            return EIPCResult.createResult(-204, new Bundle());
        }
        String str2 = (String) objArr[0];
        String str3 = (String) objArr[1];
        Pair<String, String> b16 = QQGuildJumpSource.b(((Integer) objArr[2]).intValue(), "NavigateToGuildInfoPageToJoinMethod");
        GuildJumpUtil.j(context2, str2, "", str3, b16.first, b16.second);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
