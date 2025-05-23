package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.zplan.api.impl.ZPlanPortraitImageView;
import com.tencent.aelight.camera.zplan.api.impl.ZPlanRegionView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001]B\u001f\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010Y\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\nH\u0016JR\u0010'\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0016R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00100R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00100R\u0016\u0010?\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00100R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010BR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006^"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/ZPlanEditPicRawImage;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditPicRawImageNew;", "", "K0", "", "cropWidth", "F0", "s0", "Landroid/graphics/Matrix;", "matrix", "", "adjustBounds", "z0", "G0", "onCreate", "editVideoState", "", "extra", "editVideoStateChanged", "", "o0", "factor", "focusX", "focusY", "t0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "keepDoodle", "y0", "Landroid/view/View;", "v", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "fragmentIndex", "Lfs/b;", "generateContext", "editVideoPrePublish", BdhLogUtil.LogTag.Tag_Req, "I", "mRegionShape", ExifInterface.LATITUDE_SOUTH, UserInfo.SEX_FEMALE, "mViewWidth", "T", "mViewHeight", "U", "mBitmapWidth", "V", "mBitmapHeight", "W", "mLastFocusX", "X", "mLastFocusY", "Y", "mBaseScale", "Z", "mMaxScale", "Landroid/graphics/RectF;", "a0", "Landroid/graphics/RectF;", "mBaseBounds", "b0", "Landroid/graphics/Matrix;", "mBaseMatrix", "c0", "mTempMatrix", "", "d0", "[F", "mTempValues", "e0", "mTempRect", "Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanRegionView;", "f0", "Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanRegionView;", "mZPlanRegionView", "Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanPortraitImageView;", "g0", "Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanPortraitImageView;", "mPortraitImageview", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;", "manager", "enableMask", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;II)V", "h0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ZPlanEditPicRawImage extends EditPicRawImageNew {

    /* renamed from: R, reason: from kotlin metadata */
    private final int mRegionShape;

    /* renamed from: S, reason: from kotlin metadata */
    private float mViewWidth;

    /* renamed from: T, reason: from kotlin metadata */
    private float mViewHeight;

    /* renamed from: U, reason: from kotlin metadata */
    private float mBitmapWidth;

    /* renamed from: V, reason: from kotlin metadata */
    private float mBitmapHeight;

    /* renamed from: W, reason: from kotlin metadata */
    private float mLastFocusX;

    /* renamed from: X, reason: from kotlin metadata */
    private float mLastFocusY;

    /* renamed from: Y, reason: from kotlin metadata */
    private float mBaseScale;

    /* renamed from: Z, reason: from kotlin metadata */
    private float mMaxScale;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final RectF mBaseBounds;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Matrix mBaseMatrix;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Matrix mTempMatrix;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final float[] mTempValues;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final RectF mTempRect;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ZPlanRegionView mZPlanRegionView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private ZPlanPortraitImageView mPortraitImageview;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/aioeditor/takevideo/ZPlanEditPicRawImage$b", "Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;", "Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanPortraitImageView;", "e0", "Landroid/graphics/Matrix;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements ai {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.ai
        public ZPlanPortraitImageView e0() {
            ZPlanPortraitImageView zPlanPortraitImageView = ZPlanEditPicRawImage.this.mPortraitImageview;
            if (zPlanPortraitImageView != null) {
                return zPlanPortraitImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            return null;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.ai
        public Matrix z() {
            return ZPlanEditPicRawImage.this.mBaseMatrix;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEditPicRawImage(EditVideoPartManager manager, int i3, int i16) {
        super(manager, i3);
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.mRegionShape = i16;
        this.mBaseScale = 1.0f;
        this.mMaxScale = 3.0f;
        this.mBaseBounds = new RectF();
        this.mBaseMatrix = new Matrix();
        this.mTempMatrix = new Matrix();
        this.mTempValues = new float[9];
        this.mTempRect = new RectF();
    }

    private final void F0(int cropWidth) {
        ZPlanRegionView zPlanRegionView = this.mZPlanRegionView;
        ZPlanRegionView zPlanRegionView2 = null;
        if (zPlanRegionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanRegionView");
            zPlanRegionView = null;
        }
        int width = zPlanRegionView.getWidth();
        ZPlanRegionView zPlanRegionView3 = this.mZPlanRegionView;
        if (zPlanRegionView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanRegionView");
            zPlanRegionView3 = null;
        }
        int height = zPlanRegionView3.getHeight();
        QLog.i("ZPlanEditPicRawImage", 1, "regionView width = " + width + ", regionView height = " + height);
        int i3 = (width - cropWidth) / 2;
        float f16 = ((float) height) * 0.14778325f;
        int i16 = (width + cropWidth) / 2;
        float f17 = ((float) cropWidth) + f16;
        ZPlanRegionView zPlanRegionView4 = this.mZPlanRegionView;
        if (zPlanRegionView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanRegionView");
        } else {
            zPlanRegionView2 = zPlanRegionView4;
        }
        zPlanRegionView2.setRegionPosition(i3, (int) f16, i16, (int) f17);
    }

    private final int G0() {
        int k3 = this.mParent.C.k();
        if (k3 == 144) {
            return ViewUtils.dip2px(280.0f);
        }
        if (k3 != 145) {
            return ViewUtils.dip2px(280.0f);
        }
        return ViewUtils.dip2px(240.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(ZPlanEditPicRawImage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(ZPlanEditPicRawImage this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(ZPlanEditPicRawImage this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanPortraitImageView zPlanPortraitImageView = this$0.mPortraitImageview;
        ZPlanPortraitImageView zPlanPortraitImageView2 = null;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        int width = zPlanPortraitImageView.getWidth();
        ZPlanPortraitImageView zPlanPortraitImageView3 = this$0.mPortraitImageview;
        if (zPlanPortraitImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
        } else {
            zPlanPortraitImageView2 = zPlanPortraitImageView3;
        }
        int height = zPlanPortraitImageView2.getHeight();
        if (!z16 || width <= 0 || height <= 0) {
            return;
        }
        this$0.s0();
        this$0.x0(width, height);
    }

    private final void K0() {
        Bitmap bitmap = this.f67707e;
        if (bitmap != null && !bitmap.isRecycled()) {
            ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
            ZPlanPortraitImageView zPlanPortraitImageView2 = null;
            if (zPlanPortraitImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                zPlanPortraitImageView = null;
            }
            int width = zPlanPortraitImageView.getWidth();
            ZPlanPortraitImageView zPlanPortraitImageView3 = this.mPortraitImageview;
            if (zPlanPortraitImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            } else {
                zPlanPortraitImageView2 = zPlanPortraitImageView3;
            }
            int height = zPlanPortraitImageView2.getHeight();
            QLog.i("ZPlanEditPicRawImage", 1, "current portraitView width = " + width + ", current portraitView height = " + height);
            if (((int) this.mViewWidth) == width && ((int) this.mViewHeight) == height) {
                return;
            }
            EditPicRawImage.Q = height;
            s0();
            x0(width, height);
            return;
        }
        QLog.e("ZPlanEditPicRawImage", 1, "display bitmap is invalid");
    }

    private final void s0() {
        float f16;
        float f17;
        float coerceAtLeast;
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        if (zPlanPortraitImageView.getWidth() > 0) {
            ZPlanPortraitImageView zPlanPortraitImageView2 = this.mPortraitImageview;
            if (zPlanPortraitImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                zPlanPortraitImageView2 = null;
            }
            if (zPlanPortraitImageView2.getHeight() > 0) {
                ZPlanPortraitImageView zPlanPortraitImageView3 = this.mPortraitImageview;
                if (zPlanPortraitImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                    zPlanPortraitImageView3 = null;
                }
                Drawable drawable = zPlanPortraitImageView3.getDrawable();
                if (drawable == null) {
                    QLog.d("ZPlanEditPicRawImage", 1, "image view with no drawable");
                    return;
                }
                this.mBitmapWidth = drawable.getIntrinsicWidth();
                float intrinsicHeight = drawable.getIntrinsicHeight();
                this.mBitmapHeight = intrinsicHeight;
                if (this.mBitmapWidth > 0.0f && intrinsicHeight > 0.0f) {
                    ZPlanPortraitImageView zPlanPortraitImageView4 = this.mPortraitImageview;
                    if (zPlanPortraitImageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                        zPlanPortraitImageView4 = null;
                    }
                    this.mViewWidth = zPlanPortraitImageView4.getWidth();
                    ZPlanPortraitImageView zPlanPortraitImageView5 = this.mPortraitImageview;
                    if (zPlanPortraitImageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                        zPlanPortraitImageView5 = null;
                    }
                    float height = zPlanPortraitImageView5.getHeight();
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
                    QLog.i("ZPlanEditPicRawImage", 1, "bitmap width = " + f19 + "bitmap height = " + f27 + "scale = " + this.mBaseScale + ", tx = " + f17 + ", ty = " + f16);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mBaseScale, this.mMaxScale);
                    this.mMaxScale = coerceAtLeast;
                    this.mBaseMatrix.reset();
                    Matrix matrix = this.mBaseMatrix;
                    float f36 = this.mBaseScale;
                    matrix.setScale(f36, f36);
                    this.mBaseMatrix.postTranslate(f17, f16);
                    z0(this.mBaseMatrix, false);
                    this.mBaseBounds.set(0.0f, 0.0f, this.mBitmapWidth, this.mBitmapHeight);
                    ZPlanPortraitImageView zPlanPortraitImageView6 = this.mPortraitImageview;
                    if (zPlanPortraitImageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                        zPlanPortraitImageView6 = null;
                    }
                    zPlanPortraitImageView6.getImageMatrix().mapRect(this.mBaseBounds);
                    EditVideoDoodle editVideoDoodle = this.mParent.I;
                    if (editVideoDoodle != null) {
                        if (!(this.mBitmapWidth / this.mViewWidth == this.mBitmapHeight / this.mViewHeight)) {
                            editVideoDoodle.t0(new RectF(this.mBaseBounds));
                            return;
                        } else {
                            editVideoDoodle.t0(null);
                            return;
                        }
                    }
                    return;
                }
                QLog.d("ZPlanEditPicRawImage", 1, "image view drawable size is not ready");
                return;
            }
        }
        QLog.e("ZPlanEditPicRawImage", 1, "initImageMatrix failed, view size invalid.");
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int fragmentIndex, fs.b generateContext) {
        Intrinsics.checkNotNullParameter(generateContext, "generateContext");
        super.editVideoPrePublish(fragmentIndex, generateContext);
        publishEditExport(ai.class, new b());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int editVideoState, Object extra) {
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        zPlanPortraitImageView.setVisibility(0);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage
    public float o0() {
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        Matrix imageMatrix = zPlanPortraitImageView.getImageMatrix();
        if (imageMatrix != null) {
            imageMatrix.getValues(this.mTempValues);
        }
        return this.mTempValues[0];
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        if (this.mUi == null) {
            return;
        }
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setVideoDuration(-1L);
        ZPlanRegionView zPlanRegionView = null;
        if (g.f(this.mParent.C.E)) {
            this.f67708f.obtainMessage(999, Long.valueOf(this.mParent.C.E)).sendToTarget();
        } else {
            ThreadManagerV2.excute(this, 16, null, false);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZPlanPortraitImageView zPlanPortraitImageView = new ZPlanPortraitImageView(context);
        this.mPortraitImageview = zPlanPortraitImageView;
        ViewTreeObserver viewTreeObserver = zPlanPortraitImageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.ag
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    ZPlanEditPicRawImage.H0(ZPlanEditPicRawImage.this);
                }
            });
        }
        final int G0 = G0();
        ZPlanPortraitImageView zPlanPortraitImageView2 = this.mPortraitImageview;
        if (zPlanPortraitImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView2 = null;
        }
        zPlanPortraitImageView2.setCropRestrict(G0, G0);
        View findViewSure = findViewSure(R.id.rsn);
        Intrinsics.checkNotNull(findViewSure, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) findViewSure;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ZPlanPortraitImageView zPlanPortraitImageView3 = this.mPortraitImageview;
        if (zPlanPortraitImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView3 = null;
        }
        relativeLayout.addView(zPlanPortraitImageView3, 1, layoutParams);
        relativeLayout.setBackgroundColor(-1);
        ZPlanPortraitImageView zPlanPortraitImageView4 = this.mPortraitImageview;
        if (zPlanPortraitImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView4 = null;
        }
        ViewParent parent = zPlanPortraitImageView4.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ZPlanRegionView zPlanRegionView2 = new ZPlanRegionView(context2, G0, G0, this.mRegionShape);
        this.mZPlanRegionView = zPlanRegionView2;
        ((ViewGroup) parent).addView(zPlanRegionView2, layoutParams2);
        ZPlanRegionView zPlanRegionView3 = this.mZPlanRegionView;
        if (zPlanRegionView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanRegionView");
        } else {
            zPlanRegionView = zPlanRegionView3;
        }
        zPlanRegionView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.ah
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ZPlanEditPicRawImage.I0(ZPlanEditPicRawImage.this, G0);
            }
        });
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage, android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanEditPicRawImage", 2, "onLayoutChange, height pixel change,bottom:" + bottom + " oldBottom:" + oldBottom + " top:" + top + " oldTop:" + oldTop);
        }
        if (oldBottom != bottom && EditPicRawImage.Q == 0 && bottom > 0) {
            EditPicRawImage.Q = bottom - top;
        }
        final boolean z16 = (oldRight - oldLeft == right - left && oldBottom - oldTop == bottom - top) ? false : true;
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        zPlanPortraitImageView.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.af
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEditPicRawImage.J0(ZPlanEditPicRawImage.this, z16);
            }
        });
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage
    public void t0(float factor, float focusX, float focusY) {
        float coerceAtLeast;
        float coerceAtMost;
        float o06 = this.mMaxScale / o0();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mBaseScale / o0(), factor);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(o06, coerceAtLeast);
        if (Math.abs(coerceAtMost - 1) < 1.0E-6d) {
            return;
        }
        Matrix matrix = this.mTempMatrix;
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        matrix.set(zPlanPortraitImageView.getImageMatrix());
        this.mTempMatrix.postTranslate(focusX - this.mLastFocusX, focusY - this.mLastFocusY);
        this.mTempMatrix.postScale(coerceAtMost, coerceAtMost, focusX, focusY);
        z0(this.mTempMatrix, true);
        this.mLastFocusX = focusX;
        this.mLastFocusY = focusY;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage
    public void y0(Bitmap bitmap, boolean keepDoodle) {
        boolean equals;
        Bitmap bitmap2 = this.f67707e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f67707e.recycle();
        }
        boolean z16 = false;
        if (bitmap != null && bitmap.isRecycled()) {
            z16 = true;
        }
        if (z16) {
            QLog.w("ZPlanEditPicRawImage", 1, "setBitmap invalid:" + bitmap);
            return;
        }
        this.f67707e = bitmap;
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        ZPlanPortraitImageView zPlanPortraitImageView2 = null;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        zPlanPortraitImageView.setImageBitmap(this.f67707e);
        ZPlanPortraitImageView zPlanPortraitImageView3 = this.mPortraitImageview;
        if (zPlanPortraitImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView3 = null;
        }
        zPlanPortraitImageView3.setScaleType(ImageView.ScaleType.MATRIX);
        s0();
        equals = StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, "Letv", true);
        if (equals) {
            ZPlanPortraitImageView zPlanPortraitImageView4 = this.mPortraitImageview;
            if (zPlanPortraitImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                zPlanPortraitImageView4 = null;
            }
            zPlanPortraitImageView4.destroyDrawingCache();
            ZPlanPortraitImageView zPlanPortraitImageView5 = this.mPortraitImageview;
            if (zPlanPortraitImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                zPlanPortraitImageView5 = null;
            }
            zPlanPortraitImageView5.refreshDrawableState();
            ZPlanPortraitImageView zPlanPortraitImageView6 = this.mPortraitImageview;
            if (zPlanPortraitImageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
                zPlanPortraitImageView6 = null;
            }
            zPlanPortraitImageView6.invalidate();
        }
        if (keepDoodle || this.f67707e == null) {
            return;
        }
        ZPlanPortraitImageView zPlanPortraitImageView7 = this.mPortraitImageview;
        if (zPlanPortraitImageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView7 = null;
        }
        int width = zPlanPortraitImageView7.getWidth();
        ZPlanPortraitImageView zPlanPortraitImageView8 = this.mPortraitImageview;
        if (zPlanPortraitImageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
        } else {
            zPlanPortraitImageView2 = zPlanPortraitImageView8;
        }
        int height = zPlanPortraitImageView2.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        QLog.i("ZPlanEditPicRawImage", 1, "resizeDoodleView image width: " + width + ", height: " + height);
        x0(width, height);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z0(Matrix matrix, boolean adjustBounds) {
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
        ZPlanPortraitImageView zPlanPortraitImageView = this.mPortraitImageview;
        ZPlanPortraitImageView zPlanPortraitImageView2 = null;
        if (zPlanPortraitImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            zPlanPortraitImageView = null;
        }
        zPlanPortraitImageView.setImageMatrix(matrix);
        this.mBaseMatrix.invert(this.mTempMatrix);
        Matrix matrix2 = this.mTempMatrix;
        ZPlanPortraitImageView zPlanPortraitImageView3 = this.mPortraitImageview;
        if (zPlanPortraitImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
        } else {
            zPlanPortraitImageView2 = zPlanPortraitImageView3;
        }
        matrix2.postConcat(zPlanPortraitImageView2.getImageMatrix());
        EditVideoDoodle editVideoDoodle = this.mParent.I;
        if (editVideoDoodle != null) {
            editVideoDoodle.u0(this.mTempMatrix);
        }
    }
}
