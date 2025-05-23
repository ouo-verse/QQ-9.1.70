package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetSdkAdInfoReq extends MessageMicro<MiniAppAd$StGetSdkAdInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "strSubPosId", "strAppid", "iAdType"}, new Object[]{null, "", "", 0}, MiniAppAd$StGetSdkAdInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strSubPosId = PBField.initString("");
    public final PBStringField strAppid = PBField.initString("");
    public final PBInt32Field iAdType = PBField.initInt32(0);
}
