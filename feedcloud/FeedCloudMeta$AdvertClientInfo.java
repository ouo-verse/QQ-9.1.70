package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$AdvertClientInfo extends MessageMicro<FeedCloudMeta$AdvertClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"advert_expose_position", "items"}, new Object[]{0, null}, FeedCloudMeta$AdvertClientInfo.class);
    public final PBRepeatField<Integer> advert_expose_position = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta$AdvertItem> items = PBField.initRepeatMessage(FeedCloudMeta$AdvertItem.class);
}
