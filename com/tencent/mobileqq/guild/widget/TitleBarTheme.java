package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "", "(Ljava/lang/String;I)V", "getBottomTextColor", "", "context", "Landroid/content/Context;", "getDisturbColor", "getIconColor", "getQuiColor", "tokenResId", "themeId", "getTopTextColor", "getUnreadBackgroundColor", "setBackground", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "setJoinButtonColor", "textView", "Landroid/widget/TextView;", "TITLE_BAR_STYLE_01", "TITLE_BAR_STYLE_02", "TITLE_BAR_STYLE_03", "TITLE_BAR_STYLE_04", "TITLE_BAR_STYLE_05", "TITLE_BAR_STYLE_06", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum TitleBarTheme {
    TITLE_BAR_STYLE_01,
    TITLE_BAR_STYLE_02,
    TITLE_BAR_STYLE_03,
    TITLE_BAR_STYLE_04,
    TITLE_BAR_STYLE_05,
    TITLE_BAR_STYLE_06;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236168a;

        static {
            int[] iArr = new int[TitleBarTheme.values().length];
            try {
                iArr[TitleBarTheme.TITLE_BAR_STYLE_01.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TitleBarTheme.TITLE_BAR_STYLE_02.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TitleBarTheme.TITLE_BAR_STYLE_03.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TitleBarTheme.TITLE_BAR_STYLE_04.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TitleBarTheme.TITLE_BAR_STYLE_05.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TitleBarTheme.TITLE_BAR_STYLE_06.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f236168a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/widget/TitleBarTheme$b", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "type", "themeId", tl.h.F, "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ee0.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@NotNull Context context, int buttonType, int sizeType) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (sizeType != 3) {
                return bi.b(100);
            }
            return super.f(context, buttonType, sizeType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int h(@NotNull Context context, int type, int sizeType, int themeId) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (type == 2) {
                return bi.a(0.5f);
            }
            return super.h(context, type, sizeType, themeId);
        }
    }

    private final int getQuiColor(Context context, int tokenResId, int themeId) {
        return ie0.a.f().g(context, tokenResId, themeId);
    }

    public final int getBottomTextColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (a.f236168a[ordinal()]) {
            case 1:
                return getQuiColor(context, R.color.qui_common_feedback_normal, 1000);
            case 2:
                return getQuiColor(context, R.color.qui_common_feedback_normal, 1002);
            case 3:
                return getQuiColor(context, R.color.qui_common_feedback_normal, 1000);
            case 4:
                return getQuiColor(context, R.color.qui_common_feedback_normal, 1002);
            case 5:
                return getQuiColor(context, R.color.qui_common_feedback_normal, 1001);
            case 6:
                return getQuiColor(context, R.color.qui_common_feedback_normal, 1000);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getDisturbColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (a.f236168a[ordinal()]) {
            case 1:
                if (QQTheme.isNowSimpleUI()) {
                    return getQuiColor(context, R.color.qui_common_icon_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_icon_tertiary, 1000);
            case 2:
                return getQuiColor(context, R.color.qui_common_icon_tertiary, 1002);
            case 3:
                return getQuiColor(context, R.color.qui_common_icon_tertiary, 1000);
            case 4:
            case 5:
                return 0;
            case 6:
                return getQuiColor(context, R.color.qui_common_icon_tertiary, 1000);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getIconColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (a.f236168a[ordinal()]) {
            case 1:
                if (QQTheme.isNowSimpleUI()) {
                    return getQuiColor(context, R.color.qui_common_icon_nav_primary, 1000);
                }
                if (QQTheme.isVasTheme()) {
                    return getQuiColor(context, R.color.qui_common_icon_nav_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_icon_primary, 1000);
            case 2:
                return Color.parseColor("#FFC6C6CA");
            case 3:
                if (QQTheme.isVasTheme()) {
                    return getQuiColor(context, R.color.qui_common_icon_nav_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_icon_primary, 1000);
            case 4:
                return -1;
            case 5:
                return Color.parseColor("#262626");
            case 6:
                if (QQTheme.isVasTheme()) {
                    return getQuiColor(context, R.color.qui_common_icon_nav_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_icon_primary, 1000);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getTopTextColor(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        switch (a.f236168a[ordinal()]) {
            case 1:
                if (QQTheme.isNowSimpleUI()) {
                    return getQuiColor(context, R.color.qui_common_text_nav_primary, 1000);
                }
                if (QQTheme.isVasTheme()) {
                    return getQuiColor(context, R.color.qui_common_text_nav_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_text_primary, 1000);
            case 2:
                return Color.parseColor("#FFF0F0F4");
            case 3:
                if (QQTheme.isVasTheme()) {
                    return getQuiColor(context, R.color.qui_common_text_nav_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_text_primary, 1000);
            case 4:
                if (QQTheme.isNowThemeIsNight()) {
                    str = "#E8E9EA";
                } else {
                    str = "#FFFFFF";
                }
                return Color.parseColor(str);
            case 5:
                return Color.parseColor("#222222");
            case 6:
                if (QQTheme.isVasTheme()) {
                    return getQuiColor(context, R.color.qui_common_text_nav_secondary, 1000);
                }
                return getQuiColor(context, R.color.qui_common_text_primary, 1000);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getUnreadBackgroundColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (a.f236168a[ordinal()]) {
            case 1:
                return getQuiColor(context, R.color.qui_common_fill_standard_secondary, 1000);
            case 2:
                return getQuiColor(context, R.color.qui_common_fill_standard_secondary, 1002);
            case 3:
                return getQuiColor(context, R.color.qui_common_fill_standard_secondary, 1000);
            case 4:
            case 5:
                return 0;
            case 6:
                return getQuiColor(context, R.color.qui_common_fill_standard_secondary, 1000);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void setBackground(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        rootView.setBackgroundColor(0);
    }

    public final void setJoinButtonColor(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (a.f236168a[ordinal()] == 2) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            textView.setTextColor(getQuiColor(context, R.color.qui_button_text_primary_default, 1002));
            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
            Context context2 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "textView.context");
            int quiColor = getQuiColor(context2, R.color.qui_button_bg_primary_default, 1002);
            Context context3 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "textView.context");
            textView.setBackground(guildUIUtils.l(quiColor, getQuiColor(context3, R.color.qui_button_bg_primary_pressed, 1002), 100.0f));
            return;
        }
        Context context4 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "textView.context");
        textView.setTextColor(getQuiColor(context4, R.color.qui_button_text_primary_default, 1000));
        textView.setBackground(new b().a(textView.getContext(), 0, 2, 1000));
    }
}
