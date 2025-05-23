package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/ThemeableImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/tencent/mobileqq/guild/theme/d;", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onThemeChanged", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNightTheme", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "nightDrawable", "D", "lightDrawable", "", "E", "I", "filterColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ThemeableImageView extends AppCompatImageView implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Drawable nightDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Drawable lightDrawable;

    /* renamed from: E, reason: from kotlin metadata */
    private int filterColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isNightTheme;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThemeableImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildThemeManager.h(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildThemeManager.j(this);
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        boolean b16 = GuildThemeManager.f235286a.b();
        if (this.isNightTheme.compareAndSet(!b16, b16)) {
            QLog.d("ThemeableImageView", 2, "update the current to " + b16);
            if (b16) {
                Drawable drawable = this.nightDrawable;
                if (drawable != null) {
                    setImageDrawable(drawable);
                }
            } else {
                Drawable drawable2 = this.lightDrawable;
                if (drawable2 != null) {
                    setImageDrawable(drawable2);
                }
            }
            if (this.filterColor != 0) {
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                Drawable drawable3 = getDrawable();
                Intrinsics.checkNotNullExpressionValue(drawable3, "drawable");
                guildUIUtils.F(drawable3, this.filterColor);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThemeableImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ThemeableImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThemeableImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isNightTheme = new AtomicBoolean(false);
        this.lightDrawable = getDrawable();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w12.a.f444363u7);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026eable.ThemeableImageView)");
        this.nightDrawable = obtainStyledAttributes.getDrawable(w12.a.f444381w7);
        int i16 = w12.a.f444372v7;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.filterColor = obtainStyledAttributes.getColor(i16, 0);
        }
        obtainStyledAttributes.recycle();
    }
}
