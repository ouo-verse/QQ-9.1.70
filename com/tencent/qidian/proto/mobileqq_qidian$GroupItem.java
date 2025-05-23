package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GroupItem extends MessageMicro<mobileqq_qidian$GroupItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_groupid", "uint32_group_level", "str_group_name", "uint32_member_num"}, new Object[]{0L, 0, "", 0}, mobileqq_qidian$GroupItem.class);
    public final PBUInt64Field uint64_groupid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
    public final PBStringField str_group_name = PBField.initString("");
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
}
