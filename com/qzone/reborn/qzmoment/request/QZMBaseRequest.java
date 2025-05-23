package com.qzone.reborn.qzmoment.request;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZMBaseRequest extends VSBaseRequest {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(byteStringMicro));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set("97");
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("environment_id");
        entry2.value.set("2b7af41d");
        stQWebReq.Extinfo.add(entry2);
        return stQWebReq.toByteArray();
    }

    public long[] getRetryRetCodes() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public boolean isNeedRetry(long j3) {
        boolean z16 = j3 != -2;
        long[] retryRetCodes = getRetryRetCodes();
        if (retryRetCodes != null && retryRetCodes.length > 0) {
            int length = retryRetCodes.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = false;
                    break;
                }
                if (retryRetCodes[i3] == j3) {
                    z16 = true;
                    break;
                }
                i3++;
            }
        }
        QLog.d("QZMBaseRequest", 1, "CmdName:", getCmdName(), ",retCode:", Long.valueOf(j3), "isNeedRetry:" + z16);
        return z16;
    }
}
