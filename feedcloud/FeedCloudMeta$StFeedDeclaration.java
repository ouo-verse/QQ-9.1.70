package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedDeclaration extends MessageMicro<FeedCloudMeta$StFeedDeclaration> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"declaration_id", "declaration_content", "has_check_box", "declarations"}, new Object[]{"", "", Boolean.FALSE, null}, FeedCloudMeta$StFeedDeclaration.class);
    public final PBStringField declaration_id = PBField.initString("");
    public final PBStringField declaration_content = PBField.initString("");
    public final PBBoolField has_check_box = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudMeta$ChildFeedDeclaration> declarations = PBField.initRepeatMessage(FeedCloudMeta$ChildFeedDeclaration.class);
}
