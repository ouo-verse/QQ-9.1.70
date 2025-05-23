package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class subcmd0x501 {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10250}, new String[]{"msg_subcmd_0x501_req_body"}, new Object[]{null}, ReqBody.class);
        public SubCmd0x501ReqBody msg_subcmd_0x501_req_body = new SubCmd0x501ReqBody();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10250}, new String[]{"msg_subcmd_0x501_rsp_body"}, new Object[]{null}, RspBody.class);
        public SubCmd0x501Rspbody msg_subcmd_0x501_rsp_body = new SubCmd0x501Rspbody();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class SubCmd0x501ReqBody extends MessageMicro<SubCmd0x501ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88, 96}, new String[]{"uint64_uin", "uint32_idc_id", "uint32_appid", "uint32_login_sig_type", "bytes_login_sig_ticket", "uint32_request_flag", "rpt_uint32_service_types", "uint32_bid", "uint32_term", "uint32_plat", "uint32_net", "uint32_caller"}, new Object[]{0L, 0, 0, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0, 0, 0}, SubCmd0x501ReqBody.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_login_sig_type = PBField.initUInt32(0);
        public final PBBytesField bytes_login_sig_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_request_flag = PBField.initUInt32(0);
        public final PBRepeatField<Integer> rpt_uint32_service_types = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_term = PBField.initUInt32(0);
        public final PBUInt32Field uint32_plat = PBField.initUInt32(0);
        public final PBUInt32Field uint32_net = PBField.initUInt32(0);
        public final PBUInt32Field uint32_caller = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class SubCmd0x501Rspbody extends MessageMicro<SubCmd0x501Rspbody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_httpconn_sig_session;
        public final PBBytesField bytes_session_key;
        public DownloadEncryptConf msg_download_encrypt_conf;
        public DynTimeOutConf msg_dyn_timeout_conf;
        public IpLearnConf msg_ip_learn_conf;
        public OpenUpConf msg_open_up_conf;
        public PTVConf msg_ptv_conf;
        public ShortVideoConf msg_short_video_conf;
        public final PBRepeatMessageField<SrvAddrs> rpt_msg_httpconn_addrs;
        public final PBUInt32Field uint32_bigdata_policy;
        public final PBUInt32Field uint32_conn_attempt_delay;
        public final PBUInt32Field uint32_cs_conn;
        public final PBUInt32Field uint32_fmt_policy;
        public final PBUInt32Field uint32_pre_connection;
        public final PBUInt32Field uint32_share_channel;
        public final PBUInt32Field uint32_share_type;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class DownloadEncryptConf extends MessageMicro<DownloadEncryptConf> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField bool_enable_encrypt_request = PBField.initBool(false);
            public final PBBoolField bool_enable_encrypted_pic = PBField.initBool(false);
            public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"bool_enable_encrypt_request", "bool_enable_encrypted_pic", "uint32_ctrl_flag"}, new Object[]{bool, bool, 0}, DownloadEncryptConf.class);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class DynTimeOutConf extends MessageMicro<DynTimeOutConf> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152}, new String[]{"uint32_tbase_2g", "uint32_tbase_3g", "uint32_tbase_4g", "uint32_tbase_wifi", "uint32_torg_2g", "uint32_torg_3g", "uint32_torg_4g", "uint32_torg_wifi", "uint32_max_timeout", "uint32_enable_dyn_timeout", "uint32_max_timeout_2g", "uint32_max_timeout_3g", "uint32_max_timeout_4g", "uint32_max_timeout_wifi", "uint32_hb_timeout_2g", "uint32_hb_timeout_3g", "uint32_hb_timeout_4g", "uint32_hb_timeout_wifi", "uint32_hb_timeout_default"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, DynTimeOutConf.class);
            public final PBUInt32Field uint32_tbase_2g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_tbase_3g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_tbase_4g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_tbase_wifi = PBField.initUInt32(0);
            public final PBUInt32Field uint32_torg_2g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_torg_3g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_torg_4g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_torg_wifi = PBField.initUInt32(0);
            public final PBUInt32Field uint32_max_timeout = PBField.initUInt32(0);
            public final PBUInt32Field uint32_enable_dyn_timeout = PBField.initUInt32(0);
            public final PBUInt32Field uint32_max_timeout_2g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_max_timeout_3g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_max_timeout_4g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_max_timeout_wifi = PBField.initUInt32(0);
            public final PBUInt32Field uint32_hb_timeout_2g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_hb_timeout_3g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_hb_timeout_4g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_hb_timeout_wifi = PBField.initUInt32(0);
            public final PBUInt32Field uint32_hb_timeout_default = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class Ip6Addr extends MessageMicro<Ip6Addr> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uint32_type", "bytes_ip6", "uint32_port", "uint32_area", "uint32_same_isp"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, 0}, Ip6Addr.class);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public final PBBytesField bytes_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_port = PBField.initUInt32(0);
            public final PBUInt32Field uint32_area = PBField.initUInt32(0);
            public final PBUInt32Field uint32_same_isp = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class IpAddr extends MessageMicro<IpAddr> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24, 32, 40}, new String[]{"uint32_type", "uint32_ip", "uint32_port", "uint32_area", "uint32_same_isp"}, new Object[]{0, 0, 0, 0, 0}, IpAddr.class);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
            public final PBUInt32Field uint32_port = PBField.initUInt32(0);
            public final PBUInt32Field uint32_area = PBField.initUInt32(0);
            public final PBUInt32Field uint32_same_isp = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class IpLearnConf extends MessageMicro<IpLearnConf> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_refresh_cached_ip", "uint32_enable_ip_learn"}, new Object[]{0, 0}, IpLearnConf.class);
            public final PBUInt32Field uint32_refresh_cached_ip = PBField.initUInt32(0);
            public final PBUInt32Field uint32_enable_ip_learn = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class NetSegConf extends MessageMicro<NetSegConf> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_net_type", "uint32_segsize", "uint32_segnum", "uint32_curconnnum"}, new Object[]{0, 0, 0, 0}, NetSegConf.class);
            public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_segsize = PBField.initUInt32(0);
            public final PBUInt32Field uint32_segnum = PBField.initUInt32(0);
            public final PBUInt32Field uint32_curconnnum = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class OpenUpConf extends MessageMicro<OpenUpConf> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"bool_enable_openup", "uint32_pre_send_segnum", "uint32_pre_send_segnum_3g", "uint32_pre_send_segnum_4g", "uint32_pre_send_segnum_wifi"}, new Object[]{Boolean.FALSE, 0, 0, 0, 0}, OpenUpConf.class);
            public final PBBoolField bool_enable_openup = PBField.initBool(false);
            public final PBUInt32Field uint32_pre_send_segnum = PBField.initUInt32(0);
            public final PBUInt32Field uint32_pre_send_segnum_3g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_pre_send_segnum_4g = PBField.initUInt32(0);
            public final PBUInt32Field uint32_pre_send_segnum_wifi = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class PTVConf extends MessageMicro<PTVConf> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_channel_type", "rpt_msg_netsegconf", "bool_open_hardware_codec"}, new Object[]{0, null, Boolean.FALSE}, PTVConf.class);
            public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
            public final PBRepeatMessageField<NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(NetSegConf.class);
            public final PBBoolField bool_open_hardware_codec = PBField.initBool(false);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class ShortVideoConf extends MessageMicro<ShortVideoConf> {
            public static final int CHANNEL_TYPE_NEW = 2;
            public static final int CHANNEL_TYPE_OLD = 1;
            public static final int CHANNEL_TYPE_TRANSFER_WHILE_RECORDING = 3;
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
            public final PBRepeatMessageField<NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(NetSegConf.class);
            public final PBBoolField bool_open_hardware_codec = PBField.initBool(false);
            public final PBBoolField bool_send_ahead_signal = PBField.initBool(false);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_channel_type", "rpt_msg_netsegconf", "bool_open_hardware_codec", "bool_send_ahead_signal"}, new Object[]{0, null, bool, bool}, ShortVideoConf.class);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class SrvAddrs extends MessageMicro<SrvAddrs> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"uint32_service_type", "rpt_msg_addrs", "uint32_fragment_size", "rpt_msg_netsegconf", "rpt_msg_addrs_v6"}, new Object[]{0, null, 0, null, null}, SrvAddrs.class);
            public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
            public final PBRepeatMessageField<IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(IpAddr.class);
            public final PBUInt32Field uint32_fragment_size = PBField.initUInt32(0);
            public final PBRepeatMessageField<NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(NetSegConf.class);
            public final PBRepeatMessageField<Ip6Addr> rpt_msg_addrs_v6 = PBField.initRepeatMessage(Ip6Addr.class);
        }

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128}, new String[]{"bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_pre_connection", "uint32_cs_conn", "msg_ip_learn_conf", "msg_dyn_timeout_conf", "msg_open_up_conf", "msg_download_encrypt_conf", "msg_short_video_conf", "msg_ptv_conf", "uint32_share_type", "uint32_share_channel", "uint32_fmt_policy", "uint32_bigdata_policy", "uint32_conn_attempt_delay"}, new Object[]{byteStringMicro, byteStringMicro, null, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, 0}, SubCmd0x501Rspbody.class);
        }

        public SubCmd0x501Rspbody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_httpconn_sig_session = PBField.initBytes(byteStringMicro);
            this.bytes_session_key = PBField.initBytes(byteStringMicro);
            this.rpt_msg_httpconn_addrs = PBField.initRepeatMessage(SrvAddrs.class);
            this.uint32_pre_connection = PBField.initUInt32(0);
            this.uint32_cs_conn = PBField.initUInt32(0);
            this.msg_ip_learn_conf = new IpLearnConf();
            this.msg_dyn_timeout_conf = new DynTimeOutConf();
            this.msg_open_up_conf = new OpenUpConf();
            this.msg_download_encrypt_conf = new DownloadEncryptConf();
            this.msg_short_video_conf = new ShortVideoConf();
            this.msg_ptv_conf = new PTVConf();
            this.uint32_share_type = PBField.initUInt32(0);
            this.uint32_share_channel = PBField.initUInt32(0);
            this.uint32_fmt_policy = PBField.initUInt32(0);
            this.uint32_bigdata_policy = PBField.initUInt32(0);
            this.uint32_conn_attempt_delay = PBField.initUInt32(0);
        }
    }

    subcmd0x501() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
