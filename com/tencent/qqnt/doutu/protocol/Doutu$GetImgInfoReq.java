package com.tencent.qqnt.doutu.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Doutu$GetImgInfoReq extends MessageMicro<Doutu$GetImgInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_src_uin", "uint32_src_term", "uint32_age", "uin32_gender", "uint64_to_uin", "chat_type"}, new Object[]{0L, 0, 0, 0, 0L, 1}, Doutu$GetImgInfoReq.class);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBEnumField chat_type = PBField.initEnum(1);
}
