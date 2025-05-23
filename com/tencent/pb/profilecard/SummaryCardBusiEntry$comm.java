package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$comm extends MessageMicro<SummaryCardBusiEntry$comm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 90, 96, 106, 112, 122, 136, 146, 154}, new String[]{"ver", "seq", "fromuin", "touin", "service", "session_type", "session_key", "client_ip", "display", "result", "err_msg", "platform", "qqver", "build", "msg_login_sig", "uint32_version", "msg_uin_info", "msg_rich_display"}, new Object[]{0, 0, 0L, 0L, 0, 0, ByteStringMicro.EMPTY, 0, null, 0, "", 0, "", 0, null, 0, null, null}, SummaryCardBusiEntry$comm.class);
    public final PBUInt32Field ver = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt64Field fromuin = PBField.initUInt64(0);
    public final PBUInt64Field touin = PBField.initUInt64(0);
    public final PBUInt32Field service = PBField.initUInt32(0);
    public final PBUInt32Field session_type = PBField.initUInt32(0);
    public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field client_ip = PBField.initUInt32(0);
    public SummaryCardBusiEntry$ui display = new SummaryCardBusiEntry$ui();
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField qqver = PBField.initString("");
    public final PBInt32Field build = PBField.initInt32(0);
    public SummaryCardBusiEntry$LoginSig msg_login_sig = new SummaryCardBusiEntry$LoginSig();
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public SummaryCardBusiEntry$uin_info msg_uin_info = new MessageMicro<SummaryCardBusiEntry$uin_info>() { // from class: com.tencent.pb.profilecard.SummaryCardBusiEntry$uin_info
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_longitude", "int64_latitude"}, new Object[]{0L, 0L}, SummaryCardBusiEntry$uin_info.class);
        public final PBInt64Field int64_longitude = PBField.initInt64(0);
        public final PBInt64Field int64_latitude = PBField.initInt64(0);
    };
    public SummaryCardBusiEntry$rich_ui msg_rich_display = new SummaryCardBusiEntry$rich_ui();
}
