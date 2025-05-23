package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StGameDescResp extends MessageMicro<CircleSearchExhibition$StGameDescResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 82, 90}, new String[]{"title", "content", "icon", ZPlanPublishSource.FROM_SCHEME, "items", "report", "ext_info"}, new Object[]{"", "", "", "", null, null, null}, CircleSearchExhibition$StGameDescResp.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBRepeatMessageField<CircleSearchExhibition$StSearchTextItem> items = PBField.initRepeatMessage(CircleSearchExhibition$StSearchTextItem.class);
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
