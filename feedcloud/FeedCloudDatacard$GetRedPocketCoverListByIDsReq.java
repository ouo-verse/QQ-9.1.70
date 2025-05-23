package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.peak.PeakConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetRedPocketCoverListByIDsReq extends MessageMicro<FeedCloudDatacard$GetRedPocketCoverListByIDsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PeakConstants.COVER_ID}, new Object[]{""}, FeedCloudDatacard$GetRedPocketCoverListByIDsReq.class);
    public final PBRepeatField<String> cover_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}
