package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ad extends AbsIpcMethod {
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
        GuildJumpUtil.j(context2, str2, "", str3, "discover", "recommend_editor");
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
