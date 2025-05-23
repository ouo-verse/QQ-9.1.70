package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildDebugApi;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildDebugApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildDebugApi;", "()V", "logJumpParams", "", "tag", "", "prefix", "obj", "", "reportCaughtException", "errorName", "message", "throwable", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildDebugApiImpl implements IGuildDebugApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildDebugApi
    public void logJumpParams(@NotNull String tag, @NotNull String prefix, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        GuildJumpDebugUtils.a(tag, prefix, obj);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDebugApi
    public void reportCaughtException(@NotNull String errorName, @NotNull String message, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(errorName, "errorName");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        qw1.b.h(Reporters.f231995a, errorName, message, throwable);
    }
}
