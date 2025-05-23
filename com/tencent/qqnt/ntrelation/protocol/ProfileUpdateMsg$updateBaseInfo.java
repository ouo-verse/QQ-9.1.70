package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$updateBaseInfo extends MessageMicro<ProfileUpdateMsg$updateBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8010, 160048, 160056, 160064, 160090, 160112, 160194, 160202, 160384, 192824, 192832, 192842}, new String[]{"qid", "birthdayYear", "birthdayMonth", "birthdayDay", "longNick", "gender", "eMail", "phoneNum", "categoryId", "age", "richTime", "richBuffer"}, new Object[]{"", 0, 0, 0, "", 0, "", "", 0, 0, 0, ByteStringMicro.EMPTY}, ProfileUpdateMsg$updateBaseInfo.class);
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBStringField qid = PBField.initString("");
    public final PBStringField longNick = PBField.initString("");
    public final PBUInt32Field birthdayYear = PBField.initUInt32(0);
    public final PBUInt32Field birthdayMonth = PBField.initUInt32(0);
    public final PBUInt32Field birthdayDay = PBField.initUInt32(0);
    public final PBInt32Field gender = PBField.initInt32(0);
    public final PBStringField eMail = PBField.initString("");
    public final PBStringField phoneNum = PBField.initString("");
    public final PBUInt32Field categoryId = PBField.initUInt32(0);
    public final PBUInt32Field richTime = PBField.initUInt32(0);
    public final PBBytesField richBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
}
