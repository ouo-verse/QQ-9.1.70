package com.qzone.proxy.feedcomponent.model;

import NS_UNDEAL_COUNT.feed_host_info;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedHostInfo implements SmartParcelable {
    public static final String RELATION_CONTROL = "RELATION_CONTROL";
    public static final String RELATION_COUNT = "RELATION_COUNT";
    public static final String RELATION_HOT_FEED_INFO = "RELATION_HOT_FEED_INFO";
    public String actiondesc;
    public String nickname;

    @NeedParcel
    long uin;

    public FeedHostInfo(feed_host_info feed_host_infoVar) {
        this.nickname = "";
        this.actiondesc = "";
        if (feed_host_infoVar != null) {
            this.uin = feed_host_infoVar.uUin;
            this.nickname = feed_host_infoVar.nickname;
            this.actiondesc = feed_host_infoVar.actiondesc;
        }
    }

    public long getUin() {
        return this.uin;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public FeedHostInfo() {
        this.nickname = "";
        this.actiondesc = "";
    }
}
