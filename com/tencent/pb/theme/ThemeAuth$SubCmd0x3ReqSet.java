package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$SubCmd0x3ReqSet extends MessageMicro<ThemeAuth$SubCmd0x3ReqSet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_theme_id", "uint32_suit_id", "uint32_diy_theme_flag", "diy_theme_info"}, new Object[]{0, 0, 0, null}, ThemeAuth$SubCmd0x3ReqSet.class);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_suit_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_diy_theme_flag = PBField.initUInt32(0);
    public ThemeAuth$diyThemeInfo diy_theme_info = new ThemeAuth$diyThemeInfo();
}
