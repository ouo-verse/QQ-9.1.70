package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StGameCollectionResp extends MessageMicro<CircleSearchExhibition$StGameCollectionResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 82, 90, 98, 162, 170}, new String[]{"background", "detail", "app_id", "channel_id", "header", "icons", "image", "gift_bag", "props", "game", "report", "ext_info"}, new Object[]{"", null, "", "", null, null, null, null, null, null, null, null}, CircleSearchExhibition$StGameCollectionResp.class);
    public final PBStringField background = PBField.initString("");
    public CircleSearchExhibition$StSearchGameDetail detail = new MessageMicro<CircleSearchExhibition$StSearchGameDetail>() { // from class: circlesearch.CircleSearchExhibition$StSearchGameDetail
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 64, 72, 82, 90, 98, 106, 114, 122, 130, 138}, new String[]{CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_icon", "game_detail_url", "game_download_url", "game_slogan", "game_download_total", "game_tag", "game_publish_type", "game_status", "developer_info", "game_version", "purview_info", "privacy_policy_url", "management_subject", "ios_pkg_size", "android_pkg_size", "pkg_name"}, new Object[]{"", "", "", "", "", 0, "", 0, 0, "", "", "", "", "", "", "", ""}, CircleSearchExhibition$StSearchGameDetail.class);
        public final PBStringField game_name = PBField.initString("");
        public final PBStringField game_icon = PBField.initString("");
        public final PBStringField game_detail_url = PBField.initString("");
        public final PBStringField game_download_url = PBField.initString("");
        public final PBStringField game_slogan = PBField.initString("");
        public final PBInt32Field game_download_total = PBField.initInt32(0);
        public final PBRepeatField<String> game_tag = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBEnumField game_publish_type = PBField.initEnum(0);
        public final PBEnumField game_status = PBField.initEnum(0);
        public final PBStringField developer_info = PBField.initString("");
        public final PBStringField game_version = PBField.initString("");
        public final PBStringField purview_info = PBField.initString("");
        public final PBStringField privacy_policy_url = PBField.initString("");
        public final PBStringField management_subject = PBField.initString("");
        public final PBStringField ios_pkg_size = PBField.initString("");
        public final PBStringField android_pkg_size = PBField.initString("");
        public final PBStringField pkg_name = PBField.initString("");
    };
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public CircleSearchExhibition$StSearchHeaderColumn header = new MessageMicro<CircleSearchExhibition$StSearchHeaderColumn>() { // from class: circlesearch.CircleSearchExhibition$StSearchHeaderColumn
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 34, 42, 74, 82, 90}, new String[]{"name", "description", "playing_text", "playing_icons", ZPlanPublishSource.FROM_SCHEME, "report", "ext_info"}, new Object[]{"", "", "", null, "", null, null}, CircleSearchExhibition$StSearchHeaderColumn.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField description = PBField.initString("");
        public final PBStringField playing_text = PBField.initString("");
        public final PBRepeatMessageField<CircleSearchExhibition$StSearchIconItem> playing_icons = PBField.initRepeatMessage(CircleSearchExhibition$StSearchIconItem.class);
        public final PBStringField scheme = PBField.initString("");
        public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
        public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    };
    public final PBRepeatMessageField<CircleSearchExhibition$StSearchIconItem> icons = PBField.initRepeatMessage(CircleSearchExhibition$StSearchIconItem.class);
    public CircleSearchExhibition$StSearchImage image = new MessageMicro<CircleSearchExhibition$StSearchImage>() { // from class: circlesearch.CircleSearchExhibition$StSearchImage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82, 90}, new String[]{"text", "image", ZPlanPublishSource.FROM_SCHEME, "report", "ext_info"}, new Object[]{"", "", "", null, null}, CircleSearchExhibition$StSearchImage.class);
        public final PBStringField text = PBField.initString("");
        public final PBStringField image = PBField.initString("");
        public final PBStringField scheme = PBField.initString("");
        public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
        public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    };
    public CircleSearchExhibition$StSearchGoods gift_bag = new CircleSearchExhibition$StSearchGoods();
    public CircleSearchExhibition$StSearchGoods props = new CircleSearchExhibition$StSearchGoods();
    public CircleSearchExhibition$StSearchGame game = new CircleSearchExhibition$StSearchGame();
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
