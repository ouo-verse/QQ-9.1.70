package com.tencent.mobileqq.qcircle.api;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.Map;
import vd2.GroupInfo;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQCircleFollowApi extends QRouteApi {
    Map<GroupInfo, List<Entity>> getCircleFriendMap();

    BaseRequest getQCircleFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt);

    int getUinFollowed(String str);

    boolean hasUin(String str);

    void setUinFollowed(String str, int i3);

    void updateFollowUser(String str, String str2, boolean z16);
}
