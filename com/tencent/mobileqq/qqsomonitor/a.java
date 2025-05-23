package com.tencent.mobileqq.qqsomonitor;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f274722a;

    /* renamed from: b, reason: collision with root package name */
    public String f274723b;

    /* renamed from: c, reason: collision with root package name */
    public String f274724c;

    /* renamed from: d, reason: collision with root package name */
    public long f274725d;

    /* renamed from: e, reason: collision with root package name */
    public long f274726e;

    /* renamed from: f, reason: collision with root package name */
    public String f274727f;

    /* renamed from: g, reason: collision with root package name */
    public String f274728g;

    /* renamed from: h, reason: collision with root package name */
    public int f274729h;

    public a(String str, String str2, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.f274723b = "";
        this.f274727f = "";
        this.f274728g = "";
        this.f274729h = 0;
        this.f274722a = str;
        this.f274724c = str2;
        this.f274725d = j3;
        this.f274726e = j16;
    }

    public static boolean a(int i3) {
        if ((i3 & 1) != 0) {
            return true;
        }
        return false;
    }

    public int b(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) file)).intValue();
        }
        if (file != null && file.exists()) {
            String name = file.getName();
            String b16 = g.b(file);
            long length = file.length();
            QLog.d("SoMonitor.SoFileInfo", 1, "[isSoFileLegal], soFile{name=" + name + ", exists=" + file.exists() + ", canonicalPath=" + b16 + ", length=" + length + ", lastModified=" + file.lastModified() + "}");
            if (!TextUtils.equals(this.f274722a, name)) {
                return 1;
            }
            if (this.f274725d != length) {
                return 3;
            }
            return 0;
        }
        return -2;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "SoFileInfo{name=" + this.f274722a + ", pathKey=" + this.f274723b + ", canonicalPath=" + this.f274724c + ", md5=" + this.f274727f + ", length=" + this.f274725d + ", lastModified=" + this.f274726e + ", absPath=" + this.f274728g + ", flag=" + this.f274729h + "}";
    }
}
