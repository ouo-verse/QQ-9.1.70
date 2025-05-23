package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppStore$StGetRecommendCardDetailReq extends MessageMicro<MiniAppStore$StGetRecommendCardDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "strCardId"}, new Object[]{null, ""}, MiniAppStore$StGetRecommendCardDetailReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strCardId = PBField.initString("");
}
