package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StSecondFriend extends MessageMicro<FeedCloudMeta$StSecondFriend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uid", "nick", "head_url"}, new Object[]{0L, "", ""}, FeedCloudMeta$StSecondFriend.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField head_url = PBField.initString("");
}
