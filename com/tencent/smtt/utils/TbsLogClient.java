package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TbsLogClient {

    /* renamed from: a, reason: collision with root package name */
    static TbsLogClient f369649a;

    /* renamed from: c, reason: collision with root package name */
    static File f369650c;

    /* renamed from: d, reason: collision with root package name */
    static String f369651d;

    /* renamed from: e, reason: collision with root package name */
    static byte[] f369652e;

    /* renamed from: b, reason: collision with root package name */
    TextView f369653b;

    /* renamed from: f, reason: collision with root package name */
    private SimpleDateFormat f369654f;

    /* renamed from: g, reason: collision with root package name */
    private Context f369655g;

    /* renamed from: h, reason: collision with root package name */
    private StringBuffer f369656h = new StringBuffer();

    /* renamed from: i, reason: collision with root package name */
    private boolean f369657i = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f369658a;

        a(String str) {
            this.f369658a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = TbsLogClient.this.f369653b;
            if (textView != null) {
                textView.append(this.f369658a + "\n");
            }
        }
    }

    public TbsLogClient(Context context) {
        this.f369654f = null;
        this.f369655g = null;
        try {
            this.f369655g = context.getApplicationContext();
            this.f369654f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f369654f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        try {
            if (f369650c == null) {
                String a16 = FileUtil.a(this.f369655g, 6);
                if (a16 == null) {
                    f369650c = null;
                } else {
                    f369650c = new File(a16, "tbslog.txt");
                    f369651d = LogFileUtils.createKey();
                    f369652e = LogFileUtils.createHeaderText(f369650c.getName(), f369651d);
                }
            }
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        } catch (SecurityException e17) {
            e17.printStackTrace();
        }
    }

    public void setLogView(TextView textView) {
        this.f369653b = textView;
    }

    public void setWriteLogJIT(boolean z16) {
        this.f369657i = z16;
    }

    public void showLog(String str) {
        TextView textView = this.f369653b;
        if (textView != null) {
            textView.post(new a(str));
        }
    }

    public void writeLog(String str) {
        try {
            StringBuffer stringBuffer = this.f369656h;
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || this.f369657i) {
                writeLogToDisk();
            }
            if (this.f369656h.length() > 524288) {
                StringBuffer stringBuffer2 = this.f369656h;
                stringBuffer2.delete(0, stringBuffer2.length());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            File file = f369650c;
            if (file != null) {
                LogFileUtils.writeDataToStorage(file, f369651d, f369652e, this.f369656h.toString(), true);
                StringBuffer stringBuffer = this.f369656h;
                stringBuffer.delete(0, stringBuffer.length());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }
}
