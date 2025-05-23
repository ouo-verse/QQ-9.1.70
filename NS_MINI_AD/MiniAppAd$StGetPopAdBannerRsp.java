package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppAd$StGetPopAdBannerRsp extends MessageMicro<MiniAppAd$StGetPopAdBannerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"extInfo", "strAdTitle", "strImgUrl", "strJumpUrl", "strAdTrace"}, new Object[]{null, "", "", "", ""}, MiniAppAd$StGetPopAdBannerRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strAdTitle = PBField.initString("");
    public final PBStringField strImgUrl = PBField.initString("");
    public final PBStringField strJumpUrl = PBField.initString("");
    public final PBStringField strAdTrace = PBField.initString("");
}
