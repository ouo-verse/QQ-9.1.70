package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StUserGroupInfo extends MessageMicro<FeedCloudMeta$StUserGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "name", "userList"}, new Object[]{"", "", null}, FeedCloudMeta$StUserGroupInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398464id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
}
