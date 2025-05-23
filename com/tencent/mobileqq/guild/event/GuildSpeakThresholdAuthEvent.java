package com.tencent.mobileqq.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/event/GuildSpeakThresholdAuthEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tipText", "", "jumpText", WadlProxyConsts.KEY_JUMP_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJumpText", "()Ljava/lang/String;", "getJumpUrl", "getTipText", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildSpeakThresholdAuthEvent extends SimpleBaseEvent {

    @NotNull
    private final String jumpText;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String tipText;

    public GuildSpeakThresholdAuthEvent(@NotNull String tipText, @NotNull String jumpText, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        Intrinsics.checkNotNullParameter(jumpText, "jumpText");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.tipText = tipText;
        this.jumpText = jumpText;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ GuildSpeakThresholdAuthEvent copy$default(GuildSpeakThresholdAuthEvent guildSpeakThresholdAuthEvent, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildSpeakThresholdAuthEvent.tipText;
        }
        if ((i3 & 2) != 0) {
            str2 = guildSpeakThresholdAuthEvent.jumpText;
        }
        if ((i3 & 4) != 0) {
            str3 = guildSpeakThresholdAuthEvent.jumpUrl;
        }
        return guildSpeakThresholdAuthEvent.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTipText() {
        return this.tipText;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getJumpText() {
        return this.jumpText;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final GuildSpeakThresholdAuthEvent copy(@NotNull String tipText, @NotNull String jumpText, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        Intrinsics.checkNotNullParameter(jumpText, "jumpText");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new GuildSpeakThresholdAuthEvent(tipText, jumpText, jumpUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSpeakThresholdAuthEvent)) {
            return false;
        }
        GuildSpeakThresholdAuthEvent guildSpeakThresholdAuthEvent = (GuildSpeakThresholdAuthEvent) other;
        if (Intrinsics.areEqual(this.tipText, guildSpeakThresholdAuthEvent.tipText) && Intrinsics.areEqual(this.jumpText, guildSpeakThresholdAuthEvent.jumpText) && Intrinsics.areEqual(this.jumpUrl, guildSpeakThresholdAuthEvent.jumpUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getJumpText() {
        return this.jumpText;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getTipText() {
        return this.tipText;
    }

    public int hashCode() {
        return (((this.tipText.hashCode() * 31) + this.jumpText.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildSpeakThresholdAuthEvent(tipText=" + this.tipText + ", jumpText=" + this.jumpText + ", jumpUrl=" + this.jumpUrl + ')';
    }
}
