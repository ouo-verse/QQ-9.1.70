package com.tencent.biz.map.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class LbsSendInfo$SendMessageReq extends MessageMicro<LbsSendInfo$SendMessageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"uint64_peer_account", "enum_relation_type", "str_name", "str_address", "str_lat", "str_lng"}, new Object[]{0L, 0, "", "", "", ""}, LbsSendInfo$SendMessageReq.class);
    public final PBUInt64Field uint64_peer_account = PBField.initUInt64(0);
    public final PBEnumField enum_relation_type = PBField.initEnum(0);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_address = PBField.initString("");
    public final PBStringField str_lat = PBField.initString("");
    public final PBStringField str_lng = PBField.initString("");
}
