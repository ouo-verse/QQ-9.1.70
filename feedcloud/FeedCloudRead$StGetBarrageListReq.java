package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetBarrageListReq extends MessageMicro<FeedCloudRead$StGetBarrageListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "feedUserID", "feedID", "feedPlayTime"}, new Object[]{null, "", "", 0L}, FeedCloudRead$StGetBarrageListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField feedUserID = PBField.initString("");
    public final PBStringField feedID = PBField.initString("");
    public final PBUInt64Field feedPlayTime = PBField.initUInt64(0);
}
