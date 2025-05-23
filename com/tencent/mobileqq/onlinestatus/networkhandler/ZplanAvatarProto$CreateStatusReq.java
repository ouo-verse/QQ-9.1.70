package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$CreateStatusReq extends MessageMicro<ZplanAvatarProto$CreateStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"key", "md5", "sha1", "file_size", "file_type"}, new Object[]{"", "", "", 0L, ""}, ZplanAvatarProto$CreateStatusReq.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField sha1 = PBField.initString("");
    public final PBUInt64Field file_size = PBField.initUInt64(0);
    public final PBStringField file_type = PBField.initString("");
}
