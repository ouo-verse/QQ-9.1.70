package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes21.dex */
public final class ImMqPullup {
    static IPatchRedirector $redirector_ = null;
    public static final int COMMAND_CLEAR_MP_PULLUP = 2;
    public static final int COMMAND_QUERY_MP_PULLUP = 1;

    /* loaded from: classes21.dex */
    public static final class MsgReq extends MessageMicro<MsgReq> {
        public static final int COMMAND_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"command"}, new Object[]{1}, MsgReq.class);
        public final PBEnumField command = PBField.initEnum(1);
    }

    /* loaded from: classes21.dex */
    public static final class MsgRsp extends MessageMicro<MsgRsp> {
        public static final int COMMAND_FIELD_NUMBER = 1;
        public static final int UINT32_ITV_FIELD_NUMBER = 3;
        public static final int UINT32_RET_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"command", "uint32_ret", "uint32_itv"}, new Object[]{1, 0, 0}, MsgRsp.class);
        public final PBEnumField command = PBField.initEnum(1);
        public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
        public final PBUInt32Field uint32_itv = PBField.initUInt32(0);
    }

    ImMqPullup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
