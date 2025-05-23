package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00b0\u00012\u00020\u0001:\u000b\u00b1\u0001\u00b2\u0001\u00b3\u0001\u00b4\u0001\u00b5\u0001\rB\u0015\b\u0016\u0012\b\u0010\u00a8\u0001\u001a\u00030\u00a7\u0001\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001B!\b\u0016\u0012\b\u0010\u00a8\u0001\u001a\u00030\u00a7\u0001\u0012\n\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u00ab\u0001\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00ad\u0001B*\b\u0016\u0012\b\u0010\u00a8\u0001\u001a\u00030\u00a7\u0001\u0012\n\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u00ab\u0001\u0012\u0007\u0010\u00ae\u0001\u001a\u00020\b\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00af\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cJ&\u0010$\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\bJ\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0016J\u0010\u0010,\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\bJ\u0010\u0010.\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020\bJ\u000e\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0016J\u000e\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0016J\u0010\u00104\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\bJ\u0010\u00105\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\bJ\u0010\u00107\u001a\u00020\u00022\b\b\u0001\u00106\u001a\u00020\bJ\u0010\u00108\u001a\u00020\u00022\b\b\u0001\u00106\u001a\u00020\bJ\u0010\u0010:\u001a\u00020\u00022\b\b\u0001\u00109\u001a\u00020\bJ\u0010\u0010;\u001a\u00020\u00022\b\b\u0001\u00109\u001a\u00020\bJ\u0010\u0010<\u001a\u00020\u00022\b\b\u0001\u00109\u001a\u00020\bJ\u0016\u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\bJ\u000e\u0010@\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010A\u001a\u00020\u0004J\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\u0002J\u0006\u0010D\u001a\u00020\u0016J0\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010G\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010J\u001a\u00020\u00162\u0006\u0010I\u001a\u00020HH\u0016R\u0014\u0010L\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010KR\u0014\u0010M\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010KR\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010NR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010NR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010NR\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010NR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010ZR\u0016\u0010_\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u0016\u0010b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010NR\u001c\u0010f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bc\u0010^\u0012\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010ZR\u0016\u0010k\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010jR\u0016\u0010o\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010jR\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010^R\u0016\u0010s\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010^R\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010jR\u0016\u0010{\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010NR\u0016\u0010}\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010NR\u0016\u0010\u0081\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0017\u0010\u0083\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u0017\u0010\u0085\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0080\u0001R\u0017\u0010\u0087\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0080\u0001R\u0017\u0010\u0089\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0080\u0001R\u001e\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010^\u0012\u0005\b\u008b\u0001\u0010eR\u0018\u0010\u008d\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010NR\u0018\u0010\u008f\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010NR\u0018\u0010\u0091\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010^R\u0018\u0010\u0093\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010^R\u0018\u0010\u0095\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0094\u0001\u0010^R\u0018\u0010\u0097\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0096\u0001\u0010^R\u0018\u0010\u0099\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0098\u0001\u0010^R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001b\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u0018\u0010\u00a4\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010jR\u0018\u0010\u00a6\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010j\u00a8\u0006\u00b6\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView;", "Landroid/view/View;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "touchX", "touchY", "p", "", "g", "Landroid/graphics/Canvas;", PM.CANVAS, "e", "d", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$b;", "callback", "setCropSizeChangeListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$c;", "setOverlayViewChangeListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$d;", "interceptor", "setRectCornerMoveInterceptor", "", "isMoving", "firstDraw", "setIsMoving", "size", "setCropRectMinSize", "Landroid/graphics/RectF;", "f", CanvasView.ACTION_RECT, "setCropViewRect", "left", "top", "right", "bottom", "setResPadding", "k", "j", "mFreestyleCropMode", "setFreestyleCropMode", "circleDimmedLayer", "setCircleDimmedLayer", "cropGridRowCount", "setCropGridRowCount", "cropGridColumnCount", "setCropGridColumnCount", "showCropFrame", "setShowCropFrame", "showCropGrid", "setShowCropGrid", "dimmedColor", "setDimmedColor", "setDimmedColorWhenTouch", "width", "setCropFrameStrokeWidth", "setCropGridStrokeWidth", "color", "setCropFrameColor", "setCropGridColor", "setCropGridCornerColor", "targetAspectRatio", "type", "setTargetAspectRatio", "setTargetAspectRatioWhenFreeRatio", tl.h.F, "i", "setupCropBounds", "l", "changed", "onLayout", "onDraw", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/graphics/RectF;", "mCropViewRect", "mTempRect", UserInfo.SEX_FEMALE, "resPaddingLeft", "resPaddingTop", "resPaddingRight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "resPaddingBottom", BdhLogUtil.LogTag.Tag_Conn, "mThisWidth", "D", "mThisHeight", "", "E", "[F", "mCropGridCorners", "mCropGridCenter", "G", "I", "mCropGridRowCount", "H", "mCropGridColumnCount", "mTargetAspectRatio", "J", "getMTargetAspectType$annotations", "()V", "mTargetAspectType", "K", "mGridPoints", "L", "Z", "mShowCropFrame", "M", "mShowCropGrid", "N", "mCircleDimmedLayer", "P", "mDimmedColorWhenTouched", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mDimmedColor", "Landroid/graphics/Path;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/Path;", "mCircularPath", ExifInterface.LATITUDE_SOUTH, "mIsMoving", "T", "mCropRectCornerTouchAreaLineWidth", "U", "mMovingCropRectCornerTouchAreaLineWidth", "Landroid/graphics/Paint;", "V", "Landroid/graphics/Paint;", "mDimmedStrokePaint", "W", "mCropGridPaint", "a0", "mCropFramePaint", "b0", "mCropFrameCornersPaint", "c0", "mMovingCropFrameCornersPaint", "d0", "getMFreestyleCropMode$annotations", "e0", "mPreviousTouchX", "f0", "mPreviousTouchY", "g0", "mCurrentTouchCornerIndex", "h0", "mTouchPointThreshold", "i0", "mCropRectMinSize", "j0", "mCropRectCornerTouchAreaLineLength", "k0", "mMovingCropRectCornerTouchAreaLineLength", "l0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$b;", "mCropSizeChangeCallback", "m0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$c;", "mCallback", "n0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$d;", "rectCornerMoveInterceptor", "o0", "mShouldSetupCropBounds", "p0", "isTouchReleased", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "q0", "AspectRatioType", "a", "b", "FreestyleMode", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorCropMaskView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float mThisWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float mThisHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private float[] mCropGridCorners;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private float[] mCropGridCenter;

    /* renamed from: G, reason: from kotlin metadata */
    private int mCropGridRowCount;

    /* renamed from: H, reason: from kotlin metadata */
    private int mCropGridColumnCount;

    /* renamed from: I, reason: from kotlin metadata */
    private float mTargetAspectRatio;

    /* renamed from: J, reason: from kotlin metadata */
    private int mTargetAspectType;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private float[] mGridPoints;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mShowCropFrame;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mShowCropGrid;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mCircleDimmedLayer;

    /* renamed from: P, reason: from kotlin metadata */
    private int mDimmedColorWhenTouched;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mDimmedColor;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Path mCircularPath;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mIsMoving;

    /* renamed from: T, reason: from kotlin metadata */
    private float mCropRectCornerTouchAreaLineWidth;

    /* renamed from: U, reason: from kotlin metadata */
    private float mMovingCropRectCornerTouchAreaLineWidth;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Paint mDimmedStrokePaint;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Paint mCropGridPaint;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mCropFramePaint;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mCropFrameCornersPaint;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mMovingCropFrameCornersPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mCropViewRect;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int mFreestyleCropMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mTempRect;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private float mPreviousTouchX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float resPaddingLeft;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private float mPreviousTouchY;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int mCurrentTouchCornerIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float resPaddingTop;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int mTouchPointThreshold;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float resPaddingRight;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int mCropRectMinSize;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int mCropRectCornerTouchAreaLineLength;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private int mMovingCropRectCornerTouchAreaLineLength;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mCropSizeChangeCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float resPaddingBottom;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mCallback;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d rectCornerMoveInterceptor;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean mShouldSetupCropBounds;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchReleased;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$AspectRatioType;", "", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes17.dex */
    public @interface AspectRatioType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$FreestyleMode;", "", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes17.dex */
    public @interface FreestyleMode {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$b;", "", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "", "a", "", NodeProps.VISIBLE, "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull RectF rect);

        void b(boolean visible);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$c;", "", "Landroid/graphics/RectF;", "cropRect", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface c {
        void a(@NotNull RectF cropRect);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$d;", "", "", HippyTKDListViewAdapter.X, "y", "preX", "preY", "Landroid/graphics/PointF;", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface d {
        @NotNull
        PointF a(float x16, float y16, float preX, float preY);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropMaskView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                int i3 = this.mCropGridRowCount;
                float[] fArr = new float[(i3 * 4) + (this.mCropGridColumnCount * 4)];
                int i16 = 0;
                for (int i17 = 0; i17 < i3; i17++) {
                    int i18 = i16 + 1;
                    RectF rectF = this.mCropViewRect;
                    fArr[i16] = rectF.left;
                    int i19 = i18 + 1;
                    float f16 = i17 + 1.0f;
                    float height = rectF.height() * (f16 / (this.mCropGridRowCount + 1));
                    RectF rectF2 = this.mCropViewRect;
                    fArr[i18] = height + rectF2.top;
                    int i26 = i19 + 1;
                    fArr[i19] = rectF2.right;
                    i16 = i26 + 1;
                    fArr[i26] = (rectF2.height() * (f16 / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                }
                int i27 = this.mCropGridColumnCount;
                for (int i28 = 0; i28 < i27; i28++) {
                    int i29 = i16 + 1;
                    float f17 = i28 + 1.0f;
                    float width = this.mCropViewRect.width() * (f17 / (this.mCropGridColumnCount + 1));
                    RectF rectF3 = this.mCropViewRect;
                    fArr[i16] = width + rectF3.left;
                    int i36 = i29 + 1;
                    fArr[i29] = rectF3.top;
                    int i37 = i36 + 1;
                    float width2 = rectF3.width() * (f17 / (this.mCropGridColumnCount + 1));
                    RectF rectF4 = this.mCropViewRect;
                    fArr[i36] = width2 + rectF4.left;
                    i16 = i37 + 1;
                    fArr[i37] = rectF4.bottom;
                }
                this.mGridPoints = fArr;
            }
            float[] fArr2 = this.mGridPoints;
            if (fArr2 != null) {
                canvas.drawLines(fArr2, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            Paint paint = this.mCropFrameCornersPaint;
            int i38 = this.mCropRectCornerTouchAreaLineLength;
            float f18 = this.mCropRectCornerTouchAreaLineWidth;
            if (this.mIsMoving) {
                paint = this.mMovingCropFrameCornersPaint;
                i38 = this.mMovingCropRectCornerTouchAreaLineLength;
                f18 = this.mMovingCropRectCornerTouchAreaLineWidth;
            }
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            float f19 = i38;
            float f26 = -f19;
            this.mTempRect.inset(f19, f26);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(f26, f19);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            float f27 = (-f18) / 2.0f;
            this.mTempRect.inset(f27, f27);
            canvas.drawRect(this.mTempRect, paint);
            canvas.restore();
        }
    }

    private final void e(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        if (this.mCurrentTouchCornerIndex != -1) {
            canvas.drawColor(this.mDimmedColorWhenTouched);
        } else {
            canvas.drawColor(this.mDimmedColor);
        }
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    private final int g(float touchX, float touchY) {
        double d16 = this.mTouchPointThreshold;
        int i3 = -1;
        for (int i16 = 0; i16 < 8; i16 += 2) {
            double sqrt = Math.sqrt(Math.pow(touchX - this.mCropGridCorners[i16], 2.0d) + Math.pow(touchY - this.mCropGridCorners[i16 + 1], 2.0d));
            if (sqrt < d16) {
                i3 = i16 / 2;
                d16 = sqrt;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(VideoEditorCropMaskView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setIsMoving(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(VideoEditorCropMaskView this$0) {
        b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mIsMoving && (bVar = this$0.mCropSizeChangeCallback) != null) {
            bVar.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(VideoEditorCropMaskView this$0) {
        b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mIsMoving && (bVar = this$0.mCropSizeChangeCallback) != null) {
            bVar.b(false);
        }
    }

    private final void p(float touchX, float touchY) {
        boolean z16;
        float f16;
        float f17;
        float f18;
        float f19;
        this.mTempRect.set(this.mCropViewRect);
        boolean z17 = false;
        if (this.mTargetAspectType == 1) {
            int i3 = this.mCurrentTouchCornerIndex;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            RectF rectF = this.mTempRect;
                            RectF rectF2 = this.mCropViewRect;
                            rectF.set(touchX, rectF2.top, rectF2.right, touchY);
                        }
                    } else {
                        RectF rectF3 = this.mTempRect;
                        RectF rectF4 = this.mCropViewRect;
                        rectF3.set(rectF4.left, rectF4.top, touchX, touchY);
                    }
                } else {
                    RectF rectF5 = this.mTempRect;
                    RectF rectF6 = this.mCropViewRect;
                    rectF5.set(rectF6.left, touchY, touchX, rectF6.bottom);
                }
            } else {
                RectF rectF7 = this.mTempRect;
                RectF rectF8 = this.mCropViewRect;
                rectF7.set(touchX, touchY, rectF8.right, rectF8.bottom);
            }
            if (this.mTempRect.height() >= this.mCropRectMinSize) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mTempRect.width() >= this.mCropRectMinSize) {
                z17 = true;
            }
        } else {
            int i16 = this.mCurrentTouchCornerIndex;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            RectF rectF9 = this.mCropViewRect;
                            float min = Math.min(rectF9.right - touchX, (touchY - rectF9.top) * this.mTargetAspectRatio);
                            RectF rectF10 = this.mCropViewRect;
                            float min2 = Math.min(touchY - rectF10.top, (rectF10.right - touchX) / this.mTargetAspectRatio);
                            RectF rectF11 = this.mTempRect;
                            RectF rectF12 = this.mCropViewRect;
                            float f26 = rectF12.right;
                            float f27 = rectF12.top;
                            rectF11.set(f26 - min, f27, f26, min2 + f27);
                        }
                    } else {
                        RectF rectF13 = this.mCropViewRect;
                        float min3 = Math.min(touchX - rectF13.left, (touchY - rectF13.top) * this.mTargetAspectRatio);
                        RectF rectF14 = this.mCropViewRect;
                        float min4 = Math.min(touchY - rectF14.top, (touchX - rectF14.left) / this.mTargetAspectRatio);
                        RectF rectF15 = this.mTempRect;
                        RectF rectF16 = this.mCropViewRect;
                        float f28 = rectF16.left;
                        float f29 = rectF16.top;
                        rectF15.set(f28, f29, min3 + f28, min4 + f29);
                    }
                } else {
                    RectF rectF17 = this.mCropViewRect;
                    float min5 = Math.min(touchX - rectF17.left, (rectF17.bottom - touchY) * this.mTargetAspectRatio);
                    RectF rectF18 = this.mCropViewRect;
                    float min6 = Math.min(rectF18.bottom - touchY, (touchX - rectF18.left) / this.mTargetAspectRatio);
                    RectF rectF19 = this.mTempRect;
                    RectF rectF20 = this.mCropViewRect;
                    float f36 = rectF20.left;
                    float f37 = rectF20.bottom;
                    rectF19.set(f36, f37 - min6, min5 + f36, f37);
                }
            } else {
                RectF rectF21 = this.mCropViewRect;
                float min7 = Math.min(rectF21.right - touchX, (rectF21.bottom - touchY) * this.mTargetAspectRatio);
                RectF rectF22 = this.mCropViewRect;
                float min8 = Math.min(rectF22.bottom - touchY, (rectF22.right - touchX) / this.mTargetAspectRatio);
                RectF rectF23 = this.mTempRect;
                RectF rectF24 = this.mCropViewRect;
                float f38 = rectF24.right;
                float f39 = rectF24.bottom;
                rectF23.set(f38 - min7, f39 - min8, f38, f39);
            }
            if (this.mTempRect.height() >= this.mCropRectMinSize && this.mTempRect.width() >= this.mCropRectMinSize) {
                z17 = true;
            }
            z16 = z17;
        }
        RectF rectF25 = this.mCropViewRect;
        if (z17) {
            f16 = this.mTempRect.left;
        } else {
            f16 = rectF25.left;
        }
        if (z16) {
            f17 = this.mTempRect.top;
        } else {
            f17 = rectF25.top;
        }
        if (z17) {
            f18 = this.mTempRect.right;
        } else {
            f18 = rectF25.right;
        }
        if (z16) {
            f19 = this.mTempRect.bottom;
        } else {
            f19 = rectF25.bottom;
        }
        rectF25.set(f16, f17, f18, f19);
        if (z16 || z17) {
            q();
            postInvalidate();
            b bVar = this.mCropSizeChangeCallback;
            if (bVar != null) {
                bVar.a(this.mCropViewRect);
            }
        }
    }

    private final void q() {
        float coerceAtMost;
        com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
        this.mCropGridCorners = iVar.f(this.mCropViewRect);
        this.mCropGridCenter = iVar.e(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        Path path = this.mCircularPath;
        float centerX = this.mCropViewRect.centerX();
        float centerY = this.mCropViewRect.centerY();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mCropViewRect.width(), this.mCropViewRect.height());
        path.addCircle(centerX, centerY, coerceAtMost / 2.0f, Path.Direction.CW);
    }

    public static /* synthetic */ void setIsMoving$default(VideoEditorCropMaskView videoEditorCropMaskView, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        videoEditorCropMaskView.setIsMoving(z16, z17);
    }

    @NotNull
    public final RectF f() {
        return new RectF(this.mCropViewRect);
    }

    /* renamed from: h, reason: from getter */
    public final float getMTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    /* renamed from: i, reason: from getter */
    public final int getMTargetAspectType() {
        return this.mTargetAspectType;
    }

    /* renamed from: j, reason: from getter */
    public final float getMThisHeight() {
        return this.mThisHeight;
    }

    /* renamed from: k, reason: from getter */
    public final float getMThisWidth() {
        return this.mThisWidth;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsTouchReleased() {
        return this.isTouchReleased;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mFreestyleCropMode == 0) {
            return;
        }
        e(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            this.mThisWidth = ((((right - left) - getPaddingRight()) - getPaddingLeft()) - this.resPaddingLeft) - this.resPaddingRight;
            this.mThisHeight = ((((bottom - top) - getPaddingBottom()) - getPaddingTop()) - this.resPaddingTop) - this.resPaddingBottom;
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.l
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditorCropMaskView.m(VideoEditorCropMaskView.this);
                }
            }, 200L);
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                int i3 = this.mTargetAspectType;
                if (i3 == 2 && this.mTargetAspectRatio <= 0.0f) {
                    this.mTargetAspectRatio = (this.mThisWidth * 1.0f) / this.mThisHeight;
                }
                setTargetAspectRatio(this.mTargetAspectRatio, i3);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        PointF a16;
        boolean z17;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isTouchReleased = z16;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x16 = event.getX();
            float y16 = event.getY();
            if ((event.getAction() & 255) == 0) {
                int g16 = g(x16, y16);
                this.mCurrentTouchCornerIndex = g16;
                if (g16 != -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < 0.0f) {
                    setIsMoving$default(this, true, false, 2, null);
                    this.mPreviousTouchX = x16;
                    this.mPreviousTouchY = y16;
                }
                return z17;
            }
            if ((event.getAction() & 255) == 2 && event.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float min = Math.min(Math.max(x16, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y16, getPaddingTop()), getHeight() - getPaddingBottom());
                d dVar = this.rectCornerMoveInterceptor;
                if (dVar != null && (a16 = dVar.a(min, min2, this.mPreviousTouchX, this.mPreviousTouchY)) != null) {
                    min = a16.x;
                    min2 = a16.y;
                }
                p(min, min2);
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            }
            if ((event.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                if (this.mCallback != null) {
                    setIsMoving$default(this, false, false, 2, null);
                    c cVar = this.mCallback;
                    if (cVar != null) {
                        cVar.a(this.mCropViewRect);
                    }
                }
            }
        }
        return false;
    }

    public final void setCircleDimmedLayer(boolean circleDimmedLayer) {
        this.mCircleDimmedLayer = circleDimmedLayer;
    }

    public final void setCropFrameColor(@ColorInt int color) {
        this.mCropFramePaint.setColor(color);
    }

    public final void setCropFrameStrokeWidth(@IntRange(from = 0) int width) {
        this.mCropFramePaint.setStrokeWidth(width);
    }

    public final void setCropGridColor(@ColorInt int color) {
        this.mCropGridPaint.setColor(color);
    }

    public final void setCropGridColumnCount(@IntRange(from = 0) int cropGridColumnCount) {
        this.mCropGridColumnCount = cropGridColumnCount;
        this.mGridPoints = null;
    }

    public final void setCropGridCornerColor(@ColorInt int color) {
        this.mCropFrameCornersPaint.setColor(color);
    }

    public final void setCropGridRowCount(@IntRange(from = 0) int cropGridRowCount) {
        this.mCropGridRowCount = cropGridRowCount;
        this.mGridPoints = null;
    }

    public final void setCropGridStrokeWidth(@IntRange(from = 0) int width) {
        this.mCropGridPaint.setStrokeWidth(width);
    }

    public final void setCropRectMinSize(int size) {
        this.mCropRectMinSize = size;
    }

    public final void setCropSizeChangeListener(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCropSizeChangeCallback = callback;
    }

    public final void setCropViewRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mCropViewRect.set(rect);
        b bVar = this.mCropSizeChangeCallback;
        if (bVar != null) {
            bVar.a(rect);
        }
        q();
        postInvalidate();
    }

    public final void setDimmedColor(@ColorInt int dimmedColor) {
        this.mDimmedColor = dimmedColor;
    }

    public final void setDimmedColorWhenTouch(@ColorInt int dimmedColor) {
        this.mDimmedColorWhenTouched = dimmedColor;
    }

    public final void setFreestyleCropMode(int mFreestyleCropMode) {
        this.mFreestyleCropMode = mFreestyleCropMode;
        postInvalidate();
    }

    public final void setIsMoving(boolean isMoving, boolean firstDraw) {
        this.mIsMoving = isMoving;
        setShowCropGrid(isMoving);
        if (!isMoving) {
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.n
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditorCropMaskView.n(VideoEditorCropMaskView.this);
                }
            }, 2000L);
        } else {
            b bVar = this.mCropSizeChangeCallback;
            if (bVar != null) {
                bVar.b(true);
            }
        }
        if (firstDraw) {
            postInvalidate();
        }
    }

    public final void setOverlayViewChangeListener(@Nullable c callback) {
        this.mCallback = callback;
    }

    public final void setRectCornerMoveInterceptor(@NotNull d interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.rectCornerMoveInterceptor = interceptor;
    }

    public final void setResPadding(float left, float top, float right, float bottom) {
        this.resPaddingLeft = left;
        this.resPaddingTop = top;
        this.resPaddingRight = right;
        this.resPaddingBottom = bottom;
        this.mShouldSetupCropBounds = true;
        requestLayout();
    }

    public final void setShowCropFrame(boolean showCropFrame) {
        this.mShowCropFrame = showCropFrame;
    }

    public final void setShowCropGrid(boolean showCropGrid) {
        this.mShowCropGrid = showCropGrid;
    }

    public final void setTargetAspectRatio(float targetAspectRatio, int type) {
        if (type != 1) {
            b bVar = this.mCropSizeChangeCallback;
            if (bVar != null) {
                bVar.b(true);
            }
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.m
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditorCropMaskView.o(VideoEditorCropMaskView.this);
                }
            }, 2000L);
        }
        this.mTargetAspectRatio = targetAspectRatio;
        this.mTargetAspectType = type;
        float f16 = this.mThisWidth;
        if (f16 > 0.0f) {
            if (type == 2 && targetAspectRatio <= 0.0f) {
                this.mTargetAspectRatio = (f16 * 1.0f) / this.mThisHeight;
            }
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public final void setTargetAspectRatioWhenFreeRatio(float targetAspectRatio) {
        if (this.mTargetAspectType == 1) {
            this.mTargetAspectRatio = targetAspectRatio;
        }
    }

    public final void setupCropBounds() {
        float f16 = this.mThisWidth;
        float f17 = this.mTargetAspectRatio;
        float f18 = f16 / f17;
        float f19 = this.mThisHeight;
        if (f18 > f19) {
            float f26 = f19 * f17;
            float f27 = (f16 - f26) / 2;
            this.mCropViewRect.set(getPaddingLeft() + this.resPaddingLeft + f27, getPaddingTop() + this.resPaddingTop, getPaddingLeft() + this.resPaddingLeft + f26 + f27, getPaddingTop() + this.resPaddingTop + this.mThisHeight);
        } else {
            float f28 = (f19 - f18) / 2;
            this.mCropViewRect.set(getPaddingLeft() + this.resPaddingLeft, getPaddingTop() + this.resPaddingTop + f28, getPaddingLeft() + this.resPaddingLeft + this.mThisWidth, getPaddingTop() + this.resPaddingTop + f18 + f28);
        }
        c cVar = this.mCallback;
        if (cVar != null && cVar != null) {
            cVar.a(this.mCropViewRect);
        }
        q();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mCropGridCorners = new float[8];
        this.mCropGridCenter = new float[2];
        this.mCropGridRowCount = 2;
        this.mCropGridColumnCount = 2;
        this.mShowCropFrame = true;
        this.mShowCropGrid = true;
        this.mDimmedColorWhenTouched = ContextCompat.getColor(getContext(), R.color.bdc);
        this.mDimmedColor = ContextCompat.getColor(getContext(), R.color.bdc);
        this.mCircularPath = new Path();
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        this.mCropRectCornerTouchAreaLineWidth = eVar.a(4.0f);
        this.mMovingCropRectCornerTouchAreaLineWidth = eVar.a(6.0f);
        Paint paint = new Paint(1);
        paint.setColor(this.mDimmedColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        this.mDimmedStrokePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(1.0f);
        this.mCropGridPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(eVar.a(2.0f));
        this.mCropFramePaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setColor(-1);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(this.mCropRectCornerTouchAreaLineWidth);
        this.mCropFrameCornersPaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setColor(-1);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(this.mMovingCropRectCornerTouchAreaLineWidth);
        this.mMovingCropFrameCornersPaint = paint5;
        this.mFreestyleCropMode = 1;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = eVar.a(30.0f);
        this.mCropRectMinSize = eVar.a(100.0f);
        this.mCropRectCornerTouchAreaLineLength = eVar.a(16.0f);
        this.mMovingCropRectCornerTouchAreaLineLength = eVar.a(20.0f);
        this.isTouchReleased = true;
        setLayerType(1, null);
    }
}
