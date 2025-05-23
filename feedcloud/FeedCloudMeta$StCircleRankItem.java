package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StCircleRankItem extends MessageMicro<FeedCloudMeta$StCircleRankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"rankNo", "circleName", "fuelValue", "feedNum", "circleID"}, new Object[]{0, "", 0L, 0L, ""}, FeedCloudMeta$StCircleRankItem.class);
    public final PBInt32Field rankNo = PBField.initInt32(0);
    public final PBStringField circleName = PBField.initString("");
    public final PBInt64Field fuelValue = PBField.initInt64(0);
    public final PBInt64Field feedNum = PBField.initInt64(0);
    public final PBStringField circleID = PBField.initString("");
}
