package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$LongMsgUrlResponse extends MessageMicro<mobileqq_mp$LongMsgUrlResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ret_info", "str_url", "str_file_md5"}, new Object[]{null, "", ""}, mobileqq_mp$LongMsgUrlResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_file_md5 = PBField.initString("");
}
