package com.tencent.mobileqq.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, b<Bitmap>> f306776a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    private static ReferenceQueue<Bitmap> f306777b = new ReferenceQueue<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f306778a = null;

        /* renamed from: b, reason: collision with root package name */
        public int f306779b = 3;

        /* renamed from: c, reason: collision with root package name */
        private a f306780c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b<Bitmap> extends WeakReference<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private final String f306781a;

        public b(String str, Bitmap bitmap, ReferenceQueue referenceQueue) {
            super(bitmap, referenceQueue);
            this.f306781a = str;
        }
    }

    public static int a(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i17 <= i16 && i18 <= i3) {
            return 1;
        }
        if (i18 > i17) {
            return Math.round(i17 / i16);
        }
        return Math.round(i18 / i3);
    }

    public static Bitmap b(byte[] bArr, int i3, int i16) {
        Bitmap.Config config;
        l();
        a aVar = new a();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER) && DeviceInfoMonitor.getModel().toUpperCase().startsWith("MI 2")) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            aVar.f306778a = SafeBitmapFactory.decodeByteArray(bArr, i3, i16, options);
        } catch (OutOfMemoryError unused) {
            aVar.f306779b = 1;
        } catch (Throwable unused2) {
            aVar.f306779b = 3;
        }
        Bitmap bitmap = aVar.f306778a;
        if (bitmap != null) {
            aVar.f306779b = 0;
            String valueOf = String.valueOf(bitmap.hashCode());
            f306776a.put(valueOf, new b<>(valueOf, aVar.f306778a, f306777b));
        }
        return aVar.f306778a;
    }

    public static Bitmap c(String str) {
        return d(str, null);
    }

    public static Bitmap d(String str, BitmapFactory.Options options) {
        a aVar = new a();
        e(str, options, aVar);
        return aVar.f306778a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(String str, BitmapFactory.Options options, a aVar) {
        File file;
        int length;
        byte[] buf;
        l();
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                file = new File(str);
            } catch (FileNotFoundException unused) {
                options = 0;
            } catch (OutOfMemoryError unused2) {
                options = 0;
            } catch (Throwable unused3) {
                options = 0;
            }
            if (!file.exists()) {
                aVar.f306779b = 2;
                return;
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                length = (int) file.length();
                buf = ByteArrayPool.getGenericInstance().getBuf(length);
            } catch (FileNotFoundException unused4) {
                options = 0;
                bufferedInputStream = bufferedInputStream2;
                aVar.f306779b = 2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (options != 0) {
                    ByteArrayPool.getGenericInstance().returnBuf(options);
                }
                if (aVar.f306778a == null) {
                }
            } catch (OutOfMemoryError unused6) {
                options = 0;
                bufferedInputStream = bufferedInputStream2;
                aVar.f306779b = 1;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                if (options != 0) {
                    ByteArrayPool.getGenericInstance().returnBuf(options);
                }
                if (aVar.f306778a == null) {
                }
            } catch (Throwable unused8) {
                options = 0;
                bufferedInputStream = bufferedInputStream2;
                aVar.f306779b = 3;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused9) {
                    }
                }
                if (options != 0) {
                    ByteArrayPool.getGenericInstance().returnBuf(options);
                }
                if (aVar.f306778a == null) {
                }
            }
            if (length != bufferedInputStream2.read(buf)) {
                aVar.f306779b = 3;
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused10) {
                }
                if (buf != null) {
                    ByteArrayPool.getGenericInstance().returnBuf(buf);
                    return;
                }
                return;
            }
            aVar.f306778a = SafeBitmapFactory.decodeByteArray(buf, 0, buf.length, options);
            try {
                bufferedInputStream2.close();
            } catch (IOException unused11) {
            }
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            if (aVar.f306778a == null) {
                aVar.f306779b = 0;
                f306776a.put(str, new b<>(str, aVar.f306778a, f306777b));
            }
        } finally {
        }
    }

    public static a f(String str, BitmapFactory.Options options) {
        a aVar = new a();
        e(str, options, aVar);
        return aVar;
    }

    public static Bitmap g(Resources resources, int i3) {
        l();
        a aVar = new a();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            String str = Build.MANUFACTURER;
            if ((CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str) && DeviceInfoMonitor.getModel().toUpperCase().startsWith("MI 2")) || ("BBK".equalsIgnoreCase(str) && DeviceInfoMonitor.getModel().toUpperCase().startsWith("VIVO"))) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            } else {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
            }
            aVar.f306778a = BitmapFactory.decodeResource(resources, i3, options);
        } catch (OutOfMemoryError unused) {
            aVar.f306779b = 1;
        } catch (Throwable unused2) {
            aVar.f306779b = 3;
        }
        Bitmap bitmap = aVar.f306778a;
        if (bitmap != null) {
            aVar.f306779b = 0;
            String valueOf = String.valueOf(bitmap.hashCode());
            f306776a.put(valueOf, new b<>(valueOf, aVar.f306778a, f306777b));
        }
        return aVar.f306778a;
    }

    public static Bitmap h(Resources resources, int i3) {
        l();
        a aVar = new a();
        try {
            aVar.f306778a = BitmapFactory.decodeResource(resources, i3, new BitmapFactory.Options());
        } catch (OutOfMemoryError unused) {
            aVar.f306779b = 1;
        } catch (Throwable unused2) {
            aVar.f306779b = 3;
        }
        Bitmap bitmap = aVar.f306778a;
        if (bitmap != null) {
            aVar.f306779b = 0;
            String valueOf = String.valueOf(bitmap.hashCode());
            f306776a.put(valueOf, new b<>(valueOf, aVar.f306778a, f306777b));
        }
        return aVar.f306778a;
    }

    public static Bitmap i(String str, int i3, int i16) {
        l();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i3, i16);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            String valueOf = String.valueOf(decodeFile.hashCode());
            f306776a.put(valueOf, new b<>(valueOf, decodeFile, f306777b));
        }
        return decodeFile;
    }

    public static Bitmap j(Resources resources, int i3, int i16, int i17) {
        l();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i3, options);
        options.inSampleSize = a(options, i16, i17);
        options.inJustDecodeBounds = false;
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i3, options);
        if (decodeResource != null) {
            String valueOf = String.valueOf(decodeResource.hashCode());
            f306776a.put(valueOf, new b<>(valueOf, decodeResource, f306777b));
        }
        return decodeResource;
    }

    public static Bitmap k(InputStream inputStream, Rect rect, int i3, int i16) {
        l();
        if (inputStream.markSupported()) {
            inputStream.mark(8092);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        SafeBitmapFactory.decodeStream(inputStream, rect, options);
        options.inSampleSize = a(options, i3, i16);
        options.inJustDecodeBounds = false;
        try {
            inputStream.reset();
            Bitmap decodeStream = SafeBitmapFactory.decodeStream(inputStream, rect, options);
            if (decodeStream != null) {
                String valueOf = String.valueOf(decodeStream.hashCode());
                f306776a.put(valueOf, new b<>(valueOf, decodeStream, f306777b));
            }
            return decodeStream;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static void l() {
        while (true) {
            b bVar = (b) f306777b.poll();
            if (bVar != null) {
                f306776a.remove(bVar.f306781a);
            } else {
                return;
            }
        }
    }
}
