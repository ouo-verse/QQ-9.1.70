package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
@Deprecated
/* loaded from: classes19.dex */
public interface IHttpEngineService extends IRuntimeService {
    void cancelReq(NetReq netReq);

    void sendReq(NetReq netReq);

    NetResp sendReqSync(NetReq netReq);
}
