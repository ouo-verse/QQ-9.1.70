package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushBoxDrawRocketReq extends MessageMicro<FeedCloudWrite$PushBoxDrawRocketReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"drawBox", "from"}, new Object[]{null, 0}, FeedCloudWrite$PushBoxDrawRocketReq.class);
    public FeedCloudWrite$PushBoxBasic drawBox = new FeedCloudWrite$PushBoxBasic();
    public final PBInt32Field from = PBField.initInt32(0);
}
