package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$ExpressionInfo extends MessageMicro<FeedCloudMeta$ExpressionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"expressionURL", "expressionMD5", "expression_src", "height", "width"}, new Object[]{"", "", 0, 0, 0}, FeedCloudMeta$ExpressionInfo.class);
    public final PBStringField expressionURL = PBField.initString("");
    public final PBStringField expressionMD5 = PBField.initString("");
    public final PBUInt32Field expression_src = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
}
