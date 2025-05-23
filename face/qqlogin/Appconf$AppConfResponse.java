package face.qqlogin;

import com.tencent.bugly.library.BuglyAppVersionMode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Appconf$AppConfResponse extends MessageMicro<Appconf$AppConfResponse> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ActionSeq;
    public final PBBytesField ColorSeq;
    public final PBStringField Debug;
    public FaceCommon$EncryptContext EncContext;
    public final PBStringField ErrMsg;
    public final PBUInt32Field Ret;
    public final PBStringField Session;
    public final PBBytesField huiyan_sdk_token;
    public final PBRepeatMessageField<Appconf$ServiceProtocol> protocols;
    public final PBStringField select_data;
    public final PBStringField AppName = PBField.initString("");
    public final PBRepeatMessageField<Appconf$Wording> Wordings = PBField.initRepeatMessage(Appconf$Wording.class);
    public final PBEnumField Mode = PBField.initEnum(0);

    static {
        String[] strArr = {"AppName", "Wordings", "Mode", "ColorSeq", "Session", "Ret", "ErrMsg", BuglyAppVersionMode.DEBUG, "EncContext", "ActionSeq", "protocols", "select_data", "huiyan_sdk_token"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 58, 66, 74, 122, 162, 178, 186}, strArr, new Object[]{"", null, 0, byteStringMicro, "", 0, "", "", null, byteStringMicro, null, "", byteStringMicro}, Appconf$AppConfResponse.class);
    }

    public Appconf$AppConfResponse() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ColorSeq = PBField.initBytes(byteStringMicro);
        this.Session = PBField.initString("");
        this.Ret = PBField.initUInt32(0);
        this.ErrMsg = PBField.initString("");
        this.Debug = PBField.initString("");
        this.EncContext = new FaceCommon$EncryptContext();
        this.ActionSeq = PBField.initBytes(byteStringMicro);
        this.protocols = PBField.initRepeatMessage(Appconf$ServiceProtocol.class);
        this.select_data = PBField.initString("");
        this.huiyan_sdk_token = PBField.initBytes(byteStringMicro);
    }
}
