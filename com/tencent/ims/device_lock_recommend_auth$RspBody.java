package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class device_lock_recommend_auth$RspBody extends MessageMicro<device_lock_recommend_auth$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_uin", "uint32_seq", "uint32_ret", "rpt_msg_devicelist"}, new Object[]{0L, 0, 0, null}, device_lock_recommend_auth$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBRepeatMessageField<device_lock_recommend_auth$DeviceInfo> rpt_msg_devicelist = PBField.initRepeatMessage(device_lock_recommend_auth$DeviceInfo.class);
}
