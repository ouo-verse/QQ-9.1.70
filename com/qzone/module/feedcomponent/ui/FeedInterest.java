package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedInterest extends FeedViewSection {
    public static FeedViewSection.SectionController InterestHeaderController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedInterest.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getCellInterest() == null;
        }
    };
    protected VisitAndPraiseListView mFeedIntesrestView;

    public FeedInterest(Context context, FeedView feedView) {
        super(context, feedView);
        init();
    }

    void init() {
        setSectionController(InterestHeaderController);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mFeedIntesrestView == null) {
            this.mFeedIntesrestView = (VisitAndPraiseListView) generateView(VisitAndPraiseListView.class, -1);
        }
        return this.mFeedIntesrestView;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        VisitAndPraiseListView visitAndPraiseListView = this.mFeedIntesrestView;
        BusinessFeedData businessFeedData = this.mFeedData;
        visitAndPraiseListView.setInterestInfo(businessFeedData, businessFeedData.getCellInterest());
    }

    public boolean setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        return this.mFeedIntesrestView.setInterestInfo(businessFeedData, businessFeedData.getCellInterest());
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        super.setFeedPosition(i3);
        VisitAndPraiseListView visitAndPraiseListView = this.mFeedIntesrestView;
        if (visitAndPraiseListView != null) {
            visitAndPraiseListView.setFeedPosition(i3, this.mRootView.mIndex);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
        VisitAndPraiseListView visitAndPraiseListView = this.mFeedIntesrestView;
        if (visitAndPraiseListView != null) {
            visitAndPraiseListView.setOnFeedElementClickListener(gVar);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mFeedData = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.mFeedData = null;
        VisitAndPraiseListView visitAndPraiseListView = this.mFeedIntesrestView;
        if (visitAndPraiseListView != null) {
            visitAndPraiseListView.reset();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
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

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
    }
}
