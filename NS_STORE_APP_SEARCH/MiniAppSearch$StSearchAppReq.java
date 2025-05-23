package NS_STORE_APP_SEARCH;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$StSearchAppReq extends MessageMicro<MiniAppSearch$StSearchAppReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "query", "appType", "from"}, new Object[]{null, "", 0, 1}, MiniAppSearch$StSearchAppReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField query = PBField.initString("");
    public final PBEnumField appType = PBField.initEnum(0);
    public final PBEnumField from = PBField.initEnum(1);
}
