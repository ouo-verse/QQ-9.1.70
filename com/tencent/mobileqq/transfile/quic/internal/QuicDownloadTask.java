package com.tencent.mobileqq.transfile.quic.internal;

import android.net.http.Headers;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.internal.QuicNative;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicDownloadTask extends Task<DownloadListener> {
    static IPatchRedirector $redirector_ = null;
    private static final String ISO_8859_1 = "ISO-8859-1";
    private float currentProgress;
    public boolean encryption;
    public int fec;
    public Map<String, String> headers;
    private boolean isHeader;
    private volatile boolean mClientFailed;
    private volatile boolean mClosed;
    private volatile boolean mCompleted;
    public QuicDownloadRequest mQuicDownloadRequest;
    private QuicNative mRealQuicCall;
    private RandomAccessFile savedFile;
    private long sendReqTime;
    private long startConnTime;
    private long sum;
    public int timeOut;

    public QuicDownloadTask(ITaskHandler iTaskHandler, String str, String str2, String str3, Map<String, String> map, DownloadListener downloadListener) {
        super(iTaskHandler, "quic", str, str2, str3, map, downloadListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iTaskHandler, str, str2, str3, map, downloadListener);
            return;
        }
        this.headers = new LinkedHashMap();
        this.encryption = false;
        this.fec = 0;
        this.timeOut = 10000;
        this.savedFile = null;
        this.mCompleted = false;
        this.mClosed = false;
        this.mClientFailed = false;
        this.startConnTime = 0L;
        this.sendReqTime = 0L;
        this.sum = 0L;
        this.currentProgress = 0.0f;
        this.report.channel = "quic";
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length);
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString.toUpperCase());
            }
            return stringBuffer.toString();
        }
        return null;
    }

    private boolean cancelFinishIfNeed() {
        T t16 = this.netListener;
        if (t16 != 0 && ((DownloadListener) t16).isCanceled()) {
            this.mClientFailed = true;
            QuicNetReport quicNetReport = this.report;
            quicNetReport.errMsg = "task is canceled.";
            quicNetReport.errCode = 10007;
            doFinish(10);
            return true;
        }
        return false;
    }

    private static byte charToByte(char c16) {
        return (byte) "0123456789ABCDEF".indexOf(c16);
    }

    private void clear() {
        try {
            QuicNative quicNative = this.mRealQuicCall;
            if (quicNative != null) {
                quicNative.clear();
                this.mRealQuicCall = null;
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    private void closeSavedFile() {
        try {
            RandomAccessFile randomAccessFile = this.savedFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (IOException e16) {
            QLog.e("quic", 2, e16, new Object[0]);
        }
    }

    private void finishRecv() {
        this.report.endTime = System.currentTimeMillis();
        QuicNetReport quicNetReport = this.report;
        quicNetReport.totaltime = quicNetReport.endTime - quicNetReport.startTime;
        StringBuilder sb5 = new StringBuilder("header=>");
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(":");
            sb5.append(entry.getValue());
            sb5.append("\n");
        }
        this.report.header = sb5.toString();
        this.mCompleted = true;
        doFinish(3);
    }

    public static byte[] hexStringToBytes(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = str.toUpperCase().toCharArray();
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (charToByte(charArray[i16 + 1]) | (charToByte(charArray[i16]) << 4));
            }
            return bArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void connectionClose(int i3, String str) {
        if (this.running && !this.mClosed) {
            this.mClosed = true;
            if (!this.mCompleted && !this.mClientFailed) {
                try {
                    QuicNative quicNative = this.mRealQuicCall;
                    if (quicNative != null) {
                        this.report.extra = quicNative.getState();
                        this.report.srvMessage = this.mRealQuicCall.getSrvMessage();
                    }
                } catch (UnsatisfiedLinkError e16) {
                    e16.printStackTrace();
                }
                QuicNetReport quicNetReport = this.report;
                int i16 = i3 + 20000;
                quicNetReport.errCode = i16;
                quicNetReport.errMsg = str;
                handleException(i16, 3);
            }
            clear();
            if (this.handler != null) {
                Message obtain = Message.obtain();
                obtain.what = 7;
                obtain.obj = this;
                this.handler.handleMessage(obtain);
            }
            this.running = false;
        }
    }

    void doFinish(int i3) {
        try {
            QuicNative quicNative = this.mRealQuicCall;
            if (quicNative != null) {
                this.report.extra = quicNative.getState();
                this.report.srvMessage = this.mRealQuicCall.getSrvMessage();
                this.mRealQuicCall.setTransCompleted(true);
            }
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("quic", 4, e16, new Object[0]);
        }
        try {
            RandomAccessFile randomAccessFile = this.savedFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e17) {
            this.report.errMsg = e17.toString();
        }
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 == 10) {
                    handleException(this.report.errCode, 9);
                }
            } else {
                handleException(this.report.errCode, 4);
            }
        } else {
            handleFinish(this.report.tempPath);
        }
        if (i3 == 5) {
            try {
                QuicNative quicNative2 = this.mRealQuicCall;
                if (quicNative2 != null) {
                    quicNative2.setTransCompleted(true);
                }
            } catch (UnsatisfiedLinkError e18) {
                e18.printStackTrace();
            }
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.finalize();
            closeSavedFile();
        }
    }

    protected boolean handleBodyOnParseHeader(String str, BufferedReader bufferedReader, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, bufferedReader, Integer.valueOf(i3))).booleanValue();
        }
        if (bufferedReader.readLine() != null) {
            String[] split = str.split(System.getProperty("line.separator"), i3 + 2);
            byte[] hexStringToBytes = hexStringToBytes(bytesToHexString(split[split.length - 1].getBytes("ISO-8859-1")));
            if (hexStringToBytes != null) {
                parseBody(hexStringToBytes, hexStringToBytes.length);
                return true;
            }
        }
        return false;
    }

    protected boolean handleHeaderLine(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        int indexOf = str.indexOf(":");
        String trim = str.substring(0, indexOf).trim();
        String trim2 = str.substring(indexOf + 1).trim();
        this.headers.put(trim, trim2);
        if (trim.equalsIgnoreCase(Headers.CONTENT_LEN)) {
            this.report.contentLength = Long.parseLong(trim2) + this.downloadLength;
        } else if (trim.equalsIgnoreCase("content-type")) {
            this.report.contentType = trim2;
        } else {
            if (trim.equalsIgnoreCase(HttpMsg.USERRETURNCODE) && Integer.parseInt(trim2) != 0) {
                this.mClientFailed = true;
                this.report.errCode = Integer.parseInt(trim2);
                this.report.errMsg = "User-ReturnCode is " + this.report.errCode;
                doFinish(5);
                return true;
            }
            if (trim.equalsIgnoreCase("x-nws-log-uuid")) {
                this.report.uuid = trim2;
            }
        }
        return false;
    }

    protected boolean handleStateLine(String str) throws ProtocolException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        parseStateLine(str);
        int i3 = this.report.httpStatus;
        if (i3 != 200 && i3 != 206) {
            this.mClientFailed = true;
            QuicNetReport quicNetReport = this.report;
            quicNetReport.errCode = quicNetReport.httpStatus;
            doFinish(5);
            return true;
        }
        return false;
    }

    void parseBody(byte[] bArr, int i3) {
        try {
            RandomAccessFile randomAccessFile = this.savedFile;
            if (randomAccessFile != null) {
                randomAccessFile.write(bArr, 0, i3);
                long j3 = this.sum + i3;
                this.sum = j3;
                QuicNetReport quicNetReport = this.report;
                long j16 = j3 + this.downloadLength;
                quicNetReport.fileSize = j16;
                long j17 = quicNetReport.contentLength;
                float f16 = (((float) j16) * 1.0f) / ((float) j17);
                if (f16 - this.currentProgress >= 0.01f || f16 == 1.0f) {
                    this.currentProgress = f16;
                    T t16 = this.netListener;
                    if (t16 != 0) {
                        ((DownloadListener) t16).onDownloadProgress(quicNetReport.url, j17, j16);
                    }
                }
            }
        } catch (Exception e16) {
            this.mClientFailed = true;
            this.report.errMsg = e16.toString();
            this.report.errCode = 10006;
            doFinish(5);
        }
        QuicNetReport quicNetReport2 = this.report;
        if (quicNetReport2.fileSize == quicNetReport2.contentLength) {
            finishRecv();
            QuicNative quicNative = this.mRealQuicCall;
            if (quicNative != null) {
                quicNative.setTransCompleted(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x00e0 -> B:71:0x00e3). Please report as a decompilation issue!!! */
    protected void parseResponseHeader(byte[] bArr, int i3) {
        String str;
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, i3);
            return;
        }
        try {
            str = new String(bArr, "ISO-8859-1");
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        QuicNetReport quicNetReport = this.report;
        ?? r26 = this.headers;
        quicNetReport.headers = r26;
        BufferedReader bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                int i16 = 0;
                r26 = new ByteArrayInputStream(bArr, 0, i3);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(r26));
                    try {
                        String readLine = bufferedReader2.readLine();
                        while (readLine != null) {
                            boolean startsWith = readLine.startsWith("HTTP/1.");
                            if (startsWith) {
                                contains = startsWith;
                                if (handleStateLine(readLine)) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                    try {
                                        r26.close();
                                        return;
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                        return;
                                    }
                                }
                            } else {
                                contains = readLine.contains(":");
                                if (contains) {
                                    contains = contains;
                                    if (handleHeaderLine(readLine)) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e26) {
                                            e26.printStackTrace();
                                        }
                                        try {
                                            r26.close();
                                            return;
                                        } catch (IOException e27) {
                                            e27.printStackTrace();
                                            return;
                                        }
                                    }
                                } else {
                                    if (readLine.length() == 0 && handleBodyOnParseHeader(str, bufferedReader2, i16)) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e28) {
                                            e28.printStackTrace();
                                        }
                                        try {
                                            r26.close();
                                            return;
                                        } catch (IOException e29) {
                                            e29.printStackTrace();
                                            return;
                                        }
                                    }
                                    readLine = bufferedReader2.readLine();
                                    bufferedReader = contains;
                                }
                            }
                            i16++;
                            readLine = bufferedReader2.readLine();
                            bufferedReader = contains;
                        }
                        try {
                            bufferedReader2.close();
                        } catch (IOException e36) {
                            e36.printStackTrace();
                        }
                        r26.close();
                    } catch (Exception e37) {
                        e = e37;
                        bufferedReader = bufferedReader2;
                        this.mClientFailed = true;
                        this.report.errMsg = e.toString();
                        this.report.errCode = 10001;
                        doFinish(5);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e38) {
                                e38.printStackTrace();
                            }
                        }
                        if (r26 != 0) {
                            r26.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e39) {
                                e39.printStackTrace();
                            }
                        }
                        if (r26 != 0) {
                            try {
                                r26.close();
                                throw th;
                            } catch (IOException e46) {
                                e46.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e47) {
                    e = e47;
                }
            } catch (Exception e48) {
                e = e48;
                r26 = 0;
            } catch (Throwable th6) {
                th = th6;
                r26 = 0;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void prepare(QuicNative.QuicCallback quicCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) quicCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, "prepare ", Integer.valueOf(this.report.f293472id));
        }
        QuicNetReport quicNetReport = this.report;
        QuicDownloadRequest quicDownloadRequest = new QuicDownloadRequest(quicNetReport.f293473ip, quicNetReport.port, quicNetReport.url);
        this.mQuicDownloadRequest = quicDownloadRequest;
        Map<String, String> map = this.headers;
        if (map != null) {
            quicDownloadRequest.setHeader(map);
        }
        this.report.slice = 1;
        QuicNative quicNative = new QuicNative();
        this.mRealQuicCall = quicNative;
        quicNative.setCallback(quicCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveResponse(byte[] bArr, int i3) {
        if (!this.running || this.mClosed || this.mClientFailed || this.mCompleted || cancelFinishIfNeed()) {
            return;
        }
        if (bArr == null) {
            this.mClientFailed = true;
            QuicNetReport quicNetReport = this.report;
            quicNetReport.errMsg = "receiveResponse data is null.";
            quicNetReport.errCode = 10006;
            doFinish(5);
            return;
        }
        if (this.isHeader) {
            this.report.firstPackageCost = System.currentTimeMillis() - this.sendReqTime;
            parseResponseHeader(bArr, i3);
            this.isHeader = false;
            return;
        }
        parseBody(bArr, i3);
    }

    public void sendData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, Integer.valueOf(this.report.f293472id), " has get a connect");
        }
        this.report.tConn = System.currentTimeMillis() - this.startConnTime;
        if (this.running && !this.mClosed && !this.mClientFailed && !this.mCompleted) {
            this.isHeader = true;
            try {
                this.sendReqTime = System.currentTimeMillis();
                while (true) {
                    QuicDownloadRequest quicDownloadRequest = this.mQuicDownloadRequest;
                    if (!quicDownloadRequest.isFinish) {
                        byte[] requestData = quicDownloadRequest.getRequestData();
                        this.mRealQuicCall.sendRequest(requestData, requestData.length, this.mQuicDownloadRequest.isFinish, this.timeOut);
                    } else {
                        return;
                    }
                }
            } catch (Throwable unused) {
                handleException(30006, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startConnect() {
        try {
            if (!TextUtils.isEmpty(this.report.tempPath)) {
                closeSavedFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.report.tempPath, "rw");
                this.savedFile = randomAccessFile;
                randomAccessFile.seek(this.downloadLength);
            }
        } catch (Exception e16) {
            QLog.e("quic", 4, e16, this.report.f293472id + " setOutputStream failed");
        }
        if (this.running && !this.mClosed && !this.mClientFailed && !this.mCompleted) {
            if (TextUtils.isEmpty(this.mQuicDownloadRequest.f293471ip)) {
                handleException(10005, 4);
                return;
            }
            if (TextUtils.isEmpty(this.report.tempPath)) {
                handleException(10004, 4);
                return;
            }
            try {
                if (this.mRealQuicCall != null) {
                    this.startConnTime = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("quic", 4, "startConnect ", Long.valueOf(this.startConnTime));
                    }
                    QuicNative quicNative = this.mRealQuicCall;
                    QuicNetReport quicNetReport = this.report;
                    int i3 = quicNetReport.f293472id;
                    QuicDownloadRequest quicDownloadRequest = this.mQuicDownloadRequest;
                    String str = quicDownloadRequest.host;
                    String str2 = quicDownloadRequest.f293471ip;
                    int i16 = quicDownloadRequest.port;
                    boolean z16 = this.encryption;
                    int i17 = this.fec;
                    byte[] reportMsg = quicNetReport.getReportMsg();
                    QuicNetReport quicNetReport2 = this.report;
                    quicNative.startConnect(i3, str, str2, i16, z16, i17, reportMsg, quicNetReport2.isIpv6, quicNetReport2.rttHost);
                }
            } catch (Throwable unused) {
                handleException(30006, 4);
            }
        }
    }
}
