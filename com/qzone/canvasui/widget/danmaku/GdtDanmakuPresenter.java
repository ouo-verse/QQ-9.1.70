package com.qzone.canvasui.widget.danmaku;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.Pools;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* loaded from: classes39.dex */
public class GdtDanmakuPresenter extends RelativeLayout {
    private static final int START_OFFSET = 600;
    private static final String TAG = "GdtDanmakuPresenter";
    private String BACKGROUND_COLOR;
    private int DANMAKU_INTERVAL;
    private int MAX_CACHE_SIZE;
    private int MAX_SHOWN_TEXT_NUM;
    private float SPEED;
    private String TEXT_COLOR;
    private int TEXT_SIZE;
    private int TRACT_INTERVAL;
    private int TRACT_NUM;
    private Pools.SimplePool<GdtDanmakuItemView> mCache;
    private Context mContext;
    private GdtDanmakuModel mDanmakuModel;
    private boolean mIsRunning;
    private DanmakuRunnable[] mRunnables;
    private int mTractLength;
    private final Handler mUIHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class DanmakuRunnable implements Runnable {
        private int mTrackIndex;

        public DanmakuRunnable(int i3) {
            this.mTrackIndex = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(GdtDanmakuPresenter.TAG, "create new danmaku item in row " + this.mTrackIndex);
            GdtDanmakuItemView acquireDanmakuView = GdtDanmakuPresenter.this.acquireDanmakuView();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            acquireDanmakuView.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredWidth = acquireDanmakuView.getMeasuredWidth();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) acquireDanmakuView.getLayoutParams();
            layoutParams.topMargin = this.mTrackIndex * (acquireDanmakuView.getMeasuredHeight() + AdUIUtils.dp2px(GdtDanmakuPresenter.this.TRACT_INTERVAL, GdtDanmakuPresenter.this.getResources()));
            acquireDanmakuView.setLayoutParams(layoutParams);
            GdtDanmakuPresenter.this.addView(acquireDanmakuView);
            acquireDanmakuView.start();
            GdtDanmakuPresenter.this.mUIHandler.postDelayed(GdtDanmakuPresenter.this.mRunnables[this.mTrackIndex], (int) ((GdtDanmakuPresenter.this.DANMAKU_INTERVAL + AdUIUtils.px2dp(GdtDanmakuPresenter.this.getContext(), measuredWidth)) / GdtDanmakuPresenter.this.SPEED));
        }
    }

    public GdtDanmakuPresenter(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GdtDanmakuItemView acquireDanmakuView() {
        final GdtDanmakuItemView acquire = this.mCache.acquire();
        if (acquire == null) {
            acquire = new GdtDanmakuItemView(this.mContext);
        }
        acquire.setTextSize(this.TEXT_SIZE);
        acquire.setClickable(false);
        acquire.setTextColor(Color.parseColor(this.TEXT_COLOR));
        GradientDrawable gradientDrawable = (GradientDrawable) acquire.getBackground();
        gradientDrawable.setColor(Color.parseColor(this.BACKGROUND_COLOR));
        acquire.setBackground(gradientDrawable);
        String nextContentInOrder = this.mDanmakuModel.getNextContentInOrder();
        if (nextContentInOrder.length() > this.MAX_SHOWN_TEXT_NUM) {
            nextContentInOrder = nextContentInOrder.substring(0, this.MAX_SHOWN_TEXT_NUM) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        acquire.setText(nextContentInOrder);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        acquire.measure(makeMeasureSpec, makeMeasureSpec);
        int dp2px = AdUIUtils.dp2px(this.mTractLength, getResources()) + acquire.getMeasuredWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(acquire, "translationX", AdUIUtils.dp2px(this.mTractLength, getResources()), -r2);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.qzone.canvasui.widget.danmaku.GdtDanmakuPresenter.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z16) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GdtDanmakuPresenter.this.cacheDanmakuView(acquire);
                GdtDanmakuPresenter.this.removeView(acquire);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z16) {
                onAnimationStart(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.setDuration((int) (AdUIUtils.px2dp(getContext(), dp2px) / this.SPEED));
        acquire.setAnimator(ofFloat);
        return acquire;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheDanmakuView(GdtDanmakuItemView gdtDanmakuItemView) {
        try {
            this.mCache.release(gdtDanmakuItemView);
        } catch (IllegalStateException unused) {
        }
    }

    private void reset() {
        DanmakuRunnable[] danmakuRunnableArr = this.mRunnables;
        if (danmakuRunnableArr != null) {
            for (DanmakuRunnable danmakuRunnable : danmakuRunnableArr) {
                this.mUIHandler.removeCallbacks(danmakuRunnable);
            }
        }
        removeAllViews();
        clearDisappearingChildren();
    }

    public float getDanmakuInterval() {
        return this.DANMAKU_INTERVAL;
    }

    public int getMaxCacheSize() {
        return this.MAX_CACHE_SIZE;
    }

    public int getMaxShownTextNum() {
        return this.MAX_SHOWN_TEXT_NUM;
    }

    public float getSpeed() {
        return this.SPEED;
    }

    public int getTextSize() {
        return this.TEXT_SIZE;
    }

    public int getTractInterval() {
        return this.TRACT_INTERVAL;
    }

    public int getTractNum() {
        return this.TRACT_NUM;
    }

    public GdtDanmakuPresenter initDanmakuItemViews(int i3, String[] strArr) {
        this.mDanmakuModel.setContents(strArr);
        this.mTractLength = AdUIUtils.px2dp(getContext(), i3);
        return this;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public GdtDanmakuPresenter setDanmakuInterval(int i3) {
        this.DANMAKU_INTERVAL = i3;
        return this;
    }

    public GdtDanmakuPresenter setMaxCacheSize(int i3) {
        this.MAX_CACHE_SIZE = i3;
        return this;
    }

    public GdtDanmakuPresenter setMaxShownTextNum(int i3) {
        this.MAX_SHOWN_TEXT_NUM = i3;
        return this;
    }

    public GdtDanmakuPresenter setSpeed(float f16) {
        this.SPEED = f16;
        return this;
    }

    public GdtDanmakuPresenter setTextSize(int i3) {
        this.TEXT_SIZE = i3;
        return this;
    }

    public GdtDanmakuPresenter setTractInterval(int i3) {
        this.TRACT_INTERVAL = i3;
        return this;
    }

    public GdtDanmakuPresenter setTractNum(int i3) {
        this.TRACT_NUM = i3;
        return this;
    }

    public boolean start() {
        reset();
        this.mIsRunning = false;
        if (this.mDanmakuModel.isEmpty() || this.mTractLength == -1) {
            return false;
        }
        if (this.mCache == null) {
            this.mCache = new Pools.SimplePool<>(this.MAX_CACHE_SIZE);
        }
        DanmakuRunnable[] danmakuRunnableArr = this.mRunnables;
        if (danmakuRunnableArr != null) {
            for (DanmakuRunnable danmakuRunnable : danmakuRunnableArr) {
                this.mUIHandler.removeCallbacks(danmakuRunnable);
            }
        }
        this.mRunnables = new DanmakuRunnable[this.TRACT_NUM];
        for (int i3 = 0; i3 < this.TRACT_NUM; i3++) {
            this.mRunnables[i3] = new DanmakuRunnable(i3);
            this.mUIHandler.postDelayed(this.mRunnables[i3], i3 * 600);
        }
        this.mIsRunning = true;
        Log.i(TAG, "danmaku start");
        return true;
    }

    public void stop() {
        reset();
        this.mIsRunning = false;
        GdtDanmakuModel gdtDanmakuModel = this.mDanmakuModel;
        if (gdtDanmakuModel != null) {
            gdtDanmakuModel.reset();
        }
        Log.i(TAG, "danmaku is stopped");
    }

    public GdtDanmakuPresenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.TRACT_NUM = 2;
        this.TRACT_INTERVAL = 10;
        this.DANMAKU_INTERVAL = 20;
        this.SPEED = 0.1f;
        this.TEXT_SIZE = 14;
        this.TEXT_COLOR = "#FFFFFFFF";
        this.BACKGROUND_COLOR = "#993C3C3C";
        this.MAX_SHOWN_TEXT_NUM = 10;
        this.MAX_CACHE_SIZE = 10;
        this.mTractLength = -1;
        this.mDanmakuModel = new GdtDanmakuModel();
        this.mContext = context;
    }
}
