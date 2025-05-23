package com.tenpay.sdk.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import com.tenpay.api.QFuncProxy;
import com.tenpay.proxy.DataProxy;
import com.tenpay.util.MD5;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetBean {
    public static long mTLSEndTime;
    public String mCgiName;
    public String mConnectProtocol;
    public String mErrorCode;
    public String mInnerIp;
    public boolean mIsUserInnerDns;
    public String mMd5;
    public String mMsgNo;
    public String mNetworkType;
    public String mServerActionTime;
    public String mServerIp;
    public String mServerRequestTime;
    public String mServerReuseSession;
    public String mServerTcpTimes;
    public String mTLSHandshakeTime;
    public String mUin;
    public String mUrl;
    final int REQ_ID_LOG_UPLOAD = 11;
    public long mConnectBeginTime = 0;
    public long mConnectEndTime = 0;
    public long mReceiveFirstTime = 0;
    public long mReceiveAllTime = 0;

    private String parseCgiName(String str) {
        try {
            String substring = str.substring(0, str.indexOf(".cgi?"));
            return substring.substring(substring.lastIndexOf(47) + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public String getMsgNo(String str) {
        String msgNo = QFuncProxy.getMsgNo(str);
        this.mMsgNo = msgNo;
        return msgNo;
    }

    public void init(String str, String str2, String str3) {
        this.mUrl = str2;
        this.mUin = str;
        this.mNetworkType = str3;
        this.mConnectBeginTime = 0L;
        this.mConnectEndTime = 0L;
        this.mReceiveFirstTime = 0L;
        this.mReceiveAllTime = 0L;
        this.mErrorCode = null;
        this.mServerIp = null;
        this.mConnectProtocol = null;
        this.mTLSHandshakeTime = null;
        this.mServerRequestTime = null;
        this.mServerActionTime = null;
        this.mServerTcpTimes = null;
        this.mServerReuseSession = null;
        this.mIsUserInnerDns = false;
        this.mCgiName = parseCgiName(str2);
        this.mMd5 = MD5.hexdigest(str2);
    }

    public void logUpload() {
        if (!TextUtils.isEmpty(this.mServerIp) && this.mServerIp.startsWith("/")) {
            this.mServerIp = this.mServerIp.substring(1);
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", this.mUin);
        bundle.putString("co", String.valueOf(this.mConnectEndTime - this.mConnectBeginTime));
        bundle.putString("wt", String.valueOf(this.mReceiveFirstTime - this.mConnectBeginTime));
        bundle.putString("rc", String.valueOf(this.mReceiveAllTime - this.mReceiveFirstTime));
        bundle.putString("dip", this.mServerIp);
        bundle.putString(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN, this.mMsgNo);
        bundle.putString("ec", this.mErrorCode);
        bundle.putString("cgi", this.mCgiName);
        bundle.putString("r5", this.mMd5);
        bundle.putString(StartupSessionConstant.KNTMODULENAME, this.mNetworkType);
        if (!TextUtils.isEmpty(this.mConnectProtocol)) {
            bundle.putString("cp", this.mConnectProtocol);
        }
        if (!TextUtils.isEmpty(this.mTLSHandshakeTime)) {
            bundle.putString("th", this.mTLSHandshakeTime);
        }
        DataProxy.logUpload(bundle);
    }
}
