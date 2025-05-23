package com.tencent.trpcprotocol.zplan.add_whitelist.handle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class handle$BatchAddWhitelistReq extends MessageMicro<handle$BatchAddWhitelistReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26}, new String[]{"appids", "ext_data"}, new Object[]{0L, ""}, handle$BatchAddWhitelistReq.class);
    public final PBRepeatField<Long> appids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField ext_data = PBField.initString("");
}
