package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.oskplayer.util.SecretUtils;

/* loaded from: classes5.dex */
public final class SerializationPB$ShareGroupRecommendFeed extends MessageMicro<SerializationPB$ShareGroupRecommendFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField join_feed_id;
    public final PBUInt64Field recommend_id;
    public final PBBytesField title_wording;
    public SerializationPB$ShareGroupFeed share_group_feed = new MessageMicro<SerializationPB$ShareGroupFeed>() { // from class: com.tencent.biz.qqstory.base.SerializationPB$ShareGroupFeed
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48}, new String[]{"video_list_feed", "member_count", "video_count", SecretUtils.DES, "group_id", "today_join_member_count"}, new Object[]{null, 0, 0, "", "", 0}, SerializationPB$ShareGroupFeed.class);
        public SerializationPB$VideoListFeed video_list_feed = new SerializationPB$VideoListFeed();
        public final PBUInt32Field member_count = PBField.initUInt32(0);
        public final PBUInt32Field video_count = PBField.initUInt32(0);
        public final PBStringField des = PBField.initString("");
        public final PBStringField group_id = PBField.initString("");
        public final PBUInt32Field today_join_member_count = PBField.initUInt32(0);
    };
    public final PBStringField blurb = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"share_group_feed", "blurb", "join_feed_id", "recommend_id", "title_wording"}, new Object[]{null, "", byteStringMicro, 0L, byteStringMicro}, SerializationPB$ShareGroupRecommendFeed.class);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.biz.qqstory.base.SerializationPB$ShareGroupFeed] */
    public SerializationPB$ShareGroupRecommendFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.join_feed_id = PBField.initBytes(byteStringMicro);
        this.recommend_id = PBField.initUInt64(0L);
        this.title_wording = PBField.initBytes(byteStringMicro);
    }
}
