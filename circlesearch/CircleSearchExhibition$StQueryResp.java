package circlesearch;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StQueryResp extends MessageMicro<CircleSearchExhibition$StQueryResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 90}, new String[]{"feeds", "users", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, LinkReportConstant$GlobalKey.EVENTS, "sub_tags", "games", "game_desc", "game_collection", "grey", "ext_info", "correction_info"}, new Object[]{null, null, null, null, null, null, null, null, Boolean.FALSE, null, null}, CircleSearchExhibition$StQueryResp.class);
    public CircleSearchExhibition$StFeedResp feeds = new MessageMicro<CircleSearchExhibition$StFeedResp>() { // from class: circlesearch.CircleSearchExhibition$StFeedResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feeds", "attach_info", "end"}, new Object[]{null, "", 0}, CircleSearchExhibition$StFeedResp.class);
        public final PBRepeatMessageField<CircleSearchExhibition$stFeedItem> feeds = PBField.initRepeatMessage(CircleSearchExhibition$stFeedItem.class);
        public final PBStringField attach_info = PBField.initString("");
        public final PBInt32Field end = PBField.initInt32(0);
    };
    public CircleSearchExhibition$StUserResp users = new MessageMicro<CircleSearchExhibition$StUserResp>() { // from class: circlesearch.CircleSearchExhibition$StUserResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"uid", "attach_info", "end", "users", "correction_info"}, new Object[]{"", "", 0, null, null}, CircleSearchExhibition$StUserResp.class);
        public final PBRepeatField<String> uid = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField attach_info = PBField.initString("");
        public final PBInt32Field end = PBField.initInt32(0);
        public final PBRepeatMessageField<CircleSearchExhibition$StQueryUser> users = PBField.initRepeatMessage(CircleSearchExhibition$StQueryUser.class);
        public CircleSearchExhibition$CorrectionInfo correction_info = new CircleSearchExhibition$CorrectionInfo();
    };
    public CircleSearchExhibition$StTagResp tags = new MessageMicro<CircleSearchExhibition$StTagResp>() { // from class: circlesearch.CircleSearchExhibition$StTagResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"tag_name", "attach_info", "end", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "correction_info"}, new Object[]{"", "", 0, null, null}, CircleSearchExhibition$StTagResp.class);
        public final PBRepeatField<String> tag_name = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField attach_info = PBField.initString("");
        public final PBInt32Field end = PBField.initInt32(0);
        public final PBRepeatMessageField<CircleSearchExhibition$stTagItem> tags = PBField.initRepeatMessage(CircleSearchExhibition$stTagItem.class);
        public CircleSearchExhibition$CorrectionInfo correction_info = new CircleSearchExhibition$CorrectionInfo();
    };
    public CircleSearchExhibition$StHotEventResp events = new MessageMicro<CircleSearchExhibition$StHotEventResp>() { // from class: circlesearch.CircleSearchExhibition$StHotEventResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "attach_info", "end"}, new Object[]{null, "", 0}, CircleSearchExhibition$StHotEventResp.class);
        public CircleSearchExhibition$HotEventItem item = new MessageMicro<CircleSearchExhibition$HotEventItem>() { // from class: circlesearch.CircleSearchExhibition$HotEventItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 66, 74}, new String[]{"type", "search_type", "more_text", "more_url", "feeds", "rank", "title", "live_feeds", "feedItems"}, new Object[]{0, 0, "", "", null, 0, "", null, null}, CircleSearchExhibition$HotEventItem.class);
            public final PBInt32Field type = PBField.initInt32(0);
            public final PBInt32Field search_type = PBField.initInt32(0);
            public final PBStringField more_text = PBField.initString("");
            public final PBStringField more_url = PBField.initString("");
            public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
            public final PBInt32Field rank = PBField.initInt32(0);
            public final PBStringField title = PBField.initString("");
            public final PBRepeatMessageField<FeedCloudMeta$StFeed> live_feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
            public final PBRepeatMessageField<CircleSearchExhibition$stFeedItem> feedItems = PBField.initRepeatMessage(CircleSearchExhibition$stFeedItem.class);
        };
        public final PBStringField attach_info = PBField.initString("");
        public final PBInt32Field end = PBField.initInt32(0);
    };
    public CircleSearchExhibition$StSubTagResp sub_tags = new MessageMicro<CircleSearchExhibition$StSubTagResp>() { // from class: circlesearch.CircleSearchExhibition$StSubTagResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sub_tags"}, new Object[]{""}, CircleSearchExhibition$StSubTagResp.class);
        public final PBRepeatField<String> sub_tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public CircleSearchExhibition$StGameResp games = new MessageMicro<CircleSearchExhibition$StGameResp>() { // from class: circlesearch.CircleSearchExhibition$StGameResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"game", "mini_app", "goods"}, new Object[]{null, null, null}, CircleSearchExhibition$StGameResp.class);
        public CircleSearchExhibition$StSearchGame game = new CircleSearchExhibition$StSearchGame();
        public CircleSearchExhibition$StSearchMiniApp mini_app = new MessageMicro<CircleSearchExhibition$StSearchMiniApp>() { // from class: circlesearch.CircleSearchExhibition$StSearchMiniApp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82}, new String[]{"title", "items", "more", "ext_info"}, new Object[]{"", null, "", null}, CircleSearchExhibition$StSearchMiniApp.class);
            public final PBStringField title = PBField.initString("");
            public final PBRepeatMessageField<CircleSearchExhibition$StSearchSmallItem> items = PBField.initRepeatMessage(CircleSearchExhibition$StSearchSmallItem.class);
            public final PBStringField more = PBField.initString("");
            public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
        };
        public CircleSearchExhibition$StSearchGoods goods = new CircleSearchExhibition$StSearchGoods();
    };
    public CircleSearchExhibition$StGameDescResp game_desc = new CircleSearchExhibition$StGameDescResp();
    public CircleSearchExhibition$StGameCollectionResp game_collection = new CircleSearchExhibition$StGameCollectionResp();
    public final PBBoolField grey = PBField.initBool(false);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public CircleSearchExhibition$CorrectionInfo correction_info = new CircleSearchExhibition$CorrectionInfo();
}
