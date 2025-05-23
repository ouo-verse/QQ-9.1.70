package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$GroupReqItem;
import feedcloud.FeedCloudRead$StGetRelationGroupListReq;
import feedcloud.FeedCloudRead$StGetRelationGroupListRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleRelationGroupRequest extends QCircleBaseRequest {
    public static final String ATTACH_INFO = "attachInfo";
    private static final int DEF_LOAD_COUNT = 1000;
    public static final String GROUP_ID = "gid";
    private FeedCloudRead$StGetRelationGroupListReq mRequest = new FeedCloudRead$StGetRelationGroupListReq();

    public QCircleRelationGroupRequest(int i3, List<Map<String, Object>> list) {
        List<FeedCloudRead$GroupReqItem> convertGroupReqItems = convertGroupReqItems(list);
        if (convertGroupReqItems != null && !convertGroupReqItems.isEmpty()) {
            this.mRequest.reqItems.set(convertGroupReqItems);
        }
        this.mRequest.scene.set(i3);
        this.mRequest.count.set(1000L);
    }

    private List<FeedCloudRead$GroupReqItem> convertGroupReqItems(List<Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Map<String, Object> map : list) {
                FeedCloudRead$GroupReqItem feedCloudRead$GroupReqItem = new FeedCloudRead$GroupReqItem();
                Object obj = map.get(GROUP_ID);
                if (obj instanceof String) {
                    feedCloudRead$GroupReqItem.gid.set(obj.toString());
                }
                Object obj2 = map.get("attachInfo");
                if (obj2 instanceof String) {
                    feedCloudRead$GroupReqItem.attachInfo.set(obj2.toString());
                }
                arrayList.add(feedCloudRead$GroupReqItem);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRelationGroupList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        FeedCloudRead$StGetRelationGroupListReq feedCloudRead$StGetRelationGroupListReq = this.mRequest;
        if (feedCloudRead$StGetRelationGroupListReq == null) {
            return new byte[0];
        }
        return feedCloudRead$StGetRelationGroupListReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetRelationGroupListRsp feedCloudRead$StGetRelationGroupListRsp = new FeedCloudRead$StGetRelationGroupListRsp();
        try {
            feedCloudRead$StGetRelationGroupListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetRelationGroupListRsp;
    }
}
