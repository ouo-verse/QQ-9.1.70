package com.tencent.qcircle.weseevideo.editor.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerDrawingOperationMask;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.tavsticker.core.ITAVStickerEventListener;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WsStickerEditView extends TAVStickerEditView {
    String ADJUST_TIME_TEXT;
    int CLICK_DURATION;
    protected float DEFAULT_BORDER_STROKE_WIDTH;
    protected float OPERATION_BUTTON_SCALE;
    protected float STICKER_CORNER_RADIUS;
    private final String TAG;
    int TOUCH_SLOP;
    private RectF adjustTimeBtnRect;
    private Bitmap bmpAdjustTimeRange;
    protected Bitmap bmpDelete;
    protected Bitmap bmpEdit;
    protected Bitmap bmpZoom;
    protected Paint borderPaint;
    protected Paint btnPaint;
    private int btnTextColor;
    private Paint btnTextPaint;
    private int clickPadding;
    protected RectF deleteBtnRect;
    protected int drawMask;
    protected RectF editBtnRect;
    boolean isStickerSelected;
    private OnBtnTouchListener onBtnTouchListener;
    private TAVStickerOperationMode operationMode;
    protected RectF stickerBorderRect;
    protected OnStickerEditButtonClickListener stickerEditButtonClickListener;
    private StickerEditViewIconConfig stickerEditViewIconConfig;
    protected Matrix stickerMatrix;
    protected RectF zoomBtnRect;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class OnBtnTouchListener implements View.OnTouchListener {
        private Point downPoint;
        private boolean isClickAdjustTime;
        private boolean isClickDelete;
        private boolean isClickEdit;

        OnBtnTouchListener() {
            this.isClickAdjustTime = false;
            this.isClickDelete = false;
            this.isClickEdit = false;
            this.downPoint = new Point();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (WsStickerEditView.this.getSticker().isEditable() && WsStickerEditView.this.isStickerSelected) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                if (TAVStickerMode.ACTIVE == WsStickerEditView.this.getMode()) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (Math.abs(x16 - this.downPoint.x) <= WsStickerEditView.this.TOUCH_SLOP && Math.abs(y16 - this.downPoint.y) <= WsStickerEditView.this.TOUCH_SLOP) {
                                    return true;
                                }
                                this.isClickAdjustTime = false;
                                this.isClickDelete = false;
                                this.isClickEdit = false;
                            }
                        } else {
                            long abs = Math.abs(motionEvent.getEventTime() - motionEvent.getDownTime());
                            WsStickerEditView wsStickerEditView = WsStickerEditView.this;
                            if (abs < wsStickerEditView.CLICK_DURATION) {
                                if (this.isClickAdjustTime) {
                                    OnStickerEditButtonClickListener onStickerEditButtonClickListener = wsStickerEditView.stickerEditButtonClickListener;
                                    if (onStickerEditButtonClickListener != null) {
                                        onStickerEditButtonClickListener.onAdjustTimeClick(wsStickerEditView.getSticker());
                                    }
                                    return true;
                                }
                                if (this.isClickDelete) {
                                    OnStickerEditButtonClickListener onStickerEditButtonClickListener2 = wsStickerEditView.stickerEditButtonClickListener;
                                    if (onStickerEditButtonClickListener2 != null) {
                                        onStickerEditButtonClickListener2.onDeleteClick(wsStickerEditView.getSticker());
                                    }
                                    return true;
                                }
                                if (this.isClickEdit) {
                                    ArrayList arrayList = new ArrayList();
                                    if (WsStickerEditView.this.getSticker().getStickerTextItems() != null) {
                                        Iterator<TAVStickerTextItem> it = WsStickerEditView.this.getSticker().getStickerTextItems().iterator();
                                        while (it.hasNext()) {
                                            TAVStickerTextItem next = it.next();
                                            if (next.getLayerType() == 3) {
                                                arrayList.add(next);
                                            }
                                        }
                                    }
                                    WsStickerEditView wsStickerEditView2 = WsStickerEditView.this;
                                    OnStickerEditButtonClickListener onStickerEditButtonClickListener3 = wsStickerEditView2.stickerEditButtonClickListener;
                                    if (onStickerEditButtonClickListener3 != null) {
                                        onStickerEditButtonClickListener3.onEditClick(wsStickerEditView2.getSticker(), arrayList);
                                    }
                                    return true;
                                }
                            }
                        }
                    } else {
                        this.isClickAdjustTime = false;
                        this.isClickDelete = false;
                        this.downPoint.set(x16, y16);
                        if (WsStickerEditView.this.isTouchAdjustTimeBtn(x16, y16) && StickerDrawingOperationMask.isDrawLeftBottom(WsStickerEditView.this.drawMask)) {
                            this.isClickAdjustTime = true;
                            return true;
                        }
                        if (WsStickerEditView.this.isTouchDeleteBtn(x16, y16) && StickerDrawingOperationMask.isDrawLeftTop(WsStickerEditView.this.drawMask)) {
                            this.isClickDelete = true;
                            return true;
                        }
                        if (WsStickerEditView.this.isTouchEditBtn(motionEvent.getX(), motionEvent.getY()) && StickerDrawingOperationMask.isDrawRightTop(WsStickerEditView.this.drawMask)) {
                            this.isClickEdit = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnStickerEditButtonClickListener {
        void onAdjustTimeClick(TAVSticker tAVSticker);

        void onDeleteClick(TAVSticker tAVSticker);

        void onEditClick(TAVSticker tAVSticker, List<TAVStickerLayerItem> list);

        void onStickerClick(TAVSticker tAVSticker);

        void onStickerSelected(TAVSticker tAVSticker);
    }

    public WsStickerEditView(Context context, TAVSticker tAVSticker, StickerEditViewIconConfig stickerEditViewIconConfig) {
        super(context, tAVSticker);
        this.TAG = WsStickerEditView.class.getSimpleName();
        this.btnTextColor = Color.parseColor("#1E1E22");
        this.btnPaint = new Paint();
        this.borderPaint = new Paint();
        this.btnTextPaint = new Paint();
        this.adjustTimeBtnRect = new RectF();
        this.deleteBtnRect = new RectF();
        this.zoomBtnRect = new RectF();
        this.editBtnRect = new RectF();
        this.stickerEditButtonClickListener = null;
        this.onBtnTouchListener = null;
        this.drawMask = 63;
        this.isStickerSelected = false;
        this.operationMode = TAVStickerOperationMode.OP_NONE;
        this.stickerMatrix = new Matrix();
        this.stickerBorderRect = new RectF();
        this.clickPadding = ViewUtils.dip2px(5.0f);
        this.ADJUST_TIME_TEXT = "\u8c03\u6574\u65f6\u957f";
        this.OPERATION_BUTTON_SCALE = 0.5f;
        this.TOUCH_SLOP = 16;
        this.CLICK_DURATION = 200;
        this.DEFAULT_BORDER_STROKE_WIDTH = ViewUtils.dip2px(1.5f);
        this.STICKER_CORNER_RADIUS = ViewUtils.dip2px(3.0f);
        this.stickerEditViewIconConfig = stickerEditViewIconConfig;
        init();
    }

    private void drawAdjustTimeBtn(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints == null) {
            return;
        }
        canvas.save();
        if (originalVertexPoints.length >= 4) {
            PointF pointF = originalVertexPoints[3];
            float f16 = pointF.x;
            float f17 = pointF.y;
            canvas.concat(this.stickerMatrix);
            canvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f16, f17);
            Rect rect = new Rect(0, 0, this.bmpAdjustTimeRange.getWidth(), this.bmpAdjustTimeRange.getHeight());
            this.adjustTimeBtnRect = new RectF(f16 - this.bmpAdjustTimeRange.getWidth(), f17 - this.bmpAdjustTimeRange.getHeight(), f16 + this.bmpAdjustTimeRange.getWidth(), f17 + this.bmpAdjustTimeRange.getHeight());
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(this.bmpAdjustTimeRange, rect, this.adjustTimeBtnRect, (Paint) null);
        }
        canvas.getMatrix().mapRect(this.adjustTimeBtnRect);
        canvas.restore();
    }

    private void drawEditBtn(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints == null) {
            return;
        }
        canvas.save();
        if (originalVertexPoints.length >= 4) {
            PointF pointF = originalVertexPoints[1];
            float f16 = pointF.x;
            float f17 = pointF.y;
            canvas.concat(this.stickerMatrix);
            canvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f16, f17);
            Rect rect = new Rect(0, 0, this.bmpEdit.getWidth(), this.bmpEdit.getHeight());
            this.editBtnRect = new RectF(f16 - this.bmpEdit.getWidth(), f17 - this.bmpEdit.getHeight(), f16 + this.bmpEdit.getWidth(), f17 + this.bmpEdit.getHeight());
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(this.bmpEdit, rect, this.editBtnRect, (Paint) null);
        }
        canvas.getMatrix().mapRect(this.editBtnRect);
        canvas.restore();
    }

    private void initStickerEventListener() {
        super.setOnStickerEventListener(new ITAVStickerEventListener() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.2
            @Override // com.tencent.tavsticker.core.ITAVStickerEventListener
            public void onDataChanged(TAVSticker tAVSticker, TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19) {
                TLog.d(WsStickerEditView.this.TAG, "onDataChanged -> $tavSticker, centerX : $centerX, centerY : $centerX, scale : $scale, rotate : $rotate");
                WsStickerEditView.this.operationMode = tAVStickerOperationMode;
                StickerEventDispatcher.getInstance().onStickerDataChanged(tAVSticker, tAVStickerOperationMode, f16, f17, f18, f19);
            }

            @Override // com.tencent.tavsticker.core.ITAVStickerEventListener
            public void onStickerClick(TAVSticker tAVSticker, MotionEvent motionEvent) {
                TLog.d(WsStickerEditView.this.TAG, "onStickerClick -> $tavSticker");
                WsStickerEditView wsStickerEditView = WsStickerEditView.this;
                OnStickerEditButtonClickListener onStickerEditButtonClickListener = wsStickerEditView.stickerEditButtonClickListener;
                if (onStickerEditButtonClickListener != null) {
                    if (wsStickerEditView.isStickerSelected) {
                        onStickerEditButtonClickListener.onStickerClick(wsStickerEditView.getSticker());
                    } else {
                        onStickerEditButtonClickListener.onStickerSelected(wsStickerEditView.getSticker());
                    }
                }
                WsStickerEditView.this.isStickerSelected = true;
            }

            @Override // com.tencent.tavsticker.core.ITAVStickerEventListener
            public void onTouchBegin(TAVSticker tAVSticker, MotionEvent motionEvent) {
                TLog.d(WsStickerEditView.this.TAG, "onTouchBegin -> $tavSticker");
                StickerEventDispatcher.getInstance().onStickerStatusChanged(tAVSticker, Boolean.TRUE, Boolean.valueOf(WsStickerEditView.this.isStickerSelected));
            }

            @Override // com.tencent.tavsticker.core.ITAVStickerEventListener
            public void onTouchEnd(TAVSticker tAVSticker, MotionEvent motionEvent) {
                TLog.d(WsStickerEditView.this.TAG, "onTouchEnd -> $tavSticker");
                WsStickerEditView.this.operationMode = TAVStickerOperationMode.OP_NONE;
                StickerEventDispatcher.getInstance().onStickerStatusChanged(tAVSticker, Boolean.FALSE, Boolean.valueOf(WsStickerEditView.this.isStickerSelected));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchAdjustTimeBtn(int i3, int i16) {
        RectF rectF = this.adjustTimeBtnRect;
        float f16 = rectF.left;
        float f17 = rectF.right;
        if (f16 < f17) {
            float f18 = rectF.top;
            float f19 = rectF.bottom;
            if (f18 < f19) {
                float f26 = i3;
                int i17 = this.clickPadding;
                if (f26 >= f16 - i17 && f26 < f17 + i17) {
                    float f27 = i16;
                    if (f27 >= f18 - i17 && f27 < f19 + i17) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchEditBtn(float f16, float f17) {
        return this.editBtnRect.contains(f16, f17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (TAVStickerMode.ACTIVE == this.mode && canvas != null) {
            if (StickerDrawingOperationMask.isDrawBorder(this.drawMask)) {
                drawBorder(canvas);
            }
            if (StickerDrawingOperationMask.isDrawLeftTop(this.drawMask) && BitmapUtil.isValidBitmap(this.bmpDelete)) {
                drawDeleteBtn(canvas);
            }
            if (StickerDrawingOperationMask.isDrawRightBottom(this.drawMask) && BitmapUtil.isValidBitmap(this.bmpZoom)) {
                drawZoomBtn(canvas);
            }
            if (StickerDrawingOperationMask.isDrawLeftBottom(this.drawMask) && BitmapUtil.isValidBitmap(this.bmpAdjustTimeRange)) {
                drawAdjustTimeBtn(canvas);
            }
        }
    }

    protected void drawBorder(Canvas canvas) {
        PointF[] originalVertexPoints = getOriginalVertexPoints();
        if (originalVertexPoints != null && originalVertexPoints.length >= 4) {
            canvas.save();
            this.stickerMatrix.reset();
            this.stickerMatrix.postTranslate(this.centerX - this.originalCenterX, this.centerY - this.originalCenterY);
            this.stickerMatrix.postRotate(getSticker().getRotate(), this.centerX, this.centerY);
            this.stickerMatrix.postScale(getSticker().getScale(), getSticker().getScale(), this.centerX, this.centerY);
            canvas.concat(this.stickerMatrix);
            RectF rectF = this.stickerBorderRect;
            PointF pointF = originalVertexPoints[0];
            rectF.set(pointF.x, pointF.y, originalVertexPoints[2].x, originalVertexPoints[3].y);
            updateBorderPaint();
            RectF rectF2 = this.stickerBorderRect;
            float f16 = this.STICKER_CORNER_RADIUS;
            canvas.drawRoundRect(rectF2, f16, f16, this.borderPaint);
            canvas.restore();
        }
    }

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
            canvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f16, f17);
            Rect rect = new Rect(0, 0, this.bmpDelete.getWidth(), this.bmpDelete.getHeight());
            this.deleteBtnRect = new RectF(f16 - this.bmpDelete.getWidth(), f17 - this.bmpDelete.getHeight(), f16 + this.bmpDelete.getWidth(), f17 + this.bmpDelete.getHeight());
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(this.bmpDelete, rect, this.deleteBtnRect, (Paint) null);
        }
        canvas.getMatrix().mapRect(this.deleteBtnRect);
        canvas.restore();
    }

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
            canvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f16, f17);
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

    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    protected View.OnTouchListener getStickerTouchListener() {
        return new OnBtnTouchListener();
    }

    protected void init() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.addPAGFlushListener(new PAGView.PAGFlushListener() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.1
                @Override // org.libpag.PAGView.PAGFlushListener
                public void onFlush() {
                }
            });
        }
        StickerEditViewIconConfig stickerEditViewIconConfig = this.stickerEditViewIconConfig;
        if (stickerEditViewIconConfig != null && stickerEditViewIconConfig.getDeleteIconResId() != -1) {
            this.bmpDelete = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getDeleteIconResId());
        }
        StickerEditViewIconConfig stickerEditViewIconConfig2 = this.stickerEditViewIconConfig;
        if (stickerEditViewIconConfig2 != null && stickerEditViewIconConfig2.getZoomIconResId() != -1) {
            this.bmpZoom = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getZoomIconResId());
        }
        StickerEditViewIconConfig stickerEditViewIconConfig3 = this.stickerEditViewIconConfig;
        if (stickerEditViewIconConfig3 != null && stickerEditViewIconConfig3.getEditIconResId() != -1) {
            this.bmpEdit = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getEditIconResId());
        }
        StickerEditViewIconConfig stickerEditViewIconConfig4 = this.stickerEditViewIconConfig;
        if (stickerEditViewIconConfig4 != null && stickerEditViewIconConfig4.getAdjustTimeRangeIconResId() != -1) {
            this.bmpAdjustTimeRange = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getAdjustTimeRangeIconResId());
        }
        this.btnPaint.setAntiAlias(true);
        this.btnPaint.setColor(-1);
        this.btnPaint.setStrokeWidth(1.0f);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setColor(-1);
        this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH);
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setShadowLayer(0.5f, 0.5f, 0.5f, -7829368);
        this.btnTextPaint.setAntiAlias(true);
        this.btnTextPaint.setColor(this.btnTextColor);
        this.btnTextPaint.setTextSize(ViewUtils.dip2px(24.0f));
        this.btnTextPaint.setTextAlign(Paint.Align.CENTER);
        this.btnTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        addOnTouchListener(getStickerTouchListener());
        initStickerEventListener();
        if (getSticker().getMode() == TAVStickerMode.ACTIVE) {
            this.isStickerSelected = true;
        }
    }

    public boolean isDrawGuideLine() {
        return StickerDrawingOperationMask.isDrawGuideLine(this.drawMask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTouchDeleteBtn(int i3, int i16) {
        return this.deleteBtnRect.contains(i3, i16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.operationMode = TAVStickerOperationMode.OP_NONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isStickerSelected = false;
        this.operationMode = TAVStickerOperationMode.OP_NONE;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    @NotNull
    public PointF positionInterceptor(float f16, float f17) {
        PointF pointF = new PointF(f16, f17);
        float abs = Math.abs((f16 + (this.stickerWidth / 2.0f)) - (getWidth() / 2.0f));
        float f18 = WsStickerContentView.DRAG_ADSORPTION_THRESHOLD;
        if (abs < f18) {
            pointF.x = (getWidth() / 2.0f) - (this.stickerWidth / 2.0f);
        }
        if (Math.abs((f17 + (this.stickerHeight / 2.0f)) - (getHeight() / 2.0f)) < f18) {
            pointF.y = (getHeight() / 2.0f) - (this.stickerHeight / 2.0f);
        }
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    public float rotateInterceptor(float f16) {
        if (Math.abs(f16 - 0.0f) < 2.0f) {
            return 0.0f;
        }
        if (Math.abs(f16 - 45.0f) <= 2.0f) {
            return 45.0f;
        }
        if (Math.abs(f16 - 90.0f) <= 2.0f) {
            return 90.0f;
        }
        if (Math.abs(f16 - 135.0f) <= 2.0f) {
            return 135.0f;
        }
        if (Math.abs(f16 - 180.0f) <= 2.0f) {
            return 180.0f;
        }
        if (Math.abs(f16 - 225.0f) <= 2.0f) {
            return 225.0f;
        }
        if (Math.abs(f16 - 270.0f) <= 2.0f) {
            return 270.0f;
        }
        if (Math.abs(f16 - 315.0f) <= 2.0f) {
            return 315.0f;
        }
        if (Math.abs(f16 - 360.0f) <= 2.0f) {
            return 0.0f;
        }
        return f16;
    }

    public void setDrawingOperationMask(int i3) {
        this.drawMask = i3;
        postInvalidate();
    }

    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    public void setMode(TAVStickerMode tAVStickerMode) {
        boolean z16;
        TAVStickerMode tAVStickerMode2 = TAVStickerMode.ACTIVE;
        if (tAVStickerMode == tAVStickerMode2 && this.mode != TAVStickerMode.INACTIVE) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isStickerSelected = z16;
        super.setMode(tAVStickerMode);
        if (tAVStickerMode == tAVStickerMode2) {
            bringToFront();
        }
    }

    public void setOnStickerEditButtonClickListener(OnStickerEditButtonClickListener onStickerEditButtonClickListener) {
        this.stickerEditButtonClickListener = onStickerEditButtonClickListener;
    }

    protected void updateBorderPaint() {
        float scale = getSticker().getScale();
        if (0.0f != scale) {
            this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / scale);
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerEditView
    public void setOnStickerEventListener(ITAVStickerEventListener iTAVStickerEventListener) {
    }
}
