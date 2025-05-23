package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TSsoCmd0x2Req extends MessageMicro<VipFunCallAndRing$TSsoCmd0x2Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"u64_friend_uin", "str_friend_phone"}, new Object[]{0L, ""}, VipFunCallAndRing$TSsoCmd0x2Req.class);
    public final PBUInt64Field u64_friend_uin = PBField.initUInt64(0);
    public final PBStringField str_friend_phone = PBField.initString("");
}
