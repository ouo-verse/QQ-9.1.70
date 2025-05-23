package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.common.RoundedCornerRelativeLayout;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellInterest;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FrdLikeVideoItemLayout extends RoundedCornerRelativeLayout {
    public static final int PROGRESS_INIT_VALUE = 0;
    public static final int PROGRESS_MAX_VALUE = 100;
    private static final String TAG = "FrdLikeVideoItemLayout";
    public static final int VIDEO_ITEM_HEIGHT = com.qzone.adapter.feedcomponent.j.f(290);
    public static final int VIDEO_ITEM_WIDTH = com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_ZIRAN);
    public AvatarImageView mAppAvatar1;
    public AvatarImageView mAppAvatar2;
    public AvatarImageView mAppAvatar3;
    public RelativeLayout mAppAvatarContainer1;
    public RelativeLayout mAppAvatarContainer2;
    public RelativeLayout mAppAvatarContainer3;
    public AsyncImageView mAppLogo;
    public RelativeLayout mAppLogoContainer;
    public TextView mAppTitle;
    public AvatarImageView mAvatarImageView;
    public TextView mCommentCount;
    public CellTextView mContent;
    public BusinessFeedData mFeedData;
    public LinearLayout mFriendListContainer;
    public TextView mFriendListText;
    public int mIndex;
    public View mItemCover;
    public int mItemHeight;
    public RelativeLayout mItemLayout;
    public int mItemWidth;
    protected Handler mMainHandler;
    public TextView mNickNameView;
    public RelativeLayout mNickPart;
    public ProgressBar mPlayProgress;
    public TextView mPopularAppText;
    public TextView mPraiseCount;
    public TextView mVideoDuration;
    public FeedVideoView mVideoView;

    public FrdLikeVideoItemLayout(Context context) {
        this(context, null);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1710), this);
        this.mItemLayout = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2774));
        this.mItemCover = findViewById(com.qzone.adapter.feedcomponent.j.O(2775));
        this.mNickNameView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2767));
        this.mAvatarImageView = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2768));
        this.mVideoView = (FeedVideoView) findViewById(com.qzone.adapter.feedcomponent.j.O(2769));
        this.mPraiseCount = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2770));
        this.mCommentCount = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2771));
        this.mVideoDuration = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2772));
        this.mPlayProgress = (ProgressBar) findViewById(com.qzone.adapter.feedcomponent.j.O(2773));
        this.mContent = (CellTextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2776));
        this.mAppLogoContainer = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2886));
        this.mAppLogo = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2887));
        this.mAppTitle = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2888));
        this.mPopularAppText = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2889));
        this.mFriendListContainer = (LinearLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2890));
        this.mAppAvatarContainer1 = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2892));
        this.mAppAvatar1 = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2893));
        this.mAppAvatarContainer2 = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2894));
        this.mAppAvatar2 = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2895));
        this.mAppAvatarContainer3 = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2896));
        this.mAppAvatar3 = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2897));
        this.mFriendListText = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2898));
        this.mNickPart = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2899));
        this.mContent.setClickable(false);
        this.mContent.setLongclickable(false);
        this.mContent.setCellClickable(false);
        this.mContent.setText("");
        this.mPraiseCount.setText("");
        this.mCommentCount.setText("");
        this.mPlayProgress.setMax(100);
        this.mPlayProgress.setProgress(0);
        this.mAppLogo.setAsyncImageProcessor(new RoundCornerProcessor(ViewUtils.dpToPx(6.0f)));
    }

    private void reSizeAutoVideo() {
        VideoInfo videoInfo = this.mFeedData.getVideoInfo();
        int i3 = videoInfo.width;
        int i16 = videoInfo.height;
        com.qzone.proxy.feedcomponent.b.e(TAG, "reSizeAutoVideo, width = " + i3 + ", videoHeight = " + i16);
        if (i3 <= 0 || i16 <= 0) {
            return;
        }
        int i17 = (i16 * this.mItemWidth) / i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVideoView.mAutoVideoView.getLayoutParams();
        layoutParams.topMargin = (this.mItemHeight - i17) / 2;
        this.mVideoView.mAutoVideoView.setLayoutParams(layoutParams);
    }

    public boolean canAutoPlayNow() {
        if (!com.qzone.adapter.feedcomponent.i.H().m()) {
            com.qzone.proxy.feedcomponent.b.e(TAG, "not support auto play");
            return false;
        }
        FeedVideoView feedVideoView = this.mVideoView;
        if (feedVideoView != null && feedVideoView.getAutoVideoView() != null) {
            if (BaseVideoManager.getFeedVideoManager().u(this.mVideoView.getAutoVideoView())) {
                if (!isVideoPartlyOnScreen()) {
                    com.qzone.proxy.feedcomponent.b.e(TAG, "!isVideoPartlyOnScreen()");
                    return false;
                }
            } else if (!isVideoALLOnScreen()) {
                com.qzone.proxy.feedcomponent.b.e(TAG, "!isVideoALLOnScreen()");
                return false;
            }
            return true;
        }
        com.qzone.proxy.feedcomponent.b.e(TAG, "no videoview to play");
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.common.RoundedCornerRelativeLayout, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public BaseVideo getAutoVideo() {
        FeedVideoView feedVideoView = this.mVideoView;
        if (feedVideoView != null) {
            return feedVideoView.getAutoVideoView();
        }
        return null;
    }

    public int getmIndex() {
        return this.mIndex;
    }

    public boolean isPlaying() {
        FeedVideoView feedVideoView = this.mVideoView;
        if (feedVideoView == null) {
            return false;
        }
        return BaseVideoManager.getFeedVideoManager().u(feedVideoView.getAutoVideoView());
    }

    public void resetPlayState() {
        BusinessFeedData businessFeedData = this.mFeedData;
        updateProgress(0L, (businessFeedData == null || businessFeedData.getVideoInfo() == null) ? 0L : this.mFeedData.getVideoInfo().videoTime, 0L);
    }

    public void setData(BusinessFeedData businessFeedData) {
        String str;
        String str2;
        String valueOf;
        String valueOf2;
        BusinessFeedData businessFeedData2;
        if (businessFeedData == null) {
            com.qzone.proxy.feedcomponent.b.c(TAG, "recomm video feeddata is null");
            return;
        }
        this.mFeedData = businessFeedData;
        int i3 = this.mItemWidth;
        boolean z16 = businessFeedData.isFrdLikeMiniAppContainer() || ((businessFeedData2 = this.mFeedData.parentFeedData) != null && businessFeedData2.isFrdLikeMiniAppContainer());
        if (businessFeedData.getCommentInfo() != null) {
            float f16 = businessFeedData.getCommentInfo().realCount;
            if (businessFeedData.getCommentEssence() != null) {
                f16 += businessFeedData.getCommentEssence().realCount;
            }
            float f17 = f16 / 10000.0f;
            if (f16 > 10000.0f) {
                valueOf2 = String.format("%.2f", Float.valueOf(f17)) + "w";
            } else {
                valueOf2 = String.valueOf((int) f16);
            }
            this.mCommentCount.setText(valueOf2);
        }
        if (businessFeedData.getLikeInfo() != null) {
            float f18 = businessFeedData.getLikeInfo().likeNum;
            float f19 = f18 / 10000.0f;
            if (f18 > 10000.0f) {
                valueOf = String.format("%.2f", Float.valueOf(f19)) + "w";
            } else {
                valueOf = String.valueOf((int) f18);
            }
            this.mPraiseCount.setText(valueOf);
        }
        if (businessFeedData.getVideoInfo() != null) {
            this.mVideoDuration.setText(businessFeedData.getVideoInfo().showVideoTime);
        }
        if (businessFeedData.getCellSummaryV2() == null) {
            str = "";
        } else {
            str = businessFeedData.getCellSummaryV2().summary;
        }
        this.mContent.setText(str);
        if (z16) {
            this.mNickPart.setVisibility(8);
            this.mAppLogoContainer.setVisibility(0);
            if (businessFeedData.getCellUserInfo() != null && businessFeedData.getCellUserInfo().getUser() != null) {
                this.mAppLogo.setAsyncImage(businessFeedData.getCellUserInfo().getUser().logo);
                this.mAppTitle.setText(businessFeedData.getCellUserInfo().getUser().nickName);
            }
            CellInterest cellInterest = businessFeedData.getCellInterest();
            if (cellInterest != null) {
                ArrayList<User> arrayList = cellInterest.users;
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.mFriendListContainer.setVisibility(0);
                    this.mAppAvatarContainer1.setVisibility(0);
                    this.mAppAvatar1.loadAvatar(cellInterest.users.get(0).uin);
                    if (cellInterest.users.size() >= 2) {
                        this.mAppAvatarContainer2.setVisibility(0);
                        this.mAppAvatar2.loadAvatar(cellInterest.users.get(1).uin);
                    }
                    if (cellInterest.users.size() >= 3) {
                        this.mAppAvatarContainer3.setVisibility(0);
                        this.mAppAvatar3.loadAvatar(cellInterest.users.get(2).uin);
                    }
                    this.mFriendListText.setText(cellInterest.desc);
                } else {
                    this.mPopularAppText.setVisibility(0);
                    this.mPopularAppText.setText(cellInterest.desc);
                }
            }
        } else {
            this.mNickPart.setVisibility(0);
            this.mAppLogoContainer.setVisibility(8);
            if (businessFeedData.getCellUserInfo() != null && businessFeedData.getCellUserInfo().getUser() != null) {
                this.mAvatarImageView.loadAvatar(businessFeedData.getCellUserInfo().getUser().uin);
                this.mNickNameView.setText(businessFeedData.getCellUserInfo().getUser().nickName);
            }
        }
        String str3 = "Null";
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            PictureUrl pictureUrl = businessFeedData.getVideoInfo() != null ? businessFeedData.getVideoInfo().coverUrl : null;
            if (pictureUrl == null) {
                str2 = "Null";
            } else {
                str2 = businessFeedData.getVideoInfo().coverUrl.url;
            }
            if (pictureUrl == null) {
                com.qzone.proxy.feedcomponent.b.c(TAG, "videoinfo is null");
                return;
            }
            com.qzone.proxy.feedcomponent.b.c(TAG, String.format("cover size:%d %d, url:%s, widthPassed in: %d", Integer.valueOf(pictureUrl.width), Integer.valueOf(pictureUrl.height), str2, Integer.valueOf(i3)));
        }
        if (businessFeedData.getVideoInfo() != null) {
            businessFeedData.getVideoInfo().playType = (byte) (businessFeedData.getVideoInfo().playType & (-3));
        }
        this.mVideoView.setMaxVideoWidth(i3);
        this.mVideoView.setFeedData(businessFeedData, businessFeedData.getVideoInfo());
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            Object[] objArr = new Object[1];
            if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().coverUrl != null) {
                str3 = businessFeedData.getVideoInfo().coverUrl.url;
            }
            objArr[0] = str3;
            com.qzone.proxy.feedcomponent.b.c(TAG, String.format("video cover url %s", objArr));
        }
        this.mVideoView.setAdjustToHeight(false, this.mItemHeight);
        FeedAutoVideo feedAutoVideo = this.mVideoView.mAutoVideoView;
        feedAutoVideo.mVideoCover.showPlayIcon = true;
        feedAutoVideo.hideDurationTextView();
        this.mVideoView.mAutoVideoView.hideSoundLine();
        this.mVideoView.mAutoVideoView.mVideoCover.setShowOpenFreeTrafficIcon(false);
        if (z16 && businessFeedData.isFrdLikeMiniAppJumpDirect() && (this.mVideoView.mAutoVideoView.mVideoCover instanceof AutoVideoCover)) {
            if (AreaManager.FEED_FRD_LIKE_MINI_APP_PLAY_ICON == null) {
                AreaManager.FEED_FRD_LIKE_MINI_APP_PLAY_ICON = com.qzone.adapter.feedcomponent.j.g(964);
            }
            ((AutoVideoCover) this.mVideoView.mAutoVideoView.mVideoCover).setPlayIconDrawable(true, AreaManager.FEED_FRD_LIKE_MINI_APP_PLAY_ICON);
        }
        this.mVideoView.setPadding(0, 0, 0, 0);
        reSizeAutoVideo();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, this.mItemHeight);
        layoutParams.addRule(13, -1);
        this.mVideoView.setLayoutParams(layoutParams);
        this.mItemLayout.setLayoutParams(new RelativeLayout.LayoutParams(this.mItemWidth, this.mItemHeight));
        requestLayout();
    }

    public void setFeedPos(int i3, int i16) {
        this.mIndex = i16;
        FeedVideoView feedVideoView = this.mVideoView;
        if (feedVideoView != null) {
            feedVideoView.setFeedPos(i3, i16);
        }
    }

    public void setItemWH(int i3, int i16) {
        this.mItemWidth = i3;
        this.mItemHeight = i16;
    }

    public void setmIndex(int i3) {
        this.mIndex = i3;
    }

    public FrdLikeVideoItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        setContentDescription(FrdLikeVideoFeedView.TITLE_TEXT_DEFAULT);
        setWillNotDraw(false);
        initUI(context);
    }

    public boolean isVideoALLOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr[1] >= ViewUtils.dpToPx(76.0f) && iArr[1] + getMeasuredHeight() < ViewUtils.getScreenHeight();
    }

    public boolean isVideoPartlyOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int measuredHeight = getMeasuredHeight();
        int screenHeight = ViewUtils.getScreenHeight();
        com.qzone.proxy.feedcomponent.b.e(TAG, "location[1]" + iArr[1] + ", height = " + measuredHeight + ", screenHeight = " + screenHeight);
        return iArr[1] + measuredHeight >= ViewUtils.dpToPx(76.0f) && iArr[1] < screenHeight;
    }

    public void updateProgress(final long j3, final long j16, final long j17) {
        Handler handler = this.mMainHandler;
        if (handler == null || 0 == j16) {
            return;
        }
        handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoItemLayout.1
            @Override // java.lang.Runnable
            public void run() {
                long j18 = j3;
                if (j18 < 0) {
                    j18 = 0;
                }
                long j19 = j16;
                if (j18 >= j19) {
                    j18 = j19;
                }
                ProgressBar progressBar = FrdLikeVideoItemLayout.this.mPlayProgress;
                if (progressBar != null) {
                    float f16 = ((float) j18) / ((float) j19);
                    progressBar.setProgress((int) (100.0f * f16));
                    float f17 = (float) j17;
                    long j26 = j16;
                    float f18 = f17 / ((float) j26);
                    TextView textView = FrdLikeVideoItemLayout.this.mVideoDuration;
                    if (textView != null) {
                        textView.setText(VideoInfo.getShownTimeFromNumeric(j26 - j3));
                    }
                    if (FeedGlobalEnv.g().isDebug()) {
                        com.qzone.proxy.feedcomponent.b.e(FrdLikeVideoItemLayout.TAG, "[jinqianli] [debug] video play percent is " + f16 + ", buffer percent is " + f18);
                    }
                }
            }
        });
    }
}
