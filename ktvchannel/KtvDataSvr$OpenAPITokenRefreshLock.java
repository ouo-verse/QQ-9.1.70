package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class KtvDataSvr$OpenAPITokenRefreshLock extends MessageMicro<KtvDataSvr$OpenAPITokenRefreshLock> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"refresh_stamp"}, new Object[]{0}, KtvDataSvr$OpenAPITokenRefreshLock.class);
    public final PBUInt32Field refresh_stamp = PBField.initUInt32(0);
}
