package com.tencent.qcircle.tavcut.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qcircle.tavcut.view.ext.OnActiveBasePicListener;
import com.tencent.qcircle.tavcut.view.ext.OnGestureListener;
import com.tencent.qcircle.tavcut.view.ext.OnLongPressListener;
import com.tencent.qcircle.tavcut.view.ext.OnOutsidePhotoTapListener;
import com.tencent.qcircle.tavcut.view.ext.OnPhotoTapListener;
import com.tencent.qcircle.tavcut.view.ext.OnRotationListener;
import com.tencent.qcircle.tavcut.view.ext.OnScaleChangedListener;
import com.tencent.qcircle.tavcut.view.ext.OnSingleFlingListener;
import com.tencent.qcircle.tavcut.view.ext.OnViewDragListener;
import com.tencent.qcircle.tavcut.view.ext.OnViewTapListener;
import com.tencent.qcircle.tavcut.view.ext.TAVGestureDetector;
import com.tencent.tavsticker.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u008b\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010^\u001a\u0002012\u0006\u0010_\u001a\u00020)2\b\b\u0002\u0010`\u001a\u000201J\u0012\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0014J\u000e\u0010e\u001a\u00020b2\u0006\u0010f\u001a\u00020gJ\u0012\u0010h\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J \u0010i\u001a\u00020\r2\u0006\u0010j\u001a\u00020)2\u0006\u0010k\u001a\u00020)2\u0006\u0010_\u001a\u00020)H\u0002J\u0006\u0010l\u001a\u00020\rJ\u0006\u0010m\u001a\u00020\u0001J@\u0010n\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u00010'j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u0001`*2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020)0TJ\u0018\u0010o\u001a\u0002012\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020gH\u0016J\u000e\u0010s\u001a\u00020b2\u0006\u0010t\u001a\u000203J\u000e\u0010u\u001a\u00020b2\u0006\u0010v\u001a\u000201J\u000e\u0010w\u001a\u00020b2\u0006\u0010x\u001a\u000201J\u000e\u0010y\u001a\u00020b2\u0006\u0010z\u001a\u000207J\u001c\u0010{\u001a\u00020b2\u0006\u0010|\u001a\u00020!2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020)0TJ\u000e\u0010}\u001a\u00020b2\u0006\u0010~\u001a\u00020<J\u000f\u0010\u007f\u001a\u00020b2\u0007\u0010\u0080\u0001\u001a\u00020>J\u0012\u0010\u0081\u0001\u001a\u00020b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010DJ\u0012\u0010\u0082\u0001\u001a\u00020b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010FJ\u0010\u0010\u0083\u0001\u001a\u00020b2\u0007\u0010\u0084\u0001\u001a\u00020BJ\u0012\u0010\u0085\u0001\u001a\u00020b2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010HJ\u0012\u0010\u0087\u0001\u001a\u00020b2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010JJ\u0012\u0010\u0089\u0001\u001a\u00020b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010@J\u0012\u0010\u008a\u0001\u001a\u00020b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010OR\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R:\u0010&\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u00010'j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u0001`*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R:\u0010.\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u00010'j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u0001`*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010S\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010TX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\u001bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001d\"\u0004\bW\u0010\u001fR$\u0010Y\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/qcircle/tavcut/view/TAVCutImageView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_MAX_SCALE", "", "DEFAULT_MID_SCALE", "DEFAULT_MIN_SCALE", "DEFAULT_ZOOM_DURATION", "HORIZONTAL_EDGE_BOTH", "HORIZONTAL_EDGE_LEFT", "HORIZONTAL_EDGE_NONE", "HORIZONTAL_EDGE_RIGHT", "SINGLE_TOUCH", "VERTICAL_EDGE_BOTH", "VERTICAL_EDGE_BOTTOM", "VERTICAL_EDGE_NONE", "VERTICAL_EDGE_TOP", "bitmapBound", "Landroid/graphics/RectF;", "getBitmapBound", "()Landroid/graphics/RectF;", "setBitmapBound", "(Landroid/graphics/RectF;)V", "bmpZoom", "Landroid/graphics/Bitmap;", "getBmpZoom", "()Landroid/graphics/Bitmap;", "setBmpZoom", "(Landroid/graphics/Bitmap;)V", "borderLines", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/graphics/PointF;", "Lkotlin/collections/ArrayList;", "center", "innerImageView", "Landroid/widget/ImageView;", "innerLines", "innerStickerContainer", "isActive", "", "mActiveBasePicListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnActiveBasePicListener;", "mAllowParentInterceptOnEdge", "mBlockParentIntercept", "mGestureCallback", "Lcom/tencent/qcircle/tavcut/view/TAVCutImageView$GestureCallback;", "mGestureDetector", "Landroid/view/GestureDetector;", "mHorizontalScrollEdge", "mLongPressListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnLongPressListener;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnDragListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnViewDragListener;", "mOnRotationListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnRotationListener;", "mOutsidePhotoTapListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnOutsidePhotoTapListener;", "mPhotoTapListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnPhotoTapListener;", "mScaleChangeListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnScaleChangedListener;", "mSingleFlingListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnSingleFlingListener;", "mTAVDetector", "Lcom/tencent/qcircle/tavcut/view/ext/TAVGestureDetector;", "mVerticalScrollEdge", "mViewTapListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnViewTapListener;", "maxDis", "onGestureListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnGestureListener;", "points", "", "zoomBtnRect", "getZoomBtnRect", "setZoomBtnRect", "value", "zoomResId", "getZoomResId", "()I", "setZoomResId", "(I)V", "checkInside", "point", "isFromSticker", "dispatchDraw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "dispatchStickerTouchEvent", "e", "Landroid/view/MotionEvent;", "drawZoomBtn", "getCross", "p1", "p2", "getRotate", "getStickerContainer", "makePointPairs", "onTouch", "v", "Landroid/view/View;", "ev", "setActiveBasePicListener", "onActiveBasePicListener", "setAllowParentInterceptOnEdge", "allow", "setBasePicActive", "active", "setGestureCallback", "gestureCallback", "setImageBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "setLongPressListener", "onLongPressListener", "setOnClick", "listener", "setOnOutsidePhotoTapListener", "setOnPhotoTapListener", "setOnRotationListener", "onRotationListener", "setOnScaleChangeListener", "onScaleChangedListener", "setOnSingleFlingListener", "onSingleFlingListener", "setOnViewDragListener", "setOnViewTapListener", "GestureCallback", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class TAVCutImageView extends FrameLayout implements View.OnTouchListener {
    private final float DEFAULT_MAX_SCALE;
    private final float DEFAULT_MID_SCALE;
    private final float DEFAULT_MIN_SCALE;
    private final int DEFAULT_ZOOM_DURATION;
    private final int HORIZONTAL_EDGE_BOTH;
    private final int HORIZONTAL_EDGE_LEFT;
    private final int HORIZONTAL_EDGE_NONE;
    private final int HORIZONTAL_EDGE_RIGHT;
    private final int SINGLE_TOUCH;
    private final int VERTICAL_EDGE_BOTH;
    private final int VERTICAL_EDGE_BOTTOM;
    private final int VERTICAL_EDGE_NONE;
    private final int VERTICAL_EDGE_TOP;
    private HashMap _$_findViewCache;

    @Nullable
    private RectF bitmapBound;

    @Nullable
    private Bitmap bmpZoom;
    private ArrayList<Pair<PointF, PointF>> borderLines;
    private PointF center;
    private ImageView innerImageView;
    private ArrayList<Pair<PointF, PointF>> innerLines;
    private FrameLayout innerStickerContainer;
    private boolean isActive;
    private OnActiveBasePicListener mActiveBasePicListener;
    private boolean mAllowParentInterceptOnEdge;
    private boolean mBlockParentIntercept;
    private GestureCallback mGestureCallback;
    private GestureDetector mGestureDetector;
    private int mHorizontalScrollEdge;
    private OnLongPressListener mLongPressListener;
    private View.OnClickListener mOnClickListener;
    private OnViewDragListener mOnDragListener;
    private OnRotationListener mOnRotationListener;
    private OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangedListener mScaleChangeListener;
    private OnSingleFlingListener mSingleFlingListener;
    private TAVGestureDetector mTAVDetector;
    private int mVerticalScrollEdge;
    private OnViewTapListener mViewTapListener;
    private float maxDis;
    private final OnGestureListener onGestureListener;
    private List<? extends PointF> points;

    @NotNull
    private RectF zoomBtnRect;
    private int zoomResId;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qcircle/tavcut/view/TAVCutImageView$GestureCallback;", "", "getPoints", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRotate", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public interface GestureCallback {
        @Nullable
        ArrayList<float[]> getPoints();

        float getRotate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TAVCutImageView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public static /* synthetic */ boolean checkInside$default(TAVCutImageView tAVCutImageView, PointF pointF, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return tAVCutImageView.checkInside(pointF, z16);
    }

    private final void drawZoomBtn(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
            List<? extends PointF> list = this.points;
            if (list != null) {
                if (list.size() >= 4) {
                    float f16 = list.get(2).x;
                    float f17 = list.get(2).y;
                    canvas.rotate(getRotate(), f16, f17);
                    canvas.scale(0.5f, 0.5f, f16, f17);
                    Bitmap bitmap = this.bmpZoom;
                    if (bitmap != null) {
                        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        this.zoomBtnRect = new RectF(f16 - bitmap.getWidth(), f17 - bitmap.getHeight(), f16 + bitmap.getWidth(), f17 + bitmap.getHeight());
                        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                        canvas.drawBitmap(bitmap, rect, this.zoomBtnRect, (Paint) null);
                    }
                }
                canvas.restore();
            }
        }
    }

    private final float getCross(PointF p16, PointF p26, PointF point) {
        float f16 = point.x;
        float f17 = f16 - p16.x;
        float f18 = point.y;
        return (f17 * (f18 - p26.y)) - ((f16 - p26.x) * (f18 - p16.y));
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i3) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i3));
        if (view == null) {
            View findViewById = findViewById(i3);
            this._$_findViewCache.put(Integer.valueOf(i3), findViewById);
            return findViewById;
        }
        return view;
    }

    public final boolean checkInside(@NotNull PointF point, boolean isFromSticker) {
        int collectionSizeOrDefault;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(point, "point");
        if (isFromSticker) {
            point = new PointF(point.x + this.innerStickerContainer.getX(), point.y + this.innerStickerContainer.getY());
        }
        ArrayList<Pair<PointF, PointF>> arrayList = this.borderLines;
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                arrayList2.add(Float.valueOf(getCross((PointF) pair.getFirst(), (PointF) pair.getSecond(), point)));
            }
            if (!arrayList2.isEmpty()) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    if (Math.signum(((Number) it5.next()).floatValue()) == Math.signum(((Number) arrayList2.get(0)).floatValue())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.isActive) {
            return;
        }
        if (canvas != null) {
            canvas.save();
        }
        ArrayList<Pair<PointF, PointF>> arrayList = this.innerLines;
        if (arrayList != null) {
            RectF rectF = this.bitmapBound;
            if (rectF != null && canvas != null) {
                canvas.clipRect(rectF);
            }
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setStrokeWidth(ViewUtils.dip2px(0.5f));
            paint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            paint2.setColor(Color.parseColor("#B3FFFFFF"));
            paint2.setStrokeWidth(ViewUtils.dip2px(0.5f));
            paint2.setStyle(Paint.Style.STROKE);
            if (arrayList.size() < 8) {
                return;
            }
            for (int i3 = 0; i3 <= 7; i3++) {
                Path path = new Path();
                path.moveTo(arrayList.get(i3).getFirst().x, arrayList.get(i3).getFirst().y);
                path.lineTo(arrayList.get(i3).getSecond().x, arrayList.get(i3).getSecond().y);
                if (i3 <= 3) {
                    if (canvas != null) {
                        canvas.drawPath(path, paint);
                    }
                } else if (canvas != null) {
                    canvas.drawPath(path, paint2);
                }
            }
        }
        drawZoomBtn(canvas);
        if (canvas != null) {
            canvas.restore();
        }
    }

    public final void dispatchStickerTouchEvent(@NotNull MotionEvent e16) {
        Intrinsics.checkParameterIsNotNull(e16, "e");
        this.innerStickerContainer.dispatchTouchEvent(e16);
    }

    @Nullable
    public final RectF getBitmapBound() {
        return this.bitmapBound;
    }

    @Nullable
    protected final Bitmap getBmpZoom() {
        return this.bmpZoom;
    }

    public final float getRotate() {
        GestureCallback gestureCallback = this.mGestureCallback;
        if (gestureCallback != null) {
            return gestureCallback.getRotate();
        }
        return 0.0f;
    }

    @NotNull
    /* renamed from: getStickerContainer, reason: from getter */
    public final FrameLayout getInnerStickerContainer() {
        return this.innerStickerContainer;
    }

    @NotNull
    protected final RectF getZoomBtnRect() {
        return this.zoomBtnRect;
    }

    public final int getZoomResId() {
        return this.zoomResId;
    }

    @Nullable
    public final ArrayList<Pair<PointF, PointF>> makePointPairs(@NotNull List<? extends PointF> points) {
        Intrinsics.checkParameterIsNotNull(points, "points");
        int i3 = 1;
        if (!(!points.isEmpty()) || points.size() < 4) {
            return null;
        }
        ArrayList<Pair<PointF, PointF>> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        float f16 = 0.0f;
        int i16 = -1;
        for (int i17 = 1; i17 <= 3; i17++) {
            float calcDistance = TAVCutImageViewKt.calcDistance(points.get(0), points.get(i17));
            if (calcDistance > f16) {
                i16 = i17;
                f16 = calcDistance;
            }
        }
        this.maxDis = f16;
        if (this.center == null) {
            this.center = new PointF();
            Unit unit = Unit.INSTANCE;
        }
        PointF pointF = this.center;
        if (pointF != null) {
            float f17 = 2;
            pointF.x = (points.get(0).x + points.get(i16).x) / f17;
            pointF.y = (points.get(0).y + points.get(i16).y) / f17;
        }
        boolean z16 = false;
        for (int i18 = 1; i18 <= 3; i18++) {
            if (i18 == i16) {
                boolean z17 = false;
                for (int i19 = 1; i19 <= 3; i19++) {
                    if (i18 != i19) {
                        if (z17) {
                            arrayList.add(new Pair<>(points.get(i18), points.get(i19)));
                            arrayList2.add(new Pair(points.get(i19), points.get(i18)));
                        } else {
                            arrayList.add(new Pair<>(points.get(i19), points.get(i18)));
                            arrayList2.add(new Pair(points.get(i18), points.get(i19)));
                            z17 = true;
                        }
                    }
                }
            } else if (z16) {
                arrayList.add(new Pair<>(points.get(0), points.get(i18)));
                arrayList2.add(new Pair(points.get(0), points.get(i18)));
            } else {
                arrayList.add(new Pair<>(points.get(i18), points.get(0)));
                arrayList2.add(new Pair(points.get(i18), points.get(0)));
                z16 = true;
            }
        }
        this.borderLines = new ArrayList<>(arrayList2);
        int i26 = 1;
        for (int i27 = 2; i26 <= i27; i27 = 2) {
            float f18 = 3;
            float f19 = i26;
            float f26 = (((arrayList.get(0).getFirst().x - arrayList.get(0).getSecond().x) / f18) * f19) + arrayList.get(0).getSecond().x;
            float f27 = (((arrayList.get(0).getFirst().y - arrayList.get(0).getSecond().y) / f18) * f19) + arrayList.get(0).getSecond().y;
            float f28 = (((arrayList.get(i3).getFirst().x - arrayList.get(i3).getSecond().x) / f18) * f19) + arrayList.get(i3).getSecond().x;
            float f29 = (((arrayList.get(i3).getFirst().y - arrayList.get(i3).getSecond().y) / f18) * f19) + arrayList.get(i3).getSecond().y;
            float f36 = (((arrayList.get(i27).getFirst().x - arrayList.get(i27).getSecond().x) / f18) * f19) + arrayList.get(i27).getSecond().x;
            float f37 = (((arrayList.get(i27).getFirst().y - arrayList.get(i27).getSecond().y) / f18) * f19) + arrayList.get(i27).getSecond().y;
            float f38 = (((arrayList.get(3).getFirst().x - arrayList.get(3).getSecond().x) / f18) * f19) + arrayList.get(3).getSecond().x;
            float f39 = (((arrayList.get(3).getFirst().y - arrayList.get(3).getSecond().y) / f18) * f19) + arrayList.get(3).getSecond().y;
            arrayList.add(new Pair<>(new PointF(f26, f27), new PointF(f36, f37)));
            arrayList.add(new Pair<>(new PointF(f28, f29), new PointF(f38, f39)));
            i26++;
            i3 = 1;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(@NotNull View v3, @NotNull MotionEvent ev5) {
        boolean z16;
        TAVGestureDetector tAVGestureDetector;
        boolean z17;
        TAVGestureDetector tAVGestureDetector2;
        boolean z18;
        TAVGestureDetector tAVGestureDetector3;
        boolean z19;
        TAVGestureDetector tAVGestureDetector4;
        TAVGestureDetector tAVGestureDetector5;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        GestureDetector gestureDetector;
        TAVGestureDetector tAVGestureDetector6;
        TAVGestureDetector tAVGestureDetector7;
        TAVGestureDetector tAVGestureDetector8;
        OnLongPressListener onLongPressListener;
        Intrinsics.checkParameterIsNotNull(v3, "v");
        Intrinsics.checkParameterIsNotNull(ev5, "ev");
        int action = ev5.getAction();
        boolean z36 = false;
        if (action != 0) {
            if ((action == 1 || action == 3) && (onLongPressListener = this.mLongPressListener) != null) {
                onLongPressListener.onLongPressRelease();
            }
        } else {
            ViewParent parent = v3.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (this.zoomBtnRect.contains(ev5.getX(), ev5.getY())) {
                z16 = true;
                tAVGestureDetector = this.mTAVDetector;
                if (tAVGestureDetector == null && tAVGestureDetector.isScaling()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                tAVGestureDetector2 = this.mTAVDetector;
                if (tAVGestureDetector2 == null && tAVGestureDetector2.isDragging()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                tAVGestureDetector3 = this.mTAVDetector;
                if (tAVGestureDetector3 == null && tAVGestureDetector3.isRotating()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                tAVGestureDetector4 = this.mTAVDetector;
                if (tAVGestureDetector4 != null) {
                    tAVGestureDetector4.setCenter(this.center, this.maxDis);
                }
                tAVGestureDetector5 = this.mTAVDetector;
                if (tAVGestureDetector5 == null && tAVGestureDetector5.onTouchEvent(ev5, z16)) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z17 && (tAVGestureDetector8 = this.mTAVDetector) != null && !tAVGestureDetector8.isScaling()) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z18 && (tAVGestureDetector7 = this.mTAVDetector) != null && !tAVGestureDetector7.isDragging()) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (z19 && (tAVGestureDetector6 = this.mTAVDetector) != null && !tAVGestureDetector6.isRotating()) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (z27 && z28 && z29) {
                    z36 = true;
                }
                this.mBlockParentIntercept = z36;
                gestureDetector = this.mGestureDetector;
                if (gestureDetector == null && gestureDetector.onTouchEvent(ev5)) {
                    return true;
                }
                return z26;
            }
        }
        z16 = false;
        tAVGestureDetector = this.mTAVDetector;
        if (tAVGestureDetector == null) {
        }
        z17 = false;
        tAVGestureDetector2 = this.mTAVDetector;
        if (tAVGestureDetector2 == null) {
        }
        z18 = false;
        tAVGestureDetector3 = this.mTAVDetector;
        if (tAVGestureDetector3 == null) {
        }
        z19 = false;
        tAVGestureDetector4 = this.mTAVDetector;
        if (tAVGestureDetector4 != null) {
        }
        tAVGestureDetector5 = this.mTAVDetector;
        if (tAVGestureDetector5 == null) {
        }
        z26 = false;
        if (z17) {
        }
        z27 = false;
        if (z18) {
        }
        z28 = false;
        if (z19) {
        }
        z29 = false;
        if (z27) {
            z36 = true;
        }
        this.mBlockParentIntercept = z36;
        gestureDetector = this.mGestureDetector;
        if (gestureDetector == null) {
        }
        return z26;
    }

    public final void setActiveBasePicListener(@NotNull OnActiveBasePicListener onActiveBasePicListener) {
        Intrinsics.checkParameterIsNotNull(onActiveBasePicListener, "onActiveBasePicListener");
        this.mActiveBasePicListener = onActiveBasePicListener;
    }

    public final void setAllowParentInterceptOnEdge(boolean allow) {
        this.mAllowParentInterceptOnEdge = allow;
    }

    public final void setBasePicActive(boolean active) {
        if (active != this.isActive) {
            this.isActive = active;
            postInvalidate();
        }
    }

    public final void setBitmapBound(@Nullable RectF rectF) {
        this.bitmapBound = rectF;
    }

    protected final void setBmpZoom(@Nullable Bitmap bitmap) {
        this.bmpZoom = bitmap;
    }

    public final void setGestureCallback(@NotNull GestureCallback gestureCallback) {
        Intrinsics.checkParameterIsNotNull(gestureCallback, "gestureCallback");
        this.mGestureCallback = gestureCallback;
    }

    public final void setImageBitmap(@NotNull final Bitmap bitmap, @NotNull final List<? extends PointF> points) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        Intrinsics.checkParameterIsNotNull(points, "points");
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.view.TAVCutImageView$setImageBitmap$1
            @Override // java.lang.Runnable
            public final void run() {
                ImageView imageView;
                TAVCutImageView.this.points = points;
                TAVCutImageView tAVCutImageView = TAVCutImageView.this;
                tAVCutImageView.innerLines = tAVCutImageView.makePointPairs(points);
                TAVCutImageView.this.setBitmapBound(TAVCutImageViewKt.calculateBitmap(r0.getMeasuredWidth(), TAVCutImageView.this.getMeasuredHeight(), bitmap));
                if (!bitmap.isRecycled()) {
                    imageView = TAVCutImageView.this.innerImageView;
                    imageView.setImageBitmap(bitmap);
                }
                TAVCutImageView.this.invalidate();
            }
        });
    }

    public final void setLongPressListener(@NotNull OnLongPressListener onLongPressListener) {
        Intrinsics.checkParameterIsNotNull(onLongPressListener, "onLongPressListener");
        this.mLongPressListener = onLongPressListener;
    }

    public final void setOnClick(@NotNull View.OnClickListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.mOnClickListener = listener;
    }

    public final void setOnOutsidePhotoTapListener(@Nullable OnOutsidePhotoTapListener listener) {
        this.mOutsidePhotoTapListener = listener;
    }

    public final void setOnPhotoTapListener(@Nullable OnPhotoTapListener listener) {
        this.mPhotoTapListener = listener;
    }

    public final void setOnRotationListener(@NotNull OnRotationListener onRotationListener) {
        Intrinsics.checkParameterIsNotNull(onRotationListener, "onRotationListener");
        this.mOnRotationListener = onRotationListener;
    }

    public final void setOnScaleChangeListener(@Nullable OnScaleChangedListener onScaleChangedListener) {
        this.mScaleChangeListener = onScaleChangedListener;
    }

    public final void setOnSingleFlingListener(@Nullable OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    public final void setOnViewDragListener(@Nullable OnViewDragListener listener) {
        this.mOnDragListener = listener;
    }

    public final void setOnViewTapListener(@Nullable OnViewTapListener listener) {
        this.mViewTapListener = listener;
    }

    protected final void setZoomBtnRect(@NotNull RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "<set-?>");
        this.zoomBtnRect = rectF;
    }

    public final void setZoomResId(int i3) {
        this.zoomResId = i3;
        this.bmpZoom = BitmapFactory.decodeResource(getResources(), this.zoomResId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TAVCutImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TAVCutImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.DEFAULT_MAX_SCALE = 3.0f;
        this.DEFAULT_MID_SCALE = 1.75f;
        this.DEFAULT_MIN_SCALE = 1.0f;
        this.DEFAULT_ZOOM_DURATION = 200;
        this.HORIZONTAL_EDGE_NONE = -1;
        this.HORIZONTAL_EDGE_RIGHT = 1;
        this.HORIZONTAL_EDGE_BOTH = 2;
        this.VERTICAL_EDGE_NONE = -1;
        this.VERTICAL_EDGE_BOTTOM = 1;
        this.VERTICAL_EDGE_BOTH = 2;
        this.SINGLE_TOUCH = 1;
        this.mAllowParentInterceptOnEdge = true;
        this.mHorizontalScrollEdge = 2;
        this.mVerticalScrollEdge = 2;
        this.innerImageView = new ImageView(getContext());
        this.innerStickerContainer = new FrameLayout(getContext());
        this.zoomBtnRect = new RectF();
        OnGestureListener onGestureListener = new OnGestureListener() { // from class: com.tencent.qcircle.tavcut.view.TAVCutImageView$onGestureListener$1
            @Override // com.tencent.qcircle.tavcut.view.ext.OnGestureListener
            public void onDrag(float dx5, float dy5) {
                TAVGestureDetector tAVGestureDetector;
                OnViewDragListener onViewDragListener;
                boolean z16;
                tAVGestureDetector = TAVCutImageView.this.mTAVDetector;
                if (tAVGestureDetector != null && tAVGestureDetector.isScaling()) {
                    return;
                }
                ViewParent parent = TAVCutImageView.this.getParent();
                Intrinsics.checkExpressionValueIsNotNull(parent, "parent");
                if (!TAVCutImageView.this.isActive) {
                    z16 = TAVCutImageView.this.mBlockParentIntercept;
                    if (!z16) {
                        parent.requestDisallowInterceptTouchEvent(false);
                        if (TAVCutImageView.this.isActive && onViewDragListener != null) {
                            onViewDragListener.onDrag(dx5, dy5);
                        }
                        return;
                    }
                }
                parent.requestDisallowInterceptTouchEvent(true);
                if (TAVCutImageView.this.isActive) {
                    onViewDragListener = TAVCutImageView.this.mOnDragListener;
                    onViewDragListener.onDrag(dx5, dy5);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
            
                r0 = r1.this$0.mOnRotationListener;
             */
            @Override // com.tencent.qcircle.tavcut.view.ext.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onRotation(float focusX, float focusY, float angle) {
                OnRotationListener onRotationListener;
                if (TAVCutImageView.this.isActive && onRotationListener != null) {
                    onRotationListener.onRotation(focusX, focusY, angle);
                }
            }

            @Override // com.tencent.qcircle.tavcut.view.ext.OnGestureListener
            public void onScale(float scaleFactor, float focusX, float focusY) {
                if (TAVCutImageView.this.isActive) {
                    onScale(scaleFactor, focusX, focusY, 0.0f, 0.0f);
                }
            }

            @Override // com.tencent.qcircle.tavcut.view.ext.OnGestureListener
            public void onScale(float scaleFactor, float focusX, float focusY, float dx5, float dy5) {
                OnScaleChangedListener onScaleChangedListener;
                OnViewDragListener onViewDragListener;
                if (TAVCutImageView.this.isActive) {
                    onScaleChangedListener = TAVCutImageView.this.mScaleChangeListener;
                    if (onScaleChangedListener != null) {
                        onScaleChangedListener.onScaleChange(scaleFactor, focusX, focusY);
                    }
                    onViewDragListener = TAVCutImageView.this.mOnDragListener;
                    if (onViewDragListener != null) {
                        onViewDragListener.onDrag(dx5, dy5);
                    }
                }
            }

            @Override // com.tencent.qcircle.tavcut.view.ext.OnGestureListener
            public void onFling(float startX, float startY, float velocityX, float velocityY) {
            }
        };
        this.onGestureListener = onGestureListener;
        addView(this.innerImageView, new FrameLayout.LayoutParams(-1, -1));
        addView(this.innerStickerContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mTAVDetector = new TAVGestureDetector(getContext(), onGestureListener);
        GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.qcircle.tavcut.view.TAVCutImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
                Intrinsics.checkParameterIsNotNull(e16, "e1");
                Intrinsics.checkParameterIsNotNull(e26, "e2");
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(@NotNull MotionEvent e16) {
                Intrinsics.checkParameterIsNotNull(e16, "e");
                OnLongPressListener onLongPressListener = TAVCutImageView.this.mLongPressListener;
                if (onLongPressListener != null) {
                    onLongPressListener.onLongPress();
                }
            }
        });
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.tencent.qcircle.tavcut.view.TAVCutImageView.2
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(@NotNull MotionEvent ev5) {
                Intrinsics.checkParameterIsNotNull(ev5, "ev");
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(@NotNull MotionEvent e16) {
                Intrinsics.checkParameterIsNotNull(e16, "e");
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
                Intrinsics.checkParameterIsNotNull(e16, "e");
                View.OnClickListener onClickListener = TAVCutImageView.this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(TAVCutImageView.this);
                }
                OnViewTapListener onViewTapListener = TAVCutImageView.this.mViewTapListener;
                if (onViewTapListener != null) {
                    onViewTapListener.onViewTap(TAVCutImageView.this, e16.getX(), e16.getY(), e16);
                    return false;
                }
                return false;
            }
        });
        setOnTouchListener(this);
        setOnViewTapListener(new OnViewTapListener() { // from class: com.tencent.qcircle.tavcut.view.TAVCutImageView.3
            @Override // com.tencent.qcircle.tavcut.view.ext.OnViewTapListener
            public void onViewTap(@Nullable View view, float x16, float y16, @NotNull MotionEvent e16) {
                OnActiveBasePicListener onActiveBasePicListener;
                Intrinsics.checkParameterIsNotNull(e16, "e");
                boolean z16 = TAVCutImageView.this.isActive;
                TAVCutImageView tAVCutImageView = TAVCutImageView.this;
                boolean z17 = false;
                if (TAVCutImageView.checkInside$default(tAVCutImageView, new PointF(x16, y16), false, 2, null) && !TAVCutImageView.this.isActive) {
                    z17 = true;
                }
                tAVCutImageView.isActive = z17;
                if (z16 != TAVCutImageView.this.isActive && (onActiveBasePicListener = TAVCutImageView.this.mActiveBasePicListener) != null) {
                    onActiveBasePicListener.OnActiveBasePic(TAVCutImageView.this.isActive, e16);
                }
                TAVCutImageView.this.invalidate();
            }
        });
    }
}
