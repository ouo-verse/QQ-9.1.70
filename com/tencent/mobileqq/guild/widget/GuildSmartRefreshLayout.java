package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshContent;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSmartRefreshLayout;", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "Lcom/tencent/theme/SkinnableView;", "", "color", "", "b", "a", "colorRes", "setRefreshHeaderBackgroundColorResId", "onThemeChanged", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "refreshHeaderBackgroundPaint", "Landroid/content/res/ColorStateList;", "e", "Landroid/content/res/ColorStateList;", "refreshHeaderBackgroundColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSmartRefreshLayout extends SmartRefreshLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Paint refreshHeaderBackgroundPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ColorStateList refreshHeaderBackgroundColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSmartRefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setWillNotDraw(false);
    }

    private final void b(int color) {
        Paint paint = this.refreshHeaderBackgroundPaint;
        if (paint == null) {
            paint = new Paint();
        }
        paint.setColor(color);
        this.refreshHeaderBackgroundPaint = paint;
        invalidate();
    }

    public final void a() {
        this.refreshHeaderBackgroundPaint = null;
        this.refreshHeaderBackgroundColor = null;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        float f16;
        Paint paint;
        View view;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        IRefreshContent iRefreshContent = this.mRefreshContent;
        if (iRefreshContent != null && (view = iRefreshContent.getView()) != null) {
            f16 = view.getY();
        } else {
            f16 = 0.0f;
        }
        if (f16 > 0.0f && (paint = this.refreshHeaderBackgroundPaint) != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), f16, paint);
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        ColorStateList colorStateList = this.refreshHeaderBackgroundColor;
        if (colorStateList != null) {
            b(colorStateList.getDefaultColor());
        }
    }

    public final void setRefreshHeaderBackgroundColorResId(int colorRes) {
        ColorStateList colorStateList = getResources().getColorStateList(colorRes);
        b(colorStateList.getDefaultColor());
        this.refreshHeaderBackgroundColor = colorStateList;
    }
}
