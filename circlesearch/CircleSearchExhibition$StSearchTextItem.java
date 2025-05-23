package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSearchTextItem extends MessageMicro<CircleSearchExhibition$StSearchTextItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82, 90}, new String[]{"text", ZPlanPublishSource.FROM_SCHEME, "report", "ext_info"}, new Object[]{"", "", null, null}, CircleSearchExhibition$StSearchTextItem.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
