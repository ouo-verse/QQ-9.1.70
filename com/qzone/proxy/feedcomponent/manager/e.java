package com.qzone.proxy.feedcomponent.manager;

import NS_MOBILE_FEEDS.single_feed;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.service.FeedIncrementalUpdateService;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface e {
    void deleteByFeedsKey(String str, boolean z16);

    boolean deleteFeedData(String str, String[] strArr);

    boolean deleteFeedDataDbOnly(String str, String[] strArr);

    List<BusinessFeedData> getCurrentUIDatas();

    BusinessFeedData getFeedDataByFeedsKey(String str);

    List<BusinessFeedData> increaseUpdate(HashMap<String, FeedIncrementalUpdateService.a> hashMap, List<BusinessFeedData> list);

    List<BusinessFeedData> increaseUpdate(List<single_feed> list, List<BusinessFeedData> list2);

    BusinessFeedData query(String str, String[] strArr);

    BusinessFeedData queryWithMem(String str, String str2, String str3);

    boolean saveFakeFeed(BusinessFeedData businessFeedData);

    boolean updateFeedData(BusinessFeedData businessFeedData);
}
