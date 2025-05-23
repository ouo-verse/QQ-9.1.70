package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StAddPhoneNumberRsp extends MessageMicro<INTERFACE$StAddPhoneNumberRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"extInfo", MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, "iv", "countryCode", "purePhoneNumber", MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID}, new Object[]{null, "", "", "", "", ""}, INTERFACE$StAddPhoneNumberRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField encryptedData = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f24957iv = PBField.initString("");
    public final PBStringField countryCode = PBField.initString("");
    public final PBStringField purePhoneNumber = PBField.initString("");
    public final PBStringField phoneNumberID = PBField.initString("");
}
