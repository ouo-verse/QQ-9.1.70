package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleFeedBase$ViewedFeed;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudViewHistory$StGetViewHistoryReq extends MessageMicro<FeedCloudViewHistory$StGetViewHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"attach_info", "feeds"}, new Object[]{"", null}, FeedCloudViewHistory$StGetViewHistoryReq.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBRepeatMessageField<QQCircleFeedBase$ViewedFeed> feeds = PBField.initRepeatMessage(QQCircleFeedBase$ViewedFeed.class);
}
