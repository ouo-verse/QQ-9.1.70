package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StYouZanGood extends MessageMicro<CertifiedAccountMeta$StYouZanGood> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"title", "img", "price", "url", "itemID", NotificationActivity.KEY_ALIAS}, new Object[]{"", "", 0L, "", 0L, ""}, CertifiedAccountMeta$StYouZanGood.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField img = PBField.initString("");
    public final PBUInt64Field price = PBField.initUInt64(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt64Field itemID = PBField.initInt64(0);
    public final PBStringField alias = PBField.initString("");
}
