package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetDecorationRsp extends MessageMicro<FeedCloudRead$GetDecorationRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"jump_info", "icon"}, new Object[]{null, ""}, FeedCloudRead$GetDecorationRsp.class);
    public FeedCloudMeta$DecorateJumpInfo jump_info = new FeedCloudMeta$DecorateJumpInfo();
    public final PBStringField icon = PBField.initString("");
}
