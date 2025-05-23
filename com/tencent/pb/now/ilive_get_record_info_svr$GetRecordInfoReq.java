package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_get_record_info_svr$GetRecordInfoReq extends MessageMicro<ilive_get_record_info_svr$GetRecordInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"vid", "platform", "filetype", "is_ipv6"}, new Object[]{"", 0, 0, 0}, ilive_get_record_info_svr$GetRecordInfoReq.class);
    public final PBStringField vid = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field filetype = PBField.initUInt32(0);
    public final PBUInt32Field is_ipv6 = PBField.initUInt32(0);
}
