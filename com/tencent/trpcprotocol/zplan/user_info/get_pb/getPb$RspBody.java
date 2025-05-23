package com.tencent.trpcprotocol.zplan.user_info.get_pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$UserInfo;

/* loaded from: classes27.dex */
public final class getPb$RspBody extends MessageMicro<getPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_infos"}, new Object[]{null}, getPb$RspBody.class);
    public final PBRepeatMessageField<commonPb$UserInfo> user_infos = PBField.initRepeatMessage(commonPb$UserInfo.class);
}
