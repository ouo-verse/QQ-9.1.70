package com.tencent.trpcprotocol.zplan.user_info.get_pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$InfoDes;

/* loaded from: classes27.dex */
public final class getPb$ReqBody extends MessageMicro<getPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uins", "need_infos"}, new Object[]{0L, null}, getPb$ReqBody.class);
    public final PBRepeatField<Long> uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<commonPb$InfoDes> need_infos = PBField.initRepeatMessage(commonPb$InfoDes.class);
}
