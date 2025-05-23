package com.tencent.mobileqq.guild.mainframe;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/d;", "", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "b", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "a", "()Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "(Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;)V", "sourceInfo", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f227410a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GuildAppReportSourceInfo sourceInfo;

    d() {
    }

    @Nullable
    public final GuildAppReportSourceInfo a() {
        return sourceInfo;
    }

    public final void b(@Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        sourceInfo = guildAppReportSourceInfo;
    }
}
