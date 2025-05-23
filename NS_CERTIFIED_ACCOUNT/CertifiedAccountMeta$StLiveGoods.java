package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StLiveGoods extends MessageMicro<CertifiedAccountMeta$StLiveGoods> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 66}, new String[]{"goodsId", "imgUrl", "name", "desc", "curPrice", "orgPrice", "inventory", "saleTip"}, new Object[]{"", "", "", "", 0, 0, 0, ""}, CertifiedAccountMeta$StLiveGoods.class);
    public final PBStringField goodsId = PBField.initString("");
    public final PBStringField imgUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field curPrice = PBField.initInt32(0);
    public final PBInt32Field orgPrice = PBField.initInt32(0);
    public final PBInt32Field inventory = PBField.initInt32(0);
    public final PBStringField saleTip = PBField.initString("");
}
