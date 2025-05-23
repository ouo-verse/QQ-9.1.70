package com.tencent.mobileqq.guild.discover.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R*\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010!\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/widget/GuildRoundBoardImageView;", "Lcom/tencent/widget/RoundRectImageView;", "", "a", "", "guildBoardWidth", "setGuildBoardWidth", "guildBoardColor", "setGuildBoardColor", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "getMTempRectF", "()Landroid/graphics/RectF;", "mTempRectF", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "boardPaint", "value", "f", "I", "getBoardWidth", "()I", "setBoardWidth", "(I)V", "boardWidth", h.F, "getBoardColor", "setBoardColor", "boardColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRoundBoardImageView extends RoundRectImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mTempRectF;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint boardPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int boardWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int boardColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRoundBoardImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        this.boardPaint.setAntiAlias(true);
        this.boardPaint.setStyle(Paint.Style.STROKE);
        this.boardPaint.setColor(this.boardColor);
        this.boardPaint.setStrokeWidth(this.boardWidth);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        float f16;
        int i3;
        super.onDraw(canvas);
        if (this.boardWidth != 0 && this.boardPaint.getColor() != 0) {
            float width = getWidth();
            float height = getHeight();
            float f17 = this.mRadius;
            float f18 = 2 * f17;
            if (canvas != null) {
                canvas.drawLine(f17, 0.0f, width - f17, 0.0f, this.boardPaint);
            }
            int i16 = this.mRoundMode;
            if (i16 != 1 && i16 != 3 && i16 != 4) {
                if (canvas != null) {
                    f16 = 0.0f;
                    canvas.drawLine(width - f17, 0.0f, width, 0.0f, this.boardPaint);
                } else {
                    f16 = 0.0f;
                }
                if (canvas != null) {
                    canvas.drawLine(width, 0.0f, width, f17, this.boardPaint);
                }
            } else {
                f16 = 0.0f;
                this.mTempRectF.set(width - f18, 0.0f, width, f18);
                if (canvas != null) {
                    canvas.drawArc(this.mTempRectF, -90.0f, 90.0f, false, this.boardPaint);
                }
            }
            if (canvas != null) {
                canvas.drawLine(width, f17, width, height - f17, this.boardPaint);
            }
            int i17 = this.mRoundMode;
            if (i17 != 1 && i17 != 5 && i17 != 4) {
                if (canvas != null) {
                    i3 = 5;
                    canvas.drawLine(width, height - f17, width, height, this.boardPaint);
                } else {
                    i3 = 5;
                }
                if (canvas != null) {
                    canvas.drawLine(width, height, width - f17, height, this.boardPaint);
                }
            } else {
                i3 = 5;
                this.mTempRectF.set(width - f18, height - f18, width, height);
                if (canvas != null) {
                    canvas.drawArc(this.mTempRectF, 0.0f, 90.0f, false, this.boardPaint);
                }
            }
            if (canvas != null) {
                canvas.drawLine(width - f17, height, f17, height, this.boardPaint);
            }
            int i18 = this.mRoundMode;
            if (i18 != 1 && i18 != i3 && i18 != 2) {
                if (canvas != null) {
                    canvas.drawLine(f17, height, 0.0f, height, this.boardPaint);
                }
                if (canvas != null) {
                    canvas.drawLine(0.0f, height, 0.0f, height - f17, this.boardPaint);
                }
            } else {
                this.mTempRectF.set(f16, height - f18, f18, height);
                if (canvas != null) {
                    canvas.drawArc(this.mTempRectF, 90.0f, 90.0f, false, this.boardPaint);
                }
            }
            if (canvas != null) {
                canvas.drawLine(0.0f, height - f17, 0.0f, f17, this.boardPaint);
            }
            int i19 = this.mRoundMode;
            if (i19 != 1 && i19 != 3 && i19 != 2) {
                if (canvas != null) {
                    canvas.drawLine(0.0f, f17, 0.0f, 0.0f, this.boardPaint);
                }
                if (canvas != null) {
                    canvas.drawLine(0.0f, 0.0f, f17, 0.0f, this.boardPaint);
                    return;
                }
                return;
            }
            this.mTempRectF.set(f16, f16, f18, f18);
            if (canvas != null) {
                canvas.drawArc(this.mTempRectF, 180.0f, 90.0f, false, this.boardPaint);
            }
        }
    }

    public final void setBoardColor(int i3) {
        this.boardColor = i3;
        postInvalidate();
    }

    public final void setBoardWidth(int i3) {
        this.boardWidth = i3;
        postInvalidate();
    }

    public final void setGuildBoardColor(int guildBoardColor) {
        setBoardColor(guildBoardColor);
    }

    public final void setGuildBoardWidth(int guildBoardWidth) {
        setBoardWidth(guildBoardWidth);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRoundBoardImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildRoundBoardImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRoundBoardImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTempRectF = new RectF();
        this.boardPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.S4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026GuildRoundBoardImageView)");
        setBoardWidth(obtainStyledAttributes.getDimensionPixelSize(up1.a.U4, 0));
        setBoardColor(obtainStyledAttributes.getColor(up1.a.T4, 0));
        obtainStyledAttributes.recycle();
        a();
    }
}
