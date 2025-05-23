package com.qzone.reborn.qzmoment.request;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentReader$StGetLightInteractListReq;
import qzonemoment.QZMomentReader$StGetLightInteractListRsp;

/* loaded from: classes37.dex */
public class QZMGetPraiseListRequest extends QZMBaseRequest {
    private QZMomentReader$StGetLightInteractListReq mRequest = new QZMomentReader$StGetLightInteractListReq();

    public QZMGetPraiseListRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRequest.attachInfo.set(str);
        }
        this.mRequest.type.set(0);
        if (qZMomentMeta$StFeed != null) {
            this.mRequest.feedID.set(qZMomentMeta$StFeed.f430362id.get());
            this.mRequest.hostID.set(qZMomentMeta$StFeed.poster.f430367id.get());
            this.mRequest.f430368id.set(qZMomentMeta$StFeed.likeInfo.f430363id.get());
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commreader.ComReader.GetLightInteractList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return get$pbReqBytes();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public QZMomentReader$StGetLightInteractListRsp decode(byte[] bArr) {
        QZMomentReader$StGetLightInteractListRsp qZMomentReader$StGetLightInteractListRsp = new QZMomentReader$StGetLightInteractListRsp();
        try {
            qZMomentReader$StGetLightInteractListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMPraiseListRequest", 1, "decode error: ", e16);
        }
        return qZMomentReader$StGetLightInteractListRsp;
    }
}
