package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$SubCmd0x3RspSet extends MessageMicro<ThemeAuth$SubCmd0x3RspSet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int32_result", "uint32_theme_id", "uint32_suit_id", "str_diy_theme_err_msg"}, new Object[]{0, 0, 0, ""}, ThemeAuth$SubCmd0x3RspSet.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBInt32Field uint32_theme_id = PBField.initInt32(0);
    public final PBInt32Field uint32_suit_id = PBField.initInt32(0);
    public final PBStringField str_diy_theme_err_msg = PBField.initString("");
}
