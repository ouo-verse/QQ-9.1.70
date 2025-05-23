package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$ReqUserInfo extends MessageMicro<oidb_0xfe1$ReqUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_req_uin", "timestamp"}, new Object[]{0L, 0L}, oidb_0xfe1$ReqUserInfo.class);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
}
