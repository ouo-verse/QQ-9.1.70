package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static String f243467b;

    /* renamed from: c, reason: collision with root package name */
    public static String f243468c;

    /* renamed from: a, reason: collision with root package name */
    private String f243469a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f243467b = null;
            f243468c = null;
        }
    }

    public f(String str) {
        this(str, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    private byte[] a(String str) {
        byte[] bArr;
        FileInputStream fileInputStream;
        QLog.e("MagicfaceResLoader", 1, "read video: " + str);
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file = new File(str.replace("xbig", "big"));
                if (!file.exists()) {
                    return null;
                }
            }
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable unused2) {
            bArr = null;
        }
        try {
            try {
                int available = fileInputStream.available();
                bArr = new byte[available];
                try {
                    int read = fileInputStream.read(bArr);
                    if (read != available) {
                        QLog.e("MagicfaceResLoader", 1, read + " != " + available);
                    }
                    QLog.e("MagicfaceResLoader", 1, "length: " + read);
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                    return bArr;
                } catch (Throwable unused4) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return bArr;
                }
            } catch (Throwable unused6) {
                bArr = null;
            }
        } catch (Exception unused7) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused8) {
                }
            }
            return null;
        }
    }

    public static String d() {
        return e(1);
    }

    public static String e(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceResLoader", 2, "func getVideoPath begins.");
        }
        String str = f243468c;
        boolean z16 = true;
        if (str != null && i3 == 1) {
            f243467b = str;
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[1]. videoPath:" + f243467b);
            }
            return f243467b;
        }
        if (i3 != 2 && i3 != 3) {
            long min = Math.min(ah.x(), ah.w());
            boolean r06 = ah.r0();
            if (ah.n() < 2) {
                z16 = false;
            }
            if (min >= 852) {
                if (r06) {
                    f243467b = "sbig";
                } else if (z16) {
                    f243467b = "xbig";
                } else {
                    f243467b = "big";
                }
            } else if (min >= 640) {
                if (z16) {
                    f243467b = "xbig";
                } else {
                    f243467b = "big";
                }
            } else if (min >= 480) {
                f243467b = "big";
            } else {
                f243467b = NtFaceConstant.SMALL;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[2]. videoPath:" + f243467b);
            }
            String str2 = f243467b;
            f243468c = str2;
            return str2;
        }
        f243467b = "video";
        return "video";
    }

    public String b(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file = new File(str.replace("xbig", "big"));
                    if (!file.exists()) {
                        return null;
                    }
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[fileInputStream2.available()];
                        fileInputStream2.read(bArr);
                        str2 = new String(bArr, "utf-8");
                    } catch (Exception e16) {
                        str2 = null;
                        fileInputStream = fileInputStream2;
                        e = e16;
                    }
                    try {
                        String replaceFirst = str2.replaceFirst("^.*<", "<");
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused) {
                        }
                        return replaceFirst;
                    } catch (Exception e17) {
                        fileInputStream = fileInputStream2;
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicfaceResLoader", 2, "" + e.getMessage());
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return str2;
                    }
                } catch (Throwable th5) {
                    fileInputStream = fileInputStream2;
                    th = th5;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e18) {
            e = e18;
            str2 = null;
        }
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.f243469a + "audio" + File.separator + str;
    }

    public String f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return b(this.f243469a + f243467b + File.separator + str);
    }

    public c g(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
        c cVar = new c();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f243469a);
        sb5.append(f243467b);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str);
        cVar.f243438d = a(sb5.toString());
        cVar.f243437c = a(this.f243469a + f243467b + str3 + str2);
        return cVar;
    }

    public f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        } else {
            this.f243469a = str;
            e(i3);
        }
    }
}
