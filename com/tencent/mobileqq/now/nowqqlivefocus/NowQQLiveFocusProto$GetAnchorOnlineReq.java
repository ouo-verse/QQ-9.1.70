package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$GetAnchorOnlineReq extends MessageMicro<NowQQLiveFocusProto$GetAnchorOnlineReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "is_uid"}, new Object[]{0L, 0}, NowQQLiveFocusProto$GetAnchorOnlineReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field is_uid = PBField.initUInt32(0);
}
