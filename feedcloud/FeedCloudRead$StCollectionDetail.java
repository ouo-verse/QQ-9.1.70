package feedcloud;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StCollectionDetail extends MessageMicro<FeedCloudRead$StCollectionDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{WidgetCacheConstellationData.NUM, "feedID", "cover", "content", QZoneDTLoginReporter.SCHEMA, "feed"}, new Object[]{0, "", "", "", "", null}, FeedCloudRead$StCollectionDetail.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
}
