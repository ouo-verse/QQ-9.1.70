package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StPhoneNumber extends MessageMicro<INTERFACE$StPhoneNumber> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"phoneType", "purePhoneNumber", "countryCode", MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, "iv", MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID}, new Object[]{0, "", "", "", "", ""}, INTERFACE$StPhoneNumber.class);
    public final PBInt32Field phoneType = PBField.initInt32(0);
    public final PBStringField purePhoneNumber = PBField.initString("");
    public final PBStringField countryCode = PBField.initString("");
    public final PBStringField encryptedData = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f24964iv = PBField.initString("");
    public final PBStringField phoneNumberID = PBField.initString("");
}
