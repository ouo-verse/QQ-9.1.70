package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ak extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        String str2;
        String str3;
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        boolean z16 = false;
        String str4 = (String) objArr[0];
        if (objArr.length >= 4) {
            z16 = ((Boolean) objArr[1]).booleanValue();
            str2 = (String) objArr[2];
            str3 = (String) objArr[3];
        } else {
            str2 = null;
            str3 = null;
        }
        if (!ca.a() && !z16) {
            return EIPCResult.createResult(-204, new Bundle());
        }
        if (z16) {
            GuildJumpUtil.n(context, new JumpGuildParam(str4, ""));
        } else {
            com.tencent.mobileqq.guild.util.a.a(str2);
            com.tencent.mobileqq.guild.util.a.b(str4);
            com.tencent.mobileqq.guild.util.a.c(str3);
            GuildJumpUtil.r(context, str4);
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
