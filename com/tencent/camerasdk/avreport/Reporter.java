package com.tencent.camerasdk.avreport;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Reporter {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private Boolean auto;
    private File dir;
    private Handler ioHandler;
    private HandlerThread ioThread;
    private Runnable uploadRunable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        TAG = Reporter.class.getSimpleName() + "-" + Integer.toHexString(Reporter.class.hashCode());
    }

    public Reporter(File file, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) bool);
            return;
        }
        this.ioThread = null;
        this.ioHandler = null;
        this.uploadRunable = new Runnable() { // from class: com.tencent.camerasdk.avreport.Reporter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Reporter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    for (File file2 : Reporter.this.dir.listFiles()) {
                        if (file2.exists() && file2.isFile()) {
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            byte[] bArr = new byte[1024];
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    stringBuffer.append(new String(bArr, 0, read));
                                }
                            }
                            fileInputStream.close();
                            file2.delete();
                            Reporter.this.report(stringBuffer.toString());
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                Reporter.this.schedule();
            }
        };
        this.dir = file;
        this.auto = bool;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG);
        this.ioThread = baseHandlerThread;
        baseHandlerThread.setDaemon(true);
        this.ioThread.start();
        do {
        } while (!this.ioThread.isAlive());
        this.ioHandler = new Handler(this.ioThread.getLooper());
        schedule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(String str) {
        String str2 = TAG;
        AVRLogUtils.d(str2, "report : " + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://h.trace.qq.com/kv").openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(false);
            httpURLConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            AVRLogUtils.d(str2, "report: reponse code = " + httpURLConnection.getResponseCode());
            AVRLogUtils.d(str2, "report: reponse msg = " + httpURLConnection.getResponseMessage());
            httpURLConnection.disconnect();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        Handler handler;
        if (this.auto.booleanValue() && (handler = this.ioHandler) != null) {
            handler.postDelayed(this.uploadRunable, 30000L);
        }
    }

    public void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Handler handler = this.ioHandler;
        if (handler != null) {
            handler.removeCallbacks(this.uploadRunable);
            this.ioHandler.post(this.uploadRunable);
        }
    }
}
