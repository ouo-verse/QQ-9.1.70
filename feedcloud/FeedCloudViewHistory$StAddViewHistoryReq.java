package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qqcircle.QQCircleFeedBase$ViewedFeed;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudViewHistory$StAddViewHistoryReq extends MessageMicro<FeedCloudViewHistory$StAddViewHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"viewed_feed"}, new Object[]{null}, FeedCloudViewHistory$StAddViewHistoryReq.class);
    public final PBRepeatMessageField<QQCircleFeedBase$ViewedFeed> viewed_feed = PBField.initRepeatMessage(QQCircleFeedBase$ViewedFeed.class);
}
