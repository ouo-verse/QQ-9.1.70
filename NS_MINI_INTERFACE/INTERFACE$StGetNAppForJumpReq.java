package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetNAppForJumpReq extends MessageMicro<INTERFACE$StGetNAppForJumpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"extInfo", PreloadingFragment.KEY_APPID, "native_appid", "android_pkg_name", "ios_bundleid", "scene"}, new Object[]{null, "", "", "", "", 0}, INTERFACE$StGetNAppForJumpReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField mini_appid = PBField.initString("");
    public final PBStringField native_appid = PBField.initString("");
    public final PBStringField android_pkg_name = PBField.initString("");
    public final PBStringField ios_bundleid = PBField.initString("");
    public final PBInt32Field scene = PBField.initInt32(0);
}
