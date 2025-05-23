package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StEveryoneSearchInfo;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StEveryoneSearchInfo extends MessageMicro<CircleSearchExhibition$StEveryoneSearchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feed_id", "everyone_search_info"}, new Object[]{"", null}, CircleSearchExhibition$StEveryoneSearchInfo.class);
    public final PBStringField feed_id = PBField.initString("");
    public FeedCloudMeta$StEveryoneSearchInfo everyone_search_info = new FeedCloudMeta$StEveryoneSearchInfo();
}
