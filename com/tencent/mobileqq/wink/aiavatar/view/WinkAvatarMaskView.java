package com.tencent.mobileqq.wink.aiavatar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u0004\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R*\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010$\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u0014\u0010&\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0011R\u0014\u0010(\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0011R*\u00100\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00104\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R*\u00108\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010+\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarMaskView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "clipLength", "", "c", "b", "a", "onDraw", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "shadowPaint", "f", "I", "cornerMaskShowColor", h.F, "cornerMaskHideColor", "i", "cornerMaskColor", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getAnchorBarStrokeWidthPx", "()I", "setAnchorBarStrokeWidthPx", "(I)V", "anchorBarStrokeWidthPx", BdhLogUtil.LogTag.Tag_Conn, "getCircleStrokeWidthPx", "setCircleStrokeWidthPx", "circleStrokeWidthPx", "D", "circlePaint", "E", "anchorBarPaint", "", UserInfo.SEX_FEMALE, "Z", "getShowCornerMask", "()Z", "setShowCornerMask", "(Z)V", "showCornerMask", "G", "getShowCircleBorder", "setShowCircleBorder", "showCircleBorder", "H", "getShowAnchorBar", "setShowAnchorBar", "showAnchorBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAvatarMaskView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private int circleStrokeWidthPx;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Paint circlePaint;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Paint anchorBarPaint;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean showCornerMask;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean showCircleBorder;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showAnchorBar;

    @NotNull
    public Map<Integer, View> I;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF drawRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint shadowPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int cornerMaskShowColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int cornerMaskHideColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int cornerMaskColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int anchorBarStrokeWidthPx;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarMaskView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Canvas canvas, int clipLength) {
        if (this.showAnchorBar) {
            float strokeWidth = (clipLength * 0.5f) - (this.anchorBarPaint.getStrokeWidth() * 0.5f);
            float dpToPx = ViewUtils.dpToPx(20.0f) * 0.5f;
            canvas.drawLine(this.drawRect.centerX() + strokeWidth, this.drawRect.centerY() - dpToPx, this.drawRect.centerX() + strokeWidth, this.drawRect.centerY() + dpToPx, this.anchorBarPaint);
            canvas.drawLine(this.drawRect.centerX() - strokeWidth, this.drawRect.centerY() - dpToPx, this.drawRect.centerX() - strokeWidth, this.drawRect.centerY() + dpToPx, this.anchorBarPaint);
            canvas.drawLine(this.drawRect.centerX() - dpToPx, this.drawRect.centerY() - strokeWidth, this.drawRect.centerX() + dpToPx, this.drawRect.centerY() - strokeWidth, this.anchorBarPaint);
            canvas.drawLine(this.drawRect.centerX() - dpToPx, this.drawRect.centerY() + strokeWidth, this.drawRect.centerX() + dpToPx, this.drawRect.centerY() + strokeWidth, this.anchorBarPaint);
        }
    }

    private final void b(Canvas canvas, int clipLength) {
        if (this.showCircleBorder) {
            canvas.drawCircle(this.drawRect.centerX(), this.drawRect.centerY(), (clipLength * 0.5f) - (this.anchorBarPaint.getStrokeWidth() * 0.5f), this.circlePaint);
        }
    }

    private final void c(Canvas canvas, int clipLength) {
        if (this.showCornerMask) {
            return;
        }
        float strokeWidth = this.anchorBarPaint.getStrokeWidth() * 0.5f;
        RectF rectF = new RectF(this.drawRect);
        rectF.inset(strokeWidth, strokeWidth);
        Path path = new Path();
        RectF rectF2 = this.drawRect;
        path.moveTo(rectF2.right - strokeWidth, rectF2.centerY());
        path.addArc(rectF, 0.0f, -360.0f);
        RectF rectF3 = this.drawRect;
        path.moveTo(rectF3.right, rectF3.centerY());
        RectF rectF4 = this.drawRect;
        path.lineTo(rectF4.right, rectF4.bottom);
        RectF rectF5 = this.drawRect;
        path.lineTo(rectF5.left, rectF5.bottom);
        RectF rectF6 = this.drawRect;
        path.lineTo(rectF6.left, rectF6.top);
        RectF rectF7 = this.drawRect;
        path.lineTo(rectF7.right, rectF7.top);
        RectF rectF8 = this.drawRect;
        path.moveTo(rectF8.right, rectF8.centerY());
        path.close();
        this.shadowPaint.setColor(this.cornerMaskColor);
        canvas.drawPath(path, this.shadowPaint);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int min = Math.min(getWidth(), getHeight());
        this.drawRect.left = (getWidth() - min) / 2.0f;
        RectF rectF = this.drawRect;
        float f16 = min;
        rectF.right = rectF.left + f16;
        rectF.top = (getHeight() - min) / 2.0f;
        RectF rectF2 = this.drawRect;
        rectF2.bottom = rectF2.top + f16;
        c(canvas, min);
        b(canvas, min);
        a(canvas, min);
    }

    public final void setAnchorBarStrokeWidthPx(int i3) {
        this.anchorBarStrokeWidthPx = i3;
        this.anchorBarPaint.setStrokeWidth(i3);
        invalidate();
    }

    public final void setCircleStrokeWidthPx(int i3) {
        this.circleStrokeWidthPx = i3;
        this.circlePaint.setStrokeWidth(i3);
        invalidate();
    }

    public final void setShowAnchorBar(boolean z16) {
        this.showAnchorBar = z16;
        invalidate();
    }

    public final void setShowCircleBorder(boolean z16) {
        this.showCircleBorder = z16;
        invalidate();
    }

    public final void setShowCornerMask(boolean z16) {
        int i3;
        this.showCornerMask = z16;
        if (z16) {
            i3 = this.cornerMaskShowColor;
        } else {
            i3 = this.cornerMaskHideColor;
        }
        this.cornerMaskColor = i3;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.I = new LinkedHashMap();
        this.drawRect = new RectF();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.shadowPaint = paint;
        this.cornerMaskShowColor = context.getColor(R.color.qui_common_bubble_guest_secondary);
        int color = context.getColor(R.color.qui_common_bg_bottom_standard);
        this.cornerMaskHideColor = color;
        this.cornerMaskColor = color;
        this.anchorBarStrokeWidthPx = ViewUtils.dpToPx(4.0f);
        this.circleStrokeWidthPx = ViewUtils.dpToPx(2.0f);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(context.getColor(R.color.qui_common_icon_allwhite_primary));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.circleStrokeWidthPx);
        this.circlePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(context.getColor(R.color.qui_common_icon_allwhite_primary));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(this.anchorBarStrokeWidthPx);
        this.anchorBarPaint = paint3;
    }

    public /* synthetic */ WinkAvatarMaskView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
