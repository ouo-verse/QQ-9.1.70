package com.tencent.trpcprotocol.transfer;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class TransferPB$HTTPTransferReq extends MessageMicro<TransferPB$HTTPTransferReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"appid", "method", "url", "header", "body", "user_ip"}, new Object[]{"", "", "", "", ByteStringMicro.EMPTY, ""}, TransferPB$HTTPTransferReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField method = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField header = PBField.initString("");
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField user_ip = PBField.initString("");
}
