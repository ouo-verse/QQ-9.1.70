package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.qzone.module.feedcomponent.ui.FeedViewSection;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedBirthdayGiftSection extends FeedCommonSection {
    protected com.qzone.proxy.feedcomponent.ui.h onFeedEventListener;

    public <T extends FeedFriendBirthdayGiftPanel> FeedBirthdayGiftSection(Context context, Class<T> cls, FeedViewSection.SectionController sectionController, FeedView feedView) {
        super(context, cls, sectionController, feedView);
    }

    protected void bindOnEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
        FeedChildView feedChildView = this.mView;
        if (feedChildView == null || !(feedChildView instanceof FeedFriendBirthdayGiftPanel)) {
            return;
        }
        ((FeedFriendBirthdayGiftPanel) feedChildView).setOnFeedEventListener(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.FeedCommonSection, com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onApplyFeedData() {
        super.onApplyFeedData();
        bindOnEventListener(this.onFeedEventListener);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedCommonSection, com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        bindOnEventListener(null);
    }

    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
        this.onFeedEventListener = hVar;
        if (isEmpty()) {
            return;
        }
        bindOnEventListener(hVar);
    }

    public <T extends FeedFriendBirthdayGiftPanel> FeedBirthdayGiftSection(Context context, Class<T> cls, FeedViewSection.SectionController sectionController, FeedView feedView, ViewGroup.LayoutParams layoutParams) {
        super(context, cls, sectionController, feedView, layoutParams);
    }
}
