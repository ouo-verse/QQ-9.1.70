package com.tencent.online.push.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$ForegroundReq extends MessageMicro<OnlinePushField$ForegroundReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1360808, 1360816}, new String[]{"uin", "received_voip_msg_count"}, new Object[]{0L, 0}, OnlinePushField$ForegroundReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field received_voip_msg_count = PBField.initUInt32(0);
}
