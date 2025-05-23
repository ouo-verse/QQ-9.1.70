package com.tencent.mobileqq.wink.editor.crop;

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
import com.tencent.mobileqq.wink.utils.u;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0014\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00a1\u00012\u00020\u0001:\u0007\u00a2\u0001\r\u00a3\u0001\f\u0017B\u0015\b\u0016\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001B!\b\u0016\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009e\u0001B*\b\u0016\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001\u0012\u0007\u0010\u009f\u0001\u001a\u00020\b\u00a2\u0006\u0006\b\u009a\u0001\u0010\u00a0\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016J.\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$J\u0010\u0010(\u001a\u00020\u00022\b\b\u0001\u0010'\u001a\u00020\bJ\u0010\u0010*\u001a\u00020\u00022\b\b\u0001\u0010)\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020$J\u000e\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020$J\u000e\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020$J\u0010\u00102\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\bJ\u0010\u00103\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\bJ\u0010\u00105\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\bJ\u0010\u00106\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\bJ\u0010\u00108\u001a\u00020\u00022\b\b\u0001\u00107\u001a\u00020\bJ\u0010\u00109\u001a\u00020\u00022\b\b\u0001\u00107\u001a\u00020\bJ\u0010\u0010:\u001a\u00020\u00022\b\b\u0001\u00107\u001a\u00020\bJ\u0016\u0010=\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\bJ\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\u0002J0\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0014J\u0010\u0010C\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010F\u001a\u00020$2\u0006\u0010E\u001a\u00020DH\u0016R\u0014\u0010H\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010GR\u0014\u0010I\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010GR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010JR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010JR\u0016\u0010M\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010JR\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010JR\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010JR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010WR\u0016\u0010Z\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010]\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010\\R\u0016\u0010`\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010JR\u001c\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\ba\u0010\\\u0012\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010WR\u0016\u0010i\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0016\u0010m\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010hR\u0016\u0010o\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010hR\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010\\R\u0016\u0010s\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010\\R\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010}\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010zR\u0014\u0010\u007f\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010zR\u0016\u0010\u0081\u0001\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010zR\u001e\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010\\\u0012\u0005\b\u0083\u0001\u0010cR\u0018\u0010\u0085\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010JR\u0018\u0010\u0087\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010JR\u0018\u0010\u0089\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010\\R\u0018\u0010\u008b\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010\\R\u0018\u0010\u008d\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010\\R\u0018\u0010\u008f\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010\\R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0097\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0096\u0001\u0010h\u00a8\u0006\u00a4\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView;", "Landroid/view/View;", "", "j", "", "touchX", "touchY", "i", "", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "b", "a", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$b;", "callback", "setOverlayViewChangeListener", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$c;", "interceptor", "setRectCornerMoveInterceptor", "size", "setCropRectMinSize", "Landroid/graphics/RectF;", "c", CanvasView.ACTION_RECT, "setCropViewRect", "left", "top", "right", "bottom", "bottomHeight", "setResPadding", tl.h.F, "g", "mFreestyleCropMode", "setFreestyleCropMode", "", "circleDimmedLayer", "setCircleDimmedLayer", "cropGridRowCount", "setCropGridRowCount", "cropGridColumnCount", "setCropGridColumnCount", "showCropFrame", "setShowCropFrame", "showCropGrid", "setShowCropGrid", "showCropCornerTouchArea", "setShowCropCornerTouchArea", "dimmedColor", "setDimmedColor", "setDimmedColorWhenTouch", "width", "setCropFrameStrokeWidth", "setCropGridStrokeWidth", "color", "setCropFrameColor", "setCropGridColor", "setCropGridCornerColor", "targetAspectRatio", "type", "setTargetAspectRatio", "e", "f", "setupCropBounds", "changed", "onLayout", "onDraw", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/graphics/RectF;", "mCropViewRect", "mTempRect", UserInfo.SEX_FEMALE, "resPaddingLeft", "resPaddingTop", "resPaddingRight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "resPaddingBottom", BdhLogUtil.LogTag.Tag_Conn, "resBottomHeight", "D", "mThisWidth", "E", "mThisHeight", "", "[F", "mCropGridCorners", "G", "mCropGridCenter", "H", "I", "mCropGridRowCount", "mCropGridColumnCount", "J", "mTargetAspectRatio", "K", "getMTargetAspectType$annotations", "()V", "mTargetAspectType", "L", "mGridPoints", "M", "Z", "mShowCropFrame", "N", "mShowCropGrid", "P", "mShowCropCornerTouchArea", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mCircleDimmedLayer", BdhLogUtil.LogTag.Tag_Req, "mDimmedColorWhenTouched", ExifInterface.LATITUDE_SOUTH, "mDimmedColor", "Landroid/graphics/Path;", "T", "Landroid/graphics/Path;", "mCircularPath", "Landroid/graphics/Paint;", "U", "Landroid/graphics/Paint;", "mDimmedStrokePaint", "V", "mCropGridPaint", "W", "mCropFramePaint", "a0", "mCropFrameCornersPaint", "b0", "getMFreestyleCropMode$annotations", "c0", "mPreviousTouchX", "d0", "mPreviousTouchY", "e0", "mCurrentTouchCornerIndex", "f0", "mTouchPointThreshold", "g0", "mCropRectMinSize", "h0", "mCropRectCornerTouchAreaLineLength", "i0", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$b;", "mCallback", "j0", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$c;", "rectCornerMoveInterceptor", "k0", "mShouldSetupCropBounds", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "m0", "AspectRatioType", "FreestyleMode", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorCropMaskView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float resBottomHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private float mThisWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private float mThisHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private float[] mCropGridCorners;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private float[] mCropGridCenter;

    /* renamed from: H, reason: from kotlin metadata */
    private int mCropGridRowCount;

    /* renamed from: I, reason: from kotlin metadata */
    private int mCropGridColumnCount;

    /* renamed from: J, reason: from kotlin metadata */
    private float mTargetAspectRatio;

    /* renamed from: K, reason: from kotlin metadata */
    private int mTargetAspectType;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private float[] mGridPoints;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mShowCropFrame;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mShowCropGrid;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mShowCropCornerTouchArea;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean mCircleDimmedLayer;

    /* renamed from: R, reason: from kotlin metadata */
    private int mDimmedColorWhenTouched;

    /* renamed from: S, reason: from kotlin metadata */
    private int mDimmedColor;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Path mCircularPath;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Paint mDimmedStrokePaint;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Paint mCropGridPaint;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Paint mCropFramePaint;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mCropFrameCornersPaint;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int mFreestyleCropMode;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float mPreviousTouchX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mCropViewRect;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float mPreviousTouchY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mTempRect;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int mCurrentTouchCornerIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float resPaddingLeft;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int mTouchPointThreshold;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int mCropRectMinSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float resPaddingTop;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int mCropRectCornerTouchAreaLineLength;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float resPaddingRight;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mCallback;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c rectCornerMoveInterceptor;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean mShouldSetupCropBounds;

    /* renamed from: l0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319761l0;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float resPaddingBottom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$AspectRatioType;", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes21.dex */
    public @interface AspectRatioType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$FreestyleMode;", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes21.dex */
    public @interface FreestyleMode {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$b;", "", "Landroid/graphics/RectF;", "cropRect", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NotNull RectF cropRect);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMaskView$c;", "", "", HippyTKDListViewAdapter.X, "y", "preX", "preY", "Landroid/graphics/PointF;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        @NotNull
        PointF a(float x16, float y16, float preX, float preY);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropMaskView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Canvas canvas) {
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
        if (this.mShowCropCornerTouchArea && this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF5 = this.mTempRect;
            int i38 = this.mCropRectCornerTouchAreaLineLength;
            rectF5.inset(i38, -i38);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF6 = this.mTempRect;
            int i39 = this.mCropRectCornerTouchAreaLineLength;
            rectF6.inset(-i39, i39);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    private final void b(Canvas canvas) {
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

    private final int d(float touchX, float touchY) {
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

    private final void i(float touchX, float touchY) {
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
            j();
            postInvalidate();
        }
    }

    private final void j() {
        float coerceAtMost;
        u uVar = u.f326728a;
        this.mCropGridCorners = uVar.f(this.mCropViewRect);
        this.mCropGridCenter = uVar.e(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        Path path = this.mCircularPath;
        float centerX = this.mCropViewRect.centerX();
        float centerY = this.mCropViewRect.centerY();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mCropViewRect.width(), this.mCropViewRect.height());
        path.addCircle(centerX, centerY, coerceAtMost / 2.0f, Path.Direction.CW);
    }

    @NotNull
    public final RectF c() {
        return new RectF(this.mCropViewRect);
    }

    /* renamed from: e, reason: from getter */
    public final float getMTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    /* renamed from: f, reason: from getter */
    public final int getMTargetAspectType() {
        return this.mTargetAspectType;
    }

    /* renamed from: g, reason: from getter */
    public final float getMThisHeight() {
        return this.mThisHeight;
    }

    /* renamed from: h, reason: from getter */
    public final float getMThisWidth() {
        return this.mThisWidth;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mFreestyleCropMode == 0) {
            return;
        }
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            this.mThisWidth = ((((right - left) - getPaddingRight()) - getPaddingLeft()) - this.resPaddingLeft) - this.resPaddingRight;
            float paddingBottom = (((((bottom - top) - getPaddingBottom()) - getPaddingTop()) - this.resPaddingTop) - this.resPaddingBottom) - this.resBottomHeight;
            this.mThisHeight = paddingBottom;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                int i3 = this.mTargetAspectType;
                if (i3 == 2 && this.mTargetAspectRatio <= 0.0f) {
                    this.mTargetAspectRatio = (this.mThisWidth * 1.0f) / paddingBottom;
                }
                setTargetAspectRatio(this.mTargetAspectRatio, i3);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        PointF a16;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z16 = false;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0 && this.mShowCropCornerTouchArea) {
            float x16 = event.getX();
            float y16 = event.getY();
            if ((event.getAction() & 255) == 0) {
                int d16 = d(x16, y16);
                this.mCurrentTouchCornerIndex = d16;
                if (d16 != -1) {
                    z16 = true;
                }
                if (!z16) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = x16;
                    this.mPreviousTouchY = y16;
                }
                return z16;
            }
            if ((event.getAction() & 255) == 2 && event.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float min = Math.min(Math.max(x16, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y16, getPaddingTop()), getHeight() - getPaddingBottom());
                c cVar = this.rectCornerMoveInterceptor;
                if (cVar != null && (a16 = cVar.a(min, min2, this.mPreviousTouchX, this.mPreviousTouchY)) != null) {
                    min = a16.x;
                    min2 = a16.y;
                }
                i(min, min2);
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            }
            if ((event.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                b bVar = this.mCallback;
                if (bVar != null && bVar != null) {
                    bVar.a(this.mCropViewRect);
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

    public final void setCropViewRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        w53.b.a("wink_crop_WinkEditorCropMaskView", "setCropViewRect " + com.tencent.mobileqq.wink.editor.util.e.a(rect));
        this.mCropViewRect.set(rect);
        this.mTargetAspectRatio = rect.width() / rect.height();
        j();
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

    public final void setOverlayViewChangeListener(@Nullable b callback) {
        this.mCallback = callback;
    }

    public final void setRectCornerMoveInterceptor(@NotNull c interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.rectCornerMoveInterceptor = interceptor;
    }

    public final void setResPadding(float left, float top, float right, float bottom, float bottomHeight) {
        this.resPaddingLeft = left;
        this.resPaddingTop = top;
        this.resPaddingRight = right;
        this.resPaddingBottom = bottom;
        this.resBottomHeight = bottomHeight;
        this.mShouldSetupCropBounds = true;
        requestLayout();
    }

    public final void setShowCropCornerTouchArea(boolean showCropCornerTouchArea) {
        this.mShowCropCornerTouchArea = showCropCornerTouchArea;
    }

    public final void setShowCropFrame(boolean showCropFrame) {
        this.mShowCropFrame = showCropFrame;
    }

    public final void setShowCropGrid(boolean showCropGrid) {
        this.mShowCropGrid = showCropGrid;
    }

    public final void setTargetAspectRatio(float targetAspectRatio, int type) {
        w53.b.a("wink_crop_WinkEditorCropMaskView", "setTargetAspectRatio targetAspectRatio:" + targetAspectRatio + ", type:" + type);
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
        b bVar = this.mCallback;
        if (bVar != null && bVar != null) {
            bVar.a(this.mCropViewRect);
        }
        j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f319761l0 = new LinkedHashMap();
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mCropGridCorners = new float[8];
        this.mCropGridCenter = new float[2];
        this.mCropGridRowCount = 2;
        this.mCropGridColumnCount = 2;
        this.mShowCropFrame = true;
        this.mShowCropGrid = true;
        this.mShowCropCornerTouchArea = true;
        this.mDimmedColorWhenTouched = ContextCompat.getColor(getContext(), R.color.bdc);
        this.mDimmedColor = ContextCompat.getColor(getContext(), R.color.bdc);
        this.mCircularPath = new Path();
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
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        paint3.setStrokeWidth(eVar.a(2.0f));
        this.mCropFramePaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setColor(-1);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(eVar.a(4.0f));
        this.mCropFrameCornersPaint = paint4;
        this.mFreestyleCropMode = 1;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = eVar.a(30.0f);
        this.mCropRectMinSize = eVar.a(100.0f);
        this.mCropRectCornerTouchAreaLineLength = eVar.a(10.0f);
    }
}
