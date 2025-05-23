package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f {
    public static boolean a(Context context, String str, long j3) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!im.b(file)) {
                in.b(null);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            in.f(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean b16 = b(context, str, j3);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    in.b(randomAccessFile);
                    return b16;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    in.b(randomAccessFile);
                    throw th;
                }
            } catch (IOException e16) {
                e = e16;
                e.printStackTrace();
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                in.b(randomAccessFile);
                return true;
            }
        } catch (IOException e17) {
            e = e17;
            randomAccessFile = null;
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            in.b(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00dc A[Catch: all -> 0x00f0, IOException -> 0x00f3, LOOP:0: B:16:0x00d6->B:18:0x00dc, LOOP_END, TRY_LEAVE, TryCatch #9 {IOException -> 0x00f3, all -> 0x00f0, blocks: (B:15:0x00d2, B:16:0x00d6, B:18:0x00dc), top: B:14:0x00d2 }] */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, long j3) {
        Closeable closeable;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        Iterator it;
        File file = new File(context.getFilesDir(), "/.vdevdir/");
        if (!im.b(file)) {
            return true;
        }
        File file2 = new File(file, "lcfp");
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + "," + currentTimeMillis;
        ?? exists = file2.exists();
        try {
            if (exists != 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file2));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split(":");
                            if (split.length == 2) {
                                if (TextUtils.equals(split[0], String.valueOf(str))) {
                                    String[] split2 = split[1].split(",");
                                    if (split2.length == 2) {
                                        long parseLong = Long.parseLong(split2[1]);
                                        if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j3)) * 0.9f) {
                                            in.b(bufferedReader);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                            }
                        } catch (Exception unused) {
                            arrayList.clear();
                            in.b(bufferedReader);
                            arrayList.add(str2);
                            bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                            }
                            in.b(bufferedWriter2);
                            return true;
                        }
                    }
                } catch (Exception unused2) {
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    closeable = null;
                    in.b(closeable);
                    throw th;
                }
            } else if (!in.f(file2)) {
                return true;
            }
            arrayList.add(str2);
            try {
                bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
            } catch (IOException e16) {
                e = e16;
                bufferedWriter = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedWriter = null;
            }
            try {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    bufferedWriter2.write((String) it.next());
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                }
                in.b(bufferedWriter2);
            } catch (IOException e17) {
                e = e17;
                bufferedWriter = bufferedWriter2;
                try {
                    jz4.c.B(e.toString());
                    in.b(bufferedWriter);
                    return true;
                } catch (Throwable th7) {
                    th = th7;
                    in.b(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedWriter = bufferedWriter2;
                in.b(bufferedWriter);
                throw th;
            }
            return true;
        } catch (Throwable th9) {
            th = th9;
            closeable = exists;
        }
    }
}
