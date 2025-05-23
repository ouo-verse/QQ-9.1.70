package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$FollowReq extends MessageMicro<clientbusilogic$FollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uin", "ext", "account_type", "luin"}, new Object[]{0, "", 0, 0L}, clientbusilogic$FollowReq.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField ext = PBField.initString("");
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
}
