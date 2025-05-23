package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetSecurityControlStateReq extends MessageMicro<FeedCloudRead$GetSecurityControlStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feedID", "posterID", "queryType"}, new Object[]{"", "", 0}, FeedCloudRead$GetSecurityControlStateReq.class);
    public final PBRepeatField<String> feedID;
    public final PBRepeatField<String> posterID;
    public final PBUInt32Field queryType;

    public FeedCloudRead$GetSecurityControlStateReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.feedID = PBField.initRepeat(pBStringField);
        this.posterID = PBField.initRepeat(pBStringField);
        this.queryType = PBField.initUInt32(0);
    }
}
