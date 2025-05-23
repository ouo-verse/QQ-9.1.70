package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMaskView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0011\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KB\u001b\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bJ\u0010NB#\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010O\u001a\u00020\u000e\u00a2\u0006\u0004\bJ\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ0\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0015J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\fR\u0014\u0010\u001f\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0014\u0010!\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010 R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\"R*\u0010*\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010-\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R*\u00101\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'\"\u0004\b0\u0010)R*\u00105\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010%\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010%R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010%R\u0014\u0010;\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010:R\u0014\u0010=\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010?\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0014\u0010A\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010D\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropView;", "Landroid/widget/FrameLayout;", "", "k", "j", "Landroid/graphics/RectF;", "cropRectF", "d", "", "width", "height", "setResourceSize", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "shouldDelayChildPressedState", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView;", "f", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView;", "g", "enable", "setEnableAutoAdjust", "i", "e", tl.h.F, "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView;", "editorGestureTextureView", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView;", "maskView", "Z", "enableAutoAdjust", "value", UserInfo.SEX_FEMALE, "getResPaddingLeft", "()F", "setResPaddingLeft", "(F)V", "resPaddingLeft", "getResPaddingTop", "setResPaddingTop", "resPaddingTop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getResPaddingRight", "setResPaddingRight", "resPaddingRight", BdhLogUtil.LogTag.Tag_Conn, "getResPaddingBottom", "setResPaddingBottom", "resPaddingBottom", "D", "resourceWidth", "E", "resourceHeight", "Landroid/graphics/RectF;", "originRectF", "G", "imageRectF", "H", "resImageRectF", "I", "maskRectF", "Landroid/graphics/Matrix;", "J", "Landroid/graphics/Matrix;", "maskMatrix", "K", "resImageMatrix", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorCropView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float resPaddingBottom;

    /* renamed from: D, reason: from kotlin metadata */
    private float resourceWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private float resourceHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RectF originRectF;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final RectF imageRectF;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final RectF resImageRectF;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RectF maskRectF;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Matrix maskMatrix;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Matrix resImageMatrix;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoEditorGestureTextureView editorGestureTextureView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoEditorCropMaskView maskView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableAutoAdjust;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float resPaddingLeft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float resPaddingTop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float resPaddingRight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropView$b", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$c;", "Landroid/graphics/RectF;", "cropRect", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements VideoEditorCropMaskView.c {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMaskView.c
        public void a(@NotNull RectF cropRect) {
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            if (VideoEditorCropView.this.enableAutoAdjust) {
                VideoEditorCropView.this.d(cropRect);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropView$c", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$d;", "", HippyTKDListViewAdapter.X, "y", "preX", "preY", "Landroid/graphics/PointF;", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements VideoEditorCropMaskView.d {
        c() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMaskView.d
        @NotNull
        public PointF a(float x16, float y16, float preX, float preY) {
            float[] c16 = VideoEditorCropView.this.editorGestureTextureView.c();
            com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
            if (iVar.l(c16, new PointF(x16, y16))) {
                return new PointF(x16, y16);
            }
            PointF c17 = iVar.c(c16, new PointF(x16, y16));
            if (c17 == null) {
                return new PointF(preX, preY);
            }
            return c17;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(RectF cropRectF) {
        boolean z16;
        float width;
        RectF rectF;
        float f16 = this.resPaddingLeft;
        RectF rectF2 = new RectF(f16, this.resPaddingTop, this.maskView.getMThisWidth() + f16, this.resPaddingTop + this.maskView.getMThisHeight());
        float mThisWidth = this.maskView.getMThisWidth() / this.maskView.getMThisHeight();
        float width2 = cropRectF.width() / cropRectF.height();
        if (this.maskView.getMTargetAspectRatio() == width2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.maskView.setTargetAspectRatioWhenFreeRatio(width2);
        }
        if (width2 < mThisWidth) {
            width = rectF2.height() / cropRectF.height();
            rectF = new RectF(rectF2.centerX() - ((cropRectF.width() * width) / 2.0f), this.resPaddingTop, rectF2.centerX() + ((cropRectF.width() * width) / 2), this.resPaddingTop + rectF2.height());
        } else {
            width = rectF2.width() / cropRectF.width();
            rectF = new RectF(this.resPaddingLeft, rectF2.centerY() - ((cropRectF.height() * width) / 2.0f), this.resPaddingLeft + rectF2.width(), rectF2.centerY() + ((cropRectF.height() * width) / 2.0f));
        }
        float centerX = rectF2.centerX() - cropRectF.centerX();
        float centerY = rectF2.centerY() - cropRectF.centerY();
        VideoEditorGestureTextureView videoEditorGestureTextureView = this.editorGestureTextureView;
        Matrix matrix = new Matrix();
        matrix.postScale(width, width, cropRectF.centerX(), cropRectF.centerY());
        matrix.postTranslate(centerX, centerY);
        videoEditorGestureTextureView.p(matrix);
        this.editorGestureTextureView.setCropRect(rectF);
        this.maskView.setCropViewRect(rectF);
    }

    private final void j() {
        this.maskView.setOverlayViewChangeListener(new b());
        this.maskView.setRectCornerMoveInterceptor(new c());
    }

    private final void k() {
        this.maskView.setResPadding(this.resPaddingLeft, this.resPaddingTop, this.resPaddingRight, this.resPaddingBottom);
    }

    @NotNull
    public final RectF e() {
        RectF rectF = new RectF(0.0f, 0.0f, this.resourceWidth, this.resourceHeight);
        RectF f16 = this.editorGestureTextureView.f();
        float width = f16.width() / rectF.width();
        float[] fArr = new float[2];
        this.editorGestureTextureView.d().mapPoints(fArr, new float[]{f16.left, f16.top});
        RectF f17 = this.maskView.f();
        Matrix matrix = new Matrix();
        matrix.postTranslate(-fArr[0], -fArr[1]);
        float f18 = 1;
        matrix.postScale(f18 / (this.editorGestureTextureView.e() * width), f18 / (this.editorGestureTextureView.e() * width));
        matrix.mapRect(f17);
        return f17;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final VideoEditorGestureTextureView getEditorGestureTextureView() {
        return this.editorGestureTextureView;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final VideoEditorCropMaskView getMaskView() {
        return this.maskView;
    }

    public final boolean h() {
        if (this.editorGestureTextureView.getIsTouchReleased() && this.maskView.getIsTouchReleased()) {
            return true;
        }
        return false;
    }

    public final void i() {
        boolean z16;
        boolean z17 = false;
        setEnableAutoAdjust(false);
        if (this.maskView.f().width() == this.maskView.getMThisWidth()) {
            z16 = true;
        } else {
            z16 = false;
        }
        float f16 = 1.0f;
        if (z16) {
            f16 = RangesKt___RangesKt.coerceAtMost((this.maskView.getMThisHeight() * 1.0f) / this.maskView.f().width(), (this.maskView.getMThisWidth() * 1.0f) / this.maskView.f().height());
        } else {
            if (this.maskView.f().height() == this.maskView.getMThisHeight()) {
                z17 = true;
            }
            if (z17) {
                f16 = RangesKt___RangesKt.coerceAtMost((this.maskView.getMThisWidth() * 1.0f) / this.maskView.f().height(), (this.maskView.getMThisHeight() * 1.0f) / this.maskView.f().width());
            }
        }
        this.editorGestureTextureView.E(-90.0f);
        this.editorGestureTextureView.F(f16);
        VideoEditorCropMaskView videoEditorCropMaskView = this.maskView;
        videoEditorCropMaskView.setTargetAspectRatio(1 / videoEditorCropMaskView.getMTargetAspectRatio(), this.maskView.getMTargetAspectType());
        setEnableAutoAdjust(true);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        boolean z16;
        boolean z17 = true;
        if (this.resourceWidth == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.resourceHeight != -1.0f) {
                z17 = false;
            }
            if (!z17) {
                int paddingLeft = ((right - left) - getPaddingLeft()) - getPaddingRight();
                int paddingTop = ((bottom - top) - getPaddingTop()) - getPaddingBottom();
                float f16 = paddingLeft;
                float f17 = (f16 - this.resPaddingLeft) - this.resPaddingRight;
                float f18 = paddingTop;
                float f19 = (f18 - this.resPaddingTop) - this.resPaddingBottom;
                float f26 = this.resourceWidth / this.resourceHeight;
                this.originRectF.set(0.0f, 0.0f, f16, f18);
                float f27 = f17 / f26;
                if (f27 < f19) {
                    float f28 = (f18 - (f16 / f26)) / 2.0f;
                    this.imageRectF.set(0.0f, f28, f16, f18 - f28);
                    RectF rectF = this.resImageRectF;
                    float f29 = this.resPaddingLeft;
                    float f36 = (f19 - f27) / 2.0f;
                    rectF.set(f29, this.resPaddingTop + f36, f17 + f29, (f18 - this.resPaddingBottom) - f36);
                } else {
                    float f37 = (f16 - (f18 * f26)) / 2.0f;
                    this.imageRectF.set(f37, 0.0f, f16 - f37, f18);
                    RectF rectF2 = this.resImageRectF;
                    float f38 = (f16 - (f26 * f19)) / 2.0f;
                    float f39 = this.resPaddingTop;
                    rectF2.set(f38, f39, f16 - f38, f19 + f39);
                }
                this.maskMatrix.setRectToRect(this.originRectF, this.resImageRectF, Matrix.ScaleToFit.CENTER);
                this.resImageMatrix.setRectToRect(this.imageRectF, this.resImageRectF, Matrix.ScaleToFit.CENTER);
                this.maskMatrix.mapRect(this.maskRectF, this.originRectF);
                this.maskView.setResPadding(this.resPaddingLeft, this.resPaddingTop, this.resPaddingRight, this.resPaddingBottom);
                this.editorGestureTextureView.setImageAreaMatrix(this.imageRectF);
                this.editorGestureTextureView.setOriginMatrix(this.resImageMatrix);
            }
        }
        int i3 = bottom - top;
        this.editorGestureTextureView.layout(getPaddingLeft() + 0, getPaddingTop() + 0, right - getPaddingRight(), i3 - getPaddingBottom());
        this.maskView.layout(getPaddingLeft() + 0, getPaddingTop() + 0, right - getPaddingRight(), i3 - getPaddingBottom());
    }

    public final void setEnableAutoAdjust(boolean enable) {
        this.enableAutoAdjust = enable;
        if (enable) {
            d(this.maskView.f());
        }
    }

    public final void setResPaddingBottom(float f16) {
        boolean z16;
        if (this.resPaddingBottom == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.resPaddingBottom = f16;
        k();
        requestLayout();
    }

    public final void setResPaddingLeft(float f16) {
        boolean z16;
        if (this.resPaddingLeft == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.resPaddingLeft = f16;
        k();
        requestLayout();
    }

    public final void setResPaddingRight(float f16) {
        boolean z16;
        if (this.resPaddingRight == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.resPaddingRight = f16;
        k();
        requestLayout();
    }

    public final void setResPaddingTop(float f16) {
        boolean z16;
        if (this.resPaddingTop == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.resPaddingTop = f16;
        k();
        requestLayout();
    }

    public final void setResourceSize(float width, float height) {
        if (width > 0.0f && height > 0.0f) {
            this.resourceWidth = width;
            this.resourceHeight = height;
            postInvalidate();
        } else {
            this.resourceWidth = -1.0f;
            this.resourceHeight = -1.0f;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        VideoEditorGestureTextureView videoEditorGestureTextureView = new VideoEditorGestureTextureView(context2);
        this.editorGestureTextureView = videoEditorGestureTextureView;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        VideoEditorCropMaskView videoEditorCropMaskView = new VideoEditorCropMaskView(context3);
        this.maskView = videoEditorCropMaskView;
        this.resourceWidth = -1.0f;
        this.resourceHeight = -1.0f;
        this.originRectF = new RectF();
        this.imageRectF = new RectF();
        this.resImageRectF = new RectF();
        this.maskRectF = new RectF();
        this.maskMatrix = new Matrix();
        this.resImageMatrix = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.qqvideoedit.d.J6);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026eable.WinkEditorCropView)");
        setResPaddingLeft(obtainStyledAttributes.getDimension(com.tencent.mobileqq.qqvideoedit.d.L6, this.resPaddingLeft));
        setResPaddingTop(obtainStyledAttributes.getDimension(com.tencent.mobileqq.qqvideoedit.d.N6, this.resPaddingTop));
        setResPaddingRight(obtainStyledAttributes.getDimension(com.tencent.mobileqq.qqvideoedit.d.M6, this.resPaddingRight));
        setResPaddingBottom(obtainStyledAttributes.getDimension(com.tencent.mobileqq.qqvideoedit.d.K6, this.resPaddingBottom));
        obtainStyledAttributes.recycle();
        addView(videoEditorGestureTextureView);
        addView(videoEditorCropMaskView);
        videoEditorGestureTextureView.setOpaque(false);
        j();
    }
}
