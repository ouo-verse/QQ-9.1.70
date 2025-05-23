package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoGYGenerateReq extends MessageMicro<FeedCloudWrite$StDoGYGenerateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"extInfo", "scene", "contents", "from"}, new Object[]{null, 0, 0, 0}, FeedCloudWrite$StDoGYGenerateReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBRepeatField<Integer> contents = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
