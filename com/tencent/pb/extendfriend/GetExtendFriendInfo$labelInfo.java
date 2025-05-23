package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GetExtendFriendInfo$labelInfo extends MessageMicro<GetExtendFriendInfo$labelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_label_id", "str_label_name"}, new Object[]{0L, ""}, GetExtendFriendInfo$labelInfo.class);
    public final PBUInt64Field uint64_label_id = PBField.initUInt64(0);
    public final PBStringField str_label_name = PBField.initString("");
}
