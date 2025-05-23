package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyRedDotCustomInfo extends QRouteApi {
    String getContentMsg();

    int getContentType();

    String getFaceUrl();

    boolean getIsOfficialNotify();

    boolean getIsOfficialNum();

    String getRecommendPeopleMsgId();

    int getRedDotNum();

    String getTopicId();

    long getUin();

    int getUserType();

    void parse(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

    void parse(Object obj);
}
