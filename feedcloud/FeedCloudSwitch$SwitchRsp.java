package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSwitch$SwitchRsp extends MessageMicro<FeedCloudSwitch$SwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"switchs"}, new Object[]{null}, FeedCloudSwitch$SwitchRsp.class);
    public final PBRepeatMessageField<FeedCloudUsersettings$Entry> switchs = PBField.initRepeatMessage(FeedCloudUsersettings$Entry.class);
}
