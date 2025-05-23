package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$ShareInfo extends MessageMicro<MiniAppAd$ShareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"share_rate", "share_check"}, new Object[]{0, ""}, MiniAppAd$ShareInfo.class);
    public final PBUInt32Field share_rate = PBField.initUInt32(0);
    public final PBStringField share_check = PBField.initString("");
}
