package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GroupReqItem extends MessageMicro<FeedCloudRead$GroupReqItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "attachInfo"}, new Object[]{"", ""}, FeedCloudRead$GroupReqItem.class);
    public final PBStringField gid = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
}
