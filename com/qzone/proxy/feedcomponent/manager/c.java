package com.qzone.proxy.feedcomponent.manager;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface c {
    void onFeedCreate(BusinessFeedData businessFeedData);

    void onFeedDelete();

    void onFeedPartionUpdate(List<BusinessFeedData> list);

    void onFeedUpdate(BusinessFeedData businessFeedData, boolean z16);
}
