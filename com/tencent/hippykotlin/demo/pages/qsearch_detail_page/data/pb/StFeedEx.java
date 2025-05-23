package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class StFeedEx {
    public final String feedPb;
    public final String feedPbToken;
    public final StFeed stFeed;

    public StFeedEx(StFeed stFeed, String str) {
        this.stFeed = stFeed;
        this.feedPb = str;
        this.feedPbToken = SearchItemsKt.access$toPBToken(str);
    }

    public final void loadFeedPB() {
        String str;
        if (this.feedPb.length() == 0) {
            return;
        }
        Utils utils = Utils.INSTANCE;
        String pagerId = utils.currentBridgeModule().getPagerId();
        if (pagerId.length() > 0) {
            if (c.f117352a.k(pagerId).getPageData().getIsIOS()) {
                str = "TNF_COMM_StFeed";
            } else {
                str = "feedcloud.FeedCloudMeta$StFeed";
            }
        } else {
            str = "";
        }
        if (str.length() > 0) {
            utils.currentBridgeModule().preloadPB(str, this.feedPb, this.feedPbToken);
        } else {
            utils.logToNative("StFeedEx StFeed withFeedData className error");
        }
    }
}
