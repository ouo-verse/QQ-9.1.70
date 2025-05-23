package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.common.CenterViewPager;
import com.qzone.module.feedcomponent.ui.common.PagerAdapter;
import com.qzone.module.feedcomponent.ui.common.WrapContentViewPager;
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
public class FrdLikeVideoSlideFeedView extends AbsFeedView {
    public static final int ITEM_VIEW_HEIGHT;
    public static final int ITEM_VIEW_WIDTH;
    public static final int SHOW_VIEW_MIN_SIZE = 3;
    public static final String TAG = "FrdLikeVideoSlideFeedView";
    public static final String TITLE_TEXT_DEFAULT = "\u66f4\u591a\u89c6\u9891";
    public static final String TITLE_TEXT_FRIEND_APP = "\u597d\u53cb\u5728\u73a9";
    public static final float WH_RATIO = 1.333f;
    private BusinessFeedData mCurPlayFeedData;
    private int mFeedPosition;
    private FeedAutoVideo.OnVideoPlayStatusListener mOnVideoPlayListener;
    private Button mRightTopBtn;
    private View mSplitHeader;
    private RelativeLayout mTitleContainer;
    private TextView mTitleText;
    private MyWrapContentViewPager mViewPager;
    private MyAdapter myAdapter;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class MyAdapter extends PagerAdapter {
        private int mFeedPosition;
        private List<BusinessFeedData> mFeeds;
        private FrdLikeVideoItemLayout mPrimaryItem;
        private List<FrdLikeVideoItemLayout> mCachedViews = new ArrayList();
        private int mPrimaryPosition = -1;
        private long mLastCoverClickTime = 0;
        private View.OnClickListener mAvatarClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.MyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null && (view.getTag() instanceof Integer) && FrdLikeVideoSlideFeedView.this.onFeedElementClickListener != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (MyAdapter.this.mFeeds != null && intValue >= 0 && intValue < MyAdapter.this.mFeeds.size()) {
                        FrdLikeVideoSlideFeedView frdLikeVideoSlideFeedView = FrdLikeVideoSlideFeedView.this;
                        frdLikeVideoSlideFeedView.onFeedElementClickListener.onClick(frdLikeVideoSlideFeedView, FeedElement.CONTAINER_USER_AVATAR, frdLikeVideoSlideFeedView.getMFeedPosition(), Integer.valueOf(intValue));
                        MyAdapter myAdapter = MyAdapter.this;
                        FrdLikeVideoSlideFeedView.this.doTTTReport((BusinessFeedData) myAdapter.mFeeds.get(intValue), 17, 1, intValue);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        private View.OnClickListener mNickClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.MyAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null && (view.getTag() instanceof Integer) && FrdLikeVideoSlideFeedView.this.onFeedElementClickListener != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (MyAdapter.this.mFeeds != null && intValue >= 0 && intValue < MyAdapter.this.mFeeds.size()) {
                        FrdLikeVideoSlideFeedView frdLikeVideoSlideFeedView = FrdLikeVideoSlideFeedView.this;
                        frdLikeVideoSlideFeedView.onFeedElementClickListener.onClick(frdLikeVideoSlideFeedView, FeedElement.CONTAINER_USER_NICKNAME, frdLikeVideoSlideFeedView.getMFeedPosition(), Integer.valueOf(intValue));
                        MyAdapter myAdapter = MyAdapter.this;
                        FrdLikeVideoSlideFeedView.this.doTTTReport((BusinessFeedData) myAdapter.mFeeds.get(intValue), 18, 1, intValue);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        private View.OnClickListener mCoverClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.MyAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FrdLikeVideoSlideFeedView.this.onFeedElementClickListener == null) {
                    com.qzone.proxy.feedcomponent.b.i(FrdLikeVideoSlideFeedView.TAG, "[instantiateItem][onClick] onFeedElementClickListener is null");
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - MyAdapter.this.mLastCoverClickTime < 1000) {
                        MyAdapter.this.mLastCoverClickTime = currentTimeMillis;
                    } else {
                        MyAdapter.this.mLastCoverClickTime = currentTimeMillis;
                        FrdLikeVideoSlideFeedView frdLikeVideoSlideFeedView = FrdLikeVideoSlideFeedView.this;
                        frdLikeVideoSlideFeedView.onFeedElementClickListener.onClick(view, FeedElement.CONTAINER_USER_VIDEO_CLICK, frdLikeVideoSlideFeedView.getMFeedPosition(), MyAdapter.this.mFeeds);
                        if (view != null && (view.getTag() instanceof Integer)) {
                            int intValue = ((Integer) view.getTag()).intValue();
                            if (MyAdapter.this.mFeeds != null && intValue >= 0 && intValue < MyAdapter.this.mFeeds.size()) {
                                MyAdapter myAdapter = MyAdapter.this;
                                FrdLikeVideoSlideFeedView.this.doTTTReport((BusinessFeedData) myAdapter.mFeeds.get(intValue), 26, 1, intValue);
                                MyAdapter myAdapter2 = MyAdapter.this;
                                FrdLikeVideoSlideFeedView.this.doTTTReport((BusinessFeedData) myAdapter2.mFeeds.get(intValue), 20, 16, intValue);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };

        public MyAdapter() {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[destroyItem] position=" + i3 + ", object=" + obj + ", thread=" + Thread.currentThread().getName());
            FrdLikeVideoItemLayout frdLikeVideoItemLayout = (FrdLikeVideoItemLayout) obj;
            frdLikeVideoItemLayout.setOnClickListener(null);
            viewGroup.removeView(frdLikeVideoItemLayout);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getCount() {
            List<BusinessFeedData> list = this.mFeeds;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public float getPageWidth(int i3) {
            return (FrdLikeVideoSlideFeedView.ITEM_VIEW_WIDTH * 1.0f) / ViewUtils.getScreenWidth();
        }

        public BusinessFeedData getPrimaryFeedData() {
            int i3 = this.mPrimaryPosition;
            if (i3 < 0 || i3 >= getCount()) {
                return null;
            }
            return this.mFeeds.get(this.mPrimaryPosition);
        }

        public FrdLikeVideoItemLayout getPrimaryItem() {
            return this.mPrimaryItem;
        }

        public int getPrimaryPosition() {
            return this.mPrimaryPosition;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            FrdLikeVideoItemLayout frdLikeVideoItemLayout;
            com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[instantiateItem] position=" + i3 + ", thread=" + Thread.currentThread().getName());
            if (this.mCachedViews.size() > i3) {
                frdLikeVideoItemLayout = this.mCachedViews.get(i3);
            } else {
                frdLikeVideoItemLayout = new FrdLikeVideoItemLayout(viewGroup.getContext());
                frdLikeVideoItemLayout.setOutlineProvider(new RoundRectOutlineProvider());
                frdLikeVideoItemLayout.setClipToOutline(true);
                this.mCachedViews.add(frdLikeVideoItemLayout);
            }
            int i16 = FrdLikeVideoSlideFeedView.ITEM_VIEW_WIDTH;
            int i17 = FrdLikeVideoSlideFeedView.ITEM_VIEW_HEIGHT;
            frdLikeVideoItemLayout.setItemWH(i16, i17);
            frdLikeVideoItemLayout.setTag(Integer.valueOf(i3));
            frdLikeVideoItemLayout.setData(this.mFeeds.get(i3));
            frdLikeVideoItemLayout.setFeedPos(this.mFeedPosition, i3);
            frdLikeVideoItemLayout.mVideoView.setOnVideoPlayStatusListener(FrdLikeVideoSlideFeedView.this.mOnVideoPlayListener);
            frdLikeVideoItemLayout.mCommentCount.setVisibility(8);
            frdLikeVideoItemLayout.mPraiseCount.setVisibility(8);
            frdLikeVideoItemLayout.mVideoDuration.setVisibility(8);
            frdLikeVideoItemLayout.mAvatarImageView.setTag(Integer.valueOf(i3));
            frdLikeVideoItemLayout.mItemCover.setTag(Integer.valueOf(i3));
            frdLikeVideoItemLayout.mAvatarImageView.setOnClickListener(this.mAvatarClickListener);
            frdLikeVideoItemLayout.mItemCover.setOnClickListener(this.mCoverClickListener);
            frdLikeVideoItemLayout.mContent.setTextSize(com.qzone.proxy.feedcomponent.util.g.a(16.0f));
            frdLikeVideoItemLayout.mNickNameView.setTextSize(14.0f);
            frdLikeVideoItemLayout.mNickNameView.setTag(Integer.valueOf(i3));
            frdLikeVideoItemLayout.mNickNameView.setOnClickListener(this.mNickClickListener);
            viewGroup.addView(frdLikeVideoItemLayout, i16, i17);
            return frdLikeVideoItemLayout;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        public void setData(List<BusinessFeedData> list, int i3) {
            com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[setData] feedPosition=" + i3);
            this.mFeedPosition = i3;
            this.mFeeds = list;
            notifyDataSetChanged();
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i3, Object obj) {
            List<BaseVideo> activeBaseVideo;
            com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[setPrimaryItem] position=" + i3 + ", object=" + obj);
            if (this.mPrimaryPosition != i3) {
                this.mPrimaryItem = (FrdLikeVideoItemLayout) obj;
                this.mPrimaryPosition = i3;
                if (com.qzone.adapter.feedcomponent.i.H().m() && (activeBaseVideo = FrdLikeVideoSlideFeedView.this.getActiveBaseVideo()) != null && activeBaseVideo.size() > 0) {
                    BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(activeBaseVideo);
                }
                List<BusinessFeedData> list = this.mFeeds;
                if (list == null || i3 < 0 || i3 >= list.size()) {
                    return;
                }
                FrdLikeVideoSlideFeedView.this.doTTTReport(this.mFeeds.get(i3), 26, 19, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class MyWrapContentViewPager extends WrapContentViewPager {
        private float lastX;
        private float lastY;

        public MyWrapContentViewPager(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.lastX = motionEvent.getX();
                this.lastY = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (motionEvent.getAction() == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float abs = Math.abs(x16 - this.lastX);
                float abs2 = Math.abs(y16 - this.lastY);
                float scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                if (abs >= scaledTouchSlop) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else if (abs2 >= scaledTouchSlop) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public MyWrapContentViewPager(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static {
        int screenWidth = (int) (ViewUtils.getScreenWidth() * 0.66f);
        ITEM_VIEW_WIDTH = screenWidth;
        ITEM_VIEW_HEIGHT = (int) (screenWidth * 1.333f);
    }

    public FrdLikeVideoSlideFeedView(Context context) {
        super(context);
        this.mTitleText = null;
        this.mOnVideoPlayListener = new FeedAutoVideo.OnVideoPlayStatusListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.5
            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayComplete(BaseVideo baseVideo) {
                com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayComplete] ");
                FrdLikeVideoItemLayout primaryItem = FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryItem();
                if ((baseVideo instanceof FeedAutoVideo) && primaryItem != null) {
                    FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                    primaryItem.updateProgress(0L, feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills());
                }
                FrdLikeVideoSlideFeedView.this.playNextVideo();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
                com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayProgressUpdate] ");
                if (FrdLikeVideoSlideFeedView.this.myAdapter == null) {
                    com.qzone.proxy.feedcomponent.b.i(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayProgressUpdate] myAdapter is null");
                    return;
                }
                FrdLikeVideoItemLayout primaryItem = FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryItem();
                if (!(baseVideo instanceof FeedAutoVideo) || primaryItem == null) {
                    return;
                }
                FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                primaryItem.updateProgress(feedAutoVideo.getmCurPositionMills(), feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmLastValidPositionMills());
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStart(BaseVideo baseVideo) {
                com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayStart] thread=" + Thread.currentThread().getName());
                if (FrdLikeVideoSlideFeedView.this.myAdapter == null) {
                    com.qzone.proxy.feedcomponent.b.i(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayStart] myAdapter is null");
                    return;
                }
                BusinessFeedData primaryFeedData = FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryFeedData();
                if (primaryFeedData != null && primaryFeedData.getVideoInfo() != null) {
                    FrdLikeVideoItemLayout primaryItem = FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryItem();
                    if (primaryItem == null) {
                        com.qzone.proxy.feedcomponent.b.i(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayStart] item is null");
                        return;
                    } else {
                        primaryItem.updateProgress(0L, primaryFeedData.getVideoInfo().videoTime, 0L);
                        return;
                    }
                }
                com.qzone.proxy.feedcomponent.b.i(FrdLikeVideoSlideFeedView.TAG, "[onVideoPlayStart] feedData or videoinfo is null, " + primaryFeedData);
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStop(BaseVideo baseVideo) {
            }
        };
        initUI(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playNextVideo() {
        postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.4
            @Override // java.lang.Runnable
            public void run() {
                int primaryPosition = FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryPosition() + 1;
                if (primaryPosition < FrdLikeVideoSlideFeedView.this.myAdapter.getCount()) {
                    FrdLikeVideoSlideFeedView.this.mViewPager.setCurrentItem(primaryPosition, true);
                }
            }
        }, 500L);
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

    public List<BaseVideo> getActiveBaseVideo() {
        FrdLikeVideoItemLayout primaryItem;
        ArrayList arrayList = new ArrayList();
        MyAdapter myAdapter = this.myAdapter;
        if (myAdapter != null && myAdapter.getPrimaryItem() != null && (primaryItem = this.myAdapter.getPrimaryItem()) != null && primaryItem.canAutoPlayNow()) {
            arrayList.add(this.myAdapter.getPrimaryItem().getAutoVideo());
        }
        return arrayList;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
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
        FrdLikeVideoItemLayout primaryItem;
        super.onRecycled();
        MyAdapter myAdapter = this.myAdapter;
        if (myAdapter != null && (primaryItem = myAdapter.getPrimaryItem()) != null && primaryItem.isPlaying()) {
            primaryItem.getAutoVideo().onPause();
        }
        this.mViewPager.setOnPageChangeListener(null);
        this.mFeedPosition = 0;
        this.mCurPlayFeedData = null;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        List<BaseVideo> activeBaseVideo;
        com.qzone.proxy.feedcomponent.b.a(TAG, "[onStateIdle] ");
        if (!com.qzone.adapter.feedcomponent.i.H().m() || (activeBaseVideo = getActiveBaseVideo()) == null || activeBaseVideo.size() <= 0) {
            return;
        }
        BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(activeBaseVideo);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
        com.qzone.proxy.feedcomponent.b.a(TAG, "[onStateScrolling] ");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "[setData] feedData is invalid");
            return;
        }
        super.setData(businessFeedData);
        if (businessFeedData.getRecommHeader() != null && !TextUtils.isEmpty(businessFeedData.getRecommHeader().leftTitle)) {
            str = businessFeedData.getRecommHeader().leftTitle;
        } else if (businessFeedData.isFrdLikeMiniAppContainer()) {
            str = "\u597d\u53cb\u5728\u73a9";
        } else {
            str = TITLE_TEXT_DEFAULT;
        }
        TextView textView = this.mTitleText;
        if (textView != null) {
            textView.setText(str);
        }
        setContentDescription(str);
        if (businessFeedData.isFrdLikeMiniAppContainer() && this.mTitleText != null) {
            Drawable drawable = AreaManager.FEED_FRD_LIKE_MINI_APP_LOGO;
            int i3 = AreaManager.dp15;
            drawable.setBounds(0, 0, i3, i3);
            this.mTitleText.setCompoundDrawablePadding(AreaManager.f48751dp2);
            this.mTitleText.setCompoundDrawables(drawable, null, null, null);
        }
        ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
        if (recBusinessFeedDatas != null && recBusinessFeedDatas.size() >= 3) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < recBusinessFeedDatas.size(); i16++) {
                BusinessFeedData businessFeedData2 = recBusinessFeedDatas.get(i16);
                if (i16 == 0) {
                    this.mCurPlayFeedData = businessFeedData2;
                }
                if (businessFeedData2 != null && businessFeedData2.getVideoInfo() != null && businessFeedData2.getVideoInfo().coverUrl != null && !TextUtils.isEmpty(businessFeedData2.getVideoInfo().coverUrl.url)) {
                    arrayList.add(businessFeedData2);
                } else {
                    com.qzone.proxy.feedcomponent.b.i(TAG, "invalid videoinfo @" + i16);
                }
            }
            if (arrayList.size() < 3) {
                com.qzone.proxy.feedcomponent.b.i(TAG, "[setFeedData] finalList.size() not enough");
                return;
            }
            com.qzone.proxy.feedcomponent.b.e(TAG, "[setFeedData] finalList.size()=" + arrayList.size());
            setVisibility(0);
            this.myAdapter.setData(arrayList, this.mFeedPosition);
            return;
        }
        com.qzone.proxy.feedcomponent.b.i(TAG, "[setFeedData] feedData.getRecBusinessFeedDatas().size() not enough");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class RoundRectOutlineProvider extends ViewOutlineProvider {
        RoundRectOutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, FrdLikeVideoSlideFeedView.ITEM_VIEW_WIDTH - (com.qzone.proxy.feedcomponent.util.g.a(8.0f) * 2), FrdLikeVideoSlideFeedView.ITEM_VIEW_HEIGHT, ViewUtils.dpToPx(6.0f));
        }
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
        this.myAdapter = new MyAdapter();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ITEM_VIEW_HEIGHT);
        layoutParams.setMargins(com.qzone.proxy.feedcomponent.util.g.a(8.0f), 0, com.qzone.proxy.feedcomponent.util.g.a(8.0f), com.qzone.proxy.feedcomponent.util.g.a(18.0f));
        MyWrapContentViewPager myWrapContentViewPager = new MyWrapContentViewPager(context);
        this.mViewPager = myWrapContentViewPager;
        myWrapContentViewPager.setAdapter(this.myAdapter);
        this.mViewPager.setOnPageChangeListener(new CenterViewPager.SimpleOnPageChangeListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.1
            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.SimpleOnPageChangeListener, com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[onPageScrollStateChanged] state=" + i3);
                if (i3 != 1 || FrdLikeVideoSlideFeedView.this.myAdapter == null || FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryItem() == null || FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryItem().getAutoVideo() == null) {
                    return;
                }
                FrdLikeVideoSlideFeedView.this.myAdapter.getPrimaryItem().getAutoVideo().onPause();
            }

            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.SimpleOnPageChangeListener, com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                com.qzone.proxy.feedcomponent.b.a(FrdLikeVideoSlideFeedView.TAG, "[onPageSelected] position=" + i3);
            }
        });
        addView(this.mViewPager, layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
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
        button.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(647));
        int i3 = AreaManager.dp15;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.rightMargin = AreaManager.dp10;
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        Rect rect = new Rect();
        this.mRightTopBtn.getHitRect(rect);
        rect.left -= 10;
        rect.top -= 10;
        rect.right += 10;
        rect.bottom += 10;
        this.mRightTopBtn.setTouchDelegate(new TouchDelegate(rect, this.mRightTopBtn));
        relativeLayout.addView(this.mRightTopBtn, layoutParams);
        this.mRightTopBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ClickedPoint clickedPoint = new ClickedPoint(FrdLikeVideoSlideFeedView.this.mRightTopBtn.getLeft(), FrdLikeVideoSlideFeedView.this.mRightTopBtn.getBottom(), 0, 0, FrdLikeVideoSlideFeedView.this.mRightTopBtn.getWidth(), FrdLikeVideoSlideFeedView.this.mRightTopBtn.getHeight());
                FrdLikeVideoSlideFeedView frdLikeVideoSlideFeedView = FrdLikeVideoSlideFeedView.this;
                frdLikeVideoSlideFeedView.onFeedElementClickListener.onClick(frdLikeVideoSlideFeedView, FeedElement.DROPDOWN_BUTTON, frdLikeVideoSlideFeedView.getMFeedPosition(), clickedPoint);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
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
