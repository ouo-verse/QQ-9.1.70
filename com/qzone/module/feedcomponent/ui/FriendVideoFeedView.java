package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.common.RoundedCornerRelativeLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellViewMore;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.AsyncImageView;
import com.tencent.litetransfersdk.LiteTransferType;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FriendVideoFeedView extends AbsFeedView implements FeedAutoVideo.OnVideoPlayStatusListener {
    private static final int ITEM_DIVIDER_WIDTH;
    public static final int PAGE_WIDTH_DEFAULT;
    private static final String TITLE_TEXT_DEFAULT = "\u597d\u53cb\u77ed\u89c6\u9891";
    public static final int VIEW_PAGER_INTERVEVAL;
    private static final int VIEW_PAGER_MARGIN = AreaManager.dp10;
    public static final Drawable avatarBorder;
    public static final Drawable avatarBorderWeishi;
    private List<BusinessFeedData> covers;
    private FriendVideoPagerAdapter mAdapter;
    List<BaseVideo> mCurrPlayList;
    private int mFeedPosition;
    private Button mRightTopBtn;
    private LinearLayout mTailLayout;
    private TextView mTailText;
    private HorizontalListView mViewPager;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    private RelativeLayout titleContainer;
    private TextView titleText;
    private ConcurrentMap<Integer, Integer> videoWidthMap;

    static {
        int i3 = AreaManager.f48753dp4;
        ITEM_DIVIDER_WIDTH = i3;
        PAGE_WIDTH_DEFAULT = AreaManager.dp200;
        VIEW_PAGER_INTERVEVAL = i3;
        avatarBorder = com.qzone.adapter.feedcomponent.j.g(839);
        avatarBorderWeishi = com.qzone.adapter.feedcomponent.j.g(872);
    }

    public FriendVideoFeedView(Context context) {
        super(context);
        this.covers = new ArrayList();
        this.videoWidthMap = new ConcurrentHashMap();
        this.mFeedPosition = -1;
        this.titleText = null;
        initUI(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollIdle() {
        if (getParent() instanceof ViewGroup) {
            com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onListViewIdleWithVideoCover((ViewGroup) getParent(), null, this.mAdapter, false);
            this.mCurrPlayList = getPlayVideos();
        }
    }

    private void updateTopContainer() {
        boolean isWeishiVideoContainer = isWeishiVideoContainer(this.mFeedData);
        if (this.titleText != null) {
            if (isWeishiVideoContainer) {
                Drawable drawable = AreaManager.QZONE_FEED_VIDEO_WEISHI_LOGO;
                int i3 = AreaManager.dp15;
                drawable.setBounds(0, 0, i3, i3);
                this.titleText.setCompoundDrawablePadding(AreaManager.f48751dp2);
                this.titleText.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            if (isMiniAppVideoContainer(this.mFeedData)) {
                Drawable drawable2 = AreaManager.FEED_FRD_LIKE_MINI_APP_LOGO;
                int i16 = AreaManager.dp15;
                drawable2.setBounds(0, 0, i16, i16);
                this.titleText.setCompoundDrawablePadding(AreaManager.f48751dp2);
                this.titleText.setCompoundDrawables(drawable2, null, null, null);
                return;
            }
            this.titleText.setCompoundDrawables(null, null, null, null);
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

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    public List<BaseVideo> getPlayVideoOnFeedListIdle() {
        int childCount = this.mViewPager.getChildCount();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (this.mViewPager.getChildAt(i3) instanceof FriendVideoItemLayout) {
                FriendVideoItemLayout friendVideoItemLayout = (FriendVideoItemLayout) this.mViewPager.getChildAt(i3);
                if (friendVideoItemLayout.getLeft() >= 0 && friendVideoItemLayout.getRight() <= ViewUtils.getScreenWidth() && friendVideoItemLayout.getVideoView() != null && friendVideoItemLayout.getVideoView().getAutoVideoView() != null) {
                    arrayList.add(friendVideoItemLayout.getVideoView().getAutoVideoView());
                    break;
                }
            }
            i3++;
        }
        return arrayList;
    }

    public List<BaseVideo> getPlayVideos() {
        int childCount = this.mViewPager.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.mViewPager.getChildAt(i3) instanceof FriendVideoItemLayout) {
                FriendVideoItemLayout friendVideoItemLayout = (FriendVideoItemLayout) this.mViewPager.getChildAt(i3);
                if (((Math.min(friendVideoItemLayout.getRight(), ViewUtils.getScreenWidth()) - Math.max(friendVideoItemLayout.getLeft(), 0)) * 1.0f) / (friendVideoItemLayout.getRight() - friendVideoItemLayout.getLeft()) >= 0.8d && friendVideoItemLayout.getVideoView() != null && friendVideoItemLayout.getVideoView().getAutoVideoView() != null) {
                    arrayList.add(friendVideoItemLayout.getVideoView().getAutoVideoView());
                }
            }
        }
        return arrayList;
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
        HorizontalListView horizontalListView = this.mViewPager;
        if (horizontalListView != null) {
            int currentX = horizontalListView.getCurrentX();
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null) {
                businessFeedData.scrollX = currentX;
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        this.mCurrPlayList = getPlayVideos();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayComplete(final BaseVideo baseVideo) {
        List<BaseVideo> list = this.mCurrPlayList;
        if (list == null || list.size() < 0) {
            this.mCurrPlayList = getPlayVideos();
        }
        List<BaseVideo> list2 = this.mCurrPlayList;
        if (list2 == null || list2.size() < 2) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.5
            @Override // java.lang.Runnable
            public void run() {
                int indexOf = FriendVideoFeedView.this.mCurrPlayList.indexOf(baseVideo) + 1;
                if (indexOf < FriendVideoFeedView.this.mCurrPlayList.size()) {
                    BaseVideo baseVideo2 = FriendVideoFeedView.this.mCurrPlayList.get(indexOf);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(baseVideo2);
                    BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(arrayList);
                }
            }
        }, 500L);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        try {
            com.qzone.reborn.feedx.widget.i.a(this.titleContainer, i3);
            com.qzone.reborn.feedx.widget.i.a(this.mViewPager, i3);
            com.qzone.reborn.feedx.widget.i.a(this.mTailLayout, i3);
        } catch (Throwable unused) {
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        String str;
        String str2;
        super.setData(businessFeedData);
        TextView textView = this.titleText;
        if (textView != null) {
            if (businessFeedData.getRecommHeader() == null) {
                str2 = TITLE_TEXT_DEFAULT;
            } else {
                str2 = businessFeedData.getRecommHeader().leftTitle;
            }
            textView.setText(str2);
        }
        if (businessFeedData.getRecommHeader() == null && com.qzone.adapter.feedcomponent.i.H().X0()) {
            com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", "getRecommHeader is null");
        }
        this.covers.clear();
        this.videoWidthMap.clear();
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", "feed set");
        }
        BusinessFeedData businessFeedData2 = null;
        for (int i3 = 0; i3 < businessFeedData.getRecBusinessFeedDatas().size(); i3++) {
            BusinessFeedData businessFeedData3 = businessFeedData.getRecBusinessFeedDatas().get(i3);
            if (businessFeedData3.getVideoInfo() != null && businessFeedData3.getVideoInfo().coverUrl != null && !TextUtils.isEmpty(businessFeedData3.getVideoInfo().coverUrl.url)) {
                if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\tis cover:");
                    sb5.append(businessFeedData3.isFriendVideoCoverFeed());
                    if (businessFeedData3.isFriendVideoCoverFeed()) {
                        str = "----------";
                    } else {
                        str = "";
                    }
                    sb5.append(str);
                    com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", sb5.toString());
                }
                if (businessFeedData3.isFriendVideoCoverFeed()) {
                    this.covers.add(businessFeedData3);
                    if (businessFeedData3.getRecBusinessFeedDatas() == null) {
                        businessFeedData3.setRecBusinessFeedDatas(new ArrayList<>());
                    } else {
                        businessFeedData3.getRecBusinessFeedDatas().clear();
                    }
                    businessFeedData2 = businessFeedData3;
                } else if (businessFeedData2 != null) {
                    businessFeedData2.getRecBusinessFeedDatas().add(businessFeedData3);
                } else {
                    com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "FIRST item of feeddata should be cover", new Exception());
                }
            } else {
                com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", String.format("videoInfo is null %d feedkey: %s time %s isBalcony:%s", Long.valueOf(businessFeedData3.getCellUserInfo().user.uin), businessFeedData3.getFeedCommInfo().feedskey, Long.valueOf(businessFeedData3.getFeedCommInfo().time), Boolean.valueOf(businessFeedData3.isBalconyFeed())));
            }
        }
        this.mAdapter.setData(this.covers, businessFeedData.getCellViewMore());
        this.mAdapter.notifyDataSetChanged();
        if (businessFeedData.getCellViewMore() != null && !TextUtils.isEmpty(businessFeedData.getCellViewMore().guide_content)) {
            this.mTailLayout.setVisibility(0);
            HorizontalListView horizontalListView = this.mViewPager;
            horizontalListView.setPadding(horizontalListView.getPaddingLeft(), this.mViewPager.getPaddingTop(), this.mViewPager.getPaddingRight(), 0);
            this.mTailText.setText(businessFeedData.getCellViewMore().guide_content);
        } else {
            this.mTailLayout.setVisibility(8);
            HorizontalListView horizontalListView2 = this.mViewPager;
            horizontalListView2.setPadding(horizontalListView2.getPaddingLeft(), this.mViewPager.getPaddingTop(), this.mViewPager.getPaddingRight(), AreaManager.dp10);
        }
        int i16 = businessFeedData.scrollX;
        if (i16 > 0) {
            this.mViewPager.resetCurrentX(i16);
        }
        updateTopContainer();
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
    public class FriendVideoPagerAdapter extends BaseAdapter {
        private CellViewMore mCellViewMore;
        public View mMorePageView;
        private boolean mNeedMorePageView;
        private List<BusinessFeedData> videobanners = new ArrayList();

        public FriendVideoPagerAdapter() {
        }

        public void destroy() {
            this.videobanners.clear();
            this.mCellViewMore = null;
            this.mNeedMorePageView = false;
        }

        public View generateMorePageView(CellViewMore cellViewMore) {
            Context context = FriendVideoFeedView.this.getContext();
            RoundedCornerRelativeLayout roundedCornerRelativeLayout = new RoundedCornerRelativeLayout(context);
            roundedCornerRelativeLayout.enableRoundedCorner(true);
            int i3 = AreaManager.dp200;
            int i16 = (int) ((i3 * 9) / 16.0f);
            roundedCornerRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(i16, i3));
            AsyncImageView asyncImageView = new AsyncImageView(context);
            asyncImageView.setLayoutParams(new RelativeLayout.LayoutParams(i16, i3));
            String str = cellViewMore.busi_param.get(153);
            asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            asyncImageView.setAsyncImage(str);
            roundedCornerRelativeLayout.addView(asyncImageView);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            roundedCornerRelativeLayout.addView(linearLayout);
            AsyncImageView asyncImageView2 = new AsyncImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            asyncImageView2.setLayoutParams(layoutParams);
            String str2 = cellViewMore.busi_param.get(154);
            asyncImageView2.setAsyncImage(str2);
            com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", String.format("iconUrl:%s", str2));
            linearLayout.addView(asyncImageView2);
            TextView textView = new TextView(context);
            asyncImageView2.setLayoutParams(layoutParams);
            textView.setGravity(17);
            textView.setText(cellViewMore.busi_param.get(109));
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = AreaManager.dp8;
            linearLayout.addView(textView, layoutParams2);
            return roundedCornerRelativeLayout;
        }

        public CellViewMore getCellViewMore() {
            return this.mCellViewMore;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<BusinessFeedData> list = this.videobanners;
            int size = list != null ? list.size() : 0;
            return this.mNeedMorePageView ? size + 1 : size;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.videobanners.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public int getPageWidthPx(int i3) {
            List<BusinessFeedData> list = this.videobanners;
            if (list != null && list.size() > 1) {
                int i16 = FriendVideoFeedView.PAGE_WIDTH_DEFAULT;
                return (i3 == 0 || i3 == this.videobanners.size() - 1) ? i16 + FriendVideoFeedView.VIEW_PAGER_MARGIN : i16;
            }
            return ViewUtils.getScreenWidth();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            final FriendVideoItemLayout friendVideoItemLayout;
            Integer valueOf;
            try {
                com.qzone.proxy.feedcomponent.b.e("FRIENDVIDEO", "position:" + i3);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "getView err", e16);
                view2 = view;
            }
            if (i3 == this.videobanners.size()) {
                if (this.mMorePageView == null) {
                    this.mMorePageView = generateMorePageView(this.mCellViewMore);
                }
                this.mMorePageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.FriendVideoPagerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        EventCollector.getInstance().onViewClickedBefore(view3);
                        if (FriendVideoFeedView.this.mAdapter.getCellViewMore() != null && FriendVideoFeedView.this.mAdapter.getCellViewMore().busi_param != null) {
                            String str = FriendVideoFeedView.this.mAdapter.getCellViewMore().busi_param.get(152);
                            FriendVideoFeedView friendVideoFeedView = FriendVideoFeedView.this;
                            friendVideoFeedView.onFeedElementClickListener.onClick(friendVideoFeedView, FeedElement.URL, friendVideoFeedView.getMFeedPosition(), new com.qzone.proxy.feedcomponent.model.e(str, null, FriendVideoFeedView.this.getMFeedPosition()));
                            try {
                                if (FriendVideoFeedView.this.mFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                                    if (WeishiHelper.isWeishiInstall(str)) {
                                        com.qzone.adapter.feedcomponent.i.H().f2(693, 3, 2, null);
                                    } else {
                                        com.qzone.adapter.feedcomponent.i.H().f2(693, 3, 3, null);
                                    }
                                } else {
                                    com.qzone.adapter.feedcomponent.i.H().f2(691, 3, 2, null);
                                }
                            } catch (Exception e17) {
                                com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e17);
                            }
                        }
                        EventCollector.getInstance().onViewClicked(view3);
                    }
                });
                try {
                    if (FriendVideoFeedView.this.mFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                        com.qzone.adapter.feedcomponent.i.H().f2(693, 3, 1, null);
                    } else {
                        com.qzone.adapter.feedcomponent.i.H().f2(691, 3, 1, null);
                    }
                } catch (Exception e17) {
                    com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e17);
                }
                view2 = this.mMorePageView;
                EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
                return view2;
            }
            if (view != null && (view instanceof FriendVideoItemLayout)) {
                friendVideoItemLayout = (FriendVideoItemLayout) view;
            } else {
                friendVideoItemLayout = new FriendVideoItemLayout(FriendVideoFeedView.this.getContext());
                if (friendVideoItemLayout.getVideoView() != null) {
                    friendVideoItemLayout.getVideoView().setOnVideoPlayStatusListener(FriendVideoFeedView.this);
                }
            }
            final BusinessFeedData businessFeedData = this.videobanners.get(i3);
            try {
                if (FriendVideoFeedView.this.mFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                    com.qzone.adapter.feedcomponent.i.H().q2(693, 2, 1, businessFeedData.getVideoInfo().actionUrl);
                } else {
                    com.qzone.adapter.feedcomponent.i.H().f2(691, 2, 1, null);
                }
                com.qzone.adapter.feedcomponent.i.H().p2(businessFeedData);
            } catch (Exception e18) {
                com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e18);
            }
            if (FriendVideoFeedView.this.videoWidthMap.containsKey(Integer.valueOf(i3))) {
                valueOf = (Integer) FriendVideoFeedView.this.videoWidthMap.get(Integer.valueOf(i3));
            } else {
                valueOf = Integer.valueOf(AreaManager.dp96);
                if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().coverUrl != null && businessFeedData.getVideoInfo().coverUrl.width != 0 && businessFeedData.getVideoInfo().coverUrl.height != 0) {
                    valueOf = Integer.valueOf((FriendVideoItemLayout.VIDEO_HEIGHT * businessFeedData.getVideoInfo().coverUrl.width) / businessFeedData.getVideoInfo().coverUrl.height);
                } else {
                    com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", "\u89c6\u9891cover\u5c3a\u5bf8\u4e3a0");
                }
                FriendVideoFeedView.this.videoWidthMap.put(Integer.valueOf(i3), valueOf);
            }
            friendVideoItemLayout.setFeedPos(FriendVideoFeedView.this.mFeedPosition, i3);
            friendVideoItemLayout.setData(businessFeedData, valueOf.intValue());
            friendVideoItemLayout.setCoverIndex(i3);
            if (friendVideoItemLayout.avatarImageView != null && friendVideoItemLayout.nickNameView != null) {
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.FriendVideoPagerAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        EventCollector.getInstance().onViewClickedBefore(view3);
                        if (FriendVideoFeedView.this.mFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                            FriendVideoFeedView friendVideoFeedView = FriendVideoFeedView.this;
                            friendVideoFeedView.onFeedElementClickListener.onClick(friendVideoItemLayout, FeedElement.FRIEND_VIDEO_CLICK_COVER, friendVideoFeedView.getMFeedPosition(), FriendVideoFeedView.this.covers);
                            try {
                                com.qzone.adapter.feedcomponent.i.H().f2(693, 2, 3, null);
                            } catch (Exception e19) {
                                com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e19);
                            }
                        } else {
                            try {
                                com.qzone.adapter.feedcomponent.i.H().f2(691, 2, 3, null);
                            } catch (Exception e26) {
                                com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e26);
                            }
                            FriendVideoItemLayout friendVideoItemLayout2 = friendVideoItemLayout;
                            long j3 = 0;
                            if (view3 == friendVideoItemLayout2.avatarImageView) {
                                FriendVideoFeedView friendVideoFeedView2 = FriendVideoFeedView.this;
                                com.qzone.proxy.feedcomponent.ui.g gVar = friendVideoFeedView2.onFeedElementClickListener;
                                FeedElement feedElement = FeedElement.USER_AVATAR;
                                int mFeedPosition = friendVideoFeedView2.getMFeedPosition();
                                BusinessFeedData businessFeedData2 = businessFeedData;
                                if (businessFeedData2 != null && businessFeedData2.getUser() != null) {
                                    j3 = businessFeedData.getUser().uin;
                                }
                                gVar.onClick(null, feedElement, mFeedPosition, Long.valueOf(j3));
                            } else if (view3 == friendVideoItemLayout2.nickNameView) {
                                FriendVideoFeedView friendVideoFeedView3 = FriendVideoFeedView.this;
                                com.qzone.proxy.feedcomponent.ui.g gVar2 = friendVideoFeedView3.onFeedElementClickListener;
                                FeedElement feedElement2 = FeedElement.FRIEND_NICKNAME;
                                int mFeedPosition2 = friendVideoFeedView3.getMFeedPosition();
                                BusinessFeedData businessFeedData3 = businessFeedData;
                                if (businessFeedData3 != null && businessFeedData3.getUser() != null) {
                                    j3 = businessFeedData.getUser().uin;
                                }
                                gVar2.onClick(friendVideoFeedView3, feedElement2, mFeedPosition2, Long.valueOf(j3));
                            } else if (view3 == friendVideoItemLayout2.praisview) {
                                if (!businessFeedData.getLikeInfoV2().isLiked) {
                                    friendVideoItemLayout.praisview.setImageDrawable(AreaManager.FEED_VIDEO_BANNER_PRAISE_P);
                                } else {
                                    friendVideoItemLayout.praisview.setImageDrawable(AreaManager.FEED_VIDEO_BANNER_PRAISE_N);
                                }
                                FriendVideoFeedView.this.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(friendVideoItemLayout.mIndex));
                                FriendVideoFeedView friendVideoFeedView4 = FriendVideoFeedView.this;
                                friendVideoFeedView4.onFeedElementClickListener.onClick(friendVideoFeedView4, FeedElement.PRAISE_BUTTON, friendVideoFeedView4.getMFeedPosition(), null);
                            }
                        }
                        EventCollector.getInstance().onViewClicked(view3);
                    }
                };
                friendVideoItemLayout.avatarImageView.setOnClickListener(onClickListener);
                friendVideoItemLayout.nickNameView.setOnClickListener(onClickListener);
                friendVideoItemLayout.praisview.setOnClickListener(onClickListener);
            }
            view2 = friendVideoItemLayout;
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
            com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "getView err", e16);
            view2 = view;
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }

        private boolean needMorePageView(CellViewMore cellViewMore) {
            HashMap<Integer, String> hashMap;
            if (cellViewMore == null || (hashMap = cellViewMore.busi_param) == null) {
                return false;
            }
            return !TextUtils.isEmpty(hashMap.get(109));
        }

        public void setData(List<BusinessFeedData> list, CellViewMore cellViewMore) {
            if (list != null) {
                this.videobanners.clear();
                this.videobanners.addAll(list);
            }
            this.mCellViewMore = cellViewMore;
            this.mNeedMorePageView = needMorePageView(cellViewMore);
            notifyDataSetChanged();
        }
    }

    private void stopPlayVideos() {
        this.mCurrPlayList = null;
    }

    public void initUI(Context context) {
        setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.titleContainer = relativeLayout;
        relativeLayout.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        initLeftTopUI(context, this.titleContainer);
        initRightTopUI(context, this.titleContainer);
        addView(this.titleContainer, new RelativeLayout.LayoutParams(-1, AreaManager.dp36));
        QzoneHorizontalListView qzoneHorizontalListView = new QzoneHorizontalListView(context);
        this.mViewPager = qzoneHorizontalListView;
        qzoneHorizontalListView.setPadding(AreaManager.dp8, 0, AreaManager.dp10, 0);
        this.mViewPager.setClipToPadding(false);
        this.mViewPager.setDividerWidth(ITEM_DIVIDER_WIDTH);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, new LinearLayout.LayoutParams(-1, FriendVideoItemLayout.VIDEO_HEIGHT));
        FriendVideoPagerAdapter friendVideoPagerAdapter = new FriendVideoPagerAdapter();
        this.mAdapter = friendVideoPagerAdapter;
        this.mViewPager.setAdapter((ListAdapter) friendVideoPagerAdapter);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTailLayout = linearLayout;
        linearLayout.setGravity(17);
        this.mTailLayout.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        this.mTailLayout.setOrientation(0);
        TextView textView = new TextView(context);
        this.mTailText = textView;
        textView.setText("\u5f00\u542f\u77ed\u89c6\u9891");
        this.mTailText.setTextColor(com.qzone.adapter.feedcomponent.j.F());
        this.mTailText.setTextSize(14.0f);
        this.mTailLayout.addView(this.mTailText, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(com.qzone.adapter.feedcomponent.j.g(LiteTransferType.MsgBodyType.MsgType_0x346));
        int i3 = AreaManager.dp20;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMargins(AreaManager.f48753dp4, 0, 0, 0);
        this.mTailLayout.addView(imageView, layoutParams);
        this.mTailLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                BusinessFeedData businessFeedData = FriendVideoFeedView.this.mFeedData;
                String str = (businessFeedData == null || businessFeedData.getCellViewMore() == null) ? null : businessFeedData.getCellViewMore().jump_url;
                if (FriendVideoFeedView.this.onFeedElementClickListener == null && businessFeedData != null && businessFeedData.getCellViewMore() != null && !TextUtils.isEmpty(str)) {
                    try {
                        if (FriendVideoFeedView.this.mFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                            if (WeishiHelper.isWeishiInstall(str)) {
                                com.qzone.adapter.feedcomponent.i.H().f2(693, 4, 1, null);
                            } else {
                                com.qzone.adapter.feedcomponent.i.H().f2(693, 4, 2, null);
                            }
                        } else {
                            com.qzone.adapter.feedcomponent.i.H().f2(691, 4, 0, null);
                        }
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e16);
                    }
                    FriendVideoFeedView friendVideoFeedView = FriendVideoFeedView.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = friendVideoFeedView.onFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(friendVideoFeedView, FeedElement.URL, friendVideoFeedView.getMFeedPosition(), new com.qzone.proxy.feedcomponent.model.e(str, null, FriendVideoFeedView.this.getMFeedPosition()));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, AreaManager.dp44);
        layoutParams2.gravity = 1;
        this.mViewPager.setOnScrollStateChangedListener(new HorizontalListView.OnScrollStateChangedListener() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.2
            @Override // com.tencent.widget.HorizontalListView.OnScrollStateChangedListener
            public void onScrollStateChanged(int i16) {
                if (i16 != 4097) {
                    return;
                }
                FriendVideoFeedView.this.onScrollIdle();
            }
        });
        this.mViewPager.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i16, j3);
                if (i16 >= FriendVideoFeedView.this.covers.size()) {
                    if (FriendVideoFeedView.this.mAdapter != null && FriendVideoFeedView.this.mAdapter.mMorePageView != null) {
                        FriendVideoFeedView.this.mAdapter.mMorePageView.performClick();
                    }
                } else {
                    FriendVideoFeedView friendVideoFeedView = FriendVideoFeedView.this;
                    friendVideoFeedView.onFeedElementClickListener.onClick(view, FeedElement.FRIEND_VIDEO_CLICK_COVER, friendVideoFeedView.getMFeedPosition(), FriendVideoFeedView.this.covers);
                    try {
                        if (FriendVideoFeedView.this.mFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                            com.qzone.adapter.feedcomponent.i.H().f2(693, 2, 2, null);
                        } else {
                            com.qzone.adapter.feedcomponent.i.H().f2(691, 2, 2, null);
                        }
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.b.d("FRIENDVIDEO", "report err", e16);
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i16, j3);
            }
        });
        addView(this.mTailLayout, layoutParams2);
    }

    public static boolean isMiniAppVideoContainer(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            r0 = (businessFeedData.getFeedCommInfo().feedsAttr2 & 4194304) != 0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("feedid = ");
            sb5.append(businessFeedData.getFeedCommInfo().feedsid);
            if (r0) {
                str = " \u5c0f\u7a0b\u5e8f\u89c6\u9891";
            } else {
                str = " \u4e0d\u662f\u5c0f\u7a0b\u5e8f\u89c6\u9891";
            }
            sb5.append(str);
            com.qzone.proxy.feedcomponent.b.e("FRIENDVIDEO", sb5.toString());
        }
        return r0;
    }

    public static boolean isWeishiVideoContainer(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            r0 = (businessFeedData.getFeedCommInfo().feedsAttr2 & 4194304) != 0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("feedid = ");
            sb5.append(businessFeedData.getFeedCommInfo().feedsid);
            if (r0) {
                str = " \u5fae\u89c6\u89c6\u9891";
            } else {
                str = " \u4e0d\u662f\u5fae\u89c6\u89c6\u9891";
            }
            sb5.append(str);
            com.qzone.proxy.feedcomponent.b.e("FRIENDVIDEO", sb5.toString());
        }
        return r0;
    }

    private void initLeftTopUI(Context context, RelativeLayout relativeLayout) {
        if (context == null || relativeLayout == null) {
            return;
        }
        TextView textView = new TextView(context);
        this.titleText = textView;
        textView.setText(TITLE_TEXT_DEFAULT);
        this.titleText.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        this.titleText.setTextSize(14.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = AreaManager.dp8;
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.titleText, layoutParams);
    }

    private void initRightTopUI(Context context, RelativeLayout relativeLayout) {
        if (context == null || relativeLayout == null) {
            return;
        }
        Button button = new Button(context);
        this.mRightTopBtn = button;
        button.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(929));
        int i3 = AreaManager.dp20;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.rightMargin = AreaManager.dp10;
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.mRightTopBtn, layoutParams);
        this.mRightTopBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendVideoFeedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ClickedPoint clickedPoint = new ClickedPoint(FriendVideoFeedView.this.mRightTopBtn.getLeft(), FriendVideoFeedView.this.mRightTopBtn.getBottom(), 0, 0, FriendVideoFeedView.this.mRightTopBtn.getWidth(), FriendVideoFeedView.this.mRightTopBtn.getHeight());
                FriendVideoFeedView friendVideoFeedView = FriendVideoFeedView.this;
                friendVideoFeedView.onFeedElementClickListener.onClick(friendVideoFeedView, FeedElement.DROPDOWN_BUTTON, friendVideoFeedView.getMFeedPosition(), clickedPoint);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void onScrollFling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayStart(BaseVideo baseVideo) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayStop(BaseVideo baseVideo) {
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
