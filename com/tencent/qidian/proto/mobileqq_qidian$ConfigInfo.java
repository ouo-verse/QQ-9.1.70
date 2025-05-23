package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ConfigInfo extends MessageMicro<mobileqq_qidian$ConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104}, new String[]{"uint32_type", "uint32_event", "str_title", "str_content", "str_action", "str_aaction", "str_iaction", "str_paction", "msg_corp_simple", "str_url", "str_log", "str_lat", "uint32_title_type"}, new Object[]{0, 0, "", "", "", "", "", "", null, "", "", "", 0}, mobileqq_qidian$ConfigInfo.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_event = PBField.initUInt32(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_action = PBField.initString("");
    public final PBStringField str_aaction = PBField.initString("");
    public final PBStringField str_iaction = PBField.initString("");
    public final PBStringField str_paction = PBField.initString("");
    public mobileqq_qidian$ConfigCorpSimpleInfo msg_corp_simple = new mobileqq_qidian$ConfigCorpSimpleInfo();
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_log = PBField.initString("");
    public final PBStringField str_lat = PBField.initString("");
    public final PBUInt32Field uint32_title_type = PBField.initUInt32(0);
}
