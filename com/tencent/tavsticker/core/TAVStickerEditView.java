package com.tencent.tavsticker.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerEditViewEventType;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerMoveLimit;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.RectUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerEditView extends FrameLayout implements ITAVStickerRenderer {
    public static final String TAG = "TAVStickerEditView";
    private Paint borderPaint;
    protected float centerX;
    protected float centerY;
    private Region clipRegion;
    private Context context;
    private PointF convertPoint;
    protected float correctedOriginalCenterX;
    protected float correctedOriginalCenterY;
    protected int eventType;
    private boolean isDrawMovieLimitRect;
    protected boolean isFirstDraw;
    protected boolean isNeedInitLocation;
    private boolean isShowDefaultBorder;
    protected TAVStickerMode mode;
    protected int moveRegionHeight;
    protected int moveRegionWidth;
    protected int moveStartOffsetX;
    protected int moveStartOffsetY;
    private Paint movieRectPaint;
    protected float originalCenterX;
    protected float originalCenterY;
    private PointF[] originalVertexPoints;
    protected PAGView pagView;
    private Path path;
    protected float positionX;
    protected float positionY;
    private RectF rectF;
    private Region region;
    protected float rotate;
    protected float scale;
    protected float scaleMax;
    protected float scaleMin;
    protected RectF singleZoomRotateRect;
    protected TAVSticker sticker;
    protected int stickerContainerHeight;
    protected int stickerContainerWidth;
    protected ITAVStickerEventListener stickerEventListener;
    protected int stickerHeight;
    protected Rect stickerMoveLimitRect;
    private View.OnTouchListener stickerTouchListener;
    protected int stickerWidth;
    private List<View.OnTouchListener> touchListeners;
    protected PointF[] vertexPoints;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class TavStickerTouchListener implements View.OnTouchListener {
        private static final int CLICK_DURATION = 200;
        private static final int SINGLE_POINT = 1;
        private static final int TOUCH_SLOP = 16;
        private static final int TWO_POINT = 2;
        private int actionIndex;
        private PointF centerPoint;
        private PointF downPoint;
        private boolean isClickSticker;
        private boolean isTouchInSingleZoomRotateRect;
        private boolean isTouchInStickerRect;
        private float lastDownRotate;
        private float lastDownScale;
        private TAVStickerOperationMode operationMode;
        private float twoPointDownDistance;
        private float twoPointDownRotate;

        TavStickerTouchListener() {
            this.isTouchInStickerRect = false;
            this.isTouchInSingleZoomRotateRect = false;
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            this.downPoint = new PointF();
            this.centerPoint = new PointF();
            this.twoPointDownRotate = 0.0f;
            this.lastDownRotate = 0.0f;
            this.lastDownScale = 1.0f;
            this.twoPointDownDistance = 0.0f;
            this.isClickSticker = false;
            this.actionIndex = 0;
        }

        private boolean checkClickInterval(MotionEvent motionEvent) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() < 200) {
                return true;
            }
            return false;
        }

        private void handleActionDown(MotionEvent motionEvent) {
            TAVStickerEditView tAVStickerEditView = TAVStickerEditView.this;
            ITAVStickerEventListener iTAVStickerEventListener = tAVStickerEditView.stickerEventListener;
            if (iTAVStickerEventListener != null) {
                iTAVStickerEventListener.onTouchBegin(tAVStickerEditView.sticker, motionEvent);
            }
            this.downPoint.set(motionEvent.getX(), motionEvent.getY());
            TAVStickerEditView tAVStickerEditView2 = TAVStickerEditView.this;
            tAVStickerEditView2.positionX = tAVStickerEditView2.getPositionX();
            TAVStickerEditView tAVStickerEditView3 = TAVStickerEditView.this;
            tAVStickerEditView3.positionY = tAVStickerEditView3.getPositionY();
            TAVStickerEditView tAVStickerEditView4 = TAVStickerEditView.this;
            this.lastDownRotate = tAVStickerEditView4.rotate;
            this.lastDownScale = tAVStickerEditView4.scale;
            this.isClickSticker = true;
            if (this.isTouchInSingleZoomRotateRect) {
                this.operationMode = TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE;
                PointF[] pointFArr = tAVStickerEditView4.vertexPoints;
                PointF middlePoint = TAVStickerUtil.getMiddlePoint(pointFArr[0], pointFArr[2]);
                this.centerPoint = middlePoint;
                this.twoPointDownRotate = TAVStickerUtil.getRotation(middlePoint, this.downPoint);
                this.twoPointDownDistance = TAVStickerUtil.getDistance(this.centerPoint, this.downPoint);
            }
        }

        private void handleActionMove(MotionEvent motionEvent) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (2 == motionEvent.getPointerCount()) {
                if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(TAVStickerEditView.this.eventType)) {
                    TLog.d(TAVStickerEditView.TAG, "\u53cc\u6307\u7f29\u653e\u65cb\u8f6c");
                    this.operationMode = TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE;
                    onHandleScaleAndRotate(motionEvent.getX(1) - motionEvent.getX(0), motionEvent.getY(1) - motionEvent.getY(0));
                }
            } else if (1 == motionEvent.getPointerCount()) {
                if (Math.abs(x16 - this.downPoint.x) > 16.0f || Math.abs(y16 - this.downPoint.y) > 16.0f) {
                    this.isClickSticker = false;
                }
                if (this.operationMode == TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE) {
                    if (TAVStickerEditViewEventType.isHandleSingleZoomRotate(TAVStickerEditView.this.eventType)) {
                        TLog.d(TAVStickerEditView.TAG, "\u5355\u6307\u7f29\u653e\u65cb\u8f6c");
                        onHandleScaleAndRotate(this.centerPoint.x - motionEvent.getX(), this.centerPoint.y - motionEvent.getY());
                    }
                } else if (TAVStickerEditViewEventType.isHandleDrag(TAVStickerEditView.this.eventType)) {
                    String str = TAVStickerEditView.TAG;
                    TLog.d(str, "\u5355\u6307\u79fb\u52a8");
                    if (!this.isClickSticker) {
                        this.operationMode = TAVStickerOperationMode.OP_DRAG;
                    }
                    TAVStickerEditView tAVStickerEditView = TAVStickerEditView.this;
                    float f16 = tAVStickerEditView.positionX + x16;
                    PointF pointF = this.downPoint;
                    float f17 = f16 - pointF.x;
                    float f18 = (tAVStickerEditView.positionY + y16) - pointF.y;
                    PointF positionInterceptor = tAVStickerEditView.positionInterceptor(f17, f18);
                    TLog.d(str, "handleActionMove -> curPositionX : " + f17 + ", realX : " + positionInterceptor.x + ", curPositionY : " + f18 + ", realY : " + positionInterceptor.y);
                    TAVStickerEditView.this.setPosition(positionInterceptor.x, positionInterceptor.y);
                }
            }
            TAVStickerOperationMode tAVStickerOperationMode = this.operationMode;
            if (tAVStickerOperationMode != TAVStickerOperationMode.OP_NONE) {
                TAVStickerEditView.this.adjustLocation(tAVStickerOperationMode);
            }
        }

        private void handleActionPointerDown(MotionEvent motionEvent) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            PointF[] pointFArr = TAVStickerEditView.this.vertexPoints;
            this.centerPoint = TAVStickerUtil.getMiddlePoint(pointFArr[0], pointFArr[2]);
            this.twoPointDownRotate = TAVStickerUtil.getRotation(motionEvent);
            this.twoPointDownDistance = TAVStickerUtil.getDistance(new PointF(motionEvent.getX(this.actionIndex), motionEvent.getY(this.actionIndex)), this.downPoint);
        }

        private void handleActionPointerUp(MotionEvent motionEvent) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            TAVStickerEditView tAVStickerEditView = TAVStickerEditView.this;
            tAVStickerEditView.positionX = tAVStickerEditView.getPositionX();
            TAVStickerEditView tAVStickerEditView2 = TAVStickerEditView.this;
            tAVStickerEditView2.positionY = tAVStickerEditView2.getPositionY();
            TAVStickerEditView tAVStickerEditView3 = TAVStickerEditView.this;
            this.lastDownRotate = tAVStickerEditView3.rotate;
            this.lastDownScale = tAVStickerEditView3.scale;
            if (motionEvent.getPointerId(this.actionIndex) == 0) {
                this.downPoint.set(motionEvent.getX(1), motionEvent.getY(1));
            } else if (1 == motionEvent.getPointerId(this.actionIndex)) {
                this.downPoint.set(motionEvent.getX(0), motionEvent.getY(0));
            }
        }

        private void handleActionUp(MotionEvent motionEvent) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            if (TAVStickerEditView.this.stickerEventListener != null && checkClickInterval(motionEvent) && this.isClickSticker && TAVStickerEditViewEventType.isHandleClick(TAVStickerEditView.this.eventType)) {
                TAVStickerEditView tAVStickerEditView = TAVStickerEditView.this;
                tAVStickerEditView.stickerEventListener.onStickerClick(tAVStickerEditView.sticker, motionEvent);
            }
            TAVStickerEditView tAVStickerEditView2 = TAVStickerEditView.this;
            ITAVStickerEventListener iTAVStickerEventListener = tAVStickerEditView2.stickerEventListener;
            if (iTAVStickerEventListener != null) {
                iTAVStickerEventListener.onTouchEnd(tAVStickerEditView2.sticker, motionEvent);
            }
        }

        private float handleScaleLimit(float f16) {
            TAVStickerEditView tAVStickerEditView = TAVStickerEditView.this;
            float f17 = tAVStickerEditView.scaleMin;
            if (f17 > 0.0f && f16 < f17) {
                f16 = f17;
            }
            float f18 = tAVStickerEditView.scaleMax;
            if (f18 > 0.0f && f16 > f18) {
                return f18;
            }
            return f16;
        }

        private void isTouchInSticker(MotionEvent motionEvent) {
            boolean z16 = true;
            if ((motionEvent.getAction() & 255) == 0 || 1 == (motionEvent.getAction() & 255)) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                PointF[] pointFArr = TAVStickerEditView.this.vertexPoints;
                this.isTouchInStickerRect = TAVStickerUtil.inQuadrangle(pointFArr[0], pointFArr[1], pointFArr[2], pointFArr[3], new PointF(x16, y16));
                RectF rectF = TAVStickerEditView.this.singleZoomRotateRect;
                if (rectF == null || !rectF.contains(x16, y16)) {
                    z16 = false;
                }
                this.isTouchInSingleZoomRotateRect = z16;
            }
        }

        private void onHandleScaleAndRotate(float f16, float f17) {
            this.isClickSticker = false;
            float rotation = (TAVStickerUtil.getRotation(f16, f17) - this.twoPointDownRotate) + this.lastDownRotate;
            if (rotation < 0.0f) {
                rotation += 360.0f;
            } else if (rotation > 360.0f) {
                rotation -= 360.0f;
            }
            float rotateInterceptor = TAVStickerEditView.this.rotateInterceptor(rotation);
            String str = TAVStickerEditView.TAG;
            TLog.d(str, "onHandleScaleAndRotate -> rotation : " + rotation + ", displayRotation : " + rotateInterceptor);
            TAVStickerEditView.this.setRotate(rotateInterceptor);
            if (this.twoPointDownDistance > 0.0f) {
                float handleScaleLimit = handleScaleLimit(this.lastDownScale * (((float) Math.sqrt((f16 * f16) + (f17 * f17))) / this.twoPointDownDistance));
                float scaleInterceptor = TAVStickerEditView.this.scaleInterceptor(handleScaleLimit);
                TLog.d(str, "onHandleScaleAndRotate -> curScale : " + handleScaleLimit + ", displayScale : " + scaleInterceptor);
                TAVStickerEditView.this.setScale(scaleInterceptor);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.actionIndex = motionEvent.getActionIndex();
            if (TAVStickerEditView.this.sticker.isEditable() && TAVStickerEditView.this.eventType != 0) {
                isTouchInSticker(motionEvent);
                TAVStickerEditView.this.bringToFront();
                TAVStickerEditView.this.setMode(TAVStickerMode.ACTIVE);
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 5) {
                                if (action == 6) {
                                    handleActionPointerUp(motionEvent);
                                }
                            } else {
                                handleActionPointerDown(motionEvent);
                            }
                        } else {
                            handleActionMove(motionEvent);
                        }
                    } else {
                        handleActionUp(motionEvent);
                    }
                } else {
                    handleActionDown(motionEvent);
                }
                return true;
            }
            return false;
        }
    }

    public TAVStickerEditView(@NonNull Context context, @NonNull TAVSticker tAVSticker) {
        super(context);
        this.context = null;
        this.sticker = null;
        this.pagView = null;
        this.mode = TAVStickerMode.DEFAULT;
        this.isShowDefaultBorder = true;
        this.moveStartOffsetX = 0;
        this.moveStartOffsetY = 0;
        this.moveRegionWidth = 0;
        this.moveRegionHeight = 0;
        this.stickerContainerWidth = 0;
        this.stickerContainerHeight = 0;
        this.stickerWidth = 0;
        this.stickerHeight = 0;
        this.borderPaint = null;
        this.movieRectPaint = null;
        this.isDrawMovieLimitRect = false;
        this.stickerTouchListener = null;
        this.touchListeners = new ArrayList();
        this.stickerEventListener = null;
        this.convertPoint = new PointF();
        this.vertexPoints = new PointF[]{new PointF(), new PointF(), new PointF(), new PointF()};
        this.originalVertexPoints = new PointF[]{new PointF(), new PointF(), new PointF(), new PointF()};
        this.singleZoomRotateRect = null;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.originalCenterX = 0.0f;
        this.originalCenterY = 0.0f;
        this.correctedOriginalCenterX = 0.0f;
        this.correctedOriginalCenterY = 0.0f;
        this.eventType = 15;
        this.stickerMoveLimitRect = null;
        this.scale = 1.0f;
        this.scaleMax = 0.0f;
        this.scaleMin = 0.0f;
        this.rotate = 0.0f;
        this.positionX = 0.0f;
        this.positionY = 0.0f;
        this.isFirstDraw = true;
        this.isNeedInitLocation = true;
        this.path = new Path();
        this.rectF = new RectF();
        this.region = new Region();
        this.clipRegion = new Region();
        if (context != null && tAVSticker != null) {
            this.context = context;
            this.sticker = tAVSticker;
            init();
            return;
        }
        throw new IllegalArgumentException("<init> can not initialization TAVStickerEditView, parameter 'context' and 'sticker' must not is null!");
    }

    private PointF convertCoordinate(float f16, float f17) {
        PAGView pAGView;
        if (this.convertPoint == null) {
            this.convertPoint = new PointF();
        }
        int width = getWidth();
        int height = getHeight();
        float f18 = width;
        float f19 = height;
        float f26 = f16 + ((f18 / 2.0f) - this.correctedOriginalCenterX);
        float f27 = f17 + ((f19 / 2.0f) - this.correctedOriginalCenterY);
        if (width > 0 && height > 0 && (pAGView = this.pagView) != null) {
            this.convertPoint.set(((f26 - (this.centerX - this.originalCenterX)) / f18) * pAGView.getWidth(), ((f27 - (this.centerY - this.originalCenterY)) / f19) * this.pagView.getHeight());
            return this.convertPoint;
        }
        this.convertPoint.set(f26, f27);
        return this.convertPoint;
    }

    private void init() {
        initStickerData();
        initPaint();
        initPagView();
        if (getLayoutParams() == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        setWillNotDraw(false);
        this.sticker.registerRenderer(this);
        TavStickerTouchListener tavStickerTouchListener = new TavStickerTouchListener();
        this.stickerTouchListener = tavStickerTouchListener;
        addOnTouchListener(tavStickerTouchListener);
    }

    private void initLocationData() {
        this.vertexPoints[0].set(this.positionX, this.positionY);
        this.vertexPoints[1].set(this.positionX + this.stickerWidth, this.positionY);
        this.vertexPoints[2].set(this.positionX + this.stickerWidth, this.positionY + this.stickerHeight);
        this.vertexPoints[3].set(this.positionX, this.positionY + this.stickerHeight);
        PointF[] pointFArr = this.originalVertexPoints;
        PointF[] pointFArr2 = this.vertexPoints;
        pointFArr[0] = pointFArr2[0];
        pointFArr[1] = pointFArr2[1];
        pointFArr[2] = pointFArr2[2];
        pointFArr[3] = pointFArr2[3];
        this.centerX = TAVStickerUtil.getMiddlePoint(pointFArr2[0], pointFArr2[2]).x;
        PointF[] pointFArr3 = this.vertexPoints;
        float f16 = TAVStickerUtil.getMiddlePoint(pointFArr3[0], pointFArr3[2]).y;
        this.centerY = f16;
        this.originalCenterX = this.centerX;
        this.originalCenterY = f16;
    }

    private void initMoveRectPaint() {
        Paint paint = new Paint();
        this.movieRectPaint = paint;
        paint.setAntiAlias(true);
        this.movieRectPaint.setStrokeWidth(this.sticker.getStrokeWidth());
        this.movieRectPaint.setColor(SupportMenu.CATEGORY_MASK);
        this.movieRectPaint.setStyle(Paint.Style.STROKE);
    }

    private void initPagView() {
        PAGView pAGView = new PAGView(this.context);
        this.pagView = pAGView;
        addView(pAGView);
        PAGFile pagFile = this.sticker.getPagFile();
        if (pagFile != null) {
            TLog.d(TAG, "initPagView -> pagFile.width() : " + pagFile.width() + ", pagFile.height() : " + pagFile.height());
            this.pagView.setFile(pagFile);
        }
        if (this.sticker.isAutoPlay()) {
            play(0);
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth(this.sticker.getStrokeWidth());
        this.borderPaint.setColor(this.sticker.getStrokeColor());
    }

    private boolean isTouchInStickerEditView(int i3, int i16) {
        this.path.reset();
        Path path = this.path;
        PointF pointF = this.vertexPoints[0];
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.path;
        PointF pointF2 = this.vertexPoints[1];
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.path;
        PointF pointF3 = this.vertexPoints[2];
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.path;
        PointF pointF4 = this.vertexPoints[3];
        path4.lineTo(pointF4.x, pointF4.y);
        Path path5 = this.path;
        PointF pointF5 = this.vertexPoints[0];
        path5.lineTo(pointF5.x, pointF5.y);
        this.path.computeBounds(this.rectF, true);
        Region region = this.clipRegion;
        RectF rectF = this.rectF;
        region.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        this.region.setPath(this.path, this.clipRegion);
        boolean contains = this.region.contains(i3, i16);
        TLog.d(TAG, "isTouchInStickerEditView -> contains : " + contains);
        return contains;
    }

    public void addOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            return;
        }
        this.touchListeners.add(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustLocation(TAVStickerOperationMode tAVStickerOperationMode) {
        float f16;
        updateVertexPoints();
        PointF[] pointFArr = this.vertexPoints;
        this.centerX = TAVStickerUtil.getMiddlePoint(pointFArr[0], pointFArr[2]).x;
        PointF[] pointFArr2 = this.vertexPoints;
        this.centerY = TAVStickerUtil.getMiddlePoint(pointFArr2[0], pointFArr2[2]).y;
        handleMoveLimit();
        int i3 = this.stickerContainerWidth;
        float f17 = 0.5f;
        if (i3 != 0) {
            f16 = this.centerX / i3;
        } else {
            f16 = 0.5f;
        }
        int i16 = this.stickerContainerHeight;
        if (i16 != 0) {
            f17 = this.centerY / i16;
        }
        updateStickerOnAdjustLocation(f16, f17);
        ITAVStickerEventListener iTAVStickerEventListener = this.stickerEventListener;
        if (iTAVStickerEventListener != null) {
            iTAVStickerEventListener.onDataChanged(this.sticker, tAVStickerOperationMode, this.centerX, this.centerY, this.scale, this.rotate);
        }
    }

    public long duration() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.duration() / 1000;
        }
        return 0L;
    }

    public boolean flush(boolean z16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.flush(z16);
        }
        return false;
    }

    public TAVStickerMode getMode() {
        return this.mode;
    }

    public PointF[] getOriginalVertexPoints() {
        return this.originalVertexPoints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getPositionX() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.getTranslationX();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getPositionY() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.getTranslationY();
        }
        return 0.0f;
    }

    public double getProgress() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.getProgress();
        }
        return 0.0d;
    }

    public TAVSticker getSticker() {
        return this.sticker;
    }

    protected View.OnTouchListener getStickerTouchListener() {
        return this.stickerTouchListener;
    }

    public void getUnderPointLayerItems(int i3, int i16, ITAVTouchStickerLayerListener iTAVTouchStickerLayerListener) {
        ArrayList arrayList;
        TAVStickerSolidItem tavStickerSolidItem;
        if (iTAVTouchStickerLayerListener == null || this.pagView == null) {
            return;
        }
        if (isTouchInStickerEditView(i3, i16)) {
            arrayList = new ArrayList();
            PointF convertCoordinate = convertCoordinate(i3, i16);
            PAGLayer[] layersUnderPoint = this.pagView.getLayersUnderPoint(convertCoordinate.x, convertCoordinate.y);
            if (layersUnderPoint != null && layersUnderPoint.length > 0) {
                for (PAGLayer pAGLayer : layersUnderPoint) {
                    if (pAGLayer != null) {
                        int editableIndex = pAGLayer.editableIndex();
                        if (3 == pAGLayer.layerType()) {
                            TAVStickerTextItem tavStickerTextItem = this.sticker.getTavStickerTextItem(editableIndex);
                            if (tavStickerTextItem != null) {
                                arrayList.add(tavStickerTextItem);
                            }
                        } else if (5 == pAGLayer.layerType()) {
                            TAVStickerImageItem tavStickerImageItem = this.sticker.getTavStickerImageItem(editableIndex);
                            if (tavStickerImageItem != null) {
                                arrayList.add(tavStickerImageItem);
                            }
                        } else if (2 == pAGLayer.layerType() && (tavStickerSolidItem = this.sticker.getTavStickerSolidItem(editableIndex)) != null) {
                            arrayList.add(tavStickerSolidItem);
                        }
                    }
                }
            } else {
                return;
            }
        } else {
            arrayList = null;
        }
        iTAVTouchStickerLayerListener.onTouchSticker(this.sticker, arrayList);
    }

    protected void handleMoveLimit() {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26 = this.centerX;
        float f27 = this.centerY;
        if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit()) {
            PointF[] pointFArr = this.vertexPoints;
            float minXBy4Point = TAVStickerUtil.getMinXBy4Point(pointFArr[0], pointFArr[1], pointFArr[2], pointFArr[3]);
            PointF[] pointFArr2 = this.vertexPoints;
            float maxXBy4Point = TAVStickerUtil.getMaxXBy4Point(pointFArr2[0], pointFArr2[1], pointFArr2[2], pointFArr2[3]);
            PointF[] pointFArr3 = this.vertexPoints;
            float minYBy4Point = TAVStickerUtil.getMinYBy4Point(pointFArr3[0], pointFArr3[1], pointFArr3[2], pointFArr3[3]);
            PointF[] pointFArr4 = this.vertexPoints;
            float maxYBy4Point = TAVStickerUtil.getMaxYBy4Point(pointFArr4[0], pointFArr4[1], pointFArr4[2], pointFArr4[3]);
            int i3 = this.moveStartOffsetX;
            if (minXBy4Point < i3) {
                f19 = i3 - minXBy4Point;
                f26 += f19;
            } else {
                f19 = 0.0f;
            }
            int i16 = this.moveRegionWidth;
            if (maxXBy4Point > i16 + i3) {
                f19 = (i16 + i3) - maxXBy4Point;
                f26 += f19;
            }
            int i17 = this.moveStartOffsetY;
            if (minYBy4Point < i17) {
                f18 = i17 - minYBy4Point;
                f27 += f18;
            } else {
                f18 = 0.0f;
            }
            int i18 = this.moveRegionHeight;
            if (maxYBy4Point > i18 + i17) {
                f18 = (i18 + i17) - maxYBy4Point;
                f27 += f18;
            }
            if (minXBy4Point < i3 && maxXBy4Point > i16 + i3) {
                f26 += 0.0f;
                f19 = 0.0f;
            }
            if (minYBy4Point < i17 && maxYBy4Point > i18 + i17) {
                f27 += 0.0f;
                f18 = 0.0f;
            }
        } else {
            int i19 = this.moveStartOffsetX;
            if (f26 < i19) {
                f16 = i19 - f26;
                f26 = i19 + 0;
            } else {
                f16 = 0.0f;
            }
            int i26 = this.moveRegionWidth;
            if (f26 > i26 + i19) {
                f16 = (i26 + i19) - f26;
                f26 = i26 + i19;
            }
            int i27 = this.moveStartOffsetY;
            if (f27 < i27) {
                f17 = i27 - f27;
                f27 = i27 + 0;
            } else {
                f17 = 0.0f;
            }
            int i28 = this.moveRegionHeight;
            if (f27 > i28 + i27) {
                f17 = (i28 + i27) - f27;
                f27 = i28 + i27;
            }
            f18 = f17;
            if (f26 < i19 && f26 > i26 + i19) {
                f26 += 0.0f;
                f16 = 0.0f;
            }
            if (f27 < i27 && f27 > i28 + i27) {
                f27 += 0.0f;
                f19 = f16;
                f18 = 0.0f;
            } else {
                f19 = f16;
            }
        }
        this.centerX = f26;
        this.centerY = f27;
        if (Math.abs(f19) > 0.0f || Math.abs(f18) > 0.0f) {
            setPosition(getPositionX() + f19, getPositionY() + f18);
            updateVertexPoints();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean handleTouchEvent(View view, MotionEvent motionEvent) {
        for (int size = this.touchListeners.size() - 1; size >= 0; size--) {
            View.OnTouchListener onTouchListener = this.touchListeners.get(size);
            if (onTouchListener != null && onTouchListener.onTouch(view, motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void initLocation(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams;
        this.isNeedInitLocation = false;
        this.stickerContainerWidth = i3;
        this.stickerContainerHeight = i16;
        updateStickerMoveRect();
        RectF stickerRect = TAVStickerUtil.getStickerRect(this.sticker, i3, i16, 1.0f);
        if (stickerRect != null) {
            this.stickerWidth = (int) RectUtil.getRectWidth(stickerRect);
            this.stickerHeight = (int) RectUtil.getRectHeight(stickerRect);
            this.positionX = (int) stickerRect.left;
            this.positionY = (int) stickerRect.top;
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null && (layoutParams = pAGView.getLayoutParams()) != null) {
            layoutParams.width = this.stickerWidth;
            layoutParams.height = this.stickerHeight;
            this.pagView.setLayoutParams(layoutParams);
        }
        initLocationData();
        initScaleData();
        setPosition(this.positionX, this.positionY);
        setScale(this.scale);
        setRotate(this.rotate);
        updateVertexPoints();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initScaleData() {
        float maxScale = this.sticker.getMaxScale();
        this.scaleMax = maxScale;
        if (maxScale < 0.0f && this.sticker.getWidth() > 0 && this.sticker.getHeight() > 0) {
            this.scaleMax = (Math.max(this.moveRegionWidth, this.moveRegionHeight) * 1.0f) / Math.min(this.sticker.getWidth(), this.sticker.getHeight());
        }
        if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit()) {
            float min = Math.min(this.moveRegionWidth, this.moveRegionHeight);
            PointF[] pointFArr = this.vertexPoints;
            float distance = TAVStickerUtil.getDistance(pointFArr[0], pointFArr[2]);
            if (distance > 0.0f) {
                this.scaleMax = Math.min(min / distance, this.scaleMax);
            }
        }
        float minScale = this.sticker.getMinScale();
        this.scaleMin = minScale;
        if (minScale < 0.0f) {
            this.scaleMin = 0.0f;
        }
        float f16 = this.scaleMin;
        if (f16 > 0.0f) {
            float f17 = this.scaleMax;
            if (f17 > 0.0f) {
                if (this.scale < f16) {
                    this.scale = f16;
                }
                if (this.scale > f17) {
                    this.scale = f17;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initStickerData() {
        this.isShowDefaultBorder = this.sticker.isShowDefaultBorder();
        float scale = this.sticker.getScale();
        this.scale = scale;
        if (scale <= 0.0f) {
            this.scale = 1.0f;
            this.sticker.setScale(1.0f);
        }
        this.rotate = this.sticker.getRotate();
    }

    public boolean isNeedInitLocation() {
        return this.isNeedInitLocation;
    }

    public boolean isPlaying() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.isPlaying();
        }
        return false;
    }

    public float maxFrameRate() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.maxFrameRate();
            return 0.0f;
        }
        return 0.0f;
    }

    public void needInitLocation() {
        this.isNeedInitLocation = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isFirstDraw) {
            this.isFirstDraw = false;
            adjustLocation(TAVStickerOperationMode.OP_NONE);
            this.correctedOriginalCenterX = this.centerX;
            this.correctedOriginalCenterY = this.centerY;
        }
        if (this.isShowDefaultBorder && TAVStickerMode.ACTIVE == this.mode) {
            PointF[] pointFArr = this.vertexPoints;
            PointF pointF = pointFArr[0];
            float f16 = pointF.x;
            float f17 = pointF.y;
            PointF pointF2 = pointFArr[1];
            canvas.drawLine(f16, f17, pointF2.x, pointF2.y, this.borderPaint);
            PointF[] pointFArr2 = this.vertexPoints;
            PointF pointF3 = pointFArr2[1];
            float f18 = pointF3.x;
            float f19 = pointF3.y;
            PointF pointF4 = pointFArr2[2];
            canvas.drawLine(f18, f19, pointF4.x, pointF4.y, this.borderPaint);
            PointF[] pointFArr3 = this.vertexPoints;
            PointF pointF5 = pointFArr3[2];
            float f26 = pointF5.x;
            float f27 = pointF5.y;
            PointF pointF6 = pointFArr3[3];
            canvas.drawLine(f26, f27, pointF6.x, pointF6.y, this.borderPaint);
            PointF[] pointFArr4 = this.vertexPoints;
            PointF pointF7 = pointFArr4[3];
            float f28 = pointF7.x;
            float f29 = pointF7.y;
            PointF pointF8 = pointFArr4[0];
            canvas.drawLine(f28, f29, pointF8.x, pointF8.y, this.borderPaint);
        }
        if (this.isDrawMovieLimitRect && RectUtil.rectIsValid(this.stickerMoveLimitRect)) {
            if (this.movieRectPaint == null) {
                initMoveRectPaint();
            }
            canvas.drawRect(this.stickerMoveLimitRect, this.movieRectPaint);
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    }

    public void play(int i3) {
        TLog.d(TAG, "play -> repeatCount : " + i3);
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRepeatCount(i3);
            if (!this.pagView.isPlaying()) {
                this.pagView.play();
            }
        }
    }

    @NonNull
    protected PointF positionInterceptor(float f16, float f17) {
        return new PointF(f16, f17);
    }

    public void removeOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            return;
        }
        for (View.OnTouchListener onTouchListener2 : new ArrayList(this.touchListeners)) {
            if (onTouchListener2 != null && onTouchListener2 == onTouchListener) {
                this.touchListeners.remove(onTouchListener);
            }
        }
    }

    public void setDrawMovieLimitRect(boolean z16) {
        this.isDrawMovieLimitRect = z16;
        postInvalidate();
    }

    public void setEventType(int i3) {
        this.eventType = i3;
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerRenderer
    public void setImageData(int i3, PAGImage pAGImage) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.replaceImage(i3, pAGImage);
        }
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerRenderer
    public void setLayerColor(String str, int i3) {
        PAGLayer[] layersByName;
        PAGView pAGView = this.pagView;
        if (pAGView == null || (layersByName = ((PAGFile) pAGView.getComposition()).getLayersByName(str)) == null) {
            return;
        }
        for (PAGLayer pAGLayer : layersByName) {
            if (pAGLayer instanceof PAGSolidLayer) {
                ((PAGSolidLayer) pAGLayer).setSolidColor(i3);
            }
        }
    }

    public void setMaxFrameRate(float f16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setMaxFrameRate(f16);
        }
    }

    public void setMode(TAVStickerMode tAVStickerMode) {
        this.mode = tAVStickerMode;
        postInvalidate();
    }

    public void setOnStickerEventListener(ITAVStickerEventListener iTAVStickerEventListener) {
        this.stickerEventListener = iTAVStickerEventListener;
    }

    @Override // android.view.View
    @Deprecated
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        addOnTouchListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPosition(float f16, float f17) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setTranslationX(f16);
            this.pagView.setTranslationY(f17);
        }
    }

    public void setProgress(double d16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setProgress(d16);
        }
    }

    protected void setRotate(float f16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRotation(f16);
        }
        this.rotate = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setScale(float f16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setScaleX(f16);
            this.pagView.setScaleY(f16);
        }
        this.scale = f16;
    }

    public void setSingleZoomRotateRect(RectF rectF) {
        this.singleZoomRotateRect = rectF;
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerRenderer
    public void setTextData(int i3, PAGText pAGText) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setTextData(i3, pAGText);
        }
    }

    public void stop() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    public void updateStickerMoveRect() {
        Rect stickerMoveLimitRect = RectUtil.getStickerMoveLimitRect(this.sticker.getMoveRect(), this.stickerContainerWidth, this.stickerContainerHeight);
        this.stickerMoveLimitRect = stickerMoveLimitRect;
        if (RectUtil.rectIsValid(stickerMoveLimitRect)) {
            Rect rect = this.stickerMoveLimitRect;
            this.moveStartOffsetX = rect.left;
            this.moveStartOffsetY = rect.top;
            this.moveRegionWidth = RectUtil.getRectWidth(rect);
            this.moveRegionHeight = RectUtil.getRectHeight(this.stickerMoveLimitRect);
            return;
        }
        this.moveStartOffsetX = 0;
        this.moveStartOffsetY = 0;
        this.moveRegionWidth = this.stickerContainerWidth;
        this.moveRegionHeight = this.stickerContainerHeight;
    }

    protected void updateStickerOnAdjustLocation(float f16, float f17) {
        this.sticker.setCenterX(f16).setCenterY(f17).setScale(this.scale).setRotate(this.rotate);
    }

    protected void updateVertexPoints() {
        PointF[] computeRectanglePoints = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
        PointF[] pointFArr = this.vertexPoints;
        pointFArr[0] = computeRectanglePoints[0];
        pointFArr[1] = computeRectanglePoints[1];
        pointFArr[2] = computeRectanglePoints[2];
        pointFArr[3] = computeRectanglePoints[3];
    }

    public boolean flush() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.flush();
        }
        return false;
    }

    @FloatRange(from = 0.0d, to = GeometryConstants.LONGITUDE_SPAN)
    protected float rotateInterceptor(float f16) {
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float scaleInterceptor(float f16) {
        return f16;
    }
}
