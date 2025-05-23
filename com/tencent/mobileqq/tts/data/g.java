package com.tencent.mobileqq.tts.data;

import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f303374b;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f303375c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile g f303376d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, d> f303377a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f303374b = MobileQQ.sMobileQQ.getCacheDir().getAbsolutePath() + "/tts_cache/";
        f303375c = new byte[0];
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f303377a = new ConcurrentHashMap();
        }
    }

    private boolean g(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static g h() {
        if (f303376d == null) {
            synchronized (f303375c) {
                if (f303376d == null) {
                    f303376d = new g();
                }
            }
        }
        return f303376d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(File file) {
        FileUtils.deleteDirectory(file.getAbsolutePath());
    }

    @Override // com.tencent.mobileqq.tts.data.b
    public void a(String str, long j3, Boolean bool) {
        d dVar;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), bool);
            return;
        }
        if (!TextUtils.isEmpty(str) && j3 > 0 && (dVar = this.f303377a.get(str)) != null && dVar.b() == j3) {
            BufferedOutputStream a16 = dVar.a();
            try {
                try {
                    if (bool.booleanValue()) {
                        a16.flush();
                        a16.close();
                    } else {
                        a16.close();
                        g(str);
                    }
                    this.f303377a.remove(str);
                    try {
                        a16.close();
                    } catch (Exception e16) {
                        e = e16;
                        sb5 = new StringBuilder();
                        sb5.append("storageFinish finally error!");
                        sb5.append(e);
                        QLog.e("TtsFileCache", 1, sb5.toString());
                    }
                } catch (Exception e17) {
                    QLog.e("TtsFileCache", 1, "storageFinish error!" + e17);
                    this.f303377a.remove(str);
                    try {
                        a16.close();
                    } catch (Exception e18) {
                        e = e18;
                        sb5 = new StringBuilder();
                        sb5.append("storageFinish finally error!");
                        sb5.append(e);
                        QLog.e("TtsFileCache", 1, sb5.toString());
                    }
                }
            } catch (Throwable th5) {
                this.f303377a.remove(str);
                try {
                    a16.close();
                } catch (Exception e19) {
                    QLog.e("TtsFileCache", 1, "storageFinish finally error!" + e19);
                }
                throw th5;
            }
        }
    }

    @Override // com.tencent.mobileqq.tts.data.b
    public boolean b(String str, long j3) {
        BufferedOutputStream bufferedOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3))).booleanValue();
        }
        if (TextUtils.isEmpty(str) || this.f303377a.containsKey(str) || !FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("102615", true)) {
            return false;
        }
        File file = new File(f303374b);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(str.substring(0, str.lastIndexOf("/")));
        if (!file2.exists() && !file2.mkdirs()) {
            return false;
        }
        File file3 = new File(str);
        if (file3.exists() && !file3.delete()) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str), 4096);
        } catch (Exception e16) {
            e = e16;
        }
        try {
            this.f303377a.put(str, new d(j3, bufferedOutputStream));
            return true;
        } catch (Exception e17) {
            e = e17;
            bufferedOutputStream2 = bufferedOutputStream;
            QLog.e("TtsFileCache", 1, "saveStreamToFile exception error " + e);
            this.f303377a.remove(str);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                    QLog.e("TtsFileCache", 1, "initTtsStreamLocalFile exception1 error " + e);
                }
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.tts.data.b
    public InputStream c(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InputStream) iPatchRedirector.redirect((short) 2, this, str, str2, str3);
        }
        if (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("102615", true)) {
            return null;
        }
        String i3 = i(str, str3);
        if (TextUtils.isEmpty(i3)) {
            return null;
        }
        String j3 = j(i3, str2);
        if (!TextUtils.isEmpty(j3) && !this.f303377a.containsKey(j3)) {
            File file = new File(j3);
            if (!file.exists()) {
                return null;
            }
            if (file.length() <= 1024) {
                QLog.i("TtsFileCache", 1, "getTtsStreamFromLocalFile min size file check. delete.");
                file.delete();
                return null;
            }
            if (NetConnInfoCenter.getServerTimeMillis() - file.lastModified() >= 86400000) {
                file.delete();
                return null;
            }
            try {
                return new BufferedInputStream(new FileInputStream(j3));
            } catch (Exception e16) {
                QLog.e("TtsFileCache", 1, "getStreamFromLocalFile" + e16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tts.data.b
    public boolean d(String str, long j3, int i3) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && j3 > 0 && new File(str).exists() && (dVar = this.f303377a.get(str)) != null && dVar.b() == j3) {
            try {
                dVar.a().write(i3);
                return true;
            } catch (Exception e16) {
                QLog.e("TtsFileCache", 1, "saveStreamToFile error " + e16);
            }
        }
        return false;
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        final File file = new File(f303374b + str + "/");
        if (!file.exists()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tts.data.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k(file);
            }
        }, 64, null, false);
    }

    public String i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return MD5Coding.encodeHexStr(str) + "_voice" + str2;
        }
        return null;
    }

    public String j(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f303374b + str2 + "/" + str;
    }
}
