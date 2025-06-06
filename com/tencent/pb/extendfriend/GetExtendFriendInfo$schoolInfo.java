package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GetExtendFriendInfo$schoolInfo extends MessageMicro<GetExtendFriendInfo$schoolInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"str_school_id", "str_school_name", "uint64_state", "uint32_idx", "uint32_category"}, new Object[]{"", "", 0L, 0, 0}, GetExtendFriendInfo$schoolInfo.class);
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
    public final PBUInt64Field uint64_state = PBField.initUInt64(0);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_category = PBField.initUInt32(0);
}
