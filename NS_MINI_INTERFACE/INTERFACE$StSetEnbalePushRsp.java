package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class INTERFACE$StSetEnbalePushRsp extends MessageMicro<INTERFACE$StSetEnbalePushRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"enablePush"}, new Object[]{0}, INTERFACE$StSetEnbalePushRsp.class);
    public final PBUInt32Field enablePush = PBField.initUInt32(0);
}
