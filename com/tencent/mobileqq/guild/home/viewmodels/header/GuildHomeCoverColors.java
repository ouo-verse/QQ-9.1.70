package com.tencent.mobileqq.guild.home.viewmodels.header;

import android.graphics.Color;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b5\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001\tB\u00a7\u0001\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020\u0004\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\u0004\u0012\u0006\u00106\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u00020\u0004\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\fR\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b#\u0010\fR\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b%\u0010\fR\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b'\u0010\fR\u0017\u0010*\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b)\u0010\fR\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u00100\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u00102\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u00104\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b3\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u00106\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b\u001d\u0010\fR\u0017\u00108\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b7\u0010\n\u001a\u0004\b \u0010\f\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", DomainData.DOMAIN_NAME, "()I", "type", "b", "j", "mainColor", "c", "i", "guildNameColor", "d", "l", "onlineMemberColor", "e", "getGlobalMsgColor", "globalMsgColor", "f", "getSubChannelTitleColor", "subChannelTitleColor", "g", "getSubChannelSubTitleColor", "subChannelSubTitleColor", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "subChannelBgColor", "k", "navigationBarColor", "getNavigationBarSpaceColor", "navigationBarSpaceColor", "getStickyTitleBarBgTop", "stickyTitleBarBgTop", "getStickyTitleBarBgBottom", "stickyTitleBarBgBottom", "groupChatMainColor", "groupChatTipsColor", "o", "groupChatLineColor", "p", "groupChatTimeColor", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "groupChatSummaryColor", "r", "groupChatSummaryHighlightColor", ReportConstant.COSTREPORT_PREFIX, "groupChatUnreadBg", "t", "groupChatUnreadTextColor", "<init>", "(IIIIIIIIIIIIIIIIIIII)V", "u", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.e, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeCoverColors {

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mainColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int guildNameColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int onlineMemberColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int globalMsgColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subChannelTitleColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subChannelSubTitleColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subChannelBgColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int navigationBarColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int navigationBarSpaceColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int stickyTitleBarBgTop;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int stickyTitleBarBgBottom;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int groupChatMainColor;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int groupChatTipsColor;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int groupChatLineColor;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int groupChatTimeColor;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int groupChatSummaryColor;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final int groupChatSummaryHighlightColor;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final int groupChatUnreadBg;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final int groupChatUnreadTextColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/e$a;", "", "", "type", "mainColor", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "c", "b", "", com.tencent.luggage.wxa.c8.c.f123400v, "color", "a", "TYPE_BLACK", "I", "TYPE_IDLE", "TYPE_WHITE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(float alpha, int color) {
            return (((int) ((alpha * 255.0f) + 0.5f)) << 24) | (color & 16777215);
        }

        @NotNull
        public final GuildHomeCoverColors b(int type, int mainColor) {
            return new GuildHomeCoverColors(type, mainColor, -16777216, a(0.7f, -16777216), a(0.4f, -16777216), -16777216, a(0.4f, -16777216), a(0.5f, -1), a(0.7f, -16777216), a(0.25f, -16777216), a(0.85f, mainColor), mainColor, -16777216, a(0.7f, Color.parseColor("#1A1C1E")), a(0.1f, -16777216), a(0.5f, Color.parseColor("#1A1C1E")), R.color.f157143bp4, R.color.bp5, a(0.2f, -1), a(0.4f, Color.parseColor("#1A1C1E")));
        }

        @NotNull
        public final GuildHomeCoverColors c(int type, int mainColor) {
            return new GuildHomeCoverColors(type, mainColor, -1, a(0.8f, -1), a(0.6f, -1), -1, a(0.6f, -1), a(0.2f, -1), a(0.8f, -1), a(0.4f, -1), a(0.85f, mainColor), mainColor, -1, a(0.8f, -1), a(0.15f, -1), a(0.8f, -1), R.color.bp7, R.color.bp6, a(0.08f, -16777216), a(0.8f, -1));
        }

        Companion() {
        }
    }

    public GuildHomeCoverColors(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, int i56, int i57, int i58) {
        this.type = i3;
        this.mainColor = i16;
        this.guildNameColor = i17;
        this.onlineMemberColor = i18;
        this.globalMsgColor = i19;
        this.subChannelTitleColor = i26;
        this.subChannelSubTitleColor = i27;
        this.subChannelBgColor = i28;
        this.navigationBarColor = i29;
        this.navigationBarSpaceColor = i36;
        this.stickyTitleBarBgTop = i37;
        this.stickyTitleBarBgBottom = i38;
        this.groupChatMainColor = i39;
        this.groupChatTipsColor = i46;
        this.groupChatLineColor = i47;
        this.groupChatTimeColor = i48;
        this.groupChatSummaryColor = i49;
        this.groupChatSummaryHighlightColor = i56;
        this.groupChatUnreadBg = i57;
        this.groupChatUnreadTextColor = i58;
    }

    /* renamed from: a, reason: from getter */
    public final int getGroupChatLineColor() {
        return this.groupChatLineColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getGroupChatMainColor() {
        return this.groupChatMainColor;
    }

    /* renamed from: c, reason: from getter */
    public final int getGroupChatSummaryColor() {
        return this.groupChatSummaryColor;
    }

    /* renamed from: d, reason: from getter */
    public final int getGroupChatSummaryHighlightColor() {
        return this.groupChatSummaryHighlightColor;
    }

    /* renamed from: e, reason: from getter */
    public final int getGroupChatTimeColor() {
        return this.groupChatTimeColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeCoverColors)) {
            return false;
        }
        GuildHomeCoverColors guildHomeCoverColors = (GuildHomeCoverColors) other;
        if (this.type == guildHomeCoverColors.type && this.mainColor == guildHomeCoverColors.mainColor && this.guildNameColor == guildHomeCoverColors.guildNameColor && this.onlineMemberColor == guildHomeCoverColors.onlineMemberColor && this.globalMsgColor == guildHomeCoverColors.globalMsgColor && this.subChannelTitleColor == guildHomeCoverColors.subChannelTitleColor && this.subChannelSubTitleColor == guildHomeCoverColors.subChannelSubTitleColor && this.subChannelBgColor == guildHomeCoverColors.subChannelBgColor && this.navigationBarColor == guildHomeCoverColors.navigationBarColor && this.navigationBarSpaceColor == guildHomeCoverColors.navigationBarSpaceColor && this.stickyTitleBarBgTop == guildHomeCoverColors.stickyTitleBarBgTop && this.stickyTitleBarBgBottom == guildHomeCoverColors.stickyTitleBarBgBottom && this.groupChatMainColor == guildHomeCoverColors.groupChatMainColor && this.groupChatTipsColor == guildHomeCoverColors.groupChatTipsColor && this.groupChatLineColor == guildHomeCoverColors.groupChatLineColor && this.groupChatTimeColor == guildHomeCoverColors.groupChatTimeColor && this.groupChatSummaryColor == guildHomeCoverColors.groupChatSummaryColor && this.groupChatSummaryHighlightColor == guildHomeCoverColors.groupChatSummaryHighlightColor && this.groupChatUnreadBg == guildHomeCoverColors.groupChatUnreadBg && this.groupChatUnreadTextColor == guildHomeCoverColors.groupChatUnreadTextColor) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getGroupChatTipsColor() {
        return this.groupChatTipsColor;
    }

    /* renamed from: g, reason: from getter */
    public final int getGroupChatUnreadBg() {
        return this.groupChatUnreadBg;
    }

    /* renamed from: h, reason: from getter */
    public final int getGroupChatUnreadTextColor() {
        return this.groupChatUnreadTextColor;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.type * 31) + this.mainColor) * 31) + this.guildNameColor) * 31) + this.onlineMemberColor) * 31) + this.globalMsgColor) * 31) + this.subChannelTitleColor) * 31) + this.subChannelSubTitleColor) * 31) + this.subChannelBgColor) * 31) + this.navigationBarColor) * 31) + this.navigationBarSpaceColor) * 31) + this.stickyTitleBarBgTop) * 31) + this.stickyTitleBarBgBottom) * 31) + this.groupChatMainColor) * 31) + this.groupChatTipsColor) * 31) + this.groupChatLineColor) * 31) + this.groupChatTimeColor) * 31) + this.groupChatSummaryColor) * 31) + this.groupChatSummaryHighlightColor) * 31) + this.groupChatUnreadBg) * 31) + this.groupChatUnreadTextColor;
    }

    /* renamed from: i, reason: from getter */
    public final int getGuildNameColor() {
        return this.guildNameColor;
    }

    /* renamed from: j, reason: from getter */
    public final int getMainColor() {
        return this.mainColor;
    }

    /* renamed from: k, reason: from getter */
    public final int getNavigationBarColor() {
        return this.navigationBarColor;
    }

    /* renamed from: l, reason: from getter */
    public final int getOnlineMemberColor() {
        return this.onlineMemberColor;
    }

    /* renamed from: m, reason: from getter */
    public final int getSubChannelBgColor() {
        return this.subChannelBgColor;
    }

    /* renamed from: n, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "GuildHomeCoverColors(type=" + this.type + ", mainColor=" + Util.toHexString(this.mainColor) + ", guildNameColor=" + Util.toHexString(this.guildNameColor) + ", onlineMemberColor=" + Util.toHexString(this.onlineMemberColor) + ", globalMsgColor=" + Util.toHexString(this.globalMsgColor) + ", subChannelTitleColor=" + Util.toHexString(this.subChannelTitleColor) + ", subChannelSubTitleColor=" + Util.toHexString(this.subChannelSubTitleColor) + ", subChannelBgColor=" + Util.toHexString(this.subChannelBgColor) + ", navigationBarColor=" + Util.toHexString(this.navigationBarColor) + ", stickyTitleBarBgTop=" + Util.toHexString(this.stickyTitleBarBgTop) + ", stickyTitleBarBgBottom=" + Util.toHexString(this.stickyTitleBarBgBottom) + ")";
    }
}
