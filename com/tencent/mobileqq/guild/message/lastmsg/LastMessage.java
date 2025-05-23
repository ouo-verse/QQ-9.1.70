package com.tencent.mobileqq.guild.message.lastmsg;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001:\u00015B[\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002Jv\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\"\u0010+R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b(\u0010,\u001a\u0004\b)\u0010-R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b'\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b/\u00101\u001a\u0004\b&\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "", "", "toString", "l", "guildId", "channelId", "", "type", QCircleLpReportDc010001.KEY_SUBTYPE, AppConstants.Key.COLUMN_MSG_SENDER_UIN, "senderNickname", "", "content", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "sendState", "", "time", "Lju1/a;", "customData", "a", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;JLju1/a;)Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "b", "c", "I", "k", "()I", "d", "Ljava/lang/Integer;", "getSubType", "()Ljava/lang/Integer;", "e", "i", h.F, "g", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "()Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "J", "j", "()J", "Lju1/a;", "()Lju1/a;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;JLju1/a;)V", "SendState", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class LastMessage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer subType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String senderUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String senderNickname;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence content;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SendState sendState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ju1.a customData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "", "(Ljava/lang/String;I)V", "SENDING", "SEND_SUCCESS", "SEND_FAILED", "SEND_SUCCESS_NOSEQ", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum SendState {
        SENDING,
        SEND_SUCCESS,
        SEND_FAILED,
        SEND_SUCCESS_NOSEQ
    }

    public LastMessage(@NotNull String guildId, @NotNull String channelId, int i3, @Nullable Integer num, @NotNull String senderUin, @NotNull String senderNickname, @NotNull CharSequence content, @NotNull SendState sendState, long j3, @NotNull ju1.a customData) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(senderNickname, "senderNickname");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(customData, "customData");
        this.guildId = guildId;
        this.channelId = channelId;
        this.type = i3;
        this.subType = num;
        this.senderUin = senderUin;
        this.senderNickname = senderNickname;
        this.content = content;
        this.sendState = sendState;
        this.time = j3;
        this.customData = customData;
    }

    @NotNull
    public final LastMessage a(@NotNull String guildId, @NotNull String channelId, int type, @Nullable Integer subType, @NotNull String senderUin, @NotNull String senderNickname, @NotNull CharSequence content, @NotNull SendState sendState, long time, @NotNull ju1.a customData) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(senderNickname, "senderNickname");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(customData, "customData");
        return new LastMessage(guildId, channelId, type, subType, senderUin, senderNickname, content, sendState, time, customData);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ju1.a getCustomData() {
        return this.customData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LastMessage)) {
            return false;
        }
        LastMessage lastMessage = (LastMessage) other;
        if (Intrinsics.areEqual(this.guildId, lastMessage.guildId) && Intrinsics.areEqual(this.channelId, lastMessage.channelId) && this.type == lastMessage.type && Intrinsics.areEqual(this.subType, lastMessage.subType) && Intrinsics.areEqual(this.senderUin, lastMessage.senderUin) && Intrinsics.areEqual(this.senderNickname, lastMessage.senderNickname) && Intrinsics.areEqual(this.content, lastMessage.content) && this.sendState == lastMessage.sendState && this.time == lastMessage.time && Intrinsics.areEqual(this.customData, lastMessage.customData)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final SendState getSendState() {
        return this.sendState;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getSenderNickname() {
        return this.senderNickname;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.type) * 31;
        Integer num = this.subType;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return ((((((((((((hashCode2 + hashCode) * 31) + this.senderUin.hashCode()) * 31) + this.senderNickname.hashCode()) * 31) + this.content.hashCode()) * 31) + this.sendState.hashCode()) * 31) + androidx.fragment.app.a.a(this.time)) * 31) + this.customData.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getSenderUin() {
        return this.senderUin;
    }

    /* renamed from: j, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: k, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String l() {
        CharSequence take;
        StringBuilder sb5 = new StringBuilder();
        sb5.append('(');
        sb5.append(this.guildId);
        sb5.append(',');
        sb5.append(this.channelId);
        sb5.append(MsgSummary.STR_COLON);
        take = StringsKt___StringsKt.take(this.content, 2);
        sb5.append((Object) take);
        sb5.append(')');
        return sb5.toString();
    }

    @NotNull
    public String toString() {
        CharSequence take;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("LastMessage(guildId=");
        sb5.append(this.guildId);
        sb5.append(", channelId=");
        sb5.append(this.channelId);
        sb5.append(", type=");
        sb5.append(this.type);
        sb5.append(", subType=");
        sb5.append(this.subType);
        sb5.append(", senderUin=");
        sb5.append(this.senderUin);
        sb5.append(", senderNickname=");
        sb5.append(this.senderNickname);
        sb5.append(", content=");
        take = StringsKt___StringsKt.take(this.content, 2);
        sb5.append((Object) take);
        sb5.append(", sendState=");
        sb5.append(this.sendState);
        sb5.append(", time=");
        sb5.append(this.time);
        sb5.append(')');
        return sb5.toString();
    }
}
