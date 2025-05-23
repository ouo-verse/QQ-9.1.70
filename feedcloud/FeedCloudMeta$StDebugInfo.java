package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StDebugInfo extends MessageMicro<FeedCloudMeta$StDebugInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"debugMap", "debugMapBytes"}, new Object[]{null, null}, FeedCloudMeta$StDebugInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> debugMap = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> debugMapBytes = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
}
