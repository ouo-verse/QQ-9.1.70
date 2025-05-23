package circlesearch;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSearchSmallItem extends MessageMicro<CircleSearchExhibition$StSearchSmallItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 82}, new String[]{"title", "subtitle", "icon", ZPlanPublishSource.FROM_SCHEME, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "button_scheme", "report", "ext_info"}, new Object[]{"", "", "", "", "", "", "", null, null}, CircleSearchExhibition$StSearchSmallItem.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField button_scheme = PBField.initString("");
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
