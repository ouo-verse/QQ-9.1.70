package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetDropdownAppAdListRsp extends MessageMicro<MiniAppAd$StGetDropdownAppAdListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "vecAppAdInfo", "gdt_cookie"}, new Object[]{null, null, ""}, MiniAppAd$StGetDropdownAppAdListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<MiniAppAd$StAppAdInfo> vecAppAdInfo = PBField.initRepeatMessage(MiniAppAd$StAppAdInfo.class);
    public final PBStringField gdt_cookie = PBField.initString("");
}
