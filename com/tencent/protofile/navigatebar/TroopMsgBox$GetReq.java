package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$GetReq extends MessageMicro<TroopMsgBox$GetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cookie"}, new Object[]{ByteStringMicro.EMPTY}, TroopMsgBox$GetReq.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
