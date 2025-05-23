package com.tencent.mobileqq.guild.util;

import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006J(\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bq;", "", "Landroid/widget/TextView;", "labelView", "", "character", "", "textColor", "bgRes", "", "b", "a", "d", "Landroid/graphics/drawable/GradientDrawable;", "e", "c", "I", "LEVEL_VIEW_PADDING", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bq {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bq f235472a = new bq();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int LEVEL_VIEW_PADDING = QQGuildUIUtil.f(3.0f);

    bq() {
    }

    public final void a(@NotNull TextView labelView, @NotNull String character) {
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(character, "character");
        b(labelView, character, R.color.guild_theme_collection_label_normal_text_color, R.drawable.guild_theme_collection_label_normal_bg);
    }

    public final void b(@NotNull TextView labelView, @NotNull String character, @ColorRes int textColor, @DrawableRes int bgRes) {
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(character, "character");
        int i3 = LEVEL_VIEW_PADDING;
        labelView.setPadding(i3, 0, i3, 0);
        labelView.setText(character);
        labelView.setTextColor(AppCompatResources.getColorStateList(labelView.getContext(), textColor));
        labelView.setBackgroundResource(bgRes);
    }

    public final void c(@NotNull TextView labelView, @NotNull String character) {
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(character, "character");
        d(labelView, character, R.color.bu_, R.drawable.guild_theme_collection_label_relationship_chain_bg);
    }

    public final void d(@NotNull TextView labelView, @NotNull String character, @ColorRes int textColor, @DrawableRes int bgRes) {
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(character, "character");
        int i3 = LEVEL_VIEW_PADDING;
        labelView.setPadding(i3, 0, i3, 0);
        labelView.setText(character);
        labelView.setTextColor(AppCompatResources.getColorStateList(labelView.getContext(), textColor));
        labelView.setBackgroundResource(bgRes);
    }

    public final void e(@NotNull TextView labelView, @NotNull String character, @ColorRes int textColor, @NotNull GradientDrawable bgRes) {
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(character, "character");
        Intrinsics.checkNotNullParameter(bgRes, "bgRes");
        int i3 = LEVEL_VIEW_PADDING;
        labelView.setPadding(i3, 0, i3, 0);
        labelView.setText(character);
        labelView.setTextColor(AppCompatResources.getColorStateList(labelView.getContext(), textColor));
        labelView.setBackground(bgRes);
    }
}
