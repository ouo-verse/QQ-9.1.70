package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$ShowWindowInfo extends MessageMicro<ECWindowInfoSvr$ShowWindowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"name", "icon", "url", "desc"}, new Object[]{"", "", "", ""}, ECWindowInfoSvr$ShowWindowInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
