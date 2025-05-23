package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class StatSvcSimpleGet {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rept_bind_qq", "int32_battrey_status"}, new Object[]{0L, 0}, ReqBody.class);
        public final PBRepeatField<Long> rept_bind_qq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBInt32Field int32_battrey_status = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"uint32_error_code", "str_errmsg", "uint32_hello_interval", "str_clientip", "uint32_client_battey_get_interval"}, new Object[]{0, "", 0, "", 0}, RspBody.class);
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
        public final PBUInt32Field uint32_hello_interval = PBField.initUInt32(0);
        public final PBStringField str_clientip = PBField.initString("");
        public final PBUInt32Field uint32_client_battey_get_interval = PBField.initUInt32(0);
    }

    StatSvcSimpleGet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
