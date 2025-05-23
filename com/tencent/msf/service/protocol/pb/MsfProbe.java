package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes21.dex */
public final class MsfProbe {
    static IPatchRedirector $redirector_;

    /* loaded from: classes21.dex */
    public static final class AckMsfProbeReq extends MessageMicro<AckMsfProbeReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"main_process_status"}, new Object[]{0}, AckMsfProbeReq.class);
        public final PBUInt32Field main_process_status = PBField.initUInt32(0);
    }

    /* loaded from: classes21.dex */
    public static final class MsfHelloReq extends MessageMicro<MsfHelloReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"main_process_status"}, new Object[]{0}, MsfHelloReq.class);
        public final PBUInt32Field main_process_status = PBField.initUInt32(0);
    }

    /* loaded from: classes21.dex */
    public static final class MsfHelloResp extends MessageMicro<MsfHelloResp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"reply_code", "reply_string", "msf_hello_interval"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, MsfHelloResp.class);
        public final PBUInt32Field reply_code = PBField.initUInt32(0);
        public final PBBytesField reply_string = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field msf_hello_interval = PBField.initUInt32(0);
    }

    /* loaded from: classes21.dex */
    public static final class MsfProbePush extends MessageMicro<MsfProbePush> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"msf_hello_interval"}, new Object[]{0}, MsfProbePush.class);
        public final PBUInt32Field msf_hello_interval = PBField.initUInt32(0);
    }

    MsfProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
