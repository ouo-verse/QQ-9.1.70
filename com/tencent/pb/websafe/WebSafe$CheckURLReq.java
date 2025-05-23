package com.tencent.pb.websafe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class WebSafe$CheckURLReq extends MessageMicro<WebSafe$CheckURLReq> {
    public static final int GDT_DATA_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "gdt_data"}, new Object[]{"", ""}, WebSafe$CheckURLReq.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField gdt_data = PBField.initString("");
}
