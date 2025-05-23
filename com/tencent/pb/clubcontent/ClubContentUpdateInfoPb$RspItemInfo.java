package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClubContentUpdateInfoPb$RspItemInfo extends MessageMicro<ClubContentUpdateInfoPb$RspItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"str_name", "uint_version", "uint_update_flag", "str_extend"}, new Object[]{"", 0, 0, ""}, ClubContentUpdateInfoPb$RspItemInfo.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint_version = PBField.initUInt32(0);
    public final PBUInt32Field uint_update_flag = PBField.initUInt32(0);
    public final PBStringField str_extend = PBField.initString("");
}
