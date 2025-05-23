package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$ThemeFileInfo extends MessageMicro<ThemeAuth$ThemeFileInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_file_path", "str_file_md5"}, new Object[]{"", ""}, ThemeAuth$ThemeFileInfo.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_file_md5 = PBField.initString("");
}
