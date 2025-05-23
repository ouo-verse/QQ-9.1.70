package com.tencent.rfix.lib.atta;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.thread.IRFixThreadPool;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.tls.Tls12SocketFactory;
import com.tencent.rfix.loader.utils.CloseUtil;
import com.tencent.rfix.loader.utils.ProcessUtils;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static e f364923h;

    /* renamed from: d, reason: collision with root package name */
    private final Context f364924d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f364925e;

    /* renamed from: f, reason: collision with root package name */
    private a f364926f;

    e(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364924d = context;
            this.f364925e = new Handler(Looper.getMainLooper(), this);
        }
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(e(str), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            RFixLog.e("RFix.RFixATTAReporter", "", e16);
            return "";
        }
    }

    public static e c(Context context) {
        if (f364923h == null) {
            synchronized (e.class) {
                if (f364923h == null) {
                    f364923h = new e(context);
                }
            }
        }
        return f364923h;
    }

    private String e(String str) {
        if (str.indexOf(36) < 0) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '$') {
                sb5.append('\\');
            }
            sb5.append(charAt);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f364926f == null) {
            this.f364926f = new a(this.f364924d);
        }
        for (b bVar : this.f364926f.b(ProcessUtils.getProcessName(this.f364924d))) {
            if (g(bVar)) {
                this.f364926f.a(bVar.a());
            }
        }
    }

    protected boolean g(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar)).booleanValue();
        }
        boolean z16 = false;
        if (!RFixATTASwitch.isATTAReportEnable()) {
            RFixLog.d("RFix.RFixATTAReporter", String.format("reportRecordToATTA report disabled. recordId=%s", Integer.valueOf(bVar.a())));
            return true;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("https://h.trace.qq.com/kv?").openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoOutput(true);
                    Tls12SocketFactory.enableTls12OnPreKitkat(httpURLConnection2);
                    httpURLConnection2.getOutputStream().write(bVar.b().getBytes(StandardCharsets.UTF_8));
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode == 200) {
                        z16 = true;
                    } else {
                        RFixLog.w("RFix.RFixATTAReporter", String.format("reportRecordToATTA responseCode=%s record=%s", Integer.valueOf(responseCode), bVar));
                    }
                    CloseUtil.disconnectQuietly(httpURLConnection2);
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection = httpURLConnection2;
                    RFixLog.e("RFix.RFixATTAReporter", "reportRecordToATTA fail!", e);
                    CloseUtil.disconnectQuietly(httpURLConnection);
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    CloseUtil.disconnectQuietly(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        return z16;
    }

    public boolean h(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) map)).booleanValue();
        }
        RFixLog.d("RFix.RFixATTAReporter", "reportToATTA params=" + map);
        if (map != null && map.containsKey("attaid") && map.containsKey("token")) {
            this.f364925e.obtainMessage(100, map).sendToTarget();
            return true;
        }
        RFixLog.e("RFix.RFixATTAReporter", "reportToATTA params invalid!");
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 100) {
            final Map map = (Map) message.obj;
            RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.atta.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.d(map);
                }
            }, IRFixThreadPool.ThreadType.THREAD_IO);
            return true;
        }
        if (i3 == 101) {
            RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.atta.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.f();
                }
            }, IRFixThreadPool.ThreadType.THREAD_NETWORK);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void d(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str2)) {
                if (!z16) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb5.append(str);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(b(str2));
                z16 = false;
            }
        }
        if (this.f364926f == null) {
            this.f364926f = new a(this.f364924d);
        }
        this.f364926f.c(ProcessUtils.getProcessName(this.f364924d), sb5.toString());
        this.f364925e.removeMessages(101);
        this.f364925e.sendEmptyMessageDelayed(101, 2000L);
    }
}
