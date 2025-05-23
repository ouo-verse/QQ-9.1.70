package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetAdForSdkReq extends MessageMicro<MiniAppAd$StGetAdForSdkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"extInfo", "strGetAdUrl", "mapParam", "strAppid", "iAdType"}, new Object[]{null, "", null, "", 0}, MiniAppAd$StGetAdForSdkReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strGetAdUrl = PBField.initString("");
    public final PBRepeatMessageField<COMM.Entry> mapParam = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBStringField strAppid = PBField.initString("");
    public final PBInt32Field iAdType = PBField.initInt32(0);
}
