package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RecommendItem extends MessageMicro<NowQQLiveHomepageProto$RecommendItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 72, 80}, new String[]{"uint32_type", "msg_anchor", "msg_tag", "msg_hot_topic", "msg_banner", "msg_topicorvideo", "string_key", "need_row_insert", "row_insert_position"}, new Object[]{0, null, null, null, null, null, "", Boolean.FALSE, 0}, NowQQLiveHomepageProto$RecommendItem.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public NowQQLiveHomepageProto$RcmdAnchor msg_anchor = new NowQQLiveHomepageProto$RcmdAnchor();
    public NowQQLiveHomepageProto$RcmdTag msg_tag = new MessageMicro<NowQQLiveHomepageProto$RcmdTag>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RcmdTag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"string_tag"}, new Object[]{""}, NowQQLiveHomepageProto$RcmdTag.class);
        public final PBStringField string_tag = PBField.initString("");
    };
    public NowQQLiveHomepageProto$RcmdHotTopic msg_hot_topic = new MessageMicro<NowQQLiveHomepageProto$RcmdHotTopic>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RcmdHotTopic
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"offical_topic", "hot_topics", "string_url_more"}, new Object[]{null, null, ""}, NowQQLiveHomepageProto$RcmdHotTopic.class);
        public NowQQLiveHomepageProto$TopicItem offical_topic = new MessageMicro<NowQQLiveHomepageProto$TopicItem>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$TopicItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"string_topic", "uint32_member_count", "string_bg_url", "string_url"}, new Object[]{"", 0, "", ""}, NowQQLiveHomepageProto$TopicItem.class);
            public final PBStringField string_topic = PBField.initString("");
            public final PBUInt32Field uint32_member_count = PBField.initUInt32(0);
            public final PBStringField string_bg_url = PBField.initString("");
            public final PBStringField string_url = PBField.initString("");
        };
        public final PBRepeatMessageField<NowQQLiveHomepageProto$TopicItem> hot_topics = PBField.initRepeatMessage(NowQQLiveHomepageProto$TopicItem.class);
        public final PBStringField string_url_more = PBField.initString("");
    };
    public NowQQLiveHomepageProto$Banner msg_banner = new MessageMicro<NowQQLiveHomepageProto$Banner>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$Banner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_banner_item"}, new Object[]{null}, NowQQLiveHomepageProto$Banner.class);
        public final PBRepeatMessageField<NowQQLiveHomepageProto$BannerItem> rpt_banner_item = PBField.initRepeatMessage(NowQQLiveHomepageProto$BannerItem.class);
    };
    public NowQQLiveHomepageProto$RcmdTopicOrVideoList msg_topicorvideo = new MessageMicro<NowQQLiveHomepageProto$RcmdTopicOrVideoList>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RcmdTopicOrVideoList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"topic_list", "more_url"}, new Object[]{null, ""}, NowQQLiveHomepageProto$RcmdTopicOrVideoList.class);
        public final PBRepeatMessageField<NowQQLiveHomepageProto$RcmdTopicOrVideo> topic_list = PBField.initRepeatMessage(NowQQLiveHomepageProto$RcmdTopicOrVideo.class);
        public final PBStringField more_url = PBField.initString("");
    };
    public final PBStringField string_key = PBField.initString("");
    public final PBBoolField need_row_insert = PBField.initBool(false);
    public final PBUInt32Field row_insert_position = PBField.initUInt32(0);
}
