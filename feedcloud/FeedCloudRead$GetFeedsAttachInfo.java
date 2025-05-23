package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFeedsAttachInfo extends MessageMicro<FeedCloudRead$GetFeedsAttachInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cookie"}, new Object[]{""}, FeedCloudRead$GetFeedsAttachInfo.class);
    public final PBStringField cookie = PBField.initString("");
}
