package com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class SignalPlazaSvrPB$GetUserSignalRsp extends MessageMicro<SignalPlazaSvrPB$GetUserSignalRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "signal_info"}, new Object[]{0, "", null}, SignalPlazaSvrPB$GetUserSignalRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public SignalPlazaSvrPB$SignalInfo signal_info = new SignalPlazaSvrPB$SignalInfo();
}
