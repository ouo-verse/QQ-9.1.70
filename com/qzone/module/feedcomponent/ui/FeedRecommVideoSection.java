package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.shell.DittoUIEngine;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommVideoSection extends FeedViewSection {
    protected static FeedViewSection.SectionController sController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommVideoSection.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getVideoRecommendInfo() == null || businessFeedData.getVideoRecommendInfo().size() <= 0;
        }
    };
    protected FeedRecommVideoView mFeedRecommVideoView;

    public FeedRecommVideoSection(Context context, FeedView feedView) {
        super(context, feedView);
        setSectionController(sController);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mFeedRecommVideoView == null) {
            this.mFeedRecommVideoView = (FeedRecommVideoView) LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_viewstub_feed_recomm_video_view"), (ViewGroup) null);
        }
        return this.mFeedRecommVideoView;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
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
    public void reset() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
    }
}
