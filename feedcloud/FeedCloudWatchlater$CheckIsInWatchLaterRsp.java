package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$CheckIsInWatchLaterRsp extends MessageMicro<FeedCloudWatchlater$CheckIsInWatchLaterRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"check_list"}, new Object[]{null}, FeedCloudWatchlater$CheckIsInWatchLaterRsp.class);
    public final PBRepeatMessageField<FeedCloudWatchlater$CheckListEntry> check_list = PBField.initRepeatMessage(FeedCloudWatchlater$CheckListEntry.class);
}
