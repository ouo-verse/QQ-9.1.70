package NS_STORE_APP_SEARCH;

import NS_COMM.COMM;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StoreAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$StSearchAppRsp extends MessageMicro<MiniAppSearch$StSearchAppRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"extInfo", "appList", "isFinished", "highlightWords", "searchExtInfo", "rcmdList"}, new Object[]{null, null, 0, "", null, null}, MiniAppSearch$StSearchAppRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<STORE_APP_CLIENT$StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT$StoreAppInfo.class);
    public final PBInt32Field isFinished = PBField.initInt32(0);
    public final PBRepeatField<String> highlightWords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<MiniAppSearch$SearchExtInfo> searchExtInfo = PBField.initRepeatMessage(MiniAppSearch$SearchExtInfo.class);
    public final PBRepeatMessageField<STORE_APP_CLIENT$StoreAppInfo> rcmdList = PBField.initRepeatMessage(STORE_APP_CLIENT$StoreAppInfo.class);
}
