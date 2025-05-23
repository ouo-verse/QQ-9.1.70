package com.qzone.module.feedcomponent.ui;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface FeedChildView {
    void onRecycled();

    void onStateIdle();

    void onStateScrolling();

    void setAlpha(int i3);

    void setFeedData(BusinessFeedData businessFeedData);

    void setFeedPosition(int i3);

    void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar);
}
