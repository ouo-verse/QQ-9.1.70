package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCacheController extends MessageMicro<INTERFACE$StCacheController> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"appInfo", "cachePkg"}, new Object[]{null, 0}, INTERFACE$StCacheController.class);
    public INTERFACE$StApiAppInfo appInfo = new INTERFACE$StApiAppInfo();
    public final PBInt32Field cachePkg = PBField.initInt32(0);
}
