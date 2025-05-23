package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$VersionInfo extends MessageMicro<OpenSdkRecCommon$VersionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"sdkv", "qqv", "os"}, new Object[]{"", "", ""}, OpenSdkRecCommon$VersionInfo.class);
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342465os = PBField.initString("");
}
