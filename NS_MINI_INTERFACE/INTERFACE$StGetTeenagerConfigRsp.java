package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetTeenagerConfigRsp extends MessageMicro<INTERFACE$StGetTeenagerConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"appIDs", MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "extInfo"}, new Object[]{"", 0, 0, ""}, INTERFACE$StGetTeenagerConfigRsp.class);
    public final PBRepeatField<String> appIDs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field frequencySwitch = PBField.initUInt32(0);
    public final PBUInt32Field timeInterval = PBField.initUInt32(0);
    public final PBStringField extInfo = PBField.initString("");
}
