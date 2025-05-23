package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.peak.PeakConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetRedPocketCoverReq extends MessageMicro<FeedCloudDatacard$GetRedPocketCoverReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PeakConstants.COVER_ID}, new Object[]{""}, FeedCloudDatacard$GetRedPocketCoverReq.class);
    public final PBStringField cover_id = PBField.initString("");
}
