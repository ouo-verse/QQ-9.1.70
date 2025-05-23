package com.tencent.guild.aio.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/util/k;", "", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f112410a = new k();

    k() {
    }

    @NotNull
    public final JumpGuildParam a(@NotNull AIOParam aioParam) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        int i3;
        long j3;
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        Bundle l3 = aioParam.l();
        String string = l3.getString("guild_id", "");
        if (TextUtils.isEmpty(string)) {
            string = a.g(aioParam);
        }
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) l3.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        String b16 = a.b(aioParam);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(b16);
        }
        if (iGProChannelInfo != null) {
            i3 = iGProChannelInfo.getType();
        } else {
            i3 = 0;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(string, b16, joinInfoParam);
        JumpGuildParam.JoinInfoParam joinInfoParam2 = jumpGuildParam.getJoinInfoParam();
        if (iGProChannelInfo != null) {
            j3 = iGProChannelInfo.getApplicationId();
        } else {
            j3 = 0;
        }
        joinInfoParam2.setPageEntranceId(QQGuildJumpSource.a(i3, j3));
        return jumpGuildParam;
    }
}
