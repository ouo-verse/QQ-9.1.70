package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.request.BaseRequest;
import feedcloud.GetSwitchReq;
import feedcloud.GetSwitchRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleNewGetUserSwitchRequest extends QCircleBaseRequest {
    private List<String> mKeys;
    private GetSwitchReq mReq;
    private String mUin;

    public QCircleNewGetUserSwitchRequest(String str, List<String> list) {
        this.mUin = str;
        ArrayList arrayList = new ArrayList();
        this.mKeys = arrayList;
        arrayList.addAll(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.userswitch.Userswitch.GetSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        GetSwitchReq.a aVar = new GetSwitchReq.a();
        aVar.c(Arrays.asList(this.mUin));
        aVar.b(this.mKeys);
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public GetSwitchRsp decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return GetSwitchRsp.ADAPTER.decode(bArr);
        } catch (Throwable th5) {
            RFWLog.d(BaseRequest.TAG, RFWLog.USR, "[decode] e: ", th5);
            return null;
        }
    }
}
