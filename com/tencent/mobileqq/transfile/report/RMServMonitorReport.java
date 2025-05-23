package com.tencent.mobileqq.transfile.report;

import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.StepInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RMServMonitorReport {
    static IPatchRedirector $redirector_ = null;
    public static final String REPORT_NAME_NM_PICDOWN = "actRichMediaNetMonitor_picDown";
    public static final String REPORT_NAME_NM_PICUP = "actRichMediaNetMonitor_picUp";
    public static final String REPORT_NAME_NM_PTTDOWN = "actRichMediaNetMonitor_pttDown";
    public static final String REPORT_NAME_NM_PTTUP = "actRichMediaNetMonitor_pttUp";
    public static final String REPORT_NAME_NM_VIDEODOWN = "actRichMediaNetMonitor_videoDown";
    public static final String REPORT_NAME_NM_VIDEOUP = "actRichMediaNetMonitor_videoUp";
    private static final String TAG = "RMServMonitorReport";
    public static final int VALUE_IP_TYPE_DOMAIN = 3;
    public static final int VALUE_IP_TYPE_IPV4 = 1;
    public static final int VALUE_IP_TYPE_IPV6 = 2;
    private ArrayList<String> failIpReported;
    public String mBusiType;
    public String mChatType;
    public String mChatUin;
    public String mConnCost;
    public String mErrDesc;
    public String mFailCode;
    public long mFileSize;
    public String mHttpErrCode;
    public int mIPPolicy;
    public int mIPStackType;
    public int mIpType;
    public boolean mIsHttps;
    private boolean mIsSuccess;
    public String mMD5;
    public int mMSFConnIpType;
    public String mReason;
    public String mServerIp;
    public String mServerPort;
    public long mTimeCost;
    public String mUUID;
    public String mUrl;

    public RMServMonitorReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.failIpReported = new ArrayList<>();
        this.mServerIp = "";
        this.mServerPort = "";
        this.mFailCode = "";
        this.mReason = "";
        this.mErrDesc = "";
        this.mChatType = "";
        this.mChatUin = "";
        this.mUrl = "";
        this.mHttpErrCode = "";
        this.mMD5 = "";
        this.mUUID = "";
        this.mBusiType = "";
    }

    private HashMap<String, String> buildReportInfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("isSuccess", String.valueOf(this.mIsSuccess));
        hashMap.put("server_ip", this.mServerIp);
        hashMap.put("server_port", this.mServerPort);
        hashMap.put("param_FailCode", this.mFailCode);
        hashMap.put(ReportConstant.KEY_REASON, this.mReason);
        hashMap.put(ReportConstant.KEY_ERR_DESC, this.mErrDesc);
        hashMap.put("chatType", this.mChatType);
        hashMap.put("chatUin", this.mChatUin);
        hashMap.put("file_url", this.mUrl);
        hashMap.put("http_errorCode", this.mHttpErrCode);
        hashMap.put("md5", this.mMD5);
        hashMap.put("uuid", this.mUUID);
        hashMap.put("business_type", this.mBusiType);
        hashMap.put(ReportConstant.KEY_TIME_COST, String.valueOf(this.mTimeCost));
        hashMap.put(MediaDBValues.FILESIZE, String.valueOf(this.mFileSize));
        hashMap.put(ReportConstant.KEY_IPV6POLICY, String.valueOf(this.mIPPolicy));
        hashMap.put(ReportConstant.KEY_MSFCONN_IP_TPYE, String.valueOf(this.mMSFConnIpType));
        hashMap.put(ReportConstant.KEY_NET_IP_TYPE, String.valueOf(this.mIPStackType));
        hashMap.put(TransReport.rep_ip_type, String.valueOf(this.mIpType));
        hashMap.put(ReportConstant.KEY_IS_HTTPS, String.valueOf(this.mIsHttps ? 1 : 0));
        hashMap.put(TransReport.rep_Ip_ConnCost, this.mConnCost);
        return hashMap;
    }

    private void realReport(String str, HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, this.mIsSuccess, this.mTimeCost, this.mFileSize, hashMap, "");
        String str2 = "null";
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("report , reportName = ");
            sb5.append(str);
            sb5.append(", mServerIp = ");
            String str3 = this.mServerIp;
            if (str3 == null) {
                str3 = "null";
            }
            sb5.append(str3);
            sb5.append(" , mTimeCost = ");
            sb5.append(this.mTimeCost);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (this.mIpType == 2) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str + "_ipv6", this.mIsSuccess, this.mTimeCost, this.mFileSize, hashMap, "");
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("report , reportName = ");
                sb6.append(str);
                sb6.append("_ipv6, mServerIp = ");
                String str4 = this.mServerIp;
                if (str4 != null) {
                    str2 = str4;
                }
                sb6.append(str2);
                sb6.append(" , mTimeCost = ");
                sb6.append(this.mTimeCost);
                QLog.d(TAG, 2, sb6.toString());
            }
        }
    }

    private void setCommonParams() {
        this.mIPStackType = NetConnInfoCenter.getActiveNetIpFamily(true);
        this.mMSFConnIpType = MsfServiceSdk.get().getConnectedIPFamily();
        this.mIpType = getIpType(this.mServerIp);
    }

    public void doReport(String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
            return;
        }
        if (!z16 && (str2 = this.mServerIp) != null) {
            if (this.failIpReported.contains(str2)) {
                return;
            } else {
                this.failIpReported.add(this.mServerIp);
            }
        }
        this.mIsSuccess = z16;
        setCommonParams();
        realReport(str, buildReportInfo());
    }

    public void doReportForServerMonitor(String str, boolean z16, String str2, String str3, int i3, String str4, boolean z17, StepInfo stepInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), str2, str3, Integer.valueOf(i3), str4, Boolean.valueOf(z17), stepInfo);
            return;
        }
        if (this.mReason == null) {
            this.mReason = str2;
        }
        if (this.mErrDesc == null) {
            this.mErrDesc = str3;
        }
        this.mChatType = i3 + "";
        this.mChatUin = str4 + "";
        if (z17) {
            this.mIPPolicy = Ipv6Config.getFlags().mBdhStrategy;
        } else {
            this.mIPPolicy = Ipv6Config.getFlags().mRMDownStrategy;
        }
        if (stepInfo != null && stepInfo.startTime > 0) {
            this.mTimeCost = (System.nanoTime() - stepInfo.startTime) / 1000000;
        }
        doReport(str, z16);
    }

    protected int getIpType(String str) {
        String replaceAll;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        if (str != null && (replaceAll = str.replaceAll("[\\[\\]]", "")) != null) {
            if (IPAddressUtil.isIPv6LiteralAddress(replaceAll)) {
                return 2;
            }
            if (IPAddressUtil.isIPv4LiteralAddress(replaceAll)) {
                return 1;
            }
        }
        return 3;
    }
}
