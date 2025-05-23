package com.tencent.state.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.square.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J(\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0007J\b\u0010+\u001a\u00020\u001eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/view/RoundImageView;", "Lcom/tencent/state/view/SquareImageView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBitmapPaint", "Landroid/graphics/Paint;", "mBitmapShader", "Landroid/graphics/BitmapShader;", "mDisableLeftBottom", "", "mDisableLeftTop", "mDisableRightBottom", "mDisableRightTop", "mMatrix", "Landroid/graphics/Matrix;", "mRadius", "mRoundRect", "Landroid/graphics/RectF;", "mScaleType", "Lcom/tencent/state/view/ImageScaleType;", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "w", h.F, "oldw", "oldh", "setRadius", "radius", "setUpShader", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RoundImageView extends SquareImageView {
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private boolean mDisableLeftBottom;
    private boolean mDisableLeftTop;
    private boolean mDisableRightBottom;
    private boolean mDisableRightTop;
    private Matrix mMatrix;
    private int mRadius;
    private RectF mRoundRect;
    private ImageScaleType mScaleType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageScaleType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ImageScaleType.FIX_XY.ordinal()] = 1;
            iArr[ImageScaleType.CENTER_CORP.ordinal()] = 2;
        }
    }

    public RoundImageView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
            return bitmap;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap2 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(bitmap2);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
        return bitmap2;
    }

    private final void setUpShader() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap drawableToBitmap = drawableToBitmap(drawable);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(drawableToBitmap, tileMode, tileMode);
            float width = getWidth() / drawableToBitmap.getWidth();
            float height = getHeight() / drawableToBitmap.getHeight();
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.mScaleType.ordinal()];
            if (i3 == 1) {
                this.mMatrix.setScale(width, height);
            } else if (i3 == 2) {
                float coerceAtLeast = (drawableToBitmap.getWidth() == getWidth() && drawableToBitmap.getHeight() == getHeight()) ? 1.0f : RangesKt___RangesKt.coerceAtLeast(width, height);
                float f16 = coerceAtLeast;
                this.mMatrix.setScale(coerceAtLeast, f16);
                float f17 = 2;
                this.mMatrix.postTranslate((-((drawableToBitmap.getWidth() * coerceAtLeast) - getWidth())) / f17, (-((drawableToBitmap.getHeight() * f16) - getHeight())) / f17);
            }
            BitmapShader bitmapShader = this.mBitmapShader;
            Intrinsics.checkNotNull(bitmapShader);
            bitmapShader.setLocalMatrix(this.mMatrix);
            this.mBitmapPaint.setShader(this.mBitmapShader);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getDrawable() != null) {
            setUpShader();
            RectF rectF = this.mRoundRect;
            if (rectF != null) {
                int i3 = this.mRadius;
                canvas.drawRoundRect(rectF, i3, i3, this.mBitmapPaint);
                if (this.mDisableLeftTop) {
                    float f16 = rectF.left;
                    float f17 = rectF.top;
                    int i16 = this.mRadius;
                    canvas.drawRect(f16, f17, f16 + i16, f17 + i16, this.mBitmapPaint);
                }
                if (this.mDisableLeftBottom) {
                    float f18 = rectF.left;
                    float f19 = rectF.bottom;
                    int i17 = this.mRadius;
                    canvas.drawRect(f18, f19 - i17, f18 + i17, f19, this.mBitmapPaint);
                }
                if (this.mDisableRightTop) {
                    float f26 = rectF.right;
                    int i18 = this.mRadius;
                    float f27 = rectF.top;
                    canvas.drawRect(f26 - i18, f27, f26, f27 + i18, this.mBitmapPaint);
                }
                if (this.mDisableRightBottom) {
                    float f28 = rectF.right;
                    int i19 = this.mRadius;
                    float f29 = rectF.bottom;
                    canvas.drawRect(f28 - i19, f29 - i19, f28, f29, this.mBitmapPaint);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.mRoundRect = new RectF(0.0f, 0.0f, w3, h16);
    }

    public final void setRadius(int radius) {
        this.mRadius = radius;
        invalidate();
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RoundImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.mBitmapPaint = paint;
        this.mMatrix = new Matrix();
        this.mScaleType = ImageScaleType.CENTER_CORP;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundImageView);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_radius, 0);
        this.mDisableLeftTop = obtainStyledAttributes.getBoolean(R.styleable.RoundImageView_riv_disableLeftTop, false);
        this.mDisableRightTop = obtainStyledAttributes.getBoolean(R.styleable.RoundImageView_riv_disableRightTop, false);
        this.mDisableLeftBottom = obtainStyledAttributes.getBoolean(R.styleable.RoundImageView_riv_disableLeftBottom, false);
        this.mDisableRightBottom = obtainStyledAttributes.getBoolean(R.styleable.RoundImageView_riv_disableRightBottom, false);
        this.mScaleType = ImageScaleType.INSTANCE.parse(obtainStyledAttributes.getInt(R.styleable.RoundImageView_riv_scale_type, this.mScaleType.getValue()));
        obtainStyledAttributes.recycle();
    }
}
