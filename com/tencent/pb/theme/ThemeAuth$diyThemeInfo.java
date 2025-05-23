package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$diyThemeInfo extends MessageMicro<ThemeAuth$diyThemeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin32_drawer_tab_id", "uin32_message_tab_id", "uin32_aio_tab_id", "uin32_freind_tab_id", "uin32_dynamics_tab_id"}, new Object[]{0, 0, 0, 0, 0}, ThemeAuth$diyThemeInfo.class);
    public final PBUInt32Field uin32_drawer_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_message_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_aio_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_freind_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_dynamics_tab_id = PBField.initUInt32(0);
}
