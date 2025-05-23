package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StFeedDrawer extends MessageMicro<FeedCloudRead$StFeedDrawer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 7994}, new String[]{"type", "cards", "drawerTitle", "ext_info"}, new Object[]{0, null, "", null}, FeedCloudRead$StFeedDrawer.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudRead$StDrawerCard> cards = PBField.initRepeatMessage(FeedCloudRead$StDrawerCard.class);
    public final PBStringField drawerTitle = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> ext_info = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
