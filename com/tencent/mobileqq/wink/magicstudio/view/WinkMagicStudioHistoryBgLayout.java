package com.tencent.mobileqq.wink.magicstudio.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/WinkMagicStudioHistoryBgLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "pathPaint", "", "e", UserInfo.SEX_FEMALE, NodeProps.BORDER_WIDTH, "Landroid/graphics/Path;", "f", "Landroid/graphics/Path;", "roundRectPath", tl.h.F, "roundRectRadius", "i", "trianglePath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "triangleHeight", BdhLogUtil.LogTag.Tag_Conn, "triangleWidth", "D", "combinedPath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkMagicStudioHistoryBgLayout extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final float triangleWidth;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Path combinedPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint pathPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float borderWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path roundRectPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float roundRectRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path trianglePath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float triangleHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMagicStudioHistoryBgLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float width = getWidth();
        float height = getHeight();
        float f16 = 2;
        float f17 = (height - this.triangleHeight) - (this.borderWidth * f16);
        this.roundRectPath.reset();
        Path path = this.roundRectPath;
        float f18 = this.borderWidth;
        RectF rectF = new RectF(f18, f18, width - (f18 * f16), f17);
        float f19 = this.roundRectRadius;
        path.addRoundRect(rectF, new float[]{f19, f19, f19, f19, f19, f19, f19, f19}, Path.Direction.CW);
        this.roundRectPath.close();
        this.trianglePath.reset();
        PointF pointF = new PointF((width - this.triangleWidth) / f16, f17);
        PointF pointF2 = new PointF((this.triangleWidth + width) / f16, f17);
        PointF pointF3 = new PointF(width / f16, height - this.borderWidth);
        this.trianglePath.moveTo(pointF.x, pointF.y);
        this.trianglePath.lineTo(pointF2.x, pointF2.y);
        this.trianglePath.lineTo(pointF3.x, pointF3.y);
        this.trianglePath.close();
        this.combinedPath.reset();
        this.combinedPath.op(this.roundRectPath, this.trianglePath, Path.Op.UNION);
        canvas.drawPath(this.combinedPath, this.pathPaint);
        canvas.clipPath(this.combinedPath);
        super.onDraw(canvas);
    }

    public /* synthetic */ WinkMagicStudioHistoryBgLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMagicStudioHistoryBgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.pathPaint = paint;
        float dpToPx = ViewUtils.dpToPx(1.0f);
        this.borderWidth = dpToPx;
        this.roundRectPath = new Path();
        this.roundRectRadius = ViewUtils.dpToPx(16.0f);
        this.trianglePath = new Path();
        this.triangleHeight = ViewUtils.dpToPx(6.0f);
        this.triangleWidth = ViewUtils.dpToPx(12.0f);
        this.combinedPath = new Path();
        setBackgroundColor(0);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx);
        paint.setColor(Color.parseColor("#1AFFFFFF"));
        paint.setAntiAlias(true);
    }
}
