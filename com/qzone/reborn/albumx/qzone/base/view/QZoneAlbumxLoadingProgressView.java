package com.qzone.reborn.albumx.qzone.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u0001\u0006B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u000b\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010!\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/view/QZoneAlbumxLoadingProgressView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "b", "a", "", "topProgress", HippyQQPagView.FunctionName.SET_PROGRESS, "onDraw", "", "width", "height", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Paint;", "paint", "startColor", "endColor", "setPaintShader", "", "c", "d", "I", "topStartColor", "e", "topEndColor", "f", "Z", "isSmallDimen", h.F, UserInfo.SEX_FEMALE, "progressWidth", "Landroid/graphics/RectF;", "i", "Landroid/graphics/RectF;", "viewBounds", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "topPBPaint", BdhLogUtil.LogTag.Tag_Conn, "curAngle", "D", "rotateDegree", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLoadingProgressView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float curAngle;

    /* renamed from: D, reason: from kotlin metadata */
    private float rotateDegree;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int topStartColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int topEndColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSmallDimen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float progressWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final RectF viewBounds;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Paint topPBPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLoadingProgressView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Canvas canvas) {
        if (this.curAngle <= 0.0f) {
            return;
        }
        float f16 = 2;
        float f17 = this.progressWidth / f16;
        int save = canvas.save();
        canvas.rotate(this.rotateDegree, this.viewBounds.width() / f16, this.viewBounds.height() / f16);
        canvas.drawArc(f17, f17, this.viewBounds.width() - f17, this.viewBounds.height() - f17, -90.0f, this.curAngle, false, this.topPBPaint);
        canvas.restoreToCount(save);
    }

    private final void b(Canvas canvas) {
        RectF rectF = this.viewBounds;
        canvas.translate(rectF.left, rectF.top);
        canvas.clipRect(0.0f, 0.0f, this.viewBounds.width(), this.viewBounds.height());
    }

    public final boolean c() {
        int l3 = ar.l();
        int k3 = ar.k();
        QLog.d("QZoneAlbumxLoadingProgressView", 1, "[isSmallDimen] width: " + l3 + ", height: " + k3);
        return l3 < 856 || k3 < 1852;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        b(canvas);
        a(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);
        int min = Math.min(width, height);
        int i3 = (width - min) / 2;
        int i16 = (height - min) / 2;
        this.viewBounds.set(getPaddingLeft() + i3, getPaddingTop() + i16, (width - getPaddingRight()) - i3, (height - getPaddingBottom()) - i16);
        setPaintShader(this.topPBPaint, this.topStartColor, this.topEndColor);
    }

    public final void setPaintShader(Paint paint, int startColor, int endColor) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        RectF rectF = this.viewBounds;
        float f16 = rectF.right - rectF.left;
        float f17 = 2;
        float f18 = f16 / f17;
        float sqrt = (float) Math.sqrt(2.0f);
        float f19 = ((sqrt - 1) / sqrt) * f18;
        float f26 = (f18 * f17) - f19;
        paint.setShader(new LinearGradient(f19, f19, f26, f26, startColor, endColor, Shader.TileMode.CLAMP));
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLoadingProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneAlbumxLoadingProgressView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLoadingProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.topStartColor = Color.parseColor("#0099FF");
        this.topEndColor = Color.parseColor("#00F0FF");
        this.viewBounds = new RectF();
        boolean c16 = c();
        this.isSmallDimen = c16;
        float e16 = ar.e(c16 ? 24.0f : 29.0f);
        this.progressWidth = e16;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(e16);
        this.topPBPaint = paint;
    }

    public final void setProgress(float topProgress) {
        this.curAngle = (topProgress * 360.0f) / 100;
        invalidate();
    }
}
