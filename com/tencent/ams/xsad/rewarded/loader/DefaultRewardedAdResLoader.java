package com.tencent.ams.xsad.rewarded.loader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.xsad.rewarded.loader.c;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.ams.xsad.rewarded.utils.h;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultRewardedAdResLoader implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String f71814d;

    /* renamed from: e, reason: collision with root package name */
    private static DefaultRewardedAdResLoader f71815e;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f71816a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<c.b, b> f71817b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f71818c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class TaskRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private b f71819d;

        public TaskRunnable(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultRewardedAdResLoader.this, (Object) bVar);
            } else {
                this.f71819d = bVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = this.f71819d;
            if (bVar.f71821a) {
                return;
            }
            bVar.f71825e = -SystemClock.elapsedRealtime();
            DefaultRewardedAdResLoader.this.f71818c.sendMessage(DefaultRewardedAdResLoader.this.f71818c.obtainMessage(0, this.f71819d));
            c.b bVar2 = this.f71819d.f71822b;
            int i3 = bVar2.f71831a;
            if (i3 == 0 || i3 == 1) {
                if (bVar2.f71832b.startsWith("http")) {
                    file = DefaultRewardedAdResLoader.this.l(bVar2.f71832b, bVar2.f71833c);
                    if (file == null) {
                        file = DefaultRewardedAdResLoader.this.m(bVar2.f71832b, bVar2.f71833c);
                    }
                } else {
                    file = bVar2.f71832b.startsWith("/") ? new File(bVar2.f71832b) : null;
                }
                if (file != null && file.exists()) {
                    this.f71819d.f71823c = file;
                }
            }
            this.f71819d.f71825e += SystemClock.elapsedRealtime();
            DefaultRewardedAdResLoader.this.f71818c.sendMessage(DefaultRewardedAdResLoader.this.f71818c.obtainMessage(1, this.f71819d));
            com.tencent.ams.xsad.rewarded.utils.c.c(DefaultRewardedAdResLoader.f71814d, "load res:" + bVar2 + " cost:" + this.f71819d.f71825e + "ms");
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultRewardedAdResLoader.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof b)) {
                return;
            }
            b bVar = (b) obj;
            if (message.what == 0) {
                for (c.a aVar : bVar.f71827g) {
                    if (aVar != null) {
                        aVar.a(bVar.f71822b);
                    }
                }
                com.tencent.ams.xsad.rewarded.utils.c.c(DefaultRewardedAdResLoader.f71814d, "onLoadStart: " + bVar.f71822b);
                return;
            }
            for (c.a aVar2 : bVar.f71827g) {
                if (aVar2 != null) {
                    File file = bVar.f71823c;
                    if (file != null) {
                        aVar2.b(bVar.f71822b, file);
                    } else {
                        aVar2.c(bVar.f71822b, bVar.f71824d);
                    }
                }
            }
            DefaultRewardedAdResLoader.this.f71817b.remove(bVar.f71822b, bVar);
            if (bVar.f71823c != null) {
                com.tencent.ams.xsad.rewarded.utils.c.c(DefaultRewardedAdResLoader.f71814d, "onLoadFinish: " + bVar.f71822b);
            } else {
                com.tencent.ams.xsad.rewarded.utils.c.e(DefaultRewardedAdResLoader.f71814d, "onLoadFailed: " + bVar.f71822b + " error:" + bVar.f71824d);
            }
            bVar.f71826f = true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MtpConstants.FORMAT_BMP);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f71814d = DefaultRewardedAdResLoader.class.getSimpleName();
        }
    }

    DefaultRewardedAdResLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f71817b = new ConcurrentHashMap<>();
        this.f71818c = new a(Looper.getMainLooper());
        this.f71816a = h.a().c();
    }

    private void h(String str, String str2) {
        try {
            InputStream j3 = j(str, "");
            if (j3 != null && !com.tencent.ams.xsad.rewarded.loader.b.g().i(str, j3)) {
                com.tencent.ams.xsad.rewarded.utils.c.e(f71814d, "fetchToFile -> failed, url:" + str + ", fileName:" + str2);
            }
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b(f71814d, "fetchToFile failed: " + str, th5);
        }
    }

    public static synchronized DefaultRewardedAdResLoader i() {
        DefaultRewardedAdResLoader defaultRewardedAdResLoader;
        synchronized (DefaultRewardedAdResLoader.class) {
            if (f71815e == null) {
                f71815e = new DefaultRewardedAdResLoader();
            }
            defaultRewardedAdResLoader = f71815e;
        }
        return defaultRewardedAdResLoader;
    }

    private InputStream j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            if (!TextUtils.isEmpty(str2)) {
                httpURLConnection.setRequestProperty(ISchemeApi.KEY_REFERER, str2);
            }
            httpURLConnection.connect();
            return httpURLConnection.getInputStream();
        } catch (Exception e16) {
            com.tencent.ams.xsad.rewarded.utils.c.c(f71814d, "getStreamFromUrl: " + e16.getMessage());
            return null;
        }
    }

    private boolean k(c.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.f71832b)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File l(String str, String str2) {
        try {
            String a16 = com.tencent.ams.xsad.rewarded.loader.b.g().a(str);
            if (a16 != null) {
                File file = new File(a16);
                if (file.exists()) {
                    if (str2 == null || n(a16, str2)) {
                        com.tencent.ams.xsad.rewarded.utils.c.c(f71814d, "loadFileFromCache success: " + str);
                        return file;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b(f71814d, "loadFileFromCache fail: " + str, th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File m(String str, String str2) {
        try {
            String a16 = com.tencent.ams.xsad.rewarded.loader.b.g().a(str);
            if (a16 != null) {
                File file = new File(a16);
                h(str, a16);
                if (str2 == null || n(a16, str2)) {
                    com.tencent.ams.xsad.rewarded.utils.c.c(f71814d, "loadFileFromHttp success: " + str);
                    return file;
                }
            }
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b(f71814d, "loadFileFromHttp fail: " + str, th5);
        }
        com.tencent.ams.xsad.rewarded.utils.c.e(f71814d, "loadFileFromHttp fail");
        return null;
    }

    private boolean n(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            com.tencent.ams.xsad.rewarded.utils.c.e(f71814d, "validate file succeed but md5 is null");
            return true;
        }
        File file = new File(str);
        String d16 = g.d(file);
        if (d16 != null && str2.equalsIgnoreCase(d16)) {
            com.tencent.ams.xsad.rewarded.utils.c.c(f71814d, "validate file succeed: " + str);
            return true;
        }
        file.delete();
        com.tencent.ams.xsad.rewarded.utils.c.c(f71814d, "validate file failed: " + str + " md5 result is " + d16 + ", not " + str2);
        return false;
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.c
    public void a(c.b bVar, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) aVar);
            return;
        }
        if (k(bVar)) {
            com.tencent.ams.xsad.rewarded.utils.c.e(f71814d, "loadAsync failed: invalid resInfo");
            return;
        }
        String str = f71814d;
        com.tencent.ams.xsad.rewarded.utils.c.c(str, "loadAsync start: " + bVar);
        b bVar2 = this.f71817b.get(bVar);
        if (bVar2 != null) {
            if (aVar != null) {
                if (bVar2.f71826f) {
                    File file = bVar2.f71823c;
                    if (file != null) {
                        aVar.b(bVar, file);
                        com.tencent.ams.xsad.rewarded.utils.c.c(str, "loadAsync finish(prev ok): " + bVar);
                        return;
                    }
                    aVar.c(bVar, bVar2.f71824d);
                    com.tencent.ams.xsad.rewarded.utils.c.c(str, "loadAsync failed(prev fail): " + bVar);
                    return;
                }
                bVar2.f71827g.add(aVar);
                return;
            }
            return;
        }
        b bVar3 = new b(null);
        bVar3.f71822b = bVar;
        if (aVar != null) {
            bVar3.f71827g.add(aVar);
        }
        this.f71817b.put(bVar, bVar3);
        this.f71816a.execute(new TaskRunnable(bVar3));
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.c
    public void b(c.b bVar, c.a aVar) {
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) aVar);
            return;
        }
        if (!k(bVar) && (bVar2 = this.f71817b.get(bVar)) != null) {
            bVar2.f71827g.remove(aVar);
            if (bVar2.f71827g.size() == 0) {
                bVar2.f71821a = true;
                this.f71817b.remove(bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f71821a;

        /* renamed from: b, reason: collision with root package name */
        public c.b f71822b;

        /* renamed from: c, reason: collision with root package name */
        public File f71823c;

        /* renamed from: d, reason: collision with root package name */
        public String f71824d;

        /* renamed from: e, reason: collision with root package name */
        public long f71825e;

        /* renamed from: f, reason: collision with root package name */
        boolean f71826f;

        /* renamed from: g, reason: collision with root package name */
        public List<c.a> f71827g;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f71827g = new ArrayList();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}
