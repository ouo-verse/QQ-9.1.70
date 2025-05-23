package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedForward extends FeedContent {
    protected static FeedViewSection.SectionController sForwardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedForward.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null) {
                return true;
            }
            return (businessFeedData.getFeedCommInfo().showMask & 1) > 0 || businessFeedData.getOriginalInfo() == null;
        }
    };

    public FeedForward(Context context, FeedView feedView) {
        super(context, feedView);
        setForward(true);
        setSectionController(sForwardController);
    }

    public boolean isForwardVisible() {
        return isViewVisible(this.mFeedContentContainer) || isViewVisible(this.mAutoVideo);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedContent, com.qzone.module.feedcomponent.ui.FeedViewSection
    public List<View> obtainViews() {
        return super.obtainViews();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedContent, com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedContent, com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedData(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        super.setFeedData(businessFeedData, feedViewOptions);
    }

    private boolean isViewVisible(View view) {
        return view != null && view.getParent() != null && view.getVisibility() == 0 && view.getWidth() > 0 && view.getHeight() > 0;
    }
}
