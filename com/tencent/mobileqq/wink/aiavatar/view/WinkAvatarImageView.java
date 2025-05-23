package com.tencent.mobileqq.wink.aiavatar.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z53.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 p2\u00020\u0001:\u0005qrstuB'\b\u0007\u0012\u0006\u0010j\u001a\u00020i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u0012\b\b\u0002\u0010m\u001a\u00020\u001c\u00a2\u0006\u0004\bn\u0010oJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\bJ\u0018\u0010$\u001a\u00020\u00042\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000bJ\u001e\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*J&\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u0010-\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\bJ\u0006\u00102\u001a\u00020\u0004J\u0012\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000100H\u0016J\u0012\u00105\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000206H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010<R\u0016\u0010A\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010<R\u0016\u0010C\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010BR\u0016\u0010D\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010BR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010@R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010<R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010FR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010GR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bQ\u0010<R\u0016\u0010T\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010<R\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010GR\u0016\u0010\\\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010GR\u0016\u0010^\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010\u0010R\u0014\u0010`\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010@R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\b?\u0010dR\u001b\u0010h\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010c\u001a\u0004\b<\u0010g\u00a8\u0006v"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/drawable/Drawable;", "imageDrawable", "", "postInvalidate", "G", "", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "centerX", "centerY", "I", "Lz53/e;", "detector", "J", "dx", "dy", "K", "Landroid/graphics/Matrix;", "E", "enable", "B", "y", "", "widthPx", "setAnchorBarStrokeWidth", NodeProps.VISIBLE, "setBlurCornerMaskVisible", "setBlurImageVisible", "Lkotlin/Function0;", "onTapListener", "setOnTapListener", "topOffset", "setTopOffset", "Landroid/graphics/RectF;", "faceRatioRectF", "faceRatio", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$FaceFillPriority;", "faceFillPriority", "setFaceRatioRectF", "targetWidth", "targetHeight", "usedARGB", "Landroid/graphics/Bitmap;", BdhLogUtil.LogTag.Tag_Conn, "L", "bm", "setImageBitmap", "onDraw", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "drawable", "setImageDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "scaleFactor", "minScale", "D", "Landroid/graphics/RectF;", "centerAreaRectF", "Landroid/graphics/Matrix;", "initialMatrix", "imageTransMatrix", "H", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$FaceFillPriority;", "Z", "isTouchEnable", "Lkotlin/jvm/functions/Function0;", "Lkotlinx/coroutines/Job;", "M", "Lkotlinx/coroutines/Job;", "blurJob", "N", "Landroid/graphics/Bitmap;", "blurBimap", "P", "blurImageScaleFactor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "blurRadius", "Landroid/graphics/Paint;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/Paint;", "blurPaint", ExifInterface.LATITUDE_SOUTH, "showBlurCornerMask", "T", "showBlurImage", "U", "anchorBarStrokeWidthPx", "V", "drawRect", "Landroid/view/GestureDetector;", "W", "Lkotlin/Lazy;", "()Landroid/view/GestureDetector;", "gestureDetector", "a0", "()Lz53/e;", "scaleGestureDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c0", "a", "b", "FaceFillPriority", "c", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAvatarImageView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private float minScale;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private RectF centerAreaRectF;

    /* renamed from: E, reason: from kotlin metadata */
    private float topOffset;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Matrix initialMatrix;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Matrix imageTransMatrix;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private RectF faceRatioRectF;

    /* renamed from: I, reason: from kotlin metadata */
    private float faceRatio;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private FaceFillPriority faceFillPriority;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isTouchEnable;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onTapListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Job blurJob;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Bitmap blurBimap;

    /* renamed from: P, reason: from kotlin metadata */
    private final float blurImageScaleFactor;

    /* renamed from: Q, reason: from kotlin metadata */
    private float blurRadius;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Paint blurPaint;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean showBlurCornerMask;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean showBlurImage;

    /* renamed from: U, reason: from kotlin metadata */
    private int anchorBarStrokeWidthPx;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final RectF drawRect;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy gestureDetector;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scaleGestureDetector;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f317867b0;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float scaleFactor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$FaceFillPriority;", "", "(Ljava/lang/String;I)V", "LongSide", "ShortSide", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum FaceFillPriority {
        LongSide,
        ShortSide
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$a;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "distanceX", "distanceY", "", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "e", "onSingleTapUp", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            WinkAvatarImageView.this.K(-distanceX, -distanceY);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            Function0 function0 = WinkAvatarImageView.this.onTapListener;
            if (function0 != null) {
                function0.invoke();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$c;", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animation", "", "onAnimationUpdate", "", "d", "[F", "interpolateMatrixValues", "e", "fromMatrixValues", "f", "toMatrixValues", "Landroid/graphics/Matrix;", "fromMatrix", "toMatrix", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private final class c extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final float[] interpolateMatrixValues;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final float[] fromMatrixValues;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final float[] toMatrixValues;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WinkAvatarImageView f317873h;

        public c(@NotNull WinkAvatarImageView winkAvatarImageView, @NotNull Matrix fromMatrix, Matrix toMatrix) {
            Intrinsics.checkNotNullParameter(fromMatrix, "fromMatrix");
            Intrinsics.checkNotNullParameter(toMatrix, "toMatrix");
            this.f317873h = winkAvatarImageView;
            this.interpolateMatrixValues = new float[9];
            float[] fArr = new float[9];
            this.fromMatrixValues = fArr;
            float[] fArr2 = new float[9];
            this.toMatrixValues = fArr2;
            fromMatrix.getValues(fArr);
            toMatrix.getValues(fArr2);
            setFloatValues(0.0f, 1.0f);
            setDuration(200L);
            addUpdateListener(this);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            int length = this.interpolateMatrixValues.length;
            for (int i3 = 0; i3 < length; i3++) {
                Object animatedValue = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                float[] fArr = this.interpolateMatrixValues;
                float f16 = this.fromMatrixValues[i3];
                fArr[i3] = f16 + ((this.toMatrixValues[i3] - f16) * floatValue);
            }
            this.f317873h.imageTransMatrix.setValues(this.interpolateMatrixValues);
            WinkAvatarImageView winkAvatarImageView = this.f317873h;
            winkAvatarImageView.setImageMatrix(winkAvatarImageView.imageTransMatrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$d;", "Lz53/e$a;", "Lz53/e;", "var1", "", "a", "c", "", "b", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class d implements e.a {
        public d() {
        }

        @Override // z53.e.a
        public boolean a(@NotNull z53.e var1) {
            Intrinsics.checkNotNullParameter(var1, "var1");
            WinkAvatarImageView.this.J(var1);
            return true;
        }

        @Override // z53.e.a
        public void b(@NotNull z53.e var1) {
            Intrinsics.checkNotNullParameter(var1, "var1");
        }

        @Override // z53.e.a
        public boolean c(@NotNull z53.e var1) {
            Intrinsics.checkNotNullParameter(var1, "var1");
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f317875a;

        static {
            int[] iArr = new int[FaceFillPriority.values().length];
            try {
                iArr[FaceFillPriority.LongSide.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FaceFillPriority.ShortSide.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f317875a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(Canvas canvas) {
        if ((this.showBlurCornerMask || this.showBlurImage) && this.blurBimap != null) {
            canvas.save();
            canvas.concat(this.imageTransMatrix);
            Matrix matrix = new Matrix();
            float f16 = this.blurImageScaleFactor;
            matrix.postScale(1.0f / f16, 1.0f / f16);
            Bitmap bitmap = this.blurBimap;
            Intrinsics.checkNotNull(bitmap);
            canvas.drawBitmap(bitmap, matrix, this.blurPaint);
            canvas.restore();
        }
    }

    private final GestureDetector D() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r1 < r5) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Matrix E() {
        float f16;
        float f17;
        float f18;
        if (getDrawable() == null) {
            return new Matrix(this.imageTransMatrix);
        }
        Matrix matrix = new Matrix(this.imageTransMatrix);
        float[] fArr = new float[9];
        this.imageTransMatrix.getValues(fArr);
        float f19 = fArr[0];
        float f26 = this.minScale;
        if (f19 < f26) {
            float f27 = f26 / f19;
            matrix.postScale(f27, f27);
        }
        float f28 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, getDrawable().getIntrinsicWidth() * 1.0f, getDrawable().getIntrinsicHeight() * 1.0f);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        float f29 = rectF2.left;
        RectF rectF3 = this.centerAreaRectF;
        float f36 = rectF3.left;
        if (f29 > f36 || rectF2.right < rectF3.right) {
            if (f29 <= f36) {
                f29 = rectF2.right;
                f36 = rectF3.right;
            }
            f16 = f36 - f29;
            f17 = rectF2.top;
            f18 = rectF3.top;
            if (f17 <= f18 || rectF2.bottom < rectF3.bottom) {
                if (f17 <= f18) {
                    f28 = f18 - f17;
                } else {
                    float f37 = rectF2.bottom;
                    float f38 = rectF3.bottom;
                    if (f37 < f38) {
                        f28 = f38 - f37;
                    }
                }
            }
            matrix.postTranslate(f16, f28);
            return matrix;
        }
        f16 = 0.0f;
        f17 = rectF2.top;
        f18 = rectF3.top;
        if (f17 <= f18) {
        }
        if (f17 <= f18) {
        }
        matrix.postTranslate(f16, f28);
        return matrix;
    }

    private final z53.e F() {
        return (z53.e) this.scaleGestureDetector.getValue();
    }

    private final void G(Drawable imageDrawable, boolean postInvalidate) {
        float max;
        float coerceAtMost;
        float coerceIn;
        float coerceAtMost2;
        float coerceIn2;
        if (imageDrawable != null) {
            int intrinsicWidth = imageDrawable.getIntrinsicWidth();
            float f16 = intrinsicWidth;
            float intrinsicHeight = imageDrawable.getIntrinsicHeight();
            RectF rectF = new RectF(0.0f, 0.0f, f16, intrinsicHeight);
            if (this.topOffset <= 0.0f) {
                float width = (getWidth() - Math.min(getWidth(), getHeight())) / 2.0f;
                float height = (getHeight() - Math.min(getWidth(), getHeight())) / 2.0f;
                this.centerAreaRectF = new RectF(width, height, Math.min(getWidth(), getHeight()) + width, Math.min(getWidth(), getHeight()) + height);
            } else {
                float width2 = (getWidth() - Math.min(getWidth(), getHeight())) / 2.0f;
                float f17 = this.topOffset;
                this.centerAreaRectF = new RectF(width2, f17, Math.min(getWidth(), getHeight()) + width2, Math.min(getWidth(), getHeight()) + f17);
            }
            this.minScale = (Math.min(getWidth(), getHeight()) * 1.0f) / Math.min(intrinsicWidth, r12);
            float centerX = this.centerAreaRectF.centerX() - rectF.centerX();
            float centerY = this.centerAreaRectF.centerY() - rectF.centerY();
            Matrix matrix = new Matrix();
            this.imageTransMatrix = matrix;
            matrix.postTranslate(centerX, centerY);
            Matrix matrix2 = this.imageTransMatrix;
            float f18 = this.minScale;
            matrix2.postScale(f18, f18, this.centerAreaRectF.centerX(), this.centerAreaRectF.centerY());
            this.initialMatrix.set(this.imageTransMatrix);
            if (!this.faceRatioRectF.isEmpty()) {
                RectF rectF2 = new RectF(0.0f, 0.0f, f16, intrinsicHeight);
                RectF rectF3 = new RectF();
                RectF rectF4 = this.faceRatioRectF;
                RectF rectF5 = new RectF(rectF4.left * f16, rectF4.top * intrinsicHeight, rectF4.right * f16, rectF4.bottom * intrinsicHeight);
                RectF rectF6 = new RectF();
                this.imageTransMatrix.mapRect(rectF3, rectF2);
                this.imageTransMatrix.mapRect(rectF6, rectF5);
                int i3 = e.f317875a[this.faceFillPriority.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        max = Math.min(this.faceRatioRectF.width(), this.faceRatioRectF.height());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    max = Math.max(this.faceRatioRectF.width(), this.faceRatioRectF.height());
                }
                float max2 = Math.max(1.0f, this.faceRatio / max);
                this.imageTransMatrix.postScale(max2, max2, this.centerAreaRectF.centerX(), this.centerAreaRectF.centerY());
                this.imageTransMatrix.mapRect(rectF3, rectF2);
                this.imageTransMatrix.mapRect(rectF6, rectF5);
                float f19 = rectF3.right;
                RectF rectF7 = this.centerAreaRectF;
                float f26 = f19 - rectF7.right;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(rectF3.left - rectF7.left, f26);
                coerceIn = RangesKt___RangesKt.coerceIn(rectF3.centerX() - rectF6.centerX(), coerceAtMost, f26);
                float f27 = rectF3.bottom;
                RectF rectF8 = this.centerAreaRectF;
                float f28 = f27 - rectF8.bottom;
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(rectF3.top - rectF8.top, f28);
                coerceIn2 = RangesKt___RangesKt.coerceIn(rectF3.centerY() - rectF6.centerY(), coerceAtMost2, f28);
                this.imageTransMatrix.postTranslate(coerceIn, coerceIn2);
            }
            setImageMatrix(this.imageTransMatrix);
            if (postInvalidate) {
                postInvalidate();
            }
        }
    }

    static /* synthetic */ void H(WinkAvatarImageView winkAvatarImageView, Drawable drawable, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        winkAvatarImageView.G(drawable, z16);
    }

    private final void I(float scaleX, float scaleY, float centerX, float centerY) {
        this.imageTransMatrix.postScale(scaleX, scaleY, centerX, centerY);
        setImageMatrix(this.imageTransMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(z53.e detector) {
        boolean z16;
        float f16 = detector.f();
        if (f16 > 1.0f) {
            f16 *= this.scaleFactor;
        } else {
            if (f16 == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                f16 /= this.scaleFactor;
            }
        }
        I(f16, f16, detector.getMFocusX(), detector.getMFocusY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(float dx5, float dy5) {
        this.imageTransMatrix.postTranslate(dx5, dy5);
        setImageMatrix(this.imageTransMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(WinkAvatarImageView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        H(this$0, this$0.getDrawable(), false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnTapListener$default(WinkAvatarImageView winkAvatarImageView, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        winkAvatarImageView.setOnTapListener(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WinkAvatarImageView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        H(this$0, this$0.getDrawable(), false, 2, null);
    }

    public final void B(boolean enable) {
        this.isTouchEnable = enable;
    }

    @Nullable
    public final Bitmap C(int targetWidth, int targetHeight, boolean usedARGB) {
        Bitmap.Config config;
        Bitmap bitmap;
        Bitmap.Config config2;
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                if (usedARGB) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                bitmap = createBitmap;
            }
            if (usedARGB) {
                config2 = Bitmap.Config.ARGB_8888;
            } else {
                config2 = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(targetWidth, targetHeight, config2);
            Canvas canvas2 = new Canvas(createBitmap2);
            Matrix matrix = new Matrix();
            matrix.set(this.imageTransMatrix);
            float min = Math.min(this.centerAreaRectF.width(), this.centerAreaRectF.height());
            RectF rectF = this.centerAreaRectF;
            matrix.postTranslate(-rectF.left, -rectF.top);
            float f16 = (targetWidth * 1.0f) / min;
            matrix.postScale(f16, f16);
            canvas2.drawBitmap(bitmap, matrix, new Paint(6));
            return createBitmap2;
        }
        return null;
    }

    public final void L() {
        Job job = this.blurJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.blurJob = null;
        Bitmap bitmap = this.blurBimap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.blurBimap = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        if (canvas == null) {
            return;
        }
        A(canvas);
        if (this.showBlurImage) {
            return;
        }
        int min = Math.min(getWidth(), getHeight());
        this.drawRect.left = (getWidth() - min) / 2.0f;
        RectF rectF = this.drawRect;
        float f16 = min;
        rectF.right = rectF.left + f16;
        float f17 = this.topOffset;
        if (f17 <= 0.0f) {
            rectF.top = (getHeight() - min) / 2.0f;
        } else {
            rectF.top = f17;
        }
        RectF rectF2 = this.drawRect;
        rectF2.bottom = rectF2.top + f16;
        canvas.save();
        if (this.showBlurCornerMask) {
            Path path = new Path();
            path.addCircle(this.drawRect.centerX(), this.drawRect.centerY(), (f16 * 0.5f) - (this.anchorBarStrokeWidthPx * 0.5f), Path.Direction.CCW);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isTouchEnable) {
            return true;
        }
        boolean onTouchEvent = D().onTouchEvent(event) | F().i(event);
        if ((event.getAction() & event.getAction()) == 1) {
            new c(this, this.imageTransMatrix, E()).start();
        }
        return onTouchEvent;
    }

    public final void setAnchorBarStrokeWidth(int widthPx) {
        this.anchorBarStrokeWidthPx = widthPx;
    }

    public final void setBlurCornerMaskVisible(boolean visible) {
        this.showBlurCornerMask = visible;
        invalidate();
    }

    public final void setBlurImageVisible(boolean visible) {
        RenderEffect createBlurEffect;
        this.showBlurImage = visible;
        if (visible) {
            this.blurPaint.setAlpha(255);
            if (Build.VERSION.SDK_INT >= 31) {
                float f16 = this.blurRadius;
                createBlurEffect = RenderEffect.createBlurEffect(f16, f16, Shader.TileMode.CLAMP);
                setRenderEffect(createBlurEffect);
            } else {
                this.showBlurImage = true;
            }
        } else {
            this.blurPaint.setAlpha(40);
            if (Build.VERSION.SDK_INT >= 31) {
                setRenderEffect(null);
            } else {
                this.showBlurImage = false;
            }
        }
        invalidate();
    }

    public final void setFaceRatioRectF(@NotNull RectF faceRatioRectF, float faceRatio, @NotNull FaceFillPriority faceFillPriority) {
        Intrinsics.checkNotNullParameter(faceRatioRectF, "faceRatioRectF");
        Intrinsics.checkNotNullParameter(faceFillPriority, "faceFillPriority");
        this.faceRatioRectF.set(faceRatioRectF);
        this.faceRatio = faceRatio;
        this.faceFillPriority = faceFillPriority;
        H(this, getDrawable(), false, 2, null);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(@Nullable Bitmap bm5) {
        Job launch$default;
        L();
        if (bm5 != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkAvatarImageView$setImageBitmap$1(bm5, this, null), 3, null);
            this.blurJob = launch$default;
        } else {
            super.setImageBitmap(null);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        G(drawable, false);
        super.setImageDrawable(drawable);
    }

    public final void setOnTapListener(@Nullable Function0<Unit> onTapListener) {
        this.onTapListener = onTapListener;
    }

    public final void setTopOffset(float topOffset) {
        this.topOffset = topOffset;
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.view.a
            @Override // java.lang.Runnable
            public final void run() {
                WinkAvatarImageView.M(WinkAvatarImageView.this);
            }
        });
    }

    public final void y() {
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.view.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkAvatarImageView.z(WinkAvatarImageView.this);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarImageView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f317867b0 = new LinkedHashMap();
        setScaleType(ImageView.ScaleType.MATRIX);
        this.scaleFactor = 1.03f;
        this.minScale = 1.0f;
        this.centerAreaRectF = new RectF();
        this.initialMatrix = new Matrix();
        this.imageTransMatrix = new Matrix();
        this.faceRatioRectF = new RectF();
        this.faceRatio = 0.3f;
        this.faceFillPriority = FaceFillPriority.LongSide;
        this.isTouchEnable = true;
        this.blurImageScaleFactor = 0.2f;
        this.blurRadius = ViewUtils.dpToPx(10.0f);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(40);
        this.blurPaint = paint;
        this.anchorBarStrokeWidthPx = ViewUtils.dpToPx(4.0f);
        this.drawRect = new RectF();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView$gestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                return new GestureDetector(context, new WinkAvatarImageView.a(), null, true);
            }
        });
        this.gestureDetector = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<z53.e>() { // from class: com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView$scaleGestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                return new e(context, new WinkAvatarImageView.d());
            }
        });
        this.scaleGestureDetector = lazy2;
    }

    public /* synthetic */ WinkAvatarImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
