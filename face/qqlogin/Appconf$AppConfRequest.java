package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Appconf$AppConfRequest extends MessageMicro<Appconf$AppConfRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField GUID;
    public final PBBytesField bssid;
    public final PBBytesField enc_identity;
    public final PBBytesField imei;
    public final PBBytesField qimei36;
    public final PBRepeatField<Integer> support_modes;
    public final PBBoolField use_huiyan_sdk;
    public final PBUInt32Field AppID = PBField.initUInt32(0);
    public final PBStringField Platform = PBField.initString("");
    public final PBStringField QQVersion = PBField.initString("");
    public final PBStringField YtSDKEnv = PBField.initString("");
    public final PBStringField TmpKey = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 64, 74, 82, 90, 98, 104}, new String[]{"AppID", "Platform", "QQVersion", "YtSDKEnv", "TmpKey", "GUID", "support_modes", "imei", "qimei36", "bssid", "enc_identity", "use_huiyan_sdk"}, new Object[]{0, "", "", "", "", byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, Boolean.FALSE}, Appconf$AppConfRequest.class);
    }

    public Appconf$AppConfRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.GUID = PBField.initBytes(byteStringMicro);
        this.support_modes = PBField.initRepeat(PBEnumField.__repeatHelper__);
        this.imei = PBField.initBytes(byteStringMicro);
        this.qimei36 = PBField.initBytes(byteStringMicro);
        this.bssid = PBField.initBytes(byteStringMicro);
        this.enc_identity = PBField.initBytes(byteStringMicro);
        this.use_huiyan_sdk = PBField.initBool(false);
    }
}
