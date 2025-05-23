package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$Advice extends MessageMicro<FeedCloudRead$Advice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 64, 74, 82}, new String[]{"advice_id", "advice_rate", "advice_update", "advice_tips", "jump_url", "jump_toast", "advice_desc", "useful", "advice_rate_desc", "advice_rate_unit"}, new Object[]{"", "", Boolean.FALSE, "", "", "", "", 0, "", ""}, FeedCloudRead$Advice.class);
    public final PBStringField advice_id = PBField.initString("");
    public final PBStringField advice_rate = PBField.initString("");
    public final PBBoolField advice_update = PBField.initBool(false);
    public final PBStringField advice_tips = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField jump_toast = PBField.initString("");
    public final PBStringField advice_desc = PBField.initString("");
    public final PBInt32Field useful = PBField.initInt32(0);
    public final PBStringField advice_rate_desc = PBField.initString("");
    public final PBStringField advice_rate_unit = PBField.initString("");
}
