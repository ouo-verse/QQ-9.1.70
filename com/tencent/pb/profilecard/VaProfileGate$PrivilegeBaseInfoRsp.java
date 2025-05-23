package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$PrivilegeBaseInfoRsp extends MessageMicro<VaProfileGate$PrivilegeBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField strJumpUrl;
    public final PBBytesField strMsg;
    public final PBUInt32Field uIsGrayUsr;
    public final PBRepeatMessageField<VaProfileGate$PrivilegeInfo> vClosePriv;
    public final PBRepeatMessageField<VaProfileGate$PrivilegeInfo> vOpenPriv;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"strMsg", "strJumpUrl", "vOpenPriv", "vClosePriv", "uIsGrayUsr"}, new Object[]{byteStringMicro, byteStringMicro, null, null, 0}, VaProfileGate$PrivilegeBaseInfoRsp.class);
    }

    public VaProfileGate$PrivilegeBaseInfoRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.strMsg = PBField.initBytes(byteStringMicro);
        this.strJumpUrl = PBField.initBytes(byteStringMicro);
        this.vOpenPriv = PBField.initRepeatMessage(VaProfileGate$PrivilegeInfo.class);
        this.vClosePriv = PBField.initRepeatMessage(VaProfileGate$PrivilegeInfo.class);
        this.uIsGrayUsr = PBField.initUInt32(0);
    }
}
