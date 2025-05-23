package com.tencent.mobileqq.guild.media;

import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cz;
import com.tencent.mobileqq.qqguildsdk.data.df;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/z;", "", "", "guildId", "channelId", "", tl.h.F, "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "f", "g", "", "isLand", "c", "a", "tag", "b", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z f230084a = new z();

    z() {
    }

    @JvmStatic
    public static final int h(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        IGProGuildInfo L = ch.L(guildId);
        if (L == null) {
            return 3;
        }
        if (L.getUserType() == 2) {
            return 1;
        }
        if (L.getUserType() == 1 || ch.h0(channelId)) {
            return 2;
        }
        if (!ch.j0(guildId)) {
            return 3;
        }
        return 4;
    }

    public final int a(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        if (channelInfo.getInviteSpeakCfg().getInviteSpeakState() == 2) {
            return 0;
        }
        return 1;
    }

    @NotNull
    public final String b(@NotNull String tag) {
        JumpGuildParam jumpGuildParam;
        String str;
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        String str2;
        Map<String, String> reportInfoMap;
        GuildAppReportSourceInfo reportSourceInfo;
        Map<String, String> reportInfoMap2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Bundle loadBeanBundle = com.tencent.mobileqq.guild.media.core.j.a().getLoadBeanBundle();
        GuildAppReportSourceInfo guildAppReportSourceInfo2 = null;
        if (loadBeanBundle != null) {
            jumpGuildParam = (JumpGuildParam) loadBeanBundle.getParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
        } else {
            jumpGuildParam = null;
        }
        if (!(jumpGuildParam instanceof JumpGuildParam)) {
            jumpGuildParam = null;
        }
        if (jumpGuildParam != null && (reportSourceInfo = jumpGuildParam.getReportSourceInfo()) != null && (reportInfoMap2 = reportSourceInfo.getReportInfoMap()) != null) {
            str = reportInfoMap2.get(tag);
        } else {
            str = null;
        }
        if (str != null) {
            String str3 = jumpGuildParam.getReportSourceInfo().getReportInfoMap().get(tag);
            Intrinsics.checkNotNull(str3);
            QLog.d("GuildMediaReportUtils", 1, "getReportInfo 1 " + tag + MsgSummary.STR_COLON + ((Object) str3));
            String str4 = jumpGuildParam.getReportSourceInfo().getReportInfoMap().get(tag);
            Intrinsics.checkNotNull(str4);
            return str4;
        }
        if (loadBeanBundle != null) {
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) loadBeanBundle.getParcelable("GuildAppReportSourceInfo");
        } else {
            guildAppReportSourceInfo = null;
        }
        if (guildAppReportSourceInfo instanceof GuildAppReportSourceInfo) {
            guildAppReportSourceInfo2 = guildAppReportSourceInfo;
        }
        if (guildAppReportSourceInfo2 == null || (reportInfoMap = guildAppReportSourceInfo2.getReportInfoMap()) == null || (str2 = reportInfoMap.get(tag)) == null) {
            str2 = "";
        }
        QLog.d("GuildMediaReportUtils", 1, "getReportInfo 2 " + tag + MsgSummary.STR_COLON + str2);
        return str2;
    }

    @NotNull
    public final String c(boolean isLand) {
        if (isLand) {
            return "landscape_mode";
        }
        return "grid_page";
    }

    public final int d(@NotNull String guildId, @NotNull String channelId) {
        List<cz> channelStateList;
        IAudioChannelState iAudioChannelState;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        dt guildState = ((IGPSService) ch.R0(IGPSService.class)).getGuildState(guildId);
        if (guildState == null || (channelStateList = guildState.getChannelStateList()) == null) {
            return 0;
        }
        for (cz czVar : channelStateList) {
            if (Intrinsics.areEqual(czVar.getChannelId(), channelId)) {
                Integer num = null;
                if (czVar instanceof IAudioChannelState) {
                    iAudioChannelState = (IAudioChannelState) czVar;
                } else {
                    iAudioChannelState = null;
                }
                if (iAudioChannelState != null) {
                    num = Integer.valueOf(iAudioChannelState.getChannelState());
                }
                int i3 = 4;
                if (num != null && num.intValue() == 4) {
                    return 1;
                }
                if (num != null && num.intValue() == 9) {
                    return 2;
                }
                if (num == null || num.intValue() != 17) {
                    if (num != null && num.intValue() == 8) {
                        return 5;
                    }
                    i3 = 6;
                    if (num == null || num.intValue() != 18) {
                        if (num == null || num.intValue() != 6) {
                            return 0;
                        }
                        return 7;
                    }
                }
                return i3;
            }
        }
        return 0;
    }

    public final int e() {
        int o16 = MediaChannelUtils.o(MediaChannelUtils.f228046a, null, 1, null);
        if (o16 == 2) {
            return 2;
        }
        if (o16 != 4) {
            return 1;
        }
        return 3;
    }

    public final int f(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        int talkPermission = channelInfo.getTalkPermission();
        if (talkPermission == 1) {
            return 1;
        }
        if (talkPermission == 2) {
            return 2;
        }
        return 3;
    }

    public final int g(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Iterator<df> it = channelInfo.getAuthControlStatusList().iterator();
        while (it.hasNext()) {
            df next = it.next();
            if (next.getAuthControlKey() == 5) {
                if (next.getAuthControlValue() != 1) {
                    return 1;
                }
                return 2;
            }
        }
        return 1;
    }
}
