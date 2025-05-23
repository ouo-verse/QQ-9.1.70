package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StOperationInfo extends MessageMicro<INTERFACE$StOperationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"reportData", "amsAdInfo", "tianshuAdId", "recommend", "tagInfo", "tagInfos"}, new Object[]{"", "", 0, null, null, null}, INTERFACE$StOperationInfo.class);
    public final PBStringField reportData = PBField.initString("");
    public final PBStringField amsAdInfo = PBField.initString("");
    public final PBUInt32Field tianshuAdId = PBField.initUInt32(0);
    public INTERFACE$StRecommendInfo recommend = new MessageMicro<INTERFACE$StRecommendInfo>() { // from class: NS_MINI_INTERFACE.INTERFACE$StRecommendInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"itemId", "recomTrace"}, new Object[]{"", ""}, INTERFACE$StRecommendInfo.class);
        public final PBStringField itemId = PBField.initString("");
        public final PBStringField recomTrace = PBField.initString("");
    };
    public INTERFACE$TagInfo tagInfo = new INTERFACE$TagInfo();
    public final PBRepeatMessageField<INTERFACE$TagInfo> tagInfos = PBField.initRepeatMessage(INTERFACE$TagInfo.class);
}
