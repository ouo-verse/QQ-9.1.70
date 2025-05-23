package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetNAppForJumpRsp extends MessageMicro<INTERFACE$StGetNAppForJumpRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74}, new String[]{"extInfo", "native_appid", "ios_bundleid", "ios_schema", "appName", "android_pkg", "ios_donwload_url", "onlyOpen", "android_donwload_url"}, new Object[]{null, "", "", "", "", "", "", 0, ""}, INTERFACE$StGetNAppForJumpRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField native_appid = PBField.initString("");
    public final PBStringField ios_bundleid = PBField.initString("");
    public final PBStringField ios_schema = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField android_pkg = PBField.initString("");
    public final PBStringField ios_donwload_url = PBField.initString("");
    public final PBInt32Field onlyOpen = PBField.initInt32(0);
    public final PBStringField android_donwload_url = PBField.initString("");
}
