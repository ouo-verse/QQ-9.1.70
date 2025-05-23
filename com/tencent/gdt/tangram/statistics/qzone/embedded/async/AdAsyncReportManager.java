package com.tencent.gdt.tangram.statistics.qzone.embedded.async;

import am0.a;
import android.text.TextUtils;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventSource;
import com.qzone.commoncode.module.videorecommend.model.VideoRecommendInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdAsyncReportManager {
    private static AdAsyncReportManager INSTANCE = new AdAsyncReportManager();
    private ArrayList<BusinessFeedData> feedDataList = new ArrayList<>();

    AdAsyncReportManager() {
    }

    public static AdAsyncReportManager getInstance() {
        return INSTANCE;
    }

    public void clearData() {
        this.feedDataList.clear();
    }

    public void report(Event event) {
        EventSource eventSource;
        Object[] objArr;
        if (event == null || (eventSource = event.source) == null || TextUtils.isEmpty(eventSource.getName()) || !"WriteOperation".equals(event.source.getName()) || (objArr = (Object[]) event.params) == null || objArr.length == 0 || !(objArr[0] instanceof String)) {
            return;
        }
        report(event.what, objArr);
    }

    private BusinessFeedData getFeedData(String str) {
        for (int i3 = 0; i3 < this.feedDataList.size(); i3++) {
            BusinessFeedData businessFeedData = this.feedDataList.get(i3);
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().ugckey != null && businessFeedData.getFeedCommInfo().ugckey.equals(str)) {
                return businessFeedData;
            }
        }
        return null;
    }

    public void addReportData(VideoRecommendInfo videoRecommendInfo) {
        if (videoRecommendInfo != null) {
            BusinessFeedData createBusinessFeedData = BusinessFeedData.createBusinessFeedData(videoRecommendInfo);
            if (createBusinessFeedData.isGDTAdvFeed()) {
                this.feedDataList.add(createBusinessFeedData);
            }
        }
    }

    public void report(int i3, Object[] objArr) {
        BusinessFeedData feedData = getFeedData((String) objArr[0]);
        if (feedData != null) {
            new a(new a.C0048a().c(feedData).b(objArr).d(i3).a()).d();
        }
    }
}
