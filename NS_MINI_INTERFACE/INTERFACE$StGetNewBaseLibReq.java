package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetNewBaseLibReq extends MessageMicro<INTERFACE$StGetNewBaseLibReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "curVersion", "type"}, new Object[]{null, "", 0}, INTERFACE$StGetNewBaseLibReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField curVersion = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
}
