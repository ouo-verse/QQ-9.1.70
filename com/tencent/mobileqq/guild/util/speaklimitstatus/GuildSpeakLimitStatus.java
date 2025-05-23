package com.tencent.mobileqq.guild.util.speaklimitstatus;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildMuteApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/speaklimitstatus/GuildSpeakLimitStatus;", "", "", "limitStatus", "I", "getLimitStatus", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "GUILD_ROLE_OWNER", "GUILD_ROLE_GUILD_ADMIN", "GUILD_ROLE_CHANNEL_ADMIN", "GUILD_ROLE_CATEGORY_ADMIN", "GUILD_ROLE_GUEST", "GUILD_SPEAK_THRESHOLD", "DIRECT_MSG_THRESHOLD", "GUILD_MUTE_ALL", "GUILD_MUTE_SELF", "CHANNEL_READ_ONLY", "CHANNEL_READ_ONLY_LIVE_ANCHOR_MUTE", "GUEST_PREVIEW_CHANNEL_LIMIT", "GUEST_INTERACT_LIMIT", "GUEST_REAL_AUTH_LIMIT", "GUILD_GUEST_LIVE", "GUEST_LIVE_LIMIT", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public enum GuildSpeakLimitStatus {
    GUILD_ROLE_OWNER(4096),
    GUILD_ROLE_GUILD_ADMIN(8192),
    GUILD_ROLE_CHANNEL_ADMIN(16384),
    GUILD_ROLE_CATEGORY_ADMIN(32768),
    GUILD_ROLE_GUEST(1),
    GUILD_SPEAK_THRESHOLD(2),
    DIRECT_MSG_THRESHOLD(4),
    GUILD_MUTE_ALL(1024),
    GUILD_MUTE_SELF(2048),
    CHANNEL_READ_ONLY(16),
    CHANNEL_READ_ONLY_LIVE_ANCHOR_MUTE(32),
    GUEST_PREVIEW_CHANNEL_LIMIT(128),
    GUEST_INTERACT_LIMIT(256),
    GUEST_REAL_AUTH_LIMIT(512),
    GUILD_GUEST_LIVE(131072),
    GUEST_LIVE_LIMIT(65536);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int limitStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b,\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/util/speaklimitstatus/GuildSpeakLimitStatus$a;", "", "", "status", "", "u", "v", "w", "I", "", "guildId", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "M", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "p", "E", ReportConstant.COSTREPORT_PREFIX, "K", "l", "k", "t", h.F, "i", "b", "c", "r", BdhLogUtil.LogTag.Tag_Conn, "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "J", "N", "H", "channelType", DomainData.DOMAIN_NAME, "(ILjava/lang/String;Ljava/lang/Integer;)Z", UserInfo.SEX_FEMALE, "L", "P", "O", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d", "a", "f", "g", "e", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean E(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUEST_INTERACT_LIMIT;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean G(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.CHANNEL_READ_ONLY_LIVE_ANCHOR_MUTE;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean I(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_GUEST_LIVE;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean K(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUEST_REAL_AUTH_LIMIT;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean M(int status) {
            if (!v(status) && w(status) && l(status)) {
                return true;
            }
            return false;
        }

        private final boolean b(int status) {
            if (r(status) && !E(status) && !K(status) && !u(status) && !m(status) && !G(status)) {
                return true;
            }
            return false;
        }

        private final boolean c(int status) {
            if (r(status) && !O(status) && !K(status) && !u(status) && !m(status) && !G(status)) {
                return true;
            }
            return false;
        }

        private final boolean h(int status, String guildId) {
            if (!r(status) && ((!C(status) || B(status)) && ((!u(status) || j(guildId)) && ((!G(status) || B(status)) && (!m(status) || B(status)))))) {
                return true;
            }
            return false;
        }

        private final boolean i(int status, String guildId) {
            if (!r(status) && ((!C(status) || B(status)) && (!u(status) || j(guildId)))) {
                return true;
            }
            return false;
        }

        private final boolean j(String guildId) {
            boolean z16;
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 || !((IGuildMuteApi) QRoute.api(IGuildMuteApi.class)).hasGuildMuteManagePermission(guildId)) {
                return false;
            }
            return true;
        }

        private final boolean k(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_ROLE_CHANNEL_ADMIN;
            if ((guildSpeakLimitStatus.getLimitStatus() & status) != guildSpeakLimitStatus.getLimitStatus()) {
                GuildSpeakLimitStatus guildSpeakLimitStatus2 = GuildSpeakLimitStatus.GUILD_ROLE_CATEGORY_ADMIN;
                if ((status & guildSpeakLimitStatus2.getLimitStatus()) != guildSpeakLimitStatus2.getLimitStatus()) {
                    return false;
                }
            }
            return true;
        }

        private final boolean l(int status) {
            if (k(status) && !t(status)) {
                return true;
            }
            return false;
        }

        private final boolean m(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.CHANNEL_READ_ONLY;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean o(int status) {
            if (m(status) && !K(status) && !u(status) && !F(status)) {
                return true;
            }
            return false;
        }

        private final boolean p(int status, String guildId) {
            if (m(status) && !C(status) && ((!u(status) || j(guildId)) && !B(status))) {
                return true;
            }
            return false;
        }

        private final boolean s(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUEST_PREVIEW_CHANNEL_LIMIT;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean t(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_ROLE_GUILD_ADMIN;
            if ((guildSpeakLimitStatus.getLimitStatus() & status) != guildSpeakLimitStatus.getLimitStatus()) {
                GuildSpeakLimitStatus guildSpeakLimitStatus2 = GuildSpeakLimitStatus.GUILD_ROLE_OWNER;
                if ((status & guildSpeakLimitStatus2.getLimitStatus()) != guildSpeakLimitStatus2.getLimitStatus()) {
                    return false;
                }
            }
            return true;
        }

        private final boolean u(int status) {
            if (!v(status) && !w(status)) {
                return false;
            }
            return true;
        }

        private final boolean v(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_MUTE_ALL;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean w(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_MUTE_SELF;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        private final boolean y(int status) {
            if (u(status) && !E(status) && !K(status)) {
                return true;
            }
            return false;
        }

        private final boolean z(int status, String guildId) {
            if (D(status)) {
                return false;
            }
            if (j(guildId) && p(status, guildId)) {
                return false;
            }
            if ((!w(status) || j(guildId)) && !v(status)) {
                return false;
            }
            return true;
        }

        public final boolean A(int status) {
            if (!B(status) && !r(status)) {
                return true;
            }
            return false;
        }

        public final boolean B(int status) {
            if (!k(status) && !t(status)) {
                return false;
            }
            return true;
        }

        public final boolean C(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_SPEAK_THRESHOLD;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        public final boolean D(int status) {
            if (C(status) && A(status)) {
                return true;
            }
            return false;
        }

        public final boolean F(int status) {
            if (!E(status) && !s(status)) {
                return false;
            }
            return true;
        }

        public final boolean H(int status) {
            if (G(status) && !D(status) && !u(status) && !B(status)) {
                return true;
            }
            return false;
        }

        public final boolean J(int status, @Nullable String guildId) {
            if (r(status) && !I(status)) {
                return false;
            }
            return z(status, guildId);
        }

        public final boolean L(int status) {
            if (K(status) && !F(status)) {
                return true;
            }
            return false;
        }

        public final boolean N(int status) {
            if (M(status) && !D(status)) {
                return true;
            }
            return false;
        }

        public final boolean O(int status) {
            if (r(status)) {
                GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUEST_LIVE_LIMIT;
                if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean P(int status) {
            return r(status);
        }

        public final boolean a(int status, @Nullable String guildId) {
            if (r(status)) {
                return false;
            }
            return d(status, guildId);
        }

        public final boolean d(int status, @Nullable String guildId) {
            if (!h(status, guildId) && !b(status)) {
                return false;
            }
            return true;
        }

        public final boolean e(int status) {
            if (!B(status) && q(status)) {
                return false;
            }
            return true;
        }

        public final boolean f(int status, @Nullable String guildId) {
            if (!h(status, guildId) && !c(status)) {
                return false;
            }
            return true;
        }

        public final boolean g(int status, @Nullable String guildId) {
            if (!i(status, guildId) && !b(status)) {
                return false;
            }
            return true;
        }

        public final boolean n(int status, @Nullable String guildId, @Nullable Integer channelType) {
            if (r(status)) {
                if (channelType != null && channelType.intValue() == 5) {
                    return o(status);
                }
                return false;
            }
            return p(status, guildId);
        }

        public final boolean q(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.DIRECT_MSG_THRESHOLD;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        public final boolean r(int status) {
            GuildSpeakLimitStatus guildSpeakLimitStatus = GuildSpeakLimitStatus.GUILD_ROLE_GUEST;
            if ((status & guildSpeakLimitStatus.getLimitStatus()) == guildSpeakLimitStatus.getLimitStatus()) {
                return true;
            }
            return false;
        }

        public final boolean x(int status, @Nullable String guildId) {
            if (r(status)) {
                return y(status);
            }
            return z(status, guildId);
        }

        Companion() {
        }
    }

    GuildSpeakLimitStatus(int i3) {
        this.limitStatus = i3;
    }

    public final int getLimitStatus() {
        return this.limitStatus;
    }
}
