package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StShareURLInfo extends MessageMicro<FeedCloudMeta$StShareURLInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "url", "ext_info"}, new Object[]{0, "", null}, FeedCloudMeta$StShareURLInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
