package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SCUpdateRsp extends MessageMicro<SCUpdatePB$SCUpdateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"ret", "msg", "cmd", "comm", "rsp0x01", "rsp0x02"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, null, null, null}, SCUpdatePB$SCUpdateRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f342172msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field cmd = PBField.initInt32(0);
    public SCUpdatePB$SCUpdateRspComm comm = new SCUpdatePB$SCUpdateRspComm();
    public SCUpdatePB$SyncVCRRsp rsp0x01 = new SCUpdatePB$SyncVCRRsp();
    public SCUpdatePB$GetUrlRsp rsp0x02 = new SCUpdatePB$GetUrlRsp();
}
