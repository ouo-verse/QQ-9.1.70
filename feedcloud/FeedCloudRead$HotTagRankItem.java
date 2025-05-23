package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$HotTagRankItem extends MessageMicro<FeedCloudRead$HotTagRankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"info", "feedList", "innerAttachInfo"}, new Object[]{null, null, ""}, FeedCloudRead$HotTagRankItem.class);
    public FeedCloudMeta$StHotTagInfo info = new FeedCloudMeta$StHotTagInfo();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField innerAttachInfo = PBField.initString("");
}
