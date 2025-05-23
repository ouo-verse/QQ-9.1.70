package com.tencent.mobileqq.wink.editor.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMaskView;
import com.tencent.mobileqq.wink.utils.u;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001XB\u0011\b\u0016\u0012\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bP\u0010QB\u001b\b\u0016\u0012\u0006\u0010O\u001a\u00020N\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u00a2\u0006\u0004\bP\u0010TB#\b\u0016\u0012\u0006\u0010O\u001a\u00020N\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\u0006\u0010U\u001a\u00020\u0010\u00a2\u0006\u0004\bP\u0010VJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ0\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0015J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005R\u0014\u0010#\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0014\u0010%\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010$R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R*\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R*\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010(\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R*\u00107\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010(\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R*\u0010;\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010(\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010(R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010(R\u0014\u0010A\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010E\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0014\u0010G\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010@R\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010J\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropView;", "Landroid/widget/FrameLayout;", "", "l", "k", "Landroid/graphics/RectF;", "cropRectF", "d", "", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "width", "height", "setResourceSize", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "shouldDelayChildPressedState", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView;", "f", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView;", tl.h.F, "enable", "setEnableAutoAdjust", "j", "e", "i", "picClip", "g", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView;", "editorGestureTextureView", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView;", "maskView", "Z", "enableAutoAdjust", UserInfo.SEX_FEMALE, "getResPaddingLeft", "()F", "setResPaddingLeft", "(F)V", "resPaddingLeft", "getResPaddingTop", "setResPaddingTop", "resPaddingTop", "getResPaddingRight", "setResPaddingRight", "resPaddingRight", BdhLogUtil.LogTag.Tag_Conn, "getResPaddingBottom", "setResPaddingBottom", "resPaddingBottom", "D", "getResBottomHeight", "setResBottomHeight", "resBottomHeight", "E", "resourceWidth", "resourceHeight", "G", "Landroid/graphics/RectF;", "originRectF", "H", "imageRectF", "I", "resImageRectF", "J", "maskRectF", "Landroid/graphics/Matrix;", "K", "Landroid/graphics/Matrix;", "maskMatrix", "L", "resImageMatrix", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorCropView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float resPaddingBottom;

    /* renamed from: D, reason: from kotlin metadata */
    private float resBottomHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private float resourceWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private float resourceHeight;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final RectF originRectF;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final RectF imageRectF;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RectF resImageRectF;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final RectF maskRectF;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Matrix maskMatrix;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Matrix resImageMatrix;

    @NotNull
    public Map<Integer, View> M;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorGestureTextureView editorGestureTextureView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorCropMaskView maskView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableAutoAdjust;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float resPaddingLeft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float resPaddingTop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float resPaddingRight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropView$b", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$b;", "Landroid/graphics/RectF;", "cropRect", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkEditorCropMaskView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMaskView.b
        public void a(@NotNull RectF cropRect) {
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            if (WinkEditorCropView.this.enableAutoAdjust) {
                WinkEditorCropView.this.d(cropRect);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropView$c", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$c;", "", HippyTKDListViewAdapter.X, "y", "preX", "preY", "Landroid/graphics/PointF;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkEditorCropMaskView.c {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMaskView.c
        @NotNull
        public PointF a(float x16, float y16, float preX, float preY) {
            float[] b16 = WinkEditorCropView.this.editorGestureTextureView.b();
            u uVar = u.f326728a;
            if (uVar.n(b16, new PointF(x16, y16))) {
                return new PointF(x16, y16);
            }
            PointF c16 = uVar.c(b16, new PointF(x16, y16));
            if (c16 == null) {
                return new PointF(preX, preY);
            }
            return c16;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(RectF cropRectF) {
        float width;
        RectF rectF;
        float f16 = this.resPaddingLeft;
        RectF rectF2 = new RectF(f16, this.resPaddingTop, this.maskView.getMThisWidth() + f16, this.resPaddingTop + this.maskView.getMThisHeight());
        float width2 = rectF2.width() / rectF2.height();
        float width3 = cropRectF.width() / cropRectF.height();
        w53.b.f("wink_crop_WinkEditorCropView", "maskRatio = " + width2 + ", cropRatio = " + width3);
        String a16 = com.tencent.mobileqq.wink.editor.util.e.a(rectF2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("maskRect: ");
        sb5.append(a16);
        w53.b.f("wink_crop_WinkEditorCropView", sb5.toString());
        if (width3 < width2) {
            width = rectF2.height() / cropRectF.height();
            rectF = new RectF(rectF2.centerX() - ((cropRectF.width() * width) / 2.0f), rectF2.top, rectF2.centerX() + ((cropRectF.width() * width) / 2.0f), rectF2.bottom);
        } else {
            width = rectF2.width() / cropRectF.width();
            rectF = new RectF(rectF2.left, rectF2.centerY() - ((cropRectF.height() * width) / 2.0f), rectF2.right, rectF2.centerY() + ((cropRectF.height() * width) / 2.0f));
        }
        w53.b.f("wink_crop_WinkEditorCropView", "targetRect: " + com.tencent.mobileqq.wink.editor.util.e.a(rectF));
        float centerX = rectF2.centerX() - cropRectF.centerX();
        float centerY = rectF2.centerY() - cropRectF.centerY();
        this.editorGestureTextureView.r(width, cropRectF.centerX(), cropRectF.centerY());
        this.editorGestureTextureView.s(centerX, centerY);
        this.maskView.setCropViewRect(rectF);
        this.editorGestureTextureView.setCropRect(rectF);
    }

    private final void k() {
        this.maskView.setOverlayViewChangeListener(new b());
        this.maskView.setRectCornerMoveInterceptor(new c());
    }

    private final void l() {
        this.maskView.setResPadding(this.resPaddingLeft, this.resPaddingTop, this.resPaddingRight, this.resPaddingBottom, this.resBottomHeight);
    }

    private final float m(float value) {
        return ((int) (value / 2)) * 2.0f;
    }

    @NotNull
    public final RectF e() {
        RectF rectF = new RectF(0.0f, 0.0f, this.resourceWidth, this.resourceHeight);
        RectF f16 = this.editorGestureTextureView.f();
        float width = f16.width() / rectF.width();
        float[] fArr = new float[2];
        this.editorGestureTextureView.d().mapPoints(fArr, new float[]{f16.left, f16.top});
        RectF c16 = this.maskView.c();
        Matrix matrix = new Matrix();
        matrix.postTranslate(-fArr[0], -fArr[1]);
        float f17 = 1;
        matrix.postScale(f17 / (this.editorGestureTextureView.e() * width), f17 / (this.editorGestureTextureView.e() * width));
        matrix.mapRect(c16);
        return c16;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final WinkEditorGestureTextureView getEditorGestureTextureView() {
        return this.editorGestureTextureView;
    }

    @NotNull
    public final RectF g(@NotNull RectF picClip) {
        Intrinsics.checkNotNullParameter(picClip, "picClip");
        RectF rectF = new RectF(0.0f, 0.0f, this.resourceWidth, this.resourceHeight);
        RectF f16 = this.editorGestureTextureView.f();
        float width = f16.width() / rectF.width();
        float[] fArr = new float[2];
        this.editorGestureTextureView.d().mapPoints(fArr, new float[]{f16.left, f16.top});
        Matrix matrix = new Matrix();
        matrix.postScale(this.editorGestureTextureView.e() * width, this.editorGestureTextureView.e() * width);
        matrix.postTranslate(fArr[0], fArr[1]);
        matrix.mapRect(picClip);
        return picClip;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final WinkEditorCropMaskView getMaskView() {
        return this.maskView;
    }

    public final boolean i() {
        return this.editorGestureTextureView.getIsTouchReleased();
    }

    public final void j() {
        boolean z16;
        boolean z17 = false;
        setEnableAutoAdjust(false);
        if (this.maskView.c().width() == this.maskView.getMThisWidth()) {
            z16 = true;
        } else {
            z16 = false;
        }
        float f16 = 1.0f;
        if (z16) {
            f16 = RangesKt___RangesKt.coerceAtMost((this.maskView.getMThisHeight() * 1.0f) / this.maskView.c().width(), (this.maskView.getMThisWidth() * 1.0f) / this.maskView.c().height());
        } else {
            if (this.maskView.c().height() == this.maskView.getMThisHeight()) {
                z17 = true;
            }
            if (z17) {
                f16 = RangesKt___RangesKt.coerceAtMost((this.maskView.getMThisWidth() * 1.0f) / this.maskView.c().height(), (this.maskView.getMThisHeight() * 1.0f) / this.maskView.c().width());
            }
        }
        this.editorGestureTextureView.K(90.0f);
        this.editorGestureTextureView.L(f16);
        WinkEditorCropMaskView winkEditorCropMaskView = this.maskView;
        winkEditorCropMaskView.setTargetAspectRatio(1 / winkEditorCropMaskView.getMTargetAspectRatio(), this.maskView.getMTargetAspectType());
        setEnableAutoAdjust(true);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        boolean z16;
        float f16;
        float f17;
        w53.b.a("wink_crop_WinkEditorCropView", "onLayout changed:" + changed + " ,left:" + left + ", top:" + top + ", right:" + right + ", bottom:" + bottom + " ,paddingTop:" + getPaddingTop() + ", paddingBottom:" + getPaddingBottom());
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
                float f18 = paddingLeft;
                float f19 = (f18 - this.resPaddingLeft) - this.resPaddingRight;
                float f26 = paddingTop;
                float f27 = ((f26 - this.resPaddingTop) - this.resPaddingBottom) - this.resBottomHeight;
                float f28 = this.resourceWidth / this.resourceHeight;
                this.originRectF.set(0.0f, 0.0f, f18, f26);
                float f29 = f19 / f28;
                if (f29 < f27) {
                    float f36 = f18 / f28;
                    this.imageRectF.set(0.0f, (f26 - f36) / 2.0f, f18, (f26 + f36) / 2.0f);
                    RectF rectF = this.resImageRectF;
                    float f37 = this.resPaddingLeft;
                    float f38 = this.resPaddingTop;
                    rectF.set(f37, ((f27 - f29) / 2.0f) + f38, f19 + f37, f38 + ((f27 + f29) / 2.0f));
                } else {
                    float f39 = f27 * f28;
                    float f46 = this.resourceHeight;
                    float f47 = this.resourceWidth;
                    if ((f18 / f47) * f46 <= f26) {
                        f17 = f46 * (f18 / f47);
                        f16 = f18;
                    } else {
                        f16 = f28 * f26;
                        f17 = f26;
                    }
                    this.imageRectF.set((f18 - f16) / 2.0f, (f26 - f17) / 2.0f, (f16 + f18) / 2.0f, (f26 + f17) / 2.0f);
                    RectF rectF2 = this.resImageRectF;
                    float f48 = (f18 - f39) / 2.0f;
                    float f49 = this.resPaddingTop;
                    rectF2.set(f48, f49, f18 - f48, f27 + f49);
                }
                w53.b.a("wink_crop_WinkEditorCropView", "onLayout srcRect:" + com.tencent.mobileqq.wink.editor.util.e.a(this.imageRectF) + ", dstRect:" + com.tencent.mobileqq.wink.editor.util.e.a(this.resImageRectF));
                this.maskMatrix.setRectToRect(this.originRectF, this.resImageRectF, Matrix.ScaleToFit.CENTER);
                this.resImageMatrix.setRectToRect(this.imageRectF, this.resImageRectF, Matrix.ScaleToFit.CENTER);
                this.maskMatrix.mapRect(this.maskRectF, this.originRectF);
                this.maskView.setResPadding(this.resPaddingLeft, this.resPaddingTop, this.resPaddingRight, this.resPaddingBottom, this.resBottomHeight);
                this.editorGestureTextureView.v(this.imageRectF, this.resImageMatrix);
                this.editorGestureTextureView.setImageAreaMatrix(this.imageRectF);
                this.editorGestureTextureView.setOriginMatrix(this.resImageMatrix);
            }
        }
        this.editorGestureTextureView.layout(getPaddingLeft() + left, getPaddingTop() + top, right - getPaddingRight(), bottom - getPaddingBottom());
        this.maskView.layout(left + getPaddingLeft(), top + getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
    }

    public final void setEnableAutoAdjust(boolean enable) {
        this.enableAutoAdjust = enable;
        if (enable) {
            d(this.maskView.c());
        }
    }

    public final void setResBottomHeight(float f16) {
        boolean z16;
        if (this.resBottomHeight == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.resBottomHeight = m(f16);
        l();
        requestLayout();
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
        this.resPaddingBottom = m(f16);
        l();
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
        this.resPaddingLeft = m(f16);
        l();
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
        this.resPaddingRight = m(f16);
        l();
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
        this.resPaddingTop = m(f16);
        l();
        requestLayout();
    }

    public final void setResourceSize(float width, float height) {
        if (width > 0.0f && height > 0.0f) {
            this.resourceWidth = width;
            this.resourceHeight = height;
            requestLayout();
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
    public WinkEditorCropView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.M = new LinkedHashMap();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        WinkEditorGestureTextureView winkEditorGestureTextureView = new WinkEditorGestureTextureView(context2);
        this.editorGestureTextureView = winkEditorGestureTextureView;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        WinkEditorCropMaskView winkEditorCropMaskView = new WinkEditorCropMaskView(context3);
        this.maskView = winkEditorCropMaskView;
        this.resourceWidth = -1.0f;
        this.resourceHeight = -1.0f;
        this.originRectF = new RectF();
        this.imageRectF = new RectF();
        this.resImageRectF = new RectF();
        this.maskRectF = new RectF();
        this.maskMatrix = new Matrix();
        this.resImageMatrix = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.f323328u9);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026eable.WinkEditorCropView)");
        setResPaddingLeft(obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.f323362x9, this.resPaddingLeft));
        setResPaddingTop(obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.f323386z9, this.resPaddingTop));
        setResPaddingRight(obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.f323374y9, this.resPaddingRight));
        setResPaddingBottom(obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.f323350w9, this.resPaddingBottom));
        setResBottomHeight(obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.f323339v9, this.resBottomHeight));
        obtainStyledAttributes.recycle();
        addView(winkEditorGestureTextureView);
        addView(winkEditorCropMaskView);
        winkEditorGestureTextureView.setOpaque(false);
        k();
    }
}
