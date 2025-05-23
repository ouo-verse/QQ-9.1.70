package com.tencent.biz.qqcircle.immersive.personal.data;

import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$StProfileBizData;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface a {
    QQCircleBase$StUserBusiData a();

    FeedCloudRead$StGetMainPageBasicDataRsp b();

    FeedCloudMeta$StUser c();

    g d();

    QQCircleFeedBase$StMainPageBasicBusiRspData e();

    void f(String str, long j3);

    QQCircleProfile$StProfileBizData g();

    long h(String str);

    ConcurrentHashMap<Integer, Boolean> i();

    void j(String str);
}
