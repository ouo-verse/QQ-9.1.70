package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc04171 implements LpReportInfo {
    public String mBytesRefer;
    public String mChatId;
    public int mMsgFrom;
    public int mMsgType;
    public String mPlatform;
    public String mSenderUin;
    public String mUrl;
    public String mAppid = "";
    public String mSubAppid = "";
    public String mGuid = "";
    public String mQQPfTo = "";

    public LpReportInfo_dc04171(String str, String str2, String str3, int i3, int i16, String str4, String str5) {
        this.mUrl = str;
        this.mBytesRefer = str2;
        this.mPlatform = str3;
        this.mMsgType = i3;
        this.mMsgFrom = i16;
        this.mSenderUin = str4;
        this.mChatId = str5;
    }

    public static void report(String str, String str2, String str3, int i3, int i16, String str4, String str5) {
        LpReportManager.getInstance().reportToDC04171(new LpReportInfo_dc04171(str, str2, str3, i3, i16, str4, str5), false, false);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc041171:" + this.mUrl + "," + this.mBytesRefer + "," + this.mPlatform;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        LpReportUtils.safePut(hashMap, "uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        LpReportUtils.safePut(hashMap, "appid", this.mAppid);
        LpReportUtils.safePut(hashMap, "subappid", this.mSubAppid);
        LpReportUtils.safePut(hashMap, "os_type", "Android");
        LpReportUtils.safePut(hashMap, "app_name", "QQ");
        LpReportUtils.safePut(hashMap, "device_name", DeviceInfoMonitor.getModel());
        LpReportUtils.safePut(hashMap, "imei", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getIMEI());
        LpReportUtils.safePut(hashMap, "guid", this.mGuid);
        LpReportUtils.safePut(hashMap, "url", this.mUrl);
        LpReportUtils.safePut(hashMap, "qq_pf_to", this.mQQPfTo);
        LpReportUtils.safePut(hashMap, "bytes_referer", this.mBytesRefer);
        LpReportUtils.safePut(hashMap, "plateform", this.mPlatform);
        LpReportUtils.safePut(hashMap, QQHealthReportApiImpl.MSG_TYPE_KEY, String.valueOf(this.mMsgType));
        LpReportUtils.safePut(hashMap, "msg_from", String.valueOf(this.mMsgFrom));
        LpReportUtils.safePut(hashMap, "send_uin", this.mSenderUin);
        LpReportUtils.safePut(hashMap, "msg_chatid", this.mChatId);
        return hashMap;
    }
}
