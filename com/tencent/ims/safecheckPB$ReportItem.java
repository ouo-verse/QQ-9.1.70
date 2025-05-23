package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class safecheckPB$ReportItem extends MessageMicro<safecheckPB$ReportItem> {
    public static final int STRING_TARGET_MD5_FIELD_NUMBER = 2;
    public static final int STRING_TARGET_PACKNAME_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_target_packname", "string_target_md5"}, new Object[]{"", ""}, safecheckPB$ReportItem.class);
    public final PBStringField string_target_packname = PBField.initString("");
    public final PBStringField string_target_md5 = PBField.initString("");
}
