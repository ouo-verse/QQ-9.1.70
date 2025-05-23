package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class faceproto$Request extends MessageMicro<faceproto$Request> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField EncFaceInfo;
    public final PBBytesField EncUserInfo;
    public final PBBytesField XPSEnvData;
    public faceproto$App SrcApp = new faceproto$App();
    public final PBUInt32Field AppID = PBField.initUInt32(0);
    public FaceCommon$UserInfo UserInfo = new FaceCommon$UserInfo();
    public faceproto$FaceInfo FaceInfo = new faceproto$FaceInfo();
    public final PBStringField TmpKey = PBField.initString("");
    public final PBStringField Session = PBField.initString("");
    public final PBUInt32Field CurRetryCnt = PBField.initUInt32(0);
    public final PBStringField plt = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 66, 74, 82, 90}, new String[]{"SrcApp", "AppID", "UserInfo", "FaceInfo", "TmpKey", "Session", "CurRetryCnt", "plt", "EncUserInfo", "EncFaceInfo", "XPSEnvData"}, new Object[]{null, 0, null, null, "", "", 0, "", byteStringMicro, byteStringMicro, byteStringMicro}, faceproto$Request.class);
    }

    public faceproto$Request() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.EncUserInfo = PBField.initBytes(byteStringMicro);
        this.EncFaceInfo = PBField.initBytes(byteStringMicro);
        this.XPSEnvData = PBField.initBytes(byteStringMicro);
    }
}
