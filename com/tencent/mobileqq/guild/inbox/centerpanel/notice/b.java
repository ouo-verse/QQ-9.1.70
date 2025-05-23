package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/b;", "", "", "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "", "block", "a", "b", "", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/GuildInfoProcess;", "Ljava/util/Map;", "guildInfoProcesses", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, GuildInfoProcess> guildInfoProcesses = new LinkedHashMap();

    @UiThread
    public final void a(@NotNull String guildId, @NotNull Function1<? super IGProGuildInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.guildInfoProcesses.containsKey(guildId)) {
            GuildInfoProcess guildInfoProcess = this.guildInfoProcesses.get(guildId);
            if (guildInfoProcess != null) {
                guildInfoProcess.c(block);
                return;
            }
            return;
        }
        this.guildInfoProcesses.put(guildId, new GuildInfoProcess(guildId));
        GuildInfoProcess guildInfoProcess2 = this.guildInfoProcesses.get(guildId);
        if (guildInfoProcess2 != null) {
            guildInfoProcess2.c(block);
        }
    }

    @UiThread
    public final void b(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        GuildInfoProcess guildInfoProcess = this.guildInfoProcesses.get(guildId);
        if (guildInfoProcess != null) {
            guildInfoProcess.f();
        }
    }
}
