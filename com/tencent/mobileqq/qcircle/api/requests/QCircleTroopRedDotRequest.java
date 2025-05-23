package com.tencent.mobileqq.qcircle.api.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.Set;
import qqcircle.QQCircleCounter$CountInfoReq;
import qqcircle.QQCircleCounter$CountInfoRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleTroopRedDotRequest extends QCircleBaseRequest {
    private QQCircleCounter$CountInfoReq mReq = new QQCircleCounter$CountInfoReq();

    public QCircleTroopRedDotRequest(Set<String> set) {
        if (set != null && set.size() != 0) {
            StringBuilder sb5 = new StringBuilder(1024);
            for (String str : set) {
                sb5.append(',');
                sb5.append(str);
            }
            if (!TextUtils.isEmpty(sb5)) {
                sb5.delete(0, 1);
            }
            String sb6 = sb5.toString();
            this.mReq.reqType.set(5);
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("group_uins");
            feedCloudCommon$Entry.value.set(sb6);
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
            this.mReq.extInfo.set(feedCloudCommon$StCommonExt);
            this.mReq.reqType.set(5);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlecounter.CircleCounter.GetSimpleCountInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp = new QQCircleCounter$CountInfoRsp();
        try {
            qQCircleCounter$CountInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleCounter$CountInfoRsp;
    }
}
