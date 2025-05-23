package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$AppReqInfo extends MessageMicro<OpenSdkRecCommon$AppReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"appid", "sdkp", "qq_app_type", "md5time", "sign", "appUniqueIdentifier"}, new Object[]{0L, "", 0, 0L, "", ""}, OpenSdkRecCommon$AppReqInfo.class);
    public final PBInt64Field appid = PBField.initInt64(0);
    public final PBStringField sdkp = PBField.initString("");
    public final PBEnumField qq_app_type = PBField.initEnum(0);
    public final PBInt64Field md5time = PBField.initInt64(0);
    public final PBStringField sign = PBField.initString("");
    public final PBStringField appUniqueIdentifier = PBField.initString("");
}
