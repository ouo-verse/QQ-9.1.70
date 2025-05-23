package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ik {

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f389418e = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with root package name */
    private Context f389419a;

    /* renamed from: b, reason: collision with root package name */
    private FileLock f389420b;

    /* renamed from: c, reason: collision with root package name */
    private String f389421c;

    /* renamed from: d, reason: collision with root package name */
    private RandomAccessFile f389422d;

    ik(Context context) {
        this.f389419a = context;
    }

    public static ik a(Context context, File file) {
        jz4.c.z("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = f389418e;
        if (set.add(str)) {
            ik ikVar = new ik(context);
            ikVar.f389421c = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                ikVar.f389422d = randomAccessFile;
                ikVar.f389420b = randomAccessFile.getChannel().lock();
                jz4.c.z("Locked: " + str + " :" + ikVar.f389420b);
                if (ikVar.f389420b == null) {
                    RandomAccessFile randomAccessFile2 = ikVar.f389422d;
                    if (randomAccessFile2 != null) {
                        in.b(randomAccessFile2);
                    }
                    set.remove(ikVar.f389421c);
                }
                return ikVar;
            } catch (Throwable th5) {
                if (ikVar.f389420b == null) {
                    RandomAccessFile randomAccessFile3 = ikVar.f389422d;
                    if (randomAccessFile3 != null) {
                        in.b(randomAccessFile3);
                    }
                    f389418e.remove(ikVar.f389421c);
                }
                throw th5;
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void b() {
        jz4.c.z("unLock: " + this.f389420b);
        FileLock fileLock = this.f389420b;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f389420b.release();
            } catch (IOException unused) {
            }
            this.f389420b = null;
        }
        RandomAccessFile randomAccessFile = this.f389422d;
        if (randomAccessFile != null) {
            in.b(randomAccessFile);
        }
        f389418e.remove(this.f389421c);
    }
}
