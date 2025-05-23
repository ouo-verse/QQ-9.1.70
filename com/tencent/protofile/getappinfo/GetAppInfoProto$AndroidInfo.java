package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.vivo.push.PushClientConstants;

/* loaded from: classes22.dex */
public final class GetAppInfoProto$AndroidInfo extends MessageMicro<GetAppInfoProto$AndroidInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"apkDownUrl", "packName", PushClientConstants.TAG_CLASS_NAME, "sourceUrl", "officalwebsite", "messagetail", "bundleid"}, new Object[]{"", "", "", "", "", "", ""}, GetAppInfoProto$AndroidInfo.class);
    public final PBStringField apkDownUrl = PBField.initString("");
    public final PBStringField packName = PBField.initString("");
    public final PBStringField className = PBField.initString("");
    public final PBStringField sourceUrl = PBField.initString("");
    public final PBStringField officalwebsite = PBField.initString("");
    public final PBStringField messagetail = PBField.initString("");
    public final PBStringField bundleid = PBField.initString("");
}
