package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class MobileConfRsp extends MessageMicro<MobileConfRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"configType", "conf", "ret"}, new Object[]{0, "", 0}, MobileConfRsp.class);
    public final PBInt32Field configType = PBField.initInt32(0);
    public final PBStringField conf = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
}
