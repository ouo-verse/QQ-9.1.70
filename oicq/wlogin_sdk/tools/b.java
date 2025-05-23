package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    public static b f422989e;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f422990f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static StringBuilder f422991g = new StringBuilder();

    /* renamed from: h, reason: collision with root package name */
    public static StringBuilder f422992h = new StringBuilder();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f422993a = false;

    /* renamed from: b, reason: collision with root package name */
    public Context f422994b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f422995c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f422996d;

    public b(Context context) {
        this.f422994b = context;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FileTracer");
        this.f422995c = baseHandlerThread;
        try {
            baseHandlerThread.start();
            if (this.f422995c.isAlive()) {
                this.f422996d = new Handler(this.f422995c.getLooper(), this);
            }
            this.f422996d.sendEmptyMessage(1024);
            this.f422996d.sendEmptyMessageDelayed(1025, 5000L);
        } catch (Error unused) {
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && str2 != null) {
            if (f422989e == null) {
                f422989e = new b(context);
            }
            synchronized (f422990f) {
                if (f422992h.length() > 40960) {
                    StringBuilder sb5 = f422992h;
                    sb5.delete(0, sb5.length() / 2);
                    StringBuilder sb6 = f422992h;
                    sb6.append("log has been cut len ");
                    sb6.append(f422992h.length());
                    sb6.append("\n");
                }
                try {
                    StringBuilder sb7 = f422992h;
                    sb7.append(util.getDate());
                    sb7.append(util.getCurrentPid());
                    sb7.append(util.getThreadId());
                    sb7.append(util.getUser(str));
                    sb7.append(str2);
                    sb7.append("\n");
                } catch (Exception unused) {
                    f422992h = new StringBuilder();
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1024) {
            if (i3 == 1025) {
                try {
                    if (util.ExistSDCard()) {
                        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + util.LOG_DIR + "/" + this.f422994b.getPackageName();
                        util.LOGI("oldPath:" + str, "");
                        File file = new File(str);
                        if (file.exists()) {
                            File[] listFiles = file.listFiles();
                            if (listFiles != null && listFiles.length > 0) {
                                util.LOGI("oldPath delete " + listFiles.length, "");
                                for (File file2 : listFiles) {
                                    file2.delete();
                                }
                            }
                            file.delete();
                        } else {
                            util.LOGI("oldPath not exist", "");
                        }
                    }
                } catch (Throwable th5) {
                    util.LOGI(Log.getStackTraceString(th5), "");
                }
            }
        } else {
            if (Thread.currentThread() == this.f422995c && !this.f422993a) {
                this.f422993a = true;
                try {
                    StringBuilder sb5 = f422992h;
                    if (sb5 != null && sb5.length() != 0) {
                        f422991g = f422992h;
                        f422992h = new StringBuilder();
                        byte[] compress = util.compress(f422991g.toString().getBytes());
                        if (compress != null && compress.length != 0) {
                            byte[] bArr = new byte[compress.length + 4];
                            util.int32_to_buf(bArr, 0, compress.length);
                            System.arraycopy(compress, 0, bArr, 4, compress.length);
                            util.writeFile(util.getLogFileName(this.f422994b, util.getCurrentDay()), bArr);
                        }
                    }
                } catch (Error unused) {
                }
                this.f422993a = false;
            }
            try {
                this.f422996d.sendEmptyMessageDelayed(1024, 2000L);
            } catch (Throwable unused2) {
            }
        }
        return true;
    }
}
