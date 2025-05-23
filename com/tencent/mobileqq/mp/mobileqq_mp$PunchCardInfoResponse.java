package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes15.dex */
public final class mobileqq_mp$PunchCardInfoResponse extends MessageMicro<mobileqq_mp$PunchCardInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret_info", "body"}, new Object[]{null, ""}, mobileqq_mp$PunchCardInfoResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBStringField body = PBField.initString("");
}
