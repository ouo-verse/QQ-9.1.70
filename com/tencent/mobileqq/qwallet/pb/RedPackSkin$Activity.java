package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$Activity extends MessageMicro<RedPackSkin$Activity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"name", "url", "icon", "a_icon"}, new Object[]{"", "", "", ""}, RedPackSkin$Activity.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField a_icon = PBField.initString("");
}
