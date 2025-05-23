package com.tencent.mobileqq.vpng.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f313218a;

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f313219b;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f313220c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vpng.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static class C8961a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f313221a;

        /* renamed from: b, reason: collision with root package name */
        char[] f313222b;

        C8961a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f313222b = new char[4];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(byte[] bArr) {
            this.f313221a = a.b(bArr);
            int i3 = 0;
            while (true) {
                char[] cArr = this.f313222b;
                if (i3 < cArr.length) {
                    cArr[i3] = (char) bArr[i3 + 4];
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f313218a = new char[]{'I', 'E', 'N', 'D'};
        f313219b = new char[]{'v', 'P', 'N', 'g'};
        f313220c = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            i3 = (i3 << 8) | (bArr[i16] & 255);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
    
        r0 = r0.f313221a;
        r3 = new byte[r0];
        r2.read(r3, 0, r0);
        r8.write(r3, 0, r0);
        r1 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0070 -> B:23:0x00cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str, String str2) {
        ?? r85;
        RandomAccessFile randomAccessFile;
        IOException e16;
        FileOutputStream fileOutputStream;
        FileNotFoundException e17;
        C8961a c8961a;
        byte[] bArr;
        byte[] bArr2;
        boolean z16 = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, "r");
                } catch (FileNotFoundException e18) {
                    randomAccessFile = null;
                    e17 = e18;
                    fileOutputStream = null;
                } catch (IOException e19) {
                    randomAccessFile = null;
                    e16 = e19;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    r85 = 0;
                    if (randomAccessFile2 != null) {
                    }
                    if (r85 == 0) {
                    }
                }
                try {
                    fileOutputStream = new FileOutputStream(new File(str2));
                } catch (FileNotFoundException e26) {
                    e17 = e26;
                    fileOutputStream = null;
                } catch (IOException e27) {
                    e16 = e27;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    str = null;
                    randomAccessFile2 = randomAccessFile;
                    r85 = str;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                    if (r85 == 0) {
                        try {
                            r85.close();
                            throw th;
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    c8961a = new C8961a();
                    bArr = new byte[8];
                    bArr2 = new byte[8];
                } catch (FileNotFoundException e36) {
                    e17 = e36;
                    e17.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e37) {
                            e37.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (!z16) {
                    }
                    return z16;
                } catch (IOException e38) {
                    e16 = e38;
                    e16.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e39) {
                            e39.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (!z16) {
                    }
                    return z16;
                }
            } catch (IOException e46) {
                e46.printStackTrace();
            }
            if (randomAccessFile.read(bArr2, 0, 8) > 0 && Arrays.equals(f313220c, bArr2)) {
                while (true) {
                    randomAccessFile.read(bArr, 0, 8);
                    c8961a.b(bArr);
                    if (Arrays.equals(f313219b, c8961a.f313222b)) {
                        break;
                    }
                    if (!Arrays.equals(f313218a, c8961a.f313222b)) {
                        randomAccessFile.skipBytes(c8961a.f313221a + 4);
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e47) {
                    e47.printStackTrace();
                }
                fileOutputStream.close();
                if (!z16) {
                    new File(str2).deleteOnExit();
                }
                return z16;
            }
            try {
                randomAccessFile.close();
            } catch (IOException e48) {
                e48.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e49) {
                e49.printStackTrace();
            }
            return false;
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
