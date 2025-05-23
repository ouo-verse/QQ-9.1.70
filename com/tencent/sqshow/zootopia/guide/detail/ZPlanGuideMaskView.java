package com.tencent.sqshow.zootopia.guide.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u0001\u0007B\u001b\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0019R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00068"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanGuideMaskView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "b", "c", "a", "", "centerX", "centerY", "radius", "setCircle", "left", "top", "right", "bottom", "setRect", "setHalfScreen", "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "e", UserInfo.SEX_FEMALE, "mCircleX", "f", "mCircleY", h.F, "mCircleRadius", "i", "Landroid/graphics/Canvas;", "mBitmapCanvas", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", "mTempBitmap", BdhLogUtil.LogTag.Tag_Conn, "mTop", "D", "mRight", "E", "mLeft", "mBottom", "", "G", "I", "mMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanGuideMaskView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float mTop;

    /* renamed from: D, reason: from kotlin metadata */
    private float mRight;

    /* renamed from: E, reason: from kotlin metadata */
    private float mLeft;

    /* renamed from: F, reason: from kotlin metadata */
    private float mBottom;

    /* renamed from: G, reason: from kotlin metadata */
    private int mMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mCircleX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mCircleY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mCircleRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Canvas mBitmapCanvas;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Bitmap mTempBitmap;

    public ZPlanGuideMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mBitmapCanvas = new Canvas();
        paint.setARGB(0, 0, 0, 0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        setClickable(true);
    }

    private final void a(Canvas canvas) {
        Bitmap bitmap = this.mTempBitmap;
        Unit unit = null;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, getWidth(), getHeight()), (Paint) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            canvas.drawColor(Color.parseColor("#B3000000"));
        }
    }

    private final void b(Canvas canvas) {
        if (this.mCircleX == 0.0f) {
            return;
        }
        if (this.mCircleY == 0.0f) {
            return;
        }
        if (this.mTempBitmap == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                this.mTempBitmap = createBitmap;
                this.mBitmapCanvas.setBitmap(createBitmap);
                this.mBitmapCanvas.drawColor(Color.parseColor("#B3000000"));
                this.mBitmapCanvas.drawCircle(this.mCircleX, this.mCircleY, this.mCircleRadius, this.mPaint);
            } catch (Throwable th5) {
                QLog.e("ZPlanGuideMaskView", 1, th5, new Object[0]);
            }
        }
        a(canvas);
    }

    private final void c(Canvas canvas) {
        if (this.mLeft == 0.0f) {
            if (this.mTop == 0.0f) {
                if (this.mRight == 0.0f) {
                    if (this.mBottom == 0.0f) {
                        return;
                    }
                }
            }
        }
        if (this.mTempBitmap == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                this.mTempBitmap = createBitmap;
                this.mBitmapCanvas.setBitmap(createBitmap);
                this.mBitmapCanvas.drawColor(Color.parseColor("#B3000000"));
                if (this.mMode == 2) {
                    this.mBitmapCanvas.drawRect(0.0f, this.mTop, getWidth(), getHeight(), this.mPaint);
                } else {
                    this.mBitmapCanvas.drawRect(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mPaint);
                }
            } catch (Throwable th5) {
                QLog.e("ZPlanGuideMaskView", 1, th5, new Object[0]);
            }
        }
        a(canvas);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mMode == 0) {
            b(canvas);
        } else {
            c(canvas);
        }
    }

    public final void setCircle(float centerX, float centerY, float radius) {
        this.mMode = 0;
        this.mCircleX = centerX;
        this.mCircleY = centerY;
        this.mCircleRadius = radius;
        postInvalidate();
        QLog.i("ZPlanGuideMaskView", 4, "mCircleX == " + this.mCircleX + " , mCircleY == " + this.mCircleY + " , mCircleRadius == mCircleRadius");
    }

    public final void setHalfScreen(float top) {
        this.mMode = 2;
        this.mTop = top;
        postInvalidate();
    }

    public final void setRect(float left, float top, float right, float bottom) {
        this.mMode = 1;
        this.mLeft = left;
        this.mTop = top;
        this.mRight = right;
        this.mBottom = bottom;
        postInvalidate();
        QLog.i("ZPlanGuideMaskView", 4, "left == " + left + " , top == " + top + " , right == " + right + " , bottom == " + bottom);
    }
}
