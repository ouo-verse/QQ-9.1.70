package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUseUserAppReq extends MessageMicro<INTERFACE$StUseUserAppReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 33, 40, 48, 58, 66}, new String[]{"extInfo", "appId", "verType", "useTime", "source", "needRecommend", "oldRecommendList", "channelInfo"}, new Object[]{null, "", 0, Double.valueOf(0.0d), 0, 0, null, null}, INTERFACE$StUseUserAppReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBEnumField verType = PBField.initEnum(0);
    public final PBDoubleField useTime = PBField.initDouble(0.0d);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBInt32Field needRecommend = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE$StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE$StRecommendApp.class);
    public INTERFACE$StCurrChannelInfo channelInfo = new INTERFACE$StCurrChannelInfo();
}
