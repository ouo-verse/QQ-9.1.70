package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetBusiInfoReq;
import feedcloud.FeedCloudRead$StGetBusiInfoRsp;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase$StBusiInfoReqData;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetTabListRequest extends QCircleBaseRequest {
    public final FeedCloudRead$StGetBusiInfoReq mReq;

    public QCircleGetTabListRequest(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, QCircleFolderBean qCircleFolderBean) {
        FeedCloudRead$StGetBusiInfoReq feedCloudRead$StGetBusiInfoReq = new FeedCloudRead$StGetBusiInfoReq();
        this.mReq = feedCloudRead$StGetBusiInfoReq;
        QQCircleFeedBase$StBusiInfoReqData qQCircleFeedBase$StBusiInfoReqData = new QQCircleFeedBase$StBusiInfoReqData();
        if (f.v().m() != null) {
            qQCircleFeedBase$StBusiInfoReqData.busiMap.set(f.v().m().busiMap.get());
        }
        if (feedCloudMeta$StGPSV2 != null) {
            qQCircleFeedBase$StBusiInfoReqData.gpsInfo.set(feedCloudMeta$StGPSV2);
        }
        if (qCircleFolderBean != null && qCircleFolderBean.getLastPageScheme() != null) {
            qQCircleFeedBase$StBusiInfoReqData.entrySchema.set(qCircleFolderBean.getLastPageScheme());
        }
        feedCloudRead$StGetBusiInfoReq.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StBusiInfoReqData.toByteArray()));
        a();
    }

    private void a() {
        String str;
        boolean e65 = c.e6();
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("needCityTab");
        PBStringField pBStringField = feedCloudCommon$Entry.value;
        String str2 = "1";
        if (e65) {
            str = "1";
        } else {
            str = "0";
        }
        pBStringField.set(str);
        feedCloudCommon$StCommonExt.mapInfo.set(Arrays.asList(feedCloudCommon$Entry));
        this.mReq.extInfo.set(feedCloudCommon$StCommonExt);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("wrapNearbyTabOpenConfig open bit is:");
        if (!e65) {
            str2 = "0";
        }
        sb5.append(str2);
        QLog.d("QCircleGetTabListRequest", 1, sb5.toString());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetBusiInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return new FeedCloudRead$StGetBusiInfoReq().toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetBusiInfoRsp feedCloudRead$StGetBusiInfoRsp = new FeedCloudRead$StGetBusiInfoRsp();
        try {
            feedCloudRead$StGetBusiInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetBusiInfoRsp;
    }
}
