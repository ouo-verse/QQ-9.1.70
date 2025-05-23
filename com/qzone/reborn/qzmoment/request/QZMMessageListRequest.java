package com.qzone.reborn.qzmoment.request;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentReader$StGetNoticeListReq;
import qzonemoment.QZMomentReader$StGetNoticeListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMMessageListRequest extends QZMBaseRequest {
    private QZMomentReader$StGetNoticeListReq mRequest = new QZMomentReader$StGetNoticeListReq();

    public QZMMessageListRequest(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRequest.feedAttchInfo.set(str);
        }
        this.mRequest.listNum.set(10);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qz_moment.commreader.ComReader.GetNoticeList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return getRequestByteData();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public QZMomentReader$StGetNoticeListRsp decode(byte[] bArr) {
        QZMomentReader$StGetNoticeListRsp qZMomentReader$StGetNoticeListRsp = new QZMomentReader$StGetNoticeListRsp();
        try {
            qZMomentReader$StGetNoticeListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMMessageListRequest", 1, "decode error: ", e16);
        }
        return qZMomentReader$StGetNoticeListRsp;
    }
}
