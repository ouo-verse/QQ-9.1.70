package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* loaded from: classes28.dex */
public final class KtvDataSvr$OpenAPITokenCache extends MessageMicro<KtvDataSvr$OpenAPITokenCache> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "refresh_token", "expires_in"}, new Object[]{"", "", 0}, KtvDataSvr$OpenAPITokenCache.class);
    public final PBStringField access_token = PBField.initString("");
    public final PBStringField refresh_token = PBField.initString("");
    public final PBUInt32Field expires_in = PBField.initUInt32(0);
}
