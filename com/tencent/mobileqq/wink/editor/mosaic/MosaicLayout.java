package com.tencent.mobileqq.wink.editor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import com.tencent.widget.ScaleGestureDetector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001mB\u0019\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J0\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0014J(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0014J\u0018\u0010 \u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000fJ@\u0010 \u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020#2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%J@\u0010 \u001a\u00020\u00032\u0006\u0010*\u001a\u00020)2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020#2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%J\u0012\u0010+\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0016J\u0014\u00102\u001a\u0004\u0018\u00010!2\n\b\u0002\u00101\u001a\u0004\u0018\u00010!J\b\u00103\u001a\u0004\u0018\u00010)J\u0006\u00104\u001a\u00020\fJ\u0006\u00105\u001a\u00020\fJ\u000e\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206R\"\u0010?\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010DR\u0016\u0010G\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010FR\u0016\u0010H\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010FR\u0016\u0010J\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010IR\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010RR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010FR\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010LR\u0016\u0010]\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010LR\u0016\u0010_\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010FR\u0016\u0010a\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010FR\u0016\u0010c\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010FR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010R\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/MosaicLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/widget/ScaleGestureDetector$OnScaleGestureListener;", "", tl.h.F, "g", "i", "Landroid/graphics/RectF;", "rectF", "c", "Landroid/view/MotionEvent;", "event", "", "e", "d", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "l", "t", "r", "b", "onLayout", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "La73/a;", "viewModel", "index", "setData", "", "path", "", "degree", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "unDoPaintPath", "reDoPaintPath", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onTouchEvent", "Lcom/tencent/widget/ScaleGestureDetector;", "detector", "onScale", "onScaleBegin", "onScaleEnd", "business", "k", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lq83/a;", "mosaicPaintUpdateCallback", "setMosaicPaintUpdateCallback", "Lcom/tencent/mobileqq/wink/editor/mosaic/PicMosaicView;", "Lcom/tencent/mobileqq/wink/editor/mosaic/PicMosaicView;", "getMosaicView", "()Lcom/tencent/mobileqq/wink/editor/mosaic/PicMosaicView;", "setMosaicView", "(Lcom/tencent/mobileqq/wink/editor/mosaic/PicMosaicView;)V", "mosaicView", "Landroid/view/View;", "Landroid/view/View;", "layerView", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", UserInfo.SEX_FEMALE, "lastX", "lastY", "Lcom/tencent/widget/ScaleGestureDetector;", "scaleGestureDetector", BdhLogUtil.LogTag.Tag_Conn, "I", "gestureState", "D", "firstFingerId", "E", "Ljava/lang/String;", "Landroid/graphics/RectF;", "showRect", "G", "H", "Ljava/util/concurrent/CopyOnWriteArrayList;", "J", "Landroid/graphics/Bitmap;", "originBitmap", "K", "bitmapViewWidth", "L", "bitmapViewHeight", "M", "baseScale", "N", "showOriginRectWidth", "P", "showOriginRectHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "showViewRectF", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", ExifInterface.LATITUDE_SOUTH, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MosaicLayout extends RelativeLayout implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: C, reason: from kotlin metadata */
    private int gestureState;

    /* renamed from: D, reason: from kotlin metadata */
    private int firstFingerId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String path;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RectF showRect;

    /* renamed from: G, reason: from kotlin metadata */
    private float degree;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private CopyOnWriteArrayList<MosaicLinePath> unDoPaintPath;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private CopyOnWriteArrayList<MosaicLinePath> reDoPaintPath;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Bitmap originBitmap;

    /* renamed from: K, reason: from kotlin metadata */
    private int bitmapViewWidth;

    /* renamed from: L, reason: from kotlin metadata */
    private int bitmapViewHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private float baseScale;

    /* renamed from: N, reason: from kotlin metadata */
    private float showOriginRectWidth;

    /* renamed from: P, reason: from kotlin metadata */
    private float showOriginRectHeight;

    /* renamed from: Q, reason: from kotlin metadata */
    private RectF showViewRectF;

    @NotNull
    public Map<Integer, View> R;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PicMosaicView mosaicView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View layerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float lastX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float lastY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ScaleGestureDetector scaleGestureDetector;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/mosaic/MosaicLayout$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            Bitmap bitmap;
            super.onStateChange(state, option);
            if (state == LoadState.STATE_SUCCESS) {
                Bitmap bitmap2 = null;
                if (option != null) {
                    bitmap = option.getResultBitMap();
                } else {
                    bitmap = null;
                }
                w53.b.f("MosaicLayout", "initBitmap" + bitmap);
                MosaicLayout mosaicLayout = MosaicLayout.this;
                if (option != null) {
                    bitmap2 = option.getResultBitMap();
                }
                mosaicLayout.originBitmap = bitmap2;
                MosaicLayout.this.i();
                return;
            }
            w53.b.g("MosaicLayout", "state:" + state);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MosaicLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.R = new LinkedHashMap();
        this.gestureState = 1;
        this.firstFingerId = -1;
        this.path = "";
        PicMosaicView picMosaicView = new PicMosaicView(context, null, 2, 0 == true ? 1 : 0);
        this.mosaicView = picMosaicView;
        addView(picMosaicView, new RelativeLayout.LayoutParams(-2, -2));
        View view = new View(context);
        this.layerView = view;
        addView(view, new RelativeLayout.LayoutParams(-1, -1));
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStrokeWidth(ViewUtils.dip2px(4.0f));
        paint.setStyle(Paint.Style.STROKE);
        this.paint = paint;
        this.scaleGestureDetector = new ScaleGestureDetector(context, this);
    }

    private final void c(RectF rectF) {
        boolean z16;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(-16777216);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
        shapeDrawable2.getPaint().setColor(-16777216);
        boolean z17 = false;
        LayerDrawable layerDrawable = new LayerDrawable(new ShapeDrawable[]{shapeDrawable, shapeDrawable2});
        if (rectF != null) {
            if (rectF.left == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (rectF.top == 0.0f) {
                    z17 = true;
                }
                if (!z17) {
                    layerDrawable.setLayerInset(0, 0, 0, 0, (int) rectF.bottom);
                    layerDrawable.setLayerInset(1, 0, (int) rectF.bottom, 0, 0);
                }
            }
            layerDrawable.setLayerInset(0, 0, 0, (int) rectF.right, 0);
            layerDrawable.setLayerInset(1, (int) rectF.right, 0, 0, 0);
        }
        this.layerView.setBackground(layerDrawable);
        requestLayout();
    }

    private final boolean d(MotionEvent event) {
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.firstFingerId = event.getPointerId(0);
        }
        if (this.firstFingerId != event.getPointerId(event.getActionIndex())) {
            return false;
        }
        MotionEvent copyEvent = MotionEvent.obtain(event);
        float[] fArr = {event.getX(), event.getY()};
        Matrix matrix = new Matrix();
        this.mosaicView.getMatrix().invert(matrix);
        matrix.mapPoints(fArr);
        copyEvent.setLocation(fArr[0], fArr[1]);
        if (actionMasked == 6 && this.firstFingerId == event.getPointerId(event.getActionIndex())) {
            copyEvent.setAction(1);
        }
        PicMosaicView picMosaicView = this.mosaicView;
        Intrinsics.checkNotNullExpressionValue(copyEvent, "copyEvent");
        boolean m3 = picMosaicView.m(copyEvent);
        copyEvent.recycle();
        return m3;
    }

    private final boolean e(MotionEvent event) {
        return this.scaleGestureDetector.onTouchEvent(event);
    }

    private final void g() {
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option obtain = Option.obtain();
        obtain.setUrl(this.path);
        obtain.setLoadingDrawableColor(0);
        g16.loadImage(obtain, new b());
    }

    private final void h() {
        Unit unit;
        RectF rectF = this.showRect;
        RectF rectF2 = null;
        if (rectF != null) {
            Intrinsics.checkNotNull(rectF);
            float f16 = rectF.right;
            RectF rectF3 = this.showRect;
            Intrinsics.checkNotNull(rectF3);
            this.showOriginRectWidth = f16 - rectF3.left;
            RectF rectF4 = this.showRect;
            Intrinsics.checkNotNull(rectF4);
            float f17 = rectF4.bottom;
            RectF rectF5 = this.showRect;
            Intrinsics.checkNotNull(rectF5);
            this.showOriginRectHeight = f17 - rectF5.top;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.showOriginRectWidth = this.bitmapViewWidth;
            this.showOriginRectHeight = this.bitmapViewHeight;
        }
        if (getWidth() / this.showOriginRectWidth >= getHeight() / this.showOriginRectHeight) {
            this.baseScale = getHeight() / this.showOriginRectHeight;
            float width = (getWidth() - (this.showOriginRectWidth * this.baseScale)) / 2;
            this.showViewRectF = new RectF(width, 0.0f, (this.showOriginRectWidth * this.baseScale) + width, getHeight());
        } else {
            this.baseScale = getWidth() / this.showOriginRectWidth;
            float height = (getHeight() - (this.showOriginRectHeight * this.baseScale)) / 2;
            this.showViewRectF = new RectF(0.0f, height, getWidth(), (this.showOriginRectHeight * this.baseScale) + height);
        }
        Matrix matrix = new Matrix();
        float f18 = this.baseScale;
        matrix.setScale(f18, f18);
        RectF rectF6 = new RectF();
        RectF rectF7 = this.showRect;
        if (rectF7 != null) {
            matrix.mapRect(rectF6, rectF7);
        } else {
            RectF rectF8 = new RectF(0.0f, 0.0f, this.showOriginRectWidth, this.showOriginRectHeight);
            matrix.mapRect(rectF6, rectF8);
            w53.b.f("MosaicLayout", "baseScale:" + this.baseScale + " srcRect:" + rectF8 + " -> dstRectF:" + rectF6);
        }
        PicMosaicView picMosaicView = this.mosaicView;
        picMosaicView.setPivotX(0.0f);
        picMosaicView.setPivotY(0.0f);
        picMosaicView.setScaleX(this.baseScale);
        picMosaicView.setScaleY(this.baseScale);
        RectF rectF9 = this.showViewRectF;
        if (rectF9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showViewRectF");
            rectF9 = null;
        }
        picMosaicView.setX(rectF9.left - rectF6.left);
        RectF rectF10 = this.showViewRectF;
        if (rectF10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showViewRectF");
            rectF10 = null;
        }
        picMosaicView.setY(rectF10.top - rectF6.top);
        picMosaicView.setRotation(this.degree);
        this.mosaicView.setBaseScale(this.baseScale);
        this.mosaicView.r(1.0f, this.baseScale * 1.0f, 3.0f);
        RectF rectF11 = this.showViewRectF;
        if (rectF11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showViewRectF");
        } else {
            rectF2 = rectF11;
        }
        c(rectF2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        Integer num;
        Integer num2;
        Bitmap bitmap = this.originBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            this.bitmapViewWidth = bitmap.getWidth();
            Bitmap bitmap2 = this.originBitmap;
            Intrinsics.checkNotNull(bitmap2);
            this.bitmapViewHeight = bitmap2.getHeight();
            Bitmap bitmap3 = this.originBitmap;
            BitmapDrawable bitmapDrawable = null;
            if (bitmap3 != null) {
                num = Integer.valueOf(bitmap3.getWidth());
            } else {
                num = null;
            }
            Bitmap bitmap4 = this.originBitmap;
            if (bitmap4 != null) {
                num2 = Integer.valueOf(bitmap4.getHeight());
            } else {
                num2 = null;
            }
            w53.b.f("MosaicLayout", "bitmapViewWidth:" + num + " bitmapViewHeight:" + num2);
            this.mosaicView.setImageBitmap(this.originBitmap);
            Bitmap bitmap5 = this.originBitmap;
            Intrinsics.checkNotNull(bitmap5);
            if (bitmap5.getDensity() != 0) {
                Drawable drawable = this.mosaicView.getDrawable();
                if (drawable instanceof BitmapDrawable) {
                    bitmapDrawable = (BitmapDrawable) drawable;
                }
                if (bitmapDrawable != null) {
                    Bitmap bitmap6 = this.originBitmap;
                    Intrinsics.checkNotNull(bitmap6);
                    bitmapDrawable.setTargetDensity(bitmap6.getDensity());
                }
            }
            PicMosaicView picMosaicView = this.mosaicView;
            CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList = this.unDoPaintPath;
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            picMosaicView.setUnDoPathList(copyOnWriteArrayList);
            PicMosaicView picMosaicView2 = this.mosaicView;
            CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList2 = this.reDoPaintPath;
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            }
            picMosaicView2.setReDoPathList(copyOnWriteArrayList2);
            this.mosaicView.setScaleType(ImageView.ScaleType.MATRIX);
            this.mosaicView.setImageMatrix(new Matrix());
            PicMosaicView picMosaicView3 = this.mosaicView;
            Bitmap bitmap7 = this.originBitmap;
            Intrinsics.checkNotNull(bitmap7);
            picMosaicView3.setOriginBitmap(bitmap7);
            this.mosaicView.setMeasureWidthAndHeight(this.bitmapViewWidth, this.bitmapViewHeight);
            measureChild(this.mosaicView, View.MeasureSpec.makeMeasureSpec(this.bitmapViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.bitmapViewHeight, 1073741824));
            requestLayout();
            h();
        }
    }

    public static /* synthetic */ String l(MosaicLayout mosaicLayout, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return mosaicLayout.k(str);
    }

    @Nullable
    public final Bitmap f() {
        return this.mosaicView.g();
    }

    public final boolean j() {
        boolean k3 = this.mosaicView.k();
        if (k3) {
            this.mosaicView.invalidate();
        }
        return k3;
    }

    @Nullable
    public final String k(@Nullable String business) {
        return this.mosaicView.o(business);
    }

    public final boolean m() {
        boolean q16 = this.mosaicView.q();
        if (q16) {
            this.mosaicView.invalidate();
        }
        return q16;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        w53.b.a("MosaicLayout", "onLayout... mosaicView.measuredWidth:" + this.mosaicView.getMeasuredWidth() + " mosaicView.measuredHeight:" + this.mosaicView.getMeasuredHeight());
        PicMosaicView picMosaicView = this.mosaicView;
        picMosaicView.layout(0, 0, picMosaicView.getMeasuredWidth(), this.mosaicView.getMeasuredHeight());
        View view = this.layerView;
        view.layout(0, 0, view.getMeasuredWidth(), this.layerView.getMeasuredHeight());
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChild(this.mosaicView, widthMeasureSpec, heightMeasureSpec);
        measureChild(this.layerView, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        float scaleFactor = detector.getScaleFactor();
        float scaleX = getScaleX();
        float min = Math.min(3.0f / scaleX, Math.max(1.0f / scaleX, scaleFactor));
        float f16 = 1;
        if (Math.abs(min - f16) < 1.0E-6d) {
            w53.b.a("MosaicLayout", "onScale false");
            return true;
        }
        int width = getWidth();
        int height = getHeight();
        float f17 = f16 - min;
        float x16 = getX() + ((detector.getFocusX() * f17) / scaleX);
        float y16 = getY() + ((detector.getFocusY() * f17) / scaleX);
        if (x16 > 0.0f) {
            x16 = 0.0f;
        } else {
            float f18 = width;
            float f19 = f18 * min;
            if (x16 + f19 < f18) {
                x16 = f18 - f19;
            }
        }
        setX(x16);
        if (y16 > 0.0f) {
            y16 = 0.0f;
        } else {
            float f26 = height;
            float f27 = f26 * min;
            if (y16 + f27 < f26) {
                y16 = f26 - f27;
            }
        }
        setY(y16);
        setPivotX(detector.getFocusX());
        setPivotY(detector.getFocusY());
        setScaleX(getScaleX() * min);
        setScaleY(getScaleY() * min);
        this.lastX = detector.getFocusX();
        this.lastY = detector.getFocusY();
        this.mosaicView.r(1.0f, getScaleX() * this.baseScale, 3.0f);
        return false;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        this.lastX = detector.getFocusX();
        this.lastY = detector.getFocusY();
        return true;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        this.lastX = 0.0f;
        this.lastY = 0.0f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        w53.b.a("MosaicLayout", "onSizeChanged... w:" + w3 + " h:" + h16 + " oldw:" + oldw + " oldh:" + oldh);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        boolean z16;
        Intrinsics.checkNotNull(event);
        int actionMasked = event.getActionMasked();
        boolean z17 = false;
        if (actionMasked == 0) {
            this.gestureState = 1;
            boolean d16 = d(event);
            boolean e16 = e(event);
            if (!d16 && !e16) {
                return false;
            }
            return true;
        }
        if (this.gestureState == 1) {
            MotionEvent cancel = MotionEvent.obtain(event);
            cancel.setAction(3);
            if (event.getEventTime() - event.getDownTime() <= 100) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (actionMasked == 5 && z16) {
                this.gestureState = 3;
                Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
                d(cancel);
            } else if (!z16) {
                this.gestureState = 2;
                Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
                e(cancel);
            }
            cancel.recycle();
        }
        int i3 = this.gestureState;
        if (i3 == 3) {
            z17 = e(event);
        } else if (i3 == 2) {
            z17 = d(event);
        } else if (i3 == 1) {
            boolean d17 = d(event);
            boolean e17 = e(event);
            if (d17 || e17) {
                z17 = true;
            }
        }
        if (actionMasked == 1) {
            this.gestureState = 1;
        }
        return z17;
    }

    public final void setData(@Nullable a73.a viewModel, int index) {
        String str;
        ArrayList<MosaicData> N1;
        MosaicData mosaicData;
        ArrayList<MosaicData> N12;
        MosaicData mosaicData2;
        Matrix P1;
        if (viewModel == null || (str = viewModel.M1()) == null) {
            str = "";
        }
        this.path = str;
        CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList = null;
        this.showRect = viewModel != null ? viewModel.O1() : null;
        this.degree = (viewModel == null || (P1 = viewModel.P1()) == null) ? 0.0f : com.tencent.mobileqq.wink.editor.crop.a.b(P1);
        this.unDoPaintPath = (viewModel == null || (N12 = viewModel.N1()) == null || (mosaicData2 = N12.get(index)) == null) ? null : mosaicData2.getPathList();
        if (viewModel != null && (N1 = viewModel.N1()) != null && (mosaicData = N1.get(index)) != null) {
            copyOnWriteArrayList = mosaicData.getUndoPathList();
        }
        this.reDoPaintPath = copyOnWriteArrayList;
        w53.b.f("MosaicLayout", "setData... path:" + this.path + " rect:" + this.showRect + " degree:" + this.degree);
        g();
    }

    public final void setMosaicPaintUpdateCallback(@NotNull q83.a mosaicPaintUpdateCallback) {
        Intrinsics.checkNotNullParameter(mosaicPaintUpdateCallback, "mosaicPaintUpdateCallback");
        this.mosaicView.setMosaicPaintUpdateCallback(mosaicPaintUpdateCallback);
    }

    public final void setMosaicView(@NotNull PicMosaicView picMosaicView) {
        Intrinsics.checkNotNullParameter(picMosaicView, "<set-?>");
        this.mosaicView = picMosaicView;
    }

    public final void setData(@NotNull String path, @Nullable RectF rectF, float degree, @Nullable CopyOnWriteArrayList<MosaicLinePath> unDoPaintPath, @Nullable CopyOnWriteArrayList<MosaicLinePath> reDoPaintPath) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.showRect = rectF;
        this.degree = degree;
        this.unDoPaintPath = unDoPaintPath;
        this.reDoPaintPath = reDoPaintPath;
        w53.b.f("MosaicLayout", "setData... path:" + path + " rect:" + rectF + " degree:" + degree);
        g();
    }

    public final void setData(@NotNull Bitmap bitmap, @Nullable RectF rectF, float degree, @Nullable CopyOnWriteArrayList<MosaicLinePath> unDoPaintPath, @Nullable CopyOnWriteArrayList<MosaicLinePath> reDoPaintPath) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.showRect = rectF;
        this.degree = degree;
        this.unDoPaintPath = unDoPaintPath;
        this.reDoPaintPath = reDoPaintPath;
        w53.b.f("MosaicLayout", "setData... path:" + this.path + " rect:" + rectF + " degree:" + degree);
        this.originBitmap = bitmap;
        i();
    }
}
