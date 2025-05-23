package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClubContentUpdateInfoPb$ReqAppInfo extends MessageMicro<ClubContentUpdateInfoPb$ReqAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint_appid", "rpt_msg_reqiteminfo"}, new Object[]{0, null}, ClubContentUpdateInfoPb$ReqAppInfo.class);
    public final PBUInt32Field uint_appid = PBField.initUInt32(0);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb$ReqItemInfo> rpt_msg_reqiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb$ReqItemInfo.class);
}
