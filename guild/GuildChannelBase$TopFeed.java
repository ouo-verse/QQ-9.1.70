package guild;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.tav.core.AssetExtension;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$TopFeed extends MessageMicro<GuildChannelBase$TopFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 58, 66, 72, 80, 90, 98}, new String[]{"feed_id", "user_id", AlbumCacheData.CREATE_TIME, "feed_abstract", "top_timestamp", "operator_tinyid", "channel_sign", "label", "read_time", "need_notify", "feed", "feed_detail_title"}, new Object[]{"", "", 0L, null, 0L, 0L, null, null, 0L, Boolean.FALSE, ByteStringMicro.EMPTY, ""}, GuildChannelBase$TopFeed.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField user_id = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public GuildChannelBase$TopFeedAbstract feed_abstract = new MessageMicro<GuildChannelBase$TopFeedAbstract>() { // from class: guild.GuildChannelBase$TopFeedAbstract
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", AssetExtension.SCENE_THUMBNAIL}, new Object[]{"", null}, GuildChannelBase$TopFeedAbstract.class);
        public final PBStringField title = PBField.initString("");
        public GuildChannelBase$Thumbnail thumbnail = new MessageMicro<GuildChannelBase$Thumbnail>() { // from class: guild.GuildChannelBase$Thumbnail
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", "type"}, new Object[]{"", 0}, GuildChannelBase$Thumbnail.class);
            public final PBStringField url = PBField.initString("");
            public final PBEnumField type = PBField.initEnum(0);
        };
    };
    public final PBInt64Field top_timestamp = PBField.initInt64(0);
    public final PBUInt64Field operator_tinyid = PBField.initUInt64(0);
    public GuildChannelBase$StChannelSign channel_sign = new GuildChannelBase$StChannelSign();
    public GuildChannelBase$TopFeedLabel label = new MessageMicro<GuildChannelBase$TopFeedLabel>() { // from class: guild.GuildChannelBase$TopFeedLabel
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "text", "color"}, new Object[]{0, "", 0}, GuildChannelBase$TopFeedLabel.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt32Field f403413id = PBField.initUInt32(0);
        public final PBStringField text = PBField.initString("");
        public final PBUInt32Field color = PBField.initUInt32(0);
    };
    public final PBInt64Field read_time = PBField.initInt64(0);
    public final PBBoolField need_notify = PBField.initBool(false);
    public final PBBytesField feed = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField feed_detail_title = PBField.initString("");
}
