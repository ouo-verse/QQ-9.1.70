package com.tencent.mobileqq.guild.quickshare;

import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020'H\u00d6\u0001J\t\u0010(\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/ShareParam;", "Ljava/io/Serializable;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "source", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "triggerScene", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareTriggerScene;", "dialogTips", "", "dialogTheme", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickDialogTheme;", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareTriggerScene;Ljava/lang/String;Lcom/tencent/mobileqq/guild/quickshare/GuildQuickDialogTheme;)V", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getDialogTheme", "()Lcom/tencent/mobileqq/guild/quickshare/GuildQuickDialogTheme;", "getDialogTips", "()Ljava/lang/String;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getSource", "()Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "getTriggerScene", "()Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareTriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class ShareParam implements Serializable {

    @NotNull
    private final IGProChannelInfo channelInfo;

    @NotNull
    private final GuildQuickDialogTheme dialogTheme;

    @NotNull
    private final String dialogTips;

    @NotNull
    private final IGProGuildInfo guildInfo;

    @NotNull
    private final GuildSharePageSource source;

    @NotNull
    private final GuildQuickShareTriggerScene triggerScene;

    public ShareParam(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull GuildSharePageSource source, @NotNull GuildQuickShareTriggerScene triggerScene, @NotNull String dialogTips, @NotNull GuildQuickDialogTheme dialogTheme) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(dialogTips, "dialogTips");
        Intrinsics.checkNotNullParameter(dialogTheme, "dialogTheme");
        this.guildInfo = guildInfo;
        this.channelInfo = channelInfo;
        this.source = source;
        this.triggerScene = triggerScene;
        this.dialogTips = dialogTips;
        this.dialogTheme = dialogTheme;
    }

    public static /* synthetic */ ShareParam copy$default(ShareParam shareParam, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, GuildSharePageSource guildSharePageSource, GuildQuickShareTriggerScene guildQuickShareTriggerScene, String str, GuildQuickDialogTheme guildQuickDialogTheme, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            iGProGuildInfo = shareParam.guildInfo;
        }
        if ((i3 & 2) != 0) {
            iGProChannelInfo = shareParam.channelInfo;
        }
        IGProChannelInfo iGProChannelInfo2 = iGProChannelInfo;
        if ((i3 & 4) != 0) {
            guildSharePageSource = shareParam.source;
        }
        GuildSharePageSource guildSharePageSource2 = guildSharePageSource;
        if ((i3 & 8) != 0) {
            guildQuickShareTriggerScene = shareParam.triggerScene;
        }
        GuildQuickShareTriggerScene guildQuickShareTriggerScene2 = guildQuickShareTriggerScene;
        if ((i3 & 16) != 0) {
            str = shareParam.dialogTips;
        }
        String str2 = str;
        if ((i3 & 32) != 0) {
            guildQuickDialogTheme = shareParam.dialogTheme;
        }
        return shareParam.copy(iGProGuildInfo, iGProChannelInfo2, guildSharePageSource2, guildQuickShareTriggerScene2, str2, guildQuickDialogTheme);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final IGProChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final GuildSharePageSource getSource() {
        return this.source;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final GuildQuickShareTriggerScene getTriggerScene() {
        return this.triggerScene;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getDialogTips() {
        return this.dialogTips;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final GuildQuickDialogTheme getDialogTheme() {
        return this.dialogTheme;
    }

    @NotNull
    public final ShareParam copy(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull GuildSharePageSource source, @NotNull GuildQuickShareTriggerScene triggerScene, @NotNull String dialogTips, @NotNull GuildQuickDialogTheme dialogTheme) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(dialogTips, "dialogTips");
        Intrinsics.checkNotNullParameter(dialogTheme, "dialogTheme");
        return new ShareParam(guildInfo, channelInfo, source, triggerScene, dialogTips, dialogTheme);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareParam)) {
            return false;
        }
        ShareParam shareParam = (ShareParam) other;
        if (Intrinsics.areEqual(this.guildInfo, shareParam.guildInfo) && Intrinsics.areEqual(this.channelInfo, shareParam.channelInfo) && this.source == shareParam.source && this.triggerScene == shareParam.triggerScene && Intrinsics.areEqual(this.dialogTips, shareParam.dialogTips) && this.dialogTheme == shareParam.dialogTheme) {
            return true;
        }
        return false;
    }

    @NotNull
    public final IGProChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    public final GuildQuickDialogTheme getDialogTheme() {
        return this.dialogTheme;
    }

    @NotNull
    public final String getDialogTips() {
        return this.dialogTips;
    }

    @NotNull
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    @NotNull
    public final GuildSharePageSource getSource() {
        return this.source;
    }

    @NotNull
    public final GuildQuickShareTriggerScene getTriggerScene() {
        return this.triggerScene;
    }

    public int hashCode() {
        return (((((((((this.guildInfo.hashCode() * 31) + this.channelInfo.hashCode()) * 31) + this.source.hashCode()) * 31) + this.triggerScene.hashCode()) * 31) + this.dialogTips.hashCode()) * 31) + this.dialogTheme.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShareParam(guildInfo=" + this.guildInfo + ", channelInfo=" + this.channelInfo + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ", dialogTips=" + this.dialogTips + ", dialogTheme=" + this.dialogTheme + ')';
    }
}
