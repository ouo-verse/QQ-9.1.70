package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransCommon$MemberInfo extends MessageMicro<AudioTransCommon$MemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"str_uin", "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port"}, new Object[]{"", 0, 1, 1, 0}, AudioTransCommon$MemberInfo.class);
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
    public final PBEnumField enum_term = PBField.initEnum(1);
    public final PBEnumField enum_net_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
}
