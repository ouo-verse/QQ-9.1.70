package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$LoadMoreFeedInfo extends MessageMicro<FeedCloudRead$LoadMoreFeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"load_more_type", "page_up_attach_info"}, new Object[]{0, ""}, FeedCloudRead$LoadMoreFeedInfo.class);
    public final PBEnumField load_more_type = PBField.initEnum(0);
    public final PBStringField page_up_attach_info = PBField.initString("");
}
