package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.requests.QCircleDoFollowRequest;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.Map;
import vd2.GroupInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleFollowApiImpl implements IQCircleFollowApi {
    private static final String TAG = "QCircleConfigApiImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
    public Map<GroupInfo, List<Entity>> getCircleFriendMap() {
        return QCircleRelationGroupManager.instance().getFriendGroupMap();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
    public BaseRequest getQCircleFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        return new QCircleDoFollowRequest(feedCloudMeta$StUser, i3, feedCloudCommon$StCommonExt);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
    public int getUinFollowed(String str) {
        return QCircleFollowManager.getInstance().getUinFollowed(str).intValue();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
    public boolean hasUin(String str) {
        return QCircleFollowManager.getInstance().hasUin(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
    public void setUinFollowed(String str, int i3) {
        QCircleFollowManager.getInstance().setUinFollowed(str, i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
    public void updateFollowUser(String str, String str2, boolean z16) {
        QCircleRelationGroupManager.instance().updateFollowFriendListToDB(str, str2, z16);
    }
}
