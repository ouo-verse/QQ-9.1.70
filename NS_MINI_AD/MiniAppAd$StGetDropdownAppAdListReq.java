package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.superplayer.report.SPReportHelper;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetDropdownAppAdListReq extends MessageMicro<MiniAppAd$StGetDropdownAppAdListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64}, new String[]{"extInfo", "user_info", "position_info", "device_info", "context_info", SPReportHelper.KEY_DEBUG_INFO, "gdt_cookie", "support_https"}, new Object[]{null, null, null, null, null, null, "", Boolean.FALSE}, MiniAppAd$StGetDropdownAppAdListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public MiniAppAd$UserInfo user_info = new MiniAppAd$UserInfo();
    public final PBRepeatMessageField<MiniAppAd$PositionInfo> position_info = PBField.initRepeatMessage(MiniAppAd$PositionInfo.class);
    public MiniAppAd$DeviceInfo device_info = new MiniAppAd$DeviceInfo();
    public MiniAppAd$ContextInfo context_info = new MiniAppAd$ContextInfo();
    public MiniAppAd$DebugInfo debug_info = new MiniAppAd$DebugInfo();
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBBoolField support_https = PBField.initBool(false);
}
