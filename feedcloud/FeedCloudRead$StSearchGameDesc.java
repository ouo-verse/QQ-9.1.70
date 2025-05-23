package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchGameDesc extends MessageMicro<FeedCloudRead$StSearchGameDesc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 82, 90}, new String[]{"title", "content", "icon", ZPlanPublishSource.FROM_SCHEME, "items", "report", "extInfo"}, new Object[]{"", "", "", "", null, null, null}, FeedCloudRead$StSearchGameDesc.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StSearchTextItem> items = PBField.initRepeatMessage(FeedCloudRead$StSearchTextItem.class);
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
