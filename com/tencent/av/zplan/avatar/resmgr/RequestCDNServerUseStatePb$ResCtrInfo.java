package com.tencent.av.zplan.avatar.resmgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class RequestCDNServerUseStatePb$ResCtrInfo extends MessageMicro<RequestCDNServerUseStatePb$ResCtrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"res_name", "status"}, new Object[]{"", 0}, RequestCDNServerUseStatePb$ResCtrInfo.class);
    public final PBStringField res_name = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
}
