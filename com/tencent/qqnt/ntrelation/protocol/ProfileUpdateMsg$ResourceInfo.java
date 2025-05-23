package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$ResourceInfo extends MessageMicro<ProfileUpdateMsg$ResourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{164810, 164818, 164826, 164834, 164840, 164850, 164858}, new String[]{"iconDynamicUrl", "iconStaticUrl", "iconCartoonUrl", "iconCartoonMd5", "playCartoon", "iconName", "grayUrl"}, new Object[]{"", "", "", "", 0, "", ""}, ProfileUpdateMsg$ResourceInfo.class);
    public final PBStringField iconDynamicUrl = PBField.initString("");
    public final PBStringField iconStaticUrl = PBField.initString("");
    public final PBStringField iconCartoonUrl = PBField.initString("");
    public final PBStringField iconCartoonMd5 = PBField.initString("");
    public final PBStringField iconName = PBField.initString("");
    public final PBUInt32Field playCartoon = PBField.initUInt32(0);
    public final PBStringField grayUrl = PBField.initString("");
}
