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

/* compiled from: P */
/* loaded from: classes9.dex */
public final class Bdh_extinfo {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class CommFileExtReq extends MessageMicro<CommFileExtReq> {
        public static final int BYTES_UUID_FIELD_NUMBER = 2;
        public static final int UINT32_ACTION_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_action_type", "bytes_uuid"}, new Object[]{0, ByteStringMicro.EMPTY}, CommFileExtReq.class);
        public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
        public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class CommFileExtRsp extends MessageMicro<CommFileExtRsp> {
        public static final int BYTES_DOWNLOAD_URL_FIELD_NUMBER = 2;
        public static final int INT32_RETCODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_retcode", "bytes_download_url"}, new Object[]{0, ByteStringMicro.EMPTY}, CommFileExtRsp.class);
        public final PBInt32Field int32_retcode = PBField.initInt32(0);
        public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class PicInfo extends MessageMicro<PicInfo> {
        public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
        public static final int UINT32_IDX_FIELD_NUMBER = 1;
        public static final int UINT32_SIZE_FIELD_NUMBER = 2;
        public static final int UINT32_TYPE_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_type"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0}, PicInfo.class);
        public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
        public final PBUInt32Field uint32_size = PBField.initUInt32(0);
        public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class QQVoiceExtReq extends MessageMicro<QQVoiceExtReq> {
        public static final int BYTES_QID_FIELD_NUMBER = 1;
        public static final int UINT32_BITS_FIELD_NUMBER = 4;
        public static final int UINT32_CHANNEL_FIELD_NUMBER = 5;
        public static final int UINT32_FMT_FIELD_NUMBER = 2;
        public static final int UINT32_PINYIN_FIELD_NUMBER = 6;
        public static final int UINT32_RATE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"bytes_qid", "uint32_fmt", "uint32_rate", "uint32_bits", "uint32_channel", "uint32_pinyin"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, 0, 0}, QQVoiceExtReq.class);
        public final PBBytesField bytes_qid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_fmt = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rate = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bits = PBField.initUInt32(0);
        public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pinyin = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class QQVoiceExtRsp extends MessageMicro<QQVoiceExtRsp> {
        public static final int BYTES_QID_FIELD_NUMBER = 1;
        public static final int INT32_RETCODE_FIELD_NUMBER = 2;
        public static final int MSG_RESULT_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_qid", "int32_retcode", "msg_result"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, QQVoiceExtRsp.class);
        public final PBBytesField bytes_qid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field int32_retcode = PBField.initInt32(0);
        public final PBRepeatMessageField<QQVoiceResult> msg_result = PBField.initRepeatMessage(QQVoiceResult.class);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class QQVoiceResult extends MessageMicro<QQVoiceResult> {
        public static final int BYTES_PINYIN_FIELD_NUMBER = 2;
        public static final int BYTES_TEXT_FIELD_NUMBER = 1;
        public static final int UINT32_SOURCE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_pinyin;
        public final PBBytesField bytes_text;
        public final PBUInt32Field uint32_source;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_text", "bytes_pinyin", "uint32_source"}, new Object[]{byteStringMicro, byteStringMicro, 0}, QQVoiceResult.class);
        }

        public QQVoiceResult() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_text = PBField.initBytes(byteStringMicro);
            this.bytes_pinyin = PBField.initBytes(byteStringMicro);
            this.uint32_source = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ShortVideoReqExtInfo extends MessageMicro<ShortVideoReqExtInfo> {
        public static final int BOOL_IS_MERGE_CMD_BEFORE_DATA_FIELD_NUMBER = 6;
        public static final int MSG_SHORTVIDEO_SURE_REQ_FIELD_NUMBER = 5;
        public static final int MSG_THUMBINFO_FIELD_NUMBER = 3;
        public static final int MSG_VIDEOINFO_FIELD_NUMBER = 4;
        public static final int UINT32_CMD_FIELD_NUMBER = 1;
        public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"uint32_cmd", "uint64_session_id", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_req", "bool_is_merge_cmd_before_data"}, new Object[]{0, 0L, null, null, null, Boolean.FALSE}, ShortVideoReqExtInfo.class);
        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_id = PBField.initUInt64(0);
        public PicInfo msg_thumbinfo = new PicInfo();
        public VideoInfo msg_videoinfo = new VideoInfo();
        public ShortVideoSureReqInfo msg_shortvideo_sure_req = new ShortVideoSureReqInfo();
        public final PBBoolField bool_is_merge_cmd_before_data = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ShortVideoRspExtInfo extends MessageMicro<ShortVideoRspExtInfo> {
        public static final int BYTES_ERRINFO_FIELD_NUMBER = 4;
        public static final int INT32_RETCODE_FIELD_NUMBER = 3;
        public static final int MSG_SHORTVIDEO_SURE_RSP_FIELD_NUMBER = 7;
        public static final int MSG_THUMBINFO_FIELD_NUMBER = 5;
        public static final int MSG_VIDEOINFO_FIELD_NUMBER = 6;
        public static final int UINT32_CMD_FIELD_NUMBER = 1;
        public static final int UINT32_RETRY_FLAG_FIELD_NUMBER = 8;
        public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64}, new String[]{"uint32_cmd", "uint64_session_id", "int32_retcode", "bytes_errinfo", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_rsp", "uint32_retry_flag"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY, null, null, null, 0}, ShortVideoRspExtInfo.class);
        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_id = PBField.initUInt64(0);
        public final PBInt32Field int32_retcode = PBField.initInt32(0);
        public final PBBytesField bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
        public PicInfo msg_thumbinfo = new PicInfo();
        public VideoInfo msg_videoinfo = new VideoInfo();
        public ShortVideoSureRspInfo msg_shortvideo_sure_rsp = new ShortVideoSureRspInfo();
        public final PBUInt32Field uint32_retry_flag = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ShortVideoSureReqInfo extends MessageMicro<ShortVideoSureReqInfo> {
        public static final int MSG_THUMBINFO_FIELD_NUMBER = 6;
        public static final int RPT_MSG_DROP_VIDEOINFO_FIELD_NUMBER = 8;
        public static final int RPT_MSG_MERGE_VIDEOINFO_FIELD_NUMBER = 7;
        public static final int UINT32_BUSINESS_TYPE_FIELD_NUMBER = 9;
        public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 2;
        public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 5;
        public static final int UINT32_SUB_BUSINESS_TYPE_FIELD_NUMBER = 10;
        public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
        public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 4;
        public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 72, 80}, new String[]{"uint64_fromuin", "uint32_chat_type", "uint64_touin", "uint64_group_code", "uint32_client_type", "msg_thumbinfo", "rpt_msg_merge_videoinfo", "rpt_msg_drop_videoinfo", "uint32_business_type", "uint32_sub_business_type"}, new Object[]{0L, 0, 0L, 0L, 0, null, null, null, 0, 0}, ShortVideoSureReqInfo.class);
        public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
        public PicInfo msg_thumbinfo = new PicInfo();
        public final PBRepeatMessageField<VideoInfo> rpt_msg_merge_videoinfo = PBField.initRepeatMessage(VideoInfo.class);
        public final PBRepeatMessageField<VideoInfo> rpt_msg_drop_videoinfo = PBField.initRepeatMessage(VideoInfo.class);
        public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sub_business_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ShortVideoSureRspInfo extends MessageMicro<ShortVideoSureRspInfo> {
        public static final int BYTES_FILEID_FIELD_NUMBER = 1;
        public static final int BYTES_UKEY_FIELD_NUMBER = 2;
        public static final int MSG_VIDEOINFO_FIELD_NUMBER = 3;
        public static final int UINT32_MERGE_COST_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_fileid;
        public final PBBytesField bytes_ukey;
        public VideoInfo msg_videoinfo;
        public final PBUInt32Field uint32_merge_cost;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"bytes_fileid", "bytes_ukey", "msg_videoinfo", "uint32_merge_cost"}, new Object[]{byteStringMicro, byteStringMicro, null, 0}, ShortVideoSureRspInfo.class);
        }

        public ShortVideoSureRspInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_fileid = PBField.initBytes(byteStringMicro);
            this.bytes_ukey = PBField.initBytes(byteStringMicro);
            this.msg_videoinfo = new VideoInfo();
            this.uint32_merge_cost = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class StoryVideoExtReq extends MessageMicro<StoryVideoExtReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], StoryVideoExtReq.class);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class StoryVideoExtRsp extends MessageMicro<StoryVideoExtRsp> {
        public static final int BYTES_CDN_URL_FIELD_NUMBER = 3;
        public static final int BYTES_FILE_ID_FIELD_NUMBER = 5;
        public static final int BYTES_FILE_KEY_FIELD_NUMBER = 4;
        public static final int BYTES_MSG_FIELD_NUMBER = 2;
        public static final int INT32_RETCODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cdn_url;
        public final PBBytesField bytes_file_id;
        public final PBBytesField bytes_file_key;
        public final PBBytesField bytes_msg;
        public final PBInt32Field int32_retcode = PBField.initInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_retcode", "bytes_msg", "bytes_cdn_url", "bytes_file_key", "bytes_file_id"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, StoryVideoExtRsp.class);
        }

