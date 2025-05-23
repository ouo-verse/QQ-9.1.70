package com.tencent.aelight.camera.ae.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FaceImageViewer extends ImageView implements View.OnTouchListener, View.OnClickListener {
    private static final float ADD_ICON_WIDTH = 68.0f;
    private static final float CENTER_VIEW_WIDTH = 720.0f;
    private static final String TAG = "FaceImageViewer";
    private final int COMBINED_ACTION_PROTECT_DURATION;
    private final int DRAG;
    private final int MAX_SINGLE_CLICK_DURATION;
    private final int MIN_MOVE_EVENT_COUNT_IN_COMBINED_ACTION;
    private final int NONE;
    private final int ZOOM;
    private long actionDownTime;
    private long combinedActionProtectExpireAt;
    private float currentX;
    private float currentY;
    private Matrix initMatrix;
    private boolean isAnimationPlaying;
    private boolean isCombinedAction;
    private boolean isFirstDraw;
    private boolean isImageSelected;
    private OnSaveScrollInfoListener listener;
    private Activity mActivity;
    private LayerDrawable mAnimationDrawable;
    private Drawable mAnimationSolidDrawable;
    private float mBaseDistance;
    private int mCenterViewWidth;
    private Matrix mCurrentMatrix;
    private boolean mIsSelecting;
    private float mLastRotation;
    private boolean mMovable;
    private NodeItem mNodeItem;
    private boolean mSigleDown;
    private ValueAnimator mValueAnimator;
    private int mode;
    private int moveEventCount;
    private int prePointerCount;
    private float preX;
    private float preY;
    private float touchDownX;
    private float touchDownY;
    private float touchUpX;
    private float touchUpY;
    private float[] values;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnSaveScrollInfoListener {
        void onSaveScrollInfo(NodeItem nodeItem);
    }

    public FaceImageViewer(Context context) {
        this(context, null);
    }

    private void drawAnimationIfNeed(Canvas canvas) {
        if (this.isAnimationPlaying) {
            this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
            this.mAnimationDrawable.draw(canvas);
        }
    }

    private float getScale() {
        this.mCurrentMatrix.getValues(this.values);
        float[] fArr = this.values;
        return Math.min(fArr[0], fArr[4]);
    }

    private void onTouchScaleAndRotate(float f16, float f17, float f18, float f19) {
        this.mCurrentMatrix.postScale(f16, f16, f17, f18);
        ImagePositonManager.setShowPosition(getDrawable(), this.mCurrentMatrix, getWidth(), getHeight());
        this.mCurrentMatrix.postRotate(f19, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.mCurrentMatrix);
        updateCurrentMatrix();
    }

    private void operateMoveEvent(MotionEvent motionEvent) {
        int i3 = this.mode;
        if (i3 == 1) {
            ImagePositonManager.setMovePosition(getDrawable(), this.mCurrentMatrix, this.currentX - this.preX, this.currentY - this.preY, getWidth(), getHeight());
            setImageMatrix(this.mCurrentMatrix);
            updateCurrentMatrix();
            this.preX = this.currentX;
            this.preY = this.currentY;
            return;
        }
        if (i3 != 2) {
            return;
        }
        float x16 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        float y16 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        float x17 = motionEvent.getX(0) - motionEvent.getX(1);
        float y17 = motionEvent.getY(0) - motionEvent.getY(1);
        float sqrt = (float) Math.sqrt((x17 * x17) + (y17 * y17));
        float f16 = this.mBaseDistance;
        if (f16 == 0.0f) {
            this.mBaseDistance = sqrt;
            return;
        }
        if (Math.abs(sqrt - f16) >= 1.0f) {
            float f17 = sqrt / this.mBaseDistance;
            this.mBaseDistance = sqrt;
            float calcRotation = calcRotation(motionEvent) - this.mLastRotation;
            this.mLastRotation = calcRotation(motionEvent);
            onTouchScaleAndRotate(f17, x16, y16, calcRotation);
        }
    }

    private void updateCurrentMatrix() {
        Matrix matrix;
        NodeItem nodeItem = this.mNodeItem;
        if (nodeItem == null || (matrix = nodeItem.matrix) == null) {
            return;
        }
        matrix.set(this.mCurrentMatrix);
    }

    public void clearBitmaps() {
        Bitmap bitmap = this.mNodeItem.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mNodeItem.bitmap.recycle();
        }
        Bitmap bitmap2 = this.mNodeItem.cropBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mNodeItem.cropBitmap.recycle();
        }
        setImageBitmap(null);
    }

    public NodeItem getNode() {
        return this.mNodeItem;
    }

    public int getNodeGroupID() {
        return this.mNodeItem.nodeGroupID;
    }

    public int getNodeID() {
        return this.mNodeItem.nodeID;
    }

    public boolean isImageSelected() {
        return this.isImageSelected;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.mIsSelecting) {
            activeSelected();
            com.tencent.aelight.camera.ae.report.b.b().v1();
            ((IPicChooseJumpUtil) QRoute.api(IPicChooseJumpUtil.class)).jumpWithSinglePicResult(this.mActivity, this.mNodeItem.nodeID);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        NodeItem nodeItem = this.mNodeItem;
        if (nodeItem.once) {
            updateMatrix(getWidth(), getHeight());
        } else {
            this.mCurrentMatrix.set(nodeItem.matrix);
            setImageMatrix(this.mCurrentMatrix);
        }
        try {
            super.onDraw(canvas);
            drawAnimationIfNeed(canvas);
        } catch (Throwable unused) {
        }
    }

    public void setImageSelected(boolean z16) {
        this.isImageSelected = z16;
    }

    public void setMovable(boolean z16) {
        this.mMovable = z16;
        if (z16) {
            setOnTouchListener(this);
        } else {
            setOnTouchListener(null);
        }
    }

    public void setNodeBitmap(Bitmap bitmap) {
        NodeItem nodeItem = this.mNodeItem;
        nodeItem.bitmap = bitmap;
        nodeItem.once = true;
        OnSaveScrollInfoListener onSaveScrollInfoListener = this.listener;
        if (onSaveScrollInfoListener != null) {
            onSaveScrollInfoListener.onSaveScrollInfo(nodeItem);
        }
    }

    public void setNodeInfo(NodeItem nodeItem) {
        NodeItem nodeItem2 = this.mNodeItem;
        nodeItem2.nodeID = nodeItem.nodeID;
        nodeItem2.nodeGroupID = nodeItem.nodeGroupID;
        nodeItem2.once = nodeItem.once;
        nodeItem2.matrix.set(nodeItem.matrix);
        NodeItem nodeItem3 = this.mNodeItem;
        nodeItem3.bitmap = nodeItem.bitmap;
        nodeItem3.maskRect = nodeItem.maskRect;
        nodeItem3.zIndex = nodeItem.zIndex;
    }

    public void setOnSaveScrollInfoListener(OnSaveScrollInfoListener onSaveScrollInfoListener) {
        this.listener = onSaveScrollInfoListener;
    }

    public void startAnimaterIfNeed() {
        if (this.mValueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(150, 0);
            this.mValueAnimator = ofInt;
            ofInt.setDuration(700L);
            this.mValueAnimator.setRepeatCount(4);
            this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
            this.mValueAnimator.setRepeatMode(2);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.aelight.camera.ae.play.FaceImageViewer.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FaceImageViewer.this.mAnimationSolidDrawable.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    FaceImageViewer.this.invalidate();
                }
            });
            this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.aelight.camera.ae.play.FaceImageViewer.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FaceImageViewer.this.isAnimationPlaying = false;
                    FaceImageViewer.this.invalidate();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    FaceImageViewer.this.isAnimationPlaying = true;
                }
            });
        }
        if (this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator.start();
    }

    public void transformCurrentMatrix(float f16, float f17, float f18, float f19) {
        this.initMatrix.reset();
        this.mCurrentMatrix.set(this.initMatrix);
        this.mCurrentMatrix.postTranslate(f18, f19);
        this.mCurrentMatrix.postScale(f16, f16, getWidth() / 2, getHeight() / 2);
        this.mCurrentMatrix.postRotate(f17, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.mCurrentMatrix);
        updateCurrentMatrix();
        this.mNodeItem.once = false;
    }

    public void updateCropBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        if (createBitmap != null && !createBitmap.isRecycled()) {
            this.mNodeItem.cropBitmap = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            createBitmap.recycle();
        }
        OnSaveScrollInfoListener onSaveScrollInfoListener = this.listener;
        if (onSaveScrollInfoListener != null) {
            onSaveScrollInfoListener.onSaveScrollInfo(this.mNodeItem);
        }
    }

    public void updateMatrix(int i3, int i16) {
        int i17;
        int i18;
        Bitmap bitmap;
        this.initMatrix.reset();
        this.mCurrentMatrix.set(this.initMatrix);
        NodeItem nodeItem = this.mNodeItem;
        if (nodeItem != null) {
            nodeItem.once = false;
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            i17 = drawable.getIntrinsicWidth();
            i18 = drawable.getIntrinsicHeight();
        } else {
            NodeItem nodeItem2 = this.mNodeItem;
            if (nodeItem2 == null || (bitmap = nodeItem2.bitmap) == null) {
                i17 = 720;
                i18 = 1280;
            } else {
                i17 = bitmap.getWidth();
                i18 = this.mNodeItem.bitmap.getHeight();
            }
        }
        float max = Math.max((i3 * 1.0f) / i17, (i16 * 1.0f) / i18);
        this.mCurrentMatrix.postTranslate(r6 - (i17 / 2), r7 - (i18 / 2));
        this.mCurrentMatrix.postScale(max, max, i3 / 2, i16 / 2);
        setImageMatrix(this.mCurrentMatrix);
        updateCurrentMatrix();
    }

    public FaceImageViewer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NONE = 0;
        this.DRAG = 1;
        this.ZOOM = 2;
        this.mode = 0;
        this.MAX_SINGLE_CLICK_DURATION = 100;
        this.COMBINED_ACTION_PROTECT_DURATION = 300;
        this.MIN_MOVE_EVENT_COUNT_IN_COMBINED_ACTION = 5;
        this.initMatrix = new Matrix();
        this.mCurrentMatrix = new Matrix();
        this.values = new float[9];
        this.moveEventCount = 0;
        this.isCombinedAction = false;
        this.mLastRotation = 0.0f;
        this.mNodeItem = new NodeItem();
        this.isImageSelected = false;
        this.mIsSelecting = false;
        this.mMovable = false;
        this.mSigleDown = true;
        this.mBaseDistance = 0.0f;
        this.isFirstDraw = true;
        this.mCenterViewWidth = 0;
        this.isAnimationPlaying = false;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.mActivity = (Activity) context;
        setOnClickListener(this);
        clearSeclected();
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.isq);
        this.mAnimationDrawable = layerDrawable;
        this.mAnimationSolidDrawable = layerDrawable.findDrawableByLayerId(R.id.ruu);
    }

    private float calcRotation(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    public void activeSelected() {
        this.mIsSelecting = true;
    }

    public void clearSeclected() {
        this.mIsSelecting = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.currentX = 0.0f;
        this.currentY = 0.0f;
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            this.currentX += motionEvent.getX();
            this.currentY += motionEvent.getY();
        }
        float f16 = pointerCount;
        float f17 = this.currentX / f16;
        this.currentX = f17;
        float f18 = this.currentY / f16;
        this.currentY = f18;
        if (pointerCount != this.prePointerCount) {
            this.preX = f17;
            this.preY = f18;
            this.prePointerCount = pointerCount;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.actionDownTime = System.currentTimeMillis();
            this.touchDownX = motionEvent.getRawX();
            this.touchDownY = motionEvent.getRawY();
            this.mSigleDown = true;
            this.isCombinedAction = false;
            this.moveEventCount = 0;
            this.mBaseDistance = 0.0f;
            this.mode = 1;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.actionDownTime;
            if (this.moveEventCount > 5) {
                this.isCombinedAction = true;
            }
            if (this.isCombinedAction) {
                this.combinedActionProtectExpireAt = currentTimeMillis + 300;
            } else if (currentTimeMillis <= this.combinedActionProtectExpireAt) {
                this.mSigleDown = false;
            }
            this.touchUpX = motionEvent.getRawX();
            this.touchUpY = motionEvent.getRawY();
            this.prePointerCount = 0;
            if (Math.abs(this.touchUpX - this.touchDownX) <= 10.0f && Math.abs(this.touchDownY - this.touchUpY) <= 10.0f) {
                if (this.mSigleDown && j3 < 100) {
                    try {
                        Field declaredField = View.class.getDeclaredField("mListenerInfo");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(view);
                        Field declaredField2 = obj.getClass().getDeclaredField("mOnClickListener");
                        declaredField2.setAccessible(true);
                        Object obj2 = declaredField2.get(obj);
                        if (obj2 != null && (obj2 instanceof View.OnClickListener)) {
                            ((View.OnClickListener) obj2).onClick(view);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } else {
                OnSaveScrollInfoListener onSaveScrollInfoListener = this.listener;
                if (onSaveScrollInfoListener != null) {
                    onSaveScrollInfoListener.onSaveScrollInfo(this.mNodeItem);
                }
            }
        } else if (action == 2) {
            operateMoveEvent(motionEvent);
            this.moveEventCount++;
        } else if (action == 5) {
            this.mSigleDown = false;
            this.mLastRotation = calcRotation(motionEvent);
            this.isCombinedAction = true;
            this.mode = 2;
        } else if (action == 6) {
            this.mode = 0;
        }
        return true;
    }
}
