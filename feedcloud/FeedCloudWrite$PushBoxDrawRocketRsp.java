package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushBoxDrawRocketRsp extends MessageMicro<FeedCloudWrite$PushBoxDrawRocketRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"drawBoxResult", "taskCenterJumpUrl", "gift_result", "un_open_count", "show_off_btn"}, new Object[]{null, "", null, 0L, null}, FeedCloudWrite$PushBoxDrawRocketRsp.class);
    public FeedCloudWrite$PushBoxBasic drawBoxResult = new FeedCloudWrite$PushBoxBasic();
    public final PBStringField taskCenterJumpUrl = PBField.initString("");
    public FeedCloudWrite$PushBoxDrawGiftResult gift_result = new FeedCloudWrite$PushBoxDrawGiftResult();
    public final PBUInt64Field un_open_count = PBField.initUInt64(0);
    public FeedCloudWrite$PushShowOffBtn show_off_btn = new FeedCloudWrite$PushShowOffBtn();
}
