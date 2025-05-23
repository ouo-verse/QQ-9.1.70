package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClubContentUpdateInfoPb$ReqItemInfo extends MessageMicro<ClubContentUpdateInfoPb$ReqItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_name", "uint_version"}, new Object[]{"", 0}, ClubContentUpdateInfoPb$ReqItemInfo.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint_version = PBField.initUInt32(0);
}
