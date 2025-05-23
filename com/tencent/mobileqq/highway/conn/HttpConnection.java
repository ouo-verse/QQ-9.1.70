package com.tencent.mobileqq.highway.conn;

import android.net.Proxy;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HttpConnection implements IConnection, IProtocolCodecListener {
    static IPatchRedirector $redirector_ = null;
    private static final String BIG_DATA_HIGHWAY_URL = "/cgi-bin/httpconn?htcmd=0x6ff0082";
    private static final int MAX_REDIRECT_NUM = 5;
    private int iErrCode;
    private boolean isIpv6;
    private int mConnId;
    private IConnectionListener mConnListener;
    private HttpURLConnection mConnection;
    private ConnManager mConnmanager;
    private EndPoint mCurrentPoint;
    private TcpProtocolDataCodec mDataCodec;
    private HandlerThread mExecutor;
    private Handler mHandler;
    private String mStrErrInfo;

    public HttpConnection(ConnManager connManager, int i3, EndPoint endPoint, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, connManager, Integer.valueOf(i3), endPoint, Boolean.valueOf(z16));
            return;
        }
        this.iErrCode = 0;
        this.mStrErrInfo = "";
        this.mConnmanager = connManager;
        this.mConnId = i3;
        this.mCurrentPoint = endPoint;
        this.mExecutor = new BaseHandlerThread("BDH-HTTP-" + i3);
        this.isIpv6 = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendRequest() {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] doSendRequest about to peak one request.");
        HwRequest pullNextRequest = this.mConnmanager.pullNextRequest(this, false, 0L, 0L, 0);
        if (pullNextRequest == null) {
            return;
        }
        TcpProtocolDataCodec tcpProtocolDataCodec = new TcpProtocolDataCodec();
        this.mDataCodec = tcpProtocolDataCodec;
        tcpProtocolDataCodec.setProtocolCodecListener(this);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] doSendRequest continue to send. ReqInfo : " + pullNextRequest.toString());
        pullNextRequest.endpoint = this.mCurrentPoint;
        byte[] requestBody = pullNextRequest.getRequestBody();
        if (requestBody == null && pullNextRequest.hasRequestBody()) {
            pullNextRequest.reqListener.handleError(-1004, "NullBody", this);
            wakeupChannel();
            return;
        }
        handleHttpReqData(pullNextRequest, this.mDataCodec.encodeC2SData(this.mCurrentPoint, pullNextRequest, requestBody), pullNextRequest.mBuCmdId);
        int i3 = this.iErrCode;
        if (i3 == 0) {
            wakeupChannel();
            return;
        }
        pullNextRequest.reqListener.handleError(i3, this.mStrErrInfo, this);
        if (this.iErrCode == -1014) {
            stopConnThread();
        }
    }

    private String getBdhConnURL() {
        StringBuilder sb5 = new StringBuilder();
        if (this.isIpv6) {
            sb5.append("http://");
            sb5.append("[");
            sb5.append(this.mCurrentPoint.host);
            sb5.append("]");
        } else {
            sb5.append("http://");
            sb5.append(this.mCurrentPoint.host);
        }
        if (this.mCurrentPoint.port != 80) {
            sb5.append(":");
            sb5.append(this.mCurrentPoint.port);
        }
        sb5.append(BIG_DATA_HIGHWAY_URL);
        return sb5.toString();
    }

    private HttpURLConnection getConnection(String str, HashMap<String, String> hashMap, long j3, int i3) throws Throwable {
        boolean z16;
        boolean z17;
        HttpURLConnection httpURLConnection;
        boolean z18;
        HttpURLConnection connectionWithXOnlineHost;
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] Open Connection. Try Open : " + str);
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        HttpURLConnection httpURLConnection2 = null;
        boolean z19 = false;
        int i16 = 0;
        while (!z19 && i16 < 2) {
            String apnType = BdhUtils.getApnType(AppNetConnInfo.getCurrentAPN());
            boolean z26 = true;
            if (apnType.toLowerCase().equals(BdhUtils.APN_TYPE_CMWAP)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (defaultHost != null && defaultPort > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && z17) {
                if (!apnType.equals(BdhUtils.APN_TYPE_CMWAP) && !apnType.equals(BdhUtils.APN_TYPE_UNIWAP) && !apnType.equals(BdhUtils.APN_TYPE_3GWAP)) {
                    if (apnType.equals(BdhUtils.APN_TYPE_CTWAP)) {
                        connectionWithXOnlineHost = BdhUtils.getConnectionWithDefaultProxy(str, defaultHost, defaultPort);
                    } else {
                        connectionWithXOnlineHost = BdhUtils.getConnectionWithDefaultProxy(str, defaultHost, defaultPort);
                    }
                } else {
                    connectionWithXOnlineHost = BdhUtils.getConnectionWithXOnlineHost(str, defaultHost, defaultPort);
                }
                httpURLConnection = connectionWithXOnlineHost;
                z18 = true;
            } else {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection(java.net.Proxy.NO_PROXY);
                z18 = false;
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode((int) j3);
            httpURLConnection.addRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.addRequestProperty("Connection", "close");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            try {
                httpURLConnection.connect();
            } catch (Throwable th5) {
                if (z17) {
                    if (!z18 || !z17) {
                        if (z17) {
                            if (z18) {
                                throw th5;
                            }
                        } else {
                            throw th5;
                        }
                    }
                    z26 = false;
                } else {
                    throw th5;
                }
            }
            i16++;
            httpURLConnection2 = httpURLConnection;
            z19 = z26;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] Open Connection Succ.");
        return httpURLConnection2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d8, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleHttpReqData(HwRequest hwRequest, byte[] bArr, int i3) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        int i16;
        if (bArr != null && bArr.length > 0) {
            this.iErrCode = 0;
            String bdhConnURL = getBdhConnURL();
            HashMap<String, String> hashMap = new HashMap<>();
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            String str = bdhConnURL;
            int i17 = 0;
            OutputStream outputStream = null;
            while (true) {
                try {
                    IRequestListener iRequestListener = hwRequest.reqListener;
                    if (iRequestListener != null) {
                        iRequestListener.handleSendBegin(this.mConnId);
                    }
                    HttpURLConnection connection = getConnection(str, hashMap, bArr.length, i3);
                    this.mConnection = connection;
                    outputStream = connection.getOutputStream();
                    for (int i18 = 0; i18 < bArr.length; i18 += 10240) {
                        outputStream.write(bArr, i18, Math.min(10240, bArr.length - i18));
                        outputStream.flush();
                    }
                    IRequestListener iRequestListener2 = hwRequest.reqListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.handleSendEnd(this.mConnId, getProtoType());
                    }
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] Write Succ.");
                    int responseCode = this.mConnection.getResponseCode();
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] Recv Response, Http Code : " + responseCode);
                    if (responseCode == 200 || responseCode == 206) {
                        break;
                    }
                    if (responseCode != 302 && responseCode != 301) {
                        this.iErrCode = -1013;
                        this.mStrErrInfo = this.mConnection.getHeaderFields().toString();
                        break;
                    }
                    if (i17 >= 5 || (str = this.mConnection.getHeaderField("Location")) == null || str.length() <= 0) {
                        break;
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    this.mConnection.disconnect();
                    hashMap.put("Referer", getBdhConnURL());
                    i17++;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            }
            inputStream = this.mConnection.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                byte[] bArr2 = new byte[10240];
                loop2: while (true) {
                    i16 = 0;
                    do {
                        int read = inputStream.read(bArr2, i16, 10240 - i16);
                        if (read <= 0) {
                            break loop2;
                        } else {
                            i16 += read;
                        }
                    } while (i16 < 10240);
                    byteArrayOutputStream.write(bArr2);
                }
                if (i16 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i16);
                }
                byteArrayOutputStream.flush();
                this.mDataCodec.decodeS2CData(byteArrayOutputStream.toByteArray());
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "[HttpConn] Short Connection Finish.");
                byteArrayOutputStream.close();
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    } catch (IOException unused2) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                HttpURLConnection httpURLConnection = this.mConnection;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th7) {
                th = th7;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    this.iErrCode = -1003;
                    this.mStrErrInfo = th.getClass().getName();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    HttpURLConnection httpURLConnection2 = this.mConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } finally {
                }
            }
        }
    }

    private void stopConnThread() {
        HandlerThread handlerThread;
        Handler handler = this.mHandler;
        if (handler != null && (handlerThread = this.mExecutor) != null && handlerThread.isAlive()) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.highway.conn.HttpConnection.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HttpConnection.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        HttpConnection.this.mExecutor.quit();
                        HttpConnection.this.mExecutor = null;
                        HttpConnection.this.mHandler = null;
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public boolean connect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            this.mExecutor.start();
            this.mHandler = new Handler(this.mExecutor.getLooper());
            if (this.mConnListener != null) {
                QLog.d(BdhLogUtil.Tag, 1, "C. On Http ConnectionConnected : ID:" + this.mConnId);
                this.mConnListener.onConnect(true, this.mConnId, this, this.mCurrentPoint, 0, new ConnReportInfo());
            }
            wakeupChannel();
            return true;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            disConnect();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void disConnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
        }
        if (this.mConnListener != null) {
            QLog.d(BdhLogUtil.Tag, 1, "C. On Http DisConnected : ID:" + this.mConnId);
            this.mConnListener.onDisConnect(this.mConnId, this);
        }
        stopConnThread();
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public int getConnId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mConnId;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public EndPoint getEndPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EndPoint) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCurrentPoint;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public int getProtoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public boolean isIpv6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isIpv6;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public boolean isWritable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.highway.codec.IProtocolCodecListener
    public void onDecodeInvalidData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        this.iErrCode = -1013;
        this.mStrErrInfo = "DecodeError[" + i3 + "]";
        IConnectionListener iConnectionListener = this.mConnListener;
        if (iConnectionListener != null) {
            iConnectionListener.onRecvInvalidData(this.mCurrentPoint, this);
        }
        disConnect();
    }

    @Override // com.tencent.mobileqq.highway.codec.IProtocolCodecListener
    public void onDecodeSucessfully(List<HwResponse> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        } else if (this.mConnListener != null) {
            this.mConnmanager.onDecodeSucessfully(list);
        }
    }

    @Override // com.tencent.mobileqq.highway.codec.IProtocolCodecListener
    public void onEncodePkgError(HwRequest hwRequest, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) hwRequest, i3);
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void setConnectListener(IConnectionListener iConnectionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iConnectionListener);
        } else {
            this.mConnListener = iConnectionListener;
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void setUrgentFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void wakeupChannel() {
        HandlerThread handlerThread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null && (handlerThread = this.mExecutor) != null && handlerThread.isAlive()) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.highway.conn.HttpConnection.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HttpConnection.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            HttpConnection.this.doSendRequest();
                        } catch (Exception unused) {
                        }
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
