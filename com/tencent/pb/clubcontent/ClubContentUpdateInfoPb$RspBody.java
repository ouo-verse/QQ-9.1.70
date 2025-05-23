package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class ClubContentUpdateInfoPb$RspBody extends MessageMicro<ClubContentUpdateInfoPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int_result", "rpt_msg_rspappinfo"}, new Object[]{0, null}, ClubContentUpdateInfoPb$RspBody.class);
    public final PBInt32Field int_result = PBField.initInt32(0);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb$RspAppInfo> rpt_msg_rspappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb$RspAppInfo.class);
}
