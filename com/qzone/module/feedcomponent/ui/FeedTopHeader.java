package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedTopHeader extends BaseFeedView implements FeedChildView {
    public static FeedViewSection.SectionController TopHeaderController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedTopHeader.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return (businessFeedData != null && businessFeedData.getFeedCommInfo().isTopFeed() && businessFeedData.feedType == 3) ? false : true;
        }
    };
    CellFeedCommInfo cellFeedCommInfo;

    public FeedTopHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1647), this);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo == null || !cellFeedCommInfo.isTopFeed();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        if (getVisibility() == 0) {
            setVisibility(8);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            Drawable background = getChildAt(i16).getBackground();
            if (background != null) {
                background.setAlpha(i3);
            }
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void update() {
        if (isEmptyData()) {
            this.hasUsed = false;
        } else {
            this.hasUsed = true;
        }
        onUpdate();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.cellFeedCommInfo = null;
        setVisibility(8);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        setVisibility(0);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
    }
}
