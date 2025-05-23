package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GetExtendFriendInfo$ReqBody extends MessageMicro<GetExtendFriendInfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, GetExtendFriendInfo$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
