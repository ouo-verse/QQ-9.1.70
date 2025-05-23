package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$BeReportedReq extends MessageMicro<Security$BeReportedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"url", "cok", "bod"}, new Object[]{"", null, null}, Security$BeReportedReq.class);
    public final PBStringField url = PBField.initString("");
    public Security$COK cok = new MessageMicro<Security$COK>() { // from class: com.tencent.trpcprotocol.qqstranger.security.security.Security$COK
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"app_id", "app_key", "u_uin", "u_type", StartupReportKey.AUTH_TYPE, "u_sig_type", "u_sig", "u_id"}, new Object[]{"", "", "", "", "", "", "", ""}, Security$COK.class);
        public final PBStringField app_id = PBField.initString("");
        public final PBStringField app_key = PBField.initString("");
        public final PBStringField u_uin = PBField.initString("");
        public final PBStringField u_type = PBField.initString("");
        public final PBStringField auth_type = PBField.initString("");
        public final PBStringField u_sig_type = PBField.initString("");
        public final PBStringField u_sig = PBField.initString("");
        public final PBStringField u_id = PBField.initString("");
    };
    public Security$BOD bod = new MessageMicro<Security$BOD>() { // from class: com.tencent.trpcprotocol.qqstranger.security.security.Security$BOD
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sense", "need_all_credit"}, new Object[]{0, 0}, Security$BOD.class);
        public final PBUInt32Field sense = PBField.initUInt32(0);
        public final PBUInt32Field need_all_credit = PBField.initUInt32(0);
    };
}
