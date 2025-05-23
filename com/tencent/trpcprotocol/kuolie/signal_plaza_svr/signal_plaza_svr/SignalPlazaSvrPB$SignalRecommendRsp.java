package com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class SignalPlazaSvrPB$SignalRecommendRsp extends MessageMicro<SignalPlazaSvrPB$SignalRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"ret_code", "ret_msg", "signal_infos", "flag_end", "cookies"}, new Object[]{0, "", null, 0, ""}, SignalPlazaSvrPB$SignalRecommendRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<SignalPlazaSvrPB$SignalInfo> signal_infos = PBField.initRepeatMessage(SignalPlazaSvrPB$SignalInfo.class);
    public final PBUInt32Field flag_end = PBField.initUInt32(0);
    public final PBStringField cookies = PBField.initString("");
}
