package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001\nB\u001b\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0014J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001d\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxProgressBar;", "Landroid/view/View;", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "", "cornerRadius", "Landroid/graphics/Path;", "b", "", "progress", "a", "", HippyQQPagView.FunctionName.SET_PROGRESS, "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "e", "Landroid/graphics/RectF;", "rectF", "f", UserInfo.SEX_FEMALE, "strokeWidth", "i", "cornerDiameter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", BdhLogUtil.LogTag.Tag_Conn, "progressLineTotalLength", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRectBoxProgressBar extends View {
    private static final int E = Color.parseColor("#E6E6E6");
    private static final int F = Color.parseColor("#4AB6FF");

    /* renamed from: C, reason: from kotlin metadata */
    private float progressLineTotalLength;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RectF rectF;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float strokeWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float cornerRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float cornerDiameter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int progress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSRectBoxProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.paint = paint;
        this.rectF = new RectF();
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        this.strokeWidth = cVar.b(2);
        float b16 = cVar.b(4);
        this.cornerRadius = b16;
        float f16 = 2;
        this.cornerDiameter = b16 * f16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.R6);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026le.QFSRectBoxProgressBar)");
        this.cornerRadius = obtainStyledAttributes.getDimension(y91.a.S6, this.cornerRadius);
        this.strokeWidth = obtainStyledAttributes.getDimension(y91.a.T6, this.strokeWidth);
        obtainStyledAttributes.recycle();
        paint.setStrokeWidth(this.strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        this.cornerDiameter = f16 * this.cornerRadius;
    }

    private final Path a(RectF rect, int progress) {
        Path path = new Path();
        float f16 = (progress / 100.0f) * this.progressLineTotalLength;
        float f17 = 2;
        float width = (rect.width() - (this.cornerRadius * f17)) / f17;
        float min = Math.min(f16, width);
        path.moveTo(rect.centerX(), rect.top);
        path.lineTo(rect.centerX() + min, rect.top);
        float f18 = f16 - min;
        if (f18 <= 0.0f) {
            return path;
        }
        float f19 = rect.right;
        float f26 = this.cornerDiameter;
        float f27 = rect.top;
        path.arcTo(new RectF(f19 - f26, f27, f19, f26 + f27), 270.0f, 90.0f);
        float f28 = f18 - (this.cornerRadius * 1.5707964f);
        if (f28 <= 0.0f) {
            return path;
        }
        float min2 = Math.min(f28, rect.height() - (this.cornerRadius * f17));
        path.lineTo(rect.right, rect.top + this.cornerRadius + min2);
        float f29 = f28 - min2;
        if (f29 <= 0.0f) {
            return path;
        }
        float f36 = rect.right;
        float f37 = this.cornerDiameter;
        float f38 = rect.bottom;
        path.arcTo(new RectF(f36 - f37, f38 - f37, f36, f38), 0.0f, 90.0f);
        float f39 = f29 - (this.cornerRadius * 1.5707964f);
        if (f39 <= 0.0f) {
            return path;
        }
        float min3 = Math.min(f39, rect.width() - (this.cornerRadius * f17));
        path.lineTo((rect.right - this.cornerRadius) - min3, rect.bottom);
        float f46 = f39 - min3;
        if (f46 <= 0.0f) {
            return path;
        }
        float f47 = rect.left;
        float f48 = rect.bottom;
        float f49 = this.cornerDiameter;
        path.arcTo(new RectF(f47, f48 - f49, f49 + f47, f48), 90.0f, 90.0f);
        float f56 = f46 - (this.cornerRadius * 1.5707964f);
        if (f56 <= 0.0f) {
            return path;
        }
        float min4 = Math.min(f56, rect.height() - (this.cornerRadius * f17));
        path.lineTo(rect.left, (rect.bottom - this.cornerRadius) - min4);
        float f57 = f56 - min4;
        if (f57 <= 0.0f) {
            return path;
        }
        float f58 = rect.left;
        float f59 = rect.top;
        float f65 = this.cornerDiameter;
        path.arcTo(new RectF(f58, f59, f58 + f65, f65 + f59), 180.0f, 90.0f);
        float f66 = f57 - (this.cornerRadius * 1.5707964f);
        if (f66 <= 0.0f) {
            return path;
        }
        float min5 = Math.min(f66, width);
        if (progress == 100) {
            path.lineTo(rect.centerX() + min5, rect.top);
        } else {
            path.lineTo(rect.left + min5, rect.top);
        }
        return path;
    }

    private final Path b(RectF rect, float cornerRadius) {
        Path path = new Path();
        path.addRoundRect(rect, cornerRadius, cornerRadius, Path.Direction.CW);
        return path;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.paint.setColor(E);
        canvas.drawPath(b(this.rectF, this.cornerRadius), this.paint);
        this.paint.setColor(F);
        canvas.drawPath(a(this.rectF, this.progress), this.paint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        float f16 = this.strokeWidth;
        RectF rectF = new RectF(f16, f16, w3 - f16, h16 - f16);
        this.rectF = rectF;
        float width = rectF.width() - this.cornerDiameter;
        float f17 = 2;
        float height = this.rectF.height();
        float f18 = this.cornerDiameter;
        this.progressLineTotalLength = (width * f17) + ((height - f18) * f17) + (f18 * 3.1415927f);
    }

    public final void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
