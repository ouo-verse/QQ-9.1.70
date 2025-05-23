package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$WebJsInfo extends MessageMicro<PreloadInfoCheckUpdate$WebJsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66}, new String[]{"head", "err_page_url", "err_file", "err_line", "err_message", "err_timestamp", "err_level", "phone_model"}, new Object[]{null, "", "", "", "", 0L, "", ""}, PreloadInfoCheckUpdate$WebJsInfo.class);
    public PreloadInfoCheckUpdate$ControlReqHead head = new PreloadInfoCheckUpdate$ControlReqHead();
    public final PBStringField err_page_url = PBField.initString("");
    public final PBStringField err_file = PBField.initString("");
    public final PBStringField err_line = PBField.initString("");
    public final PBStringField err_message = PBField.initString("");
    public final PBInt64Field err_timestamp = PBField.initInt64(0);
    public final PBStringField err_level = PBField.initString("");
    public final PBStringField phone_model = PBField.initString("");
}
