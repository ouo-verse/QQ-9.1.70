package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StContentAccelerateRsp extends MessageMicro<INTERFACE$StContentAccelerateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "rspHeaders", "cacheData", "httpReturnCode"}, new Object[]{null, null, ByteStringMicro.EMPTY, 0}, INTERFACE$StContentAccelerateRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<COMM.Entry> rspHeaders = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBBytesField cacheData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field httpReturnCode = PBField.initInt32(0);
}
