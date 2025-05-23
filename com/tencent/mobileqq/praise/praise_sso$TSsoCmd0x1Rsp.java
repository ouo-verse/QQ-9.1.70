package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class praise_sso$TSsoCmd0x1Rsp extends MessageMicro<praise_sso$TSsoCmd0x1Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"i32_itemId", "str_url"}, new Object[]{0, ""}, praise_sso$TSsoCmd0x1Rsp.class);
    public final PBInt32Field i32_itemId = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
}
