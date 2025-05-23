package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$ChildFeedDeclaration extends MessageMicro<FeedCloudMeta$ChildFeedDeclaration> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"id", "content"}, new Object[]{"", ""}, FeedCloudMeta$ChildFeedDeclaration.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398438id = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
