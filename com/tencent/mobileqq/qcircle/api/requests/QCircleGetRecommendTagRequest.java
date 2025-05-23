package com.tencent.mobileqq.qcircle.api.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudTagcategorysvr$PicRecomEntry;
import feedcloud.FeedCloudTagcategorysvr$StTagCategoryRecomReq;
import feedcloud.FeedCloudTagcategorysvr$StTagCategoryRecomRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleGetRecommendTagRequest extends QCircleBaseRequest {
    public static final String TAG = "QCircleGetRecommendTagRequest";
    private FeedCloudTagcategorysvr$StTagCategoryRecomReq mReq;

    public QCircleGetRecommendTagRequest(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, List<FeedCloudTagcategorysvr$PicRecomEntry> list, String str, List<byte[]> list2, int i3) {
        FeedCloudTagcategorysvr$StTagCategoryRecomReq feedCloudTagcategorysvr$StTagCategoryRecomReq = new FeedCloudTagcategorysvr$StTagCategoryRecomReq();
        this.mReq = feedCloudTagcategorysvr$StTagCategoryRecomReq;
        feedCloudTagcategorysvr$StTagCategoryRecomReq.reqType.set(i3);
        FeedCloudTagcategorysvr$StTagCategoryRecomReq feedCloudTagcategorysvr$StTagCategoryRecomReq2 = this.mReq;
        feedCloudTagcategorysvr$StTagCategoryRecomReq2.gpsInfo = feedCloudMeta$StGPSV2;
        feedCloudTagcategorysvr$StTagCategoryRecomReq2.picRecomMap.set(list);
        if (!TextUtils.isEmpty(str)) {
            this.mReq.musicID.set(str);
        }
        if (list2 != null && !list2.isEmpty()) {
            for (int i16 = 0; i16 < list2.size(); i16++) {
                this.mReq.picBufferList.add(ByteStringMicro.copyFrom(list2.get(i16)));
            }
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.tagcategorysvr.TagCategoryProcess.GetTagCategoryRecom";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudTagcategorysvr$StTagCategoryRecomRsp feedCloudTagcategorysvr$StTagCategoryRecomRsp = new FeedCloudTagcategorysvr$StTagCategoryRecomRsp();
        try {
            feedCloudTagcategorysvr$StTagCategoryRecomRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudTagcategorysvr$StTagCategoryRecomRsp;
    }
}
