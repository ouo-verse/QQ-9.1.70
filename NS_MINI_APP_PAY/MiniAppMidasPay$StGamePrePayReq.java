package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGamePrePayReq extends MessageMicro<MiniAppMidasPay$StGamePrePayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 64, 74, 82, 88, 98, 106}, new String[]{"extInfo", "openid", "appid", "ts", "zone_id", AdParam.PF, "user_ip", "amt", "bill_no", "goodid", "good_num", "app_remark", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{null, "", "", 0L, "", "", "", 0L, "", "", 0, "", ""}, MiniAppMidasPay$StGamePrePayReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField appid = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f24942ts = PBField.initInt64(0);
    public final PBStringField zone_id = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f24941pf = PBField.initString("");
    public final PBStringField user_ip = PBField.initString("");
    public final PBInt64Field amt = PBField.initInt64(0);
    public final PBStringField bill_no = PBField.initString("");
    public final PBStringField goodid = PBField.initString("");
    public final PBInt32Field good_num = PBField.initInt32(0);
    public final PBStringField app_remark = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
}
