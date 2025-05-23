package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class STORE_APP_CLIENT$StGetGuessYouLikeRsp extends MessageMicro<STORE_APP_CLIENT$StGetGuessYouLikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "appList", "isFinish"}, new Object[]{null, null, 0}, STORE_APP_CLIENT$StGetGuessYouLikeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<STORE_APP_CLIENT$StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT$StoreAppInfo.class);
    public final PBInt32Field isFinish = PBField.initInt32(0);
}
