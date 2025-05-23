package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StClearCountInfo extends MessageMicro<FeedCloudRead$StClearCountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"countType", "clearType", "delayTimeInterval", "rewriteClearTime"}, new Object[]{0, 0, 0L, 0L}, FeedCloudRead$StClearCountInfo.class);
    public final PBInt32Field countType = PBField.initInt32(0);
    public final PBInt32Field clearType = PBField.initInt32(0);
    public final PBInt64Field delayTimeInterval = PBField.initInt64(0);
    public final PBInt64Field rewriteClearTime = PBField.initInt64(0);
}
