package com.tencent.av.zplan.avatar.resmgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class RequestCDNServerUseStatePb$GetResCtrRsp extends MessageMicro<RequestCDNServerUseStatePb$GetResCtrRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, RequestCDNServerUseStatePb$GetResCtrRsp.class);
    public final PBRepeatMessageField<RequestCDNServerUseStatePb$ResCtrInfo> infos = PBField.initRepeatMessage(RequestCDNServerUseStatePb$ResCtrInfo.class);
}
