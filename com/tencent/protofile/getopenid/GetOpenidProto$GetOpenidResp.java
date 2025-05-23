package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class GetOpenidProto$GetOpenidResp extends MessageMicro<GetOpenidProto$GetOpenidResp> {
    public static final int LIST_FIELD_NUMBER = 2;
    public static final int RETCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "list"}, new Object[]{0, null}, GetOpenidProto$GetOpenidResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<GetOpenidProto$GetOpenidEntry> list = PBField.initRepeatMessage(GetOpenidProto$GetOpenidEntry.class);
}
