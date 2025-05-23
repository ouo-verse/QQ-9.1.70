package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;

/* loaded from: classes5.dex */
public class QFSGetFeedListByPoolIDRequest extends QCircleTabGetFeedListRequest {
    public QFSGetFeedListByPoolIDRequest(QCircleTabGetFeedListRequest.b bVar) {
        super(bVar);
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListByYuhengPoolID";
    }
}
