package com.tencent.aelight.camera.zplan.api.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u0001\u0003B)\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\b\b\u0001\u0010%\u001a\u00020\u0010\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010R\"\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010%\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanRegionView;", "Landroid/view/View;", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "d", "c", tl.h.F, "Landroid/graphics/Path;", "path", "", "startY", "g", "f", "", "type", "e", "b", "onDraw", "left", "top", "right", "bottom", "setRegionPosition", "I", "getTargetWidth", "()I", "setTargetWidth", "(I)V", "targetWidth", "getTargetHeight", "setTargetHeight", "targetHeight", "getMaskShapeType", "setMaskShapeType", "maskShapeType", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "mPaint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", "mStartY", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;III)V", BdhLogUtil.LogTag.Tag_Conn, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ZPlanRegionView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int targetWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int targetHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int maskShapeType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Rect mRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Paint mPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private double mStartY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRegionView(Context context, int i3, int i16, @ZPlanMaskShapeType int i17) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.targetWidth = i3;
        this.targetHeight = i16;
        this.maskShapeType = i17;
        this.mRect = new Rect();
        this.mPaint = new Paint();
    }

    private final boolean a() {
        Rect rect = this.mRect;
        if (((rect.left != 0) | (rect.top != 0) | (rect.right != 0)) || (rect.bottom != 0)) {
            return true;
        }
        rect.left = (getWidth() - this.targetWidth) / 2;
        this.mRect.top = (getHeight() - this.targetHeight) / 2;
        this.mRect.right = (getWidth() + this.targetWidth) / 2;
        this.mRect.bottom = (getWidth() + this.targetHeight) / 2;
        return false;
    }

    private final void c(Canvas canvas) {
        Path path = new Path();
        h();
        g(path, this.mStartY);
        Rect rect = this.mRect;
        path.addArc(new RectF(rect.left, rect.top, rect.right, rect.bottom), 0.0f, -360.0f);
        f(canvas, path, this.mStartY);
        e(canvas, 0);
    }

    private final void d(Canvas canvas) {
        Path path = new Path();
        h();
        g(path, this.mStartY);
        Rect rect = this.mRect;
        path.addRect(rect.left, rect.top, rect.right, rect.bottom, Path.Direction.CCW);
        f(canvas, path, this.mStartY);
        e(canvas, 1);
    }

    private final void e(Canvas canvas, int type) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(1291845632);
        this.mPaint.setStrokeWidth(5.0f);
        b(canvas, type);
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(3.0f);
        b(canvas, type);
    }

    private final void f(Canvas canvas, Path path, double startY) {
        float f16 = (float) startY;
        path.moveTo(getWidth(), f16);
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0.0f, getHeight());
        path.lineTo(0.0f, 0.0f);
        path.lineTo(getWidth(), 0.0f);
        path.moveTo(getWidth(), f16);
        path.close();
        canvas.drawPath(path, this.mPaint);
    }

    private final void g(Path path, double startY) {
        this.mPaint.setColor(1711276032);
        this.mPaint.setStyle(Paint.Style.FILL);
        path.moveTo(getWidth(), (float) startY);
    }

    private final void h() {
        Rect rect = this.mRect;
        this.mStartY = rect.top + (rect.height() * 0.5d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            QLog.e("ZPlanRegionView", 1, "onDraw failed, canvas null.");
            return;
        }
        a();
        int i3 = this.maskShapeType;
        if (i3 == 0) {
            c(canvas);
        } else {
            if (i3 != 1) {
                return;
            }
            d(canvas);
        }
    }

    public final void setMaskShapeType(int i3) {
        this.maskShapeType = i3;
    }

    public final void setRegionPosition(int left, int top, int right, int bottom) {
        Rect rect = this.mRect;
        rect.left = left;
        rect.top = top;
        rect.right = right;
        rect.bottom = bottom;
    }

    public final void setTargetHeight(int i3) {
        this.targetHeight = i3;
    }

    public final void setTargetWidth(int i3) {
        this.targetWidth = i3;
    }

    private final void b(Canvas canvas, int type) {
        if (type == 0) {
            Rect rect = this.mRect;
            canvas.drawCircle(rect.left + (rect.width() * 0.5f), (float) this.mStartY, this.mRect.width() * 0.5f, this.mPaint);
        } else {
            if (type != 1) {
                return;
            }
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
