package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchHotEventInfo extends MessageMicro<FeedCloudRead$StSearchHotEventInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 64}, new String[]{"feedList", "more_text", "more_url", "rank", "title", "attachInfo", "isOver", "heat"}, new Object[]{null, "", "", 0, "", "", 0, 0}, FeedCloudRead$StSearchHotEventInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField more_text = PBField.initString("");
    public final PBStringField more_url = PBField.initString("");
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt32Field isOver = PBField.initInt32(0);
    public final PBUInt32Field heat = PBField.initUInt32(0);
}
