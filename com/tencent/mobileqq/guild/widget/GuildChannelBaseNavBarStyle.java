package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildChannelBaseNavBarStyle;", "", "(Ljava/lang/String;I)V", "getCenterIconDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawableId", "", "getQuiColor", "tokenResId", "themeId", "getTextColor", "setLeftIcon", "", "iconView", "Landroid/widget/ImageView;", "STYLE_SKIN", "STYLE_NIGHT", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GuildChannelBaseNavBarStyle {
    STYLE_SKIN,
    STYLE_NIGHT;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235821a;

        static {
            int[] iArr = new int[GuildChannelBaseNavBarStyle.values().length];
            try {
                iArr[GuildChannelBaseNavBarStyle.STYLE_SKIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildChannelBaseNavBarStyle.STYLE_NIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f235821a = iArr;
        }
    }

    private final int getQuiColor(Context context, int tokenResId, int themeId) {
        return ie0.a.f().g(context, tokenResId, themeId);
    }

    @Nullable
    public final Drawable getCenterIconDrawable(@NotNull Context context, int drawableId) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = a.f235821a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return GuildUIUtils.y(context, drawableId, getQuiColor(context, R.color.qui_common_icon_tertiary, 1002));
            }
            throw new NoWhenBranchMatchedException();
        }
        return GuildUIUtils.w(context, drawableId, Integer.valueOf(R.color.qui_common_icon_tertiary));
    }

    public final int getTextColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = a.f235821a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return getQuiColor(context, R.color.qui_common_text_primary, 1002);
            }
            throw new NoWhenBranchMatchedException();
        }
        return getQuiColor(context, R.color.qui_common_text_primary, 1000);
    }

    public final void setLeftIcon(@NotNull Context context, @NotNull ImageView iconView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        int i3 = a.f235821a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                iconView.setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_skin_top_back_left_icon, getQuiColor(context, R.color.qui_common_icon_primary, 1002)));
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
        iconView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_skin_top_back_left_icon, Integer.valueOf(R.color.qui_common_icon_primary)));
    }
}
