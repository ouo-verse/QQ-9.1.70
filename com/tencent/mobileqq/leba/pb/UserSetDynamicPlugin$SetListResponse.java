package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$SetListResponse extends MessageMicro<UserSetDynamicPlugin$SetListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sequence", "reson_code"}, new Object[]{0L, 0}, UserSetDynamicPlugin$SetListResponse.class);
    public final PBUInt64Field sequence = PBField.initUInt64(0);
    public final PBUInt32Field reson_code = PBField.initUInt32(0);
}
