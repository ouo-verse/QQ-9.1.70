package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDelUserGroupReq extends MessageMicro<FeedCloudWrite$StDelUserGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "id"}, new Object[]{null, ""}, FeedCloudWrite$StDelUserGroupReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398483id = PBField.initString("");
}
