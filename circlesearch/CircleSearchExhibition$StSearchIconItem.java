package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSearchIconItem extends MessageMicro<CircleSearchExhibition$StSearchIconItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82, 90}, new String[]{"text", "icon", ZPlanPublishSource.FROM_SCHEME, "report", "ext_info"}, new Object[]{"", "", "", null, null}, CircleSearchExhibition$StSearchIconItem.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
