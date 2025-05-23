package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class GetAppInfoProto$MsgIconsurl extends MessageMicro<GetAppInfoProto$MsgIconsurl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"size", "url"}, new Object[]{"", ""}, GetAppInfoProto$MsgIconsurl.class);
    public final PBStringField size = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
