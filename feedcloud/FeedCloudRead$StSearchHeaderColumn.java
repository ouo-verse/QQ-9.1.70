package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchHeaderColumn extends MessageMicro<FeedCloudRead$StSearchHeaderColumn> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 34, 42, 74, 82, 90}, new String[]{"name", "description", "playing_text", "playing_icons", ZPlanPublishSource.FROM_SCHEME, "report", "extInfo"}, new Object[]{"", "", "", null, "", null, null}, FeedCloudRead$StSearchHeaderColumn.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField playing_text = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StSearchIconItem> playing_icons = PBField.initRepeatMessage(FeedCloudRead$StSearchIconItem.class);
    public final PBStringField scheme = PBField.initString("");
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
