package com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;

/* loaded from: classes27.dex */
public final class SignalPlazaSvrPB$GetSignalConfigRsp extends MessageMicro<SignalPlazaSvrPB$GetSignalConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret_code", "ret_msg", "signal_configs", "signal_expire"}, new Object[]{0, "", null, 0L}, SignalPlazaSvrPB$GetSignalConfigRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<SignalPB$SignalConfig> signal_configs = PBField.initRepeatMessage(SignalPB$SignalConfig.class);
    public final PBUInt64Field signal_expire = PBField.initUInt64(0);
}
