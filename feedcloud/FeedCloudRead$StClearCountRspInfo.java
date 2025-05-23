package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StClearCountRspInfo extends MessageMicro<FeedCloudRead$StClearCountRspInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"countType", "clearTime"}, new Object[]{0, 0L}, FeedCloudRead$StClearCountRspInfo.class);
    public final PBInt32Field countType = PBField.initInt32(0);
    public final PBInt64Field clearTime = PBField.initInt64(0);
}
