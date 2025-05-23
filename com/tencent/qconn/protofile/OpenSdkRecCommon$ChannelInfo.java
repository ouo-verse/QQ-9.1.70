package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$ChannelInfo extends MessageMicro<OpenSdkRecCommon$ChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"id", "inner_id", "join_sig"}, new Object[]{"", 0L, ByteStringMicro.EMPTY}, OpenSdkRecCommon$ChannelInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342461id = PBField.initString("");
    public final PBUInt64Field inner_id = PBField.initUInt64(0);
    public final PBBytesField join_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
