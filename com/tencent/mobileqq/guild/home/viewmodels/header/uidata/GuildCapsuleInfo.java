package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.channellist.MsgData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "I", "d", "()I", "channelType", "channelName", "appChannelIconUrl", "Lcom/tencent/mobileqq/guild/channellist/q;", "f", "Lcom/tencent/mobileqq/guild/channellist/q;", "()Lcom/tencent/mobileqq/guild/channellist/q;", "setMsgData", "(Lcom/tencent/mobileqq/guild/channellist/q;)V", AppConstants.Key.COLUMN_MSG_DATA, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildCapsuleInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appChannelIconUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MsgData msgData;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAppChannelIconUrl() {
        return this.appChannelIconUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: d, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCapsuleInfo)) {
            return false;
        }
        GuildCapsuleInfo guildCapsuleInfo = (GuildCapsuleInfo) other;
        if (Intrinsics.areEqual(this.guildId, guildCapsuleInfo.guildId) && Intrinsics.areEqual(this.channelId, guildCapsuleInfo.channelId) && this.channelType == guildCapsuleInfo.channelType && Intrinsics.areEqual(this.channelName, guildCapsuleInfo.channelName) && Intrinsics.areEqual(this.appChannelIconUrl, guildCapsuleInfo.appChannelIconUrl) && Intrinsics.areEqual(this.msgData, guildCapsuleInfo.msgData)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final MsgData getMsgData() {
        return this.msgData;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.channelType) * 31) + this.channelName.hashCode()) * 31;
        String str = this.appChannelIconUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.msgData.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCapsuleInfo(guildId=" + this.guildId + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", channelName=" + this.channelName + ", appChannelIconUrl=" + this.appChannelIconUrl + ", msgData=" + this.msgData + ")";
    }
}
