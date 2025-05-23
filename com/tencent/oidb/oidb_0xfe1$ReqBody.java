package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$ReqBody extends MessageMicro<oidb_0xfe1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"rpt_uint64_req_uins", "uint64_increment_get_start_time", "msg_req_param", "rpt_user_infos"}, new Object[]{0L, 0L, null, null}, oidb_0xfe1$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_req_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_increment_get_start_time = PBField.initUInt64(0);
    public oidb_0xfe1$ReqData msg_req_param = new oidb_0xfe1$ReqData();
    public final PBRepeatMessageField<oidb_0xfe1$ReqUserInfo> rpt_user_infos = PBField.initRepeatMessage(oidb_0xfe1$ReqUserInfo.class);
}
