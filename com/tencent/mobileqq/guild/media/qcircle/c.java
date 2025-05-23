package com.tencent.mobileqq.guild.media.qcircle;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b9\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u00c5\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0004\u0012\b\b\u0002\u0010@\u001a\u00020\u0004\u0012\b\b\u0002\u0010E\u001a\u00020A\u0012\b\b\u0002\u0010H\u001a\u00020\u0004\u0012\b\b\u0002\u0010K\u001a\u00020\u0002\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u001c\u0010\u000eR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u001f\u0010\u000eR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010!\u001a\u0004\b\u0018\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\n\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\n\u001a\u0004\b)\u0010\f\"\u0004\b1\u0010\u000eR\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010!\u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\n\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010!\u001a\u0004\b3\u0010\"\"\u0004\b:\u0010$R\"\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b0\u0010\"\"\u0004\b<\u0010$R\"\u0010@\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010!\u001a\u0004\b\u001e\u0010\"\"\u0004\b?\u0010$R\"\u0010E\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010B\u001a\u0004\b\t\u0010C\"\u0004\b>\u0010DR\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010!\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\n\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000e\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "guildId", "b", "e", "t", "channelId", "c", "getGuildName", HippyTKDListViewAdapter.X, "guildName", "d", "getGuildIcon", "v", "guildIcon", "r", "btnUrl", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, TuxUIConstants.POP_BTN_TEXT, "I", "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "btnWidth", tl.h.F, "y", "joinSig", "i", "j", "B", "mainSourceId", "o", "G", "subSourceId", "k", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "liveRoomId", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "roomState", DomainData.DOMAIN_NAME, UserInfo.SEX_FEMALE, "sessionId", "D", "playerSum", BdhLogUtil.LogTag.Tag_Conn, "openMicSum", "p", "u", "channelType", "", "J", "()J", "(J)V", "anchorId", "getJoinedGuild", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "joinedGuild", "getSuggestTagName", "H", "suggestTagName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIJILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int btnWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String joinSig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mainSourceId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String subSourceId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String liveRoomId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int roomState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sessionId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int playerSum;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int openMicSum;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int channelType;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int joinedGuild;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String suggestTagName;

    public c() {
        this(null, null, null, null, null, null, 0, null, null, null, null, 0, null, 0, 0, 0, 0L, 0, null, 524287, null);
    }

    public final void A(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveRoomId = str;
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainSourceId = str;
    }

    public final void C(int i3) {
        this.openMicSum = i3;
    }

    public final void D(int i3) {
        this.playerSum = i3;
    }

    public final void E(int i3) {
        this.roomState = i3;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subSourceId = str;
    }

    public final void H(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.suggestTagName = str;
    }

    /* renamed from: a, reason: from getter */
    public final long getAnchorId() {
        return this.anchorId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBtnText() {
        return this.btnText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getBtnUrl() {
        return this.btnUrl;
    }

    /* renamed from: d, reason: from getter */
    public final int getBtnWidth() {
        return this.btnWidth;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.guildId, cVar.guildId) && Intrinsics.areEqual(this.channelId, cVar.channelId) && Intrinsics.areEqual(this.guildName, cVar.guildName) && Intrinsics.areEqual(this.guildIcon, cVar.guildIcon) && Intrinsics.areEqual(this.btnUrl, cVar.btnUrl) && Intrinsics.areEqual(this.btnText, cVar.btnText) && this.btnWidth == cVar.btnWidth && Intrinsics.areEqual(this.joinSig, cVar.joinSig) && Intrinsics.areEqual(this.mainSourceId, cVar.mainSourceId) && Intrinsics.areEqual(this.subSourceId, cVar.subSourceId) && Intrinsics.areEqual(this.liveRoomId, cVar.liveRoomId) && this.roomState == cVar.roomState && Intrinsics.areEqual(this.sessionId, cVar.sessionId) && this.playerSum == cVar.playerSum && this.openMicSum == cVar.openMicSum && this.channelType == cVar.channelType && this.anchorId == cVar.anchorId && this.joinedGuild == cVar.joinedGuild && Intrinsics.areEqual(this.suggestTagName, cVar.suggestTagName)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getJoinSig() {
        return this.joinSig;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.guildName.hashCode()) * 31) + this.guildIcon.hashCode()) * 31) + this.btnUrl.hashCode()) * 31) + this.btnText.hashCode()) * 31) + this.btnWidth) * 31) + this.joinSig.hashCode()) * 31) + this.mainSourceId.hashCode()) * 31) + this.subSourceId.hashCode()) * 31) + this.liveRoomId.hashCode()) * 31) + this.roomState) * 31) + this.sessionId.hashCode()) * 31) + this.playerSum) * 31) + this.openMicSum) * 31) + this.channelType) * 31) + androidx.fragment.app.a.a(this.anchorId)) * 31) + this.joinedGuild) * 31) + this.suggestTagName.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getMainSourceId() {
        return this.mainSourceId;
    }

    /* renamed from: k, reason: from getter */
    public final int getOpenMicSum() {
        return this.openMicSum;
    }

    /* renamed from: l, reason: from getter */
    public final int getPlayerSum() {
        return this.playerSum;
    }

    /* renamed from: m, reason: from getter */
    public final int getRoomState() {
        return this.roomState;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getSubSourceId() {
        return this.subSourceId;
    }

    public final void p(long j3) {
        this.anchorId = j3;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnText = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnUrl = str;
    }

    public final void s(int i3) {
        this.btnWidth = i3;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    @NotNull
    public String toString() {
        return "GuildFeedData guildId " + this.guildId + "channelId " + this.channelId + "guildName " + this.guildName + "anchorId " + this.anchorId + "sessionId " + this.sessionId + "joinSig " + this.joinSig + "mainSourceId " + this.mainSourceId + "subSourceId " + this.subSourceId + "liveRoomId " + this.liveRoomId;
    }

    public final void u(int i3) {
        this.channelType = i3;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildIcon = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void x(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildName = str;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.joinSig = str;
    }

    public final void z(int i3) {
        this.joinedGuild = i3;
    }

    public c(@NotNull String guildId, @NotNull String channelId, @NotNull String guildName, @NotNull String guildIcon, @NotNull String btnUrl, @NotNull String btnText, int i3, @NotNull String joinSig, @NotNull String mainSourceId, @NotNull String subSourceId, @NotNull String liveRoomId, int i16, @NotNull String sessionId, int i17, int i18, int i19, long j3, int i26, @NotNull String suggestTagName) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(guildIcon, "guildIcon");
        Intrinsics.checkNotNullParameter(btnUrl, "btnUrl");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        Intrinsics.checkNotNullParameter(joinSig, "joinSig");
        Intrinsics.checkNotNullParameter(mainSourceId, "mainSourceId");
        Intrinsics.checkNotNullParameter(subSourceId, "subSourceId");
        Intrinsics.checkNotNullParameter(liveRoomId, "liveRoomId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(suggestTagName, "suggestTagName");
        this.guildId = guildId;
        this.channelId = channelId;
        this.guildName = guildName;
        this.guildIcon = guildIcon;
        this.btnUrl = btnUrl;
        this.btnText = btnText;
        this.btnWidth = i3;
        this.joinSig = joinSig;
        this.mainSourceId = mainSourceId;
        this.subSourceId = subSourceId;
        this.liveRoomId = liveRoomId;
        this.roomState = i16;
        this.sessionId = sessionId;
        this.playerSum = i17;
        this.openMicSum = i18;
        this.channelType = i19;
        this.anchorId = j3;
        this.joinedGuild = i26;
        this.suggestTagName = suggestTagName;
    }

    public /* synthetic */ c(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, int i16, String str11, int i17, int i18, int i19, long j3, int i26, String str12, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? "" : str, (i27 & 2) != 0 ? "" : str2, (i27 & 4) != 0 ? "" : str3, (i27 & 8) != 0 ? "" : str4, (i27 & 16) != 0 ? "" : str5, (i27 & 32) != 0 ? "" : str6, (i27 & 64) != 0 ? 183 : i3, (i27 & 128) != 0 ? "" : str7, (i27 & 256) != 0 ? "" : str8, (i27 & 512) != 0 ? "" : str9, (i27 & 1024) != 0 ? "" : str10, (i27 & 2048) != 0 ? 0 : i16, (i27 & 4096) != 0 ? "" : str11, (i27 & 8192) != 0 ? 0 : i17, (i27 & 16384) != 0 ? 0 : i18, (i27 & 32768) != 0 ? 0 : i19, (i27 & 65536) != 0 ? 0L : j3, (i27 & 131072) != 0 ? 0 : i26, (i27 & 262144) != 0 ? "" : str12);
    }
}
