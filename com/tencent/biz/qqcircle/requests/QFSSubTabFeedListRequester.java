package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSubTabFeedListRequester extends QCircleTabGetFeedListRequest {
    public QFSSubTabFeedListRequester(QCircleTabGetFeedListRequest.b bVar) {
        super(bVar);
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommunityPage";
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest, com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) a.c("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommunityPage").second;
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest, com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) a.c("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommunityPage").first;
    }
}
