package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.guild.api.IGuildJumpParserFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildJumpParserFactoryImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildJumpParserFactory;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getGuildJumpParserClass", "<init>", "()V", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildJumpParserFactoryImpl implements IGuildJumpParserFactory {
    @Override // com.tencent.mobileqq.guild.api.IGuildJumpParserFactory
    @NotNull
    public Class<? extends av> getGuildJumpParserClass() {
        return com.tencent.mobileqq.guild.jump.h.class;
    }
}
