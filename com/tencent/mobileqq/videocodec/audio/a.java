package com.tencent.mobileqq.videocodec.audio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleDateFormat f312504d;

    /* renamed from: a, reason: collision with root package name */
    private String f312505a;

    /* renamed from: b, reason: collision with root package name */
    private String f312506b;

    /* renamed from: c, reason: collision with root package name */
    private FileOutputStream f312507c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f312504d = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
        }
    }

    public a(String str) throws RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f312505a = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f312505a);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("audio_data_cache");
        sb5.append(str2);
        this.f312505a = sb5.toString();
        File file = new File(this.f312505a);
        boolean mkdirs = file.mkdirs();
        boolean isDirectory = file.isDirectory();
        if (!mkdirs && !isDirectory) {
            QLog.e("AudioDataCache", 2, new RuntimeException("AudioDataCache: mkd=" + mkdirs + " isdir=" + isDirectory), new Object[0]);
        }
    }

    public static String b() {
        String str;
        SimpleDateFormat simpleDateFormat = f312504d;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date()) + "_" + new Random().nextInt(10000);
        }
        return str;
    }

    public synchronized String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioDataCache", 2, "closeCache: path=" + this.f312506b);
        }
        String str = this.f312505a + this.f312506b;
        FileOutputStream fileOutputStream = this.f312507c;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        }
        return str;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f312505a + this.f312506b;
    }

    public synchronized void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioDataCache", 2, "initCache: oldpath=" + this.f312506b + " mOutStream=" + this.f312507c);
        }
        this.f312506b = b();
        String str = this.f312505a + this.f312506b;
        File file = new File(str);
        if (!file.exists()) {
            try {
                this.f312507c = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                this.f312507c = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioDataCache", 2, "initCache: newPath=" + this.f312506b);
            }
            return;
        }
        throw new RuntimeException("AudioDataCache: file exists| " + str);
    }

    public synchronized boolean e(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        FileOutputStream fileOutputStream = this.f312507c;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(bArr, i3, i16);
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioDataCache", 2, "writeData: exception", e16);
                }
            }
            return z16;
        }
        z16 = false;
        return z16;
    }
}
