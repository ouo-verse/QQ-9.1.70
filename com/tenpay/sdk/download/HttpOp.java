package com.tenpay.sdk.download;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.paynet.NetManager;
import com.tenpay.sdk.util.NetBean;
import com.tenpay.util.Utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class HttpOp {
    public static final int HTTP_CONNECTIONTIMEOUT = 30000;
    public static final int HTTP_CONNECTIONTIMEOUT_2G = 20000;
    public static final int HTTP_CONNECTIONTIMEOUT_3G = 10000;
    public static final int HTTP_CONNECTIONTIMEOUT_WIFI_4G = 6000;
    public static final String HTTP_DATA = "data";
    public static final int HTTP_READTIMEOUT = 45000;
    public static final int HTTP_READ_TIMEOUT_2G = 10000;
    public static final int HTTP_READ_TIMEOUT_3G = 8000;
    public static final int HTTP_READ_TIMEOUT_WIFI_4G = 4000;
    public static final String HTTP_STATUS = "status";
    public static final String HTTP_TMP_FNAME = "tfname";
    public static final String OP_CODE = "op_code";
    public static final int OP_FAILED = 2;
    public static final int OP_FIL_ERR = 6;
    public static final String OP_MSG = "op_msg";
    public static final int OP_OK = 1;
    public static final int OP_STOP = 4;
    public static final int OP_TIMEOUT = 3;
    public static final int OP_URI_ERR = 5;
    private static final String TAG = "HttpOp";
    protected volatile boolean isRetryWhenIpFailed;
    protected HttpURLConnection mHttp = null;
    int connectTime = 30000;
    int readTime = HTTP_READTIMEOUT;
    public NetBean mRecord = new NetBean();
    protected volatile boolean mIsNeedStop = false;

    protected void addHttpBody(Bundle bundle, InputStream inputStream) {
        boolean z16;
        String string = bundle.getString("Content-Encoding");
        if (string != null && string.indexOf("gzip") >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        readHttpBody(bundle, inputStream, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addHttpHeader(Context context, Bundle bundle, HttpURLConnection httpURLConnection) {
        String str;
        int i3;
        try {
            for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                QwLog.i("header : " + key + " => " + QwLog.list2str(value));
                if ("Set-Cookie".equals(key)) {
                    QFuncProxy.writeTagCookie(context, null, value);
                }
                if (key != null && value != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    char c16 = 0;
                    int i16 = 0;
                    while (i16 < value.size()) {
                        String str2 = value.get(i16);
                        if (stringBuffer.length() > 0) {
                            str = "|%s";
                        } else {
                            str = "%s";
                        }
                        Object[] objArr = new Object[1];
                        objArr[c16] = str2;
                        stringBuffer.append(String.format(str, objArr));
                        if ("Set-Cookie".equals(key) && str2.contains("x-stgw-ssl")) {
                            String[] split = str2.split("_");
                            QwLog.ia(split);
                            if (split != null) {
                                if (split.length > 1) {
                                    this.mRecord.mServerRequestTime = split[1];
                                }
                                if (split.length > 2) {
                                    this.mRecord.mServerActionTime = split[2];
                                }
                                if (split.length > 3) {
                                    this.mRecord.mServerTcpTimes = split[3];
                                }
                                if (split.length > 4) {
                                    this.mRecord.mConnectProtocol = split[4];
                                }
                                if (split.length > 5) {
                                    this.mRecord.mServerReuseSession = split[5];
                                }
                                if (split.length > 9) {
                                    this.mRecord.mTLSHandshakeTime = "";
                                    if (!TextUtils.isEmpty(split[9])) {
                                        try {
                                            Long valueOf = Long.valueOf(split[9]);
                                            StringBuilder sb5 = new StringBuilder();
                                            NetBean netBean = this.mRecord;
                                            sb5.append(netBean.mTLSHandshakeTime);
                                            i3 = i16;
                                            try {
                                                sb5.append(valueOf.longValue() / 1000);
                                                netBean.mTLSHandshakeTime = sb5.toString();
                                            } catch (NumberFormatException e16) {
                                                e = e16;
                                                QLog.e(TAG, 1, "", e);
                                                i16 = i3 + 1;
                                                c16 = 0;
                                            }
                                        } catch (NumberFormatException e17) {
                                            e = e17;
                                            i3 = i16;
                                        }
                                        i16 = i3 + 1;
                                        c16 = 0;
                                    }
                                }
                            }
                        }
                        i3 = i16;
                        i16 = i3 + 1;
                        c16 = 0;
                    }
                    if (stringBuffer.length() > 0) {
                        bundle.putString(key, stringBuffer.toString());
                    }
                }
            }
        } catch (Exception e18) {
            QLog.e(TAG, 1, "", e18);
        }
    }

    public HttpURLConnection createHttp(String str, Context context) {
        String host = Utils.getHost(str);
        if (host == null) {
            return null;
        }
        NetBean netBean = this.mRecord;
        netBean.mIsUserInnerDns = false;
        netBean.mInnerIp = null;
        QwLog.i("createHttp,first replaced Url =" + str);
        try {
            URL url = new URL(str);
            getConnectAndReadTimeOut(context);
            if ("https".equals(url.getProtocol())) {
                QwLog.i("https request...");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setConnectTimeout(this.connectTime);
                httpsURLConnection.setReadTimeout(this.readTime);
                httpsURLConnection.setInstanceFollowRedirects(true);
                HttpURLConnection.setFollowRedirects(true);
                httpsURLConnection.setRequestProperty("Host", host);
                NetManager.instance().addNameVerifyHost(httpsURLConnection, host);
                SSLSocketFactory sSLFactory = NetManager.instance().getSSLFactory(context);
                if (sSLFactory == null) {
                    sSLFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
                }
                QwLog.i("https socket factory = " + sSLFactory);
                httpsURLConnection.setSSLSocketFactory(sSLFactory);
                return httpsURLConnection;
            }
            QwLog.i("http request...");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.connectTime);
            httpURLConnection.setReadTimeout(this.readTime);
            httpURLConnection.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(true);
            httpURLConnection.setRequestProperty("Host", host);
            return httpURLConnection;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return null;
        }
    }

    public void getConnectAndReadTimeOut(Context context) {
        this.connectTime = 30000;
        this.readTime = HTTP_READTIMEOUT;
    }

    public boolean isRetryWhenIpFailed(boolean z16, Context context, String str, int i3, Exception exc) {
        this.isRetryWhenIpFailed = false;
        NetBean netBean = this.mRecord;
        if (netBean.mIsUserInnerDns && !StringUtil.isEmpty(netBean.mInnerIp) && QFuncProxy.isNetSupport(context)) {
            DataProxy.reportBadIp(Utils.getHost(str), this.mRecord.mInnerIp);
            if (z16) {
                this.isRetryWhenIpFailed = true;
            }
        }
        QwLog.i("isRetryWhenIpFailed:" + this.isRetryWhenIpFailed + ",isNeedIpFailToTry:" + z16 + ",mIsUserInnerDns:" + this.mRecord.mIsUserInnerDns + ",mInnerIp:" + this.mRecord.mInnerIp + ",netSupport:" + QFuncProxy.isNetSupport(context) + ",status:" + i3 + ",exception:" + exc.toString());
        return this.isRetryWhenIpFailed;
    }

    public boolean isV6Ip(String str) {
        boolean z16;
        if (!StringUtil.isEmpty(str) && str.startsWith("[")) {
            z16 = true;
        } else {
            z16 = false;
        }
        QwLog.i("isV6Ip:" + z16 + ",ip:" + str);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void op_failed(Bundle bundle) {
        bundle.putInt(OP_CODE, 2);
    }

    protected void op_fil_err(Bundle bundle) {
        bundle.putInt(OP_CODE, 6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void op_ok(Bundle bundle) {
        bundle.putInt(OP_CODE, 1);
    }

    protected void op_stop(Bundle bundle) {
        bundle.putInt(OP_CODE, 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void op_timeout(Bundle bundle) {
        bundle.putInt(OP_CODE, 3);
    }

    protected void op_uri_err(Bundle bundle) {
        bundle.putInt(OP_CODE, 5);
    }

    protected void readHttpBody(Bundle bundle, InputStream inputStream, boolean z16) {
        int read;
        if (inputStream == null) {
            QwLog.i("entry is null...");
            return;
        }
        if (z16) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException e16) {
                QLog.e(TAG, 1, "", e16);
                return;
            } catch (IllegalStateException e17) {
                QLog.e(TAG, 1, "", e17);
                return;
            }
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z17 = true;
        while (!this.mIsNeedStop && (read = inputStream.read(bArr)) > 0) {
            if (z17) {
                this.mRecord.mReceiveFirstTime = System.currentTimeMillis();
                z17 = false;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bundle.putByteArray("data", byteArrayOutputStream.toByteArray());
        op_ok(bundle);
        Utils.closeObject(inputStream);
        Utils.closeObject(byteArrayOutputStream);
    }

    public abstract Bundle startRun(Context context, String str);

    public void stopRun() {
        this.mIsNeedStop = true;
    }
}
