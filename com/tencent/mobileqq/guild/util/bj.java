package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"", "channelName", "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "viewType", "a", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bj {
    @Nullable
    public static final String a(@Nullable String str, @NotNull HashTagViewType viewType) {
        GuildMsgAbFlag guildMsgAbFlag;
        boolean z16;
        IGuildUserService iGuildUserService;
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iGuildUserService = (IGuildUserService) peekAppRuntime.getRuntimeService(IGuildUserService.class, "")) != null) {
            guildMsgAbFlag = iGuildUserService.guildMode();
        } else {
            guildMsgAbFlag = null;
        }
        if (guildMsgAbFlag == GuildMsgAbFlag.KSIMPLEMODEL) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (viewType == HashTagViewType.VIEW_TYPE_FEED_SQUARE) {
            if (z16) {
                return "\u70ed\u95e8";
            }
            return "\u5e16\u5b50\u5e7f\u573a";
        }
        if (viewType == HashTagViewType.VIEW_TYPE_FEED_SECTION && !z16) {
            return "\u5e16\u5b50\u5e7f\u573a-" + str;
        }
        return str;
    }
}
