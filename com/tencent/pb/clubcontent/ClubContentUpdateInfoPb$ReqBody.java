package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class ClubContentUpdateInfoPb$ReqBody extends MessageMicro<ClubContentUpdateInfoPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"int_protocolver", "uint_clientplatid", "str_clientver", "uint_uin", "rpt_msg_reqappinfo"}, new Object[]{0, 0, "", 0L, null}, ClubContentUpdateInfoPb$ReqBody.class);
    public final PBInt32Field int_protocolver = PBField.initInt32(0);
    public final PBUInt32Field uint_clientplatid = PBField.initUInt32(0);
    public final PBStringField str_clientver = PBField.initString("");
    public final PBUInt64Field uint_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb$ReqAppInfo> rpt_msg_reqappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb$ReqAppInfo.class);
}
