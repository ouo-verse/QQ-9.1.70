package com.tencent.mobileqq.guild.media.gift;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/gift/GuildGiftCircleProgressView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/RectF;", "l", "", "progress", "", HippyQQPagView.FunctionName.SET_PROGRESS, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "mStokeWidthDp", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mProgressColor", "D", "Landroid/graphics/RectF;", "mOvalRect", "Landroid/graphics/Paint;", "E", "Landroid/graphics/Paint;", "mPaint", "mProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGiftCircleProgressView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private final int mProgressColor;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RectF mOvalRect;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: F, reason: from kotlin metadata */
    private float mProgress;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float mStokeWidthDp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGiftCircleProgressView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final RectF l() {
        RectF rectF = this.mOvalRect;
        if (rectF != null) {
            Intrinsics.checkNotNull(rectF);
            return rectF;
        }
        float f16 = this.mStokeWidthDp / 2;
        RectF rectF2 = new RectF(f16, f16, getWidth() - f16, getHeight() - f16);
        this.mOvalRect = rectF2;
        Intrinsics.checkNotNull(rectF2);
        return rectF2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawArc(l(), -90.0f, this.mProgress * 3.6f, false, this.mPaint);
        }
    }

    public final void setProgress(float progress) {
        boolean z16;
        float coerceAtMost;
        float coerceAtLeast;
        if (progress == this.mProgress) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(100.0f, progress);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0.0f, coerceAtMost);
            this.mProgress = coerceAtLeast;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGiftCircleProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        float dpToPx = ViewUtils.dpToPx(4.0f);
        this.mStokeWidthDp = dpToPx;
        int color = getResources().getColor(R.color.bn7);
        this.mProgressColor = color;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);
        paint.setStrokeWidth(dpToPx);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint = paint;
    }

    public /* synthetic */ GuildGiftCircleProgressView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
