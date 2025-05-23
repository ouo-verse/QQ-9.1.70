package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$CheckIsInWatchLaterReq extends MessageMicro<FeedCloudWatchlater$CheckIsInWatchLaterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_id_list"}, new Object[]{""}, FeedCloudWatchlater$CheckIsInWatchLaterReq.class);
    public final PBRepeatField<String> feed_id_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
