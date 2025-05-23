package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$ReqShareBackflowVerify extends MessageMicro<ReqGroupVideo$ReqShareBackflowVerify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "bytes_crypt_room_info"}, new Object[]{0L, ByteStringMicro.EMPTY}, ReqGroupVideo$ReqShareBackflowVerify.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_crypt_room_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
