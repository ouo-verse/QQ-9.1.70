package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f151806a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f151807b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f151808c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f151809d;

    /* renamed from: e, reason: collision with root package name */
    public static ThreadPoolExecutor f151810e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f151807b = availableProcessors;
        int i3 = availableProcessors + 1;
        f151808c = i3;
        int i16 = (availableProcessors * 2) + 1;
        f151809d = i16;
        f151810e = new BaseThreadPoolExecutor(i3, i16, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
                return available;
            } catch (Exception e16) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e16.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th5;
        }
    }

    public static boolean b(String str) {
        if (str != null && str.length() > 0) {
            return false;
        }
        return true;
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f151806a != null && str.startsWith("content")) {
            try {
                return a(f151806a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int a(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            return str.length() <= 0 ? i3 : Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static boolean a(int i3) {
        return i3 == 36 || i3 == 46;
    }
}
