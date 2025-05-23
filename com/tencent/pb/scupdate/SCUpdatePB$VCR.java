package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$VCR extends MessageMicro<SCUpdatePB$VCR> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"seq", "bid", "scid", "optype", "version", "extendinfo"}, new Object[]{0L, 0, "", 0, "", null}, SCUpdatePB$VCR.class);
    public final PBInt64Field seq = PBField.initInt64(0);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField scid = PBField.initString("");
    public final PBUInt32Field optype = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
    public SCUpdatePB$ItemExtend extendinfo = new SCUpdatePB$ItemExtend();
}
