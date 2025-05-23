package appoint.define;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$FeedInfo extends MessageMicro<appoint_define$FeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 66, 72, 82, 88, 96, 104, 114}, new String[]{"uint64_feed_type", "str_feed_id", "msg_feed_content", "msg_topic_info", "uint32_publish_time", "uint32_praise_count", "uint32_praise_flag", "rpt_msg_praise_user", "uint32_comment_count", "rpt_msg_comment_list", "uint32_comment_ret_all", "uint32_hot_flag", "uint64_svr_reserved", "msg_hot_entry"}, new Object[]{0L, "", null, null, 0L, 0, 0, null, 0, null, 0, 0, 0L, null}, appoint_define$FeedInfo.class);
    public final PBUInt64Field uint64_feed_type = PBField.initUInt64(0);
    public final PBStringField str_feed_id = PBField.initString("");
    public appoint_define$FeedContent msg_feed_content = new MessageMicro<appoint_define$FeedContent>() { // from class: appoint.define.appoint_define$FeedContent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42, 50, 56, 66, 74, 160, 168, 178, 184, 194, 202}, new String[]{"rpt_str_pic_url", "msg_text", "str_href_url", "str_group_name", "str_group_bulletin", "uint32_feed_type", "str_poi_id", "str_poi_title", "uint32_effective_time", "uint32_expiation_time", "msg_locale", "uint32_feeds_index", "msg_ad", "bytes_private_data"}, new Object[]{"", null, "", "", "", 0, "", "", 0, 0, null, 0, null, ByteStringMicro.EMPTY}, appoint_define$FeedContent.class);
        public final PBRepeatField<String> rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
        public appoint_define$RichText msg_text = new appoint_define$RichText();
        public final PBStringField str_href_url = PBField.initString("");
        public final PBStringField str_group_name = PBField.initString("");
        public final PBStringField str_group_bulletin = PBField.initString("");
        public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
        public final PBStringField str_poi_id = PBField.initString("");
        public final PBStringField str_poi_title = PBField.initString("");
        public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
        public appoint_define$LocaleInfo msg_locale = new appoint_define$LocaleInfo();
        public final PBUInt32Field uint32_feeds_index = PBField.initUInt32(0);
        public appoint_define$ADFeed msg_ad = new MessageMicro<appoint_define$ADFeed>() { // from class: appoint.define.appoint_define$ADFeed
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_task_id", "uint32_style", MessageForUniteGrayTip.KEY_BYTES_CONTENT}, new Object[]{0, 0, ByteStringMicro.EMPTY}, appoint_define$ADFeed.class);
            public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_style = PBField.initUInt32(0);
            public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        public final PBBytesField bytes_private_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public appoint_define$NearbyTopic msg_topic_info = new MessageMicro<appoint_define$NearbyTopic>() { // from class: appoint.define.appoint_define$NearbyTopic
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 146}, new String[]{"uint64_topic_id", "str_topic", "str_foreword", "uint32_create_time", "uint32_update_time", "uint32_hot_flag", "uint32_button_style", "str_button_src", "str_background_src", "str_attendee_info", "uint32_index", "uint32_publish_scope", "uint32_effective_time", "uint32_expiation_time", "uint32_pushed_usr_count", "uint32_timerange_left", "uint32_timerange_right", "str_area"}, new Object[]{0L, "", "", 0, 0, 0, 0, "", "", "", 0, 0, 0, 0, 0, 0, 0, ""}, appoint_define$NearbyTopic.class);
        public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);
        public final PBStringField str_topic = PBField.initString("");
        public final PBStringField str_foreword = PBField.initString("");
        public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_button_style = PBField.initUInt32(0);
        public final PBStringField str_button_src = PBField.initString("");
        public final PBStringField str_background_src = PBField.initString("");
        public final PBStringField str_attendee_info = PBField.initString("");
        public final PBUInt32Field uint32_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_publish_scope = PBField.initUInt32(0);
        public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pushed_usr_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_timerange_left = PBField.initUInt32(0);
        public final PBUInt32Field uint32_timerange_right = PBField.initUInt32(0);
        public final PBStringField str_area = PBField.initString("");
    };
    public final PBUInt64Field uint32_publish_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$StrangerInfo> rpt_msg_praise_user = PBField.initRepeatMessage(appoint_define$StrangerInfo.class);
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$FeedComment> rpt_msg_comment_list = PBField.initRepeatMessage(appoint_define$FeedComment.class);
    public final PBUInt32Field uint32_comment_ret_all = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_svr_reserved = PBField.initUInt64(0);
    public appoint_define$HotEntry msg_hot_entry = new MessageMicro<appoint_define$HotEntry>() { // from class: appoint.define.appoint_define$HotEntry
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_open_flag", "uint32_rest_time", "str_foreword", "str_background_src"}, new Object[]{0, 0, "", ""}, appoint_define$HotEntry.class);
        public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rest_time = PBField.initUInt32(0);
        public final PBStringField str_foreword = PBField.initString("");
        public final PBStringField str_background_src = PBField.initString("");
    };
}
