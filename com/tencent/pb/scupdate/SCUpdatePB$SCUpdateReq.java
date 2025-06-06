package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SCUpdateReq extends MessageMicro<SCUpdatePB$SCUpdateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"cmd", "comm", "req0x01", "req0x02"}, new Object[]{0, null, null, null}, SCUpdatePB$SCUpdateReq.class);
    public final PBInt32Field cmd = PBField.initInt32(0);
    public SCUpdatePB$SCUpdateReqComm comm = new SCUpdatePB$SCUpdateReqComm();
    public SCUpdatePB$SyncVCRReq req0x01 = new SCUpdatePB$SyncVCRReq();
    public SCUpdatePB$GetUrlReq req0x02 = new SCUpdatePB$GetUrlReq();
}
