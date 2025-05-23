package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetDropdownAppListReq extends MessageMicro<INTERFACE$StGetDropdownAppListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 66, 74}, new String[]{"extInfo", "oldRecommendList", "feiqi", "types", "hasCache", "deviceInfo", "subTypes", "itemIds", "tab_exp_id"}, new Object[]{null, null, 0, 0, 0, null, 0, "", ""}, INTERFACE$StGetDropdownAppListReq.class);
    public INTERFACE$DeviceInfo deviceInfo;
    public final PBInt32Field hasCache;
    public final PBRepeatField<String> itemIds;
    public final PBRepeatField<Integer> subTypes;
    public final PBStringField tab_exp_id;
    public final PBRepeatField<Integer> types;
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE$StRecommendApp.class);
    public final PBInt32Field feiqi = PBField.initInt32(0);

    public INTERFACE$StGetDropdownAppListReq() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.types = PBField.initRepeat(pBInt32Field);
        this.hasCache = PBField.initInt32(0);
        this.deviceInfo = new INTERFACE$DeviceInfo();
        this.subTypes = PBField.initRepeat(pBInt32Field);
        this.itemIds = PBField.initRepeat(PBStringField.__repeatHelper__);
        this.tab_exp_id = PBField.initString("");
    }
}
