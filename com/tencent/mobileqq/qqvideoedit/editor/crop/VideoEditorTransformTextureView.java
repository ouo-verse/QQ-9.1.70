package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.annotation.IntRange;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 I2\u00020\u0001:\u0002%\u0013B\u0011\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u00a2\u0006\u0004\b^\u0010_B\u001b\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u00a2\u0006\u0004\b^\u0010bB#\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\u0006\u0010c\u001a\u00020\u0015\u00a2\u0006\u0004\b^\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010J \u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u001e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#J0\u0010,\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015H\u0014J\b\u0010-\u001a\u00020\u0002H\u0014R\u001a\u00101\u001a\u00020\t8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010.\u001a\u0004\b/\u00100R\u001a\u00103\u001a\u00020\t8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b2\u00100R\u0014\u00104\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010.R\"\u0010:\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010=\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\"\u0010@\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00105\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\"\u0010G\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010N\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010R\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\u0016\u0010T\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010.R\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010.R&\u0010[\u001a\u0012\u0012\u0004\u0012\u00020#0Wj\b\u0012\u0004\u0012\u00020#`X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorTransformTextureView;", "Landroid/view/TextureView;", "", "u", "Landroid/graphics/Matrix;", "transform", CanvasView.ACTION_SET_TRANSFORM, "matrix", "setOriginMatrix", "", "c", "Landroid/graphics/RectF;", "f", "rectF", "setImageAreaMatrix", "t", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "l", "", "valueIndex", DomainData.DOMAIN_NAME, "deltaX", "deltaY", ReportConstant.COSTREPORT_PREFIX, "deltaScale", "px", "py", "r", "p", "deltaAngle", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorTransformTextureView$b;", "listener", "a", "", "changed", "left", "top", "right", "bottom", "onLayout", "o", "[F", tl.h.F, "()[F", "mCurrentImageCorners", "g", "mCurrentImageCenter", "mMatrixValues", "Landroid/graphics/Matrix;", "getMOriginMatrix", "()Landroid/graphics/Matrix;", "setMOriginMatrix", "(Landroid/graphics/Matrix;)V", "mOriginMatrix", "i", "setMCurrentImageMatrix", "mCurrentImageMatrix", "getMEffectMatrix", "setMEffectMatrix", "mEffectMatrix", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/RectF;", "getMImageRectF", "()Landroid/graphics/RectF;", "setMImageRectF", "(Landroid/graphics/RectF;)V", "mImageRectF", "D", "I", "k", "()I", "setMThisWidth", "(I)V", "mThisWidth", "E", "j", "setMThisHeight", "mThisHeight", UserInfo.SEX_FEMALE, "mInitialImageCorners", "G", "mInitialImageCenter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "transformListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class VideoEditorTransformTextureView extends TextureView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private RectF mImageRectF;

    /* renamed from: D, reason: from kotlin metadata */
    private int mThisWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int mThisHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private float[] mInitialImageCorners;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private float[] mInitialImageCenter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<b> transformListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] mCurrentImageCorners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] mCurrentImageCenter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] mMatrixValues;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Matrix mOriginMatrix;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Matrix mCurrentImageMatrix;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Matrix mEffectMatrix;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorTransformTextureView$b;", "", "Landroid/graphics/Matrix;", "matrix", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull Matrix matrix);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorTransformTextureView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void u() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    public final void a(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.transformListener.contains(listener)) {
            return;
        }
        this.transformListener.add(listener);
    }

    public final float b() {
        return l(this.mCurrentImageMatrix);
    }

    @NotNull
    public final float[] c() {
        float[] fArr = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final Matrix d() {
        return new Matrix(this.mCurrentImageMatrix);
    }

    public final float e() {
        return m(this.mCurrentImageMatrix);
    }

    @NotNull
    public final RectF f() {
        return com.tencent.mobileqq.qqvideoedit.utils.i.f276251a.n(this.mInitialImageCorners);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: g, reason: from getter */
    public final float[] getMCurrentImageCenter() {
        return this.mCurrentImageCenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: h, reason: from getter */
    public final float[] getMCurrentImageCorners() {
        return this.mCurrentImageCorners;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i, reason: from getter */
    public final Matrix getMCurrentImageMatrix() {
        return this.mCurrentImageMatrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j, reason: from getter */
    public final int getMThisHeight() {
        return this.mThisHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k, reason: from getter */
    public final int getMThisWidth() {
        return this.mThisWidth;
    }

    public final float l(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        return (float) (-(Math.atan2(n(matrix, 1), n(matrix, 0)) * 57.29577951308232d));
    }

    public final float m(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        return (float) Math.sqrt(Math.pow(n(matrix, 0), 2.0d) + Math.pow(n(matrix, 3), 2.0d));
    }

    public final float n(@NotNull Matrix matrix, @IntRange(from = 0, to = 9) int valueIndex) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[valueIndex];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        RectF rectF;
        if (this.mImageRectF.isEmpty()) {
            rectF = new RectF(0.0f, 0.0f, this.mThisWidth, this.mThisHeight);
        } else {
            rectF = this.mImageRectF;
        }
        com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
        float[] f16 = iVar.f(rectF);
        float[] e16 = iVar.e(rectF);
        this.mOriginMatrix.mapPoints(this.mInitialImageCorners, f16);
        this.mOriginMatrix.mapPoints(this.mInitialImageCenter, e16);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mThisWidth = getWidth();
        this.mThisHeight = getHeight();
        o();
    }

    public final void p(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.mCurrentImageMatrix.postConcat(matrix);
        setTransform(this.mCurrentImageMatrix);
    }

    public final void q(float deltaAngle, float px5, float py5) {
        boolean z16;
        if (deltaAngle == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.mCurrentImageMatrix.postRotate(deltaAngle, px5, py5);
            setTransform(this.mCurrentImageMatrix);
        }
    }

    public void r(float deltaScale, float px5, float py5) {
        boolean z16;
        if (deltaScale == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.mCurrentImageMatrix.postScale(deltaScale, deltaScale, px5, py5);
            setTransform(this.mCurrentImageMatrix);
        }
    }

    public final void s(float deltaX, float deltaY) {
        boolean z16;
        boolean z17 = true;
        if (deltaX == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (deltaY != 0.0f) {
                z17 = false;
            }
            if (z17) {
                return;
            }
        }
        this.mCurrentImageMatrix.postTranslate(deltaX, deltaY);
        setTransform(this.mCurrentImageMatrix);
    }

    public final void setImageAreaMatrix(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        this.mImageRectF = new RectF(rectF);
    }

    public final void setOriginMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.mOriginMatrix.set(matrix);
        setTransform(this.mCurrentImageMatrix);
    }

    @Override // android.view.TextureView
    public void setTransform(@Nullable Matrix transform) {
        this.mEffectMatrix.set(this.mOriginMatrix);
        this.mCurrentImageMatrix.set(transform);
        this.mEffectMatrix.postConcat(transform);
        super.setTransform(this.mEffectMatrix);
        Iterator<T> it = this.transformListener.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(new Matrix(transform));
        }
        u();
        postInvalidate();
    }

    public final void t() {
        setTransform(new Matrix());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorTransformTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorTransformTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mOriginMatrix = new Matrix();
        this.mCurrentImageMatrix = new Matrix();
        this.mEffectMatrix = new Matrix();
        this.mImageRectF = new RectF();
        this.mInitialImageCorners = new float[8];
        this.mInitialImageCenter = new float[2];
        this.transformListener = new ArrayList<>();
    }
}
