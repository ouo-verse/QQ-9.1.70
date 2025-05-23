package com.trunk.group_feeds;

import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class group_feeds$GroupFeedsMessage extends MessageMicro<group_feeds$GroupFeedsMessage> {
    public static final int MSG_TYPE_ACTIVITY = 23;
    public static final int MSG_TYPE_APP_NOTICES = 17;
    public static final int MSG_TYPE_CHATMSG = 9;
    public static final int MSG_TYPE_COMMENT = 1;
    public static final int MSG_TYPE_COURSE = 20;
    public static final int MSG_TYPE_FEEDS = 0;
    public static final int MSG_TYPE_GAMES = 21;
    public static final int MSG_TYPE_GROUP_ALBUM = 18;
    public static final int MSG_TYPE_MEMO = 5;
    public static final int MSG_TYPE_MSGPIC = 11;
    public static final int MSG_TYPE_MSGVIDEO = 10;
    public static final int MSG_TYPE_NEW_GUIDELINES = 19;
    public static final int MSG_TYPE_NEW_MEMO = 13;
    public static final int MSG_TYPE_NEW_OBJ_STREAM = 22;
    public static final int MSG_TYPE_PIC_VIEW = 15;
    public static final int MSG_TYPE_SHARE = 4;
    public static final int MSG_TYPE_VOTE = 12;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_album_name;
    public final PBBytesField bytes_app_name;
    public final PBBytesField bytes_app_open_param;
    public final PBBytesField bytes_batch_id;
    public final PBBytesField bytes_comment_author_nickname;
    public final PBBytesField bytes_extra_data;
    public final PBBytesField bytes_feeds_author_nickname;
    public final PBBytesField bytes_group_name;
    public final PBBytesField bytes_group_nickname;
    public final PBBytesField bytes_msg_resid;
    public final PBInt32Field int32_app_id;
    public final PBInt32Field int32_photo_num;
    public final PBInt32Field int32_vote_status;
    public MemoCtrlInfo memo_ctrl_info;
    public ThemeBrief msg_theme_brief;
    public Vote msg_vote_content;
    public final PBUInt32Field opt_uint32_ctl_flag;
    public final PBRepeatField<Long> rpt_concern_uin;
    public final PBRepeatField<Integer> rpt_my_vote_option_id_list;
    public final PBRepeatField<Long> rpt_notify_uin_list;
    public final PBRepeatMessageField<VoteRecord> rpt_vote_record;
    public final PBRepeatMessageField<VoteStatistic> rpt_vote_statistic;
    public final PBUInt32Field uint32_NC_feeds_terinal_ctrl;
    public final PBUInt32Field uint32_edu_organization_id;
    public final PBUInt32Field uint32_expire_time;
    public final PBRepeatField<Integer> uint32_reported_id;
    public final PBEnumField enum_feeds_type = PBField.initEnum(0);
    public final PBRepeatMessageField<MessageContent> rpt_feeds_content = PBField.initRepeatMessage(MessageContent.class);
    public final PBFixed32Field fixed32_win_width = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_win_height = PBField.initFixed32(0);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ContentList extends MessageMicro<ContentList> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_cont_elements"}, new Object[]{null}, ContentList.class);
        public final PBRepeatMessageField<MessageContent> rpt_cont_elements = PBField.initRepeatMessage(MessageContent.class);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class MemoCtrlInfo extends MessageMicro<MemoCtrlInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_need_confirmation"}, new Object[]{0}, MemoCtrlInfo.class);
        public final PBUInt32Field uint32_need_confirmation = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class MessageContent extends MessageMicro<MessageContent> {
        public static final int CONTENT_TYPE_CONTROL = 14;
        public static final int CONTENT_TYPE_C_VOTE = 9;
        public static final int CONTENT_TYPE_FACE = 2;
        public static final int CONTENT_TYPE_FILE = 5;
        public static final int CONTENT_TYPE_GBK_FACE = 8;
        public static final int CONTENT_TYPE_LINK = 1;
        public static final int CONTENT_TYPE_MUSIC = 4;
        public static final int CONTENT_TYPE_NC_TAG = 15;
        public static final int CONTENT_TYPE_OBJ_IN_XML = 13;
        public static final int CONTENT_TYPE_PIC = 3;
        public static final int CONTENT_TYPE_PTT = 16;
        public static final int CONTENT_TYPE_TEXT = 0;
        public static final int CONTENT_TYPE_TITLE = 10;
        public static final int CONTENT_TYPE_VIDEO = 6;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_content_value;
        public final PBBytesField bytes_file_content_sha;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_file_name;
        public final PBBytesField bytes_file_ori;
        public final PBBytesField bytes_file_triple_sha;
        public final PBBytesField bytes_file_url;
        public final PBBytesField bytes_file_uuid;
        public final PBBytesField bytes_music_name;
        public final PBBytesField bytes_music_url_for_accept;
        public final PBBytesField bytes_music_url_for_refuse;
        public final PBBytesField bytes_music_user_rank;
        public final PBBytesField bytes_object_message_brief;
        public final PBBytesField bytes_pic_id;
        public final PBBytesField bytes_pic_md5;
        public final PBBytesField bytes_pic_path;
        public final PBBytesField bytes_pic_size;
        public final PBBytesField bytes_pic_url;
        public final PBBytesField bytes_video_id;
        public final PBBytesField bytes_video_introduction;
        public final PBBytesField bytes_video_original_url;
        public final PBBytesField bytes_video_source;
        public final PBBytesField bytes_video_swf_url;
        public final PBEnumField enum_content_type = PBField.initEnum(0);
        public final PBInt32Field int32_face_idx;
        public final PBUInt32Field uint32_file_attr;
        public final PBUInt32Field uint32_group_msg_seq;
        public final PBFixed32Field uint32_music_id;
        public final PBUInt64Field uint64_file_size;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 69, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 200, 210, 216, 226, 234, 242, 248, 314, 320, MapItemKt.ITEM_AVATAR_MIN_WIDTH}, new String[]{"enum_content_type", "bytes_content_value", "bytes_pic_size", "bytes_pic_path", "bytes_pic_id", "bytes_pic_url", "bytes_music_user_rank", "uint32_music_id", "bytes_music_name", "bytes_music_url_for_accept", "bytes_music_url_for_refuse", "bytes_file_name", "bytes_file_url", "bytes_file_ori", "bytes_pic_md5", "bytes_video_swf_url", "bytes_video_original_url", "bytes_video_id", "bytes_video_introduction", "int32_face_idx", "bytes_video_source", "uint64_file_size", "bytes_file_content_sha", "bytes_file_triple_sha", "bytes_file_md5", "uint32_file_attr", "bytes_object_message_brief", "uint32_group_msg_seq", "bytes_file_uuid"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro}, MessageContent.class);
        }

        public MessageContent() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_content_value = PBField.initBytes(byteStringMicro);
            this.bytes_pic_size = PBField.initBytes(byteStringMicro);
            this.bytes_pic_path = PBField.initBytes(byteStringMicro);
            this.bytes_pic_id = PBField.initBytes(byteStringMicro);
            this.bytes_pic_url = PBField.initBytes(byteStringMicro);
            this.bytes_pic_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_music_user_rank = PBField.initBytes(byteStringMicro);
            this.uint32_music_id = PBField.initFixed32(0);
            this.bytes_music_name = PBField.initBytes(byteStringMicro);
            this.bytes_music_url_for_accept = PBField.initBytes(byteStringMicro);
            this.bytes_music_url_for_refuse = PBField.initBytes(byteStringMicro);
            this.bytes_file_name = PBField.initBytes(byteStringMicro);
            this.bytes_file_url = PBField.initBytes(byteStringMicro);
            this.bytes_file_ori = PBField.initBytes(byteStringMicro);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.bytes_file_content_sha = PBField.initBytes(byteStringMicro);
            this.bytes_file_triple_sha = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.uint32_file_attr = PBField.initUInt32(0);
            this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_video_swf_url = PBField.initBytes(byteStringMicro);
            this.bytes_video_original_url = PBField.initBytes(byteStringMicro);
            this.bytes_video_id = PBField.initBytes(byteStringMicro);
            this.bytes_video_introduction = PBField.initBytes(byteStringMicro);
            this.bytes_video_source = PBField.initBytes(byteStringMicro);
            this.int32_face_idx = PBField.initInt32(0);
            this.bytes_object_message_brief = PBField.initBytes(byteStringMicro);
            this.uint32_group_msg_seq = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ThemeBrief extends MessageMicro<ThemeBrief> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_state", "rpt_uint64_msguin", "uint32_speaker_num", "uint64_open_uin"}, new Object[]{0, 0L, 0, 0L}, ThemeBrief.class);
        public final PBUInt32Field uint32_state = PBField.initUInt32(0);
        public final PBRepeatField<Long> rpt_uint64_msguin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_speaker_num = PBField.initUInt32(0);
        public final PBUInt64Field uint64_open_uin = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Vote extends MessageMicro<Vote> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 53}, new String[]{"msg_title", "int32_max_vote_per_uin", "rpt_msg_options", "msg_vote_des", "msg_vote_res", "uint32_vote_deadline"}, new Object[]{null, 0, null, null, null, 0}, Vote.class);
        public ContentList msg_title = new ContentList();
        public final PBInt32Field int32_max_vote_per_uin = PBField.initInt32(0);
        public final PBRepeatMessageField<ContentList> rpt_msg_options = PBField.initRepeatMessage(ContentList.class);
        public ContentList msg_vote_des = new ContentList();
        public ContentList msg_vote_res = new ContentList();
        public final PBFixed32Field uint32_vote_deadline = PBField.initFixed32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class VoteRecord extends MessageMicro<VoteRecord> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 29}, new String[]{"rpt_option_id", "fixed32_vote_uin", "fixed32_vote_time"}, new Object[]{0, 0, 0}, VoteRecord.class);
        public final PBRepeatField<Integer> rpt_option_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
        public final PBFixed32Field fixed32_vote_uin = PBField.initFixed32(0);
        public final PBFixed32Field fixed32_vote_time = PBField.initFixed32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class VoteStatistic extends MessageMicro<VoteStatistic> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_option_id", "int32_vote_count"}, new Object[]{0, 0}, VoteStatistic.class);
        public final PBInt32Field int32_option_id = PBField.initInt32(0);
        public final PBInt32Field int32_vote_count = PBField.initInt32(0);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 45, 53, 58, 66, 82, 98, 104, 114, 122, 128, 154, 162, 168, 178, 184, 192, 202, 210, 216, 226, 232, 242, 248, 256, 400, 410, 416, PlayUI.UIType.BIG_CARD_SHAPED_PIC}, new String[]{"enum_feeds_type", "rpt_feeds_content", "fixed32_win_width", "fixed32_win_height", "bytes_feeds_author_nickname", "bytes_comment_author_nickname", "bytes_group_nickname", "msg_vote_content", "rpt_my_vote_option_id_list", "rpt_vote_statistic", "rpt_vote_record", "int32_vote_status", "bytes_group_name", "bytes_app_name", "rpt_notify_uin_list", "bytes_app_open_param", "int32_app_id", "uint32_reported_id", "bytes_album_name", "bytes_batch_id", "int32_photo_num", "bytes_msg_resid", "uint32_edu_organization_id", "msg_theme_brief", "uint32_NC_feeds_terinal_ctrl", "rpt_concern_uin", "opt_uint32_ctl_flag", "bytes_extra_data", "uint32_expire_time", "memo_ctrl_info"}, new Object[]{0, null, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, null, 0, null, null, 0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, null, 0, 0L, 0, byteStringMicro, 0, null}, group_feeds$GroupFeedsMessage.class);
    }

    public group_feeds$GroupFeedsMessage() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_feeds_author_nickname = PBField.initBytes(byteStringMicro);
        this.bytes_comment_author_nickname = PBField.initBytes(byteStringMicro);
        this.bytes_group_nickname = PBField.initBytes(byteStringMicro);
        this.msg_vote_content = new Vote();
        this.rpt_my_vote_option_id_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
        this.rpt_vote_statistic = PBField.initRepeatMessage(VoteStatistic.class);
        this.rpt_vote_record = PBField.initRepeatMessage(VoteRecord.class);
        this.int32_vote_status = PBField.initInt32(0);
        this.bytes_group_name = PBField.initBytes(byteStringMicro);
        this.bytes_app_name = PBField.initBytes(byteStringMicro);
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_notify_uin_list = PBField.initRepeat(pBUInt64Field);
        this.bytes_app_open_param = PBField.initBytes(byteStringMicro);
        this.int32_app_id = PBField.initInt32(0);
        this.uint32_reported_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        this.bytes_album_name = PBField.initBytes(byteStringMicro);
        this.bytes_batch_id = PBField.initBytes(byteStringMicro);
        this.int32_photo_num = PBField.initInt32(0);
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.uint32_edu_organization_id = PBField.initUInt32(0);
        this.msg_theme_brief = new ThemeBrief();
        this.uint32_NC_feeds_terinal_ctrl = PBField.initUInt32(0);
        this.rpt_concern_uin = PBField.initRepeat(pBUInt64Field);
        this.opt_uint32_ctl_flag = PBField.initUInt32(0);
        this.bytes_extra_data = PBField.initBytes(byteStringMicro);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.memo_ctrl_info = new MemoCtrlInfo();
    }
}
