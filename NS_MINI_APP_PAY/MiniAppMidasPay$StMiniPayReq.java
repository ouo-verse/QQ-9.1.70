package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StMiniPayReq extends MessageMicro<MiniAppMidasPay$StMiniPayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 120, 130}, new String[]{"extInfo", "openid", "appid", "offer_id", "ts", "zone_id", AdParam.PF, "user_ip", "amt", "bill_no", "pay_item", "app_remark", PreloadTRTCPlayerParams.KEY_SIG, "qq_sig", "sandbox_env", "openkey"}, new Object[]{null, "", "", "", 0L, "", "", "", 0L, "", "", "", "", "", 0L, ""}, MiniAppMidasPay$StMiniPayReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField offer_id = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f24948ts = PBField.initInt64(0);
    public final PBStringField zone_id = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f24947pf = PBField.initString("");
    public final PBStringField user_ip = PBField.initString("");
    public final PBInt64Field amt = PBField.initInt64(0);
    public final PBStringField bill_no = PBField.initString("");
    public final PBStringField pay_item = PBField.initString("");
    public final PBStringField app_remark = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
    public final PBStringField qq_sig = PBField.initString("");
    public final PBInt64Field sandbox_env = PBField.initInt64(0);
    public final PBStringField openkey = PBField.initString("");
}
