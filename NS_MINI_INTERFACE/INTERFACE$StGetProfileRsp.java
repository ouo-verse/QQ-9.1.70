package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes.dex */
public final class INTERFACE$StGetProfileRsp extends MessageMicro<INTERFACE$StGetProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER, "rawData", "signature", MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, "iv"}, new Object[]{null, null, "", "", "", ""}, INTERFACE$StGetProfileRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE$StApiUserInfo user = new INTERFACE$StApiUserInfo();
    public final PBStringField rawData = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
    public final PBStringField encryptedData = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f24961iv = PBField.initString("");
}
