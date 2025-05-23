package msf.msgsvc;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$BusinessWPATmp extends MessageMicro<msg_svc$BusinessWPATmp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig;
    public final PBBytesField sigt;
    public final PBUInt64Field to_uin = PBField.initUInt64(0);

    static {
        String[] strArr = {"to_uin", PreloadTRTCPlayerParams.KEY_SIG, "sigt"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, strArr, new Object[]{0L, byteStringMicro, byteStringMicro}, msg_svc$BusinessWPATmp.class);
    }

    public msg_svc$BusinessWPATmp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sig = PBField.initBytes(byteStringMicro);
        this.sigt = PBField.initBytes(byteStringMicro);
    }
}
