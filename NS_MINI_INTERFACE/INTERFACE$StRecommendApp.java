package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StRecommendApp extends MessageMicro<INTERFACE$StRecommendApp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"appId", "exposuredNum", "pullTime"}, new Object[]{"", 0, 0L}, INTERFACE$StRecommendApp.class);
    public final PBStringField appId = PBField.initString("");
    public final PBInt32Field exposuredNum = PBField.initInt32(0);
    public final PBInt64Field pullTime = PBField.initInt64(0);
}
