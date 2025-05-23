package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoShareReq extends MessageMicro<FeedCloudWrite$StDoShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"items", "feedID"}, new Object[]{null, ""}, FeedCloudWrite$StDoShareReq.class);
    public final PBRepeatMessageField<FeedCloudWrite$ShareItem> items = PBField.initRepeatMessage(FeedCloudWrite$ShareItem.class);
    public final PBStringField feedID = PBField.initString("");
}