        public StoryVideoExtRsp() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_msg = PBField.initBytes(byteStringMicro);
            this.bytes_cdn_url = PBField.initBytes(byteStringMicro);
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.bytes_file_id = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class UploadPicExtInfo extends MessageMicro<UploadPicExtInfo> {
        public static final int BYTES_DOWNLOAD_URL_FIELD_NUMBER = 2;
        public static final int BYTES_FILE_RESID_FIELD_NUMBER = 1;
        public static final int BYTES_THUMB_DOWNLOAD_URL_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_download_url;
        public final PBBytesField bytes_file_resid;
        public final PBBytesField bytes_thumb_download_url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_file_resid", "bytes_download_url", "bytes_thumb_download_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, UploadPicExtInfo.class);
        }

        public UploadPicExtInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_resid = PBField.initBytes(byteStringMicro);
            this.bytes_download_url = PBField.initBytes(byteStringMicro);
            this.bytes_thumb_download_url = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class VideoInfo extends MessageMicro<VideoInfo> {
        public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
        public static final int UINT32_FORMAT_FIELD_NUMBER = 4;
        public static final int UINT32_IDX_FIELD_NUMBER = 1;
        public static final int UINT32_IS_AUDIO_FIELD_NUMBER = 9;
        public static final int UINT32_RES_LEN_FIELD_NUMBER = 5;
        public static final int UINT32_RES_WIDTH_FIELD_NUMBER = 6;
        public static final int UINT32_SIZE_FIELD_NUMBER = 2;
        public static final int UINT32_TIME_FIELD_NUMBER = 7;
        public static final int UINT64_STARTTIME_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 64, 72}, new String[]{"uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_format", "uint32_res_len", "uint32_res_width", "uint32_time", "uint64_starttime", "uint32_is_audio"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0L, 0}, VideoInfo.class);
        public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
        public final PBUInt32Field uint32_size = PBField.initUInt32(0);
        public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_format = PBField.initUInt32(0);
        public final PBUInt32Field uint32_res_len = PBField.initUInt32(0);
        public final PBUInt32Field uint32_res_width = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_starttime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_is_audio = PBField.initUInt32(0);
    }

    Bdh_extinfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
