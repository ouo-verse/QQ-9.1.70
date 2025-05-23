package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$RelationGroup extends MessageMicro<FeedCloudRead$RelationGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "name", "relationInfo", "attachInfo", "hasNext", "groupFlag"}, new Object[]{"", "", null, "", 0, 0}, FeedCloudRead$RelationGroup.class);
    public final PBStringField gid = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta$StRelationInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBInt32Field groupFlag = PBField.initInt32(0);
}
