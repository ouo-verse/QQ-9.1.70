package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class MobileConfReq extends MessageMicro<MobileConfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"configType", "busiReq"}, new Object[]{0, ""}, MobileConfReq.class);
    public final PBInt32Field configType = PBField.initInt32(0);
    public final PBStringField busiReq = PBField.initString("");
}
