package com.tencent.mobileqq.webview.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.c;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebStateReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static HashMap<String, Integer> f314847i;

    /* renamed from: j, reason: collision with root package name */
    public static int f314848j;

    /* renamed from: a, reason: collision with root package name */
    public int f314849a;

    /* renamed from: b, reason: collision with root package name */
    public long f314850b;

    /* renamed from: c, reason: collision with root package name */
    public int f314851c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f314852d;

    /* renamed from: e, reason: collision with root package name */
    public long f314853e;

    /* renamed from: f, reason: collision with root package name */
    public String f314854f;

    /* renamed from: g, reason: collision with root package name */
    public long f314855g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final com.tencent.mobileqq.webview.swift.injector.c f314856h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49590);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f314847i = new HashMap<>();
            f314848j = 6;
        }
    }

    public WebStateReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314849a = 0;
        this.f314852d = false;
        this.f314856h = (com.tencent.mobileqq.webview.swift.injector.c) aa.d(com.tencent.mobileqq.webview.swift.injector.c.class);
    }

    private String a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "Unknown";
                    }
                    return "4G";
                }
                return "3G";
            }
            return "2G";
        }
        return "wifi";
    }

    public void b(AppRuntime appRuntime, String str, int i3) {
        long longAccountUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        if (i3 == 0) {
            return;
        }
        if (appRuntime == null) {
            longAccountUin = 0;
        } else {
            longAccountUin = appRuntime.getLongAccountUin();
        }
        long j3 = longAccountUin;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.post(new Runnable(str, j3, i3) { // from class: com.tencent.mobileqq.webview.util.WebStateReporter.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314862d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f314863e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f314864f;

            {
                this.f314862d = str;
                this.f314863e = j3;
                this.f314864f = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, WebStateReporter.this, str, Long.valueOf(j3), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i16;
                boolean z16;
                String str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (WebStateReporter.f314847i.containsKey(this.f314862d)) {
                    i16 = WebStateReporter.f314847i.get(this.f314862d).intValue();
                } else {
                    i16 = 10;
                }
                if (1 != i16 && this.f314863e % i16 != WebStateReporter.f314848j) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return;
                }
                String str3 = "";
                try {
                    Uri parse = Uri.parse(this.f314862d);
                    if (parse != null) {
                        String host = parse.getHost();
                        if (TextUtils.isEmpty(host) || !host.endsWith("qq.com")) {
                            return;
                        } else {
                            str3 = URLEncoder.encode(this.f314862d);
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                if (WebStateReporter.this.f314851c == 13) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                sb5.append(str2);
                sb5.append("|");
                sb5.append(String.valueOf(-this.f314864f));
                sb5.append("|");
                sb5.append(str3);
                sb5.append("|");
                sb5.append(str3);
                sb5.append("|");
                sb5.append(this.f314864f);
                ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).d(null, "dc00757", sb5.toString(), true);
            }
        }, 5, null, false);
    }

    void c(Context context) {
        c.a t16 = this.f314856h.t();
        if (t16 != null) {
            f314847i.putAll(t16.f314604a);
            f314848j = t16.f314605b;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebStateReporter", 2, String.format("parseCrashStatConfig config=%s", t16));
        }
    }

    public void d(Context context, long j3, String str, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, Long.valueOf(j3), str, Boolean.valueOf(z16));
            return;
        }
        if (context != null && j3 > 0 && !TextUtils.isEmpty(str)) {
            if (this.f314852d) {
                this.f314851c = this.f314849a;
                this.f314855g = this.f314850b;
                this.f314852d = false;
            }
            try {
                i3 = NetworkUtil.getSystemNetwork(context);
            } catch (Exception unused) {
                i3 = 0;
            }
            ThreadManagerV2.post(new Runnable(z16, str, context, j3, a(i3)) { // from class: com.tencent.mobileqq.webview.util.WebStateReporter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f314857d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f314858e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Context f314859f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ long f314860h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f314861i;

                {
                    this.f314857d = z16;
                    this.f314858e = str;
                    this.f314859f = context;
                    this.f314860h = j3;
                    this.f314861i = r11;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WebStateReporter.this, Boolean.valueOf(z16), str, context, Long.valueOf(j3), r11);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00e5 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x00e6  */
                /* JADX WARN: Removed duplicated region for block: B:54:0x00c8  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i16;
                    int indexOf;
                    String str2;
                    boolean z17;
                    Integer num;
                    int intValue;
                    String str3;
                    String str4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean z18 = this.f314857d;
                    if (!TextUtils.isEmpty(this.f314858e)) {
                        try {
                            Uri parse = Uri.parse(this.f314858e);
                            String queryParameter = parse.getQueryParameter("hasRedDot");
                            if (!TextUtils.isEmpty(queryParameter)) {
                                z18 = queryParameter.equalsIgnoreCase("1");
                            }
                            String queryParameter2 = parse.getQueryParameter("crashFrom");
                            if (!TextUtils.isEmpty(queryParameter2)) {
                                i16 = Integer.parseInt(queryParameter2);
                            } else {
                                i16 = -1;
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("WebStateReporter_report", 2, "parse url, redDot : " + queryParameter + ", urlFromType : " + queryParameter2);
                                }
                            } catch (Exception e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                    QLog.e("WebStateReporter_report", 2, "parse url got some problem!", e);
                                }
                                boolean z19 = z18;
                                indexOf = this.f314858e.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                                str2 = this.f314858e;
                                z17 = false;
                                if (indexOf != -1) {
                                }
                                if (WebStateReporter.f314847i.isEmpty()) {
                                }
                                if (!WebStateReporter.f314847i.containsKey(str2)) {
                                }
                                intValue = num.intValue();
                                if (1 != intValue) {
                                }
                                z17 = true;
                                if (z17) {
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                            i16 = -1;
                        }
                        boolean z192 = z18;
                        indexOf = this.f314858e.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        str2 = this.f314858e;
                        z17 = false;
                        if (indexOf != -1) {
                            str2 = str2.substring(0, indexOf);
                        }
                        if (WebStateReporter.f314847i.isEmpty()) {
                            WebStateReporter.this.c(this.f314859f);
                            if (WebStateReporter.f314847i.isEmpty()) {
                                WebStateReporter.f314847i.put(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE, 10);
                            }
                        }
                        if (!WebStateReporter.f314847i.containsKey(str2)) {
                            num = WebStateReporter.f314847i.get(str2);
                        } else {
                            num = WebStateReporter.f314847i.get(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
                        }
                        intValue = num.intValue();
                        if (1 != intValue || this.f314860h % intValue == WebStateReporter.f314848j) {
                            z17 = true;
                        }
                        if (z17) {
                            return;
                        }
                        if (i16 != -1) {
                            str3 = str2 + "?type=" + i16;
                        } else {
                            str3 = str2;
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("try report web status,  step: ");
                            sb5.append(WebStateReporter.this.f314851c);
                            sb5.append(", hasRedDot : ");
                            sb5.append(z192);
                            sb5.append(", crashFrom : ");
                            sb5.append(i16);
                            sb5.append(", stepTime: ");
                            WebStateReporter webStateReporter = WebStateReporter.this;
                            sb5.append(webStateReporter.f314855g - webStateReporter.f314853e);
                            sb5.append(", totalTime: ");
                            sb5.append(System.currentTimeMillis() - WebStateReporter.this.f314853e);
                            sb5.append("\n");
                            sb5.append(str3);
                            QLog.d("WebStateReporter_report", 2, sb5.toString());
                        }
                        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
                        if (!TextUtils.isEmpty(WebStateReporter.this.f314854f)) {
                            str4 = WebStateReporter.this.f314854f;
                        } else {
                            str4 = "unknown";
                        }
                        String str5 = str4;
                        String str6 = this.f314861i;
                        WebStateReporter webStateReporter2 = WebStateReporter.this;
                        mVar.a(null, "P_CliOper", "WebStatusReport", "", str5, str6, z192 ? 1 : 0, 1, webStateReporter2.f314851c, str3, Build.VERSION.RELEASE, String.valueOf(webStateReporter2.f314855g - webStateReporter2.f314853e), String.valueOf(System.currentTimeMillis() - WebStateReporter.this.f314853e));
                    }
                }
            }, 5, null, false);
        }
    }

    public void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.f314853e = j3;
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.f314851c = i3;
        this.f314855g = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("WebStateReporter_report", 2, "Current State = " + i3);
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f314854f = str;
        }
    }
}
