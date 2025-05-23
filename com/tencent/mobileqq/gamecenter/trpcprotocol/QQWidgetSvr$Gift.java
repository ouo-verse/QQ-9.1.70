package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$Gift extends MessageMicro<QQWidgetSvr$Gift> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48}, new String[]{"icon", "count", "jump_url", "appid", "text", "url_type"}, new Object[]{"", 0L, "", "", "", 0}, QQWidgetSvr$Gift.class);
    public final PBStringField icon = PBField.initString("");
    public final PBInt64Field count = PBField.initInt64(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBInt32Field url_type = PBField.initInt32(0);
}
