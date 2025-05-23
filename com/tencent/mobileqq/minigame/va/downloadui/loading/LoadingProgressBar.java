package com.tencent.mobileqq.minigame.va.downloadui.loading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tJ\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0014J(\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0014J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/loading/LoadingProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBitmap", "Landroid/graphics/Bitmap;", "mBitmapHeight", "mBitmapWidth", "", "mInitDone", "", "mPaint", "Landroid/graphics/Paint;", "mProgress", "mRectF", "Landroid/graphics/RectF;", "mRectSrc", "Landroid/graphics/Rect;", "mViewHeight", "mViewWidth", "path", "Landroid/graphics/Path;", "getRoundedCornerBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "init", "", "bgResId", "barWidth", "barHeight", "onDraw", PM.CANVAS, "Landroid/graphics/Canvas;", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "w", h.F, "oldw", "oldh", HippyQQPagView.FunctionName.SET_PROGRESS, "progress", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LoadingProgressBar extends View {
    private static final String TAG = "MiniGameVALoadingProgressBar";
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private float mBitmapWidth;
    private boolean mInitDone;
    private final Paint mPaint;
    private float mProgress;
    private final RectF mRectF;
    private final Rect mRectSrc;
    private int mViewHeight;
    private int mViewWidth;
    private Path path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingProgressBar(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.mRectSrc = new Rect();
        this.mRectF = new RectF();
    }

    public final void init(int bgResId, int barWidth, int barHeight) {
        this.mViewWidth = barWidth;
        this.mViewHeight = barHeight;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), bgResId);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(resources, bgResId)");
        Bitmap roundedCornerBitmap = getRoundedCornerBitmap(decodeResource);
        this.mBitmap = roundedCornerBitmap;
        Bitmap bitmap = null;
        if (roundedCornerBitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBitmap");
            roundedCornerBitmap = null;
        }
        this.mBitmapWidth = roundedCornerBitmap.getWidth();
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBitmap");
        } else {
            bitmap = bitmap2;
        }
        this.mBitmapHeight = bitmap.getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, this.mViewWidth, this.mViewHeight);
        Path path = new Path();
        int i3 = this.mViewHeight;
        path.addRoundRect(rectF, i3 / 2.0f, i3 / 2.0f, Path.Direction.CW);
        this.path = path;
        this.mInitDone = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mInitDone) {
            float width = (this.mProgress / 100) * getWidth();
            this.mPaint.setColor(Color.argb(128, 255, 255, 255));
            this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
            float f16 = 2;
            canvas.drawRoundRect(this.mRectF, getHeight() / f16, getHeight() / f16, this.mPaint);
            Path path = this.path;
            if (path == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
                path = null;
            }
            canvas.clipPath(path);
            this.mPaint.setColor(Color.argb(255, 0, 0, 0));
            this.mRectF.set(0.0f, 0.0f, width, getHeight());
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBitmap");
                bitmap = null;
            }
            canvas.drawBitmap(bitmap, (Rect) null, this.mRectF, this.mPaint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.mRectF.set(0.0f, 0.0f, w3, h16);
    }

    public final void setProgress(int progress) {
        this.mProgress = progress;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mPaint = new Paint();
        this.mRectSrc = new Rect();
        this.mRectF = new RectF();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingProgressBar(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mPaint = new Paint();
        this.mRectSrc = new Rect();
        this.mRectF = new RectF();
    }

    private final Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        return bitmap;
    }
}
