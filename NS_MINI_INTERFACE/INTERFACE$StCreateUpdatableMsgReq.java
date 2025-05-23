package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCreateUpdatableMsgReq extends MessageMicro<INTERFACE$StCreateUpdatableMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58}, new String[]{"extInfo", "appid", "shareInfo", "templateId", "from", "serviceType", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{null, "", null, "", 0, 0, ByteStringMicro.EMPTY}, INTERFACE$StCreateUpdatableMsgReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public INTERFACE$StUpdatableMsgShareInfo shareInfo = new INTERFACE$StUpdatableMsgShareInfo();
    public final PBStringField templateId = PBField.initString("");
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBUInt32Field serviceType = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
