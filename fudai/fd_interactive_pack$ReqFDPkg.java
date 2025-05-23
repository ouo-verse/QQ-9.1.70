package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class fd_interactive_pack$ReqFDPkg extends MessageMicro<fd_interactive_pack$ReqFDPkg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 88, 98, 106, 114, 122}, new String[]{"fdid", "cmd_type", "share_fd", "grabe_re", "recv_details", "device_info"}, new Object[]{"", 0, null, null, null, ""}, fd_interactive_pack$ReqFDPkg.class);
    public final PBStringField fdid = PBField.initString("");
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public fd_interactive_pack$ShareFDReq share_fd = new MessageMicro<fd_interactive_pack$ShareFDReq>() { // from class: fudai.fd_interactive_pack$ShareFDReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"host_prof", "share_meta"}, new Object[]{null, null}, fd_interactive_pack$ShareFDReq.class);
        public fd_comm$UinProf host_prof = new fd_comm$UinProf();
        public fd_comm$FDShareMeta share_meta = new fd_comm$FDShareMeta();
    };
    public fd_interactive_pack$GrabeRedEnvelopeReq grabe_re = new MessageMicro<fd_interactive_pack$GrabeRedEnvelopeReq>() { // from class: fudai.fd_interactive_pack$GrabeRedEnvelopeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 88}, new String[]{"op_prof", "host_uin", "share_meta", "src_version"}, new Object[]{null, 0L, null, 0}, fd_interactive_pack$GrabeRedEnvelopeReq.class);
        public fd_comm$UinProf op_prof = new fd_comm$UinProf();
        public final PBUInt64Field host_uin = PBField.initUInt64(0);
        public fd_comm$FDShareMeta share_meta = new fd_comm$FDShareMeta();
        public final PBUInt32Field src_version = PBField.initUInt32(0);
    };
    public fd_interactive_pack$FDRecvDetailsReq recv_details = new MessageMicro<fd_interactive_pack$FDRecvDetailsReq>() { // from class: fudai.fd_interactive_pack$FDRecvDetailsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"op_uin", "host_uin"}, new Object[]{0L, 0L}, fd_interactive_pack$FDRecvDetailsReq.class);
        public final PBUInt64Field op_uin = PBField.initUInt64(0);
        public final PBUInt64Field host_uin = PBField.initUInt64(0);
    };
    public final PBStringField device_info = PBField.initString("");
}
