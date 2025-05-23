package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$FeedSelfDeclaration extends MessageMicro<FeedCloudMeta$FeedSelfDeclaration> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "lbs", "source"}, new Object[]{"", null, null}, FeedCloudMeta$FeedSelfDeclaration.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398442id = PBField.initString("");
    public FeedCloudMeta$ShootLBS lbs = new FeedCloudMeta$ShootLBS();
    public FeedCloudMeta$SourceInfo source = new FeedCloudMeta$SourceInfo();
}
