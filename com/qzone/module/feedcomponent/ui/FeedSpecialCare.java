package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSpecialCare;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.RoundRectImageView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSpecialCare extends BaseFeedView implements FeedChildView {
    final String TAG;
    View.OnClickListener addButtonClickListener;
    ImageView addButtonImageView;
    TextView addDescriptionTextView;
    View.OnClickListener avatarClickListener;
    AvatarImageView avatarImageView;
    private View avatarSpace;
    View backGroundView;
    BusinessFeedData businessFeedData;
    private RoundRectImageView cardBgRriv;
    CellSpecialCare cellSpecialCare;
    private ImageView closeCardBtnIv;
    private TextView contentCntView;
    private TextView contentUnitView;
    private View contentView;
    private View descSpace;
    TextView descriptionTextView;
    private ImageView genderIv;
    View mCardView;
    private FeedAdvContainer mFeedAdvContainer;
    private int mParentFeedDataPos;
    int mTrans;
    boolean needFillBlackArea;
    private View nickSpace;
    TextView nicknameTextView;
    LinearLayout recommendFriendCardInContainerOperatingLayout;
    private static String networkDisable = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528");
    public static FeedViewSection.SectionController SpecialCareController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedSpecialCare.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || !businessFeedData.isSpecialCareInContainerFeed();
        }
    };

    public FeedSpecialCare(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = FeedSpecialCare.class.getSimpleName();
        this.mTrans = 255;
        this.mParentFeedDataPos = -1;
        this.mContext = context;
        setupUIWidgets(context);
    }

    public static void doReport(int i3) {
        com.qzone.adapter.feedcomponent.i.H().f(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, i3, 2);
    }

    void changeSpecialCareState() {
        CellSpecialCare cellSpecialCare = this.cellSpecialCare;
        if (cellSpecialCare != null) {
            if (cellSpecialCare.isSpecialCare) {
                this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.A());
                this.addDescriptionTextView.setTextColor(-1);
                this.addDescriptionTextView.setText(this.cellSpecialCare.descriptionBeforeClick);
                this.cellSpecialCare.isSpecialCare = false;
                return;
            }
            this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.y());
            this.addDescriptionTextView.setTextColor(-16777216);
            this.addDescriptionTextView.setText(this.cellSpecialCare.descriptionAfterClick);
            this.cellSpecialCare.isSpecialCare = true;
            return;
        }
        com.qzone.proxy.feedcomponent.b.c(this.TAG, "changeSpecialCareState data null");
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return this.cellSpecialCare == null;
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
        String[] split;
        String str;
        String str2;
        CellSpecialCare cellSpecialCare = this.cellSpecialCare;
        if (cellSpecialCare != null && cellSpecialCare.userInfo != null && cellSpecialCare.iconUrlBeforeClick != null && cellSpecialCare.iconUrlAfterClick != null) {
            this.cardBgRriv.setVisibility(8);
            this.closeCardBtnIv.setImageResource(com.qzone.adapter.feedcomponent.j.h(931));
            this.avatarSpace.setVisibility(8);
            this.nickSpace.setVisibility(8);
            this.genderIv.setVisibility(8);
            this.descSpace.setVisibility(0);
            this.contentView.setVisibility(0);
            String str3 = this.cellSpecialCare.relationContent;
            if (str3 == null) {
                split = new String[0];
            } else {
                split = str3.split("\\|");
            }
            String str4 = "";
            if (split.length <= 0) {
                str = "";
                str2 = str;
            } else {
                String str5 = split[0];
                if (split.length <= 1) {
                    str = "";
                    str2 = str;
                } else {
                    str2 = split[1];
                    if (split.length > 2) {
                        str4 = split[2];
                    }
                    str = str4;
                }
                str4 = str5;
            }
            com.qzone.adapter.feedcomponent.j.V(this.avatarImageView);
            this.avatarImageView.loadAvatar(this.cellSpecialCare.userInfo.uin, (short) com.qzone.adapter.feedcomponent.j.f(284));
            this.nicknameTextView.setText(this.cellSpecialCare.userInfo.nickName);
            this.descriptionTextView.setText(str4);
            this.contentCntView.setText(str2);
            this.contentUnitView.setText(str);
            setSpecialCareState(this.cellSpecialCare.isSpecialCare);
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

    public void setCellSpecialCareData(BusinessFeedData businessFeedData) {
        this.cellSpecialCare = businessFeedData.getCellSpecialCare();
        this.businessFeedData = businessFeedData;
    }

    public void setFeedAdvContainer(FeedAdvContainer feedAdvContainer) {
        this.mFeedAdvContainer = feedAdvContainer;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        setCellSpecialCareData(businessFeedData);
        update();
    }

    public void setNeedFillBlackArea(boolean z16) {
        this.needFillBlackArea = z16;
    }

    public void setParentFeedDataPos(int i3) {
        this.mParentFeedDataPos = i3;
    }

    void setupUIWidgets(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1661), this);
        this.mCardView = getChildAt(0);
        this.backGroundView = findViewById(com.qzone.adapter.feedcomponent.j.O(2325));
        this.closeCardBtnIv = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2514));
        this.avatarImageView = (AvatarImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2314));
        this.nicknameTextView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2315));
        this.avatarImageView.setOval();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedSpecialCare.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CellSpecialCare cellSpecialCare;
                User user;
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedSpecialCare feedSpecialCare = FeedSpecialCare.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedSpecialCare.onFeedElementClickListener;
                if (gVar != null && (cellSpecialCare = feedSpecialCare.cellSpecialCare) != null && (user = cellSpecialCare.userInfo) != null) {
                    gVar.onClick(view, FeedElement.USER_AVATAR, feedSpecialCare.feedPosition, Long.valueOf(user.uin));
                    FeedSpecialCare.this.reportAvatarClick();
                    if (FeedSpecialCare.this.cellSpecialCare.userInfo.uin > 0) {
                        com.qzone.adapter.feedcomponent.i.H().f2(619, 11, 3, String.valueOf(FeedSpecialCare.this.cellSpecialCare.userInfo.uin));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.avatarClickListener = onClickListener;
        this.avatarImageView.setOnClickListener(onClickListener);
        this.avatarImageView.setForeground((Drawable) null);
        this.nicknameTextView.setOnClickListener(this.avatarClickListener);
        TextView textView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2316));
        this.descriptionTextView = textView;
        textView.setPadding(0, 0, 0, 0);
        this.recommendFriendCardInContainerOperatingLayout = (LinearLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2327));
        this.addButtonImageView = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2317));
        this.addDescriptionTextView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2318));
        this.addButtonClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedSpecialCare.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedGlobalEnv.g().isNetworkAvailable(FeedSpecialCare.this.mContext)) {
                    FeedSpecialCare feedSpecialCare = FeedSpecialCare.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedSpecialCare.onFeedElementClickListener;
                    if (gVar != null && feedSpecialCare.cellSpecialCare != null) {
                        gVar.onClick(view, FeedElement.SPECIAL_CARE_IN_CONTAINER, feedSpecialCare.feedPosition, feedSpecialCare.businessFeedData);
                        FeedSpecialCare.this.changeSpecialCareState();
                        FeedSpecialCare.this.reportAddClick();
                    }
                } else {
                    FeedGlobalEnv.g().showToast(1000, FeedSpecialCare.this.mContext, FeedSpecialCare.networkDisable);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.closeCardBtnIv.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedSpecialCare.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                User user;
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedSpecialCare.doReport(6);
                if (FeedSpecialCare.this.mFeedAdvContainer != null) {
                    i3 = FeedSpecialCare.this.mFeedAdvContainer.mAdapter.getCurrentFeedIndex(FeedSpecialCare.this.businessFeedData);
                    FeedSpecialCare.this.mFeedAdvContainer.deleteFeedDataAndUpdate(FeedSpecialCare.this.businessFeedData);
                    CellSpecialCare cellSpecialCare = FeedSpecialCare.this.cellSpecialCare;
                    if (cellSpecialCare != null && (user = cellSpecialCare.userInfo) != null && user.uin > 0) {
                        com.qzone.adapter.feedcomponent.i.H().f2(619, 11, 5, String.valueOf(FeedSpecialCare.this.cellSpecialCare.userInfo.uin));
                    }
                } else {
                    i3 = -1;
                }
                FeedSpecialCare feedSpecialCare = FeedSpecialCare.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedSpecialCare.onFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(view, FeedElement.FEED_SPECIAL_CARE_CARD_CLOSE, feedSpecialCare.feedPosition, new Object[]{feedSpecialCare.businessFeedData, Integer.valueOf(feedSpecialCare.mParentFeedDataPos), Integer.valueOf(i3)});
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAvatarClick() {
        doReport(3);
    }

    void reportAddClick() {
        doReport(4);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.businessFeedData = null;
        this.cellSpecialCare = null;
    }

    void setSpecialCareState(boolean z16) {
        if (z16) {
            this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.A());
            this.addDescriptionTextView.setTextColor(-16777216);
            this.addDescriptionTextView.setText(this.cellSpecialCare.descriptionAfterClick);
        } else {
            this.recommendFriendCardInContainerOperatingLayout.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.y());
            this.addDescriptionTextView.setText(this.cellSpecialCare.descriptionBeforeClick);
            this.addDescriptionTextView.setTextColor(-1);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }
}
