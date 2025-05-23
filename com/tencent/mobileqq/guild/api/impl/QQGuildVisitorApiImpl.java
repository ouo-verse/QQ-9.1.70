package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IQQGuildVisitorApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/QQGuildVisitorApiImpl;", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi;", "", "pageTag", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "getVisitorJoinGuildTimerTaskClass", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQGuildVisitorApiImpl implements IQQGuildVisitorApi {
    @Override // com.tencent.mobileqq.guild.api.IQQGuildVisitorApi
    @NotNull
    public IQQGuildVisitorApi.a getVisitorJoinGuildTimerTaskClass(@NotNull String pageTag, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(pageTag, "pageTag");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        return new or1.b(null, pageTag, jumpGuildParam);
    }
}
