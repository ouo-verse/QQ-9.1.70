package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$Result extends MessageMicro<UnifySearchDiscovery$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 162, 170, 178, 184, 194, 202, 210, 218, 226, 234}, new String[]{"type", "has_header", "title_header", "hide_top_divider", "sub_business_items", "operation_items", "hot_search_items", "hotword_update_ts", "special_topic_item", "hot_word_gif_item", "hot_search_gif_item", "result_ext", "guess_want_items", "operation_hot_search_items"}, new Object[]{0, 0, null, 0, null, null, null, 0, null, null, null, ByteStringMicro.EMPTY, null, null}, UnifySearchDiscovery$Result.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field has_header = PBField.initUInt32(0);
    public UnifySearchDiscovery$TitleHeaderItem title_header = new UnifySearchDiscovery$TitleHeaderItem();
    public final PBUInt32Field hide_top_divider = PBField.initUInt32(0);
    public final PBUInt32Field hotword_update_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchDiscovery$SubBusinessItem> sub_business_items = PBField.initRepeatMessage(UnifySearchDiscovery$SubBusinessItem.class);
    public final PBRepeatMessageField<UnifySearchDiscovery$OperationItem> operation_items = PBField.initRepeatMessage(UnifySearchDiscovery$OperationItem.class);
    public final PBRepeatMessageField<UnifySearchDiscovery$HotSearchItem> hot_search_items = PBField.initRepeatMessage(UnifySearchDiscovery$HotSearchItem.class);
    public UnifySearchDiscovery$SpecialTopic special_topic_item = new MessageMicro<UnifySearchDiscovery$SpecialTopic>() { // from class: pb.unify.search.UnifySearchDiscovery$SpecialTopic
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField icon_url;
        public final PBUInt32Field is_hotsearch;
        public final PBBytesField jump_url;
        public final PBBytesField left_icon_url;
        public final PBBytesField more_text;
        public final PBUInt32Field show_type;
        public final PBBytesField title_color;
        public final PBRepeatMessageField<UnifySearchDiscovery$TopicImage> topic_images;
        public final PBRepeatMessageField<UnifySearchDiscovery$TopicItem> topic_items;
        public final PBBytesField topic_title;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 74, 80}, new String[]{"topic_title", "title_color", "icon_url", "topic_items", "jump_url", "show_type", "left_icon_url", "more_text", "topic_images", "is_hotsearch"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, null, byteStringMicro, 0, byteStringMicro, byteStringMicro, null, 0}, UnifySearchDiscovery$SpecialTopic.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.topic_title = PBField.initBytes(byteStringMicro);
            this.title_color = PBField.initBytes(byteStringMicro);
            this.icon_url = PBField.initBytes(byteStringMicro);
            this.topic_items = PBField.initRepeatMessage(UnifySearchDiscovery$TopicItem.class);
            this.jump_url = PBField.initBytes(byteStringMicro);
            this.show_type = PBField.initUInt32(0);
            this.left_icon_url = PBField.initBytes(byteStringMicro);
            this.more_text = PBField.initBytes(byteStringMicro);
            this.topic_images = PBField.initRepeatMessage(UnifySearchDiscovery$TopicImage.class);
            this.is_hotsearch = PBField.initUInt32(0);
        }
    };
    public UnifySearchDiscovery$GifInfoItem hot_word_gif_item = new MessageMicro<UnifySearchDiscovery$GifInfoItem>() { // from class: pb.unify.search.UnifySearchDiscovery$GifInfoItem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField gif_id;
        public final PBBytesField gif_url;
        public final PBBytesField gif_url_night;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"gif_url", "gif_url_night", "gif_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, UnifySearchDiscovery$GifInfoItem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.gif_url = PBField.initBytes(byteStringMicro);
            this.gif_url_night = PBField.initBytes(byteStringMicro);
            this.gif_id = PBField.initBytes(byteStringMicro);
        }
    };
    public UnifySearchDiscovery$GifInfoItem hot_search_gif_item = new MessageMicro<UnifySearchDiscovery$GifInfoItem>() { // from class: pb.unify.search.UnifySearchDiscovery$GifInfoItem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField gif_id;
        public final PBBytesField gif_url;
        public final PBBytesField gif_url_night;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"gif_url", "gif_url_night", "gif_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, UnifySearchDiscovery$GifInfoItem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.gif_url = PBField.initBytes(byteStringMicro);
            this.gif_url_night = PBField.initBytes(byteStringMicro);
            this.gif_id = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBBytesField result_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public UnifySearchDiscovery$GuessWantSearch guess_want_items = new UnifySearchDiscovery$GuessWantSearch();
    public UnifySearchDiscovery$OperationHotSearch operation_hot_search_items = new UnifySearchDiscovery$OperationHotSearch();
}
