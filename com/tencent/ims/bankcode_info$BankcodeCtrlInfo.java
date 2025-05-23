package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class bankcode_info$BankcodeCtrlInfo extends MessageMicro<bankcode_info$BankcodeCtrlInfo> {
    public static final int BANKCODE_ELEMS_FIELD_NUMBER = 1;
    public static final int FROMUIN_PHONENUM_FIELD_NUMBER = 6;
    public static final int MSGTAIL_CONF_FILE_MD5_FIELD_NUMBER = 5;
    public static final int MSGTAIL_CONF_FILE_URL_FIELD_NUMBER = 4;
    public static final int MSGTAIL_ID_FIELD_NUMBER = 2;
    public static final int MSGTAIL_VER_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"bankcode_elems", "msgtail_id", "msgtail_ver", "msgtail_conf_file_url", "msgtail_conf_file_md5", "fromuin_phonenum"}, new Object[]{null, 0, 0, "", "", ""}, bankcode_info$BankcodeCtrlInfo.class);
    public final PBRepeatMessageField<bankcode_info$BankcodeElem> bankcode_elems = PBField.initRepeatMessage(bankcode_info$BankcodeElem.class);
    public final PBUInt32Field msgtail_id = PBField.initUInt32(0);
    public final PBUInt32Field msgtail_ver = PBField.initUInt32(0);
    public final PBStringField msgtail_conf_file_url = PBField.initString("");
    public final PBStringField msgtail_conf_file_md5 = PBField.initString("");
    public final PBStringField fromuin_phonenum = PBField.initString("");
}
