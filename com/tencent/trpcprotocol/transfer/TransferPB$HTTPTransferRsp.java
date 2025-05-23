package com.tencent.trpcprotocol.transfer;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class TransferPB$HTTPTransferRsp extends MessageMicro<TransferPB$HTTPTransferRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"status_code", "header", "body"}, new Object[]{0, "", ByteStringMicro.EMPTY}, TransferPB$HTTPTransferRsp.class);
    public final PBInt32Field status_code = PBField.initInt32(0);
    public final PBStringField header = PBField.initString("");
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
}
