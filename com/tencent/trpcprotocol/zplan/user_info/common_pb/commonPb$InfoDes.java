package com.tencent.trpcprotocol.zplan.user_info.common_pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class commonPb$InfoDes extends MessageMicro<commonPb$InfoDes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"name", "type"}, new Object[]{0, 0}, commonPb$InfoDes.class);
    public final PBEnumField name = PBField.initEnum(0);
    public final PBEnumField type = PBField.initEnum(0);
}
