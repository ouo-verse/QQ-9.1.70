package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class CSDataHighwayHead {
    static IPatchRedirector $redirector_ = null;
    public static final int RET_ERR_BUSY = 128;
    public static final int RET_ERR_MAINTAIN = 129;
    public static final int RET_FAIL = 192;
    public static final int RET_NOT_EXIST = 193;
    public static final int RET_SUC = 0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class C2CCommonExtendinfo extends MessageMicro<C2CCommonExtendinfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_info_id", "msg_filter_extendinfo"}, new Object[]{0, null}, C2CCommonExtendinfo.class);
        public final PBUInt32Field uint32_info_id = PBField.initUInt32(0);
        public FilterExtendinfo msg_filter_extendinfo = new FilterExtendinfo();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class DataHighwayHead extends MessageMicro<DataHighwayHead> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_build_ver;
        public final PBBytesField bytes_command;
        public final PBBytesField bytes_uin;
        public final PBUInt32Field env_id;
        public final PBUInt32Field locale_id;
        public final PBUInt32Field uint32_appid;
        public final PBUInt32Field uint32_command_id;
        public final PBUInt32Field uint32_dataflag;
        public final PBUInt32Field uint32_retry_times;
        public final PBUInt32Field uint32_seq;
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 80, 88}, new String[]{"uint32_version", "bytes_uin", "bytes_command", "uint32_seq", "uint32_retry_times", "uint32_appid", "uint32_dataflag", "uint32_command_id", "bytes_build_ver", "locale_id", "env_id"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, 0, 0}, DataHighwayHead.class);
        }

        public DataHighwayHead() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uin = PBField.initBytes(byteStringMicro);
            this.bytes_command = PBField.initBytes(byteStringMicro);
            this.uint32_seq = PBField.initUInt32(0);
            this.uint32_retry_times = PBField.initUInt32(0);
            this.uint32_appid = PBField.initUInt32(0);
            this.uint32_dataflag = PBField.initUInt32(0);
            this.uint32_command_id = PBField.initUInt32(0);
            this.bytes_build_ver = PBField.initBytes(byteStringMicro);
            this.locale_id = PBField.initUInt32(0);
            this.env_id = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class DataHole extends MessageMicro<DataHole> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_begin", "uint64_end"}, new Object[]{0L, 0L}, DataHole.class);
        public final PBUInt64Field uint64_begin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_end = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class FilterExtendinfo extends MessageMicro<FilterExtendinfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_filter_flag", "msg_image_filter_request"}, new Object[]{0, null}, FilterExtendinfo.class);
        public final PBUInt32Field uint32_filter_flag = PBField.initUInt32(0);
        public ImageFilterRequest msg_image_filter_request = new ImageFilterRequest();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class FilterStyle extends MessageMicro<FilterStyle> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"style_id", QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME}, new Object[]{0, ByteStringMicro.EMPTY}, FilterStyle.class);
        public final PBUInt32Field style_id = PBField.initUInt32(0);
        public final PBBytesField style_name = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ImageFilterRequest extends MessageMicro<ImageFilterRequest> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field client_ip;
        public final PBUInt32Field height;
        public final PBBytesField image_data;
        public final PBBytesField session_id;
        public FilterStyle style;
        public final PBUInt64Field uin;
        public final PBUInt32Field width;

        static {
            String[] strArr = {ServiceConst.PARA_SESSION_ID, "client_ip", "uin", "style", "width", "height", "image_data"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 58}, strArr, new Object[]{byteStringMicro, 0, 0L, null, 0, 0, byteStringMicro}, ImageFilterRequest.class);
        }

        public ImageFilterRequest() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.session_id = PBField.initBytes(byteStringMicro);
            this.client_ip = PBField.initUInt32(0);
            this.uin = PBField.initUInt64(0L);
            this.style = new FilterStyle();
            this.width = PBField.initUInt32(0);
            this.height = PBField.initUInt32(0);
            this.image_data = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ImageFilterResponse extends MessageMicro<ImageFilterResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret_code", "image_data", "cost_time"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, ImageFilterResponse.class);
        public final PBInt32Field ret_code = PBField.initInt32(0);
        public final PBBytesField image_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field cost_time = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class LoginSigHead extends MessageMicro<LoginSigHead> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_loginsig_type", "bytes_loginsig"}, new Object[]{0, ByteStringMicro.EMPTY}, LoginSigHead.class);
        public final PBUInt32Field uint32_loginsig_type = PBField.initUInt32(0);
        public final PBBytesField bytes_loginsig = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class NewServiceTicket extends MessageMicro<NewServiceTicket> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_signature;
        public final PBBytesField bytes_ukey;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_signature", "bytes_ukey"}, new Object[]{byteStringMicro, byteStringMicro}, NewServiceTicket.class);
        }

        public NewServiceTicket() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_signature = PBField.initBytes(byteStringMicro);
            this.bytes_ukey = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class PicInfoExt extends MessageMicro<PicInfoExt> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96}, new String[]{"uint32_pic_width", "uint32_pic_height", "uint32_pic_flag", "uint32_busi_type", "uint32_src_term", "uint32_plat_type", "uint32_net_type", "uint32_img_type", "uint32_app_pic_type", "bytes_echo_created_by_server", "uint64_qqmeet_guild_id", "uint64_qqmeet_channel_id"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0L, 0L}, PicInfoExt.class);
        public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pic_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
        public final PBUInt32Field uint32_plat_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_img_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_app_pic_type = PBField.initUInt32(0);
        public final PBBytesField bytes_echo_created_by_server = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_qqmeet_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_qqmeet_channel_id = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class PicRspExtInfo extends MessageMicro<PicRspExtInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"bytes_skey", "uint32_client_ip", "uint64_up_offset", "uint64_block_size"}, new Object[]{ByteStringMicro.EMPTY, 0, 0L, 0L}, PicRspExtInfo.class);
        public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
        public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0);
        public final PBUInt64Field uint64_block_size = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class QueryHoleRsp extends MessageMicro<QueryHoleRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_result", "rpt_data_hole", "bool_comp_flag"}, new Object[]{0, null, Boolean.FALSE}, QueryHoleRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBRepeatMessageField<DataHole> rpt_data_hole = PBField.initRepeatMessage(DataHole.class);
        public final PBBoolField bool_comp_flag = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ReqDataHighwayHead extends MessageMicro<ReqDataHighwayHead> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"msg_basehead", "msg_seghead", "bytes_req_extendinfo", "uint64_timestamp", "msg_login_sig_head"}, new Object[]{null, null, ByteStringMicro.EMPTY, 0L, null}, ReqDataHighwayHead.class);
        public DataHighwayHead msg_basehead = new DataHighwayHead();
        public SegHead msg_seghead = new SegHead();
        public final PBBytesField bytes_req_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
        public LoginSigHead msg_login_sig_head = new LoginSigHead();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_query_hole_rsp"}, new Object[]{null}, RspBody.class);
        public QueryHoleRsp msg_query_hole_rsp = new QueryHoleRsp();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class RspDataHighwayHead extends MessageMicro<RspDataHighwayHead> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 64, 72, 80}, new String[]{"msg_basehead", "msg_seghead", "uint32_error_code", "uint32_allow_retry", "uint32_cachecost", "uint32_htcost", "bytes_rsp_extendinfo", "uint64_timestamp", "uint64_range", "uint32_is_reset"}, new Object[]{null, null, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0L, 0L, 0}, RspDataHighwayHead.class);
        public DataHighwayHead msg_basehead = new DataHighwayHead();
        public SegHead msg_seghead = new SegHead();
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
        public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cachecost = PBField.initUInt32(0);
        public final PBUInt32Field uint32_htcost = PBField.initUInt32(0);
        public final PBBytesField bytes_rsp_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
        public final PBUInt64Field uint64_range = PBField.initUInt64(0);
        public final PBUInt32Field uint32_is_reset = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class SegHead extends MessageMicro<SegHead> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_serviceticket;
        public final PBUInt32Field uint32_cache_addr;
        public final PBUInt32Field uint32_cache_port;
        public final PBUInt32Field uint32_flag;
        public final PBUInt32Field uint32_query_times;
        public final PBUInt32Field uint32_update_cacheip;
        public final PBUInt32Field uint32_serviceid = PBField.initUInt32(0);
        public final PBUInt64Field uint64_filesize = PBField.initUInt64(0);
        public final PBUInt64Field uint64_dataoffset = PBField.initUInt64(0);
        public final PBUInt32Field uint32_datalength = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rtcode = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66, 74, 80, 88, 96, 104}, new String[]{"uint32_serviceid", "uint64_filesize", "uint64_dataoffset", "uint32_datalength", "uint32_rtcode", "bytes_serviceticket", "uint32_flag", "bytes_md5", "bytes_file_md5", "uint32_cache_addr", "uint32_query_times", "uint32_update_cacheip", "uint32_cache_port"}, new Object[]{0, 0L, 0L, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0}, SegHead.class);
        }

        public SegHead() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_serviceticket = PBField.initBytes(byteStringMicro);
            this.uint32_flag = PBField.initUInt32(0);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.uint32_cache_addr = PBField.initUInt32(0);
            this.uint32_query_times = PBField.initUInt32(0);
            this.uint32_update_cacheip = PBField.initUInt32(0);
            this.uint32_cache_port = PBField.initUInt32(0);
        }
    }

    CSDataHighwayHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
