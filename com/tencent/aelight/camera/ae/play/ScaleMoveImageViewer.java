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
public class ScaleMoveImageViewer extends ImageView implements View.OnTouchListener, View.OnClickListener {
    private static final float MAX_SCALE = 4.0f;
    private static final float MIN_SCALE = 0.2f;
    private static final String TAG = "ScaleMoveImageViewer";
    private float SOURCE_SCALE;
    private float currentX;
    private float currentY;
    private Matrix initMatrix;
    private boolean isAnimationPlaying;
    private boolean isImageSelected;
    private OnSaveScrollInfoListener listener;
    private Activity mActivity;
    private LayerDrawable mAnimationDrawable;
    private Drawable mAnimationSolidDrawable;
    private float mBaseDistance;
    private Matrix mCurrentMatrix;
    private boolean mIsSelecting;
    private Matrix mLastGestureMatrix;
    private Drawable mMaskCoverImage;
    private boolean mMovable;
    private NodeItem mNodeItem;
    private boolean mSigleDown;
    private ValueAnimator mValueAnimator;
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

    public ScaleMoveImageViewer(Context context) {
        this(context, null);
    }

    private void drawAnimationIfNeed(Canvas canvas) {
        if (this.isAnimationPlaying) {
            this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
            this.mAnimationDrawable.draw(canvas);
        }
    }

    private void drawCoverImage(Canvas canvas) {
        Drawable drawable = this.mMaskCoverImage;
        if (drawable != null) {
            drawable.setBounds(0, getHeight() / 2, getWidth(), getHeight());
            this.mMaskCoverImage.draw(canvas);
        }
    }

    private float getScale() {
        this.mCurrentMatrix.getValues(this.values);
        float[] fArr = this.values;
        return Math.min(fArr[0], fArr[4]);
    }

