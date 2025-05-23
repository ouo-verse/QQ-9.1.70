package com.pay.http;

import android.util.Log;
import com.pay.tool.APMidasTools;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes2.dex */
public abstract class APBaseHttpReq extends BaseThread {
    protected IAPHttpAns httpAns;
    public APBaseHttpParam httpParam;
    protected HttpURLConnection httpURLConnection;
    private boolean isStop = false;
    private byte[] resultContent;

    public APBaseHttpReq() {
        APBaseHttpParam aPBaseHttpParam = new APBaseHttpParam();
        this.httpParam = aPBaseHttpParam;
        aPBaseHttpParam.reqParam = new HashMap<>();
        this.httpParam.domain = APMidasTools.getSysServerDomain();
    }

    private void closeOutput() {
        try {
            if (this.httpURLConnection.getDoOutput()) {
                try {
                    this.httpURLConnection.getOutputStream().flush();
                    this.httpURLConnection.getOutputStream().close();
                } catch (Throwable unused) {
                }
            }
        } catch (Exception e16) {
            APLog.i("closeOutput", e16.toString());
        }
    }

    private void closeStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
                return;
            }
        }
        if (outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
        this.httpURLConnection.disconnect();
    }

    private void createConnection() {
        URL url;
        try {
            url = new URL(this.httpParam.url);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            url = null;
        }
        if (APMidasPayAPI.env.equals(APMidasPayAPI.ENV_TESTING)) {
            APLog.i("APHttp Request", "URL = " + this.httpParam.url);
        } else {
            APLog.i("APHttp Request", "URL = " + this.httpParam.url + " HOST = " + this.httpParam.defaultDomain);
        }
        this.httpAns.onStart(this);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            this.httpURLConnection = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.httpParam.connectTimeout);
            this.httpURLConnection.setReadTimeout(this.httpParam.readTimeout);
            this.httpURLConnection.setRequestProperty("Host", this.httpParam.defaultDomain);
            this.httpURLConnection.setUseCaches(false);
        } catch (Exception e17) {
            APLog.i("createConnection", e17.toString());
        }
    }

    private void initRequest() {
        constructParam();
        this.httpParam.constructUrl();
        preCreateConnection();
        createConnection();
        closeOutput();
        setHeader();
        setBody();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x006d, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0074, code lost:
    
        closeStream(r6, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x007f, code lost:
    
        if (r18.httpParam.reqType.equals("https://") == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0081, code lost:
    
        com.tencent.midas.comm.APLog.d("APBaseHttpReq", "finally https");
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0084, code lost:
    
        r0 = javax.net.ssl.SSLContext.getInstance("TLS");
        r0.init(r15, r15, new java.security.SecureRandom());
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r0.getSocketFactory());
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0098, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0099, code lost:
    
        com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally Exception" + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00af, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00d9, code lost:
    
        r17 = r6;
        r18.resultContent = r13.toByteArray();
        r18.httpAns.onFinish(r18);
        sendReportData(r5, r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [javax.net.ssl.TrustManager[], javax.net.ssl.KeyManager[]] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void requestProgress() {
        InputStream inputStream;
        Throwable th5;
        Exception e16;
        StringBuilder sb5;
        IOException e17;
        Exception e18;
        Exception e19;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.httpParam.begTime = System.currentTimeMillis();
        initRequest();
        ?? r152 = 0;
        try {
            try {
                if (this.httpParam.sendType.equals("POST")) {
                    DataOutputStream dataOutputStream = new DataOutputStream(this.httpURLConnection.getOutputStream());
                    dataOutputStream.write(this.httpParam.urlParams.getBytes());
                    dataOutputStream.flush();
                }
            } catch (Throwable th6) {
                try {
                    th6.printStackTrace();
                } catch (SocketTimeoutException e26) {
                    e19 = e26;
                    inputStream = null;
                    closeStream(inputStream, byteArrayOutputStream);
                    tryAgain(-8, -1, e19, "\u7f51\u7edc\u54cd\u5e94\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                    closeStream(inputStream, byteArrayOutputStream);
                    if (!this.httpParam.reqType.equals("https://")) {
                    }
                } catch (ConnectTimeoutException e27) {
                    e18 = e27;
                    inputStream = null;
                    closeStream(inputStream, byteArrayOutputStream);
                    tryAgain(-7, -1, e18, "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                    closeStream(inputStream, byteArrayOutputStream);
                    if (!this.httpParam.reqType.equals("https://")) {
                    }
                } catch (IOException e28) {
                    e17 = e28;
                    inputStream = null;
                    tryAgain(APMidasTools.getErrorCodeFromException(e17), -1, e17, "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                    closeStream(inputStream, byteArrayOutputStream);
                    if (!this.httpParam.reqType.equals("https://")) {
                    }
                } catch (Exception e29) {
                    e16 = e29;
                    inputStream = null;
                    closeStream(inputStream, byteArrayOutputStream);
                    tryAgain(-6, -1, e16, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                    closeStream(inputStream, byteArrayOutputStream);
                    if (!this.httpParam.reqType.equals("https://")) {
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    inputStream = null;
                    closeStream(inputStream, byteArrayOutputStream);
                    if (this.httpParam.reqType.equals("https://")) {
                    }
                }
            }
            inputStream = this.httpURLConnection.getInputStream();
            try {
                int i3 = 200;
                if (this.httpURLConnection.getResponseCode() == 200) {
                    try {
                        byte[] bArr = new byte[1024];
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            if (this.isStop) {
                                try {
                                    break;
                                } catch (SocketTimeoutException e36) {
                                    e19 = e36;
                                    closeStream(inputStream, byteArrayOutputStream);
                                    tryAgain(-8, -1, e19, "\u7f51\u7edc\u54cd\u5e94\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                    closeStream(inputStream, byteArrayOutputStream);
                                    if (!this.httpParam.reqType.equals("https://")) {
                                        APLog.d("APBaseHttpReq", "finally https");
                                        try {
                                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                                            sSLContext.init(null, null, new SecureRandom());
                                            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                                            return;
                                        } catch (Exception e37) {
                                            e = e37;
                                            sb5 = new StringBuilder();
                                            sb5.append("finally Exception");
                                            sb5.append(e.toString());
                                            APLog.e("APBaseHttpReq", sb5.toString());
                                        }
                                    }
                                    return;
                                } catch (ConnectTimeoutException e38) {
                                    e18 = e38;
                                    closeStream(inputStream, byteArrayOutputStream);
                                    tryAgain(-7, -1, e18, "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                    closeStream(inputStream, byteArrayOutputStream);
                                    if (!this.httpParam.reqType.equals("https://")) {
                                        APLog.d("APBaseHttpReq", "finally https");
                                        try {
                                            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
                                            sSLContext2.init(null, null, new SecureRandom());
                                            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext2.getSocketFactory());
                                            return;
                                        } catch (Exception e39) {
                                            e = e39;
                                            sb5 = new StringBuilder();
                                            sb5.append("finally Exception");
                                            sb5.append(e.toString());
                                            APLog.e("APBaseHttpReq", sb5.toString());
                                        }
                                    }
                                    return;
                                } catch (IOException e46) {
                                    e17 = e46;
                                    tryAgain(APMidasTools.getErrorCodeFromException(e17), -1, e17, "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                    closeStream(inputStream, byteArrayOutputStream);
                                    if (!this.httpParam.reqType.equals("https://")) {
                                        APLog.d("APBaseHttpReq", "finally https");
                                        try {
                                            SSLContext sSLContext3 = SSLContext.getInstance("TLS");
                                            sSLContext3.init(null, null, new SecureRandom());
                                            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext3.getSocketFactory());
                                            return;
                                        } catch (Exception e47) {
                                            e = e47;
                                            sb5 = new StringBuilder();
                                            sb5.append("finally Exception");
                                            sb5.append(e.toString());
                                            APLog.e("APBaseHttpReq", sb5.toString());
                                        }
                                    }
                                    return;
                                } catch (Exception e48) {
                                    e16 = e48;
                                    closeStream(inputStream, byteArrayOutputStream);
                                    tryAgain(-6, -1, e16, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                                    closeStream(inputStream, byteArrayOutputStream);
                                    if (!this.httpParam.reqType.equals("https://")) {
                                        APLog.d("APBaseHttpReq", "finally https");
                                        try {
                                            SSLContext sSLContext4 = SSLContext.getInstance("TLS");
                                            sSLContext4.init(null, null, new SecureRandom());
                                            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext4.getSocketFactory());
                                            return;
                                        } catch (Exception e49) {
                                            e = e49;
                                            sb5 = new StringBuilder();
                                            sb5.append("finally Exception");
                                            sb5.append(e.toString());
                                            APLog.e("APBaseHttpReq", sb5.toString());
                                        }
                                    }
                                    return;
                                }
                            }
                            byteArrayOutputStream.write(bArr, i16, read);
                            int i18 = i17 + read;
                            inputStream2 = inputStream;
                            try {
                                this.httpAns.onReceive(bArr, read, i18, this);
                                i3 = 200;
                                i16 = 0;
                                i17 = i18;
                                inputStream = inputStream2;
                                r152 = 0;
                            } catch (SocketTimeoutException e56) {
                                e19 = e56;
                                inputStream = inputStream2;
                                closeStream(inputStream, byteArrayOutputStream);
                                tryAgain(-8, -1, e19, "\u7f51\u7edc\u54cd\u5e94\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                closeStream(inputStream, byteArrayOutputStream);
                                if (!this.httpParam.reqType.equals("https://")) {
                                }
                            } catch (ConnectTimeoutException e57) {
                                e18 = e57;
                                inputStream = inputStream2;
                                closeStream(inputStream, byteArrayOutputStream);
                                tryAgain(-7, -1, e18, "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                closeStream(inputStream, byteArrayOutputStream);
                                if (!this.httpParam.reqType.equals("https://")) {
                                }
                            } catch (IOException e58) {
                                e17 = e58;
                                inputStream = inputStream2;
                                tryAgain(APMidasTools.getErrorCodeFromException(e17), -1, e17, "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                closeStream(inputStream, byteArrayOutputStream);
                                if (!this.httpParam.reqType.equals("https://")) {
                                }
                            } catch (Exception e59) {
                                e16 = e59;
                                inputStream = inputStream2;
                                closeStream(inputStream, byteArrayOutputStream);
                                tryAgain(-6, -1, e16, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                                closeStream(inputStream, byteArrayOutputStream);
                                if (!this.httpParam.reqType.equals("https://")) {
                                }
                            } catch (Throwable th8) {
                                th5 = th8;
                                inputStream = inputStream2;
                                closeStream(inputStream, byteArrayOutputStream);
                                if (this.httpParam.reqType.equals("https://")) {
                                }
                            }
                        }
                    } catch (SocketTimeoutException e65) {
                        e19 = e65;
                    } catch (ConnectTimeoutException e66) {
                        e18 = e66;
                    } catch (IOException e67) {
                        e17 = e67;
                    } catch (Exception e68) {
                        e16 = e68;
                    } catch (Throwable th9) {
                        th = th9;
                        th5 = th;
                        closeStream(inputStream, byteArrayOutputStream);
                        if (this.httpParam.reqType.equals("https://")) {
                        }
                    }
                } else {
                    inputStream2 = inputStream;
                    try {
                        tryAgain(-10, this.httpURLConnection.getResponseCode(), null, "\u7f51\u7edc\u9519\u8bef(\u9519\u8bef\u7801" + this.httpURLConnection.getResponseCode() + ")");
                    } catch (SocketTimeoutException e69) {
                        e19 = e69;
                        inputStream = inputStream2;
                        closeStream(inputStream, byteArrayOutputStream);
                        tryAgain(-8, -1, e19, "\u7f51\u7edc\u54cd\u5e94\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                        closeStream(inputStream, byteArrayOutputStream);
                        if (!this.httpParam.reqType.equals("https://")) {
                        }
                    } catch (ConnectTimeoutException e75) {
                        e18 = e75;
                        inputStream = inputStream2;
                        closeStream(inputStream, byteArrayOutputStream);
                        tryAgain(-7, -1, e18, "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                        closeStream(inputStream, byteArrayOutputStream);
                        if (!this.httpParam.reqType.equals("https://")) {
                        }
                    } catch (IOException e76) {
                        e17 = e76;
                        inputStream = inputStream2;
                        tryAgain(APMidasTools.getErrorCodeFromException(e17), -1, e17, "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                        closeStream(inputStream, byteArrayOutputStream);
                        if (!this.httpParam.reqType.equals("https://")) {
                        }
                    } catch (Exception e77) {
                        e16 = e77;
                        inputStream = inputStream2;
                        closeStream(inputStream, byteArrayOutputStream);
                        tryAgain(-6, -1, e16, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                        closeStream(inputStream, byteArrayOutputStream);
                        if (!this.httpParam.reqType.equals("https://")) {
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        inputStream = inputStream2;
                        th5 = th;
                        closeStream(inputStream, byteArrayOutputStream);
                        if (this.httpParam.reqType.equals("https://")) {
                        }
                    }
                }
                closeStream(inputStream2, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    APLog.d("APBaseHttpReq", "finally https");
                    try {
                        SSLContext sSLContext5 = SSLContext.getInstance("TLS");
                        sSLContext5.init(null, null, new SecureRandom());
                        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext5.getSocketFactory());
                    } catch (Exception e78) {
                        e = e78;
                        sb5 = new StringBuilder();
                        sb5.append("finally Exception");
                        sb5.append(e.toString());
                        APLog.e("APBaseHttpReq", sb5.toString());
                    }
                }
            } catch (SocketTimeoutException e79) {
                e19 = e79;
            } catch (ConnectTimeoutException e85) {
                e18 = e85;
            } catch (IOException e86) {
                e17 = e86;
            } catch (Exception e87) {
                e16 = e87;
            } catch (Throwable th11) {
                th = th11;
            }
        } catch (Throwable th12) {
            th = th12;
            th5 = th;
            closeStream(inputStream, byteArrayOutputStream);
            if (this.httpParam.reqType.equals("https://")) {
                APLog.d("APBaseHttpReq", "finally https");
                try {
                    SSLContext sSLContext6 = SSLContext.getInstance("TLS");
                    sSLContext6.init(null, null, new SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext6.getSocketFactory());
                    throw th5;
                } catch (Exception e88) {
                    APLog.e("APBaseHttpReq", "finally Exception" + e88.toString());
                    throw th5;
                }
            }
            throw th5;
        }
    }

    private void sendReportData(int i3, int i16) {
        this.httpParam.urlName.endsWith("log_data");
    }

    private void tryAgain(int i3, int i16, Exception exc, String str) {
        sendReportData(i3, i16);
        APLog.i("APBaseHttpReq", getClass().getName() + " tryAgain reqTimes = " + this.httpParam.requestTimes + " tryTimes = " + this.httpParam.reTryTimes);
        try {
            APBaseHttpParam aPBaseHttpParam = this.httpParam;
            if (aPBaseHttpParam.requestTimes < aPBaseHttpParam.reTryTimes) {
                aPBaseHttpParam.constructReTryUrl();
                requestProgress();
                return;
            }
            try {
                if (aPBaseHttpParam.reqType.equals("https://")) {
                    for (Throwable th5 = exc; th5 != null; th5 = th5.getCause()) {
                        if (!(th5 instanceof CertificateExpiredException) && !(th5 instanceof CertificateNotYetValidException)) {
                        }
                        APLog.e("APBaseHttpReq", "\u60a8\u7684\u8bbe\u5907\u7cfb\u7edf\u65f6\u95f4\u4e0d\u6b63\u786e\uff0c\u8bf7\u66f4\u6539");
                        this.httpAns.onError(this, 1100, str);
                        return;
                    }
                }
                this.httpAns.onError(this, 1000, str);
                APLog.i("APBaseHttpReq", str);
                exc.printStackTrace();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } catch (Exception unused) {
        }
    }

    public byte[] getContent() {
        return this.resultContent;
    }

    public IAPHttpAns getHttpAns() {
        return this.httpAns;
    }

    public void requestAgain() {
        requestProgress();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        requestProgress();
        super.run();
    }

    public void setContent(byte[] bArr) {
        this.resultContent = bArr;
    }

    public void setHttpAns(IAPHttpAns iAPHttpAns) {
        this.httpAns = iAPHttpAns;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setReportUrl(String str, String str2, String str3) {
        this.httpParam.setReportUrl(str, str2, str3);
    }

    protected void setUrl(String str, String str2, String str3, String str4) {
        this.httpParam.setUrl(str, str2, str3, str4);
    }

    public void startRequest() {
        start();
    }

    public void stopRequest() {
        Log.i("APBaseHttpReq", "stopRequest");
        this.isStop = true;
        this.httpAns.onStop(this);
    }

    public void constructParam() {
    }

    protected void preCreateConnection() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBody() {
    }

    protected void setHeader() {
    }
}
