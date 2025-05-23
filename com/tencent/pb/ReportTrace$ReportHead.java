package com.tencent.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$ReportHead extends MessageMicro<ReportTrace$ReportHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 66, 72}, new String[]{"appid", "platform", "ver", "os_ver", "model", "udid", "ip_type", "client_ip", "conn_type"}, new Object[]{0, 0, "", "", "", "", 0, ByteStringMicro.EMPTY, 0}, ReportTrace$ReportHead.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField ver = PBField.initString("");
    public final PBStringField os_ver = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField udid = PBField.initString("");
    public final PBUInt32Field ip_type = PBField.initUInt32(0);
    public final PBBytesField client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field conn_type = PBField.initUInt32(0);
}
