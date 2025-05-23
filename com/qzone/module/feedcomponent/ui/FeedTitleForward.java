package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedTitleForward extends FeedTitle {
    boolean used;
    public static Drawable mBackgroundDrawableForward = new ColorDrawable(com.qzone.adapter.feedcomponent.j.c(12));
    protected static FeedViewSection.SectionController ForwardTitleController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedTitleForward.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.feedType == 4098 || !businessFeedData.needShowForwardTitle();
        }
    };

    public FeedTitleForward(Context context, FeedView feedView) {
        super(context, feedView);
        setForward(true);
        setSectionController(ForwardTitleController);
    }

    public int getTop() {
        CanvasTitleView canvasTitleView = this.mCanvasTitleView;
        if (canvasTitleView == null) {
            return 0;
        }
        return canvasTitleView.getTop();
    }

    public boolean isUsed() {
        return this.used;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTitle, com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mCanvasTitleView == null) {
            this.mCanvasTitleView = (CanvasTitleView) generateView(CanvasTitleView.class, -1);
        }
        this.mCanvasTitleView.setIsForward(true);
        return this.mCanvasTitleView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.FeedTitle, com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onApplyFeedData() {
        super.onApplyFeedData();
    }

    public void setTrans(int i3) {
        Drawable drawable = mBackgroundDrawableForward;
        if (drawable != null) {
            drawable.setAlpha(i3);
        }
    }

    public void setUsed(boolean z16) {
        this.used = z16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
    }

    public void onFinishSetData() {
    }
}
