package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$GetRcmdReq extends MessageMicro<NowQQLiveFocusProto$GetRcmdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, NowQQLiveFocusProto$GetRcmdReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
