package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;

/* loaded from: classes.dex */
public final class INTERFACE$StSchemeParam extends MessageMicro<INTERFACE$StSchemeParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 74, 82}, new String[]{PreloadingFragment.KEY_APPID, "path", "sig_querystring", "querystring", "extradata", "versionType", "versionId", ISchemeApi.KEY_REFERER, "via", "scene"}, new Object[]{"", "", "", "", "", 0, "", "", "", ""}, INTERFACE$StSchemeParam.class);
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
