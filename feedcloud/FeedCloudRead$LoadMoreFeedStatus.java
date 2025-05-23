package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$LoadMoreFeedStatus extends MessageMicro<FeedCloudRead$LoadMoreFeedStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"can_page_up", "page_up_attach_info"}, new Object[]{Boolean.FALSE, ""}, FeedCloudRead$LoadMoreFeedStatus.class);
    public final PBBoolField can_page_up = PBField.initBool(false);
    public final PBStringField page_up_attach_info = PBField.initString("");
}
