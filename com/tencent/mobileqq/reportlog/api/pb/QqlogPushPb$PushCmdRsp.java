package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class QqlogPushPb$PushCmdRsp extends MessageMicro<QqlogPushPb$PushCmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"seq", "ret", "msg"}, new Object[]{0, 0, ""}, QqlogPushPb$PushCmdRsp.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f281245msg = PBField.initString("");
}
