package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserAppMoreInfoReq extends MessageMicro<INTERFACE$StGetUserAppMoreInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "appIds", "verType"}, new Object[]{null, "", 0}, INTERFACE$StGetUserAppMoreInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> appIds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField verType = PBField.initEnum(0);
}
