package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StAppDataCache extends MessageMicro<INTERFACE$StAppDataCache> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"wnsCgiUrl", "cacheKey"}, new Object[]{"", ""}, INTERFACE$StAppDataCache.class);
    public final PBStringField wnsCgiUrl = PBField.initString("");
    public final PBStringField cacheKey = PBField.initString("");
}
