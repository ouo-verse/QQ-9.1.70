package com.tencent.mobileqq.wink.editor.mosaic;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.mosaic.doodle.DoodleLayout;
import com.tencent.mobileqq.wink.editor.mosaic.ui.DoodleView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0003JR\u0010 \u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016R$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00104\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010E\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010F\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010@R\u0016\u0010H\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010@R\u0016\u0010J\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010@R\u0016\u0010K\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010@R\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010@R\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010T\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010PR\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/b;", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "e", "Landroid/graphics/Matrix;", "matrix", "", "adjustBounds", "j", "onGlobalLayout", "", "c", "b", "d", "", "width", "height", tl.h.F, "keepDoodle", "i", "f", "Landroid/view/View;", "v", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getMImageView", "()Landroid/widget/ImageView;", "setMImageView", "(Landroid/widget/ImageView;)V", "mImageView", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "getMDisplayBitmap", "()Landroid/graphics/Bitmap;", "setMDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "mDisplayBitmap", "I", "getCurrentModelHeight", "()I", "setCurrentModelHeight", "(I)V", "currentModelHeight", "Lcom/tencent/mobileqq/wink/editor/mosaic/ui/DoodleView;", "Lcom/tencent/mobileqq/wink/editor/mosaic/ui/DoodleView;", "doodleView", "Lcom/tencent/mobileqq/wink/editor/mosaic/doodle/DoodleLayout;", "Lcom/tencent/mobileqq/wink/editor/mosaic/doodle/DoodleLayout;", "doodleLayout", "La73/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "La73/a;", "mosaicViewModel", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "mViewWidth", "D", "mViewHeight", "E", "mBitmapWidth", "mBitmapHeight", "G", "mOriginBitmapWidth", "H", "mOriginBitmapHeight", "mBaseScale", "J", "mMaxScale", "Landroid/graphics/RectF;", "K", "Landroid/graphics/RectF;", "mBaseBounds", "L", "Landroid/graphics/Matrix;", "mBaseMatrix", "M", "mTempMatrix", "", "N", "[F", "mTempValues", "P", "mTempRect", "Landroid/view/ViewTreeObserver;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/ViewTreeObserver;", "viewTreeObserver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements View.OnLayoutChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: C, reason: from kotlin metadata */
    private float mViewWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float mViewHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private float mBitmapWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private float mBitmapHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private float mOriginBitmapWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private float mOriginBitmapHeight;

    /* renamed from: I, reason: from kotlin metadata */
    private float mBaseScale = 1.0f;

    /* renamed from: J, reason: from kotlin metadata */
    private float mMaxScale = 3.0f;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final RectF mBaseBounds = new RectF();

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Matrix mBaseMatrix = new Matrix();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Matrix mTempMatrix = new Matrix();

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final float[] mTempValues = new float[9];

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final RectF mTempRect = new RectF();

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ViewTreeObserver viewTreeObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mDisplayBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentModelHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DoodleView doodleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DoodleLayout doodleLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a73.a mosaicViewModel;

    private final void e() {
        RectF rectF;
        Unit unit;
        float f16;
        float f17;
        ImageView imageView = this.mImageView;
        Intrinsics.checkNotNull(imageView);
        if (imageView.getWidth() > 0) {
            ImageView imageView2 = this.mImageView;
            Intrinsics.checkNotNull(imageView2);
            if (imageView2.getHeight() > 0) {
                ImageView imageView3 = this.mImageView;
                Intrinsics.checkNotNull(imageView3);
                Drawable drawable = imageView3.getDrawable();
                if (drawable == null) {
                    ms.a.a("PicRawImage_Mosaic", "image view with no drawable");
                    return;
                }
                a73.a aVar = this.mosaicViewModel;
                if (aVar != null) {
                    aVar.P1();
                }
                a73.a aVar2 = this.mosaicViewModel;
                if (aVar2 != null) {
                    rectF = aVar2.O1();
                } else {
                    rectF = null;
                }
                if (rectF != null) {
                    this.mBitmapWidth = rectF.right - rectF.left;
                    this.mBitmapHeight = rectF.bottom - rectF.top;
                    this.mOriginBitmapWidth = drawable.getIntrinsicWidth();
                    this.mOriginBitmapHeight = drawable.getIntrinsicHeight();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    this.mBitmapWidth = drawable.getIntrinsicWidth();
                    float intrinsicHeight = drawable.getIntrinsicHeight();
                    this.mBitmapHeight = intrinsicHeight;
                    this.mOriginBitmapWidth = this.mBitmapWidth;
                    this.mOriginBitmapHeight = intrinsicHeight;
                }
                if (this.mBitmapWidth > 0.0f && this.mBitmapHeight > 0.0f) {
                    Intrinsics.checkNotNull(this.mImageView);
                    this.mViewWidth = r0.getWidth();
                    ImageView imageView4 = this.mImageView;
                    Intrinsics.checkNotNull(imageView4);
                    float height = imageView4.getHeight();
                    this.mViewHeight = height;
                    float f18 = this.mViewWidth;
                    float f19 = this.mBitmapWidth;
                    float f26 = f18 / f19;
                    float f27 = this.mBitmapHeight;
                    if (f26 >= height / f27) {
                        float f28 = height / f27;
                        this.mBaseScale = f28;
                        f17 = (f18 - (f28 * f19)) / 2;
                        f16 = 0.0f;
                    } else {
                        float f29 = f18 / f19;
                        this.mBaseScale = f29;
                        f16 = (height - (f29 * f27)) / 2;
                        f17 = 0.0f;
                    }
                    if (rectF != null) {
                        f17 -= rectF.left;
                        f16 -= rectF.top;
                    }
                    ms.a.f("PicRawImage_Mosaic", "scale = " + this.mBaseScale + ", tx = " + f17 + ", ty = " + f16 + " bitmap width = " + f19 + ", bitmap height = " + f27);
                    this.mMaxScale = Math.max(this.mBaseScale, this.mMaxScale);
                    this.mBaseMatrix.reset();
                    Matrix matrix = this.mBaseMatrix;
                    float f36 = this.mBaseScale;
                    matrix.setScale(f36, f36);
                    if (rectF != null) {
                        this.mBaseMatrix.setRectToRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), new RectF(0.0f, 0.0f, this.mViewWidth, this.mViewHeight), Matrix.ScaleToFit.CENTER);
                    } else {
                        this.mBaseMatrix.postTranslate(f17, f16);
                    }
                    boolean z16 = false;
                    j(this.mBaseMatrix, false);
                    this.mBaseBounds.set(0.0f, 0.0f, this.mOriginBitmapWidth, this.mOriginBitmapHeight);
                    w53.b.a("PicRawImage_Mosaic", "initImageMatrix mBasebounds: " + this.mBaseBounds);
                    ImageView imageView5 = this.mImageView;
                    Intrinsics.checkNotNull(imageView5);
                    imageView5.getImageMatrix().mapRect(this.mBaseBounds);
                    w53.b.a("PicRawImage_Mosaic", "initImageMatrix mapRect -> mBasebounds: " + this.mBaseBounds);
                    DoodleView doodleView = this.doodleView;
                    if (doodleView != null) {
                        if (this.mBitmapWidth / this.mViewWidth == this.mBitmapHeight / this.mViewHeight) {
                            z16 = true;
                        }
                        if (!z16) {
                            Intrinsics.checkNotNull(doodleView);
                            doodleView.setContentBounds(new RectF(this.mBaseBounds));
                            return;
                        } else {
                            Intrinsics.checkNotNull(doodleView);
                            doodleView.setContentBounds(null);
                            return;
                        }
                    }
                    return;
                }
                ms.a.a("PicRawImage_Mosaic", "image view drawable size is not ready");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mImageView;
        Intrinsics.checkNotNull(imageView);
        int width = imageView.getWidth();
        ImageView imageView2 = this$0.mImageView;
        Intrinsics.checkNotNull(imageView2);
        int height = imageView2.getHeight();
        if (z16 && width > 0 && height > 0) {
            this$0.e();
            this$0.h(width, height);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(Matrix matrix, boolean adjustBounds) {
        float f16;
        float f17;
        float f18;
        if (adjustBounds) {
            float f19 = 0.0f;
            this.mTempRect.set(0.0f, 0.0f, this.mBitmapWidth, this.mBitmapHeight);
            matrix.mapRect(this.mTempRect);
            RectF rectF = this.mTempRect;
            float f26 = rectF.left;
            RectF rectF2 = this.mBaseBounds;
            float f27 = rectF2.left;
            if (f26 <= f27) {
                f26 = rectF.right;
                f27 = rectF2.right;
                if (f26 >= f27) {
                    f16 = 0.0f;
                    f17 = rectF.top;
                    f18 = rectF2.top;
                    if (f17 <= f18) {
                        f19 = f18 - f17;
                    } else {
                        float f28 = rectF.bottom;
                        float f29 = rectF2.bottom;
                        if (f28 < f29) {
                            f19 = f29 - f28;
                        }
                    }
                    matrix.postTranslate(f16, f19);
                }
            }
            f16 = f27 - f26;
            f17 = rectF.top;
            f18 = rectF2.top;
            if (f17 <= f18) {
            }
            matrix.postTranslate(f16, f19);
        }
        ImageView imageView = this.mImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageMatrix(matrix);
        ImageView imageView2 = this.mImageView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.invalidate();
        this.mBaseMatrix.invert(this.mTempMatrix);
        Matrix matrix2 = this.mTempMatrix;
        ImageView imageView3 = this.mImageView;
        Intrinsics.checkNotNull(imageView3);
        matrix2.postConcat(imageView3.getImageMatrix());
        DoodleView doodleView = this.doodleView;
        if (doodleView != null) {
            Intrinsics.checkNotNull(doodleView);
            doodleView.setExtraTransform(this.mTempMatrix);
        }
    }

    /* renamed from: b, reason: from getter */
    public final float getMBaseScale() {
        return this.mBaseScale;
    }

    public final float c() {
        ImageView imageView = this.mImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.getImageMatrix().getValues(this.mTempValues);
        return this.mTempValues[0];
    }

    /* renamed from: d, reason: from getter */
    public final float getMMaxScale() {
        return this.mMaxScale;
    }

    public final void f() {
        this.currentModelHeight = 0;
        ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        ImageView imageView = this.mImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.removeOnLayoutChangeListener(this);
    }

    public final void h(int width, int height) {
        i(width, height, false);
    }

    public final void i(int width, int height, boolean keepDoodle) {
        DoodleLayout doodleLayout = this.doodleLayout;
        Intrinsics.checkNotNull(doodleLayout);
        doodleLayout.c(width, height, keepDoodle);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ms.a.f("PicRawImage_Mosaic", "[EditPicRawImage onGlobalLayout]");
        Bitmap bitmap = this.mDisplayBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            if (!bitmap.isRecycled()) {
                ImageView imageView = this.mImageView;
                Intrinsics.checkNotNull(imageView);
                int width = imageView.getWidth();
                ImageView imageView2 = this.mImageView;
                Intrinsics.checkNotNull(imageView2);
                int height = imageView2.getHeight();
                float f16 = this.mViewWidth;
                if (((int) f16) != width || ((int) this.mViewHeight) != height) {
                    ms.a.f("PicRawImage_Mosaic", "last width = " + f16 + ", last height = " + this.mViewHeight);
                    ms.a.f("PicRawImage_Mosaic", "current width = " + width + ", current height = " + height);
                    this.currentModelHeight = height;
                    e();
                    i(width, height, true);
                    return;
                }
                return;
            }
        }
        ms.a.f("PicRawImage_Mosaic", "display bitmap is invalid");
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        final boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("PicRawImage_Mosaic", 2, "onLayoutChange, height pixel change,bottom:" + bottom + " oldBottom:" + oldBottom + " top:" + top + " oldTop:" + oldTop);
        }
        if (oldBottom != bottom && this.currentModelHeight == 0 && bottom > 0) {
            this.currentModelHeight = bottom - top;
        }
        int i3 = oldBottom - oldTop;
        int i16 = bottom - top;
        if (oldRight - oldLeft == right - left && i3 == i16) {
            z16 = false;
        } else {
            z16 = true;
        }
        ImageView imageView = this.mImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.mosaic.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(b.this, z16);
            }
        });
    }
}
