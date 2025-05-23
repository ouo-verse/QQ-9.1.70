package com.tencent.av.zplan.avatar.resmgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class RequestCDNServerUseStatePb$GetResCtrReq extends MessageMicro<RequestCDNServerUseStatePb$GetResCtrReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res_names"}, new Object[]{""}, RequestCDNServerUseStatePb$GetResCtrReq.class);
    public final PBRepeatField<String> res_names = PBField.initRepeat(PBStringField.__repeatHelper__);
}
