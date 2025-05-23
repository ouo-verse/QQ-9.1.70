package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mtt.supportui.views.recyclerview.IRecyclerViewFooter;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDDefaultFooter extends HippyTKDFooterView implements HippyTKDInvalidateCallback, IRecyclerViewFooter {
    private static final int BALL_COUNT = 3;
    private static final String TAG = "DefaultFooterView";
    private int ballColor;
    private int mBallColorId;
    private AnimatingBall[] mBalls;
    private Integer mCustomBallColor;
    private String mCustomMessage;
    private boolean mIsAttached;
    public int mLoadingStatus;
    public int mPullDownToRefreshDistanceBetweenIconText;
    public Drawable mPullDownToRefreshFailIcon;
    public Drawable mPullDownToRefreshSucIcon;
    private boolean mRefreshing;
    private int mShowLoadingDelayTime;
    private PullToRefreshListener refreshListener;

    public HippyTKDDefaultFooter(Context context) {
        super(context);
        this.mLoadingStatus = 0;
        this.mCustomMessage = null;
        this.ballColor = ResourceUtil.getColor(R.color.cvd);
        this.mCustomBallColor = null;
        this.mPullDownToRefreshDistanceBetweenIconText = ImmersiveUtils.dpToPx(8.0f);
        this.mShowLoadingDelayTime = 0;
        this.mBalls = new AnimatingBall[3];
        for (int i3 = 0; i3 < 3; i3++) {
            this.mBalls[i3] = new AnimatingBall(this, i3);
        }
        setFocusable(true);
        setBallColor(0);
        setTextSize(ImmersiveUtils.dpToPx(12.0f));
        setTextMargins(this.mPullDownToRefreshDistanceBetweenIconText, 0, 0, 0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.dpToPx(36.0f)));
        setFocusable(true);
        setWillNotDraw(false);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.IRecyclerViewFooter
    public int getLoadingStatus() {
        return this.mLoadingStatus;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.mIsAttached = true;
        if (this.mRefreshing) {
            Log.d(TAG, hashCode() + ",doRefresh");
            for (int i3 = 0; i3 < 3; i3++) {
                this.mBalls[i3].animateRefresh();
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mIsAttached = false;
        for (int i3 = 0; i3 < 3; i3++) {
            this.mBalls[i3].stopAllAnimators();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRefreshing) {
            int width = (getWidth() - ((AnimatingBall.BALL_SIZE * 2) + (AnimatingBall.BALL_MARGIN_H * 2))) / 2;
            int i3 = 0;
            while (true) {
                AnimatingBall[] animatingBallArr = this.mBalls;
                if (i3 < animatingBallArr.length) {
                    animatingBallArr[i3].draw(canvas, 0, getHeight() / 2, width);
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            super.onDraw(canvas);
        }
    }

    public void setBallColor(int i3) {
        if (i3 != 0) {
            this.ballColor = ResourceUtil.getColor(i3);
            this.mBallColorId = i3;
        } else {
            Integer num = this.mCustomBallColor;
            if (num != null) {
                this.ballColor = num.intValue();
            } else {
                this.ballColor = ResourceUtil.getColor(R.color.cvd);
            }
            this.mBallColorId = 0;
        }
        for (int i16 = 0; i16 < 3; i16++) {
            this.mBalls[i16].setInitialColor(this.ballColor);
        }
        this.mPullDownToRefreshSucIcon = UIBitmapUtils.getColorImage(ResourceUtil.getBitmap(R.drawable.f162595mh3), this.ballColor);
        setTextColor(this.ballColor);
    }

    public void setCustomBallColor(Integer num) {
        this.mCustomBallColor = num;
        setBallColor(this.mBallColorId);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.IRecyclerViewFooter
    public void setLoadingStatus(int i3) {
        setLoadingStatus(i3, -1);
    }

    public void setPullToRefreshListener(PullToRefreshListener pullToRefreshListener) {
        this.refreshListener = pullToRefreshListener;
    }

    public void setShowLoadingDelayTime(int i3) {
        this.mShowLoadingDelayTime = i3;
    }

    public void startLoading() {
        setTextVisisbility(4);
        setImageVisibility(4);
        Log.d(TAG, hashCode() + ",startLoading");
        if (this.mRefreshing) {
            return;
        }
        if (this.mIsAttached) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.mBalls[i3].animateRefresh();
            }
            invalidate();
        }
        this.mRefreshing = true;
    }

    public void stopLoading() {
        setTextVisisbility(0);
        setImageVisibility(0);
        Log.d(TAG, this + ",stopLoading!!!");
        if (!this.mRefreshing) {
            return;
        }
        Log.d(TAG, hashCode() + ",stoped");
        this.mRefreshing = false;
    }

    public void setLoadingStatus(int i3, String str) {
        this.mCustomMessage = str;
        setLoadingStatus(i3, -1);
    }

    public void setLoadingStatus(int i3, int i16) {
        this.mLoadingStatus = i3;
        if (i3 == 1) {
            if (this.mShowLoadingDelayTime > 0) {
                postDelayed(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDDefaultFooter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyTKDDefaultFooter hippyTKDDefaultFooter = HippyTKDDefaultFooter.this;
                        if (hippyTKDDefaultFooter.mLoadingStatus == 1) {
                            hippyTKDDefaultFooter.startLoading();
                        }
                    }
                }, this.mShowLoadingDelayTime);
                return;
            } else {
                startLoading();
                return;
            }
        }
        if (i3 == 2) {
            stopLoading();
            setText("");
            setImageDrawable(null);
            return;
        }
        if (i3 == 3) {
            stopLoading();
            setText(ResourceUtil.getString(R.string.f2206169l));
            setImageDrawable(this.mPullDownToRefreshFailIcon);
            return;
        }
        if (i3 == 4) {
            stopLoading();
            setText(ResourceUtil.getString(R.string.f2206869s));
            setImageDrawable(this.mPullDownToRefreshFailIcon);
            return;
        }
        if (i3 == 9) {
            stopLoading();
            setText(ResourceUtil.getString(R.string.f2206269m));
            setImageDrawable(null);
            return;
        }
        if (i3 == 10) {
            stopLoading();
            setText(ResourceUtil.getString(R.string.f2206369n));
            setImageDrawable(null);
            return;
        }
        if (i3 == 5) {
            stopLoading();
            setText(ResourceUtil.getString(R.string.f2206169l));
            setImageDrawable(this.mPullDownToRefreshFailIcon);
            postDelayed(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDDefaultFooter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (HippyTKDDefaultFooter.this.refreshListener != null) {
                        HippyTKDDefaultFooter.this.refreshListener.onNeedPullToRefresh();
                    }
                }
            }, 2000L);
            return;
        }
        if (i3 == 6) {
            stopLoading();
            setText(ResourceUtil.getString(R.string.f2206069k));
            setImageDrawable(null);
            return;
        }
        if (i3 == 7) {
            stopLoading();
            setText("");
            setImageDrawable(null);
            return;
        }
        if (i3 == 8) {
            stopLoading();
            setImageDrawable(null);
            setText("");
        } else if (i3 == 0) {
            stopLoading();
            setImageDrawable(null);
            setText("");
        } else if (i3 == 100) {
            stopLoading();
            setImageDrawable(null);
            setText(this.mCustomMessage);
        }
    }
}
