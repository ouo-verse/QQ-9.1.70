package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClubContentUpdateInfoPb$RspAppInfo extends MessageMicro<ClubContentUpdateInfoPb$RspAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint_appid", "rpt_msg_rspiteminfo"}, new Object[]{0, null}, ClubContentUpdateInfoPb$RspAppInfo.class);
    public final PBUInt32Field uint_appid = PBField.initUInt32(0);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb$RspItemInfo> rpt_msg_rspiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb$RspItemInfo.class);
}
