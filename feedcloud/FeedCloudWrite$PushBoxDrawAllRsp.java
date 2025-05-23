package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushBoxDrawAllRsp extends MessageMicro<FeedCloudWrite$PushBoxDrawAllRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50}, new String[]{"drawBoxResult", "isEnd", "taskCenterJumpUrl", "gift_result", "un_open_count", "show_off_btn"}, new Object[]{null, Boolean.FALSE, "", null, 0L, null}, FeedCloudWrite$PushBoxDrawAllRsp.class);
    public final PBRepeatMessageField<FeedCloudWrite$PushBoxBasic> drawBoxResult = PBField.initRepeatMessage(FeedCloudWrite$PushBoxBasic.class);
    public final PBBoolField isEnd = PBField.initBool(false);
    public final PBStringField taskCenterJumpUrl = PBField.initString("");
    public FeedCloudWrite$PushBoxDrawGiftResult gift_result = new FeedCloudWrite$PushBoxDrawGiftResult();
    public final PBUInt64Field un_open_count = PBField.initUInt64(0);
    public FeedCloudWrite$PushShowOffBtn show_off_btn = new FeedCloudWrite$PushShowOffBtn();
}
