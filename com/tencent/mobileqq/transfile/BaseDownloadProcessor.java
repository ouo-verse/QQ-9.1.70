package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ipv6.IpStrategy;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class BaseDownloadProcessor extends BaseTransProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final boolean IS_MAIN_PROCESS;
    public static final String PTT_VIDEO_DOWNLOAD_DOMAIN = "grouptalk.c2c.qq.com";
    public static final boolean S_CAN_PRINT_URL = true;
    private static int mPicDownloadPort;
    private static boolean sPicDownloadPortInited;
    protected boolean mDirectMsgUrlDown;
    public ArrayList<com.tencent.mobileqq.pic.c> mDownCallBacks;
    String mDownDomain;
    public boolean mHasIpv6List;
    ArrayList<ServerAddr> mIpList;
    protected IpStrategy mIpStrategy;
    public boolean mIpv6First;
    protected boolean mIsHttpsDownload;
    int mLastProgress;
    protected int mNetType;
    long mRecvLen;
    int mReqUrlCount;
    String mRespUrl;
    String mStorageSource;
    protected boolean mSupportAvifDown;
    protected OldEngineDPCProfile mTimeoutProfile;
    long mTotolLen;
    String mUrlPath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        boolean z16 = false;
        sPicDownloadPortInited = false;
        mPicDownloadPort = 80;
        if (MobileQQ.sProcessId == 1) {
            z16 = true;
        }
        IS_MAIN_PROCESS = z16;
    }

    public BaseDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mIpList = new ArrayList<>();
        this.mReqUrlCount = 0;
        this.mTotolLen = 0L;
        this.mRecvLen = 0L;
        this.mRespUrl = null;
        this.mStorageSource = null;
        this.mDownCallBacks = new ArrayList<>();
        this.mDirectMsgUrlDown = false;
        this.mSupportAvifDown = true;
        this.mLastProgress = 0;
        if (transferRequest.mDownCallBack != null) {
            synchronized (this) {
                this.mDownCallBacks.add(transferRequest.mDownCallBack);
            }
        }
        this.mTimeoutProfile = BaseTransProcessorStaticVariable.TIMEOUT_PROFILE;
        this.mIpStrategy = IpStrategyFactory.createDownStrategy();
        this.mNetType = NetConnInfoCenter.getActiveNetIpFamily(true);
    }

    public static byte[] bytesFromHexString(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[str.length() / 2];
            char[] charArray = str.toCharArray();
            for (int i3 = 0; i3 < charArray.length; i3 += 2) {
                StringBuilder sb5 = new StringBuilder(2);
                sb5.append(charArray[i3]);
                sb5.append(charArray[i3 + 1]);
                bArr[i3 / 2] = (byte) Integer.parseInt(sb5.toString(), 16);
            }
            return bArr;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG", 2, "bytesFromHexString Exception=" + e16.getMessage());
            }
            return null;
        }
    }

    public static int getPicDownloadPort() {
        if (!sPicDownloadPortInited) {
            try {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
                if (QLog.isColorLevel()) {
                    QLog.d(BaseTransProcessor.TAG, 2, "getPicDownloadPort:" + featureValue);
                }
                String[] split = featureValue.split("\\|");
                if (split.length > 9) {
                    mPicDownloadPort = Integer.valueOf(split[9]).intValue();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(BaseTransProcessor.TAG, 2, "getPicDownloadPort e:" + e16.toString());
                }
            }
            sPicDownloadPortInited = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(BaseTransProcessor.TAG, 2, "getPicDownloadPort return " + mPicDownloadPort);
        }
        return mPicDownloadPort;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void accountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "transfileController destroy", null, null);
        onError();
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG", 2, "accountChanged transfileController destroy");
        }
        super.accountChanged();
    }

    public void addDownCallback(com.tencent.mobileqq.pic.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar);
        } else {
            synchronized (this) {
                this.mDownCallBacks.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getMd5InBytesOfGroup(String str, String str2) {
        byte[] bArr;
        if (str != null && str.length() == 32) {
            bArr = bytesFromHexString(str);
        } else {
            bArr = null;
        }
        if (bArr == null && str2 != null) {
            int indexOf = str2.indexOf(".");
            if (indexOf > 0) {
                str2 = str2.substring(0, indexOf);
            }
            if (str2.length() == 32) {
                return bytesFromHexString(str2);
            }
            if (str2.length() == 38) {
                String replace = str2.substring(1, 37).replace("-", "");
                if (replace.length() == 32) {
                    return bytesFromHexString(replace);
                }
                return bArr;
            }
            if (str2.length() == 34) {
                String substring = str2.substring(1, 33);
                if (substring.length() == 32) {
                    return bytesFromHexString(substring);
                }
                return bArr;
            }
            return bArr;
        }
        return bArr;
    }

    public void removeDownCallBack(com.tencent.mobileqq.pic.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            return;
        }
        synchronized (this) {
            ArrayList<com.tencent.mobileqq.pic.c> arrayList = this.mDownCallBacks;
            if (arrayList != null) {
                arrayList.remove(cVar);
            }
        }
    }

    public void reportForIpv6(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (this.mIpv6First) {
            this.mProcessorReport.mReportInfo.put(TransReport.rep_is_ipv6, String.valueOf(1));
        }
        this.mProcessorReport.mReportInfo.put(TransReport.rep_has_ipv6_list, String.valueOf(this.mHasIpv6List ? 1 : 0));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_ipv6_first, String.valueOf(this.mIpv6First ? 1 : 0));
        this.mProcessorReport.reportForIpv6(z16, j3, false, getReportTAG());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportForServerMonitor(NetResp netResp, boolean z16, String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, netResp, Boolean.valueOf(z16), str, str2);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq) && ((HttpNetReq) netReq).mReqUrl != null) {
            String str4 = ((HttpNetReq) netReq).mReqUrl;
            this.mRSMReporter.mUrl = str4;
            try {
                URL url = new URL(str4);
                String host = url.getHost();
                int port = url.getPort();
                RMServMonitorReport rMServMonitorReport = this.mRSMReporter;
                rMServMonitorReport.mServerIp = host;
                rMServMonitorReport.mServerPort = String.valueOf(port);
                this.mRSMReporter.mHttpErrCode = netResp.mHttpCode + "";
                RMServMonitorReport rMServMonitorReport2 = this.mRSMReporter;
                rMServMonitorReport2.mMD5 = this.mUiRequest.mMd5;
                rMServMonitorReport2.mUUID = str2;
                rMServMonitorReport2.mFailCode = String.valueOf(netResp.mErrCode);
                this.mRSMReporter.mErrDesc = netResp.mErrDesc;
                if (netResp.mErrCode == -9527) {
                    str3 = netResp.mRespProperties.get(NetResp.KEY_REASON);
                } else {
                    str3 = null;
                }
                RMServMonitorReport rMServMonitorReport3 = this.mRSMReporter;
                rMServMonitorReport3.mReason = str3;
                ProcessorReport processorReport = this.mProcessorReport;
                String str5 = processorReport.reason;
                String str6 = processorReport.errDesc;
                TransferRequest transferRequest = this.mUiRequest;
                rMServMonitorReport3.doReportForServerMonitor(str, z16, str5, str6, transferRequest.mUinType, transferRequest.mPeerUin, false, processorReport.mStepTrans);
            } catch (Throwable th5) {
                QLog.e(BaseTransProcessor.TAG, 1, "reportForServerMonitor err.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<ServerAddr> selectIpList(ArrayList<ServerAddr> arrayList, ArrayList<ServerAddr> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? selectIpList(arrayList, arrayList2, null) : (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList, (Object) arrayList2);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this) {
            FileMsg fileMsg = this.file;
            if (fileMsg != null) {
                fileMsg.status = 2001;
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG", 2, "start ");
                }
            }
        }
        super.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<ServerAddr> selectIpList(ArrayList<ServerAddr> arrayList, ArrayList<ServerAddr> arrayList2, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, this, arrayList, arrayList2, str);
        }
        this.mHasIpv6List = false;
        this.mIpv6First = false;
        if (arrayList != null && arrayList.size() > 0) {
            this.mHasIpv6List = true;
        }
        ArrayList<ServerAddr> selectIpList = this.mIpStrategy.selectIpList(arrayList, arrayList2, this.mNetType);
        if (selectIpList != null && selectIpList.size() > 0) {
            ServerAddr serverAddr = selectIpList.get(0);
            if (serverAddr != null && serverAddr.isIpv6) {
                this.mIpv6First = true;
            }
        } else if (!TextUtils.isEmpty(str)) {
            QLog.i(BaseTransProcessor.TAG, 1, "selectIpList, result is empty, use spare domain, domain=" + str);
            TransFileUtil.addDomainToList(selectIpList, str);
        }
        return selectIpList;
    }

    public BaseDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mIpList = new ArrayList<>();
        this.mReqUrlCount = 0;
        this.mTotolLen = 0L;
        this.mRecvLen = 0L;
        this.mRespUrl = null;
        this.mStorageSource = null;
        this.mDownCallBacks = new ArrayList<>();
        this.mDirectMsgUrlDown = false;
        this.mSupportAvifDown = true;
        this.mLastProgress = 0;
    }
}
