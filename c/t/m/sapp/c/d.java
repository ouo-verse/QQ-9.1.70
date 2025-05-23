package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f30145a;

    /* renamed from: b, reason: collision with root package name */
    public Context f30146b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, FileChannel> f30147c;

    public d(Context context) {
        this.f30147c = null;
        this.f30146b = context;
        this.f30147c = new HashMap(5);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f30145a == null) {
                f30145a = new d(context);
            }
            dVar = f30145a;
        }
        return dVar;
    }

    public synchronized boolean b(String str) {
        if (str != null) {
            if (str.trim().length() > 0) {
                File a16 = a(str);
                if (a16 == null) {
                    return true;
                }
                try {
                    FileChannel fileChannel = this.f30147c.get(str);
                    if (fileChannel == null || !fileChannel.isOpen()) {
                        fileChannel = new FileOutputStream(a16).getChannel();
                        this.f30147c.put(str, fileChannel);
                    }
                    FileLock lock = fileChannel.lock();
                    if (lock != null) {
                        if (lock.isValid()) {
                            return true;
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public synchronized void c(String str) {
        if (str != null) {
            if (str.trim().length() > 0) {
                try {
                    FileChannel fileChannel = this.f30147c.get(str);
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    public synchronized File a(String str) {
        File file;
        try {
            file = new File(this.f30146b.getFilesDir(), "TencentLocationCoverSDK_sapp_" + str + ".lock");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException unused) {
            file = null;
        }
        return file;
    }
}
