package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleConfig$GetRainbowKVConfReq;
import qqcircle.QQCircleConfig$GetRainbowKVConfRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetRainbowKVConfRequest extends QCircleBaseRequest {
    private QQCircleConfig$GetRainbowKVConfReq mRequest;

    public QCircleGetRainbowKVConfRequest(String str, String str2, String str3) {
        QQCircleConfig$GetRainbowKVConfReq qQCircleConfig$GetRainbowKVConfReq = new QQCircleConfig$GetRainbowKVConfReq();
        this.mRequest = qQCircleConfig$GetRainbowKVConfReq;
        qQCircleConfig$GetRainbowKVConfReq.appId.set(str);
        this.mRequest.group.set(str2);
        this.mRequest.key.set(str3);
        this.mRequest.cookie.set("");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleconfig.CircleConfigService.GetRainbowKVConfig";
    }

    public QQCircleConfig$GetRainbowKVConfReq getReq() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleConfig$GetRainbowKVConfRsp qQCircleConfig$GetRainbowKVConfRsp = new QQCircleConfig$GetRainbowKVConfRsp();
        try {
            qQCircleConfig$GetRainbowKVConfRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleConfig$GetRainbowKVConfRsp;
    }
}
