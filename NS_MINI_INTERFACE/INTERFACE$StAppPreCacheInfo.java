package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StAppPreCacheInfo extends MessageMicro<INTERFACE$StAppPreCacheInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"getDataUrl", "preCacheKey", "expireTime", "cacheType", "useProxy"}, new Object[]{"", "", 0L, 0, 0}, INTERFACE$StAppPreCacheInfo.class);
    public final PBStringField getDataUrl = PBField.initString("");
    public final PBStringField preCacheKey = PBField.initString("");
    public final PBInt64Field expireTime = PBField.initInt64(0);
    public final PBInt32Field cacheType = PBField.initInt32(0);
    public final PBInt32Field useProxy = PBField.initInt32(0);
}
