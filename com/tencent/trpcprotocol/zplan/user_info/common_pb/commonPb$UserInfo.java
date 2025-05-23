package com.tencent.trpcprotocol.zplan.user_info.common_pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class commonPb$UserInfo extends MessageMicro<commonPb$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "infos"}, new Object[]{0L, null}, commonPb$UserInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<commonPb$Info> infos = PBField.initRepeatMessage(commonPb$Info.class);
}
