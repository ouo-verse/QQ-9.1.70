package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    FileOutputStream f250545a;

    /* renamed from: b, reason: collision with root package name */
    byte f250546b;

    /* renamed from: c, reason: collision with root package name */
    byte f250547c;

    /* renamed from: d, reason: collision with root package name */
    boolean f250548d;

    public g(File file, boolean z16) throws IOException {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16));
            return;
        }
        this.f250545a = null;
        this.f250546b = (byte) 0;
        this.f250547c = (byte) 0;
        this.f250548d = true;
        try {
            if (z16) {
                if (file.length() >= 5) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[5];
                            int read = fileInputStream.read(bArr);
                            if (read >= 1 && bArr[0] != 0) {
                                this.f250548d = false;
                            } else if (read == 5 && bArr[0] == 0) {
                                this.f250548d = true;
                                this.f250546b = (byte) 0;
                                for (int i3 = 1; i3 < 5; i3++) {
                                    this.f250546b = (byte) (this.f250546b ^ bArr[i3]);
                                }
                            } else {
                                fileInputStream.close();
                                throw new Exception();
                            }
                            fileInputStream.close();
                            this.f250545a = new FileOutputStream(file, z16);
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            fileInputStream.close();
                            throw new IOException();
                        }
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = null;
                    }
                } else if (file.length() > 0) {
                    this.f250548d = false;
                    this.f250545a = new FileOutputStream(file, z16);
                }
            } else {
                this.f250545a = new FileOutputStream(file, z16);
                if (this.f250548d) {
                    byte[] bArr2 = new byte[4];
                    while (this.f250546b == 0) {
                        new Random().nextBytes(bArr2);
                        for (int i16 = 0; i16 < 4; i16++) {
                            this.f250546b = (byte) (this.f250546b ^ bArr2[i16]);
                        }
                    }
                    this.f250545a.write(this.f250547c);
                    this.f250545a.write(bArr2);
                }
            }
        } catch (FileNotFoundException e18) {
            e18.printStackTrace();
            this.f250545a = null;
            throw new IOException();
        }
    }

    public void a() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        FileOutputStream fileOutputStream = this.f250545a;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

    public void b(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (this.f250545a == null || str == null || str.length() == 0) {
            return;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            if (this.f250548d) {
                byte[] bArr = new byte[length];
                for (int i3 = 0; i3 < length; i3++) {
                    bArr[i3] = (byte) (bytes[i3] ^ this.f250546b);
                }
                this.f250545a.write(bArr);
                return;
            }
            this.f250545a.write(bytes);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b1 A[Catch: IOException -> 0x00ad, TRY_LEAVE, TryCatch #6 {IOException -> 0x00ad, blocks: (B:75:0x00a9, B:68:0x00b1), top: B:74:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String e16, String str) {
        ?? r95;
        IOException e17;
        FileNotFoundException e18;
        FileInputStream fileInputStream;
        byte[] bArr;
        byte[] bArr2;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) e16);
            } catch (FileNotFoundException e19) {
                e18 = e19;
                e16 = 0;
            } catch (IOException e26) {
                e17 = e26;
                e16 = 0;
            } catch (Throwable th5) {
                th = th5;
                r95 = 0;
                if (fileInputStream2 != null) {
                }
                if (r95 != 0) {
                }
                throw th;
            }
            try {
                e16 = new FileOutputStream(str);
                try {
                    bArr = new byte[1024];
                    bArr2 = new byte[1024];
                } catch (FileNotFoundException e27) {
                    e18 = e27;
                    fileInputStream2 = fileInputStream;
                    e16 = e16;
                    e18.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e28) {
                            e16 = e28;
                            e16.printStackTrace();
                            return false;
                        }
                    }
                    if (e16 != 0) {
                        e16.close();
                    }
                    return false;
                } catch (IOException e29) {
                    e17 = e29;
                    fileInputStream2 = fileInputStream;
                    e16 = e16;
                    e17.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e36) {
                            e16 = e36;
                            e16.printStackTrace();
                            return false;
                        }
                    }
                    if (e16 != 0) {
                        e16.close();
                    }
                    return false;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = e16;
                    th = th;
                    r95 = fileInputStream2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    if (r95 != 0) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e37) {
                e18 = e37;
                e16 = 0;
            } catch (IOException e38) {
                e17 = e38;
                e16 = 0;
            } catch (Throwable th7) {
                th = th7;
                r95 = fileInputStream2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e39) {
                        e39.printStackTrace();
                        throw th;
                    }
                }
                if (r95 != 0) {
                    r95.close();
                }
                throw th;
            }
            if (fileInputStream.read(bArr, 0, 5) == 5 && bArr[0] == 0) {
                byte b16 = 0;
                for (int i3 = 1; i3 < 5; i3++) {
                    b16 = (byte) (b16 ^ bArr[i3]);
                }
                while (fileInputStream.available() > 0) {
                    int read = fileInputStream.read(bArr);
                    for (int i16 = 0; i16 < read; i16++) {
                        bArr2[i16] = (byte) (bArr[i16] ^ b16);
                    }
                    e16.write(bArr2, 0, read);
                }
                try {
                    fileInputStream.close();
                    e16.close();
                } catch (IOException e46) {
                    e46.printStackTrace();
                }
                return true;
            }
            try {
                fileInputStream.close();
                e16.close();
            } catch (IOException e47) {
                e47.printStackTrace();
            }
            return false;
        } catch (Throwable th8) {
            th = th8;
            fileInputStream = fileInputStream2;
        }
    }

    public void b() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        FileOutputStream fileOutputStream = this.f250545a;
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
    }

    public static byte[] a(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                int length = bytes.length;
                byte[] bArr = new byte[length];
                for (int i3 = 0; i3 < length; i3++) {
                    bArr[i3] = (byte) (bytes[i3] ^ 204);
                }
                return bArr;
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }
}
