package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchIconItem extends MessageMicro<FeedCloudRead$StSearchIconItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82, 90}, new String[]{"text", "icon", ZPlanPublishSource.FROM_SCHEME, "report", "extInfo"}, new Object[]{"", "", "", null, null}, FeedCloudRead$StSearchIconItem.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
