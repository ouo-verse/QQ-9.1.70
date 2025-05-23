package com.tencent.qqnt.qbasealbum.preview.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0007\u0086\u0001\u0087\u0001\u0088\u0001;B\u0011\u0012\u0006\u0010=\u001a\u00020\u001f\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0003JP\u00101\u001a\u00020\u00152\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u00103\u001a\u000202H\u0016J\u0010\u00107\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u000105J\u0010\u00109\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u000108J\u0006\u0010:\u001a\u00020\u0015R\u0014\u0010=\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b>\u0010\"R\u0014\u0010A\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b@\u0010\"R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010\"R\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\"R\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010YR\u0017\u0010\\\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010Y\u001a\u0004\bN\u0010[R\u0014\u0010]\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010YR\u0014\u0010_\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010^R\u0014\u0010b\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010aR\u0018\u0010d\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010cR\u0018\u0010f\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010eR\u001c\u0010i\u001a\b\u0018\u00010gR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010hR\u0016\u0010j\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010GR\u0016\u0010k\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010GR\u0016\u0010l\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\"R\u0016\u0010m\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\"R\u0016\u0010n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R$\u0010q\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b8G@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bp\u0010O\u001a\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010tR\u0014\u0010x\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010wR\u0014\u0010y\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010[R\u0013\u0010|\u001a\u0004\u0018\u00010\u00198F\u00a2\u0006\u0006\u001a\u0004\bz\u0010{R%\u0010}\u001a\u00020\u00032\u0006\u0010}\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\r\u001a\u0004\bV\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0081\u0001\u001a\u00020s2\u0007\u0010\u0081\u0001\u001a\u00020s8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\bG\u0010\u0082\u0001\"\u0005\bp\u0010\u0083\u0001\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnLayoutChangeListener;", "", "dx", "dy", "", "K", "", "P", "isHorizontalSlop", "M", "isVerticalSlop", "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "L", "Landroid/graphics/Matrix;", "matrix", "", "whichValue", "J", "", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/graphics/RectF;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "drawable", "Y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", "imageView", "G", UserInfo.SEX_FEMALE, "y", "O", "degrees", "V", "Landroid/view/View;", "v", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "Landroid/view/MotionEvent;", "ev", "onTouch", "Landroid/view/View$OnLongClickListener;", "listener", "U", "Landroid/view/View$OnClickListener;", "T", "X", "d", "Landroid/widget/ImageView;", "mImageView", "e", "touchSlop", "f", "ple", "Landroid/view/animation/Interpolator;", h.F, "Landroid/view/animation/Interpolator;", "mInterpolator", "i", "I", "mZoomDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mMinScale", "mMidScale", "D", "mMaxScale", "E", "Z", "mAllowParentInterceptOnEdge", "mBlockParentIntercept", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "mGestureDetector", "Lcom/tencent/qqnt/qbasealbum/preview/view/a;", "H", "Lcom/tencent/qqnt/qbasealbum/preview/view/a;", "mScaleDragDetector", "Landroid/graphics/Matrix;", "mBaseMatrix", "()Landroid/graphics/Matrix;", "imageMatrix", "mSuppMatrix", "Landroid/graphics/RectF;", "mDisplayRect", "", "[F", "mMatrixValues", "Landroid/view/View$OnClickListener;", "mOnClickListener", "Landroid/view/View$OnLongClickListener;", "mLongClickListener", "Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$FlingRunnable;", "Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$FlingRunnable;", "mCurrentFlingRunnable", "mHorizontalScrollEdge", "mVerticalScrollEdge", "mBaseRotation", "mScaleFocusX", "mScaleFocusY", "<set-?>", "W", "isZoomEnabled", "()Z", "Landroid/widget/ImageView$ScaleType;", "Landroid/widget/ImageView$ScaleType;", "mScaleType", "Lcom/tencent/qqnt/qbasealbum/preview/view/b;", "Lcom/tencent/qqnt/qbasealbum/preview/view/b;", "onGestureListener", "drawMatrix", "B", "()Landroid/graphics/RectF;", "displayRect", "scale", "()F", "setScale", "(F)V", "scaleType", "()Landroid/widget/ImageView$ScaleType;", "(Landroid/widget/ImageView$ScaleType;)V", "<init>", "(Landroid/widget/ImageView;)V", "AnimatedZoomRunnable", "c", "FlingRunnable", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float mMidScale;

    /* renamed from: D, reason: from kotlin metadata */
    private float mMaxScale;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mAllowParentInterceptOnEdge;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mBlockParentIntercept;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.qbasealbum.preview.view.a mScaleDragDetector;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Matrix mBaseMatrix;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Matrix imageMatrix;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Matrix mSuppMatrix;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final RectF mDisplayRect;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final float[] mMatrixValues;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener mOnClickListener;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View.OnLongClickListener mLongClickListener;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private FlingRunnable mCurrentFlingRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    private int mHorizontalScrollEdge;

    /* renamed from: S, reason: from kotlin metadata */
    private int mVerticalScrollEdge;

    /* renamed from: T, reason: from kotlin metadata */
    private float mBaseRotation;

    /* renamed from: U, reason: from kotlin metadata */
    private float mScaleFocusX;

    /* renamed from: V, reason: from kotlin metadata */
    private float mScaleFocusY;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isZoomEnabled;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private ImageView.ScaleType mScaleType;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.qbasealbum.preview.view.b onGestureListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float touchSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float ple;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Interpolator mInterpolator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mZoomDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mMinScale;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$AnimatedZoomRunnable;", "Ljava/lang/Runnable;", "", "e", "", TencentLocation.RUN_MODE, "d", UserInfo.SEX_FEMALE, "mFocalX", "mFocalY", "", "f", "J", "mStartTime", h.F, "mZoomStart", "i", "mZoomEnd", "currentZoom", "targetZoom", "<init>", "(Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher;FFFF)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private final class AnimatedZoomRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float mFocalX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float mFocalY;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long mStartTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final float mZoomStart;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final float mZoomEnd;

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhotoViewAttacher.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.mFocalX = f18;
            this.mFocalY = f19;
            this.mStartTime = System.currentTimeMillis();
            this.mZoomStart = f16;
            this.mZoomEnd = f17;
        }

        private final float e() {
            float coerceAtMost;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / PhotoViewAttacher.this.mZoomDuration);
            return PhotoViewAttacher.this.mInterpolator.getInterpolation(coerceAtMost);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            final float e16 = e();
            float f16 = this.mZoomStart;
            float f17 = f16 + ((this.mZoomEnd - f16) * e16);
            final float f18 = f17 / f17;
            PhotoViewAttacher.this.onGestureListener.onScale(f18, this.mFocalX, this.mFocalY);
            if (e16 < 1.0f) {
                PhotoViewAttacher.this.mImageView.postOnAnimation(this);
                ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(e16, f18, this) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$AnimatedZoomRunnable$run$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ float $deltaScale;
                    final /* synthetic */ float $t;
                    final /* synthetic */ PhotoViewAttacher.AnimatedZoomRunnable this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$t = e16;
                        this.$deltaScale = f18;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, Float.valueOf(e16), Float.valueOf(f18), this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        float f19;
                        float f26;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        float f27 = this.$t;
                        float f28 = this.$deltaScale;
                        f19 = this.this$0.mFocalX;
                        f26 = this.this$0.mFocalY;
                        return "AnimatedZoomRunnable postOnAnimation t:" + f27 + " deltaScale:" + f28 + " mFocalX:" + f19 + " mFocalY:" + f26;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$FlingRunnable;", "Ljava/lang/Runnable;", "", "e", "", "viewWidth", "viewHeight", "velocityX", "velocityY", "f", TencentLocation.RUN_MODE, "Landroid/widget/OverScroller;", "d", "Landroid/widget/OverScroller;", "mScroller", "I", "mCurrentX", "mCurrentY", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher;Landroid/content/Context;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class FlingRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final OverScroller mScroller;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int mCurrentX;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int mCurrentY;

        public FlingRunnable(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoViewAttacher.this, (Object) context);
            } else {
                this.mScroller = new OverScroller(context);
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.mScroller.forceFinished(true);
            }
        }

        public final void f(int viewWidth, int viewHeight, int velocityX, int velocityY) {
            int roundToInt;
            int i3;
            int i16;
            int roundToInt2;
            int i17;
            int i18;
            int roundToInt3;
            int roundToInt4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(viewWidth), Integer.valueOf(viewHeight), Integer.valueOf(velocityX), Integer.valueOf(velocityY));
                return;
            }
            RectF B = PhotoViewAttacher.this.B();
            if (B != null) {
                roundToInt = MathKt__MathJVMKt.roundToInt(-B.left);
                float f16 = viewWidth;
                if (f16 < B.width()) {
                    roundToInt4 = MathKt__MathJVMKt.roundToInt(B.width() - f16);
                    i3 = 0;
                    i16 = roundToInt4;
                } else {
                    i3 = roundToInt;
                    i16 = i3;
                }
                roundToInt2 = MathKt__MathJVMKt.roundToInt(-B.top);
                float f17 = viewHeight;
                if (f17 < B.height()) {
                    roundToInt3 = MathKt__MathJVMKt.roundToInt(B.height() - f17);
                    i18 = roundToInt3;
                    i17 = 0;
                } else {
                    i17 = roundToInt2;
                    i18 = i17;
                }
                this.mCurrentX = roundToInt;
                this.mCurrentY = roundToInt2;
                if (roundToInt != i16 || roundToInt2 != i18) {
                    this.mScroller.fling(roundToInt, roundToInt2, velocityX, velocityY, i3, i16, i17, i18, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttacher.this.z();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                PhotoViewAttacher.this.mImageView.postOnAnimation(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "distanceX", "distanceY", "", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "e", "", e.a.NAME, "velocityX", "velocityY", "onFling", "onSingleTapUp", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoViewAttacher.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) e16);
                return;
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            if (PhotoViewAttacher.this.mLongClickListener != null) {
                View.OnLongClickListener onLongClickListener = PhotoViewAttacher.this.mLongClickListener;
                Intrinsics.checkNotNull(onLongClickListener);
                onLongClickListener.onLongClick(PhotoViewAttacher.this.mImageView);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, e16, e26, Float.valueOf(distanceX), Float.valueOf(distanceY))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            float f16 = 0;
            float f17 = f16 - distanceX;
            float f18 = f16 - distanceY;
            PhotoViewAttacher.this.onGestureListener.onDrag(f17, f18);
            return PhotoViewAttacher.this.O(f17, f18);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) e16)).booleanValue();
            }
            PhotoViewAttacher.t(PhotoViewAttacher.this);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$b", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "ev", "onDoubleTap", "onDoubleTapEvent", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements GestureDetector.OnDoubleTapListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoViewAttacher.this);
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ev5)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(ev5, "ev");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            PhotoViewAttacher.this.B();
            e16.getX();
            e16.getY();
            return false;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$c;", "", "", "DEFAULT_MAX_ANIM_SCALE", UserInfo.SEX_FEMALE, "DEFAULT_MAX_SCALE", "DEFAULT_MID_SCALE", "DEFAULT_MIN_ANIM_SCALE", "DEFAULT_MIN_SCALE", "", "DEFAULT_ZOOM_DURATION", "I", "HORIZONTAL_EDGE_BOTH", "HORIZONTAL_EDGE_LEFT", "HORIZONTAL_EDGE_NONE", "HORIZONTAL_EDGE_RIGHT", "SINGLE_TOUCH", "", "TAG", "Ljava/lang/String;", "VERTICAL_EDGE_BOTH", "VERTICAL_EDGE_BOTTOM", "VERTICAL_EDGE_NONE", "VERTICAL_EDGE_TOP", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$c, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher$d;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface d {
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361425a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44542);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f361425a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PhotoViewAttacher(@NotNull ImageView mImageView) {
        Intrinsics.checkNotNullParameter(mImageView, "mImageView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mImageView);
            return;
        }
        this.mImageView = mImageView;
        this.touchSlop = 8.0f;
        this.ple = 0.6f;
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.mZoomDuration = 200;
        this.mMinScale = 1.0f;
        this.mMidScale = 1.75f;
        this.mMaxScale = 3.5f;
        this.mAllowParentInterceptOnEdge = true;
        this.mBaseMatrix = new Matrix();
        this.imageMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mHorizontalScrollEdge = 2;
        this.mVerticalScrollEdge = 2;
        this.isZoomEnabled = true;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        com.tencent.qqnt.qbasealbum.preview.view.b bVar = new com.tencent.qqnt.qbasealbum.preview.view.b() { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$onGestureListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoViewAttacher.this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.preview.view.b
            public void onDrag(final float dx5, final float dy5) {
                a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    aVar = PhotoViewAttacher.this.mScaleDragDetector;
                    Intrinsics.checkNotNull(aVar);
                    if (aVar.e()) {
                        return;
                    }
                    PhotoViewAttacher.this.mSuppMatrix.postTranslate(dx5, dy5);
                    PhotoViewAttacher.this.z();
                    final PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                    ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(dx5, dy5, photoViewAttacher) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$onGestureListener$1$onDrag$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ float $dx;
                        final /* synthetic */ float $dy;
                        final /* synthetic */ PhotoViewAttacher this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$dx = dx5;
                            this.$dy = dy5;
                            this.this$0 = photoViewAttacher;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, Float.valueOf(dx5), Float.valueOf(dy5), photoViewAttacher);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            boolean z16;
                            boolean z17;
                            int i3;
                            int i16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                return (String) iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                            float f16 = this.$dx;
                            float f17 = this.$dy;
                            z16 = this.this$0.mAllowParentInterceptOnEdge;
                            z17 = this.this$0.mBlockParentIntercept;
                            i3 = this.this$0.mHorizontalScrollEdge;
                            i16 = this.this$0.mVerticalScrollEdge;
                            return "onDrag dx:" + f16 + " dy:" + f17 + " mAllowParentInterceptOnEdge:" + z16 + " mBlockParentIntercept:" + z17 + " mHorizontalScrollEdge:" + i3 + " mVerticalScrollEdge:" + i16 + " imageviewHashCode:" + this.this$0.mImageView.hashCode();
                        }
                    });
                    ViewParent parent = PhotoViewAttacher.this.mImageView.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(PhotoViewAttacher.this.O(dx5, dy5));
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Float.valueOf(dx5), Float.valueOf(dy5));
            }

            @Override // com.tencent.qqnt.qbasealbum.preview.view.b
            public void onFling(final float startX, final float startY, final float velocityX, final float velocityY) {
                PhotoViewAttacher.FlingRunnable flingRunnable;
                int G;
                int F;
                PhotoViewAttacher.FlingRunnable flingRunnable2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z16 = true;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Float.valueOf(startX), Float.valueOf(startY), Float.valueOf(velocityX), Float.valueOf(velocityY));
                    return;
                }
                final PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(startX, startY, photoViewAttacher, velocityX, velocityY) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$onGestureListener$1$onFling$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ float $startX;
                    final /* synthetic */ float $startY;
                    final /* synthetic */ float $velocityX;
                    final /* synthetic */ float $velocityY;
                    final /* synthetic */ PhotoViewAttacher this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$startX = startX;
                        this.$startY = startY;
                        this.this$0 = photoViewAttacher;
                        this.$velocityX = velocityX;
                        this.$velocityY = velocityY;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, Float.valueOf(startX), Float.valueOf(startY), photoViewAttacher, Float.valueOf(velocityX), Float.valueOf(velocityY));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (String) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        return "onFling startX:" + this.$startX + " startY:" + this.$startY + " getScale:" + this.this$0.H() + " velocityX:" + this.$velocityX + " velocityY:" + this.$velocityY;
                    }
                });
                if (PhotoViewAttacher.this.H() != 1.0f) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                photoViewAttacher2.mCurrentFlingRunnable = new PhotoViewAttacher.FlingRunnable(photoViewAttacher2.mImageView.getContext());
                flingRunnable = PhotoViewAttacher.this.mCurrentFlingRunnable;
                Intrinsics.checkNotNull(flingRunnable);
                PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                G = photoViewAttacher3.G(photoViewAttacher3.mImageView);
                PhotoViewAttacher photoViewAttacher4 = PhotoViewAttacher.this;
                F = photoViewAttacher4.F(photoViewAttacher4.mImageView);
                flingRunnable.f(G, F, (int) velocityX, (int) velocityY);
                ImageView imageView = PhotoViewAttacher.this.mImageView;
                flingRunnable2 = PhotoViewAttacher.this.mCurrentFlingRunnable;
                imageView.post(flingRunnable2);
            }

            @Override // com.tencent.qqnt.qbasealbum.preview.view.b
            public void onScale(final float scaleFactor, final float focusX, final float focusY) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Float.valueOf(scaleFactor), Float.valueOf(focusX), Float.valueOf(focusY));
                    return;
                }
                final PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(scaleFactor, photoViewAttacher, focusX, focusY) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$onGestureListener$1$onScale$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ float $focusX;
                    final /* synthetic */ float $focusY;
                    final /* synthetic */ float $scaleFactor;
                    final /* synthetic */ PhotoViewAttacher this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$scaleFactor = scaleFactor;
                        this.this$0 = photoViewAttacher;
                        this.$focusX = focusX;
                        this.$focusY = focusY;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, Float.valueOf(scaleFactor), photoViewAttacher, Float.valueOf(focusX), Float.valueOf(focusY));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (String) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        return "onScale scalefactor:" + this.$scaleFactor + " curScale:" + this.this$0.H() + " focusX:" + this.$focusX + " focusY:" + this.$focusY;
                    }
                });
                float H = PhotoViewAttacher.this.H();
                PhotoViewAttacher.this.mScaleFocusX = focusX;
                PhotoViewAttacher.this.mScaleFocusY = focusY;
                if (H <= 7.0f || scaleFactor <= 1.0f) {
                    if (H < 0.6f && scaleFactor < 1.0f) {
                        return;
                    }
                    PhotoViewAttacher.this.mSuppMatrix.postScale(scaleFactor, scaleFactor, focusX, focusY);
                    PhotoViewAttacher.this.z();
                }
            }
        };
        this.onGestureListener = bVar;
        mImageView.setOnTouchListener(this);
        mImageView.addOnLayoutChangeListener(this);
        if (!mImageView.isInEditMode()) {
            this.mBaseRotation = 0.0f;
            this.mScaleDragDetector = new com.tencent.qqnt.qbasealbum.preview.view.a(mImageView.getContext(), bVar);
            GestureDetector gestureDetector = new GestureDetector(mImageView.getContext(), new a());
            this.mGestureDetector = gestureDetector;
            Intrinsics.checkNotNull(gestureDetector);
            gestureDetector.setOnDoubleTapListener(new b());
        }
    }

    private final boolean A() {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        RectF C = C(D());
        if (C == null) {
            return false;
        }
        float height = C.height();
        float width = C.width();
        float F = F(this.mImageView);
        float f27 = 0.0f;
        if (height <= F) {
            int i3 = e.f361425a[this.mScaleType.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f19 = (F - height) / 2;
                    f26 = C.top;
                } else {
                    f19 = F - height;
                    f26 = C.top;
                }
                f16 = f19 - f26;
            } else {
                f16 = -C.top;
            }
            this.mVerticalScrollEdge = 2;
        } else {
            float f28 = C.top;
            if (f28 > 0.0f) {
                this.mVerticalScrollEdge = 0;
                f16 = -f28;
            } else {
                float f29 = C.bottom;
                if (f29 < F) {
                    this.mVerticalScrollEdge = 1;
                    f16 = F - f29;
                } else {
                    this.mVerticalScrollEdge = -1;
                    f16 = 0.0f;
                }
            }
        }
        float G = G(this.mImageView);
        if (width <= G) {
            int i16 = e.f361425a[this.mScaleType.ordinal()];
            if (i16 != 2) {
                if (i16 != 3) {
                    f17 = (G - width) / 2;
                    f18 = C.left;
                } else {
                    f17 = G - width;
                    f18 = C.left;
                }
                f27 = f17 - f18;
            } else {
                f27 = -C.left;
            }
            this.mHorizontalScrollEdge = 2;
        } else {
            float f36 = C.left;
            if (f36 > 0.0f) {
                this.mHorizontalScrollEdge = 0;
                f27 = -f36;
            } else {
                float f37 = C.right;
                if (f37 < G) {
                    f27 = G - f37;
                    this.mHorizontalScrollEdge = 1;
                } else {
                    this.mHorizontalScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f27, f16);
        return true;
    }

    private final RectF C(Matrix matrix) {
        if (this.mImageView.getDrawable() != null) {
            this.mDisplayRect.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.mDisplayRect);
            return this.mDisplayRect;
        }
        return null;
    }

    private final Matrix D() {
        this.imageMatrix.set(this.mBaseMatrix);
        this.imageMatrix.postConcat(this.mSuppMatrix);
        return this.imageMatrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private final float J(Matrix matrix, int whichValue) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[whichValue];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K(float dx5, float dy5) {
        boolean z16 = this.mAllowParentInterceptOnEdge;
        com.tencent.qqnt.qbasealbum.preview.view.a aVar = this.mScaleDragDetector;
        Intrinsics.checkNotNull(aVar);
        return "mAllowParentInterceptOnEdge:" + z16 + " isScaling:" + aVar.e() + " mBlockParentIntercept:" + this.mBlockParentIntercept + " getScale:" + H() + " mHorizontalScrollEdge:" + this.mHorizontalScrollEdge + " mVerticalScrollEdge:" + this.mVerticalScrollEdge + " dx:" + dx5 + " dy:" + dy5;
    }

    private final boolean L(float dx5, float dy5) {
        if (Math.abs(dx5) > this.touchSlop && Math.abs(dx5) > Math.abs(dy5)) {
            return true;
        }
        return false;
    }

    private final boolean M(float dx5, float dy5, boolean isHorizontalSlop) {
        if (!isHorizontalSlop || this.ple * Math.abs(dx5) <= Math.abs(dy5)) {
            return false;
        }
        int i3 = this.mHorizontalScrollEdge;
        if (i3 != 2 && ((i3 != 0 || dx5 < this.touchSlop) && (i3 != 1 || dx5 > 0 - this.touchSlop))) {
            return false;
        }
        return true;
    }

    private final boolean N(float dx5, float dy5, boolean isVerticalSlop) {
        if (!isVerticalSlop || this.ple * Math.abs(dy5) <= Math.abs(dx5)) {
            return false;
        }
        int i3 = this.mVerticalScrollEdge;
        if (i3 != 2 && ((i3 != 0 || dy5 < this.touchSlop) && (i3 != 1 || dy5 > 0 - this.touchSlop))) {
            return false;
        }
        return true;
    }

    private final boolean P(float dx5, float dy5) {
        int i3 = this.mVerticalScrollEdge;
        if (i3 == 0 && this.mHorizontalScrollEdge == 0) {
            float f16 = this.touchSlop;
            if (dy5 >= f16 && dx5 >= f16) {
                return true;
            }
        }
        if (i3 == 0 && this.mHorizontalScrollEdge == 1) {
            float f17 = this.touchSlop;
            if (dy5 >= f17 && dx5 <= 0 - f17) {
                return true;
            }
        }
        if (i3 == 1 && this.mHorizontalScrollEdge == 0) {
            float f18 = this.touchSlop;
            if (dy5 <= 0 - f18 && dx5 >= f18) {
                return true;
            }
        }
        if (i3 == 1 && this.mHorizontalScrollEdge == 1) {
            float f19 = 0;
            float f26 = this.touchSlop;
            if (dy5 <= f19 - f26 && dx5 <= f19 - f26) {
                return true;
            }
        }
        return false;
    }

    private final boolean Q(float dx5, float dy5) {
        if (Math.abs(dy5) > this.touchSlop && Math.abs(dy5) > Math.abs(dx5)) {
            return true;
        }
        return false;
    }

    private final void R() {
        this.mSuppMatrix.reset();
        V(this.mBaseRotation);
        S(D());
        A();
    }

    private final void S(Matrix matrix) {
        this.mImageView.setImageMatrix(matrix);
    }

    private final void Y(final Drawable drawable) {
        float coerceAtMost;
        float coerceAtMost2;
        if (drawable == null) {
            return;
        }
        final float G = G(this.mImageView);
        final float F = F(this.mImageView);
        final int intrinsicWidth = drawable.getIntrinsicWidth();
        final int intrinsicHeight = drawable.getIntrinsicHeight();
        ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(G, F, intrinsicWidth, intrinsicHeight, drawable) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$updateBaseMatrix$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Drawable $drawable;
            final /* synthetic */ int $drawableHeight;
            final /* synthetic */ int $drawableWidth;
            final /* synthetic */ float $viewHeight;
            final /* synthetic */ float $viewWidth;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$viewWidth = G;
                this.$viewHeight = F;
                this.$drawableWidth = intrinsicWidth;
                this.$drawableHeight = intrinsicHeight;
                this.$drawable = drawable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Float.valueOf(G), Float.valueOf(F), Integer.valueOf(intrinsicWidth), Integer.valueOf(intrinsicHeight), drawable);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "updateBaseMatrix viewWidth:" + this.$viewWidth + " viewHeight:" + this.$viewHeight + " drawableWidth:" + this.$drawableWidth + " drawableHeight:" + this.$drawableHeight + " drawableHash:" + this.$drawable.hashCode();
            }
        });
        this.mBaseMatrix.reset();
        float f16 = intrinsicWidth;
        float f17 = G / f16;
        float f18 = intrinsicHeight;
        float f19 = F / f18;
        ImageView.ScaleType scaleType = this.mScaleType;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((G - f16) / 2.0f, (F - f18) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f17, f19);
            this.mBaseMatrix.postScale(max, max);
            this.mBaseMatrix.postTranslate((G - (f16 * max)) / 2.0f, (F - (f18 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(f17, f19);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(1.0f, coerceAtMost);
            this.mBaseMatrix.postScale(coerceAtMost2, coerceAtMost2);
            this.mBaseMatrix.postTranslate((G - (f16 * coerceAtMost2)) / 2.0f, (F - (f18 * coerceAtMost2)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f16, f18);
            RectF rectF2 = new RectF(0.0f, 0.0f, G, F);
            if (((int) this.mBaseRotation) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f18, f16);
            }
            int i3 = e.f361425a[this.mScaleType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            } else {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        R();
    }

    public static final /* synthetic */ d t(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    private final void y() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            Intrinsics.checkNotNull(flingRunnable);
            flingRunnable.e();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        if (A()) {
            S(D());
        }
    }

    @Nullable
    public final RectF B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RectF) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        A();
        return C(D());
    }

    @NotNull
    public final Matrix E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Matrix) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.imageMatrix;
    }

    public final float H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        return (float) Math.sqrt(((float) Math.pow(J(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow(J(this.mSuppMatrix, 3), 2.0d)));
    }

    @NotNull
    public final ImageView.ScaleType I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ImageView.ScaleType) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mScaleType;
    }

    public final boolean O(final float dx5, final float dy5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(dx5), Float.valueOf(dy5))).booleanValue();
        }
        if (this.mAllowParentInterceptOnEdge) {
            com.tencent.qqnt.qbasealbum.preview.view.a aVar = this.mScaleDragDetector;
            Intrinsics.checkNotNull(aVar);
            if (!aVar.e() && !this.mBlockParentIntercept) {
                boolean Q = Q(dx5, dy5);
                boolean L = L(dx5, dy5);
                if (N(dx5, dy5, Q)) {
                    ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(dx5, dy5) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$isNeedToDisAllowParentInterceptEvent$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ float $dx;
                        final /* synthetic */ float $dy;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$dx = dx5;
                            this.$dy = dy5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, PhotoViewAttacher.this, Float.valueOf(dx5), Float.valueOf(dy5));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            String K;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            K = PhotoViewAttacher.this.K(this.$dx, this.$dy);
                            return "isNeedToDisAllowInterceptEvent vertical solp false " + K;
                        }
                    });
                    return false;
                }
                if (M(dx5, dy5, L)) {
                    ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(dx5, dy5) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$isNeedToDisAllowParentInterceptEvent$3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ float $dx;
                        final /* synthetic */ float $dy;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$dx = dx5;
                            this.$dy = dy5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, PhotoViewAttacher.this, Float.valueOf(dx5), Float.valueOf(dy5));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            String K;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            K = PhotoViewAttacher.this.K(this.$dx, this.$dy);
                            return "isNeedToDisAllowInterceptEvent horizontal solp false " + K;
                        }
                    });
                    return false;
                }
                if (P(dx5, dy5)) {
                    ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(dx5, dy5) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$isNeedToDisAllowParentInterceptEvent$4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ float $dx;
                        final /* synthetic */ float $dy;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$dx = dx5;
                            this.$dy = dy5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, PhotoViewAttacher.this, Float.valueOf(dx5), Float.valueOf(dy5));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            String K;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            K = PhotoViewAttacher.this.K(this.$dx, this.$dy);
                            return "isNeedToDisAllowInterceptEvent corner slop false " + K;
                        }
                    });
                    return false;
                }
                ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(dx5, dy5) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$isNeedToDisAllowParentInterceptEvent$5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ float $dx;
                    final /* synthetic */ float $dy;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$dx = dx5;
                        this.$dy = dy5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, PhotoViewAttacher.this, Float.valueOf(dx5), Float.valueOf(dy5));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        String K;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        K = PhotoViewAttacher.this.K(this.$dx, this.$dy);
                        return "isNeedToDisAllowInterceptEvent default:true " + K;
                    }
                });
                return true;
            }
        }
        ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(dx5, dy5) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$isNeedToDisAllowParentInterceptEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ float $dx;
            final /* synthetic */ float $dy;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$dx = dx5;
                this.$dy = dy5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PhotoViewAttacher.this, Float.valueOf(dx5), Float.valueOf(dy5));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String K;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                K = PhotoViewAttacher.this.K(this.$dx, this.$dy);
                return "isNeedToDisAllowInterceptEvent true " + K;
            }
        });
        return true;
    }

    public final void T(@Nullable View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
        } else {
            this.mOnClickListener = listener;
        }
    }

    public final void U(@Nullable View.OnLongClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
        } else {
            this.mLongClickListener = listener;
        }
    }

    public final void V(float degrees) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(degrees));
        } else {
            this.mSuppMatrix.postRotate(degrees % 360);
            z();
        }
    }

    public final void W(@NotNull ImageView.ScaleType scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) scaleType);
            return;
        }
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (c.c(scaleType) && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            X();
        }
    }

    public final void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else if (this.isZoomEnabled) {
            Y(this.mImageView.getDrawable());
        } else {
            R();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@NotNull View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, v3, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
            Y(this.mImageView.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(@NotNull View v3, @NotNull final MotionEvent ev5) {
        boolean z16;
        com.tencent.qqnt.qbasealbum.preview.view.a aVar;
        GestureDetector gestureDetector;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) v3, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean z19 = false;
        if (!this.isZoomEnabled || !c.b((ImageView) v3)) {
            return false;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (H() < this.mMinScale) {
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    float H = H();
                    floatRef.element = H;
                    if (H < 0.6f) {
                        floatRef.element = 0.6f;
                    }
                    final RectF B = B();
                    if (B != null) {
                        ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(ev5, this, floatRef, B) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$onTouch$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ MotionEvent $ev;
                            final /* synthetic */ RectF $rect;
                            final /* synthetic */ Ref.FloatRef $startScale;
                            final /* synthetic */ PhotoViewAttacher this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$ev = ev5;
                                this.this$0 = this;
                                this.$startScale = floatRef;
                                this.$rect = B;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, ev5, this, floatRef, B);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                float f16;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                int action2 = this.$ev.getAction();
                                float H2 = this.this$0.H();
                                float f17 = this.$startScale.element;
                                f16 = this.this$0.mMinScale;
                                return "postAnimationZoom minscale event:" + action2 + " scale:" + H2 + " startScale:" + f17 + " mMinScale:" + f16 + " rect:" + this.$rect;
                            }
                        });
                        v3.post(new AnimatedZoomRunnable(floatRef.element, this.mMinScale, B.centerX(), B.centerY()));
                        z16 = true;
                    }
                } else if (H() > this.mMaxScale) {
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    float H2 = H();
                    floatRef2.element = H2;
                    if (H2 > 7.0f) {
                        floatRef2.element = 7.0f;
                    }
                    ox3.a.a("QBaseAlbum.PhotoViewAttacher", new Function0<String>(ev5, this, floatRef2) { // from class: com.tencent.qqnt.qbasealbum.preview.view.PhotoViewAttacher$onTouch$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ MotionEvent $ev;
                        final /* synthetic */ Ref.FloatRef $startScale;
                        final /* synthetic */ PhotoViewAttacher this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$ev = ev5;
                            this.this$0 = this;
                            this.$startScale = floatRef2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ev5, this, floatRef2);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            float f16;
                            float f17;
                            float f18;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            int action2 = this.$ev.getAction();
                            float H3 = this.this$0.H();
                            float f19 = this.$startScale.element;
                            f16 = this.this$0.mMaxScale;
                            f17 = this.this$0.mScaleFocusX;
                            f18 = this.this$0.mScaleFocusY;
                            return "postAnimationZoom maxscale event:" + action2 + " scale:" + H3 + " startScale:" + f19 + " mMaxScale:" + f16 + " scaleX:" + f17 + " scaleY:" + f18;
                        }
                    });
                    v3.post(new AnimatedZoomRunnable(floatRef2.element, this.mMaxScale, this.mScaleFocusX, this.mScaleFocusY));
                    z16 = true;
                }
                aVar = this.mScaleDragDetector;
                if (aVar != null) {
                    Intrinsics.checkNotNull(aVar);
                    boolean e16 = aVar.e();
                    com.tencent.qqnt.qbasealbum.preview.view.a aVar2 = this.mScaleDragDetector;
                    Intrinsics.checkNotNull(aVar2);
                    boolean d16 = aVar2.d();
                    com.tencent.qqnt.qbasealbum.preview.view.a aVar3 = this.mScaleDragDetector;
                    Intrinsics.checkNotNull(aVar3);
                    boolean f16 = aVar3.f(ev5);
                    if (!e16) {
                        com.tencent.qqnt.qbasealbum.preview.view.a aVar4 = this.mScaleDragDetector;
                        Intrinsics.checkNotNull(aVar4);
                        if (!aVar4.e()) {
                            z17 = true;
                            if (!d16) {
                                com.tencent.qqnt.qbasealbum.preview.view.a aVar5 = this.mScaleDragDetector;
                                Intrinsics.checkNotNull(aVar5);
                                if (!aVar5.d()) {
                                    z18 = true;
                                    int pointerCount = ev5.getPointerCount();
                                    if ((z17 && z18) || pointerCount > 1) {
                                        z19 = true;
                                    }
                                    this.mBlockParentIntercept = z19;
                                    z16 = f16;
                                }
                            }
                            z18 = false;
                            int pointerCount2 = ev5.getPointerCount();
                            if (z17) {
                                z19 = true;
                                this.mBlockParentIntercept = z19;
                                z16 = f16;
                            }
                            z19 = true;
                            this.mBlockParentIntercept = z19;
                            z16 = f16;
                        }
                    }
                    z17 = false;
                    if (!d16) {
                    }
                    z18 = false;
                    int pointerCount22 = ev5.getPointerCount();
                    if (z17) {
                    }
                    z19 = true;
                    this.mBlockParentIntercept = z19;
                    z16 = f16;
                }
                gestureDetector = this.mGestureDetector;
                if (gestureDetector != null) {
                    Intrinsics.checkNotNull(gestureDetector);
                    if (gestureDetector.onTouchEvent(ev5)) {
                        return true;
                    }
                }
                return z16;
            }
        } else {
            ViewParent parent = v3.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            y();
        }
        z16 = false;
        aVar = this.mScaleDragDetector;
        if (aVar != null) {
        }
        gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
        }
        return z16;
    }
}
