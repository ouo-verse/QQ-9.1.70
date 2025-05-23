package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$NegativeFeedbackReq extends MessageMicro<FeedCloudPubGuideSvr$NegativeFeedbackReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"feedback_type", "type", "id"}, new Object[]{0, 0, ""}, FeedCloudPubGuideSvr$NegativeFeedbackReq.class);
    public final PBEnumField feedback_type = PBField.initEnum(0);
    public final PBEnumField type = PBField.initEnum(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398468id = PBField.initString("");
}
