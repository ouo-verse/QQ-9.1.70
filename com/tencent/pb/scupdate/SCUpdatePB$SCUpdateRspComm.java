package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SCUpdateRspComm extends MessageMicro<SCUpdatePB$SCUpdateRspComm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"polltime", "cookie"}, new Object[]{0, 0L}, SCUpdatePB$SCUpdateRspComm.class);
    public final PBInt32Field polltime = PBField.initInt32(0);
    public final PBInt64Field cookie = PBField.initInt64(0);
}
