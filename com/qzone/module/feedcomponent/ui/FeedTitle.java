package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.shell.DittoUIEngine;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedTitle extends FeedViewSection {
    protected static FeedViewSection.SectionController sTitleController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedTitle.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getUser() == null || !CanvasTitleView.hasValidUserInfo(businessFeedData.getUser()) || businessFeedData.isQCircleRecommFeed();
        }
    };
    protected CanvasTitleView mCanvasTitleView;
    protected boolean mIsForward;

    public FeedTitle(Context context, FeedView feedView) {
        super(context, feedView);
        init();
    }

    private void applyFeedDataForTitleView(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions, boolean z16, boolean z17) {
        if (!businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && !businessFeedData.isSpecialCareInContainerFeed()) {
            if (businessFeedData.isSubFeed && businessFeedData.parentContainerSubType == 1) {
                setTitleViewGone();
            } else {
                BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
                if (businessFeedData2 != null && businessFeedData2.isFriendLikeContainer()) {
                    setTitleViewGone();
                } else if (businessFeedData.isAlbumRecFeed()) {
                    setTitleViewGone();
                } else if (businessFeedData.isRecommendQQCircleFeed()) {
                    setTitleViewGone();
                } else {
                    CanvasTitleView canvasTitleView = this.mCanvasTitleView;
                    if (canvasTitleView != null) {
                        canvasTitleView.setVisibility(0);
                        this.mCanvasTitleView.setFeedData(businessFeedData, z16, z17);
                    }
                }
            }
        } else {
            setTitleViewGone();
        }
        initTitleView(businessFeedData, feedViewOptions);
    }

    private void initTitleView(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            if (feedViewOptions != null) {
                canvasTitleView.setCanComment(feedViewOptions.canComment);
                this.mCanvasTitleView.setCanReply(feedViewOptions.canReply);
                this.mCanvasTitleView.setHasInterest(feedViewOptions.isInterest);
                this.mCanvasTitleView.setIsTodayInHistoryDetail(feedViewOptions.isTodayInHistoryDetail);
            }
            this.mCanvasTitleView.setCanReturnGift(businessFeedData.getLocalInfo().canReturnGift);
            this.mCanvasTitleView.setCanLookUp(businessFeedData.getLocalInfo().canLookUp);
            this.mCanvasTitleView.setCanJoinAlbum(businessFeedData.getLocalInfo().canJoinAlbum);
            this.mCanvasTitleView.setJoinedAlbum(businessFeedData.getLocalInfo().joinedAlbum);
            this.mCanvasTitleView.setCanGiveBack(businessFeedData.getFeedCommInfo().canGiveBack());
            this.mCanvasTitleView.setCanHuNuan(businessFeedData.getLocalInfoV2().canHuNuan);
            this.mCanvasTitleView.update();
            this.mCanvasTitleView.forceLayout();
        }
    }

    private void setTitleViewGone() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.setVisibility(8);
        }
    }

    public boolean canShowFeedSkin() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        return canvasTitleView != null && canvasTitleView.canShowFeedSkin();
    }

    void init() {
        setSectionController(sTitleController);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mCanvasTitleView == null) {
            CanvasTitleView canvasTitleView = (CanvasTitleView) generateView(CanvasTitleView.class, -1);
            this.mCanvasTitleView = canvasTitleView;
            canvasTitleView.setId(DittoUIEngine.g().getResourceId("@id/feed_canvas_title_view"));
        }
        return this.mCanvasTitleView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onApplyFeedData() {
        BusinessFeedData businessFeedData;
        if (this.mIsForward) {
            businessFeedData = this.mFeedData.getOriginalInfo();
        } else {
            businessFeedData = this.mFeedData;
        }
        FeedViewSection.FeedViewOptions feedViewOptions = this.mOptions;
        applyFeedDataForTitleView(businessFeedData, feedViewOptions, feedViewOptions != null ? feedViewOptions.isPassive : false, feedViewOptions != null ? feedViewOptions.isFromMessag : false);
    }

    public void onPause() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.onPause();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.onRecycled();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.onStateIdle();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.onStateScrolling();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.update();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.reset();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.setAlpha(i3);
        }
    }

    public void setCanJoinAlbum(boolean z16) {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.setCanJoinAlbum(z16);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        super.setFeedPosition(i3);
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.setFeedPosition(i3, this.mRootView.mIndex);
        }
    }

    public void setForward(boolean z16) {
        this.mIsForward = z16;
    }

    public void setJoinedAlbum(boolean z16) {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.setJoinedAlbum(z16);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView != null) {
            canvasTitleView.setOnFeedElementClickListener(gVar);
        }
    }
}
