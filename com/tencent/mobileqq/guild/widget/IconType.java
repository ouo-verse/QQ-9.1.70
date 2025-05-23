package com.tencent.mobileqq.guild.widget;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'THREE_DOTS_SETTING' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/IconType;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "Lcom/tencent/mobileqq/guild/widget/ClickType;", "iconRes", "", "hasRedDot", "", "appendRes", "(Ljava/lang/String;ILcom/tencent/mobileqq/guild/widget/ClickType;IZI)V", "getAppendRes", "()I", "getClickType", "()Lcom/tencent/mobileqq/guild/widget/ClickType;", "getHasRedDot", "()Z", "getIconRes", "SHARE", "THREE_DOTS_SETTING", "THREE_LINES_SETTING", "THREE_LINES_SETTING_RED_DOT", "BACK", "HEXAGON_SETTING", "QUIT", "SCALE", "FULL_SCREEN", "MINIMIZE_SCREEN", "RANKING_LIST", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class IconType {
    public static final IconType BACK;
    public static final IconType FULL_SCREEN;
    public static final IconType HEXAGON_SETTING;
    public static final IconType MINIMIZE_SCREEN;
    public static final IconType QUIT;
    public static final IconType RANKING_LIST;
    public static final IconType SCALE;
    public static final IconType THREE_DOTS_SETTING;
    public static final IconType THREE_LINES_SETTING;
    public static final IconType THREE_LINES_SETTING_RED_DOT;
    private final int appendRes;

    @NotNull
    private final ClickType clickType;
    private final boolean hasRedDot;
    private final int iconRes;
    public static final IconType SHARE = new IconType("SHARE", 0, ClickType.SHARE, R.drawable.guild_share_white, false, 0, 12, null);
    private static final /* synthetic */ IconType[] $VALUES = $values();

    private static final /* synthetic */ IconType[] $values() {
        return new IconType[]{SHARE, THREE_DOTS_SETTING, THREE_LINES_SETTING, THREE_LINES_SETTING_RED_DOT, BACK, HEXAGON_SETTING, QUIT, SCALE, FULL_SCREEN, MINIMIZE_SCREEN, RANKING_LIST};
    }

    static {
        int i3 = 0;
        DefaultConstructorMarker defaultConstructorMarker = null;
        THREE_DOTS_SETTING = new IconType("THREE_DOTS_SETTING", 1, ClickType.THREE_DOTS_SETTING, R.drawable.guild_three_dots_setting_white, false, i3, 12, defaultConstructorMarker);
        int i16 = 0;
        int i17 = 12;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        THREE_LINES_SETTING = new IconType("THREE_LINES_SETTING", 2, ClickType.THREE_LINES_SETTING, R.drawable.guild_three_lines_setting_white, 0 == true ? 1 : 0, i16, i17, defaultConstructorMarker2);
        THREE_LINES_SETTING_RED_DOT = new IconType("THREE_LINES_SETTING_RED_DOT", 3, ClickType.THREE_LINES_SETTING_RED_DOT, R.drawable.guild_three_lines_setting_white, true, i3, 8, defaultConstructorMarker);
        BACK = new IconType("BACK", 4, ClickType.BACK, R.drawable.guild_left_arrow_white, 0 == true ? 1 : 0, i16, i17, defaultConstructorMarker2);
        boolean z16 = false;
        int i18 = 12;
        HEXAGON_SETTING = new IconType("HEXAGON_SETTING", 5, ClickType.HEXAGON_SETTING, R.drawable.guild_hexagon_setting_white, z16, i3, i18, defaultConstructorMarker);
        QUIT = new IconType("QUIT", 6, ClickType.QUIT, R.drawable.guild_quit_white, 0 == true ? 1 : 0, i16, i17, defaultConstructorMarker2);
        SCALE = new IconType("SCALE", 7, ClickType.SCALE, R.drawable.guild_scale_arrow_white, z16, i3, i18, defaultConstructorMarker);
        FULL_SCREEN = new IconType("FULL_SCREEN", 8, ClickType.FULL_SCREEN, R.drawable.guild_full_screen_white, 0 == true ? 1 : 0, i16, i17, defaultConstructorMarker2);
        MINIMIZE_SCREEN = new IconType("MINIMIZE_SCREEN", 9, ClickType.MINIMIZE_SCREEN, R.drawable.guild_minimize_screen_white, z16, i3, i18, defaultConstructorMarker);
        RANKING_LIST = new IconType("RANKING_LIST", 10, ClickType.RANKING_LIST, R.drawable.guild_ranking_list, 0 == true ? 1 : 0, i16, i17, defaultConstructorMarker2);
    }

    IconType(String str, int i3, ClickType clickType, int i16, boolean z16, int i17) {
        this.clickType = clickType;
        this.iconRes = i16;
        this.hasRedDot = z16;
        this.appendRes = i17;
    }

    public static IconType valueOf(String str) {
        return (IconType) Enum.valueOf(IconType.class, str);
    }

    public static IconType[] values() {
        return (IconType[]) $VALUES.clone();
    }

    public final int getAppendRes() {
        return this.appendRes;
    }

    @NotNull
    public final ClickType getClickType() {
        return this.clickType;
    }

    public final boolean getHasRedDot() {
        return this.hasRedDot;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    /* synthetic */ IconType(String str, int i3, ClickType clickType, int i16, boolean z16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, clickType, i16, (i18 & 4) != 0 ? false : z16, (i18 & 8) != 0 ? -1 : i17);
    }
}
