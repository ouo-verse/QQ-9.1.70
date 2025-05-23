package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$updateCoreInfo extends MessageMicro<ProfileUpdateMsg$updateCoreInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{160018, 160074}, new String[]{"nick", "remark"}, new Object[]{"", ""}, ProfileUpdateMsg$updateCoreInfo.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
}
