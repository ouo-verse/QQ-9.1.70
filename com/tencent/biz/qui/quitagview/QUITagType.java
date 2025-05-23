package com.tencent.biz.qui.quitagview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qui/quitagview/QUITagType;", "", "(Ljava/lang/String;I)V", "createBgDrawable", "Landroid/graphics/drawable/Drawable;", "fillColor", "Landroid/content/res/ColorStateList;", "strokeColor", "corner", "", "getBgDrawable", "context", "Landroid/content/Context;", "cornerRadius", "getBgDrawable$QUITagView_debug", "getIconColor", "getIconColor$QUITagView_debug", "getTextColor", "getTextColor$QUITagView_debug", "FILL", "BORDER", "COLOR_BLUE", "COLOR_NAVY_BLUE", "COLOR_PURPLE", "COLOR_GREEN", "COLOR_PINK", "COLOR_RED", "COLOR_ORANGE", "COLOR_YELLOW", "QUITagView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public enum QUITagType {
    FILL,
    BORDER,
    COLOR_BLUE,
    COLOR_NAVY_BLUE,
    COLOR_PURPLE,
    COLOR_GREEN,
    COLOR_PINK,
    COLOR_RED,
    COLOR_ORANGE,
    COLOR_YELLOW;

    private final Drawable createBgDrawable(ColorStateList fillColor, ColorStateList strokeColor, float corner) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (fillColor != null) {
            gradientDrawable.setColor(fillColor);
        }
        if (strokeColor != null) {
            gradientDrawable.setStroke(e.c(1.0f), strokeColor);
        }
        gradientDrawable.setCornerRadius(e.c(corner));
        return gradientDrawable;
    }

    @NotNull
    public final Drawable getBgDrawable$QUITagView_debug(@NotNull Context context, float cornerRadius) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = b.f95342c[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return createBgDrawable(getTextColor$QUITagView_debug(context).withAlpha(26), null, cornerRadius);
            }
            return createBgDrawable(null, context.getResources().getColorStateList(R.color.qui_common_border_standard), cornerRadius);
        }
        return createBgDrawable(context.getResources().getColorStateList(R.color.qui_common_fill_standard_primary), null, cornerRadius);
    }

    @NotNull
    public final ColorStateList getIconColor$QUITagView_debug(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = b.f95341b[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return getTextColor$QUITagView_debug(context);
            }
            ColorStateList colorStateList = context.getResources().getColorStateList(R.color.qui_common_icon_primary);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getCol\u2026.qui_common_icon_primary)");
            return colorStateList;
        }
        ColorStateList colorStateList2 = context.getResources().getColorStateList(R.color.qui_common_icon_secondary);
        Intrinsics.checkNotNullExpressionValue(colorStateList2, "context.resources.getCol\u2026ui_common_icon_secondary)");
        return colorStateList2;
    }

    @NotNull
    public final ColorStateList getTextColor$QUITagView_debug(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (b.f95340a[ordinal()]) {
            case 1:
                ColorStateList colorStateList = context.getResources().getColorStateList(R.color.qui_common_text_secondary);
                Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getCol\u2026ui_common_text_secondary)");
                return colorStateList;
            case 2:
                ColorStateList colorStateList2 = context.getResources().getColorStateList(R.color.qui_common_text_primary);
                Intrinsics.checkNotNullExpressionValue(colorStateList2, "context.resources.getCol\u2026.qui_common_text_primary)");
                return colorStateList2;
            case 3:
                ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor("#0099ff"));
                Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(C\u2026or.parseColor(\"#0099ff\"))");
                return valueOf;
            case 4:
                ColorStateList valueOf2 = ColorStateList.valueOf(Color.parseColor("#0066CC"));
                Intrinsics.checkNotNullExpressionValue(valueOf2, "ColorStateList.valueOf(C\u2026or.parseColor(\"#0066CC\"))");
                return valueOf2;
            case 5:
                ColorStateList valueOf3 = ColorStateList.valueOf(Color.parseColor("#8566FF"));
                Intrinsics.checkNotNullExpressionValue(valueOf3, "ColorStateList.valueOf(C\u2026or.parseColor(\"#8566FF\"))");
                return valueOf3;
            case 6:
                ColorStateList valueOf4 = ColorStateList.valueOf(Color.parseColor("#15D173"));
                Intrinsics.checkNotNullExpressionValue(valueOf4, "ColorStateList.valueOf(C\u2026or.parseColor(\"#15D173\"))");
                return valueOf4;
            case 7:
                ColorStateList valueOf5 = ColorStateList.valueOf(Color.parseColor("#FF66B3"));
                Intrinsics.checkNotNullExpressionValue(valueOf5, "ColorStateList.valueOf(C\u2026or.parseColor(\"#FF66B3\"))");
                return valueOf5;
            case 8:
                ColorStateList valueOf6 = ColorStateList.valueOf(Color.parseColor("#FF5967"));
                Intrinsics.checkNotNullExpressionValue(valueOf6, "ColorStateList.valueOf(C\u2026or.parseColor(\"#FF5967\"))");
                return valueOf6;
            case 9:
                ColorStateList valueOf7 = ColorStateList.valueOf(Color.parseColor("#FF8D40"));
                Intrinsics.checkNotNullExpressionValue(valueOf7, "ColorStateList.valueOf(C\u2026or.parseColor(\"#FF8D40\"))");
                return valueOf7;
            case 10:
                ColorStateList valueOf8 = ColorStateList.valueOf(Color.parseColor("#FFB300"));
                Intrinsics.checkNotNullExpressionValue(valueOf8, "ColorStateList.valueOf(C\u2026or.parseColor(\"#FFB300\"))");
                return valueOf8;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
