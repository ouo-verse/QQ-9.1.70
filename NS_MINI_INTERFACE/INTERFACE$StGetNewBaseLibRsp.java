package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetNewBaseLibRsp extends MessageMicro<INTERFACE$StGetNewBaseLibRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "libInfo", WidgetCacheConstellationData.INTERVAL, "jsOrsoLibs"}, new Object[]{null, null, 0, null}, INTERFACE$StGetNewBaseLibRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE$StBaseLibInfo libInfo = new INTERFACE$StBaseLibInfo();
    public final PBInt32Field interval = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE$StBaseLibInfo> jsOrsoLibs = PBField.initRepeatMessage(INTERFACE$StBaseLibInfo.class);
}
