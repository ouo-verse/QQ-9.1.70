package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.oskplayer.util.SecretUtils;

/* loaded from: classes28.dex */
public final class fd_interactive_pack$RspFDPkg extends MessageMicro<fd_interactive_pack$RspFDPkg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 88, 98, 106, 114}, new String[]{"op_uin", "result_code", "result_msg", "fdid", "cmd_type", "share_fd", "grabe_re", "recv_details"}, new Object[]{0L, 0, "", "", 0, null, null, null}, fd_interactive_pack$RspFDPkg.class);
    public final PBUInt64Field op_uin = PBField.initUInt64(0);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField result_msg = PBField.initString("");
    public final PBStringField fdid = PBField.initString("");
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public fd_interactive_pack$ShareFDRsp share_fd = new MessageMicro<fd_interactive_pack$ShareFDRsp>() { // from class: fudai.fd_interactive_pack$ShareFDRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"share_meta"}, new Object[]{null}, fd_interactive_pack$ShareFDRsp.class);
        public fd_comm$FDShareMeta share_meta = new fd_comm$FDShareMeta();
    };
    public fd_interactive_pack$GrabeRedEnvelopeRsp grabe_re = new MessageMicro<fd_interactive_pack$GrabeRedEnvelopeRsp>() { // from class: fudai.fd_interactive_pack$GrabeRedEnvelopeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 58}, new String[]{"host_prof", "grab_state", "pack_info", "top_des", "busi_elem", "switch_jmp_main_page", "luck_card_info"}, new Object[]{null, 1, null, "", null, 0, null}, fd_interactive_pack$GrabeRedEnvelopeRsp.class);
        public fd_comm$UinProf host_prof = new fd_comm$UinProf();
        public final PBEnumField grab_state = PBField.initEnum(1);
        public fd_comm$GrabPack pack_info = new fd_comm$GrabPack();
        public final PBStringField top_des = PBField.initString("");
        public fd_comm$BusiElement busi_elem = new fd_comm$BusiElement();
        public final PBUInt32Field switch_jmp_main_page = PBField.initUInt32(0);
        public fd_comm$LuckCard luck_card_info = new MessageMicro<fd_comm$LuckCard>() { // from class: fudai.fd_comm$LuckCard
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"luck_card_type", "show_icon_tab", "icon_url", "des_type", SecretUtils.DES}, new Object[]{1, Boolean.FALSE, "", 1, ""}, fd_comm$LuckCard.class);
            public final PBEnumField luck_card_type = PBField.initEnum(1);
            public final PBBoolField show_icon_tab = PBField.initBool(false);
            public final PBStringField icon_url = PBField.initString("");
            public final PBEnumField des_type = PBField.initEnum(1);
            public final PBStringField des = PBField.initString("");
        };
    };
    public fd_interactive_pack$FDRecvDetailsRsp recv_details = new MessageMicro<fd_interactive_pack$FDRecvDetailsRsp>() { // from class: fudai.fd_interactive_pack$FDRecvDetailsRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field host_uin = PBField.initUInt64(0);
        public fd_comm$BusiElement busi_elem = new fd_comm$BusiElement();
        public final PBStringField fd_desc = PBField.initString("");
        public final PBBoolField is_over = PBField.initBool(false);
        public fd_comm$GrabPack recv_info = new fd_comm$GrabPack();
        public final PBStringField fd_recv_msg = PBField.initString("");
        public final PBBoolField ctnue_share = PBField.initBool(false);
        public final PBRepeatMessageField<fd_interactive_pack$SingleRecvDetail> re_recv_list = PBField.initRepeatMessage(fd_interactive_pack$SingleRecvDetail.class);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 170}, new String[]{"host_uin", "busi_elem", "fd_desc", "is_over", "recv_info", "fd_recv_msg", "ctnue_share", "re_recv_list"}, new Object[]{0L, null, "", bool, null, "", bool, null}, fd_interactive_pack$FDRecvDetailsRsp.class);
        }
    };
}
