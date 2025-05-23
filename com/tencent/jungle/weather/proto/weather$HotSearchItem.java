package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$HotSearchItem extends MessageMicro<weather$HotSearchItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"word", "flag", "appURL", "h5URL", "miniAppURL"}, new Object[]{"", 0, "", "", ""}, weather$HotSearchItem.class);
    public final PBStringField word = PBField.initString("");
    public final PBEnumField flag = PBField.initEnum(0);
    public final PBStringField appURL = PBField.initString("");
    public final PBStringField h5URL = PBField.initString("");
    public final PBStringField miniAppURL = PBField.initString("");
}
