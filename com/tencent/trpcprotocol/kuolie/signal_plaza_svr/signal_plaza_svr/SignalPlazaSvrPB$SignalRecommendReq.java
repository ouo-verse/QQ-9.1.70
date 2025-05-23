package com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class SignalPlazaSvrPB$SignalRecommendReq extends MessageMicro<SignalPlazaSvrPB$SignalRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"req_count", "partner_id", "cookies"}, new Object[]{0, 0L, ""}, SignalPlazaSvrPB$SignalRecommendReq.class);
    public final PBUInt32Field req_count = PBField.initUInt32(0);
    public final PBUInt64Field partner_id = PBField.initUInt64(0);
    public final PBStringField cookies = PBField.initString("");
}
