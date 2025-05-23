package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public final class HwSessionInfoPersistentPB {
    static IPatchRedirector $redirector_;

    /* loaded from: classes9.dex */
    public static final class HwSessionInfoPB extends MessageMicro<HwSessionInfoPB> {
        public static final int BYTES_HTTPCONN_SIG_SESSION_FIELD_NUMBER = 1;
        public static final int BYTES_SESSION_KEY_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_httpconn_sig_session;
        public final PBBytesField bytes_session_key;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_httpconn_sig_session", "bytes_session_key"}, new Object[]{byteStringMicro, byteStringMicro}, HwSessionInfoPB.class);
        }

        public HwSessionInfoPB() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_httpconn_sig_session = PBField.initBytes(byteStringMicro);
            this.bytes_session_key = PBField.initBytes(byteStringMicro);
        }
    }

    HwSessionInfoPersistentPB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
