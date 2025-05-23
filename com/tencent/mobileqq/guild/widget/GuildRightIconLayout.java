package com.tencent.mobileqq.guild.widget;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\u001d\u0010!B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b\u001d\u0010$B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b\u001d\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "d", "Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "titleBarTheme", "Lcom/tencent/mobileqq/guild/widget/IconType;", "iconType", "setIconRes", "a", "e", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "setOriginIconView", "(Landroid/widget/ImageView;)V", "originIconView", "Landroid/view/View;", "Landroid/view/View;", "c", "()Landroid/view/View;", "setRedDotView", "(Landroid/view/View;)V", "redDotView", "f", "Lcom/tencent/mobileqq/guild/widget/IconType;", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", tl.h.F, "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRightIconLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView originIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public View redDotView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IconType iconType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildRightIconLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f4m, this);
        View findViewById = findViewById(R.id.f2150017);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.origin_icon)");
        setOriginIconView((ImageView) findViewById);
        View findViewById2 = findViewById(R.id.f72053pt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.red_dot_icon)");
        setRedDotView(findViewById2);
        if (Build.VERSION.SDK_INT >= 26) {
            b().setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final IconType getIconType() {
        return this.iconType;
    }

    @NotNull
    public final ImageView b() {
        ImageView imageView = this.originIconView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("originIconView");
        return null;
    }

    @NotNull
    public final View c() {
        View view = this.redDotView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("redDotView");
        return null;
    }

    public final void e(@NotNull TitleBarTheme titleBarTheme) {
        Intrinsics.checkNotNullParameter(titleBarTheme, "titleBarTheme");
        IconType iconType = this.iconType;
        if (iconType != null) {
            ImageView b16 = b();
            IconType iconType2 = this.iconType;
            Intrinsics.checkNotNull(iconType2);
            h.a(b16, titleBarTheme, iconType2);
            if (iconType.getAppendRes() > 0) {
                b().setImageDrawable(new LayerDrawable(new Drawable[]{b().getDrawable(), ResourcesCompat.getDrawable(getContext().getResources(), iconType.getAppendRes(), null)}));
            }
        }
    }

    public final void setIconRes(@NotNull TitleBarTheme titleBarTheme, @NotNull IconType iconType) {
        Intrinsics.checkNotNullParameter(titleBarTheme, "titleBarTheme");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        this.iconType = iconType;
        setTag(R.id.x2g, iconType.getClickType());
        h.a(b(), titleBarTheme, iconType);
        int i3 = 0;
        if (iconType.getAppendRes() > 0) {
            b().setImageDrawable(new LayerDrawable(new Drawable[]{b().getDrawable(), ResourcesCompat.getDrawable(getContext().getResources(), iconType.getAppendRes(), null)}));
        }
        View c16 = c();
        if (!iconType.getHasRedDot()) {
            i3 = 8;
        }
        c16.setVisibility(i3);
    }

    public final void setOriginIconView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.originIconView = imageView;
    }

    public final void setRedDotView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.redDotView = view;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildRightIconLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildRightIconLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRightIconLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        d(context);
    }
}
