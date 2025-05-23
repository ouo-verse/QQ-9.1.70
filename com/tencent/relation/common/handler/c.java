package com.tencent.relation.common.handler;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface c {
    oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody);

    int getBusinessType();

    Bundle getRequestExtraData();

    void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, oidb_0x5eb$RspBody oidb_0x5eb_rspbody, boolean z16);
}
