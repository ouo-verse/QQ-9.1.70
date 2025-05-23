package com.tencent.mobileqq.activity.photo.incompatiblephoto;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f184464d;

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f184465e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f184464d = "WEBP".getBytes();
            f184465e = "RIFF".getBytes();
        }
    }

    public d(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f184461a = "PhotoIncompatibleWebp";
            this.f184462b = "reportGenerateWebp";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:
    
        r5 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002a, code lost:
    
        if (r5 >= 12) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        if (com.tencent.mobileqq.activity.photo.incompatiblephoto.d.f184464d[r5 - 8] == r0[r5]) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0036, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0042, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0046, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0047, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str) {
        byte[] bArr = new byte[16];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileInputStream2.read(bArr);
                    int i3 = 0;
                    while (true) {
                        byte[] bArr2 = f184465e;
                        if (i3 >= bArr2.length) {
                            break;
                        }
                        if (bArr2[i3] != bArr[i3]) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                            return false;
                        }
                        i3++;
                    }
                    return false;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
