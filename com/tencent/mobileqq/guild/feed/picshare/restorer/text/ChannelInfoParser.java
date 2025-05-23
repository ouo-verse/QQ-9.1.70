package com.tencent.mobileqq.guild.feed.picshare.restorer.text;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import en1.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser;", "Len1/a;", "Lorg/json/JSONObject;", "jsonObject", "Len1/a$a;", "result", "", "a", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser$ChannelInfo;", "c", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser$AnchorInfo;", "b", "", "d", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser$ChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser$AnchorInfo;", "anchorInfo", "Ljava/lang/String;", "feedID", "<init>", "()V", "AnchorInfo", "ChannelInfo", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ChannelInfoParser implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ChannelInfo channelInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AnchorInfo anchorInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String feedID = "";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser$AnchorInfo;", "Ljava/io/Serializable;", "anchorUid", "", "nick", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnchorUid", "()Ljava/lang/String;", "getNick", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class AnchorInfo implements Serializable {

        @NotNull
        private final String anchorUid;

        @NotNull
        private final String nick;

        public AnchorInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AnchorInfo copy$default(AnchorInfo anchorInfo, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = anchorInfo.anchorUid;
            }
            if ((i3 & 2) != 0) {
                str2 = anchorInfo.nick;
            }
            return anchorInfo.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getAnchorUid() {
            return this.anchorUid;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        @NotNull
        public final AnchorInfo copy(@NotNull String anchorUid, @NotNull String nick) {
            Intrinsics.checkNotNullParameter(anchorUid, "anchorUid");
            Intrinsics.checkNotNullParameter(nick, "nick");
            return new AnchorInfo(anchorUid, nick);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) other;
            if (Intrinsics.areEqual(this.anchorUid, anchorInfo.anchorUid) && Intrinsics.areEqual(this.nick, anchorInfo.nick)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getAnchorUid() {
            return this.anchorUid;
        }

        @NotNull
        public final String getNick() {
            return this.nick;
        }

        public int hashCode() {
            return (this.anchorUid.hashCode() * 31) + this.nick.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnchorInfo(anchorUid=" + this.anchorUid + ", nick=" + this.nick + ')';
        }

        public AnchorInfo(@NotNull String anchorUid, @NotNull String nick) {
            Intrinsics.checkNotNullParameter(anchorUid, "anchorUid");
            Intrinsics.checkNotNullParameter(nick, "nick");
            this.anchorUid = anchorUid;
            this.nick = nick;
        }

        public /* synthetic */ AnchorInfo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser$ChannelInfo;", "Ljava/io/Serializable;", "guildID", "", "channelId", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getGuildID", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class ChannelInfo implements Serializable {

        @NotNull
        private final String channelId;

        @NotNull
        private final String guildID;

        public ChannelInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ChannelInfo copy$default(ChannelInfo channelInfo, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = channelInfo.guildID;
            }
            if ((i3 & 2) != 0) {
                str2 = channelInfo.channelId;
            }
            return channelInfo.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGuildID() {
            return this.guildID;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final ChannelInfo copy(@NotNull String guildID, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildID, "guildID");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new ChannelInfo(guildID, channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelInfo)) {
                return false;
            }
            ChannelInfo channelInfo = (ChannelInfo) other;
            if (Intrinsics.areEqual(this.guildID, channelInfo.guildID) && Intrinsics.areEqual(this.channelId, channelInfo.channelId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final String getGuildID() {
            return this.guildID;
        }

        public int hashCode() {
            return (this.guildID.hashCode() * 31) + this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelInfo(guildID=" + this.guildID + ", channelId=" + this.channelId + ')';
        }

        public ChannelInfo(@NotNull String guildID, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildID, "guildID");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.guildID = guildID;
            this.channelId = channelId;
        }

        public /* synthetic */ ChannelInfo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    public ChannelInfoParser() {
        int i3 = 3;
        this.channelInfo = new ChannelInfo(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        this.anchorInfo = new AnchorInfo(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
    }

    @Override // en1.a
    public void a(@NotNull JSONObject jsonObject, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = jsonObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"id\")");
        this.feedID = string;
        JSONObject jSONObject = jsonObject.getJSONObject("channelInfo").getJSONObject("sign");
        String guildID = jSONObject.getString("guild_id");
        String channelID = jSONObject.getString("channel_id");
        String posterUid = jsonObject.getJSONObject(QAdVrReport.ElementID.AD_POSTER).getString("id");
        String nick = jsonObject.getJSONObject(QAdVrReport.ElementID.AD_POSTER).getString("nick");
        Intrinsics.checkNotNullExpressionValue(guildID, "guildID");
        Intrinsics.checkNotNullExpressionValue(channelID, "channelID");
        this.channelInfo = new ChannelInfo(guildID, channelID);
        Intrinsics.checkNotNullExpressionValue(posterUid, "posterUid");
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        this.anchorInfo = new AnchorInfo(posterUid, nick);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final AnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFeedID() {
        return this.feedID;
    }
}
