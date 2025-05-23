package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.view.FilterEnum;
import cooperation.qqcircle.report.QFS5507ReportHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class pbenterroom {
    public static final int CMD_NEW_ACCESS = 16423;
    public static final int ERR_NICK = 1;
    public static final int ERR_NO_DATA = 2;
    public static final int OK = 0;
    public static final int RESP_ARGUMENT_ERROR = 103;
    public static final int RESP_AUTH = 1004;
    public static final int RESP_BLACK_HIT = 101;
    public static final int RESP_INNER_ERROR = 1;
    public static final int RESP_K_NOT_ADMIN = 1002;
    public static final int RESP_K_NOT_ON_STAGE = 1001;
    public static final int RESP_OK = 0;
    public static final int RESP_PARAM_ERROR = 1003;
    public static final int RESP_UNKNOWN_ERROR = 102;
    public static final int SUBCMD_ENTER_ROOM = 1;
    public static final int SUBCMD_ENTER_ROOM2 = 2;
    public static final int SUBCMD_GET_K_SIG = 5;
    public static final int SUBCMD_GET_K_SIG_VOICE = 6;
    public static final int SUBCMD_GET_SIG = 7;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class AnchorAvInfo extends MessageMicro<AnchorAvInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"av_type"}, new Object[]{0}, AnchorAvInfo.class);
        public final PBUInt32Field av_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class AuthInfo extends MessageMicro<AuthInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField appid;
        public final PBBytesField key;
        public final PBUInt32Field type = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "appid", "key"}, new Object[]{0, byteStringMicro, byteStringMicro}, AuthInfo.class);
        }

        public AuthInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.appid = PBField.initBytes(byteStringMicro);
            this.key = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CameraInfo extends MessageMicro<CameraInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "uid"}, new Object[]{0, 0L}, CameraInfo.class);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt64Field uid = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CatchDollVideoInfo extends MessageMicro<CatchDollVideoInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"camera_info"}, new Object[]{null}, CatchDollVideoInfo.class);
        public final PBRepeatMessageField<CameraInfo> camera_info = PBField.initRepeatMessage(CameraInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CdnInfo extends MessageMicro<CdnInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url_host", "url_param"}, new Object[]{"", ""}, CdnInfo.class);
        public final PBStringField url_host = PBField.initString("");
        public final PBStringField url_param = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CmdInfo extends MessageMicro<CmdInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ip", "port"}, new Object[]{0, 0}, CmdInfo.class);

        /* renamed from: ip, reason: collision with root package name */
        public final PBRepeatField<Integer> f99909ip;
        public final PBRepeatField<Integer> port;

        public CmdInfo() {
            PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
            this.f99909ip = PBField.initRepeat(pBUInt32Field);
            this.port = PBField.initRepeat(pBUInt32Field);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class EnterRoomReq extends MessageMicro<EnterRoomReq> {
        static final MessageMicro.FieldMap __fieldMap__;
        public AuthInfo auth;
        public final PBUInt64Field flag;
        public final PBUInt32Field from_id;
        public final PBUInt64Field gid;
        public final PBDoubleField latitude;
        public final PBDoubleField longitude;
        public final PBUInt32Field open_live_type;
        public final PBBytesField private_key;
        public final PBBytesField refer_source;
        public final PBUInt32Field room_type;

        /* renamed from: ts, reason: collision with root package name */
        public final PBUInt64Field f99910ts;
        public final PBUInt32Field roomId = PBField.initUInt32(0);
        public final PBStringField machineCode = PBField.initString("");
        public final PBUInt32Field enter_type = PBField.initUInt32(0);

        static {
            String[] strArr = {"roomId", "machineCode", QFS5507ReportHelper.JsonKey.ENTER_TYPE, "private_key", "ts", "flag", "refer_source", "open_live_type", "latitude", "longitude", "room_type", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, "from_id", QCircleRelationGroupRequest.GROUP_ID};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 58, 64, 73, 81, 88, 98, 104, 272}, strArr, new Object[]{0, "", 0, byteStringMicro, 0L, 0L, byteStringMicro, 0, valueOf, valueOf, 0, null, 0, 0L}, EnterRoomReq.class);
        }

        public EnterRoomReq() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.private_key = PBField.initBytes(byteStringMicro);
            this.f99910ts = PBField.initUInt64(0L);
            this.flag = PBField.initUInt64(0L);
            this.refer_source = PBField.initBytes(byteStringMicro);
            this.open_live_type = PBField.initUInt32(0);
            this.latitude = PBField.initDouble(0.0d);
            this.longitude = PBField.initDouble(0.0d);
            this.room_type = PBField.initUInt32(0);
            this.auth = new AuthInfo();
            this.from_id = PBField.initUInt32(0);
            this.gid = PBField.initUInt64(0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class EnterRoomRsp extends MessageMicro<EnterRoomRsp> {
        static final MessageMicro.FieldMap __fieldMap__;
        public AnchorAvInfo av_info;
        public final PBBytesField buff_login_key;
        public final PBBytesField buz_data;
        public final PBUInt32Field buz_time;
        public CatchDollVideoInfo catch_doll_video_info;
        public final PBStringField close_jump_url;
        public final PBUInt32Field close_media;
        public CmdInfo cmd_info;
        public final PBStringField doll_info_url;
        public final PBBoolField enable_rank_list;
        public final PBStringField endpage_jump_url;
        public final PBBytesField ext_info;
        public final PBRepeatField<String> h5_url;
        public final PBRepeatField<String> hls_url;
        public final PBUInt32Field jump_type;
        public final PBBytesField jump_url;
        public final PBBytesField media_data;
        public ProgramInfo program_info;
        public RecordInfo record_info;
        public final PBRepeatField<String> rtmp_url;
        public OpenSkdInfo sdk_info;
        public UserInfo self_info;
        public final PBBytesField sig;
        public final PBUInt32Field st_type;
        public final PBBytesField token;
        public final PBUInt32Field use_url;
        public final PBUInt32Field result = PBField.initUInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public RoomInfo room_info = new RoomInfo();
        public UserInfo anchor_info = new UserInfo();
        public VoiceInfo voice_info = new VoiceInfo();
        public VideoInfo video_info = new VideoInfo();

        static {
            int[] iArr = {8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90, 98, 106, 114, 120, 130, 138, 146, 154, 162, 170, 178, 186, 194, 200, 208, 218, 226, 232, 242, 248, FilterEnum.MIC_PTU_BAIXI};
            String[] strArr = {"result", "err_msg", AegisLogger.ROOM_INFO, "anchor_info", "voice_info", "video_info", PreloadTRTCPlayerParams.KEY_SIG, "cmd_info", "self_info", "st_type", "buff_login_key", "media_data", "record_info", "sdk_info", "jump_type", "jump_url", "rtmp_url", "hls_url", "h5_url", "ext_info", "av_info", "catch_doll_video_info", "doll_info_url", "token", "close_media", "use_url", "close_jump_url", "buz_data", "buz_time", "endpage_jump_url", "enable_rank_list", "program_info"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0, "", null, null, null, null, byteStringMicro, null, null, 0, byteStringMicro, byteStringMicro, null, null, 0, byteStringMicro, "", "", "", byteStringMicro, null, null, "", byteStringMicro, 0, 0, "", byteStringMicro, 0, "", Boolean.FALSE, null}, EnterRoomRsp.class);
        }

        public EnterRoomRsp() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.sig = PBField.initBytes(byteStringMicro);
            this.cmd_info = new CmdInfo();
            this.self_info = new UserInfo();
            this.st_type = PBField.initUInt32(0);
            this.buff_login_key = PBField.initBytes(byteStringMicro);
            this.media_data = PBField.initBytes(byteStringMicro);
            this.record_info = new RecordInfo();
            this.sdk_info = new OpenSkdInfo();
            this.jump_type = PBField.initUInt32(0);
            this.jump_url = PBField.initBytes(byteStringMicro);
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.rtmp_url = PBField.initRepeat(pBStringField);
            this.hls_url = PBField.initRepeat(pBStringField);
            this.h5_url = PBField.initRepeat(pBStringField);
            this.ext_info = PBField.initBytes(byteStringMicro);
            this.av_info = new AnchorAvInfo();
            this.catch_doll_video_info = new CatchDollVideoInfo();
            this.doll_info_url = PBField.initString("");
            this.token = PBField.initBytes(byteStringMicro);
            this.close_media = PBField.initUInt32(0);
            this.use_url = PBField.initUInt32(0);
            this.close_jump_url = PBField.initString("");
            this.buz_data = PBField.initBytes(byteStringMicro);
            this.buz_time = PBField.initUInt32(0);
            this.endpage_jump_url = PBField.initString("");
            this.enable_rank_list = PBField.initBool(false);
            this.program_info = new ProgramInfo();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Extinfo extends MessageMicro<Extinfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"net_type", "phone_type", "client_version", "resolution", "content_type"}, new Object[]{"", "", "", null, 0}, Extinfo.class);
        public final PBStringField net_type = PBField.initString("");
        public final PBStringField phone_type = PBField.initString("");
        public final PBStringField client_version = PBField.initString("");
        public Resolution resolution = new Resolution();
        public final PBUInt32Field content_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class OpenSkdInfo extends MessageMicro<OpenSkdInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"mode", PreloadTRTCPlayerParams.KEY_SIG, "time"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, OpenSkdInfo.class);
        public final PBUInt32Field mode = PBField.initUInt32(0);
        public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field time = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class ProgramInfo extends MessageMicro<ProgramInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 58}, new String[]{"title", "start_ts", "desc", "cover", "end_ts", "cancel_ts", "id"}, new Object[]{"", 0, "", "", 0, 0, ""}, ProgramInfo.class);
        public final PBStringField title = PBField.initString("");
        public final PBUInt32Field start_ts = PBField.initUInt32(0);
        public final PBStringField desc = PBField.initString("");
        public final PBRepeatField<String> cover = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field end_ts = PBField.initUInt32(0);
        public final PBUInt32Field cancel_ts = PBField.initUInt32(0);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f99911id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RecordInfo extends MessageMicro<RecordInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"record_status", "record_url"}, new Object[]{0, ByteStringMicro.EMPTY}, RecordInfo.class);
        public final PBUInt32Field record_status = PBField.initUInt32(0);
        public final PBBytesField record_url = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Resolution extends MessageMicro<Resolution> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"height", "width"}, new Object[]{0, 0}, Resolution.class);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBUInt32Field width = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RichTitleElement extends MessageMicro<RichTitleElement> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_type", "string_text", "string_url"}, new Object[]{0, "", ""}, RichTitleElement.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBStringField string_text = PBField.initString("");
        public final PBStringField string_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RoomInfo extends MessageMicro<RoomInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField announcement;
        public final PBUInt32Field gift_flag;
        public final PBUInt32Field goods_flag;
        public final PBStringField program_id;
        public final PBUInt32Field report_flag;
        public final PBStringField share_desc;
        public final PBStringField share_title;
        public final PBBytesField share_url;
        public final PBUInt32Field short_no;
        public final PBUInt32Field total_num;
        public final PBUInt32Field roomid = PBField.initUInt32(0);
        public final PBUInt32Field logo = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBUInt32Field subroomid = PBField.initUInt32(0);
        public final PBRepeatMessageField<RichTitleElement> room_labels = PBField.initRepeatMessage(RichTitleElement.class);
        public final PBUInt32Field room_type = PBField.initUInt32(0);
        public final PBUInt32Field room_status = PBField.initUInt32(0);
        public final PBStringField full_logo = PBField.initString("");

        static {
            String[] strArr = {"roomid", "logo", "name", "subroomid", "room_labels", "room_type", "room_status", "full_logo", "announcement", GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "share_title", "share_desc", "short_no", "total_num", "goods_flag", "program_id", "gift_flag", "report_flag"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 74, 82, 90, 98, 104, 112, 120, 130, 136, 144}, strArr, new Object[]{0, 0, "", 0, null, 0, 0, "", byteStringMicro, byteStringMicro, "", "", 0, 0, 0, "", 0, 0}, RoomInfo.class);
        }

        public RoomInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.announcement = PBField.initBytes(byteStringMicro);
            this.share_url = PBField.initBytes(byteStringMicro);
            this.share_title = PBField.initString("");
            this.share_desc = PBField.initString("");
            this.short_no = PBField.initUInt32(0);
            this.total_num = PBField.initUInt32(0);
            this.goods_flag = PBField.initUInt32(0);
            this.program_id = PBField.initString("");
            this.gift_flag = PBField.initUInt32(0);
            this.report_flag = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class UserInfo extends MessageMicro<UserInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 64, 72, 82, 88, 96, 104, 120}, new String[]{"userid", "sex", "name", "logo", "user_type", "explicit_uid", "noble_level", "noble_begin_ts", "noble_end_ts", "head_url", "user_role", "imsdk_tinyid", "vip_explicit_uid", AudienceReportConst.CLIENT_TYPE}, new Object[]{0L, 0, "", "", 0, 0L, 0, 0L, 0L, "", 0, 0L, 0L, 0}, UserInfo.class);
        public final PBUInt64Field userid = PBField.initUInt64(0);
        public final PBUInt32Field sex = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBStringField logo = PBField.initString("");
        public final PBUInt32Field user_type = PBField.initUInt32(0);
        public final PBUInt64Field explicit_uid = PBField.initUInt64(0);
        public final PBUInt32Field noble_level = PBField.initUInt32(0);
        public final PBUInt64Field noble_begin_ts = PBField.initUInt64(0);
        public final PBUInt64Field noble_end_ts = PBField.initUInt64(0);
        public final PBStringField head_url = PBField.initString("");
        public final PBUInt32Field user_role = PBField.initUInt32(0);
        public final PBUInt64Field imsdk_tinyid = PBField.initUInt64(0);
        public final PBUInt64Field vip_explicit_uid = PBField.initUInt64(0);
        public final PBUInt32Field client_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class VideoInfo extends MessageMicro<VideoInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBRepeatField<ByteStringMicro> bytes_video_urls;
        public final PBBytesField tptm;
        public final PBRepeatField<Integer> video_mgr_ip;
        public final PBRepeatField<Integer> video_svr_ip;
        public final PBRepeatField<Integer> video_svr_port;
        public final PBUInt32Field video_status = PBField.initUInt32(0);
        public final PBUInt32Field video_id = PBField.initUInt32(0);
        public final PBRepeatMessageField<CdnInfo> cdn_infos = PBField.initRepeatMessage(CdnInfo.class);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 56, 66}, new String[]{"video_status", "video_id", "cdn_infos", "video_svr_ip", "video_svr_port", "tptm", "video_mgr_ip", "bytes_video_urls"}, new Object[]{0, 0, null, 0, 0, byteStringMicro, 0, byteStringMicro}, VideoInfo.class);
        }

        public VideoInfo() {
            PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
            this.video_svr_ip = PBField.initRepeat(pBUInt32Field);
            this.video_svr_port = PBField.initRepeat(pBUInt32Field);
            this.tptm = PBField.initBytes(ByteStringMicro.EMPTY);
            this.video_mgr_ip = PBField.initRepeat(pBUInt32Field);
            this.bytes_video_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class VoiceInfo extends MessageMicro<VoiceInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBRepeatField<ByteStringMicro> bytes_voice_urls;

        /* renamed from: ip, reason: collision with root package name */
        public final PBRepeatField<Integer> f99912ip;
        public final PBRepeatField<Integer> port;
        public final PBBytesField voiceConnKey;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"ip", "port", "voiceConnKey", "bytes_voice_urls"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, VoiceInfo.class);
        }

        public VoiceInfo() {
            PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
            this.f99912ip = PBField.initRepeat(pBUInt32Field);
            this.port = PBField.initRepeat(pBUInt32Field);
            this.voiceConnKey = PBField.initBytes(ByteStringMicro.EMPTY);
            this.bytes_voice_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
        }
    }

    pbenterroom() {
    }
}
