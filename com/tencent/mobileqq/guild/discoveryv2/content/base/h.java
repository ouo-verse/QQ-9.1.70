package com.tencent.mobileqq.guild.discoveryv2.content.base;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0000H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "", "", "getItemType", "", "getItemId", "newItem", "", "areItemsTheSame", "areContentsTheSame", "getChangePayload", "i4", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface h {

    /* renamed from: i4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f216928a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\bW\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bW\u0010XR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0006\u0010\bR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\r\u0010\bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\n\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\bR\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\bR\u0017\u0010(\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\bR\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\bR\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\bR\u0017\u00101\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\bR\u0017\u00103\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b\u001d\u0010\bR\u0017\u00106\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\bR\u0017\u00109\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\bR\u0017\u0010<\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\bR\u0017\u0010=\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0012\u0010\bR\u0017\u0010?\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b>\u0010\u0004\u001a\u0004\b>\u0010\bR\u0017\u0010@\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b\u000f\u0010\bR\u0017\u0010A\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b;\u0010\u0004\u001a\u0004\b \u0010\bR\u0017\u0010B\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b,\u0010\bR\u0017\u0010C\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b2\u0010\bR\u0017\u0010E\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bD\u0010\u0004\u001a\u0004\b:\u0010\bR\u0017\u0010G\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bF\u0010\u0004\u001a\u0004\b)\u0010\bR\u0017\u0010I\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bH\u0010\u0004\u001a\u0004\b7\u0010\bR\u0017\u0010K\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bJ\u0010\u0004\u001a\u0004\b4\u0010\bR\u0017\u0010M\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bL\u0010\u0004\u001a\u0004\b&\u0010\bR\u0017\u0010O\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bN\u0010\u0004\u001a\u0004\b/\u0010\bR\u0017\u0010P\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0019\u0010\bR\u0017\u0010R\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bQ\u0010\u0004\u001a\u0004\b\u001b\u0010\bR\u0017\u0010T\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bS\u0010\u0004\u001a\u0004\b#\u0010\bR\u0017\u0010V\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bU\u0010\u0004\u001a\u0004\b\u0015\u0010\b\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h$a;", "", "", "b", "I", "BASE_LINE", "c", "i", "()I", "TYPE_LOAD_MORE", "d", "a", "TYPE_ACTIVE", "e", "TYPE_CATEGORY_FEATURED", "f", "getTYPE_USER_GUILDS", "TYPE_USER_GUILDS", "g", "w", "TYPE_RECOMMEND_GUILDS", tl.h.F, "getTYPE_HOT_ACTIVITY_GUILDS", "TYPE_HOT_ACTIVITY_GUILDS", "TYPE_CONFIG_BANNER", "j", "TYPE_CONFIG_SPACE", "k", "TYPE_CONFIG_DIVIDER", "l", "getTYPE_SEARCH", "TYPE_SEARCH", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTYPE_MY_GUILD", "TYPE_MY_GUILD", DomainData.DOMAIN_NAME, "getTYPE_EMPTY_GUILD", "TYPE_EMPTY_GUILD", "o", "getTYPE_PLACEHOLDER_GUILD", "TYPE_PLACEHOLDER_GUILD", "p", "getTYPE_GUILD_NOTICE", "TYPE_GUILD_NOTICE", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getTYPE_NAVIGATION_BAR", "TYPE_NAVIGATION_BAR", "r", "y", "TYPE_TEXT", ReportConstant.COSTREPORT_PREFIX, "TYPE_PIC_MIX", "t", "B", "TYPE_VIDEO_MIX", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "TYPE_THIRD_VIDEO", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "TYPE_THIRD_SHARE_LINK", "TYPE_GROUP", HippyTKDListViewAdapter.X, "TYPE_ROBOT_TYPE_DEFAULT", "TYPE_FEATURED_GUILDS", "TYPE_POPULAR_LIVE", "TYPE_RECOMMENDED_GUILD", "TYPE_RECOMMENDED_LIVE", BdhLogUtil.LogTag.Tag_Conn, "TYPE_RECOMMENDED_VOICE", "D", "TYPE_RECOMMENDED_FILE", "E", "TYPE_RECOMMENDED_SCREEN_SHARE", UserInfo.SEX_FEMALE, "TYPE_RECOMMENDED_SCHEME", "G", "TYPE_RECOMMENDED_FEED_TOPIC", "H", "TYPE_RECOMMENDED_GUILD_FEEDS", "TYPE_MY_TAB_EMPTY", "J", "TYPE_MY_TAB_END", "K", "TYPE_RECOMMENDED_AD", "L", "TYPE_HORIZONTAL_SINGLE_GUILD", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.base.h$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: A, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_GUILD;

        /* renamed from: B, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_LIVE;

        /* renamed from: C, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_VOICE;

        /* renamed from: D, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_FILE;

        /* renamed from: E, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_SCREEN_SHARE;

        /* renamed from: F, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_SCHEME;

        /* renamed from: G, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_FEED_TOPIC;

        /* renamed from: H, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_GUILD_FEEDS;

        /* renamed from: I, reason: from kotlin metadata */
        private static final int TYPE_MY_TAB_EMPTY;

        /* renamed from: J, reason: from kotlin metadata */
        private static final int TYPE_MY_TAB_END;

        /* renamed from: K, reason: from kotlin metadata */
        private static final int TYPE_RECOMMENDED_AD;

        /* renamed from: L, reason: from kotlin metadata */
        private static final int TYPE_HORIZONTAL_SINGLE_GUILD;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f216928a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int BASE_LINE;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_LOAD_MORE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ACTIVE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_CATEGORY_FEATURED;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_USER_GUILDS;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_RECOMMEND_GUILDS;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_HOT_ACTIVITY_GUILDS;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_CONFIG_BANNER;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_CONFIG_SPACE;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_CONFIG_DIVIDER;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_SEARCH;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_MY_GUILD;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_EMPTY_GUILD;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_PLACEHOLDER_GUILD;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_GUILD_NOTICE;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_NAVIGATION_BAR;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_TEXT;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_PIC_MIX;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_VIDEO_MIX;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_THIRD_VIDEO;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_THIRD_SHARE_LINK;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_GROUP;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_ROBOT_TYPE_DEFAULT;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_FEATURED_GUILDS;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_POPULAR_LIVE;

        static {
            int i3 = BASE_LINE + 1;
            TYPE_LOAD_MORE = i3;
            int i16 = i3 + 1;
            TYPE_ACTIVE = i16;
            int i17 = i16 + 1;
            TYPE_CATEGORY_FEATURED = i17;
            int i18 = i17 + 1;
            TYPE_USER_GUILDS = i18;
            int i19 = i18 + 1;
            TYPE_RECOMMEND_GUILDS = i19;
            int i26 = i19 + 1;
            TYPE_HOT_ACTIVITY_GUILDS = i26;
            int i27 = i26 + 1;
            TYPE_CONFIG_BANNER = i27;
            int i28 = i27 + 1;
            TYPE_CONFIG_SPACE = i28;
            int i29 = i28 + 1;
            TYPE_CONFIG_DIVIDER = i29;
            int i36 = i29 + 1;
            TYPE_SEARCH = i36;
            int i37 = i36 + 1;
            TYPE_MY_GUILD = i37;
            int i38 = i37 + 1;
            TYPE_EMPTY_GUILD = i38;
            int i39 = i38 + 1;
            TYPE_PLACEHOLDER_GUILD = i39;
            int i46 = i39 + 1;
            TYPE_GUILD_NOTICE = i46;
            int i47 = i46 + 1;
            TYPE_NAVIGATION_BAR = i47;
            int i48 = i47 + 1;
            TYPE_TEXT = i48;
            int i49 = i48 + 1;
            TYPE_PIC_MIX = i49;
            int i56 = i49 + 1;
            TYPE_VIDEO_MIX = i56;
            int i57 = i56 + 1;
            TYPE_THIRD_VIDEO = i57;
            int i58 = i57 + 1;
            TYPE_THIRD_SHARE_LINK = i58;
            int i59 = i58 + 1;
            TYPE_GROUP = i59;
            int i65 = i59 + 1;
            TYPE_ROBOT_TYPE_DEFAULT = i65;
            int i66 = i65 + 1;
            TYPE_FEATURED_GUILDS = i66;
            int i67 = i66 + 1;
            TYPE_POPULAR_LIVE = i67;
            int i68 = i67 + 1;
            TYPE_RECOMMENDED_GUILD = i68;
            int i69 = i68 + 1;
            TYPE_RECOMMENDED_LIVE = i69;
            int i75 = i69 + 1;
            TYPE_RECOMMENDED_VOICE = i75;
            int i76 = i75 + 1;
            TYPE_RECOMMENDED_FILE = i76;
            int i77 = i76 + 1;
            TYPE_RECOMMENDED_SCREEN_SHARE = i77;
            int i78 = i77 + 1;
            TYPE_RECOMMENDED_SCHEME = i78;
            int i79 = i78 + 1;
            TYPE_RECOMMENDED_FEED_TOPIC = i79;
            int i85 = i79 + 1;
            TYPE_RECOMMENDED_GUILD_FEEDS = i85;
            int i86 = i85 + 1;
            TYPE_MY_TAB_EMPTY = i86;
            int i87 = i86 + 1;
            TYPE_MY_TAB_END = i87;
            int i88 = i87 + 1;
            TYPE_RECOMMENDED_AD = i88;
            int i89 = i88 + 1;
            BASE_LINE = i89;
            TYPE_HORIZONTAL_SINGLE_GUILD = i89;
        }

        Companion() {
        }

        public final int A() {
            return TYPE_THIRD_VIDEO;
        }

        public final int B() {
            return TYPE_VIDEO_MIX;
        }

        public final int a() {
            return TYPE_ACTIVE;
        }

        public final int b() {
            return TYPE_CATEGORY_FEATURED;
        }

        public final int c() {
            return TYPE_CONFIG_BANNER;
        }

        public final int d() {
            return TYPE_CONFIG_DIVIDER;
        }

        public final int e() {
            return TYPE_CONFIG_SPACE;
        }

        public final int f() {
            return TYPE_FEATURED_GUILDS;
        }

        public final int g() {
            return TYPE_GROUP;
        }

        public final int h() {
            return TYPE_HORIZONTAL_SINGLE_GUILD;
        }

        public final int i() {
            return TYPE_LOAD_MORE;
        }

        public final int j() {
            return TYPE_MY_TAB_EMPTY;
        }

        public final int k() {
            return TYPE_MY_TAB_END;
        }

        public final int l() {
            return TYPE_PIC_MIX;
        }

        public final int m() {
            return TYPE_POPULAR_LIVE;
        }

        public final int n() {
            return TYPE_RECOMMENDED_AD;
        }

        public final int o() {
            return TYPE_RECOMMENDED_FEED_TOPIC;
        }

        public final int p() {
            return TYPE_RECOMMENDED_FILE;
        }

        public final int q() {
            return TYPE_RECOMMENDED_GUILD;
        }

        public final int r() {
            return TYPE_RECOMMENDED_GUILD_FEEDS;
        }

        public final int s() {
            return TYPE_RECOMMENDED_LIVE;
        }

        public final int t() {
            return TYPE_RECOMMENDED_SCHEME;
        }

        public final int u() {
            return TYPE_RECOMMENDED_SCREEN_SHARE;
        }

        public final int v() {
            return TYPE_RECOMMENDED_VOICE;
        }

        public final int w() {
            return TYPE_RECOMMEND_GUILDS;
        }

        public final int x() {
            return TYPE_ROBOT_TYPE_DEFAULT;
        }

        public final int y() {
            return TYPE_TEXT;
        }

        public final int z() {
            return TYPE_THIRD_SHARE_LINK;
        }
    }

    boolean areContentsTheSame(@NotNull h newItem);

    boolean areItemsTheSame(@NotNull h newItem);

    @Nullable
    Object getChangePayload(@NotNull h newItem);

    long getItemId();

    int getItemType();
}
