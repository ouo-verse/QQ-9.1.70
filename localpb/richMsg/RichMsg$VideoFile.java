package localpb.richMsg;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RichMsg$VideoFile extends MessageMicro<RichMsg$VideoFile> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_mediacodec_encode;
    public final PBBoolField bool_story_video_send_to_recent;
    public final PBBoolField bool_support_progressive;
    public final PBBytesField bytes_camera_video_templateid;
    public final PBBytesField bytes_camera_video_templatename;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_file_uuid;
    public final PBBytesField bytes_hotvideo_icon;
    public final PBBytesField bytes_hotvideo_icon_sub;
    public final PBBytesField bytes_hotvideo_title;
    public final PBBytesField bytes_hotvideo_url;
    public final PBBytesField bytes_local_file_md5;
    public final PBBytesField bytes_shortVideoId;
    public final PBBytesField bytes_source;
    public final PBBytesField bytes_thumb_file_md5;
    public final PBBytesField bytes_video_file_source_dir;
    public final PBUInt64Field file_lastmodified;
    public final PBUInt32Field red_envelope_pay_stat;
    public final PBUInt32Field uin32_from_chat_type;
    public final PBUInt32Field uin32_to_chat_type;
    public final PBUInt32Field uin32_uiOperatorFlag;
    public final PBUInt32Field uint32_busi_type;
    public final PBUInt32Field uint32_embed_video;
    public final PBUInt32Field uint32_file_format;
    public final PBUInt32Field uint32_file_height;
    public final PBUInt32Field uint32_file_progress;
    public final PBUInt32Field uint32_file_size;
    public final PBUInt32Field uint32_file_status;
    public final PBUInt32Field uint32_file_time;
    public final PBUInt32Field uint32_file_type;
    public final PBUInt32Field uint32_file_width;
    public final PBUInt32Field uint32_is_local_video;
    public final PBUInt32Field uint32_long_video_kandian_type;
    public final PBUInt32Field uint32_msg_tail_type;
    public final PBUInt32Field uint32_red_envelope_type;
    public final PBUInt32Field uint32_source_codec_format;
    public final PBUInt32Field uint32_special_video_type;
    public final PBUInt32Field uint32_sub_busi_type;
    public final PBUInt32Field uint32_thumb_file_size;
    public final PBUInt32Field uint32_thumb_height;
    public final PBUInt32Field uint32_thumb_width;
    public final PBUInt32Field uint32_transfered_size;
    public final PBUInt32Field uint32_video_attr;
    public final PBUInt32Field uint32_video_binary_set;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112, 120, 128, 136, 144, 152, 162, 168, 176, 184, 194, 200, 208, 216, 224, 232, 240, 250, 258, 266, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288, 296, 306, 312, 320, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 338, 346, g.CTRL_INDEX, 360}, new String[]{"bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_status", "uint32_file_progress", "uint32_file_type", "bytes_thumb_file_md5", "bytes_source", "file_lastmodified", "uint32_thumb_file_size", "uint32_busi_type", "uin32_from_chat_type", "uin32_to_chat_type", "uin32_uiOperatorFlag", "bytes_video_file_source_dir", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "bytes_local_file_md5", "uint32_is_local_video", "uint32_transfered_size", "uint32_sub_busi_type", "uint32_video_attr", "uint32_video_binary_set", "bool_is_mediacodec_encode", "bytes_hotvideo_icon", "bytes_hotvideo_title", "bytes_hotvideo_url", "bytes_hotvideo_icon_sub", "uint32_special_video_type", "uint32_msg_tail_type", "uint32_red_envelope_type", "bytes_shortVideoId", "red_envelope_pay_stat", "uint32_long_video_kandian_type", "bool_story_video_send_to_recent", "bytes_camera_video_templateid", "bytes_camera_video_templatename", "uint32_embed_video", "uint32_source_codec_format"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0L, 0, 0, 0, 0, 0, byteStringMicro, bool, 0, 0, byteStringMicro, 0, 0, 0, 0, 0, bool, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, bool, byteStringMicro, byteStringMicro, 0, 0}, RichMsg$VideoFile.class);
    }

    public RichMsg$VideoFile() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.uint32_file_format = PBField.initUInt32(0);
        this.uint32_file_time = PBField.initUInt32(0);
        this.uint32_file_size = PBField.initUInt32(0);
        this.uint32_thumb_width = PBField.initUInt32(0);
        this.uint32_thumb_height = PBField.initUInt32(0);
        this.uint32_file_status = PBField.initUInt32(0);
        this.uint32_file_progress = PBField.initUInt32(0);
        this.uint32_file_type = PBField.initUInt32(0);
        this.bytes_thumb_file_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_source = PBField.initBytes(byteStringMicro);
        this.file_lastmodified = PBField.initUInt64(0L);
        this.uint32_thumb_file_size = PBField.initUInt32(0);
        this.uint32_busi_type = PBField.initUInt32(0);
        this.uin32_from_chat_type = PBField.initUInt32(0);
        this.uin32_to_chat_type = PBField.initUInt32(0);
        this.uin32_uiOperatorFlag = PBField.initUInt32(0);
        this.bytes_video_file_source_dir = PBField.initBytes(byteStringMicro);
        this.bool_support_progressive = PBField.initBool(false);
        this.uint32_file_width = PBField.initUInt32(0);
        this.uint32_file_height = PBField.initUInt32(0);
        this.bytes_local_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_is_local_video = PBField.initUInt32(0);
        this.uint32_transfered_size = PBField.initUInt32(0);
        this.uint32_sub_busi_type = PBField.initUInt32(0);
        this.uint32_video_attr = PBField.initUInt32(0);
        this.uint32_video_binary_set = PBField.initUInt32(0);
        this.bool_is_mediacodec_encode = PBField.initBool(false);
        this.bytes_hotvideo_icon = PBField.initBytes(byteStringMicro);
        this.bytes_hotvideo_title = PBField.initBytes(byteStringMicro);
        this.bytes_hotvideo_url = PBField.initBytes(byteStringMicro);
        this.bytes_hotvideo_icon_sub = PBField.initBytes(byteStringMicro);
        this.uint32_special_video_type = PBField.initUInt32(0);
        this.uint32_msg_tail_type = PBField.initUInt32(0);
        this.uint32_red_envelope_type = PBField.initUInt32(0);
        this.bytes_shortVideoId = PBField.initBytes(byteStringMicro);
        this.red_envelope_pay_stat = PBField.initUInt32(0);
        this.uint32_long_video_kandian_type = PBField.initUInt32(0);
        this.bool_story_video_send_to_recent = PBField.initBool(false);
        this.bytes_camera_video_templateid = PBField.initBytes(byteStringMicro);
        this.bytes_camera_video_templatename = PBField.initBytes(byteStringMicro);
        this.uint32_embed_video = PBField.initUInt32(0);
        this.uint32_source_codec_format = PBField.initUInt32(0);
    }
}
