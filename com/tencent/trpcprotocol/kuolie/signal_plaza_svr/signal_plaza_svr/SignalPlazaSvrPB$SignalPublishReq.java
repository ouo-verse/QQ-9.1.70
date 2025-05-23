package com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class SignalPlazaSvrPB$SignalPublishReq extends MessageMicro<SignalPlazaSvrPB$SignalPublishReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"partner_id", "partner_adj_id"}, new Object[]{0L, 0L}, SignalPlazaSvrPB$SignalPublishReq.class);
    public final PBUInt64Field partner_id = PBField.initUInt64(0);
    public final PBUInt64Field partner_adj_id = PBField.initUInt64(0);
}
