package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetDropdownAppListRsp extends MessageMicro<INTERFACE$StGetDropdownAppListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56, 64, 72, 82, 88, 98}, new String[]{"extInfo", "modules", "cacheLst", "showStore", "showUserAppList", "fixApps", "isFinished", "freshInternal", "realRecommdInternal", "searchInfo", "useOld", "operationApp"}, new Object[]{null, null, null, 0, 0, null, 0, 0, 0, null, 0, null}, INTERFACE$StGetDropdownAppListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StModuleInfo> modules = PBField.initRepeatMessage(INTERFACE$StModuleInfo.class);
    public final PBRepeatMessageField<INTERFACE$StCacheController> cacheLst = PBField.initRepeatMessage(INTERFACE$StCacheController.class);
    public final PBInt32Field showStore = PBField.initInt32(0);
    public final PBInt32Field showUserAppList = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE$StUserAppInfo> fixApps = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
    public final PBInt32Field isFinished = PBField.initInt32(0);
    public final PBInt32Field freshInternal = PBField.initInt32(0);
    public final PBInt32Field realRecommdInternal = PBField.initInt32(0);
    public INTERFACE$StSearchModuleInfo searchInfo = new INTERFACE$StSearchModuleInfo();
    public final PBInt32Field useOld = PBField.initInt32(0);
    public INTERFACE$StOperationApp operationApp = new MessageMicro<INTERFACE$StOperationApp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StOperationApp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app", "name", "icon", "nightIcon"}, new Object[]{null, "", "", ""}, INTERFACE$StOperationApp.class);
        public INTERFACE$StUserAppInfo app = new INTERFACE$StUserAppInfo();
        public final PBStringField name = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
        public final PBStringField nightIcon = PBField.initString("");
    };
}
