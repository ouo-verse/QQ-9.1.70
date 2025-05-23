package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StUser extends MessageMicro<CertifiedAccountMeta$StUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 106, 114, 120}, new String[]{"id", "nick", "icon", "desc", "followState", "type", "email", "telNum", "attr", "youZhan", "yzOrderPage", "registerCertifiedAccountUrl", "personInfo", "iconInfo", "certifiedType"}, new Object[]{"", "", "", "", 0, 0, "", "", 0L, null, "", "", null, null, 0}, CertifiedAccountMeta$StUser.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24929id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField email = PBField.initString("");
    public final PBStringField telNum = PBField.initString("");
    public final PBUInt64Field attr = PBField.initUInt64(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StYouZanShop> youZhan = PBField.initRepeatMessage(CertifiedAccountMeta$StYouZanShop.class);
    public final PBStringField yzOrderPage = PBField.initString("");
    public final PBStringField registerCertifiedAccountUrl = PBField.initString("");
    public CertifiedAccountMeta$StPersonInfo personInfo = new CertifiedAccountMeta$StPersonInfo();
    public CertifiedAccountMeta$StIconInfo iconInfo = new CertifiedAccountMeta$StIconInfo();
    public final PBUInt32Field certifiedType = PBField.initUInt32(0);
}
