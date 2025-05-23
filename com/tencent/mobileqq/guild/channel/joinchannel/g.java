package com.tencent.mobileqq.guild.channel.joinchannel;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/g;", "", "", "mainSource", "subSource", "", "entranceId", "sourceType", "searchExtensionInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildSourceId;", "b", "result", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f214997a = new g();

    g() {
    }

    @JvmStatic
    @NotNull
    public static final GuildSourceId b(@NotNull String mainSource, @NotNull String subSource, int entranceId, int sourceType, @NotNull String searchExtensionInfo) {
        boolean z16;
        GuildSourceId guildSourceId;
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        Intrinsics.checkNotNullParameter(searchExtensionInfo, "searchExtensionInfo");
        if (mainSource.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.guild.util.s.e("Guild.join.JoinGuildUtils", "main source is null", new RuntimeException("source error"));
            if (QLog.isDebugVersion()) {
                Logger logger = Logger.f235387a;
                RuntimeException runtimeException = new RuntimeException("source error");
                Logger.b bVar = new Logger.b();
                bVar.a().add("throwExceptionIfGray(version=true):");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.join.JoinGuildUtils", 1, (String) it.next(), runtimeException);
                }
            }
            guildSourceId = new GuildSourceId("share", "others", entranceId, sourceType, searchExtensionInfo);
        } else {
            guildSourceId = new GuildSourceId(mainSource, subSource, entranceId, sourceType, searchExtensionInfo);
        }
        guildSourceId.v(com.tencent.mobileqq.guild.report.b.c());
        guildSourceId.y(com.tencent.mobileqq.guild.report.b.f());
        guildSourceId.w(com.tencent.mobileqq.guild.report.b.e());
        return guildSourceId;
    }

    public final boolean a(int result) {
        if (result != 22006 && result != 22009 && result != 22010 && result != 22007) {
            return false;
        }
        return true;
    }
}
