package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$QidianWpaAddFriendReqBody extends MessageMicro<mobileqq_qidian$QidianWpaAddFriendReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_visitID", "uint64_customer_uin"}, new Object[]{"", 0L}, mobileqq_qidian$QidianWpaAddFriendReqBody.class);
    public final PBStringField str_visitID = PBField.initString("");
    public final PBUInt64Field uint64_customer_uin = PBField.initUInt64(0);
}
