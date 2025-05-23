package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildChannelInfoApi;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildChannelInfoApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildChannelInfoApi;", "()V", "fetchChannelInfoAnyway", "", "guildId", "", "channelId", "block", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Lkotlin/ParameterName;", "name", "info", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildChannelInfoApiImpl implements IGuildChannelInfoApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildChannelInfoApi
    public void fetchChannelInfoAnyway(@NotNull String guildId, @NotNull String channelId, @NotNull final Function1<? super IGProChannelInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(block, "block");
        GuildMainFrameUtils.e(guildId, channelId, new Function2<IGProChannelInfo, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildChannelInfoApiImpl$fetchChannelInfoAnyway$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo, Boolean bool) {
                invoke(iGProChannelInfo, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable IGProChannelInfo iGProChannelInfo, boolean z16) {
                block.invoke(iGProChannelInfo);
            }
        });
    }
}
