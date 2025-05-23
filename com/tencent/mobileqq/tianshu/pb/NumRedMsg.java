package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class NumRedMsg {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumMsgBusi extends MessageMicro<NumMsgBusi> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 66, 74}, new String[]{"ui64_msgid", "ui_appid", "str_path", "str_missionid", "ui_expire_time", "str_content", "str_url", "str_ext", "str_ret"}, new Object[]{0L, 0, "", "", 0, "", "", "", ""}, NumMsgBusi.class);
        public final PBUInt64Field ui64_msgid = PBField.initUInt64(0);
        public final PBUInt32Field ui_appid = PBField.initUInt32(0);
        public final PBStringField str_path = PBField.initString("");
        public final PBStringField str_missionid = PBField.initString("");
        public final PBUInt32Field ui_expire_time = PBField.initUInt32(0);
        public final PBStringField str_content = PBField.initString("");
        public final PBStringField str_url = PBField.initString("");
        public final PBStringField str_ext = PBField.initString("");
        public final PBStringField str_ret = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumMsgReqBody extends MessageMicro<NumMsgReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"i_proto_ver", "ui_plat_id", "str_client_ver", "ui64_uin", "rpt_num_msg"}, new Object[]{0, 0, "", 0L, null}, NumMsgReqBody.class);
        public final PBInt32Field i_proto_ver = PBField.initInt32(0);
        public final PBUInt32Field ui_plat_id = PBField.initUInt32(0);
        public final PBStringField str_client_ver = PBField.initString("");
        public final PBUInt64Field ui64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<NumMsgBusi> rpt_num_msg = PBField.initRepeatMessage(NumMsgBusi.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumMsgRspBody extends MessageMicro<NumMsgRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"i_retcode", "str_errmsg", "ui64_uin", "rpt_num_red"}, new Object[]{0, "", 0L, null}, NumMsgRspBody.class);
        public final PBInt32Field i_retcode = PBField.initInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
        public final PBUInt64Field ui64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<NumMsgBusi> rpt_num_red = PBField.initRepeatMessage(NumMsgBusi.class);
    }

    NumRedMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
