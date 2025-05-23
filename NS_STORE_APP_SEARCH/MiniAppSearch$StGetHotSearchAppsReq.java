package NS_STORE_APP_SEARCH;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$StGetHotSearchAppsReq extends MessageMicro<MiniAppSearch$StGetHotSearchAppsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "from"}, new Object[]{null, 1}, MiniAppSearch$StGetHotSearchAppsReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField from = PBField.initEnum(1);
}
