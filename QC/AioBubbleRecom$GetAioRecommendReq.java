package QC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AioBubbleRecom$GetAioRecommendReq extends MessageMicro<AioBubbleRecom$GetAioRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"loginInfo", "appid"}, new Object[]{null, 0}, AioBubbleRecom$GetAioRecommendReq.class);
    public AioBubbleRecom$LoginInfo loginInfo = new AioBubbleRecom$LoginInfo();
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
