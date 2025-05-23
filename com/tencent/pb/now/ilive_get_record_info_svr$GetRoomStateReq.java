package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_get_record_info_svr$GetRoomStateReq extends MessageMicro<ilive_get_record_info_svr$GetRoomStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"roomid", "source"}, new Object[]{0, ""}, ilive_get_record_info_svr$GetRoomStateReq.class);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBStringField source = PBField.initString("");
}
