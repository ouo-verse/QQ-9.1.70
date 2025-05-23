package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.ProtocolException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class Task<T> {
    static IPatchRedirector $redirector_ = null;
    static final String CONTENT_LENGTH = "content-length";
    static final String CONTENT_TYPE = "content-type";
    static final int ERROR_CODE_CANCELED = 10007;
    static final int ERROR_CODE_DNS_ERROR = 10005;
    static final int ERROR_CODE_HEADER = 10001;
    static final int ERROR_CODE_READ_DATA_FAILED = 10006;
    static final int ERROR_CODE_SAVE_PATH = 10004;
    static final int ERROR_CODE_SERVER = 20000;
    static final int ERROR_COPY_FAILED = 10008;
    static final int ERROR_NATIVE_METHOD_ERROR = 30006;
    static final String USER_RETURNCODE = "User-ReturnCode";
    static final String UUID = "x-nws-log-uuid";
    long downloadLength;
    public ITaskHandler handler;
    Map<String, String> headers;
    T netListener;
    public QuicNetReport report;
    public boolean running;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task(ITaskHandler iTaskHandler, String str, String str2, String str3, String str4, Map<String, String> map, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iTaskHandler, str, str2, str3, str4, map, t16);
            return;
        }
        this.downloadLength = 0L;
        this.running = true;
        this.handler = iTaskHandler;
        this.headers = map;
        this.netListener = t16;
        QuicNetReport quicNetReport = new QuicNetReport();
        this.report = quicNetReport;
        quicNetReport.channel = str;
        quicNetReport.tempPath = getTempPath(str4, str3, str2);
        QuicNetReport quicNetReport2 = this.report;
        quicNetReport2.savePath = str3;
        quicNetReport2.f293472id = QuicDownloadRunnable.getTaskID(quicNetReport2.tempPath);
        QuicNetReport quicNetReport3 = this.report;
        quicNetReport3.errCode = 0;
        quicNetReport3.httpStatus = 0;
        quicNetReport3.url = str2;
        quicNetReport3.startTime = System.currentTimeMillis();
    }

    private void copyFile(String str) {
        File file = new File(str);
        boolean copyFile = FileUtils.copyFile(file, new File(this.report.savePath), true);
        FileUtils.deleteFile(file);
        if (copyFile) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.obj = this;
            this.handler.handleMessage(obtain);
            return;
        }
        this.report.errMsg = "copy temp file fail.";
        handleException(10008, 4);
    }

    public static String getTempPath(String str, String str2, String str3) {
        if (str != null && str.length() > 0) {
            return str;
        }
        return str2 + "." + MD5.toMD5(str3) + ".tmp";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleException(int i3, int i16) {
        QLog.e("quic", 4, this.report.f293472id + " handleException code " + i3 + " failed " + i16 + " running " + this.running);
        if (this.handler == null || !this.running) {
            return;
        }
        this.report.errCode = i3;
        if (NetworkUtil.isNetworkAvailable()) {
            this.report.failReason = i16;
        } else {
            this.report.failReason = 6;
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = this;
        this.handler.handleMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleFinish(String str) {
        if (!this.running) {
            return;
        }
        copyFile(str);
    }

    public void initDownloadFile() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.downloadLength = 0L;
        File file = new File(this.report.tempPath);
        if (file.exists()) {
            file.delete();
            FileUtils.createFile(this.report.tempPath);
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            FileUtils.createDirectory(parentFile.getAbsolutePath());
        }
        FileUtils.createFile(this.report.tempPath);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseStateLine(String str) throws ProtocolException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        int i3 = 4;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("quic", 4, "HTTP/1.0");
                    }
                } else if (charAt == 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("quic", 4, "HTTP/1.1");
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                i3 = 9;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (!str.startsWith("ICY ")) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i16 = i3 + 3;
        if (str.length() >= i16) {
            try {
                this.report.httpStatus = Integer.parseInt(str.substring(i3, i16));
                return;
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }
}
