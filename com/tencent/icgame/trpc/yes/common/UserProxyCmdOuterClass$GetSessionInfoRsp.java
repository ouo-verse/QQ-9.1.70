package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetSessionInfoRsp extends MessageMicro<UserProxyCmdOuterClass$GetSessionInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_sig"}, new Object[]{ByteStringMicro.EMPTY}, UserProxyCmdOuterClass$GetSessionInfoRsp.class);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
