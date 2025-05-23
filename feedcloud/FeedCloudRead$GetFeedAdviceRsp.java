package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFeedAdviceRsp extends MessageMicro<FeedCloudRead$GetFeedAdviceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"advices", "mordata_word", "mordata_url"}, new Object[]{null, "", ""}, FeedCloudRead$GetFeedAdviceRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$Advice> advices = PBField.initRepeatMessage(FeedCloudRead$Advice.class);
    public final PBStringField mordata_word = PBField.initString("");
    public final PBStringField mordata_url = PBField.initString("");
}
