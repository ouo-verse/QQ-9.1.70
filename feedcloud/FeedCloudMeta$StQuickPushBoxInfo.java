package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StQuickPushBoxInfo extends MessageMicro<FeedCloudMeta$StQuickPushBoxInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"divide_num", "low_rockets", "high_rockets"}, new Object[]{0, 0, 0}, FeedCloudMeta$StQuickPushBoxInfo.class);
    public final PBUInt32Field divide_num = PBField.initUInt32(0);
    public final PBRepeatField<Integer> high_rockets;
    public final PBRepeatField<Integer> low_rockets;

    public FeedCloudMeta$StQuickPushBoxInfo() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.low_rockets = PBField.initRepeat(pBUInt32Field);
        this.high_rockets = PBField.initRepeat(pBUInt32Field);
    }
}
