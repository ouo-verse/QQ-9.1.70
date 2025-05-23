package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.qcircle.tavcut.constants.Constants;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerEditViewEventType;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class BlurStickerEditView extends WsStickerEditView implements WSOverLayBlurManager.SourceImageObserver {
    private static final String TAG = "BlurStickerEditView";
    private volatile Bitmap bgBitmap;
    private Paint blurBgPaint;
    private Paint blurTextPaint;
    private CIImage curCIImage;
    private GaosiBlurFilter hBlurFilter;
    CountDownLatch latch;
    ReentrantLock lock;
    private Handler playerThreadHandler;
    private ScaleTextureFilter scaleBigTextureFilter;
    private ScaleTextureFilter scaleSmallTextureFilter;
    private String textPngPath;
    private HashMap<String, TextureInfo> textureMap;
    private String texturePngPath;
    private GaosiBlurFilter vBlurFilter;
    private float xScale;
    private float xScaleMax;
    private float xScaleMin;
    private float yScale;
    private float yScaleMax;
    private float yScaleMin;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class TavStickerTouchListener implements View.OnTouchListener {
        private static final int CLICK_DURATION = 200;
        private static final int SINGLE_POINT = 1;
        private static final int TOUCH_SLOP = 16;
        private static final int TWO_POINT = 2;
        private float lastDownScaleX = 1.0f;
        private float lastDownScaleY = 1.0f;
        private float twoPointDownDistance = 0.0f;
        private float xDistanceOnDown = 0.0f;
        private float yDistanceOnDown = 0.0f;
        private boolean isTouchInStickerRect = false;
        private boolean isTouchInSingleZoomRotateRect = false;
        private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
        private PointF downPoint = new PointF();
        private PointF centerPoint = new PointF();
        private float twoPointDownRotate = 0.0f;
        private float lastDownRotate = 0.0f;
        private float lastDownScale = 1.0f;
        private boolean isClickSticker = false;
        private int actionIndex = 0;
        private boolean isClickDelete = false;

        protected TavStickerTouchListener() {
        }

        private boolean checkClickInterval(MotionEvent motionEvent) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() < 200) {
                return true;
            }
            return false;
        }

        private void handleActionDown(MotionEvent motionEvent) {
            this.downPoint.set(motionEvent.getX(), motionEvent.getY());
            if (BlurStickerEditView.this.isTouchDeleteBtn((int) motionEvent.getX(), (int) motionEvent.getY()) && StickerDrawingOperationMask.isDrawLeftTop(((WsStickerEditView) BlurStickerEditView.this).drawMask)) {
                this.isClickDelete = true;
                this.isClickSticker = true;
                return;
            }
            BlurStickerEditView blurStickerEditView = BlurStickerEditView.this;
            ((TAVStickerEditView) blurStickerEditView).positionX = blurStickerEditView.getPositionX();
            BlurStickerEditView blurStickerEditView2 = BlurStickerEditView.this;
            ((TAVStickerEditView) blurStickerEditView2).positionY = blurStickerEditView2.getPositionY();
            this.lastDownRotate = ((TAVStickerEditView) BlurStickerEditView.this).rotate;
            if (TAVStickerExKt.isLockRatio(((TAVStickerEditView) BlurStickerEditView.this).sticker)) {
                this.lastDownScale = ((TAVStickerEditView) BlurStickerEditView.this).scale;
            } else {
                this.lastDownScaleX = BlurStickerEditView.this.xScale;
                this.lastDownScaleY = BlurStickerEditView.this.yScale;
            }
            this.lastDownScale = ((TAVStickerEditView) BlurStickerEditView.this).scale;
            this.isClickSticker = true;
            if (this.isTouchInSingleZoomRotateRect) {
                this.operationMode = TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE;
                PointF middlePoint = TAVStickerUtil.getMiddlePoint(((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[0], ((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[2]);
                this.centerPoint = middlePoint;
                this.twoPointDownRotate = TAVStickerUtil.getRotation(middlePoint, this.downPoint);
                this.twoPointDownDistance = TAVStickerUtil.getDistance(this.centerPoint, this.downPoint);
                this.xDistanceOnDown = Math.abs(this.downPoint.x - this.centerPoint.x);
                this.yDistanceOnDown = Math.abs(this.downPoint.y - this.centerPoint.y);
            }
        }

        private void handleActionMove(MotionEvent motionEvent) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (Math.abs(x16 - this.downPoint.x) > 16.0f || Math.abs(y16 - this.downPoint.y) > 16.0f) {
                this.isClickDelete = false;
            }
            if (2 == motionEvent.getPointerCount()) {
                if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(((TAVStickerEditView) BlurStickerEditView.this).eventType)) {
                    TLog.d(BlurStickerEditView.TAG, "\u53cc\u6307\u7f29\u653e\u65cb\u8f6c");
                    this.operationMode = TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE;
                    onHandleScaleAndRotate(motionEvent.getX(1) - motionEvent.getX(0), motionEvent.getY(1) - motionEvent.getY(0));
                }
            } else if (1 == motionEvent.getPointerCount()) {
                if (Math.abs(x16 - this.downPoint.x) > 16.0f || Math.abs(y16 - this.downPoint.y) > 16.0f) {
                    this.isClickSticker = false;
                }
                if (this.operationMode == TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE) {
                    if (TAVStickerEditViewEventType.isHandleSingleZoomRotate(((TAVStickerEditView) BlurStickerEditView.this).eventType)) {
                        TLog.d(BlurStickerEditView.TAG, "\u5355\u6307\u7f29\u653e\u65cb\u8f6c");
                        onHandleScaleAndRotate(this.centerPoint.x - motionEvent.getX(), this.centerPoint.y - motionEvent.getY());
                    }
                } else if (TAVStickerEditViewEventType.isHandleDrag(((TAVStickerEditView) BlurStickerEditView.this).eventType)) {
                    Log.d(BlurStickerEditView.TAG, "\u5355\u6307\u79fb\u52a8");
                    if (!this.isClickSticker) {
                        this.operationMode = TAVStickerOperationMode.OP_DRAG;
                    }
                    float f16 = (((TAVStickerEditView) BlurStickerEditView.this).positionX + x16) - this.downPoint.x;
                    float f17 = (((TAVStickerEditView) BlurStickerEditView.this).positionY + y16) - this.downPoint.y;
                    PointF positionInterceptor = BlurStickerEditView.this.positionInterceptor(f16, f17);
                    TLog.d(BlurStickerEditView.TAG, "handleActionMove -> curPositionX : " + f16 + ", realX : " + positionInterceptor.x + ", curPositionY : " + f17 + ", realY : " + positionInterceptor.y);
                    BlurStickerEditView.this.setPosition(positionInterceptor.x, positionInterceptor.y);
                }
            }
            TAVStickerOperationMode tAVStickerOperationMode = this.operationMode;
            if (tAVStickerOperationMode != TAVStickerOperationMode.OP_NONE) {
                BlurStickerEditView.this.adjustLocation(tAVStickerOperationMode);
            }
        }

        private void handleActionPointerDown(MotionEvent motionEvent) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            this.centerPoint = TAVStickerUtil.getMiddlePoint(((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[0], ((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[2]);
            this.twoPointDownRotate = TAVStickerUtil.getRotation(motionEvent);
            this.twoPointDownDistance = TAVStickerUtil.getDistance(new PointF(motionEvent.getX(this.actionIndex), motionEvent.getY(this.actionIndex)), this.downPoint);
        }

        private void handleActionPointerUp(MotionEvent motionEvent) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            BlurStickerEditView blurStickerEditView = BlurStickerEditView.this;
            ((TAVStickerEditView) blurStickerEditView).positionX = blurStickerEditView.getPositionX();
            BlurStickerEditView blurStickerEditView2 = BlurStickerEditView.this;
            ((TAVStickerEditView) blurStickerEditView2).positionY = blurStickerEditView2.getPositionY();
            this.lastDownRotate = ((TAVStickerEditView) BlurStickerEditView.this).rotate;
            this.lastDownScale = ((TAVStickerEditView) BlurStickerEditView.this).scale;
            this.lastDownScaleX = BlurStickerEditView.this.xScale;
            this.lastDownScaleY = BlurStickerEditView.this.yScale;
            if (motionEvent.getPointerId(this.actionIndex) == 0) {
                this.downPoint.set(motionEvent.getX(1), motionEvent.getY(1));
            } else if (1 == motionEvent.getPointerId(this.actionIndex)) {
                this.downPoint.set(motionEvent.getX(0), motionEvent.getY(0));
            }
        }

        private boolean handleActionUp(MotionEvent motionEvent) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
            if (this.isClickDelete) {
                if (((WsStickerEditView) BlurStickerEditView.this).stickerEditButtonClickListener != null) {
                    ((WsStickerEditView) BlurStickerEditView.this).stickerEditButtonClickListener.onDeleteClick(BlurStickerEditView.this.getSticker());
                    return true;
                }
                return true;
            }
            return false;
        }

        private float handleScaleLimit(float f16) {
            if (((TAVStickerEditView) BlurStickerEditView.this).scaleMin > 0.0f && f16 < ((TAVStickerEditView) BlurStickerEditView.this).scaleMin) {
                f16 = ((TAVStickerEditView) BlurStickerEditView.this).scaleMin;
            }
            if (((TAVStickerEditView) BlurStickerEditView.this).scaleMax > 0.0f && f16 > ((TAVStickerEditView) BlurStickerEditView.this).scaleMax) {
                return ((TAVStickerEditView) BlurStickerEditView.this).scaleMax;
            }
            return f16;
        }

        private boolean isTouchInSticker(MotionEvent motionEvent) {
            boolean z16;
            if ((motionEvent.getAction() & 255) == 0) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                this.isTouchInStickerRect = TAVStickerUtil.inQuadrangle(((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[0], ((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[1], ((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[2], ((TAVStickerEditView) BlurStickerEditView.this).vertexPoints[3], new PointF(x16, y16));
                if (((TAVStickerEditView) BlurStickerEditView.this).singleZoomRotateRect != null && ((TAVStickerEditView) BlurStickerEditView.this).singleZoomRotateRect.contains(x16, y16)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.isTouchInSingleZoomRotateRect = z16;
            }
            if (this.isTouchInStickerRect || this.isTouchInSingleZoomRotateRect) {
                return true;
            }
            return false;
        }

        private void onHandleScaleAndRotate(float f16, float f17) {
            this.isClickSticker = false;
            if (TAVStickerExKt.isRotateEnable(((TAVStickerEditView) BlurStickerEditView.this).sticker)) {
                float rotation = (TAVStickerUtil.getRotation(f16, f17) - this.twoPointDownRotate) + this.lastDownRotate;
                if (rotation < 0.0f) {
                    rotation += 360.0f;
                } else if (rotation > 360.0f) {
                    rotation -= 360.0f;
                }
                TLog.d(BlurStickerEditView.TAG, "onHandleScaleAndRotate -> rotation : " + rotation + ", displayRotation : " + BlurStickerEditView.this.rotateInterceptor(rotation));
            }
            if (this.twoPointDownDistance > 0.0f) {
                if (TAVStickerExKt.isLockRatio(((TAVStickerEditView) BlurStickerEditView.this).sticker)) {
                    float handleScaleLimit = handleScaleLimit(this.lastDownScale * (((float) Math.sqrt((f16 * f16) + (f17 * f17))) / this.twoPointDownDistance));
                    float scaleInterceptor = BlurStickerEditView.this.scaleInterceptor(handleScaleLimit);
                    TLog.d(BlurStickerEditView.TAG, "onHandleScaleAndRotate -> curScale : " + handleScaleLimit + ", displayScale : " + scaleInterceptor);
                    BlurStickerEditView.this.setScale(scaleInterceptor);
                    return;
                }
                float abs = Math.abs(f16);
                float abs2 = Math.abs(f17);
                float f18 = this.lastDownScaleX * (abs / this.xDistanceOnDown);
                float f19 = this.lastDownScaleY * (abs2 / this.yDistanceOnDown);
                float handleScaleXLimit = BlurStickerEditView.this.handleScaleXLimit(f18);
                float handleScaleYLimit = BlurStickerEditView.this.handleScaleYLimit(f19);
                setXScale(handleScaleXLimit);
                setYScale(handleScaleYLimit);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.actionIndex = motionEvent.getActionIndex();
            if (((TAVStickerEditView) BlurStickerEditView.this).sticker.isEditable() && ((TAVStickerEditView) BlurStickerEditView.this).eventType != 0) {
                isTouchInSticker(motionEvent);
                BlurStickerEditView.this.bringToFront();
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
                        return handleActionUp(motionEvent);
                    }
                } else {
                    handleActionDown(motionEvent);
                }
                return true;
            }
            return false;
        }

        protected void setXScale(float f16) {
            if (((TAVStickerEditView) BlurStickerEditView.this).pagView != null) {
                ((TAVStickerEditView) BlurStickerEditView.this).pagView.setScaleX(f16);
                BlurStickerEditView.this.xScale = f16;
            }
        }

        protected void setYScale(float f16) {
            if (((TAVStickerEditView) BlurStickerEditView.this).pagView != null) {
                ((TAVStickerEditView) BlurStickerEditView.this).pagView.setScaleY(f16);
                BlurStickerEditView.this.yScale = f16;
            }
        }
    }

    public BlurStickerEditView(Context context, TAVSticker tAVSticker, StickerEditViewIconConfig stickerEditViewIconConfig) {
        super(context, tAVSticker, stickerEditViewIconConfig);
        this.textureMap = new HashMap<>();
        this.hBlurFilter = new GaosiBlurFilter(true, 10);
        this.vBlurFilter = new GaosiBlurFilter(false, 10);
        this.scaleSmallTextureFilter = new ScaleTextureFilter();
        this.scaleBigTextureFilter = new ScaleTextureFilter();
        this.blurBgPaint = new Paint();
        this.blurTextPaint = new Paint();
        this.xScale = -1.0f;
        this.yScale = -1.0f;
        this.xScaleMax = 0.0f;
        this.yScaleMax = 0.0f;
        this.xScaleMin = 0.0f;
        this.yScaleMin = 0.0f;
        this.lock = new ReentrantLock();
        this.latch = new CountDownLatch(0);
        initBlurBgPaint();
        this.pagView.setVisibility(4);
        this.eventType = 13;
    }

    private void drawBlurBgTexture(Canvas canvas) {
        try {
            RectF stickerRectF = getStickerRectF();
            if (this.bgBitmap != null) {
                Bitmap bitmap = this.bgBitmap;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.blurBgPaint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                float f16 = this.STICKER_CORNER_RADIUS;
                canvas.drawRoundRect(stickerRectF, f16, f16, this.blurBgPaint);
                Handler handler = this.playerThreadHandler;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.BlurStickerEditView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BlurStickerEditView.TAG, "run: thread = " + Thread.currentThread());
                            Log.d(BlurStickerEditView.TAG, "Thread Name2: " + Thread.currentThread().getName());
                            if (BlurStickerEditView.this.lock.isHeldByCurrentThread()) {
                                BlurStickerEditView.this.lock.unlock();
                            }
                        }
                    });
                }
            } else {
                Log.e(TAG, "drawBlurBgTexture: \u6a21\u7cca\u7eb9\u7406\u4e3a\u7a7a\uff01");
                final CIImage sourceCIImage = WSOverLayBlurManager.getSourceCIImage();
                final RenderInfo renderInfo = WSOverLayBlurManager.getRenderInfo();
                Handler handler2 = this.playerThreadHandler;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.BlurStickerEditView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BlurStickerEditView.this.onSourceImageUpdated(sourceCIImage, renderInfo);
                        }
                    });
                }
            }
        } catch (Exception e16) {
            Log.e(TAG, "updateBgPaint: " + e16.toString());
        }
    }

    private TextureInfo extractTextureInfoFromCIImage(CIImage cIImage, RenderInfo renderInfo) {
        return renderInfo.getCiContext().convertImageToTexture(cIImage, getCacheTextureInfo((int) cIImage.getSize().width, (int) cIImage.getSize().height));
    }

    private TextureInfo getCacheTextureInfo(int i3, int i16) {
        TextureInfo textureInfo;
        String str = i3 + "_" + i16;
        if (this.textureMap.containsKey(str)) {
            textureInfo = this.textureMap.get(str);
        } else {
            textureInfo = null;
        }
        if (textureInfo == null) {
            TextureInfo newTextureInfo = CIContext.newTextureInfo(i3, i16);
            this.textureMap.put(str, newTextureInfo);
            return newTextureInfo;
        }
        return textureInfo;
    }

    @NotNull
    private RectF getStickerRectF() {
        RectF rectF = new RectF();
        rectF.left = this.centerX - ((TAVStickerExKt.getStickerScaleX(this.sticker) * this.stickerBorderRect.width()) / 2.0f);
        rectF.right = this.centerX + ((TAVStickerExKt.getStickerScaleX(this.sticker) * this.stickerBorderRect.width()) / 2.0f);
        rectF.top = this.centerY - ((TAVStickerExKt.getStickerScaleY(this.sticker) * this.stickerBorderRect.height()) / 2.0f);
        rectF.bottom = this.centerY + ((TAVStickerExKt.getStickerScaleY(this.sticker) * this.stickerBorderRect.height()) / 2.0f);
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float handleScaleXLimit(float f16) {
        float f17 = this.xScaleMin;
        if (f17 > 0.0f && f16 < f17) {
            f16 = f17;
        }
        float f18 = this.xScaleMax;
        if (f18 > 0.0f && f16 > f18) {
            return f18;
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float handleScaleYLimit(float f16) {
        float f17 = this.yScaleMin;
        if (f17 > 0.0f && f16 < f17) {
            f16 = f17;
        }
        float f18 = this.yScaleMax;
        if (f18 > 0.0f && f16 > f18) {
            return f18;
        }
        return f16;
    }

    private void initBlurBgPaint() {
        Paint paint = new Paint();
        this.blurBgPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.blurTextPaint = paint2;
        paint2.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints != null) {
            RectF rectF = this.stickerBorderRect;
            PointF pointF = originalVertexPoints[0];
            rectF.set(pointF.x, pointF.y, originalVertexPoints[2].x, originalVertexPoints[3].y);
        }
        String str = this.texturePngPath;
        if (str != null && str.length() > 0) {
            drawBlurBgTexture(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView
    protected void drawBorder(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints != null && originalVertexPoints.length >= 4) {
            canvas.save();
            this.stickerMatrix.reset();
            this.stickerMatrix.postTranslate(this.centerX - this.originalCenterX, this.centerY - this.originalCenterY);
            this.stickerMatrix.postRotate(getSticker().getRotate(), this.centerX, this.centerY);
            if (this.sticker.getExtraBundle().getBoolean(Constants.STICKER.KEY_STICKER_LOCK_RATIO)) {
                this.stickerMatrix.postScale(this.sticker.getScale(), this.sticker.getScale(), this.centerX, this.centerY);
            } else {
                this.stickerMatrix.postScale(TAVStickerExKt.getStickerScaleX(this.sticker), TAVStickerExKt.getStickerScaleY(this.sticker), this.centerX, this.centerY);
            }
            canvas.concat(this.stickerMatrix);
            RectF rectF = this.stickerBorderRect;
            PointF pointF = originalVertexPoints[0];
            rectF.set(pointF.x, pointF.y, originalVertexPoints[2].x, originalVertexPoints[3].y);
            Path path = new Path();
            ((WsStickerEditView) this).borderPaint.setStrokeJoin(Paint.Join.ROUND);
            PointF pointF2 = originalVertexPoints[0];
            path.moveTo(pointF2.x, pointF2.y);
            PointF pointF3 = originalVertexPoints[1];
            path.lineTo(pointF3.x, pointF3.y);
            PointF pointF4 = originalVertexPoints[2];
            path.moveTo(pointF4.x, pointF4.y);
            PointF pointF5 = originalVertexPoints[3];
            path.lineTo(pointF5.x, pointF5.y);
            ((WsStickerEditView) this).borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / this.yScale);
            canvas.drawPath(path, ((WsStickerEditView) this).borderPaint);
            Path path2 = new Path();
            PointF pointF6 = originalVertexPoints[1];
            path2.moveTo(pointF6.x, pointF6.y);
            PointF pointF7 = originalVertexPoints[2];
            path2.lineTo(pointF7.x, pointF7.y);
            PointF pointF8 = originalVertexPoints[3];
            path2.moveTo(pointF8.x, pointF8.y);
            PointF pointF9 = originalVertexPoints[0];
            path2.lineTo(pointF9.x, pointF9.y);
            ((WsStickerEditView) this).borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / this.xScale);
            canvas.drawPath(path2, ((WsStickerEditView) this).borderPaint);
            canvas.restore();
        }
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView
    protected void drawDeleteBtn(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints == null) {
            return;
        }
        canvas.save();
        if (originalVertexPoints.length >= 4) {
            PointF pointF = originalVertexPoints[0];
            float f16 = pointF.x;
            float f17 = pointF.y;
            canvas.concat(this.stickerMatrix);
            canvas.scale(this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleX(this.sticker), this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleY(this.sticker), f16, f17);
            Rect rect = new Rect(0, 0, this.bmpDelete.getWidth(), this.bmpDelete.getHeight());
            this.deleteBtnRect = new RectF(f16 - this.bmpDelete.getWidth(), f17 - this.bmpDelete.getHeight(), f16 + this.bmpDelete.getWidth(), f17 + this.bmpDelete.getHeight());
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(this.bmpDelete, rect, this.deleteBtnRect, (Paint) null);
        }
        canvas.getMatrix().mapRect(this.deleteBtnRect);
        canvas.restore();
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView
    protected void drawZoomBtn(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints == null) {
            return;
        }
        canvas.save();
        if (originalVertexPoints.length >= 4) {
            PointF pointF = originalVertexPoints[2];
            float f16 = pointF.x;
            float f17 = pointF.y;
            canvas.concat(this.stickerMatrix);
            canvas.scale(this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleX(this.sticker), this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleY(this.sticker), f16, f17);
            Rect rect = new Rect(0, 0, this.bmpZoom.getWidth(), this.bmpZoom.getHeight());
            RectF rectF = new RectF(f16 - this.bmpZoom.getWidth(), f17 - this.bmpZoom.getHeight(), f16 + this.bmpZoom.getWidth(), f17 + this.bmpZoom.getHeight());
            this.zoomBtnRect = rectF;
            setSingleZoomRotateRect(rectF);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(this.bmpZoom, rect, this.zoomBtnRect, (Paint) null);
        }
        canvas.getMatrix().mapRect(this.zoomBtnRect);
        canvas.restore();
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView, com.tencent.tavsticker.core.TAVStickerEditView
    protected View.OnTouchListener getStickerTouchListener() {
        return new TavStickerTouchListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    public void initScaleData() {
        this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
        this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
        float stickerScaleMaxX = TAVStickerExKt.getStickerScaleMaxX(this.sticker);
        float stickerScaleMaxY = TAVStickerExKt.getStickerScaleMaxY(this.sticker);
        float stickerScaleMinX = TAVStickerExKt.getStickerScaleMinX(this.sticker);
        float sticerScaleMinY = TAVStickerExKt.getSticerScaleMinY(this.sticker);
        if (stickerScaleMaxX <= 0.0f) {
            stickerScaleMaxX = (this.moveRegionWidth * 1.0f) / this.stickerWidth;
        }
        this.xScaleMax = stickerScaleMaxX;
        if (stickerScaleMaxY <= 0.0f) {
            stickerScaleMaxY = (this.moveRegionHeight * 1.0f) / this.stickerHeight;
        }
        this.yScaleMax = stickerScaleMaxY;
        this.yScaleMin = Math.max(stickerScaleMinX, 0.0f);
        float max = Math.max(sticerScaleMinY, 0.0f);
        this.xScaleMin = max;
        float f16 = this.xScaleMax;
        if (f16 > 0.0f && this.xScale > f16) {
            this.xScale = f16;
        }
        float f17 = this.yScaleMax;
        if (f17 > 0.0f && this.yScale > f17) {
            this.yScale = f17;
        }
        if (this.xScale < max) {
            this.xScale = max;
        }
        float f18 = this.yScale;
        float f19 = this.yScaleMin;
        if (f18 < f19) {
            this.yScale = f19;
        }
        TAVStickerExKt.setStickerScaleY(this.sticker, this.yScale);
        TAVStickerExKt.setStickerScaleX(this.sticker, this.xScale);
        super.initScaleData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    public void initStickerData() {
        this.xScale = this.sticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_X, 1.0f);
        this.yScale = this.sticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_Y, 1.0f);
        this.texturePngPath = TAVStickerExKt.getStickerTexturePngPath(getSticker());
        this.textPngPath = TAVStickerExKt.getStickerTextPngPath(getSticker());
        super.initStickerData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CIImage cIImage = this.curCIImage;
        if (cIImage != null) {
            cIImage.release();
        }
    }

    @Override // com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager.SourceImageObserver
    public void onSourceImageUpdated(CIImage cIImage, RenderInfo renderInfo) {
        try {
            CIImage cIImage2 = this.curCIImage;
            if (cIImage2 != null) {
                cIImage2.release();
            }
            TextureInfo extractTextureInfoFromCIImage = extractTextureInfoFromCIImage(cIImage, renderInfo);
            int i3 = extractTextureInfoFromCIImage.preferRotation;
            this.scaleSmallTextureFilter.release();
            this.hBlurFilter.release();
            this.vBlurFilter.release();
            CIImage cIImage3 = new CIImage(WSOverLayBlurManager.getBlurredTextureInfo(extractTextureInfoFromCIImage, getWidth(), getHeight(), i3, 10, 0.25f, this.hBlurFilter, this.vBlurFilter, this.scaleSmallTextureFilter, this.scaleBigTextureFilter).m261clone());
            cIImage3.applyPreferRotation(0);
            cIImage3.applyFillInFrame(new CGRect(new PointF(0.0f, 0.0f), new CGSize(getWidth(), getHeight())), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
            cIImage3.applyFlip(false, true);
            this.curCIImage = cIImage3;
            if (this.playerThreadHandler == null) {
                this.playerThreadHandler = new Handler();
            }
            Log.d(TAG, "Thread Name1: " + Thread.currentThread().getName());
            if (this.lock.tryLock()) {
                this.bgBitmap = TAVGLUtils.saveBitmap(cIImage3);
                postInvalidate();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView, com.tencent.tavsticker.core.TAVStickerEditView
    public void setMode(TAVStickerMode tAVStickerMode) {
        super.setMode(tAVStickerMode);
        if (tAVStickerMode != TAVStickerMode.ACTIVE && getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    public void setScale(float f16) {
        if (TAVStickerExKt.isLockRatio(this.sticker)) {
            super.setScale(f16);
            return;
        }
        float f17 = this.xScale;
        if (f17 != -1.0f && this.yScale != -1.0f) {
            this.xScale = handleScaleXLimit(f17);
            this.yScale = handleScaleYLimit(this.yScale);
            this.pagView.setScaleX(this.xScale);
            this.pagView.setScaleY(this.yScale);
            TAVStickerExKt.setStickerScaleX(this.sticker, this.xScale);
            TAVStickerExKt.setStickerScaleY(this.sticker, this.yScale);
            return;
        }
        this.pagView.setScaleX(TAVStickerExKt.getStickerScaleX(this.sticker));
        this.pagView.setScaleY(TAVStickerExKt.getStickerScaleY(this.sticker));
        this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
        this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView
    protected void updateBorderPaint() {
        if (0.0f != getSticker().getScale()) {
            Paint paint = ((WsStickerEditView) this).borderPaint;
            float f16 = this.DEFAULT_BORDER_STROKE_WIDTH;
            paint.setStrokeWidth(Math.min(f16 / this.xScale, f16 / this.yScale));
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    protected void updateStickerOnAdjustLocation(float f16, float f17) {
        this.sticker.setCenterX(f16).setCenterY(f17);
        if (!TAVStickerExKt.isLockRatio(this.sticker)) {
            if (this.xScale != -1.0f) {
                this.sticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_X, this.xScale);
            } else {
                this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
            }
            if (this.yScale != -1.0f) {
                this.sticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_Y, this.yScale);
            } else {
                this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
            }
        } else {
            this.sticker.setScale(this.scale);
        }
        if (TAVStickerExKt.isRotateEnable(this.sticker)) {
            this.sticker.setRotate(this.rotate);
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    protected void updateVertexPoints() {
        PointF[] computeRectanglePoints = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
        PointF[] pointFArr = this.vertexPoints;
        pointFArr[0] = computeRectanglePoints[0];
        pointFArr[1] = computeRectanglePoints[1];
        pointFArr[2] = computeRectanglePoints[2];
        pointFArr[3] = computeRectanglePoints[3];
        Log.d("btn_pos", "updateVertexPoints: " + this.vertexPoints[0].toString() + " " + this.vertexPoints[1].toString() + " " + this.vertexPoints[2].toString() + " " + this.vertexPoints[3].toString());
    }
}
