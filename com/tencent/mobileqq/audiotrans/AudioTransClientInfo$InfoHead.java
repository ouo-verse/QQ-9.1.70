package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientInfo$InfoHead extends MessageMicro<AudioTransClientInfo$InfoHead> {
    public static final int INFO_C2S_CREATE_SESSION_REQ = 1;
    public static final int INFO_C2S_CREATE_SESSION_RSP = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no"}, new Object[]{"", "", 0, 1, 0}, AudioTransClientInfo$InfoHead.class);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
}
