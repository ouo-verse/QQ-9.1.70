package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeUndealmsg$IntervalControl extends MessageMicro<FeedCloudEeveeUndealmsg$IntervalControl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"pollingInterval", "sceneSwitchInterval", "homeSwitchInterval"}, new Object[]{0, 0, 0}, FeedCloudEeveeUndealmsg$IntervalControl.class);
    public final PBInt32Field pollingInterval = PBField.initInt32(0);
    public final PBInt32Field sceneSwitchInterval = PBField.initInt32(0);
    public final PBInt32Field homeSwitchInterval = PBField.initInt32(0);
}
