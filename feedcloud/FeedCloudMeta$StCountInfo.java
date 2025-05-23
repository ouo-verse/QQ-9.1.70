package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StCountInfo extends MessageMicro<FeedCloudMeta$StCountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"barragecount", "view_count", "like_count"}, new Object[]{0, 0, 0}, FeedCloudMeta$StCountInfo.class);
    public final PBUInt32Field barragecount = PBField.initUInt32(0);
    public final PBUInt32Field view_count = PBField.initUInt32(0);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
}
