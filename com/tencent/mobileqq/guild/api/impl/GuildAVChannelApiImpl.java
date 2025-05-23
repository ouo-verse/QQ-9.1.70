package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildAVChannelApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildAVChannelApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelSourceParam;", "getAvChannelSourceParam", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$MediaChannelCallback;", "cb", "", "exitChannel", "", "isInChannel", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelDetailInfo;", "getCurrentChannelDetailInfo", "isFloatingWndShowing", "quitAVFloatWindowWithExitRoom", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildAVChannelApiImpl implements IGuildAVChannelApi {

    @NotNull
    public static final String TAG = "GuildAVChannelApiImpl";

    private final IGuildAVChannelApi.ChannelSourceParam getAvChannelSourceParam(long guildId, long channelId) {
        Integer num;
        Bundle bundle;
        String str;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam.JoinInfoParam joinInfoParam2;
        IGProChannelInfo C = ch.C(ch.l(), String.valueOf(guildId), String.valueOf(channelId));
        String str2 = null;
        if (C != null) {
            num = Integer.valueOf(C.getType());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            bundle = com.tencent.mobileqq.guild.media.core.j.a().getLoadBeanBundle();
        } else if (num != null && num.intValue() == 5) {
            bundle = GLiveChannelCore.f226698a.s().getBundle();
        } else {
            bundle = null;
        }
        if (bundle != null && (joinInfoParam2 = (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
            str = joinInfoParam2.getMainSource();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (bundle != null && (joinInfoParam = (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
            str2 = joinInfoParam.getSubSource();
        }
        if (str2 != null) {
            str3 = str2;
        }
        return new IGuildAVChannelApi.ChannelSourceParam(str, str3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVChannelApi
    public void exitChannel(long guildId, long channelId, @Nullable IGuildAVChannelApi.MediaChannelCallback cb5) {
        Integer num;
        QLog.i(TAG, 1, "[exitChannel] guildId: " + guildId + ", channelId: " + channelId);
        if (!isInChannel(guildId, channelId)) {
            QLog.i(TAG, 1, "[exitChannel] not in channel currently. return success");
            if (cb5 != null) {
                cb5.onSuccess();
                return;
            }
            return;
        }
        IGProChannelInfo C = ch.C(ch.l(), String.valueOf(guildId), String.valueOf(channelId));
        Integer num2 = null;
        if (C != null) {
            num = Integer.valueOf(C.getType());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            com.tencent.mobileqq.guild.media.core.j.a().D("", TAG);
            if (cb5 != null) {
                cb5.onSuccess();
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 5) {
            GLiveChannelCore.f226698a.b(TAG);
            GuildFloatWindowUtils.p();
            if (cb5 != null) {
                cb5.onSuccess();
                return;
            }
            return;
        }
        if (C != null) {
            num2 = Integer.valueOf(C.getType());
        }
        QLog.e(TAG, 1, "[exitChannel] support channel type: " + num2);
        if (cb5 != null) {
            IGuildAVChannelApi.MediaChannelCallback.DefaultImpls.onFailed$default(cb5, -1, "Not yet implemented", null, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVChannelApi
    @NotNull
    public IGuildAVChannelApi.ChannelDetailInfo getCurrentChannelDetailInfo() {
        Boolean bool;
        boolean z16 = true;
        if (!((IGuildJumpApi) QRoute.api(IGuildJumpApi.class)).isGuildUser()) {
            QLog.w(TAG, 1, "[getCurrentChannelDetailInfo] is not guild user, return default");
            return new IGuildAVChannelApi.ChannelDetailInfo(0L, 0L, null, 7, null);
        }
        IGProGuildUserState alreadyEnteredChannel = ((IGPSService) ch.R0(IGPSService.class)).getAlreadyEnteredChannel();
        if (alreadyEnteredChannel != null) {
            bool = Boolean.valueOf(alreadyEnteredChannel.getHasEnteredChannel());
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = Intrinsics.areEqual(bool, Boolean.FALSE);
        }
        if (z16) {
            return new IGuildAVChannelApi.ChannelDetailInfo(0L, 0L, null, 7, null);
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return new IGuildAVChannelApi.ChannelDetailInfo(alreadyEnteredChannel.getGuildId(), alreadyEnteredChannel.getChannelId(), getAvChannelSourceParam(alreadyEnteredChannel.getGuildId(), alreadyEnteredChannel.getChannelId()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVChannelApi
    public boolean isFloatingWndShowing() {
        return GuildFloatWindowUtils.m();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVChannelApi
    public boolean isInChannel(long guildId, long channelId) {
        boolean z16 = false;
        if (!((IGuildJumpApi) QRoute.api(IGuildJumpApi.class)).isGuildUser()) {
            QLog.w(TAG, 1, "[isInChannel] (" + guildId + ", " + channelId + ") is not guild user, return false");
            return false;
        }
        IGProGuildUserState alreadyEnteredChannel = ((IGPSService) ch.R0(IGPSService.class)).getAlreadyEnteredChannel();
        if ((alreadyEnteredChannel != null && alreadyEnteredChannel.getHasEnteredChannel()) && alreadyEnteredChannel.getGuildId() == guildId && alreadyEnteredChannel.getChannelId() == channelId) {
            z16 = true;
        }
        QLog.i(TAG, 1, "[isInChannel] guildId: " + guildId + ", channelId: " + channelId + ", hasEntered: " + (alreadyEnteredChannel != null ? Boolean.valueOf(alreadyEnteredChannel.getHasEnteredChannel()) : null) + ". ret: " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVChannelApi
    public void quitAVFloatWindowWithExitRoom() {
        GuildFloatWindowUtils.q();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVChannelApi
    public boolean isInChannel() {
        if (!((IGuildJumpApi) QRoute.api(IGuildJumpApi.class)).isGuildUser()) {
            QLog.w(TAG, 1, "[isInChannel] is not guild user, return false");
            return false;
        }
        IGProGuildUserState alreadyEnteredChannel = ((IGPSService) ch.R0(IGPSService.class)).getAlreadyEnteredChannel();
        boolean hasEnteredChannel = alreadyEnteredChannel != null ? alreadyEnteredChannel.getHasEnteredChannel() : false;
        QLog.i(TAG, 1, "[isInChannel] " + hasEnteredChannel);
        return hasEnteredChannel;
    }
}
