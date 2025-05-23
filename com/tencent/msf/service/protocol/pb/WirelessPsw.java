package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes21.dex */
public final class WirelessPsw {
    static IPatchRedirector $redirector_;

    /* loaded from: classes21.dex */
    public static final class CWirelessPswReq extends MessageMicro<CWirelessPswReq> {
        public static final int CMD_FIELD_NUMBER = 5;
        public static final int IP_FIELD_NUMBER = 2;
        public static final int KSID_FIELD_NUMBER = 4;
        public static final int TIME_FIELD_NUMBER = 3;
        public static final int UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uin", "ip", "time", "ksid", "cmd"}, new Object[]{0L, 0, 0, ByteStringMicro.EMPTY, 0}, CWirelessPswReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);

        /* renamed from: ip, reason: collision with root package name */
        public final PBUInt32Field f336522ip = PBField.initUInt32(0);
        public final PBUInt32Field time = PBField.initUInt32(0);
        public final PBBytesField ksid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field cmd = PBField.initUInt32(0);
    }

    /* loaded from: classes21.dex */
    public static final class CWirelessPswRsp extends MessageMicro<CWirelessPswRsp> {
        public static final int RET_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, CWirelessPswRsp.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    }

    WirelessPsw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
