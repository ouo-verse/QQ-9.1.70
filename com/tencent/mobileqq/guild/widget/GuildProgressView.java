package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u0014\u0010+\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010\"R\u0014\u0010-\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\"\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildProgressView;", "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/theme/d;", "", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onThemeChanged", "Landroid/util/AttributeSet;", "d", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "value", "e", "I", "getTotal", "()I", "setTotal", "(I)V", "total", "f", HippyQQPagView.FunctionName.GET_PROGRESS, HippyQQPagView.FunctionName.SET_PROGRESS, "progress", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/graphics/drawable/Drawable;", "getProgressBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setProgressBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "progressBackgroundDrawable", "i", "getProgressDrawable", "setProgressDrawable", "progressDrawable", "a", "defaultBackgroundDrawable", "b", "defaultProgressDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProgressView extends View implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AttributeSet attrs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int progress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable progressBackgroundDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable progressDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProgressView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable a() {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.guild_progress_bg_drawable);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    private final Drawable b() {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.guild_progress_drawable);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    private final int c() {
        return (int) ((this.progress / this.total) * getWidth());
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildThemeManager.g(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildThemeManager.j(this);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.progressBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.progressBackgroundDrawable.draw(canvas);
        this.progressDrawable.setBounds(0, 0, c(), getHeight());
        this.progressDrawable.draw(canvas);
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.attrs, up1.a.J4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.GuildProgressView)");
        Drawable drawable = obtainStyledAttributes.getDrawable(up1.a.K4);
        if (drawable == null) {
            drawable = a();
        }
        this.progressBackgroundDrawable = drawable;
        Drawable drawable2 = obtainStyledAttributes.getDrawable(up1.a.M4);
        if (drawable2 == null) {
            drawable2 = b();
        }
        this.progressDrawable = drawable2;
        obtainStyledAttributes.recycle();
        invalidate();
    }

    public final void setProgress(int i3) {
        this.progress = i3;
        invalidate();
    }

    public final void setProgressBackgroundDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.progressBackgroundDrawable = drawable;
    }

    public final void setProgressDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.progressDrawable = drawable;
    }

    public final void setTotal(int i3) {
        this.total = i3;
        invalidate();
    }

    public /* synthetic */ GuildProgressView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.J4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.GuildProgressView)");
        setTotal(obtainStyledAttributes.getInt(up1.a.O4, 0));
        setProgress(obtainStyledAttributes.getInt(up1.a.L4, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(up1.a.K4);
        this.progressBackgroundDrawable = drawable == null ? a() : drawable;
        Drawable drawable2 = obtainStyledAttributes.getDrawable(up1.a.M4);
        this.progressDrawable = drawable2 == null ? b() : drawable2;
        obtainStyledAttributes.recycle();
    }
}
