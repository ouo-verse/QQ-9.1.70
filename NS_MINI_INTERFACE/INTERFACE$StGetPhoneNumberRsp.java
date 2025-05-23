package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StGetPhoneNumberRsp extends MessageMicro<INTERFACE$StGetPhoneNumberRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"extInfo", "purePhoneNumber", "countryCode", MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, "iv", "phoneLists"}, new Object[]{null, "", "", "", "", null}, INTERFACE$StGetPhoneNumberRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField purePhoneNumber = PBField.initString("");
    public final PBStringField countryCode = PBField.initString("");
    public final PBStringField encryptedData = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f24960iv = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StPhoneNumber> phoneLists = PBField.initRepeatMessage(INTERFACE$StPhoneNumber.class);
}
