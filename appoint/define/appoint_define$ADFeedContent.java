package appoint.define;

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
public final class appoint_define$ADFeedContent extends MessageMicro<appoint_define$ADFeedContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 74}, new String[]{"msg_user_info", "rpt_str_pic_url", "msg_text", "str_attend_info", "str_action_url", "uint32_publish_time", "msg_hot_topic_list", "str_more_url", "str_record_duration"}, new Object[]{null, "", null, "", "", 0, null, "", ""}, appoint_define$ADFeedContent.class);
    public appoint_define$UserInfo msg_user_info = new MessageMicro<appoint_define$UserInfo>() { // from class: appoint.define.appoint_define$UserInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_avatar;
        public final PBBytesField bytes_nickname;
        public final PBUInt32Field uint32_age;
        public final PBUInt32Field uint32_gender;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"uint64_uin", "bytes_nickname", "uint32_age", "uint32_gender", "bytes_avatar"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro}, appoint_define$UserInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nickname = PBField.initBytes(byteStringMicro);
            this.uint32_age = PBField.initUInt32(0);
            this.uint32_gender = PBField.initUInt32(0);
            this.bytes_avatar = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBRepeatField<String> rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public appoint_define$RichText msg_text = new appoint_define$RichText();
    public final PBStringField str_attend_info = PBField.initString("");
    public final PBStringField str_action_url = PBField.initString("");
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
    public appoint_define$HotTopicList msg_hot_topic_list = new MessageMicro<appoint_define$HotTopicList>() { // from class: appoint.define.appoint_define$HotTopicList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_topic_list"}, new Object[]{null}, appoint_define$HotTopicList.class);
        public final PBRepeatMessageField<appoint_define$HotTopic> rpt_topic_list = PBField.initRepeatMessage(appoint_define$HotTopic.class);
    };
    public final PBStringField str_more_url = PBField.initString("");
    public final PBStringField str_record_duration = PBField.initString("");
}
