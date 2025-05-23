package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$DailyInfo extends MessageMicro<FeedCloudMeta$DailyInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_daily = PBField.initBool(false);
    public final PBUInt32Field valid_time = PBField.initUInt32(0);
    public final PBStringField tag = PBField.initString("");
    public final PBBoolField right_change = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"is_daily", "valid_time", "tag", "right_change"}, new Object[]{bool, 0, "", bool}, FeedCloudMeta$DailyInfo.class);
    }
}