    private void onTouchScale(float f16, float f17, float f18) {
        float scale = getScale();
        if ((scale > 4.0f && f16 < 1.0f) || ((scale < 0.2f && f16 > 1.0f) || (f16 < 4.0f && f16 > 0.2f))) {
            this.mCurrentMatrix.postScale(f16, f16, f17, f18);
        }
        if (getScale() < this.SOURCE_SCALE) {
            this.mCurrentMatrix.set(this.mLastGestureMatrix);
        }
        ImagePositonManager.setShowPosition(getDrawable(), this.mCurrentMatrix, getWidth(), getHeight());
        setImageMatrix(this.mCurrentMatrix);
        updateCurrentMatrix();
        this.mLastGestureMatrix.set(this.mCurrentMatrix);
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
            drawCoverImage(canvas);
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
        nodeItem3.type = nodeItem.type;
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
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.aelight.camera.ae.play.ScaleMoveImageViewer.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ScaleMoveImageViewer.this.mAnimationSolidDrawable.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    ScaleMoveImageViewer.this.invalidate();
                }
            });
            this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.aelight.camera.ae.play.ScaleMoveImageViewer.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ScaleMoveImageViewer.this.isAnimationPlaying = false;
                    ScaleMoveImageViewer.this.invalidate();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ScaleMoveImageViewer.this.isAnimationPlaying = true;
                }
            });
        }
        if (this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator.start();
    }

    public void updateCropBitmap() {
        this.mNodeItem.matrix.getValues(this.values);
        float f16 = 0;
        float[] fArr = this.values;
        int i3 = (int) (((int) (f16 - fArr[2])) / fArr[0]);
        int i16 = (int) (((int) (f16 - fArr[5])) / fArr[4]);
        int width = (int) (getWidth() / this.values[0]);
        int height = (int) (getHeight() / this.values[4]);
        if (width > 0 && height > 0 && i3 >= 0 && i16 >= 0) {
            Bitmap bitmap = this.mNodeItem.cropBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                NodeItem nodeItem = this.mNodeItem;
                Bitmap bitmap2 = nodeItem.bitmap;
                Bitmap bitmap3 = nodeItem.cropBitmap;
                if (bitmap2 != bitmap3) {
                    bitmap3.recycle();
                }
            }
            Bitmap bitmap4 = this.mNodeItem.bitmap;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                try {
                    NodeItem nodeItem2 = this.mNodeItem;
                    nodeItem2.cropBitmap = Bitmap.createBitmap(nodeItem2.bitmap, i3, i16, width, height);
                } catch (IllegalArgumentException unused) {
                    NodeItem nodeItem3 = this.mNodeItem;
                    nodeItem3.cropBitmap = nodeItem3.bitmap;
                } catch (OutOfMemoryError unused2) {
                    NodeItem nodeItem4 = this.mNodeItem;
                    nodeItem4.cropBitmap = nodeItem4.bitmap;
                }
            }
            OnSaveScrollInfoListener onSaveScrollInfoListener = this.listener;
            if (onSaveScrollInfoListener != null) {
                onSaveScrollInfoListener.onSaveScrollInfo(this.mNodeItem);
                return;
            }
            return;
        }
        Bitmap bitmap5 = this.mNodeItem.cropBitmap;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.mNodeItem.cropBitmap.recycle();
        }
        NodeItem nodeItem5 = this.mNodeItem;
        Bitmap bitmap6 = nodeItem5.bitmap;
        if (bitmap6 != null) {
            nodeItem5.cropBitmap = Bitmap.createBitmap(bitmap6, 0, 0, bitmap6.getWidth() - 1, this.mNodeItem.bitmap.getHeight() - 1);
        }
        OnSaveScrollInfoListener onSaveScrollInfoListener2 = this.listener;
        if (onSaveScrollInfoListener2 != null) {
            onSaveScrollInfoListener2.onSaveScrollInfo(this.mNodeItem);
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
        this.SOURCE_SCALE = max;
        this.mCurrentMatrix.postTranslate(r6 - (i17 / 2), r7 - (i18 / 2));
        this.mCurrentMatrix.postScale(max, max, i3 / 2, i16 / 2);
        setImageMatrix(this.mCurrentMatrix);
        this.mLastGestureMatrix.set(this.mCurrentMatrix);
        updateCurrentMatrix();
    }

    public ScaleMoveImageViewer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initMatrix = new Matrix();
        this.mCurrentMatrix = new Matrix();
        this.mLastGestureMatrix = new Matrix();
        this.values = new float[9];
        this.mNodeItem = new NodeItem();
        this.isImageSelected = false;
        this.mIsSelecting = false;
        this.mMovable = false;
        this.mSigleDown = true;
        this.mBaseDistance = 0.0f;
        this.isAnimationPlaying = false;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.mActivity = (Activity) context;
        setOnClickListener(this);
        clearSeclected();
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.isq);
        this.mAnimationDrawable = layerDrawable;
        this.mAnimationSolidDrawable = layerDrawable.findDrawableByLayerId(R.id.ruu);
        this.mMaskCoverImage = getResources().getDrawable(R.drawable.is8);
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
        int action = motionEvent.getAction();
        if (action == 0) {
            this.touchDownX = motionEvent.getRawX();
            this.touchDownY = motionEvent.getRawY();
            this.mSigleDown = true;
            this.mBaseDistance = 0.0f;
        } else if (action == 1) {
            this.touchUpX = motionEvent.getRawX();
            this.touchUpY = motionEvent.getRawY();
            this.prePointerCount = 0;
            if (Math.abs(this.touchUpX - this.touchDownX) <= 10.0f && Math.abs(this.touchDownY - this.touchUpY) <= 10.0f) {
                if (this.mSigleDown) {
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
            ImagePositonManager.setMovePosition(getDrawable(), this.mCurrentMatrix, this.currentX - this.preX, this.currentY - this.preY, getWidth(), getHeight());
            setImageMatrix(this.mCurrentMatrix);
            updateCurrentMatrix();
            this.preX = this.currentX;
            this.preY = this.currentY;
            if (motionEvent.getPointerCount() == 2) {
                float x16 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                float y16 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                float x17 = motionEvent.getX(0) - motionEvent.getX(1);
                float y17 = motionEvent.getY(0) - motionEvent.getY(1);
                float sqrt = (float) Math.sqrt((x17 * x17) + (y17 * y17));
                float f19 = this.mBaseDistance;
                if (f19 == 0.0f) {
                    this.mBaseDistance = sqrt;
                } else if (Math.abs(sqrt - f19) >= 10.0f) {
                    float f26 = sqrt / this.mBaseDistance;
                    this.mBaseDistance = sqrt;
                    onTouchScale(f26, x16, y16);
                }
            }
        } else if (action == 5) {
            this.mSigleDown = false;
        }
        return true;
    }
}
