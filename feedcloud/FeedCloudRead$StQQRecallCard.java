package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StQQRecallCard extends MessageMicro<FeedCloudRead$StQQRecallCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "feed", "jumpURL"}, new Object[]{0, null, ""}, FeedCloudRead$StQQRecallCard.class);
    public final PBEnumField type = PBField.initEnum(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBStringField jumpURL = PBField.initString("");
}
