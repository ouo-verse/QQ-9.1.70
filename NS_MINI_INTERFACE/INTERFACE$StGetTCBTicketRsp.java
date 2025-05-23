package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetTCBTicketRsp extends MessageMicro<INTERFACE$StGetTCBTicketRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "ticket", WadlProxyConsts.CREATE_TIME, "period"}, new Object[]{null, "", 0, 0}, INTERFACE$StGetTCBTicketRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField ticket = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBUInt32Field period = PBField.initUInt32(0);
}
