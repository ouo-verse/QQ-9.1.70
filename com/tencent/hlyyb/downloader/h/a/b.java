package com.tencent.hlyyb.downloader.h.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hlyyb.downloader.g.a.g;
import com.tencent.hlyyb.downloader.g.a.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f114701d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f114702e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f114703f;

        public a(Context context, String str, int i3) {
            this.f114701d = context;
            this.f114702e = str;
            this.f114703f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.c(this.f114701d, this.f114702e, this.f114703f);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static void a(Context context, int i3) {
        try {
            d(context, "skip_pull", i3);
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, String str, int i3) {
        String str2;
        String str3;
        ApplicationInfo applicationInfo;
        if (context == null) {
            str2 = "";
        } else {
            try {
                str2 = context.getPackageName();
            } catch (Throwable unused) {
                str2 = "";
            }
        }
        try {
            try {
                if (context != null) {
                    try {
                        applicationInfo = context.getApplicationInfo();
                    } catch (Throwable unused2) {
                    }
                    if (applicationInfo != null) {
                        str3 = String.valueOf(applicationInfo.targetSdkVersion);
                        String a16 = c.a(context);
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://qappcenterv6.3g.qq.com/report/qd?data=" + str2 + "|" + str + "|" + a16 + "|-1|1|||" + Build.VERSION.SDK_INT + "|" + str3 + "|false||-1|-1|-1|-1||" + i3 + "|" + ContainerUtils.FIELD_DELIMITER + "pid=" + g.f(g.c(a16, 3))).openConnection();
                        httpsURLConnection.setConnectTimeout(60000);
                        httpsURLConnection.setReadTimeout(60000);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.connect();
                        httpsURLConnection.getResponseCode();
                        return;
                    }
                }
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL("https://qappcenterv6.3g.qq.com/report/qd?data=" + str2 + "|" + str + "|" + a16 + "|-1|1|||" + Build.VERSION.SDK_INT + "|" + str3 + "|false||-1|-1|-1|-1||" + i3 + "|" + ContainerUtils.FIELD_DELIMITER + "pid=" + g.f(g.c(a16, 3))).openConnection();
                httpsURLConnection2.setConnectTimeout(60000);
                httpsURLConnection2.setReadTimeout(60000);
                httpsURLConnection2.setUseCaches(false);
                httpsURLConnection2.connect();
                httpsURLConnection2.getResponseCode();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
            String a162 = c.a(context);
        } catch (Throwable unused3) {
            return;
        }
        str3 = "";
    }

    public static void d(Context context, String str, int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a aVar = new a(context, str, i3);
            Handler c16 = h.c();
            if (c16 != null) {
                c16.post(aVar);
                return;
            } else {
                new BaseThread(aVar).start();
                return;
            }
        }
        c(context, str, i3);
    }
}
