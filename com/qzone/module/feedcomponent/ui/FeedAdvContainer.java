package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.qzone.module.feedcomponent.actionreport.UserActionReportHelper;
import com.qzone.module.feedcomponent.ui.common.CenterViewPager;
import com.qzone.module.feedcomponent.ui.common.PagerAdapter;
import com.qzone.module.feedcomponent.ui.common.WrapContentViewPager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedAdvContainer extends AbsFeedView {
    static final int CONTENT_FEED_FRIENDS_BIRTHDAY = 3004;
    static final int CONTENT_FEED_FUNCTIONGUIDE = 3005;
    static final int CONTENT_FEED_LIKE_FRIEND_CONTAINER = 3006;
    static final int CONTENT_FEED_RECOMMEND_FRIENDS = 3003;
    static final int CONTENT_MULTI_ADV = 3001;
    static final int CONTENT_SPECIAL_CARE = 3002;
    private static String lookUpMoreText = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AdvContainerLookUpMore", "\u67e5\u770b\u66f4\u591a");
    final String TAG;
    int contentType;
    FeedContainerPreScroll feedContainerPreScroll;
    boolean hasRecyled;
    boolean hasReportInitialCard;
    private boolean isFriendLikeContainer;
    private final int isShowBirthdayGifPanelLastPage;
    private final Set<Integer> lastReportIndexSet;
    FeedContainerViewPager mAdapter;
    public Drawable mBackgroundDrawable;
    Context mContext;
    int mCurrPageIndex;
    boolean mDataFilled;
    int mDownX;
    int mDownY;
    BusinessFeedData mFeedData;
    int mFeedPos;
    com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    public com.qzone.proxy.feedcomponent.ui.h mOnFeedEventListener;
    public Drawable mTopBackGroundDrawable;
    int mTrans;
    WrapContentViewPager mViewPager;
    boolean needFillBlackArea;
    Paint paint;
    FeedRecommBottom recommBottomView;
    FeedRecommHeader recommHeaderView;
    boolean scrollDirectionDetermined;
    int showingCardQuantity;

    public FeedAdvContainer(Context context, BusinessFeedData businessFeedData) {
        super(context);
        this.TAG = "FeedAdvContainer";
        this.mFeedPos = -1;
        this.contentType = 3001;
        this.mTrans = 255;
        this.isFriendLikeContainer = false;
        this.isShowBirthdayGifPanelLastPage = com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "sepcialBirthGiftLastPage", 0);
        this.paint = new Paint();
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
        this.mOnFeedEventListener = new com.qzone.proxy.feedcomponent.ui.h() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.3
            @Override // com.qzone.proxy.feedcomponent.ui.h
            public void onEvent(View view, int i3, int i16, Object obj) {
                WrapContentViewPager wrapContentViewPager;
                if (i3 == 10000 && i16 == 1 && (wrapContentViewPager = FeedAdvContainer.this.mViewPager) != null) {
                    wrapContentViewPager.setCurrentItem(wrapContentViewPager.getCurrentItem() + 1, true);
                }
            }
        };
        this.lastReportIndexSet = new HashSet();
        this.mContext = context;
        this.type = 2;
        setOrientation(1);
        setContentType(businessFeedData);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRecommendType() {
        int i3 = this.contentType;
        return i3 == 3003 || i3 == 3002;
    }

    public void deleteFeedDataAndUpdate(BusinessFeedData businessFeedData) {
        com.qzone.proxy.feedcomponent.ui.g gVar;
        FeedContainerViewPager feedContainerViewPager = this.mAdapter;
        if (feedContainerViewPager != null) {
            feedContainerViewPager.deleteFeedDataAndUpdate(businessFeedData);
            if (this.mAdapter.getCount() == 0) {
                int i3 = this.contentType;
                if ((i3 == 3003 || i3 == 3002 || i3 == 3002 || i3 == 3004) && (gVar = this.mOnFeedElementClickListener) != null) {
                    gVar.onClick(this, FeedElement.FEEDBACK, this.mFeedPos, -1);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r2 != 3) goto L26;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.scrollDirectionDetermined) {
                        int abs = Math.abs(x16 - this.mDownX);
                        int abs2 = Math.abs(y16 - this.mDownY);
                        if (Math.max(abs, abs2) > AreaConst.SCROLL_DIRECTION_THRESHHOLD) {
                            this.scrollDirectionDetermined = true;
                        }
                        if (abs < abs2 && getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
            this.scrollDirectionDetermined = false;
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            this.mDownX = x16;
            this.mDownY = y16;
        }
        UserActionReportHelper.containerOnTouchEvent(motionEvent, this.mAdapter);
        return super.dispatchTouchEvent(motionEvent);
    }

    public FeedView getCurrentFeedView() {
        View subView;
        FeedContainerViewPager feedContainerViewPager = this.mAdapter;
        if (feedContainerViewPager == null || (subView = feedContainerViewPager.getSubView(this.mCurrPageIndex)) == null || !(subView instanceof FeedView)) {
            return null;
        }
        resetView(subView);
        return (FeedView) subView;
    }

    public BusinessFeedData getFeedData() {
        return this.mFeedData;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPos;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public View getFollowButtonPos(Rect rect) {
        FeedView currentFeedView = getCurrentFeedView();
        if (currentFeedView != null) {
            return currentFeedView.getFollowButtonPos(rect);
        }
        return null;
    }

    public int getNextScorllFamousSpacePos(int i3) {
        CellRecommItem cellRecommItem;
        if (this.mAdapter == null) {
            return -1;
        }
        while (true) {
            i3++;
            if (i3 >= this.mAdapter.getCount()) {
                i3 = -1;
                break;
            }
            BusinessFeedData item = this.mAdapter.getItem(i3);
            if (item != null && (cellRecommItem = item.cellRecommItem) != null && !cellRecommItem.isFollowed) {
                break;
            }
        }
        return (i3 < this.mAdapter.getCount() + (-2) || i3 <= 0) ? i3 - 1 : this.mAdapter.getCount() - 3;
    }

    public int getshowingCardQuantity() {
        return this.showingCardQuantity;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    void initUI() {
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i3 = this.contentType;
        if (i3 != 3002 && i3 != 3003 && i3 != 3004) {
            layoutParams.setMargins(0, AreaConst.dp10, 0, 0);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        FeedRecommHeader feedRecommHeader = new FeedRecommHeader(this.mContext, null);
        this.recommHeaderView = feedRecommHeader;
        addView(feedRecommHeader, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.mViewPager = new WrapContentViewPager(this.mContext);
        FeedContainerViewPager feedContainerViewPager = new FeedContainerViewPager();
        this.mAdapter = feedContainerViewPager;
        this.mViewPager.setAdapter(feedContainerViewPager);
        addView(this.mViewPager, layoutParams2);
        this.mViewPager.setOnPageChangeListener(new CenterViewPager.OnPageChangeListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.1
            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageSelected(int i16) {
                ArrayList<BusinessFeedData> recBusinessFeedDatas;
                com.qzone.proxy.feedcomponent.b.e("FeedContainerViewPager", "onPageSelected:" + i16);
                View subView = FeedAdvContainer.this.mAdapter.getSubView(i16);
                if (subView != null && (subView instanceof FeedView)) {
                    ((FeedView) subView).startVideoIfNeed();
                }
                FeedAdvContainer.this.resetView(subView);
                FeedAdvContainer feedAdvContainer = FeedAdvContainer.this;
                if (feedAdvContainer.mCurrPageIndex != i16) {
                    feedAdvContainer.reportRecommendCardExposure(i16, feedAdvContainer.showingCardQuantity);
                    FeedAdvContainer feedAdvContainer2 = FeedAdvContainer.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedAdvContainer2.mOnFeedElementClickListener;
                    if (gVar != null && feedAdvContainer2.contentType == 3001) {
                        gVar.onClick(feedAdvContainer2.mAdapter.getSubView(i16), FeedElement.ADV_CONTAINER, FeedAdvContainer.this.mFeedPos, null);
                    }
                }
                FeedAdvContainer feedAdvContainer3 = FeedAdvContainer.this;
                feedAdvContainer3.mCurrPageIndex = i16;
                BusinessFeedData businessFeedData = feedAdvContainer3.mFeedData;
                if (businessFeedData != null) {
                    businessFeedData.currShowIndex = i16;
                    int i17 = feedAdvContainer3.contentType;
                    int i18 = 0;
                    if (i17 == 3002) {
                        while (true) {
                            FeedAdvContainer feedAdvContainer4 = FeedAdvContainer.this;
                            if (i18 >= feedAdvContainer4.showingCardQuantity) {
                                break;
                            }
                            feedAdvContainer4.reportExposureOfSpecialCareCard(feedAdvContainer4.mFeedPos, feedAdvContainer4.mFeedData, feedAdvContainer4.mCurrPageIndex + i18);
                            i18++;
                        }
                    } else if (i17 == 3003 && (recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas()) != null && recBusinessFeedDatas.size() > 0) {
                        while (true) {
                            FeedAdvContainer feedAdvContainer5 = FeedAdvContainer.this;
                            if (i18 >= feedAdvContainer5.showingCardQuantity) {
                                break;
                            }
                            feedAdvContainer5.reportExposeFriendsCookies(feedAdvContainer5.mFeedData, feedAdvContainer5.mCurrPageIndex + i18);
                            i18++;
                        }
                    }
                }
                FeedAdvContainer feedAdvContainer6 = FeedAdvContainer.this;
                UserActionReportHelper.feedAdvContainerPageSelected(feedAdvContainer6.mCurrPageIndex, feedAdvContainer6.mAdapter.getCount(), FeedAdvContainer.this.mAdapter);
                FeedAdvContainer feedAdvContainer7 = FeedAdvContainer.this;
                feedAdvContainer7.feedContainerPreScroll.feedScrolledByUser(feedAdvContainer7.mFeedData);
            }

            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i16) {
            }

            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageScrolled(int i16, float f16, int i17) {
            }
        });
        int i16 = this.contentType;
        if (i16 != 3002 && i16 != 3003 && i16 != 3004) {
            this.mBackgroundDrawable = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON);
        } else {
            this.mBackgroundDrawable = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
        }
        this.mTopBackGroundDrawable = new ColorDrawable(com.qzone.adapter.feedcomponent.j.E());
        setWillNotDraw(false);
        setupShowingCardQuantity();
        this.feedContainerPreScroll = new FeedContainerPreScroll();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int i17 = this.contentType;
        if (i17 == 3002 || i17 == 3003) {
            layoutParams3.setMargins(0, -AreaConst.dp15, 0, 0);
        }
        FeedRecommBottom feedRecommBottom = new FeedRecommBottom(this.mContext, null);
        this.recommBottomView = feedRecommBottom;
        addView(feedRecommBottom, layoutParams3);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
            ColorDrawable colorDrawable = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
            this.mBackgroundDrawable = colorDrawable;
            colorDrawable.setAlpha(this.mTrans);
            this.mBackgroundDrawable.setBounds(0, AreaConst.dp15, getMeasuredWidth(), getMeasuredHeight());
            this.mBackgroundDrawable.draw(canvas);
            super.onDraw(canvas);
            return;
        }
        int i3 = this.contentType;
        if (i3 != 3002 && i3 != 3003 && i3 != 3004) {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2 != null && businessFeedData2.getFeedCommInfo().isBizRecomFamousFeeds()) {
                this.paint.setColor(com.qzone.adapter.feedcomponent.j.m());
                this.paint.setAlpha(this.mTrans);
                int i16 = AreaConst.dp10;
                canvas.drawRect(0.0f, i16, getMeasuredWidth(), getMeasuredHeight(), this.paint);
                this.paint.setColor(com.qzone.adapter.feedcomponent.j.s());
                this.paint.setAlpha(this.mTrans);
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), i16, this.paint);
                return;
            }
            ColorDrawable colorDrawable2 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
            this.mBackgroundDrawable = colorDrawable2;
            colorDrawable2.setAlpha(this.mTrans);
            this.mBackgroundDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.mBackgroundDrawable.draw(canvas);
            if (this.needFillBlackArea) {
                ColorDrawable colorDrawable3 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.E());
                this.mTopBackGroundDrawable = colorDrawable3;
                colorDrawable3.setAlpha(this.mTrans);
                this.mTopBackGroundDrawable.setBounds(0, 0, getMeasuredWidth(), AreaConst.FEED_VIEW_TOP_BLACK_AREA);
                this.mTopBackGroundDrawable.draw(canvas);
                this.mTopBackGroundDrawable.setBounds(0, this.mBackgroundDrawable.getBounds().bottom - AreaConst.FEED_VIEW_BOTTOM_BLACK_AREA, getMeasuredWidth(), this.mBackgroundDrawable.getBounds().bottom);
                this.mTopBackGroundDrawable.draw(canvas);
                Drawable drawable = this.mTopBackGroundDrawable;
                int i17 = AreaConst.FEED_VIEW_LEFT_RIGH_BLACK_AREA;
                drawable.setBounds(0, 0, i17, this.mBackgroundDrawable.getBounds().bottom);
                this.mTopBackGroundDrawable.draw(canvas);
                this.mTopBackGroundDrawable.setBounds(getMeasuredWidth() - i17, 0, getMeasuredWidth(), this.mBackgroundDrawable.getBounds().bottom);
                this.mTopBackGroundDrawable.draw(canvas);
            }
            super.onDraw(canvas);
            return;
        }
        ColorDrawable colorDrawable4 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
        this.mBackgroundDrawable = colorDrawable4;
        colorDrawable4.setAlpha(this.mTrans);
        this.mBackgroundDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.mBackgroundDrawable.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onPause() {
        int count = this.mAdapter.getCount();
        FeedView feedView = null;
        for (int i3 = 0; i3 < count; i3++) {
            View subView = this.mAdapter.getSubView(i3);
            if (subView != null && (subView instanceof FeedView)) {
                feedView = (FeedView) this.mAdapter.getSubView(i3);
            }
            if (feedView != null) {
                feedView.onPause();
            }
        }
        super.onPause();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onRecycled(boolean z16) {
        super.onRecycled(z16);
        int count = this.mAdapter.getCount();
        for (int i3 = 0; i3 < count; i3++) {
            View subView = this.mAdapter.getSubView(i3);
            if (subView != null && (subView instanceof FeedView)) {
                FeedView feedView = (FeedView) subView;
                if (feedView.getParent() != null) {
                    ((ViewGroup) feedView.getParent()).removeView(feedView);
                }
                feedView.onRecycled(z16);
                ViewLoader.getInstance().recycleFeedViewInAdvContainer(feedView);
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        FeedView currentFeedView = getCurrentFeedView();
        if (currentFeedView != null) {
            currentFeedView.onStateIdle();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void preScrollContent(ListAdapter listAdapter) {
        this.feedContainerPreScroll.preScrollContent(this.mFeedData, this.mViewPager, (AreaConst.cardContainerWidth * 1) / 5, listAdapter, this.mFeedPos);
    }

    void reportExposureOfSpecialCareCard(final int i3, final BusinessFeedData businessFeedData, final int i16) {
        FeedGlobalEnv.g().getBackgroundHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.2
            @Override // java.lang.Runnable
            public void run() {
                CellRecommItem cellRecommItem;
                User user;
                if (!businessFeedData.isSpecialCareInContainerFeed() || FeedAdvContainer.this.mOnFeedElementClickListener == null || businessFeedData.getRecBusinessFeedDatas() == null || businessFeedData.getRecBusinessFeedDatas().size() <= i16) {
                    return;
                }
                FeedAdvContainer.this.mOnFeedElementClickListener.onClick(null, FeedElement.SPECIAL_CARE_IN_CONTAINER_EXPOSURE, i3, businessFeedData.getRecBusinessFeedDatas().get(i16));
                BusinessFeedData businessFeedData2 = businessFeedData.getRecBusinessFeedDatas().get(i16);
                if (businessFeedData2 == null || (cellRecommItem = businessFeedData2.cellRecommItem) == null || (user = cellRecommItem.userInfo) == null || user.uin <= 0) {
                    return;
                }
                com.qzone.adapter.feedcomponent.i.H().f2(619, 11, 7, String.valueOf(businessFeedData2.cellRecommItem.userInfo.uin));
            }
        });
    }

    public void scrollWhenSendFriendRecommendSuccess(int i3, boolean z16) {
        WrapContentViewPager wrapContentViewPager = this.mViewPager;
        if (wrapContentViewPager != null) {
            wrapContentViewPager.setCurrentItem(i3, z16);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        this.mTrans = i3;
    }

    void setContentType(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            if (businessFeedData.isMultiAdvContainerFeed()) {
                this.contentType = 3001;
                return;
            }
            if (businessFeedData.isSpecialCareInContainerFeed()) {
                this.contentType = 3002;
                return;
            }
            if (!businessFeedData.isCardFriendsRecommendContainerFeed() && !businessFeedData.isCardSchoolRecommendContainerFeed() && !businessFeedData.isCardFollowMoreRecommendContainerFeed() && !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                if (businessFeedData.isFriendBirthdayContainerFeed()) {
                    this.contentType = 3004;
                    return;
                } else if (businessFeedData.isFunctionGuideFeed()) {
                    this.contentType = 3005;
                    return;
                } else {
                    this.contentType = 3001;
                    com.qzone.proxy.feedcomponent.b.c("FeedAdvContainer", "setContentType invalid type");
                    return;
                }
            }
            this.contentType = 3003;
            return;
        }
        this.contentType = 3001;
        com.qzone.proxy.feedcomponent.b.c("FeedAdvContainer", "setContentType data null");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPos = i3;
        this.mAdapter.mFeedPos = i3;
        this.recommHeaderView.setFeedPosition(i3);
        this.recommBottomView.setFeedPosition(i3);
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(this.mFeedPos));
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
        this.needFillBlackArea = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
        this.mAdapter.mOnFeedElementClickListener = gVar;
        this.recommHeaderView.setOnFeedElementClickListener(gVar);
        this.recommBottomView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
    }

    void setUIParams() {
        int i3 = this.contentType;
        if (i3 == 3002 || i3 == 3003) {
            this.mViewPager.setCenterModeChildren(true, false);
            this.mViewPager.setEnableScroll(true);
            this.mViewPager.setPageMargin(com.qzone.adapter.feedcomponent.j.f(283));
            int i16 = isRecommendType() ? 292 : FilterEnum.MIC_PTU_TRANS_KONGCHENG;
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null && businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                this.mViewPager.setDefaultHeight(com.qzone.adapter.feedcomponent.j.f(i16) + AreaConst.dp20 + AreaConst.dp15);
            } else {
                this.mViewPager.setDefaultHeight(com.qzone.adapter.feedcomponent.j.f(i16) + AreaConst.dp10);
            }
            this.mViewPager.setOverScrollMode(2);
            setPadding(0, 0, 0, 0);
            return;
        }
        if (i3 == 3004) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mViewPager.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.mViewPager.setPadding(0, 0, 0, 0);
            this.mViewPager.setDefaultHeight(com.qzone.proxy.feedcomponent.util.g.a(207.0f));
            this.mViewPager.setPreMeasureChildToMeasureHeight(true);
            this.mViewPager.setPageMargin(0);
            this.mViewPager.setLayoutParams(layoutParams);
            setPadding(0, 0, 0, AreaConst.dp10);
            return;
        }
        this.mViewPager.setCenterModeChildren(true, true);
        this.mViewPager.setCurrentItemInCenter(this.mCurrPageIndex);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mViewPager.getLayoutParams();
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 != null && businessFeedData2.getFeedCommInfo().isBizRecomFamousFeeds()) {
            this.mViewPager.setPadding(0, 0, 0, 0);
            layoutParams2.setMargins(0, 0, 0, AreaConst.dp10);
            this.mViewPager.setDefaultHeight((int) ((AreaConst.feedWidth_Rec / 1.778f) + ExFeedTitleView.HEIGHT));
        } else {
            setPadding(0, 0, 0, 0);
            BusinessFeedData businessFeedData3 = this.mFeedData;
            if (businessFeedData3 != null && businessFeedData3.isFriendLikeContainer()) {
                layoutParams2.setMargins(0, 0, 0, this.mFeedData.getCellViewMore() != null ? 0 : AreaConst.dp10);
            } else {
                layoutParams2.setMargins(0, 0, 0, AreaConst.dp14);
            }
            this.mViewPager.setPadding(0, AreaConst.f48748dp3, 0, 0);
            this.mViewPager.setDefaultHeight((int) (AreaConst.feedWidth_Rec * 1.2f));
        }
        this.mViewPager.setLayoutParams(layoutParams2);
    }

    void setupShowingCardQuantity() {
        this.showingCardQuantity = FeedGlobalEnv.g().getScreenWidth() / com.qzone.adapter.feedcomponent.j.f(isRecommendType() ? 291 : FilterEnum.MIC_PTU_TRANS_XINXIAN);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || businessFeedData2.getRecBusinessFeedDatas() == null || this.mFeedData.getRecBusinessFeedDatas().size() <= 0) {
            return;
        }
        boolean z17 = this.mFeedData.isCardFriendsRecommendContainerFeed() || this.mFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || this.mFeedData.isCardSchoolRecommendContainerFeed() || this.mFeedData.isCardFollowMoreRecommendContainerFeed();
        for (int i3 = 0; i3 < this.mFeedData.getRecBusinessFeedDatas().size(); i3++) {
            BusinessFeedData businessFeedData3 = this.mFeedData.getRecBusinessFeedDatas().get(i3);
            if (z17) {
                if (businessFeedData3.getRecommItem() != null && j3 == businessFeedData3.getRecommItem().userInfo.uin) {
                    businessFeedData3.getFeedCommInfo().isFollowed = z16;
                    if (businessFeedData3.getRecommAction() != null) {
                        businessFeedData3.getRecommAction().hasFollowed = z16 ? 1 : 0;
                    }
                    if (businessFeedData3.getRecommItem() != null) {
                        businessFeedData3.getRecommItem().isFollowed = z16;
                    }
                    View subView = this.mAdapter.getSubView(i3);
                    if (subView != null && (subView instanceof AbsFeedView)) {
                        FeedViewBuilder.updateFollowInfo(this.mContext, (AbsFeedView) subView, businessFeedData3);
                    }
                }
            } else if (j3 == businessFeedData3.getUser().uin) {
                businessFeedData3.getFeedCommInfo().isFollowed = z16;
                if (businessFeedData3.getRecommAction() != null) {
                    businessFeedData3.getRecommAction().hasFollowed = z16 ? 1 : 0;
                }
                View subView2 = this.mAdapter.getSubView(i3);
                if (subView2 != null && (subView2 instanceof AbsFeedView)) {
                    FeedViewBuilder.updateFollowInfo(this.mContext, (AbsFeedView) subView2, businessFeedData3);
                }
            }
        }
    }

    public void updateRecommendFriendsUI(String str) {
        FeedContainerViewPager feedContainerViewPager;
        if (this.contentType == 3003 && (feedContainerViewPager = this.mAdapter) != null) {
            feedContainerViewPager.updateViewDatas(str);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || businessFeedData2.getRecBusinessFeedDatas() == null || this.mFeedData.getRecBusinessFeedDatas().size() <= 0) {
            return;
        }
        boolean z17 = this.mFeedData.isCardFriendsRecommendContainerFeed() || this.mFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || this.mFeedData.isCardSchoolRecommendContainerFeed() || this.mFeedData.isCardFollowMoreRecommendContainerFeed();
        for (int i3 = 0; i3 < this.mFeedData.getRecBusinessFeedDatas().size(); i3++) {
            BusinessFeedData businessFeedData3 = this.mFeedData.getRecBusinessFeedDatas().get(i3);
            if (z17) {
                if (businessFeedData3.getRecommItem() != null && j3 == businessFeedData3.getRecommItem().userInfo.uin) {
                    businessFeedData3.getFeedCommInfo().isSpecialFollowed = z16;
                    if (businessFeedData3.getRecommItem() != null) {
                        businessFeedData3.getRecommItem().iSpecialFollowed = z16;
                    }
                    View subView = this.mAdapter.getSubView(i3);
                    if (subView != null && (subView instanceof AbsFeedView)) {
                        FeedViewBuilder.updateFollowInfo(this.mContext, (AbsFeedView) subView, businessFeedData3);
                    }
                }
            } else if (j3 == businessFeedData3.getUser().uin) {
                businessFeedData3.getFeedCommInfo().isSpecialFollowed = z16;
                View subView2 = this.mAdapter.getSubView(i3);
                if (subView2 != null && (subView2 instanceof AbsFeedView)) {
                    FeedViewBuilder.updateFollowInfo(this.mContext, (AbsFeedView) subView2, businessFeedData3);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class FeedContainerViewPager extends PagerAdapter {
        final String TAG = "FeedContainerViewPager";
        protected final List<BusinessFeedData> feedDataList = new ArrayList();
        protected ArrayList<LinearLayout> listViews;
        protected int mContentType;
        protected int mFeedPos;
        protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
        protected List<BusinessFeedData> realFeedDataList;

        public FeedContainerViewPager() {
            resetViewLists();
        }

        public void deleteFeedDataAndUpdate(BusinessFeedData businessFeedData) {
            WrapContentViewPager wrapContentViewPager;
            if (this.feedDataList == null || businessFeedData == null) {
                return;
            }
            this.realFeedDataList.remove(businessFeedData);
            if (this.feedDataList.remove(businessFeedData)) {
                resetViewLists();
                notifyDataSetChanged();
            }
            if ((businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || businessFeedData.isFriendBirthdayContainerFeed()) && getCount() <= FeedAdvContainer.this.getshowingCardQuantity() && (wrapContentViewPager = FeedAdvContainer.this.mViewPager) != null) {
                wrapContentViewPager.setEnableScroll(false);
                FeedAdvContainer.this.mViewPager.setCurrentItem(0, false);
                if (businessFeedData.isFriendBirthdayContainerFeed()) {
                    FeedAdvContainer.this.mViewPager.setCenterModeChildren(true, false);
                }
            }
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            com.qzone.proxy.feedcomponent.b.e("FeedContainerViewPager", "destroyItem position:" + i3);
            LinearLayout linearLayout = (LinearLayout) obj;
            View childAt = linearLayout.getChildAt(0);
            if (childAt instanceof FeedView) {
                ViewLoader.getInstance().recycleFeedViewInAdvContainer((FeedView) childAt);
            }
            linearLayout.removeAllViews();
            viewGroup.removeView(linearLayout);
            if (i3 < this.listViews.size()) {
                this.listViews.set(i3, null);
            }
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getCount() {
            List<BusinessFeedData> list = this.feedDataList;
            if (list != null) {
                FeedAdvContainer feedAdvContainer = FeedAdvContainer.this;
                switch (feedAdvContainer.contentType) {
                    case 3001:
                        return list.size();
                    case 3002:
                        return list.size();
                    case 3003:
                        return list.size();
                    case 3004:
                        if (feedAdvContainer.isShowBirthdayGifPanelLastPage == 1) {
                            return this.feedDataList.size() + 1;
                        }
                        return this.feedDataList.size();
                }
            }
            return 0;
        }

        public int getCurrentFeedIndex(BusinessFeedData businessFeedData) {
            List<BusinessFeedData> list = this.realFeedDataList;
            if (list == null || businessFeedData == null) {
                return -1;
            }
            return list.indexOf(businessFeedData);
        }

        public int getFeedPos() {
            return this.mFeedPos;
        }

        View getFriendBirthdayGiftJumpingTab(LinearLayout linearLayout) {
            LayoutInflater.from(FeedAdvContainer.this.getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1672), linearLayout);
            View childAt = linearLayout.getChildAt(0);
            if (childAt == null) {
                return linearLayout;
            }
            Drawable background = childAt.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background.mutate()).setColor(com.qzone.adapter.feedcomponent.j.m());
            }
            TextView textView = (TextView) childAt.findViewById(com.qzone.adapter.feedcomponent.j.O(2397));
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.FeedContainerViewPager.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    FeedContainerViewPager feedContainerViewPager = FeedContainerViewPager.this;
                    feedContainerViewPager.mOnFeedElementClickListener.onClick(view, FeedElement.FRIEND_BIRTHDAY_MORE_FRIENDS, feedContainerViewPager.mFeedPos, null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
            childAt.setOnClickListener(onClickListener);
            textView.setOnClickListener(onClickListener);
            return linearLayout;
        }

        public BusinessFeedData getItem(int i3) {
            List<BusinessFeedData> list = this.feedDataList;
            if (list != null && list.size() >= i3 + 1) {
                return this.feedDataList.get(i3);
            }
            return null;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getItemPosition(Object obj) {
            return this.listViews.contains(obj) ? -1 : -2;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public float getPageWidth(int i3) {
            float e16;
            int screenWidth;
            float f16 = AreaConst.REC_WIDTH_WEIGHT;
            FeedAdvContainer feedAdvContainer = FeedAdvContainer.this;
            int i16 = feedAdvContainer.contentType;
            if ((i16 == 3002 || i16 == 3003) && feedAdvContainer.mViewPager != null) {
                int i17 = feedAdvContainer.isRecommendType() ? 291 : FilterEnum.MIC_PTU_TRANS_XINXIAN;
                if (i3 != 0 && i3 != this.feedDataList.size() - 1) {
                    e16 = com.qzone.adapter.feedcomponent.j.e(i17);
                    screenWidth = FeedGlobalEnv.g().getScreenWidth();
                } else {
                    e16 = com.qzone.adapter.feedcomponent.j.e(i17) + com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_BAIXI);
                    screenWidth = FeedGlobalEnv.g().getScreenWidth();
                }
                f16 = e16 / screenWidth;
            }
            int i18 = FeedAdvContainer.this.contentType;
            if (i18 == 3004) {
                f16 = AreaConst.FBG_WIDTH_WEIGHT;
            }
            return (i18 != 3001 || i3 == 0 || i3 == this.feedDataList.size() + (-1)) ? f16 : f16 - AreaConst.REC_GAP_WIDTH_WEIGHT;
        }

        int getPreLastViewPagerHeight() {
            int i3;
            BusinessFeedData businessFeedData = FeedAdvContainer.this.mFeedData;
            if (businessFeedData == null || (i3 = businessFeedData.currShowHeight) == 0) {
                return -1;
            }
            return i3;
        }

        View getRecommendFriendsHorizontalCardJumpingTab(LinearLayout linearLayout) {
            LayoutInflater.from(FeedAdvContainer.this.getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1667), linearLayout);
            View childAt = linearLayout.getChildAt(0);
            if (childAt == null) {
                return linearLayout;
            }
            Drawable background = childAt.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background.mutate()).setColor(com.qzone.adapter.feedcomponent.j.m());
            }
            ImageView imageView = (ImageView) childAt.findViewById(com.qzone.adapter.feedcomponent.j.O(2390));
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.FeedContainerViewPager.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    FeedContainerViewPager feedContainerViewPager = FeedContainerViewPager.this;
                    feedContainerViewPager.mOnFeedElementClickListener.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_GOTO_MAYKNOW_PERSONS_PAGE, feedContainerViewPager.mFeedPos, null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
            View findViewById = childAt.findViewById(com.qzone.adapter.feedcomponent.j.O(2454));
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            }
            TextView textView = (TextView) childAt.findViewById(com.qzone.adapter.feedcomponent.j.O(2414));
            if (textView != null) {
                textView.setText(FeedAdvContainer.lookUpMoreText);
            }
            childAt.setOnClickListener(onClickListener);
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
            return linearLayout;
        }

        View getSpecialCareJumpingTab(LinearLayout linearLayout) {
            LayoutInflater.from(FeedAdvContainer.this.getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1662), linearLayout);
            View childAt = linearLayout.getChildAt(0);
            if (childAt == null) {
                return linearLayout;
            }
            Drawable background = childAt.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background.mutate()).setColor(com.qzone.adapter.feedcomponent.j.m());
            }
            ImageView imageView = (ImageView) childAt.findViewById(com.qzone.adapter.feedcomponent.j.O(2320));
            TextView textView = (TextView) childAt.findViewById(com.qzone.adapter.feedcomponent.j.O(2321));
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.FeedContainerViewPager.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    FeedContainerViewPager feedContainerViewPager = FeedContainerViewPager.this;
                    feedContainerViewPager.mOnFeedElementClickListener.onClick(view, FeedElement.JUMP_TO_SPECIAL_CARE, feedContainerViewPager.mFeedPos, null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
            childAt.setOnClickListener(onClickListener);
            imageView.setOnClickListener(onClickListener);
            textView.setOnClickListener(onClickListener);
            return linearLayout;
        }

        public View getSubView(int i3) {
            ArrayList<LinearLayout> arrayList = this.listViews;
            if (arrayList == null || i3 >= arrayList.size() || i3 < 0 || this.listViews.get(i3) == null) {
                return null;
            }
            return this.listViews.get(i3).getChildAt(0);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            FeedView feedView;
            int i16;
            LinearLayout linearLayout;
            View findViewById;
            com.qzone.proxy.feedcomponent.b.a("FeedContainerViewPager", "instantiateItem position:" + i3);
            ArrayList<LinearLayout> arrayList = this.listViews;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            if (this.listViews.get(i3) == null) {
                View obtainViewInPositionFromCache = obtainViewInPositionFromCache(i3, FeedAdvContainer.this.contentType);
                LinearLayout linearLayout2 = new LinearLayout(FeedAdvContainer.this.mContext);
                linearLayout2.addView(obtainViewInPositionFromCache);
                viewGroup.addView(linearLayout2);
                this.listViews.set(i3, linearLayout2);
                setSingleFeedViewData(i3, FeedAdvContainer.this.contentType);
                FeedAdvContainer.this.resetView(obtainViewInPositionFromCache);
            }
            FeedAdvContainer feedAdvContainer = FeedAdvContainer.this;
            if (!feedAdvContainer.hasReportInitialCard) {
                int i17 = feedAdvContainer.contentType;
                if (i17 == 3002) {
                    int i18 = 0;
                    while (true) {
                        FeedAdvContainer feedAdvContainer2 = FeedAdvContainer.this;
                        if (i18 >= feedAdvContainer2.showingCardQuantity) {
                            break;
                        }
                        feedAdvContainer2.reportExposureOfSpecialCareCard(this.mFeedPos, feedAdvContainer2.mFeedData, i18);
                        i18++;
                    }
                } else if (i17 == 3003) {
                    int i19 = 0;
                    while (true) {
                        FeedAdvContainer feedAdvContainer3 = FeedAdvContainer.this;
                        if (i19 >= feedAdvContainer3.showingCardQuantity) {
                            break;
                        }
                        feedAdvContainer3.reportExposeFriendsCookies(feedAdvContainer3.mFeedData, i19);
                        i19++;
                    }
                }
                FeedAdvContainer feedAdvContainer4 = FeedAdvContainer.this;
                feedAdvContainer4.reportRecommendCardExposure(0, feedAdvContainer4.showingCardQuantity);
                FeedAdvContainer.this.hasReportInitialCard = true;
            }
            FeedAdvContainer feedAdvContainer5 = FeedAdvContainer.this;
            if (feedAdvContainer5.needFillBlackArea && ((i16 = feedAdvContainer5.contentType) == 3002 || i16 == 3004 || i16 == 3003 || i16 == 3005)) {
                if (i3 < this.feedDataList.size()) {
                    FeedView feedView2 = (FeedView) getSubView(i3);
                    if (feedView2 != null) {
                        feedView2.setNeedFillBlackArea(FeedAdvContainer.this.needFillBlackArea);
                        feedView2.setAlpha(FeedAdvContainer.this.mTrans);
                    }
                } else if (i3 == this.feedDataList.size() && (linearLayout = this.listViews.get(i3)) != null && (findViewById = linearLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2324))) != null && findViewById.getBackground() != null) {
                    findViewById.getBackground().setAlpha(FeedAdvContainer.this.mTrans);
                }
            } else {
                BusinessFeedData businessFeedData = feedAdvContainer5.mFeedData;
                if (businessFeedData != null && businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && i3 < this.feedDataList.size() && (feedView = (FeedView) getSubView(i3)) != null) {
                    feedView.setAlpha(FeedAdvContainer.this.mTrans);
                }
            }
            com.qzone.proxy.feedcomponent.ui.g gVar = this.mOnFeedElementClickListener;
            if (gVar != null) {
                gVar.onClick(getSubView(i3), FeedElement.FEED_CONTAINER_VIEW_OBTAIN, this.mFeedPos, null);
            }
            return this.listViews.get(i3);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        void measureLastViewHeight(final View view, int i3) {
            if (!(view instanceof AbsFeedView) && i3 == 3004) {
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAdvContainer.FeedContainerViewPager.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        BusinessFeedData businessFeedData = FeedAdvContainer.this.mFeedData;
                        if (businessFeedData == null) {
                            return true;
                        }
                        businessFeedData.currShowHeight = view.getHeight();
                        return true;
                    }
                };
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
                }
            }
        }

        View obtainViewInPositionFromCache(int i3, int i16) {
            FeedView obtainFeedViewInAdvContainer;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            View view = null;
            switch (i16) {
                case 3001:
                    if (i3 >= 0 && i3 < this.feedDataList.size()) {
                        obtainFeedViewInAdvContainer = ViewLoader.getInstance().obtainFeedViewInAdvContainer(FeedAdvContainer.this.mContext, false);
                        int i17 = AreaConst.cardContainerWingPad;
                        int i18 = AreaConst.cardContainerGap;
                        if (i3 == 0) {
                            layoutParams.setMargins(i17, 0, i18, 0);
                        } else if (i3 == this.feedDataList.size() - 1) {
                            layoutParams.setMargins(i18, 0, i17, 0);
                        } else {
                            layoutParams.setMargins(i18, 0, i18, 0);
                        }
                        obtainFeedViewInAdvContainer.setLayoutParams(layoutParams);
                        obtainFeedViewInAdvContainer.setPadding(0, 0, 0, AreaConst.dp10);
                        obtainFeedViewInAdvContainer.mFeedData = null;
                        obtainFeedViewInAdvContainer.mIndex = i3;
                        obtainFeedViewInAdvContainer.setFeedPosition(this.mFeedPos);
                        obtainFeedViewInAdvContainer.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                        view = obtainFeedViewInAdvContainer;
                        break;
                    }
                    break;
                case 3002:
                case 3003:
                    if (i3 >= 0 && i3 < this.feedDataList.size()) {
                        FeedView obtainFeedViewInAdvContainer2 = ViewLoader.getInstance().obtainFeedViewInAdvContainer(FeedAdvContainer.this.mContext, false);
                        if (i3 == 0) {
                            layoutParams.setMargins(com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_BAIXI), 0, 0, 0);
                            layoutParams.gravity = 5;
                        } else if (i3 == this.feedDataList.size() - 1) {
                            layoutParams.setMargins(0, 0, com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_BAIXI), 0);
                            layoutParams.gravity = 3;
                        } else {
                            layoutParams.setMargins(0, 0, 0, 0);
                        }
                        obtainFeedViewInAdvContainer2.mFeedData = null;
                        obtainFeedViewInAdvContainer2.setPadding(0, 0, 0, 0);
                        obtainFeedViewInAdvContainer2.mIndex = i3;
                        obtainFeedViewInAdvContainer2.setFeedPosition(this.mFeedPos);
                        obtainFeedViewInAdvContainer2.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                        FeedRecommendFriendsHorizontalCardView recommendFriendsHorizontalCardView = obtainFeedViewInAdvContainer2.getRecommendFriendsHorizontalCardView();
                        if (recommendFriendsHorizontalCardView != null) {
                            recommendFriendsHorizontalCardView.setParentFeedDataPos(FeedAdvContainer.this.mFeedPos);
                            recommendFriendsHorizontalCardView.setFeedAdvContainer(FeedAdvContainer.this);
                        }
                        FeedSpecialCare specialCare = obtainFeedViewInAdvContainer2.getSpecialCare();
                        if (specialCare != null) {
                            specialCare.setParentFeedDataPos(FeedAdvContainer.this.mFeedPos);
                            specialCare.setFeedAdvContainer(FeedAdvContainer.this);
                        }
                        view = obtainFeedViewInAdvContainer2;
                        break;
                    } else if (i3 == this.feedDataList.size()) {
                        LinearLayout linearLayout = new LinearLayout(FeedAdvContainer.this.mContext);
                        if (i16 == 3002) {
                            view = getSpecialCareJumpingTab(linearLayout);
                        } else if (i16 == 3003) {
                            view = getRecommendFriendsHorizontalCardJumpingTab(linearLayout);
                        }
                        if (this.feedDataList.size() == 0) {
                            layoutParams.setMargins(com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_BAIXI), 0, com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_BAIXI), 0);
                        } else {
                            layoutParams.setMargins(0, 0, com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_BAIXI), 0);
                        }
                        layoutParams.gravity = 3;
                        break;
                    }
                    break;
                case 3004:
                    if (i3 >= 0 && i3 < this.feedDataList.size()) {
                        obtainFeedViewInAdvContainer = ViewLoader.getInstance().obtainFeedViewInAdvContainer(FeedAdvContainer.this.mContext, false);
                        if (i3 == 0) {
                            layoutParams.setMargins(AreaConst.dp6, 0, 0, 0);
                        } else {
                            layoutParams.setMargins(0, 0, 0, 0);
                        }
                        obtainFeedViewInAdvContainer.setLayoutParams(layoutParams);
                        obtainFeedViewInAdvContainer.setPadding(0, 0, 0, AreaConst.dp10);
                        obtainFeedViewInAdvContainer.mFeedData = null;
                        obtainFeedViewInAdvContainer.mIndex = i3;
                        obtainFeedViewInAdvContainer.setFeedPosition(this.mFeedPos);
                        obtainFeedViewInAdvContainer.setOnFeedEventListener(FeedAdvContainer.this.mOnFeedEventListener);
                        obtainFeedViewInAdvContainer.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                        view = obtainFeedViewInAdvContainer;
                        break;
                    } else if (i3 == this.feedDataList.size()) {
                        view = getFriendBirthdayGiftJumpingTab(new LinearLayout(FeedAdvContainer.this.mContext));
                        layoutParams.setMargins(AreaConst.f48748dp3, 0, AreaConst.dp10, 0);
                        layoutParams.height = getPreLastViewPagerHeight();
                        layoutParams.gravity = 5;
                        break;
                    }
                    break;
                default:
                    com.qzone.proxy.feedcomponent.b.c("FeedContainerViewPager", "obtainViewInPositionFromCache switch to default");
                    break;
            }
            if (view != null) {
                view.setLayoutParams(layoutParams);
                measureLastViewHeight(view, i16);
            }
            return view;
        }

        public void resetViewDisplay() {
            int count = getCount();
            for (int i3 = 0; i3 < count; i3++) {
                FeedAdvContainer.this.resetView(getSubView(i3));
            }
        }

        void resetViewLists() {
            this.listViews = new ArrayList<>();
            int count = getCount();
            for (int i3 = 0; i3 < count; i3++) {
                this.listViews.add(null);
            }
        }

        void setSingleFeedViewData(int i3, int i16) {
            List<BusinessFeedData> list = this.feedDataList;
            if (list == null || list.size() == 0 || i3 < 0 || i3 >= this.feedDataList.size()) {
                return;
            }
            BusinessFeedData businessFeedData = this.feedDataList.get(i3);
            AbsFeedView absFeedView = (AbsFeedView) getSubView(i3);
            if (absFeedView == null || !(absFeedView instanceof FeedView)) {
                return;
            }
            if (businessFeedData != null) {
                if (!businessFeedData.hasCalculate) {
                    com.qzone.adapter.feedcomponent.d.w(businessFeedData);
                }
                absFeedView.mFeedData = businessFeedData;
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(FeedGlobalEnv.getContext(), absFeedView, businessFeedData, false);
            }
            FeedView feedView = (FeedView) absFeedView;
            feedView.mIndex = i3;
            absFeedView.setFeedPosition(this.mFeedPos);
            absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
            absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
            if (i16 == 3002 || i16 == 3003) {
                FeedRecommendFriendsHorizontalCardView recommendFriendsHorizontalCardView = feedView.getRecommendFriendsHorizontalCardView();
                if (recommendFriendsHorizontalCardView != null) {
                    recommendFriendsHorizontalCardView.setParentFeedDataPos(FeedAdvContainer.this.mFeedPos);
                    recommendFriendsHorizontalCardView.setFeedAdvContainer(FeedAdvContainer.this);
                }
                FeedSpecialCare specialCare = feedView.getSpecialCare();
                if (specialCare != null) {
                    specialCare.setParentFeedDataPos(FeedAdvContainer.this.mFeedPos);
                    specialCare.setFeedAdvContainer(FeedAdvContainer.this);
                }
            }
        }

        void setupSummaryLine(int i3) {
            int i16 = 0;
            for (BusinessFeedData businessFeedData : this.feedDataList) {
                int measureContainerFeedSummaryLine = AreaManager.getInstance().measureContainerFeedSummaryLine(businessFeedData.getCellSummaryV2(), businessFeedData.isSubOfMultiAdvContainerFeed());
                if (i16 < measureContainerFeedSummaryLine && ((i3 == 3001 && measureContainerFeedSummaryLine <= AreaConst.ADV_CONTAINER_SUMMARY_MAX_LINE) || i3 != 3001)) {
                    i16 = measureContainerFeedSummaryLine;
                }
            }
            if (i16 > 0) {
                for (BusinessFeedData businessFeedData2 : this.feedDataList) {
                    if (businessFeedData2.getCellSummaryV2() != null) {
                        businessFeedData2.getCellSummaryV2().minLine = i16;
                    }
                }
            }
        }

        public void updateViewDatas(String str) {
            List<BusinessFeedData> list;
            CellRecommItem cellRecommItem;
            User user;
            if (FeedAdvContainer.this.contentType != 3003 || (list = this.feedDataList) == null || list.size() == 0) {
                return;
            }
            for (int i3 = 0; i3 < this.feedDataList.size(); i3++) {
                BusinessFeedData businessFeedData = this.feedDataList.get(i3);
                if (businessFeedData != null && (cellRecommItem = businessFeedData.cellRecommItem) != null && (user = cellRecommItem.userInfo) != null && TextUtils.equals(String.valueOf(user.uin), str)) {
                    FeedAdvContainer.this.scrollWhenSendFriendRecommendSuccess(businessFeedData.containerIndex, false);
                    AbsFeedView absFeedView = (AbsFeedView) getSubView(i3);
                    if (absFeedView != null) {
                        if (!businessFeedData.hasCalculate) {
                            com.qzone.adapter.feedcomponent.d.w(businessFeedData);
                        }
                        absFeedView.mFeedData = businessFeedData;
                        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(FeedGlobalEnv.getContext(), absFeedView, businessFeedData, false);
                        ((FeedView) absFeedView).mIndex = i3;
                        absFeedView.setFeedPosition(this.mFeedPos);
                        absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                        absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                    }
                }
            }
        }

        private int preMesureRecommDescLine(CellRecommItem cellRecommItem) {
            if (cellRecommItem == null || TextUtils.isEmpty(cellRecommItem.content)) {
                return 0;
            }
            return cellRecommItem.content.length() > 8 ? 2 : 1;
        }

        public void setData(List<BusinessFeedData> list, int i3, boolean z16, com.qzone.proxy.feedcomponent.ui.g gVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("FeedContainerViewPager", "setData size:" + list.size());
            if (gVar == null) {
                this.mOnFeedElementClickListener = gVar;
            }
            int count = getCount();
            this.feedDataList.clear();
            this.feedDataList.addAll(list);
            this.realFeedDataList = list;
            setupSummaryLine(i3);
            setupRecommDescLine(i3);
            if (z16 || count != getCount() || this.mContentType != i3) {
                resetViewLists();
                notifyDataSetChanged();
            }
            this.mContentType = i3;
        }

        void setupRecommDescLine(int i3) {
            BusinessFeedData businessFeedData;
            if (i3 != 3003 || (businessFeedData = FeedAdvContainer.this.mFeedData) == null) {
                return;
            }
            if (businessFeedData.isCardSchoolRecommendContainerFeed() || FeedAdvContainer.this.mFeedData.isCardFollowMoreRecommendContainerFeed()) {
                Iterator<BusinessFeedData> it = this.feedDataList.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    int preMesureRecommDescLine = preMesureRecommDescLine(it.next().getRecommItem());
                    if (i16 < preMesureRecommDescLine) {
                        i16 = preMesureRecommDescLine;
                    }
                }
                if (i16 > 0) {
                    for (BusinessFeedData businessFeedData2 : this.feedDataList) {
                        if (businessFeedData2.getRecommItem() != null) {
                            businessFeedData2.getRecommItem().minLine = i16;
                        }
                    }
                }
            }
        }
    }

    public void reportExposeFriendsCookies(BusinessFeedData businessFeedData, int i3) {
        CellRecommItem cellRecommItem;
        User user;
        if (businessFeedData == null || businessFeedData.getRecBusinessFeedDatas() == null || i3 < 0 || i3 >= businessFeedData.getRecBusinessFeedDatas().size()) {
            return;
        }
        BusinessFeedData businessFeedData2 = businessFeedData.getRecBusinessFeedDatas().get(i3);
        String str = (businessFeedData2 == null || businessFeedData2.getOperationInfoV2() == null || businessFeedData2.getOperationInfoV2().busiParam == null) ? null : businessFeedData2.getOperationInfoV2().busiParam.get(52);
        if (this.mOnFeedElementClickListener != null && str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            User user2 = new User();
            if (businessFeedData2.getRecommItem() != null && businessFeedData2.getRecommItem().userInfo != null) {
                user2 = businessFeedData2.getRecommItem().userInfo;
            }
            this.mOnFeedElementClickListener.onClick(this, FeedElement.FEED_RECOMMEND_FRIENDS_EXPOSE_REPORT, this.mFeedPos, new Object[]{arrayList, user2});
        }
        if (businessFeedData2 == null || (cellRecommItem = businessFeedData2.cellRecommItem) == null || (user = cellRecommItem.userInfo) == null || user.uin <= 0) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().f2(619, 10, 7, String.valueOf(businessFeedData2.cellRecommItem.userInfo.uin));
    }

    void resetView(View view) {
        BusinessFeedData businessFeedData;
        int i3;
        if (view == null || (businessFeedData = this.mFeedData) == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() || (i3 = this.contentType) == 3004) {
            view.setPadding(0, 0, 0, 0);
        } else if (i3 == 3001) {
            int i16 = AreaConst.CONTAINER_LINE_WIDTH;
            view.setPadding(i16, i16 - 1, i16, i16);
        } else {
            view.setPadding(0, 0, 0, AreaConst.dp10_5);
        }
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("FeedAdvContainer", "setFeedData");
        this.mTrans = com.qzone.adapter.feedcomponent.i.H().E0();
        this.mDataFilled = true;
        this.mFeedData = businessFeedData;
        this.hasReportInitialCard = false;
        setContentType(businessFeedData);
        this.mCurrPageIndex = this.mFeedData.currShowIndex;
        setUIParams();
        this.hasRecyled = false;
        if (businessFeedData.getRecommHeader() != null) {
            boolean z16 = !(businessFeedData.getRecommAction() == null || businessFeedData.getRecommAction().isReport == 0) || !(businessFeedData.getActiveAdv() == null || businessFeedData.getActiveAdv().isReport == 0) || businessFeedData.isSpecialCareInContainerFeed() || businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardFollowMoreRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || businessFeedData.isFriendBirthdayContainerFeed() || businessFeedData.getFeedCommInfo().isRecomLiveShowFeed() || businessFeedData.isFunctionGuideFeed() || businessFeedData.isFriendLikeContainer() || (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && this.contentType == 3001);
            this.recommHeaderView.setFeedData(businessFeedData);
            this.recommHeaderView.setHeaderData(businessFeedData.getRecommHeader(), z16);
            this.recommHeaderView.setFeedAttr(businessFeedData.getFeedCommInfo().feedsAttr, businessFeedData.isSubFeed);
            this.recommHeaderView.setIsHotRecommFeed(businessFeedData.getFeedCommInfo().isHotRecommFeed() || businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds());
            this.recommHeaderView.setStyle(businessFeedData.getSinglePicAdvStyle());
            if (this.contentType == 3002) {
                this.recommHeaderView.setSpecialCareInContainer(true);
            } else {
                this.recommHeaderView.setSpecialCareInContainer(false);
            }
            if (businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                this.recommHeaderView.setSpecialFollowContainer(true);
            } else {
                this.recommHeaderView.setSpecialFollowContainer(false);
            }
            if (this.contentType == 3004) {
                this.recommHeaderView.setFriendBirthdayInContainer(true);
            } else {
                this.recommHeaderView.setFriendBirthdayInContainer(false);
            }
            if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds()) {
                this.recommHeaderView.setBizRecomContainer(true);
            } else {
                this.recommHeaderView.setBizRecomContainer(false);
            }
            int singlePicAdvStyle = businessFeedData.getSinglePicAdvStyle();
            if (singlePicAdvStyle > 0) {
                this.recommHeaderView.setStyle(singlePicAdvStyle);
                if (businessFeedData.isAdFeeds() && businessFeedData.isAdFeeds() && businessFeedData.getLocalInfo().canLike && businessFeedData.getLocalInfo().canShare && businessFeedData.getLocalInfo().canComment && singlePicAdvStyle == 4) {
                    this.recommHeaderView.setStyle(-1);
                }
            }
            if (this.contentType == 3003) {
                this.recommHeaderView.setFriendRecommendInContainer(true);
            } else {
                this.recommHeaderView.setFriendRecommendInContainer(false);
            }
            if (businessFeedData.isFriendLikeContainer()) {
                this.recommHeaderView.setLikeFriendContainer(true);
            } else {
                this.recommHeaderView.setLikeFriendContainer(false);
            }
            if (businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
                this.recommHeaderView.setFollowMoreContainer(true);
            } else {
                this.recommHeaderView.setFollowMoreContainer(false);
            }
            boolean z17 = (this.contentType != 3001 && businessFeedData.hasCustomDropList()) || (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && this.contentType == 3001);
            if (!businessFeedData.isFriendLikeContainer() && !businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
                this.recommHeaderView.setHasCustomDropdownList(z17);
            } else {
                this.recommHeaderView.setHasCustomDropdownList(true);
                this.recommHeaderView.setNeedRightTitle(true);
            }
            this.recommHeaderView.setNeedHideDropdownListForBizRecomContainer(!businessFeedData.hasCustomDropList());
            int i3 = this.contentType;
            if (i3 != 3002 && i3 != 3001 && i3 != 3004 && i3 != 3003 && !businessFeedData.isFriendPlayingFeed()) {
                this.recommHeaderView.setBoarderLineVisibility(0);
                FeedRecommHeader feedRecommHeader = this.recommHeaderView;
                int i16 = AreaConst.dp8;
                feedRecommHeader.setBoarderLinePadding(i16, i16);
            } else {
                this.recommHeaderView.setBoarderLineVisibility(8);
            }
            this.recommHeaderView.setVisibility(0);
            this.recommHeaderView.update();
        } else {
            this.recommHeaderView.setVisibility(8);
        }
        WrapContentViewPager wrapContentViewPager = this.mViewPager;
        int i17 = this.contentType;
        wrapContentViewPager.autoScrollMode(i17 == 3001 || i17 == 3004);
        this.mAdapter.setData(businessFeedData.getRecBusinessFeedDatas(), this.contentType, true, this.mOnFeedElementClickListener);
        if (this.contentType == 3004) {
            if (this.mAdapter.getCount() <= 1) {
                this.mViewPager.setEnableScroll(false);
                this.mViewPager.setCurrentItem(0, false);
                this.mViewPager.setCenterModeChildren(true, false);
                com.qzone.proxy.feedcomponent.b.i("FeedAdvContainer", "set current 0");
            } else {
                this.mViewPager.setEnableScroll(true);
                this.mViewPager.setCenterModeChildren(true, true);
            }
        }
        this.mViewPager.setCurrentItemInternal(businessFeedData.currShowIndex, false, true);
        this.mAdapter.resetViewDisplay();
        boolean isFriendLikeContainer = businessFeedData.isFriendLikeContainer();
        this.isFriendLikeContainer = isFriendLikeContainer;
        if ((isFriendLikeContainer || businessFeedData.isSpecialCareInContainerFeed() || businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardFollowMoreRecommendContainerFeed()) && businessFeedData.getCellViewMore() != null) {
            this.recommBottomView.setFeedData(businessFeedData);
            this.recommBottomView.setVisibility(0);
            this.recommBottomView.update();
        } else {
            this.recommBottomView.setVisibility(8);
        }
        if (businessFeedData.isAdvContainerFirstFeed()) {
            return;
        }
        this.recommBottomView.setPadding(0, 0, 0, AreaConst.dp10_5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRecommendCardExposure(int i3, int i16) {
        if (i3 < 0) {
            return;
        }
        if (i16 < 1) {
            i16 = 1;
        }
        HashSet hashSet = new HashSet(i16);
        HashSet hashSet2 = new HashSet(i16);
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = i3 + i17;
            if (!this.lastReportIndexSet.contains(Integer.valueOf(i18))) {
                hashSet2.add(Integer.valueOf(i18));
            }
            hashSet.add(Integer.valueOf(i18));
        }
        this.lastReportIndexSet.clear();
        this.lastReportIndexSet.addAll(hashSet);
        if (hashSet2.isEmpty()) {
            return;
        }
        int i19 = this.contentType;
        if (i19 == 3002) {
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                ((Integer) it.next()).intValue();
                FeedSpecialCare.doReport(5);
            }
            return;
        }
        if (i19 != 3003) {
            return;
        }
        Iterator it5 = hashSet2.iterator();
        while (it5.hasNext()) {
            int intValue = ((Integer) it5.next()).intValue();
            BusinessFeedData businessFeedData = intValue < this.mAdapter.feedDataList.size() ? this.mAdapter.feedDataList.get(intValue) : null;
            CellRecommItem cellRecommItem = businessFeedData != null ? businessFeedData.cellRecommItem : null;
            if (cellRecommItem != null) {
                FeedRecommendFriendsHorizontalCardView.doReport(5, intValue, cellRecommItem);
            }
        }
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
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedFirstDrawListener(com.qzone.proxy.feedcomponent.ui.i iVar) {
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
}
