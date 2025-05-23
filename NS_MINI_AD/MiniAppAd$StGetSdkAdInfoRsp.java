package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetSdkAdInfoRsp extends MessageMicro<MiniAppAd$StGetSdkAdInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "strSourceFrom", "strMiniCategory", "strPosId"}, new Object[]{null, "", "", ""}, MiniAppAd$StGetSdkAdInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strSourceFrom = PBField.initString("");
    public final PBStringField strMiniCategory = PBField.initString("");
    public final PBStringField strPosId = PBField.initString("");
}
