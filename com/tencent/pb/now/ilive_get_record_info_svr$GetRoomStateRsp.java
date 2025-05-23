package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_get_record_info_svr$GetRoomStateRsp extends MessageMicro<ilive_get_record_info_svr$GetRoomStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"result", "is_on_live", "vid", "recorded_share_url", "another_live_room_id", "another_live_mqq"}, new Object[]{0, 0, "", "", 0L, ""}, ilive_get_record_info_svr$GetRoomStateRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field is_on_live = PBField.initUInt32(0);
    public final PBStringField vid = PBField.initString("");
    public final PBStringField recorded_share_url = PBField.initString("");
    public final PBUInt64Field another_live_room_id = PBField.initUInt64(0);
    public final PBStringField another_live_mqq = PBField.initString("");
}
