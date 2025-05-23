package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StWearingMedalInfo extends MessageMicro<FeedCloudMeta$StWearingMedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "medalName", "medalID"}, new Object[]{0, "", ""}, FeedCloudMeta$StWearingMedalInfo.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField medalName = PBField.initString("");
    public final PBStringField medalID = PBField.initString("");
}
