package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$SetFeedAdviceReq extends MessageMicro<FeedCloudRead$SetFeedAdviceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"user_id", "advice_id", "userful"}, new Object[]{"", "", 0}, FeedCloudRead$SetFeedAdviceReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField advice_id = PBField.initString("");
    public final PBInt32Field userful = PBField.initInt32(0);
}
