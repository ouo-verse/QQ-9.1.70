package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.request.BaseRequest;
import feedcloud.SetSwitchReq;
import feedcloud.SetSwitchRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleNewSetUserSwitchRequest extends QCircleBaseRequest {
    private boolean mIsSwitch;
    private String mKey;
    private String mUin;

    public QCircleNewSetUserSwitchRequest(String str, String str2, boolean z16) {
        this.mUin = str;
        this.mKey = str2;
        this.mIsSwitch = z16;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.userswitch.Userswitch.SetSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        SetSwitchReq.a aVar = new SetSwitchReq.a();
        aVar.c(this.mUin);
        aVar.b(this.mKey);
        aVar.d(this.mIsSwitch);
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public SetSwitchRsp decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return SetSwitchRsp.ADAPTER.decode(bArr);
        } catch (Throwable th5) {
            RFWLog.d(BaseRequest.TAG, RFWLog.USR, "[decode] e: ", th5);
            return null;
        }
    }
}
