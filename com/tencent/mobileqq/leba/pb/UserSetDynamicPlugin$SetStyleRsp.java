package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$SetStyleRsp extends MessageMicro<UserSetDynamicPlugin$SetStyleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"reson_code", "style"}, new Object[]{0, 0}, UserSetDynamicPlugin$SetStyleRsp.class);
    public final PBUInt32Field reson_code = PBField.initUInt32(0);
    public final PBEnumField style = PBField.initEnum(0);
}
