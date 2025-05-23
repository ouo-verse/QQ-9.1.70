package QC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AioBubbleRecom$GetAioRecommendRsp extends MessageMicro<AioBubbleRecom$GetAioRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"items", "ruleId"}, new Object[]{null, ""}, AioBubbleRecom$GetAioRecommendRsp.class);
    public final PBRepeatMessageField<AioBubbleRecom$ItemInfo> items = PBField.initRepeatMessage(AioBubbleRecom$ItemInfo.class);
    public final PBStringField ruleId = PBField.initString("");
}
