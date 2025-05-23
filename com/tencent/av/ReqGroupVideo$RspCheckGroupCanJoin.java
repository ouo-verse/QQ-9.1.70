package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$RspCheckGroupCanJoin extends MessageMicro<ReqGroupVideo$RspCheckGroupCanJoin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"result", "is_can_join", "join_wording"}, new Object[]{null, Boolean.FALSE, ByteStringMicro.EMPTY}, ReqGroupVideo$RspCheckGroupCanJoin.class);
    public common$ErrorInfo result = new common$ErrorInfo();
    public final PBBoolField is_can_join = PBField.initBool(false);
    public final PBBytesField join_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
