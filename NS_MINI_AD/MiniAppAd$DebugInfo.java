package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$DebugInfo extends MessageMicro<MiniAppAd$DebugInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field debug_adindexid = PBField.initUInt32(0);
    public final PBBoolField nomatch = PBField.initBool(false);
    public final PBBoolField debug = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"debug_adindexid", "nomatch", "debug"}, new Object[]{0, bool, bool}, MiniAppAd$DebugInfo.class);
    }
}
