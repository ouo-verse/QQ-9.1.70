package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import eipc.EIPCResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes13.dex */
public class aj extends AbsIpcMethod {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit e(int i3, JumpGuildParam jumpGuildParam, GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
        if (!guildAndChannelInfoRsp.l()) {
            QQToastUtil.showQQToast(1, R.string.f15162187);
            return null;
        }
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        if (i3 == 3) {
            jumpGuildParam.getExtras().putInt("extra_launch_mode", 3);
        }
        GuildJumpUtil.n(context, jumpGuildParam);
        return null;
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        final int intValue = ((Integer) objArr[0]).intValue();
        final JumpGuildParam jumpGuildParam = (JumpGuildParam) objArr[1];
        QLog.d("NavigateToGuildPageWithSigMethod", 1, "NavigateToGuildPageWithSigMethodpageType: " + intValue + ", jumpGuildParam: " + jumpGuildParam);
        GuildMainFrameUtils.g(jumpGuildParam.getGuildId(), "", 0, "", false, new Function1() { // from class: com.tencent.mobileqq.guild.ipc.methods.ai
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e16;
                e16 = aj.e(intValue, jumpGuildParam, (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj);
                return e16;
            }
        });
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
