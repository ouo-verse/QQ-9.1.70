package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetBarrageListRsp extends MessageMicro<FeedCloudRead$StGetBarrageListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "vecBarrage", "isFinish", "feedPlayTime"}, new Object[]{null, null, 0, 0L}, FeedCloudRead$StGetBarrageListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StBarrage> vecBarrage = PBField.initRepeatMessage(FeedCloudMeta$StBarrage.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt64Field feedPlayTime = PBField.initUInt64(0);
}
