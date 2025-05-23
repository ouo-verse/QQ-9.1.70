package com.tencent.mobileqq.transfile.report;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.StepInfo;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes19.dex */
public class ProcessorReport {
    static IPatchRedirector $redirector_;
    public static ConcurrentHashMap<String, Integer> sReportMap;
    public int errCode;
    public String errDesc;
    public long mEndTime;
    public boolean mIsOldDbRec;
    public HashMap<String, String> mReportInfo;
    public int mReportedFlag;
    public boolean mSendByQuickHttp;
    public long mStartTime;
    public StepInfo mStepDirectDown;
    public StepInfo mStepMsg;
    public StepInfo mStepTrans;
    public StepInfo mStepUrl;
    public String reason;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42224);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            sReportMap = new ConcurrentHashMap<>();
        }
    }

    public ProcessorReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mReportInfo = new HashMap<>();
        this.errCode = 9001;
        this.reason = "";
        this.errDesc = "";
        this.mIsOldDbRec = false;
        this.mReportedFlag = 0;
        this.mSendByQuickHttp = false;
        this.mStepUrl = new StepInfo();
        this.mStepTrans = new StepInfo();
        this.mStepMsg = new StepInfo();
        this.mStepDirectDown = new StepInfo();
    }

    public static boolean adjustErrorCode(int i3, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return true;
        }
        if (i3 != -9530 && i3 != -9532 && i3 != -9533 && i3 != -9531) {
            if (i3 != -9528 && i3 != -9529) {
                return false;
            }
            hashMap.put(ReportConstant.KEY_REASON, getServerReason("P", i3));
            hashMap.put("param_FailCode", Integer.toString(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE));
            return true;
        }
        hashMap.put(ReportConstant.KEY_REASON, getServerReason(AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, i3));
        hashMap.put("param_FailCode", Integer.toString(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE));
        return true;
    }

    public static String getClientReason(String str) {
        return "C_" + str;
    }

    public static String getExceptionMessage(Exception exc) {
        if (exc == null) {
            return "Exception e is null";
        }
        String message = exc.getMessage();
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace != null) {
            StringBuilder sb5 = new StringBuilder(":");
            int length = stackTrace.length;
            if (length > 8) {
                length = 8;
            }
            sb5.append("\n");
            for (int i3 = 0; i3 < length; i3++) {
                sb5.append(stackTrace[i3].toString());
                sb5.append("\n");
            }
            return exc.toString() + sb5.toString();
        }
        return message;
    }

    public static String getHttpCmdReason(int i3, long j3) {
        return "S_" + i3 + "_" + j3;
    }

    public static String getHttpDataReason(int i3, long j3) {
        return "H_" + i3 + "_" + j3;
    }

    public static String getMsgReason(long j3) {
        return "M_" + j3;
    }

    public static String getServerReason(String str, long j3) {
        return str + "_" + j3;
    }

    public static String getUrlReason(long j3) {
        return "T_" + j3;
    }

    public void copyRespCommon(StepInfo stepInfo, RichProto.RichProtoResp.RespCommon respCommon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) stepInfo, (Object) respCommon);
            return;
        }
        if (stepInfo != null && respCommon != null) {
            stepInfo.logFinishTime();
            stepInfo.successTryCount = respCommon.successCount;
            stepInfo.failTryCount = respCommon.failCount;
            if (respCommon.result == 0) {
                stepInfo.result = 1;
            } else {
                stepInfo.result = 0;
                setError(respCommon.errCode, respCommon.errStr, respCommon.reason, stepInfo);
            }
        }
    }

    public void copyStaticsInfoFromNetResp(StepInfo stepInfo, NetResp netResp, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, stepInfo, netResp, Boolean.valueOf(z16));
            return;
        }
        if (stepInfo != null && netResp != null) {
            this.mReportInfo.put(ReportConstant.KEY_OLD_SERVER_IP, netResp.mRespProperties.get("serverip"));
            if (z16) {
                this.mReportInfo.put("serverip", netResp.mRespProperties.get("serverip"));
                stepInfo.successTryCount++;
                stepInfo.failTryCount += netResp.mTryTime - 1;
                stepInfo.logFinishTime();
                stepInfo.result = 1;
                this.mReportInfo.remove("param_url");
                this.mReportInfo.remove("param_rspHeader");
                return;
            }
            this.mReportInfo.put("serverip", netResp.mRespProperties.get(NetResp.KEY_FIRST_USE_IP));
            stepInfo.failTryCount += netResp.mTryTime;
            if (netResp.mErrCode == -9527) {
                str = netResp.mRespProperties.get(NetResp.KEY_REASON);
            } else {
                str = null;
            }
            setError(netResp.mErrCode, netResp.mErrDesc, str, stepInfo);
            this.mReportInfo.put("param_url", netResp.mRespProperties.get("param_url"));
            this.mReportInfo.put("param_rspHeader", netResp.mRespProperties.get("param_rspHeader"));
            if (netResp.mErrCode == -9527 && "H_404_-124".equals(str)) {
                this.mReportInfo.put("param_reqHeader", netResp.mRespProperties.get("param_reqHeader"));
            }
            stepInfo.result = 0;
        }
    }

    public void copyStatisInfo(StepInfo stepInfo, boolean z16, boolean z17, StatictisInfo statictisInfo) {
        int i3;
        int i16;
        String str;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, stepInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), statictisInfo);
            return;
        }
        if (statictisInfo == null) {
            return;
        }
        stepInfo.logFinishTime();
        if (z17) {
            stepInfo.failTryCount = statictisInfo.retryCount - 1;
            stepInfo.successTryCount = 1;
            stepInfo.result = 1;
            return;
        }
        int i18 = statictisInfo.errCode;
        if (i18 == 2900) {
            if (!z16) {
                str = getMsgReason(statictisInfo.detailErrorReason);
            } else {
                str = getUrlReason(statictisInfo.detailErrorReason);
            }
            i16 = AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE;
        } else if (i18 != 1002 && i18 != 1013) {
            if (!z16) {
                i17 = AppConstants.RichMediaErrorCode.ERROR_MSG_MSF_ERROR;
            } else {
                i17 = AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR;
            }
            i16 = i17;
            str = statictisInfo.timeoutReason;
        } else {
            if (!z16) {
                i3 = AppConstants.RichMediaErrorCode.ERROR_MSG_TIMEOUT;
            } else {
                i3 = AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT;
            }
            i16 = i3;
            str = statictisInfo.timeoutReason;
        }
        setError(i16, "", str, stepInfo);
        stepInfo.failTryCount = statictisInfo.retryCount;
        stepInfo.successTryCount = 0;
        stepInfo.result = 0;
    }

    public void reportForIpv6(boolean z16, long j3, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), str);
            return;
        }
        this.mReportInfo.put(ReportConstant.KEY_NET_IP_TYPE, String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
        this.mReportInfo.put(ReportConstant.KEY_MSFCONN_IP_TPYE, String.valueOf(MsfServiceSdk.get().getConnectedIPFamily()));
        if (z17) {
            this.mReportInfo.put(ReportConstant.KEY_IPV6POLICY, String.valueOf(Ipv6Config.getFlags().mBdhStrategy));
        } else {
            this.mReportInfo.put(ReportConstant.KEY_IPV6POLICY, String.valueOf(Ipv6Config.getFlags().mRMDownStrategy));
        }
        if (this.mReportInfo.get(TransReport.rep_is_ipv6) != null && this.mReportInfo.get(TransReport.rep_is_ipv6).equals(String.valueOf(1))) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str + "_ipv6", z16, j3, 0L, this.mReportInfo, "");
        }
    }

    public void setError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setError(i3, str, null, null);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
    }

    public void setError(int i3, String str, String str2, StepInfo stepInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, stepInfo);
            return;
        }
        this.errCode = i3;
        this.errDesc = str;
        if (str2 != null && !"".equals(str2)) {
            this.mReportInfo.put(ReportConstant.KEY_REASON, str2);
        }
        if (stepInfo != null) {
            stepInfo.logFinishTime();
            stepInfo.result = 0;
        }
    }
}
