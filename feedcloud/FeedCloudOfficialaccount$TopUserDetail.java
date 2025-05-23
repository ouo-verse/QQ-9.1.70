package feedcloud;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudOfficialaccount$TopUserDetail extends MessageMicro<FeedCloudOfficialaccount$TopUserDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"uin", "nick", QCircleSchemeAttr.Detail.AVATAR_URL, "show_aperture"}, new Object[]{"", "", "", Boolean.FALSE}, FeedCloudOfficialaccount$TopUserDetail.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar_url = PBField.initString("");
    public final PBBoolField show_aperture = PBField.initBool(false);
}
