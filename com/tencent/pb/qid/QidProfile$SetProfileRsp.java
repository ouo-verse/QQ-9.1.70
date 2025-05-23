package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QidProfile$SetProfileRsp extends MessageMicro<QidProfile$SetProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"index"}, new Object[]{0L}, QidProfile$SetProfileRsp.class);
    public final PBUInt64Field index = PBField.initUInt64(0);
}
