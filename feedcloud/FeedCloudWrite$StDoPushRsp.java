package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoPushRsp extends MessageMicro<FeedCloudWrite$StDoPushRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64, 74, 82, 90}, new String[]{"extInfo", "consumeFuel", "myFuel", "busiRspData", "returnFuel", "totalCnt", "cancelPushStatus", "pushedCnt", "taskInfo", "pushBoxViewInfo", "push_broke_toast"}, new Object[]{null, 0, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, null, null, null}, FeedCloudWrite$StDoPushRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field consumeFuel = PBField.initUInt32(0);
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field returnFuel = PBField.initUInt32(0);
    public final PBUInt32Field totalCnt = PBField.initUInt32(0);
    public final PBUInt32Field cancelPushStatus = PBField.initUInt32(0);
    public final PBInt32Field pushedCnt = PBField.initInt32(0);
    public FeedCloudWrite$PushDoneTaskInfo taskInfo = new MessageMicro<FeedCloudWrite$PushDoneTaskInfo>() { // from class: feedcloud.FeedCloudWrite$PushDoneTaskInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "desc", "jump_url"}, new Object[]{"", "", ""}, FeedCloudWrite$PushDoneTaskInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f398479id = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    };
    public FeedCloudMeta$PushBoxViewInfo pushBoxViewInfo = new FeedCloudMeta$PushBoxViewInfo();
    public FeedCloudMeta$PushBrokeToast push_broke_toast = new FeedCloudMeta$PushBrokeToast();
}
