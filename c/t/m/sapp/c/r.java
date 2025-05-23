package c.t.m.sapp.c;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public String f30198a = "WriterAndReader";

    /* renamed from: b, reason: collision with root package name */
    public File f30199b;

    public r(String str) {
        this.f30199b = null;
        this.f30199b = new File(str);
    }

    public boolean a(byte[] bArr, boolean z16) {
        FileOutputStream fileOutputStream = null;
        try {
            if (!this.f30199b.exists()) {
                File file = new File(this.f30199b.getParent());
                if (!file.exists()) {
                    file.mkdirs();
                    this.f30199b.createNewFile();
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.f30199b, z16);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            } catch (Exception unused2) {
                fileOutputStream = fileOutputStream2;
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Exception unused3) {
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                try {
                    fileOutputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String a(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (this.f30199b.exists()) {
                    fileInputStream = new FileInputStream(this.f30199b.getAbsolutePath());
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.close();
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        fileInputStream.close();
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        return str2;
                    } catch (Exception unused3) {
                        fileInputStream2 = fileInputStream;
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused4) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused7) {
                        }
                        return str;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            fileInputStream.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (Exception unused9) {
                            throw th;
                        }
                    }
                }
                try {
                    try {
                        throw null;
                    } catch (Exception unused10) {
                        byteArrayOutputStream.close();
                        return str;
                    }
                } catch (Exception unused11) {
                    return str;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception unused12) {
        }
    }
}
