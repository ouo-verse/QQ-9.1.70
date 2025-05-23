package com.tencent.mobileqq.guild.live.helper;

import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.config.g;
import com.tencent.mobileqq.guild.util.bs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/config/g;", "c", "", "guildID", "", "a", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {
    public static final boolean a(@NotNull String guildID) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        if (!c().a().contains("*") && !c().a().contains(guildID)) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull String guildID) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        ArrayList<String> a16 = QQGuildMCParser.INSTANCE.a("100544", "canProgramLiveGuild");
        if (!a16.contains("*") && !a16.contains(guildID)) {
            return false;
        }
        return true;
    }

    private static final g c() {
        return bs.f235483a.h("100595").getCanGameLiveGuild();
    }
}
