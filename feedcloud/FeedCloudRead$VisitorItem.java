package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$VisitorItem extends MessageMicro<FeedCloudRead$VisitorItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"visitors", "vis_time"}, new Object[]{null, ""}, FeedCloudRead$VisitorItem.class);
    public FeedCloudMeta$StUser visitors = new FeedCloudMeta$StUser();
    public final PBStringField vis_time = PBField.initString("");
}
