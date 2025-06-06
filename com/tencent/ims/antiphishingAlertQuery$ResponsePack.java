package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class antiphishingAlertQuery$ResponsePack extends MessageMicro<antiphishingAlertQuery$ResponsePack> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 72, 82, 90, 96}, new String[]{"u32_app_type", "u32_alert_type", "u32_default_wording", "str_toast", "str_dialog_title", "str_dialog_text", "str_dialog_btn_left", "str_dialog_btn_right", "u32_svr_url_ver", "str_download_link", "str_hash", "u32_seq"}, new Object[]{0, 0, 0, "", "", "", "", "", 0, "", "", 0}, antiphishingAlertQuery$ResponsePack.class);
    public final PBUInt32Field u32_app_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_alert_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_default_wording = PBField.initUInt32(0);
    public final PBStringField str_toast = PBField.initString("");
    public final PBStringField str_dialog_title = PBField.initString("");
    public final PBStringField str_dialog_text = PBField.initString("");
    public final PBStringField str_dialog_btn_left = PBField.initString("");
    public final PBStringField str_dialog_btn_right = PBField.initString("");
    public final PBUInt32Field u32_svr_url_ver = PBField.initUInt32(0);
    public final PBStringField str_download_link = PBField.initString("");
    public final PBStringField str_hash = PBField.initString("");
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
}
