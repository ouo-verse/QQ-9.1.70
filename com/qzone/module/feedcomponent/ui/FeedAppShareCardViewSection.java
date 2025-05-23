package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedAppShareCardViewSection extends FeedViewSection {
    protected static final FeedViewSection.SectionController sectionController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedAppShareCardViewSection.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || !businessFeedData.isAppShareCardFeed();
        }
    };
    private FeedAppShareCardView mAppShareCardView;

    public FeedAppShareCardViewSection(Context context, FeedView feedView) {
        super(context, feedView);
        setSectionController(sectionController);
        this.mAppShareCardView = new FeedAppShareCardView(getContext());
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.isAppShareCardFeed()) {
            return null;
        }
        return this.mAppShareCardView;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView != null) {
            feedAppShareCardView.onApplyFeedData();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        reset();
        setOnFeedElementClickListener(null);
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView != null) {
            feedAppShareCardView.setVisibility(8);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView == null || feedAppShareCardView.getBackground() == null) {
            return;
        }
        this.mAppShareCardView.getBackground().setAlpha(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedData(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        super.setFeedData(businessFeedData, feedViewOptions);
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView != null) {
            feedAppShareCardView.setFeedData(this.mFeedData);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        super.setFeedPosition(i3);
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView != null) {
            feedAppShareCardView.setFeedPosition(i3);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView != null) {
            feedAppShareCardView.setOnFeedElementClickListener(gVar);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.mFeedData = null;
        FeedAppShareCardView feedAppShareCardView = this.mAppShareCardView;
        if (feedAppShareCardView != null) {
            feedAppShareCardView.setFeedData(null);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
    }
}
