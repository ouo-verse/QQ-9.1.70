package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$SubCmd0x2ReqCheck extends MessageMicro<ThemeAuth$SubCmd0x2ReqCheck> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_theme_id", "str_theme_version"}, new Object[]{0, ""}, ThemeAuth$SubCmd0x2ReqCheck.class);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
    public final PBStringField str_theme_version = PBField.initString("");
}
