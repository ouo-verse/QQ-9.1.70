package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$Result extends MessageMicro<OpenSdkRecCommon$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "msg"}, new Object[]{0, ""}, OpenSdkRecCommon$Result.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342464msg = PBField.initString("");
}
