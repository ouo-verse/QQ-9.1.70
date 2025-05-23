package com.tencent.mobileqq.guild.channel.frame.openaction;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.channel.frame.openaction.i;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/e;", "Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e implements i {
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (r3 == null) goto L33;
     */
    @Override // com.tencent.mobileqq.guild.channel.frame.openaction.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        QBaseActivity qBaseActivity;
        String str;
        int i3;
        int i16;
        String jumpUrl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        String str2 = jumpGuildParam.guildId;
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        boolean z16 = true;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(channelId)) {
            o02.a.g(11);
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
            } else {
                qBaseActivity = QBaseActivity.sTopActivity;
            }
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            IGProAppChnnPreInfo pollingChannelOfApp = iGPSService.getPollingChannelOfApp(str2, channelId);
            IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
            String str3 = "";
            String str4 = null;
            if (pollingChannelOfApp != null && (jumpUrl = pollingChannelOfApp.getJumpUrl()) != null) {
                if (jumpUrl.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    if (channelInfo != null) {
                        str = channelInfo.getAppChannelJumpUrl();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "channelInfo?.appChannelJumpUrl ?: \"\"");
                        str3 = str;
                    }
                } else {
                    str3 = jumpUrl;
                }
                if (pollingChannelOfApp != null) {
                    i3 = pollingChannelOfApp.getJumpType();
                } else if (channelInfo != null) {
                    i3 = channelInfo.getAppChannelJumpType();
                } else {
                    i3 = 2;
                }
                if (pollingChannelOfApp != null) {
                    i16 = (int) pollingChannelOfApp.getAppid();
                } else {
                    i16 = IChannelType.APP_SUB_CHANNEL_TYPE_LINK;
                }
                GuildClientParams a16 = new GuildClientParams().e0(str2).f(channelId).g0(jumpGuildParam.isGuest()).j0(str3).a(i16);
                if (channelInfo != null) {
                    str4 = channelInfo.getChannelName();
                }
                return kg1.a.d(qBaseActivity, a16.g(str4).c0(iGPSService.getGuildAvatarUrl(str2, 40)).i0(i3).n(0).d0(b(jumpGuildParam)).e());
            }
            if (channelInfo != null) {
                str = channelInfo.getAppChannelJumpUrl();
            } else {
                str = null;
            }
        } else {
            QLog.w("Guild.jump.ChannelWorldOpenAction", 1, "handleAction: guildId or channelId is null");
            return false;
        }
    }

    @NotNull
    public Bundle b(@NotNull JumpGuildParam jumpGuildParam) {
        return i.a.a(this, jumpGuildParam);
    }
}
