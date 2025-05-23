package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPushPageReq extends MessageMicro<FeedCloudRead$StGetPushPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_id"}, new Object[]{""}, FeedCloudRead$StGetPushPageReq.class);
    public final PBStringField feed_id = PBField.initString("");
}
