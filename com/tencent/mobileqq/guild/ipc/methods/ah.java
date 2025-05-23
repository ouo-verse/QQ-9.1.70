package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.GuildShareInviteCodeParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.util.Pair;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ah extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        String str2;
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        String str3 = (String) objArr[0];
        int intValue = ((Integer) objArr[1]).intValue();
        if (objArr.length >= 3) {
            str2 = (String) objArr[2];
        } else {
            str2 = "";
        }
        String str4 = (String) objArr[3];
        if (!TextUtils.isEmpty(str4)) {
            com.tencent.mobileqq.guild.report.b.g(str4, "NavigateToGuildPageWithInvitedInfoMethod");
        }
        o02.a.e(new Bundle(), 7);
        Pair<String, String> b16 = QQGuildJumpSource.b(intValue, "NavigateToGuildPageWithInvitedInfoMethod");
        GuildJumpUtil.m(context, new GuildShareInviteCodeParam(str3, str2, b16.first, b16.second));
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
