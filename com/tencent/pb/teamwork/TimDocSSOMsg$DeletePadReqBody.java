package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$DeletePadReqBody extends MessageMicro<TimDocSSOMsg$DeletePadReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid;
    public final PBBytesField bytes_pad_url;
    public TimDocSSOMsg$LoginInfo msg_login_info;
    public final PBRepeatMessageField<TimDocSSOMsg$PadId> rpt_msg_padid_list;
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid;
    public final PBUInt32Field uint32_list_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58}, new String[]{"uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_list_type", "uint32_domainid", "bytes_localpadid", "rpt_msg_padid_list"}, new Object[]{0, byteStringMicro, null, 0, 0, byteStringMicro, null}, TimDocSSOMsg$DeletePadReqBody.class);
    }

    public TimDocSSOMsg$DeletePadReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pad_url = PBField.initBytes(byteStringMicro);
        this.msg_login_info = new TimDocSSOMsg$LoginInfo();
        this.uint32_list_type = PBField.initUInt32(0);
        this.uint32_domainid = PBField.initUInt32(0);
        this.bytes_localpadid = PBField.initBytes(byteStringMicro);
        this.rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg$PadId.class);
    }
}
