package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SubMsgType0x51 {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class MsgBody extends MessageMicro<MsgBody> {
        public static final int BYTES_APPNAME_FIELD_NUMBER = 4;
        public static final int BYTES_HINT1_FIELD_NUMBER = 2;
        public static final int BYTES_HINT2_FIELD_NUMBER = 3;
        public static final int BYTES_LOGINCITY_FIELD_NUMBER = 5;
        public static final int BYTES_LOGIN_CONF_FIELD_NUMBER = 8;
        public static final int BYTES_QRSIG_URL_FIELD_NUMBER = 1;
        public static final int UINT32_ALLOW_TMP_AUTH_FIELD_NUMBER = 7;
        public static final int UINT32_LOGINTIME_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_appname;
        public final PBBytesField bytes_hint1;
        public final PBBytesField bytes_hint2;
        public final PBBytesField bytes_login_conf;
        public final PBBytesField bytes_logincity;
        public final PBBytesField bytes_qrsig_url;
        public final PBUInt32Field uint32_allow_tmp_auth;
        public final PBUInt32Field uint32_logintime;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66}, new String[]{"bytes_qrsig_url", "bytes_hint1", "bytes_hint2", "bytes_appname", "bytes_logincity", "uint32_logintime", "uint32_allow_tmp_auth", "bytes_login_conf"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, MsgBody.class);
        }

        public MsgBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_qrsig_url = PBField.initBytes(byteStringMicro);
            this.bytes_hint1 = PBField.initBytes(byteStringMicro);
            this.bytes_hint2 = PBField.initBytes(byteStringMicro);
            this.bytes_appname = PBField.initBytes(byteStringMicro);
            this.bytes_logincity = PBField.initBytes(byteStringMicro);
            this.uint32_logintime = PBField.initUInt32(0);
            this.uint32_allow_tmp_auth = PBField.initUInt32(0);
            this.bytes_login_conf = PBField.initBytes(byteStringMicro);
        }
    }

    SubMsgType0x51() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
