package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$TabCache extends MessageMicro<FeedCloudMeta$TabCache> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cacheinfo"}, new Object[]{null}, FeedCloudMeta$TabCache.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> cacheinfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
