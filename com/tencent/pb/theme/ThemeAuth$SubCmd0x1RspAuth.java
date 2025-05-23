package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$SubCmd0x1RspAuth extends MessageMicro<ThemeAuth$SubCmd0x1RspAuth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 66, 72, 82, 88, 98, 104, 112, 120, 128}, new String[]{"int32_result", "uint32_theme_id", "str_download_url", "str_version", "uint32_size", "int32_is_sound_theme", "int32_suit_id", "str_err_msg", "uint32_diy_theme_flag", "rsp_diy_theme_info", "int32_disable_download", "rsp_diy_theme_detail", "uint32_concise_id", "uint32_concise_switch", "uint32_study_switch", "uint32_young_switch"}, new Object[]{0, 0, "", "", 0, 0, 0, "", 0, null, 0, null, 0, 0, 0, 0}, ThemeAuth$SubCmd0x1RspAuth.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
    public final PBStringField str_download_url = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBInt32Field int32_is_sound_theme = PBField.initInt32(0);
    public final PBInt32Field int32_suit_id = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBUInt32Field uint32_diy_theme_flag = PBField.initUInt32(0);
    public ThemeAuth$RspDiyThemeInfo rsp_diy_theme_info = new ThemeAuth$RspDiyThemeInfo();
    public final PBInt32Field int32_disable_download = PBField.initInt32(0);
    public ThemeAuth$RspDiyThemeDetail rsp_diy_theme_detail = new ThemeAuth$RspDiyThemeDetail();
    public final PBUInt32Field uint32_concise_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_concise_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_study_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_young_switch = PBField.initUInt32(0);
}
