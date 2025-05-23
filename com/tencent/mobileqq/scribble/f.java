package com.tencent.mobileqq.scribble;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static boolean a(byte[] bArr, String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr2);
                            if (read != -1) {
                                fileOutputStream.write(bArr2, 0, read);
                            } else {
                                try {
                                    fileInputStream2.close();
                                    fileOutputStream.close();
                                    return true;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    QLog.e("ScribbleUtils", 1, e16, new Object[0]);
                                    return false;
                                }
                            }
                        }
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        QLog.e("ScribbleUtils", 1, e, new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                QLog.e("ScribbleUtils", 1, e18, new Object[0]);
                                return false;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return true;
                        }
                        QLog.e("ScribbleUtils", 1, "fileOutputStream is null");
                        return false;
                    } catch (IOException e19) {
                        e = e19;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        QLog.e("ScribbleUtils", 1, e, new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                QLog.e("ScribbleUtils", 1, e26, new Object[0]);
                                return false;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return true;
                        }
                        QLog.e("ScribbleUtils", 1, "fileOutputStream is null");
                        return false;
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                                QLog.e("ScribbleUtils", 1, e27, new Object[0]);
                                return false;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return true;
                        }
                        QLog.e("ScribbleUtils", 1, "fileOutputStream is null");
                        return false;
                    }
                } catch (FileNotFoundException e28) {
                    e = e28;
                } catch (IOException e29) {
                    e = e29;
                }
            } catch (FileNotFoundException e36) {
                e = e36;
                fileOutputStream = null;
            } catch (IOException e37) {
                e = e37;
                fileOutputStream = null;
            } catch (Throwable unused2) {
                fileOutputStream = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public static String b(String str) {
        String str2 = "";
        try {
            str2 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        } catch (UnsatisfiedLinkError unused) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                    if (d16 != null) {
                        str2 = d16;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        QLog.i("ScribbleUtils", 1, "calcMD5 md5:" + str2);
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c A[Catch: Exception -> 0x007f, TRY_LEAVE, TryCatch #0 {Exception -> 0x007f, blocks: (B:44:0x0077, B:39:0x007c), top: B:43:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Boolean c(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (FileUtils.fileExists(str2)) {
            FileUtils.deleteFile(str2);
        }
        FileInputStream fileInputStream = null;
        try {
            if (new File(str).exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1444];
                    int i3 = 0;
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                        System.out.println(i3);
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream2.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    try {
                        QLog.e("ScribbleUtils", 1, " copyFile failed");
                        e.printStackTrace();
                        Boolean bool = Boolean.FALSE;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused) {
                                return bool;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return bool;
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } else {
                QLog.e("ScribbleUtils", 1, " oldfile not exist");
            }
            return Boolean.TRUE;
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                fileInputStream = new FileInputStream(new File((String) str));
            } catch (FileNotFoundException e16) {
                e = e16;
                fileInputStream = null;
            } catch (IOException e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable unused) {
                str = 0;
                if (str != 0) {
                }
                return null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                    QLog.e("ScribbleUtils", 1, e18, new Object[0]);
                }
                return byteArray;
            } catch (FileNotFoundException e19) {
                e = e19;
                e.printStackTrace();
                QLog.e("ScribbleUtils", 1, e, new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                        QLog.e("ScribbleUtils", 1, e26, new Object[0]);
                    }
                }
                return null;
            } catch (IOException e27) {
                e = e27;
                e.printStackTrace();
                QLog.e("ScribbleUtils", 1, e, new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                        QLog.e("ScribbleUtils", 1, e28, new Object[0]);
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            if (str != 0) {
                try {
                    str.close();
                } catch (IOException e29) {
                    e29.printStackTrace();
                    QLog.e("ScribbleUtils", 1, e29, new Object[0]);
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(String str, int i3, String str2) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    int i16 = 0;
                    while (true) {
                        int i17 = i16 + 1024;
                        if (i17 >= i3) {
                            break;
                        }
                        fileInputStream2.read(bArr);
                        i16 = i17;
                    }
                    int i18 = i3 - i16;
                    if (i18 <= 0) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            QLog.e("ScribbleUtils", 1, e16, new Object[0]);
                        }
                        return false;
                    }
                    fileInputStream2.read(new byte[i18]);
                    File file2 = new File(str2);
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr2, 0, read);
                        }
                        fileOutputStream.flush();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            QLog.e("ScribbleUtils", 1, e17, new Object[0]);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            QLog.e("ScribbleUtils", 1, e18, new Object[0]);
                        }
                        return true;
                    } catch (Exception e19) {
                        e = e19;
                        fileInputStream = fileInputStream2;
                        try {
                            QLog.e("ScribbleUtils", 1, " FileInputStream failed");
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                    QLog.e("ScribbleUtils", 1, e26, new Object[0]);
                                }
                            }
                            if (fileOutputStream == null) {
                                return false;
                            }
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (IOException e27) {
                                e27.printStackTrace();
                                QLog.e("ScribbleUtils", 1, e27, new Object[0]);
                                return false;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                    QLog.e("ScribbleUtils", 1, e28, new Object[0]);
                                }
                            }
                            if (fileOutputStream == null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException e29) {
                                    e29.printStackTrace();
                                    QLog.e("ScribbleUtils", 1, e29, new Object[0]);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    }
                } catch (Exception e36) {
                    e = e36;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e37) {
                e = e37;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } else {
            QLog.e("ScribbleUtils", 1, "file not exist!");
            return false;
        }
    }
}
