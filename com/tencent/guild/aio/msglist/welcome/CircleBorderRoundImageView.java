package com.tencent.guild.aio.msglist.welcome;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.widget.RoundImageView;
import fn0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00132\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u001c\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/CircleBorderRoundImageView;", "Lcom/tencent/mobileqq/widget/RoundImageView;", "", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "", "radius", "color", "c", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "setCustomAttributes", "onDraw", "Landroid/content/Context;", "D", "Landroid/content/Context;", "mContext", "E", "I", "mBorderThickness", UserInfo.SEX_FEMALE, "defaultWidth", "G", "defaultHeight", "H", "mBorderInsideColor", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class CircleBorderRoundImageView extends RoundImageView {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: E, reason: from kotlin metadata */
    private int mBorderThickness;

    /* renamed from: F, reason: from kotlin metadata */
    private int defaultWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private int defaultHeight;

    /* renamed from: H, reason: from kotlin metadata */
    private int mBorderInsideColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleBorderRoundImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        d();
    }

    private final void c(Canvas canvas, int radius, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.mBorderThickness);
        canvas.drawCircle(this.defaultWidth / 2, this.defaultHeight / 2, radius, paint);
    }

    private final void d() {
        this.mBorderThickness = 2;
        this.mBorderInsideColor = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.RoundImageView, android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.defaultWidth == 0) {
            this.defaultWidth = getWidth();
        }
        if (this.defaultHeight == 0) {
            this.defaultHeight = getHeight();
        }
        int min = Math.min(this.defaultWidth, this.defaultHeight) / 2;
        int i3 = this.mBorderThickness;
        c(canvas, (min - i3) + (i3 / 2), this.mBorderInsideColor);
    }

    public final void setCustomAttributes(@Nullable AttributeSet attrs) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attrs, e.Y);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "mContext.obtainStyledAtt\u2026rcleBorderRoundImageView)");
        this.mBorderThickness = obtainStyledAttributes.getDimensionPixelSize(e.f399897a0, 0);
        this.mBorderInsideColor = obtainStyledAttributes.getColor(e.Z, -1);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleBorderRoundImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        setCustomAttributes(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleBorderRoundImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        setCustomAttributes(attributeSet);
    }
}
