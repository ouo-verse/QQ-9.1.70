package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes18.dex */
public final class KidModePassword$ClientInfo extends MessageMicro<KidModePassword$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"client_addr", "platform", "client_version", "guid"}, new Object[]{ByteStringMicro.EMPTY, 0, "", ""}, KidModePassword$ClientInfo.class);
    public final PBBytesField client_addr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField platform = PBField.initEnum(0);
    public final PBStringField client_version = PBField.initString("");
    public final PBStringField guid = PBField.initString("");
}
