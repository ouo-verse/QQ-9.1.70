package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$GetAnchorOnline1Req extends MessageMicro<NowQQLiveFocusProto$GetAnchorOnline1Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uin", "is_uid", "source", "need_kroom"}, new Object[]{0L, 0, 0, 0}, NowQQLiveFocusProto$GetAnchorOnline1Req.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field is_uid = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field need_kroom = PBField.initUInt32(0);
}
