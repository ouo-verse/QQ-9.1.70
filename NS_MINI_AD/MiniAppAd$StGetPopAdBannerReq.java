package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppAd$StGetPopAdBannerReq extends MessageMicro<MiniAppAd$StGetPopAdBannerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "strAppId", "strRefer"}, new Object[]{null, "", ""}, MiniAppAd$StGetPopAdBannerReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strAppId = PBField.initString("");
    public final PBStringField strRefer = PBField.initString("");
}
