package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppStore$StGetMyAppListByTypeReq extends MessageMicro<MiniAppStore$StGetMyAppListByTypeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"extInfo", "uiAppType", "uiListType"}, new Object[]{null, 0, 0}, MiniAppStore$StGetMyAppListByTypeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field uiAppType = PBField.initUInt32(0);
    public final PBUInt32Field uiListType = PBField.initUInt32(0);
}
