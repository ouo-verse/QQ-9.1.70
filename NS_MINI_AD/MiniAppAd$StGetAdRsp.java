package NS_MINI_AD;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetAdRsp extends MessageMicro<MiniAppAd$StGetAdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48}, new String[]{"extInfo", "strAdsJson", "strAdTemplateJson", "iTestId", "vecAppInfo", "iPreLoadLevel"}, new Object[]{null, "", "", 0L, null, 0L}, MiniAppAd$StGetAdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strAdsJson = PBField.initString("");
    public final PBStringField strAdTemplateJson = PBField.initString("");
    public final PBInt64Field iTestId = PBField.initInt64(0);
    public final PBRepeatMessageField<INTERFACE$StApiAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE$StApiAppInfo.class);
    public final PBInt64Field iPreLoadLevel = PBField.initInt64(0);
}
