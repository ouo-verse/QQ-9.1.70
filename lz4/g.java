package lz4;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.in;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    public static String a(kz4.c cVar) {
        return cVar.f413529a + "#" + cVar.f413530b + "#" + cVar.f413531c + "#" + cVar.f413526h;
    }

    private static HashMap<String, String> b(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split("%%%");
                            if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                hashMap.put(split[0], split[1]);
                            }
                        } catch (Exception e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            jz4.c.q(e);
                            in.b(bufferedReader);
                            return hashMap;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            in.b(bufferedReader);
                            throw th;
                        }
                    }
                    in.b(bufferedReader2);
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
            return hashMap;
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d8, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> c(Context context, String str) {
        File file;
        RandomAccessFile randomAccessFile;
        ?? r46;
        kz4.c e16;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            FileLock fileLock = null;
            try {
                file = new File(str + ".lock");
            } catch (Exception e17) {
                e = e17;
                file = null;
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
                file = null;
                randomAccessFile = null;
            }
            try {
                in.f(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        r46 = new BufferedReader(new FileReader(str));
                        while (true) {
                            try {
                                String readLine = r46.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split("%%%");
                                if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (e16 = e(d(split[0]), split[1])) != null) {
                                    arrayList.add(e16.d());
                                }
                            } catch (Exception e18) {
                                e = e18;
                                fileLock = lock;
                                r46 = r46;
                                try {
                                    jz4.c.q(e);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e19) {
                                            jz4.c.q(e19);
                                        }
                                    }
                                    in.b(randomAccessFile);
                                    in.b(r46);
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e26) {
                                            jz4.c.q(e26);
                                        }
                                    }
                                    in.b(randomAccessFile);
                                    in.b(r46);
                                    if (file != null) {
                                        file.delete();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                fileLock = lock;
                                if (fileLock != null) {
                                }
                                in.b(randomAccessFile);
                                in.b(r46);
                                if (file != null) {
                                }
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException e27) {
                                jz4.c.q(e27);
                            }
                        }
                        in.b(randomAccessFile);
                        in.b(r46);
                    } catch (Exception e28) {
                        e = e28;
                        r46 = 0;
                    } catch (Throwable th8) {
                        th = th8;
                        r46 = 0;
                    }
                } catch (Exception e29) {
                    e = e29;
                    r46 = 0;
                } catch (Throwable th9) {
                    th = th9;
                    r46 = 0;
                }
            } catch (Exception e36) {
                e = e36;
                randomAccessFile = null;
                r46 = randomAccessFile;
                jz4.c.q(e);
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                in.b(randomAccessFile);
                in.b(r46);
            } catch (Throwable th10) {
                th = th10;
                randomAccessFile = null;
                r46 = randomAccessFile;
                if (fileLock != null) {
                    fileLock.release();
                }
                in.b(randomAccessFile);
                in.b(r46);
                if (file != null) {
                }
            }
            file.delete();
            return arrayList;
        }
        return arrayList;
    }

    private static kz4.c d(String str) {
        kz4.c cVar = null;
        try {
            String[] j3 = j(str);
            if (j3 == null || j3.length < 4 || TextUtils.isEmpty(j3[0]) || TextUtils.isEmpty(j3[1]) || TextUtils.isEmpty(j3[2]) || TextUtils.isEmpty(j3[3])) {
                return null;
            }
            cVar = kz4.c.e();
            cVar.f413529a = Integer.parseInt(j3[0]);
            cVar.f413530b = j3[1];
            cVar.f413531c = Integer.parseInt(j3[2]);
            cVar.f413526h = Integer.parseInt(j3[3]);
            return cVar;
        } catch (Exception unused) {
            jz4.c.z("parse per key error");
            return cVar;
        }
    }

    private static kz4.c e(kz4.c cVar, String str) {
        long[] i3;
        if (cVar == null || (i3 = i(str)) == null) {
            return null;
        }
        cVar.f413527i = i3[0];
        cVar.f413528j = i3[1];
        return cVar;
    }

    private static void f(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th5;
        Exception e16;
        if (!TextUtils.isEmpty(str) && hashMap != null && hashMap.size() != 0) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
            } catch (Exception e17) {
                bufferedWriter = null;
                e16 = e17;
            } catch (Throwable th6) {
                bufferedWriter = null;
                th5 = th6;
                in.b(bufferedWriter);
                throw th5;
            }
            try {
                try {
                    for (String str2 : hashMap.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                        bufferedWriter.newLine();
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    in.b(bufferedWriter);
                    throw th5;
                }
            } catch (Exception e18) {
                e16 = e18;
                jz4.c.q(e16);
                in.b(bufferedWriter);
            }
            in.b(bufferedWriter);
        }
    }

    public static void g(String str, kz4.d[] dVarArr) {
        RandomAccessFile randomAccessFile;
        if (dVarArr != null && dVarArr.length > 0 && !TextUtils.isEmpty(str)) {
            FileLock fileLock = null;
            try {
                File file = new File(str + ".lock");
                in.f(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    HashMap<String, String> b16 = b(str);
                    for (kz4.d dVar : dVarArr) {
                        if (dVar != null) {
                            String a16 = a((kz4.c) dVar);
                            long j3 = ((kz4.c) dVar).f413527i;
                            long j16 = ((kz4.c) dVar).f413528j;
                            if (!TextUtils.isEmpty(a16) && j3 > 0 && j16 >= 0) {
                                h(b16, a16, j3, j16);
                            }
                        }
                    }
                    f(str, b16);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e16) {
                            e = e16;
                            jz4.c.q(e);
                            in.b(randomAccessFile);
                        }
                    }
                } catch (Throwable unused) {
                    try {
                        jz4.c.z("failed to write perf to file ");
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e17) {
                                e = e17;
                                jz4.c.q(e);
                                in.b(randomAccessFile);
                            }
                        }
                        in.b(randomAccessFile);
                    } catch (Throwable th5) {
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e18) {
                                jz4.c.q(e18);
                            }
                        }
                        in.b(randomAccessFile);
                        throw th5;
                    }
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
            }
            in.b(randomAccessFile);
        }
    }

    private static void h(HashMap<String, String> hashMap, String str, long j3, long j16) {
        String str2;
        String str3 = hashMap.get(str);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put(str, j3 + "#" + j16);
            return;
        }
        long[] i3 = i(str3);
        if (i3 != null) {
            long j17 = i3[0];
            if (j17 > 0) {
                long j18 = i3[1];
                if (j18 >= 0) {
                    str2 = (j3 + j17) + "#" + (j16 + j18);
                    hashMap.put(str, str2);
                }
            }
        }
        str2 = j3 + "#" + j16;
        hashMap.put(str, str2);
    }

    protected static long[] i(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return null;
        }
    }

    private static String[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
