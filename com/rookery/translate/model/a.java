package com.rookery.translate.model;

import android.content.Context;
import android.os.Environment;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final DiskLruCache f61214a;

    public a(Context context, int i3, long j3) throws IOException {
        File d16 = d(context);
        if (!d16.exists()) {
            d16.mkdirs();
        }
        this.f61214a = DiskLruCache.open(d16, i3, 1, j3);
        e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if (r4 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0018, code lost:
    
        if (r4 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        Throwable th5;
        DiskLruCache.Snapshot snapshot;
        try {
            snapshot = this.f61214a.get(d.a(str));
            if (snapshot != null) {
                try {
                    try {
                        String string = snapshot.getString(0);
                        snapshot.close();
                        return string;
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (snapshot != null) {
                            snapshot.close();
                        }
                        throw th5;
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                }
            }
        } catch (Exception e17) {
            e = e17;
            snapshot = null;
        } catch (Throwable th7) {
            th5 = th7;
            snapshot = null;
            if (snapshot != null) {
            }
            throw th5;
        }
    }

    private File d(Context context) {
        String str = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName() + "/cache/";
        File c16 = d.c(context);
        if (("mounted".equals(Environment.getExternalStorageState()) || !d.d()) && c16 != null) {
            str = c16.getPath();
        } else {
            String path = context.getCacheDir().getPath();
            if (path != null && path.length() > 0) {
                str = path;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Translator", 2, "[TransDiskCache] getDiskCacheDir:" + str);
        }
        return new File(str + File.separator + "TransDiskCache_simsun_qqi");
    }

    public b b(String str, long j3, String str2) {
        String c16 = c(d.f(str2, str));
        if (c16 == null) {
            return null;
        }
        String c17 = c(d.e(str2, str, j3));
        Boolean bool = Boolean.FALSE;
        if (c17 != null) {
            bool = Boolean.valueOf(c17);
        }
        return new b(c16, bool.booleanValue());
    }

    public String c(String str) {
        return a(str);
    }

    public void e() {
    }
}
