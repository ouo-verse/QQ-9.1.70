package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class mobileqq_qidian$PubAccItem extends MessageMicro<mobileqq_qidian$PubAccItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 56, 64, 72, 82, 90, 98}, new String[]{"uint32_type", "str_uin", "uint32_verity", "str_name", "str_desc", "str_verify_data", "uint64_state", "uint32_grade", "uint64_display", "str_extra", "str_face_url", "str_qr_url"}, new Object[]{0, "", 0, "", "", "", 0L, 0, 0L, "", "", ""}, mobileqq_qidian$PubAccItem.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_verity = PBField.initUInt32(0);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_verify_data = PBField.initString("");
    public final PBUInt64Field uint64_state = PBField.initUInt64(0);
    public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
    public final PBUInt64Field uint64_display = PBField.initUInt64(0);
    public final PBStringField str_extra = PBField.initString("");
    public final PBStringField str_face_url = PBField.initString("");
    public final PBStringField str_qr_url = PBField.initString("");
}
