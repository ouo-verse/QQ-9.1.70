package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.shell.DittoUIEngine;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedFakeGapSection extends FeedViewSection implements FeedChildView {
    protected static FeedViewSection.SectionController FakeGapController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedFakeGapSection.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null) {
                return true;
            }
            return (businessFeedData.getRecommHeader() == null || (businessFeedData.getFeedCommInfo().isBizRecomFeeds() && businessFeedData.isSubFeed)) && businessFeedData.getCellInterest() == null;
        }
    };
    RelativeLayout mFeedFakeGap;
    ImageView mFeedFakeGapLine;

    public FeedFakeGapSection(Context context, FeedView feedView) {
        super(context, feedView);
        init();
    }

    void init() {
        setSectionController(FakeGapController);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mFeedFakeGap == null) {
            RelativeLayout relativeLayout = (RelativeLayout) DittoUIEngine.g().inflateView(getContext(), "qzone_canvas_ui_feed_fake_gap.json", (ViewGroup) null);
            this.mFeedFakeGap = relativeLayout;
            this.mFeedFakeGapLine = (ImageView) relativeLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2570));
        }
        return this.mFeedFakeGap;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        showFakeGap();
    }

    public void showFakeGap() {
        if (FeedUtil.isCurrentFeedAdvFeedTopAfter(this.mFeedData) && com.qzone.adapter.feedcomponent.i.f41893g) {
            this.mFeedFakeGap.setVisibility(0);
            if (!com.qzone.adapter.feedcomponent.i.f41890d && !FeedUtil.isCurrentFeedAdvFeedTopAfter(this.mFeedData)) {
                if (com.qzone.adapter.feedcomponent.i.f41891e < 255) {
                    ColorDrawable colorDrawable = new ColorDrawable(com.qzone.adapter.feedcomponent.j.s());
                    colorDrawable.setAlpha(com.qzone.adapter.feedcomponent.i.f41891e);
                    this.mFeedFakeGap.setBackgroundDrawable(colorDrawable);
                    com.qzone.adapter.feedcomponent.i.A2(true);
                } else {
                    this.mFeedFakeGap.setVisibility(8);
                    com.qzone.adapter.feedcomponent.i.A2(false);
                }
                this.mFeedFakeGapLine.setVisibility(8);
                return;
            }
            ColorDrawable colorDrawable2 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
            colorDrawable2.setAlpha(com.qzone.adapter.feedcomponent.i.f41891e);
            this.mFeedFakeGap.setBackgroundDrawable(colorDrawable2);
            this.mFeedFakeGapLine.setVisibility(0);
            com.qzone.adapter.feedcomponent.i.A2(true);
            return;
        }
        this.mFeedFakeGapLine.setVisibility(8);
        this.mFeedFakeGap.setVisibility(8);
        com.qzone.adapter.feedcomponent.i.A2(false);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        com.qzone.adapter.feedcomponent.i.A2(false);
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
    public void setAlpha(int i3) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
    }
}
