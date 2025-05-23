package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$ItemVersion extends MessageMicro<SCUpdatePB$ItemVersion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"bid", "scid", "version", "flag", "subappid", "subitemid"}, new Object[]{0, "", "", 0, 0, 0}, SCUpdatePB$ItemVersion.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField scid = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBUInt32Field subappid = PBField.initUInt32(0);
    public final PBUInt32Field subitemid = PBField.initUInt32(0);
}
