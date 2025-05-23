package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$DoSecurityControlReq extends MessageMicro<FeedCloudWrite$DoSecurityControlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"feedID", "posterID", "actionType", "subActionType"}, new Object[]{"", "", 0, 0}, FeedCloudWrite$DoSecurityControlReq.class);
    public final PBUInt32Field actionType;
    public final PBRepeatField<String> feedID;
    public final PBRepeatField<String> posterID;
    public final PBUInt32Field subActionType;

    public FeedCloudWrite$DoSecurityControlReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.feedID = PBField.initRepeat(pBStringField);
        this.posterID = PBField.initRepeat(pBStringField);
        this.actionType = PBField.initUInt32(0);
        this.subActionType = PBField.initUInt32(0);
    }
}
