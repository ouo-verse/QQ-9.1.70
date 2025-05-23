package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0xe96$RspBody extends MessageMicro<oidb_0xe96$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"uint32_display_flag", "str_hori_bar_content", "str_change_mibao_url", "str_tips_header", "str_tips_content", "uint32_next_access_time"}, new Object[]{0, "", "", "", "", 0}, oidb_0xe96$RspBody.class);
    public final PBUInt32Field uint32_display_flag = PBField.initUInt32(0);
    public final PBStringField str_hori_bar_content = PBField.initString("");
    public final PBStringField str_change_mibao_url = PBField.initString("");
    public final PBStringField str_tips_header = PBField.initString("");
    public final PBStringField str_tips_content = PBField.initString("");
    public final PBUInt32Field uint32_next_access_time = PBField.initUInt32(0);
}
