package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import qqcircle.QQCircleFeedBase$ViewedFeed;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudViewHistory$StGetViewHistoryRsp extends MessageMicro<FeedCloudViewHistory$StGetViewHistoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"count_data", "is_over", "attach_info", "feeds"}, new Object[]{0L, Boolean.FALSE, "", null}, FeedCloudViewHistory$StGetViewHistoryRsp.class);
    public final PBUInt64Field count_data = PBField.initUInt64(0);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
    public final PBRepeatMessageField<QQCircleFeedBase$ViewedFeed> feeds = PBField.initRepeatMessage(QQCircleFeedBase$ViewedFeed.class);
}
