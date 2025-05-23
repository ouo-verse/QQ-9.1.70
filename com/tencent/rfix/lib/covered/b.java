package com.tencent.rfix.lib.covered;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.lib.atta.e;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements Handler.Callback {
    static IPatchRedirector $redirector_;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile b C;

    /* renamed from: d, reason: collision with root package name */
    private final Context f364955d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f364956e;

    /* renamed from: f, reason: collision with root package name */
    private final a f364957f;

    /* renamed from: h, reason: collision with root package name */
    private int f364958h;

    /* renamed from: i, reason: collision with root package name */
    private int f364959i;

    /* renamed from: m, reason: collision with root package name */
    private int f364960m;

    b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f364958h = -1;
        this.f364959i = -1;
        this.f364960m = -1;
        this.f364955d = context;
        this.f364956e = new Handler(context.getMainLooper(), this);
        this.f364957f = new a(context);
    }

    private Map<String, String> a() {
        String str;
        String str2;
        boolean z16 = new RFixGlobalPreferences(this.f364955d).testEnvEnable;
        if (z16) {
            str = "01200075137";
        } else {
            str = "0f500075739";
        }
        if (z16) {
            str2 = "7113327981";
        } else {
            str2 = "4334229441";
        }
        RFixParams params = RFix.getInstance().getParams();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", str);
        hashMap.put("token", str2);
        hashMap.put("app_id", params.getAppId());
        hashMap.put("user_id", params.getUserId());
        hashMap.put("device_id", params.getDeviceId());
        hashMap.put("event_name", "DailyCovered");
        return hashMap;
    }

    private void b() {
        Map<String, String> a16 = a();
        boolean c16 = c(a16);
        if (c16) {
            this.f364957f.e(this.f364958h);
        }
        boolean d16 = d(a16);
        if (d16) {
            this.f364957f.f(this.f364959i);
        }
        boolean e16 = e(a16);
        if (e16) {
            this.f364957f.g(this.f364960m);
        }
        if (!c16 && !d16 && !e16) {
            RFixLog.i("RFix.TaskCoveredReporter", "checkAndReportDailyCovered no version changed.");
        } else {
            e.c(this.f364955d).h(a16);
            this.f364957f.saveStoreInfo();
        }
    }

    private boolean c(Map<String, String> map) {
        int c16;
        if (this.f364958h != -1 && (c16 = this.f364957f.c()) != this.f364958h) {
            map.put("old_config_version", String.valueOf(c16));
            map.put("new_config_version", String.valueOf(this.f364958h));
            RFixLog.i("RFix.TaskCoveredReporter", "checkIfConfigVersionChanged config version changed, old: " + c16 + " new: " + this.f364958h);
            return true;
        }
        return false;
    }

    private boolean d(Map<String, String> map) {
        int a16;
        if (this.f364959i != -1 && (a16 = this.f364957f.a()) != this.f364959i) {
            map.put("old_install_version", String.valueOf(a16));
            map.put("new_install_version", String.valueOf(this.f364959i));
            RFixLog.i("RFix.TaskCoveredReporter", "checkIfInstallVersionChanged install version changed, old: " + a16 + " new: " + this.f364959i);
            return true;
        }
        return false;
    }

    private boolean e(Map<String, String> map) {
        int b16;
        if (this.f364960m != -1 && (b16 = this.f364957f.b()) != this.f364960m) {
            map.put("old_load_version", String.valueOf(b16));
            map.put("new_load_version", String.valueOf(this.f364960m));
            RFixLog.i("RFix.TaskCoveredReporter", "checkIfLoadVersionChanged load version changed, old: " + b16 + " new: " + this.f364960m);
            return true;
        }
        return false;
    }

    public static b f(Context context) {
        if (C == null) {
            synchronized (b.class) {
                if (C == null) {
                    C = new b(context);
                }
            }
        }
        return C;
    }

    public synchronized void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        RFixLog.d("RFix.TaskCoveredReporter", "onConfigCovered versionId=" + i3);
        this.f364958h = i3;
        if (i3 == 0) {
            this.f364959i = 0;
            this.f364956e.sendEmptyMessage(100);
        } else {
            this.f364956e.sendEmptyMessageDelayed(100, 5000L);
        }
    }

    public synchronized void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        RFixLog.d("RFix.TaskCoveredReporter", "onInstallCovered versionId=" + i3);
        this.f364959i = i3;
        this.f364956e.removeMessages(100);
        this.f364956e.sendEmptyMessage(100);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 100) {
            b();
            return true;
        }
        return true;
    }

    public synchronized void i(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        RFixLog.d("RFix.TaskCoveredReporter", "onLoadCovered versionId=" + i3 + ", effectImmediate=" + z16);
        this.f364960m = i3;
        if (z16) {
            this.f364956e.removeMessages(100);
            this.f364956e.sendEmptyMessage(100);
        }
    }
}
