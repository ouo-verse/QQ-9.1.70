package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchMiniApp extends MessageMicro<FeedCloudRead$StSearchMiniApp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82}, new String[]{"title", "items", "more", "extInfo"}, new Object[]{"", null, "", null}, FeedCloudRead$StSearchMiniApp.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StSearchSmallItem> items = PBField.initRepeatMessage(FeedCloudRead$StSearchSmallItem.class);
    public final PBStringField more = PBField.initString("");
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
