package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StMiniPresentReq extends MessageMicro<MiniAppMidasPay$StMiniPresentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66, 74, 80, 90, 98, 106, 112, 122}, new String[]{"extInfo", "openid", "qq_appid", "offer_id", "ts", "zone_id", AdParam.PF, "pfkey", "user_ip", "present_counts", "bill_no", PreloadTRTCPlayerParams.KEY_SIG, "qq_sig", "sandbox_env", "openkey"}, new Object[]{null, "", "", "", 0L, "", "", "", "", 0L, "", "", "", 0L, ""}, MiniAppMidasPay$StMiniPresentReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField qq_appid = PBField.initString("");
    public final PBStringField offer_id = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f24950ts = PBField.initInt64(0);
    public final PBStringField zone_id = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f24949pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBStringField user_ip = PBField.initString("");
    public final PBInt64Field present_counts = PBField.initInt64(0);
    public final PBStringField bill_no = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
    public final PBStringField qq_sig = PBField.initString("");
    public final PBInt64Field sandbox_env = PBField.initInt64(0);
    public final PBStringField openkey = PBField.initString("");
}
