package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FrdLikeVideoFeedView extends AbsFeedView {
    public static final String TAG = "FrdLikeVideoFeedView";
    public static final String TITLE_TEXT_DEFAULT = "\u597d\u53cb\u70ed\u64ad";
    public static final int VIEW_DILIVER_INTERVEVAL = AreaManager.f48753dp4;
    private View.OnClickListener mAvatarClickListener;
    private View.OnClickListener mCoverClickListener;
    private BusinessFeedData mCurPlayFeedData;
    private int mCurPlayIndex;
    private FrdLikeVideoItemLayout mCurPlayItem;
    private View.OnClickListener mFeedClickListener;
    private int mFeedPosition;
    private View.OnClickListener mFollowClickListener;
    private long mLastCoverClickTime;
    private FrdLikeVideoItemLayout mLeftItem;
    private View.OnClickListener mNickClickListener;
    private FeedAutoVideo.OnVideoPlayStatusListener mOnVideoPlayListener;
    private FrdLikeVideoItemLayout mRightItem;
    private Button mRightTopBtn;
    private View mSplitHeader;
    private RelativeLayout mTitleContainer;
    private TextView mTitleText;
    private List<BusinessFeedData> mVideoList;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;

    public FrdLikeVideoFeedView(Context context) {
        super(context);
        this.mVideoList = new ArrayList();
        this.mTitleText = null;
        this.mFeedPosition = -1;
        this.mCurPlayIndex = -1;
        this.mLastCoverClickTime = 0L;
        this.mCoverClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FrdLikeVideoFeedView.this.mVideoList != null && FrdLikeVideoFeedView.this.mVideoList.size() > 0 && view != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - FrdLikeVideoFeedView.this.mLastCoverClickTime < 1000) {
                        FrdLikeVideoFeedView.this.mLastCoverClickTime = currentTimeMillis;
                    } else {
                        FrdLikeVideoFeedView.this.mLastCoverClickTime = currentTimeMillis;
                        int i16 = 0;
                        if (view.getTag() instanceof Integer) {
                            i3 = ((Integer) view.getTag()).intValue();
                        } else {
                            com.qzone.proxy.feedcomponent.b.c(FrdLikeVideoFeedView.TAG, "[jinqianli] [error] click null cover, position is 0");
                            i3 = 0;
                        }
                        if (i3 >= 0 && i3 < FrdLikeVideoFeedView.this.mVideoList.size()) {
                            ArrayList arrayList = new ArrayList();
                            int i17 = i3 % 2;
                            if (i17 == 0) {
                                if (i3 < FrdLikeVideoFeedView.this.mVideoList.size()) {
                                    arrayList.add((BusinessFeedData) FrdLikeVideoFeedView.this.mVideoList.get(i3));
                                    int i18 = i3 + 1;
                                    if (i18 < FrdLikeVideoFeedView.this.mVideoList.size()) {
                                        arrayList.add((BusinessFeedData) FrdLikeVideoFeedView.this.mVideoList.get(i18));
                                    }
                                }
                            } else if (i17 == 1) {
                                int i19 = i3 - 1;
                                if (i19 >= 0 && i19 < FrdLikeVideoFeedView.this.mVideoList.size()) {
                                    arrayList.add((BusinessFeedData) FrdLikeVideoFeedView.this.mVideoList.get(i19));
                                    if (i3 < FrdLikeVideoFeedView.this.mVideoList.size()) {
                                        arrayList.add((BusinessFeedData) FrdLikeVideoFeedView.this.mVideoList.get(i3));
                                    }
                                }
                                i16 = 1;
                            } else {
                                i16 = i3;
                            }
                            if (arrayList.size() <= 0) {
                                com.qzone.proxy.feedcomponent.b.c(FrdLikeVideoFeedView.TAG, "[jinqianli] [error] click cover, position is " + i16 + ", video list size is " + arrayList.size());
                            }
                            if (FeedGlobalEnv.g().isDebug()) {
                                com.qzone.proxy.feedcomponent.b.e(FrdLikeVideoFeedView.TAG, "[jinqianli] [debug] click cover, position is " + i16 + ", size is " + arrayList.size());
                            }
                            if (FrdLikeVideoFeedView.this.onFeedElementClickListener != null) {
                                view.setTag(Integer.valueOf(i16));
                                FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                                frdLikeVideoFeedView.onFeedElementClickListener.onClick(view, FeedElement.CONTAINER_USER_VIDEO_CLICK, frdLikeVideoFeedView.getMFeedPosition(), arrayList);
                                FrdLikeVideoFeedView frdLikeVideoFeedView2 = FrdLikeVideoFeedView.this;
                                frdLikeVideoFeedView2.doTTTReport((BusinessFeedData) frdLikeVideoFeedView2.mVideoList.get(i3), 26, 1, i3);
                                FrdLikeVideoFeedView frdLikeVideoFeedView3 = FrdLikeVideoFeedView.this;
                                frdLikeVideoFeedView3.doTTTReport((BusinessFeedData) frdLikeVideoFeedView3.mVideoList.get(i3), 20, 16, i3);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mFeedClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.mAvatarClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null && (view.getTag() instanceof Integer) && FrdLikeVideoFeedView.this.onFeedElementClickListener != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (FrdLikeVideoFeedView.this.mVideoList != null && intValue >= 0 && intValue < FrdLikeVideoFeedView.this.mVideoList.size()) {
                        FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                        frdLikeVideoFeedView.onFeedElementClickListener.onClick(frdLikeVideoFeedView, FeedElement.CONTAINER_USER_AVATAR, frdLikeVideoFeedView.getMFeedPosition(), Integer.valueOf(intValue));
                        FrdLikeVideoFeedView frdLikeVideoFeedView2 = FrdLikeVideoFeedView.this;
                        frdLikeVideoFeedView2.doTTTReport((BusinessFeedData) frdLikeVideoFeedView2.mVideoList.get(intValue), 17, 1, intValue);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mNickClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null && (view.getTag() instanceof Integer) && FrdLikeVideoFeedView.this.onFeedElementClickListener != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (FrdLikeVideoFeedView.this.mVideoList != null && intValue >= 0 && intValue < FrdLikeVideoFeedView.this.mVideoList.size()) {
                        FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                        frdLikeVideoFeedView.onFeedElementClickListener.onClick(frdLikeVideoFeedView, FeedElement.CONTAINER_USER_NICKNAME, frdLikeVideoFeedView.getMFeedPosition(), Integer.valueOf(intValue));
                        FrdLikeVideoFeedView frdLikeVideoFeedView2 = FrdLikeVideoFeedView.this;
                        frdLikeVideoFeedView2.doTTTReport((BusinessFeedData) frdLikeVideoFeedView2.mVideoList.get(intValue), 18, 1, intValue);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mFollowClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null && FrdLikeVideoFeedView.this.onFeedElementClickListener != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                    frdLikeVideoFeedView.onFeedElementClickListener.onClick(frdLikeVideoFeedView, FeedElement.FOLLOW_CONTAINER_USER, frdLikeVideoFeedView.getMFeedPosition(), Integer.valueOf(intValue));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mOnVideoPlayListener = new FeedAutoVideo.OnVideoPlayStatusListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.6
            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayComplete(final BaseVideo baseVideo) {
                FrdLikeVideoFeedView.this.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (baseVideo == null || FrdLikeVideoFeedView.this.mLeftItem == null || FrdLikeVideoFeedView.this.mRightItem == null || FrdLikeVideoFeedView.this.mVideoList == null) {
                            return;
                        }
                        if ((baseVideo instanceof FeedAutoVideo) && FrdLikeVideoFeedView.this.mCurPlayItem != null) {
                            FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                            FrdLikeVideoFeedView.this.mCurPlayItem.updateProgress(0L, feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills());
                        }
                        int i3 = FrdLikeVideoFeedView.this.mCurPlayIndex + 1;
                        int i16 = i3 % 2;
                        FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                        FrdLikeVideoItemLayout frdLikeVideoItemLayout = i16 == 0 ? frdLikeVideoFeedView.mLeftItem : frdLikeVideoFeedView.mRightItem;
                        if (FrdLikeVideoFeedView.this.mVideoList.size() > i3) {
                            if (i16 == 0) {
                                FrdLikeVideoFeedView.this.playNextVideo(i3);
                            } else if (frdLikeVideoItemLayout.canAutoPlayNow()) {
                                frdLikeVideoItemLayout.getAutoVideo().doPlayVideo();
                            }
                            if (FeedGlobalEnv.g().isDebug()) {
                                com.qzone.proxy.feedcomponent.b.e(FrdLikeVideoFeedView.TAG, "[jinqianli] [debug] onVideoPlayComplete(), next is " + i3 + ", total is " + FrdLikeVideoFeedView.this.mVideoList.size());
                            }
                        }
                    }
                }, 500L);
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
                if (!(baseVideo instanceof FeedAutoVideo) || FrdLikeVideoFeedView.this.mCurPlayItem == null) {
                    return;
                }
                FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                FrdLikeVideoFeedView.this.mCurPlayItem.updateProgress(feedAutoVideo.getmCurPositionMills(), feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmLastValidPositionMills());
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStart(BaseVideo baseVideo) {
                if (!(baseVideo instanceof FeedAutoVideo) || FrdLikeVideoFeedView.this.mLeftItem == null || FrdLikeVideoFeedView.this.mRightItem == null || FrdLikeVideoFeedView.this.mVideoList == null) {
                    return;
                }
                FrdLikeVideoFeedView.this.mCurPlayIndex = baseVideo.mIndex;
                FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                frdLikeVideoFeedView.mFeedData.currShowIndex = frdLikeVideoFeedView.mCurPlayIndex;
                FrdLikeVideoFeedView frdLikeVideoFeedView2 = FrdLikeVideoFeedView.this;
                frdLikeVideoFeedView2.mCurPlayItem = frdLikeVideoFeedView2.mCurPlayIndex % 2 == 0 ? FrdLikeVideoFeedView.this.mLeftItem : FrdLikeVideoFeedView.this.mRightItem;
                if (FrdLikeVideoFeedView.this.mCurPlayIndex < FrdLikeVideoFeedView.this.mVideoList.size()) {
                    FrdLikeVideoFeedView frdLikeVideoFeedView3 = FrdLikeVideoFeedView.this;
                    frdLikeVideoFeedView3.mCurPlayFeedData = (BusinessFeedData) frdLikeVideoFeedView3.mVideoList.get(FrdLikeVideoFeedView.this.mCurPlayIndex);
                }
                FrdLikeVideoFeedView.this.mCurPlayItem.updateProgress(0L, (FrdLikeVideoFeedView.this.mCurPlayFeedData == null || FrdLikeVideoFeedView.this.mCurPlayFeedData.getVideoInfo() == null) ? 0L : FrdLikeVideoFeedView.this.mCurPlayFeedData.getVideoInfo().videoTime, 0L);
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FrdLikeVideoFeedView.TAG, "[jinqianli] [debug] onVideoPlayStart(), cur play index is " + FrdLikeVideoFeedView.this.mCurPlayIndex);
                }
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStop(BaseVideo baseVideo) {
            }
        };
        initUI(context);
    }

    private BaseVideo getBaseVideoView(int i3, FrdLikeVideoItemLayout frdLikeVideoItemLayout) {
        List<BusinessFeedData> list = this.mVideoList;
        if (list == null || frdLikeVideoItemLayout == null || list == null || i3 < 0 || list.size() <= i3) {
            return null;
        }
        BusinessFeedData businessFeedData = this.mVideoList.get(i3);
        frdLikeVideoItemLayout.setTag(Integer.valueOf(i3));
        frdLikeVideoItemLayout.setData(businessFeedData);
        frdLikeVideoItemLayout.setFeedPos(this.mFeedPosition, i3);
        frdLikeVideoItemLayout.mItemCover.setTag(Integer.valueOf(i3));
        frdLikeVideoItemLayout.mVideoDuration.setTag(Integer.valueOf(i3));
        frdLikeVideoItemLayout.mAvatarImageView.setTag(Integer.valueOf(i3));
        frdLikeVideoItemLayout.mNickNameView.setTag(Integer.valueOf(i3));
        BaseVideo autoVideo = frdLikeVideoItemLayout.getAutoVideo();
        autoVideo.resetTimeView();
        setUpListener();
        doTTTReport(businessFeedData, 26, 19, i3);
        return autoVideo;
    }

    private List<BaseVideo> getCurActiveList() {
        if (this.mCurPlayItem == null || this.mLeftItem == null || this.mRightItem == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        BaseVideo autoVideo = this.mCurPlayItem.getAutoVideo();
        if (autoVideo != null) {
            arrayList.add(autoVideo);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean playNextVideo(int i3) {
        List<BusinessFeedData> list = this.mVideoList;
        if (list != null && i3 < list.size()) {
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= this.mVideoList.size()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            BaseVideo baseVideoView = getBaseVideoView(i3, this.mLeftItem);
            if (baseVideoView != null) {
                arrayList.add(baseVideoView);
            }
            BaseVideo baseVideoView2 = getBaseVideoView(i3 + 1, this.mRightItem);
            if (baseVideoView2 != null) {
                arrayList.add(baseVideoView2);
            }
            if (arrayList.size() > 1) {
                BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(arrayList);
                return true;
            }
        }
        return false;
    }

    private void setUpListener() {
        FrdLikeVideoItemLayout frdLikeVideoItemLayout = this.mLeftItem;
        if (frdLikeVideoItemLayout != null) {
            frdLikeVideoItemLayout.mItemCover.setOnClickListener(this.mCoverClickListener);
            this.mLeftItem.mVideoView.setOnVideoPlayStatusListener(this.mOnVideoPlayListener);
            this.mLeftItem.mAvatarImageView.setOnClickListener(this.mAvatarClickListener);
            this.mLeftItem.mNickNameView.setOnClickListener(this.mNickClickListener);
        }
        FrdLikeVideoItemLayout frdLikeVideoItemLayout2 = this.mRightItem;
        if (frdLikeVideoItemLayout2 != null) {
            frdLikeVideoItemLayout2.mItemCover.setOnClickListener(this.mCoverClickListener);
            this.mRightItem.mVideoView.setOnVideoPlayStatusListener(this.mOnVideoPlayListener);
            this.mRightItem.mAvatarImageView.setOnClickListener(this.mAvatarClickListener);
            this.mRightItem.mNickNameView.setOnClickListener(this.mNickClickListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void doTTTReport(BusinessFeedData businessFeedData, int i3, int i16, int i17) {
        FeedActionRecorder.getInstance().addAction(businessFeedData, getMFeedPosition(), System.currentTimeMillis(), i3, i16, i17 + 1);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    public List<BaseVideo> getPlayVideoOnFeedListIdle() {
        return getCurActiveList();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        FrdLikeVideoItemLayout frdLikeVideoItemLayout = this.mCurPlayItem;
        if (frdLikeVideoItemLayout != null && frdLikeVideoItemLayout.getAutoVideo() != null && this.mCurPlayItem.isPlaying()) {
            this.mCurPlayItem.getAutoVideo().onPause();
        }
        this.mFeedPosition = 0;
        this.mCurPlayItem = this.mLeftItem;
        this.mCurPlayFeedData = null;
        List<BusinessFeedData> list = this.mVideoList;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        if (this.mCurPlayItem == null || !(getParent() instanceof ViewGroup) || this.mCurPlayItem.getAutoVideo() == null || !this.mCurPlayItem.canAutoPlayNow()) {
            return;
        }
        this.mCurPlayItem.getAutoVideo().doPlayVideo();
    }

    public void resetPlayState() {
        FrdLikeVideoItemLayout frdLikeVideoItemLayout = this.mLeftItem;
        if (frdLikeVideoItemLayout != null) {
            frdLikeVideoItemLayout.resetPlayState();
        }
        FrdLikeVideoItemLayout frdLikeVideoItemLayout2 = this.mRightItem;
        if (frdLikeVideoItemLayout2 != null) {
            frdLikeVideoItemLayout2.resetPlayState();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        try {
            Drawable background = this.mTitleContainer.getBackground();
            if (background != null) {
                background.setAlpha(i3);
            }
            Drawable background2 = this.mLeftItem.getBackground();
            if (background2 != null) {
                background2.setAlpha(i3);
            }
            Drawable background3 = this.mRightItem.getBackground();
            if (background3 != null) {
                background3.setAlpha(i3);
            }
            Drawable background4 = this.mSplitHeader.getBackground();
            if (background4 != null) {
                background4.setAlpha(i3);
            }
            getBackground();
            if (background4 != null) {
                background4.setAlpha(i3);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        super.setData(businessFeedData);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        String str;
        setData(businessFeedData);
        if (businessFeedData.getRecommHeader() == null) {
            str = TITLE_TEXT_DEFAULT;
        } else {
            str = businessFeedData.getRecommHeader().leftTitle;
        }
        TextView textView = this.mTitleText;
        if (textView != null) {
            textView.setText(str);
        }
        setContentDescription(str);
        this.mVideoList.clear();
        ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
        if (recBusinessFeedDatas != null && recBusinessFeedDatas.size() > 1) {
            for (int i3 = 0; i3 < recBusinessFeedDatas.size(); i3++) {
                BusinessFeedData businessFeedData2 = recBusinessFeedDatas.get(i3);
                if (i3 == 0) {
                    this.mCurPlayFeedData = businessFeedData2;
                }
                if (businessFeedData2 != null && businessFeedData2.getVideoInfo() != null && businessFeedData2.getVideoInfo().coverUrl != null && !TextUtils.isEmpty(businessFeedData2.getVideoInfo().coverUrl.url)) {
                    com.qzone.proxy.feedcomponent.b.e(TAG, "cover size, width = " + businessFeedData2.getVideoInfo().coverUrl.width + ", height = " + businessFeedData2.getVideoInfo().coverUrl.height);
                    this.mVideoList.add(businessFeedData2);
                } else if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                    com.qzone.proxy.feedcomponent.b.i(TAG, String.format("Cannot get videoInfo from %d", Integer.valueOf(i3)));
                }
            }
            com.qzone.proxy.feedcomponent.b.e(TAG, "[jinqianli] setData(), frd like sub feed list size is " + this.mVideoList.size());
            setUpListener();
            this.mCurPlayIndex = 0;
            setVisibility(playNextVideo(0) ? 0 : 8);
            return;
        }
        com.qzone.proxy.feedcomponent.b.c(TAG, "[jinqianli] [error] setData(), frd like sub feed list size is empty or 1");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void initUI(Context context) {
        setOrientation(1);
        View view = new View(context);
        this.mSplitHeader = view;
        view.setBackgroundColor(-1250068);
        addView(this.mSplitHeader, new LinearLayout.LayoutParams(-1, AreaManager.dp10));
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mTitleContainer = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        initLeftTopUI(context, this.mTitleContainer);
        initRightTopUI(context, this.mTitleContainer);
        addView(this.mTitleContainer, new RelativeLayout.LayoutParams(-1, AreaManager.dp34));
        this.mLeftItem = new FrdLikeVideoItemLayout(context);
        this.mRightItem = new FrdLikeVideoItemLayout(context);
        this.mLeftItem.enableRoundedCorner(true);
        this.mRightItem.enableRoundedCorner(true);
        this.mLeftItem.setTag(0);
        this.mRightItem.setTag(1);
        this.mLeftItem.mItemCover.setTag(0);
        this.mRightItem.mItemCover.setTag(1);
        this.mLeftItem.setGravity(16);
        this.mRightItem.setGravity(16);
        this.mCurPlayItem = this.mLeftItem;
        int screenWidth = ViewUtils.getScreenWidth();
        int i3 = VIEW_DILIVER_INTERVEVAL;
        float f16 = ((screenWidth - i3) - (AreaManager.FEED_INTERVAL * 2)) / 2;
        int i16 = FrdLikeVideoItemLayout.VIDEO_ITEM_HEIGHT;
        int i17 = FrdLikeVideoItemLayout.VIDEO_ITEM_WIDTH;
        float f17 = i16 * (f16 / i17);
        int i18 = (int) f16;
        int i19 = (int) f17;
        com.qzone.proxy.feedcomponent.b.e(TAG, "[jinqianli] initUI(), reset video item width from " + i17 + " to " + i18 + ", reset video item height from " + i16 + " to " + i19);
        this.mLeftItem.setItemWH(i18, i19);
        this.mRightItem.setItemWH(i18, i19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i18, i19);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i18, i19);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, i19);
        layoutParams3.gravity = 1;
        View view2 = new View(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, i19);
        int i26 = AreaManager.FEED_INTERVAL;
        layoutParams4.setMargins(i26, 0, i26, AreaManager.dp20);
        linearLayout.addView(this.mLeftItem, layoutParams);
        linearLayout.addView(view2, layoutParams3);
        linearLayout.addView(this.mRightItem, layoutParams2);
        addView(linearLayout, layoutParams4);
        setOnClickListener(this.mFeedClickListener);
        setBackgroundColor(-1);
        setVisibility(8);
    }

    private void initLeftTopUI(Context context, RelativeLayout relativeLayout) {
        if (context == null || relativeLayout == null) {
            return;
        }
        TextView textView = new TextView(context);
        this.mTitleText = textView;
        textView.setText(TITLE_TEXT_DEFAULT);
        this.mTitleText.setTextColor(-16777216);
        this.mTitleText.setTextSize(14.0f);
        this.mTitleText.setCompoundDrawables(null, null, null, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = AreaManager.dp10;
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.mTitleText, layoutParams);
    }

    private void initRightTopUI(Context context, RelativeLayout relativeLayout) {
        if (context == null || relativeLayout == null) {
            return;
        }
        Button button = new Button(context);
        this.mRightTopBtn = button;
        button.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(719));
        int i3 = AreaManager.dp15;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.rightMargin = AreaManager.dp10;
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.mRightTopBtn, layoutParams);
        this.mRightTopBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ClickedPoint clickedPoint = new ClickedPoint(FrdLikeVideoFeedView.this.mRightTopBtn.getLeft(), FrdLikeVideoFeedView.this.mRightTopBtn.getBottom(), 0, 0, FrdLikeVideoFeedView.this.mRightTopBtn.getWidth(), FrdLikeVideoFeedView.this.mRightTopBtn.getHeight());
                FrdLikeVideoFeedView frdLikeVideoFeedView = FrdLikeVideoFeedView.this;
                frdLikeVideoFeedView.onFeedElementClickListener.onClick(frdLikeVideoFeedView, FeedElement.DROPDOWN_BUTTON, frdLikeVideoFeedView.getMFeedPosition(), clickedPoint);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
