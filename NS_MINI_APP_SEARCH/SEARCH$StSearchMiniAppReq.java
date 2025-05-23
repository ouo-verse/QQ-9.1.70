package NS_MINI_APP_SEARCH;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SEARCH$StSearchMiniAppReq extends MessageMicro<SEARCH$StSearchMiniAppReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "query", "pageSize"}, new Object[]{null, "", 0}, SEARCH$StSearchMiniAppReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField query = PBField.initString("");
    public final PBInt32Field pageSize = PBField.initInt32(0);
}
