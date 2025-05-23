package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class GetOpenidProto$GetOpenidReq extends MessageMicro<GetOpenidProto$GetOpenidReq> {
    public static final int APPID_FIELD_NUMBER = 1;
    public static final int LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", "list"}, new Object[]{0L, null}, GetOpenidProto$GetOpenidReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBRepeatMessageField<GetOpenidProto$GetOpenidEntry> list = PBField.initRepeatMessage(GetOpenidProto$GetOpenidEntry.class);
}
