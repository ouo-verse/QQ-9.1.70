package com.tencent.tgpa.lite.g;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    public static String a(String str, String str2) {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains(str2)) {
                    str3 = readLine.trim();
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        fileInputStream.close();
        return str3;
    }

    public static File b(String str) {
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        return b(b(str));
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0045: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:70), block:B:29:0x0045 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File b16 = b(str);
        StringBuilder sb5 = new StringBuilder();
        FileInputStream fileInputStream3 = null;
        try {
            try {
                byte[] bArr = new byte[1024];
                fileInputStream = new FileInputStream(b16);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb5.append(new String(bArr, 0, read));
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                String sb6 = sb5.toString();
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return sb6;
            } catch (IOException e19) {
                e = e19;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static boolean a(String str) {
        return str != null && a(b(str));
    }

    public static boolean b(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(str2.getBytes());
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return true;
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }
}
