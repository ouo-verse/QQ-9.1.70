package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBatchFollowReq extends MessageMicro<FeedCloudWrite$StDoBatchFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"extInfo", VasLiveIPCModule.KEY_FOLLOW_TYPE, "userList", "from", "followMethod", "src"}, new Object[]{null, 0, null, 0, 0, 0}, FeedCloudWrite$StDoBatchFollowReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field followMethod = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
}
