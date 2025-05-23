package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StYouZanShop extends MessageMicro<CertifiedAccountMeta$StYouZanShop> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"type", "id", "name", QZoneDTLoginReporter.SCHEMA, "goodNum", "goods"}, new Object[]{0, "", "", "", 0, null}, CertifiedAccountMeta$StYouZanShop.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24930id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBUInt32Field goodNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StYouZanGood> goods = PBField.initRepeatMessage(CertifiedAccountMeta$StYouZanGood.class);
}
