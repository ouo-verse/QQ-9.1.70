package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$TofuProfileRsp extends MessageMicro<FeedCloudRead$TofuProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feeds", "ext"}, new Object[]{null, ""}, FeedCloudRead$TofuProfileRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$TofuFeed> feeds = PBField.initRepeatMessage(FeedCloudRead$TofuFeed.class);
    public final PBStringField ext = PBField.initString("");
}
