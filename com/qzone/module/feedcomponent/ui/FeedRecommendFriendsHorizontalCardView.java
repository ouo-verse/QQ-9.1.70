package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.RoundRectImageView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommendFriendsHorizontalCardView extends BaseFeedView implements FeedChildView {
    private static final String TAG = "FeedRecommendFriendsHorizontalCardView";
    private View.OnClickListener addButtonClickListener;
    private ImageView addButtonImageView;
    private TextView addDescriptionTextView;
    private View.OnClickListener addFollowButtonClickListener;
    private View.OnClickListener addSpecialFollowButtonClickListener;
    private View.OnClickListener avatarClickListener;
    private AvatarImageView avatarImageView;
    private View avatarSpace;
    private View backGroundView;
    private BusinessFeedData businessFeedData;
    private RoundRectImageView cardBgRriv;
    private CellRecommItem cellRecommItem;
    private RelativeLayout certificationArea;
    private ImageView closeCardBtnIv;
    private TextView contentCntView;
    private TextView contentUnitView;
    private View contentView;
    private View descSpace;
    private TextView descriptionTextView;
    private ImageView genderIv;
    private View.OnClickListener intimacyClickListener;
    private View mCardView;
    private FeedAdvContainer mFeedAdvContainer;
    private boolean mIsFollowClicked;
    private int mParentFeedDataPos;
    private int mTrans;
    private boolean needFillBlackArea;
    private View nickSpace;
    private View.OnClickListener nicknameClikListener;
    private TextView nicknameTextView;
    private LinearLayout recommendFriendCardInContainerOperatingLayout;
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static String networkDisable = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528");
    public static FeedViewSection.SectionController RecommendFriendsCardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null || businessFeedData.getRecommItem() == null) {
                return true;
            }
            return (businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardFollowMoreRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) ? false : true;
        }
    };

    public FeedRecommendFriendsHorizontalCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCardView = null;
        this.needFillBlackArea = false;
        this.mTrans = 255;
        this.mParentFeedDataPos = -1;
        this.mIsFollowClicked = false;
        this.mContext = context;
        setupUIWidgets(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReport(int i3) {
        FeedAdvContainer.FeedContainerViewPager feedContainerViewPager;
        FeedAdvContainer feedAdvContainer = this.mFeedAdvContainer;
        doReport(i3, (feedAdvContainer == null || (feedContainerViewPager = feedAdvContainer.mAdapter) == null) ? 0 : feedContainerViewPager.getCurrentFeedIndex(this.businessFeedData), this.cellRecommItem);
    }

    private void setAddFollowState(boolean z16) {
        LinearLayout linearLayout = this.recommendFriendCardInContainerOperatingLayout;
        if (linearLayout != null) {
            int paddingLeft = linearLayout.getPaddingLeft();
            int paddingTop = this.recommendFriendCardInContainerOperatingLayout.getPaddingTop();
            int paddingRight = this.recommendFriendCardInContainerOperatingLayout.getPaddingRight();
            int paddingBottom = this.recommendFriendCardInContainerOperatingLayout.getPaddingBottom();
            if (z16) {
                this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.A());
                this.addDescriptionTextView.setText(this.cellRecommItem.descriptionAfterClick);
                this.addDescriptionTextView.setTextColor(-16777216);
                if (this.mIsFollowClicked) {
                    this.mIsFollowClicked = false;
                    int nextScorllFamousSpacePos = this.mFeedAdvContainer.getNextScorllFamousSpacePos(this.mFeedAdvContainer.mAdapter.getCurrentFeedIndex(this.businessFeedData));
                    if (nextScorllFamousSpacePos >= 0) {
                        this.mFeedAdvContainer.scrollWhenSendFriendRecommendSuccess(nextScorllFamousSpacePos, true);
                    }
                }
            } else {
                this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.y());
                this.addDescriptionTextView.setText(this.cellRecommItem.descriptionBeforeClick);
                this.addDescriptionTextView.setTextColor(-1);
            }
            this.recommendFriendCardInContainerOperatingLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    private void setAddSpecialFollowState(boolean z16) {
        LinearLayout linearLayout = this.recommendFriendCardInContainerOperatingLayout;
        if (linearLayout != null) {
            int paddingLeft = linearLayout.getPaddingLeft();
            int paddingTop = this.recommendFriendCardInContainerOperatingLayout.getPaddingTop();
            int paddingRight = this.recommendFriendCardInContainerOperatingLayout.getPaddingRight();
            int paddingBottom = this.recommendFriendCardInContainerOperatingLayout.getPaddingBottom();
            if (z16) {
                this.recommendFriendCardInContainerOperatingLayout.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(935));
                this.addDescriptionTextView.setText(this.cellRecommItem.descriptionAfterClick);
                this.addDescriptionTextView.setTextColor(-16777216);
                if (this.mIsFollowClicked) {
                    this.mIsFollowClicked = false;
                    int nextScorllFamousSpacePos = this.mFeedAdvContainer.getNextScorllFamousSpacePos(this.mFeedAdvContainer.mAdapter.getCurrentFeedIndex(this.businessFeedData));
                    if (nextScorllFamousSpacePos >= 0) {
                        this.mFeedAdvContainer.scrollWhenSendFriendRecommendSuccess(nextScorllFamousSpacePos, true);
                    }
                }
            } else {
                this.recommendFriendCardInContainerOperatingLayout.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(934));
                this.addDescriptionTextView.setText(this.cellRecommItem.descriptionBeforeClick);
                this.addDescriptionTextView.setTextColor(-1);
            }
            this.recommendFriendCardInContainerOperatingLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    private void setupUIWidgets(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1661), this);
        this.mCardView = getChildAt(0);
        this.backGroundView = findViewById(com.qzone.adapter.feedcomponent.j.O(2325));
        this.closeCardBtnIv = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2514));
        this.avatarImageView = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2314));
        this.nicknameTextView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2315));
        this.avatarImageView.setOval();
        this.avatarImageView.setAvatarMask(0);
        this.certificationArea = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2330));
        this.avatarClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommendFriendsHorizontalCardView.this.doReport(3);
                FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                if (feedRecommendFriendsHorizontalCardView.onFeedElementClickListener != null && feedRecommendFriendsHorizontalCardView.cellRecommItem != null && FeedRecommendFriendsHorizontalCardView.this.cellRecommItem.userInfo != null) {
                    FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView2 = FeedRecommendFriendsHorizontalCardView.this;
                    feedRecommendFriendsHorizontalCardView2.onFeedElementClickListener.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_CLICK_AVATAR_OR_NICKNAME, feedRecommendFriendsHorizontalCardView2.feedPosition, feedRecommendFriendsHorizontalCardView2.cellRecommItem.userInfo);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.nicknameClikListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommendFriendsHorizontalCardView.this.doReport(3);
                FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                feedRecommendFriendsHorizontalCardView.onFeedElementClickListener.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_CLICK_AVATAR_OR_NICKNAME, feedRecommendFriendsHorizontalCardView.feedPosition, feedRecommendFriendsHorizontalCardView.cellRecommItem.userInfo);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.avatarImageView.setOnClickListener(this.avatarClickListener);
        this.nicknameTextView.setOnClickListener(this.nicknameClikListener);
        this.closeCardBtnIv.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommendFriendsHorizontalCardView.this.doReport(6);
                if (FeedRecommendFriendsHorizontalCardView.this.mFeedAdvContainer != null) {
                    i3 = FeedRecommendFriendsHorizontalCardView.this.mFeedAdvContainer.mAdapter.getCurrentFeedIndex(FeedRecommendFriendsHorizontalCardView.this.businessFeedData);
                    FeedRecommendFriendsHorizontalCardView.this.mFeedAdvContainer.deleteFeedDataAndUpdate(FeedRecommendFriendsHorizontalCardView.this.businessFeedData);
                } else {
                    i3 = -1;
                }
                if (FeedRecommendFriendsHorizontalCardView.this.getFriendUin() > 0) {
                    com.qzone.adapter.feedcomponent.i.H().f2(619, 10, 5, String.valueOf(FeedRecommendFriendsHorizontalCardView.this.getFriendUin()));
                }
                FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedRecommendFriendsHorizontalCardView.onFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_CARD_CLOSE, feedRecommendFriendsHorizontalCardView.feedPosition, new Object[]{feedRecommendFriendsHorizontalCardView.businessFeedData, Integer.valueOf(FeedRecommendFriendsHorizontalCardView.this.mParentFeedDataPos), Integer.valueOf(i3)});
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.intimacyClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                if (feedRecommendFriendsHorizontalCardView.onFeedElementClickListener != null && feedRecommendFriendsHorizontalCardView.cellRecommItem != null && FeedRecommendFriendsHorizontalCardView.this.cellRecommItem.userInfo != null) {
                    FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView2 = FeedRecommendFriendsHorizontalCardView.this;
                    feedRecommendFriendsHorizontalCardView2.onFeedElementClickListener.onClick(view, FeedElement.SPECIAL_CARE_IN_CONTAINER_INTIMACY, feedRecommendFriendsHorizontalCardView2.feedPosition, Long.valueOf(feedRecommendFriendsHorizontalCardView2.cellRecommItem.userInfo.uin));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.descriptionTextView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2316));
        this.recommendFriendCardInContainerOperatingLayout = (LinearLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2327));
        this.addButtonImageView = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2317));
        this.addDescriptionTextView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2318));
        this.addButtonClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommendFriendsHorizontalCardView.this.doReport(4);
                if (FeedGlobalEnv.g().isNetworkAvailable(FeedRecommendFriendsHorizontalCardView.this.mContext)) {
                    FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                    if (feedRecommendFriendsHorizontalCardView.onFeedElementClickListener != null && feedRecommendFriendsHorizontalCardView.cellRecommItem != null && !FeedRecommendFriendsHorizontalCardView.this.cellRecommItem.isFriend) {
                        long friendUin = FeedRecommendFriendsHorizontalCardView.this.getFriendUin();
                        if (friendUin >= 0) {
                            FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView2 = FeedRecommendFriendsHorizontalCardView.this;
                            feedRecommendFriendsHorizontalCardView2.onFeedElementClickListener.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_ADD_FRIEND, feedRecommendFriendsHorizontalCardView2.feedPosition, new Object[]{Long.valueOf(friendUin), FeedRecommendFriendsHorizontalCardView.this.businessFeedData, Integer.valueOf(FeedRecommendFriendsHorizontalCardView.this.mParentFeedDataPos)});
                        }
                    }
                } else {
                    FeedGlobalEnv.g().showToast(1000, FeedRecommendFriendsHorizontalCardView.this.mContext, FeedRecommendFriendsHorizontalCardView.networkDisable);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.addFollowButtonClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedGlobalEnv.g().isNetworkAvailable(FeedRecommendFriendsHorizontalCardView.this.mContext)) {
                    FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                    if (feedRecommendFriendsHorizontalCardView.onFeedElementClickListener != null && feedRecommendFriendsHorizontalCardView.cellRecommItem != null) {
                        long friendUin = FeedRecommendFriendsHorizontalCardView.this.getFriendUin();
                        if (friendUin >= 0) {
                            int currentFeedIndex = FeedRecommendFriendsHorizontalCardView.this.mFeedAdvContainer.mAdapter.getCurrentFeedIndex(FeedRecommendFriendsHorizontalCardView.this.businessFeedData);
                            FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView2 = FeedRecommendFriendsHorizontalCardView.this;
                            feedRecommendFriendsHorizontalCardView2.onFeedElementClickListener.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_FOLLOW, feedRecommendFriendsHorizontalCardView2.feedPosition, new Object[]{Long.valueOf(friendUin), FeedRecommendFriendsHorizontalCardView.this.businessFeedData, Integer.valueOf(FeedRecommendFriendsHorizontalCardView.this.mParentFeedDataPos), Integer.valueOf(currentFeedIndex)});
                            if (!FeedRecommendFriendsHorizontalCardView.this.cellRecommItem.isFollowed) {
                                FeedRecommendFriendsHorizontalCardView.this.mIsFollowClicked = true;
                            }
                        }
                    }
                } else {
                    FeedGlobalEnv.g().showToast(1000, FeedRecommendFriendsHorizontalCardView.this.mContext, FeedRecommendFriendsHorizontalCardView.networkDisable);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.addSpecialFollowButtonClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommendFriendsHorizontalCardView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedGlobalEnv.g().isNetworkAvailable(FeedRecommendFriendsHorizontalCardView.this.mContext)) {
                    FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = FeedRecommendFriendsHorizontalCardView.this;
                    if (feedRecommendFriendsHorizontalCardView.onFeedElementClickListener != null && feedRecommendFriendsHorizontalCardView.cellRecommItem != null) {
                        long friendUin = FeedRecommendFriendsHorizontalCardView.this.getFriendUin();
                        if (friendUin >= 0) {
                            int currentFeedIndex = FeedRecommendFriendsHorizontalCardView.this.mFeedAdvContainer.mAdapter.getCurrentFeedIndex(FeedRecommendFriendsHorizontalCardView.this.businessFeedData);
                            FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView2 = FeedRecommendFriendsHorizontalCardView.this;
                            feedRecommendFriendsHorizontalCardView2.onFeedElementClickListener.onClick(view, FeedElement.FEED_RECOMMEND_FRIENDS_SPECIAL_FOLLOW, feedRecommendFriendsHorizontalCardView2.feedPosition, new Object[]{Long.valueOf(friendUin), FeedRecommendFriendsHorizontalCardView.this.businessFeedData, Integer.valueOf(FeedRecommendFriendsHorizontalCardView.this.mParentFeedDataPos), Integer.valueOf(currentFeedIndex)});
                            if (!FeedRecommendFriendsHorizontalCardView.this.cellRecommItem.isFollowed) {
                                FeedRecommendFriendsHorizontalCardView.this.mIsFollowClicked = true;
                            }
                        }
                    }
                } else {
                    FeedGlobalEnv.g().showToast(1000, FeedRecommendFriendsHorizontalCardView.this.mContext, FeedRecommendFriendsHorizontalCardView.networkDisable);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.recommendFriendCardInContainerOperatingLayout.setOnClickListener(this.addButtonClickListener);
        this.addButtonImageView.setOnClickListener(this.addButtonClickListener);
        this.addDescriptionTextView.setOnClickListener(this.addButtonClickListener);
        this.cardBgRriv = (RoundRectImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2844));
        this.genderIv = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2845));
        this.avatarSpace = findViewById(com.qzone.adapter.feedcomponent.j.O(2846));
        this.nickSpace = findViewById(com.qzone.adapter.feedcomponent.j.O(2847));
        this.descSpace = findViewById(com.qzone.adapter.feedcomponent.j.O(2848));
        this.contentView = findViewById(com.qzone.adapter.feedcomponent.j.O(2849));
        this.contentCntView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2850));
        this.contentUnitView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2851));
    }

    public long getFriendUin() {
        User user;
        CellRecommItem cellRecommItem = this.cellRecommItem;
        if (cellRecommItem == null || (user = cellRecommItem.userInfo) == null) {
            return -1L;
        }
        return user.uin;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return this.cellRecommItem == null;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        AvatarImageView avatarImageView = this.avatarImageView;
        if (avatarImageView != null) {
            avatarImageView.setAsyncImage(null);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        CellRecommItem cellRecommItem = this.cellRecommItem;
        if (cellRecommItem != null && cellRecommItem.userInfo != null && cellRecommItem.iconUrlBeforeClick != null && cellRecommItem.iconUrlAfterClick != null) {
            try {
                Log.i(TAG, "onUpdate: " + this.cellRecommItem.extendinfo.get("sex") + " " + this.cellRecommItem.extendinfo.get(CellRecommItem.EXTEND_KEY_BG) + this.cellRecommItem.userInfo.uin);
            } catch (Exception e16) {
                Log.w(TAG, "onUpdate: ", e16);
            }
            this.cardBgRriv.setVisibility(0);
            this.cardBgRriv.setUrl(this.cellRecommItem.extendinfo.get(CellRecommItem.EXTEND_KEY_BG));
            this.closeCardBtnIv.setImageResource(com.qzone.adapter.feedcomponent.j.h(930));
            this.avatarSpace.setVisibility(0);
            this.nickSpace.setVisibility(0);
            this.descSpace.setVisibility(8);
            this.contentView.setVisibility(8);
            String str = this.cellRecommItem.extendinfo.get("sex");
            if (str != null) {
                str = str.trim();
            }
            if ("1".equals(str)) {
                this.genderIv.setVisibility(0);
                this.genderIv.setImageResource(com.qzone.adapter.feedcomponent.j.h(932));
            } else if ("2".equals(str)) {
                this.genderIv.setVisibility(0);
                this.genderIv.setImageResource(com.qzone.adapter.feedcomponent.j.h(933));
            } else {
                this.genderIv.setVisibility(8);
            }
            com.qzone.adapter.feedcomponent.j.V(this.avatarImageView);
            this.avatarImageView.loadAvatar(this.cellRecommItem.userInfo.uin, (short) com.qzone.adapter.feedcomponent.j.f(284));
            this.nicknameTextView.setText(this.cellRecommItem.userInfo.nickName);
            this.descriptionTextView.setText(this.cellRecommItem.content);
            if (this.cellRecommItem.isAddFriendButton()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.backGroundView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ViewUtils.dpToPx(215);
                    this.backGroundView.setLayoutParams(layoutParams);
                }
                this.recommendFriendCardInContainerOperatingLayout.setOnClickListener(this.addButtonClickListener);
                this.addButtonImageView.setOnClickListener(this.addButtonClickListener);
                this.addDescriptionTextView.setOnClickListener(this.addButtonClickListener);
                setAddFriendState(this.cellRecommItem.isFriend);
            } else if (this.cellRecommItem.isAddFollowButton()) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.backGroundView.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = ViewUtils.dpToPx(215);
                    this.backGroundView.setLayoutParams(layoutParams2);
                }
                this.recommendFriendCardInContainerOperatingLayout.setOnClickListener(this.addFollowButtonClickListener);
                this.addButtonImageView.setOnClickListener(this.addFollowButtonClickListener);
                this.addDescriptionTextView.setOnClickListener(this.addFollowButtonClickListener);
                setAddFollowState(this.cellRecommItem.isFollowed);
            } else if (this.cellRecommItem.isAddSpecialFollowButton()) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.backGroundView.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = ViewUtils.dpToPx(215 + 25.0f);
                    this.backGroundView.setLayoutParams(layoutParams3);
                }
                this.recommendFriendCardInContainerOperatingLayout.setOnClickListener(this.addSpecialFollowButtonClickListener);
                this.addButtonImageView.setOnClickListener(this.addSpecialFollowButtonClickListener);
                this.addDescriptionTextView.setOnClickListener(this.addSpecialFollowButtonClickListener);
                setAddSpecialFollowState(this.cellRecommItem.iSpecialFollowed);
            }
            int i3 = this.cellRecommItem.userInfo.curUserType;
            if (i3 != 47 && i3 != 57 && i3 != 48 && i3 != 54) {
                this.certificationArea.setVisibility(8);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(-1);
                gradientDrawable.setSize(ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f));
                this.certificationArea.setBackground(gradientDrawable);
                this.certificationArea.setVisibility(0);
            }
            View view = this.mCardView;
            if (view != null) {
                Drawable background = view.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background.mutate()).setColor(com.qzone.adapter.feedcomponent.j.m());
                    return;
                }
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
        View view;
        this.mTrans = i3;
        if (!this.needFillBlackArea || (view = this.backGroundView) == null || view.getBackground() == null) {
            return;
        }
        this.backGroundView.getBackground().setAlpha(this.mTrans);
    }

    public void setCellRecommItemData(BusinessFeedData businessFeedData) {
        this.cellRecommItem = businessFeedData.cellRecommItem;
        this.businessFeedData = businessFeedData;
    }

    public void setFeedAdvContainer(FeedAdvContainer feedAdvContainer) {
        this.mFeedAdvContainer = feedAdvContainer;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        setCellRecommItemData(businessFeedData);
        update();
    }

    public void setNeedFillBlackArea(boolean z16) {
        this.needFillBlackArea = z16;
    }

    public void setParentFeedDataPos(int i3) {
        this.mParentFeedDataPos = i3;
    }

    public void updateFollowState() {
        CellRecommItem cellRecommItem = this.cellRecommItem;
        if (cellRecommItem == null || !cellRecommItem.isAddFollowButton()) {
            return;
        }
        setAddFollowState(this.cellRecommItem.isFollowed);
    }

    public void updateSpecialFollowState() {
        CellRecommItem cellRecommItem = this.cellRecommItem;
        if (cellRecommItem == null || !cellRecommItem.isAddSpecialFollowButton()) {
            return;
        }
        setAddSpecialFollowState(this.cellRecommItem.iSpecialFollowed);
    }

    public static void doReport(int i3, int i16, CellRecommItem cellRecommItem) {
        User user;
        com.qzone.adapter.feedcomponent.i.H().h(PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON, i3, 2, Integer.toString(i16), cellRecommItem == null ? null : cellRecommItem.content, cellRecommItem != null ? cellRecommItem.extendinfo.get(CellRecommItem.EXTEND_KEY_ALG) : null, (cellRecommItem == null || (user = cellRecommItem.userInfo) == null) ? 0L : user.uin);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.businessFeedData = null;
        this.cellRecommItem = null;
        this.mIsFollowClicked = false;
    }

    private void setAddFriendState(boolean z16) {
        if (z16) {
            this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.A());
            this.addDescriptionTextView.setText("\u5df2\u53d1\u9001");
        } else {
            this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.y());
            this.addDescriptionTextView.setText(this.cellRecommItem.descriptionBeforeClick);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }
}
