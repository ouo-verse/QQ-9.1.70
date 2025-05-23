package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.peak.PeakConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$VerifyRedPocketCoverReq extends MessageMicro<FeedCloudDatacard$VerifyRedPocketCoverReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{PeakConstants.COVER_ID}, new Object[]{""}, FeedCloudDatacard$VerifyRedPocketCoverReq.class);
    public final PBStringField cover_id = PBField.initString("");
}
