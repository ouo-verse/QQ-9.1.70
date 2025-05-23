package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SecSharedInfo$SendInfo extends MessageMicro<SecSharedInfo$SendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"type", "md5", "url", "src_uin", "des_uin", "des_type"}, new Object[]{1, "", "", "", "", 0}, SecSharedInfo$SendInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField src_uin = PBField.initString("");
    public final PBStringField des_uin = PBField.initString("");
    public final PBInt32Field des_type = PBField.initInt32(0);
}
