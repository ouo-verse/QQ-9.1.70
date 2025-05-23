package com.tencent.icgame.game.ui.progress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0015R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006&"}, d2 = {"Lcom/tencent/icgame/game/ui/progress/RectangleProgressBar;", "Landroid/view/View;", "", "a", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "bgColor", "progressColor", "setColors", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "I", "mProgress", "e", "mBackgroundColor", "f", "mProgressColor", "", h.F, UserInfo.SEX_FEMALE, "mBackgroundRadius", "i", "mProgressRadius", "Landroid/graphics/Paint;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "mPaint", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class RectangleProgressBar extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mBackgroundColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mProgressColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mBackgroundRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mProgressRadius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RectangleProgressBar(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void a() {
        if (this.mProgress > 100) {
            this.mProgress = 100;
        }
        if (this.mProgress < 0) {
            this.mProgress = 0;
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width != 0 && height != 0 && canvas != null) {
            this.mPaint.setColor(this.mBackgroundColor);
            RectF rectF = new RectF(0.0f, 0.0f, getRight() - getLeft(), getBottom() - getTop());
            float f16 = this.mBackgroundRadius;
            canvas.drawRoundRect(rectF, f16, f16, this.mPaint);
            g.h("ICGameRectangleProgressBar_", "onDraw width:" + width + ", height:" + height + ", progress:" + this.mProgress + ", bg rectF:" + rectF);
            float f17 = ((float) width) * ((((float) this.mProgress) * 1.0f) / ((float) 100));
            this.mPaint.setColor(this.mProgressColor);
            RectF rectF2 = new RectF(0.0f, 0.0f, f17, ((float) getBottom()) - ((float) getTop()));
            float f18 = this.mProgressRadius;
            canvas.drawRoundRect(rectF2, f18, f18, this.mPaint);
            g.h("ICGameRectangleProgressBar_", "onDraw width:" + width + ", height:" + height + ", progress:" + this.mProgress + ", progress rectF:" + rectF2);
            return;
        }
        g.d("ICGameRectangleProgressBar_", "onDraw width or height is 0");
    }

    public final void setColors(int bgColor, int progressColor) {
        this.mBackgroundColor = bgColor;
        this.mProgressColor = progressColor;
    }

    public final void setProgress(int progress) {
        this.mProgress = progress;
        a();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RectangleProgressBar(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ RectangleProgressBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RectangleProgressBar(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.mBackgroundColor = Color.parseColor("#FF411FB1");
        this.mProgressColor = Color.parseColor("#FFFFE500");
        this.mBackgroundRadius = 1.0f;
        this.mProgressRadius = 1.0f;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        this.mPaint = paint;
    }
}
