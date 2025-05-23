package com.tencent.qcircle.weseevideo.editor.sticker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.core.TAVStickerContentView;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.ViewUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WsStickerContentView extends TAVStickerContentView implements IStickerEventListener {
    public static final float DRAG_ADSORPTION_THRESHOLD = ViewUtils.dip2px(2.0f) * 4.0f;
    public static final float ROTATE_ADSORPTION_THRESHOLD = 2.0f;
    public static final float VIBRATE_TIME_INTERVAL = 250.0f;
    private static final long VIBRATOR_DURATION = 30;
    private final String TAG;
    private float centerX;
    private float centerY;
    protected WsStickerEditView curStickerEditView;
    private Paint dashLinePaint;
    private Path dashPath;
    private boolean isStickerTouching;
    private long lastVibrateTime;
    private boolean needOperate;
    private boolean needVibrate;
    private TAVStickerOperationMode operationMode;
    public int parentLeft;
    public int parentTop;
    private ArrayList<PointF> points;
    private float rotate;
    private Paint solidLinePaint;
    private Path solidPath;
    private Vibrator vibrator;

    public WsStickerContentView(Context context) {
        super(context);
        this.TAG = WsStickerContentView.class.getSimpleName();
        this.vibrator = (Vibrator) TAVStickerHelper.getContext().getSystemService("vibrator");
        this.parentTop = 0;
        this.parentLeft = 0;
        this.solidLinePaint = new Paint();
        this.solidPath = new Path();
        this.dashLinePaint = new Paint();
        this.dashPath = new Path();
        this.isStickerTouching = false;
        this.needOperate = true;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.rotate = 0.0f;
        this.operationMode = TAVStickerOperationMode.OP_NONE;
        this.needVibrate = false;
        this.lastVibrateTime = 0L;
        this.curStickerEditView = null;
        init();
    }

    private boolean checkVibrateInterval() {
        long currentTimeMillis = System.currentTimeMillis();
        float abs = (float) Math.abs(currentTimeMillis - this.lastVibrateTime);
        TLog.d(this.TAG + "1", "time: " + currentTimeMillis + "lastTime: " + this.lastVibrateTime);
        this.lastVibrateTime = currentTimeMillis;
        if (abs > 250.0f) {
            return true;
        }
        return false;
    }

    private void drawDashLine(Canvas canvas) {
        ArrayList<PointF> points = getPoints();
        this.dashPath.reset();
        if (isDrawVerticalDashLine()) {
            this.needVibrate = true;
            this.dashPath.moveTo(this.centerX, 0.0f);
            this.dashPath.lineTo(this.centerX, getHeight());
        }
        if (isDrawHorizontalDashLine()) {
            this.needVibrate = true;
            this.dashPath.moveTo(0.0f, this.centerY);
            this.dashPath.lineTo(getWidth(), this.centerY);
        }
        if (isDrawNortheast2SouthwestLine()) {
            this.dashPath.moveTo(points.get(1).x, points.get(1).y);
            this.dashPath.lineTo(points.get(3).x, points.get(3).y);
        }
        if (isDrawNorthwest2SoutheastLine()) {
            this.dashPath.moveTo(points.get(0).x, points.get(0).y);
            this.dashPath.lineTo(points.get(2).x, points.get(2).y);
        }
        if (!this.dashPath.isEmpty()) {
            canvas.drawPath(this.dashPath, this.dashLinePaint);
        }
    }

    private void drawSolidLine(Canvas canvas) {
        this.solidPath.reset();
        if (isDrawVerticalSolidLine()) {
            this.needVibrate = true;
            this.solidPath.moveTo(this.centerX, 0.0f);
            this.solidPath.lineTo(this.centerX, getHeight());
        }
        if (isDrawHorizontalSolidLine()) {
            this.needVibrate = true;
            this.solidPath.moveTo(0.0f, this.centerY);
            this.solidPath.lineTo(getWidth(), this.centerY);
        }
        if (!this.solidPath.isEmpty()) {
            canvas.drawPath(this.solidPath, this.solidLinePaint);
            canvas.drawPath(this.solidPath, this.dashLinePaint);
        }
    }

    private ArrayList<PointF> getPoints() {
        if (getWidth() > 0 && getHeight() > 0) {
            float min = Math.min(getWidth(), getHeight());
            this.points.get(0).set(this.centerX - min, this.centerY - min);
            this.points.get(1).set(this.centerX + min, this.centerY - min);
            this.points.get(2).set(this.centerX + min, this.centerY + min);
            this.points.get(3).set(this.centerX - min, this.centerY + min);
        }
        return this.points;
    }

    private void init() {
        this.points = new ArrayList<>();
        for (int i3 = 0; i3 < 4; i3++) {
            this.points.add(new PointF());
        }
        this.solidLinePaint.setAntiAlias(true);
        this.solidLinePaint.setColor(-16777216);
        this.solidLinePaint.setAlpha(13);
        this.solidLinePaint.setStrokeWidth(Util.dp2px(getContext(), 1.0f));
        this.solidLinePaint.setStyle(Paint.Style.STROKE);
        this.dashLinePaint.setAntiAlias(true);
        this.dashLinePaint.setColor(-1);
        this.dashLinePaint.setStrokeWidth(Util.dp2px(getContext(), 1.0f));
        this.dashLinePaint.setStyle(Paint.Style.STROKE);
        float dp2px = Util.dp2px(getContext(), 2.0f);
        this.dashLinePaint.setPathEffect(new DashPathEffect(new float[]{dp2px, dp2px}, 0.0f));
        setWillNotDraw(false);
    }

    private boolean isDrawHorizontalDashLine() {
        if (Math.abs(this.rotate - 0.0f) >= 2.0f && Math.abs(this.rotate - 180.0f) >= 2.0f) {
            return false;
        }
        return true;
    }

    private boolean isDrawHorizontalSolidLine() {
        if (Math.abs((getHeight() / 2.0f) - this.centerY) < DRAG_ADSORPTION_THRESHOLD) {
            return true;
        }
        return false;
    }

    private boolean isDrawNortheast2SouthwestLine() {
        if (Math.abs(this.rotate - 315.0f) >= 2.0f && Math.abs(this.rotate - 135.0f) >= 2.0f) {
            return false;
        }
        return true;
    }

    private boolean isDrawNorthwest2SoutheastLine() {
        if (Math.abs(this.rotate - 45.0f) >= 2.0f && Math.abs(this.rotate - 225.0f) >= 2.0f) {
            return false;
        }
        return true;
    }

    private boolean isDrawVerticalDashLine() {
        if (Math.abs(this.rotate - 90.0f) >= 2.0f && Math.abs(this.rotate - 270.0f) >= 2.0f) {
            return false;
        }
        return true;
    }

    private boolean isDrawVerticalSolidLine() {
        if (Math.abs((getWidth() / 2.0f) - this.centerX) < DRAG_ADSORPTION_THRESHOLD) {
            return true;
        }
        return false;
    }

    private void startVibrator() {
        VibrationEffect createOneShot;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                createOneShot = VibrationEffect.createOneShot(30L, -1);
                this.vibrator.vibrate(createOneShot);
            } else {
                this.vibrator.vibrate(30L);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContentView, android.view.ViewGroup
    public void addView(View view) {
        WsStickerEditView wsStickerEditView;
        try {
            super.addView(view);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (view instanceof WsStickerEditView) {
            wsStickerEditView = (WsStickerEditView) view;
        } else {
            wsStickerEditView = null;
        }
        this.curStickerEditView = wsStickerEditView;
    }

    public WsStickerEditView getStickerEditView() {
        return this.curStickerEditView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        StickerEventDispatcher.getInstance().addStickerEventListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StickerEventDispatcher.getInstance().removeStickerEventListener(this);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isStickerTouching && canvas != null) {
            this.needVibrate = false;
            WsStickerEditView wsStickerEditView = this.curStickerEditView;
            if (wsStickerEditView != null && wsStickerEditView.isDrawGuideLine()) {
                TAVStickerOperationMode tAVStickerOperationMode = TAVStickerOperationMode.OP_DRAG;
                TAVStickerOperationMode tAVStickerOperationMode2 = this.operationMode;
                if (tAVStickerOperationMode == tAVStickerOperationMode2) {
                    drawSolidLine(canvas);
                } else if (TAVStickerOperationMode.OP_NONE != tAVStickerOperationMode2) {
                    drawDashLine(canvas);
                }
            }
            if (this.needVibrate && checkVibrateInterval()) {
                TLog.d(this.TAG, "startVibrator");
                startVibrator();
            }
        }
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener
    public void onStickerDataChanged(TAVSticker tAVSticker, TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19) {
        this.operationMode = tAVStickerOperationMode;
        this.centerX = f16;
        this.centerY = f17;
        this.rotate = f19;
        TLog.d(this.TAG, "onStickerDataChanged -> sticker : $sticker, centerX : $centerX, centerY : $centerY, scale : $scale, rotate : $rotate , operationMode" + tAVStickerOperationMode.name());
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener
    public void onStickerStatusChanged(TAVSticker tAVSticker, boolean z16, boolean z17) {
        this.isStickerTouching = z16;
        if (!z16) {
            this.operationMode = TAVStickerOperationMode.OP_NONE;
        }
        TLog.d(this.TAG, "onStickerStatusChanged -> sticker : $sticker, isTouching :" + z16);
    }

    public void setNeedOperate(boolean z16, MotionEvent motionEvent) {
        this.needOperate = z16;
        TAVStickerContentView.DispatchTouchEventListener dispatchTouchEventListener = this.dispatchTouchEventListener;
        if (dispatchTouchEventListener != null) {
            dispatchTouchEventListener.setInterceptEvent(Boolean.valueOf(!z16));
            if (motionEvent != null && z16) {
                motionEvent.offsetLocation(-this.parentLeft, -this.parentTop);
                this.dispatchTouchEventListener.onHackedTouchEvent(motionEvent);
            }
        }
    }

    public WsStickerContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = WsStickerContentView.class.getSimpleName();
        this.vibrator = (Vibrator) TAVStickerHelper.getContext().getSystemService("vibrator");
        this.parentTop = 0;
        this.parentLeft = 0;
        this.solidLinePaint = new Paint();
        this.solidPath = new Path();
        this.dashLinePaint = new Paint();
        this.dashPath = new Path();
        this.isStickerTouching = false;
        this.needOperate = true;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.rotate = 0.0f;
        this.operationMode = TAVStickerOperationMode.OP_NONE;
        this.needVibrate = false;
        this.lastVibrateTime = 0L;
        this.curStickerEditView = null;
        init();
    }

    public WsStickerContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.TAG = WsStickerContentView.class.getSimpleName();
        this.vibrator = (Vibrator) TAVStickerHelper.getContext().getSystemService("vibrator");
        this.parentTop = 0;
        this.parentLeft = 0;
        this.solidLinePaint = new Paint();
        this.solidPath = new Path();
        this.dashLinePaint = new Paint();
        this.dashPath = new Path();
        this.isStickerTouching = false;
        this.needOperate = true;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.rotate = 0.0f;
        this.operationMode = TAVStickerOperationMode.OP_NONE;
        this.needVibrate = false;
        this.lastVibrateTime = 0L;
        this.curStickerEditView = null;
        init();
    }
}
