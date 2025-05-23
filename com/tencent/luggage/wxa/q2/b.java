package com.tencent.luggage.wxa.q2;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f137801a;

    /* renamed from: b, reason: collision with root package name */
    public String f137802b;

    /* renamed from: c, reason: collision with root package name */
    public RandomAccessFile f137803c;

    /* renamed from: d, reason: collision with root package name */
    public FileLock f137804d;

    public b(String str, String str2) {
        this.f137801a = str;
        this.f137802b = str2;
    }

    public void a() {
        try {
            FileLock fileLock = this.f137804d;
            if (fileLock != null) {
                fileLock.release();
                this.f137804d = null;
            }
        } catch (Throwable th5) {
            Log.e("AdUUIDFile", "close", th5);
        }
        try {
            RandomAccessFile randomAccessFile = this.f137803c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.f137803c = null;
            }
        } catch (Throwable th6) {
            Log.e("AdUUIDFile", "close", th6);
        }
    }

    public final boolean b() {
        if (!TextUtils.isEmpty(this.f137801a) && !TextUtils.isEmpty(this.f137802b)) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (b() && this.f137803c == null && this.f137804d == null) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), this.f137801a);
                File file2 = new File(file, this.f137802b);
                if (!file.exists() && !file.mkdirs()) {
                    return false;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
                this.f137803c = randomAccessFile;
                this.f137804d = randomAccessFile.getChannel().lock();
                if (!file2.isFile()) {
                    a();
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                Log.e("AdUUIDFile", "open", th5);
                a();
            }
        }
        return false;
    }

    public String a(int i3) {
        RandomAccessFile randomAccessFile;
        if (b() && (randomAccessFile = this.f137803c) != null && this.f137804d != null) {
            try {
                if (randomAccessFile.length() <= i3) {
                    i3 = Long.valueOf(this.f137803c.length()).intValue();
                }
                if (i3 <= 0) {
                    return null;
                }
                byte[] bArr = new byte[i3];
                if (this.f137803c.read(bArr, 0, i3) == i3) {
                    return new String(bArr, 0, i3, "UTF-8");
                }
                return null;
            } catch (Throwable th5) {
                Log.e("AdUUIDFile", k.f247491e, th5);
            }
        }
        return null;
    }
}
