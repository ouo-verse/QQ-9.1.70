package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedbackReport$ContentFeedbackItem extends MessageMicro<FeedbackReport$ContentFeedbackItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56, 64, 72, 82}, new String[]{"cmsid", "content_type", "feedback_type", "reasonid", "agent_tip_words", "details", "feedback_time", "is_aggregated", "times_aggregated", "vid"}, new Object[]{"", 1, 1, 1, "", "", 0, 0, 0, ""}, FeedbackReport$ContentFeedbackItem.class);
    public final PBStringField cmsid = PBField.initString("");
    public final PBEnumField content_type = PBField.initEnum(1);
    public final PBEnumField feedback_type = PBField.initEnum(1);
    public final PBEnumField reasonid = PBField.initEnum(1);
    public final PBStringField agent_tip_words = PBField.initString("");
    public final PBStringField details = PBField.initString("");
    public final PBInt32Field feedback_time = PBField.initInt32(0);
    public final PBInt32Field is_aggregated = PBField.initInt32(0);
    public final PBInt32Field times_aggregated = PBField.initInt32(0);
    public final PBStringField vid = PBField.initString("");
}
