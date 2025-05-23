package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoFollowRsp extends MessageMicro<FeedCloudWrite$StDoFollowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"extInfo", "isDoubly", "result"}, new Object[]{null, Boolean.FALSE, 1}, FeedCloudWrite$StDoFollowRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBoolField isDoubly = PBField.initBool(false);
    public final PBEnumField result = PBField.initEnum(1);
}
