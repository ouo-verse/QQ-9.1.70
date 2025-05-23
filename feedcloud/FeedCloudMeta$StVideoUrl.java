package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StVideoUrl extends MessageMicro<FeedCloudMeta$StVideoUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56, 64, 72, 85}, new String[]{"levelType", "playUrl", "videoPrior", "videoRate", "transStatus", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "hasWatermark", "width", "height", "videoClarityScore"}, new Object[]{0, "", 0, 0, 0, ByteStringMicro.EMPTY, Boolean.FALSE, 0, 0, Float.valueOf(0.0f)}, FeedCloudMeta$StVideoUrl.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField hasWatermark = PBField.initBool(false);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBFloatField videoClarityScore = PBField.initFloat(0.0f);
}
