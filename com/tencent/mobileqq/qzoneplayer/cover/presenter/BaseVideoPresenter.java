package com.tencent.mobileqq.qzoneplayer.cover.presenter;

import android.view.View;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.view.OnCoverSizeChangeListener;
import com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;

/* loaded from: classes35.dex */
public class BaseVideoPresenter implements OnBaseVideoClickListener, OnCoverSizeChangeListener {
    protected static final String LOG_TAG = "BaseVideoPresenter";
    public static final int PLAY_ON_WIFI_REPORT_CLICK = 2;
    public static final int PLAY_ON_WIFI_REPORT_EXPOSE = 1;
    public static final int TYPE_FEED_AUTO_VIDEO_FULL_PRESENTER = 1;
    protected BaseVideo mBaseVideo;
    protected BaseVideoCoverUIWrapper mCoverWrapper;
    protected int mPresentType = -1;
    protected boolean mIsVideoPicMixMode = false;
    protected boolean mIsFullScreenMode = false;
    protected BaseVideoCover.CoverWarnType mWarnType = BaseVideoCover.CoverWarnType.DEFAULT;
    protected int mCoverWidth = 0;
    public boolean mIsShowVideoFloatCompletePage = true;

    /* loaded from: classes35.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f279329a;

        static {
            int[] iArr = new int[VideoClickElement.values().length];
            f279329a = iArr;
            try {
                iArr[VideoClickElement.NOTHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f279329a[VideoClickElement.BASE_COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f279329a[VideoClickElement.FLOAT_COMPLETE_PAGE_REPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f279329a[VideoClickElement.FLOAT_COMPLETE_PAGE_REDPOCKET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f279329a[VideoClickElement.FLOAT_COMPLETE_PAGE_MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f279329a[VideoClickElement.COMPLETE_PAGE_RETRY_ICON.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f279329a[VideoClickElement.COMPLETE_PAGE_MORE_ICON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f279329a[VideoClickElement.ERROR_PAGE_RETRY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f279329a[VideoClickElement.NET_RESUME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public BaseVideoPresenter(BaseVideo baseVideo, BaseVideoCoverUIWrapper baseVideoCoverUIWrapper) {
        this.mBaseVideo = baseVideo;
        this.mCoverWrapper = baseVideoCoverUIWrapper;
    }

    public int getCoverWidth() {
        return this.mCoverWidth;
    }

    public int getPresenterType() {
        return this.mPresentType;
    }

    public BaseVideoCover.CoverWarnType getWarnType() {
        return this.mWarnType;
    }

    public boolean isFreeTraffic() {
        return FeedVideoEnv.externalFunc.isFreeTraffic() && !FeedVideoEnv.isWifiConnected();
    }

    public boolean isFullScreenMode() {
        return false;
    }

    public boolean isLandscapeMode() {
        return false;
    }

    public boolean isVideoPicMixMode() {
        return this.mIsVideoPicMixMode;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.view.OnCoverSizeChangeListener
    public void onChangeSize(int i3, int i16) {
        this.mCoverWidth = i3;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.presenter.OnBaseVideoClickListener
    public void onClick(View view, boolean z16, VideoClickElement videoClickElement, int i3, Object[] objArr) {
        switch (a.f279329a[videoClickElement.ordinal()]) {
            case 2:
                onClickCover(z16);
                return;
            case 3:
                onPlayButtonClicked();
                return;
            case 4:
                onShowFloatRedpocket();
                return;
            case 5:
                onJumpToVideoTab();
                return;
            case 6:
                onRetryClick(z16);
                return;
            case 7:
                onMoreClick(z16);
                return;
            case 8:
            case 9:
                if (z16) {
                    onRetryClick(z16);
                    return;
                } else {
                    onPlayResumeClicked();
                    return;
                }
            default:
                return;
        }
    }

    protected void onJumpToVideoTab() {
        BaseVideo baseVideo = this.mBaseVideo;
        if (baseVideo != null) {
            baseVideo.jumpToVideoTab();
        }
    }

    protected void onPlayButtonClicked() {
        if (this.mBaseVideo != null) {
            BaseVideoManager.getFeedVideoManager().startVideo(this.mBaseVideo);
        }
    }

    protected void onPlayResumeClicked() {
        BaseVideo baseVideo = this.mBaseVideo;
        if (baseVideo != null) {
            baseVideo.getBaseVideoManager().startVideo(this.mBaseVideo);
            BaseVideoManager.getFeedVideoManager().g();
            BaseVideoManager.getFeedVideoManager().setIsNeedPlayTip(false);
            BaseVideoManager.getFeedVideoManager().l().edit().putLong("BaseVideoManager.key_current_store_stamp", System.currentTimeMillis()).apply();
            BaseVideoManager.getFeedVideoManager().f279610e = -2L;
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseVideo baseVideo2 = BaseVideoPresenter.this.mBaseVideo;
                    if (baseVideo2 != null) {
                        baseVideo2.onPlayResumeClicked();
                    }
                }
            });
        }
    }

    protected void onShowFloatRedpocket() {
        BaseVideo baseVideo = this.mBaseVideo;
        if (baseVideo != null) {
            baseVideo.showRedpocket();
        }
    }

    public void setCoverWarnType(BaseVideoCover.CoverWarnType coverWarnType) {
        this.mWarnType = coverWarnType;
    }

    public void setFullScreenMode(boolean z16) {
        this.mIsFullScreenMode = z16;
    }

    public void setIsVideoPicMixMode(boolean z16) {
        this.mIsVideoPicMixMode = z16;
    }

    public void reset() {
        this.mIsVideoPicMixMode = false;
        this.mIsFullScreenMode = false;
        this.mWarnType = BaseVideoCover.CoverWarnType.DEFAULT;
        this.mIsShowVideoFloatCompletePage = true;
    }

    protected void onClickCover(boolean z16) {
        BaseVideo baseVideo;
        if (!z16 || (baseVideo = this.mBaseVideo) == null) {
            return;
        }
        baseVideo.onVideoCoverBlankClicked();
    }

    protected void onMoreClick(boolean z16) {
        BaseVideo baseVideo;
        if (!z16 || (baseVideo = this.mBaseVideo) == null) {
            return;
        }
        baseVideo.onAdvertiseMoreClicked();
    }

    protected void onRetryClick(boolean z16) {
        BaseVideo baseVideo;
        if (!z16 || (baseVideo = this.mBaseVideo) == null) {
            return;
        }
        baseVideo.onReplayClicked();
    }

    public void reportStoreIconToLp(int i3, int i16) {
        if ((i3 == 1 || i3 == 2) && i16 >= 0 && i16 <= 5) {
            if (i16 == 4 || i16 == 5) {
                i16 = 4;
            }
            FeedVideoEnv.externalFunc.reportToLp00064(646, i3, i16);
        }
    }
}
