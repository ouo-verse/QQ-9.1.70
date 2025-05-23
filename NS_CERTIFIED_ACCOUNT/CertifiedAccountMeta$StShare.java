package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StShare extends MessageMicro<CertifiedAccountMeta$StShare> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"title", "desc", "type", "url", "author", QAdVrReport.ElementID.AD_POSTER, "cover", "video", "shorturl", "shareCardInfo", "shareQzoneInfo"}, new Object[]{"", "", 0, "", null, null, null, null, "", "", null}, CertifiedAccountMeta$StShare.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public CertifiedAccountMeta$StUser author = new CertifiedAccountMeta$StUser();
    public CertifiedAccountMeta$StUser poster = new CertifiedAccountMeta$StUser();
    public CertifiedAccountMeta$StImage cover = new CertifiedAccountMeta$StImage();
    public CertifiedAccountMeta$StVideo video = new CertifiedAccountMeta$StVideo();
    public final PBStringField shorturl = PBField.initString("");
    public final PBStringField shareCardInfo = PBField.initString("");
    public CertifiedAccountMeta$StShareQzoneInfo shareQzoneInfo = new CertifiedAccountMeta$StShareQzoneInfo();
}
