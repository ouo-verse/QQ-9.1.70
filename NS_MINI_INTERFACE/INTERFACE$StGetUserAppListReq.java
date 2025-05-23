package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserAppListReq extends MessageMicro<INTERFACE$StGetUserAppListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"extInfo", "uin", WidgetCacheConstellationData.NUM, "source"}, new Object[]{null, 0L, 0L, 0}, INTERFACE$StGetUserAppListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field num = PBField.initUInt64(0);
    public final PBInt32Field source = PBField.initInt32(0);
}
