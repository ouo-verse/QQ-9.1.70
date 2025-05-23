package NS_STORE_APP_SEARCH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$CouponInfo extends MessageMicro<MiniAppSearch$CouponInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title", "leastPrice", "amt", "iconUrl"}, new Object[]{"", "", "", ""}, MiniAppSearch$CouponInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField leastPrice = PBField.initString("");
    public final PBStringField amt = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
}
