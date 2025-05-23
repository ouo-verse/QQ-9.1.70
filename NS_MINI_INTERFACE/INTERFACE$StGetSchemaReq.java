package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetSchemaReq extends MessageMicro<INTERFACE$StGetSchemaReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74, 82, 90}, new String[]{"extInfo", PreloadingFragment.KEY_APPID, "path", "sig_querystring", "querystring", "extradata", "versionType", "versionId", ISchemeApi.KEY_REFERER, "via", "scene"}, new Object[]{null, "", "", "", "", "", 0, "", "", "", ""}, INTERFACE$StGetSchemaReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField mini_appid = PBField.initString("");
    public final PBStringField path = PBField.initString("");
    public final PBStringField sig_querystring = PBField.initString("");
    public final PBStringField querystring = PBField.initString("");
    public final PBStringField extradata = PBField.initString("");
    public final PBInt32Field versionType = PBField.initInt32(0);
    public final PBStringField versionId = PBField.initString("");
    public final PBStringField referer = PBField.initString("");
    public final PBStringField via = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
}
