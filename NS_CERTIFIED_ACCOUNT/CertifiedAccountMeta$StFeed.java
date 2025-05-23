package NS_CERTIFIED_ACCOUNT;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StFeed extends MessageMicro<CertifiedAccountMeta$StFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 128, 136, 146, 152, 162, 170, 176, 186, 194}, new String[]{"id", "title", "subtitle", QAdVrReport.ElementID.AD_POSTER, "cover", "video", "content", "type", WadlProxyConsts.CREATE_TIME, "likeInfo", "commentCount", "vecComment", "share", "visitorInfo", "images", "status", "pushStatus", "poiInfo", "feedLevel", "adBuffer", "goods", "feedAttr", "ext", "live"}, new Object[]{"", "", "", null, null, null, "", 0, 0L, null, 0, null, null, null, null, 0, 0, null, 0, ByteStringMicro.EMPTY, null, 0L, "", null}, CertifiedAccountMeta$StFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24925id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public CertifiedAccountMeta$StUser poster = new CertifiedAccountMeta$StUser();
    public CertifiedAccountMeta$StImage cover = new CertifiedAccountMeta$StImage();
    public CertifiedAccountMeta$StVideo video = new CertifiedAccountMeta$StVideo();
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public CertifiedAccountMeta$StLike likeInfo = new CertifiedAccountMeta$StLike();
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StComment> vecComment = PBField.initRepeatMessage(CertifiedAccountMeta$StComment.class);
    public CertifiedAccountMeta$StShare share = new CertifiedAccountMeta$StShare();
    public CertifiedAccountMeta$StVisitor visitorInfo = new CertifiedAccountMeta$StVisitor();
    public final PBRepeatMessageField<CertifiedAccountMeta$StImage> images = PBField.initRepeatMessage(CertifiedAccountMeta$StImage.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field pushStatus = PBField.initUInt32(0);
    public CertifiedAccountMeta$StPoiInfoV2 poiInfo = new CertifiedAccountMeta$StPoiInfoV2();
    public final PBUInt32Field feedLevel = PBField.initUInt32(0);
    public final PBBytesField adBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CertifiedAccountMeta$StYouZanGood> goods = PBField.initRepeatMessage(CertifiedAccountMeta$StYouZanGood.class);
    public final PBUInt64Field feedAttr = PBField.initUInt64(0);
    public final PBStringField ext = PBField.initString("");
    public CertifiedAccountMeta$StLive live = new CertifiedAccountMeta$StLive();
}
