package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class WirelessMibao {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class CWirelessMibaoReq extends MessageMicro<CWirelessMibaoReq> {
        public static final int CMD_FIELD_NUMBER = 7;
        public static final int GUID_FIELD_NUMBER = 5;
        public static final int IMEI_FIELD_NUMBER = 6;
        public static final int IP_FIELD_NUMBER = 2;
        public static final int KSID_FIELD_NUMBER = 4;
        public static final int TIME_FIELD_NUMBER = 3;
        public static final int UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field cmd;
        public final PBBytesField guid;
        public final PBStringField imei;
        public final PBBytesField ksid;
        public final PBUInt64Field uin = PBField.initUInt64(0);

        /* renamed from: ip, reason: collision with root package name */
        public final PBUInt32Field f336521ip = PBField.initUInt32(0);
        public final PBUInt32Field time = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56}, new String[]{"uin", "ip", "time", "ksid", "guid", "imei", "cmd"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro, "", 0}, CWirelessMibaoReq.class);
        }

        public CWirelessMibaoReq() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.ksid = PBField.initBytes(byteStringMicro);
            this.guid = PBField.initBytes(byteStringMicro);
            this.imei = PBField.initString("");
            this.cmd = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class CWirelessMibaoRsp extends MessageMicro<CWirelessMibaoRsp> {
        public static final int RET_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, CWirelessMibaoRsp.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    }

    WirelessMibao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
