package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.qqguild.directmessage.aio.input.GuildC2CPermissions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sz1.JoinTimeItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildSpeakThresholdApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi;", "", "guildId", "", "isLimitingInChannel", "channelId", "canEnableKeyboard", "isLimitingInC2C", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "getGuildSpeakableThresholdPermission", "Landroid/content/Context;", "context", "prefix", "Landroid/text/SpannableStringBuilder;", "getFaceAuthTextSpan", "", "type", "getDesByType", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "listener", "", "addListener", "removeListener", "notifyListeners", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildSpeakThresholdApiImpl implements IGuildSpeakThresholdApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public void addListener(@NotNull IGuildSpeakThresholdApi.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        sz1.d.e(listener);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public boolean canEnableKeyboard(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (DirectMessageNodeRepository.C(channelId) == null) {
            return GuildSpeakLimitStatus.INSTANCE.e(fo0.h.a(guildId, channelId));
        }
        return GuildC2CPermissions.INSTANCE.c(com.tencent.qqguild.directmessage.aio.input.a.a(channelId));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    @NotNull
    public String getDesByType(long type) {
        return JoinTimeItem.INSTANCE.b(type);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    @NotNull
    public SpannableStringBuilder getFaceAuthTextSpan(@NotNull Context context, @NotNull String prefix) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return sz1.c.f435021a.b(context, prefix);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    @NotNull
    public IGuildSpeakableThresholdPermission getGuildSpeakableThresholdPermission(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return sz1.d.f(guildId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public boolean isLimitingInC2C(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return sz1.d.l(guildId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public boolean isLimitingInChannel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return sz1.d.j(guildId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public void notifyListeners(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        sz1.d.f435022e.o(guildId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public void removeListener(@NotNull IGuildSpeakThresholdApi.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        sz1.d.p(listener);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi
    public boolean isLimitingInChannel(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return sz1.d.k(guildId, channelId);
    }
}
