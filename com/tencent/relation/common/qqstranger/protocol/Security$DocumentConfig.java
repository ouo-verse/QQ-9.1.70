package com.tencent.relation.common.qqstranger.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class Security$DocumentConfig extends MessageMicro<Security$DocumentConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"title", "body", "tips", "window_type", "confirm_btn_text"}, new Object[]{"", "", "", 0, ""}, Security$DocumentConfig.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField body = PBField.initString("");
    public final PBStringField tips = PBField.initString("");
    public final PBUInt32Field window_type = PBField.initUInt32(0);
    public final PBStringField confirm_btn_text = PBField.initString("");
}
