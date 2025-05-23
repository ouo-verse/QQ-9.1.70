package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes28.dex */
public final class msg_svc$PbDelRoamMsgReq extends MessageMicro<msg_svc$PbDelRoamMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"c2c_msg", "grp_msg", "dis_msg"}, new Object[]{null, null, null}, msg_svc$PbDelRoamMsgReq.class);
    public C2CMsg c2c_msg = new C2CMsg();
    public GrpMsg grp_msg = new GrpMsg();
    public DisMsg dis_msg = new DisMsg();

    /* loaded from: classes28.dex */
    public static final class C2CMsg extends MessageMicro<C2CMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{ShortVideoConstants.FROM_UIN, ProtocolDownloaderConstants.HEADER_FRIEND_UIN, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_random", "msg_seq"}, new Object[]{0L, 0L, 0, 0, 0}, C2CMsg.class);
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBUInt64Field peer_uin = PBField.initUInt64(0);
        public final PBUInt32Field msg_time = PBField.initUInt32(0);
        public final PBUInt32Field msg_random = PBField.initUInt32(0);
        public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    }

    /* loaded from: classes28.dex */
    public static final class DisMsg extends MessageMicro<DisMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"discuss_uin", "msg_seq"}, new Object[]{0L, 0L}, DisMsg.class);
        public final PBUInt64Field discuss_uin = PBField.initUInt64(0);
        public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    }

    /* loaded from: classes28.dex */
    public static final class GrpMsg extends MessageMicro<GrpMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "msg_seq", "uint32_resv_flag"}, new Object[]{0L, 0L, 0}, GrpMsg.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt64Field msg_seq = PBField.initUInt64(0);
        public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
    }
}
