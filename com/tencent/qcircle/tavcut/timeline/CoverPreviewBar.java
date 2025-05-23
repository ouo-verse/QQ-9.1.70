package com.tencent.qcircle.tavcut.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer;

/* loaded from: classes22.dex */
public class CoverPreviewBar extends FrameLayout {
    public static final int ALL = 0;
    private static final String TAG = "CoverPreviewBar";
    public static final int TOP = 1;
    Bitmap currCover;
    private ImageView ivCover;
    private int mLeftEdge;
    private int mLeftSpace;
    private OnPreviewBarSlideListener mOnSliderSlideListener;
    private float mProgress;
    private int mRightEdge;
    private int mTimeLineLength;
    private int mTouchDownX;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface OnPreviewBarSlideListener {
        void onProgressChanged(CoverPreviewBar coverPreviewBar, float f16, int i3);

        void onStartTouchSlide(CoverPreviewBar coverPreviewBar);

        void onStopTouchSlide(CoverPreviewBar coverPreviewBar);
    }

    public CoverPreviewBar(Context context) {
        super(context);
        this.mLeftEdge = 0;
        this.mRightEdge = getContext().getResources().getDisplayMetrics().widthPixels;
        this.currCover = null;
        initViews();
    }

    private float calculateProgress(int i3) {
        int i16 = this.mLeftEdge;
        return ((i3 - i16) * 1.0f) / (this.mRightEdge - i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extractBitmapFromPlayer(MoviePlayer moviePlayer) {
        Bitmap bitmap = moviePlayer.getTextureView().getBitmap();
        if (moviePlayer.getTavComposition() != null) {
            CGSize renderSize = moviePlayer.getTavComposition().getRenderSize();
            float f16 = renderSize.height / renderSize.width;
            if (f16 > bitmap.getHeight() / bitmap.getWidth()) {
                int height = (int) (bitmap.getHeight() / f16);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - height) / 2, 0, height, bitmap.getHeight());
                this.currCover = createBitmap;
                setImageBitmap(createBitmap);
                return;
            }
            int width = (int) (bitmap.getWidth() * f16);
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - width) / 2, bitmap.getWidth(), width);
            this.currCover = createBitmap2;
            setImageBitmap(createBitmap2);
            return;
        }
        this.currCover = bitmap;
        setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInternalParams() {
        this.mLeftEdge = this.mLeftSpace;
        int measuredWidth = getMeasuredWidth();
        this.mWidth = measuredWidth;
        this.mRightEdge = (this.mLeftEdge + this.mTimeLineLength) - measuredWidth;
        moveSliderToPosition(calculateTransXByProgress(this.mProgress));
    }

    private void initViews() {
        ImageView imageView = new ImageView(getContext());
        this.ivCover = imageView;
        addView(imageView, -1, -1);
    }

    private void updateSliderPosition(int i3) {
        Log.d(TAG, "updateSliderPosition: leftEdge = " + this.mLeftEdge + " | rightEdge = " + this.mRightEdge);
        int i16 = this.mLeftEdge;
        if (i3 < i16 || i3 > (i16 = this.mRightEdge)) {
            i3 = i16;
        }
        float calculateProgress = calculateProgress(i3) * 100.0f;
        this.mProgress = calculateProgress;
        OnPreviewBarSlideListener onPreviewBarSlideListener = this.mOnSliderSlideListener;
        if (onPreviewBarSlideListener != null) {
            onPreviewBarSlideListener.onProgressChanged(this, calculateProgress, i3);
        }
        setTranslationX(i3);
    }

    public void bindPlayer(final MoviePlayer moviePlayer) {
        moviePlayer.addPlayerListener(new IPlayer.PlayerListener() { // from class: com.tencent.qcircle.tavcut.timeline.CoverPreviewBar.2
            @Override // com.tencent.tav.player.IPlayer.PlayerListener
            public void onStatusChanged(IPlayer.PlayerStatus playerStatus) {
                if (playerStatus == IPlayer.PlayerStatus.IDLE || playerStatus == IPlayer.PlayerStatus.PAUSED) {
                    CoverPreviewBar.this.extractBitmapFromPlayer(moviePlayer);
                }
            }

            @Override // com.tencent.tav.player.IPlayer.PlayerListener
            public void onPositionChanged(CMTime cMTime) {
            }
        });
        moviePlayer.addTextureChangeListener(new MoviePlayer.SurfaceTextureChangeListener() { // from class: com.tencent.qcircle.tavcut.timeline.CoverPreviewBar.3
            @Override // com.tencent.qcircle.tavcut.player.MoviePlayer.SurfaceTextureChangeListener
            public void onTextureChange(SurfaceTexture surfaceTexture) {
                CoverPreviewBar.this.extractBitmapFromPlayer(moviePlayer);
            }
        });
    }

    public int calculateTransXByProgress(float f16) {
        int i3 = this.mRightEdge;
        return (int) (((f16 / 100.0f) * (i3 - r1)) + this.mLeftEdge);
    }

    public Bitmap getCurrCover() {
        return this.currCover;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void initCoverSlider(int i3, int i16, int i17, float f16) {
        this.mLeftSpace = i3;
        this.mTimeLineLength = i17;
        this.mProgress = f16;
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.CoverPreviewBar.1
            @Override // java.lang.Runnable
            public void run() {
                CoverPreviewBar.this.initInternalParams();
            }
        });
    }

    public void moveSliderToPosition(int i3) {
        updateSliderPosition(i3);
        OnPreviewBarSlideListener onPreviewBarSlideListener = this.mOnSliderSlideListener;
        if (onPreviewBarSlideListener != null) {
            onPreviewBarSlideListener.onStopTouchSlide(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r0 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    updateSliderPosition((int) (((int) (motionEvent.getRawX() - this.mTouchDownX)) + getTranslationX()));
                }
            }
            OnPreviewBarSlideListener onPreviewBarSlideListener = this.mOnSliderSlideListener;
            if (onPreviewBarSlideListener != null) {
                onPreviewBarSlideListener.onStopTouchSlide(this);
            }
        } else {
            this.mTouchDownX = (int) motionEvent.getRawX();
            OnPreviewBarSlideListener onPreviewBarSlideListener2 = this.mOnSliderSlideListener;
            if (onPreviewBarSlideListener2 != null) {
                onPreviewBarSlideListener2.onStartTouchSlide(this);
            }
        }
        this.mTouchDownX = (int) motionEvent.getRawX();
        return true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        ImageView imageView = this.ivCover;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setOnSliderSlideListener(OnPreviewBarSlideListener onPreviewBarSlideListener) {
        this.mOnSliderSlideListener = onPreviewBarSlideListener;
    }

    public void setPreviewBarView(ImageView imageView) {
        removeView(this.ivCover);
        this.ivCover = imageView;
        addView(imageView, -1, -1);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.ivCover;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public void updateProgress(float f16) {
        this.mProgress = f16;
        moveSliderToPosition(calculateTransXByProgress(f16));
    }

    public CoverPreviewBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLeftEdge = 0;
        this.mRightEdge = getContext().getResources().getDisplayMetrics().widthPixels;
        this.currCover = null;
        initViews();
    }

    public CoverPreviewBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mLeftEdge = 0;
        this.mRightEdge = getContext().getResources().getDisplayMetrics().widthPixels;
        this.currCover = null;
        initViews();
    }
}
