package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class g extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        String str2 = (String) objArr[0];
        int intValue = ((Integer) objArr[1]).intValue();
        Bundle bundle = new Bundle();
        try {
            IGProGuildInfo guildInfo = ((IGPSService) ch.S0(IGPSService.class, "")).getGuildInfo(str2);
            if (guildInfo != null) {
                String avatarUrl = guildInfo.getAvatarUrl(intValue);
                if (!TextUtils.isEmpty(avatarUrl)) {
                    bundle.putString("get_guild_avatar_url", avatarUrl);
                }
            }
        } catch (Exception e16) {
            QLog.e("GetGuildAvatarUrlMethod", 1, e16, new Object[0]);
        }
        return EIPCResult.createSuccessResult(bundle);
    }
}
