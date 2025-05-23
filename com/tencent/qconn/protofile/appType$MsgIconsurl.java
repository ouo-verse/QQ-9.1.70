package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class appType$MsgIconsurl extends MessageMicro<appType$MsgIconsurl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"size", "url"}, new Object[]{"", ""}, appType$MsgIconsurl.class);
    public final PBStringField size = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
