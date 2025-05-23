package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StLightInteractInfo extends MessageMicro<FeedCloudMeta$StLightInteractInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 56, 64}, new String[]{QCircleAlphaUserReporter.KEY_USER, "relation", "count", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "opTime", "urgeStatus", "thanked", "opMask"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY, 0, 0, Boolean.FALSE, 0}, FeedCloudMeta$StLightInteractInfo.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StRelationInfo relation = new FeedCloudMeta$StRelationInfo();
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opTime = PBField.initUInt32(0);
    public final PBUInt32Field urgeStatus = PBField.initUInt32(0);
    public final PBBoolField thanked = PBField.initBool(false);
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
